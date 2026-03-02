package com.newrelic.agent.android.logging;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.logging.LogReporting;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LogReporting {
    public static final String INVALID_MSG = "<invalid message>";
    protected static final String LOG_ATTRIBUTES_ATTRIBUTE = "attributes";
    protected static final String LOG_ENTITY_ATTRIBUTE = "entity.guid";
    protected static final String LOG_ERROR_CLASS_ATTRIBUTE = "error.class";
    protected static final String LOG_ERROR_MESSAGE_ATTRIBUTE = "error.message";
    protected static final String LOG_ERROR_STACK_ATTRIBUTE = "error.stack";
    protected static final String LOG_INSTRUMENTATION_ANDROID_NAME = "AndroidAgent";
    protected static final String LOG_INSTRUMENTATION_COLLECTOR_NAME = "collector.name";
    protected static final String LOG_INSTRUMENTATION_NAME = "instrumentation.name";
    protected static final String LOG_INSTRUMENTATION_PROVIDER = "instrumentation.provider";
    protected static final String LOG_INSTRUMENTATION_PROVIDER_ATTRIBUTE = "mobile";
    protected static final String LOG_INSTRUMENTATION_VERSION = "instrumentation.version";
    protected static final String LOG_LEVEL_ATTRIBUTE = "level";
    protected static final String LOG_LOGGER_ATTRIBUTE = "logger";
    protected static final String LOG_MESSAGE_ATTRIBUTE = "message";
    protected static final String LOG_PAYLOAD_ATTRIBUTES_ATTRIBUTE = "attributes";
    protected static final String LOG_PAYLOAD_COMMON_ATTRIBUTE = "common";
    protected static final String LOG_PAYLOAD_LOGS_ATTRIBUTE = "logs";
    protected static final String LOG_SESSION_ID = "sessionId";
    protected static final String LOG_TIMESTAMP_ATTRIBUTE = "timestamp";
    protected static LogLevel logLevel = LogLevel.WARN;
    protected static AgentLogger agentLogger = new AgentLogger();
    protected static AtomicReference<Logger> instance = new AtomicReference<>(agentLogger);
    public static MessageValidator validator = new MessageValidator() { // from class: com.newrelic.agent.android.logging.LogReporting.1
    };

    protected Map<String, Object> decorateLogData(MessageValidator messageValidator, Map<String, Object> map) {
        return map;
    }

    public static void initialize(File file, AgentConfiguration agentConfiguration) throws IOException {
        if (agentConfiguration.getLogReportingConfiguration().enabled) {
            setLogLevel(agentConfiguration.getLogReportingConfiguration().getLogLevel());
            LogReporter.initialize(file, agentConfiguration);
            LogReporter.getInstance().start();
            if (LogReporter.getInstance().isStarted()) {
                return;
            }
            agentLogger.log(LogLevel.ERROR, "LogReporting failed to initialize!");
        }
    }

    public static Logger getLogger() {
        return instance.get();
    }

    public static Logger setLogger(Logger logger) {
        instance.set(logger);
        return instance.get();
    }

    static LogLevel getLogLevel() {
        return logLevel;
    }

    static int getLogLevelAsInt() {
        return logLevel.ordinal();
    }

    public static void setLogLevel(String str) {
        setLogLevel(LogLevel.valueOf(str.toUpperCase()));
    }

    static void setLogLevel(int i) {
        logLevel = LogLevel.levels[i];
    }

    public static void setLogLevel(LogLevel logLevel2) {
        logLevel = logLevel2;
    }

    public static boolean isLevelEnabled(LogLevel logLevel2) {
        return logLevel.value >= logLevel2.value;
    }

    public static boolean isRemoteLoggingEnabled() {
        return FeatureFlag.featureEnabled(FeatureFlag.LogReporting) && LogLevel.NONE != getLogLevel();
    }

    public static class AgentLogger implements Logger {
        MessageValidator validator = new MessageValidator() { // from class: com.newrelic.agent.android.logging.LogReporting.AgentLogger.1
        };

        public void logToAgent(LogLevel logLevel, String str) {
            String strValidate = this.validator.validate(str);
            AgentLog agentLog = AgentLogManager.getAgentLog();
            int i = C37712.$SwitchMap$com$newrelic$agent$android$logging$LogLevel[logLevel.ordinal()];
            if (i == 1) {
                agentLog.error(strValidate);
                return;
            }
            if (i == 2) {
                agentLog.warn(strValidate);
                return;
            }
            if (i == 3) {
                agentLog.info(strValidate);
            } else if (i == 4) {
                agentLog.verbose(strValidate);
            } else {
                if (i != 5) {
                    return;
                }
                agentLog.debug(strValidate);
            }
        }

        @Override // com.newrelic.agent.android.logging.Logger
        public void log(LogLevel logLevel, String str) {
            logToAgent(logLevel, str);
        }

        @Override // com.newrelic.agent.android.logging.Logger
        public void logThrowable(LogLevel logLevel, String str, Throwable th) {
            if (th == null) {
                logToAgent(logLevel, str);
                return;
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            logToAgent(logLevel, String.format(Locale.getDefault(), "%s %s", str, stringWriter));
        }

        @Override // com.newrelic.agent.android.logging.Logger
        public void logAttributes(Map<String, Object> map) {
            final Map<String, Object> mapValidate = this.validator.validate(map);
            logToAgent(LogLevel.valueOf(((String) mapValidate.getOrDefault("level", LogLevel.INFO.name())).toUpperCase()), String.format(Locale.getDefault(), "%s: %s", "newrelic", (String) mapValidate.keySet().stream().map(new Function() { // from class: com.newrelic.agent.android.logging.LogReporting$AgentLogger$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return LogReporting.AgentLogger.lambda$logAttributes$0(mapValidate, (String) obj);
                }
            }).collect(Collectors.joining(",", "{", "}"))));
        }

        static /* synthetic */ String lambda$logAttributes$0(Map map, String str) {
            return str + "=" + String.valueOf(map.get(str));
        }

        @Override // com.newrelic.agent.android.logging.Logger
        public void logAll(Throwable th, Map<String, Object> map) {
            String str;
            final Map<String, Object> mapValidate = this.validator.validate(map);
            String str2 = (String) mapValidate.getOrDefault("level", LogLevel.INFO.name());
            String str3 = (String) mapValidate.keySet().stream().map(new Function() { // from class: com.newrelic.agent.android.logging.LogReporting$AgentLogger$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return LogReporting.AgentLogger.lambda$logAll$1(mapValidate, (String) obj);
                }
            }).collect(Collectors.joining(",", "{", "}"));
            if (th == null) {
                str = String.format(Locale.getDefault(), "%s: %s", "newrelic", str3);
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = String.format(Locale.getDefault(), "%s: %s %s", "newrelic", str3, stringWriter);
            }
            logToAgent(LogLevel.valueOf(str2.toUpperCase()), str);
        }

        static /* synthetic */ String lambda$logAll$1(Map map, String str) {
            return str + "=" + String.valueOf(map.get(str));
        }
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.logging.LogReporting$2 */
    static /* synthetic */ class C37712 {
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

    protected static Map<String, Object> validateLogData(MessageValidator messageValidator, Map<String, Object> map) {
        if (map != null) {
            map.forEach(new BiConsumer() { // from class: com.newrelic.agent.android.logging.LogReporting$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    LogReporting.lambda$validateLogData$0((String) obj, obj2);
                }
            });
        }
        return map;
    }

    static /* synthetic */ void lambda$validateLogData$0(String str, Object obj) {
        boolean z = obj instanceof String;
    }
}
