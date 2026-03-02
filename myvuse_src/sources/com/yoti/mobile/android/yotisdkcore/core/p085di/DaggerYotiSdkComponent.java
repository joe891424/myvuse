package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import android.content.SharedPreferences;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotisdkcore.C4958a;
import com.yoti.mobile.android.yotisdkcore.YotiSdk;
import com.yoti.mobile.android.yotisdkcore.core.SessionStatusProvider;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.StepTrackerLauncher;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DaggerYotiSdkComponent implements YotiSdkComponent {
    private Provider<Context> applicationContextProvider;
    private final SessionStatusModule sessionStatusModule;
    private final DaggerYotiSdkComponent yotiSdkComponent;

    public static final class Builder {
        private CommonModule commonModule;
        private SessionStatusModule sessionStatusModule;

        private Builder() {
        }

        public YotiSdkComponent build() {
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            if (this.sessionStatusModule == null) {
                this.sessionStatusModule = new SessionStatusModule();
            }
            return new DaggerYotiSdkComponent(this.commonModule, this.sessionStatusModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        public Builder sessionStatusModule(SessionStatusModule sessionStatusModule) {
            this.sessionStatusModule = (SessionStatusModule) Preconditions.checkNotNull(sessionStatusModule);
            return this;
        }
    }

    private DaggerYotiSdkComponent(CommonModule commonModule, SessionStatusModule sessionStatusModule) {
        this.yotiSdkComponent = this;
        this.sessionStatusModule = sessionStatusModule;
        initialize(commonModule, sessionStatusModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private ISessionStatusRepository iSessionStatusRepository() {
        return SessionStatusModule_SessionStatusRepositoryFactory.sessionStatusRepository(this.sessionStatusModule, sessionStatusRepository());
    }

    private void initialize(CommonModule commonModule, SessionStatusModule sessionStatusModule) {
        this.applicationContextProvider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
    }

    private YotiSdk injectYotiSdk(YotiSdk yotiSdk) {
        C4958a.m5091a(yotiSdk, sessionStatusProvider());
        C4958a.m5092a(yotiSdk, stepTrackerLauncher());
        return yotiSdk;
    }

    private SessionStatus sessionStatus() {
        return new SessionStatus(iSessionStatusRepository());
    }

    private SessionStatusProvider sessionStatusProvider() {
        return new SessionStatusProvider(sessionStatus());
    }

    private SessionStatusRepository sessionStatusRepository() {
        return new SessionStatusRepository(sessionStatusSharedPreferences());
    }

    private SharedPreferences sessionStatusSharedPreferences() {
        return SessionStatusModule_SessionStatusPreferencesFactory.sessionStatusPreferences(this.sessionStatusModule, this.applicationContextProvider.get());
    }

    private StepTrackerLauncher stepTrackerLauncher() {
        return new StepTrackerLauncher(sessionStatus());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.p085di.YotiSdkComponent
    public void inject(YotiSdk yotiSdk) {
        injectYotiSdk(yotiSdk);
    }
}
