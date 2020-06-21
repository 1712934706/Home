package temp.designpattern.factory.factoryfunction;

import temp.designpattern.factory.Car;
import temp.designpattern.factory.BENCHI;

public class BENCHIFactory implements CarFactory {

  @Override
  public Car getCar() {
    return new BENCHI();
  }
}
