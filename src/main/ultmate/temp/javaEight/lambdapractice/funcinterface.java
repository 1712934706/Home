package temp.javaEight.lambdapractice;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 函数式接口练习
 */
public class funcinterface {

  Predicate<String> predicate = (String s) -> s.isEmpty();

  Consumer<String> consumer = (String s) -> System.out.println(s);

  Function<String, Integer> function = (String s) -> s.length();


  public <T, R> List<T> test(List<T> data, Predicate<T> p, Consumer<T> c, Function<T, R> f) {

    data.forEach(t -> {
      //测试predicate
      if (p.test(t)) {
        System.out.println("是空的字符串");
        //测试consumer
        c.accept(t);
        //测试function
        System.out.println(f.apply(t));
      }
    });

    return data;

  }


}
