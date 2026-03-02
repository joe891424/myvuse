package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.domain.INfcDispatcher;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCaptureActivity_MembersInjector implements MembersInjector<MrtdCaptureActivity> {
    private final Provider<INfcDispatcher> nfcDispatcherProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public MrtdCaptureActivity_MembersInjector(Provider<ViewModelFactory> provider, Provider<INfcDispatcher> provider2) {
        this.viewModelFactoryProvider = provider;
        this.nfcDispatcherProvider = provider2;
    }

    public static MembersInjector<MrtdCaptureActivity> create(Provider<ViewModelFactory> provider, Provider<INfcDispatcher> provider2) {
        return new MrtdCaptureActivity_MembersInjector(provider, provider2);
    }

    public static void injectNfcDispatcher(MrtdCaptureActivity mrtdCaptureActivity, INfcDispatcher iNfcDispatcher) {
        mrtdCaptureActivity.nfcDispatcher = iNfcDispatcher;
    }

    public static void injectViewModelFactory(MrtdCaptureActivity mrtdCaptureActivity, ViewModelFactory viewModelFactory) {
        mrtdCaptureActivity.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MrtdCaptureActivity mrtdCaptureActivity) {
        injectViewModelFactory(mrtdCaptureActivity, this.viewModelFactoryProvider.get());
        injectNfcDispatcher(mrtdCaptureActivity, this.nfcDispatcherProvider.get());
    }
}
