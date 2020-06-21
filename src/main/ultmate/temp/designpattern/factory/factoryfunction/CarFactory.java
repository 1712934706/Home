package temp.designpattern.factory.factoryfunction;

import temp.designpattern.factory.Car;

/**
 * 抽象工厂
 * 将类的实例化（具体产品的创建）延迟到工厂类的子类（具体工厂）中完成，即由子类来决定应该实例化（创建）哪一个类
 */
public interface CarFactory {
  Car getCar();
}
