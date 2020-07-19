package temp.designpattern.strategy;

/**
 * 策略模式的核心类，通过持有策略的公共接口，实现动态执行不同策略
 */
public class Context {

  //持有策略对象
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public void contextInterace() {
    strategy.strategyInterface();
  }

}
