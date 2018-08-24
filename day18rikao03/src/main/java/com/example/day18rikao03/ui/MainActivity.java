package com.example.day18rikao03.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day18rikao03.R;
import com.fyales.tagcloud.library.TagBaseAdapter;
import com.fyales.tagcloud.library.TagCloudLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TagCloudLayout container;
    private ArrayList<String> mlist;
    private TagBaseAdapter mAdapter;
    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit_name);
        //初始化
        container = findViewById(R.id.container1);
        mlist = new ArrayList<>();
        mlist.add("哈哈");
        mlist.add("啦啦");
        mlist.add("嘻嘻");
        mAdapter = new TagBaseAdapter(this, mlist);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit_name.getText().toString();
                mlist.add(s);
                mAdapter.notifyDataSetChanged();
            }
        });
        container.setAdapter(mAdapter);
        container.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
            @Override
            public void itemClick(int position) {
                Toast.makeText(MainActivity.this,mlist.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, show.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
