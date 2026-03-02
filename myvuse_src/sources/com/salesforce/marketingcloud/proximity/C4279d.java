package com.salesforce.marketingcloud.proximity;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.proximity.AbstractC4280e;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.d */
/* JADX INFO: loaded from: classes6.dex */
class C4279d extends AbstractC4280e {

    /* JADX INFO: renamed from: i */
    private final boolean f5446i;

    /* JADX INFO: renamed from: j */
    private final JSONObject f5447j;

    public C4279d(boolean z, JSONObject jSONObject) {
        this.f5446i = z;
        this.f5447j = jSONObject;
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        c4081a.m2808d(this.f5446i);
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: b */
    public void mo3895b(List<C4278c> list) {
        C4170g.m3213d(AbstractC4280e.f5452h, "unmonitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: c */
    public void mo3897c() {
        C4170g.m3213d(AbstractC4280e.f5452h, "stopMonitoringBeaconRegions() call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        return this.f5447j;
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: a */
    public void mo3892a(List<C4278c> list) {
        C4170g.m3213d(AbstractC4280e.f5452h, "monitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: b */
    public void mo3894b(AbstractC4280e.a aVar) {
        C4170g.m3213d(AbstractC4280e.f5452h, "unregisterProximityEventListener(%s) call ignored because of unsupported device.", aVar != null ? aVar.getClass().getSimpleName() : "null");
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e
    /* JADX INFO: renamed from: a */
    public void mo3891a(AbstractC4280e.a aVar) {
        C4170g.m3213d(AbstractC4280e.f5452h, "registerProximityEventListener(%s) call ignored because of unsupported device.", aVar != null ? aVar.getClass().getSimpleName() : "null");
    }
}
