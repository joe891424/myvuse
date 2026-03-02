package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.model.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/client/RawClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "characteristicUuids", "", "", "<init>", "(Lcom/bat/sdk/ble/GattManager;Ljava/util/List;)V", "getCharacteristicUuids", "()Ljava/util/List;", "encode", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class RawClient extends CharacteristicClient<byte[], byte[]> {
    private final List<String> characteristicUuids;

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return bytes;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(byte[] request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return request;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawClient(GattManager gattManager, List<String> characteristicUuids) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        Intrinsics.checkNotNullParameter(characteristicUuids, "characteristicUuids");
        this.characteristicUuids = characteristicUuids;
    }
}
