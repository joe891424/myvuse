package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceTime;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/client/TimeClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/DeviceTime;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class TimeClient extends CharacteristicClient<DeviceTime, DeviceTime> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.timeCharacteristic, BatVocabulary.EPod2.Characteristics.timeCharacteristic, BatVocabulary.EPod3.Characteristics.timeCharacteristic, BatVocabulary.VPro.Characteristics.timeCharacteristic, BatVocabulary.Alto2.Characteristics.timeCharacteristic, BatVocabulary.Aquila.Characteristics.timeCharacteristic, BatVocabulary.AquilaNS.Characteristics.timeCharacteristic, BatVocabulary.SmartBox.Characteristics.timeCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.timeCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(DeviceTime request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        byte[] byteArrayBigEndian$default = ConversionExtensionsKt.toByteArrayBigEndian$default(request.getDateTime().getTime() / ((long) 1000), 0, 1, null);
        return request.getTimeZone() == null ? byteArrayBigEndian$default : ArraysKt.plus(byteArrayBigEndian$default, ConversionExtensionsKt.toByteArrayBigEndian(request.getTimeZone().shortValue(), 2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public DeviceTime decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[Time] bytes size: " + bytes.length);
        Date date = new Date();
        if (bytes.length == 6) {
            date.setTime(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null) * ((long) 1000));
            return new DeviceTime(date, Short.valueOf((short) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, 6), 0, 1, null)));
        }
        date.setTime(ConversionExtensionsKt.toLongBigEndian$default(bytes, 0, 1, null) * ((long) 1000));
        return new DeviceTime(date, null, 2, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
