package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.harvest.HttpTransaction;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkRequestEvent extends AnalyticsEvent {
    public NetworkRequestEvent(Set<AnalyticsAttribute> set) {
        super(null, AnalyticsEventCategory.NetworkRequest, AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST, set);
    }

    public static NetworkRequestEvent createNetworkEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> setCreateDefaultAttributeSet = createDefaultAttributeSet(httpTransaction);
        setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_TIME_ATTRIBUTE, httpTransaction.getTotalTime()));
        setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.STATUS_CODE_ATTRIBUTE, httpTransaction.getStatusCode()));
        setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE, httpTransaction.getBytesSent()));
        setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE, httpTransaction.getBytesReceived()));
        return new NetworkRequestEvent(setCreateDefaultAttributeSet);
    }

    static Set<AnalyticsAttribute> createDefaultAttributeSet(HttpTransaction httpTransaction) {
        TraceContext traceContext;
        HashSet hashSet = new HashSet();
        try {
            URL url = new URL(httpTransaction.getUrl());
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_DOMAIN_ATTRIBUTE, url.getHost()));
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_PATH_ATTRIBUTE, url.getPath()));
        } catch (MalformedURLException unused) {
            log.error(httpTransaction.getUrl() + " is not a valid URL. Unable to set host or path attributes.");
        }
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, httpTransaction.getUrl()));
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.CONNECTION_TYPE_ATTRIBUTE, httpTransaction.getWanType()));
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_METHOD_ATTRIBUTE, httpTransaction.getHttpMethod()));
        double totalTime = httpTransaction.getTotalTime();
        if (totalTime != 0.0d) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_TIME_ATTRIBUTE, totalTime));
        }
        double bytesSent = httpTransaction.getBytesSent();
        if (bytesSent != 0.0d) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE, bytesSent));
        }
        double bytesReceived = httpTransaction.getBytesReceived();
        if (bytesReceived != 0.0d) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE, bytesReceived));
        }
        if (httpTransaction.getParams() != null) {
            for (String str : httpTransaction.getParams().keySet()) {
                hashSet.add(new AnalyticsAttribute(str, httpTransaction.getParams().get(str)));
            }
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing) && ((traceContext = httpTransaction.getTraceContext()) != null || httpTransaction.getTraceAttributes() != null)) {
            try {
                hashSet.addAll(validator.toValidatedAnalyticsAttributes(traceContext != null ? traceContext.asTraceAttributes() : httpTransaction.getTraceAttributes()));
            } catch (Exception e) {
                log.error("Error occurred parsing the instrinsic attribute set: ", e);
            }
        }
        return hashSet;
    }
}
