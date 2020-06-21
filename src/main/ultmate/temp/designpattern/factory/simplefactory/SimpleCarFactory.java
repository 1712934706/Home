package temp.designpattern.factory.simplefactory;

import temp.designpattern.factory.BENCHI;
import temp.designpattern.factory.BMW;
import temp.designpattern.factory.Car;

/**
 * 简单工厂方法
 * 缺点；
 * 1 扩展性差（我想增加一种面条，除了新增一个面条产品类，还需要修改工厂类方法）
 * 2 不同的产品需要不同额外参数的时候 不支持。
 */
public class SimpleCarFactory {

  public static Car carFactory(Class<?> tClass) {
    if (tClass.getName().equals(BMW.class.getName())) {
      return new BMW();
    }
    if (tClass.getName().equals(BENCHI.class.getName())) {
      return new BENCHI();
    }
    return null;
  }
}
