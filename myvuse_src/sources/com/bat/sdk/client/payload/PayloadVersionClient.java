package com.bat.sdk.client.payload;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.PayloadVersion;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PayloadVersionClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/client/payload/PayloadVersionClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PayloadVersion;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PayloadVersionClient extends CharacteristicClient<PayloadVersion, Unit> {
    private final List<String> characteristicUuids;

    @Override // com.bat.sdk.client.CharacteristicClient
    public /* bridge */ /* synthetic */ Unit decode(byte[] bArr, DeviceType deviceType) {
        decode2(bArr, deviceType);
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayloadVersionClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod2.Characteristics.versionCharacteristic, BatVocabulary.EPod3.Characteristics.versionCharacteristic, BatVocabulary.SmartBox.Characteristics.versionCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(PayloadVersion request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        byte major = (byte) request.getMajor();
        byte minor = (byte) request.getMinor();
        byte revision = (byte) request.getRevision();
        byte[] bArr = new byte[7];
        char[] charArray = StringsKt.toCharArray(request.getTag(), 0, 7);
        ArrayList arrayList = new ArrayList(charArray.length);
        for (char c : charArray) {
            arrayList.add(Byte.valueOf((byte) c));
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            bArr[i] = ((Number) obj).byteValue();
            i = i2;
        }
        byte[] byteArrayBigEndian = ConversionExtensionsKt.toByteArrayBigEndian(request.getFileLength());
        byte fileObjectId = (byte) request.getFileObjectId();
        byte[] bArr2 = new byte[5];
        char[] charArray2 = StringsKt.toCharArray(request.getFileMd5Sum(), 0, 5);
        ArrayList arrayList2 = new ArrayList(charArray2.length);
        for (char c2 : charArray2) {
            arrayList2.add(Byte.valueOf((byte) c2));
        }
        int i3 = 0;
        for (Object obj2 : arrayList2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            bArr2[i3] = ((Number) obj2).byteValue();
            i3 = i4;
        }
        byte[] bArrPlus = ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(new byte[]{major, minor, revision}, bArr), byteArrayBigEndian), new byte[]{fileObjectId}), bArr2);
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "encode, maj:" + request.getMajor() + ", min:" + request.getMinor() + ", tag:" + request.getTag() + ", rev:" + request.getRevision() + ", fileLen:" + request.getFileLength() + ", fileObjIdByte:" + request.getFileObjectId() + ", md5bytes:" + request.getFileMd5Sum() + ", bytes:" + ConversionExtensionsKt.toHex(bArrPlus));
        return bArrPlus;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "decode, bytes:" + ConversionExtensionsKt.toHex(bytes));
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
