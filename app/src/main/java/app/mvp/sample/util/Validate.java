package app.mvp.sample.util;

import android.util.Patterns;

import app.mvp.sample.MyApplication;
import app.mvp.sample.R;
import app.mvp.sample.constant.AppConstant;

/**
 * Generic reusable methods to validate field data
 */
public final class Validate implements AppConstant {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Empty Constructor
     * not called
     */
    private Validate() {
    }

    /**
     * Method to check string is empty or not
     *
     * @param data value which need to validate
     * @return true if empty or null else false
     */
    public static boolean isEmpty(final String data) {
        return data == null || data.isEmpty();

    }

    /**
     * Check email string.
     *
     * @param email the email
     * @return the string
     */
    public static String checkEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return MyApplication.getAppContext().getString(R.string.error_email_field_empty);
        }
        if (!email.matches(Patterns.EMAIL_ADDRESS.toString())) {
            return MyApplication.getAppContext().getString(R.string.error_invalid_email);
        }
        return null;
    }

    /**
     * Check email string.
     *
     * @param email the email
     * @return the string
     */
    public static boolean validEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    /**
     * Check password string.
     *
     * @param password the password
     * @return the string
     */
    public static String checkPassword(final String password) {
        if (password == null || password.isEmpty()) {
            return MyApplication.getAppContext().getString(R.string.error_password_field_empty);
        }
        if (!checkPassLength(password)) {
            return MyApplication.getAppContext().getString(R.string.error_password_must_consists_at_least_6_character);
        }
        return null;
    }

    /**
     * Check if password is valid or not
     *
     * @param password the password
     * @return the string
     */
    public static boolean validPassword(final String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (!checkPassLength(password)) {
            return false;
        }
        return true;
    }

    /**
     * Check pass length boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean checkPassLength(final String password) {
        return !(password == null || password.length() < PASSWORD_LENGTH);
    }

}
