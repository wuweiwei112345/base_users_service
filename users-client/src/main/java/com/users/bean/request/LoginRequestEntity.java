package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 15:25
 * @Description:登录接口请求参数实体
 */
public class LoginRequestEntity {

    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
