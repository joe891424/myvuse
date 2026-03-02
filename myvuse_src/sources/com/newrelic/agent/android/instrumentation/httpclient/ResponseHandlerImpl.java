package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.instrumentation.ApacheInstrumentation;
import com.newrelic.agent.android.instrumentation.TransactionState;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class ResponseHandlerImpl<T> implements ResponseHandler<T> {
    private final ResponseHandler<T> impl;
    private final TransactionState transactionState;

    private ResponseHandlerImpl(ResponseHandler<T> responseHandler, TransactionState transactionState) {
        this.impl = responseHandler;
        this.transactionState = transactionState;
    }

    @Override // org.apache.http.client.ResponseHandler
    public T handleResponse(HttpResponse httpResponse) throws IOException {
        ApacheInstrumentation.inspectAndInstrument(this.transactionState, httpResponse);
        return this.impl.handleResponse(httpResponse);
    }

    public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> responseHandler, TransactionState transactionState) {
        return new ResponseHandlerImpl(responseHandler, transactionState);
    }
}
