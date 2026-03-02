package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "", "onBackSideScanned", "", "capture", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "onError", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "onFrontSideScanned", "onScanCompleted", "resultFront", "resultBack", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public interface ScanMultiSideDocumentListener {
    void onBackSideScanned(DocumentCaptureResult capture);

    void onError(DocumentCaptureException t);

    void onFrontSideScanned(DocumentCaptureResult capture);

    void onScanCompleted(DocumentCaptureResult resultFront, DocumentCaptureResult resultBack);
}
