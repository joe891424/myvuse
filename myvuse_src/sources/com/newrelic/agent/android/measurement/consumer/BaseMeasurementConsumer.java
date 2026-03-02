package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class BaseMeasurementConsumer extends HarvestAdapter implements MeasurementConsumer {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    private final MeasurementType measurementType;

    @Override // com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
    }

    public BaseMeasurementConsumer(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public MeasurementType getMeasurementType() {
        return this.measurementType;
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurements(Collection<Measurement> collection) {
        Iterator<Measurement> it2 = collection.iterator();
        while (it2.hasNext()) {
            consumeMeasurement(it2.next());
        }
    }
}
