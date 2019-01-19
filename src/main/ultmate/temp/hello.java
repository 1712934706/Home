package temp;

import com.google.gson.Gson;
import model.User;
import org.springframework.boot.json.GsonJsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class hello {

    public static void mainHello() {



        System.out.print("Hello world!");
        hello h = new hello();
        h.testThread();

        Map<String, String> hashMapTemp = new HashMap<String, String>();

        hashMapTemp.put("123", "456");
        hashMapTemp.get("123");


    }


    /**
     * 线程池以及任务，callable接口
     */
    public void testThread() {






        ThreadCall threadCall = new ThreadCall();

        //线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

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