package temp.designpattern.factory;

import temp.designpattern.factory.abstractfactory.AbstractCar;
import temp.designpattern.factory.abstractfactory.AbstractFactory;
import temp.designpattern.factory.abstractfactory.FactoryProducer;
import temp.designpattern.factory.factoryfunction.BMWFactory;
import temp.designpattern.factory.simplefactory.SimpleCarFactory;

/**
 * 不同工厂的测试类
 *
 * https://www.cnblogs.com/long88-club/p/11055555.html https://www.cnblogs.com/JuanF/p/9275833.html
 */
public class FactoryTest {

  public void Test() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    //简单工厂
    SimpleCarFactory.carFactory(BENCHI.class);

    //工厂模式
    Car bmw = new BMWFactory().getCar();
    bmw.getCar();

    //抽象工厂
    AbstractFactory abstractFactory = FactoryProducer.getFactory("BMWFactory");
    AbstractCar bmwCar3 = abstractFactory.getCar("BMW3");
    bmwCar3.drive();

    AbstractCar bmwCar5 = abstractFactory.getCar("BMW5");
    bmwCar5.drive();

    AbstractFactory abstractFactory1 = FactoryProducer.getFactory("BENCHIFactory");
    AbstractCar benzCar200 = abstractFactory1.getCar("BENCHI200");
    benzCar200.drive();

    AbstractCar benzCar300 = abstractFactory1.getCar("BENCHI300");
    benzCar300.drive();

  }

}
