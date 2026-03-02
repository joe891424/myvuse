package com.bat.sdk.devices;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import androidx.exifinterface.media.ExifInterface;
import com.bat.sdk.ble.BatCharacteristic;
import com.bat.sdk.ble.BatService;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.ServiceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EPen.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00130]2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0]J\u0010\u0010c\u001a\u00020\u00132\u0006\u0010d\u001a\u00020bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0015R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0015R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0015R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0015R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130]¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_¨\u0006e"}, m5598d2 = {"Lcom/bat/sdk/devices/EPen;", "", "<init>", "()V", "modelCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "getModelCharacteristic", "()Lcom/bat/sdk/ble/BatCharacteristic;", "serialNumberCharacteristic", "getSerialNumberCharacteristic", "firmwareRevisionCharacteristic", "getFirmwareRevisionCharacteristic", "hardwareRevisionCharacteristic", "getHardwareRevisionCharacteristic", "softwareRevisionCharacteristic", "getSoftwareRevisionCharacteristic", "manufacturerCharacteristic", "getManufacturerCharacteristic", "deviceInfoService", "Lcom/bat/sdk/ble/BatService;", "getDeviceInfoService", "()Lcom/bat/sdk/ble/BatService;", "batteryLevelCharacteristic", "getBatteryLevelCharacteristic", "batteryService", "getBatteryService", "coilActivationCharacteristic", "getCoilActivationCharacteristic", "pressureSensorCharacteristic", "getPressureSensorCharacteristic", "pressureThresholdCharacteristic", "getPressureThresholdCharacteristic", "bufferTimeoutCharacteristic", "getBufferTimeoutCharacteristic", "sensorDataService", "getSensorDataService", "cartomiserIdCharacteristic", "getCartomiserIdCharacteristic", "flavourIdCharacteristic", "getFlavourIdCharacteristic", "joulesRemainingCharacteristic", "getJoulesRemainingCharacteristic", "totalPuffsCharacteristic", "getTotalPuffsCharacteristic", "totalUseTimeCharacteristic", "getTotalUseTimeCharacteristic", "devicePowerLevelCharacteristic", "getDevicePowerLevelCharacteristic", "cartomiserPresentCharacteristic", "getCartomiserPresentCharacteristic", "cartomiserService", "getCartomiserService", "accelerometerXCharacteristic", "getAccelerometerXCharacteristic", "accelerometerYCharacteristic", "getAccelerometerYCharacteristic", "accelerometerZCharacteristic", "getAccelerometerZCharacteristic", "accelerometerSensitivityCharacteristic", "getAccelerometerSensitivityCharacteristic", "rotationXCharacteristic", "getRotationXCharacteristic", "rotationYCharacteristic", "getRotationYCharacteristic", "rotationZCharacteristic", "getRotationZCharacteristic", "gyroscopeSensitivityCharacteristic", "getGyroscopeSensitivityCharacteristic", "accelerometerInterruptCharacteristic", "getAccelerometerInterruptCharacteristic", "accelerometerService", "getAccelerometerService", "deviceControlCharacteristic", "getDeviceControlCharacteristic", "deviceTimeCharacteristic", "getDeviceTimeCharacteristic", "deviceStateCharacteristic", "getDeviceStateCharacteristic", "recordsAvailableCharacteristic", "getRecordsAvailableCharacteristic", "eventsAvailableCharacteristic", "getEventsAvailableCharacteristic", "deviceChargingCharacteristic", "getDeviceChargingCharacteristic", "vapeDeviceService", "getVapeDeviceService", "rxCharacteristic", "getRxCharacteristic", "txCharacteristic", "getTxCharacteristic", "uartService", "getUartService", "services", "", "getServices", "()Ljava/util/List;", "setup", "gattServices", "Landroid/bluetooth/BluetoothGattService;", "createUnknownService", "gattService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class EPen {
    private final BatCharacteristic accelerometerInterruptCharacteristic;
    private final BatCharacteristic accelerometerSensitivityCharacteristic;
    private final BatService accelerometerService;
    private final BatCharacteristic accelerometerXCharacteristic;
    private final BatCharacteristic accelerometerYCharacteristic;
    private final BatCharacteristic accelerometerZCharacteristic;
    private final BatCharacteristic batteryLevelCharacteristic;
    private final BatService batteryService;
    private final BatCharacteristic bufferTimeoutCharacteristic;
    private final BatCharacteristic cartomiserIdCharacteristic;
    private final BatCharacteristic cartomiserPresentCharacteristic;
    private final BatService cartomiserService;
    private final BatCharacteristic coilActivationCharacteristic;
    private final BatCharacteristic deviceChargingCharacteristic;
    private final BatCharacteristic deviceControlCharacteristic;
    private final BatService deviceInfoService;
    private final BatCharacteristic devicePowerLevelCharacteristic;
    private final BatCharacteristic deviceStateCharacteristic;
    private final BatCharacteristic deviceTimeCharacteristic;
    private final BatCharacteristic eventsAvailableCharacteristic;
    private final BatCharacteristic firmwareRevisionCharacteristic;
    private final BatCharacteristic flavourIdCharacteristic;
    private final BatCharacteristic gyroscopeSensitivityCharacteristic;
    private final BatCharacteristic hardwareRevisionCharacteristic;
    private final BatCharacteristic joulesRemainingCharacteristic;
    private final BatCharacteristic manufacturerCharacteristic;
    private final BatCharacteristic modelCharacteristic;
    private final BatCharacteristic pressureSensorCharacteristic;
    private final BatCharacteristic pressureThresholdCharacteristic;
    private final BatCharacteristic recordsAvailableCharacteristic;
    private final BatCharacteristic rotationXCharacteristic;
    private final BatCharacteristic rotationYCharacteristic;
    private final BatCharacteristic rotationZCharacteristic;
    private final BatCharacteristic rxCharacteristic;
    private final BatService sensorDataService;
    private final BatCharacteristic serialNumberCharacteristic;
    private final List<BatService> services;
    private final BatCharacteristic softwareRevisionCharacteristic;
    private final BatCharacteristic totalPuffsCharacteristic;
    private final BatCharacteristic totalUseTimeCharacteristic;
    private final BatCharacteristic txCharacteristic;
    private final BatService uartService;
    private final BatService vapeDeviceService;

    public EPen() {
        BatCharacteristic batCharacteristic = new BatCharacteristic(ExifInterface.TAG_MODEL, BatVocabulary.EPen.Characteristics.modelCharacteristic, false, null, 12, null);
        this.modelCharacteristic = batCharacteristic;
        BatCharacteristic batCharacteristic2 = new BatCharacteristic("Serial Number", BatVocabulary.EPen.Characteristics.serialNumberCharacteristic, false, null, 12, null);
        this.serialNumberCharacteristic = batCharacteristic2;
        BatCharacteristic batCharacteristic3 = new BatCharacteristic("Firmware Revision", BatVocabulary.EPen.Characteristics.firmwareRevisionCharacteristic, false, null, 12, null);
        this.firmwareRevisionCharacteristic = batCharacteristic3;
        BatCharacteristic batCharacteristic4 = new BatCharacteristic("Hardware Revision", BatVocabulary.EPen.Characteristics.hardwareRevisionCharacteristic, false, null, 12, null);
        this.hardwareRevisionCharacteristic = batCharacteristic4;
        BatCharacteristic batCharacteristic5 = new BatCharacteristic("Software Revision", BatVocabulary.EPen.Characteristics.softwareRevisionCharacteristic, false, null, 12, null);
        this.softwareRevisionCharacteristic = batCharacteristic5;
        BatCharacteristic batCharacteristic6 = new BatCharacteristic("Manufacturer", BatVocabulary.EPen.Characteristics.manufacturerCharacteristic, false, null, 12, null);
        this.manufacturerCharacteristic = batCharacteristic6;
        BatService batService = new BatService("Device Info", BatVocabulary.EPen.Services.deviceInfoService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic, batCharacteristic2, batCharacteristic3, batCharacteristic4, batCharacteristic5, batCharacteristic6}));
        this.deviceInfoService = batService;
        BatCharacteristic batCharacteristic7 = new BatCharacteristic("Battery Level", BatVocabulary.EPen.Characteristics.batteryLevelCharacteristic, false, null, 12, null);
        this.batteryLevelCharacteristic = batCharacteristic7;
        BatService batService2 = new BatService("Battery", BatVocabulary.EPen.Services.batteryService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf(batCharacteristic7));
        this.batteryService = batService2;
        BatCharacteristic batCharacteristic8 = new BatCharacteristic("Coil Activation", BatVocabulary.EPen.Characteristics.coilActivationCharacteristic, false, null, 12, null);
        this.coilActivationCharacteristic = batCharacteristic8;
        BatCharacteristic batCharacteristic9 = new BatCharacteristic("Pressure Sensor", BatVocabulary.EPen.Characteristics.pressureSensorCharacteristic, false, null, 12, null);
        this.pressureSensorCharacteristic = batCharacteristic9;
        BatCharacteristic batCharacteristic10 = new BatCharacteristic("Pressure Threshold", BatVocabulary.EPen.Characteristics.pressureThresholdCharacteristic, false, null, 12, null);
        this.pressureThresholdCharacteristic = batCharacteristic10;
        BatCharacteristic batCharacteristic11 = new BatCharacteristic("Buffer Timeout", BatVocabulary.EPen.Characteristics.bufferTimeoutCharacteristic, false, null, 12, null);
        this.bufferTimeoutCharacteristic = batCharacteristic11;
        BatService batService3 = new BatService("Sensor Data", BatVocabulary.EPen.Services.sensorDataService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic8, batCharacteristic9, batCharacteristic10, batCharacteristic11}));
        this.sensorDataService = batService3;
        BatCharacteristic batCharacteristic12 = new BatCharacteristic("Cartomiser Id", BatVocabulary.EPen.Characteristics.cartomiserIdCharacteristic, false, null, 12, null);
        this.cartomiserIdCharacteristic = batCharacteristic12;
        BatCharacteristic batCharacteristic13 = new BatCharacteristic("Flavour Id", BatVocabulary.EPen.Characteristics.flavourIdCharacteristic, false, null, 12, null);
        this.flavourIdCharacteristic = batCharacteristic13;
        BatCharacteristic batCharacteristic14 = new BatCharacteristic("Joules Remaining", BatVocabulary.EPen.Characteristics.joulesRemainingCharacteristic, false, null, 12, null);
        this.joulesRemainingCharacteristic = batCharacteristic14;
        BatCharacteristic batCharacteristic15 = new BatCharacteristic("Total Puffs", BatVocabulary.EPen.Characteristics.totalPuffsCharacteristic, false, null, 12, null);
        this.totalPuffsCharacteristic = batCharacteristic15;
        BatCharacteristic batCharacteristic16 = new BatCharacteristic("Total Use Time", BatVocabulary.EPen.Characteristics.totalUseTimeCharacteristic, false, null, 12, null);
        this.totalUseTimeCharacteristic = batCharacteristic16;
        BatCharacteristic batCharacteristic17 = new BatCharacteristic("Device Power Level", BatVocabulary.EPen.Characteristics.devicePowerLevelCharacteristic, false, null, 12, null);
        this.devicePowerLevelCharacteristic = batCharacteristic17;
        BatCharacteristic batCharacteristic18 = new BatCharacteristic("Cartomiser Present", BatVocabulary.EPen.Characteristics.cartomiserPresentCharacteristic, false, null, 12, null);
        this.cartomiserPresentCharacteristic = batCharacteristic18;
        BatService batService4 = new BatService("Cartomiser", BatVocabulary.EPen.Services.cartomiserService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic12, batCharacteristic13, batCharacteristic14, batCharacteristic15, batCharacteristic16, batCharacteristic17, batCharacteristic18}));
        this.cartomiserService = batService4;
        BatCharacteristic batCharacteristic19 = new BatCharacteristic("Accelerometer X", BatVocabulary.EPen.Characteristics.accelerometerXCharacteristic, false, null, 12, null);
        this.accelerometerXCharacteristic = batCharacteristic19;
        BatCharacteristic batCharacteristic20 = new BatCharacteristic("Accelerometer Y", BatVocabulary.EPen.Characteristics.accelerometerYCharacteristic, false, null, 12, null);
        this.accelerometerYCharacteristic = batCharacteristic20;
        BatCharacteristic batCharacteristic21 = new BatCharacteristic("Accelerometer Z", BatVocabulary.EPen.Characteristics.accelerometerZCharacteristic, false, null, 12, null);
        this.accelerometerZCharacteristic = batCharacteristic21;
        BatCharacteristic batCharacteristic22 = new BatCharacteristic("Accelerometer Sensitivity", BatVocabulary.EPen.Characteristics.accelerometerSensitivityCharacteristic, false, null, 12, null);
        this.accelerometerSensitivityCharacteristic = batCharacteristic22;
        BatCharacteristic batCharacteristic23 = new BatCharacteristic("Rotation X", BatVocabulary.EPen.Characteristics.rotationXCharacteristic, false, null, 12, null);
        this.rotationXCharacteristic = batCharacteristic23;
        BatCharacteristic batCharacteristic24 = new BatCharacteristic("Rotation Y", BatVocabulary.EPen.Characteristics.rotationYCharacteristic, false, null, 12, null);
        this.rotationYCharacteristic = batCharacteristic24;
        BatCharacteristic batCharacteristic25 = new BatCharacteristic("Rotation Z", BatVocabulary.EPen.Characteristics.rotationZCharacteristic, false, null, 12, null);
        this.rotationZCharacteristic = batCharacteristic25;
        BatCharacteristic batCharacteristic26 = new BatCharacteristic("Gyroscope Sensitivity", BatVocabulary.EPen.Characteristics.gyroscopeSensitivityCharacteristic, false, null, 12, null);
        this.gyroscopeSensitivityCharacteristic = batCharacteristic26;
        BatCharacteristic batCharacteristic27 = new BatCharacteristic("Accelerometer Interrupt", BatVocabulary.EPen.Characteristics.accelerometerInterruptCharacteristic, false, null, 12, null);
        this.accelerometerInterruptCharacteristic = batCharacteristic27;
        BatService batService5 = new BatService("Accelerometer", BatVocabulary.EPen.Services.accelerometerService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic19, batCharacteristic20, batCharacteristic21, batCharacteristic22, batCharacteristic23, batCharacteristic24, batCharacteristic25, batCharacteristic26, batCharacteristic27}));
        this.accelerometerService = batService5;
        BatCharacteristic batCharacteristic28 = new BatCharacteristic("Device Control", BatVocabulary.EPen.Characteristics.deviceControlCharacteristic, false, null, 12, null);
        this.deviceControlCharacteristic = batCharacteristic28;
        BatCharacteristic batCharacteristic29 = new BatCharacteristic("Device Time", BatVocabulary.EPen.Characteristics.deviceTimeCharacteristic, false, null, 12, null);
        this.deviceTimeCharacteristic = batCharacteristic29;
        BatCharacteristic batCharacteristic30 = new BatCharacteristic("Device State", BatVocabulary.EPen.Characteristics.deviceStateCharacteristic, false, null, 12, null);
        this.deviceStateCharacteristic = batCharacteristic30;
        BatCharacteristic batCharacteristic31 = new BatCharacteristic("Records Available", BatVocabulary.EPen.Characteristics.recordsAvailableCharacteristic, false, null, 12, null);
        this.recordsAvailableCharacteristic = batCharacteristic31;
        BatCharacteristic batCharacteristic32 = new BatCharacteristic("Events Available", BatVocabulary.EPen.Characteristics.eventsAvailableCharacteristic, false, null, 12, null);
        this.eventsAvailableCharacteristic = batCharacteristic32;
        BatCharacteristic batCharacteristic33 = new BatCharacteristic("Device Charging", BatVocabulary.EPen.Characteristics.deviceChargingCharacteristic, false, null, 12, null);
        this.deviceChargingCharacteristic = batCharacteristic33;
        BatService batService6 = new BatService("Vape Device", BatVocabulary.EPen.Services.vapeDeviceService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic28, batCharacteristic29, batCharacteristic30, batCharacteristic31, batCharacteristic32, batCharacteristic33}));
        this.vapeDeviceService = batService6;
        BatCharacteristic batCharacteristic34 = new BatCharacteristic("Rx", BatVocabulary.EPen.Characteristics.rxCharacteristic, false, null, 12, null);
        this.rxCharacteristic = batCharacteristic34;
        BatCharacteristic batCharacteristic35 = new BatCharacteristic("Tx", BatVocabulary.EPen.Characteristics.txCharacteristic, false, null, 12, null);
        this.txCharacteristic = batCharacteristic35;
        BatService batService7 = new BatService("UART", BatVocabulary.EPen.Services.uartService, ServiceType.Generic.INSTANCE, CollectionsKt.listOf((Object[]) new BatCharacteristic[]{batCharacteristic34, batCharacteristic35}));
        this.uartService = batService7;
        this.services = CollectionsKt.listOf((Object[]) new BatService[]{batService, batService2, batService3, batService4, batService5, batService6, batService7});
    }

    public final BatCharacteristic getModelCharacteristic() {
        return this.modelCharacteristic;
    }

    public final BatCharacteristic getSerialNumberCharacteristic() {
        return this.serialNumberCharacteristic;
    }

    public final BatCharacteristic getFirmwareRevisionCharacteristic() {
        return this.firmwareRevisionCharacteristic;
    }

    public final BatCharacteristic getHardwareRevisionCharacteristic() {
        return this.hardwareRevisionCharacteristic;
    }

    public final BatCharacteristic getSoftwareRevisionCharacteristic() {
        return this.softwareRevisionCharacteristic;
    }

    public final BatCharacteristic getManufacturerCharacteristic() {
        return this.manufacturerCharacteristic;
    }

    public final BatService getDeviceInfoService() {
        return this.deviceInfoService;
    }

    public final BatCharacteristic getBatteryLevelCharacteristic() {
        return this.batteryLevelCharacteristic;
    }

    public final BatService getBatteryService() {
        return this.batteryService;
    }

    public final BatCharacteristic getCoilActivationCharacteristic() {
        return this.coilActivationCharacteristic;
    }

    public final BatCharacteristic getPressureSensorCharacteristic() {
        return this.pressureSensorCharacteristic;
    }

    public final BatCharacteristic getPressureThresholdCharacteristic() {
        return this.pressureThresholdCharacteristic;
    }

    public final BatCharacteristic getBufferTimeoutCharacteristic() {
        return this.bufferTimeoutCharacteristic;
    }

    public final BatService getSensorDataService() {
        return this.sensorDataService;
    }

    public final BatCharacteristic getCartomiserIdCharacteristic() {
        return this.cartomiserIdCharacteristic;
    }

    public final BatCharacteristic getFlavourIdCharacteristic() {
        return this.flavourIdCharacteristic;
    }

    public final BatCharacteristic getJoulesRemainingCharacteristic() {
        return this.joulesRemainingCharacteristic;
    }

    public final BatCharacteristic getTotalPuffsCharacteristic() {
        return this.totalPuffsCharacteristic;
    }

    public final BatCharacteristic getTotalUseTimeCharacteristic() {
        return this.totalUseTimeCharacteristic;
    }

    public final BatCharacteristic getDevicePowerLevelCharacteristic() {
        return this.devicePowerLevelCharacteristic;
    }

    public final BatCharacteristic getCartomiserPresentCharacteristic() {
        return this.cartomiserPresentCharacteristic;
    }

    public final BatService getCartomiserService() {
        return this.cartomiserService;
    }

    public final BatCharacteristic getAccelerometerXCharacteristic() {
        return this.accelerometerXCharacteristic;
    }

    public final BatCharacteristic getAccelerometerYCharacteristic() {
        return this.accelerometerYCharacteristic;
    }

    public final BatCharacteristic getAccelerometerZCharacteristic() {
        return this.accelerometerZCharacteristic;
    }

    public final BatCharacteristic getAccelerometerSensitivityCharacteristic() {
        return this.accelerometerSensitivityCharacteristic;
    }

    public final BatCharacteristic getRotationXCharacteristic() {
        return this.rotationXCharacteristic;
    }

    public final BatCharacteristic getRotationYCharacteristic() {
        return this.rotationYCharacteristic;
    }

    public final BatCharacteristic getRotationZCharacteristic() {
        return this.rotationZCharacteristic;
    }

    public final BatCharacteristic getGyroscopeSensitivityCharacteristic() {
        return this.gyroscopeSensitivityCharacteristic;
    }

    public final BatCharacteristic getAccelerometerInterruptCharacteristic() {
        return this.accelerometerInterruptCharacteristic;
    }

    public final BatService getAccelerometerService() {
        return this.accelerometerService;
    }

    public final BatCharacteristic getDeviceControlCharacteristic() {
        return this.deviceControlCharacteristic;
    }

    public final BatCharacteristic getDeviceTimeCharacteristic() {
        return this.deviceTimeCharacteristic;
    }

    public final BatCharacteristic getDeviceStateCharacteristic() {
        return this.deviceStateCharacteristic;
    }

    public final BatCharacteristic getRecordsAvailableCharacteristic() {
        return this.recordsAvailableCharacteristic;
    }

    public final BatCharacteristic getEventsAvailableCharacteristic() {
        return this.eventsAvailableCharacteristic;
    }

    public final BatCharacteristic getDeviceChargingCharacteristic() {
        return this.deviceChargingCharacteristic;
    }

    public final BatService getVapeDeviceService() {
        return this.vapeDeviceService;
    }

    public final BatCharacteristic getRxCharacteristic() {
        return this.rxCharacteristic;
    }

    public final BatCharacteristic getTxCharacteristic() {
        return this.txCharacteristic;
    }

    public final BatService getUartService() {
        return this.uartService;
    }

    public final List<BatService> getServices() {
        return this.services;
    }

    public final List<BatService> setup(List<? extends BluetoothGattService> gattServices) {
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Logger.INSTANCE.log("EPen - setting up " + gattServices.size() + " services");
        ArrayList arrayList = new ArrayList();
        List<? extends BluetoothGattService> list = gattServices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(createUnknownService((BluetoothGattService) it2.next()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        if (!this.vapeDeviceService.setup(gattServices)) {
            Logger.INSTANCE.log("EPen: setup failed - vaping service is missing");
            return CollectionsKt.emptyList();
        }
        arrayList.add(this.vapeDeviceService);
        mutableList.remove(this.vapeDeviceService);
        List<BatService> list2 = this.services;
        ArrayList<BatService> arrayList3 = new ArrayList();
        for (Object obj : list2) {
            if (((BatService) obj).getGattService() == null) {
                arrayList3.add(obj);
            }
        }
        for (BatService batService : arrayList3) {
            if (batService.setup(gattServices)) {
                arrayList.add(batService);
                mutableList.remove(batService);
            }
        }
        Logger.INSTANCE.log("EPen: services are setup");
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
