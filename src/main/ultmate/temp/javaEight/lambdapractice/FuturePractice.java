package temp.javaEight.lambdapractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import utils.JsonData;

public class FuturePractice {

  public static final ThreadPoolExecutor COMMON_POOL =
      new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 1024,
          15L, TimeUnit.SECONDS,
          new LinkedBlockingQueue<>(),
          (ThreadFactory) Thread::new);

  @Autowired
  private UserService userService;


  public int doubleNum(int a) {
    return 2 * a;
  }

  public Future<JsonData<User>> getUserAsync() {
//    CompletableFuture<JsonData<User>> completableFuture = new CompletableFuture<>();
//    new Thread(() -> {
//      JsonData<User> res = userService.getUserInfoByID(1);
//      completableFuture.complete(res);
//    }).start();
//    return completableFuture;

    CompletableFuture.runAsync(() -> System.out.println("测试run async"));
    List<String> data = Arrays.asList("12", "1213", "ered");
    List<CompletableFuture<Integer>> completableFutureList = data.stream()
        .map((temp) -> CompletableFuture.supplyAsync(() -> temp.length()))
        //注意函数式接口的用法，apply是一个入参一个出参
        //函数引用，包括：静态方法，实例方法，构造方法
        .map(len -> len.thenApply(new FuturePractice()::doubleNum))
        .collect(Collectors.toList());

    completableFutureList.forEach(temp -> {
      try {
        System.out.println(temp.get());
      } catch (Exception e) {
        System.out.println("error");
      }
    });

    return CompletableFuture.supplyAsync(() -> userService.getUserInfoByID(1));
  }


}
