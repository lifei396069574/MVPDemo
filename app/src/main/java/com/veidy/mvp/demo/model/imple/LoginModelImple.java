package com.veidy.mvp.demo.model.imple;

import com.veidy.mvp.demo.http.HttpUtil;
import com.veidy.mvp.demo.model.LoginModel;
import com.veidy.mvp.demo.model.OnLoginListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Description: 登录Model实现，这里主要是网络请求的操作。
 */
public class LoginModelImple implements LoginModel {

    @Override
    public void login(String name, String password, final OnLoginListener onLoginListener) {
        String url = "http://192.168.23.226/mobile/index.php?act=login";
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("password", password);

        //网络请求
        HttpUtil.postAsync(url, params, new HttpUtil.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                onLoginListener.onFailure();
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                String json = new String(result);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    int code = 0;
                    code = jsonObject.getJSONObject("data").getInt("code");
                    //code=0 表示登录成功，code=1表示用户名错误，code=2表示密码错误
                    if (code == 0) {
                        onLoginListener.onSuccess();
                    } else if (code == 1) {
                        onLoginListener.onUsernameError();
                    } else if (code == 2) {
                        onLoginListener.onPasswordError();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

   }

}
