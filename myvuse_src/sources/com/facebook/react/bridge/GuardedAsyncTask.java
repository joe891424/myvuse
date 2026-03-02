package com.facebook.react.bridge;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void> implements TraceFieldInterface {
    public Trace _nr_trace;
    private final JSExceptionHandler mExceptionHandler;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    protected abstract void doInBackgroundGuarded(Params... paramsArr);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GuardedAsyncTask#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "GuardedAsyncTask#doInBackground", null);
        }
        Void voidDoInBackground2 = doInBackground2(objArr);
        TraceMachine.exitMethod();
        return voidDoInBackground2;
    }

    protected GuardedAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedAsyncTask(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected final Void doInBackground2(Params... paramsArr) {
        try {
            doInBackgroundGuarded(paramsArr);
            return null;
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
            return null;
        }
    }
}
