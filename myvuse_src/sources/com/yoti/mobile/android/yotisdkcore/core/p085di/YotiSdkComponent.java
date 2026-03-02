package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.YotiSdk;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {CommonModule.class, SessionStatusModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/YotiSdkComponent;", "", "inject", "", "yotiSdk", "Lcom/yoti/mobile/android/yotisdkcore/YotiSdk;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface YotiSdkComponent {
    void inject(YotiSdk yotiSdk);
}
