package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsAttribute {
    public static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    public static final String ACTION_TYPE_ATTRIBUTE = "actionType";
    public static final String ANR = "ANR";
    public static final String APPLICATION_PLATFORM_ATTRIBUTE = "platform";
    public static final String APPLICATION_PLATFORM_VERSION_ATTRIBUTE = "platformVersion";
    public static final String APP_BUILD_ATTRIBUTE = "appBuild";
    public static final String APP_DATA_ATTRIBUTE = "nr.X-NewRelic-App-Data";
    public static final String APP_EXIT_APP_STATE_ATTRIBUTE = "appState";
    public static final String APP_EXIT_DESCRIPTION_ATTRIBUTE = "description";
    public static final String APP_EXIT_FINGERPRINT_ATTRIBUTE = "fingerprint";
    public static final String APP_EXIT_ID_ATTRIBUTE = "appExitId";
    public static final String APP_EXIT_IMPORTANCE_ATTRIBUTE = "importance";
    public static final String APP_EXIT_IMPORTANCE_STRING_ATTRIBUTE = "importanceAsString";
    public static final String APP_EXIT_PROCESS_ID_ATTRIBUTE = "processId";
    public static final String APP_EXIT_PROCESS_NAME_ATTRIBUTE = "processName";
    public static final String APP_EXIT_REASON_ATTRIBUTE = "reason";
    public static final String APP_EXIT_SESSION_ID_ATTRIBUTE = "aeiSessionId";
    public static final String APP_EXIT_THREADS_ATTRIBUTE = "threads";
    public static final String APP_EXIT_TIMESTAMP_ATTRIBUTE = "exitTimestamp";
    public static final String APP_ID_ATTRIBUTE = "appId";
    public static final String APP_INSTALL_ATTRIBUTE = "install";
    public static final String APP_NAME_ATTRIBUTE = "appName";
    public static final String APP_UPGRADE_ATTRIBUTE = "upgradeFrom";
    public static final String ARCHITECTURE_ATTRIBUTE = "architecture";
    public static final int ATTRIBUTE_NAME_MAX_LENGTH = 255;
    public static final int ATTRIBUTE_VALUE_MAX_LENGTH = 4096;
    public static final String BACKGROUND_ATTRIBUTE_NAME = "background";
    public static final String BYTES_RECEIVED_ATTRIBUTE = "bytesReceived";
    public static final String BYTES_SENT_ATTRIBUTE = "bytesSent";
    public static final String CARRIER_ATTRIBUTE = "carrier";
    public static final String CONNECTION_TYPE_ATTRIBUTE = "connectionType";
    public static final String CONTENT_TYPE_ATTRIBUTE = "contentType";
    public static final String DEVICE_MANUFACTURER_ATTRIBUTE = "deviceManufacturer";
    public static final String DEVICE_MODEL_ATTRIBUTE = "deviceModel";
    public static final String EVENT_CATEGORY_ATTRIBUTE = "category";
    public static final String EVENT_NAME_ATTRIBUTE = "name";
    public static final String EVENT_TIMESTAMP_ATTRIBUTE = "timestamp";
    public static final String EVENT_TYPE_ATTRIBUTE = "eventType";
    public static final String HARVEST_ACCOUNT_ID_ATTRIBUTE = "HarvestAccountId";
    public static final String INSTANT_APP_ATTRIBUTE = "instantApp";
    public static final String INTERACTION_DURATION_ATTRIBUTE = "interactionDuration";
    public static final String LAST_INTERACTION_ATTRIBUTE = "lastInteraction";
    public static final String MEM_USAGE_MB_ATTRIBUTE = "memUsageMb";
    public static final String MUTABLE = "mutable";
    public static final String NATIVE_CRASH = "nativeCrash";
    public static final String NATIVE_CRASHING_THREAD_ID_ATTRIBUTE = "crashingThreadId";
    public static final String NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE = "exceptionMessage";
    public static final String NATIVE_ROOTED_DEVICE_ATTRIBUTE = "rootedDevice";
    public static final String NATIVE_THREADS_ATTRIBUTE = "nativeThreads";
    public static final String NETWORK_ERROR_CODE_ATTRIBUTE = "networkErrorCode";
    public static final String NEW_RELIC_VERSION_ATTRIBUTE = "newRelicVersion";
    public static final String OFFLINE_NAME_ATTRIBUTE = "offline";
    public static final String OS_BUILD_ATTRIBUTE = "osBuild";
    public static final String OS_MAJOR_VERSION_ATTRIBUTE = "osMajorVersion";
    public static final String OS_NAME_ATTRIBUTE = "osName";
    public static final String OS_VERSION_ATTRIBUTE = "osVersion";
    public static final String PROCESS_ID_ATTRIBUTE = "processId";
    public static final String REQUEST_DOMAIN_ATTRIBUTE = "requestDomain";
    public static final String REQUEST_METHOD_ATTRIBUTE = "requestMethod";
    public static final String REQUEST_PATH_ATTRIBUTE = "requestPath";
    public static final String REQUEST_URL_ATTRIBUTE = "requestUrl";
    public static final String RESPONSE_BODY_ATTRIBUTE = "nr.responseBody";
    public static final String RESPONSE_TIME_ATTRIBUTE = "responseTime";
    public static final String RUNTIME_ATTRIBUTE = "runTime";
    public static final String SESSION_DURATION_ATTRIBUTE = "sessionDuration";
    public static final String SESSION_ID_ATTRIBUTE = "sessionId";
    public static final String SESSION_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
    public static final String STATUS_CODE_ATTRIBUTE = "statusCode";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String UNHANDLED_NATIVE_EXCEPTION = "unhandledNativeException";
    public static final String USER_ID_ATTRIBUTE = "userId";
    public static final String UUID_ATTRIBUTE = "uuid";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final AnalyticsValidator validator = new AnalyticsValidator();
    private AttributeDataType attributeDataType;
    private double doubleValue;
    private boolean isPersistent;
    private String name;
    private String stringValue;

    public enum AttributeDataType {
        VOID,
        STRING,
        DOUBLE,
        BOOLEAN
    }

    protected AnalyticsAttribute() {
        this.stringValue = null;
        this.doubleValue = Double.NaN;
        this.isPersistent = false;
        this.attributeDataType = AttributeDataType.VOID;
    }

    public AnalyticsAttribute(String str, String str2) {
        this(str, str2, true);
    }

    public AnalyticsAttribute(String str, String str2, boolean z) {
        this.name = str;
        setStringValue(str2);
        this.isPersistent = z;
    }

    public AnalyticsAttribute(String str, double d) {
        this(str, d, true);
    }

    public AnalyticsAttribute(String str, double d, boolean z) {
        this.name = str;
        setDoubleValue(d);
        this.isPersistent = z;
    }

    public AnalyticsAttribute(String str, boolean z) {
        this(str, z, true);
    }

    public AnalyticsAttribute(String str, boolean z, boolean z2) {
        this.name = str;
        setBooleanValue(z);
        this.isPersistent = z2;
    }

    public AnalyticsAttribute(AnalyticsAttribute analyticsAttribute) {
        this.name = analyticsAttribute.name;
        this.doubleValue = analyticsAttribute.doubleValue;
        this.stringValue = analyticsAttribute.stringValue;
        this.isPersistent = analyticsAttribute.isPersistent;
        this.attributeDataType = analyticsAttribute.attributeDataType;
    }

    public String getName() {
        return this.name;
    }

    public boolean isStringAttribute() {
        return this.attributeDataType == AttributeDataType.STRING;
    }

    public boolean isDoubleAttribute() {
        return this.attributeDataType == AttributeDataType.DOUBLE;
    }

    public boolean isBooleanAttribute() {
        return this.attributeDataType == AttributeDataType.BOOLEAN;
    }

    public String getStringValue() {
        if (this.attributeDataType == AttributeDataType.STRING) {
            return this.stringValue;
        }
        return null;
    }

    public AnalyticsAttribute setStringValue(String str) {
        this.doubleValue = Double.NaN;
        this.stringValue = str;
        this.attributeDataType = AttributeDataType.STRING;
        return this;
    }

    public double getDoubleValue() {
        if (this.attributeDataType == AttributeDataType.DOUBLE) {
            return this.doubleValue;
        }
        return Double.NaN;
    }

    public AnalyticsAttribute setDoubleValue(double d) {
        this.doubleValue = d;
        this.stringValue = null;
        this.attributeDataType = AttributeDataType.DOUBLE;
        return this;
    }

    public boolean getBooleanValue() {
        if (this.attributeDataType == AttributeDataType.BOOLEAN) {
            return Boolean.valueOf(this.stringValue).booleanValue();
        }
        return false;
    }

    public AnalyticsAttribute setBooleanValue(boolean z) {
        this.stringValue = Boolean.toString(z);
        this.doubleValue = Double.NaN;
        this.attributeDataType = AttributeDataType.BOOLEAN;
        return this;
    }

    public boolean isPersistent() {
        return this.isPersistent && !validator.isExcludedAttributeName(this.name);
    }

    public AnalyticsAttribute setPersistent(boolean z) {
        this.isPersistent = z;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((AnalyticsAttribute) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnalyticsAttribute{");
        sb.append("name='" + this.name + "'");
        int i = C37341.f4031x35709c72[this.attributeDataType.ordinal()];
        if (i == 2) {
            sb.append(",stringValue='" + this.stringValue + "'");
        } else if (i == 3) {
            sb.append(",doubleValue='" + this.doubleValue + "'");
        } else if (i == 4) {
            sb.append(",booleanValue=" + Boolean.valueOf(this.stringValue).toString());
        }
        sb.append(",isPersistent=" + this.isPersistent);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.analytics.AnalyticsAttribute$1 */
    static /* synthetic */ class C37341 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType */
        static final /* synthetic */ int[] f4031x35709c72;

        static {
            int[] iArr = new int[AttributeDataType.values().length];
            f4031x35709c72 = iArr;
            try {
                iArr[AttributeDataType.VOID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4031x35709c72[AttributeDataType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4031x35709c72[AttributeDataType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4031x35709c72[AttributeDataType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AttributeDataType getAttributeDataType() {
        return this.attributeDataType;
    }

    public String valueAsString() {
        int i = C37341.f4031x35709c72[this.attributeDataType.ordinal()];
        if (i == 2) {
            return this.stringValue;
        }
        if (i == 3) {
            return Double.toString(this.doubleValue);
        }
        if (i != 4) {
            return null;
        }
        return Boolean.valueOf(getBooleanValue()).toString();
    }

    public JsonElement asJsonElement() {
        int i = C37341.f4031x35709c72[this.attributeDataType.ordinal()];
        if (i == 2) {
            return SafeJsonPrimitive.factory(getStringValue());
        }
        if (i == 3) {
            return SafeJsonPrimitive.factory(Double.valueOf(getDoubleValue()));
        }
        if (i != 4) {
            return null;
        }
        return SafeJsonPrimitive.factory(Boolean.valueOf(getBooleanValue()));
    }

    public static Set<AnalyticsAttribute> newFromJson(JsonObject jsonObject) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = entry.getValue().getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsString(), false));
                } else if (asJsonPrimitive.isBoolean()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsBoolean(), false));
                } else if (asJsonPrimitive.isNumber()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsDouble(), false));
                }
            } else {
                hashSet.add(new AnalyticsAttribute(key, entry.getValue().getAsString(), false));
            }
        }
        return hashSet;
    }

    boolean isValid() {
        return validator.isValidAttribute(this);
    }

    static AnalyticsAttribute createAttribute(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            AnalyticsValidator analyticsValidator = validator;
            if (!analyticsValidator.isValidAttributeName(str)) {
                return null;
            }
            if (obj instanceof String) {
                if (analyticsValidator.isValidAttributeValue(str, (String) obj)) {
                    return new AnalyticsAttribute(str, String.valueOf(obj));
                }
                return null;
            }
            if (obj instanceof Float) {
                return new AnalyticsAttribute(str, ((Float) obj).floatValue());
            }
            if (obj instanceof Double) {
                return new AnalyticsAttribute(str, ((Double) obj).doubleValue());
            }
            if (obj instanceof Integer) {
                return new AnalyticsAttribute(str, Double.valueOf(((Integer) obj).intValue()).doubleValue());
            }
            if (obj instanceof Short) {
                return new AnalyticsAttribute(str, Double.valueOf(((Short) obj).shortValue()).doubleValue());
            }
            if (obj instanceof Long) {
                return new AnalyticsAttribute(str, Double.valueOf(((Long) obj).longValue()).doubleValue());
            }
            if (obj instanceof BigDecimal) {
                return new AnalyticsAttribute(str, ((BigDecimal) obj).doubleValue());
            }
            if (obj instanceof BigInteger) {
                return new AnalyticsAttribute(str, ((BigInteger) obj).doubleValue());
            }
            if (obj instanceof Boolean) {
                return new AnalyticsAttribute(str, ((Boolean) obj).booleanValue());
            }
            log.error("Unsupported event attribute type for key [" + str + "]: " + obj.getClass().getName());
            return null;
        } catch (ClassCastException e) {
            log.error(String.format("Error casting attribute [%s] to String or Float: ", str), e);
            return null;
        }
    }
}
