package com.bat.sdk.client.epen;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.client.epen.DeviceControlRequest;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.model.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DeviceControlClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class DeviceControlClient extends CharacteristicClient<DeviceControlRequest, Unit> {
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
    public DeviceControlClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf(BatVocabulary.EPen.Characteristics.deviceControlCharacteristic);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(DeviceControlRequest request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        if (request instanceof DeviceControlRequest.ClearBleQueue) {
            return new byte[]{7};
        }
        if (request instanceof DeviceControlRequest.ClearRecords) {
            return new byte[]{1};
        }
        if (request instanceof DeviceControlRequest.DisableLED) {
            return new byte[]{4};
        }
        if (request instanceof DeviceControlRequest.EnableLED) {
            return new byte[]{3};
        }
        if (request instanceof DeviceControlRequest.InhibitBuffer) {
            return new byte[]{5};
        }
        if (request instanceof DeviceControlRequest.Sleep) {
            return new byte[]{2};
        }
        if (request instanceof DeviceControlRequest.SoftReset) {
            return new byte[]{0};
        }
        if (request instanceof DeviceControlRequest.StartRecords) {
            return new byte[]{9, (byte) RangesKt.coerceIn(((DeviceControlRequest.StartRecords) request).getNumber(), 0, 255), 0};
        }
        if (request instanceof DeviceControlRequest.StopRecords) {
            return new byte[]{10};
        }
        if (!(request instanceof DeviceControlRequest.UnInhibitBuffer)) {
            throw new NoWhenBranchMatchedException();
        }
        return new byte[]{6};
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
