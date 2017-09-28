package zielabi.icon_worldwide.com.zielabi.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.ZielAbiApplication;

/**
 * Created by margarita on 27/09/2017.
 */

public class TextSeekBar extends View {

    private int padding = 3;
    private int mWidth = 0;
    private int mHeight = 0;
    private float rectWidth = 0F;
    private int totalIndex = 15;
    private int currentIndex = 0;

    private Paint normalPaint;
    private Paint selectPaint;
    private Paint textPaint;
    Context mContext;
    private OnSeekBarChangeListener onSeekBarChangeListener;

    public TextSeekBar(Context context) {
        this(context, null);
    }

    public TextSeekBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextSeekBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        mContext=context;
    }

    public void init(Context context) {
        normalPaint = new Paint();
        normalPaint.setColor(0xFFFFFFFF);
        normalPaint.setTextSize(40);
        normalPaint.setAntiAlias(true);
        normalPaint.setTextAlign(Paint.Align.CENTER);

        textPaint = new Paint();
        textPaint.setTextSize(40);
        textPaint.setColor(ContextCompat.getColor(ZielAbiApplication.getContext(), R.color.prime_blue));
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);

        selectPaint = new Paint();
        selectPaint.setColor(0xFFFD8900);
        selectPaint.setTextSize(40);
        selectPaint.setAntiAlias(true);
        selectPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = ZielAbiApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        rectWidth = (float) (mWidth) / ((float) totalIndex + 1);
        mHeight = (int) rectWidth * 2 - 50;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < totalIndex; i++) {
            int left = (int) (i * rectWidth) + padding;
            int top = padding;
            int right = (int) ((i + 1) * rectWidth) - padding;
            int bottom = mHeight - padding;
            Rect targetRect = new Rect(left, top, right, bottom);

            if (i < currentIndex) {
                canvas.drawRect(targetRect, selectPaint);
                Paint.FontMetricsInt fontMetrics = normalPaint.getFontMetricsInt();
                int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                canvas.drawText(String.valueOf(i + 1), targetRect.centerX(), baseline, normalPaint);

            } else {
                canvas.drawRect(targetRect, normalPaint);
                Paint.FontMetricsInt fontMetrics = selectPaint.getFontMetricsInt();
                int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                canvas.drawText(String.valueOf(i + 1), targetRect.centerX(), baseline, textPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                setCurrIndex(event);
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressStart(currentIndex + 1);
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                setCurrIndex(event);
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressMoving(currentIndex + 1);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                setCurrIndex(event);
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressChanged(currentIndex + 1);
                }
                break;
            }
        }
        return true;
    }

    public void clear(){
        currentIndex = 0;
        init(getContext());
        invalidate();
    }

    private void setCurrIndex(MotionEvent event) {
        int downX = validPositionX((int) event.getX());
        currentIndex = downX / (int) rectWidth;
        invalidate();
    }

    private int validPositionX(int mDownX) {
        if (mDownX < 0) {
            mDownX = 0;
        }
        if (mDownX > mWidth) {
            mDownX = mWidth;
        }
        return mDownX;
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.onSeekBarChangeListener = onSeekBarChangeListener;
    }

    public interface OnSeekBarChangeListener {
        void onProgressStart(int index);

        void onProgressMoving(int index);

        void onProgressChanged(int index);
    }
}
