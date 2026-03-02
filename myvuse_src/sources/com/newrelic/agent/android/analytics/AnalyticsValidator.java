package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsValidator {
    private static final String ALLOWABLE_EVENT_TYPE_CHARS = "^[\\p{L}\\p{Nd} _:.]+$";
    private static final String NEW_RELIC_PREFIX = "newRelic";
    private static final String NR_PREFIX = "nr.";
    private static final String PUBLIC_PREFIX = "Public_";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    static final Set<String> reservedAttributeNames = new HashSet<String>() { // from class: com.newrelic.agent.android.analytics.AnalyticsValidator.1
        {
            add(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            add("type");
            add("timestamp");
            add(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE);
            add(AnalyticsAttribute.ACCOUNT_ID_ATTRIBUTE);
            add("appId");
            add(AnalyticsAttribute.APP_NAME_ATTRIBUTE);
            add(AnalyticsAttribute.UUID_ATTRIBUTE);
            add("sessionId");
            add(AnalyticsAttribute.OS_NAME_ATTRIBUTE);
            add(AnalyticsAttribute.OS_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.OS_MAJOR_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE);
            add(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE);
            add(AnalyticsAttribute.MEM_USAGE_MB_ATTRIBUTE);
            add(AnalyticsAttribute.CARRIER_ATTRIBUTE);
            add(AnalyticsAttribute.NEW_RELIC_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.INTERACTION_DURATION_ATTRIBUTE);
            add(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE);
            add(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE);
            add("platform");
            add("platformVersion");
            add(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE);
            add(AnalyticsAttribute.OS_BUILD_ATTRIBUTE);
            add(AnalyticsAttribute.RUNTIME_ATTRIBUTE);
            add(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE);
            add("appBuild");
        }
    };
    protected static Set<String> excludedAttributeNames = new HashSet<String>() { // from class: com.newrelic.agent.android.analytics.AnalyticsValidator.2
        {
            add(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE);
            add(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE);
            add(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE);
        }
    };
    static final Set<String> reservedEventTypes = new HashSet<String>() { // from class: com.newrelic.agent.android.analytics.AnalyticsValidator.3
        {
            add(AnalyticsEvent.EVENT_TYPE_MOBILE);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST_ERROR);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_CRASH);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_USER_ACTION);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_APPLICATION_EXIT);
        }
    };

    boolean isValidKeyName(String str) {
        boolean z = (str == null || str.isEmpty() || str.length() >= 255) ? false : true;
        if (!z) {
            log.error("Attribute name [" + str + "] is null, empty, or exceeds the maximum length of 255 characters.");
        }
        return z;
    }

    public boolean isValidAttributeName(String str) {
        boolean zIsValidKeyName = isValidKeyName(str);
        if (!zIsValidKeyName) {
            return zIsValidKeyName;
        }
        boolean zIsReservedAttributeName = isReservedAttributeName(str);
        boolean z = !zIsReservedAttributeName;
        if (zIsReservedAttributeName) {
            log.error("Attribute name [" + str + "] is reserved for internal use and will be ignored.");
        }
        return z;
    }

    public boolean isReservedAttributeName(String str) {
        if (reservedAttributeNames.contains(str)) {
            log.error("Attribute name [" + str + "] is in the reserved names list.");
            return true;
        }
        if (str.startsWith(NEW_RELIC_PREFIX)) {
            log.error("Attribute name [" + str + "] starts with reserved prefix [newRelic]");
            return true;
        }
        if (str.startsWith(NR_PREFIX)) {
            log.error("Attribute name [" + str + "] starts with reserved prefix [nr.]");
            return true;
        }
        if (!str.startsWith(PUBLIC_PREFIX)) {
            return false;
        }
        log.error("Attribute name [" + str + "] starts with reserved prefix [Public_]");
        return true;
    }

    public boolean isExcludedAttributeName(String str) {
        return excludedAttributeNames.contains(str);
    }

    public boolean isValidAttributeValue(String str, String str2) {
        boolean z = (str2 == null || str2.isEmpty() || str2.getBytes().length >= 4096) ? false : true;
        if (!z) {
            log.error("Attribute value for name [" + str + "] is null, empty, or exceeds the maximum length of 4096 bytes.");
        }
        return z;
    }

    public boolean isValidAttribute(AnalyticsAttribute analyticsAttribute) {
        return analyticsAttribute != null && isValidAttributeName(analyticsAttribute.getName()) && isValidAttributeValue(analyticsAttribute.getName(), analyticsAttribute.valueAsString());
    }

    public Set<AnalyticsAttribute> toValidatedAnalyticsAttributes(Map<String, Object> map) {
        try {
            HashSet hashSet = new HashSet();
            for (String str : map.keySet()) {
                AnalyticsAttribute analyticsAttributeCreateAttribute = AnalyticsAttribute.createAttribute(str, map.get(str));
                if (isValidAttribute(analyticsAttributeCreateAttribute)) {
                    hashSet.add(analyticsAttributeCreateAttribute);
                } else {
                    log.warn(String.format("Attribute [" + str + "] ignored: value is null, empty or exceeds the maximum name length", new Object[0]));
                }
            }
            return hashSet;
        } catch (Exception e) {
            log.error("Error occurred filtering attribute map: ", e);
            return Collections.emptySet();
        }
    }

    public Set<AnalyticsAttribute> toValidatedAnalyticsAttributes(Set<AnalyticsAttribute> set) {
        try {
            HashSet hashSet = new HashSet();
            for (AnalyticsAttribute analyticsAttribute : set) {
                if (isValidAttribute(analyticsAttribute)) {
                    hashSet.add(new AnalyticsAttribute(analyticsAttribute));
                } else {
                    log.warn(String.format("Attribute [" + analyticsAttribute.getName() + "] ignored: value is null, empty or exceeds the maximum name length", new Object[0]));
                }
            }
            return hashSet;
        } catch (Exception e) {
            log.error("Error occurred filtering attribute set: ", e);
            return Collections.emptySet();
        }
    }

    public boolean isValidEventName(String str) {
        return (str == null || str.isEmpty() || str.length() >= 255) ? false : true;
    }

    public boolean isValidEventType(String str) {
        boolean zMatches = str != null;
        if (zMatches) {
            zMatches = str.matches(ALLOWABLE_EVENT_TYPE_CHARS);
        }
        if (!zMatches) {
            log.error("Event type [" + str + "] is invalid and will be ignored. Custom event types may only include alphanumeric, ' ', '.', ':' or '_' characters.");
        }
        return zMatches;
    }

    public boolean isReservedEventType(String str) {
        boolean z = isValidEventType(str) && reservedEventTypes.contains(str);
        if (z) {
            log.error("Event type [" + str + "] is reserved and will be ignored.");
        }
        return z;
    }

    public String toValidEventType(String str) {
        return (str == null || str.isEmpty()) ? AnalyticsEvent.EVENT_TYPE_MOBILE : str;
    }

    public AnalyticsEventCategory toValidCategory(AnalyticsEventCategory analyticsEventCategory) {
        return analyticsEventCategory == null ? AnalyticsEventCategory.Custom : analyticsEventCategory;
    }
}
