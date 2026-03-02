package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadErrorToSessionStatusTypeMapper_Factory implements Factory<UploadErrorToSessionStatusTypeMapper> {

    private static final class InstanceHolder {
        private static final UploadErrorToSessionStatusTypeMapper_Factory INSTANCE = new UploadErrorToSessionStatusTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static UploadErrorToSessionStatusTypeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UploadErrorToSessionStatusTypeMapper newInstance() {
        return new UploadErrorToSessionStatusTypeMapper();
    }

    @Override // javax.inject.Provider
    public UploadErrorToSessionStatusTypeMapper get() {
        return newInstance();
    }
}
