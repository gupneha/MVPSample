package app.mvp.sample.ui.login;

import app.mvp.sample.BuildConfig;
import app.mvp.sample.constant.ApiConstant;
import app.mvp.sample.constant.AppConstant;
import app.mvp.sample.retrofit.APIError;
import app.mvp.sample.retrofit.ApiParams;
import app.mvp.sample.retrofit.ApiResponse;
import app.mvp.sample.retrofit.ResponseResolver;
import app.mvp.sample.retrofit.RestClient;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public class LoginInteractorImp implements LoginInteractor, AppConstant, ApiConstant {

    @Override
    public void login(final String email, final String password, final OnLoginFinishedListener listener) {

        ApiParams apiParams = new ApiParams.Builder()
                .add(API_EMAIL, email)
                .add(API_PASSWORD, password)
                .add(API_DEVICE_TYPE, DEVICE_TYPE)
                .add(API_DEVICE_TOKEN, "abcde")
                .add(API_LATITUDE, 0)
                .add(API_LONGITUDE, 0)
                .add(API_APP_VERSION, BuildConfig.VERSION_CODE)
                .add(API_FLUSH_SESSION, true)
                .build();

        RestClient
                .getApiInterface()
                .userLogin(apiParams.getMap())
                .enqueue(new ResponseResolver<ApiResponse>() {
                    @Override
                    public void success(final ApiResponse apiResponse) {
                        listener.onSuccess(apiResponse.getMessage());
                    }

                    @Override
                    public void failure(final APIError error) {
                        listener.onError(error);
                    }
                });

    }
}
