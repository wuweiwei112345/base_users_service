package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 15:14
 * @Description: 修改权限请求实体
 */
public class UpdatePermissionRequestEntity extends RequestBaseEntity {

    private Integer permissionId;//权限主键id
    private String permissionName;//权限名称
    private String permissionKey;//权限key
    private String permissionDescribe;//权限描述
    private Integer isDisable;//0启用1禁用
    private Date create_datetime;//创建时间
    private Date update_datetime;//最后修改时间

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescribe() {
        return permissionDescribe;
    }

    public void setPermissionDescribe(String permissionDescribe) {
        this.permissionDescribe = permissionDescribe;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Date getCreate_datetime() {
        return create_datetime;
    }

    public void setCreate_datetime(Date create_datetime) {
        this.create_datetime = create_datetime;
    }

    public Date getUpdate_datetime() {
        return update_datetime;
    }

    public void setUpdate_datetime(Date update_datetime) {
        this.update_datetime = update_datetime;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }
}
