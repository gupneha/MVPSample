package app.mvp.sample.retrofit;

import java.lang.annotation.Annotation;

import app.mvp.sample.constant.StatusCodeConstant;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Developer: Neha Gupta
 * Dated: 16/11/17
 */
final class ErrorUtils {
    /**
     * Empty Constructor
     * not called
     */
    private ErrorUtils() {
    }

    /**
     * Parse error api error.
     *
     * @param response response of api call
     * @return object of APIError
     */
    static APIError parseError(final Response<?> response) {
        final Converter<ResponseBody, APIError> converter = RestClient.getRetrofitBuilder().responseBodyConverter(APIError.class, new Annotation[0]);
        final APIError error;
        try {
            if (response.errorBody() != null) {
                error = converter.convert(response.errorBody());
            } else {
                error = new APIError(response.code(), response.message());
            }

        } catch (final Exception e) {
            int statusCode = StatusCodeConstant.DEFAULT_STATUS_CODE;
            String message = ResponseResolver.UNEXPECTED_ERROR_OCCURRED;
            if (response.code() != 0) {
                statusCode = response.code();
            }
            if (response.message() != null && !response.message().isEmpty()) {
                message = response.message();
            }
            return new APIError(statusCode, message);
        }
        return error;
    }
}
