package com.yoti.mobile.android.yotisdkcore.core.data.cache;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ConfigurationPreferences;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/cache/ResourceConfigurationCacheDataStore;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "preferences", "Landroid/content/SharedPreferences;", "requirementId", "", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/google/gson/Gson;)V", "getResourceConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ResourceConfigurationCacheDataStore implements IResourceConfigurationCacheDataStore {
    private final Gson gson;
    private final SharedPreferences preferences;
    private final String requirementId;

    @Inject
    public ResourceConfigurationCacheDataStore(@ConfigurationPreferences SharedPreferences preferences, @RequirementId String requirementId, Gson gson) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.preferences = preferences;
        this.requirementId = requirementId;
        this.gson = gson;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore
    public ResourceConfiguration getResourceConfiguration() {
        String string = this.preferences.getString(this.requirementId, null);
        if (string == null) {
            throw new IllegalStateException("No resource cached for " + this.requirementId);
        }
        Gson gson = this.gson;
        Object objFromJson = !(gson instanceof Gson) ? gson.fromJson(string, ResourceConfiguration.class) : GsonInstrumentation.fromJson(gson, string, ResourceConfiguration.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(requiremen…onfiguration::class.java)");
        return (ResourceConfiguration) objFromJson;
    }
}
