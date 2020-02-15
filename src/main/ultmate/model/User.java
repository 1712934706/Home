package model;


import java.util.Objects;

/**
 * 用户基本信息类
 */
public class User {

  /**
   * 用户id
   */
  private int id;

  /**
   * 名字
   */
  private String name;

  /**
   * 密码
   */
  private String password;

  /**
   * 别名
   */
  private String alias;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 手机
   */
  private String mobilePhone;

  /**
   * 性别
   */
  private String sex;

  /**
   * 年龄
   */
  private String age;


  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String getAlias() {
    return alias;
  }

  public String getEmail() {
    return email;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getSex() {
    return sex;
  }

  public String getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id &&
        Objects.equals(name, user.name) &&
        Objects.equals(password, user.password) &&
        Objects.equals(alias, user.alias) &&
        Objects.equals(email, user.email) &&
        Objects.equals(mobilePhone, user.mobilePhone) &&
        Objects.equals(sex, user.sex) &&
        Objects.equals(age, user.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password, alias, email, mobilePhone, sex, age);
  }

}
