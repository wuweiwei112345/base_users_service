package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 17:35
 * @Description: 查询菜单数据参数实体
 */
public class QueryMenuRequestEntity {

    private Integer menuId;//表记录主键id
    private String menuName;//菜单名称
    private String menuDescribe;//菜单描述
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间
    private String createDatetimeEnd;//创建时间
    private String updateDatetimeStart;//最后修改时间
    private String updateDatetimeEnd;//最后修改时间

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
