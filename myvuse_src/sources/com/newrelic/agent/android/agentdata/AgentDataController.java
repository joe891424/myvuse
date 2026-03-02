package com.newrelic.agent.android.agentdata;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.agentdata.builder.AgentDataBuilder;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.crash.Crash;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.ExceptionHelper;
import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class AgentDataController {
    protected static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static final AgentLog log = AgentLogManager.getAgentLog();

    static FlatBufferBuilder buildAgentDataFromHandledException(Throwable th, Map<String, Object> map) {
        UUID uuidFromString;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ApplicationInfo applicationInfo = new ApplicationInfo(Agent.getApplicationInformation());
        try {
            uuidFromString = UUID.fromString(Crash.getSafeBuildId());
        } catch (IllegalArgumentException e) {
            UUID uuidRandomUUID = UUID.randomUUID();
            ExceptionHelper.recordSupportabilityMetric(e, "RandomUUID");
            uuidFromString = uuidRandomUUID;
        }
        map2.put(HexAttribute.HEX_ATTR_APP_UUID_HI, Long.valueOf(uuidFromString.getLeastSignificantBits()));
        map2.put(HexAttribute.HEX_ATTR_APP_UUID_LO, Long.valueOf(uuidFromString.getMostSignificantBits()));
        map2.put("appVersion", applicationInfo.getApplicationVersion());
        map2.put("appBuild", applicationInfo.getApplicationBuild());
        map2.put("sessionId", agentConfiguration.getSessionID());
        map2.put(HexAttribute.HEX_ATTR_TIMESTAMP_MS, Long.valueOf(System.currentTimeMillis()));
        map2.put("message", (th.getMessage() == null || th.getMessage().length() <= 4096) ? th.getMessage() : th.getMessage().substring(0, 4096));
        String string = getRootCause(th).toString();
        if (string.length() > 4096) {
            string = string.substring(0, 4096);
        }
        map2.put(HexAttribute.HEX_ATTR_CAUSE, string);
        map2.put("name", th.getClass().toString());
        map2.put("thread", threadSetFromStackElements(th.getStackTrace()));
        map2.putAll(map);
        for (AnalyticsAttribute analyticsAttribute : AnalyticsControllerImpl.getInstance().getSessionAttributes()) {
            int i = C37311.f4030x35709c72[analyticsAttribute.getAttributeDataType().ordinal()];
            if (i == 1) {
                map3.put(analyticsAttribute.getName(), analyticsAttribute.getStringValue());
            } else if (i == 2) {
                map3.put(analyticsAttribute.getName(), Double.valueOf(analyticsAttribute.getDoubleValue()));
            } else if (i == 3) {
                map3.put(analyticsAttribute.getName(), Boolean.valueOf(analyticsAttribute.getBooleanValue()));
            }
        }
        long sessionDurationMillis = Agent.getImpl().getSessionDurationMillis();
        if (0 == sessionDurationMillis) {
            log.error("Harvest instance is not running! Session duration will be invalid");
        } else {
            map3.put(AnalyticsAttribute.SESSION_TIME_SINCE_LOAD_ATTRIBUTE, Float.valueOf(sessionDurationMillis / 1000.0f));
        }
        map3.put("obfuscated", Boolean.valueOf(Agent.getIsObfuscated()));
        map3.putAll(map);
        HashSet hashSet = new HashSet();
        hashSet.add(map2);
        return AgentDataBuilder.startAndFinishAgentData(map3, hashSet);
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.agentdata.AgentDataController$1 */
    static /* synthetic */ class C37311 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType */
        static final /* synthetic */ int[] f4030x35709c72;

        static {
            int[] iArr = new int[AnalyticsAttribute.AttributeDataType.values().length];
            f4030x35709c72 = iArr;
            try {
                iArr[AnalyticsAttribute.AttributeDataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4030x35709c72[AnalyticsAttribute.AttributeDataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4030x35709c72[AnalyticsAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static FlatBufferBuilder buildAgentDataFromHandledException(Throwable th) {
        return buildAgentDataFromHandledException(th, new HashMap());
    }

    protected static Throwable getRootCause(Throwable th) {
        if (th != null) {
            try {
                Throwable cause = th.getCause();
                return cause == null ? th : getRootCause(cause);
            } catch (Exception unused) {
                if (th != null) {
                    return th;
                }
            }
        }
        return new Throwable("Unknown cause");
    }

    protected static List<Map<String, Object>> threadSetFromStackElements(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(HexAttribute.HEX_ATTR_CLASS_NAME, stackTraceElement.getClassName());
            linkedHashMap.put("methodName", stackTraceElement.getMethodName());
            linkedHashMap.put("lineNumber", Integer.valueOf(stackTraceElement.getLineNumber()));
            linkedHashMap.put("fileName", stackTraceElement.getFileName());
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public static boolean sendAgentData(Throwable th, Map<String, Object> map) {
        if (FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions) || FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage) && !Agent.hasReachableNetworkConnection(null)) {
                    map.put(AnalyticsAttribute.OFFLINE_NAME_ATTRIBUTE, true);
                    StatsEngine.notice().inc(MetricNames.OFFLINE_STORAGE_HANDLED_EXCEPTION_COUNT);
                }
                if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
                    map.put("background", true);
                    StatsEngine.notice().inc(MetricNames.BACKGROUND_HANDLED_EXCEPTION_COUNT);
                }
                ByteBuffer byteBufferSlice = buildAgentDataFromHandledException(th, map).dataBuffer().slice();
                byte[] bArr = new byte[byteBufferSlice.remaining()];
                byteBufferSlice.get(bArr);
                AgentLog agentLog = log;
                agentLog.audit(AgentDataBuilder.toJsonString(HexAgentDataBundle.getRootAsHexAgentDataBundle(ByteBuffer.wrap(bArr)), 0));
                boolean zReportAgentData = AgentDataReporter.reportAgentData(bArr);
                if (!zReportAgentData) {
                    agentLog.error("HandledException: exception " + th.getClass().getName() + " failed to record data.");
                }
                return zReportAgentData;
            } catch (Exception unused) {
                log.error("HandledException: exception " + th.getClass().getName() + " failed to record data.");
            }
        }
        return false;
    }
}
