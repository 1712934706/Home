package temp.designpattern.proxy;

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

  }

}
