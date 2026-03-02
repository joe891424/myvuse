package com.bat.myvuse.mobile.rncomponents.nodes;

import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.ble.BleDeviceData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NodesModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/myvuse/mobile/rncomponents/nodes/ScanningState;", "", "device", "", "Lcom/bat/sdk/ble/BatDevice;", "deviceList", "Lcom/bat/sdk/ble/BleDeviceData;", "isScanning", "", "(Ljava/util/List;Ljava/util/List;Z)V", "getDevice", "()Ljava/util/List;", "getDeviceList", "()Z", "app_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ScanningState {
    private final List<BatDevice> device;
    private final List<BleDeviceData> deviceList;
    private final boolean isScanning;

    public ScanningState(List<BatDevice> device, List<BleDeviceData> deviceList, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceList, "deviceList");
        this.device = device;
        this.deviceList = deviceList;
        this.isScanning = z;
    }

    public final List<BatDevice> getDevice() {
        return this.device;
    }

    public final List<BleDeviceData> getDeviceList() {
        return this.deviceList;
    }

    /* JADX INFO: renamed from: isScanning, reason: from getter */
    public final boolean getIsScanning() {
        return this.isScanning;
    }
}
