package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.x */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC4793x {
    /* JADX INFO: renamed from: a */
    void mo4967a();

    /* JADX INFO: renamed from: a */
    void mo4968a(int i);

    /* JADX INFO: renamed from: a */
    void mo4969a(DocumentCaptureException documentCaptureException);

    /* JADX INFO: renamed from: b */
    void mo4971b();

    void onBackSideScanned(DocumentCaptureResult documentCaptureResult);

    void onFrontSideScanned(DocumentCaptureResult documentCaptureResult);

    void onScanCompleted(DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2);
}
