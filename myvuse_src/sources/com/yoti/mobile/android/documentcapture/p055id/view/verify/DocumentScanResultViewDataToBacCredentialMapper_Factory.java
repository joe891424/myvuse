package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentScanResultViewDataToBacCredentialMapper_Factory implements Factory<DocumentScanResultViewDataToBacCredentialMapper> {

    private static final class InstanceHolder {
        private static final DocumentScanResultViewDataToBacCredentialMapper_Factory INSTANCE = new DocumentScanResultViewDataToBacCredentialMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentScanResultViewDataToBacCredentialMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentScanResultViewDataToBacCredentialMapper newInstance() {
        return new DocumentScanResultViewDataToBacCredentialMapper();
    }

    @Override // javax.inject.Provider
    public DocumentScanResultViewDataToBacCredentialMapper get() {
        return newInstance();
    }
}
