package com.salesforce.marketingcloud.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import androidx.collection.ArraySet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.location.h */
/* JADX INFO: loaded from: classes6.dex */
class C4202h extends AbstractC4200f {

    /* JADX INFO: renamed from: q */
    final C4198d f5000q;

    /* JADX INFO: renamed from: r */
    final Set<InterfaceC4199e> f5001r = new ArraySet();

    /* JADX INFO: renamed from: s */
    private final Set<InterfaceC4197c> f5002s = new ArraySet();

    /* JADX INFO: renamed from: t */
    private MarketingCloudConfig f5003t;

    /* JADX INFO: renamed from: u */
    private int f5004u;

    /* JADX INFO: renamed from: v */
    private int f5005v;

    /* JADX INFO: renamed from: w */
    private String f5006w;

    /* JADX INFO: renamed from: x */
    private int f5007x;

    /* JADX INFO: renamed from: y */
    private Context f5008y;

    /* JADX INFO: renamed from: z */
    private BroadcastReceiver f5009z;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.h$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(AbstractC4200f.f4990h, "Received null intent", new Object[0]);
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(AbstractC4200f.f4990h, "Received null action", new Object[0]);
                return;
            }
            action.hashCode();
            switch (action) {
                case "com.salesforce.marketingcloud.location.LOCATION_UPDATE":
                    C4170g.m3202a(AbstractC4200f.f4990h, "Received location update.", new Object[0]);
                    C4202h.this.m3497b((Location) intent.getParcelableExtra("extra_location"));
                    break;
                case "com.salesforce.marketingcloud.location.GEOFENCE_ERROR":
                    int intExtra = intent.getIntExtra("extra_error_code", -1);
                    String stringExtra = intent.getStringExtra("extra_error_message");
                    if (intExtra != -1 && stringExtra != null) {
                        C4202h.this.m3495b(intExtra, stringExtra);
                        break;
                    }
                    break;
                case "com.salesforce.marketingcloud.location.GEOFENCE_EVENT":
                    int intExtra2 = intent.getIntExtra("extra_transition", -1);
                    if (intExtra2 != -1) {
                        C4170g.m3202a(AbstractC4200f.f4990h, "Received geofence transition %d", Integer.valueOf(intExtra2));
                        C4202h.this.m3496b(intExtra2, intent.getStringArrayListExtra("extra_fence_ids"), (Location) intent.getParcelableExtra("extra_location"));
                        break;
                    }
                    break;
                default:
                    C4170g.m3202a(AbstractC4200f.f4990h, "Received unknown action: %s", action);
                    break;
            }
        }
    }

    C4202h(Context context, MarketingCloudConfig marketingCloudConfig) throws IllegalStateException {
        this.f5008y = context;
        this.f5000q = new C4198d(context);
        this.f5003t = marketingCloudConfig;
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        this.f5009z = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.salesforce.marketingcloud.location.LOCATION_UPDATE");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_EVENT");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_ERROR");
        LocalBroadcastManager.getInstance(this.f5008y).registerReceiver(this.f5009z, intentFilter);
        c4081a.m2800a(this.f5000q.m3482c());
        c4081a.m2802a(this.f5000q.m3481b());
        c4081a.m2805b(!this.f5000q.m3483d());
    }

    /* JADX INFO: renamed from: b */
    void m3495b(int i, String str) {
        synchronized (this.f5002s) {
            if (!this.f5002s.isEmpty()) {
                for (InterfaceC4197c interfaceC4197c : this.f5002s) {
                    if (interfaceC4197c != null) {
                        interfaceC4197c.mo3475a(i, str);
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObjectM3491a = AbstractC4200f.m3491a(this.f5003t, this.f5000q.m3482c(), this.f5000q.m3481b());
        try {
            jSONObjectM3491a.put("locationRequests", this.f5004u);
            jSONObjectM3491a.put("locationsReceived", this.f5005v);
            jSONObjectM3491a.put("lastLocationRequester", this.f5006w);
            jSONObjectM3491a.put("geofenceEvents", this.f5007x);
        } catch (JSONException e) {
            C4170g.m3207b(AbstractC4200f.f4990h, e, "Error creating state for RealLocationManager.", new Object[0]);
        }
        return jSONObjectM3491a;
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        C4198d c4198d = this.f5000q;
        if (c4198d != null && z) {
            c4198d.m3478a();
        }
        Context context = this.f5008y;
        if (context == null || this.f5009z == null) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f5009z);
    }

    C4202h(Context context, C4198d c4198d) {
        this.f5008y = context;
        this.f5000q = c4198d;
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public boolean mo3493a() {
        return this.f5000q.m3483d();
    }

    /* JADX INFO: renamed from: b */
    void m3496b(int i, List<String> list, Location location) {
        String str = AbstractC4200f.f4990h;
        C4170g.m3213d(str, "onGeofenceRegionEvent", new Object[0]);
        if (list == null || list.isEmpty()) {
            C4170g.m3210c(str, "No fenceIds were provided.", new Object[0]);
            return;
        }
        this.f5007x++;
        synchronized (this.f5002s) {
            if (this.f5002s.isEmpty()) {
                C4170g.m3210c(str, "Geofence region event occured with no one listening.", new Object[0]);
            } else {
                for (InterfaceC4197c interfaceC4197c : this.f5002s) {
                    if (interfaceC4197c != null) {
                        for (String str2 : list) {
                            C4170g.m3202a(AbstractC4200f.f4990h, "Notifiying %s of geofence [%s] region event [d]", interfaceC4197c.getClass().getName(), str2, Integer.valueOf(i));
                            interfaceC4197c.mo3476a(str2, i, location);
                        }
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3459a(C4196b... c4196bArr) {
        if (c4196bArr == null || c4196bArr.length == 0) {
            C4170g.m3202a(AbstractC4200f.f4990h, "monitorGeofences - No geofenceRegions provided.", new Object[0]);
        } else {
            C4170g.m3213d(AbstractC4200f.f4990h, "Monitoring %s fence(s).", Integer.valueOf(c4196bArr.length));
            this.f5000q.m3480a(c4196bArr);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3497b(Location location) {
        if (location == null) {
            return;
        }
        this.f5005v++;
        synchronized (this.f5001r) {
            if (!this.f5001r.isEmpty()) {
                for (InterfaceC4199e interfaceC4199e : this.f5001r) {
                    if (interfaceC4199e != null) {
                        interfaceC4199e.mo3485a(location);
                    }
                }
                this.f5001r.clear();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3456a(InterfaceC4197c interfaceC4197c) {
        C4170g.m3213d(AbstractC4200f.f4990h, "registerForGeofenceRegionEvents(%s)", interfaceC4197c.getClass().getName());
        synchronized (this.f5002s) {
            this.f5002s.add(interfaceC4197c);
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3460b() {
        this.f5000q.m3478a();
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3457a(InterfaceC4199e interfaceC4199e) {
        boolean z;
        if (interfaceC4199e == null) {
            return;
        }
        synchronized (this.f5001r) {
            z = this.f5001r.add(interfaceC4199e) && this.f5001r.size() == 1;
        }
        if (z) {
            this.f5004u++;
            this.f5006w = interfaceC4199e.getClass().getName();
            this.f5000q.m3484e();
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3461b(InterfaceC4197c interfaceC4197c) {
        if (interfaceC4197c != null) {
            synchronized (this.f5002s) {
                this.f5002s.remove(interfaceC4197c);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3458a(List<String> list) {
        if (list == null || list.size() == 0) {
            C4170g.m3210c(AbstractC4200f.f4990h, "unmonitorGeofences - No geofenceRegionIds provided.", new Object[0]);
        } else {
            this.f5000q.m3479a(list);
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3462b(InterfaceC4199e interfaceC4199e) {
        synchronized (this.f5001r) {
            this.f5001r.remove(interfaceC4199e);
        }
    }
}
