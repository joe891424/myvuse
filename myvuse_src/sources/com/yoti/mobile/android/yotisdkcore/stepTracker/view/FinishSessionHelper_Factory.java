package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.FinishSessionInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FinishSessionHelper_Factory implements Factory<FinishSessionHelper> {

    /* JADX INFO: renamed from: a */
    private final Provider<FinishSessionInteractor> f7763a;

    /* JADX INFO: renamed from: b */
    private final Provider<ISessionStatusRepository> f7764b;

    public FinishSessionHelper_Factory(Provider<FinishSessionInteractor> provider, Provider<ISessionStatusRepository> provider2) {
        this.f7763a = provider;
        this.f7764b = provider2;
    }

    public static FinishSessionHelper_Factory create(Provider<FinishSessionInteractor> provider, Provider<ISessionStatusRepository> provider2) {
        return new FinishSessionHelper_Factory(provider, provider2);
    }

    public static FinishSessionHelper newInstance(FinishSessionInteractor finishSessionInteractor, ISessionStatusRepository iSessionStatusRepository) {
        return new FinishSessionHelper(finishSessionInteractor, iSessionStatusRepository);
    }

    @Override // javax.inject.Provider
    public FinishSessionHelper get() {
        return newInstance(this.f7763a.get(), this.f7764b.get());
    }
}
