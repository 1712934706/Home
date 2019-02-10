package service.impl;

import constants.LockKeys;
import controller.UserController;
import mapper.UserMapper;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import start.RedisCacheConfig;
import utils.JsonData;
import utils.RedisDistributedLock;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserMapper userMapper;

    private RedisDistributedLock redisDistributedLock;

    @Autowired
    UserServiceImpl(UserMapper userMapper, RedisDistributedLock redisDistributedLock) {
        this.userMapper = userMapper;
        this.redisDistributedLock = redisDistributedLock;
    }

    @Override
    public JsonData<User> getUserInfoByID(int id) {
        String lockID = LockKeys.PRE_LOCK_KEY_USER + id;
        //获取锁
        boolean locked = redisDistributedLock.getLock(lockID, String.valueOf(id), "30");
        if (locked) {
            //获取锁成功
            try {
                Thread.sleep(20 * 1000L);
                User user = userMapper.selectUserById(id);
                return new JsonData<>(true, "", user);
            } catch (Exception e) {
                logger.error("根据用户id获取用户信息发生错误，原因：{}", e.getMessage());
                return new JsonData<>(false, "");
            } finally {
                //释放锁
                //这里也可能会解锁失败，暂时不处理，可以等待锁过期之后自动释放
                redisDistributedLock.releaseLock(lockID, String.valueOf(id));
            }
        } else {
            return new JsonData<>(false, "获取锁失败");
        }
    }
}

