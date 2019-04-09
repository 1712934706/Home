package temp;

import controller.UserController;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 可重入锁服务
 */
public class LockService {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private Lock lock = new ReentrantLock();

  private Condition condition = lock.newCondition();

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
    try{
      lock.lock();
      logger.info("start lock singal {}", Thread.currentThread().getName());
      condition.signal();
      lock.unlock();
      logger.info("end lock singal {}", Thread.currentThread().getName());
    }
    catch (Exception e)
    {

    }
  }
}
