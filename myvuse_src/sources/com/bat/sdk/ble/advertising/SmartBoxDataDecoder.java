package com.bat.sdk.ble.advertising;

import android.util.SparseArray;
import com.bat.sdk.ble.advertising.DeviceAdvertisingData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SmartBoxDataDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/ble/advertising/SmartBoxDataDecoder;", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingDataDecoder;", "<init>", "()V", "decode", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "manufacturerSpecificData", "Landroid/util/SparseArray;", "", "canDecode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class SmartBoxDataDecoder implements DeviceAdvertisingDataDecoder {
    @Override // com.bat.sdk.ble.advertising.DeviceAdvertisingDataDecoder
    public DeviceAdvertisingData decode(SparseArray<byte[]> manufacturerSpecificData) {
        Intrinsics.checkNotNullParameter(manufacturerSpecificData, "manufacturerSpecificData");
        byte[] bArrValueAt = manufacturerSpecificData.valueAt(0);
        Intrinsics.checkNotNull(bArrValueAt);
        return new DeviceAdvertisingData.SmartBoxAdvertisingData(bArrValueAt[6], bArrValueAt[7], manufacturerSpecificData.keyAt(0), CollectionsKt.joinToString$default(CollectionsKt.reversed(ArraysKt.asList(ArraysKt.copyOfRange(bArrValueAt, 0, 6))), ":", null, null, 0, null, new Function1() { // from class: com.bat.sdk.ble.advertising.SmartBoxDataDecoder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SmartBoxDataDecoder.decode$lambda$1$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence decode$lambda$1$lambda$0(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @Override // com.bat.sdk.ble.advertising.DeviceAdvertisingDataDecoder
    public boolean canDecode(SparseArray<byte[]> manufacturerSpecificData) {
        Intrinsics.checkNotNullParameter(manufacturerSpecificData, "manufacturerSpecificData");
        return manufacturerSpecificData.size() == 1 && manufacturerSpecificData.valueAt(0).length == 8;
    }
}
