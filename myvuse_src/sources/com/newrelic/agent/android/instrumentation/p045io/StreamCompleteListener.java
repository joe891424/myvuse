package com.newrelic.agent.android.instrumentation.p045io;

/* JADX INFO: loaded from: classes6.dex */
public interface StreamCompleteListener {
    void streamComplete(StreamCompleteEvent streamCompleteEvent);

    void streamError(StreamCompleteEvent streamCompleteEvent);
}
