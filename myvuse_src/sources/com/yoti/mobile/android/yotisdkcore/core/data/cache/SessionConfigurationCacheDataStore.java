package com.yoti.mobile.android.yotisdkcore.core.data.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ConfigurationPreferences;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0017J\u0016\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/cache/SessionConfigurationCacheDataStore;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/ISessionConfigurationCacheDataStore;", "preferences", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/SharedPreferences;Lcom/google/gson/Gson;)V", "deleteConfigurations", "", "saveConfigurations", "configurations", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationCacheDataStore implements ISessionConfigurationCacheDataStore {
    private final Gson gson;
    private final SharedPreferences preferences;

    @Inject
    public SessionConfigurationCacheDataStore(@ConfigurationPreferences SharedPreferences preferences, Gson gson) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.preferences = preferences;
        this.gson = gson;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore
    public void deleteConfigurations() {
        this.preferences.edit().clear().commit();
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore
    public void saveConfigurations(List<ResourceConfiguration> configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        for (ResourceConfiguration resourceConfiguration : configurations) {
            Gson gson = this.gson;
            editorEdit.putString(resourceConfiguration.getRequirementId(), !(gson instanceof Gson) ? gson.toJson(resourceConfiguration) : GsonInstrumentation.toJson(gson, resourceConfiguration));
        }
        editorEdit.apply();
    }
}
