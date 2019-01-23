package utils;

/**
 * 数据包装类
 *
 * @param <T> 熟路类型
 */
public class JsonData<T> {

    private String message;
    private String code;
    private Boolean isSuccess;

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
