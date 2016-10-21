package com.zeno.mvpdemo.view;

import com.zeno.mvpdemo.bean.UserInfo;

/**
 * Created by Zeno on 2016/10/19.
 */
public interface ILoginView {

    /*login waite progress*/
    void loginProgress();

    /*login success hide progress*/
    void loginProgressSuccess();

    void loginSuccess(UserInfo userInfo);

    void loginFailure(String msg);
}
