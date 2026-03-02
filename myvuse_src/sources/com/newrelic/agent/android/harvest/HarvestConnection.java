package com.newrelic.agent.android.harvest;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.Deflator;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestConnection implements HarvestErrorCodes, HarvestConfigurable {
    protected static final String COLLECTOR_CONNECT_URI = "/mobile/v5/connect";
    protected static final String COLLECTOR_DATA_URI = "/mobile/v3/data";
    private static final int MAX_PLAINTEXT_MESSAGE_SIZE = 512;
    private static final int READ_TIMEOUT_IN_SECONDS = 4;
    private static final int RESPONSE_BUFFER_SIZE = 8192;
    private static final int TIMEOUT_IN_SECONDS = 20;
    private String applicationToken;
    private String collectorHost;
    private ConnectInformation connectInformation;
    private long serverTimestamp;
    protected static final int CONNECTION_TIMEOUT = (int) TimeUnit.MILLISECONDS.convert(20, TimeUnit.SECONDS);
    protected static final int READ_TIMEOUT = (int) TimeUnit.MILLISECONDS.convert(4, TimeUnit.SECONDS);
    private final AgentLog log = AgentLogManager.getAgentLog();
    private boolean useSsl = true;
    protected Map<String, String> requestHeaders = new HashMap();

    public HttpURLConnection createPost(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(READ_TIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty(Constants.Network.APPLICATION_LICENSE_HEADER, this.applicationToken);
            httpURLConnection.setRequestProperty("Content-Type", Constants.Network.ContentType.JSON);
            String property = System.getProperty("http.agent");
            if (property != null && property.length() > 0) {
                httpURLConnection.setRequestProperty("User-Agent", property);
            }
            long j = this.serverTimestamp;
            if (j != 0) {
                httpURLConnection.setRequestProperty(Constants.Network.CONNECT_TIME_HEADER, Long.valueOf(j).toString());
            }
            for (Map.Entry<String, String> entry : this.requestHeaders.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        } catch (Exception e3) {
            e = e3;
            StatsEngine.get().inc("Supportability/AgentHealth/Collector/Connection/Errors");
            this.log.error("Failed to create data POST: " + e.getMessage());
        }
        return httpURLConnection;
    }

    public HarvestResponse send(HttpURLConnection httpURLConnection, String str) {
        String str2;
        HarvestResponse harvestResponse;
        ByteBuffer byteBufferWrap;
        DeviceInformation deviceInformation;
        String strReplace;
        HarvestResponse harvestResponse2 = new HarvestResponse();
        String str3 = str.length() <= 512 ? "identity" : Constants.Network.Encoding.DEFLATE;
        try {
            try {
                try {
                    TicToc ticToc = new TicToc();
                    ticToc.tic();
                    byteBufferWrap = Constants.Network.Encoding.DEFLATE.equals(str3.toLowerCase()) ? ByteBuffer.wrap(Deflator.deflate(str.getBytes())) : ByteBuffer.wrap(str.getBytes());
                    try {
                        httpURLConnection.setFixedLengthStreamingMode(byteBufferWrap.array().length);
                        httpURLConnection.setRequestProperty("Content-Encoding", str3);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        try {
                            bufferedOutputStream.write(byteBufferWrap.array());
                            bufferedOutputStream.close();
                            harvestResponse2.setResponseTime(ticToc.toc());
                            harvestResponse2.setStatusCode(httpURLConnection.getResponseCode());
                            harvestResponse2.setResponseBody(readResponse(httpURLConnection));
                            deviceInformation = Agent.getDeviceInformation();
                            strReplace = MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, deviceInformation.getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR);
                            if (httpURLConnection.getURL().getFile().contains(COLLECTOR_CONNECT_URI)) {
                                strReplace = strReplace.replace(MetricNames.TAG_SUBDESTINATION, "connect");
                            } else if (httpURLConnection.getURL().getFile().contains(COLLECTOR_DATA_URI)) {
                                strReplace = strReplace.replace(MetricNames.TAG_SUBDESTINATION, "data");
                            }
                            harvestResponse = harvestResponse2;
                        } finally {
                        }
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (IOException e2) {
                    e = e2;
                    str2 = "Failed to retrieve collector response: ";
                    harvestResponse = harvestResponse2;
                }
                try {
                    StatsEngine.get().sampleMetricDataUsage(strReplace, byteBufferWrap.array().length, harvestResponse2.getResponseBody() == null ? 0.0f : harvestResponse2.getResponseBody().length());
                    if (byteBufferWrap.array().length > Constants.Network.MAX_PAYLOAD_SIZE) {
                        String strReplace2 = MetricNames.SUPPORTABILITY_MAXPAYLOADSIZELIMIT_ENDPOINT.replace(MetricNames.TAG_FRAMEWORK, deviceInformation.getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR);
                        if (httpURLConnection.getURL().getFile().contains(COLLECTOR_CONNECT_URI)) {
                            strReplace2 = strReplace2.replace(MetricNames.TAG_SUBDESTINATION, "connect");
                        } else if (httpURLConnection.getURL().getFile().contains(COLLECTOR_DATA_URI)) {
                            strReplace2 = strReplace2.replace(MetricNames.TAG_SUBDESTINATION, "data");
                        }
                        StatsEngine.notice().inc(strReplace2);
                        this.log.error("Unable to send harvest data because payload is larger than 1 MB, harvest data will be discarded.");
                    }
                } catch (IOException e3) {
                    e = e3;
                    str2 = "Failed to retrieve collector response: ";
                    this.log.error(str2 + e.getMessage());
                    recordCollectorError(e);
                }
                return harvestResponse;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Exception e4) {
            this.log.error("Failed to send POST to collector: " + e4.getMessage());
            recordCollectorError(e4);
            httpURLConnection.disconnect();
            return null;
        }
    }

    public HarvestResponse sendConnect() {
        if (this.connectInformation == null) {
            throw new IllegalArgumentException();
        }
        HttpURLConnection httpURLConnectionCreateConnectPost = createConnectPost();
        if (httpURLConnectionCreateConnectPost == null) {
            this.log.error("Failed to create connect POST");
            return null;
        }
        TicToc ticToc = new TicToc();
        ticToc.tic();
        HarvestResponse harvestResponseSend = send(httpURLConnectionCreateConnectPost, this.connectInformation.toJsonString());
        StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Connect", ticToc.toc());
        return harvestResponseSend;
    }

    public HarvestResponse sendData(Harvestable harvestable) {
        return sendData(harvestable.toJsonString());
    }

    public HarvestResponse sendData(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        HttpURLConnection httpURLConnectionCreateDataPost = createDataPost();
        if (httpURLConnectionCreateDataPost == null) {
            this.log.error("Failed to create data POST");
            return null;
        }
        return send(httpURLConnectionCreateDataPost, str);
    }

    public HttpURLConnection createConnectPost() {
        return createPost(getCollectorConnectUri());
    }

    public HttpURLConnection createDataPost() {
        return createPost(getCollectorDataUri());
    }

    String readStream(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream != null) {
            char[] cArr = new char[8192];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    int i = bufferedReader.read(cArr);
                    if (i < 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        }
        return sb.toString();
    }

    public String readResponse(HttpURLConnection httpURLConnection) throws IOException {
        try {
            return readStream(httpURLConnection.getInputStream());
        } catch (IOException unused) {
            return readStream(httpURLConnection.getErrorStream());
        }
    }

    private void recordCollectorError(Exception exc) {
        this.log.error("HarvestConnection: Attempting to convert network exception " + exc.getClass().getName() + " to error code.");
        StatsEngine.get().inc("Supportability/AgentHealth/Collector/ResponseErrorCodes/" + ExceptionHelper.exceptionToErrorCode(exc));
    }

    private String getCollectorUri(String str) {
        return "https://" + this.collectorHost + str;
    }

    protected String getCollectorConnectUri() {
        return getCollectorUri(COLLECTOR_CONNECT_URI);
    }

    protected String getCollectorDataUri() {
        return getCollectorUri(COLLECTOR_DATA_URI);
    }

    public void setServerTimestamp(long j) {
        this.log.debug("Setting server timestamp: " + j);
        this.serverTimestamp = j;
    }

    public void useSsl(boolean z) {
        if (!z) {
            this.log.error("Unencrypted http requests are no longer supported");
        }
        this.useSsl = true;
    }

    public void setApplicationToken(String str) {
        this.applicationToken = str;
    }

    public void setCollectorHost(String str) {
        this.collectorHost = str;
    }

    public void setRequestHeaderMap(Map<String, String> map) {
        this.requestHeaders = map;
    }

    public void setConnectInformation(ConnectInformation connectInformation) {
        this.connectInformation = connectInformation;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        setServerTimestamp(harvestConfiguration.getServer_timestamp());
        setRequestHeaderMap(harvestConfiguration.getRequest_headers_map());
    }

    public void updateConfiguration(AgentConfiguration agentConfiguration) {
        setApplicationToken(agentConfiguration.getApplicationToken());
        setCollectorHost(agentConfiguration.getCollectorHost());
        useSsl(agentConfiguration.useSsl());
    }
}
