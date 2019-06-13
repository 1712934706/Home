package temp;

import java.util.concurrent.ArrayBlockingQueue;
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

  //利用阻塞队列实现线程通信
  private ArrayBlockingQueue queue;

  public ArrayBlockingQueue getQueue() {
    return queue;
  }

  public void setQueue(ArrayBlockingQueue queue) {
    this.queue = queue;
  }


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

//********************测试lock*****************************
//  @Override
//  public void run() {
//    try {
//      // lockService.awaitTest();
//      lockService.getLockOne();
//    } catch (Exception e) {
//      logger.error(Thread.currentThread().getName() + "异常");
//    }
//
//  }

  @Override
  public void run() {
    try {
      logger.info(Thread.currentThread().getName() + " start consume");
      while (true) {
        logger.info(Thread.currentThread().getName() + " consume " + queue.take());
      }
    } catch (Exception e) {
      logger.error(Thread.currentThread().getName() + "异常");
    }

  }

}
