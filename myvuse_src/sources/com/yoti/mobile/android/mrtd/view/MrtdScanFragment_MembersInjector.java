package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdScanFragment_MembersInjector implements MembersInjector<MrtdScanFragment> {
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public MrtdScanFragment_MembersInjector(Provider<ViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<MrtdScanFragment> create(Provider<ViewModelFactory> provider) {
        return new MrtdScanFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(MrtdScanFragment mrtdScanFragment, ViewModelFactory viewModelFactory) {
        mrtdScanFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MrtdScanFragment mrtdScanFragment) {
        injectViewModelFactory(mrtdScanFragment, this.viewModelFactoryProvider.get());
    }
}
