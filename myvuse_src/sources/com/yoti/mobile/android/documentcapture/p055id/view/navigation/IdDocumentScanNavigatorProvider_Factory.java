package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentScanNavigatorProvider_Factory implements Factory<IdDocumentScanNavigatorProvider> {

    private static final class InstanceHolder {
        private static final IdDocumentScanNavigatorProvider_Factory INSTANCE = new IdDocumentScanNavigatorProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static IdDocumentScanNavigatorProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IdDocumentScanNavigatorProvider newInstance() {
        return new IdDocumentScanNavigatorProvider();
    }

    @Override // javax.inject.Provider
    public IdDocumentScanNavigatorProvider get() {
        return newInstance();
    }
}
