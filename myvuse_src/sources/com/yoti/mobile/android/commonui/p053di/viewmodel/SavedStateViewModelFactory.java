package com.yoti.mobile.android.commonui.p053di.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
@EspressoOpen
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\t\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "VM", "Landroidx/lifecycle/ViewModel;", "", "viewModelClass", "Ljava/lang/Class;", "savedStateViewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "(Ljava/lang/Class;Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;)V", "create", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Landroidx/lifecycle/ViewModel;", "viewModelOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/ViewModel;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class SavedStateViewModelFactory<VM extends ViewModel> {
    private final SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider;
    private final Class<VM> viewModelClass;

    @Inject
    public SavedStateViewModelFactory(Class<VM> viewModelClass, SavedStateHandleHolderViewModelFactoryProvider savedStateViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(savedStateViewModelFactoryProvider, "savedStateViewModelFactoryProvider");
        this.viewModelClass = viewModelClass;
        this.savedStateViewModelFactoryProvider = savedStateViewModelFactoryProvider;
    }

    public VM create(ViewModelStoreOwner viewModelOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(viewModelOwner, "viewModelOwner");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        return (VM) new ViewModelProvider(viewModelOwner, this.savedStateViewModelFactoryProvider.create(savedStateRegistryOwner)).get(this.viewModelClass);
    }

    public VM create(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return (VM) create(activity, activity);
    }

    public VM create(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return (VM) create(fragment, fragment);
    }
}
