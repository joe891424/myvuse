package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestDataValidator extends HarvestAdapter {
    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestFinalize() {
        if (Harvest.isInitialized()) {
            ensureActivityNameMetricsExist();
        }
    }

    public void ensureActivityNameMetricsExist() {
        MachineMeasurements metrics;
        HarvestData harvestData = Harvest.getInstance().getHarvestData();
        ActivityTraces activityTraces = harvestData.getActivityTraces();
        if (activityTraces == null || activityTraces.count() == 0 || (metrics = harvestData.getMetrics()) == null || metrics.isEmpty()) {
            return;
        }
        Iterator<ActivityTrace> it2 = activityTraces.getActivityTraces().iterator();
        while (it2.hasNext()) {
            String strSubstring = it2.next().rootTrace.displayName;
            int iIndexOf = strSubstring.indexOf("#");
            if (iIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            String str = TraceMachine.ACTIVITY_METRIC_PREFIX + strSubstring;
            List<Metric> allUnscoped = metrics.getMetrics().getAllUnscoped();
            if (allUnscoped != null && allUnscoped.size() > 0) {
                Iterator<Metric> it3 = allUnscoped.iterator();
                while (it3.hasNext()) {
                    if (it3.next().getName().startsWith(str)) {
                        break;
                    }
                }
            }
            Metric metric = new Metric(str);
            metric.sample(1.0d);
            metrics.addMetric(metric);
        }
    }
}
