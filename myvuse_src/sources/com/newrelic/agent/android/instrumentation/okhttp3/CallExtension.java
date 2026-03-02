package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
public class CallExtension implements Call {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private OkHttpClient client;
    Call impl;
    Request request;
    private TransactionState transactionState;

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return false;
    }

    CallExtension(OkHttpClient okHttpClient, Request request, Call call, TransactionState transactionState) {
        this.client = okHttpClient;
        this.request = request;
        this.impl = call;
        this.transactionState = transactionState;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.impl.request();
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        getTransactionState();
        try {
            return checkResponse(this.impl.execute());
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        getTransactionState();
        this.impl.enqueue(new CallbackExtension(callback, this.transactionState, this));
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.impl.cancel();
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: isCanceled */
    public boolean getCanceled() {
        return this.impl.getCanceled();
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.impl.timeout();
    }

    @Override // okhttp3.Call
    public Call clone() {
        return this.impl.clone();
    }

    private Response checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return response;
        }
        if (response.request() != null) {
            OkHttp3TransactionStateUtil.inspectAndInstrument(this.transactionState, response.request());
        }
        return OkHttp3TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
    }

    protected TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        OkHttp3TransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
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

    public Call getImpl() {
        return this.impl;
    }
}
