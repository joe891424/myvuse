package com.yoti.mobile.android.yotisdkcore.core.view;

import android.os.Parcelable;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "Landroid/os/Parcelable;", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "getUiSessionConfiguration", "()Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IFeatureConfiguration extends Parcelable {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static UiSessionConfiguration getUiSessionConfiguration(IFeatureConfiguration iFeatureConfiguration) {
            return new UiSessionConfiguration(null, null, false, 7, null);
        }
    }

    UiSessionConfiguration getUiSessionConfiguration();
}
