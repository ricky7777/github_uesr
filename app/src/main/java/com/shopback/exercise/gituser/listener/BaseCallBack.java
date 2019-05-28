package com.shopback.exercise.gituser.listener;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * base call back, handle onResponse no successful situation<br/>
 * and onFailure situation.
 */
public abstract class BaseCallBack<T> implements Callback<T> {
    @Override
    final public void onResponse(@NotNull Call call, @NotNull Response response) {
        if (response.isSuccessful()) {
            onResponseSuccess(response);
        } else {
            // TODO record fail in crashlytics
            onResponseFail(new HttpException(response));
        }
    }

    @Override
    final public void onFailure(Call call, Throwable throwable) {
        // TODO record fail in crashlytics
        onResponseFail(throwable);
    }

    public abstract void onResponseSuccess(Response<T> response);

    public abstract void onResponseFail(Throwable throwable);

}
