package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.q */
/* JADX INFO: loaded from: classes5.dex */
public final class C4728q implements InterfaceC4723l {

    /* JADX INFO: renamed from: a */
    private Recognizer.Result f6933a;

    /* JADX INFO: renamed from: b */
    private DocumentCaptureResult f6934b;

    /* JADX INFO: renamed from: c */
    private DocumentCaptureResult f6935c;

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: a */
    public DocumentCaptureResult mo4814a() {
        return this.f6934b;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: a */
    public void mo4815a(Recognizer.Result scanResult) {
        Intrinsics.checkParameterIsNotNull(scanResult, "scanResult");
        this.f6933a = scanResult.mo6354clone();
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: a */
    public void mo4816a(DocumentCaptureResult documentCaptureResult) {
        this.f6934b = documentCaptureResult;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: b */
    public Recognizer.Result mo4817b() {
        return this.f6933a;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: b */
    public void mo4818b(DocumentCaptureResult documentCaptureResult) {
        this.f6935c = documentCaptureResult;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: c */
    public DocumentCaptureResult mo4819c() {
        return this.f6935c;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.InterfaceC4723l
    /* JADX INFO: renamed from: d */
    public void mo4820d() {
        this.f6933a = null;
    }
}
