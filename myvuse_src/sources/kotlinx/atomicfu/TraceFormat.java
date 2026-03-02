package kotlinx.atomicfu;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TraceFormat.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0017¨\u0006\b"}, m5598d2 = {"Lkotlinx/atomicfu/TraceFormat;", "", "()V", "format", "", FirebaseAnalytics.Param.INDEX, "", NotificationCompat.CATEGORY_EVENT, "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
public class TraceFormat {
    public String format(int index, Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return index + ": " + event;
    }
}
