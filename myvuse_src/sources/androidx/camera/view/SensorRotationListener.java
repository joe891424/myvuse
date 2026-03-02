package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class SensorRotationListener extends OrientationEventListener {
    public static final int INVALID_SURFACE_ROTATION = -1;
    private int mRotation;

    public abstract void onRotationChanged(int rotation);

    public SensorRotationListener(Context context) {
        super(context);
        this.mRotation = -1;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int orientation) {
        if (orientation == -1) {
            return;
        }
        int i = (orientation >= 315 || orientation < 45) ? 0 : orientation >= 225 ? 1 : orientation >= 135 ? 2 : 3;
        if (this.mRotation != i) {
            this.mRotation = i;
            onRotationChanged(i);
        }
    }
}
