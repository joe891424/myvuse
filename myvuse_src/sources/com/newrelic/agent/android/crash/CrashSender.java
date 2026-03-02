package com.newrelic.agent.android.crash;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class CrashSender extends PayloadSender {
    private static final String CRASH_COLLECTOR_PATH = "/mobile_crash";
    public static final int CRASH_COLLECTOR_TIMEOUT = 5000;
    private final Crash crash;

    public CrashSender(Crash crash, AgentConfiguration agentConfiguration) {
        super(crash.toJsonString().getBytes(), agentConfiguration);
        this.crash = crash;
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected HttpURLConnection getConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(getCollectorURI().toURL().openConnection()));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", Constants.Network.ContentType.JSON);
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppTokenHeader(), this.agentConfiguration.getApplicationToken());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getDeviceOsNameHeader(), Agent.getDeviceInformation().getOsName());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppVersionHeader(), Agent.getApplicationInformation().getAppVersion());
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        return httpURLConnection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.payload.PayloadSender, java.util.concurrent.Callable
    public PayloadSender call() {
        setPayload(this.crash.toJsonString().getBytes());
        this.crash.incrementUploadCount();
        this.agentConfiguration.getCrashStore().store(this.crash);
        try {
            return super.call();
        } catch (Exception e) {
            onFailedUpload("Unable to report crash to New Relic, will try again later. " + String.valueOf(e));
            return this;
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 202) {
            StatsEngine.get().sampleTimeMs(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_TIME, this.timer.peek());
            log.info("CrashSender: Crash " + this.crash.getUuid().toString() + " successfully submitted.");
        } else if (responseCode == 408) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_TIMEOUT);
            onFailedUpload("The request to submit the payload [" + this.payload.getUuid() + "] has timed out - (will try again later) - Response code [" + responseCode + "]");
        } else if (responseCode == 429) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_THROTTLED);
            onFailedUpload("The request to submit the payload [" + this.payload.getUuid() + "] was has timed out - (will try again later) - Response code [" + responseCode + "]");
        } else if (responseCode == 500) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_REMOVED_REJECTED);
            onFailedUpload("The crash was rejected and will be deleted - Response code " + httpURLConnection.getResponseCode());
        } else {
            onFailedUpload("Something went wrong while submitting a crash (will try again later) - Response code " + httpURLConnection.getResponseCode());
        }
        log.debug("CrashSender: Crash collection took " + this.timer.toc() + "ms");
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onFailedUpload(String str) {
        log.error("CrashSender: " + str);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_FAILED_UPLOAD);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestException(Exception exc) {
        log.error("CrashSender: Crash upload failed: " + String.valueOf(exc));
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected boolean shouldUploadOpportunistically() {
        return Agent.hasReachableNetworkConnection(null);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected URI getCollectorURI() {
        return URI.create(getProtocol() + this.agentConfiguration.getCrashCollectorHost() + CRASH_COLLECTOR_PATH);
    }
}
