package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lkotlinx/coroutines/tasks/DirectExecutor;", "Ljava/util/concurrent/Executor;", "()V", "execute", "", RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME, "Ljava/lang/Runnable;", "kotlinx-coroutines-play-services"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
final class DirectExecutor implements Executor {
    public static final DirectExecutor INSTANCE = new DirectExecutor();

    private DirectExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r) {
        r.run();
    }
}
