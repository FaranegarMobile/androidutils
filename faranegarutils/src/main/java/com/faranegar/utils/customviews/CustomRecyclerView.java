package com.faranegar.utils.customviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomRecyclerView extends RecyclerView {
    private boolean animate;
    private Context context;
    private boolean mScrollable;

    class CustomScrollable implements Runnable {

        @Override
        public void run() {
            CustomRecyclerView.this.mScrollable = true;
        }
    }

    public CustomRecyclerView(Context context) {
        this(context, null);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mScrollable = false;
        this.animate = true;
        this.context = context;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return !this.mScrollable || super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (this.animate) {
            for (int i = 0; i < getChildCount(); i++) {
                animate(getChildAt(i), i);
                if (i == getChildCount() - 1) {
                    getHandler().postDelayed(new CustomScrollable(), (long) (i * 100));
                }
            }
            if (getChildCount() != 0) {
                this.animate = false;
            }
        }
    }

    private void animate(View view, int pos) {
        view.animate().cancel();
        view.setTranslationX(100.0f);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).translationX(0.0f).setDuration(300).setStartDelay((long) (pos * 100));
    }

    public void setAnimate(boolean animate){
        this.animate = animate;
    }
}
