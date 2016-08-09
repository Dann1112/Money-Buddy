package com.manrique.daniel.moneybuddy.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class Icon extends ImageView {

    public Icon(Context context) {
        super(context);
    }

    public Icon(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Icon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);

    }
}