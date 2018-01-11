package app.mvp.sample.ui.login;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public interface LoginPresenter {

    /**
     * Validate credentials.
     *
     * @param email    the email
     * @param password the password
     */
    void validateCredentials(final String email, final String password);
}
