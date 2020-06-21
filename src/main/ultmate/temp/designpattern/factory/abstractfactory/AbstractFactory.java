package temp.designpattern.factory.abstractfactory;

public abstract class AbstractFactory {

  public abstract AbstractCar getCar(String type) throws ClassNotFoundException,
      IllegalAccessException, InstantiationException;
}
