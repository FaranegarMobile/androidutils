package com.faranegar.utils.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.faranegar.utils.FaranegarUtils;

/**
 * Created by fps on 2/13/2017.
 */

public class LightTextView extends AppCompatTextView {

    public LightTextView(Context context) {
        this(context, null);
    }

    public LightTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyFont (context, whatStyle ( attrs ));
    }

    public void applyFont(Context context) {
        setTypeface( FaranegarUtils.getFont (context));
    }

    public void applyFont(Context context, int style){
        switch (style){
            case 0:
                setTypeface(FaranegarUtils.getFont (context));
                break;
            case 1:
                setTypeface(FaranegarUtils.getBoldFont (context));
                break;
            case 2:
                setTypeface(FaranegarUtils.getFontLight (context));
                break;
            case 3:
                setTypeface(FaranegarUtils.getFontAwesome (context));
                break;
        }
    }

    public int whatStyle(AttributeSet attrs)
    {
        if (attrs != null)
        {
            try {
                return  attrs.getAttributeIntValue(
                        "http://schemas.android.com/apk/res/android",
                        "textStyle",
                        Typeface.NORMAL);
            }
            catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

}
