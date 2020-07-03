package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 17:28
 * @Description: 条件查询操作请求参数实体
 */
public class QueryOperRequestEntity extends RequestBaseEntity {

    private Integer operId;//表记录主键id
    private String operName;//操作名称
    private String operCode;//操作简码
    private String operUrl;//操作url(可预设参数预留参数位)
    private Integer parentOperId;//父操作id（为0表示没有）
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间
    private String createDatetimeEnd;//创建时间
    private String updateDatetimeStart;//最后修改时间
    private String updateDatetimeEnd;//最后修改时间

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

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
