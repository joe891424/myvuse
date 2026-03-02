package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestTimer implements Runnable {
    public static final long DEFAULT_HARVEST_PERIOD = TimeUnit.SECONDS.toMillis(60);
    private static final long HARVEST_PERIOD_LEEWAY = TimeUnit.SECONDS.toMillis(1);
    private static final long NEVER_TICKED = -1;
    protected final Harvester harvester;
    protected long lastTickTime;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Harvester"));
    private final AgentLog log = AgentLogManager.getAgentLog();
    private ScheduledFuture tickFuture = null;
    protected long period = DEFAULT_HARVEST_PERIOD;
    private final Lock lock = new ReentrantLock();
    private long startTimeMs = 0;

    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
    }

    public HarvestTimer(Harvester harvester) {
        this.harvester = harvester;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                this.lock.lock();
                tickIfReady();
            } catch (Exception e) {
                this.log.error("HarvestTimer: Exception in timer tick: " + e.getMessage());
                AgentHealth.noticeException(e);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void tickIfReady() {
        long jTimeSinceLastTick = timeSinceLastTick();
        if (HARVEST_PERIOD_LEEWAY + jTimeSinceLastTick < this.period && jTimeSinceLastTick != -1) {
            this.log.debug("HarvestTimer: Tick is too soon (" + jTimeSinceLastTick + " delta) Last tick time: " + this.lastTickTime + " . Skipping.");
            return;
        }
        this.log.debug("HarvestTimer: time since last tick: " + jTimeSinceLastTick);
        try {
            tick();
        } catch (Exception e) {
            this.log.error("HarvestTimer: Exception in timer tick: " + e.getMessage());
            AgentHealth.noticeException(e);
        }
        this.log.debug("Set last tick time to: " + this.lastTickTime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tick() {
        this.log.debug("Harvest: tick");
        TicToc ticTocTic = new TicToc().tic();
        try {
            if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting)) {
                this.harvester.execute();
                this.log.debug("Harvest: executed");
                this.log.debug("Harvest: executed in the background");
            } else if (ApplicationStateMonitor.isAppInBackground()) {
                this.log.error("HarvestTimer: Attempting to harvest while app is in background");
            } else {
                this.harvester.execute();
                this.log.debug("Harvest: executed");
            }
            this.lastTickTime = now();
        } catch (Exception e) {
            this.log.error("HarvestTimer: Exception in harvest execute: " + e.getMessage());
            AgentHealth.noticeException(e);
        }
        if (this.harvester.isDisabled()) {
            stop();
        }
        this.log.debug("HarvestTimer tick took " + ticTocTic.toc() + "ms");
    }

    public void start() {
        if (!FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
            this.log.warn("HarvestTimer: Attempting to start while app is in background");
            return;
        }
        if (isRunning()) {
            this.log.warn("HarvestTimer: Attempting to start while already running");
            return;
        }
        long j = this.period;
        if (j <= 0) {
            this.log.error("HarvestTimer: Refusing to start with a period of 0 ms");
            return;
        }
        this.log.debug("HarvestTimer: Starting with a period of " + j + "ms");
        this.startTimeMs = now();
        this.tickFuture = this.scheduler.scheduleWithFixedDelay(this, 0L, this.period, TimeUnit.MILLISECONDS);
        this.harvester.start();
    }

    public void stop() {
        if (!isRunning()) {
            this.log.warn("HarvestTimer: Attempting to stop when not running");
            return;
        }
        cancelPendingTasks();
        this.log.debug("HarvestTimer: Stopped");
        this.startTimeMs = 0L;
        this.harvester.stop();
    }

    public void shutdown() {
        cancelPendingTasks();
        this.scheduler.shutdownNow();
    }

    public void tickNow(boolean z) {
        try {
            ScheduledFuture<?> scheduledFutureSchedule = this.scheduler.schedule(new Runnable() { // from class: com.newrelic.agent.android.harvest.HarvestTimer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.tick();
                }
            }, 0L, TimeUnit.MILLISECONDS);
            if (!z || scheduledFutureSchedule.isCancelled()) {
                return;
            }
            scheduledFutureSchedule.get();
            this.startTimeMs = now();
        } catch (Exception e) {
            this.log.error("Exception waiting for tickNow to finish: " + e.getMessage());
            AgentHealth.noticeException(e);
        }
    }

    public boolean isRunning() {
        return this.tickFuture != null;
    }

    public void setPeriod(long j) {
        this.period = j;
    }

    public long timeSinceLastTick() {
        if (this.lastTickTime == 0) {
            return -1L;
        }
        return now() - this.lastTickTime;
    }

    public long timeSinceStart() {
        if (this.startTimeMs == 0) {
            return 0L;
        }
        return now() - this.startTimeMs;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    protected void cancelPendingTasks() {
        try {
            this.lock.lock();
            ScheduledFuture scheduledFuture = this.tickFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.tickFuture = null;
            }
        } finally {
            this.lock.unlock();
        }
    }
}
