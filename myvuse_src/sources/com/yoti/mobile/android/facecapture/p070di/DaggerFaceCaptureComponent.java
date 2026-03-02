package com.yoti.mobile.android.facecapture.p070di;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory_Factory;
import com.yoti.mobile.android.facecapture.data.FaceCaptureRepository;
import com.yoti.mobile.android.facecapture.data.FaceCaptureRepository_Factory;
import com.yoti.mobile.android.facecapture.data.FaceCaptureResourceRepository;
import com.yoti.mobile.android.facecapture.data.FaceCaptureResourceRepository_Factory;
import com.yoti.mobile.android.facecapture.data.FaceCaptureValidationExceptionToEntityMapper;
import com.yoti.mobile.android.facecapture.data.FaceCaptureValidationExceptionToEntityMapper_Factory;
import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureResourceResponseToEntityMapper_Factory;
import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController;
import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController_Factory;
import com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiService;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiServiceAdapter;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiServiceAdapter_Factory;
import com.yoti.mobile.android.facecapture.data.remote.model.SecurityContent;
import com.yoti.mobile.android.facecapture.data.remote.model.SecurityContent_Factory_Factory;
import com.yoti.mobile.android.facecapture.p070di.module.C4835xbd5a0c1b;
import com.yoti.mobile.android.facecapture.p070di.module.C4836x1141fb71;
import com.yoti.mobile.android.facecapture.p070di.module.C4837xbe8f2e91;
import com.yoti.mobile.android.facecapture.p070di.module.C4838xb215f97d;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureApiServiceModule;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureApiServiceModule_ProvidesApiServiceFactory;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureModule;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureViewModelModule;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory;
import com.yoti.mobile.android.facecapture.view.FaceCaptureActivity;
import com.yoti.mobile.android.facecapture.view.FaceCaptureActivity_MembersInjector;
import com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor;
import com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor_Factory;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment_MembersInjector;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory_Factory;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureToEntityMapper_Factory;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel_Factory;
import com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory_Factory;
import com.yoti.mobile.android.facecapture.view.capture.mapper.ViewEventToStateMachineMapper_Factory;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider_Factory;
import com.yoti.mobile.android.facecapture.view.capture.util.LightSensor;
import com.yoti.mobile.android.facecapture.view.educational.FaceCaptureGuidelinesViewDataFactory_Factory;
import com.yoti.mobile.android.facecapture.view.navigation.FaceCaptureEducationalNavigatorProvider;
import com.yoti.mobile.android.facecapture.view.navigation.FaceCaptureEducationalNavigatorProvider_Factory;
import com.yoti.mobile.android.facecapture.view.navigation.FaceCaptureUploadNavigatorProvider_Factory;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment_MembersInjector;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel_Factory;
import com.yoti.mobile.android.facecapture.view.upload.FaceCaptureUploadErrorToFailureMapper;
import com.yoti.mobile.android.facecapture.view.upload.FaceCaptureUploadErrorToFailureMapper_Factory;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession_Factory;
import com.yoti.mobile.android.liveness.p071di.module.C4885x995a0445;
import com.yoti.mobile.android.liveness.p071di.module.LivenessFeatureConfigurationModule;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
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
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_ComputationCoroutineContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_IoCoroutineContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule_ProvidesRequirementIdFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class DaggerFaceCaptureComponent implements FaceCaptureComponent {
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<AssetToFileConverter> assetToFileConverterProvider;
    private Provider<AutomationFaceCaptureStateMachineFactory> automationFaceCaptureStateMachineFactoryProvider;
    private Provider<CaptureConfigurationProvider> captureConfigurationProvider;
    private Provider<CaptureResultProcessor> captureResultProcessorProvider;
    private final DaggerFaceCaptureComponent faceCaptureComponent;
    private Provider<FaceCaptureEducationalDependeciesProvider> faceCaptureEducationalDependeciesProvider;
    private Provider<FaceCaptureEducationalNavigatorProvider> faceCaptureEducationalNavigatorProvider;
    private Provider<FaceCaptureRepository> faceCaptureRepositoryProvider;
    private Provider<FaceCaptureResourceRepository> faceCaptureResourceRepositoryProvider;
    private Provider<FaceCaptureReviewViewModel> faceCaptureReviewViewModelProvider;
    private Provider<FaceCaptureUploadController> faceCaptureUploadControllerProvider;
    private Provider<FaceCaptureUploadDependenciesProvider> faceCaptureUploadDependenciesProvider;
    private Provider<FaceCaptureUploadErrorToFailureMapper> faceCaptureUploadErrorToFailureMapperProvider;
    private Provider<FaceCaptureValidationExceptionToEntityMapper> faceCaptureValidationExceptionToEntityMapperProvider;
    private Provider<FaceCaptureViewModel> faceCaptureViewModelProvider;
    private Provider<DeviceMetadata.Factory> factoryProvider;
    private Provider<SecurityContent.Factory> factoryProvider2;
    private Provider<IcanhazipIpRemoteDataSource> icanhazipIpRemoteDataSourceProvider;
    private Provider<IpRepository> ipRepositoryProvider;
    private Provider<IpifyIpRemoteDataSource> ipifyIpRemoteDataSourceProvider;
    private Provider<LivenessCoreSession> livenessCoreSessionProvider;
    private final LivenessFeatureConfigurationModule livenessFeatureConfigurationModule;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MetadataInterceptor> metadataInterceptorProvider;
    private Provider<MimeTypeProvider> mimeTypeProvider;
    private Provider<MultiPartBodyFactory> multiPartBodyFactoryProvider;
    private Provider<TypedInterceptor> provideAuthInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideLoggingInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideMetadataInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideSessionInterceptor$remote_productionReleaseProvider;
    private Provider<IFaceCaptureApiService> providesApiServiceProvider;
    private Provider<ViewModel> providesFaceCaptureReviewViewModelProvider;
    private Provider<IFaceCaptureStateMachineFactory> providesFaceCaptureStateMachineFactoryProvider;
    private Provider<ViewModel> providesFaceCaptureViewModelProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<IcanhazipApi> providesIcanhazipApiService$remote_productionReleaseProvider;
    private Provider<IIpCacheDataSource> providesIpCacheDataSource$remote_productionReleaseProvider;
    private Provider<IIpRemoteDataSource> providesIpRemoteDataSource$remote_productionReleaseProvider;
    private Provider<IIpRepository> providesIpRepository$remote_productionReleaseProvider;
    private Provider<IpifyApi> providesIpifyApiService$remote_productionReleaseProvider;
    private Provider<ILivenessEducationalDependeciesProvider> providesLivenessCoreEducationalDependenciesProvider;
    private Provider<ILivenessUploadDependenciesProvider> providesLivenessCoreUploadDependenciesProvider;
    private Provider<LivenessFeatureConfiguration> providesLivenessFeatureConfigurationProvider;
    private Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> providesLivenessGuidelinesViewDataFactoryProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<String> providesRequirementIdProvider;
    private Provider<SelfieApiService> providesSelfieApiServiceProvider;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<Session> providesSessionProvider;
    private Provider<ViewModelProvider.Factory> providesViewModelFactoryProvider;
    private Provider<RemoteExceptionToEntityMapper> remoteExceptionToEntityMapperProvider;
    private Provider<SelfieApiServiceAdapter> selfieApiServiceAdapterProvider;
    private Provider<SessionIdInterceptor> sessionIdInterceptorProvider;
    private Provider<Set<TypedInterceptor>> setOfTypedInterceptorProvider;
    private Provider<TypedLoggingInterceptor> typedLoggingInterceptorProvider;
    private Provider<ViewModelFactory> viewModelFactoryProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private FaceCaptureApiServiceModule faceCaptureApiServiceModule;
        private FaceCaptureModule faceCaptureModule;
        private FaceCaptureViewModelModule faceCaptureViewModelModule;
        private IpTrackingModule ipTrackingModule;
        private LivenessFeatureConfigurationModule livenessFeatureConfigurationModule;
        private RemoteModule remoteModule;
        private ResourceConfigurationModule resourceConfigurationModule;

        public FaceCaptureComponent build() {
            if (this.faceCaptureModule == null) {
                this.faceCaptureModule = new FaceCaptureModule();
            }
            Preconditions.checkBuilderRequirement(this.resourceConfigurationModule, ResourceConfigurationModule.class);
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.ipTrackingModule == null) {
                this.ipTrackingModule = new IpTrackingModule();
            }
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            if (this.faceCaptureViewModelModule == null) {
                this.faceCaptureViewModelModule = new FaceCaptureViewModelModule();
            }
            Preconditions.checkBuilderRequirement(this.faceCaptureApiServiceModule, FaceCaptureApiServiceModule.class);
            Preconditions.checkBuilderRequirement(this.livenessFeatureConfigurationModule, LivenessFeatureConfigurationModule.class);
            return new DaggerFaceCaptureComponent(this.faceCaptureModule, this.resourceConfigurationModule, this.remoteModule, this.ipTrackingModule, this.commonModule, this.faceCaptureViewModelModule, this.faceCaptureApiServiceModule, this.livenessFeatureConfigurationModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        @Deprecated
        public Builder coroutineContextModule(CoroutineContextModule coroutineContextModule) {
            Preconditions.checkNotNull(coroutineContextModule);
            return this;
        }

        public Builder faceCaptureApiServiceModule(FaceCaptureApiServiceModule faceCaptureApiServiceModule) {
            this.faceCaptureApiServiceModule = (FaceCaptureApiServiceModule) Preconditions.checkNotNull(faceCaptureApiServiceModule);
            return this;
        }

        public Builder faceCaptureModule(FaceCaptureModule faceCaptureModule) {
            this.faceCaptureModule = (FaceCaptureModule) Preconditions.checkNotNull(faceCaptureModule);
            return this;
        }

        public Builder faceCaptureViewModelModule(FaceCaptureViewModelModule faceCaptureViewModelModule) {
            this.faceCaptureViewModelModule = (FaceCaptureViewModelModule) Preconditions.checkNotNull(faceCaptureViewModelModule);
            return this;
        }

        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            this.ipTrackingModule = (IpTrackingModule) Preconditions.checkNotNull(ipTrackingModule);
            return this;
        }

        public Builder livenessFeatureConfigurationModule(LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
            this.livenessFeatureConfigurationModule = (LivenessFeatureConfigurationModule) Preconditions.checkNotNull(livenessFeatureConfigurationModule);
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

        @Deprecated
        public Builder schedulersModule(SchedulersModule schedulersModule) {
            Preconditions.checkNotNull(schedulersModule);
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private CaptureConfigurationProvider captureConfigurationProvider() {
        return new CaptureConfigurationProvider(C4885x995a0445.providesLivenessFeatureConfiguration(this.livenessFeatureConfigurationModule));
    }

    private void initialize(FaceCaptureModule faceCaptureModule, ResourceConfigurationModule resourceConfigurationModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, CommonModule commonModule, FaceCaptureViewModelModule faceCaptureViewModelModule, FaceCaptureApiServiceModule faceCaptureApiServiceModule, LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
        this.applicationContextProvider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.providesLivenessFeatureConfigurationProvider = C4885x995a0445.create(livenessFeatureConfigurationModule);
        C4837xbe8f2e91 c4837xbe8f2e91Create = C4837xbe8f2e91.create(faceCaptureModule, FaceCaptureGuidelinesViewDataFactory_Factory.create());
        this.providesLivenessGuidelinesViewDataFactoryProvider = c4837xbe8f2e91Create;
        this.faceCaptureEducationalNavigatorProvider = FaceCaptureEducationalNavigatorProvider_Factory.create(c4837xbe8f2e91Create);
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
        FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory faceCaptureApiServiceModule_ProvidesSelfieApiServiceFactoryCreate = FaceCaptureApiServiceModule_ProvidesSelfieApiServiceFactory.create(faceCaptureApiServiceModule, this.apiServiceFactoryProvider, provider5, this.providesGsonProvider);
        this.providesSelfieApiServiceProvider = faceCaptureApiServiceModule_ProvidesSelfieApiServiceFactoryCreate;
        SelfieApiServiceAdapter_Factory selfieApiServiceAdapter_FactoryCreate = SelfieApiServiceAdapter_Factory.create(faceCaptureApiServiceModule_ProvidesSelfieApiServiceFactoryCreate);
        this.selfieApiServiceAdapterProvider = selfieApiServiceAdapter_FactoryCreate;
        this.providesApiServiceProvider = FaceCaptureApiServiceModule_ProvidesApiServiceFactory.create(faceCaptureApiServiceModule, this.apiServiceFactoryProvider, this.providesOkHttpClientProvider, this.providesGsonProvider, selfieApiServiceAdapter_FactoryCreate);
        this.remoteExceptionToEntityMapperProvider = RemoteExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        FaceCaptureResourceRepository_Factory faceCaptureResourceRepository_FactoryCreate = FaceCaptureResourceRepository_Factory.create(this.providesRequirementIdProvider, this.providesApiServiceProvider, FaceCaptureResourceResponseToEntityMapper_Factory.create(), this.remoteExceptionToEntityMapperProvider);
        this.faceCaptureResourceRepositoryProvider = faceCaptureResourceRepository_FactoryCreate;
        FaceCaptureEducationalDependeciesProvider_Factory faceCaptureEducationalDependeciesProvider_FactoryCreate = FaceCaptureEducationalDependeciesProvider_Factory.create(this.providesLivenessFeatureConfigurationProvider, this.faceCaptureEducationalNavigatorProvider, faceCaptureResourceRepository_FactoryCreate, FaceCaptureGuidelinesViewDataFactory_Factory.create());
        this.faceCaptureEducationalDependeciesProvider = faceCaptureEducationalDependeciesProvider_FactoryCreate;
        this.providesLivenessCoreEducationalDependenciesProvider = C4835xbd5a0c1b.create(faceCaptureModule, faceCaptureEducationalDependeciesProvider_FactoryCreate);
        MimeTypeProvider_Factory mimeTypeProvider_FactoryCreate = MimeTypeProvider_Factory.create(this.applicationContextProvider);
        this.mimeTypeProvider = mimeTypeProvider_FactoryCreate;
        this.multiPartBodyFactoryProvider = MultiPartBodyFactory_Factory.create(this.applicationContextProvider, mimeTypeProvider_FactoryCreate);
        SecurityContent_Factory_Factory securityContent_Factory_FactoryCreate = SecurityContent_Factory_Factory.create(this.providesLivenessFeatureConfigurationProvider);
        this.factoryProvider2 = securityContent_Factory_FactoryCreate;
        this.faceCaptureUploadControllerProvider = FaceCaptureUploadController_Factory.create(this.multiPartBodyFactoryProvider, securityContent_Factory_FactoryCreate, this.providesApiServiceProvider);
        FaceCaptureValidationExceptionToEntityMapper_Factory faceCaptureValidationExceptionToEntityMapper_FactoryCreate = FaceCaptureValidationExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        this.faceCaptureValidationExceptionToEntityMapperProvider = faceCaptureValidationExceptionToEntityMapper_FactoryCreate;
        this.faceCaptureRepositoryProvider = FaceCaptureRepository_Factory.create(this.faceCaptureUploadControllerProvider, faceCaptureValidationExceptionToEntityMapper_FactoryCreate);
        this.faceCaptureUploadErrorToFailureMapperProvider = FaceCaptureUploadErrorToFailureMapper_Factory.create(ExceptionToFailureMapper_Factory.create());
        FaceCaptureUploadDependenciesProvider_Factory faceCaptureUploadDependenciesProvider_FactoryCreate = FaceCaptureUploadDependenciesProvider_Factory.create(this.faceCaptureRepositoryProvider, FaceCaptureUploadNavigatorProvider_Factory.create(), FaceCaptureToEntityMapper_Factory.create(), this.faceCaptureUploadErrorToFailureMapperProvider);
        this.faceCaptureUploadDependenciesProvider = faceCaptureUploadDependenciesProvider_FactoryCreate;
        C4836x1141fb71 c4836x1141fb71Create = C4836x1141fb71.create(faceCaptureModule, faceCaptureUploadDependenciesProvider_FactoryCreate);
        this.providesLivenessCoreUploadDependenciesProvider = c4836x1141fb71Create;
        this.livenessCoreSessionProvider = DoubleCheck.provider(LivenessCoreSession_Factory.create(this.applicationContextProvider, this.providesLivenessCoreEducationalDependenciesProvider, c4836x1141fb71Create, this.providesLivenessFeatureConfigurationProvider));
        AssetToFileConverter_Factory assetToFileConverter_FactoryCreate = AssetToFileConverter_Factory.create(this.applicationContextProvider);
        this.assetToFileConverterProvider = assetToFileConverter_FactoryCreate;
        this.automationFaceCaptureStateMachineFactoryProvider = AutomationFaceCaptureStateMachineFactory_Factory.create(assetToFileConverter_FactoryCreate);
        this.providesFaceCaptureStateMachineFactoryProvider = FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory.create(faceCaptureModule, FaceCaptureStateMachineFactory_Factory.create(), this.automationFaceCaptureStateMachineFactoryProvider);
        this.captureResultProcessorProvider = CaptureResultProcessor_Factory.create(this.applicationContextProvider, CoroutineContextModule_IoCoroutineContextFactory.create());
        this.captureConfigurationProvider = CaptureConfigurationProvider_Factory.create(this.providesLivenessFeatureConfigurationProvider);
        FaceCaptureViewModel_Factory faceCaptureViewModel_FactoryCreate = FaceCaptureViewModel_Factory.create(this.providesFaceCaptureStateMachineFactoryProvider, ViewEventToStateMachineMapper_Factory.create(), this.captureResultProcessorProvider, this.captureConfigurationProvider, CoroutineContextModule_ComputationCoroutineContextFactory.create());
        this.faceCaptureViewModelProvider = faceCaptureViewModel_FactoryCreate;
        this.providesFaceCaptureViewModelProvider = FaceCaptureViewModelModule_ProvidesFaceCaptureViewModelFactory.create(faceCaptureViewModelModule, faceCaptureViewModel_FactoryCreate);
        FaceCaptureReviewViewModel_Factory faceCaptureReviewViewModel_FactoryCreate = FaceCaptureReviewViewModel_Factory.create(this.captureResultProcessorProvider);
        this.faceCaptureReviewViewModelProvider = faceCaptureReviewViewModel_FactoryCreate;
        this.providesFaceCaptureReviewViewModelProvider = C4838xb215f97d.create(faceCaptureViewModelModule, faceCaptureReviewViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(2).put(FaceCaptureViewModel.class, (Provider) this.providesFaceCaptureViewModelProvider).put(FaceCaptureReviewViewModel.class, (Provider) this.providesFaceCaptureReviewViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<ViewModelFactory> provider6 = DoubleCheck.provider(ViewModelFactory_Factory.create(mapProviderFactoryBuild));
        this.viewModelFactoryProvider = provider6;
        this.providesViewModelFactoryProvider = DoubleCheck.provider(FaceCaptureViewModelModule_ProvidesViewModelFactoryFactory.create(faceCaptureViewModelModule, provider6));
    }

    private FaceCaptureActivity injectFaceCaptureActivity(FaceCaptureActivity faceCaptureActivity) {
        FaceCaptureActivity_MembersInjector.injectViewModelFactory(faceCaptureActivity, this.providesViewModelFactoryProvider.get());
        return faceCaptureActivity;
    }

    private FaceCaptureFragment injectFaceCaptureFragment(FaceCaptureFragment faceCaptureFragment) {
        FaceCaptureFragment_MembersInjector.injectViewModelFactory(faceCaptureFragment, this.providesViewModelFactoryProvider.get());
        FaceCaptureFragment_MembersInjector.injectConfigProvider(faceCaptureFragment, captureConfigurationProvider());
        FaceCaptureFragment_MembersInjector.injectLightSensor(faceCaptureFragment, lightSensor());
        return faceCaptureFragment;
    }

    private FaceCaptureReviewFragment injectFaceCaptureReviewFragment(FaceCaptureReviewFragment faceCaptureReviewFragment) {
        FaceCaptureReviewFragment_MembersInjector.injectViewModelFactory(faceCaptureReviewFragment, this.providesViewModelFactoryProvider.get());
        return faceCaptureReviewFragment;
    }

    private FaceCaptureSession injectFaceCaptureSession(FaceCaptureSession faceCaptureSession) {
        FaceCaptureSession_MembersInjector.injectCoreSession(faceCaptureSession, this.livenessCoreSessionProvider.get());
        return faceCaptureSession;
    }

    private LightSensor lightSensor() {
        return new LightSensor(this.applicationContextProvider.get());
    }

    @Override // com.yoti.mobile.android.facecapture.p070di.FaceCaptureComponent
    public void inject(FaceCaptureSession faceCaptureSession) {
        injectFaceCaptureSession(faceCaptureSession);
    }

    private DaggerFaceCaptureComponent(FaceCaptureModule faceCaptureModule, ResourceConfigurationModule resourceConfigurationModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, CommonModule commonModule, FaceCaptureViewModelModule faceCaptureViewModelModule, FaceCaptureApiServiceModule faceCaptureApiServiceModule, LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
        this.faceCaptureComponent = this;
        this.livenessFeatureConfigurationModule = livenessFeatureConfigurationModule;
        initialize(faceCaptureModule, resourceConfigurationModule, remoteModule, ipTrackingModule, commonModule, faceCaptureViewModelModule, faceCaptureApiServiceModule, livenessFeatureConfigurationModule);
    }

    @Override // com.yoti.mobile.android.facecapture.p070di.FaceCaptureComponent
    public void inject(FaceCaptureActivity faceCaptureActivity) {
        injectFaceCaptureActivity(faceCaptureActivity);
    }

    @Override // com.yoti.mobile.android.facecapture.p070di.FaceCaptureComponent
    public void inject(FaceCaptureFragment faceCaptureFragment) {
        injectFaceCaptureFragment(faceCaptureFragment);
    }

    @Override // com.yoti.mobile.android.facecapture.p070di.FaceCaptureComponent
    public void inject(FaceCaptureReviewFragment faceCaptureReviewFragment) {
        injectFaceCaptureReviewFragment(faceCaptureReviewFragment);
    }
}
