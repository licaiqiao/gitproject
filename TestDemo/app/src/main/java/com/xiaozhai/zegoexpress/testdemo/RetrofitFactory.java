package com.xiaozhai.zegoexpress.testdemo;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author licaiqiao
 * @date 2018/9/14
 */
public class RetrofitFactory {
    //访问超时
    private static final long TIMEOUT=30;
    //Retrofit 是基于OkhttpClient,可以创建一个okhttpclient进行一些配置
    private static OkHttpClient httpClient=new OkHttpClient.Builder()
            //打印接口信息,方便接口调试
    .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger(){
        @Override
        public void log(String message) {
            Log.e("Tag","log"+message);
        }
    }

            ).setLevel(HttpLoggingInterceptor.Level.BASIC)).connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT,TimeUnit.SECONDS)
            .build();
    private static RetrofitService retrofitService=new Retrofit.Builder()
            .baseUrl(RetrofitService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(RetrofitService.class);
    //获得RetrofitService对象
    public  static RetrofitService getInstance(){
        return retrofitService;
    }
}
