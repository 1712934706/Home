package utils;

import java.io.Serializable;

/**
 * 数据包装类
 *
 * @param <T> 数据类型
 */
public class JsonData<T> implements Serializable {

  private static final long serialVersionUID = -5809782578272943991L;

  /**
   * 提示信息
   */
  private String message;
  /**
   * 错误码
   */
  private String code;

  /**
   * 执行是否成功
   */
  private Boolean isSuccess;

  /**
   * 数据结果
   */
  private T data;

  public JsonData(Boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

  public JsonData(Boolean isSuccess, String message) {
    this.isSuccess = isSuccess;
    this.message = message;
  }

  public JsonData(Boolean isSuccess, String message, T data) {
    this.isSuccess = isSuccess;
    this.message = message;
    this.data = data;
  }

  public JsonData(Boolean isSuccess, String code, String message, T data) {
    this.isSuccess = isSuccess;
    this.code = code;
    this.message = message;
    this.data = data;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getSuccess() {
    return isSuccess;
  }

  public void setSuccess(Boolean success) {
    isSuccess = success;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
