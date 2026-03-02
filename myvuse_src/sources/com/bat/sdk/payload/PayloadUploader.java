package com.bat.sdk.payload;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.client.payload.PayloadChallengeClient;
import com.bat.sdk.client.payload.PayloadClient;
import com.bat.sdk.client.payload.PayloadControlClient;
import com.bat.sdk.client.payload.PayloadVersionClient;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.ControlCommand;
import com.bat.sdk.model.PayloadChallengeRequest;
import com.bat.sdk.model.PayloadChallengeResponse;
import com.bat.sdk.model.PayloadChunk;
import com.bat.sdk.payload.PayloadUploadResult;
import com.bat.sdk.payload.PayloadUploadState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PayloadUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJS\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploader;", "", "versionClient", "Lcom/bat/sdk/client/payload/PayloadVersionClient;", "controlClient", "Lcom/bat/sdk/client/payload/PayloadControlClient;", "challengeClient", "Lcom/bat/sdk/client/payload/PayloadChallengeClient;", "payloadClient", "Lcom/bat/sdk/client/payload/PayloadClient;", "payloadCaller", "Lcom/bat/sdk/payload/PayloadCaller;", "<init>", "(Lcom/bat/sdk/client/payload/PayloadVersionClient;Lcom/bat/sdk/client/payload/PayloadControlClient;Lcom/bat/sdk/client/payload/PayloadChallengeClient;Lcom/bat/sdk/client/payload/PayloadClient;Lcom/bat/sdk/payload/PayloadCaller;)V", "url", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "accessToken", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "uploadStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/payload/PayloadUploadState;", "getUploadStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "upload", "", "deviceAddress", "payloadCode", "Lkotlin/UShort;", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "upload-zvoA_rg", "(Ljava/lang/String;SLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PayloadUploader {
    private String accessToken;
    private final PayloadChallengeClient challengeClient;
    private final PayloadControlClient controlClient;
    private final PayloadCaller payloadCaller;
    private final PayloadClient payloadClient;
    private ScanCallback scanCallback;
    private String tenant;
    private String token;
    private final MutableStateFlow<PayloadUploadState> uploadStateFlow;
    private String url;
    private String userId;
    private final PayloadVersionClient versionClient;

    public PayloadUploader(PayloadVersionClient versionClient, PayloadControlClient controlClient, PayloadChallengeClient challengeClient, PayloadClient payloadClient, PayloadCaller payloadCaller) {
        Intrinsics.checkNotNullParameter(versionClient, "versionClient");
        Intrinsics.checkNotNullParameter(controlClient, "controlClient");
        Intrinsics.checkNotNullParameter(challengeClient, "challengeClient");
        Intrinsics.checkNotNullParameter(payloadClient, "payloadClient");
        Intrinsics.checkNotNullParameter(payloadCaller, "payloadCaller");
        this.versionClient = versionClient;
        this.controlClient = controlClient;
        this.challengeClient = challengeClient;
        this.payloadClient = payloadClient;
        this.payloadCaller = payloadCaller;
        this.url = "";
        this.userId = "";
        this.token = "";
        this.tenant = "";
        this.uploadStateFlow = StateFlowKt.MutableStateFlow(new PayloadUploadState.Idle("", null, 2, null));
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15141(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15152(null), 3, null);
    }

    public final MutableStateFlow<PayloadUploadState> getUploadStateFlow() {
        return this.uploadStateFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.payload.PayloadUploader$1 */
    /* JADX INFO: compiled from: PayloadUploader.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$1", m5608f = "PayloadUploader.kt", m5609i = {}, m5610l = {42}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C15141(Continuation<? super C15141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15141 c15141 = PayloadUploader.this.new C15141(continuation);
            c15141.L$0 = obj;
            return c15141;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<CharacteristicClient<ControlCommand, ControlCommand>.Response> flow = PayloadUploader.this.controlClient.getFlow();
                final PayloadUploader payloadUploader = PayloadUploader.this;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.payload.PayloadUploader.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CharacteristicClient<ControlCommand, ControlCommand>.Response) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CharacteristicClient<ControlCommand, ControlCommand>.Response response, Continuation<? super Unit> continuation) {
                        Logger logger = Logger.INSTANCE;
                        String name = coroutineScope.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        logger.log(name, "controlClient.flow " + response.getData() + ", device:" + response.getDeviceAddress());
                        ControlCommand data = response.getData();
                        if (Intrinsics.areEqual(data, ControlCommand.Start.INSTANCE)) {
                            PayloadUploadState value = payloadUploader.getUploadStateFlow().getValue();
                            if (value instanceof PayloadUploadState.WaitingForStart) {
                                PayloadUploadState.WaitingForStart waitingForStart = (PayloadUploadState.WaitingForStart) value;
                                byte[] bArr = (byte[]) CollectionsKt.first((List) waitingForStart.getChunks());
                                PayloadUploadState.WaitingForChunkAcceptance waitingForChunkAcceptance = new PayloadUploadState.WaitingForChunkAcceptance(response.getDeviceAddress(), waitingForStart.getChunks().subList(1, waitingForStart.getChunks().size()));
                                payloadUploader.payloadClient.write(response.getDeviceAddress(), new PayloadChunk(bArr));
                                payloadUploader.getUploadStateFlow().setValue(waitingForChunkAcceptance);
                            }
                        } else if (Intrinsics.areEqual(data, ControlCommand.Continue.INSTANCE)) {
                            PayloadUploadState value2 = payloadUploader.getUploadStateFlow().getValue();
                            if (value2 instanceof PayloadUploadState.WaitingForChunkAcceptance) {
                                List<byte[]> remainingChunks = ((PayloadUploadState.WaitingForChunkAcceptance) value2).getRemainingChunks();
                                int size = remainingChunks.size();
                                if (size == 0) {
                                    ControlCommand.Complete complete = ControlCommand.Complete.INSTANCE;
                                    PayloadUploadState.Finishing finishing = new PayloadUploadState.Finishing(response.getDeviceAddress());
                                    payloadUploader.controlClient.write(response.getDeviceAddress(), complete);
                                    payloadUploader.getUploadStateFlow().setValue(finishing);
                                } else if (size == 1) {
                                    PayloadChunk payloadChunk = new PayloadChunk((byte[]) CollectionsKt.first((List) remainingChunks));
                                    ControlCommand.Complete complete2 = ControlCommand.Complete.INSTANCE;
                                    PayloadUploadState.Finishing finishing2 = new PayloadUploadState.Finishing(response.getDeviceAddress());
                                    payloadUploader.payloadClient.write(response.getDeviceAddress(), payloadChunk);
                                    payloadUploader.controlClient.write(response.getDeviceAddress(), complete2);
                                    payloadUploader.getUploadStateFlow().setValue(finishing2);
                                } else {
                                    byte[] bArr2 = (byte[]) CollectionsKt.first((List) remainingChunks);
                                    PayloadUploadState.WaitingForChunkAcceptance waitingForChunkAcceptance2 = new PayloadUploadState.WaitingForChunkAcceptance(response.getDeviceAddress(), remainingChunks.subList(1, remainingChunks.size()));
                                    payloadUploader.payloadClient.write(response.getDeviceAddress(), new PayloadChunk(bArr2));
                                    payloadUploader.getUploadStateFlow().setValue(waitingForChunkAcceptance2);
                                }
                            }
                        } else if (Intrinsics.areEqual(data, ControlCommand.Done.INSTANCE)) {
                            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C59471(payloadUploader, response, null), 3, null);
                        } else if (Intrinsics.areEqual(data, ControlCommand.Error.INSTANCE)) {
                            payloadUploader.getUploadStateFlow().setValue(new PayloadUploadState.Idle(response.getDeviceAddress(), PayloadUploadResult.DeviceError.INSTANCE));
                        } else if (!Intrinsics.areEqual(data, ControlCommand.Complete.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.bat.sdk.payload.PayloadUploader$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: PayloadUploader.kt */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$1$1$1", m5608f = "PayloadUploader.kt", m5609i = {0}, m5610l = {97}, m5611m = "invokeSuspend", m5612n = {"$this$launch"}, m5613s = {"L$0"})
                    static final class C59471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ CharacteristicClient<ControlCommand, ControlCommand>.Response $control;
                        private /* synthetic */ Object L$0;
                        int label;
                        final /* synthetic */ PayloadUploader this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C59471(PayloadUploader payloadUploader, CharacteristicClient<ControlCommand, ControlCommand>.Response response, Continuation<? super C59471> continuation) {
                            super(2, continuation);
                            this.this$0 = payloadUploader;
                            this.$control = response;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C59471 c59471 = new C59471(this.this$0, this.$control, continuation);
                            c59471.L$0 = obj;
                            return c59471;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C59471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            final CoroutineScope coroutineScope;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                this.this$0.getUploadStateFlow().setValue(new PayloadUploadState.Idle(this.$control.getDeviceAddress(), PayloadUploadResult.Success.INSTANCE));
                                Logger logger = Logger.INSTANCE;
                                String name = coroutineScope2.getClass().getName();
                                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                logger.log(name, "ControlCommand.Done closing gatt " + this.$control.getDeviceAddress() + ", wait 5sec for epod restart");
                                this.L$0 = coroutineScope2;
                                this.label = 1;
                                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                coroutineScope = coroutineScope2;
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                coroutineScope = (CoroutineScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            PayloadUploader payloadUploader = this.this$0;
                            final CharacteristicClient<ControlCommand, ControlCommand>.Response response = this.$control;
                            final PayloadUploader payloadUploader2 = this.this$0;
                            payloadUploader.scanCallback = new ScanCallback() { // from class: com.bat.sdk.payload.PayloadUploader.1.1.1.1
                                @Override // android.bluetooth.le.ScanCallback
                                public void onScanResult(int callbackType, ScanResult result) {
                                    super.onScanResult(callbackType, result);
                                    if (result != null) {
                                        CharacteristicClient<ControlCommand, ControlCommand>.Response response2 = response;
                                        Ref.BooleanRef booleanRef2 = booleanRef;
                                        CoroutineScope coroutineScope3 = coroutineScope;
                                        PayloadUploader payloadUploader3 = payloadUploader2;
                                        if (result.getDevice().getAddress().equals(response2.getDeviceAddress()) && (!booleanRef2.element)) {
                                            LogInstrumentation.m2726d(getClass().getName(), "After MSS scan result available: " + result);
                                            booleanRef2.element = true;
                                            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new PayloadUploader$1$1$1$1$onScanResult$1$1(response2, result, payloadUploader3, null), 3, null);
                                            CoroutineScopeKt.cancel$default(coroutineScope3, null, 1, null);
                                        }
                                    }
                                }

                                @Override // android.bluetooth.le.ScanCallback
                                public void onBatchScanResults(List<ScanResult> results) {
                                    super.onBatchScanResults(results);
                                }

                                @Override // android.bluetooth.le.ScanCallback
                                public void onScanFailed(int errorCode) {
                                    super.onScanFailed(errorCode);
                                    Logger logger2 = Logger.INSTANCE;
                                    String name2 = getClass().getName();
                                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                    logger2.log(name2, "Scan failed during reconnection");
                                }
                            };
                            ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
                            List<ScanFilter> listEmptyList = CollectionsKt.emptyList();
                            BatScanner scanner = BatSdk.INSTANCE.getScanner();
                            if (scanner != null) {
                                Intrinsics.checkNotNull(scanSettingsBuild);
                                ScanCallback scanCallback = this.this$0.scanCallback;
                                Intrinsics.checkNotNull(scanCallback);
                                scanner.start(scanSettingsBuild, listEmptyList, scanCallback);
                            }
                            return Unit.INSTANCE;
                        }
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

    /* JADX INFO: renamed from: com.bat.sdk.payload.PayloadUploader$2 */
    /* JADX INFO: compiled from: PayloadUploader.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$2", m5608f = "PayloadUploader.kt", m5609i = {}, m5610l = {153}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C15152(Continuation<? super C15152> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15152 c15152 = PayloadUploader.this.new C15152(continuation);
            c15152.L$0 = obj;
            return c15152;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.bat.sdk.payload.PayloadUploader$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PayloadUploader.kt */
        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ PayloadUploader this$0;

            AnonymousClass1(PayloadUploader payloadUploader, CoroutineScope coroutineScope) {
                this.this$0 = payloadUploader;
                this.$$this$launch = coroutineScope;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.client.CharacteristicClient<com.bat.sdk.model.PayloadChallengeRequest, com.bat.sdk.model.PayloadChallengeResponse>.Response r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
                /*
                    Method dump skipped, instruction units count: 634
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.payload.PayloadUploader.C15152.AnonymousClass1.emit(com.bat.sdk.client.CharacteristicClient$Response, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((CharacteristicClient<PayloadChallengeRequest, PayloadChallengeResponse>.Response) obj, (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (PayloadUploader.this.challengeClient.getFlow().collect(new AnonymousClass1(PayloadUploader.this, coroutineScope), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: upload-zvoA_rg, reason: not valid java name */
    public final void m5928uploadzvoA_rg(String deviceAddress, short payloadCode, String countryCode, String url, String userId, String token, String tenant, String accessToken) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        this.url = url;
        this.userId = userId;
        this.token = token;
        this.tenant = tenant;
        this.accessToken = accessToken;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PayloadUploader$upload$1(deviceAddress, payloadCode, countryCode, this, null), 3, null);
    }
}
