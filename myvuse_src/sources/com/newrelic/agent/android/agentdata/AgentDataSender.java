package com.newrelic.agent.android.agentdata;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class AgentDataSender extends PayloadSender {
    public AgentDataSender(byte[] bArr, AgentConfiguration agentConfiguration) {
        super(bArr, agentConfiguration);
    }

    public AgentDataSender(Payload payload, AgentConfiguration agentConfiguration) {
        super(payload, agentConfiguration);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected HttpURLConnection getConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(getProtocol() + this.agentConfiguration.getHexCollectorHost() + this.agentConfiguration.getHexCollectorPath()).openConnection()));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppTokenHeader(), this.agentConfiguration.getApplicationToken());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getDeviceOsNameHeader(), Agent.getDeviceInformation().getOsName());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppVersionHeader(), Agent.getApplicationInformation().getAppVersion());
        httpURLConnection.setConnectTimeout(this.agentConfiguration.getHexCollectorTimeout());
        httpURLConnection.setReadTimeout(this.agentConfiguration.getHexCollectorTimeout());
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
    @Override // com.newrelic.agent.android.payload.PayloadSender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onRequestResponse(java.net.HttpURLConnection r6) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.agentdata.AgentDataSender.onRequestResponse(java.net.HttpURLConnection):void");
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected void onFailedUpload(String str) {
        log.error(str);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_FAILED_UPLOAD);
    }

    @Override // com.newrelic.agent.android.payload.PayloadSender
    protected boolean shouldUploadOpportunistically() {
        return PayloadController.shouldUploadOpportunistically();
    }
}
