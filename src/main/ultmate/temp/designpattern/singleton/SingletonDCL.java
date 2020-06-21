package temp.designpattern.singleton;

/**
 * 单例模式-DCL模式
 *
 */
public class SingletonDCL {

  private SingletonDCL() {

  }

  //加入volatile，保证new的时候由于指令重排序导致对象地址已经产生，但是没有初始化，其他线程这是获取到的是一个空对象
  private static volatile SingletonDCL singletonDCL = null;

  private static SingletonDCL getSingletonDCL() {
    //这里也可以不加，只是为了提升性能
    if (null == singletonDCL) {
      synchronized (SingletonDCL.class) {
        if (null == singletonDCL) { //加上防止多线程不安全
          singletonDCL = new SingletonDCL();//非原子操作
        }
      }
    }
    return singletonDCL;
  }

}
