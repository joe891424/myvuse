package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.HttpTransaction;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkRequestErrorEvent extends AnalyticsEvent {
    static final String DISABLE_FF_RESPONSE = "NEWRELIC_RESPONSE_BODY_CAPTURE_DISABLED";

    static Set<AnalyticsAttribute> createErrorAttributeSet(HttpTransaction httpTransaction) {
        String str;
        Set<AnalyticsAttribute> setCreateDefaultAttributeSet = NetworkRequestEvent.createDefaultAttributeSet(httpTransaction);
        if (FeatureFlag.featureEnabled(FeatureFlag.HttpResponseBodyCapture)) {
            String responseBody = httpTransaction.getResponseBody();
            if (responseBody != null && !responseBody.isEmpty()) {
                if (responseBody.length() > 4096) {
                    log.warn("NetworkRequestErrorEvent: truncating response body to 4096 bytes");
                    responseBody = responseBody.substring(0, 4096);
                }
                String strEncodeNoWrap = Agent.getEncoder().encodeNoWrap(responseBody.getBytes());
                if (strEncodeNoWrap != null && !strEncodeNoWrap.isEmpty()) {
                    setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_BODY_ATTRIBUTE, strEncodeNoWrap));
                }
            }
        } else {
            setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_BODY_ATTRIBUTE, DISABLE_FF_RESPONSE));
        }
        String appData = httpTransaction.getAppData();
        if (appData != null && !appData.isEmpty()) {
            setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.APP_DATA_ATTRIBUTE, appData));
        }
        if (httpTransaction.getParams() != null && (str = httpTransaction.getParams().get("content_type")) != null && !str.isEmpty()) {
            setCreateDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE, str));
        }
        return setCreateDefaultAttributeSet;
    }

    public NetworkRequestErrorEvent(Set<AnalyticsAttribute> set) {
        super(null, AnalyticsEventCategory.RequestError, AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST_ERROR, set);
    }

    public static NetworkRequestErrorEvent createHttpErrorEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> setCreateErrorAttributeSet = createErrorAttributeSet(httpTransaction);
        setCreateErrorAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.STATUS_CODE_ATTRIBUTE, httpTransaction.getStatusCode()));
        return new NetworkRequestErrorEvent(setCreateErrorAttributeSet);
    }

    public static NetworkRequestErrorEvent createNetworkFailureEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> setCreateErrorAttributeSet = createErrorAttributeSet(httpTransaction);
        setCreateErrorAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.NETWORK_ERROR_CODE_ATTRIBUTE, httpTransaction.getErrorCode()));
        return new NetworkRequestErrorEvent(setCreateErrorAttributeSet);
    }
}
