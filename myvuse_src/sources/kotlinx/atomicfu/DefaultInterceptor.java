package kotlinx.atomicfu;

import kotlin.Metadata;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m5598d2 = {"Lkotlinx/atomicfu/DefaultInterceptor;", "Lkotlinx/atomicfu/AtomicOperationInterceptor;", "()V", "toString", "", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
final class DefaultInterceptor extends AtomicOperationInterceptor {
    public static final DefaultInterceptor INSTANCE = new DefaultInterceptor();

    private DefaultInterceptor() {
    }

    public String toString() {
        return "DefaultInterceptor";
    }
}
