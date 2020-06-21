package temp.designpattern.singleton;

/**
 * 单例模式懒汉式
 * 缺点：线程不安全，可以通过给方法加上synchronized解决多线程安全问题，但是每次获取对象都要加锁，浪费性能
 */
public class SingletonLazy {

  //私有化构造方法，防止外部new对象
  private SingletonLazy() {
  }

  private static SingletonLazy singletonLazy = null;

  public static SingletonLazy getSingletonLazy() {
    if (null == singletonLazy) {
      singletonLazy = new SingletonLazy();
    }
    return singletonLazy;
  }

}
