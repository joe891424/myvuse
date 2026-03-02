package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.UsageReminder;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UsageReminderClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/client/UsageReminderClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/UsageReminder;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class UsageReminderClient extends CharacteristicClient<UsageReminder, UsageReminder> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsageReminderClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod3.Characteristics.usageReminderCharacteristic, BatVocabulary.SmartBox.Characteristics.usageReminderCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(UsageReminder request, DeviceType deviceType) {
        byte[] bArrPlus;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[UG] request to be sent: " + request);
        byte[] bArrPlus2 = ArraysKt.plus(ConversionExtensionsKt.toByteArrayBigEndian(request.getUsageGoal(), 2), ConversionExtensionsKt.toByteArrayBigEndian(request.getRunCycle(), 2));
        if (request.getTimeZone() != null) {
            bArrPlus2 = ArraysKt.plus(bArrPlus2, ConversionExtensionsKt.toByteArrayBigEndian(r1.shortValue(), 2));
        }
        byte[] bArrPlus3 = ArraysKt.plus(bArrPlus2, new byte[]{(byte) request.getAlertType(), (byte) request.getAlertDuration(), request.getAlertDemo(), (byte) request.getSoundPattern()});
        byte[] bArr = {(byte) request.getHapticOnDuration(), (byte) request.getHapticOffDuration()};
        if (request.getLedColor() != null && request.getLedOnDuration() != null && request.getLedOffDuration() != null) {
            bArrPlus = ArraysKt.plus(ArraysKt.plus(bArrPlus3, new byte[]{(byte) request.getLedColor().intValue(), (byte) request.getLedOnDuration().intValue(), (byte) request.getLedOffDuration().intValue()}), bArr);
        } else {
            bArrPlus = ArraysKt.plus(bArrPlus3, bArr);
        }
        Logger.INSTANCE.log("[UG] sending byteArrayToSend: " + ConversionExtensionsKt.toHexString(bArrPlus));
        return bArrPlus;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public UsageReminder decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[UR] bytes received: " + bytes.length);
        int length = bytes.length;
        if (length == 10) {
            return new UsageReminder((int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 2), 0, 1, null), (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 2, 4), 0, 1, null), null, bytes[4], bytes[5], bytes[6] == 1, bytes[7], null, null, null, bytes[8], bytes[9]);
        }
        if (length == 15) {
            return new UsageReminder((int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 2), 0, 1, null), (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 2, 4), 0, 1, null), Short.valueOf((short) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, 6), 0, 1, null)), bytes[6], bytes[7], bytes[8] == 1, bytes[9], Integer.valueOf(bytes[10]), Integer.valueOf(bytes[11]), Integer.valueOf(bytes[12]), bytes[13], bytes[14]);
        }
        return new UsageReminder(0, 0, null, 0, 0, false, 0, null, null, null, 0, 0, 4095, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
