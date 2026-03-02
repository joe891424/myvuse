package com.yoti.mobile.android.documentscan.ui;

import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.view.recognition.DetectionStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.g */
/* JADX INFO: loaded from: classes5.dex */
final class C4798g implements QuadDetectionCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7109a;

    C4798g(ImageScanFragment imageScanFragment) {
        this.f7109a = imageScanFragment;
    }

    @Override // com.microblink.metadata.detection.quad.QuadDetectionCallback
    public final void onQuadDetection(DisplayableQuadDetection displayableQuadDetection) {
        Intrinsics.checkParameterIsNotNull(displayableQuadDetection, "displayableQuadDetection");
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelAccess$getViewModel$p = ImageScanFragment.access$getViewModel$p(this.f7109a);
        DetectionStatus detectionStatus = displayableQuadDetection.getDetectionStatus();
        Intrinsics.checkExpressionValueIsNotNull(detectionStatus, "displayableQuadDetection.detectionStatus");
        scanDocumentMultiSideViewModelAccess$getViewModel$p.m4932a(detectionStatus);
    }
}
