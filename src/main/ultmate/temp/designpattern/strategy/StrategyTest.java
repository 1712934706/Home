package temp.designpattern.strategy;

/**
 * 策略模式测试类
 */
public class StrategyTest {


  public void test() {
    //执行A策略
    Strategy strategy = new StrategyA();
    Context context = new Context(strategy);
    context.contextInterace();
  }

}
