package temp.designpattern.factory.factoryfunction;

import temp.designpattern.factory.Car;
import temp.designpattern.factory.BMW;

public class BMWFactory implements CarFactory {

  @Override
  public Car getCar() {
    return new BMW();
  }
}
