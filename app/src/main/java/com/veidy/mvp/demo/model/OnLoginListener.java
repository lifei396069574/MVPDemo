package com.veidy.mvp.demo.model;

/**
 * Description: 监听器用来处理Model实现后的操作
 */
public interface OnLoginListener {


    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();

    public void onFailure();
}
