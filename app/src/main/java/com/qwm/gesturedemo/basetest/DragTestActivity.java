
package com.qwm.gesturedemo.basetest;

import android.graphics.Point;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.qwm.gesturedemo.BaseActivity;
import com.qwm.gesturedemo.R;
/**
 * <b>Project:</b> YuantaiApplication<br>
 * <b>Create Date:</b> 2017/4/26<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b>
 * 拖拽
 * <br>
 */
public class DragTestActivity extends BaseActivity {

    private View mView;
    private GestureDetectorCompat mGestureDetectorCompat;
    private static final String TAG = "DragTestActivity";

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
//        onMyDrag(event);
        return super.onTouchEvent(event);
    }

    private float mOffsetScX = 0;
    private float mOffsetScY = 0;
    private GestureDetector.SimpleOnGestureListener mSimpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            mView.setX(mView.getX()-distanceX);
//            mView.setY(mView.getY()-distanceY);
            mOffsetScX +=  -distanceX;
            mOffsetScY +=  -distanceY;
            mView.setTranslationX( mOffsetScX );
            mView.setTranslationY( mOffsetScY );
            return true;
        }
    };

    private float mLastX = 0;
    private float mLastY = 0;
    private float mOffsetX = 0;
    private float mOffsetY = 0;
    public void onMyDrag(MotionEvent event){
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                Log.i(TAG, "onMyDrag:ACTION_DOWN  "+event.getX()+"  ,  "+event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mOffsetX += event.getX()-mLastX;
                mOffsetY += event.getY()-mLastY;
                mLastX = event.getX();
                mLastY = event.getY();
                mView.setTranslationX( mOffsetX );
                mView.setTranslationY( mOffsetY );
                break;
        }
    }
}
