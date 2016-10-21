package com.zeno.mvpdemo.model;

import com.zeno.mvpdemo.bean.User;
import com.zeno.mvpdemo.bean.UserInfo;

/**
 * Created by Zeno on 2016/10/19.
 */
public class UserLoginModelImpl implements IUserLoginModel {

    /*请求登录*/
    @Override
    public void login(User user, LoginListener listener) {
        // TODO: 2016/10/19  user login internet request
        UserInfo userInfo = new UserInfo();
        listener.onLoginSuccess(userInfo);
        listener.onLoginFailure("login failure");
    }
}
