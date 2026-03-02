package kotlinx.atomicfu;

import androidx.exifinterface.media.ExifInterface;
import com.salesforce.marketingcloud.UrlHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p004a.p007c.C0005a0;

/* JADX INFO: compiled from: AtomicFU.common.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a0\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a0\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, m5598d2 = {"atomicArrayOfNulls", "Lkotlinx/atomicfu/AtomicArray;", ExifInterface.GPS_DIRECTION_TRUE, "size", "", "getAndUpdate", "", "Lkotlinx/atomicfu/AtomicBoolean;", "function", "Lkotlin/Function1;", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "loop", "", UrlHandler.ACTION, "", "update", "updateAndGet", "atomicfu"}, m5599k = 2, m5600mv = {1, 4, 3})
public final class AtomicFU_commonKt {
    public static final <T> AtomicArray<T> atomicArrayOfNulls(int i) {
        return new AtomicArray<>(i);
    }

    public static final <T> Void loop(AtomicRef<T> loop, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(loop.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(AtomicRef<T> update, Function1<? super T, ? extends T> function) {
        C0005a0 c0005a0;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            c0005a0 = (Object) update.getValue();
        } while (!update.compareAndSet(c0005a0, function.invoke(c0005a0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T getAndUpdate(AtomicRef<T> getAndUpdate, Function1<? super T, ? extends T> function) {
        ?? r0;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            r0 = (Object) getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(r0, function.invoke(r0)));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T updateAndGet(AtomicRef<T> updateAndGet, Function1<? super T, ? extends T> function) {
        C0005a0 c0005a0;
        T tInvoke;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            c0005a0 = (Object) updateAndGet.getValue();
            tInvoke = function.invoke(c0005a0);
        } while (!updateAndGet.compareAndSet(c0005a0, tInvoke));
        return tInvoke;
    }

    public static final Void loop(AtomicBoolean loop, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Boolean.valueOf(loop.getValue()));
        }
    }

    public static final void update(AtomicBoolean update, Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
    }

    public static final boolean getAndUpdate(AtomicBoolean getAndUpdate, Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
        return value;
    }

    public static final boolean updateAndGet(AtomicBoolean updateAndGet, Function1<? super Boolean, Boolean> function) {
        boolean value;
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            zBooleanValue = function.invoke(Boolean.valueOf(value)).booleanValue();
        } while (!updateAndGet.compareAndSet(value, zBooleanValue));
        return zBooleanValue;
    }

    public static final Void loop(AtomicInt loop, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Integer.valueOf(loop.getValue()));
        }
    }

    public static final void update(AtomicInt update, Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
    }

    public static final int getAndUpdate(AtomicInt getAndUpdate, Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
        return value;
    }

    public static final int updateAndGet(AtomicInt updateAndGet, Function1<? super Integer, Integer> function) {
        int value;
        int iIntValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            iIntValue = function.invoke(Integer.valueOf(value)).intValue();
        } while (!updateAndGet.compareAndSet(value, iIntValue));
        return iIntValue;
    }

    public static final Void loop(AtomicLong loop, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Long.valueOf(loop.getValue()));
        }
    }

    public static final void update(AtomicLong update, Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
    }

    public static final long getAndUpdate(AtomicLong getAndUpdate, Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
        return value;
    }

    public static final long updateAndGet(AtomicLong updateAndGet, Function1<? super Long, Long> function) {
        long value;
        long jLongValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            jLongValue = function.invoke(Long.valueOf(value)).longValue();
        } while (!updateAndGet.compareAndSet(value, jLongValue));
        return jLongValue;
    }
}
