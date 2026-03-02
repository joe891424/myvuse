package kotlinx.atomicfu;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lkotlinx/atomicfu/TraceFormatThread;", "Lkotlinx/atomicfu/TraceFormat;", "()V", "format", "", FirebaseAnalytics.Param.INDEX, "", NotificationCompat.CATEGORY_EVENT, "", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
final class TraceFormatThread extends TraceFormat {
    @Override // kotlinx.atomicfu.TraceFormat
    public String format(int index, Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        StringBuilder sbAppend = new StringBuilder().append(index).append(": [");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        return sbAppend.append(threadCurrentThread.getName()).append("] ").append(event).toString();
    }
}
