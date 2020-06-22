package temp.designpattern.proxy.dynamicproxy;

/**
 * 租客
 */
public class Tenant implements IRentHose {

  @Override
  public void rentHose() {
    System.out.println("我要租房子");
  }
}
