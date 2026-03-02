package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

/* JADX INFO: loaded from: classes6.dex */
public class ClientExtension implements Client {
    private Client impl;
    private Request request;
    private TransactionState transactionState;

    public ClientExtension(Client client) {
        this.impl = client;
    }

    public Response execute(Request request) throws IOException {
        this.request = request;
        this.transactionState = getTransactionState();
        Request crossProcessHeaders = setCrossProcessHeaders(request);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            this.transactionState.setTrace(DistributedTracing.getInstance().startTrace(this.transactionState));
            crossProcessHeaders = RetrofitTransactionStateUtil.setDistributedTraceHeaders(this.transactionState, crossProcessHeaders);
        }
        try {
            Response responseExecute = this.impl.execute(crossProcessHeaders);
            Response response = new Response(responseExecute.getUrl(), responseExecute.getStatus(), responseExecute.getReason(), responseExecute.getHeaders(), new ContentBufferingTypedInput(responseExecute.getBody()));
            checkResponse(response);
            return response;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    private Request setCrossProcessHeaders(Request request) {
        String crossProcessId = Agent.getCrossProcessId();
        ArrayList arrayList = new ArrayList(request.getHeaders());
        if (crossProcessId != null) {
            arrayList.add(new Header(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId));
        }
        return new Request(request.getMethod(), request.getUrl(), arrayList, request.getBody());
    }

    private void checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return;
        }
        RetrofitTransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
    }

    protected TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        RetrofitTransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
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

    void setRequest(Request request) {
        this.request = request;
    }
}
