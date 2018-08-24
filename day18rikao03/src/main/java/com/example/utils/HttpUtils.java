package com.example.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2018/8/24.
 */

public class HttpUtils {

    private final OkHttpClient okHttpClient;
    //成员变量
    private static   HttpUtils httpUtils;

    //有参
    private  HttpUtils(){
        okHttpClient = new OkHttpClient();
    }
    //单例
    public  static  HttpUtils getinstance(){
        if (httpUtils==null){
            //同步锁
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils =new HttpUtils();
                }
            }
        }
        return  httpUtils;
    }
    //封装get方法
    public  void  getdata(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //封装post方法
    public  void  postdata(String path1, FormBody formBody,Callback callback){
        Request request = new Request.Builder().method("POST",formBody).url(path1).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
