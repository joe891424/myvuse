package com.yoti.mobile.android.liveness.p071di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory_Factory;
import com.yoti.mobile.android.liveness.data.BiometricConsentRepository;
import com.yoti.mobile.android.liveness.data.BiometricConsentRepository_Factory;
import com.yoti.mobile.android.liveness.data.remote.GiveBiometricConsentService;
import com.yoti.mobile.android.liveness.data.remote.GiveBiometricConsentService_Factory;
import com.yoti.mobile.android.liveness.data.remote.LivenessCoreApiService;
import com.yoti.mobile.android.liveness.domain.CreateLivenessResourceInteractor;
import com.yoti.mobile.android.liveness.domain.CreateLivenessResourceInteractor_Factory;
import com.yoti.mobile.android.liveness.domain.GiveBiometricConsentInteractor;
import com.yoti.mobile.android.liveness.domain.GiveBiometricConsentInteractor_Factory;
import com.yoti.mobile.android.liveness.domain.IBiometricConsentRepository;
import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.domain.UploadLivenessCaptureInteractor;
import com.yoti.mobile.android.liveness.domain.UploadLivenessCaptureInteractor_Factory;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.p071di.module.C4873x16c9cf2a;
import com.yoti.mobile.android.liveness.p071di.module.C4874xf32f1961;
import com.yoti.mobile.android.liveness.p071di.module.C4875x6bffa058;
import com.yoti.mobile.android.liveness.p071di.module.C4876x39f50d66;
import com.yoti.mobile.android.liveness.p071di.module.C4877x599c81bf;
import com.yoti.mobile.android.liveness.p071di.module.C4878xcb53dbff;
import com.yoti.mobile.android.liveness.p071di.module.C4879xca9022ff;
import com.yoti.mobile.android.liveness.p071di.module.C4880xa9a0018b;
import com.yoti.mobile.android.liveness.p071di.module.C4881x981a7273;
import com.yoti.mobile.android.liveness.p071di.module.C4882xd161cd27;
import com.yoti.mobile.android.liveness.p071di.module.C4883x5519472d;
import com.yoti.mobile.android.liveness.p071di.module.C4884xfdfab2f0;
import com.yoti.mobile.android.liveness.p071di.module.C4885x995a0445;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreApiServiceModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreApiServiceModule_ProvidesApiServiceFactory;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreEducationalModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreUploadModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreViewModelModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory;
import com.yoti.mobile.android.liveness.p071di.module.LivenessFeatureConfigurationModule;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment_MembersInjector;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData_Factory_Factory;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel_Factory;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.liveness.view.educational.ILivenessEducationalViewConfiguration;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment_MembersInjector;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel_Factory;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorFragment;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorFragment_MembersInjector;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToSessionStatusMapper;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToSessionStatusMapper_Factory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewModel_Factory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragment;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragment_MembersInjector;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadViewModel;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadViewModel_Factory;
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
import com.yoti.mobile.android.remote.p075di.RemoteDebugModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesOkHttpClientFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesServiceLocationFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesSessionFactory;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus_Factory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusPreferencesFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusRepositoryFactory;
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
public final class DaggerLivenessCoreComponent implements LivenessCoreComponent {
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<BiometricConsentRepository> biometricConsentRepositoryProvider;
    private Provider<BiometricConsentViewModel> biometricConsentViewModelProvider;
    private Provider<CreateLivenessResourceInteractor> createLivenessResourceInteractorProvider;
    private Provider<BiometricConsentViewData.Factory> factoryProvider;
    private Provider<DeviceMetadata.Factory> factoryProvider2;
    private Provider<GiveBiometricConsentInteractor> giveBiometricConsentInteractorProvider;
    private Provider<GiveBiometricConsentService> giveBiometricConsentServiceProvider;
    private Provider<IcanhazipIpRemoteDataSource> icanhazipIpRemoteDataSourceProvider;
    private Provider<IpRepository> ipRepositoryProvider;
    private Provider<IpifyIpRemoteDataSource> ipifyIpRemoteDataSourceProvider;
    private final DaggerLivenessCoreComponent livenessCoreComponent;
    private final LivenessCoreEducationalModule livenessCoreEducationalModule;
    private final LivenessCoreUploadModule livenessCoreUploadModule;
    private Provider<LivenessEducationalViewModel> livenessEducationalViewModelProvider;
    private Provider<LivenessUploadErrorToSessionStatusMapper> livenessUploadErrorToSessionStatusMapperProvider;
    private Provider<LivenessUploadErrorViewModel> livenessUploadErrorViewModelProvider;
    private Provider<LivenessUploadViewModel> livenessUploadViewModelProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MetadataInterceptor> metadataInterceptorProvider;
    private Provider<TypedInterceptor> provideAuthInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideLoggingInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideMetadataInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideSessionInterceptor$remote_productionReleaseProvider;
    private Provider<LivenessCoreApiService> providesApiServiceProvider;
    private Provider<IBiometricConsentRepository> providesBiometricConsentRepositoryProvider;
    private Provider<ViewModel> providesBiometricConsentViewModelProvider;
    private Provider<Mapper<ILivenessCapture, ILivenessCaptureEntity>> providesCaptureToEntityMapperProvider;
    private Provider<ILivenessEducationalViewConfiguration> providesEducationalViewConfigurationProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<LivenessGuidelinesViewData.Factory<LivenessUploadFailureType>> providesGuidelinesViewDataFactoryProvider;
    private Provider<IcanhazipApi> providesIcanhazipApiService$remote_productionReleaseProvider;
    private Provider<IIpCacheDataSource> providesIpCacheDataSource$remote_productionReleaseProvider;
    private Provider<IIpRemoteDataSource> providesIpRemoteDataSource$remote_productionReleaseProvider;
    private Provider<IIpRepository> providesIpRepository$remote_productionReleaseProvider;
    private Provider<IpifyApi> providesIpifyApiService$remote_productionReleaseProvider;
    private Provider<ILivenessCaptureRepository<ILivenessCaptureEntity>> providesLivenessCaptureRepositoryProvider;
    private Provider<ViewModel> providesLivenessEducationalViewModelProvider;
    private Provider<LivenessFeatureConfiguration> providesLivenessFeatureConfigurationProvider;
    private Provider<ViewModel> providesLivenessUploadErrorViewModelProvider;
    private Provider<ViewModel> providesLivenessUploadViewModelProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<ILivenessResourceCreationRepository<ILivenessResourceEntity>> providesResourceCreationRepositoryProvider;
    private Provider<SavedStateViewModelFactory<LivenessUploadViewModel>> providesSavedStateViewModelFactoryForLivenessUploadProvider;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<Session> providesSessionProvider;
    private Provider<Mapper<Throwable, YdsFailure>> providesUploadErrorToFailureMapperProvider;
    private Provider<ViewModelProvider.Factory> providesViewModelFactoryProvider;
    private Provider<RemoteExceptionToEntityMapper> remoteExceptionToEntityMapperProvider;
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateHandleHolderViewModelFactoryProvider;
    private Provider<SessionIdInterceptor> sessionIdInterceptorProvider;
    private Provider<SharedPreferences> sessionStatusPreferencesProvider;
    private Provider<SessionStatus> sessionStatusProvider;
    private Provider<SessionStatusRepository> sessionStatusRepositoryProvider;
    private Provider<ISessionStatusRepository> sessionStatusRepositoryProvider2;
    private Provider<Set<TypedInterceptor>> setOfTypedInterceptorProvider;
    private Provider<TypedLoggingInterceptor> typedLoggingInterceptorProvider;
    private Provider<UploadLivenessCaptureInteractor> uploadLivenessCaptureInteractorProvider;
    private Provider<ViewModelFactory> viewModelFactoryProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private IpTrackingModule ipTrackingModule;
        private LivenessCoreApiServiceModule livenessCoreApiServiceModule;
        private LivenessCoreEducationalModule livenessCoreEducationalModule;
        private LivenessCoreUploadModule livenessCoreUploadModule;
        private LivenessCoreViewModelModule livenessCoreViewModelModule;
        private LivenessFeatureConfigurationModule livenessFeatureConfigurationModule;
        private RemoteModule remoteModule;
        private SessionStatusModule sessionStatusModule;

        public LivenessCoreComponent build() {
            Preconditions.checkBuilderRequirement(this.livenessCoreUploadModule, LivenessCoreUploadModule.class);
            Preconditions.checkBuilderRequirement(this.livenessFeatureConfigurationModule, LivenessFeatureConfigurationModule.class);
            if (this.livenessCoreViewModelModule == null) {
                this.livenessCoreViewModelModule = new LivenessCoreViewModelModule();
            }
            if (this.sessionStatusModule == null) {
                this.sessionStatusModule = new SessionStatusModule();
            }
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            Preconditions.checkBuilderRequirement(this.livenessCoreEducationalModule, LivenessCoreEducationalModule.class);
            if (this.livenessCoreApiServiceModule == null) {
                this.livenessCoreApiServiceModule = new LivenessCoreApiServiceModule();
            }
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.ipTrackingModule == null) {
                this.ipTrackingModule = new IpTrackingModule();
            }
            return new DaggerLivenessCoreComponent(this.livenessCoreUploadModule, this.livenessFeatureConfigurationModule, this.livenessCoreViewModelModule, this.sessionStatusModule, this.commonModule, this.livenessCoreEducationalModule, this.livenessCoreApiServiceModule, this.remoteModule, this.ipTrackingModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            this.ipTrackingModule = (IpTrackingModule) Preconditions.checkNotNull(ipTrackingModule);
            return this;
        }

        public Builder livenessCoreApiServiceModule(LivenessCoreApiServiceModule livenessCoreApiServiceModule) {
            this.livenessCoreApiServiceModule = (LivenessCoreApiServiceModule) Preconditions.checkNotNull(livenessCoreApiServiceModule);
            return this;
        }

        public Builder livenessCoreEducationalModule(LivenessCoreEducationalModule livenessCoreEducationalModule) {
            this.livenessCoreEducationalModule = (LivenessCoreEducationalModule) Preconditions.checkNotNull(livenessCoreEducationalModule);
            return this;
        }

        public Builder livenessCoreUploadModule(LivenessCoreUploadModule livenessCoreUploadModule) {
            this.livenessCoreUploadModule = (LivenessCoreUploadModule) Preconditions.checkNotNull(livenessCoreUploadModule);
            return this;
        }

        public Builder livenessCoreViewModelModule(LivenessCoreViewModelModule livenessCoreViewModelModule) {
            this.livenessCoreViewModelModule = (LivenessCoreViewModelModule) Preconditions.checkNotNull(livenessCoreViewModelModule);
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

        @Deprecated
        public Builder schedulersModule(SchedulersModule schedulersModule) {
            Preconditions.checkNotNull(schedulersModule);
            return this;
        }

        public Builder sessionStatusModule(SessionStatusModule sessionStatusModule) {
            this.sessionStatusModule = (SessionStatusModule) Preconditions.checkNotNull(sessionStatusModule);
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(LivenessCoreUploadModule livenessCoreUploadModule, LivenessFeatureConfigurationModule livenessFeatureConfigurationModule, LivenessCoreViewModelModule livenessCoreViewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, LivenessCoreEducationalModule livenessCoreEducationalModule, LivenessCoreApiServiceModule livenessCoreApiServiceModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule) {
        C4885x995a0445 c4885x995a0445Create = C4885x995a0445.create(livenessFeatureConfigurationModule);
        this.providesLivenessFeatureConfigurationProvider = c4885x995a0445Create;
        this.factoryProvider = BiometricConsentViewData_Factory_Factory.create(c4885x995a0445Create);
        this.providesServiceLocationProvider = RemoteModule_ProvidesServiceLocationFactory.create(remoteModule);
        Provider<Context> provider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.applicationContextProvider = provider;
        ApiServiceFactory_Factory apiServiceFactory_FactoryCreate = ApiServiceFactory_Factory.create(this.providesServiceLocationProvider, provider);
        this.apiServiceFactoryProvider = apiServiceFactory_FactoryCreate;
        TypedLoggingInterceptor_Factory typedLoggingInterceptor_FactoryCreate = TypedLoggingInterceptor_Factory.create(apiServiceFactory_FactoryCreate);
        this.typedLoggingInterceptorProvider = typedLoggingInterceptor_FactoryCreate;
        this.provideLoggingInterceptor$remote_productionReleaseProvider = C4921x437bef6b.create(remoteModule, typedLoggingInterceptor_FactoryCreate);
        Provider<Session> provider2 = DoubleCheck.provider(RemoteModule_ProvidesSessionFactory.create(remoteModule));
        this.providesSessionProvider = provider2;
        SessionIdInterceptor_Factory sessionIdInterceptor_FactoryCreate = SessionIdInterceptor_Factory.create(provider2);
        this.sessionIdInterceptorProvider = sessionIdInterceptor_FactoryCreate;
        this.provideSessionInterceptor$remote_productionReleaseProvider = C4923xa107bd4.create(remoteModule, sessionIdInterceptor_FactoryCreate);
        Provider<Gson> provider3 = DoubleCheck.provider(RemoteModule_ProvidesGsonFactory.create(remoteModule, this.apiServiceFactoryProvider));
        this.providesGsonProvider = provider3;
        Provider<IpifyApi> provider4 = DoubleCheck.provider(C4919xbf389a5a.create(ipTrackingModule, provider3));
        this.providesIpifyApiService$remote_productionReleaseProvider = provider4;
        this.ipifyIpRemoteDataSourceProvider = IpifyIpRemoteDataSource_Factory.create(provider4);
        Provider<IcanhazipApi> provider5 = DoubleCheck.provider(C4915xdf915f86.create(ipTrackingModule, this.providesGsonProvider));
        this.providesIcanhazipApiService$remote_productionReleaseProvider = provider5;
        IcanhazipIpRemoteDataSource_Factory icanhazipIpRemoteDataSource_FactoryCreate = IcanhazipIpRemoteDataSource_Factory.create(provider5);
        this.icanhazipIpRemoteDataSourceProvider = icanhazipIpRemoteDataSource_FactoryCreate;
        this.providesIpRemoteDataSource$remote_productionReleaseProvider = C4917x1a4ffbca.create(ipTrackingModule, this.ipifyIpRemoteDataSourceProvider, icanhazipIpRemoteDataSource_FactoryCreate);
        C4916xc9de3fea c4916xc9de3feaCreate = C4916xc9de3fea.create(ipTrackingModule);
        this.providesIpCacheDataSource$remote_productionReleaseProvider = c4916xc9de3feaCreate;
        IpRepository_Factory ipRepository_FactoryCreate = IpRepository_Factory.create(this.providesIpRemoteDataSource$remote_productionReleaseProvider, c4916xc9de3feaCreate);
        this.ipRepositoryProvider = ipRepository_FactoryCreate;
        C4918x4d860449 c4918x4d860449Create = C4918x4d860449.create(ipTrackingModule, ipRepository_FactoryCreate);
        this.providesIpRepository$remote_productionReleaseProvider = c4918x4d860449Create;
        DeviceMetadata_Factory_Factory deviceMetadata_Factory_FactoryCreate = DeviceMetadata_Factory_Factory.create(this.providesSessionProvider, c4918x4d860449Create);
        this.factoryProvider2 = deviceMetadata_Factory_FactoryCreate;
        MetadataInterceptor_Factory metadataInterceptor_FactoryCreate = MetadataInterceptor_Factory.create(deviceMetadata_Factory_FactoryCreate);
        this.metadataInterceptorProvider = metadataInterceptor_FactoryCreate;
        this.provideMetadataInterceptor$remote_productionReleaseProvider = C4922x94372e73.create(remoteModule, metadataInterceptor_FactoryCreate);
        this.provideAuthInterceptor$remote_productionReleaseProvider = C4920x3eb9105a.create(remoteModule, this.apiServiceFactoryProvider, this.providesSessionProvider);
        SetFactory setFactoryBuild = SetFactory.builder(4, 0).addProvider(this.provideLoggingInterceptor$remote_productionReleaseProvider).addProvider(this.provideSessionInterceptor$remote_productionReleaseProvider).addProvider(this.provideMetadataInterceptor$remote_productionReleaseProvider).addProvider(this.provideAuthInterceptor$remote_productionReleaseProvider).build();
        this.setOfTypedInterceptorProvider = setFactoryBuild;
        Provider<OkHttpClient> provider6 = DoubleCheck.provider(RemoteModule_ProvidesOkHttpClientFactory.create(remoteModule, this.apiServiceFactoryProvider, setFactoryBuild));
        this.providesOkHttpClientProvider = provider6;
        LivenessCoreApiServiceModule_ProvidesApiServiceFactory livenessCoreApiServiceModule_ProvidesApiServiceFactoryCreate = LivenessCoreApiServiceModule_ProvidesApiServiceFactory.create(livenessCoreApiServiceModule, this.apiServiceFactoryProvider, provider6, this.providesGsonProvider);
        this.providesApiServiceProvider = livenessCoreApiServiceModule_ProvidesApiServiceFactoryCreate;
        this.giveBiometricConsentServiceProvider = GiveBiometricConsentService_Factory.create(livenessCoreApiServiceModule_ProvidesApiServiceFactoryCreate);
        RemoteExceptionToEntityMapper_Factory remoteExceptionToEntityMapper_FactoryCreate = RemoteExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        this.remoteExceptionToEntityMapperProvider = remoteExceptionToEntityMapper_FactoryCreate;
        BiometricConsentRepository_Factory biometricConsentRepository_FactoryCreate = BiometricConsentRepository_Factory.create(this.giveBiometricConsentServiceProvider, remoteExceptionToEntityMapper_FactoryCreate);
        this.biometricConsentRepositoryProvider = biometricConsentRepository_FactoryCreate;
        C4873x16c9cf2a c4873x16c9cf2aCreate = C4873x16c9cf2a.create(livenessCoreEducationalModule, biometricConsentRepository_FactoryCreate);
        this.providesBiometricConsentRepositoryProvider = c4873x16c9cf2aCreate;
        this.giveBiometricConsentInteractorProvider = GiveBiometricConsentInteractor_Factory.create(c4873x16c9cf2aCreate);
        SessionStatusModule_SessionStatusPreferencesFactory sessionStatusModule_SessionStatusPreferencesFactoryCreate = SessionStatusModule_SessionStatusPreferencesFactory.create(sessionStatusModule, this.applicationContextProvider);
        this.sessionStatusPreferencesProvider = sessionStatusModule_SessionStatusPreferencesFactoryCreate;
        SessionStatusRepository_Factory sessionStatusRepository_FactoryCreate = SessionStatusRepository_Factory.create(sessionStatusModule_SessionStatusPreferencesFactoryCreate);
        this.sessionStatusRepositoryProvider = sessionStatusRepository_FactoryCreate;
        SessionStatusModule_SessionStatusRepositoryFactory sessionStatusModule_SessionStatusRepositoryFactoryCreate = SessionStatusModule_SessionStatusRepositoryFactory.create(sessionStatusModule, sessionStatusRepository_FactoryCreate);
        this.sessionStatusRepositoryProvider2 = sessionStatusModule_SessionStatusRepositoryFactoryCreate;
        SessionStatus_Factory sessionStatus_FactoryCreate = SessionStatus_Factory.create(sessionStatusModule_SessionStatusRepositoryFactoryCreate);
        this.sessionStatusProvider = sessionStatus_FactoryCreate;
        BiometricConsentViewModel_Factory biometricConsentViewModel_FactoryCreate = BiometricConsentViewModel_Factory.create(this.providesLivenessFeatureConfigurationProvider, this.factoryProvider, this.giveBiometricConsentInteractorProvider, sessionStatus_FactoryCreate, ExceptionToFailureMapper_Factory.create(), ErrorToSessionStatusTypeMapper_Factory.create());
        this.biometricConsentViewModelProvider = biometricConsentViewModel_FactoryCreate;
        this.providesBiometricConsentViewModelProvider = C4880xa9a0018b.create(livenessCoreViewModelModule, biometricConsentViewModel_FactoryCreate);
        this.providesEducationalViewConfigurationProvider = C4875x6bffa058.create(livenessCoreEducationalModule);
        C4877x599c81bf c4877x599c81bfCreate = C4877x599c81bf.create(livenessCoreEducationalModule);
        this.providesResourceCreationRepositoryProvider = c4877x599c81bfCreate;
        CreateLivenessResourceInteractor_Factory createLivenessResourceInteractor_FactoryCreate = CreateLivenessResourceInteractor_Factory.create(c4877x599c81bfCreate);
        this.createLivenessResourceInteractorProvider = createLivenessResourceInteractor_FactoryCreate;
        LivenessEducationalViewModel_Factory livenessEducationalViewModel_FactoryCreate = LivenessEducationalViewModel_Factory.create(this.providesEducationalViewConfigurationProvider, createLivenessResourceInteractor_FactoryCreate, this.sessionStatusProvider, ExceptionToFailureMapper_Factory.create(), ErrorToSessionStatusTypeMapper_Factory.create(), this.providesLivenessFeatureConfigurationProvider);
        this.livenessEducationalViewModelProvider = livenessEducationalViewModel_FactoryCreate;
        this.providesLivenessEducationalViewModelProvider = C4881x981a7273.create(livenessCoreViewModelModule, livenessEducationalViewModel_FactoryCreate);
        C4878xcb53dbff c4878xcb53dbffCreate = C4878xcb53dbff.create(livenessCoreUploadModule);
        this.providesLivenessCaptureRepositoryProvider = c4878xcb53dbffCreate;
        this.uploadLivenessCaptureInteractorProvider = UploadLivenessCaptureInteractor_Factory.create(c4878xcb53dbffCreate);
        this.providesCaptureToEntityMapperProvider = LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory.create(livenessCoreUploadModule);
        this.livenessUploadErrorToSessionStatusMapperProvider = LivenessUploadErrorToSessionStatusMapper_Factory.create(ErrorToSessionStatusTypeMapper_Factory.create());
        C4879xca9022ff c4879xca9022ffCreate = C4879xca9022ff.create(livenessCoreUploadModule);
        this.providesUploadErrorToFailureMapperProvider = c4879xca9022ffCreate;
        LivenessUploadViewModel_Factory livenessUploadViewModel_FactoryCreate = LivenessUploadViewModel_Factory.create(this.uploadLivenessCaptureInteractorProvider, this.providesCaptureToEntityMapperProvider, this.sessionStatusProvider, this.livenessUploadErrorToSessionStatusMapperProvider, c4879xca9022ffCreate);
        this.livenessUploadViewModelProvider = livenessUploadViewModel_FactoryCreate;
        this.providesLivenessUploadViewModelProvider = C4883x5519472d.create(livenessCoreViewModelModule, livenessUploadViewModel_FactoryCreate);
        C4876x39f50d66 c4876x39f50d66Create = C4876x39f50d66.create(livenessCoreEducationalModule);
        this.providesGuidelinesViewDataFactoryProvider = c4876x39f50d66Create;
        LivenessUploadErrorViewModel_Factory livenessUploadErrorViewModel_FactoryCreate = LivenessUploadErrorViewModel_Factory.create(c4876x39f50d66Create);
        this.livenessUploadErrorViewModelProvider = livenessUploadErrorViewModel_FactoryCreate;
        this.providesLivenessUploadErrorViewModelProvider = C4882xd161cd27.create(livenessCoreViewModelModule, livenessUploadErrorViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(4).put(BiometricConsentViewModel.class, (Provider) this.providesBiometricConsentViewModelProvider).put(LivenessEducationalViewModel.class, (Provider) this.providesLivenessEducationalViewModelProvider).put(LivenessUploadViewModel.class, (Provider) this.providesLivenessUploadViewModelProvider).put(LivenessUploadErrorViewModel.class, (Provider) this.providesLivenessUploadErrorViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<ViewModelFactory> provider7 = DoubleCheck.provider(ViewModelFactory_Factory.create(mapProviderFactoryBuild));
        this.viewModelFactoryProvider = provider7;
        this.providesViewModelFactoryProvider = DoubleCheck.provider(LivenessCoreViewModelModule_ProvidesViewModelFactoryFactory.create(livenessCoreViewModelModule, provider7));
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider8 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(this.mapOfClassOfAndProviderOfViewModelProvider));
        this.savedStateHandleHolderViewModelFactoryProvider = provider8;
        this.providesSavedStateViewModelFactoryForLivenessUploadProvider = DoubleCheck.provider(C4884xfdfab2f0.create(livenessCoreViewModelModule, provider8));
    }

    private BiometricConsentFragment injectBiometricConsentFragment(BiometricConsentFragment biometricConsentFragment) {
        BiometricConsentFragment_MembersInjector.injectViewModelFactory(biometricConsentFragment, this.providesViewModelFactoryProvider.get());
        return biometricConsentFragment;
    }

    private LivenessEducationalFragment injectLivenessEducationalFragment(LivenessEducationalFragment livenessEducationalFragment) {
        LivenessEducationalFragment_MembersInjector.injectNavigatorProvider(livenessEducationalFragment, C4874xf32f1961.providesEducationalNavigatorProvider(this.livenessCoreEducationalModule));
        LivenessEducationalFragment_MembersInjector.injectViewModelFactory(livenessEducationalFragment, this.providesViewModelFactoryProvider.get());
        return livenessEducationalFragment;
    }

    private LivenessUploadErrorFragment injectLivenessUploadErrorFragment(LivenessUploadErrorFragment livenessUploadErrorFragment) {
        LivenessUploadErrorFragment_MembersInjector.injectViewModelFactory(livenessUploadErrorFragment, this.providesViewModelFactoryProvider.get());
        return livenessUploadErrorFragment;
    }

    private LivenessUploadFragment injectLivenessUploadFragment(LivenessUploadFragment livenessUploadFragment) {
        LivenessUploadFragment_MembersInjector.injectViewModelFactory(livenessUploadFragment, this.providesSavedStateViewModelFactoryForLivenessUploadProvider.get());
        LivenessUploadFragment_MembersInjector.injectUploadNavigatorProvider(livenessUploadFragment, LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory.providesUploadNavigatorProvider(this.livenessCoreUploadModule));
        return livenessUploadFragment;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.LivenessCoreComponent
    public void inject(BiometricConsentFragment biometricConsentFragment) {
        injectBiometricConsentFragment(biometricConsentFragment);
    }

    private DaggerLivenessCoreComponent(LivenessCoreUploadModule livenessCoreUploadModule, LivenessFeatureConfigurationModule livenessFeatureConfigurationModule, LivenessCoreViewModelModule livenessCoreViewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, LivenessCoreEducationalModule livenessCoreEducationalModule, LivenessCoreApiServiceModule livenessCoreApiServiceModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule) {
        this.livenessCoreComponent = this;
        this.livenessCoreEducationalModule = livenessCoreEducationalModule;
        this.livenessCoreUploadModule = livenessCoreUploadModule;
        initialize(livenessCoreUploadModule, livenessFeatureConfigurationModule, livenessCoreViewModelModule, sessionStatusModule, commonModule, livenessCoreEducationalModule, livenessCoreApiServiceModule, remoteModule, ipTrackingModule);
    }

    @Override // com.yoti.mobile.android.liveness.p071di.LivenessCoreComponent
    public void inject(LivenessEducationalFragment livenessEducationalFragment) {
        injectLivenessEducationalFragment(livenessEducationalFragment);
    }

    @Override // com.yoti.mobile.android.liveness.p071di.LivenessCoreComponent
    public void inject(LivenessUploadFragment livenessUploadFragment) {
        injectLivenessUploadFragment(livenessUploadFragment);
    }

    @Override // com.yoti.mobile.android.liveness.p071di.LivenessCoreComponent
    public void inject(LivenessUploadErrorFragment livenessUploadErrorFragment) {
        injectLivenessUploadErrorFragment(livenessUploadErrorFragment);
    }
}
