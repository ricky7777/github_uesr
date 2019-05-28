package com.shopback.exercise.gituser.ui.main;

import com.shopback.exercise.gituser.config.GitUserConfig;
import com.shopback.exercise.gituser.listener.BaseCallBack;
import com.shopback.exercise.gituser.model.GitUser;
import com.shopback.exercise.gituser.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * Main Presenter, be responsible for MainView logic<br/>
 * like call api, receive data, and put data to MainView
 */
public class MainPresenter {
    private MainView mainView;
    private ApiService apiService;
    private final static int DEFAULT_PER_PAGE = 20;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GitUserConfig.URL_API_BASE_GITHUB)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public void fetchUsers(int since) {
        Call<List<GitUser>> call = apiService.getUsers(since, DEFAULT_PER_PAGE);
        call.enqueue(new BaseCallBack<List<GitUser>>() {

            @Override
            public void onResponseSuccess(Response<List<GitUser>> response) {
                mainView.addGitUsers(response.body());
            }

            @Override
            public void onResponseFail(Throwable throwable) {

            }
        });
    }

    public void fetchUser(String userLoginName) {
        Call<GitUser> gitUserCall = apiService.getUser(userLoginName);
        gitUserCall.enqueue(new BaseCallBack<GitUser>() {
            @Override
            public void onResponseSuccess(Response<GitUser> response) {
                mainView.showGitUserDetail(response.body());
            }

            @Override
            public void onResponseFail(Throwable throwable) {

            }
        });
    }
}