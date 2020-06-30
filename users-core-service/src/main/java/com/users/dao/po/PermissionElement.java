package com.users.dao.po;

import java.io.Serializable;
import java.util.Date;

public class PermissionElement implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission_element.permission_element_id
     *
     * @mbg.generated
     */
    private Integer permissionElementId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission_element.permission_id
     *
     * @mbg.generated
     */
    private Integer permissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission_element.element_id
     *
     * @mbg.generated
     */
    private Integer elementId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission_element.element_type
     *
     * @mbg.generated
     */
    private Integer elementType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission_element.create_datetime
     *
     * @mbg.generated
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission_element
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission_element.permission_element_id
     *
     * @return the value of permission_element.permission_element_id
     *
     * @mbg.generated
     */
    public Integer getPermissionElementId() {
        return permissionElementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission_element.permission_element_id
     *
     * @param permissionElementId the value for permission_element.permission_element_id
     *
     * @mbg.generated
     */
    public void setPermissionElementId(Integer permissionElementId) {
        this.permissionElementId = permissionElementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission_element.permission_id
     *
     * @return the value of permission_element.permission_id
     *
     * @mbg.generated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission_element.permission_id
     *
     * @param permissionId the value for permission_element.permission_id
     *
     * @mbg.generated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission_element.element_id
     *
     * @return the value of permission_element.element_id
     *
     * @mbg.generated
     */
    public Integer getElementId() {
        return elementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission_element.element_id
     *
     * @param elementId the value for permission_element.element_id
     *
     * @mbg.generated
     */
    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission_element.element_type
     *
     * @return the value of permission_element.element_type
     *
     * @mbg.generated
     */
    public Integer getElementType() {
        return elementType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission_element.element_type
     *
     * @param elementType the value for permission_element.element_type
     *
     * @mbg.generated
     */
    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission_element.create_datetime
     *
     * @return the value of permission_element.create_datetime
     *
     * @mbg.generated
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission_element.create_datetime
     *
     * @param createDatetime the value for permission_element.create_datetime
     *
     * @mbg.generated
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }
}