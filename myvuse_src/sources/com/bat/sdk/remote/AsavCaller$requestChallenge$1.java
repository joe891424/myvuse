package com.bat.sdk.remote;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AsavCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.remote.AsavCaller", m5608f = "AsavCaller.kt", m5609i = {}, m5610l = {46}, m5611m = "requestChallenge-gIAlu-s", m5612n = {}, m5613s = {})
final class AsavCaller$requestChallenge$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsavCaller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsavCaller$requestChallenge$1(AsavCaller asavCaller, Continuation<? super AsavCaller$requestChallenge$1> continuation) {
        super(continuation);
        this.this$0 = asavCaller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5933requestChallengegIAlus = this.this$0.m5933requestChallengegIAlus(null, this);
        return objM5933requestChallengegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5933requestChallengegIAlus : Result.m7232boximpl(objM5933requestChallengegIAlus);
    }
}
