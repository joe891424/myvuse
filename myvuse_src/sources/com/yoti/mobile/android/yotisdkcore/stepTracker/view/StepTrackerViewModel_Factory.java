package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncherFactory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.GetSessionConfigurationInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class StepTrackerViewModel_Factory implements Factory<StepTrackerViewModel> {

    /* JADX INFO: renamed from: a */
    private final Provider<GetSessionConfigurationInteractor> f7780a;

    /* JADX INFO: renamed from: b */
    private final Provider<FinishSessionHelper> f7781b;

    /* JADX INFO: renamed from: c */
    private final Provider<SessionStatus> f7782c;

    /* JADX INFO: renamed from: d */
    private final Provider<SessionConfigurationEntityToViewDataMapper> f7783d;

    /* JADX INFO: renamed from: e */
    private final Provider<FeatureLauncherFactory> f7784e;

    /* JADX INFO: renamed from: f */
    private final Provider<ErrorToSessionStatusTypeMapper> f7785f;

    /* JADX INFO: renamed from: g */
    private final Provider<ExceptionToFailureMapper> f7786g;

    public StepTrackerViewModel_Factory(Provider<GetSessionConfigurationInteractor> provider, Provider<FinishSessionHelper> provider2, Provider<SessionStatus> provider3, Provider<SessionConfigurationEntityToViewDataMapper> provider4, Provider<FeatureLauncherFactory> provider5, Provider<ErrorToSessionStatusTypeMapper> provider6, Provider<ExceptionToFailureMapper> provider7) {
        this.f7780a = provider;
        this.f7781b = provider2;
        this.f7782c = provider3;
        this.f7783d = provider4;
        this.f7784e = provider5;
        this.f7785f = provider6;
        this.f7786g = provider7;
    }

    public static StepTrackerViewModel_Factory create(Provider<GetSessionConfigurationInteractor> provider, Provider<FinishSessionHelper> provider2, Provider<SessionStatus> provider3, Provider<SessionConfigurationEntityToViewDataMapper> provider4, Provider<FeatureLauncherFactory> provider5, Provider<ErrorToSessionStatusTypeMapper> provider6, Provider<ExceptionToFailureMapper> provider7) {
        return new StepTrackerViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static StepTrackerViewModel newInstance(GetSessionConfigurationInteractor getSessionConfigurationInteractor, FinishSessionHelper finishSessionHelper, SessionStatus sessionStatus, SessionConfigurationEntityToViewDataMapper sessionConfigurationEntityToViewDataMapper, FeatureLauncherFactory featureLauncherFactory, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, ExceptionToFailureMapper exceptionToFailureMapper) {
        return new StepTrackerViewModel(getSessionConfigurationInteractor, finishSessionHelper, sessionStatus, sessionConfigurationEntityToViewDataMapper, featureLauncherFactory, errorToSessionStatusTypeMapper, exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public StepTrackerViewModel get() {
        return newInstance(this.f7780a.get(), this.f7781b.get(), this.f7782c.get(), this.f7783d.get(), this.f7784e.get(), this.f7785f.get(), this.f7786g.get());
    }
}
