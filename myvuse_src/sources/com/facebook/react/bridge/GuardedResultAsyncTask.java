package com.facebook.react.bridge;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result> implements TraceFieldInterface {
    public Trace _nr_trace;
    private final JSExceptionHandler mExceptionHandler;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    protected abstract Result doInBackgroundGuarded();

    protected abstract void onPostExecuteGuarded(Result result);

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GuardedResultAsyncTask#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "GuardedResultAsyncTask#doInBackground", null);
        }
        Result resultDoInBackground2 = doInBackground2(voidArr);
        TraceMachine.exitMethod();
        return resultDoInBackground2;
    }

    protected GuardedResultAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedResultAsyncTask(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected final Result doInBackground2(Void... voidArr) {
        try {
            return doInBackgroundGuarded();
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
            throw e;
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Result result) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GuardedResultAsyncTask#onPostExecute", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "GuardedResultAsyncTask#onPostExecute", null);
        }
        try {
            onPostExecuteGuarded(result);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
        TraceMachine.exitMethod();
    }
}
