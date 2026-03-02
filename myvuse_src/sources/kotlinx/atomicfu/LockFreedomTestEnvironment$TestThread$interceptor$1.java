package kotlinx.atomicfu;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.LockFreedomTestEnvironment;

/* JADX INFO: compiled from: LockFreedomTestEnvironment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004H\u0016¨\u0006\u0007"}, m5598d2 = {"kotlinx/atomicfu/LockFreedomTestEnvironment$TestThread$interceptor$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
public final class LockFreedomTestEnvironment$TestThread$interceptor$1 extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    final /* synthetic */ LockFreedomTestEnvironment.TestThread this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockFreedomTestEnvironment$TestThread$interceptor$1(LockFreedomTestEnvironment.TestThread testThread, CoroutineContext.Key key) {
        super(key);
        this.this$0 = testThread;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) ContinuationInterceptor.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ContinuationInterceptor.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, continuation);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public <T> Continuation<T> interceptContinuation(final Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        final LockFreedomTestEnvironment$TestThread$interceptor$1 lockFreedomTestEnvironment$TestThread$interceptor$1 = this;
        return new Continuation<T>() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$TestThread$interceptor$1$interceptContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return lockFreedomTestEnvironment$TestThread$interceptor$1;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                LockFreedomTestEnvironment.TestThread testThread = this.this$0;
                Continuation continuation2 = continuation;
                if (continuation2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }
                testThread.resumeWith(result, continuation2);
            }
        };
    }
}
