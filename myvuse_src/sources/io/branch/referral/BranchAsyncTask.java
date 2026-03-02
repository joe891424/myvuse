package io.branch.referral;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BranchAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements TraceFieldInterface {
    public Trace _nr_trace;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public final AsyncTask<Params, Progress, Result> executeTask(Params... paramsArr) {
        try {
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            return !(this instanceof AsyncTask) ? executeOnExecutor(executor, paramsArr) : AsyncTaskInstrumentation.executeOnExecutor(this, executor, paramsArr);
        } catch (Exception unused) {
            return !(this instanceof AsyncTask) ? execute(paramsArr) : AsyncTaskInstrumentation.execute(this, paramsArr);
        }
    }
}
