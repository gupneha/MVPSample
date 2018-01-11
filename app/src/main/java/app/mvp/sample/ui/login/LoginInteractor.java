package app.mvp.sample.ui.login;

import app.mvp.sample.retrofit.APIError;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public interface LoginInteractor {

    /**
     * login api call
     *
     * @param email    the email
     * @param password the password
     * @param listener the listener
     */
    void login(String email, String password, OnLoginFinishedListener listener);

    /**
     * listener to detect success and error for api call
     */
    interface OnLoginFinishedListener {
        /**
         * On error.
         *
         * @param error the error
         */
        void onError(APIError error);

        /**
         * On success.
         *
         * @param message the message
         */
        void onSuccess(String message);
    }


}
