package com.newrelic.agent.android.logging;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface Logger {
    public static final String TAG = "newrelic";

    default void logAll(Throwable th, Map<String, Object> map) {
    }

    default void logAttributes(Map<String, Object> map) {
    }

    default void logThrowable(LogLevel logLevel, String str, Throwable th) {
    }

    default boolean isLevelEnabled(LogLevel logLevel) {
        return LogReporting.isLevelEnabled(logLevel);
    }

    default void log(LogLevel logLevel, String str) {
        if (LogReporting.isLevelEnabled(logLevel)) {
            AgentLog agentLog = AgentLogManager.getAgentLog();
            int i = C37731.$SwitchMap$com$newrelic$agent$android$logging$LogLevel[logLevel.ordinal()];
            if (i == 1) {
                agentLog.error(str);
                return;
            }
            if (i == 2) {
                agentLog.warn(str);
                return;
            }
            if (i == 3) {
                agentLog.info(str);
            } else if (i == 4) {
                agentLog.verbose(str);
            } else {
                if (i != 5) {
                    return;
                }
                agentLog.debug(str);
            }
        }
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.logging.Logger$1 */
    static /* synthetic */ class C37731 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$logging$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$newrelic$agent$android$logging$LogLevel = iArr;
            try {
                iArr[LogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$logging$LogLevel[LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$logging$LogLevel[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$logging$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$logging$LogLevel[LogLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
