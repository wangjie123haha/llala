package com.example.day18rikao03.di;

import android.util.Log;

import com.example.utils.HttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/8/24.
 */

public class moudleimp implements icontract.imoudle {
    String path ="http://www.zhaoapi.cn/product/getCarts?uid=71";
    @Override
    public void requestdata(final calllisten calllisten) {
        HttpUtils httpUtils = HttpUtils.getinstance();
        httpUtils.getdata(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //什么也不做
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("xxx",s+"");
                calllisten.responsemsg(s);
            }
        });
    }
}
