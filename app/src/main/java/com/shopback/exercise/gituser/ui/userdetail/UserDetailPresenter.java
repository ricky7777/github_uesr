package com.shopback.exercise.gituser.ui.userdetail;

import com.shopback.exercise.gituser.listener.BaseCallBack;
import com.shopback.exercise.gituser.model.GitUser;

import retrofit2.Call;
import retrofit2.Response;
import utils.RetrofitUtils;

/**
 * Created by Ricky on 2019-05-29.<br/>
 * UserDetail Presenter, be responsible for UserDetailView logic<br/>
 * like call api, receive data, and put data to UserDetailView
 */
public class UserDetailPresenter {
    private UserDetailView userDetailView;

    public UserDetailPresenter(UserDetailView userDetailView) {
        this.userDetailView = userDetailView;
    }

    public void fetchUser(String userLoginName) {
        Call<GitUser> gitUserCall =
                RetrofitUtils.getInstance().getApiService().getUser(userLoginName);
        gitUserCall.enqueue(new BaseCallBack<GitUser>() {
            @Override
            public void onResponseSuccess(Response<GitUser> response) {
                userDetailView.showGitUserDetail(response.body());
            }

            @Override
            public void onResponseFail(Throwable throwable) {

            }
        });
    }
}
