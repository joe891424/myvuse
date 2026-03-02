package com.bat.sdk.client;

import com.bat.sdk.DateExtensionKt;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.LiquidInformation;
import com.bat.sdk.model.PodUid;
import com.bat.sdk.model.PuffRecord;
import com.bat.sdk.model.PuffRequest;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PuffsClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00162\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/client/PuffsClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PuffRequest;", "Lcom/bat/sdk/model/PuffRecord;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "NON_AUTH_POD", "", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "decodePuffRecordData", "characteristicUuids", "", "getCharacteristicUuids", "()Ljava/util/List;", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PuffsClient extends CharacteristicClient<PuffRequest, PuffRecord> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Pair<DeviceType, Integer>, Integer> puffRecordVersions = MapsKt.mapOf(TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.EPod3.INSTANCE, 0), 10), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.EPod2.INSTANCE, 0), 10), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.AquilaNS.INSTANCE, 0), 10), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.SmartBox.INSTANCE, 1), 29), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.SmartBoxUS.INSTANCE, 2), 26));
    private final String NON_AUTH_POD;
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PuffsClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.NON_AUTH_POD = "FFFFFFFFFF";
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.puffsCharacteristic, BatVocabulary.EPod2.Characteristics.puffsCharacteristic, BatVocabulary.EPod3.Characteristics.puffsCharacteristic, BatVocabulary.VPro.Characteristics.puffsCharacteristic, BatVocabulary.SmartBox.Characteristics.puffsCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.puffsCharacteristic, BatVocabulary.AquilaNS.Characteristics.puffsCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(PuffRequest request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return request.getBytes();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public PuffRecord decode(byte[] bytes, DeviceType deviceType) {
        Integer num;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        long longBigEndian$default = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null);
        if (longBigEndian$default == 4294967294L) {
            long longBigEndian$default2 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, bytes.length), 0, 1, null);
            Logger.INSTANCE.log("[Puff] Start of File");
            return new PuffRecord.StartOfFile((int) longBigEndian$default2);
        }
        if (longBigEndian$default == 4294967293L) {
            Logger.INSTANCE.log("[Puff] End of File");
            return PuffRecord.EndOfFile.INSTANCE;
        }
        Logger.INSTANCE.log("[Puff] Puff Data, bytearray size: " + bytes.length);
        if (bytes.length == 10 || bytes.length == 26 || bytes.length == 29) {
            return decodePuffRecordData(bytes);
        }
        if ((bytes.length == 0) || (num = puffRecordVersions.get(TuplesKt.m5605to(deviceType, Integer.valueOf(bytes[0])))) == null) {
            return null;
        }
        return new PuffRecord.DataList(CollectionsKt.chunked(ArraysKt.toList(ArraysKt.copyOfRange(bytes, 1, bytes.length)), num.intValue(), new Function1() { // from class: com.bat.sdk.client.PuffsClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PuffsClient.decode$lambda$0(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PuffRecord decode$lambda$0(PuffsClient this$0, List it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return this$0.decodePuffRecordData(CollectionsKt.toByteArray(it2));
    }

    private final PuffRecord decodePuffRecordData(byte[] bytes) {
        PuffRecord.Data data = null;
        long longBigEndian$default = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null);
        int length = bytes.length;
        if (length == 10) {
            int i = (int) longBigEndian$default;
            Date dateAdjusted = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, 8), 0, 1, null) * ((long) 1000)));
            Duration durationOfMillis = Duration.ofMillis(bytes[8] * 100);
            byte b = bytes[bytes.length - 1];
            if (dateAdjusted != null) {
                Intrinsics.checkNotNull(durationOfMillis);
                data = new PuffRecord.Data(i, dateAdjusted, durationOfMillis, b, bytes, null, null, null, null, null, null, null, 4064, null);
            }
            return data;
        }
        if (length == 26) {
            int i2 = (int) longBigEndian$default;
            byte b2 = bytes[4];
            Date dateAdjusted2 = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 5, 9), 0, 1, null) * ((long) 1000)));
            Duration durationOfMillis2 = Duration.ofMillis(bytes[9] * 100);
            byte b3 = bytes[bytes.length - 1];
            if (dateAdjusted2 == null) {
                return null;
            }
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 11, 16);
            byte b4 = bytes[10];
            byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bytes, 16, 21);
            if (!Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange), this.NON_AUTH_POD) && b4 != -1 && !Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange2), this.NON_AUTH_POD)) {
                long longBigEndian$default2 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 20, 24), 0, 1, null);
                byte b5 = bytes[24];
                Intrinsics.checkNotNull(durationOfMillis2);
                PuffRecord.Data data2 = new PuffRecord.Data(i2, dateAdjusted2, durationOfMillis2, b3, bytes, new PodUid(bArrCopyOfRange), new LiquidInformation(bArrCopyOfRange2), Integer.valueOf(b5), null, Integer.valueOf(b2), Integer.valueOf(b4), String.valueOf(longBigEndian$default2));
                Logger.INSTANCE.log("[Puff] PuffRecord - " + data2);
                return data2;
            }
            Intrinsics.checkNotNull(durationOfMillis2);
            return new PuffRecord.Data(i2, dateAdjusted2, durationOfMillis2, b3, bytes, null, null, null, null, null, null, null, 4064, null);
        }
        if (length != 29) {
            return null;
        }
        int i3 = (int) longBigEndian$default;
        byte b6 = bytes[4];
        Date dateAdjusted3 = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 5, 9), 0, 1, null) * ((long) 1000)));
        Duration durationOfMillis3 = Duration.ofMillis(bytes[9] * 100);
        byte b7 = bytes[bytes.length - 1];
        if (dateAdjusted3 == null) {
            return null;
        }
        byte[] bArrCopyOfRange3 = ArraysKt.copyOfRange(bytes, 11, 16);
        byte b8 = bytes[10];
        byte[] bArrCopyOfRange4 = ArraysKt.copyOfRange(bytes, 16, 21);
        if (!Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange3), this.NON_AUTH_POD) && b8 != -1 && !Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange4), this.NON_AUTH_POD)) {
            long longBigEndian$default3 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 21, 25), 0, 1, null);
            byte b9 = bytes[25];
            int longBigEndian$default4 = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 26, 28), 0, 1, null);
            Intrinsics.checkNotNull(durationOfMillis3);
            PuffRecord.Data data3 = new PuffRecord.Data(i3, dateAdjusted3, durationOfMillis3, b7, bytes, new PodUid(bArrCopyOfRange3), new LiquidInformation(bArrCopyOfRange4), Integer.valueOf(b9), Integer.valueOf(longBigEndian$default4), Integer.valueOf(b6), Integer.valueOf(b8), String.valueOf(longBigEndian$default3));
            Logger.INSTANCE.log("[Puff] PuffRecord - " + data3);
            return data3;
        }
        Intrinsics.checkNotNull(durationOfMillis3);
        return new PuffRecord.Data(i3, dateAdjusted3, durationOfMillis3, b7, bytes, null, null, null, null, null, null, null, 4064, null);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }

    /* JADX INFO: compiled from: PuffsClient.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/client/PuffsClient$Companion;", "", "<init>", "()V", "puffRecordVersions", "", "Lkotlin/Pair;", "Lcom/bat/sdk/model/DeviceType;", "", "getPuffRecordVersions", "()Ljava/util/Map;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Pair<DeviceType, Integer>, Integer> getPuffRecordVersions() {
            return PuffsClient.puffRecordVersions;
        }
    }
}
