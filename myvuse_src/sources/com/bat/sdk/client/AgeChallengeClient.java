package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.AgeChallenge;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AgeChallengeClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/client/AgeChallengeClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/AgeChallenge;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "(Lkotlin/Unit;Lcom/bat/sdk/model/DeviceType;)[B", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AgeChallengeClient extends CharacteristicClient<Unit, AgeChallenge> {
    private final List<String> characteristicUuids;

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Unit request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new byte[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgeChallengeClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod2.Characteristics.ageChallengeCharacteristic, BatVocabulary.EPod3.Characteristics.ageChallengeCharacteristic, BatVocabulary.Alto2.Characteristics.ageChallengeCharacteristic, BatVocabulary.SmartBox.Characteristics.ageChallengeCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.ageChallengeCharacteristic, BatVocabulary.Aquila.Characteristics.ageChallengeCharacteristic, BatVocabulary.AquilaNS.Characteristics.ageChallengeCharacteristic});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public AgeChallenge decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("age challenge bytes: " + ConversionExtensionsKt.toHexString(bytes));
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.slice(bytes, RangesKt.until(0, 12)));
        Logger.INSTANCE.log("device id bytes extracted from age challenge");
        byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.slice(bytes, RangesKt.until(12, 32)));
        Logger.INSTANCE.log("random data bytes extracted from age challenge");
        return new AgeChallenge(byteArray, byteArray2);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
