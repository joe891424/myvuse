package com.yoti.mobile.android.documentscan.ui.qr;

import com.facebook.common.callercontext.ContextChain;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.h */
/* JADX INFO: loaded from: classes5.dex */
final class C4821h<T> implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4822i f7153a;

    C4821h(C4822i c4822i) {
        this.f7153a = c4822i;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable throwable) {
        Intrinsics.checkExpressionValueIsNotNull(ContextChain.TAG_INFRA, "QrCodePresenter::class.java.simpleName");
        C4588L.logError(ContextChain.TAG_INFRA, "Building scan result failed", throwable);
        if (throwable instanceof DocumentCaptureException.AadhaarQrCodeNotRecognizedException) {
            this.f7153a.f7155b.mo5015a((DocumentCaptureException.AadhaarQrCodeNotRecognizedException) throwable);
            return;
        }
        InterfaceC4818e interfaceC4818e = this.f7153a.f7155b;
        Intrinsics.checkExpressionValueIsNotNull(throwable, "throwable");
        interfaceC4818e.mo5016a(throwable);
    }
}
