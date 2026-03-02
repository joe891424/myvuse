package com.bat.sdk.ble;

import android.bluetooth.BluetoothGattService;
import com.bat.sdk.devices.Alto2;
import com.bat.sdk.devices.Aquila;
import com.bat.sdk.devices.AquilaNS;
import com.bat.sdk.devices.DFU;
import com.bat.sdk.devices.EPen;
import com.bat.sdk.devices.EPod;
import com.bat.sdk.devices.EPod2;
import com.bat.sdk.devices.EPod3;
import com.bat.sdk.devices.SmartBox;
import com.bat.sdk.devices.SmartBoxUS;
import com.bat.sdk.devices.VPro;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatServiceConverter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/ble/BatServiceConverter;", "", "<init>", "()V", "convert", "Lcom/bat/sdk/ble/DeviceServices;", "deviceAddress", "", "gattServices", "", "Landroid/bluetooth/BluetoothGattService;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatServiceConverter {
    public static final BatServiceConverter INSTANCE = new BatServiceConverter();

    private BatServiceConverter() {
    }

    public final DeviceServices convert(String deviceAddress, List<? extends BluetoothGattService> gattServices) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Logger.INSTANCE.log(gattServices.size() + " services discovered for device " + deviceAddress);
        Iterator<T> it2 = gattServices.iterator();
        while (it2.hasNext()) {
            Logger.INSTANCE.log("Service -> " + ((BluetoothGattService) it2.next()).getUuid());
        }
        List<BatService> upVar = new EPod().setup(gattServices);
        List<BatService> upVar2 = new EPod2().setup(gattServices);
        List<BatService> upVar3 = new Alto2().setup(gattServices);
        List<BatService> upVar4 = new Aquila().setup(gattServices);
        List<BatService> upVar5 = new EPod3().setup(gattServices);
        List<BatService> upVar6 = new VPro().setup(gattServices);
        List<BatService> upVar7 = new SmartBox().setup(gattServices);
        List<BatService> upVar8 = new SmartBoxUS().setup(gattServices);
        List<BatService> upVar9 = new AquilaNS().setup(gattServices);
        List<BatService> upVar10 = new EPen().setup(gattServices);
        List<BatService> upVar11 = new DFU().setup(gattServices);
        return !upVar.isEmpty() ? new DeviceServices(DeviceType.EPod.INSTANCE, upVar) : !upVar2.isEmpty() ? new DeviceServices(DeviceType.EPod2.INSTANCE, upVar2) : !upVar3.isEmpty() ? new DeviceServices(DeviceType.Alto2.INSTANCE, upVar3) : !upVar4.isEmpty() ? new DeviceServices(DeviceType.Aquila.INSTANCE, upVar4) : !upVar5.isEmpty() ? new DeviceServices(DeviceType.EPod3.INSTANCE, upVar5) : !upVar6.isEmpty() ? new DeviceServices(DeviceType.VPro.INSTANCE, upVar6) : !upVar7.isEmpty() ? new DeviceServices(DeviceType.SmartBox.INSTANCE, upVar7) : !upVar8.isEmpty() ? new DeviceServices(DeviceType.SmartBoxUS.INSTANCE, upVar8) : !upVar9.isEmpty() ? new DeviceServices(DeviceType.AquilaNS.INSTANCE, upVar9) : !upVar10.isEmpty() ? new DeviceServices(DeviceType.EPen.INSTANCE, upVar10) : !upVar11.isEmpty() ? new DeviceServices(DeviceType.DFU.INSTANCE, upVar11) : new DeviceServices(DeviceType.Unknown.INSTANCE, CollectionsKt.emptyList());
    }
}
