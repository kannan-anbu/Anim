package com.kannan.ornate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.R.attr.path;
import static com.kannan.ornate.AnimTextView.Mode.A;

/**
 * Created by kannan on 11/7/17.
 */

@SuppressLint("AppCompatCustomView")
public class AnimTextView extends TextView {

    public enum Mode {

        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J,
        K,
        L,
        M,
        N;

    }

    private Mode mode = A;
    private Rect maskRect;
    private Path maskPath;
    private float revealFactor;
    private int width = -1;
    private int height = -1;

    public AnimTextView(Context context) {
        super(context);
        init();
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        maskRect = new Rect();
        maskPath = new Path();
        revealFactor = 1.0f;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(maskPath);
//        canvas.drawText(getText().toString(),
//                getLeft(), getBaseline(), getPaint());
        super.onDraw(canvas);

    }


    private void updateMask() {
        switch (mode) {
            case A:
                maskPath.moveTo(0, 0);
                maskPath.lineTo(width * revealFactor, 0);
                maskPath.lineTo(width * revealFactor, height);
                maskPath.lineTo(0, height);
                maskPath.close();
                break;
            case B:
                maskPath.moveTo(width - (width * revealFactor), 0);
                maskPath.lineTo(width, 0);
                maskPath.lineTo(width, height);
                maskPath.lineTo(width - (width * revealFactor), height);
                maskPath.close();
                break;
            case C:
                maskPath.moveTo(0, 0);
                maskPath.lineTo(width, 0);
                maskPath.lineTo(width, height * revealFactor);
                maskPath.lineTo(0, height * revealFactor);
                maskPath.close();
                break;
            case D:
                maskPath.moveTo(0, height - (height * revealFactor));
                maskPath.lineTo(width, height - (height * revealFactor));
                maskPath.lineTo(width, height);
                maskPath.lineTo(0, height);
                maskPath.close();
                break;
            case E:
                maskPath.moveTo(0, 0);
                maskPath.lineTo(width * revealFactor * 2, 0);
                maskPath.lineTo(0, height * revealFactor * 2);
                maskPath.close();
                break;
            case F:
                maskPath.moveTo(width - (width * revealFactor * 2), 0);
                maskPath.lineTo(width, 0);
                maskPath.lineTo(width, height * revealFactor * 2);
                maskPath.close();
                break;
            case G:
                maskPath.moveTo(width, height - (height * revealFactor * 2));
                maskPath.lineTo(width, height);
                maskPath.lineTo(width - (width * revealFactor * 2), height);
                maskPath.close();
                break;
            case H:
                maskPath.moveTo(0, height - (height * revealFactor *2));
                maskPath.lineTo(width * revealFactor * 2, height);
                maskPath.lineTo(0, height);
                maskPath.close();
                break;
            case I:
                maskPath.moveTo((width / 2) - (width * revealFactor / 2), 0);
                maskPath.lineTo((width / 2) + (width * revealFactor / 2), 0);
                maskPath.lineTo((width / 2) + (width * revealFactor / 2), height);
                maskPath.lineTo((width / 2) - (width * revealFactor / 2), height);
                maskPath.close();
                break;
            case J:
                maskPath.moveTo(0, (height / 2) - (height * revealFactor / 2));
                maskPath.lineTo(width, (height / 2) - (height * revealFactor / 2));
                maskPath.lineTo(width, (height / 2) + (height * revealFactor / 2));
                maskPath.lineTo(0, (height / 2) + (height * revealFactor / 2));
                maskPath.close();
                break;
            case K:
                maskPath.moveTo(0, 0);
                maskPath.lineTo(width * revealFactor, 0);
                maskPath.lineTo(width, height - (height * revealFactor));
                maskPath.lineTo(width, height);
                maskPath.lineTo(width - (width * revealFactor), height);
                maskPath.lineTo(0, height * revealFactor);
                maskPath.close();
                break;
            case L:
                maskPath.moveTo(width - (width * revealFactor), 0);
                maskPath.lineTo(width, 0);
                maskPath.lineTo(width, height * revealFactor);
                maskPath.lineTo(width * revealFactor, height);
                maskPath.lineTo(0, height);
                maskPath.lineTo(0, height - (height * revealFactor));
                maskPath.close();
                break;
            case M:
                maskPath.moveTo((width / 2) - (width * revealFactor / 2), (height / 2) - (height * revealFactor / 2));
                maskPath.lineTo((width / 2) + (width * revealFactor / 2), (height / 2) - (height * revealFactor / 2));
                maskPath.lineTo((width / 2) + (width * revealFactor / 2), (height / 2) + (height * revealFactor / 2));
                maskPath.lineTo((width / 2) - (width * revealFactor / 2), (height / 2) + (height * revealFactor / 2));
                maskPath.close();
                break;

        }
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        invalidate();
    }

    public void setRevealFactor(float factor) {
        revealFactor = factor;
        updateMask();
        invalidate();
    }

    public float getRevealFactor() {
        return revealFactor;
    }
}