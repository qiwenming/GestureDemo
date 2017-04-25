
package com.qwm.gesturedemo.basetest;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.qwm.gesturedemo.BaseActivity;
import com.qwm.gesturedemo.R;

public class DragTestActivity extends BaseActivity {

    private View mView;
    private GestureDetectorCompat mGestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_test);
        mView = findViewById(R.id.drag_view);
        mGestureDetectorCompat = new GestureDetectorCompat(this,mSimpleOnGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private GestureDetector.SimpleOnGestureListener mSimpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            mView.setX(mView.getX()-distanceX);
            mView.setY(mView.getY()-distanceY);
            return true;
        }
    };
}
