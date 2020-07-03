package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 18:59
 * @Description:条件查询页面元素请求参数实体
 */
public class QueryPageElementRequestEntity extends RequestBaseEntity {

    private Integer pageElementId;//表记录主键id
    private String pageElementCode;//页面元素英文简码
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间
    private String createDatetimeEnd;//创建时间
    private String updateDatetimeStart;//最后修改时间
    private String updateDatetimeEnd;//最后修改时间

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
