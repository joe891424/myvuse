package com.yoti.mobile.android.liveness.view.educational;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessEducationalFragment_MembersInjector implements MembersInjector<LivenessEducationalFragment> {
    private final Provider<ILivenessEducationalNavigatorProvider<ILivenessResourceEntity>> navigatorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public LivenessEducationalFragment_MembersInjector(Provider<ILivenessEducationalNavigatorProvider<ILivenessResourceEntity>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.navigatorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<LivenessEducationalFragment> create(Provider<ILivenessEducationalNavigatorProvider<ILivenessResourceEntity>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new LivenessEducationalFragment_MembersInjector(provider, provider2);
    }

    public static void injectNavigatorProvider(LivenessEducationalFragment livenessEducationalFragment, ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> iLivenessEducationalNavigatorProvider) {
        livenessEducationalFragment.navigatorProvider = iLivenessEducationalNavigatorProvider;
    }

    public static void injectViewModelFactory(LivenessEducationalFragment livenessEducationalFragment, ViewModelProvider.Factory factory) {
        livenessEducationalFragment.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessEducationalFragment livenessEducationalFragment) {
        injectNavigatorProvider(livenessEducationalFragment, this.navigatorProvider.get());
        injectViewModelFactory(livenessEducationalFragment, this.viewModelFactoryProvider.get());
    }
}
