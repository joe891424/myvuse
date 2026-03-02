package com.bat.sdk.client;

import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.model.DeviceInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.bat.sdk.client.DeviceInfoClient$getDeviceMSSPayload$deviceInfoFromNotification$1 */
/* JADX INFO: compiled from: DeviceInfoClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u00140\u0003R\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\n"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "", "Lcom/bat/sdk/model/DeviceInfo;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.client.DeviceInfoClient$getDeviceMSSPayload$deviceInfoFromNotification$1", m5608f = "DeviceInfoClient.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class C1505x5f4cdcb2 extends SuspendLambda implements Function2<CharacteristicClient<String, DeviceInfo>.Response, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $deviceAddress;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1505x5f4cdcb2(String str, Continuation<? super C1505x5f4cdcb2> continuation) {
        super(2, continuation);
        this.$deviceAddress = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C1505x5f4cdcb2 c1505x5f4cdcb2 = new C1505x5f4cdcb2(this.$deviceAddress, continuation);
        c1505x5f4cdcb2.L$0 = obj;
        return c1505x5f4cdcb2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CharacteristicClient<String, DeviceInfo>.Response response, Continuation<? super Boolean> continuation) {
        return ((C1505x5f4cdcb2) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
        return Boxing.boxBoolean(((DeviceInfo) response.getData()).getResponseHex().length() == 40 && Intrinsics.areEqual(response.getDeviceAddress(), this.$deviceAddress));
    }
}
