package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewModelFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B.\b\u0007\u0012%\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016¢\u0006\u0002\u0010\fR-\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelProviderMap", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap) {
        Intrinsics.checkNotNullParameter(viewModelProviderMap, "viewModelProviderMap");
        this.viewModelProviderMap = viewModelProviderMap;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Provider<ViewModel> provider = this.viewModelProviderMap.get(modelClass);
        Intrinsics.checkNotNull(provider);
        ViewModel viewModel = provider.get();
        if (viewModel != null) {
            return (T) viewModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.yoti.mobile.android.commonui.di.viewmodel.ViewModelFactory.create");
    }
}
