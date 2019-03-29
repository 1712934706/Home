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
    ThreadRun threadRun = new ThreadRun();
    threadRun.setContinue(true);
    threadRun.setCount(Integer.valueOf(1));

    Thread thread1 = new Thread(threadRun, "A");
    thread1.start();
    Thread thread2 = new Thread(threadRun, "B");
    thread2.start();
    Thread.sleep(2000);
    logger.info("主线程准备停止子线程");
    threadRun.setContinue(false);
  }

}
