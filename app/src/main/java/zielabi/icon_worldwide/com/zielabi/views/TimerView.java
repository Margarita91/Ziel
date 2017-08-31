package zielabi.icon_worldwide.com.zielabi.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import zielabi.icon_worldwide.com.zielabi.R;


/**

 */
public class TimerView extends View {

    private static final int ARC_START_ANGLE = 270; // 12 o'clock
    private static final float THICKNESS_SCALE = 0.020f;
    private static final float THICKNESS_SCALE_MAIN = 0.040f;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private RectF mCircleOuterBounds;
    private RectF mCircleInnerBounds;
    private Paint mCirclePaint;
    private Paint mEraserPaint;
    private Boolean mIsMain = false;
    private float mCircleSweepAngle;

    //private ValueAnimator mTimerAnimator;

    public TimerView(Context context) {
        this(context, null);
    }

    public TimerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int circleColor = R.color.prime_blue;

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TimerView);
            if (ta != null) {
                circleColor = ta.getColor(R.styleable.TimerView_circleColor, circleColor);
                ta.recycle();
            }
        }

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(circleColor);

        mEraserPaint = new Paint();
        mEraserPaint.setAntiAlias(true);
        mEraserPaint.setColor(Color.TRANSPARENT);
        mEraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // Trick to make the view square
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w != oldw || h != oldh) {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mBitmap.eraseColor(Color.TRANSPARENT);
            mCanvas = new Canvas(mBitmap);
        }

        super.onSizeChanged(w, h, oldw, oldh);
        updateBounds();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);

        if (mCircleSweepAngle > 0f) {
            mCanvas.drawArc(mCircleOuterBounds, ARC_START_ANGLE, mCircleSweepAngle, true, mCirclePaint);
            mCanvas.drawOval(mCircleInnerBounds, mEraserPaint);
        }

        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void start(int secs) {
        stop();


        // TODO: 2/4/16 mi dzev pti nkarvi
//        mTimerAnimator = ValueAnimator.ofFloat(0f, 1f);
//        mTimerAnimator.setDuration(TimeUnit.SECONDS.toMillis(secs));
//        mTimerAnimator.setInterpolator(new LinearInterpolator());
//        mTimerAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                drawProgress((float) animation.getAnimatedValue());
//
//            }
//        });
//        mTimerAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void stop() {
        // TODO: 2/4/16 mi dzev stop pti arvi
//        if (mTimerAnimator != null && mTimerAnimator.isRunning()) {
//            mTimerAnimator.cancel();
//            mTimerAnimator = null;
//
//            drawProgress(0f);
//        }
    }

    public void drawProgress(float progress) {
        mCircleSweepAngle = 360 * progress;

        invalidate();
    }

    public void drawProgressMinute(int minute, boolean b) {

        mCircleSweepAngle = minute * 6f;//360 * progress;
        mIsMain = b;
        invalidate();
    }

    private void updateBounds() {
        float thickness = getWidth() * THICKNESS_SCALE;

        if (mIsMain) {
            thickness = getWidth() * THICKNESS_SCALE_MAIN;
        }
        mCircleOuterBounds = new RectF(0, 0, getWidth(), getHeight());
        mCircleInnerBounds = new RectF(
                mCircleOuterBounds.left + thickness,
                mCircleOuterBounds.top + thickness,
                mCircleOuterBounds.right - thickness,
                mCircleOuterBounds.bottom - thickness);

        invalidate();
    }
}
