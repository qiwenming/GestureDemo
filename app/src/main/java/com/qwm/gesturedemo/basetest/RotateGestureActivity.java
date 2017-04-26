package com.qwm.gesturedemo.basetest;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.qwm.gesturedemo.R;

import multitouch.RotateGestureDetector;

/**
 * <b>Project:</b> gesturedemo<br>
 * <b>Create Date:</b> 2017/4/26<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class RotateGestureActivity extends AppCompatActivity {

    private View mView;
    private RotateGestureDetector mRotateGestureDetector;
    private float mRotationDegrees = 0.f;
    private static final String TAG = "RotateGestureActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_gesture);
        mView = findViewById(R.id.rotate_view);
        mRotateGestureDetector = new RotateGestureDetector(this,mSimpleOnRotateGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mRotateGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private RotateGestureDetector.SimpleOnRotateGestureListener mSimpleOnRotateGestureListener = new RotateGestureDetector.SimpleOnRotateGestureListener(){

        @Override
        public boolean onRotate(RotateGestureDetector detector) {
            mRotationDegrees = -detector.getRotationDegreesDelta()+mRotationDegrees;
            mRotationDegrees = mRotationDegrees % 360;
            mView.setRotation(mRotationDegrees);
            Log.i(TAG, "onRotate: "+detector.getRotationDegreesDelta()+"----"+mRotationDegrees);
            return true;
        }
    };
}
