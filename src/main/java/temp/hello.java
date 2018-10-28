package temp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class hello {
    public static void main(String args[]) {

        System.out.print("Hello world!");
        hello h = new hello();
        h.testThread();

        Map<String,String> hashMapTemp = new HashMap<String, String>();

        hashMapTemp.put("123","456");
        hashMapTemp.get("123");



    }


    /**
     * 线程池以及任务，callable接口
     */
    public void testThread() {
        ThreadCall threadCall = new ThreadCall();

        //线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,100,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

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


}
