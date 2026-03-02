package com.shazam.android.widget.text.reflow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes6.dex */
class SwitchDrawable extends Drawable {
    private Bitmap currentBitmap;
    private Rect currentBitmapSrcBounds;
    private final Bitmap endBitmap;
    private final Rect endBitmapSrcBounds;
    private final double[] endColor;
    private int height;
    private final double[] startColor;
    private final float switchThreshold;
    private PointF topLeft;
    private int width;
    static final Property<SwitchDrawable, PointF> TOP_LEFT = new Property<SwitchDrawable, PointF>(PointF.class, "topLeft") { // from class: com.shazam.android.widget.text.reflow.SwitchDrawable.1
        @Override // android.util.Property
        public void set(SwitchDrawable switchDrawable, PointF pointF) {
            switchDrawable.setTopLeft(pointF);
        }

        @Override // android.util.Property
        public PointF get(SwitchDrawable switchDrawable) {
            return switchDrawable.getTopLeft();
        }
    };
    static final Property<SwitchDrawable, Integer> WIDTH = new Property<SwitchDrawable, Integer>(Integer.class, "width") { // from class: com.shazam.android.widget.text.reflow.SwitchDrawable.2
        @Override // android.util.Property
        public void set(SwitchDrawable switchDrawable, Integer num) {
            switchDrawable.setWidth(num.intValue());
        }

        @Override // android.util.Property
        public Integer get(SwitchDrawable switchDrawable) {
            return Integer.valueOf(switchDrawable.getWidth());
        }
    };
    static final Property<SwitchDrawable, Integer> HEIGHT = new Property<SwitchDrawable, Integer>(Integer.class, "height") { // from class: com.shazam.android.widget.text.reflow.SwitchDrawable.3
        @Override // android.util.Property
        public void set(SwitchDrawable switchDrawable, Integer num) {
            switchDrawable.setHeight(num.intValue());
        }

        @Override // android.util.Property
        public Integer get(SwitchDrawable switchDrawable) {
            return Integer.valueOf(switchDrawable.getHeight());
        }
    };
    static final Property<SwitchDrawable, Integer> ALPHA = new Property<SwitchDrawable, Integer>(Integer.class, "alpha") { // from class: com.shazam.android.widget.text.reflow.SwitchDrawable.4
        @Override // android.util.Property
        public void set(SwitchDrawable switchDrawable, Integer num) {
            switchDrawable.setAlpha(num.intValue());
        }

        @Override // android.util.Property
        public Integer get(SwitchDrawable switchDrawable) {
            return Integer.valueOf(DrawableCompat.getAlpha(switchDrawable));
        }
    };
    static final Property<SwitchDrawable, Float> PROGRESS = new Property<SwitchDrawable, Float>(Float.class, "progress") { // from class: com.shazam.android.widget.text.reflow.SwitchDrawable.5
        @Override // android.util.Property
        public void set(SwitchDrawable switchDrawable, Float f) {
            switchDrawable.setProgress(f.floatValue());
        }

        @Override // android.util.Property
        public Float get(SwitchDrawable switchDrawable) {
            return Float.valueOf(0.0f);
        }
    };
    private boolean hasSwitched = false;
    private final double[] color = new double[3];
    private final Paint paint = new Paint(6);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    SwitchDrawable(Bitmap bitmap, Rect rect, float f, Bitmap bitmap2, Rect rect2, float f2, int i, int i2) {
        this.currentBitmap = bitmap;
        this.currentBitmapSrcBounds = rect;
        this.endBitmap = bitmap2;
        this.endBitmapSrcBounds = rect2;
        this.startColor = ColorUtils.colorToLAB(i);
        this.endColor = ColorUtils.colorToLAB(i2);
        this.switchThreshold = f / (f2 + f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.currentBitmap, this.currentBitmapSrcBounds, getBounds(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.paint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.paint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    void setProgress(float f) {
        setColor(f);
        if (this.hasSwitched || f < this.switchThreshold) {
            return;
        }
        this.currentBitmap = this.endBitmap;
        this.currentBitmapSrcBounds = this.endBitmapSrcBounds;
        this.hasSwitched = true;
    }

    public void setColor(float f) {
        ColorUtils.blendLab(this.startColor, this.endColor, f, this.color);
        this.paint.setColorFilter(new PorterDuffColorFilter(ColorUtils.labToColor(this.color), PorterDuff.Mode.SRC_IN));
    }

    PointF getTopLeft() {
        return this.topLeft;
    }

    void setTopLeft(PointF pointF) {
        this.topLeft = pointF;
        updateBounds();
    }

    int getWidth() {
        return this.width;
    }

    void setWidth(int i) {
        this.width = i;
        updateBounds();
    }

    int getHeight() {
        return this.height;
    }

    void setHeight(int i) {
        this.height = i;
        updateBounds();
    }

    private void updateBounds() {
        int iRound = Math.round(this.topLeft.x);
        int iRound2 = Math.round(this.topLeft.y);
        setBounds(iRound, iRound2, this.width + iRound, this.height + iRound2);
    }
}
