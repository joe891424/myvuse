package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B8\u0012)\u0010\u0002\u001a%\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ7\u0010\f\u001a\u0002H\r\"\n\b\u0000\u0010\r*\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0014¢\u0006\u0002\u0010\u0013R1\u0010\u0002\u001a%\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "viewModelProviderMap", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelProviderMap;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Ljava/util/Map;Landroidx/savedstate/SavedStateRegistryOwner;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "modelClass", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
final class SavedStateHandleHolderViewModelFactory extends AbstractSavedStateViewModelFactory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedStateHandleHolderViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap, SavedStateRegistryOwner owner) {
        super(owner, null);
        Intrinsics.checkNotNullParameter(viewModelProviderMap, "viewModelProviderMap");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.viewModelProviderMap = viewModelProviderMap;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        Provider<ViewModel> provider = this.viewModelProviderMap.get(modelClass);
        Intrinsics.checkNotNull(provider);
        ViewModel viewModel = provider.get();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get()");
        T t = (T) viewModel;
        if (t instanceof SavedStateHandleHolder) {
            ((SavedStateHandleHolder) t).setSavedStateHandle(handle);
        }
        return t;
    }
}
