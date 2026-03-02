package com.yoti.mobile.android.documentcapture.sup.view.scan;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentFileProvider_Factory implements Factory<SupDocumentFileProvider> {

    private static final class InstanceHolder {
        private static final SupDocumentFileProvider_Factory INSTANCE = new SupDocumentFileProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static SupDocumentFileProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SupDocumentFileProvider newInstance() {
        return new SupDocumentFileProvider();
    }

    @Override // javax.inject.Provider
    public SupDocumentFileProvider get() {
        return newInstance();
    }
}
