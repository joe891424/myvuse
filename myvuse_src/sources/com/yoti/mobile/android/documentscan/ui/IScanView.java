package com.yoti.mobile.android.documentscan.ui;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J*\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/IScanView;", "", "scanArea", "Landroid/graphics/RectF;", "getScanArea", "()Landroid/graphics/RectF;", "displayDocumentDetected", "", "displayErrorState", "displayManualCaptureMode", "pageNumber", "", "hasCaptureTimedOut", "", "manualCaptureBehavior", "Lkotlin/Function0;", "hideDocumentDetected", "reset", "setupView", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "updateForPage", "documentConfigKey", "", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public interface IScanView {

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.IScanView$a */
    public static final class C4764a {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m4903a(IScanView iScanView, int i, boolean z, Function0 function0, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayManualCaptureMode");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            iScanView.displayManualCaptureMode(i, z, function0);
        }
    }

    void displayDocumentDetected();

    void displayErrorState();

    void displayManualCaptureMode(int pageNumber, boolean hasCaptureTimedOut, Function0<Unit> manualCaptureBehavior);

    RectF getScanArea();

    void hideDocumentDetected();

    void reset();

    void setupView(IScanViewConfiguration viewConfig);

    void updateForPage(int pageNumber, String documentConfigKey);
}
