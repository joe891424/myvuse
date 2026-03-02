package com.facetec.sdk;

import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facetec.sdk.au */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractAsyncTaskC2155au extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
    protected Context Code;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: B */
    abstract void mo1563B();

    /* JADX INFO: renamed from: Z */
    protected void mo1564Z() {
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ Void doInBackground(Void[] voidArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "au#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "au#doInBackground", null);
        }
        Void voidM1617V = m1617V();
        TraceMachine.exitMethod();
        return voidM1617V;
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Void r3) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "au#onPostExecute", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "au#onPostExecute", null);
        }
        Code();
        TraceMachine.exitMethod();
    }

    AbstractAsyncTaskC2155au(Context context) {
        this.Code = null;
        if (context != null) {
            this.Code = context.getApplicationContext();
        }
    }

    /* JADX INFO: renamed from: V */
    protected final Void m1617V() {
        try {
            mo1563B();
            return null;
        } catch (Throwable th) {
            C2121D.Code(th);
            return null;
        }
    }

    protected final void Code() {
        try {
            mo1564Z();
        } catch (Throwable th) {
            C2121D.Code(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facetec.sdk.au$4] */
    /* JADX INFO: renamed from: B */
    static void m1615B(final Runnable runnable) {
        ?? r0 = new AbstractAsyncTaskC2155au(null) { // from class: com.facetec.sdk.au.4
            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au, android.os.AsyncTask
            protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
                return super.m1617V();
            }

            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au, android.os.AsyncTask
            protected final /* synthetic */ void onPostExecute(Void r1) {
                super.Code();
            }

            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
            /* JADX INFO: renamed from: B */
            final void mo1563B() {
                runnable.run();
            }
        };
        Executor executor = AsyncTask.SERIAL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, executor, voidArr);
        } else {
            r0.executeOnExecutor(executor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facetec.sdk.au$5] */
    /* JADX INFO: renamed from: Z */
    static void m1616Z(final Runnable runnable) {
        ?? r0 = new AbstractAsyncTaskC2155au(null) { // from class: com.facetec.sdk.au.5
            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au, android.os.AsyncTask
            protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
                return super.m1617V();
            }

            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au, android.os.AsyncTask
            protected final /* synthetic */ void onPostExecute(Void r1) {
                super.Code();
            }

            @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
            /* JADX INFO: renamed from: B */
            final void mo1563B() {
                runnable.run();
            }
        };
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, executor, voidArr);
        } else {
            r0.executeOnExecutor(executor, voidArr);
        }
    }
}
