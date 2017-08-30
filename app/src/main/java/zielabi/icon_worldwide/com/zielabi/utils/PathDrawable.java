package zielabi.icon_worldwide.com.zielabi.utils;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by margarita on 30/08/2017.
 */

public class PathDrawable extends Drawable implements ValueAnimator.AnimatorUpdateListener {
    private Path mPath;
    private Paint mPaint;
    private ValueAnimator mAnimator;

    public PathDrawable() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(0xffffffff);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void startAnimating() {
        Rect b = getBounds();
        mAnimator = ValueAnimator.ofInt(-b.bottom, b.bottom);
        mAnimator.setDuration(1000);
        mAnimator.addUpdateListener(this);
        mAnimator.start();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animator) {
        mPath.reset();
        Rect b = getBounds();
        mPath.moveTo(b.left, b.bottom);
        mPath.quadTo((b.right-b.left)/2, (Integer) animator.getAnimatedValue(), b.right, b.bottom);
        invalidateSelf();
    }
}