package com.demo.ratioimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by tonglei on 16/5/25.
 */
public class RatioImageView extends ImageView {

    // 默认的16：9
    private float ratio = 16 / 9;

    public RatioImageView(Context context) {
        super(context);
        init(context, null);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
            ratio = array.getFloat(R.styleable.RatioImageView_ratio, 16.0f / 9f);
            array.recycle();
        } else {
            ratio = 16.0f / 9f;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int heightSize = (int) (widthSize / ratio);
        setMeasuredDimension(widthSize, heightSize);
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
        postInvalidate();
    }

    public float getRatio() {
        return this.ratio;
    }
}

