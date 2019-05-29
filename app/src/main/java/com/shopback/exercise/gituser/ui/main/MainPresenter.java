package com.shopback.exercise.gituser.ui.main;

import com.shopback.exercise.gituser.listener.BaseCallBack;
import com.shopback.exercise.gituser.model.GitUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import utils.RetrofitUtils;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * Main Presenter, be responsible for UserDetailView logic<br/>
 * like call api, receive data, and put data to UserDetailView
 */
public class MainPresenter {
    private MainView mainView;
    private final static int DEFAULT_PER_PAGE = 100;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void fetchUsers(int since) {
        Call<List<GitUser>> call = RetrofitUtils.getInstance().getApiService().getUsers(since,
                DEFAULT_PER_PAGE);
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

}
