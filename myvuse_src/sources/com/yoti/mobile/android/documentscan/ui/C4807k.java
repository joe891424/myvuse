package com.yoti.mobile.android.documentscan.ui;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.recognition.ScanResultListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C4807k implements ScanResultListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7120a;

    C4807k(ImageScanFragment imageScanFragment) {
        this.f7120a = imageScanFragment;
    }

    @Override // com.microblink.view.recognition.ScanResultListener
    public void onScanningDone(RecognitionSuccessType scanResult) {
        Intrinsics.checkParameterIsNotNull(scanResult, "scanResult");
        Recognizer<?> slaveRecognizer = ImageScanFragment.access$getSuccessFrameGrabber$p(this.f7120a).getSlaveRecognizer();
        Intrinsics.checkExpressionValueIsNotNull(slaveRecognizer, "successFrameGrabber.slaveRecognizer");
        Recognizer.Result result = (Recognizer.Result) slaveRecognizer.getResult();
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelAccess$getViewModel$p = ImageScanFragment.access$getViewModel$p(this.f7120a);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        scanDocumentMultiSideViewModelAccess$getViewModel$p.m4931a(scanResult, result);
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelAccess$getViewModel$p2 = ImageScanFragment.access$getViewModel$p(this.f7120a);
        Image imageBuildImageFromJpegBytes = ImageBuilder.buildImageFromJpegBytes(ImageScanFragment.access$getCurrentImageData$p(this.f7120a), Orientation.ORIENTATION_PORTRAIT.intValue());
        Intrinsics.checkExpressionValueIsNotNull(imageBuildImageFromJpegBytes, "ImageBuilder.buildImageF…                        )");
        scanDocumentMultiSideViewModelAccess$getViewModel$p2.m4930a(imageBuildImageFromJpegBytes);
    }

    @Override // com.microblink.view.recognition.ScanResultListener
    public void onUnrecoverableError(Throwable cause) throws Throwable {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        throw cause;
    }
}
