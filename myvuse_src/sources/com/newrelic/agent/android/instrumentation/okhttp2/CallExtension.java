package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class CallExtension extends Call {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private OkHttpClient client;
    Call impl;
    Request request;
    private TransactionState transactionState;

    CallExtension(OkHttpClient okHttpClient, Request request, Call call, TransactionState transactionState) {
        super(okHttpClient, request);
        this.client = okHttpClient;
        this.request = request;
        this.impl = call;
        this.transactionState = transactionState;
    }

    public Response execute() throws IOException {
        getTransactionState();
        try {
            return checkResponse(this.impl.execute());
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    public void enqueue(Callback callback) {
        getTransactionState();
        this.impl.enqueue(new CallbackExtension(callback, this.transactionState));
    }

    public void cancel() {
        this.impl.cancel();
    }

    public boolean isCanceled() {
        return this.impl.isCanceled();
    }

    private Response checkResponse(Response response) {
        if (!getTransactionState().isComplete()) {
            response = OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
            if (response.request() != null) {
                OkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, response.request());
            }
        }
        return response;
    }

    protected TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        OkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
        return this.transactionState;
    }

    protected void error(Exception exc) {
        TransactionData transactionDataEnd;
        TransactionState transactionState = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
        if (transactionState.isComplete() || (transactionDataEnd = transactionState.end()) == null) {
            return;
        }
        transactionDataEnd.setResponseBody(exc.toString());
        TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
    }
}
