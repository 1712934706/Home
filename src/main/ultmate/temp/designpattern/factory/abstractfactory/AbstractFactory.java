package temp.designpattern.factory.abstractfactory;

/**
 * 抽象工厂
 * @see https://blog.csdn.net/qq564425/article/details/81082242
 */
public abstract class AbstractFactory {

  public abstract AbstractCar getCar(String type) throws ClassNotFoundException,
      IllegalAccessException, InstantiationException;
}
