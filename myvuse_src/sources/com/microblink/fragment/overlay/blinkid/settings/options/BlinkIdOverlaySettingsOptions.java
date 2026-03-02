package com.microblink.fragment.overlay.blinkid.settings.options;

import com.microblink.fragment.overlay.components.settings.OverlayCameraSettings;
import com.microblink.image.CurrentImageListener;
import com.microblink.image.DebugImageListener;
import com.microblink.uisettings.options.OcrResultDisplayMode;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface BlinkIdOverlaySettingsOptions<T> {
    T isHighResSuccessFrameCaptureEnabled(boolean z);

    T setBackSideScanningTimeoutMs(long j);

    T setBeepResourceId(int i);

    T setCameraSettings(OverlayCameraSettings overlayCameraSettings);

    T setCurrentImageListener(CurrentImageListener currentImageListener);

    T setDebugImageListener(DebugImageListener debugImageListener);

    T setDocumentDataMatchRequired(boolean z);

    T setLockedToPortrait(boolean z);

    T setOcrResultDisplayMode(OcrResultDisplayMode ocrResultDisplayMode);

    T setShowMrzDots(boolean z);

    T setShowNotSupportedDialog(boolean z);

    T setSplashResourceId(int i);
}
