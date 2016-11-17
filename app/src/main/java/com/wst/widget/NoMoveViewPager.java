package com.wst.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ViewPager是否可以滑动
 * Created by Administrator on 2016/9/6.
 */
public class NoMoveViewPager extends ViewPager{
    private boolean mNoFocus = true;  //if true, keep View don't move
    public NoMoveViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public NoMoveViewPager(Context context){
        this(context,null);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mNoFocus) {
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }

    public void setNoFocus(boolean b){
        mNoFocus = b;
    }
}
