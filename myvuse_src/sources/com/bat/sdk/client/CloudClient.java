package com.bat.sdk.client;

import com.bat.sdk.ble.GattManager;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.Cloud;
import com.bat.sdk.model.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.internal.p103ws.WebSocketProtocol;

/* JADX INFO: compiled from: CloudClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/client/CloudClient;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Cloud;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "_batterySaverAvailable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "batterySaverAvailable", "Lkotlinx/coroutines/flow/Flow;", "getBatterySaverAvailable", "()Lkotlinx/coroutines/flow/Flow;", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "decode", "bytes", "isBatterySaverAvailable", "", "address", "", "characteristicUuids", "", "getCharacteristicUuids", "()Ljava/util/List;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class CloudClient extends CharacteristicClient<Cloud, Cloud> {
    private final MutableSharedFlow<Boolean> _batterySaverAvailable;
    private final Flow<Boolean> batterySaverAvailable;
    private final List<String> characteristicUuids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudClient(GattManager gattManager) {
        super(gattManager);
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        MutableSharedFlow<Boolean> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        this._batterySaverAvailable = mutableSharedFlowMutableSharedFlow$default;
        this.batterySaverAvailable = mutableSharedFlowMutableSharedFlow$default;
        this.characteristicUuids = CollectionsKt.listOf((Object[]) new String[]{BatVocabulary.EPod.Characteristics.cloudCharacteristic, BatVocabulary.EPod2.Characteristics.cloudCharacteristic, BatVocabulary.EPod3.Characteristics.cloudCharacteristic, BatVocabulary.VPro.Characteristics.cloudCharacteristic, BatVocabulary.SmartBox.Characteristics.cloudCharacteristic, BatVocabulary.SmartBoxUS.Characteristics.cloudCharacteristic, BatVocabulary.AquilaNS.Characteristics.cloudCharacteristic});
    }

    public final Flow<Boolean> getBatterySaverAvailable() {
        return this.batterySaverAvailable;
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    public byte[] encode(Cloud request, DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        if (request.getBatterySavingEnabled() != null && request.getBatterySavingThresholdValue() != null && request.getBatterySavingPowerLevel() != null && request.getBatterySavingOn() != null) {
            return new byte[]{(byte) request.getLevel(), (byte) request.getBatterySavingEnabled().intValue(), (byte) request.getBatterySavingThresholdValue().intValue(), (byte) request.getBatterySavingPowerLevel().intValue(), (byte) request.getBatterySavingOn().intValue()};
        }
        if (request.getHeatingPowerMode() != null && request.getCurrentLevel() != null) {
            return new byte[]{(byte) request.getHeatingPowerMode().intValue(), (byte) request.getLevel(), (byte) request.getCurrentLevel().intValue()};
        }
        if (request.getCurrentLevel() != null) {
            return new byte[]{(byte) request.getLevel(), (byte) request.getCurrentLevel().intValue()};
        }
        return new byte[]{(byte) request.getLevel()};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bat.sdk.client.CharacteristicClient
    public Cloud decode(byte[] bytes, DeviceType deviceType) {
        Cloud cloud;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Logger.INSTANCE.log("[CloudControl] bytes received: " + bytes.length);
        int length = bytes.length;
        if (length == 1) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15021(null), 3, null);
            return new Cloud(bytes[0], null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        if (length == 2) {
            return new Cloud(bytes[0], null, null, null, null, null, Integer.valueOf(bytes[1]), 62, null);
        }
        if (length == 3) {
            return new Cloud(bytes[1], null, null, null, null, Integer.valueOf(bytes[0]), Integer.valueOf(bytes[2]), 30, null);
        }
        if (length == 5) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15032(null), 3, null);
            byte b = bytes[0];
            byte b2 = bytes[1];
            byte b3 = bytes[2];
            byte b4 = bytes[3];
            byte b5 = bytes[4];
            if (b5 == 1) {
                cloud = new Cloud(b4, Integer.valueOf(b2), Integer.valueOf(b3), Integer.valueOf(b4), Integer.valueOf(b5), null, null, 96, null);
            } else {
                cloud = new Cloud(b, Integer.valueOf(b2), Integer.valueOf(b3), Integer.valueOf(b4), Integer.valueOf(b5), null, null, 96, null);
            }
            return cloud;
        }
        return new Cloud(0, null, null, null, null, null, null, 127, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.client.CloudClient$decode$1 */
    /* JADX INFO: compiled from: CloudClient.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.CloudClient$decode$1", m5608f = "CloudClient.kt", m5609i = {}, m5610l = {65}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15021(Continuation<? super C15021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudClient.this.new C15021(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudClient.this._batterySaverAvailable.emit(Boxing.boxBoolean(false), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.client.CloudClient$decode$2 */
    /* JADX INFO: compiled from: CloudClient.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.client.CloudClient$decode$2", m5608f = "CloudClient.kt", m5609i = {}, m5610l = {72}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15032(Continuation<? super C15032> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CloudClient.this.new C15032(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CloudClient.this._batterySaverAvailable.emit(Boxing.boxBoolean(true), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void isBatterySaverAvailable(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        enqueueRead(address);
    }

    @Override // com.bat.sdk.client.CharacteristicClient
    protected List<String> getCharacteristicUuids() {
        return this.characteristicUuids;
    }
}
