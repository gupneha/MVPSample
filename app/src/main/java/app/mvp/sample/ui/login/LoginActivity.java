package app.mvp.sample.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import app.mvp.sample.R;
import app.mvp.sample.retrofit.APIError;
import app.mvp.sample.ui.base.BaseActivity;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    private EditText etEmail;
    private EditText etPassword;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mLoginPresenter = new LoginPresenterImp(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                mLoginPresenter.validateCredentials(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
                break;

            default:
        }
    }

    @Override
    public void setEmailError(final String error) {
        etEmail.setError(error);
    }

    @Override
    public void setPasswordError(final String error) {
        etPassword.setError(error);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showApiError(final APIError error) {
        Toast
                .makeText(this, error.getMessage(), Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public void showApiSuccess(final String message) {
        Toast
                .makeText(this, message, Toast.LENGTH_SHORT)
                .show();
    }
}
