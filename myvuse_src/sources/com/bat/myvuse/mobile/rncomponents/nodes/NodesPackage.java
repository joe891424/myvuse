package com.bat.myvuse.mobile.rncomponents.nodes;

import com.bat.sdk.BatSdk;
import com.bat.sdk.FirmwareManager;
import com.bat.sdk.age.AgeVerifier;
import com.bat.sdk.asav.AsavModule;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.ble.Bonding;
import com.bat.sdk.ble.BtProximityUnlock;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.BatteryClient;
import com.bat.sdk.client.BleTimeoutClient;
import com.bat.sdk.client.BuzzerClient;
import com.bat.sdk.client.CloudClient;
import com.bat.sdk.client.DeviceInfoClient;
import com.bat.sdk.client.ErrorClient;
import com.bat.sdk.client.FindVapeClient;
import com.bat.sdk.client.HapticClient;
import com.bat.sdk.client.LedClient;
import com.bat.sdk.client.LockClient;
import com.bat.sdk.client.LogsClient;
import com.bat.sdk.client.PodConnectionClient;
import com.bat.sdk.client.PowerSaveModeClient;
import com.bat.sdk.client.PuffsClient;
import com.bat.sdk.client.RechargeRemindersClient;
import com.bat.sdk.client.ResetClient;
import com.bat.sdk.client.TimeClient;
import com.bat.sdk.client.TimeoutAutoLockClient;
import com.bat.sdk.client.UsageReminderClient;
import com.bat.sdk.payload.PayloadUploader;
import com.bat.sdk.persistence.SettingsManager;
import com.bat.sdk.persistence.repository.BatDevicesRepository;
import com.bat.sdk.persistence.repository.PuffRecordRepository;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NodesPackage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020EH\u0002¨\u0006F"}, m5598d2 = {"Lcom/bat/myvuse/mobile/rncomponents/nodes/NodesPackage;", "Lcom/facebook/react/ReactPackage;", "()V", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "getAgeVerifier", "Lcom/bat/sdk/age/AgeVerifier;", "getAsav", "Lcom/bat/sdk/asav/AsavModule;", "getBatDevicesRepository", "Lcom/bat/sdk/persistence/repository/BatDevicesRepository;", "getBatteryClient", "Lcom/bat/sdk/client/BatteryClient;", "getBleTimeoutClient", "Lcom/bat/sdk/client/BleTimeoutClient;", "getBonding", "Lcom/bat/sdk/ble/Bonding;", "getBuzzerClient", "Lcom/bat/sdk/client/BuzzerClient;", "getCloudClient", "Lcom/bat/sdk/client/CloudClient;", "getDeviceInfoClient", "Lcom/bat/sdk/client/DeviceInfoClient;", "getErrorClient", "Lcom/bat/sdk/client/ErrorClient;", "getFindVapeClient", "Lcom/bat/sdk/client/FindVapeClient;", "getFirmwareManager", "Lcom/bat/sdk/FirmwareManager;", "getGattManager", "Lcom/bat/sdk/ble/GattManager;", "getHapticClient", "Lcom/bat/sdk/client/HapticClient;", "getLedClient", "Lcom/bat/sdk/client/LedClient;", "getLockClient", "Lcom/bat/sdk/client/LockClient;", "getLogsClient", "Lcom/bat/sdk/client/LogsClient;", "getMarketEnable", "Lcom/bat/sdk/payload/PayloadUploader;", "getPodConnectionClient", "Lcom/bat/sdk/client/PodConnectionClient;", "getPowerSaveClient", "Lcom/bat/sdk/client/PowerSaveModeClient;", "getProximity", "Lcom/bat/sdk/ble/BtProximityUnlock;", "getPuffRecordRepository", "Lcom/bat/sdk/persistence/repository/PuffRecordRepository;", "getPuffsClient", "Lcom/bat/sdk/client/PuffsClient;", "getRechargeRemindersClient", "Lcom/bat/sdk/client/RechargeRemindersClient;", "getResetClient", "Lcom/bat/sdk/client/ResetClient;", "getScanner", "Lcom/bat/sdk/ble/BatScanner;", "getSettingsManager", "Lcom/bat/sdk/persistence/SettingsManager;", "getTimeClient", "Lcom/bat/sdk/client/TimeClient;", "getTimeoutAutoLockClient", "Lcom/bat/sdk/client/TimeoutAutoLockClient;", "getUsageReminderClient", "Lcom/bat/sdk/client/UsageReminderClient;", "app_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NodesPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NodesModule(reactContext, getBatteryClient(), getCloudClient(), getDeviceInfoClient(), getErrorClient(), getFindVapeClient(), getLockClient(), getPuffsClient(), getLogsClient(), getTimeClient(), getScanner(), getGattManager(), getPuffRecordRepository(), getBonding(), getBatDevicesRepository(), getAgeVerifier(), getMarketEnable(), getLedClient(), getFirmwareManager(), getResetClient(), getHapticClient(), getAsav(), getProximity(), getSettingsManager(), getPodConnectionClient(), getPowerSaveClient(), getBuzzerClient(), getRechargeRemindersClient(), getUsageReminderClient(), getBleTimeoutClient(), getTimeoutAutoLockClient()));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<ViewManager<?, ?>> listEmptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(listEmptyList, "emptyList(...)");
        return listEmptyList;
    }

    private final BatteryClient getBatteryClient() {
        BatteryClient batteryClient = BatSdk.INSTANCE.getBatteryClient();
        Intrinsics.checkNotNull(batteryClient);
        return batteryClient;
    }

    private final CloudClient getCloudClient() {
        CloudClient cloudClient = BatSdk.INSTANCE.getCloudClient();
        Intrinsics.checkNotNull(cloudClient);
        return cloudClient;
    }

    private final DeviceInfoClient getDeviceInfoClient() {
        DeviceInfoClient deviceInfoClient = BatSdk.INSTANCE.getDeviceInfoClient();
        Intrinsics.checkNotNull(deviceInfoClient);
        return deviceInfoClient;
    }

    private final ErrorClient getErrorClient() {
        ErrorClient errorClient = BatSdk.INSTANCE.getErrorClient();
        Intrinsics.checkNotNull(errorClient);
        return errorClient;
    }

    private final FindVapeClient getFindVapeClient() {
        FindVapeClient findVapeClient = BatSdk.INSTANCE.getFindVapeClient();
        Intrinsics.checkNotNull(findVapeClient);
        return findVapeClient;
    }

    private final LockClient getLockClient() {
        LockClient lockClient = BatSdk.INSTANCE.getLockClient();
        Intrinsics.checkNotNull(lockClient);
        return lockClient;
    }

    private final PuffsClient getPuffsClient() {
        PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
        Intrinsics.checkNotNull(puffsClient);
        return puffsClient;
    }

    private final PuffRecordRepository getPuffRecordRepository() {
        PuffRecordRepository puffsRepository = BatSdk.INSTANCE.getPuffsRepository();
        Intrinsics.checkNotNull(puffsRepository);
        return puffsRepository;
    }

    private final TimeClient getTimeClient() {
        TimeClient timeClient = BatSdk.INSTANCE.getTimeClient();
        Intrinsics.checkNotNull(timeClient);
        return timeClient;
    }

    private final BatScanner getScanner() {
        BatScanner scanner = BatSdk.INSTANCE.getScanner();
        Intrinsics.checkNotNull(scanner);
        return scanner;
    }

    private final FirmwareManager getFirmwareManager() {
        FirmwareManager firmwareManager = BatSdk.INSTANCE.getFirmwareManager();
        Intrinsics.checkNotNull(firmwareManager);
        return firmwareManager;
    }

    private final LogsClient getLogsClient() {
        LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
        Intrinsics.checkNotNull(logsClient);
        return logsClient;
    }

    private final GattManager getGattManager() {
        GattManager gattManager = BatSdk.INSTANCE.getGattManager();
        Intrinsics.checkNotNull(gattManager);
        return gattManager;
    }

    private final Bonding getBonding() {
        Bonding bonding = BatSdk.INSTANCE.getBonding();
        Intrinsics.checkNotNull(bonding);
        return bonding;
    }

    private final BatDevicesRepository getBatDevicesRepository() {
        BatDevicesRepository batDevicesRepository = BatSdk.INSTANCE.getBatDevicesRepository();
        Intrinsics.checkNotNull(batDevicesRepository);
        return batDevicesRepository;
    }

    private final AgeVerifier getAgeVerifier() {
        AgeVerifier ageVerifier = BatSdk.INSTANCE.getAgeVerifier();
        Intrinsics.checkNotNull(ageVerifier);
        return ageVerifier;
    }

    private final PayloadUploader getMarketEnable() {
        PayloadUploader payloadUploader = BatSdk.INSTANCE.getPayloadUploader();
        Intrinsics.checkNotNull(payloadUploader);
        return payloadUploader;
    }

    private final LedClient getLedClient() {
        LedClient ledClient = BatSdk.INSTANCE.getLedClient();
        Intrinsics.checkNotNull(ledClient);
        return ledClient;
    }

    private final ResetClient getResetClient() {
        ResetClient resetClient = BatSdk.INSTANCE.getResetClient();
        Intrinsics.checkNotNull(resetClient);
        return resetClient;
    }

    private final HapticClient getHapticClient() {
        HapticClient hapticClient = BatSdk.INSTANCE.getHapticClient();
        Intrinsics.checkNotNull(hapticClient);
        return hapticClient;
    }

    private final AsavModule getAsav() {
        AsavModule asavModule = BatSdk.INSTANCE.getAsavModule();
        Intrinsics.checkNotNull(asavModule);
        return asavModule;
    }

    private final BtProximityUnlock getProximity() {
        BtProximityUnlock btProximityUnlock = BatSdk.INSTANCE.getBtProximityUnlock();
        Intrinsics.checkNotNull(btProximityUnlock);
        return btProximityUnlock;
    }

    private final SettingsManager getSettingsManager() {
        SettingsManager settingsManager = BatSdk.INSTANCE.getSettingsManager();
        Intrinsics.checkNotNull(settingsManager);
        return settingsManager;
    }

    private final PodConnectionClient getPodConnectionClient() {
        PodConnectionClient podConnectionClient = BatSdk.INSTANCE.getPodConnectionClient();
        Intrinsics.checkNotNull(podConnectionClient);
        return podConnectionClient;
    }

    private final PowerSaveModeClient getPowerSaveClient() {
        PowerSaveModeClient powerSaveModeClient = BatSdk.INSTANCE.getPowerSaveModeClient();
        Intrinsics.checkNotNull(powerSaveModeClient);
        return powerSaveModeClient;
    }

    private final BuzzerClient getBuzzerClient() {
        BuzzerClient buzzerClient = BatSdk.INSTANCE.getBuzzerClient();
        Intrinsics.checkNotNull(buzzerClient);
        return buzzerClient;
    }

    private final RechargeRemindersClient getRechargeRemindersClient() {
        RechargeRemindersClient rechargeRemindersClient = BatSdk.INSTANCE.getRechargeRemindersClient();
        Intrinsics.checkNotNull(rechargeRemindersClient);
        return rechargeRemindersClient;
    }

    private final UsageReminderClient getUsageReminderClient() {
        UsageReminderClient usageReminderClient = BatSdk.INSTANCE.getUsageReminderClient();
        Intrinsics.checkNotNull(usageReminderClient);
        return usageReminderClient;
    }

    private final BleTimeoutClient getBleTimeoutClient() {
        BleTimeoutClient bleTimeoutClient = BatSdk.INSTANCE.getBleTimeoutClient();
        Intrinsics.checkNotNull(bleTimeoutClient);
        return bleTimeoutClient;
    }

    private final TimeoutAutoLockClient getTimeoutAutoLockClient() {
        TimeoutAutoLockClient timeoutAutoLockClient = BatSdk.INSTANCE.getTimeoutAutoLockClient();
        Intrinsics.checkNotNull(timeoutAutoLockClient);
        return timeoutAutoLockClient;
    }
}
