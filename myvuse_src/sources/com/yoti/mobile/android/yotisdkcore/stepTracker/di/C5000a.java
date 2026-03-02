package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesSessionFactory;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus_Factory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesExternalDemonymProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesYdsDemonymProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusPreferencesFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusRepositoryFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncherFactory_Factory;
import com.yoti.mobile.android.yotisdkcore.core.view.ObjectiveEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.FinishSessionInteractor;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.FinishSessionInteractor_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.GetSessionConfigurationInteractor;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.GetSessionConfigurationInteractor_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.C5036m;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.DocumentCaptureStepEnumerator_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.DocumentResourceConfigEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.DocumentResourceConfigEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.FinishSessionHelper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.FinishSessionHelper_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.LivenessResourceConfigEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.LivenessResourceConfigEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.SessionConfigurationEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.SessionConfigurationEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerListAdapter;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewModel_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C5000a implements StepTrackerCoreComponent {

    /* JADX INFO: renamed from: a */
    private Provider<ISessionConfigurationRepository> f7640a;

    /* JADX INFO: renamed from: b */
    private Provider<SessionConfigurationFilterProcessor.a> f7641b;

    /* JADX INFO: renamed from: c */
    private Provider<SessionConfigurationFilterProcessor> f7642c;

    /* JADX INFO: renamed from: d */
    private Provider<GetSessionConfigurationInteractor> f7643d;

    /* JADX INFO: renamed from: e */
    private Provider<ISessionTokenRepository> f7644e;

    /* JADX INFO: renamed from: f */
    private Provider<Context> f7645f;

    /* JADX INFO: renamed from: g */
    private Provider<SharedPreferences> f7646g;

    /* JADX INFO: renamed from: h */
    private Provider<SessionStatusRepository> f7647h;

    /* JADX INFO: renamed from: i */
    private Provider<ISessionStatusRepository> f7648i;

    /* JADX INFO: renamed from: j */
    private Provider<FinishSessionInteractor> f7649j;

    /* JADX INFO: renamed from: k */
    private Provider<FinishSessionHelper> f7650k;

    /* JADX INFO: renamed from: l */
    private Provider<SessionStatus> f7651l;

    /* JADX INFO: renamed from: m */
    private Provider<IDemonymProvider> f7652m;

    /* JADX INFO: renamed from: n */
    private Provider<IDemonymProvider> f7653n;

    /* JADX INFO: renamed from: o */
    private Provider<Session> f7654o;

    /* JADX INFO: renamed from: p */
    private Provider<DocumentCaptureProperties> f7655p;

    /* JADX INFO: renamed from: q */
    private Provider<UiSessionProperties> f7656q;

    /* JADX INFO: renamed from: r */
    private Provider<DocumentResourceConfigEntityToViewDataMapper> f7657r;

    /* JADX INFO: renamed from: s */
    private Provider<CaptureCameraProperties> f7658s;

    /* JADX INFO: renamed from: t */
    private Provider<LivenessResourceConfigEntityToViewDataMapper> f7659t;

    /* JADX INFO: renamed from: u */
    private Provider<SessionConfigurationEntityToViewDataMapper> f7660u;

    /* JADX INFO: renamed from: v */
    private Provider<StepTrackerViewModel> f7661v;

    /* JADX INFO: renamed from: w */
    private Provider<ViewModel> f7662w;

    /* JADX INFO: renamed from: x */
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> f7663x;

    /* JADX INFO: renamed from: y */
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> f7664y;

    /* JADX INFO: renamed from: z */
    private Provider<SavedStateViewModelFactory<StepTrackerViewModel>> f7665z;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        private StepTrackerCoreModule f7666a;

        /* JADX INFO: renamed from: b */
        private RemoteModule f7667b;

        /* JADX INFO: renamed from: c */
        private CountryHelperModule f7668c;

        /* JADX INFO: renamed from: d */
        private SessionStatusModule f7669d;

        /* JADX INFO: renamed from: e */
        private CommonModule f7670e;

        /* JADX INFO: renamed from: f */
        private ViewModelModule f7671f;

        private b() {
        }

        /* JADX INFO: renamed from: a */
        public b m5138a(RemoteModule remoteModule) {
            this.f7667b = (RemoteModule) Preconditions.checkNotNull(remoteModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m5139a(CommonModule commonModule) {
            this.f7670e = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m5140a(CountryHelperModule countryHelperModule) {
            this.f7668c = (CountryHelperModule) Preconditions.checkNotNull(countryHelperModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m5141a(StepTrackerCoreModule stepTrackerCoreModule) {
            this.f7666a = (StepTrackerCoreModule) Preconditions.checkNotNull(stepTrackerCoreModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public StepTrackerCoreComponent m5142a() {
            Preconditions.checkBuilderRequirement(this.f7666a, StepTrackerCoreModule.class);
            Preconditions.checkBuilderRequirement(this.f7667b, RemoteModule.class);
            Preconditions.checkBuilderRequirement(this.f7668c, CountryHelperModule.class);
            if (this.f7669d == null) {
                this.f7669d = new SessionStatusModule();
            }
            Preconditions.checkBuilderRequirement(this.f7670e, CommonModule.class);
            if (this.f7671f == null) {
                this.f7671f = new ViewModelModule();
            }
            return new C5000a(this.f7666a, this.f7667b, this.f7668c, this.f7669d, this.f7670e, this.f7671f);
        }
    }

    private C5000a(StepTrackerCoreModule stepTrackerCoreModule, RemoteModule remoteModule, CountryHelperModule countryHelperModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, ViewModelModule viewModelModule) {
        m5135a(stepTrackerCoreModule, remoteModule, countryHelperModule, sessionStatusModule, commonModule, viewModelModule);
    }

    /* JADX INFO: renamed from: a */
    public static b m5134a() {
        return new b();
    }

    /* JADX INFO: renamed from: a */
    private void m5135a(StepTrackerCoreModule stepTrackerCoreModule, RemoteModule remoteModule, CountryHelperModule countryHelperModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, ViewModelModule viewModelModule) {
        this.f7640a = StepTrackerCoreModule_ProvidesStepRepositoryFactory.create(stepTrackerCoreModule);
        C4998xaa5fb8fe c4998xaa5fb8feCreate = C4998xaa5fb8fe.create(stepTrackerCoreModule);
        this.f7641b = c4998xaa5fb8feCreate;
        SessionConfigurationFilterProcessor_Factory sessionConfigurationFilterProcessor_FactoryCreate = SessionConfigurationFilterProcessor_Factory.create(c4998xaa5fb8feCreate);
        this.f7642c = sessionConfigurationFilterProcessor_FactoryCreate;
        this.f7643d = GetSessionConfigurationInteractor_Factory.create(this.f7640a, sessionConfigurationFilterProcessor_FactoryCreate);
        this.f7644e = StepTrackerCoreModule_ProvidesSessionTokenRepositoryFactory.create(stepTrackerCoreModule);
        Provider<Context> provider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.f7645f = provider;
        SessionStatusModule_SessionStatusPreferencesFactory sessionStatusModule_SessionStatusPreferencesFactoryCreate = SessionStatusModule_SessionStatusPreferencesFactory.create(sessionStatusModule, provider);
        this.f7646g = sessionStatusModule_SessionStatusPreferencesFactoryCreate;
        SessionStatusRepository_Factory sessionStatusRepository_FactoryCreate = SessionStatusRepository_Factory.create(sessionStatusModule_SessionStatusPreferencesFactoryCreate);
        this.f7647h = sessionStatusRepository_FactoryCreate;
        SessionStatusModule_SessionStatusRepositoryFactory sessionStatusModule_SessionStatusRepositoryFactoryCreate = SessionStatusModule_SessionStatusRepositoryFactory.create(sessionStatusModule, sessionStatusRepository_FactoryCreate);
        this.f7648i = sessionStatusModule_SessionStatusRepositoryFactoryCreate;
        FinishSessionInteractor_Factory finishSessionInteractor_FactoryCreate = FinishSessionInteractor_Factory.create(this.f7644e, sessionStatusModule_SessionStatusRepositoryFactoryCreate, this.f7640a);
        this.f7649j = finishSessionInteractor_FactoryCreate;
        this.f7650k = FinishSessionHelper_Factory.create(finishSessionInteractor_FactoryCreate, this.f7648i);
        this.f7651l = SessionStatus_Factory.create(this.f7648i);
        CountryHelperModule_ProvidesExternalDemonymProviderFactory countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate = CountryHelperModule_ProvidesExternalDemonymProviderFactory.create(countryHelperModule);
        this.f7652m = countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate;
        this.f7653n = CountryHelperModule_ProvidesYdsDemonymProviderFactory.create(countryHelperModule, countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate);
        this.f7654o = DoubleCheck.provider(RemoteModule_ProvidesSessionFactory.create(remoteModule));
        this.f7655p = StepTrackerCoreModule_ProvidesDocumentCapturePropertiesFactory.create(stepTrackerCoreModule);
        this.f7656q = StepTrackerCoreModule_ProvidesUiSessionPropertiesFactory.create(stepTrackerCoreModule);
        this.f7657r = DocumentResourceConfigEntityToViewDataMapper_Factory.create(DocumentTypeEntityToViewDataMapper_Factory.create(), ObjectiveEntityToViewDataMapper_Factory.create(), DocumentCaptureStepEnumerator_Factory.create(), this.f7653n, this.f7654o, this.f7655p, this.f7656q);
        StepTrackerCoreModule_ProvidesCameraPropertiesFactory stepTrackerCoreModule_ProvidesCameraPropertiesFactoryCreate = StepTrackerCoreModule_ProvidesCameraPropertiesFactory.create(stepTrackerCoreModule);
        this.f7658s = stepTrackerCoreModule_ProvidesCameraPropertiesFactoryCreate;
        LivenessResourceConfigEntityToViewDataMapper_Factory livenessResourceConfigEntityToViewDataMapper_FactoryCreate = LivenessResourceConfigEntityToViewDataMapper_Factory.create(this.f7654o, stepTrackerCoreModule_ProvidesCameraPropertiesFactoryCreate, this.f7656q);
        this.f7659t = livenessResourceConfigEntityToViewDataMapper_FactoryCreate;
        SessionConfigurationEntityToViewDataMapper_Factory sessionConfigurationEntityToViewDataMapper_FactoryCreate = SessionConfigurationEntityToViewDataMapper_Factory.create(this.f7657r, livenessResourceConfigEntityToViewDataMapper_FactoryCreate);
        this.f7660u = sessionConfigurationEntityToViewDataMapper_FactoryCreate;
        StepTrackerViewModel_Factory stepTrackerViewModel_FactoryCreate = StepTrackerViewModel_Factory.create(this.f7643d, this.f7650k, this.f7651l, sessionConfigurationEntityToViewDataMapper_FactoryCreate, FeatureLauncherFactory_Factory.create(), ErrorToSessionStatusTypeMapper_Factory.create(), ExceptionToFailureMapper_Factory.create());
        this.f7661v = stepTrackerViewModel_FactoryCreate;
        this.f7662w = ViewModelModule_ProvidesStepTrackerViewModelFactory.create(viewModelModule, stepTrackerViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(1).put(StepTrackerViewModel.class, (Provider) this.f7662w).build();
        this.f7663x = mapProviderFactoryBuild;
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider2 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(mapProviderFactoryBuild));
        this.f7664y = provider2;
        this.f7665z = DoubleCheck.provider(ViewModelModule_ProvidesSavedStateViewModelFactoryFactory.create(viewModelModule, provider2));
    }

    /* JADX INFO: renamed from: b */
    private StepTrackerFragment m5136b(StepTrackerFragment stepTrackerFragment) {
        C5036m.m5284a(stepTrackerFragment, new StepTrackerListAdapter());
        C5036m.m5283a(stepTrackerFragment, this.f7665z.get());
        return stepTrackerFragment;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreComponent
    /* JADX INFO: renamed from: a */
    public void mo5137a(StepTrackerFragment stepTrackerFragment) {
        m5136b(stepTrackerFragment);
    }
}
