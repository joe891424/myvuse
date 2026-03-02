package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.core.IAsavTimer;
import com.bat.sdk.asav.response.AsavChannelResponse;
import com.bat.sdk.asav.response.AsavChannelResponseExtensionsKt;
import com.bat.sdk.asav.response.IAsavResultListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AsavSignatureHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavSignatureHandler;", "Lcom/bat/sdk/asav/handlers/AsavHandler;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;)V", "timer", "Lcom/bat/sdk/asav/core/IAsavTimer;", "getTimer", "()Lcom/bat/sdk/asav/core/IAsavTimer;", "timer$delegate", "Lkotlin/Lazy;", "onResponseAvailable", "", "response", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "(Lcom/bat/sdk/asav/response/AsavChannelResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavSignatureHandler extends AsavHandler {

    /* JADX INFO: renamed from: timer$delegate, reason: from kotlin metadata */
    private final Lazy timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsavSignatureHandler(final IAsavContext asavContext) {
        super(asavContext, AsavHandlersExtensionsKt.signatureRequestAdvertiser(asavContext), AsavHandlersExtensionsKt.signatureResponseDiscoverer(asavContext));
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        this.timer = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.asav.handlers.AsavSignatureHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsavSignatureHandler.timer_delegate$lambda$0(asavContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAsavTimer getTimer() {
        return (IAsavTimer) this.timer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAsavTimer timer_delegate$lambda$0(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "$asavContext");
        return asavContext.timer();
    }

    @Override // com.bat.sdk.asav.handlers.AsavHandler
    public Object onResponseAvailable(AsavChannelResponse asavChannelResponse, Continuation<? super Unit> continuation) {
        boolean zBooleanValue = AsavChannelResponseExtensionsKt.stringifySignatureACK(asavChannelResponse).component1().booleanValue();
        AsavLogKt.getLogger().log("EPOD ->SDK: Signature ACK received");
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C14962(zBooleanValue, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavSignatureHandler$onResponseAvailable$2 */
    /* JADX INFO: compiled from: AsavSignatureHandler.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavSignatureHandler$onResponseAvailable$2", m5608f = "AsavSignatureHandler.kt", m5609i = {}, m5610l = {26}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14962(boolean z, Continuation<? super C14962> continuation) {
            super(2, continuation);
            this.$result = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AsavSignatureHandler.this.new C14962(this.$result, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavSignatureHandler$onResponseAvailable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AsavSignatureHandler.kt */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavSignatureHandler$onResponseAvailable$2$1", m5608f = "AsavSignatureHandler.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $result;
            int label;
            final /* synthetic */ AsavSignatureHandler this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AsavSignatureHandler asavSignatureHandler, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = asavSignatureHandler;
                this.$result = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getTimer().clear();
                    boolean z = this.$result;
                    if (z) {
                        this.this$0.getListener().onSuccess(this.this$0.getBatDevice());
                    } else {
                        if (z) {
                            throw new NoWhenBranchMatchedException();
                        }
                        IAsavResultListener.DefaultImpls.onFailure$default(this.this$0.getListener(), this.this$0.getBatDevice(), null, 2, null);
                    }
                    AsavLogKt.getLogger().log(this.$result ? "ASAV completed successfully" : "ASAV failed");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(AsavSignatureHandler.this, this.$result, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AsavSignatureHandler.this.reset();
            AsavSignatureHandler.this.getAsavContext().stop();
            return Unit.INSTANCE;
        }
    }
}
