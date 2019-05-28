package com.shopback.exercise.gituser;

import android.util.Log;

import com.shopback.exercise.gituser.config.GitUserConfig;
import com.shopback.exercise.gituser.model.GitUser;
import com.shopback.exercise.gituser.service.ApiService;

import org.junit.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * api test
 */
public class ApiTest {
    private ApiService apiService;

    public ApiTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GitUserConfig.URL_API_BASE_GITHUB)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    @Test
    public void testGetUsers() {
        final int perPage = 20;
        Call<List<GitUser>> call = apiService.getUsers(0, 20);
        call.enqueue(new Callback<List<GitUser>>() {
            @Override
            public void onResponse(Call<List<GitUser>> call, Response<List<GitUser>> response) {
                assertEquals(response.body().size(), perPage);
            }

            @Override
            public void onFailure(Call<List<GitUser>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Test
    public void testGetUser() {
        final String userLoginName = "ricky7777";
        Call<GitUser> gitUserCall = apiService.getUser(userLoginName);
        gitUserCall.enqueue(new Callback<GitUser>() {
            @Override
            public void onResponse(Call<GitUser> call, Response<GitUser> response) {
                GitUser gitUser = response.body();
                assertEquals(gitUser.getLogin(), userLoginName);
            }

            @Override
            public void onFailure(Call<GitUser> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
