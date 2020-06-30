package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 18:59
 * @Description:添加页面元素请求参数实体
 */
public class AddPageElementRequestEntity {

    private String pageElementCode;//页面元素英文简码
    private Integer isDisable;//0启用1禁用

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
