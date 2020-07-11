package temp.designpattern.adapter;

import temp.designpattern.adapter.classadapter.AdapterC;
import temp.designpattern.adapter.classadapter.Targetable;


/**
 * 测试适配器代码
 */
public class AdapterTest {

  public void test(String[] argas) {

    //类继承适配器测试
    Targetable targetable = new AdapterC();
    targetable.editWord();
    targetable.editText();
  }
}
