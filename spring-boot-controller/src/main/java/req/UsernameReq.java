package req;

import com.zy.jsy.springbootcommon.utils.DV;

public class UsernameReq {

    @DV(nullable = false,minLength = 2,maxLength = 10)
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
