package app.mvp.sample.constant;

/**
 * Developer: Neha Gupta
 * Dated: 16/11/17
 */
public interface StatusCodeConstant {
    /**
     * The constant DEFAULT_STATUS_CODE.
     */
    int DEFAULT_STATUS_CODE = 900;
    /**
     * The constant UNAUTHORIZED.
     */
    int UNAUTHORIZED = 401;

    /**
     * The constant USER_NOT_FOUND.
     */
    int USER_NOT_FOUND = 404;
    /**
     * The constant SESSION_EXPIRED.
     */
    int SESSION_EXPIRED = UNAUTHORIZED;

    /**
     * The constant CONFLICT.
     */
    int CONFLICT = 409;

    /**
     * The constant GONE.
     */
    int GONE = 410;
}
