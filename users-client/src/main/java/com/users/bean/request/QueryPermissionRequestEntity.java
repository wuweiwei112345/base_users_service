package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

/**
 * @Auther: wuwei
 * @Date: 2020/6/28 17:50
 * @Description:
 */
public class QueryPermissionRequestEntity extends RequestBaseEntity {

    private Integer permissionId;//表记录主键
    private String permissionName;//权限名称
    private String permissionKey;//权限key
    private String permissionDescribe;//权限描述
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间
    private String createDatetimeEnd;//创建时间
    private String updateDatetimeStart;//最后修改时间
    private String updateDatetimeEnd;//最后修改时间

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

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }
}
