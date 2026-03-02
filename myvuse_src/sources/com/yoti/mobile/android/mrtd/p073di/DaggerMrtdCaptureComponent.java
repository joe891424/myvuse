package com.yoti.mobile.android.mrtd.p073di;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.ViewModel;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory_Factory;
import com.yoti.mobile.android.mrtd.data.MrtdControllerFactory_Factory;
import com.yoti.mobile.android.mrtd.data.MrtdReaderFactory_Factory;
import com.yoti.mobile.android.mrtd.data.MrtdReaderProducer;
import com.yoti.mobile.android.mrtd.data.MrtdReaderProducer_Factory;
import com.yoti.mobile.android.mrtd.data.NfcEventMapper_Factory;
import com.yoti.mobile.android.mrtd.data.NfcPlatformController;
import com.yoti.mobile.android.mrtd.data.NfcPlatformController_Factory;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository_Factory;
import com.yoti.mobile.android.mrtd.data.ReaderQueueFactory_Factory;
import com.yoti.mobile.android.mrtd.domain.INfcDispatcher;
import com.yoti.mobile.android.mrtd.domain.INfcReadController;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import com.yoti.mobile.android.mrtd.domain.INfcTagProcessor;
import com.yoti.mobile.android.mrtd.domain.MrtdErrorHandler_Factory;
import com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase;
import com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase_Factory;
import com.yoti.mobile.android.mrtd.domain.NfcDispatcher;
import com.yoti.mobile.android.mrtd.domain.NfcEnabledInteractor;
import com.yoti.mobile.android.mrtd.domain.NfcEnabledInteractor_Factory;
import com.yoti.mobile.android.mrtd.domain.NfcStartListeningUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcStartListeningUseCase_Factory;
import com.yoti.mobile.android.mrtd.domain.NfcStopListeningUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcStopListeningUseCase_Factory;
import com.yoti.mobile.android.mrtd.domain.NfcTagProcessor;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity;
import com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity_MembersInjector;
import com.yoti.mobile.android.mrtd.view.MrtdErrorFragment;
import com.yoti.mobile.android.mrtd.view.MrtdErrorFragment_MembersInjector;
import com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment;
import com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment_MembersInjector;
import com.yoti.mobile.android.mrtd.view.MrtdReadFragment;
import com.yoti.mobile.android.mrtd.view.MrtdReadFragment_MembersInjector;
import com.yoti.mobile.android.mrtd.view.MrtdScanFragment;
import com.yoti.mobile.android.mrtd.view.MrtdScanFragment_MembersInjector;
import com.yoti.mobile.android.mrtd.view.MrtdScanViewModel;
import com.yoti.mobile.android.mrtd.view.MrtdScanViewModel_Factory;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule_ApplicationContextFactory;
import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DaggerMrtdCaptureComponent implements MrtdCaptureComponent {
    private Provider<Context> applicationContextProvider;
    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
    private final DaggerMrtdCaptureComponent mrtdCaptureComponent;
    private final MrtdCaptureModule mrtdCaptureModule;
    private final MrtdCoreModule mrtdCoreModule;
    private Provider<MrtdGetReadEventsUseCase> mrtdGetReadEventsUseCaseProvider;
    private Provider<MrtdReaderProducer> mrtdReaderProducerProvider;
    private Provider<MrtdScanViewModel> mrtdScanViewModelProvider;
    private Provider<NfcEnabledInteractor> nfcEnabledInteractorProvider;
    private Provider<NfcPlatformController> nfcPlatformControllerProvider;
    private Provider<NfcStartListeningUseCase> nfcStartListeningUseCaseProvider;
    private Provider<NfcStateRepository> nfcStateRepositoryProvider;
    private Provider<NfcStopListeningUseCase> nfcStopListeningUseCaseProvider;
    private Provider<BacCredential> provideAuthDataProvider;
    private Provider<MrtdAuthentication> provideAuthenticatorProvider;
    private Provider<LocalBroadcastManager> provideBroadcastManagerProvider;
    private Provider<NfcAdapter> provideNfcAdapterProvider;
    private Provider<INfcReadController> provideNfcControllerProvider;
    private Provider<INfcStateRepository> provideNfcRepositoryProvider;
    private Provider<ViewModelFactory> viewModelFactoryProvider;

    public static final class Builder {
        private CommonModule commonModule;
        private MrtdCaptureModule mrtdCaptureModule;
        private MrtdCoreModule mrtdCoreModule;

        private Builder() {
        }

        public MrtdCaptureComponent build() {
            if (this.mrtdCoreModule == null) {
                this.mrtdCoreModule = new MrtdCoreModule();
            }
            Preconditions.checkBuilderRequirement(this.mrtdCaptureModule, MrtdCaptureModule.class);
            Preconditions.checkBuilderRequirement(this.commonModule, CommonModule.class);
            return new DaggerMrtdCaptureComponent(this.mrtdCoreModule, this.mrtdCaptureModule, this.commonModule);
        }

        public Builder commonModule(CommonModule commonModule) {
            this.commonModule = (CommonModule) Preconditions.checkNotNull(commonModule);
            return this;
        }

        public Builder mrtdCaptureModule(MrtdCaptureModule mrtdCaptureModule) {
            this.mrtdCaptureModule = (MrtdCaptureModule) Preconditions.checkNotNull(mrtdCaptureModule);
            return this;
        }

        public Builder mrtdCoreModule(MrtdCoreModule mrtdCoreModule) {
            this.mrtdCoreModule = (MrtdCoreModule) Preconditions.checkNotNull(mrtdCoreModule);
            return this;
        }
    }

    private DaggerMrtdCaptureComponent(MrtdCoreModule mrtdCoreModule, MrtdCaptureModule mrtdCaptureModule, CommonModule commonModule) {
        this.mrtdCaptureComponent = this;
        this.mrtdCoreModule = mrtdCoreModule;
        this.mrtdCaptureModule = mrtdCaptureModule;
        initialize(mrtdCoreModule, mrtdCaptureModule, commonModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private INfcDispatcher iNfcDispatcher() {
        return C4905x5b0dd172.provideNfcDispatcher$mrtd_productionRelease(this.mrtdCoreModule, nfcDispatcher());
    }

    private INfcTagProcessor iNfcTagProcessor() {
        return C4906x5fe47894.providesNfcTagProcessor$mrtd_productionRelease(this.mrtdCoreModule, nfcTagProcessor());
    }

    private void initialize(MrtdCoreModule mrtdCoreModule, MrtdCaptureModule mrtdCaptureModule, CommonModule commonModule) {
        Provider<Context> provider = DoubleCheck.provider(CommonModule_ApplicationContextFactory.create(commonModule));
        this.applicationContextProvider = provider;
        MrtdCoreModule_ProvideNfcAdapterFactory mrtdCoreModule_ProvideNfcAdapterFactoryCreate = MrtdCoreModule_ProvideNfcAdapterFactory.create(mrtdCoreModule, provider);
        this.provideNfcAdapterProvider = mrtdCoreModule_ProvideNfcAdapterFactoryCreate;
        NfcStateRepository_Factory nfcStateRepository_FactoryCreate = NfcStateRepository_Factory.create(mrtdCoreModule_ProvideNfcAdapterFactoryCreate);
        this.nfcStateRepositoryProvider = nfcStateRepository_FactoryCreate;
        MrtdCoreModule_ProvideNfcRepositoryFactory mrtdCoreModule_ProvideNfcRepositoryFactoryCreate = MrtdCoreModule_ProvideNfcRepositoryFactory.create(mrtdCoreModule, nfcStateRepository_FactoryCreate);
        this.provideNfcRepositoryProvider = mrtdCoreModule_ProvideNfcRepositoryFactoryCreate;
        this.nfcEnabledInteractorProvider = NfcEnabledInteractor_Factory.create(mrtdCoreModule_ProvideNfcRepositoryFactoryCreate);
        Provider<BacCredential> provider2 = DoubleCheck.provider(MrtdCaptureModule_ProvideAuthDataFactory.create(mrtdCaptureModule));
        this.provideAuthDataProvider = provider2;
        this.provideAuthenticatorProvider = MrtdCaptureModule_ProvideAuthenticatorFactory.create(mrtdCaptureModule, provider2);
        MrtdCaptureModule_ProvideBroadcastManagerFactory mrtdCaptureModule_ProvideBroadcastManagerFactoryCreate = MrtdCaptureModule_ProvideBroadcastManagerFactory.create(mrtdCaptureModule, this.applicationContextProvider);
        this.provideBroadcastManagerProvider = mrtdCaptureModule_ProvideBroadcastManagerFactoryCreate;
        MrtdReaderProducer_Factory mrtdReaderProducer_FactoryCreate = MrtdReaderProducer_Factory.create(mrtdCaptureModule_ProvideBroadcastManagerFactoryCreate, ReaderQueueFactory_Factory.create(), MrtdControllerFactory_Factory.create(), MrtdReaderFactory_Factory.create());
        this.mrtdReaderProducerProvider = mrtdReaderProducer_FactoryCreate;
        Provider<NfcPlatformController> provider3 = DoubleCheck.provider(NfcPlatformController_Factory.create(this.provideAuthenticatorProvider, mrtdReaderProducer_FactoryCreate, NfcEventMapper_Factory.create()));
        this.nfcPlatformControllerProvider = provider3;
        MrtdCaptureModule_ProvideNfcControllerFactory mrtdCaptureModule_ProvideNfcControllerFactoryCreate = MrtdCaptureModule_ProvideNfcControllerFactory.create(mrtdCaptureModule, provider3);
        this.provideNfcControllerProvider = mrtdCaptureModule_ProvideNfcControllerFactoryCreate;
        this.nfcStartListeningUseCaseProvider = NfcStartListeningUseCase_Factory.create(mrtdCaptureModule_ProvideNfcControllerFactoryCreate);
        this.mrtdGetReadEventsUseCaseProvider = MrtdGetReadEventsUseCase_Factory.create(this.provideNfcControllerProvider, MrtdErrorHandler_Factory.create());
        NfcStopListeningUseCase_Factory nfcStopListeningUseCase_FactoryCreate = NfcStopListeningUseCase_Factory.create(this.provideNfcControllerProvider);
        this.nfcStopListeningUseCaseProvider = nfcStopListeningUseCase_FactoryCreate;
        this.mrtdScanViewModelProvider = MrtdScanViewModel_Factory.create(this.nfcEnabledInteractorProvider, this.nfcStartListeningUseCaseProvider, this.mrtdGetReadEventsUseCaseProvider, nfcStopListeningUseCase_FactoryCreate);
        MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(1).put(MrtdScanViewModel.class, (Provider) this.mrtdScanViewModelProvider).build();
        this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
        this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(mapProviderFactoryBuild));
    }

    private MrtdCaptureActivity injectMrtdCaptureActivity(MrtdCaptureActivity mrtdCaptureActivity) {
        MrtdCaptureActivity_MembersInjector.injectViewModelFactory(mrtdCaptureActivity, this.viewModelFactoryProvider.get());
        MrtdCaptureActivity_MembersInjector.injectNfcDispatcher(mrtdCaptureActivity, iNfcDispatcher());
        return mrtdCaptureActivity;
    }

    private MrtdErrorFragment injectMrtdErrorFragment(MrtdErrorFragment mrtdErrorFragment) {
        MrtdErrorFragment_MembersInjector.injectViewModelFactory(mrtdErrorFragment, this.viewModelFactoryProvider.get());
        return mrtdErrorFragment;
    }

    private MrtdGuidelinesFragment injectMrtdGuidelinesFragment(MrtdGuidelinesFragment mrtdGuidelinesFragment) {
        MrtdGuidelinesFragment_MembersInjector.injectViewModelFactory(mrtdGuidelinesFragment, this.viewModelFactoryProvider.get());
        return mrtdGuidelinesFragment;
    }

    private MrtdReadFragment injectMrtdReadFragment(MrtdReadFragment mrtdReadFragment) {
        MrtdReadFragment_MembersInjector.injectViewModelFactory(mrtdReadFragment, this.viewModelFactoryProvider.get());
        return mrtdReadFragment;
    }

    private MrtdScanFragment injectMrtdScanFragment(MrtdScanFragment mrtdScanFragment) {
        MrtdScanFragment_MembersInjector.injectViewModelFactory(mrtdScanFragment, this.viewModelFactoryProvider.get());
        return mrtdScanFragment;
    }

    private LocalBroadcastManager localBroadcastManager() {
        return MrtdCaptureModule_ProvideBroadcastManagerFactory.provideBroadcastManager(this.mrtdCaptureModule, this.applicationContextProvider.get());
    }

    private NfcAdapter nfcAdapter() {
        return this.mrtdCoreModule.provideNfcAdapter(this.applicationContextProvider.get());
    }

    private NfcDispatcher nfcDispatcher() {
        return new NfcDispatcher(nfcAdapter(), iNfcTagProcessor());
    }

    private NfcTagProcessor nfcTagProcessor() {
        return new NfcTagProcessor(localBroadcastManager());
    }

    @Override // com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent
    public void inject(MrtdCaptureActivity mrtdCaptureActivity) {
        injectMrtdCaptureActivity(mrtdCaptureActivity);
    }

    @Override // com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent
    public void inject(MrtdErrorFragment mrtdErrorFragment) {
        injectMrtdErrorFragment(mrtdErrorFragment);
    }

    @Override // com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent
    public void inject(MrtdGuidelinesFragment mrtdGuidelinesFragment) {
        injectMrtdGuidelinesFragment(mrtdGuidelinesFragment);
    }

    @Override // com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent
    public void inject(MrtdReadFragment mrtdReadFragment) {
        injectMrtdReadFragment(mrtdReadFragment);
    }

    @Override // com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent
    public void inject(MrtdScanFragment mrtdScanFragment) {
        injectMrtdScanFragment(mrtdScanFragment);
    }
}
