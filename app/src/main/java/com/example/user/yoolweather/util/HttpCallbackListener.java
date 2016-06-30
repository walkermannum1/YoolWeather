package com.example.user.yoolweather.util;

/**
 * Created by user on 2016/6/30.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
