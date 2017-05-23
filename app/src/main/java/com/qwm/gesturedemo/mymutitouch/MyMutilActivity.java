package com.qwm.gesturedemo.mymutitouch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qwm.gesturedemo.BaseActivity;
import com.qwm.gesturedemo.MyGridAdapter;
import com.qwm.gesturedemo.R;

import java.util.ArrayList;

public class MyMutilActivity extends BaseActivity {

    private GridView contentGv;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mutil);
        initGridView();
    }

    public void initGridView() {
        contentGv = (GridView) findViewById(R.id.content_gv);
        itemList = new ArrayList<>();
        itemList.add("多点基本测试");
        contentGv.setAdapter(new MyGridAdapter(this, itemList));
        contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = itemList.get(position);
                if ("多点基本测试".equals(itemStr)) {
                    startActivity(itemStr, MyMutilBaseTestActivity.class);
                }
            }
        });

    }
}
