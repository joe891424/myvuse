package com.bat.sdk.client;

import com.bat.sdk.DateExtensionKt;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.ErrorRecord;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/client/ErrorClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/ErrorRecord;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "(Lkotlin/Unit;Lcom/bat/sdk/model/DeviceType;)[B", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class ErrorClient extends CharacteristicClient<Unit, ErrorRecord> {
    private final List<String> characteristicUuids;

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Unit request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new byte[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.errorCharacteristic, BatVocabulary.EPod2.Characteristics.errorCharacteristic, BatVocabulary.EPod3.Characteristics.errorCharacteristic, BatVocabulary.VPro.Characteristics.errorCharacteristic, BatVocabulary.Alto2.Characteristics.errorCharacteristic, BatVocabulary.Aquila.Characteristics.errorCharacteristic, BatVocabulary.SmartBox.Characteristics.errorCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.errorCharacteristic, BatVocabulary.AquilaNS.Characteristics.errorCharacteristic});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public ErrorRecord decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        int length = bytes.length;
        if (length == 5) {
            Date dateAdjusted = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null) * ((long) 1000)));
            byte b = bytes[4];
            if (dateAdjusted != null) {
                return new ErrorRecord(b, dateAdjusted, null, 4, null);
            }
        } else if (length == 6) {
            byte b2 = bytes[0];
            Date dateAdjusted2 = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 1, 5), 0, 1, null) * ((long) 1000)));
            byte b3 = bytes[5];
            if (dateAdjusted2 != null) {
                return new ErrorRecord(b3, dateAdjusted2, Integer.valueOf(b2));
            }
        }
        return null;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
