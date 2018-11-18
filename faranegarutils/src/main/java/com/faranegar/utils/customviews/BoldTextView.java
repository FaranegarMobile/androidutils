package com.faranegar.utils.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by fps on 2/13/2017.
 */

public class BoldTextView extends AppCompatTextView {

    public BoldTextView(Context context) {
        this(context, null);
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/font_bold.ttf");
        this.setTypeface(typeface);
    }
}
