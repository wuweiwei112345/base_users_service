package com.users.dao.po;

import java.io.Serializable;
import java.util.Date;

public class Oper implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.oper_id
     *
     * @mbg.generated
     */
    private Integer operId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.oper_name
     *
     * @mbg.generated
     */
    private String operName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.oper_code
     *
     * @mbg.generated
     */
    private String operCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.oper_url
     *
     * @mbg.generated
     */
    private String operUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.parent_oper_id
     *
     * @mbg.generated
     */
    private Integer parentOperId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.is_disable
     *
     * @mbg.generated
     */
    private Integer isDisable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.create_datetime
     *
     * @mbg.generated
     */
    private Date createDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oper.update_datetime
     *
     * @mbg.generated
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oper
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.oper_id
     *
     * @return the value of oper.oper_id
     *
     * @mbg.generated
     */
    public Integer getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.oper_id
     *
     * @param operId the value for oper.oper_id
     *
     * @mbg.generated
     */
    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.oper_name
     *
     * @return the value of oper.oper_name
     *
     * @mbg.generated
     */
    public String getOperName() {
        return operName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.oper_name
     *
     * @param operName the value for oper.oper_name
     *
     * @mbg.generated
     */
    public void setOperName(String operName) {
        this.operName = operName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.oper_code
     *
     * @return the value of oper.oper_code
     *
     * @mbg.generated
     */
    public String getOperCode() {
        return operCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.oper_code
     *
     * @param operCode the value for oper.oper_code
     *
     * @mbg.generated
     */
    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.oper_url
     *
     * @return the value of oper.oper_url
     *
     * @mbg.generated
     */
    public String getOperUrl() {
        return operUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.oper_url
     *
     * @param operUrl the value for oper.oper_url
     *
     * @mbg.generated
     */
    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.parent_oper_id
     *
     * @return the value of oper.parent_oper_id
     *
     * @mbg.generated
     */
    public Integer getParentOperId() {
        return parentOperId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.parent_oper_id
     *
     * @param parentOperId the value for oper.parent_oper_id
     *
     * @mbg.generated
     */
    public void setParentOperId(Integer parentOperId) {
        this.parentOperId = parentOperId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.is_disable
     *
     * @return the value of oper.is_disable
     *
     * @mbg.generated
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.is_disable
     *
     * @param isDisable the value for oper.is_disable
     *
     * @mbg.generated
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.create_datetime
     *
     * @return the value of oper.create_datetime
     *
     * @mbg.generated
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.create_datetime
     *
     * @param createDatetime the value for oper.create_datetime
     *
     * @mbg.generated
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oper.update_datetime
     *
     * @return the value of oper.update_datetime
     *
     * @mbg.generated
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oper.update_datetime
     *
     * @param updateDatetime the value for oper.update_datetime
     *
     * @mbg.generated
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}