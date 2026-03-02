package com.yoti.mobile.android.mrtd.p073di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelKey;
import com.yoti.mobile.android.mrtd.view.MrtdScanViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/di/ViewModelModule;", "", "()V", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "bindViewModelFactory$mrtd_productionRelease", "bindsConfigurationViewModel", "Landroidx/lifecycle/ViewModel;", "configurationViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public abstract class ViewModelModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory$mrtd_productionRelease(ViewModelFactory factory);

    @ViewModelKey(MrtdScanViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel bindsConfigurationViewModel(MrtdScanViewModel configurationViewModel);
}
