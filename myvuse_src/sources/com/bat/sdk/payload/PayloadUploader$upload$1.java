package com.bat.sdk.payload;

import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.PayloadChallengeRequest;
import com.bat.sdk.payload.PayloadUploadState;
import com.facebook.imageutils.JfifUtil;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: PayloadUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$upload$1", m5608f = "PayloadUploader.kt", m5609i = {0}, m5610l = {JfifUtil.MARKER_SOI}, m5611m = "invokeSuspend", m5612n = {"$this$launch"}, m5613s = {"L$0"})
final class PayloadUploader$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $countryCode;
    final /* synthetic */ String $deviceAddress;
    final /* synthetic */ short $payloadCode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PayloadUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayloadUploader$upload$1(String str, short s, String str2, PayloadUploader payloadUploader, Continuation<? super PayloadUploader$upload$1> continuation) {
        super(2, continuation);
        this.$deviceAddress = str;
        this.$payloadCode = s;
        this.$countryCode = str2;
        this.this$0 = payloadUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayloadUploader$upload$1 payloadUploader$upload$1 = new PayloadUploader$upload$1(this.$deviceAddress, this.$payloadCode, this.$countryCode, this.this$0, continuation);
        payloadUploader$upload$1.L$0 = obj;
        return payloadUploader$upload$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PayloadUploader$upload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        do {
            GattManager gattManager = BatSdk.INSTANCE.getGattManager();
            Intrinsics.checkNotNull(gattManager);
            if (gattManager.isRequestPresent(this.$deviceAddress)) {
                Logger logger = Logger.INSTANCE;
                String name = coroutineScope.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                logger.log(name, "Upload " + this.$deviceAddress + ", there are pending requests in process");
                this.L$0 = coroutineScope;
                this.label = 1;
            } else {
                PayloadChallengeRequest payloadChallengeRequest = new PayloadChallengeRequest(this.$payloadCode, null);
                PayloadUploadState.ReadingChallenge readingChallenge = new PayloadUploadState.ReadingChallenge(this.$deviceAddress, this.$payloadCode, this.$countryCode, null);
                Logger logger2 = Logger.INSTANCE;
                String name2 = coroutineScope.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                logger2.log(name2, "upload device:" + this.$deviceAddress + ", challenge client write " + ((Object) UShort.m7558toStringimpl(payloadChallengeRequest.m5922getPayloadCodeMh2AYeg())));
                this.this$0.challengeClient.write(this.$deviceAddress, payloadChallengeRequest);
                Logger logger3 = Logger.INSTANCE;
                String name3 = coroutineScope.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                logger3.log(name3, "upload device:" + this.$deviceAddress + ", uploadStateFlow.value:" + this.this$0.getUploadStateFlow().getValue() + SafeJsonPrimitive.NULL_CHAR);
                this.this$0.getUploadStateFlow().setValue(readingChallenge);
                return Unit.INSTANCE;
            }
        } while (DelayKt.delay(1000L, this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
