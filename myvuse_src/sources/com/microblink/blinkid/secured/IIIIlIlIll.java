package com.microblink.blinkid.secured;

import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.facebook.imagepipeline.common.RotationOptions;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IIIIlIlIll extends OrientationEventListener {
    private Orientation IlIllIlIIl;
    private int IllIIIllII;
    private OrientationChangeListener llIIlIlIIl;

    public IIIIlIlIll(lIlIllIIlI lililliili, OrientationChangeListener orientationChangeListener) {
        super(lililliili.llIIIlllll());
        this.llIIlIlIIl = orientationChangeListener;
        int rotation = ((WindowManager) lililliili.llIIIlllll().getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (IIlIIlIllI.llIIlIlIIl(lililliili.llIIIlllll())) {
            Log.m2707d(this, "Screen is in portrait", new Object[0]);
            if (rotation == 0) {
                Log.m2707d(this, "Screen orientation is 0", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 2) {
                Log.m2707d(this, "Screen orientation is 180", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 3) {
                Log.m2707d(this, "Screen orientation is 270", new Object[0]);
                this.IllIIIllII = RotationOptions.ROTATE_270;
            } else {
                Log.m2707d(this, "Screen orientation is 90", new Object[0]);
                this.IllIIIllII = RotationOptions.ROTATE_270;
            }
        } else {
            Log.m2707d(this, "Screen is in landscape", new Object[0]);
            if (rotation == 1) {
                Log.m2707d(this, "Screen orientation is 90", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 3) {
                Log.m2707d(this, "Screen orientation is 270", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 0) {
                Log.m2707d(this, "Screen orientation is 0", new Object[0]);
                this.IllIIIllII = RotationOptions.ROTATE_270;
            } else {
                Log.m2707d(this, "Screen orientation is 180", new Object[0]);
                this.IllIIIllII = RotationOptions.ROTATE_270;
            }
        }
        Log.m2707d(this, "Calculated degrees offset: {}", Integer.valueOf(this.IllIIIllII));
        if (this.IllIIIllII == 270) {
            Log.m2707d(this, "Natural Orientation is landscape", new Object[0]);
            if (lililliili.IlIlllllII()) {
                this.IllIIIllII = 90;
            } else {
                this.IllIIIllII = RotationOptions.ROTATE_270;
            }
        } else {
            Log.m2707d(this, "Natural Orientation is portrait", new Object[0]);
        }
        this.IlIllIlIIl = Orientation.ORIENTATION_UNKNOWN;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2 = IIIIIIIIII.llIIlIlIIl;
        int i3 = this.IllIIIllII;
        OrientationChangeListener orientationChangeListener = this.llIIlIlIIl;
        if (orientationChangeListener == null || i == -1) {
            return;
        }
        int i4 = (i + i3) % 360;
        Orientation orientation = i4 < 0 ? this.IlIllIlIIl : (i4 >= 315 || i4 < 45) ? Orientation.ORIENTATION_PORTRAIT : (i4 < 45 || i4 >= 135) ? (i4 < 135 || i4 >= 225) ? (i4 < 225 || i4 >= 315) ? this.IlIllIlIIl : Orientation.ORIENTATION_LANDSCAPE_RIGHT : Orientation.ORIENTATION_PORTRAIT_UPSIDE : Orientation.ORIENTATION_LANDSCAPE_LEFT;
        if (orientation != this.IlIllIlIIl) {
            this.IlIllIlIIl = orientation;
            orientationChangeListener.onOrientationChange(orientation);
        }
    }
}
