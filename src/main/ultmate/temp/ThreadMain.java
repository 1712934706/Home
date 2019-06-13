package temp;

import controller.UserController;
import java.util.concurrent.ArrayBlockingQueue;
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
    ArrayBlockingQueue quene = new ArrayBlockingQueue(1);
    ThreadRunA threadRunA = new ThreadRunA();
    threadRunA.setContinue(isCountine);
    threadRunA.setResource(resource);
    threadRunA.setCount(Integer.valueOf(1));
    threadRunA.setLockService(lockService);
    threadRunA.setQueue(quene);

    ThreadRunB threadRunB = new ThreadRunB();
    threadRunB.setContinue(isCountine);
    threadRunB.setResource(resource);
    threadRunB.setLockService(lockService);
    threadRunB.setQueue(quene);

    Thread thread2 = new Thread(threadRunA, "A");
    thread2.start();
    Thread thread1 = new Thread(threadRunB, "B");
    thread1.start();

    Thread.sleep(5000);

  }

}
