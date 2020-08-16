package temp.mutithread.alternateprint;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadTest {

  static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
  static Boolean flag = false;

  public static void main(String[] args) throws Exception {
    Thread threadP = new Thread(() -> {
      try {
        while (true) {

          if (!flag) {
            arrayBlockingQueue.put(1);
            System.out.println("生产者，生产了" + 1);
            flag = true;
          }
        }
      } catch (Exception e) {
        System.out.println("生产者异常了");
      }
    });

    Thread threadC = new Thread(() -> {
      try {
        while (true) {
          if (flag) {
            Integer integer = arrayBlockingQueue.take();
            System.out.println("消费者，消费了" + integer);
            flag = false;
          }
        }
      } catch (Exception e) {
        System.out.println("消费者异常了");
      }
    });

    threadP.start();
    threadC.start();
    Thread.sleep(5000);
  }
}
