package com.yoti.mobile.android.documentcapture.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentFeatureErrorTagToViewEventMapper_Factory implements Factory<DocumentFeatureErrorTagToViewEventMapper> {

    private static final class InstanceHolder {
        private static final DocumentFeatureErrorTagToViewEventMapper_Factory INSTANCE = new DocumentFeatureErrorTagToViewEventMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentFeatureErrorTagToViewEventMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DocumentFeatureErrorTagToViewEventMapper newInstance() {
        return new DocumentFeatureErrorTagToViewEventMapper();
    }

    @Override // javax.inject.Provider
    public DocumentFeatureErrorTagToViewEventMapper get() {
        return newInstance();
    }
}
