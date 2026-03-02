package com.bat.sdk.ble;

import com.bat.sdk.model.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatServiceConverter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/ble/DeviceServices;", "", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "services", "", "Lcom/bat/sdk/ble/BatService;", "<init>", "(Lcom/bat/sdk/model/DeviceType;Ljava/util/List;)V", "getDeviceType", "()Lcom/bat/sdk/model/DeviceType;", "getServices", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class DeviceServices {
    private final DeviceType deviceType;
    private final List<BatService> services;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceServices copy$default(DeviceServices deviceServices, DeviceType deviceType, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceType = deviceServices.deviceType;
        }
        if ((i & 2) != 0) {
            list = deviceServices.services;
        }
        return deviceServices.copy(deviceType, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final List<BatService> component2() {
        return this.services;
    }

    public final DeviceServices copy(DeviceType deviceType, List<BatService> services) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(services, "services");
        return new DeviceServices(deviceType, services);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceServices)) {
            return false;
        }
        DeviceServices deviceServices = (DeviceServices) other;
        return Intrinsics.areEqual(this.deviceType, deviceServices.deviceType) && Intrinsics.areEqual(this.services, deviceServices.services);
    }

    public int hashCode() {
        return (this.deviceType.hashCode() * 31) + this.services.hashCode();
    }

    public String toString() {
        return "DeviceServices(deviceType=" + this.deviceType + ", services=" + this.services + ')';
    }

    public DeviceServices(DeviceType deviceType, List<BatService> services) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(services, "services");
        this.deviceType = deviceType;
        this.services = services;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final List<BatService> getServices() {
        return this.services;
    }
}
