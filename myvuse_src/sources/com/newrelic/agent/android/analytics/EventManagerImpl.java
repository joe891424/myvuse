package com.newrelic.agent.android.analytics;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.HarvestTimer;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class EventManagerImpl implements EventManager, EventListener {
    protected static final int DEFAULT_MAX_EVENT_BUFFER_SIZE = 1000;
    protected static final int DEFAULT_MAX_EVENT_BUFFER_TIME = 600;
    public static final int DEFAULT_MIN_EVENT_BUFFER_SIZE = 64;
    private AnalyticsEventStore eventStore;
    private AtomicReference<List<AnalyticsEvent>> events;
    private final AtomicInteger eventsDropped;
    private final AtomicInteger eventsEvicted;
    private final AtomicInteger eventsRecorded;
    private long firstEventTimestamp;
    private final AtomicBoolean initialized;
    AtomicReference<EventManager> instance;
    private final AtomicReference<EventListener> listener;
    int maxBufferTimeInSec;
    int maxEventPoolSize;
    private final AtomicBoolean transmitRequired;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    public static final int DEFAULT_MIN_EVENT_BUFFER_TIME = (int) (HarvestTimer.DEFAULT_HARVEST_PERIOD / 1000);

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventFlush() {
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onStart(EventManager eventManager) {
    }

    public EventManagerImpl() {
        this(1000, 600);
    }

    public EventManagerImpl(int i, int i2) {
        this.initialized = new AtomicBoolean(false);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventsRecorded = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        this.eventsEvicted = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        this.eventsDropped = atomicInteger3;
        this.transmitRequired = new AtomicBoolean(true);
        this.listener = new AtomicReference<>(this);
        this.instance = new AtomicReference<>(null);
        this.events = new AtomicReference<>(Collections.synchronizedList(new ArrayList(i)));
        this.maxBufferTimeInSec = i2;
        this.maxEventPoolSize = i;
        this.firstEventTimestamp = 0L;
        atomicInteger.set(0);
        atomicInteger2.set(0);
        atomicInteger3.set(0);
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(this.instance, null, this);
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void initialize(AgentConfiguration agentConfiguration) {
        this.eventStore = agentConfiguration.getEventStore();
        List<AnalyticsEvent> arrayList = new ArrayList<>();
        AnalyticsEventStore analyticsEventStore = this.eventStore;
        if (analyticsEventStore != null) {
            arrayList = analyticsEventStore.fetchAll();
        }
        if (!this.initialized.compareAndSet(false, true)) {
            this.eventsRecorded.set(0);
            this.eventsEvicted.set(0);
            log.verbose("EventManagerImpl.initialize(): Has already been initialized. Bypassing...");
            Iterator<AnalyticsEvent> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                addEvent(it2.next());
            }
            return;
        }
        this.firstEventTimestamp = 0L;
        this.eventsRecorded.set(0);
        this.eventsEvicted.set(0);
        empty();
        Iterator<AnalyticsEvent> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            addEvent(it3.next());
        }
        this.listener.get().onStart(this);
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void shutdown() {
        this.listener.get().onShutdown();
        this.initialized.set(false);
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int size() {
        return this.events.get().size();
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void empty() {
        Collection<AnalyticsEvent> queuedEventsSnapshot = getQueuedEventsSnapshot();
        if (queuedEventsSnapshot.size() > 0) {
            log.warn("EventManager.empty(): dropped [" + queuedEventsSnapshot.size() + "] events");
        }
        queuedEventsSnapshot.clear();
        this.firstEventTimestamp = 0L;
    }

    public void empty(Collection<AnalyticsEvent> collection) {
        this.events.get().removeAll(collection);
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public boolean isTransmitRequired() {
        return (!this.initialized.get() && this.events.get().size() > 0) || this.transmitRequired.compareAndSet(true, false) || isMaxEventPoolSizeExceeded() || isMaxEventBufferTimeExceeded();
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void setTransmitRequired() {
        this.transmitRequired.set(true);
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public boolean addEvent(AnalyticsEvent analyticsEvent) {
        AnalyticsEventStore analyticsEventStore;
        if (!this.initialized.get()) {
            this.eventsDropped.incrementAndGet();
            return false;
        }
        if (!this.listener.get().onEventAdded(analyticsEvent)) {
            log.warn("Listener dropped new event[" + analyticsEvent.getName() + "]");
            this.eventsDropped.incrementAndGet();
            return false;
        }
        if (isMaxEventBufferTimeExceeded()) {
            this.listener.get().onEventQueueTimeExceeded(this.maxBufferTimeInSec);
        }
        synchronized (this.events.get()) {
            int size = this.events.get().size();
            if (size == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.firstEventTimestamp = jCurrentTimeMillis;
                log.debug("EventManager.addEvent(): Queue is empty, setting first event timestamp to " + jCurrentTimeMillis);
            }
            if (size >= this.maxEventPoolSize) {
                try {
                    if (this.listener.get().onEventOverflow(analyticsEvent)) {
                        AgentLog agentLog = log;
                        agentLog.warn("Listener dropped overflow event[" + analyticsEvent.getName() + "]");
                        this.eventsDropped.incrementAndGet();
                        agentLog.debug("Event queue is full, scheduling harvest");
                        return false;
                    }
                    int iRandom = (int) (Math.random() * ((double) this.eventsRecorded.get()));
                    if (iRandom >= this.maxEventPoolSize) {
                        if (this.listener.get().onEventEvicted(analyticsEvent)) {
                            this.eventsDropped.incrementAndGet();
                            return false;
                        }
                    } else if (this.listener.get().onEventEvicted(this.events.get().get(iRandom))) {
                        this.events.get().remove(iRandom);
                        this.eventsEvicted.incrementAndGet();
                    }
                    this.listener.get().onEventQueueSizeExceeded(size);
                    log.debug("Event queue is full, scheduling harvest");
                } finally {
                    log.debug("Event queue is full, scheduling harvest");
                }
            }
            if (!this.events.get().add(analyticsEvent)) {
                return false;
            }
            if (FeatureFlag.featureEnabled(FeatureFlag.EventPersistence) && (analyticsEventStore = this.eventStore) != null) {
                analyticsEventStore.store(analyticsEvent);
            }
            this.eventsRecorded.incrementAndGet();
            return true;
        }
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int getEventsRecorded() {
        return this.eventsRecorded.get();
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int getEventsEjected() {
        return this.eventsEvicted.get();
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int getEventsDropped() {
        return this.eventsDropped.get();
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public boolean isMaxEventBufferTimeExceeded() {
        return this.firstEventTimestamp > 0 && System.currentTimeMillis() - this.firstEventTimestamp > ((long) (this.maxBufferTimeInSec * 1000));
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public boolean isMaxEventPoolSizeExceeded() {
        return this.events.get().size() > this.maxEventPoolSize;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int getMaxEventPoolSize() {
        return this.maxEventPoolSize;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void setMaxEventPoolSize(int i) {
        if (i < 64) {
            log.error("Event queue cannot be smaller than 64");
            i = 64;
        }
        if (i > 1000) {
            log.warn("Event queue should not be larger than 1000");
        }
        this.maxEventPoolSize = i;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void setMaxEventBufferTime(int i) {
        int i2 = DEFAULT_MIN_EVENT_BUFFER_TIME;
        if (i < i2) {
            log.error("Event buffer time cannot be shorter than " + i2 + " seconds");
            i = i2;
        }
        if (i > 600) {
            log.warn("Event buffer time should not be longer than 600 seconds");
            i = 600;
        }
        this.maxBufferTimeInSec = i;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public int getMaxEventBufferTime() {
        return this.maxBufferTimeInSec;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public Collection<AnalyticsEvent> getQueuedEvents() {
        Collection<AnalyticsEvent> collectionUnmodifiableCollection;
        synchronized (this.events.get()) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.events.get());
        }
        return collectionUnmodifiableCollection;
    }

    Collection<AnalyticsEvent> getQueuedEventsSnapshot() {
        List<AnalyticsEvent> andSet;
        synchronized (this.events.get()) {
            this.listener.get().onEventFlush();
            this.transmitRequired.set(false);
            andSet = this.events.getAndSet(Collections.synchronizedList(new ArrayList(this.maxEventPoolSize)));
        }
        return andSet;
    }

    @Override // com.newrelic.agent.android.analytics.EventManager
    public void setEventListener(EventListener eventListener) {
        if (eventListener != null) {
            this.listener.set(eventListener);
        } else {
            this.listener.set(this);
        }
    }

    public EventListener getListener() {
        return this.listener.get();
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventAdded(AnalyticsEvent analyticsEvent) {
        log.debug("Event [" + String.valueOf(analyticsEvent.getCategory()) + "] added to queue");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_ADDED);
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventOverflow(AnalyticsEvent analyticsEvent) {
        log.warn("Event queue overflow adding event [" + analyticsEvent.getName() + "]");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_OVERFLOW);
        this.transmitRequired.set(true);
        return false;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public boolean onEventEvicted(AnalyticsEvent analyticsEvent) {
        log.warn("Event [" + analyticsEvent.getName() + "] evicted from queue");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_EVICTED);
        this.transmitRequired.set(true);
        return true;
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventQueueSizeExceeded(int i) {
        log.warn("Event queue size [" + i + "] exceeded max[" + this.maxEventPoolSize + "]");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_QUEUE_SIZE_EXCEEDED);
        this.transmitRequired.set(true);
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onEventQueueTimeExceeded(int i) {
        log.warn("Event queue time [" + i + "] exceeded");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_QUEUE_TIME_EXCEEDED);
        this.transmitRequired.set(true);
    }

    @Override // com.newrelic.agent.android.analytics.EventListener
    public void onShutdown() {
        if (!this.events.get().isEmpty()) {
            log.warn("Event manager is shutting down with [" + this.events.get().size() + "] events remaining in the queue");
        }
        this.transmitRequired.set(true);
    }
}
