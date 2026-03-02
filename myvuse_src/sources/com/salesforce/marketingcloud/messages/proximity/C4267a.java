package com.salesforce.marketingcloud.messages.proximity;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4187j;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C4234b;
import com.salesforce.marketingcloud.messages.InterfaceC4235c;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.proximity.AbstractC4280e;
import com.salesforce.marketingcloud.proximity.C4278c;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4375k;
import com.salesforce.marketingcloud.storage.InterfaceC4376l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4267a implements InterfaceC4235c, AbstractC4280e.a, C4174c.c {

    /* JADX INFO: renamed from: j */
    static final String f5343j = C4170g.m3197a("ProximityMessageManager");

    /* JADX INFO: renamed from: d */
    final C4374j f5344d;

    /* JADX INFO: renamed from: e */
    final AbstractC4280e f5345e;

    /* JADX INFO: renamed from: f */
    final InterfaceC4235c.a f5346f;

    /* JADX INFO: renamed from: g */
    final C4174c f5347g;

    /* JADX INFO: renamed from: h */
    private final C4189l f5348h;

    /* JADX INFO: renamed from: i */
    private InterfaceC4235c.b f5349i;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$a */
    class a implements MarketingCloudSdk.WhenReadyListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ MarketingCloudConfig f5350a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5351b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ LatLon f5352c;

        a(MarketingCloudConfig marketingCloudConfig, String str, LatLon latLon) {
            this.f5350a = marketingCloudConfig;
            this.f5351b = str;
            this.f5352c = latLon;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            C4267a c4267a = C4267a.this;
            c4267a.f5347g.m3298a(EnumC4172a.f4822n.m3252a(this.f5350a, c4267a.f5344d.mo4220c(), EnumC4172a.m3245a(this.f5350a.applicationId(), this.f5351b, this.f5352c)));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$b */
    class b extends AbstractRunnableC4184g {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4267a.this.f5344d.m4243t().mo4143f(3);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$c */
    class c extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ C4278c f5355b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, C4278c c4278c) {
            super(str, objArr);
            this.f5355b = c4278c;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                InterfaceC4376l interfaceC4376lM4243t = C4267a.this.f5344d.m4243t();
                Region regionMo4137a = interfaceC4376lM4243t.mo4137a(this.f5355b.m3905f(), C4267a.this.f5344d.mo4218b());
                if (regionMo4137a == null) {
                    C4170g.m3202a(C4267a.f5343j, "BeaconRegion [%s] did not have matching Region in storage.", this.f5355b);
                    return;
                }
                if (C4187j.m3386a(regionMo4137a)) {
                    C4170g.m3202a(C4267a.f5343j, "Ignoring entry event.  Already inside Region [%s]", regionMo4137a);
                    return;
                }
                C4170g.m3213d(C4267a.f5343j, "Region [%s] was entered.  Will attempt to show associated message.", regionMo4137a.m3630id());
                C4187j.m3385a(regionMo4137a, true);
                interfaceC4376lM4243t.mo4140a(regionMo4137a.m3630id(), true);
                C4267a.this.f5346f.mo3648b(regionMo4137a);
                List<String> listMo4141c = interfaceC4376lM4243t.mo4141c(regionMo4137a.m3630id(), 5);
                if (listMo4141c.isEmpty()) {
                    return;
                }
                InterfaceC4375k interfaceC4375kM4242s = C4267a.this.f5344d.m4242s();
                InterfaceC4384c interfaceC4384cMo4218b = C4267a.this.f5344d.mo4218b();
                for (String str : listMo4141c) {
                    Message messageMo4123a = interfaceC4375kM4242s.mo4123a(str, interfaceC4384cMo4218b);
                    if (messageMo4123a != null) {
                        C4267a.this.f5346f.mo3647a(regionMo4137a, messageMo4123a);
                    } else {
                        C4170g.m3202a(C4267a.f5343j, "Message with id [%s] not found", str);
                    }
                }
            } catch (Exception e) {
                C4170g.m3207b(C4267a.f5343j, e, "Proximity region (%s) was entered, but failed to check for associated message", this.f5355b.m3905f());
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$d */
    class d implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ C4278c f5357a;

        d(C4278c c4278c) {
            this.f5357a = c4278c;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC4376l interfaceC4376lM4243t = C4267a.this.f5344d.m4243t();
            Region regionMo4137a = interfaceC4376lM4243t.mo4137a(this.f5357a.m3905f(), C4267a.this.f5344d.mo4218b());
            if (regionMo4137a == null) {
                C4170g.m3202a(C4267a.f5343j, "BeaconRegion [%s] did not have matching Region in storage.", this.f5357a);
            } else {
                if (!C4187j.m3386a(regionMo4137a)) {
                    C4170g.m3202a(C4267a.f5343j, "Ignoring exit event.  Was not inside BeaconRegion [%s]", this.f5357a);
                    return;
                }
                C4187j.m3385a(regionMo4137a, false);
                C4267a.this.f5346f.mo3646a(regionMo4137a);
                interfaceC4376lM4243t.mo4140a(regionMo4137a.m3630id(), false);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$e */
    class e extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ ProximityMessageResponse f5359b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, ProximityMessageResponse proximityMessageResponse) {
            super(str, objArr);
            this.f5359b = proximityMessageResponse;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            InterfaceC4384c interfaceC4384cMo4218b = C4267a.this.f5344d.mo4218b();
            InterfaceC4376l interfaceC4376lM4243t = C4267a.this.f5344d.m4243t();
            List<Region> listMo4138a = interfaceC4376lM4243t.mo4138a(3, C4267a.this.f5344d.mo4218b());
            if (!listMo4138a.isEmpty()) {
                Collections.sort(listMo4138a);
            }
            interfaceC4376lM4243t.mo4143f(3);
            InterfaceC4375k interfaceC4375kM4242s = C4267a.this.f5344d.m4242s();
            if (!this.f5359b.beacons().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Region region : this.f5359b.beacons()) {
                    try {
                        boolean z = false;
                        for (Message message : region.messages()) {
                            C4234b.m3638a(message, interfaceC4375kM4242s, interfaceC4384cMo4218b);
                            interfaceC4375kM4242s.mo4125a(message, interfaceC4384cMo4218b);
                            z = true;
                        }
                        if (z) {
                            int iBinarySearch = Collections.binarySearch(listMo4138a, region);
                            if (iBinarySearch >= 0) {
                                C4187j.m3385a(region, C4187j.m3386a(listMo4138a.remove(iBinarySearch)));
                            }
                            interfaceC4376lM4243t.mo4139a(region, interfaceC4384cMo4218b);
                            arrayList.add(new C4278c(region));
                        }
                    } catch (Exception e) {
                        C4170g.m3207b(C4267a.f5343j, e, "Unable to start monitoring proximity region: %s", region.m3630id());
                    }
                }
                C4170g.m3202a(C4267a.f5343j, "Monitoring beacons from request [%s]", arrayList);
                C4267a.this.f5345e.mo3892a(arrayList);
            }
            if (listMo4138a.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList(listMo4138a.size());
            Iterator<Region> it2 = listMo4138a.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new C4278c(it2.next()));
            }
            C4170g.m3202a(C4267a.f5343j, "Unmonitoring beacons [%s]", arrayList2);
            C4267a.this.f5345e.mo3895b(arrayList2);
        }
    }

    public C4267a(C4374j c4374j, AbstractC4280e abstractC4280e, C4174c c4174c, C4189l c4189l, InterfaceC4235c.a aVar) {
        this.f5344d = c4374j;
        this.f5345e = abstractC4280e;
        this.f5347g = c4174c;
        this.f5348h = c4189l;
        this.f5346f = aVar;
        c4174c.m3297a(EnumC4172a.f4822n, this);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: a */
    public void mo3642a() {
        this.f5345e.mo3891a(this);
        this.f5347g.m3297a(EnumC4172a.f4822n, this);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: b */
    public void mo3644b() {
        this.f5345e.mo3897c();
        this.f5345e.mo3894b(this);
        this.f5347g.m3296a(EnumC4172a.f4822n);
        this.f5348h.m3399b().execute(new b("disable_beacon_tracking", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: c */
    public void mo3645c() {
        C4170g.m3210c(f5343j, "monitorStoredRegions", new Object[0]);
        try {
            List<Region> listMo4138a = this.f5344d.m4243t().mo4138a(3, this.f5344d.mo4218b());
            if (listMo4138a.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(listMo4138a.size());
            Iterator<Region> it2 = listMo4138a.iterator();
            while (it2.hasNext()) {
                arrayList.add(new C4278c(it2.next()));
            }
            C4170g.m3202a(f5343j, "Monitoring beacons [%s]", arrayList);
            this.f5345e.mo3892a(arrayList);
        } catch (Exception unused) {
            C4170g.m3206b(f5343j, "Unable to monitor stored proximity regions.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m3822d() {
        return this.f5345e.mo3896b();
    }

    /* JADX INFO: renamed from: a */
    void m3819a(ProximityMessageResponse proximityMessageResponse) {
        C4170g.m3210c(f5343j, "Proximity message request contained %d regions", Integer.valueOf(proximityMessageResponse.beacons().size()));
        InterfaceC4235c.b bVar = this.f5349i;
        if (bVar != null) {
            bVar.mo3649a(proximityMessageResponse);
        }
        this.f5348h.m3399b().execute(new e("beacon_response", new Object[0], proximityMessageResponse));
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e.a
    /* JADX INFO: renamed from: b */
    public void mo3821b(C4278c c4278c) {
        C4170g.m3213d(f5343j, "Proximity region (%s) entered.", c4278c.m3905f());
        this.f5348h.m3399b().execute(new c("", new Object[0], c4278c));
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            C4170g.m3210c(f5343j, "Request failed: %d - %s", Integer.valueOf(c4175d.m3302b()), c4175d.m3305e());
            return;
        }
        try {
            m3819a(new ProximityMessageResponse(new JSONObject(c4175d.m3301a())));
        } catch (Exception e2) {
            C4170g.m3207b(f5343j, e2, "Error parsing response.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.proximity.AbstractC4280e.a
    /* JADX INFO: renamed from: a */
    public void mo3820a(C4278c c4278c) {
        C4170g.m3213d(f5343j, "Proximity region (%s) exited.", c4278c.m3905f());
        this.f5348h.m3399b().execute(new d(c4278c));
    }

    /* JADX INFO: renamed from: a */
    public static void m3818a(C4374j c4374j, AbstractC4280e abstractC4280e, C4174c c4174c, boolean z) {
        abstractC4280e.mo3897c();
        if (z) {
            c4374j.m4243t().mo4143f(3);
            c4374j.m4242s().mo4127e(5);
        }
        c4174c.m3296a(EnumC4172a.f4822n);
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c
    /* JADX INFO: renamed from: a */
    public void mo3643a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, InterfaceC4235c.b bVar) {
        this.f5349i = bVar;
        try {
            MarketingCloudSdk.requestSdk(new a(marketingCloudConfig, str, latLon));
        } catch (Exception e2) {
            C4170g.m3207b(f5343j, e2, "Failed to update proximity messages", new Object[0]);
        }
    }
}
