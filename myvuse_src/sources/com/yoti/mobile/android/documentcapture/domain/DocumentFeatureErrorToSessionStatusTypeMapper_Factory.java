package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentFeatureErrorToSessionStatusTypeMapper_Factory implements Factory<DocumentFeatureErrorToSessionStatusTypeMapper> {
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;

    public DocumentFeatureErrorToSessionStatusTypeMapper_Factory(Provider<ErrorToSessionStatusTypeMapper> provider) {
        this.errorToSessionStatusTypeMapperProvider = provider;
    }

    public static DocumentFeatureErrorToSessionStatusTypeMapper_Factory create(Provider<ErrorToSessionStatusTypeMapper> provider) {
        return new DocumentFeatureErrorToSessionStatusTypeMapper_Factory(provider);
    }

    public static DocumentFeatureErrorToSessionStatusTypeMapper newInstance(ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        return new DocumentFeatureErrorToSessionStatusTypeMapper(errorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public DocumentFeatureErrorToSessionStatusTypeMapper get() {
        return newInstance(this.errorToSessionStatusTypeMapperProvider.get());
    }
}
