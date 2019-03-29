package start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"service", "start", "controller", "utils","temp"})
@MapperScan("mapper")  //注意这地方要加扫描mapper
public class SpringbootApplication {

  /**
   * spring boot入口
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }

}
