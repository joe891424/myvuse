package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkEventController {
    static final AgentLog log = AgentLogManager.getAgentLog();

    public static void createHttpErrorEvent(HttpTransaction httpTransaction) {
        if (FeatureFlag.featureEnabled(FeatureFlag.NetworkErrorRequests)) {
            if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestErrorEvent.createHttpErrorEvent(httpTransaction))) {
                log.error("Failed to add MobileRequestError");
                return;
            }
            log.audit(AnalyticsEventCategory.RequestError.toString() + " added to event store for request: " + httpTransaction.getUrl());
        }
    }

    public static void createNetworkFailureEvent(HttpTransaction httpTransaction) {
        if (FeatureFlag.featureEnabled(FeatureFlag.NetworkErrorRequests)) {
            if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestErrorEvent.createNetworkFailureEvent(httpTransaction))) {
                log.error("Failed to add MobileRequestError");
                return;
            }
            log.audit(AnalyticsEventCategory.RequestError.toString() + " added to event store for request: " + httpTransaction.getUrl());
        }
    }

    public static void createNetworkRequestEvent(HttpTransaction httpTransaction) {
        if (FeatureFlag.featureEnabled(FeatureFlag.NetworkRequests)) {
            if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestEvent.createNetworkEvent(httpTransaction))) {
                log.error("Failed to add MobileRequest");
                return;
            }
            log.audit(AnalyticsEventCategory.NetworkRequest.toString() + " added to event store for request: " + httpTransaction.getUrl());
        }
    }

    protected NetworkEventController() {
    }
}
