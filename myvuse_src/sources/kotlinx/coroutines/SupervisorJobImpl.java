package kotlinx.coroutines;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;

/* JADX INFO: compiled from: Supervisor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lkotlinx/coroutines/SupervisorJobImpl;", "Lkotlinx/coroutines/JobImpl;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "childCancelled", "", HexAttribute.HEX_ATTR_CAUSE, "", "kotlinx-coroutines-core"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
final class SupervisorJobImpl extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public boolean childCancelled(Throwable cause) {
        return false;
    }

    public SupervisorJobImpl(Job job) {
        super(job);
    }
}
