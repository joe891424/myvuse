package com.bat.sdk.asav.handlers;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.util.SparseArray;
import androidx.core.util.SparseArrayKt;
import com.bat.sdk.asav.core.AsavLog;
import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: FilteringScanCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ$\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0007H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/FilteringScanCallback;", "Landroid/bluetooth/le/ScanCallback;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "statusFilter", "Lkotlin/Function2;", "Lcom/bat/sdk/asav/core/AsavStatus;", "Lcom/bat/sdk/ble/BatDevice;", "", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lkotlin/jvm/functions/Function2;)V", "getAsavContext", "()Lcom/bat/sdk/asav/core/IAsavContext;", "getStatusFilter", "()Lkotlin/jvm/functions/Function2;", "rssiThreshold", "", "getRssiThreshold", "()I", "rssiThreshold$delegate", "Lkotlin/Lazy;", "toHexString", "", "", "onScanResult", "", "callbackType", "result", "Landroid/bluetooth/le/ScanResult;", "batDeviceOf", "name", "address", "rssi", "onFilteredData", "data", "batDevice", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class FilteringScanCallback extends ScanCallback {
    private final IAsavContext asavContext;

    /* JADX INFO: renamed from: rssiThreshold$delegate, reason: from kotlin metadata */
    private final Lazy rssiThreshold;
    private final Function2<AsavStatus, BatDevice, Boolean> statusFilter;

    public abstract void onFilteredData(String data, BatDevice batDevice);

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringScanCallback(IAsavContext asavContext, Function2<? super AsavStatus, ? super BatDevice, Boolean> statusFilter) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(statusFilter, "statusFilter");
        this.asavContext = asavContext;
        this.statusFilter = statusFilter;
        this.rssiThreshold = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.asav.handlers.FilteringScanCallback$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(FilteringScanCallback.rssiThreshold_delegate$lambda$0(this.f$0));
            }
        });
    }

    public final IAsavContext getAsavContext() {
        return this.asavContext;
    }

    public final Function2<AsavStatus, BatDevice, Boolean> getStatusFilter() {
        return this.statusFilter;
    }

    private final int getRssiThreshold() {
        return ((Number) this.rssiThreshold.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rssiThreshold_delegate$lambda$0(FilteringScanCallback this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.asavContext.settings().getRSSIthreshold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHexString$lambda$1(UByte uByte) {
        return StringsKt.padStart(UStringsKt.m8546toStringLxnNnR4(uByte.getData(), 16), 2, '0');
    }

    public final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return CollectionsKt.joinToString$default(UByteArray.m7302boximpl(UByteArray.m7304constructorimpl(bArr)), "", null, null, 0, null, new Function1() { // from class: com.bat.sdk.asav.handlers.FilteringScanCallback$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilteringScanCallback.toHexString$lambda$1((UByte) obj);
            }
        }, 30, null);
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int callbackType, ScanResult result) {
        SparseArray<byte[]> manufacturerSpecificData;
        BluetoothDevice device;
        BluetoothDevice device2;
        String str;
        SparseArray<byte[]> manufacturerSpecificData2;
        int size;
        BluetoothDevice device3;
        String string = null;
        String str2 = "";
        if (Intrinsics.areEqual((result == null || (device3 = result.getDevice()) == null) ? null : device3.getAddress(), "D3:CA:C0:EE:07:1F")) {
            ScanRecord scanRecord = result.getScanRecord();
            if (scanRecord == null || (manufacturerSpecificData2 = scanRecord.getManufacturerSpecificData()) == null || (size = manufacturerSpecificData2.size()) <= 0) {
                str = "";
            } else {
                int i = 0;
                str = "";
                while (true) {
                    int i2 = i + 1;
                    manufacturerSpecificData2.keyAt(i);
                    byte[] bArrValueAt = manufacturerSpecificData2.valueAt(i);
                    Logger logger = Logger.INSTANCE;
                    StringBuilder sb = new StringBuilder("value:");
                    Intrinsics.checkNotNull(bArrValueAt, "null cannot be cast to non-null type kotlin.ByteArray");
                    logger.log("ScanCallback", sb.append(toHexString(bArrValueAt)).toString());
                    str = str + toHexString(bArrValueAt) + SafeJsonPrimitive.NULL_CHAR;
                    if (i2 >= size) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            String str3 = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS").withZone(ZoneId.systemDefault()).format(Instant.now());
            AsavLog logger2 = AsavLogKt.getLogger();
            StringBuilder sbAppend = new StringBuilder().append(str3).append(", ");
            String name = result.getDevice().getName();
            if (name == null) {
                name = "Unnamed";
            }
            logger2.debug(sbAppend.append(name).append(", ").append(result.getDevice().getAddress()).append(", ").append(str).toString());
        }
        Logger logger3 = Logger.INSTANCE;
        String str4 = FilteringScanCallbackKt.TAG;
        Intrinsics.checkNotNull(str4);
        StringBuilder sb2 = new StringBuilder("device name: ");
        String name2 = (result == null || (device2 = result.getDevice()) == null) ? null : device2.getName();
        if (name2 == null) {
            name2 = "";
        }
        logger3.log(str4, sb2.append(name2).append(", mac:").append((result == null || (device = result.getDevice()) == null) ? null : device.getAddress()).append(" rssi:").append(result != null ? Integer.valueOf(result.getRssi()) : null).toString());
        if (result != null) {
            try {
                ScanRecord scanRecord2 = result.getScanRecord();
                if (scanRecord2 != null) {
                    Logger logger4 = Logger.INSTANCE;
                    String str5 = FilteringScanCallbackKt.TAG;
                    StringBuilder sbAppend2 = new StringBuilder().append("device name: ");
                    String name3 = result.getDevice().getName();
                    if (name3 == null) {
                        name3 = "";
                    }
                    logger4.log(str5, sbAppend2.append(name3).toString());
                    String name4 = result.getDevice().getName();
                    if (name4 == null) {
                        name4 = "";
                    }
                    BatDevice batDeviceBatDeviceOf = batDeviceOf(name4, result.getDevice().getAddress(), result.getRssi());
                    Logger logger5 = Logger.INSTANCE;
                    String str6 = FilteringScanCallbackKt.TAG;
                    Intrinsics.checkNotNull(str6);
                    StringBuilder sbAppend3 = new StringBuilder().append("device name: ");
                    String name5 = result.getDevice().getName();
                    if (name5 != null) {
                        str2 = name5;
                    }
                    logger5.log(str6, sbAppend3.append(str2).append(", mac:").append(batDeviceBatDeviceOf.getAddress()).append(" rssi:").append(result.getRssi()).append(", statusFilter:").append(this.statusFilter.invoke(this.asavContext.getCurrentStatus(), batDeviceBatDeviceOf).booleanValue()).append(", manufData:").append(scanRecord2.getManufacturerSpecificData().size()).append(SafeJsonPrimitive.NULL_CHAR).toString());
                    if (result.getRssi() <= getRssiThreshold() || !this.statusFilter.invoke(this.asavContext.getCurrentStatus(), batDeviceBatDeviceOf).booleanValue() || (manufacturerSpecificData = scanRecord2.getManufacturerSpecificData()) == null || manufacturerSpecificData.size() <= 0) {
                        return;
                    }
                    byte[] bArr = (byte[]) CollectionsKt.firstOrNull(SequencesKt.toList(SequencesKt.asSequence(SparseArrayKt.valueIterator(manufacturerSpecificData))));
                    if (bArr != null) {
                        string = Arrays.toString(bArr);
                        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
                    }
                    Logger logger6 = Logger.INSTANCE;
                    String str7 = FilteringScanCallbackKt.TAG;
                    Intrinsics.checkNotNull(str7);
                    logger6.log(str7, "onFilteredData:" + batDeviceBatDeviceOf.getName() + ", " + batDeviceBatDeviceOf.getAddress() + ", " + batDeviceBatDeviceOf.getRssi() + ", data:" + string);
                    if (string != null) {
                        onFilteredData(string, batDeviceBatDeviceOf);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final BatDevice batDeviceOf(String name, String address, int rssi) {
        return new BatDevice(name == null ? "" : name, address == null ? "" : address, rssi, null, 8, null);
    }
}
