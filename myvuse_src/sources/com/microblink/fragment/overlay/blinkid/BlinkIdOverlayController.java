package com.microblink.fragment.overlay.blinkid;

import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class BlinkIdOverlayController extends BaseBlinkIdOverlayController {
    public BlinkIdOverlayController(BlinkIdOverlaySettings blinkIdOverlaySettings, ScanResultListener scanResultListener, BlinkIdOverlayView blinkIdOverlayView) {
        super(blinkIdOverlaySettings, scanResultListener, blinkIdOverlayView);
    }

    @Override // com.microblink.fragment.overlay.blinkid.BaseBlinkIdOverlayController
    protected final ImageUploadManager lllIIIlIlI() {
        return new BlinkIdUploadManager();
    }
}
