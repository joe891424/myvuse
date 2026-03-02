package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory_Factory;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper_Factory;
import com.yoti.mobile.android.remote.interceptor.MetadataInterceptor;
import com.yoti.mobile.android.remote.interceptor.MetadataInterceptor_Factory;
import com.yoti.mobile.android.remote.interceptor.SessionIdInterceptor;
import com.yoti.mobile.android.remote.interceptor.SessionIdInterceptor_Factory;
import com.yoti.mobile.android.remote.interceptor.TypedInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedLoggingInterceptor;
import com.yoti.mobile.android.remote.interceptor.TypedLoggingInterceptor_Factory;
import com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.IpRepository;
import com.yoti.mobile.android.remote.ip_tracking.data.IpRepository_Factory;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipApi;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipIpRemoteDataSource_Factory;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyApi;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource_Factory;
import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import com.yoti.mobile.android.remote.model.DeviceMetadata;
import com.yoti.mobile.android.remote.model.DeviceMetadata_Factory_Factory;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.remote.p075di.C4915xdf915f86;
import com.yoti.mobile.android.remote.p075di.C4916xc9de3fea;
import com.yoti.mobile.android.remote.p075di.C4917x1a4ffbca;
import com.yoti.mobile.android.remote.p075di.C4918x4d860449;
import com.yoti.mobile.android.remote.p075di.C4919xbf389a5a;
import com.yoti.mobile.android.remote.p075di.C4920x3eb9105a;
import com.yoti.mobile.android.remote.p075di.C4921x437bef6b;
import com.yoti.mobile.android.remote.p075di.C4922x94372e73;
import com.yoti.mobile.android.remote.p075di.C4923xa107bd4;
import com.yoti.mobile.android.remote.p075di.IpTrackingModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesOkHttpClientFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesServiceLocationFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesSessionFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.ApplicantProfileDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.ObjectiveTypeDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.StateTypeToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.SessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.SessionConfigurationCacheDataStore_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SessionConfigurationService;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SessionConfigurationService_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4978x27c318a2;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4981x500dfdb8;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SdkCoreApiServiceModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SdkCoreApiServiceModule_ProvidesApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionTokenApiServiceModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionTokenApiServiceModule_ProvidesApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.data.LivenessResourceConfigurationToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.SessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.SessionTokenRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenApiService;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenService;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenService_Factory;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreSession;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreSession_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C5012a implements StepTrackerComponent {

    /* JADX INFO: renamed from: A */
    private Provider<SessionTokenRepository> f7698A;

    /* JADX INFO: renamed from: B */
    private Provider<SdkCoreApiService> f7699B;

    /* JADX INFO: renamed from: C */
    private Provider<SessionConfigurationService> f7700C;

    /* JADX INFO: renamed from: D */
    private Provider<SharedPreferences> f7701D;

    /* JADX INFO: renamed from: E */
    private Provider<SessionConfigurationCacheDataStore> f7702E;

    /* JADX INFO: renamed from: F */
    private Provider<ISessionConfigurationCacheDataStore> f7703F;

    /* JADX INFO: renamed from: G */
    private Provider<TaskToEntityMapper> f7704G;

    /* JADX INFO: renamed from: H */
    private Provider<DocumentResourceConfigurationToEntityMapper> f7705H;

    /* JADX INFO: renamed from: I */
    private Provider<SessionConfigurationDataToEntityMapper> f7706I;

    /* JADX INFO: renamed from: J */
    private Provider<DataExceptionToEntityMapper> f7707J;

    /* JADX INFO: renamed from: K */
    private Provider<SessionConfigurationRepository> f7708K;

    /* JADX INFO: renamed from: L */
    private Provider<StepTrackerDependencyProvider> f7709L;

    /* JADX INFO: renamed from: M */
    private Provider<IStepTrackerCoreDependencyProvider> f7710M;

    /* JADX INFO: renamed from: N */
    private Provider<StepTrackerCoreSession> f7711N;

    /* JADX INFO: renamed from: a */
    private Provider<Context> f7712a;

    /* JADX INFO: renamed from: b */
    private Provider<ServiceLocation> f7713b;

    /* JADX INFO: renamed from: c */
    private Provider<ApiServiceFactory> f7714c;

    /* JADX INFO: renamed from: d */
    private Provider<TypedLoggingInterceptor> f7715d;

    /* JADX INFO: renamed from: e */
    private Provider<TypedInterceptor> f7716e;

    /* JADX INFO: renamed from: f */
    private Provider<Session> f7717f;

    /* JADX INFO: renamed from: g */
    private Provider<SessionIdInterceptor> f7718g;

    /* JADX INFO: renamed from: h */
    private Provider<TypedInterceptor> f7719h;

    /* JADX INFO: renamed from: i */
    private Provider<Gson> f7720i;

    /* JADX INFO: renamed from: j */
    private Provider<IpifyApi> f7721j;

    /* JADX INFO: renamed from: k */
    private Provider<IpifyIpRemoteDataSource> f7722k;

    /* JADX INFO: renamed from: l */
    private Provider<IcanhazipApi> f7723l;

    /* JADX INFO: renamed from: m */
    private Provider<IcanhazipIpRemoteDataSource> f7724m;

    /* JADX INFO: renamed from: n */
    private Provider<IIpRemoteDataSource> f7725n;

    /* JADX INFO: renamed from: o */
    private Provider<IIpCacheDataSource> f7726o;

    /* JADX INFO: renamed from: p */
    private Provider<IpRepository> f7727p;

    /* JADX INFO: renamed from: q */
    private Provider<IIpRepository> f7728q;

    /* JADX INFO: renamed from: r */
    private Provider<DeviceMetadata.Factory> f7729r;

    /* JADX INFO: renamed from: s */
    private Provider<MetadataInterceptor> f7730s;

    /* JADX INFO: renamed from: t */
    private Provider<TypedInterceptor> f7731t;

    /* JADX INFO: renamed from: u */
    private Provider<TypedInterceptor> f7732u;

    /* JADX INFO: renamed from: v */
    private Provider<Set<TypedInterceptor>> f7733v;

    /* JADX INFO: renamed from: w */
    private Provider<OkHttpClient> f7734w;

    /* JADX INFO: renamed from: x */
    private Provider<DeleteSessionTokenApiService> f7735x;

    /* JADX INFO: renamed from: y */
    private Provider<DeleteSessionTokenService> f7736y;

    /* JADX INFO: renamed from: z */
    private Provider<RemoteExceptionToEntityMapper> f7737z;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        private StepTrackerModule f7738a;

        /* JADX INFO: renamed from: b */
        private CommonModule f7739b;

        /* JADX INFO: renamed from: c */
        private SdkCoreApiServiceModule f7740c;

        /* JADX INFO: renamed from: d */
        private SessionTokenApiServiceModule f7741d;

        /* JADX INFO: renamed from: e */
        private SessionConfigurationModule f7742e;

        /* JADX INFO: renamed from: f */
        private RemoteModule f7743f;

        /* JADX INFO: renamed from: g */
        private IpTrackingModule f7744g;

        private b() {
        }

        /* JADX INFO: renamed from: a */
        public b m5184a(RemoteModule remoteModule) {
            this.f7743f = (RemoteModule) Preconditions.checkNotNull(remoteModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m5185a(CommonModule commonModule) {
            this.f7739b = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m5186a(SessionConfigurationModule sessionConfigurationModule) {
            this.f7742e = (SessionConfigurationModule) Preconditions.checkNotNull(sessionConfigurationModule);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public StepTrackerComponent m5187a() {
            if (this.f7738a == null) {
                this.f7738a = new StepTrackerModule();
            }
            Preconditions.checkBuilderRequirement(this.f7739b, CommonModule.class);
            if (this.f7740c == null) {
                this.f7740c = new SdkCoreApiServiceModule();
            }
            if (this.f7741d == null) {
                this.f7741d = new SessionTokenApiServiceModule();
            }
            Preconditions.checkBuilderRequirement(this.f7742e, SessionConfigurationModule.class);
            Preconditions.checkBuilderRequirement(this.f7743f, RemoteModule.class);
            if (this.f7744g == null) {
                this.f7744g = new IpTrackingModule();
            }
            return new C5012a(this.f7738a, this.f7739b, this.f7740c, this.f7741d, this.f7742e, this.f7743f, this.f7744g);
        }
    }

    private C5012a(StepTrackerModule stepTrackerModule, CommonModule commonModule, SdkCoreApiServiceModule sdkCoreApiServiceModule, SessionTokenApiServiceModule sessionTokenApiServiceModule, SessionConfigurationModule sessionConfigurationModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule) {
        m5181a(stepTrackerModule, commonModule, sdkCoreApiServiceModule, sessionTokenApiServiceModule, sessionConfigurationModule, remoteModule, ipTrackingModule);
    }

    /* JADX INFO: renamed from: a */
    public static b m5180a() {
        return new b();
    }

    /* JADX INFO: renamed from: a */
    private void m5181a(StepTrackerModule stepTrackerModule, CommonModule commonModule, SdkCoreApiServiceModule sdkCoreApiServiceModule, SessionTokenApiServiceModule sessionTokenApiServiceModule, SessionConfigurationModule sessionConfigurationModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule) {
        this.f7712a = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        RemoteModule_ProvidesServiceLocationFactory remoteModule_ProvidesServiceLocationFactoryCreate = RemoteModule_ProvidesServiceLocationFactory.create(remoteModule);
        this.f7713b = remoteModule_ProvidesServiceLocationFactoryCreate;
        ApiServiceFactory_Factory apiServiceFactory_FactoryCreate = ApiServiceFactory_Factory.create(remoteModule_ProvidesServiceLocationFactoryCreate, this.f7712a);
        this.f7714c = apiServiceFactory_FactoryCreate;
        TypedLoggingInterceptor_Factory typedLoggingInterceptor_FactoryCreate = TypedLoggingInterceptor_Factory.create(apiServiceFactory_FactoryCreate);
        this.f7715d = typedLoggingInterceptor_FactoryCreate;
        this.f7716e = C4921x437bef6b.create(remoteModule, typedLoggingInterceptor_FactoryCreate);
        Provider<Session> provider = DoubleCheck.provider(RemoteModule_ProvidesSessionFactory.create(remoteModule));
        this.f7717f = provider;
        SessionIdInterceptor_Factory sessionIdInterceptor_FactoryCreate = SessionIdInterceptor_Factory.create(provider);
        this.f7718g = sessionIdInterceptor_FactoryCreate;
        this.f7719h = C4923xa107bd4.create(remoteModule, sessionIdInterceptor_FactoryCreate);
        Provider<Gson> provider2 = DoubleCheck.provider(RemoteModule_ProvidesGsonFactory.create(remoteModule, this.f7714c));
        this.f7720i = provider2;
        Provider<IpifyApi> provider3 = DoubleCheck.provider(C4919xbf389a5a.create(ipTrackingModule, provider2));
        this.f7721j = provider3;
        this.f7722k = IpifyIpRemoteDataSource_Factory.create(provider3);
        Provider<IcanhazipApi> provider4 = DoubleCheck.provider(C4915xdf915f86.create(ipTrackingModule, this.f7720i));
        this.f7723l = provider4;
        IcanhazipIpRemoteDataSource_Factory icanhazipIpRemoteDataSource_FactoryCreate = IcanhazipIpRemoteDataSource_Factory.create(provider4);
        this.f7724m = icanhazipIpRemoteDataSource_FactoryCreate;
        this.f7725n = C4917x1a4ffbca.create(ipTrackingModule, this.f7722k, icanhazipIpRemoteDataSource_FactoryCreate);
        C4916xc9de3fea c4916xc9de3feaCreate = C4916xc9de3fea.create(ipTrackingModule);
        this.f7726o = c4916xc9de3feaCreate;
        IpRepository_Factory ipRepository_FactoryCreate = IpRepository_Factory.create(this.f7725n, c4916xc9de3feaCreate);
        this.f7727p = ipRepository_FactoryCreate;
        C4918x4d860449 c4918x4d860449Create = C4918x4d860449.create(ipTrackingModule, ipRepository_FactoryCreate);
        this.f7728q = c4918x4d860449Create;
        DeviceMetadata_Factory_Factory deviceMetadata_Factory_FactoryCreate = DeviceMetadata_Factory_Factory.create(this.f7717f, c4918x4d860449Create);
        this.f7729r = deviceMetadata_Factory_FactoryCreate;
        MetadataInterceptor_Factory metadataInterceptor_FactoryCreate = MetadataInterceptor_Factory.create(deviceMetadata_Factory_FactoryCreate);
        this.f7730s = metadataInterceptor_FactoryCreate;
        this.f7731t = C4922x94372e73.create(remoteModule, metadataInterceptor_FactoryCreate);
        this.f7732u = C4920x3eb9105a.create(remoteModule, this.f7714c, this.f7717f);
        SetFactory setFactoryBuild = SetFactory.builder(4, 0).addProvider(this.f7716e).addProvider(this.f7719h).addProvider(this.f7731t).addProvider(this.f7732u).build();
        this.f7733v = setFactoryBuild;
        Provider<OkHttpClient> provider5 = DoubleCheck.provider(RemoteModule_ProvidesOkHttpClientFactory.create(remoteModule, this.f7714c, setFactoryBuild));
        this.f7734w = provider5;
        Provider<DeleteSessionTokenApiService> provider6 = DoubleCheck.provider(SessionTokenApiServiceModule_ProvidesApiServiceFactory.create(sessionTokenApiServiceModule, this.f7714c, provider5));
        this.f7735x = provider6;
        this.f7736y = DeleteSessionTokenService_Factory.create(provider6);
        RemoteExceptionToEntityMapper_Factory remoteExceptionToEntityMapper_FactoryCreate = RemoteExceptionToEntityMapper_Factory.create(this.f7720i);
        this.f7737z = remoteExceptionToEntityMapper_FactoryCreate;
        this.f7698A = SessionTokenRepository_Factory.create(this.f7736y, remoteExceptionToEntityMapper_FactoryCreate);
        Provider<SdkCoreApiService> provider7 = DoubleCheck.provider(SdkCoreApiServiceModule_ProvidesApiServiceFactory.create(sdkCoreApiServiceModule, this.f7714c, this.f7734w));
        this.f7699B = provider7;
        this.f7700C = SessionConfigurationService_Factory.create(provider7);
        Provider<SharedPreferences> provider8 = DoubleCheck.provider(C4978x27c318a2.create(sessionConfigurationModule));
        this.f7701D = provider8;
        SessionConfigurationCacheDataStore_Factory sessionConfigurationCacheDataStore_FactoryCreate = SessionConfigurationCacheDataStore_Factory.create(provider8, this.f7720i);
        this.f7702E = sessionConfigurationCacheDataStore_FactoryCreate;
        this.f7703F = DoubleCheck.provider(C4981x500dfdb8.create(sessionConfigurationModule, sessionConfigurationCacheDataStore_FactoryCreate));
        this.f7704G = TaskToEntityMapper_Factory.create(StateTypeToEntityMapper_Factory.create());
        DocumentResourceConfigurationToEntityMapper_Factory documentResourceConfigurationToEntityMapper_FactoryCreate = DocumentResourceConfigurationToEntityMapper_Factory.create(DocumentTypeDataToEntityMapper_Factory.create(), ObjectiveTypeDataToEntityMapper_Factory.create(), this.f7704G, ApplicantProfileDataToEntityMapper_Factory.create());
        this.f7705H = documentResourceConfigurationToEntityMapper_FactoryCreate;
        this.f7706I = SessionConfigurationDataToEntityMapper_Factory.create(documentResourceConfigurationToEntityMapper_FactoryCreate, LivenessResourceConfigurationToEntityMapper_Factory.create());
        DataExceptionToEntityMapper_Factory dataExceptionToEntityMapper_FactoryCreate = DataExceptionToEntityMapper_Factory.create(this.f7720i);
        this.f7707J = dataExceptionToEntityMapper_FactoryCreate;
        SessionConfigurationRepository_Factory sessionConfigurationRepository_FactoryCreate = SessionConfigurationRepository_Factory.create(this.f7700C, this.f7703F, this.f7706I, dataExceptionToEntityMapper_FactoryCreate);
        this.f7708K = sessionConfigurationRepository_FactoryCreate;
        StepTrackerDependencyProvider_Factory stepTrackerDependencyProvider_FactoryCreate = StepTrackerDependencyProvider_Factory.create(this.f7698A, sessionConfigurationRepository_FactoryCreate);
        this.f7709L = stepTrackerDependencyProvider_FactoryCreate;
        StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory stepTrackerModule_ProvidesStepTrackerDependencyProviderFactoryCreate = StepTrackerModule_ProvidesStepTrackerDependencyProviderFactory.create(stepTrackerModule, stepTrackerDependencyProvider_FactoryCreate);
        this.f7710M = stepTrackerModule_ProvidesStepTrackerDependencyProviderFactoryCreate;
        this.f7711N = DoubleCheck.provider(StepTrackerCoreSession_Factory.create(this.f7712a, stepTrackerModule_ProvidesStepTrackerDependencyProviderFactoryCreate));
    }

    /* JADX INFO: renamed from: b */
    private StepTrackerSession m5182b(StepTrackerSession stepTrackerSession) {
        C5017f.m5197a(stepTrackerSession, this.f7711N.get());
        return stepTrackerSession;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.StepTrackerComponent
    /* JADX INFO: renamed from: a */
    public void mo5183a(StepTrackerSession stepTrackerSession) {
        m5182b(stepTrackerSession);
    }
}
