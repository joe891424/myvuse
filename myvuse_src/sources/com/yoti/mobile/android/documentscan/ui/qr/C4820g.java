package com.yoti.mobile.android.documentscan.ui.qr;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.g */
/* JADX INFO: loaded from: classes5.dex */
final class C4820g<T> implements Consumer<DocumentCaptureResult> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4822i f7152a;

    C4820g(C4822i c4822i) {
        this.f7152a = c4822i;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(DocumentCaptureResult documentCaptureResult) {
        InterfaceC4818e interfaceC4818e = this.f7152a.f7155b;
        Intrinsics.checkExpressionValueIsNotNull(documentCaptureResult, "documentCaptureResult");
        interfaceC4818e.mo5014a(documentCaptureResult);
    }
}
