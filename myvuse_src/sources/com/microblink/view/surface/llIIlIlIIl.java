package com.microblink.view.surface;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.IlIlllllII;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.surface.ICameraView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIIlIlIIl extends SurfaceView implements ICameraView {
    private float IIlIIIllIl;
    private int IlIllIlIIl;
    private int IlIllIlllI;
    private Handler IlIlllllII;
    private int IllIIIIllI;
    private int IllIIIllII;
    private GestureDetector IllIIlIIII;
    private ScaleGestureDetector lIIIIIlIlI;
    private IlIlllllII lIIIIIllll;
    private ICameraView.CameraViewEventListener lIlIIIIlIl;
    private int llIIIlllll;
    private CameraAspectMode llIIlIIlll;
    private int llIIlIlIIl;
    SurfaceHolder.Callback lllIIIlIlI;
    private int lllIlIlIIl;

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        IlIllIlIIl() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (llIIlIlIIl.this.lIlIIIIlIl == null) {
                return false;
            }
            llIIlIlIIl.this.lIlIIIIlIl.onCameraPinchEvent(scaleGestureDetector.getScaleFactor());
            return true;
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        IllIIIllII() {
        }

        @Override // java.lang.Runnable
        public void run() {
            llIIlIlIIl.this.requestLayout();
        }
    }

    /* JADX INFO: renamed from: com.microblink.view.surface.llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
    /* JADX INFO: compiled from: line */
    class C5992llIIlIlIIl extends GestureDetector.SimpleOnGestureListener {
        C5992llIIlIlIIl() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            float[] fArr = {motionEvent.getX(), motionEvent.getY()};
            Log.m2713v(this, "Camera surface view touch event at location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (llIIlIlIIl.this.llIIlIIlll == CameraAspectMode.ASPECT_FILL) {
                fArr[0] = fArr[0] - llIIlIlIIl.this.lllIlIlIIl;
                fArr[1] = fArr[1] - llIIlIlIIl.this.IlIllIlllI;
            }
            Log.m2713v(this, "Camera surface view touch event at raw sensor location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            IIlIIlIllI.IlIllIlIIl(fArr, View.MeasureSpec.getSize(llIIlIlIIl.this.getMeasuredWidth()), View.MeasureSpec.getSize(llIIlIlIIl.this.getMeasuredHeight()));
            IIlIIlIllI.IlIllIlIIl(fArr, llIIlIlIIl.this.IllIIIIllI, 1.0f, 1.0f);
            Log.m2713v(this, "Camera surface view touch event at normalized location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (llIIlIlIIl.this.lIlIIIIlIl == null) {
                return false;
            }
            llIIlIlIIl.this.lIlIIIIlIl.onCameraTapEvent(fArr[0], fArr[1]);
            return true;
        }
    }

    public llIIlIlIIl(Context context) {
        super(context);
        this.llIIlIlIIl = 0;
        this.IlIllIlIIl = 0;
        this.IllIIIllII = 0;
        this.llIIIlllll = 0;
        this.IllIIIIllI = 1;
        this.llIIlIIlll = CameraAspectMode.ASPECT_FIT;
        this.IIlIIIllIl = 1.0f;
        this.IlIllIlllI = -1;
        this.lllIlIlIIl = -1;
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
        IIlIIlIllI.llIIlIlIIl(fArr, this.IllIIIIllI, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr2, this.IllIIIIllI, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr3, this.IllIIIIllI, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr4, this.IllIIIIllI, 1.0f, 1.0f);
        IIlIIlIllI.llIIlIlIIl(fArr, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr2, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr3, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        IIlIIlIllI.llIIlIlIIl(fArr4, View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        int iRound = Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0]))));
        int iRound2 = Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1]))));
        int iRound3 = Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0]))));
        int iRound4 = Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1]))));
        if (this.llIIlIIlll == CameraAspectMode.ASPECT_FILL) {
            int i = this.lllIlIlIIl;
            iRound += i;
            iRound3 += i;
            int i2 = this.IlIllIlllI;
            iRound2 += i2;
            iRound4 += i2;
        }
        return new Rect(iRound, iRound2, iRound3, iRound4);
    }

    @Override // com.microblink.view.surface.ICameraView
    public void dispose() {
        this.lIlIIIIlIl = null;
        this.lIIIIIllll = null;
        this.lllIIIlIlI = null;
        this.IllIIlIIII = null;
        this.lIIIIIlIlI = null;
    }

    @Override // com.microblink.view.surface.ICameraView
    public View getView() {
        return this;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleHeight() {
        return this.llIIIlllll;
    }

    @Override // com.microblink.view.surface.ICameraView
    public int getVisibleWidth() {
        return this.IllIIIllII;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void installCallback(llllllllll llllllllllVar) {
        this.lllIIIlIlI = llllllllllVar.IllIIIIllI().llIIlIlIIl();
        getHolder().addCallback(this.lllIIIlIlI);
        getHolder().setType(3);
        if (llllllllllVar instanceof IlIlllllII) {
            this.lIIIIIllll = (IlIlllllII) llllllllllVar;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.lllIlIlIIl = i;
        this.IlIllIlllI = i2;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.llIIlIlIIl;
        if (i4 == 0 || (i3 = this.IlIllIlIIl) == 0) {
            setMeasuredDimension(size, size2);
            this.IllIIIllII = size;
            this.llIIIlllll = size2;
            return;
        }
        if (IIlIIlIllI.llIIlIlIIl(getContext())) {
            i4 = this.IlIllIlIIl;
            i3 = this.llIIlIlIIl;
            Log.m2707d(this, "Activity is in portrait mode, preview size used for layouting is {}x{}", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if (this.llIIlIIlll != CameraAspectMode.ASPECT_FIT) {
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
            float f = this.IIlIIIllIl;
            setMeasuredDimension((int) (size * f), (int) (size2 * f));
            return;
        }
        Log.m2707d(this, "Measuring size in ASPECT_FIT mode", new Object[0]);
        int i7 = size * i3;
        int i8 = size2 * i4;
        if (i7 > i8) {
            Log.m2707d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            this.IllIIIllII = i8 / i3;
            this.llIIIlllll = size2;
        } else {
            Log.m2707d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            this.llIIIlllll = i7 / i4;
            this.IllIIIllII = size;
        }
        float f2 = this.IllIIIllII;
        float f3 = this.IIlIIIllIl;
        setMeasuredDimension((int) (f2 * f3), (int) (this.llIIIlllll * f3));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lIlIIIIlIl == null) {
            return false;
        }
        return this.IllIIlIIII.onTouchEvent(motionEvent) || this.lIIIIIlIlI.onTouchEvent(motionEvent);
    }

    @Override // com.microblink.view.surface.ICameraView
    public void removeCallback() {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.llIIlIIlll = cameraAspectMode;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
        this.lIlIIIIlIl = cameraViewEventListener;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setDeviceNaturalOrientationLandscape(boolean z) {
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setHostActivityOrientation(int i) {
        this.IllIIIIllI = i;
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewSize(int i, int i2) {
        this.IlIllIlIIl = i2;
        this.llIIlIlIIl = i;
        this.IlIlllllII.post(new IllIIIllII());
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setPreviewZoomScale(float f) {
        this.IIlIIIllIl = f;
        requestLayout();
    }

    @Override // com.microblink.view.surface.ICameraView
    public void setRotation(int i) {
        IlIlllllII ilIlllllII = this.lIIIIIllll;
        if (ilIlllllII != null) {
            ilIlllllII.IlIllIlIIl(i);
        }
    }

    private void llIIlIlIIl(Context context) {
        this.IlIlllllII = new Handler();
        this.IllIIlIIII = new GestureDetector(context, new C5992llIIlIlIIl());
        this.lIIIIIlIlI = new ScaleGestureDetector(context, new IlIllIlIIl());
    }
}
