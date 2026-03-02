package com.yoti.mobile.android.documentscan.ui.camera;

import androidx.camera.lifecycle.ProcessCameraProvider;
import com.google.common.util.concurrent.ListenableFuture;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.c */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC4772c implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SimpleCameraFragment f7062a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ListenableFuture f7063b;

    RunnableC4772c(SimpleCameraFragment simpleCameraFragment, ListenableFuture listenableFuture) {
        this.f7062a = simpleCameraFragment;
        this.f7063b = listenableFuture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ScanMultiSideDocumentListener f7045b;
        DocumentCaptureException.CameraViewException cameraViewException;
        try {
            SimpleCameraFragment simpleCameraFragment = this.f7062a;
            V v = this.f7063b.get();
            Intrinsics.checkExpressionValueIsNotNull(v, "cameraProviderFuture.get()");
            simpleCameraFragment.m4963a((ProcessCameraProvider) v);
        } catch (IllegalArgumentException e) {
            f7045b = this.f7062a.getF7045b();
            if (f7045b != null) {
                cameraViewException = new DocumentCaptureException.CameraViewException(e);
                f7045b.onError(cameraViewException);
            }
        } catch (IllegalStateException e2) {
            f7045b = this.f7062a.getF7045b();
            if (f7045b != null) {
                cameraViewException = new DocumentCaptureException.CameraViewException(e2);
                f7045b.onError(cameraViewException);
            }
        }
    }
}
