package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 17:34
 * @Description:
 */
public class AddMenuRequestEntity extends RequestBaseEntity {

    private Integer menuParentId;//父菜单id
    private String menuName;//菜单名称
    private String menuDescribe;//菜单描述
    private Integer isDisable;//启用1禁用

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescribe() {
        return menuDescribe;
    }

    public void setMenuDescribe(String menuDescribe) {
        this.menuDescribe = menuDescribe;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

}
