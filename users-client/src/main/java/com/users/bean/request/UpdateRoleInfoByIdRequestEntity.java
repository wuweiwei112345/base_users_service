package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 14:51
 * @Description:修改角色信息根据角色id请求参数实体
 */
public class UpdateRoleInfoByIdRequestEntity {

    private Integer roleId;//表记录主键
    private String roleName;//角色名称
    private String roleDescribe;//角色描述
    private Integer isDisable;//0启用1禁用

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }
}
