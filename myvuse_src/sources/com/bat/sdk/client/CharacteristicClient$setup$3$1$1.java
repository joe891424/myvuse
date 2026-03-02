package com.bat.sdk.client;

import com.bat.sdk.ble.BatCharacteristic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CharacteristicClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.client.CharacteristicClient$setup$3$1$1", m5608f = "CharacteristicClient.kt", m5609i = {}, m5610l = {108, 116, 124, 151, 156, 160}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class CharacteristicClient$setup$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BatCharacteristic $characteristic;
    final /* synthetic */ String $deviceAddress;
    final /* synthetic */ RESPONSE $response;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CharacteristicClient<REQUEST, RESPONSE> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CharacteristicClient$setup$3$1$1(BatCharacteristic batCharacteristic, RESPONSE response, CharacteristicClient<REQUEST, RESPONSE> characteristicClient, String str, Continuation<? super CharacteristicClient$setup$3$1$1> continuation) {
        super(2, continuation);
        this.$characteristic = batCharacteristic;
        this.$response = response;
        this.this$0 = characteristicClient;
        this.$deviceAddress = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CharacteristicClient$setup$3$1$1(this.$characteristic, this.$response, this.this$0, this.$deviceAddress, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CharacteristicClient$setup$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0238  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.client.CharacteristicClient$setup$3$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
