package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 14:37
 * @Description:角色信息条件查询请求参数实体
 */
public class SelectRoleInfoByConditionRequestEntity {

    private Integer roleId;//表记录主键
    private String roleName;//角色名称
    private String roleDescribe;//角色描述
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间起始
    private String createDatetimeEnd;//创建时间结束
    private String updateDatetimeStart;//最后修改时间起始
    private String updateDatetimeEnd;//最后修改时间起始

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

    public String getUpdateDatetimeStart() {
        return updateDatetimeStart;
    }

    public void setUpdateDatetimeStart(String updateDatetimeStart) {
        this.updateDatetimeStart = updateDatetimeStart;
    }

    public String getUpdateDatetimeEnd() {
        return updateDatetimeEnd;
    }

    public void setUpdateDatetimeEnd(String updateDatetimeEnd) {
        this.updateDatetimeEnd = updateDatetimeEnd;
    }
}
