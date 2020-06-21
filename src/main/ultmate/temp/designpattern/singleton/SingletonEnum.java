package temp.designpattern.singleton;

/**
 * 单例模式-枚举方式实现 最简单最安全写法，枚举本来就是单例的
 */
public enum SingletonEnum {
  INSTANCE;

  private SingletonEnum() {

  }
}
