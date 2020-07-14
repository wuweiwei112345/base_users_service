package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/14 16:29
 * @Description:设置角色与权限关联关系请求参数实体
 */
public class SetRolePermissionRequestEntity {

    private Integer roleId;//角色id
    private Integer permissionId;//权限id

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
