package com.bat.sdk.sync;

import com.bat.sdk.BatSdk;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.client.RawClient;
import com.bat.sdk.client.epen.DeviceControlClient;
import com.bat.sdk.client.epen.DeviceControlRequest;
import com.bat.sdk.client.epen.RxClient;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.epen.RxRequest;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: EpenPuffReader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/sync/EpenPuffReader;", "", "deviceControlClient", "Lcom/bat/sdk/client/epen/DeviceControlClient;", "rxClient", "Lcom/bat/sdk/client/epen/RxClient;", "<init>", "(Lcom/bat/sdk/client/epen/DeviceControlClient;Lcom/bat/sdk/client/epen/RxClient;)V", "txClient", "Lcom/bat/sdk/client/RawClient;", "totalBytes", "Ljava/io/ByteArrayOutputStream;", "getTotalBytes", "()Ljava/io/ByteArrayOutputStream;", "readingInProgressStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getReadingInProgressStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "read", "", "deviceAddress", "", "filename", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class EpenPuffReader {
    private final DeviceControlClient deviceControlClient;
    private final MutableStateFlow<Boolean> readingInProgressStateFlow;
    private final RxClient rxClient;
    private final ByteArrayOutputStream totalBytes;
    private final RawClient txClient;

    public EpenPuffReader(DeviceControlClient deviceControlClient, RxClient rxClient) {
        Intrinsics.checkNotNullParameter(deviceControlClient, "deviceControlClient");
        Intrinsics.checkNotNullParameter(rxClient, "rxClient");
        this.deviceControlClient = deviceControlClient;
        this.rxClient = rxClient;
        this.txClient = BatSdk.INSTANCE.createRawClientFor(BatVocabulary.EPen.Characteristics.txCharacteristic);
        this.totalBytes = new ByteArrayOutputStream();
        this.readingInProgressStateFlow = StateFlowKt.MutableStateFlow(false);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15801(null), 3, null);
    }

    public final ByteArrayOutputStream getTotalBytes() {
        return this.totalBytes;
    }

    public final MutableStateFlow<Boolean> getReadingInProgressStateFlow() {
        return this.readingInProgressStateFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffReader$1 */
    /* JADX INFO: compiled from: EpenPuffReader.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffReader$1", m5608f = "EpenPuffReader.kt", m5609i = {}, m5610l = {32}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15801(Continuation<? super C15801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EpenPuffReader.this.new C15801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<CharacteristicClient<byte[], byte[]>.Response> flow = EpenPuffReader.this.txClient.getFlow();
                final EpenPuffReader epenPuffReader = EpenPuffReader.this;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.sync.EpenPuffReader.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CharacteristicClient<byte[], byte[]>.Response) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CharacteristicClient<byte[], byte[]>.Response response, Continuation<? super Unit> continuation) {
                        String str = new String(response.getData(), Charsets.UTF_8);
                        Logger.INSTANCE.log("chunk received: ".concat(str));
                        epenPuffReader.getTotalBytes().write(response.getData());
                        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "EOF", false, 2, (Object) null)) {
                            Logger.INSTANCE.log("EOF received, record is read");
                            epenPuffReader.getReadingInProgressStateFlow().setValue(Boxing.boxBoolean(false));
                            epenPuffReader.txClient.setNotificationEnabled(response.getDeviceAddress(), false);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    public final void read(String deviceAddress, String filename) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Logger.INSTANCE.log("reader: reading " + filename);
        if (this.readingInProgressStateFlow.getValue().booleanValue()) {
            Logger.INSTANCE.log("a record is being read already");
            return;
        }
        this.readingInProgressStateFlow.setValue(true);
        this.totalBytes.reset();
        this.txClient.setNotificationEnabled(deviceAddress, true);
        this.deviceControlClient.write(deviceAddress, DeviceControlRequest.UnInhibitBuffer.INSTANCE);
        this.rxClient.write(deviceAddress, new RxRequest.ReadFile(filename));
        this.deviceControlClient.write(deviceAddress, DeviceControlRequest.InhibitBuffer.INSTANCE);
    }
}
