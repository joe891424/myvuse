package com.microblink.hardware.camera;

import android.graphics.Rect;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface AutofocusListener {
    void onAutofocusFailed();

    void onAutofocusStarted(Rect[] rectArr);

    void onAutofocusStopped(Rect[] rectArr);
}
