package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/14 15:58
 * @Description:设置用户角色关系请求参数实体
 */
public class SetUserRoleRequestEntity {

    private Integer userId;//用户id
    private Integer roleId;//角色id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
