package start;

import com.google.gson.Gson;
import mapper.UserMapper;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


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
    UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

        Gson gson = new Gson();
        User user = userMapper.selectUserById(1);

        System.out.println(gson.toJson(user));
        redisTemplate.opsForValue().set("test:set1", "testValue1");
        Assert.assertEquals("testValue1", redisTemplate.opsForValue().get("test:set1"));
        System.out.println(redisTemplate.opsForValue().get("test:set1"));
    }

}
