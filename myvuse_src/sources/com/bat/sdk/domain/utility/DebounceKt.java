package com.bat.sdk.domain.utility;

import androidx.exifinterface.media.ExifInterface;
import com.bat.sdk.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: debounce.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0001¨\u0006\n"}, m5598d2 = {"debounce", "Lkotlin/Function1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "param", "", "delayMillis", "", "function", "sdk_release"}, m5599k = 2, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class DebounceKt {
    public static /* synthetic */ Function1 debounce$default(long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3000;
        }
        return debounce(j, function1);
    }

    public static final <T> Function1<T, Unit> debounce(final long j, final Function1<? super T, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Object obj = new Object();
        return new Function1() { // from class: com.bat.sdk.domain.utility.DebounceKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DebounceKt.debounce$lambda$2(obj, objectRef, j, function, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Timer] */
    public static final Unit debounce$lambda$2(Object lock, Ref.ObjectRef timer, long j, final Function1 function, final Object obj) {
        Intrinsics.checkNotNullParameter(lock, "$lock");
        Intrinsics.checkNotNullParameter(timer, "$timer");
        Intrinsics.checkNotNullParameter(function, "$function");
        synchronized (lock) {
            Timer timer2 = (Timer) timer.element;
            if (timer2 != null) {
                timer2.cancel();
            }
            timer.element = new Timer();
            Timer timer3 = (Timer) timer.element;
            if (timer3 != null) {
                timer3.schedule(new TimerTask() { // from class: com.bat.sdk.domain.utility.DebounceKt$debounce$lambda$2$lambda$1$$inlined$schedule$1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Logger.INSTANCE.log("[time] rescheduled");
                        function.invoke(obj);
                    }
                }, j);
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
