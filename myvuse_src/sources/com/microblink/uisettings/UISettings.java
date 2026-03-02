package com.microblink.uisettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.fragment.overlay.components.settings.OverlayCameraSettings;
import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UISettings<ScanOverlayType extends ScanningOverlay> {
    private Bundle llIIlIlIIl;
    private static final String IlIllIlIIl = llIIlIlIIl("Common", "usingFlagSecure");
    private static final String IllIIIllII = llIIlIlIIl("Common", "filterTouchesWhenObscured");
    private static final String llIIIlllll = llIIlIlIIl("Common", "cameraSettings");
    private static final String IllIIIIllI = llIIlIlIIl("Common", "activityTheme");

    public UISettings() {
        this.llIIlIlIIl = new Bundle();
    }

    final <T extends Parcelable> T IlIllIlIIl(String str, T t) {
        T t2 = (T) this.llIIlIlIIl.getParcelable(str);
        return t2 == null ? t : t2;
    }

    public abstract ScanOverlayType createOverlayController(Activity activity, ScanResultListener scanResultListener);

    public final int getActivityTheme() {
        return this.llIIlIlIIl.getInt(IllIIIIllI, 0);
    }

    public final boolean getFilterTouchesWhenObscured() {
        return this.llIIlIlIIl.getBoolean(IllIIIllII, false);
    }

    public abstract Class<?> getTargetActivity();

    public final boolean getUsingFlagSecure() {
        return this.llIIlIlIIl.getBoolean(IlIllIlIIl, false);
    }

    OverlayCameraSettings llIIlIlIIl() {
        CameraSettings cameraSettings = (CameraSettings) this.llIIlIlIIl.getParcelable(llIIIlllll);
        OverlayCameraSettings.Builder builder = new OverlayCameraSettings.Builder();
        if (cameraSettings != null) {
            builder.setAspectMode(cameraSettings.aspectMode);
            builder.setPreviewZoomScale(cameraSettings.previewZoomScale);
            builder.setForceLegacyApi(cameraSettings.forceLegacyApi);
            builder.setIsOptimizedForNearScan(cameraSettings.isOptimizedForNearScan);
            builder.setIsPinchToZoomAllowed(cameraSettings.isPinchToZoomAllowed);
            builder.setSurface(cameraSettings.surface);
            builder.setType(cameraSettings.type);
            builder.setVideoResolutionPreset(cameraSettings.videoResolutionPreset);
        }
        return builder.build();
    }

    public void saveToIntent(Intent intent) {
        intent.putExtra("com.microblink.activity.extras.settingsBundle", this.llIIlIlIIl);
    }

    public final void setActivityTheme(int i) {
        this.llIIlIlIIl.putInt(IllIIIIllI, i);
    }

    public final void setCameraSettings(CameraSettings cameraSettings) {
        this.llIIlIlIIl.putParcelable(llIIIlllll, cameraSettings);
    }

    public final void setFilterTouchesWhenObscured(boolean z) {
        this.llIIlIlIIl.putBoolean(IllIIIllII, z);
    }

    public final void setUsingFlagSecure(boolean z) {
        this.llIIlIlIIl.putBoolean(IlIllIlIIl, z);
    }

    final int IlIllIlIIl(String str, int i) {
        return this.llIIlIlIIl.getInt(str, i);
    }

    UISettings(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.microblink.activity.extras.settingsBundle");
        this.llIIlIlIIl = bundleExtra;
        if (bundleExtra == null) {
            this.llIIlIlIIl = new Bundle();
        }
    }

    final boolean IlIllIlIIl(String str, boolean z) {
        return this.llIIlIlIIl.getBoolean(str, z);
    }

    final long IlIllIlIIl(String str, long j) {
        return this.llIIlIlIIl.getLong(str, j);
    }

    final void llIIlIlIIl(String str, Parcelable parcelable) {
        this.llIIlIlIIl.putParcelable(str, parcelable);
    }

    final <T extends Parcelable> T llIIlIlIIl(String str) {
        return (T) this.llIIlIlIIl.getParcelable(str);
    }

    final void llIIlIlIIl(String str, int i) {
        this.llIIlIlIIl.putInt(str, i);
    }

    final void llIIlIlIIl(String str, boolean z) {
        this.llIIlIlIIl.putBoolean(str, z);
    }

    final void llIIlIlIIl(String str, long j) {
        this.llIIlIlIIl.putLong(str, j);
    }

    static String llIIlIlIIl(String str, String str2) {
        return "mb." + str + "." + str2;
    }
}
