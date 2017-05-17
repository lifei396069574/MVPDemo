package com.veidy.mvp.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.veidy.mvp.demo.MainActivity;
import com.veidy.mvp.demo.R;
import com.veidy.mvp.demo.presenter.LoginPresenter;
import com.veidy.mvp.demo.view.LoginView;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener, LoginView {

    private EditText et_name;
    private EditText et_password;
    private Button btn_login;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        loginPresenter = new LoginPresenter(this);

    }


    private void initViews() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.btn_login:
                loginPresenter.login();
                break;
            default:
                break;

        }
    }

    @Override
    public void moveToIndex() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }
}
