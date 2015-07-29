package com.htech.restaurant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.htech.restaurant.R;

public class LoginActivity extends AppCompatActivity {
    private RelativeLayout mRoot;
    private TextInputLayout mEmailLayout;
    private TextInputLayout mPasswordLayout;
    private EditText mInputEmail;
    private EditText mInputPassword;
    private Button mbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mRoot = (RelativeLayout) findViewById(R.id.root_activity_second);
        mEmailLayout = (TextInputLayout) findViewById(R.id.email_layout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        mInputEmail = (EditText) findViewById(R.id.input_email);
        mInputPassword = (EditText) findViewById(R.id.input_password);
        mbtnLogin = (Button) findViewById(R.id.activity_login_btnLogin);
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    public void submit() {

        boolean isEmptyEmail = isEmptyEmail();
        boolean isEmptyPassword = isEmptyPassword();
        if (isEmptyEmail && isEmptyPassword) {
            Snackbar.make(mRoot, "One Or More Fields Are Blank", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();
        } else if (isEmptyEmail && !isEmptyPassword) {
            mEmailLayout.setError("Email Cannot Be Empty");
            mPasswordLayout.setError(null);
        } else if (!isEmptyEmail && isEmptyPassword) {
            mPasswordLayout.setError("Password Cannot Be Empty");
            mEmailLayout.setError(null);
        } else {
            //All Good Here
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    private boolean isEmptyEmail() {
        return mInputEmail.getText() == null
                || mInputEmail.getText().toString() == null
                || mInputEmail.getText().toString().isEmpty();

    }

    private boolean isEmptyPassword() {
        return mInputPassword.getText() == null
                || mInputPassword.getText().toString() == null
                || mInputPassword.getText().toString().isEmpty();

    }

    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}