package app.mvp.sample.ui.login;

import app.mvp.sample.retrofit.APIError;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public interface LoginView {

    /**
     * Set email related error
     *
     * @param error the error
     */
    void setEmailError(final String error);

    /**
     * Set password related error
     *
     * @param error the error
     */
    void setPasswordError(final String error);

    /**
     * Show progress bar.
     */
    void showProgress();

    /**
     * Hide progress bar
     */
    void hideProgress();

    /**
     * Show error related to api call
     *
     * @param error the error
     */
    void showApiError(final APIError error);

    /**
     * Show success message in response to api call
     *
     * @param message to be displayed
     */
    void showApiSuccess(final String message);
}
