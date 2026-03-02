package com.salesforce.marketingcloud.analytics.stats;

import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.AbstractC4114i;
import com.salesforce.marketingcloud.analytics.C4104c;
import com.salesforce.marketingcloud.analytics.C4106e;
import com.salesforce.marketingcloud.analytics.InterfaceC4117l;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.config.C4144b;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4178a;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.InterfaceC4341d;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4134c extends AbstractC4114i implements C4174c.c, C4093b.b {

    /* JADX INFO: renamed from: k */
    static final String f4514k = C4170g.m3197a("DeviceStats");

    /* JADX INFO: renamed from: l */
    private static final int f4515l = 1000;

    /* JADX INFO: renamed from: m */
    private static final int f4516m = 1;

    /* JADX INFO: renamed from: d */
    final String f4517d;

    /* JADX INFO: renamed from: e */
    final C4374j f4518e;

    /* JADX INFO: renamed from: f */
    final C4174c f4519f;

    /* JADX INFO: renamed from: g */
    final MarketingCloudConfig f4520g;

    /* JADX INFO: renamed from: h */
    final C4093b f4521h;

    /* JADX INFO: renamed from: i */
    protected final C4189l f4522i;

    /* JADX INFO: renamed from: j */
    public final boolean f4523j;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$a */
    class a extends AbstractRunnableC4184g {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            InterfaceC4341d interfaceC4341dM4237n = C4134c.this.f4518e.m4237n();
            InterfaceC4384c interfaceC4384cMo4218b = C4134c.this.f4518e.mo4218b();
            List<C4133b> listMo4012j = interfaceC4341dM4237n.mo4012j(interfaceC4384cMo4218b);
            if (!listMo4012j.isEmpty()) {
                Date date = new Date();
                for (C4133b c4133b : listMo4012j) {
                    try {
                        c4133b.m2986a(date);
                        interfaceC4341dM4237n.mo4008a(c4133b, interfaceC4384cMo4218b);
                    } catch (Exception e) {
                        C4170g.m3207b(C4134c.f4514k, e, "Unable to update sync event analytic [%s]", Integer.valueOf(c4133b.m2990d()));
                    }
                }
            }
            C4170g.m3210c(C4134c.f4514k, "Handling app close and sending stats.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InAppMessage f4525b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ JSONObject f4526c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, InAppMessage inAppMessage, JSONObject jSONObject) {
            super(str, objArr);
            this.f4525b = inAppMessage;
            this.f4526c = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (C4143a.m3067e() == null || C4143a.m3067e().m3075h()) {
                C4170g.m3210c(C4134c.f4514k, "InAppMessage throttled event stat for message id %s", this.f4525b.m3690id());
                Date date = new Date();
                try {
                    C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(106, date, C4135d.m3001a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, date, this.f4525b.m3690id(), C4178a.m3325a(this.f4525b), this.f4526c), true)));
                } catch (JSONException e) {
                    C4170g.m3207b(C4134c.f4514k, e, "Failed to record iam throttled event stat.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$c */
    class c extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ JSONObject f4528b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, JSONObject jSONObject) {
            super(str, objArr);
            this.f4528b = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (C4143a.m3067e() == null || C4143a.m3067e().m3075h()) {
                try {
                    Date date = new Date();
                    C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(106, date, C4135d.m3001a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, date, (String) null, (String) null, this.f4528b), true)));
                } catch (Exception e) {
                    C4170g.m3207b(C4134c.f4514k, e, "Failed to record syncGateTimeOut Event stat.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ JSONObject f4530b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, JSONObject jSONObject) {
            super(str, objArr);
            this.f4530b = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (C4143a.m3067e() == null || C4143a.m3067e().m3075h()) {
                try {
                    Date date = new Date();
                    C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(106, date, C4135d.m3001a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, date, (String) null, (String) null, this.f4530b), true)));
                } catch (JSONException e) {
                    C4170g.m3207b(C4134c.f4514k, e, "Failed to record onInvalidConfig Event stat.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$e */
    class e extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ JSONObject f4532b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ InterfaceC4117l.a f4533c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, JSONObject jSONObject, InterfaceC4117l.a aVar) {
            super(str, objArr);
            this.f4532b = jSONObject;
            this.f4533c = aVar;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                if (C4143a.m3067e() == null || C4143a.m3067e().m3079l()) {
                    Date date = new Date();
                    C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(107, date, C4135d.m3003a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, date, this.f4532b), true)));
                }
            } catch (Exception e) {
                C4170g.m3207b(C4134c.f4514k, e, "Failed to record onTelemetryEvent stat. %s", this.f4533c.name());
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$f */
    class f extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Event[] f4535b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Date f4536c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ C4106e f4537d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, Event[] eventArr, Date date, C4106e c4106e) {
            super(str, objArr);
            this.f4535b = eventArr;
            this.f4536c = date;
            this.f4537d = c4106e;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            Event[] eventArr;
            C4143a c4143aM3067e = C4143a.m3067e();
            if (c4143aM3067e == null) {
                return;
            }
            Event[] eventArr2 = this.f4535b;
            int length = eventArr2.length;
            Boolean boolValueOf = null;
            Boolean boolValueOf2 = null;
            Boolean boolValueOf3 = null;
            int i = 0;
            Boolean boolValueOf4 = null;
            while (i < length) {
                Event event = eventArr2[i];
                try {
                    if (c4143aM3067e.m3071b(event.getName())) {
                        int i2 = h.f4541a[event.getCategory().ordinal()];
                        if (i2 == 1) {
                            if (boolValueOf4 == null) {
                                boolValueOf4 = Boolean.valueOf(c4143aM3067e.m3074g());
                            }
                            if (!boolValueOf4.booleanValue()) {
                                eventArr = eventArr2;
                            }
                            C4170g.m3210c(C4134c.f4514k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.getName(), event.attributes());
                            eventArr = eventArr2;
                            C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(105, this.f4536c, C4135d.m3002a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, this.f4536c, event.getName(), event.id, event.toJson().getJSONObject(C4352k.a.f5654h), this.f4537d.m2913e(), c4143aM3067e.m3070a(event.getName())), true)));
                        } else if (i2 == 2) {
                            if (boolValueOf == null) {
                                boolValueOf = Boolean.valueOf(c4143aM3067e.m3076i());
                            }
                            if (!boolValueOf.booleanValue()) {
                                eventArr = eventArr2;
                            }
                            C4170g.m3210c(C4134c.f4514k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.getName(), event.attributes());
                            eventArr = eventArr2;
                            C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(105, this.f4536c, C4135d.m3002a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, this.f4536c, event.getName(), event.id, event.toJson().getJSONObject(C4352k.a.f5654h), this.f4537d.m2913e(), c4143aM3067e.m3070a(event.getName())), true)));
                        } else if (i2 != 3) {
                            if (i2 == 4) {
                                if (boolValueOf3 == null) {
                                    boolValueOf3 = Boolean.valueOf(c4143aM3067e.m3078k());
                                }
                                if (!boolValueOf3.booleanValue()) {
                                    eventArr = eventArr2;
                                }
                            }
                            C4170g.m3210c(C4134c.f4514k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.getName(), event.attributes());
                            eventArr = eventArr2;
                            try {
                                C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(105, this.f4536c, C4135d.m3002a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, this.f4536c, event.getName(), event.id, event.toJson().getJSONObject(C4352k.a.f5654h), this.f4537d.m2913e(), c4143aM3067e.m3070a(event.getName())), true)));
                            } catch (Exception e) {
                                e = e;
                                C4170g.m3206b(C4134c.f4514k, "Failed to record event in devstats", e);
                            }
                        } else {
                            if (boolValueOf2 == null) {
                                boolValueOf2 = Boolean.valueOf(c4143aM3067e.m3077j());
                            }
                            if (!boolValueOf2.booleanValue()) {
                                eventArr = eventArr2;
                            }
                            C4170g.m3210c(C4134c.f4514k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.getName(), event.attributes());
                            eventArr = eventArr2;
                            C4134c.this.f4522i.m3399b().execute(new C4132a(C4134c.this.f4518e.m4237n(), C4134c.this.f4518e.mo4218b(), C4133b.m2984a(105, this.f4536c, C4135d.m3002a(C4134c.this.f4520g.applicationId(), C4134c.this.f4517d, this.f4536c, event.getName(), event.id, event.toJson().getJSONObject(C4352k.a.f5654h), this.f4537d.m2913e(), c4143aM3067e.m3070a(event.getName())), true)));
                        }
                    } else {
                        eventArr = eventArr2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    eventArr = eventArr2;
                }
                i++;
                eventArr2 = eventArr;
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$g */
    class g extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ EnumC4172a f4539b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, EnumC4172a enumC4172a) {
            super(str, objArr);
            this.f4539b = enumC4172a;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            String string;
            EnumC4172a enumC4172a = this.f4539b;
            EnumC4172a enumC4172a2 = EnumC4172a.f4826r;
            if (enumC4172a == enumC4172a2 && !EnumC4172a.m3242a(C4134c.this.f4518e)) {
                C4134c.this.f4521h.m2868d(AbstractC4092a.a.f4325j);
                return;
            }
            EnumC4172a enumC4172a3 = this.f4539b;
            EnumC4172a enumC4172a4 = EnumC4172a.f4825q;
            List<C4133b> listMo4013k = enumC4172a3 == enumC4172a4 ? C4134c.this.f4518e.m4237n().mo4013k(C4134c.this.f4518e.mo4218b()) : C4134c.this.f4518e.m4237n().mo4014p(C4134c.this.f4518e.mo4218b());
            if (listMo4013k.isEmpty()) {
                EnumC4172a enumC4172a5 = this.f4539b;
                if (enumC4172a5 == enumC4172a4) {
                    C4134c.this.f4521h.m2868d(AbstractC4092a.a.f4324i);
                    return;
                } else {
                    if (enumC4172a5 == enumC4172a2) {
                        C4134c.this.f4521h.m2868d(AbstractC4092a.a.f4325j);
                        return;
                    }
                    return;
                }
            }
            C4170g.m3210c(C4134c.f4514k, "Preparing payload for device statistics.", new Object[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("applicationId", C4134c.this.f4520g.applicationId());
                jSONObject.put("deviceId", C4134c.this.f4517d);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONArray.put(jSONObject2);
                jSONObject.put("nodes", jSONArray);
                jSONObject2.put("version", 1);
                jSONObject2.put("name", NotificationCompat.CATEGORY_EVENT);
                Integer numM3100e = 1000;
                String strM3101f = null;
                if (this.f4539b == enumC4172a2) {
                    C4144b c4144bM3069a = C4143a.m3067e() != null ? C4143a.m3067e().m3069a(C4134c.this.f4518e, C4144b.b.f4696a.name()) : null;
                    if (c4144bM3069a != null) {
                        strM3101f = c4144bM3069a.m3101f();
                        if (c4144bM3069a.m3100e() != null) {
                            numM3100e = c4144bM3069a.m3100e();
                        }
                    }
                }
                for (Map.Entry<String, JSONArray> entry : C4134c.this.m2993a(listMo4013k, numM3100e.intValue()).entrySet()) {
                    jSONObject2.put(FirebaseAnalytics.Param.ITEMS, entry.getValue());
                    EnumC4172a enumC4172a6 = this.f4539b;
                    C4134c c4134c = C4134c.this;
                    MarketingCloudConfig marketingCloudConfig = c4134c.f4520g;
                    InterfaceC4340c interfaceC4340cMo4220c = c4134c.f4518e.mo4220c();
                    if (jSONObject instanceof JSONObject) {
                        string = JSONObjectInstrumentation.toString(jSONObject);
                    } else {
                        string = jSONObject.toString();
                    }
                    C4173b c4173bM3251a = enumC4172a6.m3251a(marketingCloudConfig, interfaceC4340cMo4220c, string, strM3101f);
                    c4173bM3251a.m3264a(entry.getKey());
                    C4134c.this.f4519f.m3298a(c4173bM3251a);
                }
            } catch (Exception e) {
                C4170g.m3207b(C4134c.f4514k, e, "Failed to start sync events request.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$h */
    static /* synthetic */ class h {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4541a;

        static {
            int[] iArr = new int[Event.Category.values().length];
            f4541a = iArr;
            try {
                iArr[Event.Category.APPLICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4541a[Event.Category.ENGAGEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4541a[Event.Category.IDENTITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4541a[Event.Category.SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C4134c(MarketingCloudConfig marketingCloudConfig, String str, boolean z, C4374j c4374j, C4174c c4174c, C4093b c4093b, C4189l c4189l) {
        this.f4520g = marketingCloudConfig;
        this.f4517d = str;
        this.f4523j = z;
        this.f4518e = c4374j;
        this.f4519f = c4174c;
        this.f4521h = c4093b;
        this.f4522i = c4189l;
        c4174c.m3297a(EnumC4172a.f4825q, this);
        c4174c.m3297a(EnumC4172a.f4826r, this);
        c4093b.m2861a(this, AbstractC4092a.a.f4324i, AbstractC4092a.a.f4325j);
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2924a(long j) {
        this.f4522i.m3399b().execute(new a("stats_app_close", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: b */
    public void mo2938b(InAppMessage inAppMessage) {
        if (!this.f4523j) {
            C4170g.m3202a(f4514k, "Track user is false.  Ignoring onInAppMessageDownloaded event.", new Object[0]);
            return;
        }
        try {
            C4170g.m3210c(f4514k, "Creating download event stat for message id %s", inAppMessage.m3690id());
            Date date = new Date();
            this.f4522i.m3399b().execute(new C4132a(this.f4518e.m4237n(), this.f4518e.mo4218b(), C4133b.m2984a(101, date, C4135d.m3007b(this.f4520g.applicationId(), this.f4517d, date, inAppMessage.m3690id(), C4178a.m3325a(inAppMessage)), true)));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to record analytic event for In App Message Downloaded", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        if (aVar == AbstractC4092a.a.f4324i) {
            C4170g.m3210c(f4514k, "Handling alarm to send stats", new Object[0]);
        } else if (aVar != AbstractC4092a.a.f4325j) {
            return;
        } else {
            C4170g.m3210c(f4514k, "Handling alarm to send stats", new Object[0]);
        }
        m2994a();
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: b */
    public void mo2949b(JSONObject jSONObject) {
        try {
            this.f4522i.m3399b().execute(new c("onSyncGateTimedOutEvent", new Object[0], jSONObject));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to track syncGateTimeOut Event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4119n
    /* JADX INFO: renamed from: a */
    public void mo2944a(C4106e c4106e, Event... eventArr) {
        try {
            this.f4522i.m3399b().execute(new f("track_events", new Object[0], eventArr, new Date(), c4106e));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to record iam displayed event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2934a(InAppMessage inAppMessage) {
        try {
            C4170g.m3210c(f4514k, "InAppMessage displayed event stat for message id %s", inAppMessage.m3690id());
            Date date = new Date();
            this.f4522i.m3399b().execute(new C4132a(this.f4518e.m4237n(), this.f4518e.mo4218b(), C4133b.m2984a(104, date, C4135d.m2997a(this.f4520g.applicationId(), this.f4517d, date, inAppMessage.m3690id(), C4178a.m3325a(inAppMessage)), true)));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to record iam displayed event stat.", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo2935a(com.salesforce.marketingcloud.messages.iam.InAppMessage r17, com.salesforce.marketingcloud.messages.iam.C4259j r18) {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r1.f4523j
            r2 = 0
            if (r0 != 0) goto L11
            java.lang.String r0 = com.salesforce.marketingcloud.analytics.stats.C4134c.f4514k
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Track user is false.  Ignoring onInAppMessageCompleted event."
            com.salesforce.marketingcloud.C4170g.m3202a(r0, r3, r2)
            return
        L11:
            java.lang.String r0 = com.salesforce.marketingcloud.analytics.stats.C4134c.f4514k     // Catch: java.lang.Exception -> Lb6
            java.lang.String r3 = "Creating display event stat for message id %s"
            java.lang.String r4 = r17.m3690id()     // Catch: java.lang.Exception -> Lb6
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.C4170g.m3210c(r0, r3, r4)     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.messages.iam.InAppMessage$Button r0 = r18.m3759a()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r3 = r18.m3762d()     // Catch: java.lang.Exception -> Lb6
            int r4 = r3.hashCode()     // Catch: java.lang.Exception -> Lb6
            r5 = -935167046(0xffffffffc8427bba, float:-199150.9)
            r6 = 1
            if (r4 == r5) goto L42
            r5 = 2117198997(0x7e31e495, float:5.9115055E37)
            if (r4 == r5) goto L38
            goto L4c
        L38:
            java.lang.String r4 = "buttonClicked"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> Lb6
            if (r3 == 0) goto L4c
            r3 = r6
            goto L4d
        L42:
            java.lang.String r4 = "autoDismissed"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> Lb6
            if (r3 == 0) goto L4c
            r3 = r2
            goto L4d
        L4c:
            r3 = -1
        L4d:
            r4 = 0
            if (r3 == 0) goto L5c
            if (r3 == r6) goto L54
            r6 = 3
            goto L5c
        L54:
            if (r0 == 0) goto L5b
            java.lang.String r0 = r0.m3691id()     // Catch: java.lang.Exception -> Lb6
            r4 = r0
        L5b:
            r6 = 2
        L5c:
            r15 = r4
            r14 = r6
            java.util.Date r0 = new java.util.Date     // Catch: java.lang.Exception -> Lb6
            java.util.Date r3 = r18.m3761c()     // Catch: java.lang.Exception -> Lb6
            long r3 = r3.getTime()     // Catch: java.lang.Exception -> Lb6
            long r5 = r18.m3760b()     // Catch: java.lang.Exception -> Lb6
            long r3 = r3 + r5
            r0.<init>(r3)     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.MarketingCloudConfig r3 = r1.f4520g     // Catch: java.lang.Exception -> Lb6
            java.lang.String r7 = r3.applicationId()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r8 = r1.f4517d     // Catch: java.lang.Exception -> Lb6
            java.lang.String r10 = r17.m3690id()     // Catch: java.lang.Exception -> Lb6
            java.lang.String r11 = com.salesforce.marketingcloud.internal.C4178a.m3325a(r17)     // Catch: java.lang.Exception -> Lb6
            long r3 = r18.m3760b()     // Catch: java.lang.Exception -> Lb6
            double r3 = (double) r3     // Catch: java.lang.Exception -> Lb6
            r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)     // Catch: java.lang.Exception -> Lb6
            long r12 = (long) r3     // Catch: java.lang.Exception -> Lb6
            r9 = r0
            com.salesforce.marketingcloud.analytics.stats.d r3 = com.salesforce.marketingcloud.analytics.stats.C4135d.m2998a(r7, r8, r9, r10, r11, r12, r14, r15)     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.internal.l r4 = r1.f4522i     // Catch: java.lang.Exception -> Lb6
            java.util.concurrent.ExecutorService r4 = r4.m3399b()     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.analytics.stats.a r5 = new com.salesforce.marketingcloud.analytics.stats.a     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.storage.j r6 = r1.f4518e     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.storage.d r6 = r6.m4237n()     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.storage.j r7 = r1.f4518e     // Catch: java.lang.Exception -> Lb6
            com.salesforce.marketingcloud.util.c r7 = r7.mo4218b()     // Catch: java.lang.Exception -> Lb6
            r8 = 100
            com.salesforce.marketingcloud.analytics.stats.b r0 = com.salesforce.marketingcloud.analytics.stats.C4133b.m2984a(r8, r0, r3, r2)     // Catch: java.lang.Exception -> Lb6
            r5.<init>(r6, r7, r0)     // Catch: java.lang.Exception -> Lb6
            r4.execute(r5)     // Catch: java.lang.Exception -> Lb6
            goto Lc0
        Lb6:
            r0 = move-exception
            java.lang.String r3 = com.salesforce.marketingcloud.analytics.stats.C4134c.f4514k
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "Failed to record analytic event for In App Message Displayed"
            com.salesforce.marketingcloud.C4170g.m3207b(r3, r0, r4, r2)
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.analytics.stats.C4134c.mo2935a(com.salesforce.marketingcloud.messages.iam.InAppMessage, com.salesforce.marketingcloud.messages.iam.j):void");
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2936a(InAppMessage inAppMessage, JSONObject jSONObject) {
        try {
            this.f4522i.m3399b().execute(new b("onInAppMessageThrottled", new Object[0], inAppMessage, jSONObject));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to track iam throttled event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2937a(String str, String str2, List<String> list) {
        C4170g.m3210c(f4514k, "Creating message validation error event stat for message id %s", str);
        try {
            Date date = new Date();
            this.f4522i.m3399b().execute(new C4132a(this.f4518e.m4237n(), this.f4518e.mo4218b(), C4133b.m2984a(103, date, C4135d.m3000a(this.f4520g.applicationId(), this.f4517d, date, str, str2, list), true)));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to record validation event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2947a(JSONObject jSONObject) {
        try {
            this.f4522i.m3399b().execute(new d("onInvalidConfigEvent", new Object[0], jSONObject));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to track onInvalidConfig Event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            C4170g.m3210c(f4514k, "Request failed: %d - %s", Integer.valueOf(c4175d.m3302b()), c4175d.m3305e());
            if (c4173b.m3278p() == EnumC4172a.f4825q) {
                this.f4521h.m2865b(AbstractC4092a.a.f4324i);
            } else if (c4173b.m3278p() == EnumC4172a.f4826r) {
                this.f4521h.m2865b(AbstractC4092a.a.f4325j);
            }
            if (c4173b.m3279q() != null) {
                this.f4518e.m4237n().mo4010d(C4104c.m2906a(c4173b.m3279q()));
                return;
            }
            return;
        }
        if (c4173b.m3278p() == EnumC4172a.f4825q) {
            this.f4521h.m2866c(AbstractC4092a.a.f4324i);
        } else if (c4173b.m3278p() == EnumC4172a.f4826r) {
            this.f4521h.m2866c(AbstractC4092a.a.f4325j);
        }
        if (c4173b.m3279q() != null) {
            String[] strArrM2906a = C4104c.m2906a(c4173b.m3279q());
            C4170g.m3210c(f4514k, "Removing events %s from DB", Arrays.toString(strArrM2906a));
            this.f4518e.m4237n().mo4009c(strArrM2906a);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4117l
    /* JADX INFO: renamed from: a */
    public void mo2945a(InterfaceC4117l.a aVar, JSONObject jSONObject) {
        try {
            this.f4522i.m3399b().execute(new e("onTelemetryEvent", new Object[0], jSONObject, aVar));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to track onTelemetryEvent stat. %s", aVar.name());
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2946a(String str, String str2, String str3, String str4) {
        if (!this.f4523j) {
            C4170g.m3202a(f4514k, "Track user is false.  Ignoring onTriggerSuccessEvent event.", new Object[0]);
            return;
        }
        C4170g.m3210c(f4514k, "Creating trigger event stat for message id %s", str);
        try {
            Date date = new Date();
            this.f4522i.m3399b().execute(new C4132a(this.f4518e.m4237n(), this.f4518e.mo4218b(), C4133b.m2984a(102, date, C4135d.m2999a(this.f4520g.applicationId(), this.f4517d, date, str2, str4, str, str3), true)));
        } catch (Exception e2) {
            C4170g.m3207b(f4514k, e2, "Failed to record device stat for successful trigger event", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    Map<String, JSONArray> m2993a(List<C4133b> list, int i) {
        boolean z;
        int size = list.size();
        int iCeil = (int) Math.ceil(((double) size) / ((double) i));
        ArrayMap arrayMap = new ArrayMap(iCeil);
        for (int i2 = 0; i2 < iCeil; i2++) {
            StringBuilder sb = new StringBuilder();
            JSONArray jSONArray = new JSONArray();
            int i3 = i2 * i;
            boolean z2 = true;
            int i4 = i3;
            while (i4 < size && i4 < i3 + i) {
                C4133b c4133b = list.get(i4);
                if (z2) {
                    z = false;
                } else {
                    sb.append(',');
                    z = z2;
                }
                sb.append(c4133b.m2988b());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, c4133b.m2990d());
                    jSONObject.put(NotificationCompat.CATEGORY_EVENT, c4133b.m2989c().f4542a);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    C4170g.m3207b(f4514k, e2, "Unable to add device stats to payload.", new Object[0]);
                }
                i4++;
                z2 = z;
            }
            arrayMap.put(sb.toString(), jSONArray);
        }
        return arrayMap;
    }

    /* JADX INFO: renamed from: a */
    public void m2994a() {
        m2995a(EnumC4172a.f4825q);
        m2995a(EnumC4172a.f4826r);
    }

    /* JADX INFO: renamed from: a */
    void m2995a(EnumC4172a enumC4172a) {
        this.f4522i.m3399b().execute(new g("send_stats", new Object[0], enumC4172a));
    }

    /* JADX INFO: renamed from: a */
    public static void m2992a(C4374j c4374j, boolean z) {
        if (z) {
            c4374j.m4237n().mo4011f();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2918a(boolean z) {
        this.f4519f.m3296a(EnumC4172a.f4825q);
        this.f4519f.m3296a(EnumC4172a.f4826r);
        C4093b c4093b = this.f4521h;
        AbstractC4092a.a aVar = AbstractC4092a.a.f4324i;
        AbstractC4092a.a aVar2 = AbstractC4092a.a.f4325j;
        c4093b.m2869e(aVar, aVar2);
        if (z) {
            this.f4521h.m2868d(aVar, aVar2);
        }
    }
}
