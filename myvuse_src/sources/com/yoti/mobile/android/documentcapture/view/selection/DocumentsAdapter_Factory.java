package com.yoti.mobile.android.documentcapture.view.selection;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentsAdapter_Factory implements Factory<DocumentsAdapter> {

    private static final class InstanceHolder {
        private static final DocumentsAdapter_Factory INSTANCE = new DocumentsAdapter_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentsAdapter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentsAdapter newInstance() {
        return new DocumentsAdapter();
    }

    @Override // javax.inject.Provider
    public DocumentsAdapter get() {
        return newInstance();
    }
}
