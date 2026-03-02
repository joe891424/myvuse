package com.yoti.mobile.android.documentscan.ui;

import com.microblink.directApi.DirectApiErrorListener;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.i */
/* JADX INFO: loaded from: classes5.dex */
final class C4805i implements DirectApiErrorListener {

    /* JADX INFO: renamed from: a */
    public static final C4805i f7118a = new C4805i();

    C4805i() {
    }

    @Override // com.microblink.directApi.DirectApiErrorListener
    public final void onRecognizerError(Throwable it2) {
        Intrinsics.checkParameterIsNotNull(it2, "it");
        LogInstrumentation.m2729e(ImageScanFragment.TAG, "Recognition error", it2);
    }
}
