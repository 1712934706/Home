package temp.designpattern.factory.abstractfactory;

/**
 * 超级工厂类，建造工厂的工厂
 */
public class FactoryProducer {


  public static AbstractFactory getFactory(String type)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    Class cl = Class.forName(type);
    System.out.println("创建工厂" + type);
    return (AbstractFactory) cl.newInstance();
  }
}
