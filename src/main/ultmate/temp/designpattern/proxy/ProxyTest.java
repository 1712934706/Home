package temp.designpattern.proxy;

import temp.designpattern.proxy.dynamicproxy.IRentHose;
import temp.designpattern.proxy.dynamicproxy.IntermediaryAgent;
import temp.designpattern.proxy.dynamicproxy.Tenant;

public class ProxyTest {

  public void test() {
    //测试静态代理模式
    IRentHose tenant = new Tenant();
    IRentHose intermediaryAgent = new IntermediaryAgent(tenant);
    intermediaryAgent.rentHose();

    //测试动态代理

  }

}
