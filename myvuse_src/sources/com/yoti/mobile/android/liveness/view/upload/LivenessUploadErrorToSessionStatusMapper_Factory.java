package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadErrorToSessionStatusMapper_Factory implements Factory<LivenessUploadErrorToSessionStatusMapper> {
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusMapperProvider;

    public LivenessUploadErrorToSessionStatusMapper_Factory(Provider<ErrorToSessionStatusTypeMapper> provider) {
        this.errorToSessionStatusMapperProvider = provider;
    }

    public static LivenessUploadErrorToSessionStatusMapper_Factory create(Provider<ErrorToSessionStatusTypeMapper> provider) {
        return new LivenessUploadErrorToSessionStatusMapper_Factory(provider);
    }

    public static LivenessUploadErrorToSessionStatusMapper newInstance(ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        return new LivenessUploadErrorToSessionStatusMapper(errorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public LivenessUploadErrorToSessionStatusMapper get() {
        return newInstance(this.errorToSessionStatusMapperProvider.get());
    }
}
