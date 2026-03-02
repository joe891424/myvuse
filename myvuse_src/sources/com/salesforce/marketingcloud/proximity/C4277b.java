package com.salesforce.marketingcloud.proximity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.collection.ArraySet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.proximity.AbstractC4280e;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.List;
import java.util.Set;
import org.altbeacon.beacon.service.BeaconService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.b */
/* JADX INFO: loaded from: classes6.dex */
class C4277b extends AbstractC4280e {

    /* JADX INFO: renamed from: i */
    private final Context f5435i;

    /* JADX INFO: renamed from: j */
    private final Set<AbstractC4280e.a> f5436j;

    /* JADX INFO: renamed from: k */
    private final C4276a f5437k;

    /* JADX INFO: renamed from: l */
    private BroadcastReceiver f5438l;

    /* JADX INFO: renamed from: m */
    private int f5439m;

    /* JADX INFO: renamed from: n */
    private int f5440n;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.b$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(AbstractC4280e.f5452h, "Received null intent.", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(AbstractC4280e.f5452h, "Received null action", new Object[0]);
                return;
            }
            if (action.equals(AbstractC4280e.f5448d)) {
                C4277b.this.m3890a((C4278c) intent.getParcelableExtra(AbstractC4280e.f5450f));
            } else if (action.equals(AbstractC4280e.f5449e)) {
                C4277b.this.m3893b((C4278c) intent.getParcelableExtra(AbstractC4280e.f5450f));
            } else {
                C4170g.m3202a(AbstractC4280e.f5452h, "Received unknown action: ", action);
            }
        }
    }

    public C4277b(Context context) {
        this(context, null);
    }

    /* JADX INFO: renamed from: a */
    void m3890a(C4278c c4278c) {
        synchronized (this.f5436j) {
            this.f5439m++;
            if (c4278c != null && !this.f5436j.isEmpty()) {
                C4170g.m3210c(AbstractC4280e.f5452h, "Entered %s", c4278c);
                for (AbstractC4280e.a aVar : this.f5436j) {
                    if (aVar != null) {
                        aVar.mo3821b(c4278c);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m3893b(C4278c c4278c) {
        synchronized (this.f5436j) {
            this.f5440n++;
            if (c4278c != null && !this.f5436j.isEmpty()) {
                C4170g.m3210c(AbstractC4280e.f5452h, "Exited %s", c4278c);
                for (AbstractC4280e.a aVar : this.f5436j) {
                    if (aVar != null) {
                        aVar.mo3820a(c4278c);
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: b */
    public boolean mo3896b() {
        return true;
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: c */
    public void mo3897c() {
        C4276a c4276a = this.f5437k;
        if (c4276a != null) {
            c4276a.m3889d();
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObjectM3911a;
        try {
            jSONObjectM3911a = AbstractC4280e.m3911a();
            try {
                jSONObjectM3911a.put("enteredEvents", this.f5439m);
                jSONObjectM3911a.put("exitedEvents", this.f5440n);
            } catch (JSONException e) {
                e = e;
                C4170g.m3207b(AbstractC4280e.f5452h, e, "Failed to create component state.", new Object[0]);
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObjectM3911a = null;
        }
        return jSONObjectM3911a;
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        mo3897c();
        Context context = this.f5435i;
        if (context == null || this.f5438l == null) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f5438l);
    }

    public C4277b(Context context, ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions) throws IllegalStateException {
        this.f5436j = new ArraySet();
        C4391j.m4326a(context, "Context is null");
        this.f5435i = context;
        if (!C4389h.m4323b(context.getPackageManager(), new Intent(context, (Class<?>) BeaconService.class))) {
            throw new IllegalStateException("AltBeacon service not found");
        }
        this.f5437k = new C4276a(context, proximityNotificationCustomizationOptions);
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        c4081a.m2808d(false);
        this.f5438l = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AbstractC4280e.f5448d);
        intentFilter.addAction(AbstractC4280e.f5449e);
        LocalBroadcastManager.getInstance(this.f5435i).registerReceiver(this.f5438l, intentFilter);
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: a */
    public void mo3892a(List<C4278c> list) {
        if (list != null) {
            C4170g.m3210c(AbstractC4280e.f5452h, "monitorBeaconRegions(%d region)", Integer.valueOf(list.size()));
            this.f5437k.m3887a(list);
        }
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: b */
    public void mo3895b(List<C4278c> list) {
        if (list != null) {
            C4170g.m3210c(AbstractC4280e.f5452h, "unmonitorBeaconRegions(%d region)", Integer.valueOf(list.size()));
            this.f5437k.m3888b(list);
        }
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: a */
    public void mo3891a(AbstractC4280e.a aVar) {
        synchronized (this.f5436j) {
            if (aVar != null) {
                this.f5436j.add(aVar);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: b */
    public void mo3894b(AbstractC4280e.a aVar) {
        synchronized (this.f5436j) {
            this.f5436j.remove(aVar);
        }
    }
}
