package com.bat.sdk.devices;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.bat.sdk.ble.BatCharacteristic;
import com.bat.sdk.ble.BatService;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.CharacteristicType;
import com.bat.sdk.model.ServiceType;
import com.facebook.fbreact.specs.NativeAppearanceSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DFU.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001dJ\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001fH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006\""}, m5598d2 = {"Lcom/bat/sdk/devices/DFU;", "", "<init>", "()V", "deviceName", "Lcom/bat/sdk/ble/BatCharacteristic;", "getDeviceName", "()Lcom/bat/sdk/ble/BatCharacteristic;", "appearance", "getAppearance", "peripheralPrefConnParameters", "getPeripheralPrefConnParameters", "centralAddressResolution", "getCentralAddressResolution", "serviceChanged", "getServiceChanged", "dfuPacket", "getDfuPacket", "dfuControlPoint", "getDfuControlPoint", "buttonlessSecureDFUService", "Lcom/bat/sdk/ble/BatService;", "getButtonlessSecureDFUService", "()Lcom/bat/sdk/ble/BatService;", "genericAccessService", "getGenericAccessService", "genericAttributeService", "getGenericAttributeService", "setup", "", "gattServices", "Landroid/bluetooth/BluetoothGattService;", "createUnknownService", "gattService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class DFU {
    private final BatCharacteristic appearance;
    private final BatService buttonlessSecureDFUService;
    private final BatCharacteristic centralAddressResolution;
    private final BatCharacteristic deviceName;
    private final BatCharacteristic dfuControlPoint;
    private final BatCharacteristic dfuPacket;
    private final BatService genericAccessService;
    private final BatService genericAttributeService;
    private final BatCharacteristic peripheralPrefConnParameters;
    private final BatCharacteristic serviceChanged;

    public DFU() {
        BatCharacteristic batCharacteristic = new BatCharacteristic("Device name", BatVocabulary.DFU.Characteristics.deviceName, true, CharacteristicType.DeviceName.INSTANCE);
        this.deviceName = batCharacteristic;
        BatCharacteristic batCharacteristic2 = new BatCharacteristic(NativeAppearanceSpec.NAME, BatVocabulary.DFU.Characteristics.appearance, true, CharacteristicType.Appearance.INSTANCE);
        this.appearance = batCharacteristic2;
        BatCharacteristic batCharacteristic3 = new BatCharacteristic("Peripheral Preferred Connection Parameters", BatVocabulary.DFU.Characteristics.peripheralPrefConnParameters, true, CharacteristicType.PeripheralPrefConnParameters.INSTANCE);
        this.peripheralPrefConnParameters = batCharacteristic3;
        BatCharacteristic batCharacteristic4 = new BatCharacteristic("Central Address Resolution", BatVocabulary.DFU.Characteristics.centralAddressResolution, true, CharacteristicType.CentralAddressResolution.INSTANCE);
        this.centralAddressResolution = batCharacteristic4;
        BatCharacteristic batCharacteristic5 = new BatCharacteristic("Service Changed", BatVocabulary.DFU.Characteristics.serviceChanged, true, CharacteristicType.ButtonlessDFUwithBonds.INSTANCE);
        this.serviceChanged = batCharacteristic5;
        BatCharacteristic batCharacteristic6 = new BatCharacteristic("DFU Packet", "8EC90002-F315-4F60-9FB8-838830DAEA50", false, CharacteristicType.ButtonlessDFUwithBonds.INSTANCE, 4, null);
        this.dfuPacket = batCharacteristic6;
        BatCharacteristic batCharacteristic7 = new BatCharacteristic("DFU Control Point", "8EC90001-F315-4F60-9FB8-838830DAEA50", false, CharacteristicType.ButtonlessDFUwithBonds.INSTANCE, 4, null);
        this.dfuControlPoint = batCharacteristic7;
        this.buttonlessSecureDFUService = new BatService("Buttonless Secure DFU", BatVocabulary.DFU.Services.buttonlessSecureDFUService, ServiceType.ButtonlessSecureDFU.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic6, batCharacteristic7}));
        this.genericAccessService = new BatService("Generic Access", BatVocabulary.DFU.Services.genericAccessService, ServiceType.GenericAccess.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic, batCharacteristic2, batCharacteristic3, batCharacteristic4}));
        this.genericAttributeService = new BatService("Generic Attribute", BatVocabulary.DFU.Services.genericAttributeService, ServiceType.GenericAttribute.INSTANCE, CollectionsKt.listOf(batCharacteristic5));
    }

    public final BatCharacteristic getDeviceName() {
        return this.deviceName;
    }

    public final BatCharacteristic getAppearance() {
        return this.appearance;
    }

    public final BatCharacteristic getPeripheralPrefConnParameters() {
        return this.peripheralPrefConnParameters;
    }

    public final BatCharacteristic getCentralAddressResolution() {
        return this.centralAddressResolution;
    }

    public final BatCharacteristic getServiceChanged() {
        return this.serviceChanged;
    }

    public final BatCharacteristic getDfuPacket() {
        return this.dfuPacket;
    }

    public final BatCharacteristic getDfuControlPoint() {
        return this.dfuControlPoint;
    }

    public final BatService getButtonlessSecureDFUService() {
        return this.buttonlessSecureDFUService;
    }

    public final BatService getGenericAccessService() {
        return this.genericAccessService;
    }

    public final BatService getGenericAttributeService() {
        return this.genericAttributeService;
    }

    public final List<BatService> setup(List<? extends BluetoothGattService> gattServices) {
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Logger.INSTANCE.log("DFU: setting up " + gattServices.size() + " services");
        ArrayList arrayList = new ArrayList();
        List<? extends BluetoothGattService> list = gattServices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(createUnknownService((BluetoothGattService) it2.next()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        if (this.buttonlessSecureDFUService.setup(gattServices)) {
            arrayList.add(this.buttonlessSecureDFUService);
            mutableList.remove(this.buttonlessSecureDFUService);
        }
        if (this.genericAccessService.setup(gattServices)) {
            arrayList.add(this.genericAccessService);
            mutableList.remove(this.genericAccessService);
        }
        if (this.genericAttributeService.setup(gattServices)) {
            arrayList.add(this.genericAttributeService);
            mutableList.remove(this.genericAttributeService);
        }
        Logger.INSTANCE.log("DFU device: services are setup");
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
