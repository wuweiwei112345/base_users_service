package com.users.bean.request;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 17:09
 * @Description: 添加操作元素数据请求参数实体
 */
public class AddOperRequestEntity {

    private String operName;//操作名称
    private String operCode;//操作简码
    private String operUrl;//操作url(可预设参数预留参数位)
    private Integer parentOperId;//父操作id(为0表示没有)
    private Integer isDisable;//启用1禁用

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public Integer getParentOperId() {
        return parentOperId;
    }

    public void setParentOperId(Integer parentOperId) {
        this.parentOperId = parentOperId;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }
}
