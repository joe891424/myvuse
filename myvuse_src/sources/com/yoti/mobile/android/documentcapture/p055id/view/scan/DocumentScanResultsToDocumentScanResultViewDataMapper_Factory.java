package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentScanResultsToDocumentScanResultViewDataMapper_Factory implements Factory<DocumentScanResultsToDocumentScanResultViewDataMapper> {

    private static final class InstanceHolder {
        private static final DocumentScanResultsToDocumentScanResultViewDataMapper_Factory INSTANCE = new DocumentScanResultsToDocumentScanResultViewDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentScanResultsToDocumentScanResultViewDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentScanResultsToDocumentScanResultViewDataMapper newInstance() {
        return new DocumentScanResultsToDocumentScanResultViewDataMapper();
    }

    @Override // javax.inject.Provider
    public DocumentScanResultsToDocumentScanResultViewDataMapper get() {
        return newInstance();
    }
}
