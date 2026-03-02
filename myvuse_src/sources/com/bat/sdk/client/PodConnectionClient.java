package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.LiquidInformation;
import com.bat.sdk.model.PodConnection;
import com.bat.sdk.model.PodTypeDetails;
import com.bat.sdk.model.PodUid;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.facebook.common.callercontext.ContextChain;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PodConnectionClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5598d2 = {"Lcom/bat/sdk/client/PodConnectionClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/PodConnection;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "NON_AUTH_POD", "", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "(Lkotlin/Unit;Lcom/bat/sdk/model/DeviceType;)[B", "decode", "bytes", "isUltraPod", "", "deviceAddress", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "characteristicUuids", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PodConnectionClient extends CharacteristicClient<Unit, PodConnection> {
    private final String NON_AUTH_POD;
    private final List<String> characteristicUuids;

    /* JADX INFO: renamed from: com.bat.sdk.client.PodConnectionClient$isUltraPod$1 */
    /* JADX INFO: compiled from: PodConnectionClient.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.PodConnectionClient", m5608f = "PodConnectionClient.kt", m5609i = {0, 0, 1, 1, 1}, m5610l = {ISO7816Kt.SW1_WARNING_CHANGED, 106}, m5611m = "isUltraPod", m5612n = {"this", "deviceAddress", "this", "deviceAddress", ContextChain.TAG_INFRA}, m5613s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    static final class C15081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15081(Continuation<? super C15081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PodConnectionClient.this.isUltraPod(null, this);
        }
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Unit request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new byte[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PodConnectionClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.NON_AUTH_POD = "FFFFFFFFFF";
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod3.Characteristics.podCharacteristic, BatVocabulary.SmartBox.Characteristics.podCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.podCharacteristic});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public PodConnection decode(byte[] bytes, DeviceType deviceType) {
        PodConnection podConnection;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        boolean z = bytes[0] != 0;
        Logger.INSTANCE.log("[PodInformation] byte array size: " + bytes.length + " connected " + z);
        if (bytes.length == 1 || !z) {
            return new PodConnection(z, null, null, null, null, null, null, null, false, null, 1022, null);
        }
        int length = bytes.length;
        if (length == 19) {
            boolean z2 = bytes[0] == 2;
            byte b = bytes[1];
            byte b2 = bytes[2];
            PodTypeDetails podTypeDetails = new PodTypeDetails(ArraysKt.copyOfRange(bytes, 3, 5));
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 5, 10);
            byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bytes, 10, 14);
            long longBigEndian$default = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 14, 18), 0, 1, null);
            byte b3 = bytes[18];
            if (!Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange), this.NON_AUTH_POD) && b2 != -1 && !Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange2), this.NON_AUTH_POD)) {
                podConnection = new PodConnection(true, Integer.valueOf(b), Integer.valueOf(b2), new PodUid(bArrCopyOfRange), new LiquidInformation(bArrCopyOfRange2), String.valueOf(longBigEndian$default), Integer.valueOf(b3), null, z2, podTypeDetails, 128, null);
            } else {
                return new PodConnection(true, Integer.valueOf(b), null, null, null, null, null, null, z2, null, 764, null);
            }
        } else if (length == 22) {
            boolean z3 = bytes[0] == 2;
            byte b4 = bytes[1];
            byte b5 = bytes[2];
            PodTypeDetails podTypeDetails2 = new PodTypeDetails(ArraysKt.copyOfRange(bytes, 3, 5));
            byte[] bArrCopyOfRange3 = ArraysKt.copyOfRange(bytes, 5, 10);
            byte[] bArrCopyOfRange4 = ArraysKt.copyOfRange(bytes, 10, 15);
            long longBigEndian$default2 = ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 15, 19), 0, 1, null);
            byte b6 = bytes[19];
            int longBigEndian$default3 = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(bytes, 20, 22), 0, 1, null);
            if (!Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange3), this.NON_AUTH_POD) && b5 != -1 && !Intrinsics.areEqual(ConversionExtensionsKt.toHex(bArrCopyOfRange4), this.NON_AUTH_POD)) {
                podConnection = new PodConnection(true, Integer.valueOf(b4), Integer.valueOf(b5), new PodUid(bArrCopyOfRange3), new LiquidInformation(bArrCopyOfRange4), String.valueOf(longBigEndian$default2), Integer.valueOf(b6), Integer.valueOf(longBigEndian$default3), z3, podTypeDetails2);
            } else {
                return new PodConnection(true, Integer.valueOf(b4), null, null, null, null, null, null, z3, null, 764, null);
            }
        } else {
            return new PodConnection(false, null, null, null, null, null, null, null, false, null, 1023, null);
        }
        return podConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b6 -> B:32:0x00b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00bc -> B:34:0x00bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isUltraPod(java.lang.String r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.client.PodConnectionClient.isUltraPod(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
