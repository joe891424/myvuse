package com.salesforce.marketingcloud.location;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.location.a */
/* JADX INFO: loaded from: classes6.dex */
final class C4195a extends AbstractC4200f {

    /* JADX INFO: renamed from: q */
    private final JSONObject f4965q;

    /* JADX INFO: renamed from: r */
    private final Boolean f4966r;

    /* JADX INFO: renamed from: s */
    private final Exception f4967s;

    /* JADX INFO: renamed from: t */
    private final boolean f4968t;

    /* JADX INFO: renamed from: u */
    private final boolean f4969u;

    C4195a(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        this.f4968t = marketingCloudConfig.geofencingEnabled();
        this.f4969u = marketingCloudConfig.proximityEnabled();
        this.f4966r = bool;
        this.f4967s = exc;
        this.f4965q = AbstractC4200f.m3492a(marketingCloudConfig, bool, z, exc);
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        if (!this.f4968t && !this.f4969u) {
            c4081a.m2805b(false);
            return;
        }
        c4081a.m2805b(true);
        Exception exc = this.f4967s;
        if (exc == null) {
            Boolean bool = this.f4966r;
            if (bool == null || bool.booleanValue()) {
                return;
            }
            c4081a.m2802a(AbstractC4200f.f4987e);
            return;
        }
        String message = exc.getMessage();
        if (message != null) {
            c4081a.m2802a(message);
        }
        Exception exc2 = this.f4967s;
        if (exc2 instanceof C4201g) {
            c4081a.m2800a(((C4201g) exc2).m3494a());
        }
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3460b() {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. unmonitorAllGeofences ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        return this.f4965q;
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3459a(C4196b... c4196bArr) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. monitorGeofences ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3461b(InterfaceC4197c interfaceC4197c) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. unregisterForGeofenceRegionEvents ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3456a(InterfaceC4197c interfaceC4197c) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. registerForGeofenceRegionEvents ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: b */
    public void mo3462b(InterfaceC4199e interfaceC4199e) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. unregisterForLocationUpdate ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3457a(InterfaceC4199e interfaceC4199e) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. registerForLocationUpdate ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.AbstractC4200f
    /* JADX INFO: renamed from: a */
    public void mo3458a(List<String> list) {
        C4170g.m3216e(AbstractC4200f.f4990h, "LocationManager unavailable. unmonitorGeofences ignored", new Object[0]);
    }
}
