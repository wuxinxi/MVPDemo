package com.zeno.mvpdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zeno.mvpdemo.R;
import com.zeno.mvpdemo.bean.User;
import com.zeno.mvpdemo.bean.UserInfo;
import com.zeno.mvpdemo.presenter.UserLoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class UserLoginActivity extends BaseActivity<ILoginView, UserLoginPresenter> implements ILoginView {

    @InjectView(R.id.et_user_name)
    EditText etUserName;
    @InjectView(R.id.et_password)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.inject(this);
    }

    @Override
    protected UserLoginPresenter createPresenter() {
        return new UserLoginPresenter(this);
    }


    @OnClick({R.id.btn_login})
    public void onClick(View view) {
        User user = new User();
        user.setToken("");
        user.setUserName(etUserName.getText().toString());
        user.setUserPassword(etPassword.getText().toString());
        mPresneter.userLogin(user);
    }

    @Override
    public void loginProgress() {
        Toast.makeText(UserLoginActivity.this, "login.....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginProgressSuccess() {
        Toast.makeText(UserLoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {
           // TODO: 2016/10/19   save user info and other option
    }

    @Override
    public void loginFailure(String msg) {
        // TODO: 2016/10/19 login failure toast
        Toast.makeText(UserLoginActivity.this, "login failure", Toast.LENGTH_SHORT).show();
    }
}
