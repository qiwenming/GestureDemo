package com.qwm.gesturedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.qwm.gesturedemo.basetest.BaseTestActivity;
import com.qwm.gesturedemo.basetest.DoubleTapActivity;
import com.qwm.gesturedemo.basetest.DragTestActivity;
import com.qwm.gesturedemo.thridlib.MoveGestureActivity;
import com.qwm.gesturedemo.thridlib.RotateGestureActivity;
import com.qwm.gesturedemo.basetest.ScaleGestureActivity;
import com.qwm.gesturedemo.thridlib.ShoveGestureActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private GridView contentGv;
    private ArrayList<String> itemList;
    private static final String TAG = "MainActivity";
    public static String NOTAG = "____QWM_____";

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
        itemList.add("双击测试");
        itemList.add("拖拽测试");
        itemList.add("缩放测试");
        //添加换行
        listAddNullTag();

        itemList.add("旋转测试(第三方库)");
        itemList.add("拖拽测试(第三方库)");
        itemList.add("shove(第三方库)");

        //添加换行
        listAddNullTag();

        contentGv.setAdapter(new MyGridAdapter(this, itemList));
        contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = itemList.get(position);
                if ("手势基本测试".equals(itemStr)) {
                    startActivity(itemStr, BaseTestActivity.class);
                }else if ("双击测试".equals(itemStr)) {
                    startActivity(itemStr, DoubleTapActivity.class);
                }else if ("拖拽测试".equals(itemStr)) {
                    startActivity(itemStr, DragTestActivity.class);
                }else if ("缩放测试".equals(itemStr)) {
                    startActivity(itemStr, ScaleGestureActivity.class);
                }else if ("旋转测试(第三方库)".equals(itemStr)) {
                    startActivity(itemStr, RotateGestureActivity.class);
                }else if ("拖拽测试(第三方库)".equals(itemStr)) {
                    startActivity(itemStr, MoveGestureActivity.class);
                }else if ("shove(第三方库)".equals(itemStr)) {
                    startActivity(itemStr, ShoveGestureActivity.class);
                }
            }
        });

    }

    public void listAddNullTag(){
        int numColumns = contentGv.getNumColumns();
        if(itemList.size()%numColumns!=0){//没有填充满的时候，添加空的标记
            int count = ( (itemList.size()/numColumns +1) * numColumns ) - itemList.size();
            for (int i = 0; i < count; i++) {
                itemList.add(NOTAG);
            }
        }
    }
}
