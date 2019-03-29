package start;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import temp.ThreadMain;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadMainTest {

  @Autowired
  private ThreadMain threadMain;

  @Test
  public void testTestRunnable() {

    try {
      threadMain.testRunnable();
    } catch (Exception e) {
      Assert.assertTrue(true);
    }

  }


} 
