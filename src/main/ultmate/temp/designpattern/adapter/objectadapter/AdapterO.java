package temp.designpattern.adapter.objectadapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import temp.designpattern.adapter.Source;
import temp.designpattern.adapter.Targetable;

/**
 * 使用持有需要适配类的对象的形式来做一个适配器
 */
public class AdapterO implements Targetable {

  private static final Logger LOGGER = LoggerFactory.getLogger(AdapterO.class);

  private Source source;

  public AdapterO(Source source) {
    this.source = source;
  }

  public void editText() {
    source.editText();
  }

  public void editWord() {
    LOGGER.info("开始编辑 Word文件");
  }

}
