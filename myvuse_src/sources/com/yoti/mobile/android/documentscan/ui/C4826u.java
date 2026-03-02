package com.yoti.mobile.android.documentscan.ui;

import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.view.recognition.DetectionStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.u */
/* JADX INFO: loaded from: classes5.dex */
final class C4826u implements QuadDetectionCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7162a;

    C4826u(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        this.f7162a = scanDocumentMultiSideFragment;
    }

    @Override // com.microblink.metadata.detection.quad.QuadDetectionCallback
    public final void onQuadDetection(DisplayableQuadDetection displayableQuadDetection) {
        Intrinsics.checkParameterIsNotNull(displayableQuadDetection, "displayableQuadDetection");
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelM4906a = ScanDocumentMultiSideFragment.m4906a(this.f7162a);
        DetectionStatus detectionStatus = displayableQuadDetection.getDetectionStatus();
        Intrinsics.checkExpressionValueIsNotNull(detectionStatus, "displayableQuadDetection.detectionStatus");
        scanDocumentMultiSideViewModelM4906a.m4932a(detectionStatus);
    }
}
