package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class MeasurementPool extends BaseMeasurementProducer implements MeasurementConsumer {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final CopyOnWriteArrayList<MeasurementConsumer> consumers;
    private final CopyOnWriteArrayList<MeasurementProducer> producers;

    public MeasurementPool() {
        super(MeasurementType.Any);
        this.producers = new CopyOnWriteArrayList<>();
        this.consumers = new CopyOnWriteArrayList<>();
        addMeasurementProducer(this);
    }

    public void addMeasurementProducer(MeasurementProducer measurementProducer) {
        if (measurementProducer != null) {
            if (this.producers.addIfAbsent(measurementProducer)) {
                return;
            }
            log.debug("Attempted to add the same MeasurementProducer " + String.valueOf(measurementProducer) + "  multiple times.");
            return;
        }
        log.debug("Attempted to add null MeasurementProducer.");
    }

    public void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        if (this.producers.remove(measurementProducer)) {
            return;
        }
        log.debug("Attempted to remove MeasurementProducer " + String.valueOf(measurementProducer) + " which is not registered.");
    }

    public void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        if (measurementConsumer != null) {
            if (this.consumers.addIfAbsent(measurementConsumer)) {
                return;
            }
            log.debug("Attempted to add the same MeasurementConsumer " + String.valueOf(measurementConsumer) + " multiple times.");
            return;
        }
        log.debug("Attempted to add null MeasurementConsumer.");
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        if (this.consumers.remove(measurementConsumer)) {
            return;
        }
        log.debug("Attempted to remove MeasurementConsumer " + String.valueOf(measurementConsumer) + " which is not registered.");
    }

    public void broadcastMeasurements() {
        ArrayList<Measurement> arrayList = new ArrayList();
        Iterator<MeasurementProducer> it2 = this.producers.iterator();
        while (it2.hasNext()) {
            Collection<Measurement> collectionDrainMeasurements = it2.next().drainMeasurements();
            if (collectionDrainMeasurements.size() > 0) {
                arrayList.addAll(collectionDrainMeasurements);
                while (arrayList.remove((Object) null)) {
                }
            }
        }
        if (arrayList.size() > 0) {
            for (MeasurementConsumer measurementConsumer : this.consumers) {
                for (Measurement measurement : arrayList) {
                    if (measurementConsumer.getMeasurementType() == measurement.getType() || measurementConsumer.getMeasurementType() == MeasurementType.Any) {
                        try {
                            measurementConsumer.consumeMeasurement(measurement);
                        } catch (Exception e) {
                            ExceptionHelper.exceptionToErrorCode(e);
                            log.error("broadcastMeasurements exception[" + e.getClass().getName() + "]");
                        }
                    }
                }
            }
        }
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
        produceMeasurement(measurement);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurements(Collection<Measurement> collection) {
        produceMeasurements(collection);
    }

    @Override // com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer, com.newrelic.agent.android.measurement.producer.MeasurementProducer, com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public MeasurementType getMeasurementType() {
        return MeasurementType.Any;
    }

    public Collection<MeasurementProducer> getMeasurementProducers() {
        return this.producers;
    }

    public Collection<MeasurementConsumer> getMeasurementConsumers() {
        return this.consumers;
    }
}
