package com.microblink.view.surface;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.view.CameraAspectMode;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface ICameraView {
    public static final float PREVIEW_SCALE_NO_ZOOM = 1.0f;

    /* JADX INFO: compiled from: line */
    public interface CameraViewEventListener {
        void onCameraPinchEvent(float f);

        void onCameraTapEvent(float f, float f2);
    }

    Rect convertRectangleToActualRect(RectF rectF);

    void dispose();

    View getView();

    int getVisibleHeight();

    int getVisibleWidth();

    void installCallback(llllllllll llllllllllVar);

    void removeCallback();

    void setAspectMode(CameraAspectMode cameraAspectMode);

    void setCameraViewEventListener(CameraViewEventListener cameraViewEventListener);

    void setDeviceNaturalOrientationLandscape(boolean z);

    void setHostActivityOrientation(int i);

    void setPreviewSize(int i, int i2);

    void setPreviewZoomScale(float f);

    void setRotation(int i);
}
