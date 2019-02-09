package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.Collections;

/**
 * 利用redis实现分布式锁，redis是单节点部署
 *
 * @see 参考 https://blog.csdn.net/u014495560/article/details/82531046
 */
public class RedisDistributedLock {

    @Autowired
    private static RedisTemplate redisTemplate;

    /**
     * 这里留着使用其他写法，目前锁是读取lua脚本实现
     */
    private static DefaultRedisScript<String> redisScript;

    private static final Long EXEC_RESULT = 1L;

    /**
     * @param key        锁的key
     * @param requestId  客户端id
     * @param expireTime 过期时间
     * @return
     */
    public static boolean getLock(String key, String requestId, String expireTime) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/lock.lua")));
        Object result = redisTemplate.execute(redisScript, new StringRedisSerializer(), new StringRedisSerializer(), Collections.singletonList(key), requestId, expireTime);
        if (EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * @param key       锁的key
     * @param requestId 客户端id
     * @return
     */
    public static boolean releaseLock(String key, String requestId) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/unlock.lua")));
        Object result = redisTemplate.execute(redisScript, new StringRedisSerializer(), new StringRedisSerializer(), Collections.singletonList(key), requestId);
        if (EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;
    }


}
