package com.qwm.gesturedemo.basetest;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.qwm.gesturedemo.BaseActivity;
import com.qwm.gesturedemo.R;
/**
 * <b>Project:</b> gesturedemo<br>
 * <b>Create Date:</b> 2017/4/25<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b>
 *  基本手势测试
 * <br>
 */
public class BaseTestActivity extends BaseActivity {

    private static final String TAG = "BaseTestActivity";
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_test);
//        mGestureDetector = new GestureDetectorCompat(this,mOnGestureListener);
        mGestureDetector = new GestureDetectorCompat(this,mSimpleOnGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    
   private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
       @Override
       public boolean onDown(MotionEvent mCurrentDownEvent) {
           Log.i(TAG, "onDown: ");
           return true;
       }

       @Override
       public void onShowPress(MotionEvent mCurrentDownEvent) {
           Log.i(TAG, "onShowPress: ");
       }

       @Override
       public boolean onSingleTapUp(MotionEvent mCurrentDownEvent) {
           Log.i(TAG, "onSingleTapUp: ");
           return false;
       }

       @Override
       public boolean onScroll(MotionEvent mCurrentDownEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
           Log.i(TAG, "onScroll: "+velocityX+"----"+velocityY);
           return false;
       }

       @Override
       public void onLongPress(MotionEvent mCurrentDownEvent) {
           Log.i(TAG, "onLongPress: ");
       }

       @Override
       public boolean onFling(MotionEvent mCurrentDownEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
           Log.i(TAG, "onFling: "+velocityX+"----"+velocityY);
           if(velocityX > 10) {
               finish();
           }
           return true;
       }
   };

    private GestureDetector.SimpleOnGestureListener mSimpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onDown(MotionEvent e) {
            Log.i(TAG, "onDown: ----");
//            return super.onDown(e);
            return false;
        }
        @Override
        public boolean onFling(MotionEvent mCurrentDownEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
            Log.i(TAG, "onFling: "+velocityX+"----"+velocityY);
            if(velocityX > 10) {
                finish();
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i(TAG, "onDoubleTap: ---");
            return super.onDoubleTap(e);
        }
    };
}
