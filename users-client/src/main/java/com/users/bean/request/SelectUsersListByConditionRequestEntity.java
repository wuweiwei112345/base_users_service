package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 21:35
 * @Description:用户信息条件查询请求参数类
 */
public class SelectUsersListByConditionRequestEntity {

    private Integer userId;//表记录主键id
    private String userName;//用户名(登录使用)
    private String userPhonenum;//用户手机号(登录使用)
    private String userEmail;//用户邮箱(登录使用)
    private String userPassword;//用户密码(MD5加密结果)
    private Integer isDisable;//0启用1禁用
    private Integer isAdmin;//0非管理员 1管理员
    private String createDatetimeStart;//创建时间起始
    private String createDatetimeEnd;//创建时间结束

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(String createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public String getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(String createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
    }
}
