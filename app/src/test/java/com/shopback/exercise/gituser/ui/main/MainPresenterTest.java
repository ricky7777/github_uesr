package com.shopback.exercise.gituser.ui.main;

import com.shopback.exercise.gituser.model.GitUser;
import com.shopback.exercise.gituser.service.ApiService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;

/**
 * Created by Ricky on 2019-05-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Test
    public void testFetchUsers() {
        ApiService apiService = Mockito.mock(ApiService.class);
        Call<List<GitUser>> mockedCall = Mockito.mock(Call.class);
        Mockito.when(apiService.getUsers(0, 20)).thenReturn(mockedCall);

        Mockito.doAnswer(invocation -> {
            Callback<List<GitUser>> callback = invocation.getArgument(0, Callback.class);

            callback.onResponse(mockedCall, Response.success(new ArrayList<>()));

            return null;
        }).when(mockedCall).enqueue(any(Callback.class));

    }

}