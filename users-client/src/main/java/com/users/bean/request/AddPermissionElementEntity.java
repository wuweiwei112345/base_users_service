package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 15:13
 * @Description:添加权限与元素之间的关联数据请求实体
 */
public class AddPermissionElementEntity extends RequestBaseEntity {

    private Integer permissionId;//权限id
    private Integer elementId;//权限关联元素id
    private Integer elementType;//权限关联子元素类型

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

}
