package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.news;
import com.example.day18rikao03.R;
import com.example.widge.togglebutton;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo on 2018/8/25.
 */

public class myadapter1 extends RecyclerView.Adapter<myadapter1.oneholder> {

    private  Context context;
    private  List<news.DataBean.ListBean> list;

    public myadapter1(Context context, List<news.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public oneholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include2, null);
        oneholder oneholder = new oneholder(view);
        return oneholder;
    }

    @Override
    public void onBindViewHolder(oneholder holder, int position) {
        //设置属性
        holder.title2.setText("价格是"+list.get(position).getPrice());
        String images = list.get(position).getImages();
        if (images!=null&&images.contains("|")){
            String[] strings = images.split("\\|");
            for (int i = 0; i <strings.length ; i++) {
                Picasso.get().load(strings[i]).into(holder.img);
            }
        }else {
            Picasso.get().load(images).into(holder.img);
        }
        //设置选中状态
        holder.cb_03.setSelected(list.get(position).isChecked());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建视图
    class  oneholder extends  RecyclerView.ViewHolder{

        private CheckBox cb_03;
        private TextView title2;
        private ImageView img;

        public oneholder(View itemView) {
            super(itemView);
            //初始化
            img = itemView.findViewById(R.id.img);
            title2 = itemView.findViewById(R.id.title2);
            cb_03 = itemView.findViewById(R.id.cb_03);

        }
    }

}
