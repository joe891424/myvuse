package com.bat.sdk.client;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceInfo;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.facebook.common.callercontext.ContextChain;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceInfoClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0003R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, m5598d2 = {"Lcom/bat/sdk/client/DeviceInfoClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/DeviceInfo;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "getDeviceMSSPayload", "Lcom/bat/sdk/model/MssVersion;", "deviceAddress", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAdvName", "Lcom/bat/sdk/model/AdvertisingName;", "advertisingName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "advertisingNameRemoveZeros", "advName", "checkASCII", "", TypedValues.Custom.S_STRING, "isAdvertisingNameAvailable", "deviceInfo", "characteristicUuids", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class DeviceInfoClient extends CharacteristicClient<String, DeviceInfo> {
    private final List<String> characteristicUuids;

    /* JADX INFO: renamed from: com.bat.sdk.client.DeviceInfoClient$getDeviceMSSPayload$1 */
    /* JADX INFO: compiled from: DeviceInfoClient.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.DeviceInfoClient", m5608f = "DeviceInfoClient.kt", m5609i = {0, 0, 1, 1, 1, 1}, m5610l = {183, 194}, m5611m = "getDeviceMSSPayload", m5612n = {"this", "deviceAddress", "this", "deviceAddress", "mssVersion", ContextChain.TAG_INFRA}, m5613s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"})
    static final class C15041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15041(Continuation<? super C15041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceInfoClient.this.getDeviceMSSPayload(null, this);
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.client.DeviceInfoClient$writeAdvName$1 */
    /* JADX INFO: compiled from: DeviceInfoClient.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.DeviceInfoClient", m5608f = "DeviceInfoClient.kt", m5609i = {0, 0}, m5610l = {239}, m5611m = "writeAdvName", m5612n = {"this", "deviceAddress"}, m5613s = {"L$0", "L$1"})
    static final class C15061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15061(Continuation<? super C15061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceInfoClient.this.writeAdvName(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.deviceInfoCharacteristic, BatVocabulary.EPod2.Characteristics.deviceInfoCharacteristic, BatVocabulary.EPod3.Characteristics.deviceInfoCharacteristic, BatVocabulary.VPro.Characteristics.deviceInfoCharacteristic, BatVocabulary.Alto2.Characteristics.deviceInfoCharacteristic, BatVocabulary.Aquila.Characteristics.deviceInfoCharacteristic, BatVocabulary.SmartBox.Characteristics.deviceInfoCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.deviceInfoCharacteristic, BatVocabulary.AquilaNS.Characteristics.deviceInfoCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(String request, DeviceType deviceType) {
        String strReplace$default;
        byte[] hex;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return (request == null || (strReplace$default = StringsKt.replace$default(request, "0x", "", false, 4, (Object) null)) == null || (hex = ConversionExtensionsKt.parseHex(strReplace$default)) == null) ? new byte[0] : hex;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public DeviceInfo decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[DeviceInfoClientSDK] Byte array size: " + bytes.length);
        int length = bytes.length;
        if (length == 18) {
            String strSubstring = ConversionExtensionsKt.toHex(bytes).substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            if (Intrinsics.areEqual(strSubstring, "0002")) {
                Logger.INSTANCE.log("[DeviceInfoClientSDK] AdvName Decode");
                return new DeviceInfo(0, 0, 0, 0, null, null, ConversionExtensionsKt.toHex(bytes), null, null, null, null, 1983, null);
            }
            Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo Decode without advName");
            byte b = bytes[0];
            byte b2 = bytes[1];
            int shortValue = ConversionExtensionsKt.getShortValue(bytes, 2, ByteOrder.BIG_ENDIAN);
            int shortValue2 = ConversionExtensionsKt.getShortValue(bytes, 4, ByteOrder.BIG_ENDIAN);
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 6, 18);
            return new DeviceInfo(b, b2, shortValue, shortValue2, ConversionExtensionsKt.toHex(bArrCopyOfRange), bArrCopyOfRange, ConversionExtensionsKt.toHex(bytes), null, null, null, null, 1920, null);
        }
        if (length == 20) {
            Logger.INSTANCE.log("[DeviceInfoClientSDK] Payload Decode");
            return new DeviceInfo(0, 0, 0, 0, null, null, ConversionExtensionsKt.toHex(bytes), null, null, null, null, 1983, null);
        }
        if (length == 34) {
            Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo Decode with advName");
            byte b3 = bytes[0];
            byte b4 = bytes[1];
            int shortValue3 = ConversionExtensionsKt.getShortValue(bytes, 2, ByteOrder.BIG_ENDIAN);
            int shortValue4 = ConversionExtensionsKt.getShortValue(bytes, 4, ByteOrder.BIG_ENDIAN);
            byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bytes, 6, 18);
            return new DeviceInfo(b3, b4, shortValue3, shortValue4, ConversionExtensionsKt.toHex(bArrCopyOfRange2), bArrCopyOfRange2, ConversionExtensionsKt.toHex(bytes), advertisingNameRemoveZeros(ArraysKt.copyOfRange(bytes, bytes.length - 16, bytes.length)), null, null, null, 1792, null);
        }
        switch (length) {
            case 38:
                Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo Decode with advName and bootloader");
                byte b5 = bytes[0];
                byte b6 = bytes[1];
                int shortValue5 = ConversionExtensionsKt.getShortValue(bytes, 2, ByteOrder.BIG_ENDIAN);
                int shortValue6 = ConversionExtensionsKt.getShortValue(bytes, 4, ByteOrder.BIG_ENDIAN);
                byte[] bArrCopyOfRange3 = ArraysKt.copyOfRange(bytes, 6, 18);
                String hex = ConversionExtensionsKt.toHex(bArrCopyOfRange3);
                String strAdvertisingNameRemoveZeros = advertisingNameRemoveZeros(ArraysKt.copyOfRange(bytes, 18, 34));
                int longBigEndian$default = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 34, bytes.length), 0, 1, null);
                Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo bootloader version " + longBigEndian$default);
                return new DeviceInfo(b5, b6, shortValue5, shortValue6, hex, bArrCopyOfRange3, ConversionExtensionsKt.toHex(bytes), strAdvertisingNameRemoveZeros, Integer.valueOf(longBigEndian$default), null, null, 1536, null);
            case 39:
                Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo receives 39 bytes");
                byte b7 = bytes[0];
                byte b8 = bytes[1];
                int shortValue7 = ConversionExtensionsKt.getShortValue(bytes, 2, ByteOrder.BIG_ENDIAN);
                byte b9 = bytes[4];
                int shortValue8 = ConversionExtensionsKt.getShortValue(bytes, 5, ByteOrder.BIG_ENDIAN);
                byte[] bArrCopyOfRange4 = ArraysKt.copyOfRange(bytes, 7, 19);
                return new DeviceInfo(b7, b8, shortValue7, shortValue8, ConversionExtensionsKt.toHex(bArrCopyOfRange4), bArrCopyOfRange4, ConversionExtensionsKt.toHex(bytes), advertisingNameRemoveZeros(ArraysKt.copyOfRange(bytes, 19, 35)), Integer.valueOf((int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 35, bytes.length), 0, 1, null)), Integer.valueOf(b9), null, 1024, null);
            case 40:
                Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo receives 40 bytes");
                byte b10 = bytes[0];
                byte b11 = bytes[1];
                int shortValue9 = ConversionExtensionsKt.getShortValue(bytes, 2, ByteOrder.BIG_ENDIAN);
                byte b12 = bytes[4];
                byte b13 = bytes[5];
                int shortValue10 = ConversionExtensionsKt.getShortValue(bytes, 6, ByteOrder.BIG_ENDIAN);
                byte[] bArrCopyOfRange5 = ArraysKt.copyOfRange(bytes, 8, 20);
                String hex2 = ConversionExtensionsKt.toHex(bArrCopyOfRange5);
                String strAdvertisingNameRemoveZeros2 = advertisingNameRemoveZeros(ArraysKt.copyOfRange(bytes, 20, 36));
                int longBigEndian$default2 = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 36, bytes.length), 0, 1, null);
                Logger.INSTANCE.log("[DeviceInfoClientSDK] DeviceInfo bootloader version " + longBigEndian$default2);
                return new DeviceInfo(b10, b11, shortValue9, shortValue10, hex2, bArrCopyOfRange5, ConversionExtensionsKt.toHex(bytes), strAdvertisingNameRemoveZeros2, Integer.valueOf(longBigEndian$default2), Integer.valueOf(b12), Integer.valueOf(b13));
            default:
                return new DeviceInfo(0, 0, 0, 0, null, null, null, null, null, null, null, 2047, null);
        }
    }

    /* JADX WARN: Path cross not found for [B:32:0x00dd, B:35:0x00ea], limit reached: 50 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00cd -> B:30:0x00d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getDeviceMSSPayload(java.lang.String r14, kotlin.coroutines.Continuation<? super com.bat.sdk.model.MssVersion> r15) {
        /*
            Method dump skipped, instruction units count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.client.DeviceInfoClient.getDeviceMSSPayload(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAdvName(java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.bat.sdk.model.AdvertisingName> r14) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.client.DeviceInfoClient.writeAdvName(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String advertisingNameRemoveZeros(byte[] advName) {
        String strRemoveSurrounding = StringsKt.removeSurrounding(ConversionExtensionsKt.toHexString(advName), (CharSequence) "[ ", (CharSequence) " ]");
        return StringsKt.removeSuffix(StringsKt.decodeToString(ConversionExtensionsKt.toByteArray(StringsKt.substringBefore(strRemoveSurrounding, "00", strRemoveSurrounding))), (CharSequence) " ");
    }

    private final boolean checkASCII(String string) {
        int length = string.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (cCharAt == '$') {
                return false;
            }
            z = ' ' <= cCharAt && cCharAt < '~';
        }
        return z;
    }

    public final boolean isAdvertisingNameAvailable(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return !Intrinsics.areEqual(deviceInfo.getAdvertisingName(), "");
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
