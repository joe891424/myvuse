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

/* JADX INFO: compiled from: VPro.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0)J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020+H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006."}, m5598d2 = {"Lcom/bat/sdk/devices/VPro;", "", "<init>", "()V", "deviceInfoCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "getDeviceInfoCharacteristic", "()Lcom/bat/sdk/ble/BatCharacteristic;", "timeCharacteristic", "getTimeCharacteristic", "lockCharacteristic", "getLockCharacteristic", "batteryCharacteristic", "getBatteryCharacteristic", "puffsCharacteristic", "getPuffsCharacteristic", "findCharacteristic", "getFindCharacteristic", "ledCharacteristic", "getLedCharacteristic", "cloudCharacteristic", "getCloudCharacteristic", "vapingService", "Lcom/bat/sdk/ble/BatService;", "getVapingService", "()Lcom/bat/sdk/ble/BatService;", "lastErrorCharacteristic", "getLastErrorCharacteristic", "logsCharacteristic", "getLogsCharacteristic", "logsService", "getLogsService", "otaNewCharacteristic", "getOtaNewCharacteristic", "otaControlCharacteristic", "getOtaControlCharacteristic", "otaPayloadCharacteristic", "getOtaPayloadCharacteristic", "fotaService", "getFotaService", "setup", "", "gattServices", "Landroid/bluetooth/BluetoothGattService;", "createUnknownService", "gattService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class VPro {
    private final BatCharacteristic batteryCharacteristic;
    private final BatCharacteristic cloudCharacteristic;
    private final BatCharacteristic deviceInfoCharacteristic;
    private final BatCharacteristic findCharacteristic;
    private final BatService fotaService;
    private final BatCharacteristic lastErrorCharacteristic;
    private final BatCharacteristic ledCharacteristic;
    private final BatCharacteristic lockCharacteristic;
    private final BatCharacteristic logsCharacteristic;
    private final BatService logsService;
    private final BatCharacteristic otaControlCharacteristic;
    private final BatCharacteristic otaNewCharacteristic;
    private final BatCharacteristic otaPayloadCharacteristic;
    private final BatCharacteristic puffsCharacteristic;
    private final BatCharacteristic timeCharacteristic;
    private final BatService vapingService;

    public VPro() {
        BatCharacteristic batCharacteristic = new BatCharacteristic("Device Info", BatVocabulary.VPro.Characteristics.deviceInfoCharacteristic, false, CharacteristicType.DeviceInfo.INSTANCE, 4, null);
        this.deviceInfoCharacteristic = batCharacteristic;
        BatCharacteristic batCharacteristic2 = new BatCharacteristic("Time", BatVocabulary.VPro.Characteristics.timeCharacteristic, false, CharacteristicType.Time.INSTANCE, 4, null);
        this.timeCharacteristic = batCharacteristic2;
        BatCharacteristic batCharacteristic3 = new BatCharacteristic("Lock", BatVocabulary.VPro.Characteristics.lockCharacteristic, false, CharacteristicType.Lock.INSTANCE, 4, null);
        this.lockCharacteristic = batCharacteristic3;
        BatCharacteristic batCharacteristic4 = new BatCharacteristic("Battery", BatVocabulary.VPro.Characteristics.batteryCharacteristic, false, CharacteristicType.Battery.INSTANCE, 4, null);
        this.batteryCharacteristic = batCharacteristic4;
        BatCharacteristic batCharacteristic5 = new BatCharacteristic("Puffs", BatVocabulary.VPro.Characteristics.puffsCharacteristic, true, CharacteristicType.Puffs.INSTANCE);
        this.puffsCharacteristic = batCharacteristic5;
        BatCharacteristic batCharacteristic6 = new BatCharacteristic("Find", BatVocabulary.VPro.Characteristics.findCharacteristic, true, CharacteristicType.FindVape.INSTANCE);
        this.findCharacteristic = batCharacteristic6;
        BatCharacteristic batCharacteristic7 = new BatCharacteristic("Led", BatVocabulary.VPro.Characteristics.ledCharacteristic, true, CharacteristicType.Led.INSTANCE);
        this.ledCharacteristic = batCharacteristic7;
        BatCharacteristic batCharacteristic8 = new BatCharacteristic("Cloud", BatVocabulary.VPro.Characteristics.cloudCharacteristic, false, CharacteristicType.Cloud.INSTANCE, 4, null);
        this.cloudCharacteristic = batCharacteristic8;
        this.vapingService = new BatService("Vaping", BatVocabulary.VPro.Services.vapingService, ServiceType.Vaping.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic, batCharacteristic2, batCharacteristic3, batCharacteristic4, batCharacteristic5, batCharacteristic6, batCharacteristic7, batCharacteristic8}));
        BatCharacteristic batCharacteristic9 = new BatCharacteristic("Last Error", BatVocabulary.VPro.Characteristics.errorCharacteristic, false, CharacteristicType.LastError.INSTANCE, 4, null);
        this.lastErrorCharacteristic = batCharacteristic9;
        BatCharacteristic batCharacteristic10 = new BatCharacteristic("Logs", BatVocabulary.VPro.Characteristics.logCharacteristic, false, CharacteristicType.Logs.INSTANCE, 4, null);
        this.logsCharacteristic = batCharacteristic10;
        this.logsService = new BatService("Logs", BatVocabulary.VPro.Services.logsService, ServiceType.Log.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic9, batCharacteristic10}));
        BatCharacteristic batCharacteristic11 = new BatCharacteristic("OTA New", BatVocabulary.VPro.Characteristics.otaNewCharacteristic, false, null, 12, null);
        this.otaNewCharacteristic = batCharacteristic11;
        BatCharacteristic batCharacteristic12 = new BatCharacteristic("OTA Control", BatVocabulary.VPro.Characteristics.otaControlCharacteristic, false, null, 12, null);
        this.otaControlCharacteristic = batCharacteristic12;
        BatCharacteristic batCharacteristic13 = new BatCharacteristic("OTA Payload", BatVocabulary.VPro.Characteristics.otaPayloadCharacteristic, false, null, 12, null);
        this.otaPayloadCharacteristic = batCharacteristic13;
        this.fotaService = new BatService("Fota", BatVocabulary.VPro.Services.fotaService, ServiceType.Fota.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic11, batCharacteristic12, batCharacteristic13}));
    }

    public final BatCharacteristic getDeviceInfoCharacteristic() {
        return this.deviceInfoCharacteristic;
    }

    public final BatCharacteristic getTimeCharacteristic() {
        return this.timeCharacteristic;
    }

    public final BatCharacteristic getLockCharacteristic() {
        return this.lockCharacteristic;
    }

    public final BatCharacteristic getBatteryCharacteristic() {
        return this.batteryCharacteristic;
    }

    public final BatCharacteristic getPuffsCharacteristic() {
        return this.puffsCharacteristic;
    }

    public final BatCharacteristic getFindCharacteristic() {
        return this.findCharacteristic;
    }

    public final BatCharacteristic getLedCharacteristic() {
        return this.ledCharacteristic;
    }

    public final BatCharacteristic getCloudCharacteristic() {
        return this.cloudCharacteristic;
    }

    public final BatService getVapingService() {
        return this.vapingService;
    }

    public final BatCharacteristic getLastErrorCharacteristic() {
        return this.lastErrorCharacteristic;
    }

    public final BatCharacteristic getLogsCharacteristic() {
        return this.logsCharacteristic;
    }

    public final BatService getLogsService() {
        return this.logsService;
    }

    public final BatCharacteristic getOtaNewCharacteristic() {
        return this.otaNewCharacteristic;
    }

    public final BatCharacteristic getOtaControlCharacteristic() {
        return this.otaControlCharacteristic;
    }

    public final BatCharacteristic getOtaPayloadCharacteristic() {
        return this.otaPayloadCharacteristic;
    }

    public final BatService getFotaService() {
        return this.fotaService;
    }

    public final List<BatService> setup(List<? extends BluetoothGattService> gattServices) {
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Logger.INSTANCE.log("VPro: setting up " + gattServices.size() + " services");
        ArrayList arrayList = new ArrayList();
        List<? extends BluetoothGattService> list = gattServices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(createUnknownService((BluetoothGattService) it2.next()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        if (!this.vapingService.setup(gattServices)) {
            Logger.INSTANCE.log("VPro: setup failed - vaping service is missing");
            return CollectionsKt.emptyList();
        }
        arrayList.add(this.vapingService);
        mutableList.remove(this.vapingService);
        if (this.logsService.setup(gattServices)) {
            arrayList.add(this.logsService);
            mutableList.remove(this.logsService);
        }
        if (this.fotaService.setup(gattServices)) {
            arrayList.add(this.fotaService);
            mutableList.remove(this.fotaService);
        }
        Logger.INSTANCE.log("VPro: services are setup");
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
