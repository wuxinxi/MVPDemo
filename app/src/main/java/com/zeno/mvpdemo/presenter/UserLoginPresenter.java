package com.zeno.mvpdemo.presenter;

import com.zeno.mvpdemo.bean.User;
import com.zeno.mvpdemo.bean.UserInfo;
import com.zeno.mvpdemo.model.IUserLoginModel;
import com.zeno.mvpdemo.model.UserLoginModelImpl;
import com.zeno.mvpdemo.view.ILoginView;

/**
 * Created by Zeno on 2016/10/19.
 */
public class UserLoginPresenter extends BasePresenter<ILoginView> {

    /*View*/
    ILoginView mLoginView ;

    /*model*/
    IUserLoginModel mUserLoginModel = new UserLoginModelImpl();

    public UserLoginPresenter(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    public void userLogin(User user) {
        if (mLoginView != null) {
                mLoginView.loginProgress();
                mUserLoginModel.login(user, new IUserLoginModel.LoginListener() {
                    @Override
                    public void onLoginSuccess(UserInfo userInfo) {
                        mLoginView.loginProgressSuccess();
                        mLoginView.loginSuccess(userInfo);
                    }

                    @Override
                    public void onLoginFailure(String msg) {
                        mLoginView.loginFailure(msg);
                    }
                });
        }
    }

}
