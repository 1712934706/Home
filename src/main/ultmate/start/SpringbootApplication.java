package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
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
