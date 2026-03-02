package com.yoti.mobile.android.facecapture.view.capture;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public class MaskableFrameLayout extends FrameLayout {
    private static final int MODE_ADD = 0;
    private static final int MODE_CLEAR = 1;
    private static final int MODE_DARKEN = 2;
    private static final int MODE_DST = 3;
    private static final int MODE_DST_ATOP = 4;
    private static final int MODE_DST_IN = 5;
    private static final int MODE_DST_OUT = 6;
    private static final int MODE_DST_OVER = 7;
    private static final int MODE_LIGHTEN = 8;
    private static final int MODE_MULTIPLY = 9;
    private static final int MODE_OVERLAY = 10;
    private static final int MODE_SCREEN = 11;
    private static final int MODE_SRC = 12;
    private static final int MODE_SRC_ATOP = 13;
    private static final int MODE_SRC_IN = 14;
    private static final int MODE_SRC_OUT = 15;
    private static final int MODE_SRC_OVER = 16;
    private static final int MODE_XOR = 17;
    private Drawable mDrawableMask;
    private Bitmap mFinalMask;
    private Handler mHandler;
    private ColorFilter mMaskColorFilter;
    private Paint mPaint;
    private PorterDuffXfermode mPorterDuffXferMode;

    public MaskableFrameLayout(Context context) {
        super(context);
        this.mDrawableMask = null;
        this.mFinalMask = null;
        this.mPaint = null;
        this.mMaskColorFilter = null;
        this.mPorterDuffXferMode = null;
    }

    private void construct(Context context, AttributeSet attributeSet) {
        this.mHandler = new Handler();
        setDrawingCacheEnabled(true);
        setLayerType(2, null);
        this.mPaint = createPaint(false);
        Resources.Theme theme = context.getTheme();
        if (theme != null) {
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C4832R.styleable.YdsMaskableLayout, 0, 0);
            try {
                initMask(loadMask(typedArrayObtainStyledAttributes));
                this.mPorterDuffXferMode = getModeFromInteger(typedArrayObtainStyledAttributes.getInteger(C4832R.styleable.YdsMaskableLayout_porterduffxfermode, 0));
                initMask(this.mDrawableMask);
                if (typedArrayObtainStyledAttributes.getBoolean(C4832R.styleable.YdsMaskableLayout_anti_aliasing, false)) {
                    this.mPaint = createPaint(true);
                }
            } finally {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
        registerMeasure();
    }

    private Paint createPaint(boolean z) {
        Paint paint = new Paint(1);
        paint.setAntiAlias(z);
        paint.setXfermode(this.mPorterDuffXferMode);
        return paint;
    }

    private PorterDuffXfermode getModeFromInteger(int i) {
        PorterDuff.Mode mode;
        switch (i) {
            case 0:
                mode = PorterDuff.Mode.ADD;
                break;
            case 1:
                mode = PorterDuff.Mode.CLEAR;
                break;
            case 2:
                mode = PorterDuff.Mode.DARKEN;
                break;
            case 3:
                mode = PorterDuff.Mode.DST;
                break;
            case 4:
                mode = PorterDuff.Mode.DST_ATOP;
                break;
            case 5:
                mode = PorterDuff.Mode.DST_IN;
                break;
            case 6:
                mode = PorterDuff.Mode.DST_OUT;
                break;
            case 7:
                mode = PorterDuff.Mode.DST_OVER;
                break;
            case 8:
                mode = PorterDuff.Mode.LIGHTEN;
                break;
            case 9:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case 10:
                mode = PorterDuff.Mode.OVERLAY;
                break;
            case 11:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case 12:
                mode = PorterDuff.Mode.SRC;
                break;
            case 13:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case 14:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case 15:
                mode = PorterDuff.Mode.SRC_OUT;
                break;
            case 16:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
            case 17:
                mode = PorterDuff.Mode.XOR;
                break;
            default:
                mode = PorterDuff.Mode.DST_IN;
                break;
        }
        return new PorterDuffXfermode(mode);
    }

    private void initMask(Drawable drawable) {
        if (drawable != null) {
            this.mDrawableMask = drawable;
            if (drawable instanceof AnimationDrawable) {
                drawable.setCallback(this);
            }
        }
    }

    private Drawable loadMask(TypedArray typedArray) {
        return typedArray.getDrawable(C4832R.styleable.YdsMaskableLayout_mask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap makeBitmapMask(Drawable drawable) {
        if (drawable == null || getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.setColorFilter(this.mMaskColorFilter);
        drawable.draw(canvas);
        return ThumbnailUtils.extractThumbnail(bitmapCreateBitmap, getMeasuredWidth(), getMeasuredHeight());
    }

    private void registerMeasure() {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.yoti.mobile.android.facecapture.view.capture.MaskableFrameLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
                if (!viewTreeObserver2.isAlive()) {
                    viewTreeObserver2 = MaskableFrameLayout.this.getViewTreeObserver();
                }
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.removeOnGlobalLayoutListener(this);
                }
                MaskableFrameLayout maskableFrameLayout = MaskableFrameLayout.this;
                maskableFrameLayout.swapBitmapMask(maskableFrameLayout.makeBitmapMask(maskableFrameLayout.mDrawableMask));
            }
        });
    }

    private void setSize(int i, int i2) {
        Drawable drawable;
        if (i <= 0 || i2 <= 0 || (drawable = this.mDrawableMask) == null) {
            return;
        }
        swapBitmapMask(makeBitmapMask(drawable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swapBitmapMask(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmap2 = this.mFinalMask;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mFinalMask.recycle();
            }
            this.mFinalMask = bitmap;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint;
        super.dispatchDraw(canvas);
        if (this.mFinalMask == null || (paint = this.mPaint) == null) {
            return;
        }
        paint.setXfermode(this.mPorterDuffXferMode);
        canvas.drawBitmap(this.mFinalMask, 0.0f, 0.0f, this.mPaint);
        this.mPaint.setXfermode(null);
    }

    public Drawable getDrawableMask() {
        return this.mDrawableMask;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable != null) {
            initMask(drawable);
            swapBitmapMask(makeBitmapMask(drawable));
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setSize(i, i2);
    }

    public void removeColorFilter() {
        this.mMaskColorFilter = null;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == null || runnable == null) {
            return;
        }
        this.mHandler.postAtTime(runnable, j);
    }

    public void setColorFilterColor(int i) {
        this.mMaskColorFilter = new PorterDuffColorFilter(ContextCompat.getColor(getContext(), i), PorterDuff.Mode.SRC_IN);
    }

    public void setMask(int i) {
        Resources resources = getResources();
        if (resources != null) {
            setMask(resources.getDrawable(i));
        }
    }

    public void setPorterDuffXferMode(PorterDuff.Mode mode) {
        this.mPorterDuffXferMode = new PorterDuffXfermode(mode);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == null || runnable == null) {
            return;
        }
        this.mHandler.removeCallbacks(runnable);
    }

    public void setMask(Drawable drawable) {
        initMask(drawable);
        swapBitmapMask(makeBitmapMask(this.mDrawableMask));
        invalidate();
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawableMask = null;
        this.mFinalMask = null;
        this.mPaint = null;
        this.mMaskColorFilter = null;
        this.mPorterDuffXferMode = null;
        construct(context, attributeSet);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableMask = null;
        this.mFinalMask = null;
        this.mPaint = null;
        this.mMaskColorFilter = null;
        this.mPorterDuffXferMode = null;
        construct(context, attributeSet);
    }
}
