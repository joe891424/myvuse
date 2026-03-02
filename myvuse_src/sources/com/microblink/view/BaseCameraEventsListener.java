package com.microblink.view;

import com.microblink.hardware.camera.AutofocusListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface BaseCameraEventsListener extends AutofocusListener {
    void onCameraPreviewStarted();

    void onCameraPreviewStopped();

    void onError(Throwable th);
}
