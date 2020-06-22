package temp.designpattern.proxy.staticproxy;

/**
 * 租客
 */
public class Tenant implements IRentHose {

  @Override
  public void rentHose() {
    System.out.println("我要租房子");
  }
}
