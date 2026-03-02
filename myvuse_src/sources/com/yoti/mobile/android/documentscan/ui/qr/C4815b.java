package com.yoti.mobile.android.documentscan.ui.qr;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4815b implements InterfaceC4817d {

    /* JADX INFO: renamed from: a */
    private final AadhaarQrCodeResultExtractor f7145a;

    public C4815b(AadhaarQrCodeResultExtractor resultExtractor) {
        Intrinsics.checkParameterIsNotNull(resultExtractor, "resultExtractor");
        this.f7145a = resultExtractor;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.qr.InterfaceC4817d
    /* JADX INFO: renamed from: a */
    public Single<DocumentCaptureResult> mo5018a(String payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        Single<DocumentCaptureResult> singleSubscribeOn = Single.fromCallable(new CallableC4814a(this, payload)).subscribeOn(Schedulers.m5595io());
        Intrinsics.checkExpressionValueIsNotNull(singleSubscribeOn, "Single.fromCallable {\n  …scribeOn(Schedulers.io())");
        return singleSubscribeOn;
    }
}
