package temp.designpattern.adapter.classadapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 适配器，继承的方式适配source类
 */
public class AdapterC extends Source implements Targetable {

  private static final Logger LOGGER = LoggerFactory.getLogger(AdapterC.class);

  @Override
  public void editWord() {
    LOGGER.info("开始编辑 Word文件");
  }
}
