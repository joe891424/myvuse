package com.newrelic.agent.android.logging;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.FileBackedPayload;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URI;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class LogForwarder extends PayloadSender {
    @Override // com.newrelic.agent.android.payload.PayloadSender
    public boolean shouldRetry() {
        return true;
    }

    public LogForwarder(File file, AgentConfiguration agentConfiguration) throws IOException {
        super(agentConfiguration);
        FileBackedPayload fileBackedPayload = new FileBackedPayload(file);
        fileBackedPayload.compress(true);
        this.payload = fileBackedPayload;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.payload.PayloadSender, java.util.concurrent.Callable
    public PayloadSender call() throws Exception {
        if (shouldUploadOpportunistically()) {
            this.timer.tic();
            return super.call();
        }
        log.warn("LogForwarder: endpoint is not reachable. Will try later...");
        return this;
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected HttpURLConnection getConnection() throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(getCollectorURI().toURL().openConnection()));
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", Constants.Network.ContentType.JSON);
        httpsURLConnection.setRequestProperty("Content-Encoding", Constants.Network.Encoding.GZIP);
        httpsURLConnection.setRequestProperty(Constants.Network.APPLICATION_LICENSE_HEADER, this.agentConfiguration.getApplicationToken());
        httpsURLConnection.setConnectTimeout((int) TimeUnit.MILLISECONDS.convert(10L, TimeUnit.SECONDS));
        httpsURLConnection.setReadTimeout((int) TimeUnit.MILLISECONDS.convert(10L, TimeUnit.SECONDS));
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        return httpsURLConnection;
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 202) {
            StatsEngine.SUPPORTABILITY.sampleTimeMs(MetricNames.SUPPORTABILITY_LOG_UPLOAD_TIME, this.timer.duration());
            log.debug("LogForwarder: Log data forwarding took " + this.timer.duration() + "ms");
            int payloadSize = getPayloadSize();
            StatsEngine.SUPPORTABILITY.sample(MetricNames.SUPPORTABILITY_LOG_UNCOMPRESSED, payloadSize);
            log.info("LogForwarder: [" + payloadSize + "] bytes successfully submitted.");
        } else if (responseCode == 408) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_UPLOAD_TIMEOUT);
            onFailedUpload("The request to submit the log data payload has timed out - (will try again later) - Response code [" + this.responseCode + "]");
        } else if (responseCode == 413) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_UPLOAD_REJECTED);
            onFailedUpload("The request was rejected due to payload size limits - Response code [" + this.responseCode + "]");
        } else if (responseCode == 429) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_UPLOAD_THROTTLED);
            onFailedUpload("Log upload requests have been throttled (will try again later) - Response code [" + this.responseCode + "]");
        } else if (responseCode == 500) {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_REMOVED_REJECTED);
            onFailedUpload("The log data was rejected and will be deleted - Response code " + httpURLConnection.getResponseCode());
        } else {
            onFailedUpload("Something went wrong while forwarding (will try again later) - Response code " + httpURLConnection.getResponseCode());
        }
        log.debug("Payload [" + this.payload.getUuid() + "] delivery took " + this.timer.duration() + "ms");
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onFailedUpload(String str) {
        log.error("LogForwarder: " + str);
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_FAILED_UPLOAD);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestException(Exception exc) {
        onFailedUpload(exc.toString());
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected boolean shouldUploadOpportunistically() {
        try {
            String host = getCollectorURI().toURL().getHost();
            return host.equals(InetAddress.getByName(host).getHostName());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected URI getCollectorURI() {
        return URI.create(getProtocol() + this.agentConfiguration.getCollectorHost() + "/mobile/logs");
    }
}
