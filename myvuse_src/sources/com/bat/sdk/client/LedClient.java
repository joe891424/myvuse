package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.Led;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LedClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/client/LedClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Led;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class LedClient extends CharacteristicClient<Led, Led> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LedClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.ledCharacteristic, BatVocabulary.EPod2.Characteristics.ledCharacteristic, BatVocabulary.EPod3.Characteristics.ledCharacteristic, BatVocabulary.VPro.Characteristics.ledCharacteristic, BatVocabulary.Alto2.Characteristics.ledCharacteristic, BatVocabulary.Aquila.Characteristics.ledCharacteristic, BatVocabulary.SmartBox.Characteristics.ledCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.ledCharacteristic, BatVocabulary.AquilaNS.Characteristics.ledCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Led request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        byte brightnessLevel = (byte) request.getBrightnessLevel();
        if (request.getScreenSettingBrightness() != null && request.getPowerSaveModeBrightness() != null) {
            return new byte[]{(byte) request.getScreenSettingBrightness().intValue(), (byte) request.getPowerSaveModeBrightness().intValue(), brightnessLevel};
        }
        return new byte[]{brightnessLevel};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public Led decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        int length = bytes.length;
        if (length == 1) {
            return new Led(bytes[0], null, null, 6, null);
        }
        if (length == 3) {
            byte b = bytes[0];
            return new Led(bytes[2], Integer.valueOf(bytes[1]), Integer.valueOf(b));
        }
        return new Led(0, null, null, 7, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
