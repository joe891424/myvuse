package com.bat.sdk;

import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.BleDeviceData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BatSdk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$5$1", m5608f = "BatSdk.kt", m5609i = {0, 0, 0}, m5610l = {447}, m5611m = "emit", m5612n = {"this", "it", "actualDeviceTime"}, m5613s = {"L$0", "L$1", "L$2"})
final class BatSdk$initialize$5$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BatSdk.C14815.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BatSdk$initialize$5$1$emit$1(BatSdk.C14815.AnonymousClass1<? super T> anonymousClass1, Continuation<? super BatSdk$initialize$5$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((BleDeviceData) null, (Continuation<? super Unit>) this);
    }
}
