package com.example.entity;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-09-30 16:15:59
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 473103370837597114L;

    private String userId;

    private String userName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}