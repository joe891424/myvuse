package com.google.firebase.perf.util;

import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class URLWrapper {
    private final URL url;

    public URLWrapper(URL url) {
        this.url = url;
    }

    public URLConnection openConnection() throws IOException {
        return URLConnectionInstrumentation.openConnection(this.url.openConnection());
    }

    public String toString() {
        return this.url.toString();
    }
}
