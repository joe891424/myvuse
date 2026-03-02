package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e) {
                LogInstrumentation.m2735w("ResultCallbacks", "Unable to release ".concat(String.valueOf(String.valueOf(r))), e);
            }
        }
    }

    public abstract void onSuccess(R r);
}
