package json.pojo;

import java.util.List;

/**
 * Created by yangheng on 2017/6/9.
 */
public class AccParam {
    private List<UserAndVa> userArray;

    public AccParam(List userArray) {
        this.userArray = userArray;
    }

    public List getUserArray() {
        return userArray;
    }

    public void setUserArray(List userArray) {
        this.userArray = userArray;
    }
}
