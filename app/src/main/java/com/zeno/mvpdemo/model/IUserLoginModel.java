package com.zeno.mvpdemo.model;

import com.zeno.mvpdemo.bean.User;
import com.zeno.mvpdemo.bean.UserInfo;

/**
 * Created by Zeno on 2016/10/19.
 */
public interface IUserLoginModel {

    void login(User user,LoginListener listener);

    interface LoginListener{
        void onLoginSuccess(UserInfo userInfo);
        void onLoginFailure(String msg);
    }
}
