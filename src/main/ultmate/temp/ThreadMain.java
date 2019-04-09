package temp;

import controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 多线程主类
 */
@Service
public class ThreadMain {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  public void testRunnable() throws Exception {
    Boolean isCountine = true;
    String resource = new String("");
    LockService lockService = new LockService();
    ThreadRunA threadRunA = new ThreadRunA();
    threadRunA.setContinue(isCountine);
    threadRunA.setResource(resource);
    threadRunA.setCount(Integer.valueOf(1));
    threadRunA.setLockService(lockService);

    ThreadRunB threadRunB = new ThreadRunB();
    threadRunB.setContinue(isCountine);
    threadRunB.setResource(resource);
    threadRunB.setLockService(lockService);

    Thread thread2 = new Thread(threadRunA, "A");
    thread2.start();
    Thread.sleep(100);
    Thread thread1 = new Thread(threadRunB, "B");
    thread1.start();

    Thread.sleep(1000);

  }

}
