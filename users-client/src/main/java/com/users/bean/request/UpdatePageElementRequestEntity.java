package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 19:00
 * @Description:修改查询页面元素请求参数实体
 */
public class UpdatePageElementRequestEntity {

    private Integer pageElementId;//表记录主键id
    private String pageElementCode;//页面元素英文简码
    private Integer isDisable;//0启用1禁用

    public Integer getPageElementId() {
        return pageElementId;
    }

    public void setPageElementId(Integer pageElementId) {
        this.pageElementId = pageElementId;
    }

    public String getPageElementCode() {
        return pageElementCode;
    }

    public void setPageElementCode(String pageElementCode) {
        this.pageElementCode = pageElementCode;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

}
