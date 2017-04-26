
package com.qwm.gesturedemo.basetest;


import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.qwm.gesturedemo.BaseActivity;
import com.qwm.gesturedemo.R;
/**
 * <b>Project:</b> YuantaiApplication<br>
 * <b>Create Date:</b> 2017/4/26<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 *     缩放手势
 */
public class ScaleGestureActivity extends BaseActivity {

    private View mView;
    private ScaleGestureDetector mScaleGestureDetector;
    private static final String TAG = "ScaleGestureActivity";
    private float mScaleFactor = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_gesture);
        mView = findViewById(R.id.scale_view);
        mScaleGestureDetector = new ScaleGestureDetector(this,mScaleGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor  *= scaleGestureDetector.getScaleFactor();
            mView.setScaleX(mScaleFactor);
            mView.setScaleY(mScaleFactor);
            Log.i(TAG, "onScale: "+ scaleGestureDetector.getScaleFactor()+"----"+mScaleFactor);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

        }
    };
}
