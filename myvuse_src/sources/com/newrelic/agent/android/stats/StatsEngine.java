package com.newrelic.agent.android.stats;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class StatsEngine extends HarvestAdapter {
    public static final StatsEngine INSTANCE = new StatsEngine();
    public static final StatsEngine SUPPORTABILITY = new SupportabilityDecorator();
    static final AgentLog log = AgentLogManager.getAgentLog();
    public boolean enabled;
    private final ConcurrentHashMap<String, Metric> statsMap;

    private StatsEngine() {
        this.enabled = true;
        this.statsMap = new ConcurrentHashMap<>();
    }

    public static StatsEngine get() {
        return INSTANCE;
    }

    public static StatsEngine notice() {
        return SUPPORTABILITY;
    }

    public void inc(String str) {
        Metric metricLazyGet = lazyGet(str);
        synchronized (metricLazyGet) {
            metricLazyGet.increment();
        }
    }

    public void inc(String str, long j) {
        Metric metricLazyGet = lazyGet(str);
        synchronized (metricLazyGet) {
            metricLazyGet.increment(j);
        }
    }

    public void sample(String str, float f) {
        Metric metricLazyGet = lazyGet(str);
        synchronized (metricLazyGet) {
            metricLazyGet.sample(f);
        }
    }

    public void sampleMetricDataUsage(String str, float f, float f2) {
        Metric metricLazyGet = lazyGet(str);
        synchronized (metricLazyGet) {
            metricLazyGet.sampleMetricDataUsage(f, f2);
        }
    }

    public void sampleTimeMs(String str, long j) {
        float f = j;
        if (f >= 0.0f && str != null) {
            sample(str, f / 1000.0f);
        } else {
            log.error("StatsEngine.sampleTimeMs() called with negative time value[" + j + "] or missing metric name.");
        }
    }

    public static void populateMetrics() {
        Iterator<Map.Entry<String, Metric>> it2 = INSTANCE.getStatsMap().entrySet().iterator();
        while (it2.hasNext()) {
            Metric value = it2.next().getValue();
            sanitizeSessionStartMetric(value);
            TaskQueue.queue(value);
        }
        Iterator<Map.Entry<String, Metric>> it3 = SUPPORTABILITY.getStatsMap().entrySet().iterator();
        while (it3.hasNext()) {
            TaskQueue.queue(it3.next().getValue());
        }
    }

    private static void sanitizeSessionStartMetric(Metric metric) {
        if (metric.getCount() <= 1 || !metric.getName().contains(MetricNames.SESSION_START)) {
            return;
        }
        SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_SESSION_START_COUNT_VALUE_OVERFLOW);
        metric.setTotal(Double.valueOf(1.0d));
        metric.setCount(1L);
        metric.setMin(Double.valueOf(1.0d));
        metric.setMax(Double.valueOf(1.0d));
        metric.setSumOfSquares(Double.valueOf(1.0d));
    }

    public static void calculateMetricsDataUseage() {
        String strReplace = MetricNames.SUPPORTABILITY_DESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR);
        Iterator<Map.Entry<String, Metric>> it2 = INSTANCE.getStatsMap().entrySet().iterator();
        long count = 0;
        float total = 0.0f;
        float exclusive = 0.0f;
        while (it2.hasNext()) {
            Metric value = it2.next().getValue();
            String name = value.getName();
            if (name.contains("Collector/connect") || name.contains("Collector/data") || name.contains("Collector/f") || name.contains("Collector/mobile_crash")) {
                count += value.getCount();
                total = (float) (((double) total) + value.getTotal());
                exclusive = (float) (((double) exclusive) + value.getExclusive());
            }
        }
        Iterator<Map.Entry<String, Metric>> it3 = SUPPORTABILITY.getStatsMap().entrySet().iterator();
        while (it3.hasNext()) {
            Metric value2 = it3.next().getValue();
            String name2 = value2.getName();
            if (name2.contains("Collector/connect") || name2.contains("Collector/data") || name2.contains("Collector/f") || name2.contains("Collector/mobile_crash")) {
                count += value2.getCount();
                total = (float) (((double) total) + value2.getTotal());
                exclusive = (float) (((double) exclusive) + value2.getExclusive());
            }
        }
        get().inc(strReplace, count - 1);
        get().sampleMetricDataUsage(strReplace, total, exclusive);
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        calculateMetricsDataUseage();
        populateMetrics();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestComplete() {
        reset();
    }

    public static void reset() {
        INSTANCE.getStatsMap().clear();
        SUPPORTABILITY.getStatsMap().clear();
    }

    public static synchronized void disable() {
        INSTANCE.enabled = false;
        SUPPORTABILITY.enabled = false;
    }

    public static synchronized void enable() {
        INSTANCE.enabled = true;
        SUPPORTABILITY.enabled = true;
    }

    public ConcurrentHashMap<String, Metric> getStatsMap() {
        return this.statsMap;
    }

    protected Metric lazyGet(String str) {
        Metric metric = this.statsMap.get(str);
        if (metric == null) {
            metric = new Metric(str);
            if (this.enabled) {
                this.statsMap.put(str, metric);
            }
        }
        return metric;
    }

    static class SupportabilityDecorator extends StatsEngine {
        SupportabilityDecorator() {
            super();
        }

        String emptyIfNull(String str) {
            return str == null ? "" : str;
        }

        @Override // com.newrelic.agent.android.stats.StatsEngine
        protected Metric lazyGet(String str) {
            DeviceInformation deviceInformation = Agent.getDeviceInformation();
            String strEmptyIfNull = emptyIfNull(null);
            String strEmptyIfNull2 = emptyIfNull(null);
            String strEmptyIfNull3 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
            String strEmptyIfNull4 = emptyIfNull(deviceInformation.getAgentVersion());
            if (deviceInformation.getApplicationFramework() != null) {
                if (Objects.requireNonNull(deviceInformation.getApplicationFramework()) == ApplicationFramework.Native) {
                    if (!strEmptyIfNull3.isEmpty() && !strEmptyIfNull3.equals(strEmptyIfNull4)) {
                        strEmptyIfNull = emptyIfNull(deviceInformation.getApplicationFramework().name());
                        strEmptyIfNull2 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
                    }
                } else {
                    strEmptyIfNull = emptyIfNull(deviceInformation.getApplicationFramework().name());
                    if (!strEmptyIfNull3.equals(strEmptyIfNull4)) {
                        strEmptyIfNull2 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
                    }
                }
            }
            String strReplaceAll = str.replaceAll(MetricNames.TAG_FRAMEWORK, emptyIfNull(strEmptyIfNull)).replaceAll(MetricNames.TAG_FRAMEWORK_VERSION, emptyIfNull(strEmptyIfNull2));
            while (strReplaceAll.contains("//")) {
                strReplaceAll = strReplaceAll.replaceAll("//", "/");
            }
            return super.lazyGet(strReplaceAll);
        }
    }
}
