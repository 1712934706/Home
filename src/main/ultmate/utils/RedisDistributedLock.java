package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 利用redis实现分布式锁，redis是单节点部署
 *
 * @see 参考 https://blog.csdn.net/u014495560/article/details/82531046
 */
@Service
public class RedisDistributedLock {
    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(RedisDistributedLock.class);

    @Autowired
    private RedisTemplate redisTemplate;

    private DefaultRedisScript<Long> redisScript;

    private static final Long EXEC_RESULT = 1L;

    private void init() {
        redisScript = new DefaultRedisScript<>();
        //注意这个type，这个是lua脚本返回的结果类型，工程中lua返回的是long(redisScript只有Long）
        //这里设置的类型要和lua返回结果类型匹配
        redisScript.setResultType(Long.class);
    }

    /**
     * @param key        锁的key
     * @param requestId  客户端id
     * @param expireTime 过期时间。使用expire，单位/s
     * @return
     */
    public boolean getLock(String key, String requestId, String expireTime) {
        init();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/lock.lua")));
        Object result = redisTemplate.execute(redisScript, new StringRedisSerializer(), new StringRedisSerializer(), Collections.singletonList(key), requestId, expireTime);
        if (EXEC_RESULT.equals(result)) {
            logger.info("{}获取{}锁成功", requestId, key);
            return true;
        }
        logger.info("{}获取{}锁失败", requestId, key);
        return false;
    }

    /**
     * @param key       锁的key
     * @param requestId 客户端id
     * @return
     */
    public boolean releaseLock(String key, String requestId) {
        init();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/unlock.lua")));
        Object result = redisTemplate.execute(redisScript, new StringRedisSerializer(), new StringRedisSerializer(), Collections.singletonList(key), requestId);
        if (EXEC_RESULT.equals(result)) {
            logger.info("{}释放{}锁成功", requestId, key);
            return true;
        }
        logger.info("{}释放{}锁失敗", requestId, key);
        return false;
    }


}
