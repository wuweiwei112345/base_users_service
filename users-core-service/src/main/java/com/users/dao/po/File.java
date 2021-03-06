package com.users.dao.po;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_id
     *
     * @mbg.generated
     */
    private Integer fileId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_path
     *
     * @mbg.generated
     */
    private String filePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.is_disable
     *
     * @mbg.generated
     */
    private Integer isDisable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.create_datetime
     *
     * @mbg.generated
     */
    private Date createDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.update_datetime
     *
     * @mbg.generated
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_id
     *
     * @return the value of file.file_id
     *
     * @mbg.generated
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_id
     *
     * @param fileId the value for file.file_id
     *
     * @mbg.generated
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_path
     *
     * @return the value of file.file_path
     *
     * @mbg.generated
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_path
     *
     * @param filePath the value for file.file_path
     *
     * @mbg.generated
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.is_disable
     *
     * @return the value of file.is_disable
     *
     * @mbg.generated
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.is_disable
     *
     * @param isDisable the value for file.is_disable
     *
     * @mbg.generated
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.create_datetime
     *
     * @return the value of file.create_datetime
     *
     * @mbg.generated
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.create_datetime
     *
     * @param createDatetime the value for file.create_datetime
     *
     * @mbg.generated
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.update_datetime
     *
     * @return the value of file.update_datetime
     *
     * @mbg.generated
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.update_datetime
     *
     * @param updateDatetime the value for file.update_datetime
     *
     * @mbg.generated
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}