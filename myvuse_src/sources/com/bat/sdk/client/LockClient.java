package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.Lock;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.facebook.common.callercontext.ContextChain;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LockClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/client/LockClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Lock;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "isProximityUnlockSupported", "", "deviceAddress", "", "lockData", "(Ljava/lang/String;Lcom/bat/sdk/model/Lock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "characteristicUuids", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class LockClient extends CharacteristicClient<Lock, Lock> {
    private final List<String> characteristicUuids;

    /* JADX INFO: renamed from: com.bat.sdk.client.LockClient$isProximityUnlockSupported$1 */
    /* JADX INFO: compiled from: LockClient.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.LockClient", m5608f = "LockClient.kt", m5609i = {0, 0, 0, 1, 1, 1}, m5610l = {121, 131}, m5611m = "isProximityUnlockSupported", m5612n = {"this", "deviceAddress", "lockData", "this", "deviceAddress", ContextChain.TAG_INFRA}, m5613s = {"L$0", "L$1", "L$2", "L$0", "L$1", "I$0"})
    static final class C15071 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15071(Continuation<? super C15071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LockClient.this.isProximityUnlockSupported(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.lockCharacteristic, BatVocabulary.EPod2.Characteristics.lockCharacteristic, BatVocabulary.EPod3.Characteristics.lockCharacteristic, BatVocabulary.VPro.Characteristics.lockCharacteristic, BatVocabulary.Alto2.Characteristics.lockCharacteristic, BatVocabulary.Aquila.Characteristics.lockCharacteristic, BatVocabulary.SmartBox.Characteristics.lockCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.lockCharacteristic, BatVocabulary.AquilaNS.Characteristics.lockCharacteristic});
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Lock request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        byte locked = request.getLocked();
        if (Intrinsics.areEqual(deviceType, DeviceType.SmartBoxUS.INSTANCE)) {
            Logger.INSTANCE.log("LOCK ENCODE REQUEST: SmartBoxUS: " + request);
            Boolean autoLockEnabled = request.getAutoLockEnabled();
            Intrinsics.checkNotNull(autoLockEnabled);
            byte bBooleanValue = autoLockEnabled.booleanValue();
            Long bleTimeout = request.getBleTimeout();
            Intrinsics.checkNotNull(bleTimeout);
            return ArraysKt.plus(new byte[]{bBooleanValue, locked}, ConversionExtensionsKt.toByteArrayBigEndian(bleTimeout.longValue(), 2));
        }
        if (request.getBleTimeout() != null) {
            byte[] byteArrayBigEndian = ConversionExtensionsKt.toByteArrayBigEndian(request.getBleTimeout().longValue(), 2);
            if (request.getAutoLockEnabled() != null) {
                byte lockMode = (byte) request.getLockMode();
                byte bBooleanValue2 = request.getAutoLockEnabled().booleanValue();
                Logger.INSTANCE.log("LOCK ENCODE REQUEST: LOCK = " + ((int) locked) + ", MODE =  " + ((int) lockMode) + ", AUTO-LOCK =  " + ((int) bBooleanValue2) + ", TIMEOUT = " + byteArrayBigEndian);
                return ArraysKt.plus(new byte[]{locked, lockMode, bBooleanValue2}, byteArrayBigEndian);
            }
            if (request.getLockedValue() == null) {
                byte lockMode2 = (byte) request.getLockMode();
                Logger.INSTANCE.log("LOCK ENCODE REQUEST: LOCK = " + ((int) locked) + ", MODE =  " + ((int) lockMode2) + ", TIMEOUT = " + byteArrayBigEndian);
                return ArraysKt.plus(new byte[]{locked, lockMode2}, byteArrayBigEndian);
            }
            Logger.INSTANCE.log("LOCK ENCODE REQUEST: LOCK = " + ((int) locked) + ", TIMEOUT = " + byteArrayBigEndian);
            return ArraysKt.plus(new byte[]{locked}, byteArrayBigEndian);
        }
        if (request.getOutOfRange() != null) {
            return new byte[]{locked, request.getOutOfRange().booleanValue()};
        }
        return new byte[]{locked};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public Lock decode(byte[] bytes, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[LockClient] byteArray size: " + bytes.length);
        if (Intrinsics.areEqual(deviceType, DeviceType.SmartBoxUS.INSTANCE)) {
            boolean z = bytes[0] != 0;
            byte b = bytes[1];
            return new Lock(b != 0, 0, Long.valueOf(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 2, 4), 0, 1, null)), null, Boolean.valueOf(z), Integer.valueOf(b), 10, null);
        }
        int length = bytes.length;
        if (length == 2) {
            boolean z2 = bytes[0] != 0;
            boolean z3 = bytes[1] != 0;
            Logger.INSTANCE.log("LOCK DECODE REQUEST: LOCK = " + z2 + ", OUT OF RANGE = " + z3);
            return new Lock(z2, 0, null, Boolean.valueOf(z3), null, null, 54, null);
        }
        if (length == 3) {
            boolean z4 = bytes[0] != 0;
            long longBigEndian$default = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 1, 3), 0, 1, null);
            Logger.INSTANCE.log("LOCK DECODE REQUEST: LOCK = " + z4 + ", LOCK VALUE = " + ((int) bytes[0]) + " BLE TIMEOUT = " + longBigEndian$default);
            return new Lock(z4, 0, Long.valueOf(longBigEndian$default), null, null, Integer.valueOf(bytes[0]), 26, null);
        }
        if (length == 4) {
            boolean z5 = bytes[0] != 0;
            byte b2 = bytes[1];
            long longBigEndian$default2 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 2, 4), 0, 1, null);
            Logger.INSTANCE.log("LOCK DECODE REQUEST: LOCK = " + z5 + ", MODE =  " + ((int) b2) + ", TIMEOUT = " + ((int) ((byte) longBigEndian$default2)));
            return new Lock(z5, b2, Long.valueOf(longBigEndian$default2), null, null, null, 56, null);
        }
        if (length == 5) {
            boolean z6 = bytes[0] != 0;
            byte b3 = bytes[1];
            boolean z7 = bytes[2] != 0;
            long longBigEndian$default3 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 3, 5), 0, 1, null);
            Logger.INSTANCE.log("LOCK DECODE REQUEST: LOCK = " + z6 + ", MODE =  " + ((int) b3) + ", AUTOLOCK =  " + z7 + ", TIMEOUT = " + longBigEndian$default3);
            return new Lock(z6, b3, Long.valueOf(longBigEndian$default3), null, Boolean.valueOf(z7), null, 40, null);
        }
        boolean z8 = bytes[0] != 0;
        Logger.INSTANCE.log("LOCK DECODE REQUEST: LOCK = " + z8);
        return new Lock(z8, 0, null, null, null, Integer.valueOf(bytes[0]), 30, null);
    }

    public static /* synthetic */ Object isProximityUnlockSupported$default(LockClient lockClient, String str, Lock lock, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            lock = null;
        }
        return lockClient.isProximityUnlockSupported(str, lock, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0117 -> B:49:0x011a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x011d -> B:51:0x011e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isProximityUnlockSupported(java.lang.String r17, com.bat.sdk.model.Lock r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.client.LockClient.isProximityUnlockSupported(java.lang.String, com.bat.sdk.model.Lock, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
