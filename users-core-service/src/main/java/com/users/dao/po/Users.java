package com.users.dao.po;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_phonenum
     *
     * @mbg.generated
     */
    private String userPhonenum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_email
     *
     * @mbg.generated
     */
    private String userEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_password
     *
     * @mbg.generated
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.is_disable
     *
     * @mbg.generated
     */
    private Integer isDisable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.create_datetime
     *
     * @mbg.generated
     */
    private Date createDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_id
     *
     * @return the value of users.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_id
     *
     * @param userId the value for users.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_name
     *
     * @return the value of users.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_name
     *
     * @param userName the value for users.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_phonenum
     *
     * @return the value of users.user_phonenum
     *
     * @mbg.generated
     */
    public String getUserPhonenum() {
        return userPhonenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_phonenum
     *
     * @param userPhonenum the value for users.user_phonenum
     *
     * @mbg.generated
     */
    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_email
     *
     * @return the value of users.user_email
     *
     * @mbg.generated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_email
     *
     * @param userEmail the value for users.user_email
     *
     * @mbg.generated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_password
     *
     * @return the value of users.user_password
     *
     * @mbg.generated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_password
     *
     * @param userPassword the value for users.user_password
     *
     * @mbg.generated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.is_disable
     *
     * @return the value of users.is_disable
     *
     * @mbg.generated
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.is_disable
     *
     * @param isDisable the value for users.is_disable
     *
     * @mbg.generated
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.create_datetime
     *
     * @return the value of users.create_datetime
     *
     * @mbg.generated
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.create_datetime
     *
     * @param createDatetime the value for users.create_datetime
     *
     * @mbg.generated
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }
}