package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.PowerSaveMode;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerSaveModeClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/client/PowerSaveModeClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PowerSaveMode;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PowerSaveModeClient extends CharacteristicClient<PowerSaveMode, PowerSaveMode> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerSaveModeClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.SmartBox.Characteristics.powerSaveModeCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.powerSaveModeCharacteristic, BatVocabulary.AquilaNS.Characteristics.powerSaveModeCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(PowerSaveMode request, DeviceType deviceType) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        byte powerSaveModeEnable = request.getPowerSaveModeEnable();
        byte batteryThreshold = (byte) request.getBatteryThreshold();
        if (request.getPowerSaveModeSetting() != null) {
            return new byte[]{(byte) request.getPowerSaveModeSetting().intValue(), powerSaveModeEnable, batteryThreshold};
        }
        if (request.getBatterySavingPowerLevel() == null) {
            byte manualPowerSaveModeEnabled = request.getManualPowerSaveModeEnabled();
            byte autoPowerSaveModeEnabled = request.getAutoPowerSaveModeEnabled();
            Logger.INSTANCE.log("[PowerSaveMode] byte array " + ConversionExtensionsKt.toHexString(new byte[]{manualPowerSaveModeEnabled, autoPowerSaveModeEnabled, powerSaveModeEnable, batteryThreshold}));
            bArr = new byte[]{manualPowerSaveModeEnabled, autoPowerSaveModeEnabled, powerSaveModeEnable, batteryThreshold};
        } else {
            bArr = new byte[]{request.getManualPowerSaveModeEnabled(), batteryThreshold, (byte) request.getBatterySavingPowerLevel().intValue(), powerSaveModeEnable};
        }
        return bArr;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public PowerSaveMode decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[PowerSaveMode] byte array size: " + bytes.length);
        Logger.INSTANCE.log("[PowerSaveMode] byte array " + ConversionExtensionsKt.toHexString(bytes));
        int length = bytes.length;
        if (length == 3) {
            return new PowerSaveMode(false, false, bytes[1] == 1, bytes[2], Integer.valueOf(bytes[0]), null, 32, null);
        }
        if (length == 4) {
            boolean z = bytes[0] == 1;
            byte b = bytes[2];
            if (20 <= b && b < 66) {
                return new PowerSaveMode(z, false, bytes[3] == 1, bytes[1], null, Integer.valueOf(b), 18, null);
            }
            return new PowerSaveMode(z, bytes[1] == 1, b == 1, bytes[3], null, null, 48, null);
        }
        return new PowerSaveMode(false, false, false, 0, null, null, 63, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
