package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class hello {

  public static void mainHello() {

    System.out.print("Hello world!");
    hello h = new hello();
    h.testThread();

    Map<String, String> hashMapTemp = new HashMap<String, String>();

    hashMapTemp.put("123", "456");
    hashMapTemp.get("123");


    Map<String, String> treeMap = new TreeMap<>();
    treeMap.put(null,null);
    Map<String,String> hashtable = new Hashtable<>();
    Map<String,String> linkedHashMap = new LinkedHashMap<>();

    Long temp;
    List<Integer> res = new ArrayList<>();
    List<Integer> linklist = new LinkedList<>();
    ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

  }


  /**
   * 线程池以及任务，callable接口
   */
  public void testThread() {

    ThreadCall threadCall = new ThreadCall();

    //线程池
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100,
        TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

    ExecutorService executorService = Executors.newCachedThreadPool();

    //Future任务
    //Future<Integer> result = executorService.submit(threadCall);

    //FutureTask任务
    FutureTask<Integer> result = new FutureTask<Integer>(threadCall);
    executorService.submit(result);

    executorService.shutdown();

    try {
      Integer a = result.get();
      System.out.println(a);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }


  /**
   * runable线程测试
   */
  public String test(String s, int numRows) {
    if (null == s || s.length() < 1) {
      return "";
    }
    if (numRows < 2) {
      return s;
    }
    Character[][] str = new Character[numRows][s.length()];

    int row = 0, col = 0;

    for (int i = 0; i < s.length(); i++) {
      if (row == numRows - 1) {
        str[row][col] = s.charAt(i);
        while (true) {
          if (--row == 0) {
            i++;
            break;
          } else {
            if (i < s.length() - 1) {
              str[row][++col] = s.charAt(++i);
            }
          }

        }

      } else {
        str[row][col] = s.charAt(i);
        while (true) {
          if (++row == numRows - 1) {
            i++;
            break;
          } else {
            if (i < s.length() - 1) {
              str[row][col] = s.charAt(++i);
            }
          }

        }

      }

    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (null != str[i][j]) {
          sb.append(str[i][j]);
        }
      }
    }

    return sb.toString();

  }


}
