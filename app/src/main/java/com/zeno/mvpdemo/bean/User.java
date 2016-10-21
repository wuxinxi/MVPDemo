package com.zeno.mvpdemo.bean;

/**
 * Created by Zeno on 2016/10/19.
 */
public class User {

    private String token = "";
    private String userName;
    private String userPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
