package temp.designpattern.builder;

public class BuulderTest {

  //链式调用
  Computer computer = new Computer.Builder("KUNPENG", "32GB").setDisplay("京东方").setKeyboard("CHO")
      .build();

}
