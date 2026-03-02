package com.bat.sdk.ble;

import com.bat.sdk.ble.advertising.DeviceAdvertisingData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatDevice.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/ble/BatDevice;", "Ljava/io/Serializable;", "name", "", "address", "rssi", "", "advertisingData", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bat/sdk/ble/advertising/DeviceAdvertisingData;)V", "getName", "()Ljava/lang/String;", "getAddress", "getRssi", "()I", "getAdvertisingData", "()Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BatDevice implements Serializable {
    private final String address;
    private final DeviceAdvertisingData advertisingData;
    private final String name;
    private final int rssi;

    public static /* synthetic */ BatDevice copy$default(BatDevice batDevice, String str, String str2, int i, DeviceAdvertisingData deviceAdvertisingData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = batDevice.name;
        }
        if ((i2 & 2) != 0) {
            str2 = batDevice.address;
        }
        if ((i2 & 4) != 0) {
            i = batDevice.rssi;
        }
        if ((i2 & 8) != 0) {
            deviceAdvertisingData = batDevice.advertisingData;
        }
        return batDevice.copy(str, str2, i, deviceAdvertisingData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRssi() {
        return this.rssi;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DeviceAdvertisingData getAdvertisingData() {
        return this.advertisingData;
    }

    public final BatDevice copy(String name, String address, int rssi, DeviceAdvertisingData advertisingData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        return new BatDevice(name, address, rssi, advertisingData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatDevice)) {
            return false;
        }
        BatDevice batDevice = (BatDevice) other;
        return Intrinsics.areEqual(this.name, batDevice.name) && Intrinsics.areEqual(this.address, batDevice.address) && this.rssi == batDevice.rssi && Intrinsics.areEqual(this.advertisingData, batDevice.advertisingData);
    }

    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.address.hashCode()) * 31) + Integer.hashCode(this.rssi)) * 31;
        DeviceAdvertisingData deviceAdvertisingData = this.advertisingData;
        return iHashCode + (deviceAdvertisingData == null ? 0 : deviceAdvertisingData.hashCode());
    }

    public String toString() {
        return "BatDevice(name=" + this.name + ", address=" + this.address + ", rssi=" + this.rssi + ", advertisingData=" + this.advertisingData + ')';
    }

    public BatDevice(String name, String address, int i, DeviceAdvertisingData deviceAdvertisingData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        this.name = name;
        this.address = address;
        this.rssi = i;
        this.advertisingData = deviceAdvertisingData;
    }

    public /* synthetic */ BatDevice(String str, String str2, int i, DeviceAdvertisingData deviceAdvertisingData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : deviceAdvertisingData);
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final DeviceAdvertisingData getAdvertisingData() {
        return this.advertisingData;
    }
}
