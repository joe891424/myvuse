package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.Streams;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PayloadSender implements Callable<PayloadSender> {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentConfiguration agentConfiguration;
    protected Payload payload;
    protected int responseCode;
    protected final TicToc timer;

    public interface CompletionHandler {
        default void onException(PayloadSender payloadSender, Exception exc) {
        }

        default void onResponse(PayloadSender payloadSender) {
        }
    }

    protected abstract HttpURLConnection getConnection() throws IOException;

    protected void onRequestContent(String str) {
    }

    public boolean shouldRetry() {
        return false;
    }

    public PayloadSender(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
        this.timer = new TicToc().tic();
        this.responseCode = 0;
    }

    public PayloadSender(Payload payload, AgentConfiguration agentConfiguration) {
        this(agentConfiguration);
        this.payload = payload;
    }

    public PayloadSender(byte[] bArr, AgentConfiguration agentConfiguration) {
        this(agentConfiguration);
        this.payload = new Payload(bArr);
    }

    public Payload getPayload() {
        return this.payload;
    }

    public int getPayloadSize() {
        return this.payload.getBytes().length;
    }

    public void setPayload(byte[] bArr) {
        this.payload.putBytes(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onRequestResponse(java.net.HttpURLConnection r6) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.payload.PayloadSender.onRequestResponse(java.net.HttpURLConnection):void");
    }

    protected void onRequestException(Exception exc) {
        onFailedUpload("Payload [" + this.payload.getUuid() + "] upload failed: " + String.valueOf(exc));
    }

    protected void onFailedUpload(String str) {
        log.error(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PayloadSender call() throws Exception {
        try {
            byte[] bytes = getPayload().getBytes();
            HttpURLConnection connection = getConnection();
            try {
                try {
                    this.timer.tic();
                    connection.connect();
                    if (connection.getDoOutput()) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(connection.getOutputStream());
                        try {
                            bufferedOutputStream.write(bytes);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    this.responseCode = connection.getResponseCode();
                    onRequestResponse(connection);
                } catch (Exception e) {
                    onRequestException(e);
                }
                return this;
            } finally {
                connection.disconnect();
            }
        } catch (Exception e2) {
            onFailedUpload("Unable to upload payload [" + this.payload.getUuid() + "]  to New Relic, will try again later. " + String.valueOf(e2));
            return this;
        }
    }

    protected String getProtocol() {
        return "https://";
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    protected String readStream(InputStream inputStream, int i) throws IOException {
        String strSlurpString = Streams.slurpString(inputStream, StandardCharsets.UTF_8.toString());
        if (i < strSlurpString.length()) {
            strSlurpString.substring(0, i);
        }
        return strSlurpString;
    }

    public boolean isSuccessfulResponse() {
        int i = this.responseCode;
        return i == 200 || i == 202 || i == 500;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof PayloadSender) && getPayload() == ((PayloadSender) obj).getPayload();
    }

    protected boolean shouldUploadOpportunistically() {
        return Agent.hasReachableNetworkConnection(null);
    }

    protected URI getCollectorURI() {
        return URI.create(getProtocol() + this.agentConfiguration.getCollectorHost());
    }
}
