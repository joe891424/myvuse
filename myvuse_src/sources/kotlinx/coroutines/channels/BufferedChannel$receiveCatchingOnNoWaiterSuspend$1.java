package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "kotlinx.coroutines.channels.BufferedChannel", m5608f = "BufferedChannel.kt", m5609i = {0, 0, 0, 0}, m5610l = {3056}, m5611m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m5612n = {"this", "segment", FirebaseAnalytics.Param.INDEX, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME}, m5613s = {"L$0", "L$1", "I$0", "J$0"})
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM8740receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m8740receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM8740receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM8740receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m8747boximpl(objM8740receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
