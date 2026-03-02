package com.bat.sdk.asav.handlers;

import com.bat.sdk.asav.core.IAsavContext;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavChallengeHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/asav/handlers/AsavChallengeHandler;", "Lcom/bat/sdk/asav/handlers/AsavHandler;", "asavContext", "Lcom/bat/sdk/asav/core/IAsavContext;", "<init>", "(Lcom/bat/sdk/asav/core/IAsavContext;)V", "onResponseAvailable", "", "response", "Lcom/bat/sdk/asav/response/AsavChannelResponse;", "(Lcom/bat/sdk/asav/response/AsavChannelResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavChallengeHandler extends AsavHandler {

    /* JADX INFO: renamed from: com.bat.sdk.asav.handlers.AsavChallengeHandler$onResponseAvailable$1 */
    /* JADX INFO: compiled from: AsavChallengeHandler.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavChallengeHandler", m5608f = "AsavChallengeHandler.kt", m5609i = {0, 0, 1, 2}, m5610l = {27, 34, 40}, m5611m = "onResponseAvailable", m5612n = {"this", ClientData.KEY_CHALLENGE, "$this$onResponseAvailable_u24lambda_u245", "$this$onResponseAvailable_u24lambda_u245"}, m5613s = {"L$0", "L$1", "L$0", "L$0"})
    static final class C14911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14911(Continuation<? super C14911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsavChallengeHandler.this.onResponseAvailable(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsavChallengeHandler(IAsavContext asavContext) {
        super(asavContext, AsavHandlersExtensionsKt.challengeRequestAdvertiser(asavContext), AsavHandlersExtensionsKt.challengeResponseDiscoverer(asavContext));
        Intrinsics.checkNotNullParameter(asavContext, "asavContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // com.bat.sdk.asav.handlers.AsavHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onResponseAvailable(com.bat.sdk.asav.response.AsavChannelResponse r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.asav.handlers.AsavChallengeHandler.onResponseAvailable(com.bat.sdk.asav.response.AsavChannelResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
