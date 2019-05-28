package com.shopback.exercise.gituser.service;

import com.shopback.exercise.gituser.model.GitUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * api service interface for retrofit2<br/>
 * adapter Get/Post receive data to pojo object
 */
public interface ApiService {
    @GET("users")
    Call<List<GitUser>> getUsers(@Query("since") Integer githubUserId,@Query("per_page") Integer perPage);

    @GET("users/{userLoginName}")
    Call<GitUser> getUser(@Path("userLoginName") String userLoginName);
}
