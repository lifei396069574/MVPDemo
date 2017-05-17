package com.veidy.mvp.demo.model;

/**
 * Description: 登录接口
 */
public interface LoginModel {

    void login(String name, String password, OnLoginListener onLoginListener);
}
