package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.bean.news;
import com.example.day18rikao03.R;

import java.util.List;

/**
 * Created by lenovo on 2018/8/25.
 */

public class myadapter extends RecyclerView.Adapter<myadapter.oneholder> {

    private Context context;
    private List<com.example.bean.news.DataBean> list;

    public myadapter(Context context, List<news.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public oneholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include1, null);
        oneholder oneholder = new oneholder(view);
        return oneholder;
    }

    @Override
    public void onBindViewHolder(oneholder holder, int position) {
          holder.cb_02.setText(list.get(position).getSellerName());
          //设置选中状态
           holder.cb_02.setChecked(list.get(position).isChecked());
          //创建布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //设置布局管理器
        holder.recycle02.setLayoutManager(manager);
        //创建适配器
        myadapter1 myadapter1 = new myadapter1(context,list.get(position).getList());
        //设置适配器
        holder.recycle02.setAdapter(myadapter1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  oneholder extends  RecyclerView.ViewHolder{

        private final CheckBox cb_02;
        private final RecyclerView recycle02;

        public oneholder(View itemView) {
            super(itemView);
            //初始化
            cb_02 = itemView.findViewById(R.id.cb_02);
            recycle02 = itemView.findViewById(R.id.recycle02);

        }
    }
}
