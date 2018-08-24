package com.example.widge;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day18rikao03.R;

/**
 * Created by lenovo on 2018/8/25.
 */

public class togglebutton extends LinearLayout implements View.OnClickListener {

    private Button jia;
    private Button jian;
    private TextView number;

    public togglebutton(Context context) {
        super(context);
    }

    public togglebutton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    private void initview(Context context) {
        //加载资源及初始化
        LayoutInflater.from(context).inflate(R.layout.include3,this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        number = findViewById(R.id.number);
        //实现点击方法
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String s = number.getText().toString();
        int i = Integer.parseInt(s);
        switch (view.getId()){
            case R.id.jia:
                i+=1;
                number.setText(String.valueOf(i));
                break;
            case R.id.jian:
                if (i<=1){
                    //吐司
                    Toast.makeText(getContext(),"数量不能小于1",Toast.LENGTH_LONG).show();
                }
                i-=1;
                number.setText(String.valueOf(i));
                break;
        }
    }
}
