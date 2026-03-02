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
import okhttp3.Response;

/* JADX INFO: loaded from: classes6.dex */
public class CallbackExtension implements Callback {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private CallExtension callExtension;
    private Callback impl;
    private TransactionState transactionState;

    public CallbackExtension(Callback callback, TransactionState transactionState, CallExtension callExtension) {
        this.impl = callback;
        this.transactionState = transactionState;
        this.callExtension = callExtension;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        error(iOException);
        this.impl.onFailure(this.callExtension, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        this.impl.onResponse(this.callExtension, checkResponse(response));
    }

    private Response checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return response;
        }
        log.debug("CallbackExtension.checkResponse() - transaction is not complete.  Inspecting and instrumenting response.");
        return OkHttp3TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
    }

    protected TransactionState getTransactionState() {
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
