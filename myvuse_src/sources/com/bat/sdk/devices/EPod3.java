package com.bat.sdk.devices;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.bat.sdk.ble.BatCharacteristic;
import com.bat.sdk.ble.BatService;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.CharacteristicType;
import com.bat.sdk.model.ServiceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EPod3.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020#0=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0=J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020?H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%¨\u0006B"}, m5598d2 = {"Lcom/bat/sdk/devices/EPod3;", "", "<init>", "()V", "deviceInfoCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "getDeviceInfoCharacteristic", "()Lcom/bat/sdk/ble/BatCharacteristic;", "timeCharacteristic", "getTimeCharacteristic", "batteryCharacteristic", "getBatteryCharacteristic", "lockCharacteristic", "getLockCharacteristic", "puffsCharacteristic", "getPuffsCharacteristic", "cloudCharacteristic", "getCloudCharacteristic", "findCharacteristic", "getFindCharacteristic", "ledCharacteristic", "getLedCharacteristic", "resetCharacteristic", "getResetCharacteristic", "hapticCharacteristic", "getHapticCharacteristic", "buzzerCharacteristic", "getBuzzerCharacteristic", "podConnectionCharacteristic", "getPodConnectionCharacteristic", "usageReminderCharacteristic", "getUsageReminderCharacteristic", "rechargeRemindersCharacteristic", "getRechargeRemindersCharacteristic", "vapingService", "Lcom/bat/sdk/ble/BatService;", "getVapingService", "()Lcom/bat/sdk/ble/BatService;", "lastErrorCharacteristic", "getLastErrorCharacteristic", "logCharacteristic", "getLogCharacteristic", "logService", "getLogService", "versionCharacteristic", "getVersionCharacteristic", "controlCharacteristic", "getControlCharacteristic", "payloadCharacteristic", "getPayloadCharacteristic", "payloadChallengeCharacteristic", "getPayloadChallengeCharacteristic", "deviceManagementService", "getDeviceManagementService", "ageChallengeCharacteristic", "getAgeChallengeCharacteristic", "ageSignatureCharacteristic", "getAgeSignatureCharacteristic", "ageVerificationService", "getAgeVerificationService", "setup", "", "gattServices", "Landroid/bluetooth/BluetoothGattService;", "createUnknownService", "gattService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class EPod3 {
    private final BatCharacteristic ageChallengeCharacteristic;
    private final BatCharacteristic ageSignatureCharacteristic;
    private final BatService ageVerificationService;
    private final BatCharacteristic batteryCharacteristic;
    private final BatCharacteristic buzzerCharacteristic;
    private final BatCharacteristic cloudCharacteristic;
    private final BatCharacteristic controlCharacteristic;
    private final BatCharacteristic deviceInfoCharacteristic;
    private final BatService deviceManagementService;
    private final BatCharacteristic findCharacteristic;
    private final BatCharacteristic hapticCharacteristic;
    private final BatCharacteristic lastErrorCharacteristic;
    private final BatCharacteristic ledCharacteristic;
    private final BatCharacteristic lockCharacteristic;
    private final BatCharacteristic logCharacteristic;
    private final BatService logService;
    private final BatCharacteristic payloadChallengeCharacteristic;
    private final BatCharacteristic payloadCharacteristic;
    private final BatCharacteristic podConnectionCharacteristic;
    private final BatCharacteristic puffsCharacteristic;
    private final BatCharacteristic rechargeRemindersCharacteristic;
    private final BatCharacteristic resetCharacteristic;
    private final BatCharacteristic timeCharacteristic;
    private final BatCharacteristic usageReminderCharacteristic;
    private final BatService vapingService;
    private final BatCharacteristic versionCharacteristic;

    public EPod3() {
        BatCharacteristic batCharacteristic = new BatCharacteristic("Device Info", BatVocabulary.EPod3.Characteristics.deviceInfoCharacteristic, false, CharacteristicType.DeviceInfo.INSTANCE, 4, null);
        this.deviceInfoCharacteristic = batCharacteristic;
        BatCharacteristic batCharacteristic2 = new BatCharacteristic("Time", BatVocabulary.EPod3.Characteristics.timeCharacteristic, false, CharacteristicType.Time.INSTANCE, 4, null);
        this.timeCharacteristic = batCharacteristic2;
        BatCharacteristic batCharacteristic3 = new BatCharacteristic("Battery", BatVocabulary.EPod3.Characteristics.batteryCharacteristic, false, CharacteristicType.Battery.INSTANCE, 4, null);
        this.batteryCharacteristic = batCharacteristic3;
        BatCharacteristic batCharacteristic4 = new BatCharacteristic("Lock", BatVocabulary.EPod3.Characteristics.lockCharacteristic, true, CharacteristicType.Lock.INSTANCE);
        this.lockCharacteristic = batCharacteristic4;
        BatCharacteristic batCharacteristic5 = new BatCharacteristic("Puffs", BatVocabulary.EPod3.Characteristics.puffsCharacteristic, true, CharacteristicType.Puffs.INSTANCE);
        this.puffsCharacteristic = batCharacteristic5;
        BatCharacteristic batCharacteristic6 = new BatCharacteristic("Cloud", BatVocabulary.EPod3.Characteristics.cloudCharacteristic, true, CharacteristicType.Cloud.INSTANCE);
        this.cloudCharacteristic = batCharacteristic6;
        BatCharacteristic batCharacteristic7 = new BatCharacteristic("Find", BatVocabulary.EPod3.Characteristics.findCharacteristic, true, CharacteristicType.FindVape.INSTANCE);
        this.findCharacteristic = batCharacteristic7;
        BatCharacteristic batCharacteristic8 = new BatCharacteristic("Led", BatVocabulary.EPod3.Characteristics.ledCharacteristic, true, CharacteristicType.Led.INSTANCE);
        this.ledCharacteristic = batCharacteristic8;
        BatCharacteristic batCharacteristic9 = new BatCharacteristic("Reset", BatVocabulary.EPod3.Characteristics.resetCharacteristic, true, CharacteristicType.Reset.INSTANCE);
        this.resetCharacteristic = batCharacteristic9;
        BatCharacteristic batCharacteristic10 = new BatCharacteristic("Haptic", BatVocabulary.EPod3.Characteristics.hapticCharacteristic, true, CharacteristicType.Haptic.INSTANCE);
        this.hapticCharacteristic = batCharacteristic10;
        BatCharacteristic batCharacteristic11 = new BatCharacteristic("Buzzer", BatVocabulary.EPod3.Characteristics.buzzerCharacteristic, true, CharacteristicType.Buzzer.INSTANCE);
        this.buzzerCharacteristic = batCharacteristic11;
        BatCharacteristic batCharacteristic12 = new BatCharacteristic("Pod Connection", BatVocabulary.EPod3.Characteristics.podCharacteristic, true, CharacteristicType.PodConnection.INSTANCE);
        this.podConnectionCharacteristic = batCharacteristic12;
        BatCharacteristic batCharacteristic13 = new BatCharacteristic("Usage Reminder", BatVocabulary.EPod3.Characteristics.usageReminderCharacteristic, true, CharacteristicType.UsageReminder.INSTANCE);
        this.usageReminderCharacteristic = batCharacteristic13;
        BatCharacteristic batCharacteristic14 = new BatCharacteristic("Recharge Reminders", BatVocabulary.EPod3.Characteristics.rechargeRemindersCharacteristic, true, CharacteristicType.RechargeReminders.INSTANCE);
        this.rechargeRemindersCharacteristic = batCharacteristic14;
        this.vapingService = new BatService("Vaping", BatVocabulary.EPod3.Services.vapingService, ServiceType.Vaping.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic, batCharacteristic2, batCharacteristic6, batCharacteristic4, batCharacteristic3, batCharacteristic5, batCharacteristic7, batCharacteristic8, batCharacteristic9, batCharacteristic10, batCharacteristic11, batCharacteristic12, batCharacteristic14, batCharacteristic13}));
        BatCharacteristic batCharacteristic15 = new BatCharacteristic("Last Error", BatVocabulary.EPod3.Characteristics.errorCharacteristic, true, CharacteristicType.LastError.INSTANCE);
        this.lastErrorCharacteristic = batCharacteristic15;
        BatCharacteristic batCharacteristic16 = new BatCharacteristic("Logs", BatVocabulary.EPod3.Characteristics.logCharacteristic, true, CharacteristicType.Logs.INSTANCE);
        this.logCharacteristic = batCharacteristic16;
        this.logService = new BatService("Log", BatVocabulary.EPod3.Services.logService, ServiceType.Log.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic15, batCharacteristic16}));
        BatCharacteristic batCharacteristic17 = new BatCharacteristic("Version", BatVocabulary.EPod3.Characteristics.versionCharacteristic, false, null, 12, null);
        this.versionCharacteristic = batCharacteristic17;
        BatCharacteristic batCharacteristic18 = new BatCharacteristic("Control", BatVocabulary.EPod3.Characteristics.controlCharacteristic, false, null, 12, null);
        this.controlCharacteristic = batCharacteristic18;
        BatCharacteristic batCharacteristic19 = new BatCharacteristic("Payload", BatVocabulary.EPod3.Characteristics.payloadCharacteristic, false, null, 12, null);
        this.payloadCharacteristic = batCharacteristic19;
        BatCharacteristic batCharacteristic20 = new BatCharacteristic("Challenge", BatVocabulary.EPod3.Characteristics.payloadChallengeCharacteristic, false, null, 12, null);
        this.payloadChallengeCharacteristic = batCharacteristic20;
        this.deviceManagementService = new BatService("Device Management", BatVocabulary.EPod3.Services.deviceManagementService, ServiceType.DeviceManagement.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic17, batCharacteristic18, batCharacteristic20, batCharacteristic19}));
        BatCharacteristic batCharacteristic21 = new BatCharacteristic("Age Challenge", BatVocabulary.EPod3.Characteristics.ageChallengeCharacteristic, true, null, 8, null);
        this.ageChallengeCharacteristic = batCharacteristic21;
        BatCharacteristic batCharacteristic22 = new BatCharacteristic("Age Signature", BatVocabulary.EPod3.Characteristics.ageSignatureCharacteristic, true, null, 8, null);
        this.ageSignatureCharacteristic = batCharacteristic22;
        this.ageVerificationService = new BatService("Age Verification", BatVocabulary.EPod3.Services.ageVerificationService, ServiceType.AgeVerification.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic21, batCharacteristic22}));
    }

    public final BatCharacteristic getDeviceInfoCharacteristic() {
        return this.deviceInfoCharacteristic;
    }

    public final BatCharacteristic getTimeCharacteristic() {
        return this.timeCharacteristic;
    }

    public final BatCharacteristic getBatteryCharacteristic() {
        return this.batteryCharacteristic;
    }

    public final BatCharacteristic getLockCharacteristic() {
        return this.lockCharacteristic;
    }

    public final BatCharacteristic getPuffsCharacteristic() {
        return this.puffsCharacteristic;
    }

    public final BatCharacteristic getCloudCharacteristic() {
        return this.cloudCharacteristic;
    }

    public final BatCharacteristic getFindCharacteristic() {
        return this.findCharacteristic;
    }

    public final BatCharacteristic getLedCharacteristic() {
        return this.ledCharacteristic;
    }

    public final BatCharacteristic getResetCharacteristic() {
        return this.resetCharacteristic;
    }

    public final BatCharacteristic getHapticCharacteristic() {
        return this.hapticCharacteristic;
    }

    public final BatCharacteristic getBuzzerCharacteristic() {
        return this.buzzerCharacteristic;
    }

    public final BatCharacteristic getPodConnectionCharacteristic() {
        return this.podConnectionCharacteristic;
    }

    public final BatCharacteristic getUsageReminderCharacteristic() {
        return this.usageReminderCharacteristic;
    }

    public final BatCharacteristic getRechargeRemindersCharacteristic() {
        return this.rechargeRemindersCharacteristic;
    }

    public final BatService getVapingService() {
        return this.vapingService;
    }

    public final BatCharacteristic getLastErrorCharacteristic() {
        return this.lastErrorCharacteristic;
    }

    public final BatCharacteristic getLogCharacteristic() {
        return this.logCharacteristic;
    }

    public final BatService getLogService() {
        return this.logService;
    }

    public final BatCharacteristic getVersionCharacteristic() {
        return this.versionCharacteristic;
    }

    public final BatCharacteristic getControlCharacteristic() {
        return this.controlCharacteristic;
    }

    public final BatCharacteristic getPayloadCharacteristic() {
        return this.payloadCharacteristic;
    }

    public final BatCharacteristic getPayloadChallengeCharacteristic() {
        return this.payloadChallengeCharacteristic;
    }

    public final BatService getDeviceManagementService() {
        return this.deviceManagementService;
    }

    public final BatCharacteristic getAgeChallengeCharacteristic() {
        return this.ageChallengeCharacteristic;
    }

    public final BatCharacteristic getAgeSignatureCharacteristic() {
        return this.ageSignatureCharacteristic;
    }

    public final BatService getAgeVerificationService() {
        return this.ageVerificationService;
    }

    public final List<BatService> setup(List<? extends BluetoothGattService> gattServices) {
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Logger.INSTANCE.log("EPod 3: setting up " + gattServices.size() + " services");
        ArrayList arrayList = new ArrayList();
        List<? extends BluetoothGattService> list = gattServices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(createUnknownService((BluetoothGattService) it2.next()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        if (!this.vapingService.setup(gattServices)) {
            Logger.INSTANCE.log("EPod 3: setup failed - vaping service is missing");
            return CollectionsKt.emptyList();
        }
        arrayList.add(this.vapingService);
        mutableList.remove(this.vapingService);
        if (this.logService.setup(gattServices)) {
            arrayList.add(this.logService);
            mutableList.remove(this.logService);
        }
        if (this.deviceManagementService.setup(gattServices)) {
            arrayList.add(this.deviceManagementService);
            mutableList.remove(this.deviceManagementService);
        }
        if (this.ageVerificationService.setup(gattServices)) {
            arrayList.add(this.ageVerificationService);
            mutableList.remove(this.ageVerificationService);
        }
        Logger.INSTANCE.log("EPod 3: services are setup");
        return CollectionsKt.plus((Collection) arrayList, (Iterable) mutableList);
    }

    private final BatService createUnknownService(BluetoothGattService gattService) {
        List<BluetoothGattCharacteristic> characteristics = gattService.getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
        List<BluetoothGattCharacteristic> list = characteristics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : list) {
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            arrayList.add(new BatCharacteristic("Unknown Characteristic", uuid, bluetoothGattCharacteristic, true, null, 16, null));
        }
        ArrayList arrayList2 = arrayList;
        UUID uuid2 = gattService.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
        return new BatService(uuid2, "Unknown", ServiceType.Generic.INSTANCE, gattService, arrayList2);
    }
}
