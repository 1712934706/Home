package temp;

import controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * runnable测试
 */
public class ThreadRun implements Runnable {

  /**
   * 日志工具
   */
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  //用于测试线程之间的可见性
  private Boolean isContinue;

  //数量
  private Integer count;

  public Boolean getContinue() {
    return isContinue;
  }

  public void setContinue(Boolean aContinue) {
    isContinue = aContinue;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public void run() {
    /**###########################
     * valotile测试
     logger.info("thread start run");

     while (isContinue) {
     logger.info("thread is running");
     }
     logger.info("thread end run");
     *############################
     **/
    try {
      calCount();
    } catch (Exception e) {
    }
  }

  public synchronized void calCount() throws Exception {
    if ("A".equals(Thread.currentThread().getName())) {
      Thread.sleep(5);
    }
    for (int i = 0; i < 1000; i++) {
      System.out.println(Thread.currentThread().getName() + count++);
    }
  }

}
