package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0007\u0012)\u0010\u0002\u001a%\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003j\u0002`\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR1\u0010\u0002\u001a%\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "", "viewModelProviderMap", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelProviderMap;", "(Ljava/util/Map;)V", "create", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SavedStateHandleHolderViewModelFactoryProvider {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap;

    @Inject
    public SavedStateHandleHolderViewModelFactoryProvider(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap) {
        Intrinsics.checkNotNullParameter(viewModelProviderMap, "viewModelProviderMap");
        this.viewModelProviderMap = viewModelProviderMap;
    }

    public final AbstractSavedStateViewModelFactory create(SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        return new SavedStateHandleHolderViewModelFactory(this.viewModelProviderMap, owner);
    }
}
