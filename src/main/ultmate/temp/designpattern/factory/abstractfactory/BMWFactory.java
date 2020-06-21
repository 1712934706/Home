package temp.designpattern.factory.abstractfactory;

public class BMWFactory extends AbstractFactory {

  public AbstractCar getCar(String type) throws ClassNotFoundException,
      IllegalAccessException, InstantiationException {
    Class cl = Class.forName(type);
    return (BMWCar) cl.newInstance();
  }
}
