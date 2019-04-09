package temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * runnable测试
 */
public class ThreadRunA implements Runnable {

  /**
   * 日志工具
   */
  private static final Logger logger = LoggerFactory.getLogger(ThreadRunA.class);

  //用于测试线程之间的可见性
  private Boolean isContinue;

  //数量
  private Integer count;
  private String resource;

  //测试锁
  private LockService lockService;

  public LockService getLockService() {
    return lockService;
  }

  public void setLockService(LockService lockService) {
    this.lockService = lockService;
  }


  public Boolean getContinue() {
    return isContinue;
  }

  public void setContinue(Boolean aContinue) {
    isContinue = aContinue;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

//  @Override
//  public void run() {
//    while (true) {
//      try {
//        synchronized (isContinue) {
//          if (!"".equals(resource)) {
//            isContinue.wait();
//          }
//          logger.info("生产了");
//          resource = "apple";
//          isContinue.notify();
//          logger.info("通知消费者");
//        }
//      } catch (Exception e) {
//        logger.error(Thread.currentThread().getName() + "异常");
//      }
//    }
//
//  }


  @Override
  public void run() {
    try {
      lockService.awaitTest();
    } catch (Exception e) {
      logger.error(Thread.currentThread().getName() + "异常");
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
