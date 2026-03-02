package com.salesforce.marketingcloud.messages.geofence;

import android.location.Location;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.location.AbstractC4200f;
import com.salesforce.marketingcloud.location.C4196b;
import com.salesforce.marketingcloud.location.InterfaceC4197c;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C4234b;
import com.salesforce.marketingcloud.messages.InterfaceC4235c;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4375k;
import com.salesforce.marketingcloud.storage.InterfaceC4376l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4238a implements InterfaceC4235c, InterfaceC4197c, C4174c.c {

    /* JADX INFO: renamed from: k */
    static final String f5184k = C4170g.m3197a("GeofenceMessageManager");

    /* JADX INFO: renamed from: d */
    final AbstractC4200f f5185d;

    /* JADX INFO: renamed from: e */
    final C4374j f5186e;

    /* JADX INFO: renamed from: f */
    final InterfaceC4235c.a f5187f;

    /* JADX INFO: renamed from: g */
    final C4174c f5188g;

    /* JADX INFO: renamed from: h */
    private final C4189l f5189h;

    /* JADX INFO: renamed from: i */
    AtomicBoolean f5190i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j */
    private InterfaceC4235c.b f5191j;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$a */
    class a implements MarketingCloudSdk.WhenReadyListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ MarketingCloudConfig f5192a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5193b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ LatLon f5194c;

        a(MarketingCloudConfig marketingCloudConfig, String str, LatLon latLon) {
            this.f5192a = marketingCloudConfig;
            this.f5193b = str;
            this.f5194c = latLon;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            C4238a c4238a = C4238a.this;
            c4238a.f5188g.m3298a(EnumC4172a.f4821m.m3252a(this.f5192a, c4238a.f5186e.mo4220c(), EnumC4172a.m3245a(this.f5192a.applicationId(), this.f5193b, this.f5194c)));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5196b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f5197c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, String str2, int i) {
            super(str, objArr);
            this.f5196b = str2;
            this.f5197c = i;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                InterfaceC4376l interfaceC4376lM4243t = C4238a.this.f5186e.m4243t();
                Region regionMo4137a = interfaceC4376lM4243t.mo4137a(this.f5196b, C4238a.this.f5186e.mo4218b());
                int i = 0;
                if (regionMo4137a == null) {
                    C4170g.m3210c(C4238a.f5184k, "Removing stale geofence from being monitored.", new Object[0]);
                    C4238a.this.f5185d.mo3458a(Collections.singletonList(this.f5196b));
                    return;
                }
                int i2 = this.f5197c;
                if (i2 == 1) {
                    C4238a.this.f5187f.mo3648b(regionMo4137a);
                    i = 3;
                } else if (i2 == 2) {
                    C4238a.this.f5187f.mo3646a(regionMo4137a);
                    i = 4;
                }
                if (i != 0) {
                    List<String> listMo4141c = interfaceC4376lM4243t.mo4141c(regionMo4137a.m3630id(), i);
                    if (listMo4141c.isEmpty()) {
                        return;
                    }
                    InterfaceC4375k interfaceC4375kM4242s = C4238a.this.f5186e.m4242s();
                    InterfaceC4384c interfaceC4384cMo4218b = C4238a.this.f5186e.mo4218b();
                    for (String str : listMo4141c) {
                        Message messageMo4123a = interfaceC4375kM4242s.mo4123a(str, interfaceC4384cMo4218b);
                        if (messageMo4123a != null) {
                            C4238a.this.f5187f.mo3647a(regionMo4137a, messageMo4123a);
                        } else {
                            C4170g.m3202a(C4238a.f5184k, "Message with id [%s] not found", str);
                        }
                    }
                }
            } catch (Exception e) {
                C4170g.m3207b(C4238a.f5184k, e, "Geofence (%s - %d) was tripped, but failed to check for associated message", this.f5196b, Integer.valueOf(this.f5197c));
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$c */
    class c extends AbstractRunnableC4184g {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            List<String> listMo4142d = C4238a.this.f5186e.m4243t().mo4142d(1);
            if (!listMo4142d.isEmpty()) {
                C4238a.this.f5185d.mo3458a(listMo4142d);
            }
            C4238a.this.f5186e.m4243t().mo4143f(1);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ GeofenceMessageResponse f5200b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, GeofenceMessageResponse geofenceMessageResponse) {
            super(str, objArr);
            this.f5200b = geofenceMessageResponse;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            InterfaceC4376l interfaceC4376lM4243t = C4238a.this.f5186e.m4243t();
            List<String> listMo4142d = interfaceC4376lM4243t.mo4142d(1);
            interfaceC4376lM4243t.mo4143f(1);
            InterfaceC4375k interfaceC4375kM4242s = C4238a.this.f5186e.m4242s();
            InterfaceC4384c interfaceC4384cMo4218b = C4238a.this.f5186e.mo4218b();
            if (!this.f5200b.fences().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Region> it2 = this.f5200b.fences().iterator();
                while (true) {
                    boolean z = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Region next = it2.next();
                    try {
                        for (Message message : next.messages()) {
                            C4234b.m3638a(message, interfaceC4375kM4242s, interfaceC4384cMo4218b);
                            interfaceC4375kM4242s.mo4125a(message, interfaceC4384cMo4218b);
                            z = true;
                        }
                        if (z) {
                            if (!listMo4142d.remove(next.m3630id())) {
                                arrayList.add(next);
                            }
                            interfaceC4376lM4243t.mo4139a(next, interfaceC4384cMo4218b);
                        }
                    } catch (Exception e) {
                        C4170g.m3207b(C4238a.f5184k, e, "Unable to start monitoring geofence region: %s", next.m3630id());
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    C4238a.this.f5185d.mo3459a(C4238a.m3678a((Region) it3.next()));
                }
            }
            if (!listMo4142d.isEmpty()) {
                C4238a.this.f5185d.mo3458a(listMo4142d);
            }
            C4238a.this.f5190i.set(true);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$e */
    class e extends AbstractRunnableC4184g {
        e(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (C4238a.this.f5190i.get()) {
                C4170g.m3213d(C4238a.f5184k, "Attempt to monitor fences from DB ignored, because they're already monitored.", new Object[0]);
            }
            C4170g.m3213d(C4238a.f5184k, "monitorStoredRegions", new Object[0]);
            try {
                List<Region> listMo4138a = C4238a.this.f5186e.m4243t().mo4138a(1, C4238a.this.f5186e.mo4218b());
                if (listMo4138a.isEmpty()) {
                    return;
                }
                Iterator<Region> it2 = listMo4138a.iterator();
                while (it2.hasNext()) {
                    C4238a.this.f5185d.mo3459a(C4238a.m3678a(it2.next()));
                }
            } catch (Exception e) {
                C4170g.m3207b(C4238a.f5184k, e, "Unable to monitor stored geofence regions.", new Object[0]);
            }
        }
    }

    public C4238a(C4374j c4374j, AbstractC4200f abstractC4200f, C4174c c4174c, C4189l c4189l, InterfaceC4235c.a aVar) {
        this.f5186e = c4374j;
        this.f5185d = abstractC4200f;
        this.f5188g = c4174c;
        this.f5187f = aVar;
        this.f5189h = c4189l;
        c4174c.m3297a(EnumC4172a.f4821m, this);
    }

    /* JADX INFO: renamed from: a */
    private static int m3677a(int i) {
        if (i < 100) {
            return 100;
        }
        return i;
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: a */
    public void mo3642a() {
        this.f5185d.mo3456a(this);
        this.f5188g.m3297a(EnumC4172a.f4821m, this);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: b */
    public void mo3644b() {
        AbstractC4200f abstractC4200f = this.f5185d;
        if (abstractC4200f != null) {
            abstractC4200f.mo3461b(this);
            if (this.f5186e != null) {
                this.f5189h.m3399b().execute(new c("disable_fence_tracking", new Object[0]));
            }
        }
        this.f5188g.m3296a(EnumC4172a.f4821m);
        this.f5190i.set(false);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: c */
    public void mo3645c() {
        this.f5189h.m3399b().execute(new e("monitor_stored_regions", new Object[0]));
    }

    /* JADX INFO: renamed from: d */
    public boolean m3681d() {
        return this.f5185d.mo3493a();
    }

    /* JADX INFO: renamed from: a */
    static C4196b m3678a(Region region) {
        return new C4196b(region.m3630id(), m3677a(region.radius()), region.center().latitude(), region.center().longitude(), 3);
    }

    /* JADX INFO: renamed from: a */
    void m3680a(GeofenceMessageResponse geofenceMessageResponse) {
        C4170g.m3210c(f5184k, "Geofence message request contained %d regions", Integer.valueOf(geofenceMessageResponse.fences().size()));
        InterfaceC4235c.b bVar = this.f5191j;
        if (bVar != null) {
            bVar.mo3649a(geofenceMessageResponse);
        }
        this.f5189h.m3399b().execute(new d("fence_response", new Object[0], geofenceMessageResponse));
    }

    @Override // com.salesforce.marketingcloud.location.InterfaceC4197c
    /* JADX INFO: renamed from: a */
    public void mo3475a(int i, String str) {
        C4170g.m3202a(f5184k, "Region error %d - %s", Integer.valueOf(i), str);
    }

    @Override // com.salesforce.marketingcloud.location.InterfaceC4197c
    /* JADX INFO: renamed from: a */
    public void mo3476a(String str, int i, Location location) {
        String str2 = f5184k;
        C4170g.m3213d(str2, "Geofence (%s - %s) was tripped.", str, Integer.valueOf(i));
        if (i == 4) {
            C4170g.m3213d(str2, "Dwell transition ignore for %s", str);
        } else {
            this.f5189h.m3399b().execute(new b("fence_event", new Object[0], str, i));
        }
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            C4170g.m3210c(f5184k, "Request failed: %d - %s", Integer.valueOf(c4175d.m3302b()), c4175d.m3305e());
            return;
        }
        try {
            m3680a(new GeofenceMessageResponse(new JSONObject(c4175d.m3301a())));
        } catch (Exception e2) {
            C4170g.m3207b(f5184k, e2, "Error parsing response.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3679a(C4374j c4374j, AbstractC4200f abstractC4200f, C4174c c4174c, boolean z) {
        List<String> listMo4142d = c4374j.m4243t().mo4142d(1);
        if (!listMo4142d.isEmpty()) {
            abstractC4200f.mo3458a(listMo4142d);
        }
        if (z) {
            c4374j.m4243t().mo4143f(1);
            InterfaceC4375k interfaceC4375kM4242s = c4374j.m4242s();
            interfaceC4375kM4242s.mo4127e(3);
            interfaceC4375kM4242s.mo4127e(4);
        }
        c4174c.m3296a(EnumC4172a.f4821m);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: a */
    public void mo3643a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, InterfaceC4235c.b bVar) {
        this.f5191j = bVar;
        try {
            MarketingCloudSdk.requestSdk(new a(marketingCloudConfig, str, latLon));
        } catch (Exception e2) {
            C4170g.m3207b(f5184k, e2, "Failed to update geofence messages", new Object[0]);
        }
    }
}
