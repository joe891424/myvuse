package com.salesforce.marketingcloud.behaviors;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class LifecycleManager extends AbstractC4169f implements LifecycleObserver {

    /* JADX INFO: renamed from: g */
    static LifecycleManager f4572g;

    /* JADX INFO: renamed from: d */
    private final Application f4573d;

    /* JADX INFO: renamed from: e */
    private final AtomicBoolean f4574e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f */
    AtomicBoolean f4575f = new AtomicBoolean(false);

    private LifecycleManager(Application application) {
        this.f4573d = application;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized LifecycleManager m3032a(Application application) {
        if (f4572g == null) {
            f4572g = new LifecycleManager(application);
        }
        return f4572g;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "LifecycleManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onApplicationBackgrounded() {
        if (this.f4575f.getAndSet(false)) {
            C4170g.m3202a(C4140c.f4595k, "Application went into the background.", new Object[0]);
            C4140c.m3035a(this.f4573d, EnumC4138a.BEHAVIOR_APP_BACKGROUNDED, new Bundle());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onApplicationForegrounded() {
        if (this.f4575f.getAndSet(true) || !this.f4574e.get()) {
            return;
        }
        C4170g.m3202a(C4140c.f4595k, "Application came into the foreground.", new Object[0]);
        C4140c.m3035a(this.f4573d, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, new Bundle());
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4574e.set(false);
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        this.f4574e.set(true);
        if (this.f4575f.get()) {
            C4140c.m3035a(this.f4573d, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, null);
        }
    }
}
