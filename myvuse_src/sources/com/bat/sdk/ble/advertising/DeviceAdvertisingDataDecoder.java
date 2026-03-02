package com.bat.sdk.ble.advertising;

import android.util.SparseArray;
import kotlin.Metadata;

/* JADX INFO: compiled from: DeviceAdvertisingDataDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/ble/advertising/DeviceAdvertisingDataDecoder;", "", "decode", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "manufacturerSpecificData", "Landroid/util/SparseArray;", "", "canDecode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface DeviceAdvertisingDataDecoder {
    boolean canDecode(SparseArray<byte[]> manufacturerSpecificData);

    DeviceAdvertisingData decode(SparseArray<byte[]> manufacturerSpecificData);
}
