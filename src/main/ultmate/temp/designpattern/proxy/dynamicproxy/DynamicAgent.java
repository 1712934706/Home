package temp.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理，利用反射来实现动态调用不同对象的方法
 */
public class DynamicAgent implements InvocationHandler {

  //被代理对象
  private Object object;

  public DynamicAgent(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //代理前后可以加上代理要做的动作
    System.out.println("Before invoke " + method.getName());
    method.invoke(object, args);
    System.out.println("After invoke " + method.getName());
    return null;
  }

}
