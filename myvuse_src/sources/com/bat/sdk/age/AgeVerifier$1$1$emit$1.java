package com.bat.sdk.age;

import com.bat.sdk.age.AgeVerifier;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.model.AgeChallenge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AgeVerifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.age.AgeVerifier$1$1", m5608f = "AgeVerifier.kt", m5609i = {0, 0}, m5610l = {44}, m5611m = "emit", m5612n = {"this", "ageChallenge"}, m5613s = {"L$0", "L$1"})
final class AgeVerifier$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgeVerifier.C14841.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AgeVerifier$1$1$emit$1(AgeVerifier.C14841.AnonymousClass1<? super T> anonymousClass1, Continuation<? super AgeVerifier$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((CharacteristicClient<Unit, AgeChallenge>.Response) null, (Continuation<? super Unit>) this);
    }
}
