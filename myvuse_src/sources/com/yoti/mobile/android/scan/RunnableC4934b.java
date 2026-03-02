package com.yoti.mobile.android.scan;

import androidx.camera.lifecycle.ProcessCameraProvider;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.b */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC4934b implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewBaseFragment f7417a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ListenableFuture f7418b;

    RunnableC4934b(ScannerViewBaseFragment scannerViewBaseFragment, ListenableFuture listenableFuture) {
        this.f7417a = scannerViewBaseFragment;
        this.f7418b = listenableFuture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC4931a interfaceC4931a;
        try {
            ScannerViewBaseFragment scannerViewBaseFragment = this.f7417a;
            V v = this.f7418b.get();
            Intrinsics.checkExpressionValueIsNotNull(v, "cameraProviderFuture.get()");
            scannerViewBaseFragment.m5039a((ProcessCameraProvider) v);
        } catch (IllegalArgumentException e) {
            e = e;
            interfaceC4931a = this.f7417a.f7403e;
            if (interfaceC4931a == null) {
                return;
            }
            interfaceC4931a.onError(e);
        } catch (IllegalStateException e2) {
            e = e2;
            interfaceC4931a = this.f7417a.f7403e;
            if (interfaceC4931a == null) {
                return;
            }
            interfaceC4931a.onError(e);
        }
    }
}
