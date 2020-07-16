package temp.designpattern.adapter;

import temp.designpattern.adapter.classadapter.AdapterC;
import temp.designpattern.adapter.objectadapter.AdapterO;


/**
 * 测试适配器代码
 */
public class AdapterTest {

  public void test(String[] argas) {

    //类继承适配器测试
    Targetable targetable = new AdapterC();
    targetable.editWord();
    targetable.editText();

    //对象适配器模式
    Targetable targetable1 = new AdapterO(new Source());
    targetable1.editText();
    targetable1.editWord();
  }
}
