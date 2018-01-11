package app.mvp.sample.ui.login;

import app.mvp.sample.retrofit.APIError;
import app.mvp.sample.util.Validate;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public class LoginPresenterImp implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImp(final LoginView mLoginView) {
        this.mLoginView = mLoginView;
        this.mLoginInteractor = new LoginInteractorImp();
    }

    @Override
    public void validateCredentials(final String email, final String password) {
        if (validateFields(email, password)) {
            mLoginView.showProgress();
            mLoginInteractor.login(email, password, this);
        }
    }

    @Override
    public void onError(final APIError error) {
        mLoginView.hideProgress();
        mLoginView.showApiError(error);
    }

    @Override
    public void onSuccess(final String message) {
        mLoginView.hideProgress();
        mLoginView.showApiSuccess(message);
    }

    /**
     * validate email and password
     *
     * @param email    address entered
     * @param password entered by user
     * @return if data is valid
     */
    private boolean validateFields(final String email, final String password) {
        String emailValidationResponse = Validate.checkEmail(email);
        String passwordValidationResponse = Validate.checkPassword(password);
        if (emailValidationResponse != null) {
            mLoginView.setEmailError(emailValidationResponse);
            return false;
        }
        if (passwordValidationResponse != null) {
            mLoginView.setPasswordError(passwordValidationResponse);
            return false;
        }
        return true;
    }
}
