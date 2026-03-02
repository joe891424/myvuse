package com.yoti.mobile.android.documentcapture.sup.p057di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentRepository;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigDataToEntityMapper_Factory;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository_Factory;
import com.yoti.mobile.android.documentcapture.sup.data.cache.SupDocumentScanConfigurationCacheDataSource;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentScanConfigurationService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentScanConfigurationService_Factory;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentUploadService;
import com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator;
import com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator_Factory;
import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.domain.SupDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentCaptureActivity;
import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentCaptureActivity_MembersInjector;
import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.sup.view.navigation.SupDocumentScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.sup.view.navigation.SupDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.review.PageNumberIndicatorFormatter_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfRendererFactory;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfRendererFactory_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.scan.DocumentGuidelinesFragment;
import com.yoti.mobile.android.documentcapture.sup.view.scan.DocumentGuidelinesFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.IntentChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentFileProvider;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanConfigEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanConfigEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel_Factory;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationCaptureActivity;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationCaptureActivity_MembersInjector;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationSupDocFileUriProvider;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.sup.view.selection.SupDocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.sup.view.upload.SupDocumentViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.sup.view.upload.UploadErrorToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory_Factory;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.remote.MimeTypeProvider_Factory;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
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
import com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase;
import com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase_Factory;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_ComputationCoroutineContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_IoCoroutineContextFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4978x27c318a2;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4980x2a61395e;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesLocalisedCountriesProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule_ProvidesRequirementIdFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.AssessmentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes5.dex */
public final class DaggerSupDocumentCaptureComponent implements SupDocumentCaptureComponent {
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<BitmapRotateUseCase> bitmapRotateUseCaseProvider;
    private Provider<CaptureToBitmapTransformerFactory> captureToBitmapTransformerFactoryProvider;
    private Provider<DocumentReviewViewModel> documentReviewViewModelProvider;
    private Provider<DeviceMetadata.Factory> factoryProvider;
    private Provider<FileSizeValidator> fileSizeValidatorProvider;
    private Provider<IcanhazipIpRemoteDataSource> icanhazipIpRemoteDataSourceProvider;
    private Provider<IpRepository> ipRepositoryProvider;
    private Provider<IpifyIpRemoteDataSource> ipifyIpRemoteDataSourceProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MetadataInterceptor> metadataInterceptorProvider;
    private Provider<MimeTypeProvider> mimeTypeProvider;
    private Provider<PdfRendererFactory> pdfRendererFactoryProvider;
    private Provider<TypedInterceptor> provideAuthInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideLoggingInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideMetadataInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideSessionInterceptor$remote_productionReleaseProvider;
    private Provider<SupDocumentCaptureApiService> providesApiServiceProvider;

    /* JADX INFO: renamed from: providesConfigurationPreferences$yoti_sdk_core_productionReleaseProvider */
    private Provider<SharedPreferences> f6821xc1606568;
    private Provider<ViewModel> providesDocumentReviewViewModelProvider;
    private Provider<DocumentCaptureConfiguration> providesFeatureConfigurationProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<IcanhazipApi> providesIcanhazipApiService$remote_productionReleaseProvider;
    private Provider<IIpCacheDataSource> providesIpCacheDataSource$remote_productionReleaseProvider;
    private Provider<IIpRemoteDataSource> providesIpRemoteDataSource$remote_productionReleaseProvider;
    private Provider<IIpRepository> providesIpRepository$remote_productionReleaseProvider;
    private Provider<IpifyApi> providesIpifyApiService$remote_productionReleaseProvider;
    private Provider<LocalisedCountriesProvider> providesLocalisedCountriesProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<String> providesRequirementIdProvider;
    private Provider<IResourceConfigurationCacheDataStore> providesResourceConfigurationDataStoreProvider;
    private Provider<SavedStateViewModelFactory<DocumentReviewViewModel>> providesSavedStateViewModelFactoryForDocumentReviewProvider;
    private Provider<SavedStateViewModelFactory<SupDocumentScanViewModel>> providesSavedStateViewModelFactoryForDocumentScanProvider;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<Session> providesSessionProvider;
    private Provider<SupDocumentScanConfigurationCacheDataSource> providesSupDocumentScanConfigurationCacheDataSourceProvider;
    private Provider<ISupDocumentScanConfigurationRepository> providesSupDocumentScanConfigurationRepositoryProvider;
    private Provider<ViewModel> providesSupDocumentScanViewModelProvider;
    private Provider<RemoteExceptionToEntityMapper> remoteExceptionToEntityMapperProvider;
    private Provider<ResourceConfigurationCacheDataStore> resourceConfigurationCacheDataStoreProvider;
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateHandleHolderViewModelFactoryProvider;
    private Provider<SessionIdInterceptor> sessionIdInterceptorProvider;
    private Provider<Set<TypedInterceptor>> setOfTypedInterceptorProvider;
    private final DaggerSupDocumentCaptureComponent supDocumentCaptureComponent;
    private final SupDocumentCaptureModule supDocumentCaptureModule;
    private Provider<SupDocumentScanConfigDataToEntityMapper> supDocumentScanConfigDataToEntityMapperProvider;
    private Provider<SupDocumentScanConfigEntityToViewDataMapper> supDocumentScanConfigEntityToViewDataMapperProvider;
    private Provider<SupDocumentScanConfigurationRepository> supDocumentScanConfigurationRepositoryProvider;
    private Provider<SupDocumentScanConfigurationService> supDocumentScanConfigurationServiceProvider;
    private Provider<SupDocumentScanViewModel> supDocumentScanViewModelProvider;
    private Provider<TypedLoggingInterceptor> typedLoggingInterceptorProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private CountryHelperModule countryHelperModule;
        private IpTrackingModule ipTrackingModule;
        private RemoteModule remoteModule;
        private ResourceConfigurationModule resourceConfigurationModule;
        private SupDocumentCaptureModule supDocumentCaptureModule;
        private SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule;

        public SupDocumentCaptureComponent build() {
            Preconditions.checkBuilderRequirement(this.supDocumentCaptureModule, SupDocumentCaptureModule.class);
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.ipTrackingModule == null) {
                this.ipTrackingModule = new IpTrackingModule();
            }
            Preconditions.checkBuilderRequirement(this.resourceConfigurationModule, ResourceConfigurationModule.class);
            Preconditions.checkBuilderRequirement(this.countryHelperModule, CountryHelperModule.class);
            if (this.supDocumentCaptureViewModelModule == null) {
                this.supDocumentCaptureViewModelModule = new SupDocumentCaptureViewModelModule();
            }
            return new DaggerSupDocumentCaptureComponent(this.supDocumentCaptureModule, this.commonModule, this.remoteModule, this.ipTrackingModule, this.resourceConfigurationModule, this.countryHelperModule, this.supDocumentCaptureViewModelModule);
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

        public Builder countryHelperModule(CountryHelperModule countryHelperModule) {
            this.countryHelperModule = (CountryHelperModule) Preconditions.checkNotNull(countryHelperModule);
            return this;
        }

        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            this.ipTrackingModule = (IpTrackingModule) Preconditions.checkNotNull(ipTrackingModule);
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
        public Builder supDocumentCaptureApiServiceModule(SupDocumentCaptureApiServiceModule supDocumentCaptureApiServiceModule) {
            Preconditions.checkNotNull(supDocumentCaptureApiServiceModule);
            return this;
        }

        public Builder supDocumentCaptureModule(SupDocumentCaptureModule supDocumentCaptureModule) {
            this.supDocumentCaptureModule = (SupDocumentCaptureModule) Preconditions.checkNotNull(supDocumentCaptureModule);
            return this;
        }

        public Builder supDocumentCaptureViewModelModule(SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule) {
            this.supDocumentCaptureViewModelModule = (SupDocumentCaptureViewModelModule) Preconditions.checkNotNull(supDocumentCaptureViewModelModule);
            return this;
        }

        private Builder() {
        }
    }

    private AssessmentEntityToAssessmentResultMapper assessmentEntityToAssessmentResultMapper() {
        return new AssessmentEntityToAssessmentResultMapper(new AssessmentTypeEntityToDataMapper());
    }

    private AssetToFileConverter assetToFileConverter() {
        return new AssetToFileConverter(this.applicationContextProvider.get());
    }

    private AutomationChooser automationChooser() {
        return new AutomationChooser(automationSupDocFileUriProvider());
    }

    private AutomationSupDocFileUriProvider automationSupDocFileUriProvider() {
        return new AutomationSupDocFileUriProvider(assetToFileConverter());
    }

    public static Builder builder() {
        return new Builder();
    }

    private CountryEntityToViewDataMapper countryEntityToViewDataMapper() {
        return new CountryEntityToViewDataMapper(this.providesLocalisedCountriesProvider.get(), new DocumentTypeEntityToViewDataMapper());
    }

    private DocumentCaptureCoreSession documentCaptureCoreSession() {
        return new DocumentCaptureCoreSession(this.applicationContextProvider.get(), iDocumentSelectionDependenciesProvider(), iDocumentScanDependenciesProvider(), iDocumentUploadDependenciesProvider(), SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.providesFeatureConfiguration(this.supDocumentCaptureModule));
    }

    private DocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper() {
        return new DocumentFeatureErrorToFailureMapper(new ExceptionToFailureMapper());
    }

    private DocumentStartDestinationResolver documentStartDestinationResolver() {
        return new DocumentStartDestinationResolver(SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.providesFeatureConfiguration(this.supDocumentCaptureModule));
    }

    private ICaptureChooser iCaptureChooser() {
        return SupDocumentCaptureModule_ProvidesCaptureChooserFactory.providesCaptureChooser(this.supDocumentCaptureModule, intentChooser(), automationChooser());
    }

    private IDocumentScanDependenciesProvider iDocumentScanDependenciesProvider() {
        return C4658x45b92ccc.providesCoreScanDependenciesProvider(this.supDocumentCaptureModule, nonIdDocumentScanDependenciesProvider());
    }

    private IDocumentSelectionDependenciesProvider iDocumentSelectionDependenciesProvider() {
        return C4659x2d035fcb.providesCoreSelectionDependenciesProvider(this.supDocumentCaptureModule, supplementaryDocumentSelectionDependenciesProvider());
    }

    private IDocumentUploadDependenciesProvider iDocumentUploadDependenciesProvider() {
        return C4660xc23b088.providesCoreUploadDependenciesProvider(this.supDocumentCaptureModule, nonIdDocumentUploadDependenciesProvider());
    }

    private void initialize(SupDocumentCaptureModule supDocumentCaptureModule, CommonModule commonModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, ResourceConfigurationModule resourceConfigurationModule, CountryHelperModule countryHelperModule, SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule) {
        this.applicationContextProvider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.providesLocalisedCountriesProvider = DoubleCheck.provider(CountryHelperModule_ProvidesLocalisedCountriesProviderFactory.create(countryHelperModule));
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
        this.providesApiServiceProvider = DoubleCheck.provider(SupDocumentCaptureApiServiceModule_ProvidesApiServiceFactory.create(this.apiServiceFactoryProvider, provider5, this.providesGsonProvider));
        this.providesRequirementIdProvider = DoubleCheck.provider(ResourceConfigurationModule_ProvidesRequirementIdFactory.create(resourceConfigurationModule));
        Provider<SharedPreferences> provider6 = DoubleCheck.provider(C4978x27c318a2.create(resourceConfigurationModule));
        this.f6821xc1606568 = provider6;
        ResourceConfigurationCacheDataStore_Factory resourceConfigurationCacheDataStore_FactoryCreate = ResourceConfigurationCacheDataStore_Factory.create(provider6, this.providesRequirementIdProvider, this.providesGsonProvider);
        this.resourceConfigurationCacheDataStoreProvider = resourceConfigurationCacheDataStore_FactoryCreate;
        this.providesResourceConfigurationDataStoreProvider = DoubleCheck.provider(C4980x2a61395e.create(resourceConfigurationModule, resourceConfigurationCacheDataStore_FactoryCreate));
        this.fileSizeValidatorProvider = FileSizeValidator_Factory.create(this.applicationContextProvider, CoroutineContextModule_IoCoroutineContextFactory.create());
        this.pdfRendererFactoryProvider = PdfRendererFactory_Factory.create(this.applicationContextProvider);
        MimeTypeProvider_Factory mimeTypeProvider_FactoryCreate = MimeTypeProvider_Factory.create(this.applicationContextProvider);
        this.mimeTypeProvider = mimeTypeProvider_FactoryCreate;
        this.captureToBitmapTransformerFactoryProvider = CaptureToBitmapTransformerFactory_Factory.create(this.applicationContextProvider, this.pdfRendererFactoryProvider, mimeTypeProvider_FactoryCreate, CoroutineContextModule_IoCoroutineContextFactory.create());
        BitmapRotateUseCase_Factory bitmapRotateUseCase_FactoryCreate = BitmapRotateUseCase_Factory.create(CoroutineContextModule_ComputationCoroutineContextFactory.create());
        this.bitmapRotateUseCaseProvider = bitmapRotateUseCase_FactoryCreate;
        DocumentReviewViewModel_Factory documentReviewViewModel_FactoryCreate = DocumentReviewViewModel_Factory.create(this.fileSizeValidatorProvider, this.captureToBitmapTransformerFactoryProvider, bitmapRotateUseCase_FactoryCreate, ExceptionToFailureMapper_Factory.create(), PageNumberIndicatorFormatter_Factory.create());
        this.documentReviewViewModelProvider = documentReviewViewModel_FactoryCreate;
        this.providesDocumentReviewViewModelProvider = C4663xb78e2817.create(supDocumentCaptureViewModelModule, documentReviewViewModel_FactoryCreate);
        this.providesFeatureConfigurationProvider = SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.create(supDocumentCaptureModule);
        this.supDocumentScanConfigurationServiceProvider = SupDocumentScanConfigurationService_Factory.create(this.providesApiServiceProvider);
        this.providesSupDocumentScanConfigurationCacheDataSourceProvider = C4661xab7d6ddb.create(supDocumentCaptureModule);
        this.supDocumentScanConfigDataToEntityMapperProvider = SupDocumentScanConfigDataToEntityMapper_Factory.create(DocumentTypeDataToEntityMapper_Factory.create());
        this.remoteExceptionToEntityMapperProvider = RemoteExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        SupDocumentScanConfigurationRepository_Factory supDocumentScanConfigurationRepository_FactoryCreate = SupDocumentScanConfigurationRepository_Factory.create(this.supDocumentScanConfigurationServiceProvider, this.providesSupDocumentScanConfigurationCacheDataSourceProvider, this.providesRequirementIdProvider, this.supDocumentScanConfigDataToEntityMapperProvider, DocumentTypeEntityToDataMapper_Factory.create(), this.remoteExceptionToEntityMapperProvider);
        this.supDocumentScanConfigurationRepositoryProvider = supDocumentScanConfigurationRepository_FactoryCreate;
        this.providesSupDocumentScanConfigurationRepositoryProvider = C4662x901b2708.create(supDocumentCaptureModule, supDocumentScanConfigurationRepository_FactoryCreate);
        SupDocumentScanConfigEntityToViewDataMapper_Factory supDocumentScanConfigEntityToViewDataMapper_FactoryCreate = SupDocumentScanConfigEntityToViewDataMapper_Factory.create(DocumentTypeEntityToViewDataMapper_Factory.create());
        this.supDocumentScanConfigEntityToViewDataMapperProvider = supDocumentScanConfigEntityToViewDataMapper_FactoryCreate;
        SupDocumentScanViewModel_Factory supDocumentScanViewModel_FactoryCreate = SupDocumentScanViewModel_Factory.create(this.providesFeatureConfigurationProvider, this.providesSupDocumentScanConfigurationRepositoryProvider, supDocumentScanConfigEntityToViewDataMapper_FactoryCreate);
        this.supDocumentScanViewModelProvider = supDocumentScanViewModel_FactoryCreate;
        this.providesSupDocumentScanViewModelProvider = C4666x6e167ae.create(supDocumentCaptureViewModelModule, supDocumentScanViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(2).put(DocumentReviewViewModel.class, (Provider) this.providesDocumentReviewViewModelProvider).put(SupDocumentScanViewModel.class, (Provider) this.providesSupDocumentScanViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider7 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(mapProviderFactoryBuild));
        this.savedStateHandleHolderViewModelFactoryProvider = provider7;
        this.providesSavedStateViewModelFactoryForDocumentScanProvider = DoubleCheck.provider(C4665xa79644d7.create(supDocumentCaptureViewModelModule, provider7));
        this.providesSavedStateViewModelFactoryForDocumentReviewProvider = DoubleCheck.provider(C4664x6fc65d1c.create(supDocumentCaptureViewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
    }

    private AutomationCaptureActivity injectAutomationCaptureActivity(AutomationCaptureActivity automationCaptureActivity) {
        AutomationCaptureActivity_MembersInjector.injectSupDocFileUriProvider(automationCaptureActivity, automationSupDocFileUriProvider());
        return automationCaptureActivity;
    }

    private DocumentGuidelinesFragment injectDocumentGuidelinesFragment(DocumentGuidelinesFragment documentGuidelinesFragment) {
        DocumentGuidelinesFragment_MembersInjector.injectViewModelFactory(documentGuidelinesFragment, this.providesSavedStateViewModelFactoryForDocumentScanProvider.get());
        return documentGuidelinesFragment;
    }

    private DocumentReviewFragment injectDocumentReviewFragment(DocumentReviewFragment documentReviewFragment) {
        DocumentReviewFragment_MembersInjector.injectViewModelFactory(documentReviewFragment, this.providesSavedStateViewModelFactoryForDocumentReviewProvider.get());
        return documentReviewFragment;
    }

    private SupDocumentCaptureActivity injectSupDocumentCaptureActivity(SupDocumentCaptureActivity supDocumentCaptureActivity) {
        SupDocumentCaptureActivity_MembersInjector.injectStartDestinationResolver(supDocumentCaptureActivity, documentStartDestinationResolver());
        SupDocumentCaptureActivity_MembersInjector.injectViewModelFactory(supDocumentCaptureActivity, this.providesSavedStateViewModelFactoryForDocumentScanProvider.get());
        SupDocumentCaptureActivity_MembersInjector.injectCaptureChooser(supDocumentCaptureActivity, iCaptureChooser());
        return supDocumentCaptureActivity;
    }

    private SupDocumentCaptureSession injectSupDocumentCaptureSession(SupDocumentCaptureSession supDocumentCaptureSession) {
        SupDocumentCaptureSession_MembersInjector.injectCoreSession(supDocumentCaptureSession, documentCaptureCoreSession());
        return supDocumentCaptureSession;
    }

    private IntentChooser intentChooser() {
        return new IntentChooser(new SupDocumentFileProvider(), SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.providesFeatureConfiguration(this.supDocumentCaptureModule));
    }

    private MimeTypeProvider mimeTypeProvider() {
        return new MimeTypeProvider(this.applicationContextProvider.get());
    }

    private MultiPartBodyFactory multiPartBodyFactory() {
        return new MultiPartBodyFactory(this.applicationContextProvider.get(), mimeTypeProvider());
    }

    private NonIdDocumentScanDependenciesProvider nonIdDocumentScanDependenciesProvider() {
        return new NonIdDocumentScanDependenciesProvider(supDocumentScanNavigatorProvider(), supDocumentScanConfigurationRepository(), supDocumentScanConfigEntityToViewDataMapper());
    }

    private NonIdDocumentUploadDependenciesProvider nonIdDocumentUploadDependenciesProvider() {
        return new NonIdDocumentUploadDependenciesProvider(supDocumentUploadNavigatorProvider(), supDocumentRepository(), supDocumentViewDataToEntityMapper(), uploadErrorToViewDataMapper(), supDocumentCleanupInteractor());
    }

    private RemoteExceptionToEntityMapper remoteExceptionToEntityMapper() {
        return new RemoteExceptionToEntityMapper(this.providesGsonProvider.get());
    }

    private SupDocumentCleanupInteractor supDocumentCleanupInteractor() {
        return new SupDocumentCleanupInteractor(this.applicationContextProvider.get(), new SupDocumentFileProvider(), CoroutineContextModule_IoCoroutineContextFactory.ioCoroutineContext());
    }

    private SupDocumentConfigToDocSelectionViewDataMapper supDocumentConfigToDocSelectionViewDataMapper() {
        return new SupDocumentConfigToDocSelectionViewDataMapper(countryEntityToViewDataMapper(), new CaptureObjectiveTypeEntityToViewDataMapper());
    }

    private SupDocumentEducationalArgumentsToViewDataMapper supDocumentEducationalArgumentsToViewDataMapper() {
        return new SupDocumentEducationalArgumentsToViewDataMapper(this.providesLocalisedCountriesProvider.get());
    }

    private SupDocumentEntityToDataMapper supDocumentEntityToDataMapper() {
        return new SupDocumentEntityToDataMapper(new DocumentTypeEntityToDataMapper());
    }

    private SupDocumentFeatureErrorToFailureMapper supDocumentFeatureErrorToFailureMapper() {
        return new SupDocumentFeatureErrorToFailureMapper(documentFeatureErrorToFailureMapper());
    }

    private SupDocumentRepository supDocumentRepository() {
        return new SupDocumentRepository(supDocumentUploadService(), this.providesApiServiceProvider.get(), this.providesResourceConfigurationDataStoreProvider.get(), supDocumentEntityToDataMapper(), assessmentEntityToAssessmentResultMapper(), remoteExceptionToEntityMapper());
    }

    private SupDocumentScanConfigDataToEntityMapper supDocumentScanConfigDataToEntityMapper() {
        return new SupDocumentScanConfigDataToEntityMapper(new DocumentTypeDataToEntityMapper());
    }

    private SupDocumentScanConfigEntityToViewDataMapper supDocumentScanConfigEntityToViewDataMapper() {
        return new SupDocumentScanConfigEntityToViewDataMapper(new DocumentTypeEntityToViewDataMapper());
    }

    private SupDocumentScanConfigurationRepository supDocumentScanConfigurationRepository() {
        return new SupDocumentScanConfigurationRepository(supDocumentScanConfigurationService(), C4661xab7d6ddb.providesSupDocumentScanConfigurationCacheDataSource(this.supDocumentCaptureModule), this.providesRequirementIdProvider.get(), supDocumentScanConfigDataToEntityMapper(), new DocumentTypeEntityToDataMapper(), remoteExceptionToEntityMapper());
    }

    private SupDocumentScanConfigurationService supDocumentScanConfigurationService() {
        return new SupDocumentScanConfigurationService(this.providesApiServiceProvider.get());
    }

    private SupDocumentScanNavigatorProvider supDocumentScanNavigatorProvider() {
        return new SupDocumentScanNavigatorProvider(SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.providesFeatureConfiguration(this.supDocumentCaptureModule));
    }

    private SupDocumentUploadNavigatorProvider supDocumentUploadNavigatorProvider() {
        return new SupDocumentUploadNavigatorProvider(SupDocumentCaptureModule_ProvidesFeatureConfigurationFactory.providesFeatureConfiguration(this.supDocumentCaptureModule));
    }

    private SupDocumentUploadService supDocumentUploadService() {
        return new SupDocumentUploadService(this.providesApiServiceProvider.get(), multiPartBodyFactory(), mimeTypeProvider());
    }

    private SupDocumentViewDataToEntityMapper supDocumentViewDataToEntityMapper() {
        return new SupDocumentViewDataToEntityMapper(new DocumentTypeViewDataToEntityMapper(), new SupDocumentFileProvider());
    }

    private SupplementaryDocumentSelectionDependenciesProvider supplementaryDocumentSelectionDependenciesProvider() {
        return new SupplementaryDocumentSelectionDependenciesProvider(supDocumentConfigToDocSelectionViewDataMapper(), supDocumentEducationalArgumentsToViewDataMapper(), supDocumentFeatureErrorToFailureMapper());
    }

    private UploadErrorToViewDataMapper uploadErrorToViewDataMapper() {
        return new UploadErrorToViewDataMapper(new ExceptionToFailureMapper());
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureComponent
    public void inject(SupDocumentCaptureSession supDocumentCaptureSession) {
        injectSupDocumentCaptureSession(supDocumentCaptureSession);
    }

    private DaggerSupDocumentCaptureComponent(SupDocumentCaptureModule supDocumentCaptureModule, CommonModule commonModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, ResourceConfigurationModule resourceConfigurationModule, CountryHelperModule countryHelperModule, SupDocumentCaptureViewModelModule supDocumentCaptureViewModelModule) {
        this.supDocumentCaptureComponent = this;
        this.supDocumentCaptureModule = supDocumentCaptureModule;
        initialize(supDocumentCaptureModule, commonModule, remoteModule, ipTrackingModule, resourceConfigurationModule, countryHelperModule, supDocumentCaptureViewModelModule);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureComponent
    public void inject(SupDocumentCaptureActivity supDocumentCaptureActivity) {
        injectSupDocumentCaptureActivity(supDocumentCaptureActivity);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureComponent
    public void inject(DocumentReviewFragment documentReviewFragment) {
        injectDocumentReviewFragment(documentReviewFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureComponent
    public void inject(DocumentGuidelinesFragment documentGuidelinesFragment) {
        injectDocumentGuidelinesFragment(documentGuidelinesFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureComponent
    public void inject(AutomationCaptureActivity automationCaptureActivity) {
        injectAutomationCaptureActivity(automationCaptureActivity);
    }
}
