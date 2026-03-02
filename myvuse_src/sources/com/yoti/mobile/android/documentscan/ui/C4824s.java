package com.yoti.mobile.android.documentscan.ui;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.recognition.ScanResultListener;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.s */
/* JADX INFO: loaded from: classes5.dex */
public final class C4824s implements ScanResultListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7158a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ FrameGrabberRecognizer f7159b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Recognizer f7160c;

    C4824s(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment, FrameGrabberRecognizer frameGrabberRecognizer, Recognizer recognizer) {
        this.f7158a = scanDocumentMultiSideFragment;
        this.f7159b = frameGrabberRecognizer;
        this.f7160c = recognizer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microblink.view.recognition.ScanResultListener
    public void onScanningDone(RecognitionSuccessType scanResult) {
        Intrinsics.checkParameterIsNotNull(scanResult, "scanResult");
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelM4906a = ScanDocumentMultiSideFragment.m4906a(this.f7158a);
        Recognizer.Result result = (Recognizer.Result) this.f7160c.getResult();
        Intrinsics.checkExpressionValueIsNotNull(result, "documentRecognizer.result");
        scanDocumentMultiSideViewModelM4906a.m4931a(scanResult, result);
    }

    @Override // com.microblink.view.recognition.ScanResultListener
    public void onUnrecoverableError(Throwable cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        ScanMultiSideDocumentListener f7045b = this.f7158a.getF7045b();
        if (f7045b != null) {
            String message = cause.getMessage();
            if (message == null) {
                message = "";
            }
            f7045b.onError(new DocumentCaptureException.DocumentCaptureFailedException(message, cause));
        }
    }
}
