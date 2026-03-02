package com.bat.sdk.age;

import com.bat.sdk.age.AgeVerificationResult;
import com.bat.sdk.ble.BleRequest;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.AgeChallengeClient;
import com.bat.sdk.client.AgeSignatureClient;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.AgeChallenge;
import com.bat.sdk.model.AgeSignature;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: AgeVerifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\rJ\u0016\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerifier;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "verificationCaller", "Lcom/bat/sdk/age/AgeVerificationCaller;", "ageChallengeClient", "Lcom/bat/sdk/client/AgeChallengeClient;", "ageSignatureClient", "Lcom/bat/sdk/client/AgeSignatureClient;", "<init>", "(Lcom/bat/sdk/ble/GattManager;Lcom/bat/sdk/age/AgeVerificationCaller;Lcom/bat/sdk/client/AgeChallengeClient;Lcom/bat/sdk/client/AgeSignatureClient;)V", "url", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "accessToken", "isProductionDevice", "", "_verificationResultStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/age/AgeVerificationResult;", "verificationResultStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getVerificationResultStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "verify", "", "deviceAddress", "isReady", "checkVerification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AgeVerifier {
    private final MutableStateFlow<AgeVerificationResult> _verificationResultStateFlow;
    private String accessToken;
    private final AgeChallengeClient ageChallengeClient;
    private final AgeSignatureClient ageSignatureClient;
    private final GattManager gattManager;
    private boolean isProductionDevice;
    private String tenant;
    private String token;
    private String url;
    private String userId;
    private final AgeVerificationCaller verificationCaller;
    private final StateFlow<AgeVerificationResult> verificationResultStateFlow;

    /* JADX INFO: renamed from: com.bat.sdk.age.AgeVerifier$checkVerification$1 */
    /* JADX INFO: compiled from: AgeVerifier.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.age.AgeVerifier", m5608f = "AgeVerifier.kt", m5609i = {0, 0}, m5610l = {ISO7816Kt.SW1_WARNING_UNCHANGED}, m5611m = "checkVerification", m5612n = {"this", "deviceAddress"}, m5613s = {"L$0", "L$1"})
    static final class C14861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14861(Continuation<? super C14861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgeVerifier.this.checkVerification(null, this);
        }
    }

    public AgeVerifier(GattManager gattManager, AgeVerificationCaller verificationCaller, AgeChallengeClient ageChallengeClient, AgeSignatureClient ageSignatureClient) {
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        Intrinsics.checkNotNullParameter(verificationCaller, "verificationCaller");
        Intrinsics.checkNotNullParameter(ageChallengeClient, "ageChallengeClient");
        Intrinsics.checkNotNullParameter(ageSignatureClient, "ageSignatureClient");
        this.gattManager = gattManager;
        this.verificationCaller = verificationCaller;
        this.ageChallengeClient = ageChallengeClient;
        this.ageSignatureClient = ageSignatureClient;
        this.url = "";
        this.userId = "";
        this.token = "";
        this.tenant = "";
        this.isProductionDevice = true;
        MutableStateFlow<AgeVerificationResult> MutableStateFlow = StateFlowKt.MutableStateFlow(new AgeVerificationResult.Unknown(""));
        this._verificationResultStateFlow = MutableStateFlow;
        this.verificationResultStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C14841(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C14852(null), 3, null);
    }

    public final StateFlow<AgeVerificationResult> getVerificationResultStateFlow() {
        return this.verificationResultStateFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.age.AgeVerifier$1 */
    /* JADX INFO: compiled from: AgeVerifier.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.age.AgeVerifier$1", m5608f = "AgeVerifier.kt", m5609i = {}, m5610l = {39}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C14841(Continuation<? super C14841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14841 c14841 = AgeVerifier.this.new C14841(continuation);
            c14841.L$0 = obj;
            return c14841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (AgeVerifier.this.ageChallengeClient.getFlow().collect(new AnonymousClass1(coroutineScope, AgeVerifier.this), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception unused) {
                AgeVerifier.this._verificationResultStateFlow.setValue(new AgeVerificationResult.Error.ErrorAPI("Error in the API invoked by the BE. Please try again later. Thank you"));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.sdk.age.AgeVerifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AgeVerifier.kt */
        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ AgeVerifier this$0;

            AnonymousClass1(CoroutineScope coroutineScope, AgeVerifier ageVerifier) {
                this.$$this$launch = coroutineScope;
                this.this$0 = ageVerifier;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.client.CharacteristicClient<kotlin.Unit, com.bat.sdk.model.AgeChallenge>.Response r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
                /*
                    Method dump skipped, instruction units count: 462
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.age.AgeVerifier.C14841.AnonymousClass1.emit(com.bat.sdk.client.CharacteristicClient$Response, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((CharacteristicClient<Unit, AgeChallenge>.Response) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.age.AgeVerifier$2 */
    /* JADX INFO: compiled from: AgeVerifier.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.age.AgeVerifier$2", m5608f = "AgeVerifier.kt", m5609i = {}, m5610l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C14852(Continuation<? super C14852> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14852 c14852 = AgeVerifier.this.new C14852(continuation);
            c14852.L$0 = obj;
            return c14852;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<CharacteristicClient<AgeSignature, com.bat.sdk.model.AgeVerificationResult>.Response> flow = AgeVerifier.this.ageSignatureClient.getFlow();
                final AgeVerifier ageVerifier = AgeVerifier.this;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.age.AgeVerifier.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CharacteristicClient<AgeSignature, com.bat.sdk.model.AgeVerificationResult>.Response) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CharacteristicClient<AgeSignature, com.bat.sdk.model.AgeVerificationResult>.Response response, Continuation<? super Unit> continuation) {
                        AgeVerificationResult locked;
                        Logger logger = Logger.INSTANCE;
                        String name = coroutineScope.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        logger.log(name, "[av] received response from age signature for " + response.getDeviceAddress() + ": " + response.getData().getUnlocked());
                        ageVerifier.ageSignatureClient.setNotificationEnabled(response.getDeviceAddress(), false);
                        MutableStateFlow mutableStateFlow = ageVerifier._verificationResultStateFlow;
                        if (response.getData().getUnlocked()) {
                            locked = new AgeVerificationResult.Unlocked(response.getDeviceAddress());
                        } else {
                            locked = new AgeVerificationResult.Locked(response.getDeviceAddress());
                        }
                        mutableStateFlow.setValue(locked);
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

    public final void verify(String deviceAddress, String url, String userId, String token, String tenant, boolean isProductionDevice, String accessToken) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        if (!isReady(deviceAddress)) {
            this._verificationResultStateFlow.setValue(new AgeVerificationResult.Error.CharacteristicsAreNotReady(deviceAddress));
            return;
        }
        this.url = url;
        this.userId = userId;
        this.token = token;
        this.tenant = tenant;
        this.isProductionDevice = isProductionDevice;
        this.accessToken = accessToken;
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "[av] starting age verification");
        this.gattManager.enqueue(new BleRequest.Mtu(deviceAddress, 243));
        this.ageChallengeClient.enqueueRead(deviceAddress);
    }

    public final boolean isReady(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        return this.ageSignatureClient.isReady(deviceAddress) && this.ageChallengeClient.isReady(deviceAddress);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkVerification(java.lang.String r5, kotlin.coroutines.Continuation<? super com.bat.sdk.age.AgeVerificationResult> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bat.sdk.age.AgeVerifier.C14861
            if (r0 == 0) goto L14
            r0 = r6
            com.bat.sdk.age.AgeVerifier$checkVerification$1 r0 = (com.bat.sdk.age.AgeVerifier.C14861) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.bat.sdk.age.AgeVerifier$checkVerification$1 r0 = new com.bat.sdk.age.AgeVerifier$checkVerification$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.L$0
            com.bat.sdk.age.AgeVerifier r0 = (com.bat.sdk.age.AgeVerifier) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L63
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isReady(r5)
            if (r6 != 0) goto L53
            kotlinx.coroutines.flow.MutableStateFlow<com.bat.sdk.age.AgeVerificationResult> r6 = r4._verificationResultStateFlow
            com.bat.sdk.age.AgeVerificationResult$Error$CharacteristicsAreNotReady r0 = new com.bat.sdk.age.AgeVerificationResult$Error$CharacteristicsAreNotReady
            r0.<init>(r5)
            r6.setValue(r0)
            com.bat.sdk.age.AgeVerificationResult$Error$CharacteristicsAreNotReady r6 = new com.bat.sdk.age.AgeVerificationResult$Error$CharacteristicsAreNotReady
            r6.<init>(r5)
            return r6
        L53:
            com.bat.sdk.client.AgeSignatureClient r6 = r4.ageSignatureClient
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.read(r5, r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            r0 = r4
        L63:
            com.bat.sdk.model.AgeVerificationResult r6 = (com.bat.sdk.model.AgeVerificationResult) r6
            if (r6 == 0) goto L70
            boolean r6 = r6.getUnlocked()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            goto L71
        L70:
            r6 = 0
        L71:
            if (r6 != 0) goto L7b
            com.bat.sdk.age.AgeVerificationResult$Error$Generic r6 = new com.bat.sdk.age.AgeVerificationResult$Error$Generic
            r6.<init>(r5)
            com.bat.sdk.age.AgeVerificationResult r6 = (com.bat.sdk.age.AgeVerificationResult) r6
            goto L9f
        L7b:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 == 0) goto L8d
            com.bat.sdk.age.AgeVerificationResult$Unlocked r6 = new com.bat.sdk.age.AgeVerificationResult$Unlocked
            r6.<init>(r5)
            com.bat.sdk.age.AgeVerificationResult r6 = (com.bat.sdk.age.AgeVerificationResult) r6
            goto L9f
        L8d:
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto La5
            com.bat.sdk.age.AgeVerificationResult$Locked r6 = new com.bat.sdk.age.AgeVerificationResult$Locked
            r6.<init>(r5)
            com.bat.sdk.age.AgeVerificationResult r6 = (com.bat.sdk.age.AgeVerificationResult) r6
        L9f:
            kotlinx.coroutines.flow.MutableStateFlow<com.bat.sdk.age.AgeVerificationResult> r5 = r0._verificationResultStateFlow
            r5.setValue(r6)
            return r6
        La5:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.age.AgeVerifier.checkVerification(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
