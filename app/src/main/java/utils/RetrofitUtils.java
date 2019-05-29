package utils;

import com.shopback.exercise.gituser.config.GitUserConfig;
import com.shopback.exercise.gituser.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * retrofit utils, it's a singleton
 */
public class RetrofitUtils {
    private static RetrofitUtils instance = new RetrofitUtils();

    private ApiService apiService;

    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GitUserConfig.URL_API_BASE_GITHUB)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance() {
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
