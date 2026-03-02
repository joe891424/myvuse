package com.bat.sdk.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.bat.sdk.ble.ConnectionState;
import com.bat.sdk.ble.DiscoveryServicesState;
import com.bat.sdk.model.DeviceType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BleDeviceData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003Je\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001e¨\u0006;"}, m5598d2 = {"Lcom/bat/sdk/ble/BleDeviceData;", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "connectionState", "Lcom/bat/sdk/ble/ConnectionState;", "name", "", "rssi", "", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "services", "", "Lcom/bat/sdk/ble/BatService;", "discoveryServicesState", "Lcom/bat/sdk/ble/DiscoveryServicesState;", "btCallback", "Landroid/bluetooth/BluetoothGattCallback;", "<init>", "(Landroid/bluetooth/BluetoothGatt;Lcom/bat/sdk/ble/ConnectionState;Ljava/lang/String;ILcom/bat/sdk/model/DeviceType;Ljava/util/List;Lcom/bat/sdk/ble/DiscoveryServicesState;Landroid/bluetooth/BluetoothGattCallback;)V", "callback", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCallback;)V", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "setGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "getConnectionState", "()Lcom/bat/sdk/ble/ConnectionState;", "getName", "()Ljava/lang/String;", "getRssi", "()I", "getDeviceType", "()Lcom/bat/sdk/model/DeviceType;", "getServices", "()Ljava/util/List;", "getDiscoveryServicesState", "()Lcom/bat/sdk/ble/DiscoveryServicesState;", "getBtCallback", "()Landroid/bluetooth/BluetoothGattCallback;", "setBtCallback", "(Landroid/bluetooth/BluetoothGattCallback;)V", "address", "getAddress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BleDeviceData {
    private final String address;
    private BluetoothGattCallback btCallback;
    private final ConnectionState connectionState;
    private final DeviceType deviceType;
    private final DiscoveryServicesState discoveryServicesState;
    private BluetoothGatt gatt;
    private final String name;
    private final int rssi;
    private final List<BatService> services;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRssi() {
        return this.rssi;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final List<BatService> component6() {
        return this.services;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DiscoveryServicesState getDiscoveryServicesState() {
        return this.discoveryServicesState;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final BluetoothGattCallback getBtCallback() {
        return this.btCallback;
    }

    public final BleDeviceData copy(BluetoothGatt gatt, ConnectionState connectionState, String name, int rssi, DeviceType deviceType, List<BatService> services, DiscoveryServicesState discoveryServicesState, BluetoothGattCallback btCallback) {
        Intrinsics.checkNotNullParameter(connectionState, "connectionState");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(discoveryServicesState, "discoveryServicesState");
        return new BleDeviceData(gatt, connectionState, name, rssi, deviceType, services, discoveryServicesState, btCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleDeviceData)) {
            return false;
        }
        BleDeviceData bleDeviceData = (BleDeviceData) other;
        return Intrinsics.areEqual(this.gatt, bleDeviceData.gatt) && Intrinsics.areEqual(this.connectionState, bleDeviceData.connectionState) && Intrinsics.areEqual(this.name, bleDeviceData.name) && this.rssi == bleDeviceData.rssi && Intrinsics.areEqual(this.deviceType, bleDeviceData.deviceType) && Intrinsics.areEqual(this.services, bleDeviceData.services) && Intrinsics.areEqual(this.discoveryServicesState, bleDeviceData.discoveryServicesState) && Intrinsics.areEqual(this.btCallback, bleDeviceData.btCallback);
    }

    public int hashCode() {
        BluetoothGatt bluetoothGatt = this.gatt;
        int iHashCode = (((((((((bluetoothGatt == null ? 0 : bluetoothGatt.hashCode()) * 31) + this.connectionState.hashCode()) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.rssi)) * 31) + this.deviceType.hashCode()) * 31;
        List<BatService> list = this.services;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.discoveryServicesState.hashCode()) * 31;
        BluetoothGattCallback bluetoothGattCallback = this.btCallback;
        return iHashCode2 + (bluetoothGattCallback != null ? bluetoothGattCallback.hashCode() : 0);
    }

    public String toString() {
        return "BleDeviceData(gatt=" + this.gatt + ", connectionState=" + this.connectionState + ", name=" + this.name + ", rssi=" + this.rssi + ", deviceType=" + this.deviceType + ", services=" + this.services + ", discoveryServicesState=" + this.discoveryServicesState + ", btCallback=" + this.btCallback + ')';
    }

    public BleDeviceData(BluetoothGatt bluetoothGatt, ConnectionState connectionState, String name, int i, DeviceType deviceType, List<BatService> list, DiscoveryServicesState discoveryServicesState, BluetoothGattCallback bluetoothGattCallback) {
        Intrinsics.checkNotNullParameter(connectionState, "connectionState");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(discoveryServicesState, "discoveryServicesState");
        this.gatt = bluetoothGatt;
        this.connectionState = connectionState;
        this.name = name;
        this.rssi = i;
        this.deviceType = deviceType;
        this.services = list;
        this.discoveryServicesState = discoveryServicesState;
        this.btCallback = bluetoothGattCallback;
        Intrinsics.checkNotNull(bluetoothGatt);
        String address = bluetoothGatt.getDevice().getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        this.address = address;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public final void setGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }

    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final List<BatService> getServices() {
        return this.services;
    }

    public final DiscoveryServicesState getDiscoveryServicesState() {
        return this.discoveryServicesState;
    }

    public final BluetoothGattCallback getBtCallback() {
        return this.btCallback;
    }

    public final void setBtCallback(BluetoothGattCallback bluetoothGattCallback) {
        this.btCallback = bluetoothGattCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BleDeviceData(BluetoothGatt gatt, BluetoothGattCallback callback) {
        this(gatt, ConnectionState.Disconnected.INSTANCE, "", -1, DeviceType.Unknown.INSTANCE, new ArrayList(), DiscoveryServicesState.NotDiscovered.INSTANCE, callback);
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final String getAddress() {
        return this.address;
    }
}
