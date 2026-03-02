package com.yoti.mobile.android.documentscan.ui.qr;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.a */
/* JADX INFO: loaded from: classes5.dex */
final class CallableC4814a<V, T> implements Callable<T> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4815b f7143a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f7144b;

    CallableC4814a(C4815b c4815b, String str) {
        this.f7143a = c4815b;
        this.f7144b = str;
    }

    @Override // java.util.concurrent.Callable
    public final DocumentCaptureResult call() {
        return new DocumentCaptureResult(this.f7143a.f7145a.m5023a(this.f7144b), null, this.f7143a.f7145a.m5026d(this.f7144b), this.f7143a.f7145a.m5025c(this.f7144b), this.f7143a.f7145a.m5024b(this.f7144b));
    }
}
