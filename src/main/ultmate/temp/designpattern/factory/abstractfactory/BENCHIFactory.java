package temp.designpattern.factory.abstractfactory;

public class BENCHIFactory extends AbstractFactory {

  public AbstractCar getCar(String type) throws ClassNotFoundException,
      IllegalAccessException, InstantiationException {
    Class cl = Class.forName(type);
    return (BENCHICar) cl.newInstance();
  }
}
