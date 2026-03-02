package com.bat.sdk.payload;

import android.bluetooth.le.ScanResult;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.model.ControlCommand;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PayloadUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadUploader$1$1$1$1$onScanResult$1$1", m5608f = "PayloadUploader.kt", m5609i = {0, 1}, m5610l = {109, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED}, m5611m = "invokeSuspend", m5612n = {"$this$launch", "$this$launch"}, m5613s = {"L$0", "L$0"})
final class PayloadUploader$1$1$1$1$onScanResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharacteristicClient<ControlCommand, ControlCommand>.Response $control;
    final /* synthetic */ ScanResult $it;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PayloadUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayloadUploader$1$1$1$1$onScanResult$1$1(CharacteristicClient<ControlCommand, ControlCommand>.Response response, ScanResult scanResult, PayloadUploader payloadUploader, Continuation<? super PayloadUploader$1$1$1$1$onScanResult$1$1> continuation) {
        super(2, continuation);
        this.$control = response;
        this.$it = scanResult;
        this.this$0 = payloadUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayloadUploader$1$1$1$1$onScanResult$1$1 payloadUploader$1$1$1$1$onScanResult$1$1 = new PayloadUploader$1$1$1$1$onScanResult$1$1(this.$control, this.$it, this.this$0, continuation);
        payloadUploader$1$1$1$1$onScanResult$1$1.L$0 = obj;
        return payloadUploader$1$1$1$1$onScanResult$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PayloadUploader$1$1$1$1$onScanResult$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 5000(0x1388, double:2.4703E-320)
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L29
            if (r1 == r5) goto L20
            if (r1 != r4) goto L18
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5e
        L18:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L20:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r1
            goto L3e
        L29:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.L$0 = r8
            r7.label = r5
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r2, r1)
            if (r1 != r0) goto L3e
            return r0
        L3e:
            com.bat.sdk.BatSdk r1 = com.bat.sdk.BatSdk.INSTANCE
            com.bat.sdk.ble.GattManager r1 = r1.getGattManager()
            if (r1 == 0) goto L4f
            com.bat.sdk.client.CharacteristicClient<com.bat.sdk.model.ControlCommand, com.bat.sdk.model.ControlCommand>$Response r6 = r7.$control
            java.lang.String r6 = r6.getDeviceAddress()
            r1.closeGatt(r6)
        L4f:
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.L$0 = r8
            r7.label = r4
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r2, r1)
            if (r1 != r0) goto L5d
            return r0
        L5d:
            r0 = r8
        L5e:
            com.bat.sdk.BatSdk r8 = com.bat.sdk.BatSdk.INSTANCE
            com.bat.sdk.ble.GattManager r8 = r8.getGattManager()
            r1 = 0
            if (r8 == 0) goto L7a
            android.bluetooth.le.ScanResult r2 = r7.$it
            android.bluetooth.BluetoothDevice r2 = r2.getDevice()
            java.lang.String r2 = r2.getAddress()
            java.lang.String r3 = "getAddress(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 0
            com.bat.sdk.ble.GattManager.connect$default(r8, r2, r3, r4, r1)
        L7a:
            com.bat.sdk.payload.PayloadUploader r8 = r7.this$0
            android.bluetooth.le.ScanCallback r8 = com.bat.sdk.payload.PayloadUploader.access$getScanCallback$p(r8)
            if (r8 == 0) goto L8d
            com.bat.sdk.BatSdk r2 = com.bat.sdk.BatSdk.INSTANCE
            com.bat.sdk.ble.BatScanner r2 = r2.getScanner()
            if (r2 == 0) goto L8d
            r2.stop(r8)
        L8d:
            com.bat.sdk.payload.PayloadUploader r8 = r7.this$0
            com.bat.sdk.payload.PayloadUploader.access$setScanCallback$p(r8, r1)
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r0, r1, r5, r1)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.payload.PayloadUploader$1$1$1$1$onScanResult$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
