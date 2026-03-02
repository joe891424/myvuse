package com.yoti.mobile.android.documentcapture.p054di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider_Factory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory_Factory;
import com.yoti.mobile.android.documentcapture.data.DocumentResourceConfigurationRepository;
import com.yoti.mobile.android.documentcapture.data.DocumentResourceConfigurationRepository_Factory;
import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.documentcapture.domain.GetDocumentCaptureConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.GetDocumentCaptureConfigurationInteractor_Factory;
import com.yoti.mobile.android.documentcapture.domain.GetScanConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.GetScanConfigurationInteractor_Factory;
import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor;
import com.yoti.mobile.android.documentcapture.domain.UploadDocumentInteractor_Factory;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper_Factory;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment_FragmentArgsFactory_Factory;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.navigation.AdditionalInstructionsCoordinator;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentResourceConfigEntityToEducationalViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentResourceConfigEntityToEducationalViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsCoordinator;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment;
import com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionCoordinator;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper_Factory;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentsAdapter;
import com.yoti.mobile.android.documentcapture.view.selection.ObjectiveRequirementsAdapter;
import com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper_Factory;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadErrorFragment;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadErrorFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragment;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragment_MembersInjector;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadViewModel_Factory;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.ApiServiceFactory_Factory;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.p075di.IpTrackingModule;
import com.yoti.mobile.android.remote.p075di.RemoteDebugModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesGsonFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule_ProvidesServiceLocationFactory;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.ApplicantProfileDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter_Factory;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileDateOfBirthFormatter_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.ObjectiveTypeDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.StateTypeToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore_Factory;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus_Factory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4978x27c318a2;
import com.yoti.mobile.android.yotisdkcore.core.p085di.C4980x2a61395e;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule_ProvidesRequirementIdFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusPreferencesFactory;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule_SessionStatusRepositoryFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper_Factory;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DaggerDocumentCaptureCoreComponent implements DocumentCaptureCoreComponent {
    private Provider<AdditionalInstructionsViewModel> additionalInstructionsViewModelProvider;
    private Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private Provider<Context> applicationContextProvider;
    private Provider<CountryEntityToViewDataMapper> countryEntityToViewDataMapperProvider;
    private Provider<DataExceptionToEntityMapper> dataExceptionToEntityMapperProvider;
    private final DaggerDocumentCaptureCoreComponent documentCaptureCoreComponent;
    private Provider<DocumentEducationalViewModel> documentEducationalViewModelProvider;
    private Provider<DocumentFeatureErrorToSessionStatusTypeMapper> documentFeatureErrorToSessionStatusTypeMapperProvider;
    private Provider<DocumentRequirementsViewModel> documentRequirementsViewModelProvider;
    private Provider<DocumentResourceConfigEntityToEducationalViewDataMapper> documentResourceConfigEntityToEducationalViewDataMapperProvider;
    private Provider<DocumentResourceConfigurationRepository> documentResourceConfigurationRepositoryProvider;
    private Provider<DocumentResourceConfigurationToEntityMapper> documentResourceConfigurationToEntityMapperProvider;
    private Provider<DocumentSelectionViewModel> documentSelectionViewModelProvider;
    private Provider<DocumentUploadViewModel> documentUploadViewModelProvider;
    private Provider<DocumentViewModelHelper> documentViewModelHelperProvider;
    private Provider<AdditionalInstructionsFragment.FragmentArgsFactory> fragmentArgsFactoryProvider;
    private Provider<GetDocumentCaptureConfigurationInteractor> getDocumentCaptureConfigurationInteractorProvider;
    private Provider<GetScanConfigurationInteractor> getScanConfigurationInteractorProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private Provider<Mapper<Throwable, YdsFailure>> provideDocumentFeatureErrorToFailureMapperProvider;
    private Provider<ViewModel> providesAdditionalInstructionsViewModelProvider;

    /* JADX INFO: renamed from: providesConfigurationPreferences$yoti_sdk_core_productionReleaseProvider */
    private Provider<SharedPreferences> f6686xc1606568;
    private Provider<DocumentCaptureConfiguration> providesDocumentCaptureConfigurationProvider;
    private Provider<IDocumentCleanupInteractor> providesDocumentCleanupInteractorProvider;
    private Provider<DocumentEducationalArgumentsToViewDataMapper> providesDocumentEducationalArgumentsToViewDataMapperProvider;
    private Provider<ViewModel> providesDocumentEducationalViewModelProvider;
    private Provider<IDocumentRepository<IDocumentEntity>> providesDocumentRepositoryProvider;
    private Provider<ViewModel> providesDocumentRequirementsViewModelProvider;
    private Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> providesDocumentResourceConfigurationRepositoryProvider;
    private Provider<ViewModel> providesDocumentSelectionViewModelProvider;
    private Provider<ViewModel> providesDocumentUploadViewModelProvider;
    private Provider<Mapper<IScanConfigurationEntity, IScanConfigurationViewData>> providesEntityToScanConfigurationViewDataMapperProvider;
    private Provider<Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData>> providesEntityToSelectionViewDataProvider;
    private Provider<Gson> providesGsonProvider;
    private Provider<String> providesRequirementIdProvider;
    private Provider<IResourceConfigurationCacheDataStore> providesResourceConfigurationDataStoreProvider;
    private Provider<SavedStateViewModelFactory<DocumentEducationalViewModel>> providesSavedStateViewModelFactoryForDocumentEducationalProvider;

    /* JADX INFO: renamed from: providesSavedStateViewModelFactoryForDocumentRequirementsProvider */
    private Provider<SavedStateViewModelFactory<DocumentRequirementsViewModel>> f6687x63682e83;
    private Provider<SavedStateViewModelFactory<DocumentSelectionViewModel>> providesSavedStateViewModelFactoryForDocumentSelectionProvider;
    private Provider<SavedStateViewModelFactory<DocumentUploadViewModel>> providesSavedStateViewModelFactoryForDocumentUploadProvider;
    private Provider<IScanConfigurationRepository<IScanConfigurationEntity>> providesScanConfigurationRepositoryProvider;
    private Provider<IScanNavigatorProvider<IScanConfigurationViewData>> providesScanNavigatorProvider;
    private Provider<ServiceLocation> providesServiceLocationProvider;
    private Provider<ErrorToSessionStatusTypeMapper> providesUploadErrorToSessionStatusMapperProvider;
    private Provider<Mapper<Throwable, YdsFailure>> providesUploadErrorToViewDataMapperProvider;
    private Provider<IUploadNavigatorProvider<IDocumentViewData>> providesUploadNavigatorProvider;
    private Provider<SuspendMapper<IDocumentViewData, IDocumentEntity>> providesViewDataToUploadableEntityMapperProvider;
    private Provider<ResourceConfigurationCacheDataStore> resourceConfigurationCacheDataStoreProvider;
    private Provider<SavedStateHandleHolderViewModelFactoryProvider> savedStateHandleHolderViewModelFactoryProvider;
    private Provider<SharedPreferences> sessionStatusPreferencesProvider;
    private Provider<SessionStatus> sessionStatusProvider;
    private Provider<SessionStatusRepository> sessionStatusRepositoryProvider;
    private Provider<ISessionStatusRepository> sessionStatusRepositoryProvider2;
    private Provider<TaskToEntityMapper> taskToEntityMapperProvider;
    private Provider<UploadDocumentInteractor> uploadDocumentInteractorProvider;
    private Provider<ValidationAndGuidanceEntityToViewDataMapper> validationAndGuidanceEntityToViewDataMapperProvider;
    private Provider<ViewModelFactory> viewModelFactoryProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private DocumentCaptureCoreModule documentCaptureCoreModule;
        private RemoteModule remoteModule;
        private ResourceConfigurationModule resourceConfigurationModule;
        private ScanModule scanModule;
        private SelectionModule selectionModule;
        private SessionStatusModule sessionStatusModule;
        private UploadModule uploadModule;
        private ViewModelModule viewModelModule;

        public DocumentCaptureCoreComponent build() {
            Preconditions.checkBuilderRequirement(this.documentCaptureCoreModule, DocumentCaptureCoreModule.class);
            Preconditions.checkBuilderRequirement(this.resourceConfigurationModule, ResourceConfigurationModule.class);
            Preconditions.checkBuilderRequirement(this.selectionModule, SelectionModule.class);
            Preconditions.checkBuilderRequirement(this.scanModule, ScanModule.class);
            Preconditions.checkBuilderRequirement(this.uploadModule, UploadModule.class);
            Preconditions.checkBuilderRequirement(this.remoteModule, RemoteModule.class);
            if (this.viewModelModule == null) {
                this.viewModelModule = new ViewModelModule();
            }
            if (this.sessionStatusModule == null) {
                this.sessionStatusModule = new SessionStatusModule();
            }
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            return new DaggerDocumentCaptureCoreComponent(this.documentCaptureCoreModule, this.resourceConfigurationModule, this.selectionModule, this.scanModule, this.uploadModule, this.remoteModule, this.viewModelModule, this.sessionStatusModule, this.commonModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        public Builder documentCaptureCoreModule(DocumentCaptureCoreModule documentCaptureCoreModule) {
            this.documentCaptureCoreModule = (DocumentCaptureCoreModule) Preconditions.checkNotNull(documentCaptureCoreModule);
            return this;
        }

        @Deprecated
        public Builder ipTrackingModule(IpTrackingModule ipTrackingModule) {
            Preconditions.checkNotNull(ipTrackingModule);
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

        public Builder scanModule(ScanModule scanModule) {
            this.scanModule = (ScanModule) Preconditions.checkNotNull(scanModule);
            return this;
        }

        public Builder selectionModule(SelectionModule selectionModule) {
            this.selectionModule = (SelectionModule) Preconditions.checkNotNull(selectionModule);
            return this;
        }

        public Builder sessionStatusModule(SessionStatusModule sessionStatusModule) {
            this.sessionStatusModule = (SessionStatusModule) Preconditions.checkNotNull(sessionStatusModule);
            return this;
        }

        public Builder uploadModule(UploadModule uploadModule) {
            this.uploadModule = (UploadModule) Preconditions.checkNotNull(uploadModule);
            return this;
        }

        public Builder viewModelModule(ViewModelModule viewModelModule) {
            this.viewModelModule = (ViewModelModule) Preconditions.checkNotNull(viewModelModule);
            return this;
        }

        private Builder() {
        }
    }

    private AdditionalInstructionsCoordinator additionalInstructionsCoordinator() {
        return new AdditionalInstructionsCoordinator(documentNavigationCoordinatorHelper());
    }

    public static Builder builder() {
        return new Builder();
    }

    private DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper() {
        return new DocumentNavigationCoordinatorHelper(this.providesScanNavigatorProvider.get());
    }

    private DocumentRequirementsCoordinator documentRequirementsCoordinator() {
        return new DocumentRequirementsCoordinator(documentNavigationCoordinatorHelper());
    }

    private DocumentSelectionCoordinator documentSelectionCoordinator() {
        return new DocumentSelectionCoordinator(documentNavigationCoordinatorHelper());
    }

    private void initialize(DocumentCaptureCoreModule documentCaptureCoreModule, ResourceConfigurationModule resourceConfigurationModule, SelectionModule selectionModule, ScanModule scanModule, UploadModule uploadModule, RemoteModule remoteModule, ViewModelModule viewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule) {
        this.f6686xc1606568 = DoubleCheck.provider(C4978x27c318a2.create(resourceConfigurationModule));
        this.providesRequirementIdProvider = DoubleCheck.provider(ResourceConfigurationModule_ProvidesRequirementIdFactory.create(resourceConfigurationModule));
        this.providesServiceLocationProvider = RemoteModule_ProvidesServiceLocationFactory.create(remoteModule);
        Provider<Context> provider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.applicationContextProvider = provider;
        ApiServiceFactory_Factory apiServiceFactory_FactoryCreate = ApiServiceFactory_Factory.create(this.providesServiceLocationProvider, provider);
        this.apiServiceFactoryProvider = apiServiceFactory_FactoryCreate;
        Provider<Gson> provider2 = DoubleCheck.provider(RemoteModule_ProvidesGsonFactory.create(remoteModule, apiServiceFactory_FactoryCreate));
        this.providesGsonProvider = provider2;
        ResourceConfigurationCacheDataStore_Factory resourceConfigurationCacheDataStore_FactoryCreate = ResourceConfigurationCacheDataStore_Factory.create(this.f6686xc1606568, this.providesRequirementIdProvider, provider2);
        this.resourceConfigurationCacheDataStoreProvider = resourceConfigurationCacheDataStore_FactoryCreate;
        this.providesResourceConfigurationDataStoreProvider = DoubleCheck.provider(C4980x2a61395e.create(resourceConfigurationModule, resourceConfigurationCacheDataStore_FactoryCreate));
        this.taskToEntityMapperProvider = TaskToEntityMapper_Factory.create(StateTypeToEntityMapper_Factory.create());
        this.documentResourceConfigurationToEntityMapperProvider = DocumentResourceConfigurationToEntityMapper_Factory.create(DocumentTypeDataToEntityMapper_Factory.create(), ObjectiveTypeDataToEntityMapper_Factory.create(), this.taskToEntityMapperProvider, ApplicantProfileDataToEntityMapper_Factory.create());
        DataExceptionToEntityMapper_Factory dataExceptionToEntityMapper_FactoryCreate = DataExceptionToEntityMapper_Factory.create(this.providesGsonProvider);
        this.dataExceptionToEntityMapperProvider = dataExceptionToEntityMapper_FactoryCreate;
        DocumentResourceConfigurationRepository_Factory documentResourceConfigurationRepository_FactoryCreate = DocumentResourceConfigurationRepository_Factory.create(this.providesResourceConfigurationDataStoreProvider, this.documentResourceConfigurationToEntityMapperProvider, dataExceptionToEntityMapper_FactoryCreate);
        this.documentResourceConfigurationRepositoryProvider = documentResourceConfigurationRepository_FactoryCreate;
        Provider<ResourceConfigurationRepository<DocumentResourceConfigEntity>> provider3 = DoubleCheck.provider(C4600xf38726ee.create(documentCaptureCoreModule, documentResourceConfigurationRepository_FactoryCreate));
        this.providesDocumentResourceConfigurationRepositoryProvider = provider3;
        this.getDocumentCaptureConfigurationInteractorProvider = GetDocumentCaptureConfigurationInteractor_Factory.create(provider3);
        Provider<IScanConfigurationRepository<IScanConfigurationEntity>> provider4 = DoubleCheck.provider(ScanModule_ProvidesScanConfigurationRepositoryFactory.create(scanModule));
        this.providesScanConfigurationRepositoryProvider = provider4;
        this.getScanConfigurationInteractorProvider = GetScanConfigurationInteractor_Factory.create(provider4);
        SessionStatusModule_SessionStatusPreferencesFactory sessionStatusModule_SessionStatusPreferencesFactoryCreate = SessionStatusModule_SessionStatusPreferencesFactory.create(sessionStatusModule, this.applicationContextProvider);
        this.sessionStatusPreferencesProvider = sessionStatusModule_SessionStatusPreferencesFactoryCreate;
        SessionStatusRepository_Factory sessionStatusRepository_FactoryCreate = SessionStatusRepository_Factory.create(sessionStatusModule_SessionStatusPreferencesFactoryCreate);
        this.sessionStatusRepositoryProvider = sessionStatusRepository_FactoryCreate;
        SessionStatusModule_SessionStatusRepositoryFactory sessionStatusModule_SessionStatusRepositoryFactoryCreate = SessionStatusModule_SessionStatusRepositoryFactory.create(sessionStatusModule, sessionStatusRepository_FactoryCreate);
        this.sessionStatusRepositoryProvider2 = sessionStatusModule_SessionStatusRepositoryFactoryCreate;
        this.sessionStatusProvider = SessionStatus_Factory.create(sessionStatusModule_SessionStatusRepositoryFactoryCreate);
        Provider<DocumentCaptureConfiguration> provider5 = DoubleCheck.provider(C4599xe5632e24.create(documentCaptureCoreModule));
        this.providesDocumentCaptureConfigurationProvider = provider5;
        this.fragmentArgsFactoryProvider = AdditionalInstructionsFragment_FragmentArgsFactory_Factory.create(this.applicationContextProvider, provider5);
        this.provideDocumentFeatureErrorToFailureMapperProvider = C4602x1c0ef2e1.create(selectionModule);
        this.providesEntityToScanConfigurationViewDataMapperProvider = C4601x1e27f87.create(scanModule);
        this.documentFeatureErrorToSessionStatusTypeMapperProvider = DocumentFeatureErrorToSessionStatusTypeMapper_Factory.create(ErrorToSessionStatusTypeMapper_Factory.create());
        this.documentViewModelHelperProvider = DocumentViewModelHelper_Factory.create(this.getDocumentCaptureConfigurationInteractorProvider, this.getScanConfigurationInteractorProvider, this.sessionStatusProvider, this.providesDocumentCaptureConfigurationProvider, this.fragmentArgsFactoryProvider, DocumentTypeEntityToViewDataMapper_Factory.create(), this.provideDocumentFeatureErrorToFailureMapperProvider, this.providesEntityToScanConfigurationViewDataMapperProvider, this.documentFeatureErrorToSessionStatusTypeMapperProvider);
        this.providesDocumentEducationalArgumentsToViewDataMapperProvider = C4603x60b7e788.create(selectionModule);
        CountryEntityToViewDataMapper_Factory countryEntityToViewDataMapper_FactoryCreate = CountryEntityToViewDataMapper_Factory.create(LocalisedCountriesProvider_Factory.create(), DocumentTypeEntityToViewDataMapper_Factory.create());
        this.countryEntityToViewDataMapperProvider = countryEntityToViewDataMapper_FactoryCreate;
        DocumentResourceConfigEntityToEducationalViewDataMapper_Factory documentResourceConfigEntityToEducationalViewDataMapper_FactoryCreate = DocumentResourceConfigEntityToEducationalViewDataMapper_Factory.create(this.providesDocumentEducationalArgumentsToViewDataMapperProvider, countryEntityToViewDataMapper_FactoryCreate, CaptureObjectiveTypeEntityToViewDataMapper_Factory.create());
        this.documentResourceConfigEntityToEducationalViewDataMapperProvider = documentResourceConfigEntityToEducationalViewDataMapper_FactoryCreate;
        DocumentEducationalViewModel_Factory documentEducationalViewModel_FactoryCreate = DocumentEducationalViewModel_Factory.create(this.documentViewModelHelperProvider, documentResourceConfigEntityToEducationalViewDataMapper_FactoryCreate, this.providesDocumentEducationalArgumentsToViewDataMapperProvider, DocumentTypeViewDataToEntityMapper_Factory.create(), this.providesDocumentCaptureConfigurationProvider);
        this.documentEducationalViewModelProvider = documentEducationalViewModel_FactoryCreate;
        this.providesDocumentEducationalViewModelProvider = ViewModelModule_ProvidesDocumentEducationalViewModelFactory.create(viewModelModule, documentEducationalViewModel_FactoryCreate);
        ValidationAndGuidanceEntityToViewDataMapper_Factory validationAndGuidanceEntityToViewDataMapper_FactoryCreate = ValidationAndGuidanceEntityToViewDataMapper_Factory.create(DocumentTypeEntityToViewDataMapper_Factory.create(), LocalisedCountriesProvider_Factory.create(), ApplicantProfileAddressFormatter_Factory.create(), ApplicantProfileDateOfBirthFormatter_Factory.create());
        this.validationAndGuidanceEntityToViewDataMapperProvider = validationAndGuidanceEntityToViewDataMapper_FactoryCreate;
        DocumentRequirementsViewModel_Factory documentRequirementsViewModel_FactoryCreate = DocumentRequirementsViewModel_Factory.create(this.documentViewModelHelperProvider, this.sessionStatusProvider, this.providesDocumentCaptureConfigurationProvider, validationAndGuidanceEntityToViewDataMapper_FactoryCreate);
        this.documentRequirementsViewModelProvider = documentRequirementsViewModel_FactoryCreate;
        this.providesDocumentRequirementsViewModelProvider = ViewModelModule_ProvidesDocumentRequirementsViewModelFactory.create(viewModelModule, documentRequirementsViewModel_FactoryCreate);
        SelectionModule_ProvidesEntityToSelectionViewDataFactory selectionModule_ProvidesEntityToSelectionViewDataFactoryCreate = SelectionModule_ProvidesEntityToSelectionViewDataFactory.create(selectionModule);
        this.providesEntityToSelectionViewDataProvider = selectionModule_ProvidesEntityToSelectionViewDataFactoryCreate;
        DocumentSelectionViewModel_Factory documentSelectionViewModel_FactoryCreate = DocumentSelectionViewModel_Factory.create(this.documentViewModelHelperProvider, this.sessionStatusProvider, selectionModule_ProvidesEntityToSelectionViewDataFactoryCreate, DocumentTypeViewDataToEntityMapper_Factory.create(), this.provideDocumentFeatureErrorToFailureMapperProvider, this.documentFeatureErrorToSessionStatusTypeMapperProvider, this.providesDocumentCaptureConfigurationProvider);
        this.documentSelectionViewModelProvider = documentSelectionViewModel_FactoryCreate;
        this.providesDocumentSelectionViewModelProvider = ViewModelModule_ProvidesDocumentSelectionViewModelFactory.create(viewModelModule, documentSelectionViewModel_FactoryCreate);
        Provider<IDocumentRepository<IDocumentEntity>> provider6 = DoubleCheck.provider(UploadModule_ProvidesDocumentRepositoryFactory.create(uploadModule));
        this.providesDocumentRepositoryProvider = provider6;
        this.uploadDocumentInteractorProvider = UploadDocumentInteractor_Factory.create(provider6, this.providesDocumentResourceConfigurationRepositoryProvider);
        this.providesDocumentCleanupInteractorProvider = UploadModule_ProvidesDocumentCleanupInteractorFactory.create(uploadModule);
        this.providesViewDataToUploadableEntityMapperProvider = UploadModule_ProvidesViewDataToUploadableEntityMapperFactory.create(uploadModule);
        this.providesUploadErrorToSessionStatusMapperProvider = UploadModule_ProvidesUploadErrorToSessionStatusMapperFactory.create(uploadModule);
        UploadModule_ProvidesUploadErrorToViewDataMapperFactory uploadModule_ProvidesUploadErrorToViewDataMapperFactoryCreate = UploadModule_ProvidesUploadErrorToViewDataMapperFactory.create(uploadModule);
        this.providesUploadErrorToViewDataMapperProvider = uploadModule_ProvidesUploadErrorToViewDataMapperFactoryCreate;
        DocumentUploadViewModel_Factory documentUploadViewModel_FactoryCreate = DocumentUploadViewModel_Factory.create(this.uploadDocumentInteractorProvider, this.providesDocumentCleanupInteractorProvider, this.providesViewDataToUploadableEntityMapperProvider, this.sessionStatusProvider, this.providesUploadErrorToSessionStatusMapperProvider, uploadModule_ProvidesUploadErrorToViewDataMapperFactoryCreate);
        this.documentUploadViewModelProvider = documentUploadViewModel_FactoryCreate;
        this.providesDocumentUploadViewModelProvider = ViewModelModule_ProvidesDocumentUploadViewModelFactory.create(viewModelModule, documentUploadViewModel_FactoryCreate);
        AdditionalInstructionsViewModel_Factory additionalInstructionsViewModel_FactoryCreate = AdditionalInstructionsViewModel_Factory.create(this.documentViewModelHelperProvider, this.providesDocumentCaptureConfigurationProvider, this.sessionStatusProvider, DocumentTypeViewDataToEntityMapper_Factory.create());
        this.additionalInstructionsViewModelProvider = additionalInstructionsViewModel_FactoryCreate;
        this.providesAdditionalInstructionsViewModelProvider = ViewModelModule_ProvidesAdditionalInstructionsViewModelFactory.create(viewModelModule, additionalInstructionsViewModel_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(5).put(DocumentEducationalViewModel.class, (Provider) this.providesDocumentEducationalViewModelProvider).put(DocumentRequirementsViewModel.class, (Provider) this.providesDocumentRequirementsViewModelProvider).put(DocumentSelectionViewModel.class, (Provider) this.providesDocumentSelectionViewModelProvider).put(DocumentUploadViewModel.class, (Provider) this.providesDocumentUploadViewModelProvider).put(AdditionalInstructionsViewModel.class, (Provider) this.providesAdditionalInstructionsViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        Provider<SavedStateHandleHolderViewModelFactoryProvider> provider7 = DoubleCheck.provider(SavedStateHandleHolderViewModelFactoryProvider_Factory.create(mapProviderFactoryBuild));
        this.savedStateHandleHolderViewModelFactoryProvider = provider7;
        this.f6687x63682e83 = DoubleCheck.provider(C4605x47d3d1c7.create(viewModelModule, provider7));
        this.providesScanNavigatorProvider = DoubleCheck.provider(ScanModule_ProvidesScanNavigatorProviderFactory.create(scanModule));
        this.providesSavedStateViewModelFactoryForDocumentEducationalProvider = DoubleCheck.provider(C4604x62562aa.create(viewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
        this.providesSavedStateViewModelFactoryForDocumentSelectionProvider = DoubleCheck.provider(C4606x412bc991.create(viewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
        this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(this.mapOfClassOfAndProviderOfViewModelProvider));
        this.providesSavedStateViewModelFactoryForDocumentUploadProvider = DoubleCheck.provider(C4607x3a3d74f6.create(viewModelModule, this.savedStateHandleHolderViewModelFactoryProvider));
        this.providesUploadNavigatorProvider = DoubleCheck.provider(UploadModule_ProvidesUploadNavigatorProviderFactory.create(uploadModule));
    }

    private AdditionalInstructionsFragment injectAdditionalInstructionsFragment(AdditionalInstructionsFragment additionalInstructionsFragment) {
        AdditionalInstructionsFragment_MembersInjector.injectViewModelFactory(additionalInstructionsFragment, this.viewModelFactoryProvider.get());
        AdditionalInstructionsFragment_MembersInjector.injectCoordinator(additionalInstructionsFragment, additionalInstructionsCoordinator());
        AdditionalInstructionsFragment_MembersInjector.injectFailureTypeToErrorTagMapper(additionalInstructionsFragment, new DocumentFailureTypeToErrorTagMapper());
        AdditionalInstructionsFragment_MembersInjector.injectErrorTagToViewEventMapper(additionalInstructionsFragment, new DocumentFeatureErrorTagToViewEventMapper());
        return additionalInstructionsFragment;
    }

    private CountrySelectionFragment injectCountrySelectionFragment(CountrySelectionFragment countrySelectionFragment) {
        CountrySelectionFragment_MembersInjector.injectCoordinator(countrySelectionFragment, documentSelectionCoordinator());
        CountrySelectionFragment_MembersInjector.injectFactory(countrySelectionFragment, this.providesSavedStateViewModelFactoryForDocumentSelectionProvider.get());
        return countrySelectionFragment;
    }

    private DocumentEducationalFragment injectDocumentEducationalFragment(DocumentEducationalFragment documentEducationalFragment) {
        DocumentEducationalFragment_MembersInjector.injectObjRequirementsAdapter(documentEducationalFragment, new ObjectiveRequirementsAdapter());
        DocumentEducationalFragment_MembersInjector.injectFactory(documentEducationalFragment, this.providesSavedStateViewModelFactoryForDocumentEducationalProvider.get());
        DocumentEducationalFragment_MembersInjector.injectCoordinator(documentEducationalFragment, documentNavigationCoordinatorHelper());
        DocumentEducationalFragment_MembersInjector.injectFailureTypeToErrorTagMapper(documentEducationalFragment, new DocumentFailureTypeToErrorTagMapper());
        DocumentEducationalFragment_MembersInjector.injectErrorTagToViewEventMapper(documentEducationalFragment, new DocumentFeatureErrorTagToViewEventMapper());
        return documentEducationalFragment;
    }

    private DocumentRequirementsFragment injectDocumentRequirementsFragment(DocumentRequirementsFragment documentRequirementsFragment) {
        DocumentRequirementsFragment_MembersInjector.injectFactory(documentRequirementsFragment, this.f6687x63682e83.get());
        DocumentRequirementsFragment_MembersInjector.injectCoordinator(documentRequirementsFragment, documentRequirementsCoordinator());
        DocumentRequirementsFragment_MembersInjector.injectFailureTypeToErrorTagMapper(documentRequirementsFragment, new DocumentFailureTypeToErrorTagMapper());
        DocumentRequirementsFragment_MembersInjector.injectErrorTagToViewEventMapper(documentRequirementsFragment, new DocumentFeatureErrorTagToViewEventMapper());
        return documentRequirementsFragment;
    }

    private DocumentSelectionFragment injectDocumentSelectionFragment(DocumentSelectionFragment documentSelectionFragment) {
        DocumentSelectionFragment_MembersInjector.injectDocumentsAdapter(documentSelectionFragment, new DocumentsAdapter());
        DocumentSelectionFragment_MembersInjector.injectCoordinator(documentSelectionFragment, documentSelectionCoordinator());
        DocumentSelectionFragment_MembersInjector.injectFailureTypeToErrorTagMapper(documentSelectionFragment, new DocumentFailureTypeToErrorTagMapper());
        DocumentSelectionFragment_MembersInjector.injectErrorTagToViewEventMapper(documentSelectionFragment, new DocumentFeatureErrorTagToViewEventMapper());
        DocumentSelectionFragment_MembersInjector.injectFactory(documentSelectionFragment, this.providesSavedStateViewModelFactoryForDocumentSelectionProvider.get());
        return documentSelectionFragment;
    }

    private DocumentUploadErrorFragment injectDocumentUploadErrorFragment(DocumentUploadErrorFragment documentUploadErrorFragment) {
        DocumentUploadErrorFragment_MembersInjector.injectNavigatorProvider(documentUploadErrorFragment, this.providesUploadNavigatorProvider.get());
        return documentUploadErrorFragment;
    }

    private DocumentUploadFragment injectDocumentUploadFragment(DocumentUploadFragment documentUploadFragment) {
        DocumentUploadFragment_MembersInjector.injectViewModelFactory(documentUploadFragment, this.providesSavedStateViewModelFactoryForDocumentUploadProvider.get());
        DocumentUploadFragment_MembersInjector.injectUploadNavigationProvider(documentUploadFragment, this.providesUploadNavigatorProvider.get());
        return documentUploadFragment;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(DocumentRequirementsFragment documentRequirementsFragment) {
        injectDocumentRequirementsFragment(documentRequirementsFragment);
    }

    private DaggerDocumentCaptureCoreComponent(DocumentCaptureCoreModule documentCaptureCoreModule, ResourceConfigurationModule resourceConfigurationModule, SelectionModule selectionModule, ScanModule scanModule, UploadModule uploadModule, RemoteModule remoteModule, ViewModelModule viewModelModule, SessionStatusModule sessionStatusModule, CommonModule commonModule) {
        this.documentCaptureCoreComponent = this;
        initialize(documentCaptureCoreModule, resourceConfigurationModule, selectionModule, scanModule, uploadModule, remoteModule, viewModelModule, sessionStatusModule, commonModule);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(DocumentEducationalFragment documentEducationalFragment) {
        injectDocumentEducationalFragment(documentEducationalFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(CountrySelectionFragment countrySelectionFragment) {
        injectCountrySelectionFragment(countrySelectionFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(DocumentSelectionFragment documentSelectionFragment) {
        injectDocumentSelectionFragment(documentSelectionFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(AdditionalInstructionsFragment additionalInstructionsFragment) {
        injectAdditionalInstructionsFragment(additionalInstructionsFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(DocumentUploadFragment documentUploadFragment) {
        injectDocumentUploadFragment(documentUploadFragment);
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreComponent
    public void inject(DocumentUploadErrorFragment documentUploadErrorFragment) {
        injectDocumentUploadErrorFragment(documentUploadErrorFragment);
    }
}
