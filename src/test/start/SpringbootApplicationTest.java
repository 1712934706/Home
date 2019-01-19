package start;

import com.google.gson.Gson;
import mapper.UserMapper;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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


    @Test
    public void contextLoads() {

        Gson gson = new Gson();
        User user = userMapper.selectUserById(1);

        System.out.println(gson.toJson(user));

    }

}
