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
    ThreadRunA threadRunA = new ThreadRunA();
    threadRunA.setContinue(isCountine);
    threadRunA.setResource(resource);
    threadRunA.setCount(Integer.valueOf(1));

    ThreadRunB threadRunB = new ThreadRunB();
    threadRunB.setContinue(isCountine);
    threadRunB.setResource(resource);

    Thread thread2 = new Thread(threadRunB, "B");
    thread2.start();
    Thread.sleep(100);
    Thread thread1 = new Thread(threadRunA, "A");
    thread1.start();

    Thread.sleep(1000);

  }

}
