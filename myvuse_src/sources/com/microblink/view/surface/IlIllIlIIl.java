package com.microblink.view.surface;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.lllIIlIIlI;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.surface.ICameraView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIllIlIIl extends TextureView implements ICameraView {
    private int IIlIIIllIl;
    private int IlIllIlIIl;
    private int IlIllIlllI;
    private GestureDetector IlIlllllII;
    private float IllIIIIllI;
    private int IllIIIllII;
    private boolean IllIIlIIII;
    private Handler lIIIIIlIlI;
    private ICameraView.CameraViewEventListener lIIIIIllll;
    private int lIlIIIIlIl;
    private CameraAspectMode llIIIlllll;
    private ScaleGestureDetector llIIlIIIll;
    private int llIIlIIlll;
    private int llIIlIlIIl;
    private int lllIIIlIlI;
    private boolean lllIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.view.surface.IlIllIlIIl$IlIllIlIIl, reason: collision with other inner class name */
    /* JADX INFO: compiled from: line */
    class C5991IlIllIlIIl extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        C5991IlIllIlIIl() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (IlIllIlIIl.this.lIIIIIllll == null) {
                return false;
            }
            IlIllIlIIl.this.lIIIIIllll.onCameraPinchEvent(scaleGestureDetector.getScaleFactor());
            return true;
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        IllIIIllII() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IlIllIlIIl.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Runnable {
        llIIIlllll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IlIllIlIIl.this.llIIlIlIIl();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl extends GestureDetector.SimpleOnGestureListener {
        llIIlIlIIl() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            float[] fArr = {motionEvent.getX(), motionEvent.getY()};
            Log.m2707d(this, "Camera surface view touch event at location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            IIlIIlIllI.IlIllIlIIl(fArr, View.MeasureSpec.getSize(IlIllIlIIl.this.getMeasuredWidth()), View.MeasureSpec.getSize(IlIllIlIIl.this.getMeasuredHeight()));
            IIlIIlIllI.IlIllIlIIl(fArr, IlIllIlIIl.this.IIlIIIllIl, 1.0f, 1.0f);
            Log.m2707d(this, "Camera surface view touch event at normalized location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (IlIllIlIIl.this.lIIIIIllll == null) {
                return false;
            }
            IlIllIlIIl.this.lIIIIIllll.onCameraTapEvent(fArr[0], fArr[1]);
            return true;
        }
    }

    public IlIllIlIIl(Context context) {
        super(context);
        this.llIIlIlIIl = 0;
        this.IlIllIlIIl = 0;
        this.IllIIIllII = 0;
        this.llIIIlllll = CameraAspectMode.ASPECT_FIT;
        this.IllIIIIllI = 1.0f;
        this.lIlIIIIlIl = 0;
        this.llIIlIIlll = 0;
        this.IIlIIIllIl = 1;
        this.lllIIIlIlI = -1;
        this.IlIllIlllI = -1;
        this.lllIlIlIIl = false;
        this.IllIIlIIII = false;
        llIIlIlIIl(context);
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
        IIlIIlIllI.llIIlIlIIl(fArr, this.IIlIIIllIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr2, this.IIlIIIllIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr3, this.IIlIIIllIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr4, this.IIlIIIllIl, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr2, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr3, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr4, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        int iRound = Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0]))));
        int iRound2 = Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1]))));
        int iRound3 = Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0]))));
        int iRound4 = Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1]))));
        if (this.llIIIlllll == CameraAspectMode.ASPECT_FILL) {
            int i = this.IlIllIlllI;
            iRound += i;
            iRound3 += i;
            int i2 = this.lllIIIlIlI;
            iRound2 += i2;
            iRound4 += i2;
        }
        return new Rect(iRound, iRound2, iRound3, iRound4);
    }

    @Override // com.microblink.view.surface.ICameraView
    public void dispose() {
        this.lIIIIIllll = null;
    }

    @Override // com.microblink.view.surface.ICameraView
    public View getView() {
        return this;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleHeight() {
        return this.llIIlIIlll;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleWidth() {
        return this.lIlIIIIlIl;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void installCallback(llllllllll llllllllllVar) {
        setSurfaceTextureListener(llllllllllVar.IllIIIIllI().IlIllIlIIl());
        this.lllIlIlIIl = llllllllllVar instanceof lllIIlIIlI;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            throw new RuntimeException("Camera texture view works only on hardware accelerated windows!");
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.IlIllIlllI = i;
        this.lllIIIlIlI = i2;
        llIIlIlIIl();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.IlIllIlIIl;
        if (i4 == 0 || (i3 = this.IllIIIllII) == 0) {
            setMeasuredDimension(size, size2);
            this.lIlIIIIlIl = size;
            this.llIIlIIlll = size2;
            return;
        }
        if (IIlIIlIllI.llIIlIlIIl(getContext())) {
            i4 = this.IllIIIllII;
            i3 = this.IlIllIlIIl;
            Log.m2707d(this, "Activity is in portrait mode, preview size used for layouting is {}x{}", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if (this.llIIIlllll != CameraAspectMode.ASPECT_FIT) {
            Log.m2707d(this, "Measuring size in ASPECT_FILL mode", new Object[0]);
            int i5 = size * i3;
            int i6 = size2 * i4;
            if (i5 < i6) {
                Log.m2707d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                size = i6 / i3;
            } else {
                Log.m2707d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                size2 = i5 / i4;
            }
            Log.m2707d(this, "Measured dimension: {}x{}", Integer.valueOf(size), Integer.valueOf(size2));
            float f = this.IllIIIIllI;
            setMeasuredDimension((int) (size * f), (int) (size2 * f));
            return;
        }
        Log.m2707d(this, "Measuring size in ASPECT_FIT mode", new Object[0]);
        int i7 = size * i3;
        int i8 = size2 * i4;
        if (i7 > i8) {
            Log.m2707d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            this.lIlIIIIlIl = i8 / i3;
            this.llIIlIIlll = size2;
        } else {
            Log.m2707d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            this.llIIlIIlll = i7 / i4;
            this.lIlIIIIlIl = size;
        }
        Log.m2707d(this, "Measured dimension: {}x{}", Integer.valueOf(this.lIlIIIIlIl), Integer.valueOf(this.llIIlIIlll));
        float f2 = this.lIlIIIIlIl;
        float f3 = this.IllIIIIllI;
        setMeasuredDimension((int) (f2 * f3), (int) (this.llIIlIIlll * f3));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lIIIIIllll == null) {
            return false;
        }
        return this.IlIlllllII.onTouchEvent(motionEvent) || this.llIIlIIIll.onTouchEvent(motionEvent);
    }

    @Override // com.microblink.view.surface.ICameraView
    public void removeCallback() {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.llIIIlllll = cameraAspectMode;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
        this.lIIIIIllll = cameraViewEventListener;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setDeviceNaturalOrientationLandscape(boolean z) {
        this.IllIIlIIII = z;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setHostActivityOrientation(int i) {
        this.IIlIIIllIl = i;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewSize(int i, int i2) {
        this.IllIIIllII = i2;
        this.IlIllIlIIl = i;
        this.lIIIIIlIlI.post(new IllIIIllII());
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewZoomScale(float f) {
        this.IllIIIIllI = f;
        requestLayout();
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setRotation(int i) {
        this.llIIlIlIIl = i;
        if (this.IllIIIllII <= 0 || this.IlIllIlIIl <= 0) {
            return;
        }
        this.lIIIIIlIlI.post(new llIIIlllll());
    }

    private void llIIlIlIIl(Context context) {
        this.lIIIIIlIlI = new Handler();
        this.IlIlllllII = new GestureDetector(context, new llIIlIlIIl());
        this.llIIlIIIll = new ScaleGestureDetector(context, new C5991IlIllIlIIl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl() {
        int size = View.MeasureSpec.getSize(getMeasuredWidth());
        int size2 = View.MeasureSpec.getSize(getMeasuredHeight());
        if (this.IlIllIlIIl <= 0 || this.IllIIIllII <= 0) {
            return;
        }
        Matrix matrix = new Matrix();
        float f = size;
        float f2 = size2;
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        if (this.lllIlIlIIl && !this.IllIIlIIII) {
            if (!IIlIIlIllI.llIIlIlIIl(getContext())) {
                matrix.postScale(f2 / f, f / f2, fCenterX, fCenterY);
            }
            matrix.postRotate(this.llIIlIlIIl - 90, fCenterX, fCenterY);
        } else {
            if (IIlIIlIllI.llIIlIlIIl(getContext())) {
                matrix.postScale(f2 / f, f / f2, fCenterX, fCenterY);
            }
            matrix.postRotate(this.llIIlIlIIl, fCenterX, fCenterY);
        }
        setTransform(matrix);
    }
}
