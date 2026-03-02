package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class OkHttpInstrumentation {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static HttpURLConnection open(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) httpURLConnection);
        }
        if (httpURLConnection != null) {
            return new HttpURLConnectionExtension(httpURLConnection);
        }
        return null;
    }

    public static HttpURLConnection openWithProxy(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) httpURLConnection);
        }
        if (httpURLConnection != null) {
            return new HttpURLConnectionExtension(httpURLConnection);
        }
        return null;
    }

    public static HttpURLConnection urlFactoryOpen(HttpURLConnection httpURLConnection) {
        log.debug("OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open...");
        if (httpURLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) httpURLConnection);
        }
        if (httpURLConnection != null) {
            return new HttpURLConnectionExtension(httpURLConnection);
        }
        return null;
    }
}
