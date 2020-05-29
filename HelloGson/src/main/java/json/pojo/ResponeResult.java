package json.pojo;

/**
 * Created by yangheng on 2017/6/9.
 */
public class ResponeResult<T> {
    private static final String SUCCESS_CODE = "0000000";
    private String errorCode;
    private String errorMessage;
    private ListData data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ListData getData() {
        return data;
    }

    public void setData(ListData data) {
        this.data = data;
    }
}
