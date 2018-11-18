package com.faranegar.utils.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import static com.faranegar.utils.FaranegarUtils.getFont;


/**
 * Created by fps on 5/10/2017.
 */

public class CustomTextView extends AppCompatTextView {

    Typeface typeface;

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        typeface = getFont(context);
        setTypeface(typeface);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomTextView(Context context) {
        this(context,null);

    }
}
