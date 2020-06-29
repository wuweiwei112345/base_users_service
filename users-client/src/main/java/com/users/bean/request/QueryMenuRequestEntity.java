package com.users.bean.request;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 17:35
 * @Description:
 */
public class QueryMenuRequestEntity {

    private Integer menuId;//表记录主键id
    private String menuName;//菜单名称
    private String menuDescribe;//菜单描述
    private Integer isDisable;//启用1禁用
    private Date createDatetimeStart;//创建时间
    private Date updateDatetimeEnd;//最后修改时间

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public Date getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(Date createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public Date getUpdateDatetimeEnd() {
        return updateDatetimeEnd;
    }

    public void setUpdateDatetimeEnd(Date updateDatetimeEnd) {
        this.updateDatetimeEnd = updateDatetimeEnd;
    }
}
