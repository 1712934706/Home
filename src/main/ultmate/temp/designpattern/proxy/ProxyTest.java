package temp.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import temp.designpattern.proxy.dynamicproxy.DynamicAgent;
import temp.designpattern.proxy.staticproxy.IRentHose;
import temp.designpattern.proxy.staticproxy.IntermediaryAgent;
import temp.designpattern.proxy.staticproxy.Tenant;

public class ProxyTest {

  public void test() {
    //测试静态代理模式
    IRentHose tenant = new Tenant();
    IRentHose intermediaryAgent = new IntermediaryAgent(tenant);
    intermediaryAgent.rentHose();

    //测试动态代理
    InvocationHandler invocationHandler = new DynamicAgent(tenant);
    IRentHose iRentHose = (IRentHose) Proxy
        .newProxyInstance(tenant.getClass().getClassLoader(), tenant.getClass().getInterfaces(),
            invocationHandler);
    iRentHose.rentHose();
  }

}
