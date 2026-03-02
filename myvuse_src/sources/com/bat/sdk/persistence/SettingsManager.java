package com.bat.sdk.persistence;

import com.bat.sdk.domain.Configuration;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0013J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, m5598d2 = {"Lcom/bat/sdk/persistence/SettingsManager;", "", "settings", "Lcom/bat/sdk/persistence/Settings;", "<init>", "(Lcom/bat/sdk/persistence/Settings;)V", "value", "", "saveLogs", "getSaveLogs", "()Z", "setSaveLogs", "(Z)V", "applyConfiguration", "", "configuration", "Lcom/bat/sdk/domain/Configuration;", "saveAutoUnlockJobStart", "deviceAddress", "", "isAutoUnlockJobStarted", "getAutoUnlockJobStart", "getAutoUnlockMap", "", "cleanAutoUnlockJobStart", "saveDeviceAddress", "device", "getDeviceAddresses", "", "cleanDeviceAddresses", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class SettingsManager {
    private final Settings settings;

    public SettingsManager(Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
    }

    public final void setSaveLogs(boolean z) {
        this.settings.set("save_logs", z);
    }

    public final boolean getSaveLogs() {
        return this.settings.getBoolean("save_logs");
    }

    public final void applyConfiguration(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        setSaveLogs(configuration.getSaveLogs());
    }

    public final void saveAutoUnlockJobStart(String deviceAddress, boolean isAutoUnlockJobStarted) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Map mutableMap = MapsKt.toMutableMap(getAutoUnlockMap());
        mutableMap.put(deviceAddress, Boolean.valueOf(isAutoUnlockJobStarted));
        Gson gson = new Gson();
        String json = !(gson instanceof Gson) ? gson.toJson(mutableMap) : GsonInstrumentation.toJson(gson, mutableMap);
        Settings settings = this.settings;
        Intrinsics.checkNotNull(json);
        settings.set("auto_unlock_map", json);
    }

    public final boolean getAutoUnlockJobStart(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Boolean bool = getAutoUnlockMap().get(deviceAddress);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final Map<String, Boolean> getAutoUnlockMap() {
        String string = this.settings.getString("auto_unlock_map");
        Type type = new TypeToken<Map<String, ? extends Boolean>>() { // from class: com.bat.sdk.persistence.SettingsManager$getAutoUnlockMap$type$1
        }.getType();
        Gson gson = new Gson();
        Map<String, Boolean> map = (Map) (!(gson instanceof Gson) ? gson.fromJson(string, type) : GsonInstrumentation.fromJson(gson, string, type));
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final void cleanAutoUnlockJobStart(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Map mutableMap = MapsKt.toMutableMap(getAutoUnlockMap());
        mutableMap.remove(deviceAddress);
        Gson gson = new Gson();
        String json = !(gson instanceof Gson) ? gson.toJson(mutableMap) : GsonInstrumentation.toJson(gson, mutableMap);
        Settings settings = this.settings;
        Intrinsics.checkNotNull(json);
        settings.set("auto_unlock_map", json);
    }

    public final void cleanAutoUnlockJobStart() {
        this.settings.remove("auto_unlock_map");
    }

    public final void saveDeviceAddress(String device) {
        Intrinsics.checkNotNullParameter(device, "device");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) getDeviceAddresses());
        mutableList.add(device);
        this.settings.set("device_addresses", mutableList);
    }

    public final List<String> getDeviceAddresses() {
        return this.settings.getStringSet("device_addresses");
    }

    public final void cleanDeviceAddresses(String device) {
        Intrinsics.checkNotNullParameter(device, "device");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) getDeviceAddresses());
        mutableList.remove(device);
        this.settings.set("device_addresses", mutableList);
    }

    public final void cleanDeviceAddresses() {
        this.settings.remove("device_addresses");
    }
}
