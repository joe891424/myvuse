package com.yoti.mobile.android.liveness.domain;

import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateLivenessResourceInteractor_Factory implements Factory<CreateLivenessResourceInteractor> {
    private final Provider<ILivenessResourceCreationRepository<ILivenessResourceEntity>> livenessResourceCreationRepositoryProvider;

    public CreateLivenessResourceInteractor_Factory(Provider<ILivenessResourceCreationRepository<ILivenessResourceEntity>> provider) {
        this.livenessResourceCreationRepositoryProvider = provider;
    }

    public static CreateLivenessResourceInteractor_Factory create(Provider<ILivenessResourceCreationRepository<ILivenessResourceEntity>> provider) {
        return new CreateLivenessResourceInteractor_Factory(provider);
    }

    public static CreateLivenessResourceInteractor newInstance(ILivenessResourceCreationRepository<ILivenessResourceEntity> iLivenessResourceCreationRepository) {
        return new CreateLivenessResourceInteractor(iLivenessResourceCreationRepository);
    }

    @Override // javax.inject.Provider
    public CreateLivenessResourceInteractor get() {
        return newInstance(this.livenessResourceCreationRepositoryProvider.get());
    }
}
