package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 21:05
 * @Description:修改用户信息根据主键id请求参数实体
 */
public class UpdateUserInfoByIdRequestEntity {

    private Integer userId;//用户id
    private Integer isAdmin = 0;//是否是管理员 0非管理员 1管理员
    private String userPhonenum;//用户手机号(登录使用)
    private String userEmail;//用户邮箱(登录使用)
    private String userPassword;//用户密码(MD5加密结果)
    private Integer isDisable;//0启用1禁用

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserPhonenum() {
        return userPhonenum;
    }

    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }
}
