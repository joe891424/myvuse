package com.yoti.mobile.android.liveness.domain;

import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadLivenessCaptureInteractor_Factory implements Factory<UploadLivenessCaptureInteractor> {
    private final Provider<ILivenessCaptureRepository<ILivenessCaptureEntity>> livenessRepositoryProvider;

    public UploadLivenessCaptureInteractor_Factory(Provider<ILivenessCaptureRepository<ILivenessCaptureEntity>> provider) {
        this.livenessRepositoryProvider = provider;
    }

    public static UploadLivenessCaptureInteractor_Factory create(Provider<ILivenessCaptureRepository<ILivenessCaptureEntity>> provider) {
        return new UploadLivenessCaptureInteractor_Factory(provider);
    }

    public static UploadLivenessCaptureInteractor newInstance(ILivenessCaptureRepository<ILivenessCaptureEntity> iLivenessCaptureRepository) {
        return new UploadLivenessCaptureInteractor(iLivenessCaptureRepository);
    }

    @Override // javax.inject.Provider
    public UploadLivenessCaptureInteractor get() {
        return newInstance(this.livenessRepositoryProvider.get());
    }
}
