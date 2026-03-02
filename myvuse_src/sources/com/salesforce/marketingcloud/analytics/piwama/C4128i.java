package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.analytics.AbstractC4114i;
import com.salesforce.marketingcloud.analytics.C4102a;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.analytics.C4104c;
import com.salesforce.marketingcloud.analytics.C4105d;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.PiOrder;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.registration.C4309d;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4338a;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i */
/* JADX INFO: loaded from: classes6.dex */
public class C4128i extends AbstractC4114i implements C4174c.c {

    /* JADX INFO: renamed from: h */
    static final String f4459h = "user_id";

    /* JADX INFO: renamed from: i */
    static final String f4460i = "session_id";

    /* JADX INFO: renamed from: j */
    static final int f4461j = 100;

    /* JADX INFO: renamed from: k */
    private static final int f4462k = 30;

    /* JADX INFO: renamed from: l */
    private static final String f4463l = "et_background_time_cache";

    /* JADX INFO: renamed from: m */
    static final String f4464m = C4170g.m3197a("PiWamaAnalytic");

    /* JADX INFO: renamed from: n */
    private static final int f4465n = 1;

    /* JADX INFO: renamed from: o */
    private static AbstractC4129j f4466o;

    /* JADX INFO: renamed from: d */
    final C4374j f4467d;

    /* JADX INFO: renamed from: e */
    final C4174c f4468e;

    /* JADX INFO: renamed from: f */
    private final MarketingCloudConfig f4469f;

    /* JADX INFO: renamed from: g */
    final C4189l f4470g;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ C4374j f4471b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, C4374j c4374j) {
            super(str, objArr);
            this.f4471b = c4374j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            this.f4471b.m4236m().mo3992g(1);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i$b */
    class b implements Comparator<C4103b> {
        b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4103b c4103b, C4103b c4103b2) {
            if (c4103b.m2899f() == null) {
                return c4103b2.m2899f() == null ? 0 : -1;
            }
            if (c4103b2.m2899f() == null) {
                return 1;
            }
            return c4103b.m2899f().compareTo(c4103b2.m2899f());
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i$c */
    class c extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ long f4472b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, long j) {
            super(str, objArr);
            this.f4472b = j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            String string;
            try {
                InterfaceC4338a interfaceC4338aM4236m = C4128i.this.f4467d.m4236m();
                for (C4103b c4103b : interfaceC4338aM4236m.mo3995i(C4128i.this.f4467d.mo4218b())) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.f4472b - c4103b.m2891b().getTime());
                    if (seconds > 0) {
                        c4103b.m2892b(seconds);
                        c4103b.m2890a(true);
                        c4103b.m2897d(C4128i.this.m2974a());
                        interfaceC4338aM4236m.mo3986b(c4103b, C4128i.this.f4467d.mo4218b());
                    }
                }
                C4103b c4103bM2883a = C4103b.m2883a(new Date(this.f4472b), 1, 2);
                c4103bM2883a.m2897d(C4128i.this.m2974a());
                c4103bM2883a.m2890a(true);
                JSONObject jSONObjectMo2956c = new C4121b(new Date(this.f4472b)).mo2956c();
                if (jSONObjectMo2956c instanceof JSONObject) {
                    JSONObject jSONObject = jSONObjectMo2956c;
                    string = JSONObjectInstrumentation.toString(jSONObjectMo2956c);
                } else {
                    string = jSONObjectMo2956c.toString();
                }
                c4103bM2883a.m2895c(string);
                interfaceC4338aM4236m.mo3984a(c4103bM2883a, C4128i.this.f4467d.mo4218b());
            } catch (Exception e) {
                C4170g.m3207b(C4128i.f4464m, e, "Failed to update our PiWama TimeInApp.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ NotificationMessage f4474b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, NotificationMessage notificationMessage) {
            super(str, objArr);
            this.f4474b = notificationMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() throws JSONException {
            if (C4128i.this.f4467d.m4236m().mo3989c(1)) {
                C4128i.this.mo2924a(System.currentTimeMillis());
            }
            Date date = new Date();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f4474b.m3845id());
            Region region = this.f4474b.region();
            if (region != null) {
                arrayList.add(region.m3630id());
            }
            C4103b c4103bM2886a = C4103b.m2886a(date, 1, 5, (List<String>) arrayList, false);
            c4103bM2886a.m2897d(C4128i.this.m2974a());
            JSONObject jSONObjectMo2956c = new C4124e(date, true, c4103bM2886a.m2902i()).mo2956c();
            c4103bM2886a.m2895c(!(jSONObjectMo2956c instanceof JSONObject) ? jSONObjectMo2956c.toString() : JSONObjectInstrumentation.toString(jSONObjectMo2956c));
            C4128i.this.f4470g.m3399b().execute(new C4102a(C4128i.this.f4467d.m4236m(), C4128i.this.f4467d.mo4218b(), c4103bM2886a));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.i$e */
    class e extends AbstractRunnableC4184g {
        e(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4128i c4128i = C4128i.this;
            C4128i.m2967a(c4128i.f4468e, c4128i.f4467d.m4236m().mo3996o(C4128i.this.f4467d.mo4218b()));
        }
    }

    public C4128i(MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4174c c4174c, C4189l c4189l) {
        C4391j.m4326a(marketingCloudConfig, "MarketingCloudConfig may not be null.");
        this.f4467d = (C4374j) C4391j.m4326a(c4374j, "MCStorage may not be null.");
        this.f4468e = (C4174c) C4391j.m4326a(c4174c, "RequestManager may not be null.");
        this.f4469f = marketingCloudConfig;
        f4466o = m2971a(marketingCloudConfig) ? new C4130k(marketingCloudConfig, c4374j) : new C4120a(marketingCloudConfig, c4374j);
        c4174c.m3297a(EnumC4172a.f4817i, this);
        this.f4470g = c4189l;
    }

    /* JADX INFO: renamed from: a */
    private void m2966a(InterfaceC4122c interfaceC4122c, long j) throws IllegalArgumentException {
        String string;
        JSONObject jSONObjectMo2956c = interfaceC4122c.mo2956c();
        if (jSONObjectMo2956c == null) {
            throw new IllegalArgumentException("Failed to convert your input type to a JSON Object.");
        }
        try {
            C4103b c4103bM2883a = C4103b.m2883a(new Date(j), 1, interfaceC4122c.mo2955b());
            c4103bM2883a.m2897d(m2974a());
            if (jSONObjectMo2956c instanceof JSONObject) {
                JSONObject jSONObject = jSONObjectMo2956c;
                string = JSONObjectInstrumentation.toString(jSONObjectMo2956c);
            } else {
                string = jSONObjectMo2956c.toString();
            }
            c4103bM2883a.m2895c(string);
            c4103bM2883a.m2890a(true);
            if (TextUtils.isEmpty(c4103bM2883a.m2898e())) {
                return;
            }
            this.f4470g.m3399b().execute(new C4102a(this.f4467d.m4236m(), this.f4467d.mo4218b(), c4103bM2883a));
        } catch (Exception e2) {
            C4170g.m3207b(f4464m, e2, "Failed to record PiWamaItem in local storage.", new Object[0]);
            throw new IllegalArgumentException("Failed to record PiWamaItem in local storage.");
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2973b() {
        long j = this.f4467d.mo4222f().getLong(f4463l, -1L);
        if (j != -1) {
            this.f4467d.mo4222f().edit().remove(f4463l).apply();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(12, -30);
            if (calendar.before(calendar2)) {
                this.f4467d.mo4220c().mo3929a(InterfaceC4340c.f5564f);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2975c() {
        this.f4470g.m3399b().execute(new e("send_pi_analytics", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public String getPiIdentifier() {
        return this.f4467d.mo4220c().mo3931b("predictive_intelligence_identifier", null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void setPiIdentifier(String str) {
        if (str == null) {
            this.f4467d.mo4220c().mo3929a("predictive_intelligence_identifier");
        } else {
            this.f4467d.mo4220c().mo3930a("predictive_intelligence_identifier", str.trim());
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartContents(PiCart piCart) {
        if (piCart != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                m2966a(new C4125f(piCart, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
            } catch (Exception e2) {
                C4170g.m3207b(f4464m, e2, "Failed to add PiWamaAnalytic for trackCartContents.  See LogCat for details.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartConversion(PiOrder piOrder) {
        if (piOrder != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                m2966a(new C4126g(piOrder, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
            } catch (IllegalArgumentException e2) {
                C4170g.m3207b(f4464m, e2, "Failed to add PiWamaAnalytic for trackCartConversion.  See LogCat for details.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str, String str2, String str3, String str4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m2966a(new C4127h(str, str2, str3, str4, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
        } catch (IllegalArgumentException e2) {
            C4170g.m3207b(f4464m, e2, "Failed to record PiWamaItem for trackPageView.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2969a(C4374j c4374j, C4189l c4189l) {
        c4189l.m3399b().execute(new a("deleting_pi_analytics", new Object[0], c4374j));
    }

    /* JADX INFO: renamed from: b */
    static List<List<C4103b>> m2972b(List<C4103b> list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = size; i2 > 0; i2 -= 100) {
            int i3 = i * 100;
            i++;
            int i4 = i * 100;
            if (i4 > size) {
                i4 = i2 + i3;
            }
            arrayList.add(new ArrayList(list.subList(i3, i4)));
        }
        return arrayList;
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2924a(long j) {
        this.f4467d.mo4222f().edit().putLong(f4463l, j).apply();
        this.f4470g.m3399b().execute(new c("end_time_in_app", new Object[0], j));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: b */
    public void mo2927b(long j) {
        String string;
        Date date = new Date(j);
        m2973b();
        if (this.f4467d.m4236m().mo3989c(1)) {
            return;
        }
        try {
            C4103b c4103bM2883a = C4103b.m2883a(date, 1, 5);
            JSONObject jSONObjectMo2956c = new C4124e(date, false, Collections.emptyList()).mo2956c();
            if (jSONObjectMo2956c instanceof JSONObject) {
                JSONObject jSONObject = jSONObjectMo2956c;
                string = JSONObjectInstrumentation.toString(jSONObjectMo2956c);
            } else {
                string = jSONObjectMo2956c.toString();
            }
            c4103bM2883a.m2895c(string);
            this.f4470g.m3399b().execute(new C4102a(this.f4467d.m4236m(), this.f4467d.mo4218b(), c4103bM2883a));
        } catch (Exception e2) {
            C4170g.m3207b(f4464m, e2, "Failed to create WamaItem for TimeInApp.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    String m2974a() {
        String piIdentifier = getPiIdentifier();
        return (piIdentifier == null && this.f4469f.useLegacyPiIdentifier()) ? C4309d.m3924a(this.f4467d) : piIdentifier;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2971a(MarketingCloudConfig marketingCloudConfig) {
        String strTrim = marketingCloudConfig.predictiveIntelligenceServerUrl().toLowerCase(Locale.ENGLISH).trim();
        return (strTrim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa1s1/process_batch") || strTrim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa3s1/process_batch") || strTrim.startsWith("https://app.igodigital.com/api/v1/collect/process_batch")) ? false : true;
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            C4170g.m3210c(f4464m, "Request failed: %d - %s", Integer.valueOf(c4175d.m3302b()), c4175d.m3305e());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(c4175d.m3301a());
            m2970a(C4104c.m2906a(c4173b.m3279q() != null ? c4173b.m3279q() : ""), jSONObject.getString(f4459h), jSONObject.getString("session_id"));
        } catch (Exception e2) {
            C4170g.m3207b(f4464m, e2, "Error parsing response.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2970a(String[] strArr, String str, String str2) {
        this.f4467d.mo4220c().mo3930a(InterfaceC4340c.f5565g, str);
        this.f4467d.mo4220c().mo3930a(InterfaceC4340c.f5564f, str2);
        if (strArr != null) {
            this.f4470g.m3399b().execute(new C4105d(this.f4467d.m4236m(), strArr));
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2926a(NotificationMessage notificationMessage) {
        try {
            this.f4470g.m3399b().execute(new d("notification_opened", new Object[0], notificationMessage));
        } catch (Exception e2) {
            C4170g.m3207b(f4464m, e2, "Failed to store our WamaItem for message opened.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    static List<List<C4103b>> m2965a(List<C4103b> list) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(list, new b());
        ArrayList arrayList2 = new ArrayList();
        String strM2899f = null;
        for (C4103b c4103b : list) {
            if ((strM2899f == null || !strM2899f.equals(c4103b.m2899f())) && c4103b.m2899f() != null) {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                }
                strM2899f = c4103b.m2899f();
                arrayList2 = new ArrayList();
            }
            arrayList2.add(c4103b);
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    static void m2967a(C4174c c4174c, List<C4103b> list) {
        MarketingCloudSdk marketingCloudSdk;
        if ((!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) || (marketingCloudSdk = MarketingCloudSdk.getInstance()) == null || list.isEmpty()) {
            return;
        }
        Iterator<List<C4103b>> it2 = m2965a(list).iterator();
        while (it2.hasNext()) {
            for (List<C4103b> list2 : m2972b(it2.next())) {
                C4173b c4173bM2977a = f4466o.m2977a(marketingCloudSdk.getRegistrationManager(), marketingCloudSdk.getPushMessageManager(), marketingCloudSdk.getRegionMessageManager(), list2);
                c4173bM2977a.m3264a(C4104c.m2905a(list2));
                c4174c.m3298a(c4173bM2977a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2968a(C4374j c4374j, C4174c c4174c, C4189l c4189l, boolean z) {
        if (z) {
            m2969a(c4374j, c4189l);
            c4374j.mo4220c().mo3929a("predictive_intelligence_identifier");
        }
        c4174c.m3296a(EnumC4172a.f4817i);
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2918a(boolean z) {
        if (z) {
            m2969a(this.f4467d, this.f4470g);
        }
        C4174c c4174c = this.f4468e;
        if (c4174c != null) {
            c4174c.m3296a(EnumC4172a.f4817i);
        }
    }
}
