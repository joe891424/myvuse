package com.yoti.mobile.android.yotisdkcore.core.data.repository;

import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/ISessionConfigurationCacheDataStore;", "", "deleteConfigurations", "", "saveConfigurations", "configurations", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ISessionConfigurationCacheDataStore {
    void deleteConfigurations();

    void saveConfigurations(List<ResourceConfiguration> configurations);
}
