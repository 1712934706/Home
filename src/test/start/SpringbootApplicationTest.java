package start;

import com.alibaba.fastjson.JSON;
import mapper.UserMapper;
import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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

        User user = userMapper.selectUserById(1);

        System.out.println(JSON.toJSONString(user));
        redisTemplate.opsForValue().set("key2", "value2");
        Assert.assertEquals("value2", redisTemplate.opsForValue().get("key2"));
        System.out.println(redisTemplate.opsForValue().get("key2"));
    }

}
