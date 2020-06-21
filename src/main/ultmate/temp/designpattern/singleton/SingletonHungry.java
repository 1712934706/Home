package temp.designpattern.singleton;

/**
 * 单例模式-饿汉式
 * 缺点：对象没有到就加载，浪费内存
 */
public class SingletonHungry {

  //构造方法私有化，不可以通过构造方法来new一个对象
  private SingletonHungry() {
  }

  //类的内部构造一个对象，保证单例，其实这也是利用JVM在加载静态属性时保证线程安全，才不会出现多线程问题
  private static SingletonHungry singletonHungry = new SingletonHungry();

  private static SingletonHungry getSingletonHungry() {
    return singletonHungry;
  }

}
