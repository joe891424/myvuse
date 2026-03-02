package com.bat.sdk.client;

import com.bat.sdk.DateExtensionKt;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.LogRecord;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogsClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/client/LogsClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/LogRecord;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "(Lkotlin/Unit;Lcom/bat/sdk/model/DeviceType;)[B", "decode", "bytes", "decodeLogRecordData", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class LogsClient extends CharacteristicClient<Unit, LogRecord> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Pair<DeviceType, Integer>, Integer> logRecordVersions = MapsKt.mapOf(TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.EPod3.INSTANCE, 0), 21), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.EPod2.INSTANCE, 0), 21), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.AquilaNS.INSTANCE, 0), 21), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.SmartBox.INSTANCE, 1), 29), TuplesKt.m5605to(TuplesKt.m5605to(DeviceType.SmartBoxUS.INSTANCE, 2), 29));
    private final List<String> characteristicUuids;

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Unit request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new byte[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogsClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.logCharacteristic, BatVocabulary.EPod2.Characteristics.logCharacteristic, BatVocabulary.EPod3.Characteristics.logCharacteristic, BatVocabulary.VPro.Characteristics.logCharacteristic, BatVocabulary.Alto2.Characteristics.logCharacteristic, BatVocabulary.Aquila.Characteristics.logCharacteristic, BatVocabulary.SmartBox.Characteristics.logCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.logCharacteristic, BatVocabulary.AquilaNS.Characteristics.logCharacteristic});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public LogRecord decode(byte[] bytes, DeviceType deviceType) {
        Integer num;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        long longBigEndian$default = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null);
        if (longBigEndian$default == 4294967294L) {
            long longBigEndian$default2 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, bytes.length), 0, 1, null);
            Logger.INSTANCE.log("[Log] Start of File");
            return new LogRecord.StartOfFile((int) longBigEndian$default2);
        }
        if (longBigEndian$default == 4294967293L) {
            Logger.INSTANCE.log("[Log] End of File");
            return LogRecord.EndOfFile.INSTANCE;
        }
        Logger.INSTANCE.log("[Log] Log Data, bytearray size: " + bytes.length);
        if (bytes.length == 21 || bytes.length == 29) {
            return decodeLogRecordData(bytes);
        }
        if ((bytes.length == 0) || (num = logRecordVersions.get(TuplesKt.m5605to(deviceType, Integer.valueOf(bytes[0])))) == null) {
            return null;
        }
        return new LogRecord.DataList(CollectionsKt.chunked(ArraysKt.toList(ArraysKt.copyOfRange(bytes, 1, bytes.length)), num.intValue(), new Function1() { // from class: com.bat.sdk.client.LogsClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LogsClient.decode$lambda$0(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LogRecord decode$lambda$0(LogsClient this$0, List it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return this$0.decodeLogRecordData(CollectionsKt.toByteArray(it2));
    }

    private final LogRecord decodeLogRecordData(byte[] bytes) {
        int longBigEndian$default = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 0, 4), 0, 1, null);
        if (bytes.length == 21) {
            Date dateAdjusted = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 4, 8), 0, 1, null) * ((long) 1000)));
            byte b = bytes[8];
            byte b2 = bytes[9];
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 10, bytes.length);
            if (bArrCopyOfRange.length != 11) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return dateAdjusted != null ? new LogRecord.Data(longBigEndian$default, dateAdjusted, b, b2, bArrCopyOfRange, bytes, null, 64, null) : null;
        }
        byte b3 = bytes[4];
        Date dateAdjusted2 = DateExtensionKt.adjusted(new Date(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 5, 9), 0, 1, null) * ((long) 1000)));
        return dateAdjusted2 != null ? new LogRecord.Data(longBigEndian$default, dateAdjusted2, bytes[9], bytes[10], ArraysKt.copyOfRange(bytes, 11, bytes.length), bytes, Integer.valueOf(b3)) : null;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }

    /* JADX INFO: compiled from: LogsClient.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/client/LogsClient$Companion;", "", "<init>", "()V", "logRecordVersions", "", "Lkotlin/Pair;", "Lcom/bat/sdk/model/DeviceType;", "", "getLogRecordVersions", "()Ljava/util/Map;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Pair<DeviceType, Integer>, Integer> getLogRecordVersions() {
            return LogsClient.logRecordVersions;
        }
    }
}
