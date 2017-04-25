package com.qwm.gesturedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.qwm.gesturedemo.basetest.BaseTestActivity;
import com.qwm.gesturedemo.basetest.DragTestActivity;
import com.qwm.gesturedemo.basetest.ScaleGestureActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private GridView contentGv;
    private ArrayList<String> itemList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGridView();
        Log.i(TAG, "onCreate: "+getWindowManager().getDefaultDisplay().getWidth());
    }

    public void initGridView() {
        contentGv = (GridView) findViewById(R.id.content_gv);
        itemList = new ArrayList<>();
        itemList.add("手势基本测试");
        itemList.add("拖拽测试");
        itemList.add("缩放测试");
        contentGv.setAdapter(new MyGridAdapter(this, itemList));
        contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = itemList.get(position);
                if ("手势基本测试".equals(itemStr)) {
                    startActivity(itemStr, BaseTestActivity.class);
                }else if ("拖拽测试".equals(itemStr)) {
                    startActivity(itemStr, DragTestActivity.class);
                }else if ("缩放测试".equals(itemStr)) {
                    startActivity(itemStr, ScaleGestureActivity.class);
                }
            }
        });

    }
}
