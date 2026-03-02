package com.salesforce.marketingcloud.proximity;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.WorkRequest;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.internal.C4185h;
import com.salesforce.marketingcloud.notifications.C4275c;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.powersave.BackgroundPowerSaver;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.a */
/* JADX INFO: loaded from: classes6.dex */
class C4276a implements BeaconConsumer, MonitorNotifier {

    /* JADX INFO: renamed from: k */
    static final String f5420k = "m:0-3=4c000215,i:4-19,i:20-21,i:22-23,p:24-24";

    /* JADX INFO: renamed from: l */
    static final int f5421l = 121;

    /* JADX INFO: renamed from: m */
    static final String f5422m = "0ahUKEwj";

    /* JADX INFO: renamed from: a */
    final Map<String, Region> f5423a;

    /* JADX INFO: renamed from: b */
    private final BeaconManager f5424b;

    /* JADX INFO: renamed from: c */
    private final Context f5425c;

    /* JADX INFO: renamed from: d */
    private final List<C4278c> f5426d;

    /* JADX INFO: renamed from: e */
    final LocalBroadcastManager f5427e;

    /* JADX INFO: renamed from: f */
    private boolean f5428f;

    /* JADX INFO: renamed from: g */
    private boolean f5429g;

    /* JADX INFO: renamed from: h */
    private BackgroundPowerSaver f5430h;

    /* JADX INFO: renamed from: i */
    private Intent f5431i;

    /* JADX INFO: renamed from: j */
    private final ProximityNotificationCustomizationOptions f5432j;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.a$a */
    class a implements MarketingCloudSdk.WhenReadyListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Intent f5433a;

        a(Intent intent) {
            this.f5433a = intent;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            C4276a.this.f5427e.sendBroadcast(this.f5433a);
        }
    }

    C4276a(Context context) {
        this(context, null);
    }

    /* JADX INFO: renamed from: a */
    private void m3882a() {
        String str = AbstractC4280e.f5452h;
        C4170g.m3213d(str, "clearAllMonitoredRegions", new Object[0]);
        if (this.f5423a.isEmpty()) {
            return;
        }
        C4170g.m3213d(str, "Stop monitoring %d BeaconRegions", Integer.valueOf(this.f5423a.size()));
        for (Region region : this.f5423a.values()) {
            if (region != null) {
                m3885b(region);
            }
        }
        this.f5423a.clear();
    }

    /* JADX INFO: renamed from: b */
    private void m3884b() {
        this.f5429g = true;
        this.f5424b.bind(this);
        C4170g.m3202a(AbstractC4280e.f5452h, "Waiting for BeaconService connection", new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    private void m3886c() {
        C4170g.m3213d(AbstractC4280e.f5452h, "monitorNewRegions", new Object[0]);
        if (this.f5426d.isEmpty()) {
            return;
        }
        for (C4278c c4278c : this.f5426d) {
            if (this.f5423a.containsKey(c4278c.m3905f())) {
                C4170g.m3213d(AbstractC4280e.f5452h, "Region [%s] already monitored by SDK", c4278c);
            } else {
                Region regionM3881a = m3881a(c4278c);
                this.f5423a.put(c4278c.m3905f(), regionM3881a);
                C4170g.m3213d(AbstractC4280e.f5452h, "Now monitoring [%s]", c4278c.toString());
                this.f5424b.startMonitoring(regionM3881a);
            }
        }
        this.f5426d.clear();
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        this.f5431i = intent;
        this.f5425c.startService(intent);
        return this.f5425c.bindService(intent, serviceConnection, i);
    }

    /* JADX INFO: renamed from: d */
    public void m3889d() {
        C4170g.m3202a(AbstractC4280e.f5452h, "stopMonitoring()", new Object[0]);
        synchronized (this.f5426d) {
            if (this.f5428f) {
                m3882a();
                this.f5424b.unbind(this);
                this.f5424b.removeMonitorNotifier(this);
                if (this.f5430h != null) {
                    ((Application) this.f5425c.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f5430h);
                }
                this.f5428f = false;
            } else {
                this.f5426d.clear();
            }
        }
    }

    public void didDetermineStateForRegion(int i, Region region) {
        String str = AbstractC4280e.f5452h;
        C4170g.m3213d(str, "didDetermineStateForRegion(%d, %s)", Integer.valueOf(i), region);
        if (!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) {
            C4170g.m3216e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        Intent intentPutExtra = new Intent(i == 1 ? AbstractC4280e.f5448d : AbstractC4280e.f5449e).putExtra(AbstractC4280e.f5450f, m3880a(region));
        if (MarketingCloudSdk.isReady()) {
            this.f5427e.sendBroadcast(intentPutExtra);
        } else {
            MarketingCloudSdk.requestSdk(new a(intentPutExtra));
        }
    }

    public void didEnterRegion(Region region) {
        C4170g.m3213d(AbstractC4280e.f5452h, "didEnterRegion(%s)", region);
    }

    public void didExitRegion(Region region) {
        C4170g.m3213d(AbstractC4280e.f5452h, "didExitRegion(%s)", region);
    }

    public Context getApplicationContext() {
        return this.f5425c;
    }

    public void onBeaconServiceConnect() {
        C4170g.m3202a(AbstractC4280e.f5452h, "onBeaconServiceConnect", new Object[0]);
        synchronized (this.f5426d) {
            this.f5430h = new BackgroundPowerSaver(this.f5425c);
            this.f5424b.addMonitorNotifier(this);
            this.f5428f = true;
            this.f5429g = false;
            m3886c();
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        this.f5425c.unbindService(serviceConnection);
        this.f5425c.stopService(this.f5431i);
        this.f5428f = false;
        this.f5429g = false;
    }

    C4276a(Context context, ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions) {
        this.f5423a = new ArrayMap();
        this.f5426d = new ArrayList();
        this.f5425c = context;
        this.f5427e = LocalBroadcastManager.getInstance(context);
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context);
        this.f5424b = instanceForApplication;
        this.f5432j = proximityNotificationCustomizationOptions;
        instanceForApplication.getBeaconParsers().add(new BeaconParser("iBeacon").setBeaconLayout(f5420k));
        instanceForApplication.setBackgroundScanPeriod(5000L);
        instanceForApplication.setBackgroundBetweenScanPeriod(WorkRequest.MIN_BACKOFF_MILLIS);
        instanceForApplication.addMonitorNotifier(this);
    }

    /* JADX INFO: renamed from: a */
    private void m3883a(ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions) {
        if (proximityNotificationCustomizationOptions != null) {
            C4275c c4275c = new C4275c(proximityNotificationCustomizationOptions.getSmallIconResId(), proximityNotificationCustomizationOptions.getChannelIdProvider());
            HashMap map = new HashMap();
            map.put("alert", "Searching for available beacons ...");
            map.put(NotificationMessage.NOTIF_KEY_ID, f5422m);
            Notification notificationBuild = c4275c.setupNotificationBuilder(this.f5425c, C4185h.m3377a(map)).build();
            if (this.f5424b.isAnyConsumerBound()) {
                return;
            }
            this.f5424b.enableForegroundServiceScanning(notificationBuild, f5421l);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3888b(List<C4278c> list) {
        C4170g.m3202a(AbstractC4280e.f5452h, "unmonitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        if (list.isEmpty()) {
            return;
        }
        for (C4278c c4278c : list) {
            this.f5423a.remove(c4278c.m3905f());
            m3885b(m3881a(c4278c));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3885b(Region region) {
        try {
            this.f5424b.stopMonitoring(region);
        } catch (Exception e) {
            C4170g.m3203a(AbstractC4280e.f5452h, e, "Failed to stop monitoring %s", region);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3887a(List<C4278c> list) {
        String str = AbstractC4280e.f5452h;
        C4170g.m3202a(str, "monitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        m3883a(this.f5432j);
        this.f5424b.addMonitorNotifier(this);
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f5426d) {
            this.f5426d.clear();
            this.f5426d.addAll(list);
            if (this.f5428f) {
                m3886c();
            } else {
                C4170g.m3213d(str, "Not yet connected.  Will register Beacons once complete.", new Object[0]);
                if (!this.f5429g) {
                    m3884b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static C4278c m3880a(Region region) {
        try {
            return new C4278c(region.getUniqueId(), region.getId1().toString(), region.getId2().toInt(), region.getId3().toInt());
        } catch (Exception e) {
            C4170g.m3207b(AbstractC4280e.f5452h, e, "Unable to convert Region to BeaconRegion", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static Region m3881a(C4278c c4278c) {
        return new Region(c4278c.m3905f(), Identifier.fromUuid(UUID.fromString(c4278c.m3904e())), Identifier.fromInt(c4278c.m3906g()), Identifier.fromInt(c4278c.m3907h()));
    }
}
