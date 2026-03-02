package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdReadFragment_MembersInjector implements MembersInjector<MrtdReadFragment> {
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public MrtdReadFragment_MembersInjector(Provider<ViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<MrtdReadFragment> create(Provider<ViewModelFactory> provider) {
        return new MrtdReadFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(MrtdReadFragment mrtdReadFragment, ViewModelFactory viewModelFactory) {
        mrtdReadFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MrtdReadFragment mrtdReadFragment) {
        injectViewModelFactory(mrtdReadFragment, this.viewModelFactoryProvider.get());
    }
}
