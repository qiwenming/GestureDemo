package com.qwm.gesturedemo.basetest;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.qwm.gesturedemo.R;
/**
 * <b>Project:</b> gesturedemo<br>
 * <b>Create Date:</b> 2017/4/26<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b>
 * 双击手势
 * <br>
 */
public class DoubleTapActivity extends BaseTestActivity {

    private TextView mTv;
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_tap);
        mTv = (TextView)findViewById(R.id.doubletap_tv);
        mGestureDetector = new GestureDetectorCompat(this,mDoubleSimpGestureListener);
//        mGestureDetector = new GestureDetectorCompat(this,mOnGestureListener);
//        mGestureDetector.setOnDoubleTapListener(mOnDoubleTapListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private GestureDetector.OnDoubleTapListener mOnDoubleTapListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            logger("onSingleTapConfirmed:");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            logger("onDoubleTap:");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            logger("onDoubleTapEvent:"+MotionEvent.actionToString(e.getAction()));
            return false;
        }
    };

    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

    private GestureDetector.SimpleOnGestureListener mDoubleSimpGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            logger("onSingleTapConfirmed:");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            logger("onDoubleTap:");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            logger("onDoubleTapEvent:"+MotionEvent.actionToString(e.getAction()));
            return false;
        }
    };

    private void logger(String msg){
        String log = mTv.getText()+"\n"+msg;
        if(log.split(":").length>30){
            log = msg;
        }
        mTv.setText(log);
    }
}
