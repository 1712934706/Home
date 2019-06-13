package temp;

import controller.UserController;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 可重入锁服务
 */
public class LockService {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private ReentrantLock lock = new ReentrantLock();

  private Condition condition = lock.newCondition();

  //**************************测试await和singal方法*********************************
  public void awaitTest() {
    try {
      lock.lock();
      logger.info("start lock await {}", Thread.currentThread().getName());
      condition.await();
      lock.unlock();
      logger.info("end lock await {}", Thread.currentThread().getName());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  public void singalTest() {
    try {
      lock.lock();
      logger.info("start lock singal {}", Thread.currentThread().getName());
      condition.signal();
      lock.unlock();
      logger.info("end lock singal {}", Thread.currentThread().getName());
    } catch (Exception e) {

    }
  }
  //**************************测试await和singal方法*********************************

  //**************************测试getHoldCount()方法*********************************
  public void getLockOne() {
    try {
      lock.lock();
      logger.info(Thread.currentThread().getName() + " start lock");
      logger.info("lock count {}", lock.getHoldCount());
      getLockTwo();
      Thread.sleep(500);
      logger.info("one lock end!");

    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }

  public void getLockTwo() {
    try {
      lock.lock();
      logger.info("lock count {}", lock.getHoldCount());
    } finally {
      lock.unlock();
    }
  }

}
