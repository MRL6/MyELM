package com.bwie.myelm.htpp;

import com.bwie.myelm.core.LoggingInterceptor;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {
    //单例模式
    private static Utils utils = new Utils();

    private Utils() {
    }

    public static Utils getHttpUtils() {
        if (utils == null) {
            utils = new Utils();
        }
        return utils;
    }
    public String get(String url){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
        Request build = new Request.Builder().url(url).get().build();
        try {
            Response execute = okHttpClient.newCall(build).execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
