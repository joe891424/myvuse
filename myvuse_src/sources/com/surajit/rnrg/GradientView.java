package com.surajit.rnrg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.core.internal.view.SupportMenu;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;

/* JADX INFO: loaded from: classes6.dex */
public class GradientView extends View {
    private RectF bounds;
    private float centerX;
    private float centerY;
    private int[] colors;
    private Paint paint;
    private float radius;
    float[] stops;

    public GradientView(Context context) {
        super(context);
        init();
    }

    public GradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.bounds = new RectF();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.centerX = -1.0f;
        this.centerY = -1.0f;
        this.radius = -1.0f;
        this.colors = new int[]{SupportMenu.CATEGORY_MASK, -16776961};
    }

    private void populateColors(int i) {
        this.colors = new int[]{i, ColorUtils.setAlphaComponent(i, 167), ColorUtils.setAlphaComponent(i, 96), ColorUtils.setAlphaComponent(i, 68), ColorUtils.setAlphaComponent(i, 0)};
    }

    private void populateDefaultCenterValue(float f, float f2) {
        if (this.centerX < 0.0f) {
            this.centerX = f / 2.0f;
        }
        if (this.centerY < 0.0f) {
            this.centerY = f2 / 2.0f;
        }
        if (this.radius <= 0.0f) {
            this.radius = Math.min(f, f2) / 2.0f;
        }
    }

    public void setColors(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return;
        }
        if (readableArray.size() == 1) {
            populateColors(readableArray.getInt(0));
        } else {
            int size = readableArray.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = readableArray.getInt(i);
            }
            this.colors = iArr;
        }
        drawGradient();
    }

    public void setCenter(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            return;
        }
        this.centerX = PixelUtil.toPixelFromDIP(readableArray.getDouble(0));
        this.centerY = PixelUtil.toPixelFromDIP(readableArray.getDouble(1));
        drawGradient();
    }

    public void setRadius(float f) {
        if (f < 1.0f) {
            return;
        }
        this.radius = PixelUtil.toPixelFromDIP(f);
        drawGradient();
    }

    private void drawGradient() {
        int[] iArr;
        if (this.centerX < 0.0f || this.centerY < 0.0f || this.radius <= 0.0f || (iArr = this.colors) == null || iArr.length <= 0) {
            return;
        }
        float[] fArr = this.stops;
        if (fArr != null && fArr.length != iArr.length) {
            this.stops = null;
        }
        this.paint.setShader(new RadialGradient(this.centerX, this.centerY, this.radius, this.colors, this.stops, Shader.TileMode.CLAMP));
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        float f2 = i2;
        this.bounds.set(0.0f, 0.0f, f, f2);
        populateDefaultCenterValue(f, f2);
        drawGradient();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.bounds, this.paint);
    }

    public void setStops(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return;
        }
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.stops = fArr;
        drawGradient();
    }
}
