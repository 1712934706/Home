package temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多线程测试类
 */
public class ThreadRunB implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(ThreadRunB.class);
  //用于测试线程之间的可见性
  private Boolean isContinue;

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

//  @Override
//  public void run() {
//    while (true) {
//      try {
//        synchronized (isContinue) {
//          if ("".equals(resource)) {
//            isContinue.wait();
//          }
//          logger.info("消费了" + resource);
//          resource = "";
//          isContinue.notify();
//          logger.info("通知生产者");
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
      lockService.singalTest();
    } catch (Exception e) {
      logger.error(Thread.currentThread().getName() + "异常");
    }

  }


}
