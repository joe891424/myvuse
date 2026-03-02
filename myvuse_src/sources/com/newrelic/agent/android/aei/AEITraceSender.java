package com.newrelic.agent.android.aei;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.FileBackedPayload;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class AEITraceSender extends PayloadSender {
    static final String AEI_COLLECTOR_PATH = "/mobile/errors?protocol_version=1&platform=native&type=application_exit";
    static final int COLLECTOR_TIMEOUT = 5000;

    @Override // com.newrelic.agent.android.payload.PayloadSender
    public boolean shouldRetry() {
        return true;
    }

    public AEITraceSender(String str, AgentConfiguration agentConfiguration) {
        super(str.getBytes(), agentConfiguration);
        setPayload(str.getBytes());
    }

    public AEITraceSender(File file, AgentConfiguration agentConfiguration) {
        super(file.getAbsolutePath().getBytes(StandardCharsets.UTF_8), agentConfiguration);
        this.payload = new FileBackedPayload(file);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected HttpURLConnection getConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(getCollectorURI().toURL().openConnection()));
        HarvestConfiguration harvestConfiguration = Harvest.getHarvestConfiguration();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestProperty("Content-Encoding", "identity");
        httpURLConnection.setRequestProperty("Content-Type", Constants.Network.ContentType.JSON);
        httpURLConnection.setRequestProperty(Constants.Network.APPLICATION_LICENSE_HEADER, this.agentConfiguration.getApplicationToken());
        httpURLConnection.setRequestProperty(Constants.Network.ACCOUNT_ID_HEADER, harvestConfiguration.getAccount_id());
        httpURLConnection.setRequestProperty(Constants.Network.TRUSTED_ACCOUNT_ID_HEADER, harvestConfiguration.getTrusted_account_key());
        httpURLConnection.setRequestProperty(Constants.Network.ENTITY_GUID_HEADER, harvestConfiguration.getEntity_guid());
        httpURLConnection.setRequestProperty(Constants.Network.DEVICE_OS_NAME_HEADER, Agent.getDeviceInformation().getOsName());
        httpURLConnection.setRequestProperty(Constants.Network.APP_VERSION_HEADER, Agent.getApplicationInformation().getAppVersion());
        for (Map.Entry<String, String> entry : Harvest.getHarvestConfiguration().getRequest_headers_map().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.payload.PayloadSender, java.util.concurrent.Callable
    public PayloadSender call() {
        try {
            return super.call();
        } catch (Exception e) {
            onFailedUpload("Unable to report AEI trace to New Relic, will try again later. " + String.valueOf(e));
            return this;
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        super.onRequestResponse(httpURLConnection);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 202) {
            StatsEngine.SUPPORTABILITY.sampleTimeMs(MetricNames.SUPPORTABILITY_AEI_UPLOAD_TIME, this.timer.peek());
        } else if (responseCode == 413) {
            ((FileBackedPayload) this.payload).compress(true);
        }
        log.debug("AEITraceSender: data reporting took " + this.timer.toc() + "ms");
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onFailedUpload(String str) {
        log.error("AEITraceSender: " + str);
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_FAILED_UPLOAD);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onRequestException(Exception exc) {
        log.error("AEITraceSender: Crash upload failed: " + String.valueOf(exc));
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_FAILED_UPLOAD);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected boolean shouldUploadOpportunistically() {
        return Agent.hasReachableNetworkConnection(null);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected URI getCollectorURI() {
        return URI.create(getProtocol() + this.agentConfiguration.getCollectorHost() + AEI_COLLECTOR_PATH);
    }
}
