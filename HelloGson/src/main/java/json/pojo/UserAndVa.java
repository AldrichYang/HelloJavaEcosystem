package json.pojo;

/**
 * Created by yangheng on 2017/6/9.
 */
public class UserAndVa {
    Long userId;
    Long vaId;

    public UserAndVa(Long userId, Long vaId) {
        this.userId = userId;
        this.vaId = vaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVaId() {
        return vaId;
    }

    public void setVaId(Long vaId) {
        this.vaId = vaId;
    }
}
