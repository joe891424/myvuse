package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelProviderMapProvider;

    public ViewModelFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.viewModelProviderMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public ViewModelFactory get() {
        return newInstance(this.viewModelProviderMapProvider.get());
    }

    public static ViewModelFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new ViewModelFactory_Factory(provider);
    }

    public static ViewModelFactory newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new ViewModelFactory(map);
    }
}
