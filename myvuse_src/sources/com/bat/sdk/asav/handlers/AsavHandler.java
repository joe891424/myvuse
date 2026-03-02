package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavException;
import com.bat.sdk.asav.core.AsavLog;
import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.request.AsavChannelRequest;
import com.bat.sdk.asav.response.AsavChannelResponse;
import com.bat.sdk.asav.response.IAsavResultListener;
import com.bat.sdk.ble.BatDevice;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: AsavHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0018H\u0096A¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\u000e\u0010 \u001a\u00020\u0014H\u0096A¢\u0006\u0002\u0010!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavHandler;", "Lcom/bat/sdk/asav/handlers/IAsavRequestAdvertiser;", "Lcom/bat/sdk/asav/handlers/IAsavResponseDiscoverer;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "requestAdvertiser", "responseReceiver", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;Lcom/bat/sdk/asav/handlers/IAsavRequestAdvertiser;Lcom/bat/sdk/asav/handlers/IAsavResponseDiscoverer;)V", "getAsavContext", "()Lcom/bat/sdk/asav/core/IAsavContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", "getListener", "()Lcom/bat/sdk/asav/response/IAsavResultListener;", "setListener", "(Lcom/bat/sdk/asav/response/IAsavResultListener;)V", "onResponseAvailable", "", "response", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "(Lcom/bat/sdk/asav/response/AsavChannelResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume", "element", "Lcom/bat/sdk/asav/request/AsavChannelRequest;", "(Lcom/bat/sdk/asav/request/AsavChannelRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withListener", "reset", "advertise", "request", "batDevice", "Lcom/bat/sdk/ble/BatDevice;", "interceptResponse", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class AsavHandler implements IAsavRequestAdvertiser, IAsavResponseDiscoverer {
    private final IAsavContext asavContext;
    private IAsavResultListener listener;
    private final IAsavRequestAdvertiser requestAdvertiser;
    private final IAsavResponseDiscoverer responseReceiver;

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavHandler$consume$1 */
    /* JADX INFO: compiled from: AsavHandler.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavHandler", m5608f = "AsavHandler.kt", m5609i = {0}, m5610l = {27, 41}, m5611m = "consume$suspendImpl", m5612n = {"$this"}, m5613s = {"L$0"})
    static final class C14931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14931(Continuation<? super C14931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsavHandler.consume$suspendImpl(AsavHandler.this, null, this);
        }
    }

    @Override // com.bat.sdk.asav.handlers.IAsavRequestAdvertiser
    public Object advertise(AsavChannelRequest asavChannelRequest, Continuation<? super Unit> continuation) {
        return this.requestAdvertiser.advertise(asavChannelRequest, continuation);
    }

    @Override // com.bat.sdk.asav.handlers.IAsavResponseDiscoverer
    public BatDevice batDevice() {
        return this.responseReceiver.batDevice();
    }

    public Object consume(AsavChannelRequest asavChannelRequest, Continuation<? super Unit> continuation) {
        return consume$suspendImpl(this, asavChannelRequest, continuation);
    }

    @Override // com.bat.sdk.asav.handlers.IAsavResponseDiscoverer
    public Object interceptResponse(Continuation<? super AsavChannelResponse> continuation) {
        return this.responseReceiver.interceptResponse(continuation);
    }

    public abstract Object onResponseAvailable(AsavChannelResponse asavChannelResponse, Continuation<? super Unit> continuation);

    public AsavHandler(IAsavContext asavContext, IAsavRequestAdvertiser requestAdvertiser, IAsavResponseDiscoverer responseReceiver) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        Intrinsics.checkNotNullParameter(requestAdvertiser, "requestAdvertiser");
        Intrinsics.checkNotNullParameter(responseReceiver, "responseReceiver");
        this.asavContext = asavContext;
        this.requestAdvertiser = requestAdvertiser;
        this.responseReceiver = responseReceiver;
        this.listener = new IAsavResultListener() { // from class: com.bat.sdk.asav.handlers.AsavHandler$listener$1
            @Override // com.bat.sdk.asav.response.IAsavResultListener
            public void onAlreadyUnlocked() {
                IAsavResultListener.DefaultImpls.onAlreadyUnlocked(this);
            }

            @Override // com.bat.sdk.asav.response.IAsavResultListener
            public void onFailure(BatDevice batDevice, AsavException asavException) {
                IAsavResultListener.DefaultImpls.onFailure(this, batDevice, asavException);
            }

            @Override // com.bat.sdk.asav.response.IAsavResultListener
            public void onSuccess(BatDevice batDevice) {
                IAsavResultListener.DefaultImpls.onSuccess(this, batDevice);
            }

            @Override // com.bat.sdk.asav.response.IAsavResultListener
            public void onTimeout() {
                IAsavResultListener.DefaultImpls.onTimeout(this);
            }
        };
    }

    public final IAsavContext getAsavContext() {
        return this.asavContext;
    }

    protected final IAsavResultListener getListener() {
        return this.listener;
    }

    protected final void setListener(IAsavResultListener iAsavResultListener) {
        Intrinsics.checkNotNullParameter(iAsavResultListener, "<set-?>");
        this.listener = iAsavResultListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object consume$suspendImpl(com.bat.sdk.asav.handlers.AsavHandler r6, com.bat.sdk.asav.request.AsavChannelRequest r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof com.bat.sdk.asav.handlers.AsavHandler.C14931
            if (r0 == 0) goto L14
            r0 = r8
            com.bat.sdk.asav.handlers.AsavHandler$consume$1 r0 = (com.bat.sdk.asav.handlers.AsavHandler.C14931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.bat.sdk.asav.handlers.AsavHandler$consume$1 r0 = new com.bat.sdk.asav.handlers.AsavHandler$consume$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$0
            com.bat.sdk.asav.handlers.AsavHandler r6 = (com.bat.sdk.asav.handlers.AsavHandler) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L56
            goto L6f
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.reset()     // Catch: java.lang.Exception -> L56
            com.bat.sdk.asav.handlers.AsavHandler$consume$2 r8 = new com.bat.sdk.asav.handlers.AsavHandler$consume$2     // Catch: java.lang.Exception -> L56
            r8.<init>(r7, r5)     // Catch: java.lang.Exception -> L56
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Exception -> L56
            r0.L$0 = r6     // Catch: java.lang.Exception -> L56
            r0.label = r4     // Catch: java.lang.Exception -> L56
            java.lang.Object r6 = kotlinx.coroutines.SupervisorKt.supervisorScope(r8, r0)     // Catch: java.lang.Exception -> L56
            if (r6 != r1) goto L6f
            return r1
        L56:
            r7 = move-exception
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.bat.sdk.asav.handlers.AsavHandler$consume$3 r2 = new com.bat.sdk.asav.handlers.AsavHandler$consume$3
            r2.<init>(r7, r6, r5)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r6 != r1) goto L6f
            return r1
        L6f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.asav.handlers.AsavHandler.consume$suspendImpl(com.bat.sdk.asav.handlers.AsavHandler, com.bat.sdk.asav.request.AsavChannelRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavHandler$consume$2 */
    /* JADX INFO: compiled from: AsavHandler.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavHandler$consume$2", m5608f = "AsavHandler.kt", m5609i = {0}, m5610l = {37}, m5611m = "invokeSuspend", m5612n = {"advertiserAsync"}, m5613s = {"L$0"})
    static final class C14942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AsavChannelRequest $element;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14942(AsavChannelRequest asavChannelRequest, Continuation<? super C14942> continuation) {
            super(2, continuation);
            this.$element = asavChannelRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14942 c14942 = AsavHandler.this.new C14942(this.$element, continuation);
            c14942.L$0 = obj;
            return c14942;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C14942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r12v3, types: [T, kotlinx.coroutines.Deferred] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.LAZY, new AsavHandler$consume$2$discovererAsync$1(AsavHandler.this, objectRef2, null), 1, null);
                objectRef2.element = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.LAZY, new AnonymousClass1(AsavHandler.this, this.$element, null), 1, null);
                deferredAsync$default.start();
                this.L$0 = objectRef2;
                this.label = 1;
                if (DelayKt.delay(250L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(((Deferred) objectRef.element).start());
        }

        /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavHandler$consume$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AsavHandler.kt */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavHandler$consume$2$1", m5608f = "AsavHandler.kt", m5609i = {}, m5610l = {35}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AsavChannelRequest $element;
            int label;
            final /* synthetic */ AsavHandler this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AsavHandler asavHandler, AsavChannelRequest asavChannelRequest, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = asavHandler;
                this.$element = asavChannelRequest;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$element, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.advertise(this.$element, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavHandler$consume$3 */
    /* JADX INFO: compiled from: AsavHandler.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavHandler$consume$3", m5608f = "AsavHandler.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14953 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: $e */
        final /* synthetic */ Exception f2039$e;
        int label;
        final /* synthetic */ AsavHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14953(Exception exc, AsavHandler asavHandler, Continuation<? super C14953> continuation) {
            super(2, continuation);
            this.f2039$e = exc;
            this.this$0 = asavHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14953(this.f2039$e, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14953) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!(this.f2039$e instanceof CancellationException)) {
                AsavLogKt.getLogger().debug("Error received " + this.f2039$e.getMessage() + SafeJsonPrimitive.NULL_CHAR);
                AsavLog logger = AsavLogKt.getLogger();
                StringBuilder sb = new StringBuilder("Error received ");
                this.f2039$e.printStackTrace();
                logger.console(sb.append(Unit.INSTANCE).toString());
                this.this$0.getListener().onFailure(this.this$0.batDevice(), new AsavException(this.this$0.getAsavContext().status(), this.f2039$e));
            }
            return Unit.INSTANCE;
        }
    }

    public void withListener(IAsavResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // com.bat.sdk.asav.handlers.IAsavRequestAdvertiser
    public void reset() {
        this.requestAdvertiser.reset();
        this.responseReceiver.reset();
    }
}
