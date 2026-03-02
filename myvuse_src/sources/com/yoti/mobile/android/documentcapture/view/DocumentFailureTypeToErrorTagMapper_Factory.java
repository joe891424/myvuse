package com.yoti.mobile.android.documentcapture.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentFailureTypeToErrorTagMapper_Factory implements Factory<DocumentFailureTypeToErrorTagMapper> {

    private static final class InstanceHolder {
        private static final DocumentFailureTypeToErrorTagMapper_Factory INSTANCE = new DocumentFailureTypeToErrorTagMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentFailureTypeToErrorTagMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentFailureTypeToErrorTagMapper newInstance() {
        return new DocumentFailureTypeToErrorTagMapper();
    }

    @Override // javax.inject.Provider
    public DocumentFailureTypeToErrorTagMapper get() {
        return newInstance();
    }
}
