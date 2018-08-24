package com.example.day18rikao03.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.adapter.myadapter;
import com.example.bean.news;
import com.example.day18rikao03.R;
import com.example.day18rikao03.di.icontract;
import com.example.day18rikao03.di.presenterimp;
import com.google.gson.Gson;

import java.util.List;

public class show extends AppCompatActivity implements icontract.iview, View.OnClickListener {

    private RecyclerView recycle01;
    private CheckBox cb_01;
    private TextView zj;
    private Button js;
    private presenterimp presenterimp;
    private List<news.DataBean> data;
    private com.example.adapter.myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //初始化
        recycle01 = findViewById(R.id.recycle01);
        cb_01 = findViewById(R.id.cb_01);
        zj = findViewById(R.id.zj);
        js = findViewById(R.id.js);
        cb_01.setOnClickListener(this);
        //创建presenter层
        presenterimp = new presenterimp();
        //关联
        presenterimp.attachview(this);
        //请求
        presenterimp.requestinfo();
    }
  //显示请求方法
    @Override
    public void showtinfo(final String s) {
        //轻质转换
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //解析
                Gson gson = new Gson();
                news news = gson.fromJson(s, news.class);
                data = news.getData();
                //创建适配器
                myadapter = new myadapter(show.this, data);
                //创建布局管理器
                LinearLayoutManager manager = new LinearLayoutManager(show.this, LinearLayoutManager.VERTICAL, false);
                //设置布局管理器
                recycle01.setLayoutManager(manager);
                //添加适配器
                recycle01.setAdapter(myadapter);
            }
        });
    }
    //销毁视图

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterimp.detachview(this);
    }
 //监听方法
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.cb_01:
                //全选
                switch (view.getId()){
                    case R.id.cb_01:
                        if(cb_01.isChecked()){
                            for (int i = 0; i <data.size() ; i++) {
                                data.get(i).setChecked(true);
                                for (int j = 0; j < data.get(i).getList().size(); j++) {
                                    data.get(i).getList().get(j).setChecked(true);
                                }
                            }
                        }else {
                            for (int i = 0; i <data.size() ; i++) {
                                data.get(i).setChecked(false);
                                for (int j = 0; j < data.get(i).getList().size(); j++) {
                                    data.get(i).getList().get(j).setChecked(false);
                                }

                            }
                        }
                        myadapter.notifyDataSetChanged();
                        break;
                }
                break;
            default:
                    break;
        }
    }
}
