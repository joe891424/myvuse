package com.yoti.mobile.android.documentcapture.view.selection;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentTypeViewDataToEntityMapper_Factory implements Factory<DocumentTypeViewDataToEntityMapper> {

    private static final class InstanceHolder {
        private static final DocumentTypeViewDataToEntityMapper_Factory INSTANCE = new DocumentTypeViewDataToEntityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentTypeViewDataToEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentTypeViewDataToEntityMapper newInstance() {
        return new DocumentTypeViewDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public DocumentTypeViewDataToEntityMapper get() {
        return newInstance();
    }
}
