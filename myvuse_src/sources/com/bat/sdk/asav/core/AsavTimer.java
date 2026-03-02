package com.bat.sdk.asav.core;

import com.bat.sdk.asav.response.IAsavResultListener;
import com.bat.sdk.ble.BatDevice;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: AsavTimer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavTimer;", "Lcom/bat/sdk/asav/core/IAsavTimer;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", "attach", "", "ping", "clear", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavTimer implements IAsavTimer {
    private final IAsavContext asavContext;
    private final CoroutineScope coroutineScope;
    private IAsavResultListener listener;

    public AsavTimer(IAsavContext asavContext) {
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
        this.asavContext = asavContext;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
        this.listener = new IAsavResultListener() { // from class: com.bat.sdk.asav.core.AsavTimer$listener$1
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

    @Override // com.bat.sdk.asav.core.IAsavTimer
    public void attach(IAsavResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.core.AsavTimer$ping$1 */
    /* JADX INFO: compiled from: AsavTimer.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.core.AsavTimer$ping$1", m5608f = "AsavTimer.kt", m5609i = {}, m5610l = {20, 22}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14891(Continuation<? super C14891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AsavTimer.this.new C14891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(TimeUnit.SECONDS.toMillis(20L), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    AsavTimer.this.asavContext.stop();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            AsavLogKt.getLogger().log("Time's up! Aborting ASAV");
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(AsavTimer.this, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            AsavTimer.this.asavContext.stop();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.sdk.asav.core.AsavTimer$ping$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AsavTimer.kt */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.sdk.asav.core.AsavTimer$ping$1$1", m5608f = "AsavTimer.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AsavTimer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AsavTimer asavTimer, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = asavTimer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                    this.this$0.listener.onTimeout();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.bat.sdk.asav.core.IAsavTimer
    public void ping() {
        clear();
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C14891(null), 3, null);
    }

    @Override // com.bat.sdk.asav.core.IAsavTimer
    public void clear() {
        JobKt__JobKt.cancelChildren$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
