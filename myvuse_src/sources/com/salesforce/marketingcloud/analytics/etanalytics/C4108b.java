package com.salesforce.marketingcloud.analytics.etanalytics;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.analytics.AbstractC4114i;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.analytics.C4102a;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4179b;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4108b extends AbstractC4114i {

    /* JADX INFO: renamed from: f */
    private static final int f4399f = 0;

    /* JADX INFO: renamed from: d */
    final C4374j f4400d;

    /* JADX INFO: renamed from: e */
    private final C4189l f4401e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ C4374j f4402b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, C4374j c4374j) {
            super(str, objArr);
            this.f4402b = c4374j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            this.f4402b.m4236m().mo3982a(0);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ long f4403b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, long j) {
            super(str, objArr);
            this.f4403b = j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (C4108b.this.f4400d.m4236m().mo3989c(0)) {
                return;
            }
            try {
                C4108b.this.f4400d.m4236m().mo3984a(C4103b.m2883a(new Date(this.f4403b), 0, 4), C4108b.this.f4400d.mo4218b());
            } catch (Exception e) {
                C4170g.m3207b(AnalyticsManager.TAG, e, "Failed to create our EtAnalyticItem for TimeInApp.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b$c */
    class c extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ long f4405b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, long j) {
            super(str, objArr);
            this.f4405b = j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                List<C4103b> listMo3993g = C4108b.this.f4400d.m4236m().mo3993g(C4108b.this.f4400d.mo4218b());
                if (listMo3993g.isEmpty()) {
                    return;
                }
                for (C4103b c4103b : listMo3993g) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.f4405b - c4103b.m2891b().getTime());
                    if (seconds > 0) {
                        c4103b.m2892b(seconds);
                        c4103b.m2890a(true);
                        C4108b.this.f4400d.m4236m().mo3986b(c4103b, C4108b.this.f4400d.mo4218b());
                    }
                }
            } catch (Exception e) {
                C4170g.m3207b(AnalyticsManager.TAG, e, "Failed to update our EtAnalytic TimeInApp.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ long f4407b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, long j) {
            super(str, objArr);
            this.f4407b = j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                List<C4103b> listMo3994h = C4108b.this.f4400d.m4236m().mo3994h(C4108b.this.f4400d.mo4218b());
                if (listMo3994h.isEmpty()) {
                    return;
                }
                for (C4103b c4103b : listMo3994h) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.f4407b - c4103b.m2891b().getTime());
                    if (seconds > 0) {
                        c4103b.m2892b(seconds);
                        c4103b.m2890a(true);
                        C4108b.this.f4400d.m4236m().mo3986b(c4103b, C4108b.this.f4400d.mo4218b());
                    }
                }
            } catch (Exception e) {
                C4170g.m3207b(AnalyticsManager.TAG, e, "Failed to update local storage for stopTimeInAllRegions.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.b$e */
    class e extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Region f4409b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Date f4410c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, Region region, Date date) {
            super(str, objArr);
            this.f4409b = region;
            this.f4410c = date;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                List<C4103b> listMo3987b = C4108b.this.f4400d.m4236m().mo3987b(this.f4409b, C4108b.this.f4400d.mo4218b());
                if (listMo3987b.isEmpty()) {
                    return;
                }
                for (C4103b c4103b : listMo3987b) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.f4410c.getTime() - c4103b.m2891b().getTime());
                    if (seconds > 0) {
                        c4103b.m2892b(seconds);
                        c4103b.m2890a(true);
                        C4108b.this.f4400d.m4236m().mo3986b(c4103b, C4108b.this.f4400d.mo4218b());
                    }
                }
            } catch (Exception e) {
                C4170g.m3207b(AnalyticsManager.TAG, e, "Failed to record EtAnalyticItem for stopTimeInRegion.", new Object[0]);
            }
        }
    }

    public C4108b(C4374j c4374j, C4189l c4189l) {
        this.f4400d = c4374j;
        this.f4401e = c4189l;
    }

    /* JADX INFO: renamed from: a */
    private static void m2920a(C4189l c4189l, C4374j c4374j) {
        c4189l.m3399b().execute(new a("delete_analytics", new Object[0], c4374j));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4116k
    /* JADX INFO: renamed from: b */
    public void mo2928b(Region region) {
        Date date = new Date();
        m2923b(region, date);
        if (region.regionType() == 3) {
            return;
        }
        this.f4401e.m3399b().execute(new C4102a(this.f4400d.m4236m(), this.f4400d.mo4218b(), C4103b.m2886a(date, 0, 7, (List<String>) Collections.singletonList(region.m3630id()), true)));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: c */
    public void mo2929c(long j) {
        this.f4401e.m3399b().execute(new d("end_region_counter", new Object[0], j));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackInboxOpenEvent(InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "InboxMessage was null. Call to trackInboxOpenEvent() ignored.", new Object[0]);
        } else {
            this.f4401e.m3399b().execute(new C4102a(this.f4400d.m4236m(), this.f4400d.mo4218b(), C4103b.m2885a(new Date(), 0, 15, Collections.singletonList(inboxMessage.m3794id()), C4179b.m3332b(inboxMessage), true)));
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2924a(long j) {
        this.f4401e.m3399b().execute(new c("end_app_counter", new Object[0], j));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: b */
    public void mo2927b(long j) {
        this.f4401e.m3399b().execute(new b("start_app_counter", new Object[0], j));
    }

    /* JADX INFO: renamed from: b */
    private void m2923b(Region region, Date date) {
        this.f4401e.m3399b().execute(new e("end_region_counter", new Object[0], region, date));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2926a(NotificationMessage notificationMessage) {
        mo2924a(System.currentTimeMillis());
        this.f4401e.m3399b().execute(new C4102a(this.f4400d.m4236m(), this.f4400d.mo4218b(), C4103b.m2884a(new Date(), 0, 5, notificationMessage, false)));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4116k
    /* JADX INFO: renamed from: a */
    public void mo2925a(Region region) {
        Date date = new Date();
        m2921a(region, date);
        this.f4401e.m3399b().execute(new C4102a(this.f4400d.m4236m(), this.f4400d.mo4218b(), C4103b.m2886a(date, 0, region.regionType() == 1 ? 6 : 12, (List<String>) Collections.singletonList(region.m3630id()), true)));
    }

    /* JADX INFO: renamed from: a */
    public static void m2922a(C4374j c4374j, C4189l c4189l, boolean z) {
        if (z) {
            m2920a(c4189l, c4374j);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2921a(Region region, Date date) {
        this.f4401e.m3399b().execute(new C4102a(this.f4400d.m4236m(), this.f4400d.mo4218b(), C4103b.m2886a(date, 0, region.regionType() == 1 ? 11 : 13, (List<String>) Collections.singletonList(region.m3630id()), false)));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2918a(boolean z) {
        if (z) {
            m2920a(this.f4401e, this.f4400d);
        }
    }
}
