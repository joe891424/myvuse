package com.bat.sdk.ble.advertising;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceAdvertisingData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "Ljava/io/Serializable;", "<init>", "()V", "SmartBoxAdvertisingData", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData$SmartBoxAdvertisingData;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class DeviceAdvertisingData implements Serializable {
    public /* synthetic */ DeviceAdvertisingData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeviceAdvertisingData() {
    }

    /* JADX INFO: compiled from: DeviceAdvertisingData.kt */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData$SmartBoxAdvertisingData;", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "deviceType", "", "deviceColor", "manufactureId", "deviceAddress", "", "<init>", "(IIILjava/lang/String;)V", "getDeviceType", "()I", "getDeviceColor", "getManufactureId", "getDeviceAddress", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class SmartBoxAdvertisingData extends DeviceAdvertisingData {
        private final String deviceAddress;
        private final int deviceColor;
        private final int deviceType;
        private final int manufactureId;

        public static /* synthetic */ SmartBoxAdvertisingData copy$default(SmartBoxAdvertisingData smartBoxAdvertisingData, int i, int i2, int i3, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = smartBoxAdvertisingData.deviceType;
            }
            if ((i4 & 2) != 0) {
                i2 = smartBoxAdvertisingData.deviceColor;
            }
            if ((i4 & 4) != 0) {
                i3 = smartBoxAdvertisingData.manufactureId;
            }
            if ((i4 & 8) != 0) {
                str = smartBoxAdvertisingData.deviceAddress;
            }
            return smartBoxAdvertisingData.copy(i, i2, i3, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDeviceType() {
            return this.deviceType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDeviceColor() {
            return this.deviceColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getManufactureId() {
            return this.manufactureId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final SmartBoxAdvertisingData copy(int deviceType, int deviceColor, int manufactureId, String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new SmartBoxAdvertisingData(deviceType, deviceColor, manufactureId, deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SmartBoxAdvertisingData)) {
                return false;
            }
            SmartBoxAdvertisingData smartBoxAdvertisingData = (SmartBoxAdvertisingData) other;
            return this.deviceType == smartBoxAdvertisingData.deviceType && this.deviceColor == smartBoxAdvertisingData.deviceColor && this.manufactureId == smartBoxAdvertisingData.manufactureId && Intrinsics.areEqual(this.deviceAddress, smartBoxAdvertisingData.deviceAddress);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.deviceType) * 31) + Integer.hashCode(this.deviceColor)) * 31) + Integer.hashCode(this.manufactureId)) * 31) + this.deviceAddress.hashCode();
        }

        public String toString() {
            return "SmartBoxAdvertisingData(deviceType=" + this.deviceType + ", deviceColor=" + this.deviceColor + ", manufactureId=" + this.manufactureId + ", deviceAddress=" + this.deviceAddress + ')';
        }

        public final int getDeviceType() {
            return this.deviceType;
        }

        public final int getDeviceColor() {
            return this.deviceColor;
        }

        public final int getManufactureId() {
            return this.manufactureId;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmartBoxAdvertisingData(int i, int i2, int i3, String deviceAddress) {
            super(null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceType = i;
            this.deviceColor = i2;
            this.manufactureId = i3;
            this.deviceAddress = deviceAddress;
        }
    }
}
