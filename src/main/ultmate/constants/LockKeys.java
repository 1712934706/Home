package constants;

/**
 * redis分布式锁的key
 */
public class LockKeys {

    //利用userid作为用户模块redis锁前缀
    public static final String PRE_LOCK_KEY_USER = "userid";
}
