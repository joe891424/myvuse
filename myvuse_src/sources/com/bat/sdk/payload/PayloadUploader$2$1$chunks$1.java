package com.bat.sdk.payload;

import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.PayloadChallengeRequest;
import com.bat.sdk.model.PayloadChallengeResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PayloadUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m5598d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$2$1$chunks$1", m5608f = "PayloadUploader.kt", m5609i = {}, m5610l = {168}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class PayloadUploader$2$1$chunks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends byte[]>>, Object> {
    final /* synthetic */ String $challenge;
    final /* synthetic */ String $countryCode;
    final /* synthetic */ CharacteristicClient<PayloadChallengeRequest, PayloadChallengeResponse>.Response $it;
    final /* synthetic */ short $payloadCode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PayloadUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayloadUploader$2$1$chunks$1(CharacteristicClient<PayloadChallengeRequest, PayloadChallengeResponse>.Response response, PayloadUploader payloadUploader, String str, String str2, short s, Continuation<? super PayloadUploader$2$1$chunks$1> continuation) {
        super(2, continuation);
        this.$it = response;
        this.this$0 = payloadUploader;
        this.$challenge = str;
        this.$countryCode = str2;
        this.$payloadCode = s;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayloadUploader$2$1$chunks$1 payloadUploader$2$1$chunks$1 = new PayloadUploader$2$1$chunks$1(this.$it, this.this$0, this.$challenge, this.$countryCode, this.$payloadCode, continuation);
        payloadUploader$2$1$chunks$1.L$0 = obj;
        return payloadUploader$2$1$chunks$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends byte[]>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<byte[]>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<byte[]>> continuation) {
        return ((PayloadUploader$2$1$chunks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Logger logger = Logger.INSTANCE;
            String name = coroutineScope.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "PayloadUploadState.ReadingChallenge device:" + this.$it.getDeviceAddress() + ", request payload");
            this.label = 1;
            obj = this.this$0.payloadCaller.requestPayload(this.$challenge, this.$countryCode, UShort.m7558toStringimpl(this.$payloadCode), this.this$0.url, this.this$0.userId, this.this$0.token, this.this$0.tenant, this.this$0.accessToken, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
