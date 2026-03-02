package com.yoti.mobile.android.yotisdkcore.core.view;

import androidx.fragment.app.Fragment;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncher;", "", "()V", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "getFeatureConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "setFeatureConfiguration", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;)V", BackgroundFetch.ACTION_CONFIGURE, "", "start", "fragment", "Landroidx/fragment/app/Fragment;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FeatureLauncher {
    protected IFeatureConfiguration featureConfiguration;

    public final void configure(IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        setFeatureConfiguration(featureConfiguration);
    }

    protected final IFeatureConfiguration getFeatureConfiguration() {
        IFeatureConfiguration iFeatureConfiguration = this.featureConfiguration;
        if (iFeatureConfiguration != null) {
            return iFeatureConfiguration;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureConfiguration");
        return null;
    }

    protected final void setFeatureConfiguration(IFeatureConfiguration iFeatureConfiguration) {
        Intrinsics.checkNotNullParameter(iFeatureConfiguration, "<set-?>");
        this.featureConfiguration = iFeatureConfiguration;
    }

    public abstract void start(Fragment fragment);
}
