package com.shopback.exercise.gituser.ui.userdetail;

import com.shopback.exercise.gituser.model.GitUser;
import com.shopback.exercise.gituser.service.ApiService;

import org.junit.Test;
import org.mockito.Mockito;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;

/**
 * Created by Ricky on 2019-05-29.
 */
public class UserDetailPresenterTest {

    @Test
    public void TestfetchUser() {
        ApiService apiService = Mockito.mock(ApiService.class);
        Call<GitUser> mockedCall = Mockito.mock(Call.class);
        Mockito.when(apiService.getUser("ricky7777")).thenReturn(mockedCall);

        Mockito.doAnswer(invocation -> {
            Callback<GitUser> callback = invocation.getArgument(0, Callback.class);

            callback.onResponse(mockedCall, Response.success(null));

            return null;
        }).when(mockedCall).enqueue(any(Callback.class));

    }
}