package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public final class URLConnectionInstrumentation {
    private URLConnectionInstrumentation() {
    }

    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        return uRLConnection instanceof HttpURLConnection ? new HttpURLConnectionExtension((HttpURLConnection) uRLConnection) : uRLConnection;
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        return uRLConnection instanceof HttpURLConnection ? new HttpURLConnectionExtension((HttpURLConnection) uRLConnection) : uRLConnection;
    }

    protected static void httpClientError(TransactionState transactionState, Exception exc) {
        if (transactionState.isComplete()) {
            return;
        }
        TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd != null) {
            transactionDataEnd.setResponseBody(exc.toString());
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
        }
    }
}
