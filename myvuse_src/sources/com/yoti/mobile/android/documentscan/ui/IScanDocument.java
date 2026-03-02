package com.yoti.mobile.android.documentscan.ui;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "documentPageReviewed", "", "approved", "", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public interface IScanDocument {
    void documentPageReviewed(boolean approved);

    ScanMultiSideDocumentListener getListener();

    void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener);
}
