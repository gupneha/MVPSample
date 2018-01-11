package app.mvp.sample.retrofit;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Developer: Neha Gupta
 * Dated: 16/11/17
 */
public interface ApiInterface {

    /**
     * The constant USER_LOGIN.
     */
    String USER_LOGIN = "api/customer/login";

    /**
     * User login api call
     *
     * @param fieldMap the field map
     * @return the call
     */
    @FormUrlEncoded
    @POST(USER_LOGIN)
    Call<ApiResponse> userLogin(@FieldMap HashMap<String, String> fieldMap);
}

