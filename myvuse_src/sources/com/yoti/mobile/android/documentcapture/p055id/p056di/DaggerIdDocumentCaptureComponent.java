package com.yoti.mobile.android.documentcapture.p055id.p056di;

import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory_Factory;
import com.yoti.mobile.android.documentcapture.data.AssessmentEntityToAssessmentResultMapper;
import com.yoti.mobile.android.documentcapture.data.PageInfoEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p055id.data.AddressEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.DocumentEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.IdDocumentRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.IdScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.NfcEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository_Factory;
import com.yoti.mobile.android.documentcapture.p055id.data.OcrResultEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.ScanConfigurationDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.TextExtractionExceptionToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.UploadExceptionToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.data.local.NfcPassportCountriesLocalDataSource;
import com.yoti.mobile.android.documentcapture.p055id.data.local.NfcPassportCountriesLocalDataSource_Factory;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentUploadService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.MrzSerializer_Factory;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.ScanConfigurationService;
import com.yoti.mobile.android.documentcapture.p055id.domain.CaptureStorage;
import com.yoti.mobile.android.documentcapture.p055id.domain.CaptureStorage_Factory;
import com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor;
import com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentCaptureActivity;
import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentCaptureActivity_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentPageReviewFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentPageReviewFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultsToDocumentScanResultViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanErrorToEntityMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanFragmentFactoryWrapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragmentFactoryWrapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocConfigToDocSelectionViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.selection.IdDocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.DocumentTextExtractionErrorFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.DocumentTextExtractionErrorFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.DocumentScanResultViewDataToBacCredentialMapper_Factory;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorToFailureMapper;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper_Factory;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository_Factory;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import com.yoti.mobile.android.mrtd.p073di.MrtdCoreModule;
import com.yoti.mobile.android.mrtd.p073di.MrtdCoreModule_ProvideNfcAdapterFactory;
import com.yoti.mobile.android.mrtd.p073di.MrtdCoreModule_ProvideNfcRepositoryFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory_Factory;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
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
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonBuilderFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesOkHttpClientFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesServiceLocationFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesSessionFactory;
import com.yoti.mobile.android.yotidocs.common.BitmapFileDecoder;
import com.yoti.mobile.android.yotidocs.common.BitmapFileDecoder_Factory;
import com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader;
import com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader_Factory;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_ComputationCoroutineContextFactory;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule_IoCoroutineContextFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus_Factory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4978x27c318a2;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4980x2a61395e;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesCountryCodeHelperFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesExternalDemonymProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesLocalisedCountriesProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule_ProvidesYdsDemonymProviderFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule_ProvidesRequirementIdFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusPreferencesFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusRepositoryFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.AssessmentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes5.dex */
public final class DaggerIdDocumentCaptureComponent implements IdDocumentCaptureComponent {
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<BitmapFileDecoder> bitmapFileDecoderProvider;
    private Provider<CaptureStorage> captureStorageProvider;
    private final CountryHelperModule countryHelperModule;
    private Provider<DocumentCaptureResultToPageScanReviewViewDataMapper> documentCaptureResultToPageScanReviewViewDataMapperProvider;
    private Provider<DocumentImageLoader> documentImageLoaderProvider;
    private Provider<DocumentScanViewModel> documentScanViewModelProvider;
    private Provider<DeviceMetadata.Factory> factoryProvider;
    private Provider<DocumentCaptureConfiguration> featureConfigurationProvider;
    private Provider<GetNfcFlowTypeInteractor> getNfcFlowTypeInteractorProvider;
    private Provider<IcanhazipIpRemoteDataSource> icanhazipIpRemoteDataSourceProvider;
    private final IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule;
    private final DaggerIdDocumentCaptureComponent idDocumentCaptureComponent;
    private final IdDocumentCaptureModule idDocumentCaptureModule;
    private Provider<IdDocumentScanResultViewDataToEntityMapper> idDocumentScanResultViewDataToEntityMapperProvider;
    private Provider<ImageDimensionsReader> imageDimensionsReaderProvider;
    private Provider<IpRepository> ipRepositoryProvider;
    private Provider<IpifyIpRemoteDataSource> ipifyIpRemoteDataSourceProvider;
    private Provider<Gson> makeGsonProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<MetadataInterceptor> metadataInterceptorProvider;
    private Provider<NfcPassportCountriesLocalDataSource> nfcPassportCountriesLocalDataSourceProvider;
    private Provider<NfcPassportCountriesRepository> nfcPassportCountriesRepositoryProvider;
    private Provider<NfcStateRepository> nfcStateRepositoryProvider;
    private Provider<PageScanReviewViewModel> pageScanReviewViewModelProvider;
    private Provider<TypedInterceptor> provideAuthInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideLoggingInterceptor$remote_productionReleaseProvider;
    private Provider<TypedInterceptor> provideMetadataInterceptor$remote_productionReleaseProvider;
    private Provider<NfcAdapter> provideNfcAdapterProvider;
    private Provider<INfcStateRepository> provideNfcRepositoryProvider;
    private Provider<TypedInterceptor> provideSessionInterceptor$remote_productionReleaseProvider;
    private Provider<DocumentCaptureApiService> providesApiServiceProvider;

    /* JADX INFO: renamed from: providesConfigurationPreferences$yoti_sdk_core_productionReleaseProvider */
    private Provider<SharedPreferences> f6769xc1606568;
    private Provider<CountryCodeHelper> providesCountryCodeHelperProvider;
    private Provider<IDemonymProvider> providesExternalDemonymProvider;
    private Provider<ViewModel> providesGenericTextExtractionErrorViewModelProvider;
    private Provider<GsonBuilder> providesGsonBuilderProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<IcanhazipApi> providesIcanhazipApiService$remote_productionReleaseProvider;
    private Provider<IIpCacheDataSource> providesIpCacheDataSource$remote_productionReleaseProvider;
    private Provider<IIpRemoteDataSource> providesIpRemoteDataSource$remote_productionReleaseProvider;
    private Provider<IIpRepository> providesIpRepository$remote_productionReleaseProvider;
    private Provider<IpifyApi> providesIpifyApiService$remote_productionReleaseProvider;
    private Provider<LocalisedCountriesProvider> providesLocalisedCountriesProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<ViewModel> providesPageScanReviewViewModelProvider;
    private Provider<String> providesRequirementIdProvider;
    private Provider<IResourceConfigurationCacheDataStore> providesResourceConfigurationDataStoreProvider;
    private Provider<SavedStateViewModelFactory<DocumentScanViewModel>> providesSavedStateViewModelFactoryForDocumentCaptureProvider;

    /* JADX INFO: renamed from: providesSavedStateViewModelFactoryForDocumentNfcVerificationProvider */
    private Provider<SavedStateViewModelFactory<VerifyYourDetailsViewModel>> f6770x3ef70455;
    private Provider<SavedStateViewModelFactory<PageScanReviewViewModel>> providesSavedStateViewModelFactoryForDocumentReviewProvider;
    private Provider<ViewModel> providesScanConfigurationViewModelProvider;
    private Provider<IScanFragmentFactoryWrapper> providesScanFragmentFactoryProvider;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<SdkCoreApiService> providesSessionConfigurationApiServiceProvider;
    private Provider<Session> providesSessionProvider;
    private Provider<ViewModel> providesVerifyYourDetailsViewModelProvider;
    private Provider<IDemonymProvider> providesYdsDemonymProvider;
    private Provider<ResourceConfigurationCacheDataStore> resourceConfigurationCacheDataStoreProvider;
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateHandleHolderViewModelFactoryProvider;
    private Provider<SessionIdInterceptor> sessionIdInterceptorProvider;
    private Provider<SharedPreferences> sessionStatusPreferencesProvider;
    private Provider<SessionStatus> sessionStatusProvider;
    private Provider<SessionStatusRepository> sessionStatusRepositoryProvider;
    private Provider<ISessionStatusRepository> sessionStatusRepositoryProvider2;
    private Provider<Set<TypedInterceptor>> setOfTypedInterceptorProvider;
    private Provider<TextExtractionErrorViewModel> textExtractionErrorViewModelProvider;
    private Provider<TypedLoggingInterceptor> typedLoggingInterceptorProvider;
    private Provider<VerifyYourDetailsViewModel> verifyYourDetailsViewModelProvider;
    private Provider<ViewModelFactory> viewModelFactoryProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private CountryHelperModule countryHelperModule;
        private IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule;
        private IdDocumentCaptureModule idDocumentCaptureModule;
        private IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule;
        private IpTrackingModule ipTrackingModule;
        private MrtdCoreModule mrtdCoreModule;
        private RemoteModule remoteModule;
        private ResourceConfigurationModule resourceConfigurationModule;
        private SessionStatusModule sessionStatusModule;

        public IdDocumentCaptureComponent build() {
            Preconditions.checkBuilderRequirement(this.idDocumentCaptureModule, IdDocumentCaptureModule.class);
            if (this.mrtdCoreModule == null) {
                this.mrtdCoreModule = new MrtdCoreModule();
            }
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.ipTrackingModule == null) {
                this.ipTrackingModule = new IpTrackingModule();
            }
            Preconditions.checkBuilderRequirement(this.resourceConfigurationModule, ResourceConfigurationModule.class);
            if (this.idDocumentCaptureApiServiceModule == null) {
                this.idDocumentCaptureApiServiceModule = new IdDocumentCaptureApiServiceModule();
            }
            if (this.sessionStatusModule == null) {
                this.sessionStatusModule = new SessionStatusModule();
            }
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            Preconditions.checkBuilderRequirement(this.countryHelperModule, CountryHelperModule.class);
            if (this.idDocumentCaptureViewModelModule == null) {
                this.idDocumentCaptureViewModelModule = new IdDocumentCaptureViewModelModule();
            }
            return new DaggerIdDocumentCaptureComponent(this.idDocumentCaptureModule, this.mrtdCoreModule, this.remoteModule, this.ipTrackingModule, this.resourceConfigurationModule, this.idDocumentCaptureApiServiceModule, this.sessionStatusModule, this.commonModule, this.countryHelperModule, this.idDocumentCaptureViewModelModule);
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

        public Builder idDocumentCaptureApiServiceModule(IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule) {
            this.idDocumentCaptureApiServiceModule = (IdDocumentCaptureApiServiceModule) Preconditions.checkNotNull(idDocumentCaptureApiServiceModule);
            return this;
        }

        public Builder idDocumentCaptureModule(IdDocumentCaptureModule idDocumentCaptureModule) {
            this.idDocumentCaptureModule = (IdDocumentCaptureModule) Preconditions.checkNotNull(idDocumentCaptureModule);
            return this;
        }

        public Builder idDocumentCaptureViewModelModule(IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule) {
            this.idDocumentCaptureViewModelModule = (IdDocumentCaptureViewModelModule) Preconditions.checkNotNull(idDocumentCaptureViewModelModule);
            return this;
        }

        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            this.ipTrackingModule = (IpTrackingModule) Preconditions.checkNotNull(ipTrackingModule);
            return this;
        }

        public Builder mrtdCoreModule(MrtdCoreModule mrtdCoreModule) {
            this.mrtdCoreModule = (MrtdCoreModule) Preconditions.checkNotNull(mrtdCoreModule);
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

        public Builder sessionStatusModule(SessionStatusModule sessionStatusModule) {
            this.sessionStatusModule = (SessionStatusModule) Preconditions.checkNotNull(sessionStatusModule);
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

    private BitmapFileDecoder bitmapFileDecoder() {
        return new BitmapFileDecoder(CoroutineContextModule_IoCoroutineContextFactory.ioCoroutineContext());
    }

    public static Builder builder() {
        return new Builder();
    }

    private CountryCodeHelper countryCodeHelper() {
        return CountryHelperModule_ProvidesCountryCodeHelperFactory.providesCountryCodeHelper(this.countryHelperModule, ydsDemonymProviderIDemonymProvider());
    }

    private CountryEntityToViewDataMapper countryEntityToViewDataMapper() {
        return new CountryEntityToViewDataMapper(this.providesLocalisedCountriesProvider.get(), new DocumentTypeEntityToViewDataMapper());
    }

    private DataExceptionToEntityMapper dataExceptionToEntityMapper() {
        return new DataExceptionToEntityMapper(this.providesGsonProvider.get());
    }

    private DocumentCaptureCoreSession documentCaptureCoreSession() {
        return new DocumentCaptureCoreSession(this.applicationContextProvider.get(), iDocumentSelectionDependenciesProvider(), iDocumentScanDependenciesProvider(), iDocumentUploadDependenciesProvider(), IdDocumentCaptureModule_FeatureConfigurationFactory.featureConfiguration(this.idDocumentCaptureModule));
    }

    private DocumentEntityToDataMapper documentEntityToDataMapper() {
        return new DocumentEntityToDataMapper(new PageInfoEntityToDataMapper(), ocrResultEntityToDataMapper(), new DocumentTypeEntityToDataMapper(), new NfcEntityToDataMapper());
    }

    private DocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper() {
        return new DocumentFeatureErrorToFailureMapper(new ExceptionToFailureMapper());
    }

    private DocumentImageLoader documentImageLoader() {
        return new DocumentImageLoader(this.applicationContextProvider.get(), CoroutineContextModule_IoCoroutineContextFactory.ioCoroutineContext());
    }

    private DocumentStartDestinationResolver documentStartDestinationResolver() {
        return new DocumentStartDestinationResolver(IdDocumentCaptureModule_FeatureConfigurationFactory.featureConfiguration(this.idDocumentCaptureModule));
    }

    private DocumentUploadService documentUploadService() {
        return new DocumentUploadService(multiPartBodyFactory(), this.providesApiServiceProvider.get(), this.providesSessionConfigurationApiServiceProvider.get(), this.providesRequirementIdProvider.get(), this.idDocumentCaptureApiServiceModule.providesSessionFeedbackActivationFlag());
    }

    private IDocumentScanDependenciesProvider iDocumentScanDependenciesProvider() {
        return C4615xce94b35f.providesCoreScanDependenciesProvider(this.idDocumentCaptureModule, idDocumentScanDependenciesProvider());
    }

    private IDocumentSelectionDependenciesProvider iDocumentSelectionDependenciesProvider() {
        return C4616x9943fd18.providesCoreSelectionDependenciesProvider(this.idDocumentCaptureModule, idDocumentSelectionDependenciesProvider());
    }

    private IDocumentUploadDependenciesProvider iDocumentUploadDependenciesProvider() {
        return C4617xcc37de5b.providesCoreUploadDependenciesProvider(this.idDocumentCaptureModule, idDocumentUploadDependenciesProvider());
    }

    private IdDocConfigToDocSelectionViewDataMapper idDocConfigToDocSelectionViewDataMapper() {
        return new IdDocConfigToDocSelectionViewDataMapper(countryEntityToViewDataMapper(), new CaptureObjectiveTypeEntityToViewDataMapper());
    }

    private IdDocumentEducationalArgumentsToViewDataMapper idDocumentEducationalArgumentsToViewDataMapper() {
        return new IdDocumentEducationalArgumentsToViewDataMapper(ydsDemonymProviderIDemonymProvider());
    }

    private IdDocumentFeatureErrorToFailureMapper idDocumentFeatureErrorToFailureMapper() {
        return new IdDocumentFeatureErrorToFailureMapper(documentFeatureErrorToFailureMapper());
    }

    private IdDocumentRepository idDocumentRepository() {
        return new IdDocumentRepository(documentUploadService(), this.providesApiServiceProvider.get(), documentEntityToDataMapper(), assessmentEntityToAssessmentResultMapper(), uploadExceptionToEntityMapper());
    }

    private IdDocumentScanDependenciesProvider idDocumentScanDependenciesProvider() {
        return new IdDocumentScanDependenciesProvider(new IdDocumentScanNavigatorProvider(), idScanConfigurationRepository(), idScanConfigurationEntityToViewDataMapper());
    }

    private IdDocumentScanResultViewDataToEntityMapper idDocumentScanResultViewDataToEntityMapper() {
        return new IdDocumentScanResultViewDataToEntityMapper(new DocumentTypeViewDataToEntityMapper(), countryCodeHelper(), imageDimensionsReader(), CoroutineContextModule_ComputationCoroutineContextFactory.computationCoroutineContext());
    }

    private IdDocumentSelectionDependenciesProvider idDocumentSelectionDependenciesProvider() {
        return new IdDocumentSelectionDependenciesProvider(idDocConfigToDocSelectionViewDataMapper(), idDocumentEducationalArgumentsToViewDataMapper(), idDocumentFeatureErrorToFailureMapper());
    }

    private IdDocumentUploadDependenciesProvider idDocumentUploadDependenciesProvider() {
        return new IdDocumentUploadDependenciesProvider(idDocumentUploadNavigatorProvider(), idDocumentRepository(), idDocumentScanResultViewDataToEntityMapper(), uploadErrorToViewDataMapper(), new UploadErrorToSessionStatusTypeMapper());
    }

    private IdDocumentUploadNavigatorProvider idDocumentUploadNavigatorProvider() {
        return new IdDocumentUploadNavigatorProvider(IdDocumentCaptureModule_FeatureConfigurationFactory.featureConfiguration(this.idDocumentCaptureModule));
    }

    private IdScanConfigurationEntityToViewDataMapper idScanConfigurationEntityToViewDataMapper() {
        return new IdScanConfigurationEntityToViewDataMapper(new DocumentTypeEntityToViewDataMapper(), IdDocumentCaptureModule_FeatureConfigurationFactory.featureConfiguration(this.idDocumentCaptureModule));
    }

    private IdScanConfigurationRepository idScanConfigurationRepository() {
        return new IdScanConfigurationRepository(scanConfigurationService(), this.providesResourceConfigurationDataStoreProvider.get(), this.providesRequirementIdProvider.get(), scanConfigurationDataToEntityMapper(), new DocumentTypeEntityToDataMapper(), remoteExceptionToEntityMapper());
    }

    private ImageDimensionsReader imageDimensionsReader() {
        return new ImageDimensionsReader(bitmapFileDecoder());
    }

    private void initialize(IdDocumentCaptureModule idDocumentCaptureModule, MrtdCoreModule mrtdCoreModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, ResourceConfigurationModule resourceConfigurationModule, IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, CountryHelperModule countryHelperModule, IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule) {
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
        this.providesOkHttpClientProvider = DoubleCheck.provider(RemoteModule_ProvidesOkHttpClientFactory.create(remoteModule, this.apiServiceFactoryProvider, setFactoryBuild));
        Provider<GsonBuilder> provider5 = DoubleCheck.provider(RemoteModule_ProvidesGsonBuilderFactory.create(remoteModule, this.apiServiceFactoryProvider));
        this.providesGsonBuilderProvider = provider5;
        Provider<Gson> provider6 = DoubleCheck.provider(IdDocumentCaptureApiServiceModule_MakeGsonFactory.create(idDocumentCaptureApiServiceModule, provider5, MrzSerializer_Factory.create()));
        this.makeGsonProvider = provider6;
        this.providesApiServiceProvider = DoubleCheck.provider(IdDocumentCaptureApiServiceModule_ProvidesApiServiceFactory.create(idDocumentCaptureApiServiceModule, this.apiServiceFactoryProvider, this.providesOkHttpClientProvider, provider6));
        this.f6769xc1606568 = DoubleCheck.provider(C4978x27c318a2.create(resourceConfigurationModule));
        Provider<String> provider7 = DoubleCheck.provider(ResourceConfigurationModule_ProvidesRequirementIdFactory.create(resourceConfigurationModule));
        this.providesRequirementIdProvider = provider7;
        ResourceConfigurationCacheDataStore_Factory resourceConfigurationCacheDataStore_FactoryCreate = ResourceConfigurationCacheDataStore_Factory.create(this.f6769xc1606568, provider7, this.providesGsonProvider);
        this.resourceConfigurationCacheDataStoreProvider = resourceConfigurationCacheDataStore_FactoryCreate;
        this.providesResourceConfigurationDataStoreProvider = DoubleCheck.provider(C4980x2a61395e.create(resourceConfigurationModule, resourceConfigurationCacheDataStore_FactoryCreate));
        this.providesSessionConfigurationApiServiceProvider = DoubleCheck.provider(C4613x9da8fa95.create(idDocumentCaptureApiServiceModule, this.apiServiceFactoryProvider, this.providesOkHttpClientProvider));
        MrtdCoreModule_ProvideNfcAdapterFactory mrtdCoreModule_ProvideNfcAdapterFactoryCreate = MrtdCoreModule_ProvideNfcAdapterFactory.create(mrtdCoreModule, this.applicationContextProvider);
        this.provideNfcAdapterProvider = mrtdCoreModule_ProvideNfcAdapterFactoryCreate;
        NfcStateRepository_Factory nfcStateRepository_FactoryCreate = NfcStateRepository_Factory.create(mrtdCoreModule_ProvideNfcAdapterFactoryCreate);
        this.nfcStateRepositoryProvider = nfcStateRepository_FactoryCreate;
        this.provideNfcRepositoryProvider = MrtdCoreModule_ProvideNfcRepositoryFactory.create(mrtdCoreModule, nfcStateRepository_FactoryCreate);
        NfcPassportCountriesLocalDataSource_Factory nfcPassportCountriesLocalDataSource_FactoryCreate = NfcPassportCountriesLocalDataSource_Factory.create(this.applicationContextProvider, this.providesGsonProvider, CoroutineContextModule_IoCoroutineContextFactory.create());
        this.nfcPassportCountriesLocalDataSourceProvider = nfcPassportCountriesLocalDataSource_FactoryCreate;
        NfcPassportCountriesRepository_Factory nfcPassportCountriesRepository_FactoryCreate = NfcPassportCountriesRepository_Factory.create(nfcPassportCountriesLocalDataSource_FactoryCreate);
        this.nfcPassportCountriesRepositoryProvider = nfcPassportCountriesRepository_FactoryCreate;
        this.getNfcFlowTypeInteractorProvider = GetNfcFlowTypeInteractor_Factory.create(this.provideNfcRepositoryProvider, nfcPassportCountriesRepository_FactoryCreate);
        this.captureStorageProvider = CaptureStorage_Factory.create(this.applicationContextProvider, CoroutineContextModule_IoCoroutineContextFactory.create());
        SessionStatusModule_SessionStatusPreferencesFactory sessionStatusModule_SessionStatusPreferencesFactoryCreate = SessionStatusModule_SessionStatusPreferencesFactory.create(sessionStatusModule, this.applicationContextProvider);
        this.sessionStatusPreferencesProvider = sessionStatusModule_SessionStatusPreferencesFactoryCreate;
        SessionStatusRepository_Factory sessionStatusRepository_FactoryCreate = SessionStatusRepository_Factory.create(sessionStatusModule_SessionStatusPreferencesFactoryCreate);
        this.sessionStatusRepositoryProvider = sessionStatusRepository_FactoryCreate;
        SessionStatusModule_SessionStatusRepositoryFactory sessionStatusModule_SessionStatusRepositoryFactoryCreate = SessionStatusModule_SessionStatusRepositoryFactory.create(sessionStatusModule, sessionStatusRepository_FactoryCreate);
        this.sessionStatusRepositoryProvider2 = sessionStatusModule_SessionStatusRepositoryFactoryCreate;
        this.sessionStatusProvider = SessionStatus_Factory.create(sessionStatusModule_SessionStatusRepositoryFactoryCreate);
        IdDocumentCaptureModule_FeatureConfigurationFactory idDocumentCaptureModule_FeatureConfigurationFactoryCreate = IdDocumentCaptureModule_FeatureConfigurationFactory.create(idDocumentCaptureModule);
        this.featureConfigurationProvider = idDocumentCaptureModule_FeatureConfigurationFactoryCreate;
        this.documentCaptureResultToPageScanReviewViewDataMapperProvider = DocumentCaptureResultToPageScanReviewViewDataMapper_Factory.create(idDocumentCaptureModule_FeatureConfigurationFactoryCreate);
        CountryHelperModule_ProvidesExternalDemonymProviderFactory countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate = CountryHelperModule_ProvidesExternalDemonymProviderFactory.create(countryHelperModule);
        this.providesExternalDemonymProvider = countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate;
        CountryHelperModule_ProvidesYdsDemonymProviderFactory countryHelperModule_ProvidesYdsDemonymProviderFactoryCreate = CountryHelperModule_ProvidesYdsDemonymProviderFactory.create(countryHelperModule, countryHelperModule_ProvidesExternalDemonymProviderFactoryCreate);
        this.providesYdsDemonymProvider = countryHelperModule_ProvidesYdsDemonymProviderFactoryCreate;
        this.providesCountryCodeHelperProvider = CountryHelperModule_ProvidesCountryCodeHelperFactory.create(countryHelperModule, countryHelperModule_ProvidesYdsDemonymProviderFactoryCreate);
        BitmapFileDecoder_Factory bitmapFileDecoder_FactoryCreate = BitmapFileDecoder_Factory.create(CoroutineContextModule_IoCoroutineContextFactory.create());
        this.bitmapFileDecoderProvider = bitmapFileDecoder_FactoryCreate;
        this.imageDimensionsReaderProvider = ImageDimensionsReader_Factory.create(bitmapFileDecoder_FactoryCreate);
        this.idDocumentScanResultViewDataToEntityMapperProvider = IdDocumentScanResultViewDataToEntityMapper_Factory.create(DocumentTypeViewDataToEntityMapper_Factory.create(), this.providesCountryCodeHelperProvider, this.imageDimensionsReaderProvider, CoroutineContextModule_ComputationCoroutineContextFactory.create());
        DocumentScanViewModel_Factory documentScanViewModel_FactoryCreate = DocumentScanViewModel_Factory.create(this.getNfcFlowTypeInteractorProvider, this.captureStorageProvider, this.sessionStatusProvider, DocumentScanResultViewDataToBacCredentialMapper_Factory.create(), this.documentCaptureResultToPageScanReviewViewDataMapperProvider, DocumentScanResultsToDocumentScanResultViewDataMapper_Factory.create(), this.idDocumentScanResultViewDataToEntityMapperProvider, ScanErrorToEntityMapper_Factory.create(), ExceptionToFailureMapper_Factory.create(), ScanErrorToSessionStatusTypeMapper_Factory.create());
        this.documentScanViewModelProvider = documentScanViewModel_FactoryCreate;
        this.providesScanConfigurationViewModelProvider = C4623xf6e2250e.create(idDocumentCaptureViewModelModule, documentScanViewModel_FactoryCreate);
        PageScanReviewViewModel_Factory pageScanReviewViewModel_FactoryCreate = PageScanReviewViewModel_Factory.create(this.sessionStatusProvider, ErrorToSessionStatusTypeMapper_Factory.create());
        this.pageScanReviewViewModelProvider = pageScanReviewViewModel_FactoryCreate;
        this.providesPageScanReviewViewModelProvider = C4619xf589e6fb.create(idDocumentCaptureViewModelModule, pageScanReviewViewModel_FactoryCreate);
        VerifyYourDetailsViewModel_Factory verifyYourDetailsViewModel_FactoryCreate = VerifyYourDetailsViewModel_Factory.create(DocumentScanResultViewDataToBacCredentialMapper_Factory.create());
        this.verifyYourDetailsViewModelProvider = verifyYourDetailsViewModel_FactoryCreate;
        this.providesVerifyYourDetailsViewModelProvider = C4624x4df2cdeb.create(idDocumentCaptureViewModelModule, verifyYourDetailsViewModel_FactoryCreate);
        DocumentImageLoader_Factory documentImageLoader_FactoryCreate = DocumentImageLoader_Factory.create(this.applicationContextProvider, CoroutineContextModule_IoCoroutineContextFactory.create());
        this.documentImageLoaderProvider = documentImageLoader_FactoryCreate;
        TextExtractionErrorViewModel_Factory textExtractionErrorViewModel_FactoryCreate = TextExtractionErrorViewModel_Factory.create(documentImageLoader_FactoryCreate, this.providesLocalisedCountriesProvider, this.sessionStatusProvider, ErrorToSessionStatusTypeMapper_Factory.create());
        this.textExtractionErrorViewModelProvider = textExtractionErrorViewModel_FactoryCreate;
        this.providesGenericTextExtractionErrorViewModelProvider = C4618x55e7c974.create(idDocumentCaptureViewModelModule, textExtractionErrorViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(4).put(DocumentScanViewModel.class, (Provider) this.providesScanConfigurationViewModelProvider).put(PageScanReviewViewModel.class, (Provider) this.providesPageScanReviewViewModelProvider).put(VerifyYourDetailsViewModel.class, (Provider) this.providesVerifyYourDetailsViewModelProvider).put(TextExtractionErrorViewModel.class, (Provider) this.providesGenericTextExtractionErrorViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider8 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(mapProviderFactoryBuild));
        this.savedStateHandleHolderViewModelFactoryProvider = provider8;
        this.providesSavedStateViewModelFactoryForDocumentCaptureProvider = DoubleCheck.provider(C4620x8a5c2e67.create(idDocumentCaptureViewModelModule, provider8));
        this.providesScanFragmentFactoryProvider = DoubleCheck.provider(IdDocumentCaptureModule_ProvidesScanFragmentFactoryFactory.create(idDocumentCaptureModule, ScanFragmentFactoryWrapper_Factory.create(), AutomationScanFragmentFactoryWrapper_Factory.create()));
        this.providesSavedStateViewModelFactoryForDocumentReviewProvider = DoubleCheck.provider(C4622x7ac1aaf.create(idDocumentCaptureViewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
        this.f6770x3ef70455 = DoubleCheck.provider(C4621xccd43347.create(idDocumentCaptureViewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
        this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(this.mapOfClassOfAndProviderOfViewModelProvider));
    }

    private AutomationScanFragment injectAutomationScanFragment(AutomationScanFragment automationScanFragment) {
        AutomationScanFragment_MembersInjector.injectAssetToFileConverter(automationScanFragment, assetToFileConverter());
        return automationScanFragment;
    }

    private DocumentPageReviewFragment injectDocumentPageReviewFragment(DocumentPageReviewFragment documentPageReviewFragment) {
        DocumentPageReviewFragment_MembersInjector.injectViewModelFactory(documentPageReviewFragment, this.providesSavedStateViewModelFactoryForDocumentReviewProvider.get());
        DocumentPageReviewFragment_MembersInjector.injectDocumentImageLoader(documentPageReviewFragment, documentImageLoader());
        return documentPageReviewFragment;
    }

    private DocumentScanFragment injectDocumentScanFragment(DocumentScanFragment documentScanFragment) {
        DocumentScanFragment_MembersInjector.injectViewModelFactory(documentScanFragment, this.providesSavedStateViewModelFactoryForDocumentCaptureProvider.get());
        DocumentScanFragment_MembersInjector.injectScanFragmentFactory(documentScanFragment, this.providesScanFragmentFactoryProvider.get());
        return documentScanFragment;
    }

    private DocumentTextExtractionErrorFragment injectDocumentTextExtractionErrorFragment(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment) {
        DocumentTextExtractionErrorFragment_MembersInjector.injectViewModelFactory(documentTextExtractionErrorFragment, this.viewModelFactoryProvider.get());
        DocumentTextExtractionErrorFragment_MembersInjector.injectNavigatorProvider(documentTextExtractionErrorFragment, idDocumentUploadNavigatorProvider());
        return documentTextExtractionErrorFragment;
    }

    private IdDocumentCaptureActivity injectIdDocumentCaptureActivity(IdDocumentCaptureActivity idDocumentCaptureActivity) {
        IdDocumentCaptureActivity_MembersInjector.injectStartDestinationResolver(idDocumentCaptureActivity, documentStartDestinationResolver());
        IdDocumentCaptureActivity_MembersInjector.injectViewModelFactoryProvider(idDocumentCaptureActivity, this.savedStateHandleHolderViewModelFactoryProvider.get());
        return idDocumentCaptureActivity;
    }

    private IdDocumentCaptureSession injectIdDocumentCaptureSession(IdDocumentCaptureSession idDocumentCaptureSession) {
        IdDocumentCaptureSession_MembersInjector.injectCoreSession(idDocumentCaptureSession, documentCaptureCoreSession());
        return idDocumentCaptureSession;
    }

    private VerifyYourDetailsFragment injectVerifyYourDetailsFragment(VerifyYourDetailsFragment verifyYourDetailsFragment) {
        VerifyYourDetailsFragment_MembersInjector.injectViewModelFactory(verifyYourDetailsFragment, this.f6770x3ef70455.get());
        return verifyYourDetailsFragment;
    }

    private MimeTypeProvider mimeTypeProvider() {
        return new MimeTypeProvider(this.applicationContextProvider.get());
    }

    private MultiPartBodyFactory multiPartBodyFactory() {
        return new MultiPartBodyFactory(this.applicationContextProvider.get(), mimeTypeProvider());
    }

    private OcrResultEntityToDataMapper ocrResultEntityToDataMapper() {
        return new OcrResultEntityToDataMapper(new AddressEntityToDataMapper(), new DocumentTypeEntityToDataMapper());
    }

    private RemoteExceptionToEntityMapper remoteExceptionToEntityMapper() {
        return new RemoteExceptionToEntityMapper(this.providesGsonProvider.get());
    }

    private ScanConfigurationDataToEntityMapper scanConfigurationDataToEntityMapper() {
        return new ScanConfigurationDataToEntityMapper(new DocumentTypeDataToEntityMapper());
    }

    private ScanConfigurationService scanConfigurationService() {
        return new ScanConfigurationService(this.providesApiServiceProvider.get());
    }

    private UploadErrorToViewDataMapper uploadErrorToViewDataMapper() {
        return new UploadErrorToViewDataMapper(IdDocumentCaptureModule_FeatureConfigurationFactory.featureConfiguration(this.idDocumentCaptureModule), new ExceptionToFailureMapper());
    }

    private UploadExceptionToEntityMapper uploadExceptionToEntityMapper() {
        return new UploadExceptionToEntityMapper(new TextExtractionExceptionToEntityMapper(), dataExceptionToEntityMapper());
    }

    private IDemonymProvider ydsDemonymProviderIDemonymProvider() {
        CountryHelperModule countryHelperModule = this.countryHelperModule;
        return CountryHelperModule_ProvidesYdsDemonymProviderFactory.providesYdsDemonymProvider(countryHelperModule, CountryHelperModule_ProvidesExternalDemonymProviderFactory.providesExternalDemonymProvider(countryHelperModule));
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(IdDocumentCaptureSession idDocumentCaptureSession) {
        injectIdDocumentCaptureSession(idDocumentCaptureSession);
    }

    private DaggerIdDocumentCaptureComponent(IdDocumentCaptureModule idDocumentCaptureModule, MrtdCoreModule mrtdCoreModule, RemoteModule remoteModule, IpTrackingModule ipTrackingModule, ResourceConfigurationModule resourceConfigurationModule, IdDocumentCaptureApiServiceModule idDocumentCaptureApiServiceModule, SessionStatusModule sessionStatusModule, CommonModule commonModule, CountryHelperModule countryHelperModule, IdDocumentCaptureViewModelModule idDocumentCaptureViewModelModule) {
        this.idDocumentCaptureComponent = this;
        this.idDocumentCaptureModule = idDocumentCaptureModule;
        this.countryHelperModule = countryHelperModule;
        this.idDocumentCaptureApiServiceModule = idDocumentCaptureApiServiceModule;
        initialize(idDocumentCaptureModule, mrtdCoreModule, remoteModule, ipTrackingModule, resourceConfigurationModule, idDocumentCaptureApiServiceModule, sessionStatusModule, commonModule, countryHelperModule, idDocumentCaptureViewModelModule);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(IdDocumentCaptureActivity idDocumentCaptureActivity) {
        injectIdDocumentCaptureActivity(idDocumentCaptureActivity);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(DocumentScanFragment documentScanFragment) {
        injectDocumentScanFragment(documentScanFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(DocumentPageReviewFragment documentPageReviewFragment) {
        injectDocumentPageReviewFragment(documentPageReviewFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(VerifyYourDetailsFragment verifyYourDetailsFragment) {
        injectVerifyYourDetailsFragment(verifyYourDetailsFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment) {
        injectDocumentTextExtractionErrorFragment(documentTextExtractionErrorFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureComponent
    public void inject(AutomationScanFragment automationScanFragment) {
        injectAutomationScanFragment(automationScanFragment);
    }
}
