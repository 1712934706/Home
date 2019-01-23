package start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import utils.RedisCacheConfig;

@SpringBootApplication
@MapperScan("mapper")  //注意这地方要加扫描mapper
@Import(RedisCacheConfig.class)
public class SpringbootApplication {

    /**
     * spring boot入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
