package com.bat.sdk.client.epen;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.epen.RxRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: RxClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/client/epen/RxClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/epen/RxRequest;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class RxClient extends CharacteristicClient<RxRequest, Unit> {
    private final List<String> characteristicUuids;

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public /* bridge */ /* synthetic */ Unit decode(byte[] bArr, DeviceType deviceType) {
        decode2(bArr, deviceType);
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf(BatVocabulary.EPen.Characteristics.rxCharacteristic);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(RxRequest request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        if (request instanceof RxRequest.ListFiles) {
            byte[] bytes = "#QR\n".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        if (request instanceof RxRequest.ReadEverything) {
            byte[] bytes2 = "#SR\n".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            return bytes2;
        }
        if (!(request instanceof RxRequest.ReadFile)) {
            throw new NoWhenBranchMatchedException();
        }
        byte[] bytes3 = ("#SR" + ((RxRequest.ReadFile) request).getFilename() + '\n').getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        return bytes3;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
