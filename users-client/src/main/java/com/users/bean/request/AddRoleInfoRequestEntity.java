package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 11:05
 * @Description:添加角色信息请求参数实体
 */
public class AddRoleInfoRequestEntity {

    private String roleName;//角色名称
    private String roleDescribe;//角色描述

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

}
