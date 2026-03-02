package com.yoti.mobile.android.liveness.zoom.p072di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.data.LivenessExceptionToEntityMapper;
import com.yoti.mobile.android.liveness.data.LivenessExceptionToEntityMapper_Factory;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession_Factory;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory_Factory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToFailureMapper;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToFailureMapper_Factory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureEntityToDataMapper_Factory;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository_Factory;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceCreationRepository;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceCreationRepository_Factory;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceToEntityMapper_Factory;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecApiService;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecResourceCreationService;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecResourceCreationService_Factory;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService_Factory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4892x6dd681b2;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4893x44fa237a;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4894x514af474;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4895xce5e64e8;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4896xb83b362d;
import com.yoti.mobile.android.liveness.zoom.p072di.module.C4897x83f890d0;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecApiServiceModule;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecModule;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecModule_ProvidesFaceTecInitializerFactory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory;
import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecViewModelModule;
import com.yoti.mobile.android.liveness.zoom.view.LivenessFaceTecActivity;
import com.yoti.mobile.android.liveness.zoom.view.LivenessFaceTecActivity_MembersInjector;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecErrorToFailureMapper_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecResultProcessor_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment_MembersInjector;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.ScanFaceErrorFragment;
import com.yoti.mobile.android.liveness.zoom.view.capture.ScanFaceErrorFragment_MembersInjector;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecInitializer_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecLivenessResultProvider;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecLivenessResultProvider_Factory;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecResultProcessor_Factory;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecEducationalNavigatorProvider;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecEducationalNavigatorProvider_Factory;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecUploadNavigatorProvider_Factory;
import com.yoti.mobile.android.liveness.zoom.view.upload.LivenessFaceTecCaptureViewDataToEntityMapper_Factory;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory_Factory;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.remote.MimeTypeProvider_Factory;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.MultiPartBodyFactory_Factory;
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
import com.yoti.mobile.android.remote.p075di.RemoteDebugModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesOkHttpClientFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesServiceLocationFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesSessionFactory;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter_Factory;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule_MainThreadSchedulerFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus_Factory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule_ProvidesRequirementIdFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusPreferencesFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusRepositoryFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import io.reactivex.Scheduler;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class DaggerLivenessFaceTecComponent implements LivenessFaceTecComponent {
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<AssetToFileConverter> assetToFileConverterProvider;
    private Provider<AutomationFaceTecLivenessResultProvider> automationFaceTecLivenessResultProvider;
    private Provider<AutomationFaceTecResultProcessor> automationFaceTecResultProcessorProvider;
    private Provider<FaceTecInitializer> faceTecInitializerProvider;
    private Provider<FaceTecResultProcessor> faceTecResultProcessorProvider;
    private Provider<DeviceMetadata.Factory> factoryProvider;
    private Provider<IcanhazipIpRemoteDataSource> icanhazipIpRemoteDataSourceProvider;
    private Provider<IpRepository> ipRepositoryProvider;
    private Provider<IpifyIpRemoteDataSource> ipifyIpRemoteDataSourceProvider;
    private Provider<LivenessCoreSession> livenessCoreSessionProvider;
    private Provider<LivenessExceptionToEntityMapper> livenessExceptionToEntityMapperProvider;
    private Provider<LivenessFaceTecCaptureRepository> livenessFaceTecCaptureRepositoryProvider;
    private Provider<LivenessFaceTecCaptureViewModel> livenessFaceTecCaptureViewModelProvider;
    private final DaggerLivenessFaceTecComponent livenessFaceTecComponent;
    private Provider<LivenessFaceTecEducationalDependenciesProvider> livenessFaceTecEducationalDependenciesProvider;
    private Provider<LivenessFaceTecEducationalNavigatorProvider> livenessFaceTecEducationalNavigatorProvider;
    private final LivenessFaceTecModule livenessFaceTecModule;
    private Provider<LivenessFaceTecResourceCreationRepository> livenessFaceTecResourceCreationRepositoryProvider;
    private Provider<LivenessFaceTecResourceCreationService> livenessFaceTecResourceCreationServiceProvider;
    private Provider<LivenessFaceTecUploadDependenciesProvider> livenessFaceTecUploadDependenciesProvider;
    private Provider<LivenessFaceTecUploadService> livenessFaceTecUploadServiceProvider;
    private Provider<LivenessUploadErrorToFailureMapper> livenessUploadErrorToFailureMapperProvider;
    private Provider<Scheduler> mainThreadSchedulerProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MetadataInterceptor> metadataInterceptorProvider;
    private Provider<MimeTypeProvider> mimeTypeProvider;
    private Provider<MultiPartBodyFactory> multiPartBodyFactoryProvider;
    private Provider<TypedInterceptor> provideAuthInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideLoggingInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideMetadataInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideSessionInterceptor$remote_productionReleaseProvider;
    private Provider<LivenessFaceTecApiService> providesApiServiceProvider;
    private Provider<IFaceTecInitializer> providesFaceTecInitializerProvider;
    private Provider<IFaceTecResultProcessor> providesFaceTecResultProcessorProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<IcanhazipApi> providesIcanhazipApiService$remote_productionReleaseProvider;
    private Provider<IIpCacheDataSource> providesIpCacheDataSource$remote_productionReleaseProvider;
    private Provider<IIpRemoteDataSource> providesIpRemoteDataSource$remote_productionReleaseProvider;
    private Provider<IIpRepository> providesIpRepository$remote_productionReleaseProvider;
    private Provider<IpifyApi> providesIpifyApiService$remote_productionReleaseProvider;
    private Provider<ILivenessEducationalDependeciesProvider> providesLivenessCoreEducationalDependenciesProvider;
    private Provider<ILivenessUploadDependenciesProvider> providesLivenessCoreUploadDependenciesProvider;
    private Provider<ViewModel> providesLivenessFaceTecCaptureViewModelProvider;
    private Provider<LivenessFeatureConfiguration> providesLivenessFeatureConfigurationProvider;
    private Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> providesLivenessGuidelinesViewDataFactoryProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<String> providesRequirementIdProvider;

    /* JADX INFO: renamed from: providesSavedStateViewModelFactoryForLivenessFaceTecCaptureProvider */
    private Provider<SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel>> f7313x72d9efac;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<Session> providesSessionProvider;
    private Provider<RemoteExceptionToEntityMapper> remoteExceptionToEntityMapperProvider;
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateHandleHolderViewModelFactoryProvider;
    private Provider<SessionIdInterceptor> sessionIdInterceptorProvider;
    private Provider<SharedPreferences> sessionStatusPreferencesProvider;
    private Provider<SessionStatus> sessionStatusProvider;
    private Provider<SessionStatusRepository> sessionStatusRepositoryProvider;
    private Provider<ISessionStatusRepository> sessionStatusRepositoryProvider2;
    private Provider<Set<TypedInterceptor>> setOfTypedInterceptorProvider;
    private Provider<TypedLoggingInterceptor> typedLoggingInterceptorProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private IpTrackingModule ipTrackingModule;
        private LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule;
        private LivenessFaceTecModule livenessFaceTecModule;
        private LivenessFaceTecViewModelModule livenessFaceTecViewModelModule;
        private RemoteModule remoteModule;
        private ResourceConfigurationModule resourceConfigurationModule;
        private SchedulersModule schedulersModule;
        private SessionStatusModule sessionStatusModule;

        private Builder() {
        }

        public LivenessFaceTecComponent build() {
            Preconditions.checkBuilderRequirement(this.livenessFaceTecModule, LivenessFaceTecModule.class);
            Preconditions.checkBuilderRequirement(this.resourceConfigurationModule, ResourceConfigurationModule.class);
            if (this.livenessFaceTecApiServiceModule == null) {
                this.livenessFaceTecApiServiceModule = new LivenessFaceTecApiServiceModule();
            }
            if (this.livenessFaceTecViewModelModule == null) {
                this.livenessFaceTecViewModelModule = new LivenessFaceTecViewModelModule();
            }
            if (this.sessionStatusModule == null) {
                this.sessionStatusModule = new SessionStatusModule();
            }
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.ipTrackingModule == null) {
                this.ipTrackingModule = new IpTrackingModule();
            }
            if (this.schedulersModule == null) {
                this.schedulersModule = new SchedulersModule();
            }
            return new DaggerLivenessFaceTecComponent(this.livenessFaceTecModule, this.resourceConfigurationModule, this.livenessFaceTecApiServiceModule, this.livenessFaceTecViewModelModule, this.sessionStatusModule, this.commonModule, this.remoteModule, this.ipTrackingModule, this.schedulersModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            this.ipTrackingModule = (IpTrackingModule) Preconditions.checkNotNull(ipTrackingModule);
            return this;
        }

        public Builder livenessFaceTecApiServiceModule(LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule) {
            this.livenessFaceTecApiServiceModule = (LivenessFaceTecApiServiceModule) Preconditions.checkNotNull(livenessFaceTecApiServiceModule);
            return this;
        }

        public Builder livenessFaceTecModule(LivenessFaceTecModule livenessFaceTecModule) {
            this.livenessFaceTecModule = (LivenessFaceTecModule) Preconditions.checkNotNull(livenessFaceTecModule);
            return this;
        }

        public Builder livenessFaceTecViewModelModule(LivenessFaceTecViewModelModule livenessFaceTecViewModelModule) {
            this.livenessFaceTecViewModelModule = (LivenessFaceTecViewModelModule) Preconditions.checkNotNull(livenessFaceTecViewModelModule);
            return this;
        }

        @Deprecated
        public Builder remoteDebugModule(RemoteDebugModule remoteDebugModule) {
            Preconditions.checkNotNull(remoteDebugModule);
            return this;
        }

        public Builder remoteModule(RemoteModule remoteModule) {
            this.remoteModule = (RemoteModule) Preconditions.checkNotNull(remoteModule);
            return this;
        }

        public Builder resourceConfigurationModule(ResourceConfigurationModule resourceConfigurationModule) {
            this.resourceConfigurationModule = (ResourceConfigurationModule) Preconditions.checkNotNull(resourceConfigurationModule);
            return this;
        }

        public Builder schedulersModule(SchedulersModule schedulersModule) {
            this.schedulersModule = (SchedulersModule) Preconditions.checkNotNull(schedulersModule);
            return this;
        }

        public Builder sessionStatusModule(SessionStatusModule sessionStatusModule) {
            this.sessionStatusModule = (SessionStatusModule) Preconditions.checkNotNull(sessionStatusModule);
            return this;
        }
    }

    private DaggerLivenessFaceTecComponent(LivenessFaceTecModule livenessFaceTecModule, ResourceConfigurationModule resourceConfigurationModule, LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule, LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, SchedulersModule schedulersModule) {
        this.livenessFaceTecComponent = this;
        this.livenessFaceTecModule = livenessFaceTecModule;
        initialize(livenessFaceTecModule, resourceConfigurationModule, livenessFaceTecApiServiceModule, livenessFaceTecViewModelModule, sessionStatusModule, commonModule, remoteModule, ipTrackingModule, schedulersModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(LivenessFaceTecModule livenessFaceTecModule, ResourceConfigurationModule resourceConfigurationModule, LivenessFaceTecApiServiceModule livenessFaceTecApiServiceModule, LivenessFaceTecViewModelModule livenessFaceTecViewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, SchedulersModule schedulersModule) {
        this.applicationContextProvider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.providesLivenessFeatureConfigurationProvider = C4894x514af474.create(livenessFaceTecModule);
        SessionStatusModule_SessionStatusPreferencesFactory sessionStatusModule_SessionStatusPreferencesFactoryCreate = SessionStatusModule_SessionStatusPreferencesFactory.create(sessionStatusModule, this.applicationContextProvider);
        this.sessionStatusPreferencesProvider = sessionStatusModule_SessionStatusPreferencesFactoryCreate;
        SessionStatusRepository_Factory sessionStatusRepository_FactoryCreate = SessionStatusRepository_Factory.create(sessionStatusModule_SessionStatusPreferencesFactoryCreate);
        this.sessionStatusRepositoryProvider = sessionStatusRepository_FactoryCreate;
        SessionStatusModule_SessionStatusRepositoryFactory sessionStatusModule_SessionStatusRepositoryFactoryCreate = SessionStatusModule_SessionStatusRepositoryFactory.create(sessionStatusModule, sessionStatusRepository_FactoryCreate);
        this.sessionStatusRepositoryProvider2 = sessionStatusModule_SessionStatusRepositoryFactoryCreate;
        this.sessionStatusProvider = SessionStatus_Factory.create(sessionStatusModule_SessionStatusRepositoryFactoryCreate);
        this.mainThreadSchedulerProvider = SchedulersModule_MainThreadSchedulerFactory.create(schedulersModule);
        FaceTecInitializer_Factory faceTecInitializer_FactoryCreate = FaceTecInitializer_Factory.create(this.applicationContextProvider, this.sessionStatusProvider, FaceTecErrorToSessionStatusTypeMapper_Factory.create(), FaceTecErrorToFailureMapper_Factory.create(), this.mainThreadSchedulerProvider);
        this.faceTecInitializerProvider = faceTecInitializer_FactoryCreate;
        this.providesFaceTecInitializerProvider = DoubleCheck.provider(LivenessFaceTecModule_ProvidesFaceTecInitializerFactory.create(livenessFaceTecModule, faceTecInitializer_FactoryCreate, AutomationFaceTecInitializer_Factory.create()));
        C4895xce5e64e8 c4895xce5e64e8Create = C4895xce5e64e8.create(livenessFaceTecModule, LivenessGuidelinesViewDataFactory_Factory.create());
        this.providesLivenessGuidelinesViewDataFactoryProvider = c4895xce5e64e8Create;
        this.livenessFaceTecEducationalNavigatorProvider = LivenessFaceTecEducationalNavigatorProvider_Factory.create(this.providesFaceTecInitializerProvider, c4895xce5e64e8Create);
        this.providesRequirementIdProvider = DoubleCheck.provider(ResourceConfigurationModule_ProvidesRequirementIdFactory.create(resourceConfigurationModule));
        RemoteModule_ProvidesServiceLocationFactory remoteModule_ProvidesServiceLocationFactoryCreate = RemoteModule_ProvidesServiceLocationFactory.create(remoteModule);
        this.providesServiceLocationProvider = remoteModule_ProvidesServiceLocationFactoryCreate;
        ApiServiceFactory_Factory apiServiceFactory_FactoryCreate = ApiServiceFactory_Factory.create(remoteModule_ProvidesServiceLocationFactoryCreate, this.applicationContextProvider);
        this.apiServiceFactoryProvider = apiServiceFactory_FactoryCreate;
        TypedLoggingInterceptor_Factory typedLoggingInterceptor_FactoryCreate = TypedLoggingInterceptor_Factory.create(apiServiceFactory_FactoryCreate);
        this.typedLoggingInterceptorProvider = typedLoggingInterceptor_FactoryCreate;
        this.provideLoggingInterceptor$remote_productionReleaseProvider = C4921x437bef6b.create(remoteModule, typedLoggingInterceptor_FactoryCreate);
        Provider<Session> provider = DoubleCheck.provider(RemoteModule_ProvidesSessionFactory.create(remoteModule));
        this.providesSessionProvider = provider;
        SessionIdInterceptor_Factory sessionIdInterceptor_FactoryCreate = SessionIdInterceptor_Factory.create(provider);
        this.sessionIdInterceptorProvider = sessionIdInterceptor_FactoryCreate;
        this.provideSessionInterceptor$remote_productionReleaseProvider = C4923xa107bd4.create(remoteModule, sessionIdInterceptor_FactoryCreate);
        Provider<Gson> provider2 = DoubleCheck.provider(RemoteModule_ProvidesGsonFactory.create(remoteModule, this.apiServiceFactoryProvider));
        this.providesGsonProvider = provider2;
        Provider<IpifyApi> provider3 = DoubleCheck.provider(C4919xbf389a5a.create(ipTrackingModule, provider2));
        this.providesIpifyApiService$remote_productionReleaseProvider = provider3;
        this.ipifyIpRemoteDataSourceProvider = IpifyIpRemoteDataSource_Factory.create(provider3);
        Provider<IcanhazipApi> provider4 = DoubleCheck.provider(C4915xdf915f86.create(ipTrackingModule, this.providesGsonProvider));
        this.providesIcanhazipApiService$remote_productionReleaseProvider = provider4;
        IcanhazipIpRemoteDataSource_Factory icanhazipIpRemoteDataSource_FactoryCreate = IcanhazipIpRemoteDataSource_Factory.create(provider4);
        this.icanhazipIpRemoteDataSourceProvider = icanhazipIpRemoteDataSource_FactoryCreate;
        this.providesIpRemoteDataSource$remote_productionReleaseProvider = C4917x1a4ffbca.create(ipTrackingModule, this.ipifyIpRemoteDataSourceProvider, icanhazipIpRemoteDataSource_FactoryCreate);
        C4916xc9de3fea c4916xc9de3feaCreate = C4916xc9de3fea.create(ipTrackingModule);
        this.providesIpCacheDataSource$remote_productionReleaseProvider = c4916xc9de3feaCreate;
        IpRepository_Factory ipRepository_FactoryCreate = IpRepository_Factory.create(this.providesIpRemoteDataSource$remote_productionReleaseProvider, c4916xc9de3feaCreate);
        this.ipRepositoryProvider = ipRepository_FactoryCreate;
        C4918x4d860449 c4918x4d860449Create = C4918x4d860449.create(ipTrackingModule, ipRepository_FactoryCreate);
        this.providesIpRepository$remote_productionReleaseProvider = c4918x4d860449Create;
        DeviceMetadata_Factory_Factory deviceMetadata_Factory_FactoryCreate = DeviceMetadata_Factory_Factory.create(this.providesSessionProvider, c4918x4d860449Create);
        this.factoryProvider = deviceMetadata_Factory_FactoryCreate;
        MetadataInterceptor_Factory metadataInterceptor_FactoryCreate = MetadataInterceptor_Factory.create(deviceMetadata_Factory_FactoryCreate);
        this.metadataInterceptorProvider = metadataInterceptor_FactoryCreate;
        this.provideMetadataInterceptor$remote_productionReleaseProvider = C4922x94372e73.create(remoteModule, metadataInterceptor_FactoryCreate);
        this.provideAuthInterceptor$remote_productionReleaseProvider = C4920x3eb9105a.create(remoteModule, this.apiServiceFactoryProvider, this.providesSessionProvider);
        SetFactory setFactoryBuild = SetFactory.builder(4, 0).addProvider(this.provideLoggingInterceptor$remote_productionReleaseProvider).addProvider(this.provideSessionInterceptor$remote_productionReleaseProvider).addProvider(this.provideMetadataInterceptor$remote_productionReleaseProvider).addProvider(this.provideAuthInterceptor$remote_productionReleaseProvider).build();
        this.setOfTypedInterceptorProvider = setFactoryBuild;
        Provider<OkHttpClient> provider5 = DoubleCheck.provider(RemoteModule_ProvidesOkHttpClientFactory.create(remoteModule, this.apiServiceFactoryProvider, setFactoryBuild));
        this.providesOkHttpClientProvider = provider5;
        Provider<LivenessFaceTecApiService> provider6 = DoubleCheck.provider(LivenessFaceTecApiServiceModule_ProvidesApiServiceFactory.create(livenessFaceTecApiServiceModule, this.apiServiceFactoryProvider, provider5, this.providesGsonProvider));
        this.providesApiServiceProvider = provider6;
        this.livenessFaceTecResourceCreationServiceProvider = LivenessFaceTecResourceCreationService_Factory.create(provider6);
        this.remoteExceptionToEntityMapperProvider = RemoteExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        LivenessFaceTecResourceCreationRepository_Factory livenessFaceTecResourceCreationRepository_FactoryCreate = LivenessFaceTecResourceCreationRepository_Factory.create(this.providesRequirementIdProvider, this.livenessFaceTecResourceCreationServiceProvider, LivenessFaceTecResourceToEntityMapper_Factory.create(), this.remoteExceptionToEntityMapperProvider);
        this.livenessFaceTecResourceCreationRepositoryProvider = livenessFaceTecResourceCreationRepository_FactoryCreate;
        LivenessFaceTecEducationalDependenciesProvider_Factory livenessFaceTecEducationalDependenciesProvider_FactoryCreate = LivenessFaceTecEducationalDependenciesProvider_Factory.create(this.providesLivenessFeatureConfigurationProvider, this.livenessFaceTecEducationalNavigatorProvider, livenessFaceTecResourceCreationRepository_FactoryCreate, LivenessGuidelinesViewDataFactory_Factory.create());
        this.livenessFaceTecEducationalDependenciesProvider = livenessFaceTecEducationalDependenciesProvider_FactoryCreate;
        this.providesLivenessCoreEducationalDependenciesProvider = C4892x6dd681b2.create(livenessFaceTecModule, livenessFaceTecEducationalDependenciesProvider_FactoryCreate);
        MimeTypeProvider_Factory mimeTypeProvider_FactoryCreate = MimeTypeProvider_Factory.create(this.applicationContextProvider);
        this.mimeTypeProvider = mimeTypeProvider_FactoryCreate;
        MultiPartBodyFactory_Factory multiPartBodyFactory_FactoryCreate = MultiPartBodyFactory_Factory.create(this.applicationContextProvider, mimeTypeProvider_FactoryCreate);
        this.multiPartBodyFactoryProvider = multiPartBodyFactory_FactoryCreate;
        this.livenessFaceTecUploadServiceProvider = LivenessFaceTecUploadService_Factory.create(multiPartBodyFactory_FactoryCreate, this.providesApiServiceProvider);
        this.livenessExceptionToEntityMapperProvider = LivenessExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        this.livenessFaceTecCaptureRepositoryProvider = LivenessFaceTecCaptureRepository_Factory.create(this.livenessFaceTecUploadServiceProvider, LivenessFaceTecCaptureEntityToDataMapper_Factory.create(), this.livenessExceptionToEntityMapperProvider);
        this.livenessUploadErrorToFailureMapperProvider = LivenessUploadErrorToFailureMapper_Factory.create(ExceptionToFailureMapper_Factory.create());
        LivenessFaceTecUploadDependenciesProvider_Factory livenessFaceTecUploadDependenciesProvider_FactoryCreate = LivenessFaceTecUploadDependenciesProvider_Factory.create(this.livenessFaceTecCaptureRepositoryProvider, LivenessFaceTecUploadNavigatorProvider_Factory.create(), LivenessFaceTecCaptureViewDataToEntityMapper_Factory.create(), this.livenessUploadErrorToFailureMapperProvider);
        this.livenessFaceTecUploadDependenciesProvider = livenessFaceTecUploadDependenciesProvider_FactoryCreate;
        C4893x44fa237a c4893x44fa237aCreate = C4893x44fa237a.create(livenessFaceTecModule, livenessFaceTecUploadDependenciesProvider_FactoryCreate);
        this.providesLivenessCoreUploadDependenciesProvider = c4893x44fa237aCreate;
        this.livenessCoreSessionProvider = DoubleCheck.provider(LivenessCoreSession_Factory.create(this.applicationContextProvider, this.providesLivenessCoreEducationalDependenciesProvider, c4893x44fa237aCreate, this.providesLivenessFeatureConfigurationProvider));
        this.faceTecResultProcessorProvider = FaceTecResultProcessor_Factory.create(this.applicationContextProvider);
        AssetToFileConverter_Factory assetToFileConverter_FactoryCreate = AssetToFileConverter_Factory.create(this.applicationContextProvider);
        this.assetToFileConverterProvider = assetToFileConverter_FactoryCreate;
        AutomationFaceTecLivenessResultProvider_Factory automationFaceTecLivenessResultProvider_FactoryCreate = AutomationFaceTecLivenessResultProvider_Factory.create(assetToFileConverter_FactoryCreate);
        this.automationFaceTecLivenessResultProvider = automationFaceTecLivenessResultProvider_FactoryCreate;
        AutomationFaceTecResultProcessor_Factory automationFaceTecResultProcessor_FactoryCreate = AutomationFaceTecResultProcessor_Factory.create(automationFaceTecLivenessResultProvider_FactoryCreate);
        this.automationFaceTecResultProcessorProvider = automationFaceTecResultProcessor_FactoryCreate;
        LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory livenessFaceTecModule_ProvidesFaceTecResultProcessorFactoryCreate = LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory.create(livenessFaceTecModule, this.faceTecResultProcessorProvider, automationFaceTecResultProcessor_FactoryCreate);
        this.providesFaceTecResultProcessorProvider = livenessFaceTecModule_ProvidesFaceTecResultProcessorFactoryCreate;
        LivenessFaceTecCaptureViewModel_Factory livenessFaceTecCaptureViewModel_FactoryCreate = LivenessFaceTecCaptureViewModel_Factory.create(this.sessionStatusProvider, livenessFaceTecModule_ProvidesFaceTecResultProcessorFactoryCreate, FaceTecErrorToFailureMapper_Factory.create(), FaceTecErrorToSessionStatusTypeMapper_Factory.create());
        this.livenessFaceTecCaptureViewModelProvider = livenessFaceTecCaptureViewModel_FactoryCreate;
        this.providesLivenessFaceTecCaptureViewModelProvider = C4896xb83b362d.create(livenessFaceTecViewModelModule, livenessFaceTecCaptureViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(1).put(LivenessFaceTecCaptureViewModel.class, (Provider) this.providesLivenessFaceTecCaptureViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider7 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(mapProviderFactoryBuild));
        this.savedStateHandleHolderViewModelFactoryProvider = provider7;
        this.f7313x72d9efac = DoubleCheck.provider(C4897x83f890d0.create(livenessFaceTecViewModelModule, provider7));
    }

    private LivenessFaceTecActivity injectLivenessFaceTecActivity(LivenessFaceTecActivity livenessFaceTecActivity) {
        LivenessFaceTecActivity_MembersInjector.injectViewModelFactory(livenessFaceTecActivity, this.f7313x72d9efac.get());
        return livenessFaceTecActivity;
    }

    private LivenessFaceTecCaptureFragment injectLivenessFaceTecCaptureFragment(LivenessFaceTecCaptureFragment livenessFaceTecCaptureFragment) {
        LivenessFaceTecCaptureFragment_MembersInjector.injectViewModelFactory(livenessFaceTecCaptureFragment, this.f7313x72d9efac.get());
        return livenessFaceTecCaptureFragment;
    }

    private LivenessFaceTecSession injectLivenessFaceTecSession(LivenessFaceTecSession livenessFaceTecSession) {
        LivenessFaceTecSession_MembersInjector.injectCoreSession(livenessFaceTecSession, this.livenessCoreSessionProvider.get());
        return livenessFaceTecSession;
    }

    private ScanFaceErrorFragment injectScanFaceErrorFragment(ScanFaceErrorFragment scanFaceErrorFragment) {
        ScanFaceErrorFragment_MembersInjector.injectGuidelinesViewDataFactory(scanFaceErrorFragment, livenessGuidelinesViewDataFactoryOfLivenessUploadFailureType());
        return scanFaceErrorFragment;
    }

    private LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> livenessGuidelinesViewDataFactoryOfLivenessUploadFailureType() {
        return C4895xce5e64e8.providesLivenessGuidelinesViewDataFactory(this.livenessFaceTecModule, new LivenessGuidelinesViewDataFactory());
    }

    @Override // com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecComponent
    public void inject(LivenessFaceTecSession livenessFaceTecSession) {
        injectLivenessFaceTecSession(livenessFaceTecSession);
    }

    @Override // com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecComponent
    public void inject(LivenessFaceTecActivity livenessFaceTecActivity) {
        injectLivenessFaceTecActivity(livenessFaceTecActivity);
    }

    @Override // com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecComponent
    public void inject(LivenessFaceTecCaptureFragment livenessFaceTecCaptureFragment) {
        injectLivenessFaceTecCaptureFragment(livenessFaceTecCaptureFragment);
    }

    @Override // com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecComponent
    public void inject(ScanFaceErrorFragment scanFaceErrorFragment) {
        injectScanFaceErrorFragment(scanFaceErrorFragment);
    }
}
