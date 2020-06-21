package temp.designpattern.singleton;

/**
 * 单例模式-静态类
 * 推荐写法
 */
public class SingletonStaticClass {

  private SingletonStaticClass() {

  }

  //静态内部类在使用时才加载，加载静态内部类也会加载外部类
  private static class LazyHolder {
    //创建对象
    private static final SingletonStaticClass INSTANCE = new SingletonStaticClass();
  }

  public static final SingletonStaticClass getInstance() {
    return LazyHolder.INSTANCE;
  }
}
