package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.p045io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.p045io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.p045io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes6.dex */
public class HttpsURLConnectionExtension extends HttpsURLConnection {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private CountingInputStream errorStream;
    private final HttpsURLConnection impl;
    private TransactionState transactionState;

    public HttpsURLConnectionExtension(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.errorStream = null;
        this.impl = httpsURLConnection;
        this.transactionState = getTransactionState();
        TransactionStateUtil.setCrossProcessHeader(httpsURLConnection);
        TransactionStateUtil.setTrace(this.transactionState);
        TransactionStateUtil.setDistributedTraceHeaders(this.transactionState, httpsURLConnection);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.impl.getCipherSuite();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.impl.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.impl.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.impl.addRequestProperty(str, str2);
        TransactionStateUtil.addHeadersAsCustomAttribute(this.transactionState, str, str2);
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        TransactionState transactionState = this.transactionState;
        if (transactionState != null && !transactionState.isComplete()) {
            addTransactionAndErrorData(this.transactionState);
        }
        this.impl.disconnect();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.impl.usingProxy();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getTransactionState();
        try {
            this.impl.connect();
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.impl.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.impl.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        getTransactionState();
        try {
            Object content = this.impl.getContent();
            int contentLength = this.impl.getContentLength();
            if (contentLength >= 0) {
                TransactionState transactionState = getTransactionState();
                if (!transactionState.isComplete()) {
                    transactionState.setBytesReceived(contentLength);
                    addTransactionAndErrorData(transactionState);
                }
            }
            return content;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        getTransactionState();
        try {
            Object content = this.impl.getContent(clsArr);
            checkResponse();
            return content;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        getTransactionState();
        String contentEncoding = this.impl.getContentEncoding();
        checkResponse();
        return contentEncoding;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        getTransactionState();
        int contentLength = this.impl.getContentLength();
        checkResponse();
        return contentLength;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        getTransactionState();
        String contentType = this.impl.getContentType();
        checkResponse();
        return contentType;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        getTransactionState();
        long date = this.impl.getDate();
        checkResponse();
        return date;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getTransactionState();
        try {
            CountingInputStream countingInputStream = this.errorStream;
            if (countingInputStream == null || countingInputStream.available() == 0) {
                if (this.impl.getErrorStream() != null) {
                    this.errorStream = new CountingInputStream(this.impl.getErrorStream(), true);
                } else {
                    log.debug("HttpsURLConnectionExtension: error stream implementation is null");
                    return this.impl.getErrorStream();
                }
            }
            return this.errorStream;
        } catch (Exception e) {
            log.error("HttpsURLConnectionExtension: " + String.valueOf(e));
            return this.impl.getErrorStream();
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        getTransactionState();
        long headerFieldDate = this.impl.getHeaderFieldDate(str, j);
        checkResponse();
        return headerFieldDate;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.impl.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.impl.getPermission();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.impl.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getTransactionState();
        try {
            int responseCode = this.impl.getResponseCode();
            checkResponse();
            return responseCode;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getTransactionState();
        try {
            String responseMessage = this.impl.getResponseMessage();
            checkResponse();
            return responseMessage;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.impl.setChunkedStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.impl.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.impl.setInstanceFollowRedirects(z);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        try {
            this.impl.setRequestMethod(str);
        } catch (ProtocolException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.impl.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.impl.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.impl.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        getTransactionState();
        long expiration = this.impl.getExpiration();
        checkResponse();
        return expiration;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i) {
        getTransactionState();
        String headerField = this.impl.getHeaderField(i);
        checkResponse();
        return headerField;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        getTransactionState();
        String headerField = this.impl.getHeaderField(str);
        checkResponse();
        return headerField;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        getTransactionState();
        int headerFieldInt = this.impl.getHeaderFieldInt(str, i);
        checkResponse();
        return headerFieldInt;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i) {
        getTransactionState();
        String headerFieldKey = this.impl.getHeaderFieldKey(i);
        checkResponse();
        return headerFieldKey;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getTransactionState();
        Map<String, List<String>> headerFields = this.impl.getHeaderFields();
        checkResponse();
        return headerFields;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        getTransactionState();
        long ifModifiedSince = this.impl.getIfModifiedSince();
        checkResponse();
        return ifModifiedSince;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        final TransactionState transactionState = getTransactionState();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.impl.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(transactionState, this.impl);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() { // from class: com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension.1
                @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState.isComplete()) {
                        transactionState.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.error(streamCompleteEvent.getException());
                }

                @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (transactionState.isComplete()) {
                        return;
                    }
                    try {
                        transactionState.setStatusCode(HttpsURLConnectionExtension.this.impl.getResponseCode());
                    } catch (IOException unused) {
                        HttpsURLConnectionExtension.log.error("HttpsURLConnectionExtension.getInputStream.streamComplete: " + String.valueOf(streamCompleteEvent));
                    }
                    long contentLength = HttpsURLConnectionExtension.this.impl.getContentLength();
                    long bytes = streamCompleteEvent.getBytes();
                    if (contentLength < 0) {
                        contentLength = bytes;
                    }
                    transactionState.setBytesReceived(contentLength);
                    HttpsURLConnectionExtension.this.addTransactionAndErrorData(transactionState);
                }
            });
            return countingInputStream;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        getTransactionState();
        long lastModified = this.impl.getLastModified();
        checkResponse();
        return lastModified;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        final TransactionState transactionState = getTransactionState();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.impl.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() { // from class: com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension.2
                @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState.isComplete()) {
                        transactionState.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.error(streamCompleteEvent.getException());
                }

                @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (transactionState.isComplete()) {
                        return;
                    }
                    try {
                        transactionState.setStatusCode(HttpsURLConnectionExtension.this.impl.getResponseCode());
                    } catch (IOException unused) {
                        HttpsURLConnectionExtension.log.error("HttpsURLConnectionExtension.getOutputStream.streamComplete: " + String.valueOf(streamCompleteEvent));
                    }
                    String requestProperty = HttpsURLConnectionExtension.this.impl.getRequestProperty("Content-Length");
                    long bytes = streamCompleteEvent.getBytes();
                    if (requestProperty != null) {
                        try {
                            bytes = Long.parseLong(requestProperty);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    transactionState.setBytesSent(bytes);
                    HttpsURLConnectionExtension.this.addTransactionAndErrorData(transactionState);
                }
            });
            return countingOutputStream;
        } catch (IOException e) {
            error(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.impl.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.impl.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.impl.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.impl.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.impl.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        this.impl.setAllowUserInteraction(z);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.impl.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.impl.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        this.impl.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.impl.setDoOutput(z);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        this.impl.setIfModifiedSince(j);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.impl.setReadTimeout(i);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.impl.setRequestProperty(str, str2);
        TransactionStateUtil.addHeadersAsCustomAttribute(this.transactionState, str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.impl.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.impl.toString();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.impl.getPeerPrincipal();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.impl.getLocalPrincipal();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.impl.setHostnameVerifier(hostnameVerifier);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.impl.getHostnameVerifier();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.impl.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.impl.getSSLSocketFactory();
    }

    private void checkResponse() {
        if (getTransactionState().isComplete()) {
            return;
        }
        TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
    }

    TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        TransactionStateUtil.inspectAndInstrument(this.transactionState, this.impl);
        return this.transactionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void error(Exception exc) {
        TransactionState transactionState = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
        if (transactionState.isComplete()) {
            return;
        }
        TransactionStateUtil.inspectAndInstrumentResponse(transactionState, this.impl);
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd != null) {
            String string = exc.toString();
            try {
                InputStream errorStream = getErrorStream();
                if (errorStream != null && (errorStream instanceof CountingInputStream)) {
                    string = ((CountingInputStream) errorStream).getBufferAsString();
                }
            } catch (Exception e) {
                log.error("HttpsURLConnectionExtension.error: " + String.valueOf(e));
            }
            transactionDataEnd.setResponseBody(string);
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTransactionAndErrorData(TransactionState transactionState) {
        String bufferAsString;
        InputStream errorStream;
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd == null) {
            return;
        }
        if (transactionState.isErrorOrFailure()) {
            try {
                errorStream = getErrorStream();
            } catch (Exception e) {
                log.error("HttpsURLConnectionExtension.addTransactionAndErrorData: " + String.valueOf(e));
            }
            if (errorStream == null || !(errorStream instanceof CountingInputStream)) {
                bufferAsString = "";
            } else {
                bufferAsString = ((CountingInputStream) errorStream).getBufferAsString();
            }
            TreeMap treeMap = new TreeMap();
            String contentType = this.impl.getContentType();
            if (contentType != null && !"".equals(contentType)) {
                treeMap.put("content_type", contentType);
            }
            treeMap.put(Constants.Transactions.CONTENT_LENGTH, new StringBuilder().append(transactionState.getBytesReceived()).toString());
            transactionDataEnd.setResponseBody(bufferAsString);
            transactionDataEnd.getParams().putAll(treeMap);
        }
        TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
    }
}
