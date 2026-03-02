package com.bat.sdk.client;

import androidx.core.app.FrameMetricsAggregator;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.RechargeReminder;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RechargeRemindersClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/client/RechargeRemindersClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/RechargeReminder;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class RechargeRemindersClient extends CharacteristicClient<RechargeReminder, RechargeReminder> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RechargeRemindersClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod3.Characteristics.rechargeRemindersCharacteristic, BatVocabulary.SmartBox.Characteristics.rechargeRemindersCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.rechargeRemindersCharacteristic, BatVocabulary.AquilaNS.Characteristics.rechargeRemindersCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(RechargeReminder request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        boolean alertDemo = request.getAlertDemo();
        byte[] bArr = {(byte) request.getMinBatteryThr(), (byte) request.getMaxBatteryThr()};
        byte[] bArr2 = {(byte) request.getAlertType(), (byte) request.getAlertTrigger(), (byte) request.getAlertDuration(), alertDemo ? (byte) 1 : (byte) 0};
        if (request.getLedColorMin() != null && request.getLedColorMid() != null && request.getLedColorMax() != null) {
            return ArraysKt.plus(ArraysKt.plus(bArr, new byte[]{(byte) request.getLedColorMin().intValue(), (byte) request.getLedColorMid().intValue(), (byte) request.getLedColorMax().intValue()}), bArr2);
        }
        Logger.INSTANCE.log("[Recharge] writing " + ConversionExtensionsKt.toHexString(ArraysKt.plus(bArr, bArr2)));
        return ArraysKt.plus(bArr, bArr2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public RechargeReminder decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[Recharge] received byte array of size: " + bytes.length);
        Logger.INSTANCE.log("[Recharge] receiving " + ConversionExtensionsKt.toHexString(bytes));
        int length = bytes.length;
        if (length == 6) {
            byte b = bytes[0];
            byte b2 = bytes[1];
            byte b3 = bytes[2];
            byte b4 = bytes[3];
            byte b5 = bytes[4];
            boolean z = bytes[5] == 1;
            Logger.INSTANCE.log("[Recharge] alert type " + ((int) b3) + " alert Trigger " + ((int) b4));
            return new RechargeReminder(b, b2, null, null, null, b3, b4, b5, z);
        }
        if (length == 9) {
            byte b6 = bytes[0];
            byte b7 = bytes[1];
            byte b8 = bytes[2];
            byte b9 = bytes[3];
            byte b10 = bytes[4];
            byte b11 = bytes[5];
            byte b12 = bytes[6];
            byte b13 = bytes[7];
            Logger.INSTANCE.log("[battery] " + ((int) b13) + SafeJsonPrimitive.NULL_CHAR + ((int) bytes[7]));
            return new RechargeReminder(b6, b7, Integer.valueOf(b8), Integer.valueOf(b9), Integer.valueOf(b10), b11, b12, b13, bytes[8] == 1);
        }
        return new RechargeReminder(0, 0, null, null, null, 0, 0, 0, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
