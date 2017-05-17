package com.veidy.mvp.demo.view;

/**
 * Description: 登录View
 */
public interface LoginView {

    //登录成功后跳转到首页
    void moveToIndex();

    //Toast
    void showToast(String msg);

    //获取界面的姓名
    String getName();

    //获取界面的密码
    String getPassword();
}
