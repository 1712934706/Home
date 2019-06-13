package start;

import com.alibaba.fastjson.JSON;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import service.UserService;
import utils.JsonData;


/**
 * SpringbootApplication Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/11/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTest {

    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

        int a= -1;
        a=a&0x7fffffff;
        System.out.println(a);

        JsonData<User> user = userService.getUserInfoByID(1);

        System.out.println(JSON.toJSONString(user.getData()));
        redisTemplate.opsForValue().set("key4", "value4");

        Assert.assertEquals("value4", redisTemplate.opsForValue().get("key4"));
        System.out.println(redisTemplate.opsForValue().get("key2"));
    }

}
