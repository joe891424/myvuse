package io.ktor.utils.p098io.jvm.javaio;

import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
@DebugMetadata(m5607c = "io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1", m5608f = "Blocking.kt", m5609i = {0, 0, 1}, m5610l = {312, ISO7816Kt.SW1_WARNING_CHANGED}, m5611m = "loop", m5612n = {"this", "this_$iv", "this"}, m5613s = {"L$0", "L$1", "L$0"})
final class OutputAdapter$loop$1$loop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutputAdapter$loop$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1$loop$1(OutputAdapter$loop$1 outputAdapter$loop$1, Continuation<? super OutputAdapter$loop$1$loop$1> continuation) {
        super(continuation);
        this.this$0 = outputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loop(this);
    }
}
