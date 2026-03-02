package com.bat.sdk.remote;

import com.bat.sdk.remote.data.AuthenticationError;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: AuthenticationErrorInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, m5598d2 = {"Lcom/bat/sdk/remote/AuthenticationErrorInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "_authError", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bat/sdk/remote/data/AuthenticationError;", "authenticationErrorsFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAuthenticationErrorsFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AuthenticationErrorInterceptor implements Interceptor {
    private MutableSharedFlow<AuthenticationError> _authError;
    private final SharedFlow<AuthenticationError> authenticationErrorsFlow;

    public AuthenticationErrorInterceptor() {
        MutableSharedFlow<AuthenticationError> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        this._authError = mutableSharedFlowMutableSharedFlow$default;
        this.authenticationErrorsFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    public final SharedFlow<AuthenticationError> getAuthenticationErrorsFlow() {
        return this.authenticationErrorsFlow;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response responseProceed = chain.proceed(request);
        if (responseProceed.code() == 401) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15771(request, responseProceed, null), 3, null);
        }
        return responseProceed;
    }

    /* JADX INFO: renamed from: com.bat.sdk.remote.AuthenticationErrorInterceptor$intercept$1 */
    /* JADX INFO: compiled from: AuthenticationErrorInterceptor.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.remote.AuthenticationErrorInterceptor$intercept$1", m5608f = "AuthenticationErrorInterceptor.kt", m5609i = {}, m5610l = {20}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Request $request;
        final /* synthetic */ Response $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15771(Request request, Response response, Continuation<? super C15771> continuation) {
            super(2, continuation);
            this.$request = request;
            this.$response = response;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthenticationErrorInterceptor.this.new C15771(this.$request, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AuthenticationErrorInterceptor.this._authError.emit(new AuthenticationError(this.$request, this.$response), this) == coroutine_suspended) {
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
