package com.bat.sdk;

import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.bat.sdk.logging.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: FirmwareManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.FirmwareManager$installationListener$1$onError$1", m5608f = "FirmwareManager.kt", m5609i = {}, m5610l = {185}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class FirmwareManager$installationListener$1$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $address;
    final /* synthetic */ int $error;
    final /* synthetic */ int $errorType;
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ FirmwareManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FirmwareManager$installationListener$1$onError$1(FirmwareManager firmwareManager, String str, int i, int i2, String str2, Continuation<? super FirmwareManager$installationListener$1$onError$1> continuation) {
        super(2, continuation);
        this.this$0 = firmwareManager;
        this.$address = str;
        this.$error = i;
        this.$errorType = i2;
        this.$message = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FirmwareManager$installationListener$1$onError$1(this.this$0, this.$address, this.$error, this.$errorType, this.$message, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FirmwareManager$installationListener$1$onError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.Error(this.$address, this.$error, this.$errorType, this.$message));
            Logger.INSTANCE.log("firmware manager: onError - address: " + this.$address + " - error: " + this.$error + " - errorType: " + this.$errorType + " - message: " + this.$message);
            this.label = 1;
            if (DelayKt.delay(400L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.Idle(this.$address));
        return Unit.INSTANCE;
    }
}
