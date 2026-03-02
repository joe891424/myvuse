package com.newrelic.agent.android.background;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class ApplicationStateMonitor {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static ApplicationStateMonitor instance = null;
    protected final ArrayList<ApplicationStateListener> applicationStateListeners = new ArrayList<>();
    protected AtomicBoolean foregrounded = new AtomicBoolean(true);
    private AtomicLong activityCount = new AtomicLong(0);
    protected final ExecutorService executor = Executors.newSingleThreadExecutor(new NamedThreadFactory("AppStateMon"));

    public ApplicationStateMonitor() {
        log.info("Application state monitor has started");
    }

    public static ApplicationStateMonitor getInstance() {
        if (instance == null) {
            setInstance(new ApplicationStateMonitor());
        }
        return instance;
    }

    public static void setInstance(ApplicationStateMonitor applicationStateMonitor) {
        instance = applicationStateMonitor;
    }

    public void addApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.applicationStateListeners) {
            this.applicationStateListeners.add(applicationStateListener);
        }
    }

    public void removeApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.applicationStateListeners) {
            this.applicationStateListeners.remove(applicationStateListener);
        }
    }

    public void uiHidden() {
        this.executor.execute(new Runnable() { // from class: com.newrelic.agent.android.background.ApplicationStateMonitor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2725xe5a77411();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$uiHidden$0$com-newrelic-agent-android-background-ApplicationStateMonitor */
    /* synthetic */ void m2725xe5a77411() {
        if (this.foregrounded.get()) {
            log.info("UI has become hidden (app backgrounded)");
            notifyApplicationInBackground();
            this.foregrounded.set(false);
        }
    }

    public void activityStopped() {
        this.executor.execute(new Runnable() { // from class: com.newrelic.agent.android.background.ApplicationStateMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStateMonitor.this.activityCount.decrementAndGet() == 0) {
                    ApplicationStateMonitor.this.uiHidden();
                }
            }
        });
    }

    public void activityStarted() {
        this.executor.execute(new Runnable() { // from class: com.newrelic.agent.android.background.ApplicationStateMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2724x9190764c();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$activityStarted$1$com-newrelic-agent-android-background-ApplicationStateMonitor */
    /* synthetic */ void m2724x9190764c() {
        if (this.activityCount.incrementAndGet() != 1 || this.foregrounded.get()) {
            return;
        }
        this.foregrounded.set(true);
        notifyApplicationInForeground();
    }

    private void notifyApplicationInBackground() {
        ArrayList arrayList;
        log.verbose("Application appears to have gone to the background");
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((ApplicationStateListener) it2.next()).applicationBackgrounded(applicationStateEvent);
        }
    }

    private void notifyApplicationInForeground() {
        ArrayList arrayList;
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((ApplicationStateListener) it2.next()).applicationForegrounded(applicationStateEvent);
        }
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public boolean getForegrounded() {
        return this.foregrounded.get();
    }

    public static boolean isAppInBackground() {
        return !getInstance().getForegrounded();
    }
}
