package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C4722k {

    /* JADX INFO: renamed from: a */
    private final C4724m f6911a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC4723l f6912b;

    public C4722k(C4724m frameStore, InterfaceC4723l scanResultRepository) {
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(scanResultRepository, "scanResultRepository");
        this.f6911a = frameStore;
        this.f6912b = scanResultRepository;
    }

    /* JADX INFO: renamed from: a */
    public final void m4798a() {
        this.f6911a.m4831e();
    }

    /* JADX INFO: renamed from: a */
    public final void m4799a(int i) {
        this.f6911a.m4823a(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m4800a(long j) {
        this.f6911a.m4824a(j);
    }

    /* JADX INFO: renamed from: a */
    public final void m4801a(Recognizer.Result result) {
        if (result != null) {
            this.f6912b.mo4815a(result);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4802a(DocumentCaptureResult documentCaptureResult) {
        this.f6912b.mo4818b(documentCaptureResult);
    }

    /* JADX INFO: renamed from: a */
    public final void m4803a(String str) {
        DocumentCaptureResult documentCaptureResultMo4814a = this.f6912b.mo4814a();
        if (documentCaptureResultMo4814a != null) {
            MetaData metaData = documentCaptureResultMo4814a.getMetaData();
            this.f6912b.mo4816a(DocumentCaptureResult.copy$default(documentCaptureResultMo4814a, null, metaData != null ? MetaData.copy$default(metaData, null, null, null, str, null, null, 55, null) : null, null, null, null, 29, null));
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4804a(ImageBuffer image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        return this.f6911a.m4825a(image);
    }

    /* JADX INFO: renamed from: b */
    public final DocumentCaptureResult m4805b() {
        return this.f6912b.mo4819c();
    }

    /* JADX INFO: renamed from: b */
    public final void m4806b(ImageBuffer image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        this.f6911a.m4827b(image);
    }

    /* JADX INFO: renamed from: b */
    public final void m4807b(DocumentCaptureResult documentCaptureResult) {
        this.f6912b.mo4816a(documentCaptureResult);
    }

    /* JADX INFO: renamed from: c */
    public final DocumentCaptureResult m4808c() {
        return this.f6912b.mo4814a();
    }

    /* JADX INFO: renamed from: c */
    public final void m4809c(ImageBuffer image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        this.f6911a.m4828c(image);
    }

    /* JADX INFO: renamed from: d */
    public final Recognizer.Result m4810d() {
        return this.f6912b.mo4817b();
    }

    /* JADX INFO: renamed from: e */
    public final void m4811e() {
        this.f6911a.m4822a();
        this.f6912b.mo4820d();
    }

    /* JADX INFO: renamed from: f */
    public final void m4812f() {
        this.f6911a.m4832f();
    }

    /* JADX INFO: renamed from: g */
    public final boolean m4813g() {
        return this.f6911a.m4830d();
    }
}
