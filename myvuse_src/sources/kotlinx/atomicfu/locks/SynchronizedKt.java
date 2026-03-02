package kotlinx.atomicfu.locks;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: Synchronized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0087\b\u001a1\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00060\u0001j\u0002`\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\f*\n\u0010\r\"\u00020\u00012\u00020\u0001*\n\u0010\u000e\"\u00020\u00062\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, m5598d2 = {"reentrantLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "synchronized", ExifInterface.GPS_DIRECTION_TRUE, "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "SynchronizedObject", "atomicfu"}, m5599k = 2, m5600mv = {1, 4, 3})
public final class SynchronizedKt {
    private static final ReentrantLock reentrantLock() {
        return new ReentrantLock();
    }

    private static final <T> T withLock(ReentrantLock reentrantLock, Function0<? extends T> function0) {
        reentrantLock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    private static final <T> T m8723synchronized(Object obj, Function0<? extends T> function0) {
        T tInvoke;
        synchronized (obj) {
            try {
                tInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return tInvoke;
    }
}
