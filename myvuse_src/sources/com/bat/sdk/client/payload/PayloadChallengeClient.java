package com.bat.sdk.client.payload;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.PayloadChallengeRequest;
import com.bat.sdk.model.PayloadChallengeResponse;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PayloadChallengeClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/client/payload/PayloadChallengeClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PayloadChallengeRequest;", "Lcom/bat/sdk/model/PayloadChallengeResponse;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PayloadChallengeClient extends CharacteristicClient<PayloadChallengeRequest, PayloadChallengeResponse> {
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayloadChallengeClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod2.Characteristics.payloadChallengeCharacteristic, BatVocabulary.EPod3.Characteristics.payloadChallengeCharacteristic, BatVocabulary.SmartBox.Characteristics.payloadChallengeCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(PayloadChallengeRequest request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "encode, payloadcode:" + ((Object) UShort.m7558toStringimpl(request.m5922getPayloadCodeMh2AYeg())) + ", toByteArrayBigEndian:" + ConversionExtensionsKt.toHex(ConversionExtensionsKt.m5931toByteArrayBigEndianxj2QHRw(request.m5922getPayloadCodeMh2AYeg())));
        return ConversionExtensionsKt.m5931toByteArrayBigEndianxj2QHRw(request.m5922getPayloadCodeMh2AYeg());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public PayloadChallengeResponse decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "decode, bytes:" + ConversionExtensionsKt.toHex(bytes));
        return new PayloadChallengeResponse(ConversionExtensionsKt.toHex(bytes));
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
