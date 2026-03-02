package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SavedStateHandleHolderViewModelFactoryProvider_Factory implements Factory<SavedStateHandleHolderViewModelFactoryProvider> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelProviderMapProvider;

    public SavedStateHandleHolderViewModelFactoryProvider_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.viewModelProviderMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public SavedStateHandleHolderViewModelFactoryProvider get() {
        return newInstance(this.viewModelProviderMapProvider.get());
    }

    public static SavedStateHandleHolderViewModelFactoryProvider_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new SavedStateHandleHolderViewModelFactoryProvider_Factory(provider);
    }

    public static SavedStateHandleHolderViewModelFactoryProvider newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new SavedStateHandleHolderViewModelFactoryProvider(map);
    }
}
