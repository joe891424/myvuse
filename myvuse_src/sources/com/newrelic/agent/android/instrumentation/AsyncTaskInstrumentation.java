package com.newrelic.agent.android.instrumentation;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class AsyncTaskInstrumentation {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    protected AsyncTaskInstrumentation() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Params, Progress, Result> AsyncTask execute(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        try {
            ((TraceFieldInterface) asyncTask)._nr_setTrace(TraceMachine.getCurrentTrace());
        } catch (TracingInactiveException | NoSuchFieldError unused) {
        } catch (ClassCastException e) {
            ExceptionHelper.recordSupportabilityMetric(e, "TraceFieldInterface");
            log.error("Not a TraceFieldInterface: " + e.getMessage());
        }
        return asyncTask.execute(paramsArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Params, Progress, Result> AsyncTask executeOnExecutor(AsyncTask<Params, Progress, Result> asyncTask, Executor executor, Params... paramsArr) {
        try {
            ((TraceFieldInterface) asyncTask)._nr_setTrace(TraceMachine.getCurrentTrace());
        } catch (TracingInactiveException | NoSuchFieldError unused) {
        } catch (ClassCastException e) {
            ExceptionHelper.recordSupportabilityMetric(e, "TraceFieldInterface");
            log.error("Not a TraceFieldInterface: " + e.getMessage());
        }
        return asyncTask.executeOnExecutor(executor, paramsArr);
    }
}
