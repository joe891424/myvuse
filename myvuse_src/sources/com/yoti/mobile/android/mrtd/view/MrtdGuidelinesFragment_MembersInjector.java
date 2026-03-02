package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdGuidelinesFragment_MembersInjector implements MembersInjector<MrtdGuidelinesFragment> {
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public MrtdGuidelinesFragment_MembersInjector(Provider<ViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<MrtdGuidelinesFragment> create(Provider<ViewModelFactory> provider) {
        return new MrtdGuidelinesFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(MrtdGuidelinesFragment mrtdGuidelinesFragment, ViewModelFactory viewModelFactory) {
        mrtdGuidelinesFragment.viewModelFactory = viewModelFactory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MrtdGuidelinesFragment mrtdGuidelinesFragment) {
        injectViewModelFactory(mrtdGuidelinesFragment, this.viewModelFactoryProvider.get());
    }
}
