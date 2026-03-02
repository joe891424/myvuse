package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import kotlin.Metadata;

/* JADX INFO: compiled from: LifecycleRegistry.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001¨\u0006\u0002"}, m5598d2 = {"isMainThread", "", "lifecycle-runtime_release"}, m5599k = 2, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class LifecycleRegistry_androidKt {
    public static final boolean isMainThread() {
        return ArchTaskExecutor.getInstance().isMainThread();
    }
}
