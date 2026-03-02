package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import io.reactivex.Scheduler;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceTecInitializer_Factory implements Factory<FaceTecInitializer> {
    private final Provider<Context> contextProvider;
    private final Provider<FaceTecErrorToFailureMapper> failureMapperProvider;
    private final Provider<Scheduler> postExecutionThreadProvider;
    private final Provider<SessionStatus> sessionStatusProvider;
    private final Provider<FaceTecErrorToSessionStatusTypeMapper> sessionStatusTypeMapperProvider;

    public FaceTecInitializer_Factory(Provider<Context> provider, Provider<SessionStatus> provider2, Provider<FaceTecErrorToSessionStatusTypeMapper> provider3, Provider<FaceTecErrorToFailureMapper> provider4, Provider<Scheduler> provider5) {
        this.contextProvider = provider;
        this.sessionStatusProvider = provider2;
        this.sessionStatusTypeMapperProvider = provider3;
        this.failureMapperProvider = provider4;
        this.postExecutionThreadProvider = provider5;
    }

    public static FaceTecInitializer_Factory create(Provider<Context> provider, Provider<SessionStatus> provider2, Provider<FaceTecErrorToSessionStatusTypeMapper> provider3, Provider<FaceTecErrorToFailureMapper> provider4, Provider<Scheduler> provider5) {
        return new FaceTecInitializer_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FaceTecInitializer newInstance(Context context, SessionStatus sessionStatus, FaceTecErrorToSessionStatusTypeMapper faceTecErrorToSessionStatusTypeMapper, FaceTecErrorToFailureMapper faceTecErrorToFailureMapper, Scheduler scheduler) {
        return new FaceTecInitializer(context, sessionStatus, faceTecErrorToSessionStatusTypeMapper, faceTecErrorToFailureMapper, scheduler);
    }

    @Override // javax.inject.Provider
    public FaceTecInitializer get() {
        return newInstance(this.contextProvider.get(), this.sessionStatusProvider.get(), this.sessionStatusTypeMapperProvider.get(), this.failureMapperProvider.get(), this.postExecutionThreadProvider.get());
    }
}
