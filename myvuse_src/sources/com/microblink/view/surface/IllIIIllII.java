package com.microblink.view.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.surface.ICameraView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIIIllII extends View implements ICameraView {
    private int IIlIIIllIl;
    private Paint IlIllIlIIl;
    private float IlIllIlllI;
    private int IllIIIIllI;
    private Paint IllIIIllII;
    private int lIIIIIllll;
    private int lIlIIIIlIl;
    private Paint llIIIlllll;
    private int llIIlIIlll;
    private int llIIlIlIIl;
    private CameraAspectMode lllIIIlIlI;

    public IllIIIllII(Context context, CameraAspectMode cameraAspectMode) {
        super(context);
        this.llIIlIlIIl = 1;
        this.IllIIIIllI = 1920;
        this.lIlIIIIlIl = 1080;
        this.IIlIIIllIl = 0;
        this.lIIIIIllll = 0;
        this.IlIllIlllI = 1.0f;
        llIIlIlIIl(context, cameraAspectMode);
    }

    private void llIIlIlIIl(Context context, CameraAspectMode cameraAspectMode) {
        this.llIIlIIlll = context.getResources().getConfiguration().orientation;
        this.lllIIIlIlI = cameraAspectMode;
        Paint paint = new Paint(1);
        this.IlIllIlIIl = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.IlIllIlIIl.setTextAlign(Paint.Align.LEFT);
        this.IlIllIlIIl.setTypeface(Typeface.DEFAULT_BOLD);
        this.IlIllIlIIl.setColor(SupportMenu.CATEGORY_MASK);
        setBackgroundColor(Color.argb(255, 128, 59, 100));
        Paint paint2 = new Paint(this.IlIllIlIIl);
        this.IllIIIllII = paint2;
        paint2.setColor(-1);
        Paint paint3 = new Paint(this.IlIllIlIIl);
        this.llIIIlllll = paint3;
        paint3.setTextSize(125.0f);
        this.llIIIlllll.setColor(-16776961);
    }

    @Override // com.microblink.view.surface.ICameraView
    public Rect convertRectangleToActualRect(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float[] fArr = {f, f2};
        float f3 = rectF.right;
        float[] fArr2 = {f3, f2};
        float f4 = rectF.bottom;
        float[] fArr3 = {f, f4};
        float[] fArr4 = {f3, f4};
        IIlIIlIllI.llIIlIlIIl(fArr, this.llIIlIlIIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr2, this.llIIlIlIIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr3, this.llIIlIlIIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr4, this.llIIlIlIIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr2, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr3, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr4, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        return new Rect(Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0])))), Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1])))), Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0])))), Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1])))));
    }

    @Override // com.microblink.view.surface.ICameraView
    public void dispose() {
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = null;
    }

    @Override // com.microblink.view.surface.ICameraView
    public View getView() {
        return this;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleHeight() {
        return this.lIIIIIllll;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleWidth() {
        return this.IIlIIIllIl;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void installCallback(llllllllll llllllllllVar) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.lllIIIlIlI == CameraAspectMode.ASPECT_FIT) {
            width = this.IIlIIIllIl;
            height = this.lIIIIIllll;
        }
        boolean z = true;
        int iRound = Math.round(width / 50.0f) + 1;
        int iRound2 = Math.round(height / 50.0f) + 1;
        float f = 0.0f;
        for (int i = 0; i < iRound2; i++) {
            int i2 = 0;
            float f2 = 0.0f;
            while (i2 < iRound) {
                float f3 = f2 + 50.0f;
                canvas.drawRect(f2, f, f3, f + 50.0f, z ? i2 % 2 == 0 ? this.IlIllIlIIl : this.IllIIIllII : i2 % 2 == 0 ? this.IllIIIllII : this.IlIllIlIIl);
                i2++;
                f2 = f3;
            }
            f += 50.0f;
            z = !z;
        }
        int width2 = getWidth();
        int height2 = getHeight();
        if (this.lllIIIlIlI == CameraAspectMode.ASPECT_FIT) {
            width2 = this.IIlIIIllIl;
            height2 = this.lIIIIIllll;
        }
        canvas.drawText("Camera", (width2 - this.llIIIlllll.measureText("Camera")) / 2.0f, (height2 / 2.0f) + 62.5f, this.llIIIlllll);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.IllIIIIllI;
        int i4 = this.lIlIIIIlIl;
        if (this.llIIlIIlll != 1) {
            i4 = i3;
            i3 = i4;
        }
        if (this.lllIIIlIlI != CameraAspectMode.ASPECT_FIT) {
            int i5 = size * i3;
            int i6 = size2 * i4;
            if (i5 < i6) {
                size = i6 / i3;
            } else {
                size2 = i5 / i4;
            }
            float f = this.IlIllIlllI;
            setMeasuredDimension((int) (size * f), (int) (size2 * f));
            return;
        }
        int i7 = size * i3;
        int i8 = size2 * i4;
        if (i7 > i8) {
            this.IIlIIIllIl = i8 / i3;
            this.lIIIIIllll = size2;
        } else {
            this.lIIIIIllll = i7 / i4;
            this.IIlIIIllIl = size;
        }
        float f2 = this.IIlIIIllIl;
        float f3 = this.IlIllIlllI;
        setMeasuredDimension((int) (f2 * f3), (int) (this.lIIIIIllll * f3));
    }

    @Override // com.microblink.view.surface.ICameraView
    public void removeCallback() {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.lllIIIlIlI = cameraAspectMode;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setDeviceNaturalOrientationLandscape(boolean z) {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setHostActivityOrientation(int i) {
        this.llIIlIlIIl = i;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewSize(int i, int i2) {
        this.IllIIIIllI = i;
        this.lIlIIIIlIl = i2;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewZoomScale(float f) {
        this.IlIllIlllI = f;
        requestLayout();
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setRotation(int i) {
    }
}
