package com.users.bean.request;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 15:57
 * @Description:查询文件元素请求数据实体
 */
public class QueryFileRequestEntity {

    private Integer fileId;//表记录主键id
    private String filePath;//文件路径
    private Integer isDisable;//0启用1禁用
    private String createDatetimeStart;//创建时间
    private String createDatetimeEnd;//创建时间
    private String updateDatetimeStart;//最后修改时间
    private String updateDatetimeEnd;//最后修改时间

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
