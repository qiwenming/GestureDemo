package com.qwm.gesturedemo.thridlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.qwm.gesturedemo.R;

import multitouch.ShoveGestureDetector;

public class ShoveGestureActivity extends AppCompatActivity {

    private View mView;
    private static final String TAG = "ShoveGestureActivity";
    private ShoveGestureDetector mShoveGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shove_gesture);
        mView = findViewById(R.id.shove_view);
        mShoveGestureDetector = new ShoveGestureDetector(this,mSimpleOnShoveGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mShoveGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private ShoveGestureDetector.SimpleOnShoveGestureListener mSimpleOnShoveGestureListener = new ShoveGestureDetector.SimpleOnShoveGestureListener(){

        @Override
        public boolean onShoveBegin(ShoveGestureDetector detector) {
            Log.i(TAG, "onShoveBegin: "+detector.getShovePixelsDelta());
            return super.onShoveBegin(detector);
        }

        @Override
        public boolean onShove(ShoveGestureDetector detector) {
            Log.i(TAG, "onShove:  "+detector.getShovePixelsDelta());
            return super.onShove(detector);
        }

        @Override
        public void onShoveEnd(ShoveGestureDetector detector) {
            Log.i(TAG, "onShoveEnd: "+detector.getShovePixelsDelta());
            super.onShoveEnd(detector);
        }
    };
}
