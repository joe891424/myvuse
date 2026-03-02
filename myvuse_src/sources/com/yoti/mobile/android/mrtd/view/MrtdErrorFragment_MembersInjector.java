package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdErrorFragment_MembersInjector implements MembersInjector<MrtdErrorFragment> {
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public MrtdErrorFragment_MembersInjector(Provider<ViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<MrtdErrorFragment> create(Provider<ViewModelFactory> provider) {
        return new MrtdErrorFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(MrtdErrorFragment mrtdErrorFragment, ViewModelFactory viewModelFactory) {
        mrtdErrorFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MrtdErrorFragment mrtdErrorFragment) {
        injectViewModelFactory(mrtdErrorFragment, this.viewModelFactoryProvider.get());
    }
}
