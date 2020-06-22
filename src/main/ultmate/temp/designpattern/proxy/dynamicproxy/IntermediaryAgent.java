package temp.designpattern.proxy.dynamicproxy;

/**
 * 代理模式的核心是代理类对实际类的动作进行了包装，然后加入了代理自己的动作
 */
public class IntermediaryAgent implements IRentHose {

  /**
   * 实际对象
   */
  private IRentHose iRentHose;

  public IntermediaryAgent(IRentHose iRentHose) {
    this.iRentHose = iRentHose;
  }

  @Override
  public void rentHose() {
    //在实际动作的前后加代理
    System.out.println("交中介费");
    iRentHose.rentHose();
    System.out.println("签租房合同");
  }
}
