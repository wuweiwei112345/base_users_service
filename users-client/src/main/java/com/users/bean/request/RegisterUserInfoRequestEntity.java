package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 11:01
 * @Description:注册用户信息请求实体
 */
public class RegisterUserInfoRequestEntity {

    private String userName;//用户名(登录使用)
    private String userPhonenum;//用户手机号(登录使用)
    private String userPassword;//用户密码(MD5加密结果)
    private Integer isAdmin;//是否是管理员 0非管理员 1管理员

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhonenum() {
        return userPhonenum;
    }

    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}
