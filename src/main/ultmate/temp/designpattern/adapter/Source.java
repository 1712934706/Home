package temp.designpattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 需要适配的类
 */
public class Source {

  private static final Logger LOGGER = LoggerFactory.getLogger(Source.class);

  public void editText() {
    LOGGER.info("开始编辑 txt文本");
  }

}
