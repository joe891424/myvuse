package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.MethodMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SummaryMetricMeasurementConsumer extends MetricMeasurementConsumer implements TraceLifecycleAware {
    protected static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Summary/Name/";
    protected static final String METRIC_PREFIX = "Mobile/Summary/";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected final List<ActivityTrace> completedTraces;

    public SummaryMetricMeasurementConsumer() {
        super(MeasurementType.Any);
        this.completedTraces = new CopyOnWriteArrayList();
        this.recordUnscopedMetrics = false;
        TraceMachine.addTraceListener(this);
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer$1 */
    static /* synthetic */ class C37741 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType */
        static final /* synthetic */ int[] f4043xb32dda8c;

        static {
            int[] iArr = new int[MeasurementType.values().length];
            f4043xb32dda8c = iArr;
            try {
                iArr[MeasurementType.Method.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4043xb32dda8c[MeasurementType.Network.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4043xb32dda8c[MeasurementType.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
        if (measurement != null) {
            int i = C37741.f4043xb32dda8c[measurement.getType().ordinal()];
            if (i == 1) {
                consumeMethodMeasurement((MethodMeasurement) measurement);
            } else if (i == 2) {
                consumeNetworkMeasurement((HttpTransactionMeasurement) measurement);
            } else {
                if (i != 3) {
                    return;
                }
                consumeCustomMeasurement((CustomMetricMeasurement) measurement);
            }
        }
    }

    void consumeMethodMeasurement(MethodMeasurement methodMeasurement) {
        if (methodMeasurement.getCategory() == null || methodMeasurement.getCategory() == MetricCategory.NONE) {
            methodMeasurement.setCategory(MetricCategory.categoryForMethod(methodMeasurement.getName()));
            if (methodMeasurement.getCategory() == MetricCategory.NONE) {
                return;
            }
        }
        BaseMeasurement baseMeasurement = new BaseMeasurement(methodMeasurement);
        baseMeasurement.setName(methodMeasurement.getCategory().getCategoryName());
        super.consumeMeasurement(baseMeasurement);
    }

    void consumeCustomMeasurement(CustomMetricMeasurement customMetricMeasurement) {
        if (customMetricMeasurement.getCategory() == null || customMetricMeasurement.getCategory() == MetricCategory.NONE) {
            return;
        }
        BaseMeasurement baseMeasurement = new BaseMeasurement(customMetricMeasurement);
        baseMeasurement.setName(customMetricMeasurement.getCategory().getCategoryName());
        super.consumeMeasurement(baseMeasurement);
    }

    void consumeNetworkMeasurement(HttpTransactionMeasurement httpTransactionMeasurement) {
        BaseMeasurement baseMeasurement = new BaseMeasurement(httpTransactionMeasurement);
        baseMeasurement.setName(MetricCategory.NETWORK.getCategoryName());
        super.consumeMeasurement(baseMeasurement);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer
    protected String formatMetricName(String str) {
        return METRIC_PREFIX + (str != null ? str.replace("#", "/") : "");
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer, com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        if (this.metrics.getAll().size() == 0 || this.completedTraces.size() == 0) {
            return;
        }
        Iterator<ActivityTrace> it2 = this.completedTraces.iterator();
        while (it2.hasNext()) {
            summarizeActivityMetrics(it2.next());
        }
        if (this.metrics.getAll().size() != 0) {
            log.debug("Not all metrics were summarized!");
        }
        this.completedTraces.clear();
    }

    void summarizeActivityNetworkMetrics(ActivityTrace activityTrace) {
        String activityName = activityTrace.getActivityName();
        if (activityTrace.networkCountMetric.getCount() > 0) {
            activityTrace.networkCountMetric.setName(activityTrace.networkCountMetric.getName().replace("<activity>", activityName));
            activityTrace.networkCountMetric.setCount(1L);
            activityTrace.networkCountMetric.setMinFieldValue(Double.valueOf(activityTrace.networkCountMetric.getTotal()));
            activityTrace.networkCountMetric.setMaxFieldValue(Double.valueOf(activityTrace.networkCountMetric.getTotal()));
            Harvest.addMetric(activityTrace.networkCountMetric);
        }
        if (activityTrace.networkTimeMetric.getCount() > 0) {
            activityTrace.networkTimeMetric.setName(activityTrace.networkTimeMetric.getName().replace("<activity>", activityName));
            activityTrace.networkTimeMetric.setCount(1L);
            activityTrace.networkTimeMetric.setMinFieldValue(Double.valueOf(activityTrace.networkTimeMetric.getTotal()));
            activityTrace.networkTimeMetric.setMaxFieldValue(Double.valueOf(activityTrace.networkTimeMetric.getTotal()));
            Harvest.addMetric(activityTrace.networkTimeMetric);
        }
    }

    void summarizeActivityMetrics(ActivityTrace activityTrace) {
        Trace trace = activityTrace.rootTrace;
        List<Metric> listRemoveAllWithScope = this.metrics.removeAllWithScope(trace.metricName);
        List<Metric> listRemoveAllWithScope2 = this.metrics.removeAllWithScope(trace.metricBackgroundName);
        HashMap map = new HashMap();
        for (Metric metric : listRemoveAllWithScope) {
            map.put(metric.getName(), metric);
        }
        for (Metric metric2 : listRemoveAllWithScope2) {
            if (map.containsKey(metric2.getName())) {
                ((Metric) map.get(metric2.getName())).aggregate(metric2);
            } else {
                map.put(metric2.getName(), metric2);
            }
        }
        Iterator it2 = map.values().iterator();
        double exclusive = 0.0d;
        while (it2.hasNext()) {
            exclusive += ((Metric) it2.next()).getExclusive();
        }
        double d = (trace.exitTimestamp - trace.entryTimestamp) / 1000.0d;
        for (Metric metric3 : map.values()) {
            double exclusive2 = ((metric3.getExclusive() == 0.0d || exclusive == 0.0d) ? 0.0d : metric3.getExclusive() / exclusive) * d;
            metric3.setTotal(Double.valueOf(exclusive2));
            metric3.setExclusive(Double.valueOf(exclusive2));
            metric3.setMinFieldValue(Double.valueOf(0.0d));
            metric3.setMaxFieldValue(Double.valueOf(0.0d));
            metric3.setSumOfSquares(Double.valueOf(0.0d));
            metric3.setScope(ACTIVITY_METRIC_PREFIX + trace.displayName);
            Harvest.addMetric(metric3);
            Metric metric4 = new Metric(metric3);
            metric4.setScope(null);
            Harvest.addMetric(metric4);
        }
        summarizeActivityNetworkMetrics(activityTrace);
    }

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onTraceComplete(ActivityTrace activityTrace) {
        if (this.completedTraces.contains(activityTrace)) {
            return;
        }
        this.completedTraces.add(activityTrace);
    }
}
