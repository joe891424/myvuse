package com.salesforce.marketingcloud.events;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.C4193k;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.analytics.C4106e;
import com.salesforce.marketingcloud.analytics.C4113h;
import com.salesforce.marketingcloud.analytics.InterfaceC4117l;
import com.salesforce.marketingcloud.analytics.InterfaceC4118m;
import com.salesforce.marketingcloud.analytics.InterfaceC4119n;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.events.C4156g;
import com.salesforce.marketingcloud.events.predicates.AbstractC4163f;
import com.salesforce.marketingcloud.events.predicates.C4158a;
import com.salesforce.marketingcloud.events.predicates.C4159b;
import com.salesforce.marketingcloud.events.predicates.C4160c;
import com.salesforce.marketingcloud.events.predicates.C4161d;
import com.salesforce.marketingcloud.events.predicates.C4162e;
import com.salesforce.marketingcloud.events.predicates.C4164g;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.C4311f;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4378n;
import com.salesforce.marketingcloud.storage.p047db.C4354m;
import com.salesforce.marketingcloud.util.C4389h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4152c extends EventManager implements InterfaceC4147e, C4193k.e, InterfaceC4139b, EventSubscriber {

    /* JADX INFO: renamed from: r */
    public static final String f4704r = "event_gate_time_mills";

    /* JADX INFO: renamed from: s */
    public static final String f4705s = "event_max_display_in_session";

    /* JADX INFO: renamed from: t */
    public static final String f4706t = "event_min_time_sec_in_session";

    /* JADX INFO: renamed from: v */
    private static final String f4708v = "$opencount";

    /* JADX INFO: renamed from: w */
    private static final int f4709w = 1;

    /* JADX INFO: renamed from: d */
    protected final InterfaceC4118m f4711d;

    /* JADX INFO: renamed from: e */
    final SFMCSdkComponents f4712e;

    /* JADX INFO: renamed from: f */
    final C4374j f4713f;

    /* JADX INFO: renamed from: g */
    private final C4193k f4714g;

    /* JADX INFO: renamed from: h */
    private final C4140c f4715h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC4155f f4716i;

    /* JADX INFO: renamed from: j */
    private final InterfaceC4117l f4717j;

    /* JADX INFO: renamed from: k */
    private final InterfaceC4119n f4718k;

    /* JADX INFO: renamed from: l */
    private final C4189l f4719l;

    /* JADX INFO: renamed from: n */
    private final Context f4721n;

    /* JADX INFO: renamed from: p */
    protected C4143a f4723p;

    /* JADX INFO: renamed from: q */
    private C4311f f4724q;

    /* JADX INFO: renamed from: u */
    static final String f4707u = C4170g.m3197a("EventManager");

    /* JADX INFO: renamed from: x */
    private static final EnumSet<C4193k.d> f4710x = EnumSet.of(C4193k.d.triggers);

    /* JADX INFO: renamed from: m */
    private final AtomicBoolean f4720m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o */
    protected CountDownLatch f4722o = new CountDownLatch(1);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Event[] f4725b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, Event... eventArr) {
            super(str, objArr);
            this.f4725b = eventArr;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            int i = C4152c.this.f4713f.mo4222f().getInt(C4152c.f4704r, 0);
            if (i > 0) {
                try {
                    if (!C4152c.this.f4722o.await(i, TimeUnit.MILLISECONDS)) {
                        C4170g.m3216e(C4152c.f4707u, "Track await time of %s milliseconds exceeded!", Integer.valueOf(i));
                        C4152c.this.f4722o.countDown();
                        if (C4152c.this.f4723p.m3075h()) {
                            C4152c.this.f4711d.mo2949b(new JSONObject().put(C4143a.f4651f, i));
                        }
                    }
                } catch (InterruptedException e) {
                    C4170g.m3207b(C4152c.f4707u, e, "Encountered exception while awaiting at track.", new Object[0]);
                } catch (JSONException e2) {
                    C4170g.m3207b(C4152c.f4707u, e2, "Failed to log analytics for onSyncGateTimedOut", new Object[0]);
                }
            }
            Event[] eventArr = this.f4725b;
            ArrayList arrayList = null;
            if (eventArr != null && eventArr.length > 0) {
                for (Event event : eventArr) {
                    if (event != null) {
                        C4170g.m3202a(C4152c.f4707u, "(%s) event logged with attributes %s", event.name(), event.attributes());
                        C4152c c4152c = C4152c.this;
                        List<C4154e> listM3122a = c4152c.m3122a(event, c4152c.m3121a(event));
                        if (listM3122a != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.addAll(listM3122a);
                        }
                    }
                }
            }
            if (arrayList != null) {
                C4152c.this.m3123a(arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Event[] f4727b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, Event... eventArr) {
            super(str, objArr);
            this.f4727b = eventArr;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            Event[] eventArr = this.f4727b;
            if (eventArr == null || eventArr.length <= 0) {
                return;
            }
            C4152c c4152c = C4152c.this;
            SFMCSdkComponents sFMCSdkComponents = c4152c.f4712e;
            if (sFMCSdkComponents != null) {
                sFMCSdkComponents.getEventManager().track(C4153d.m3139b(this.f4727b, EnumSet.of(Event.Producer.PUSH)));
            } else {
                c4152c.m3124a(eventArr);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$c */
    class c extends ArrayList<Object> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ C4157h f4729a;

        c(C4157h c4157h) {
            this.f4729a = c4157h;
            add(Integer.valueOf(C4152c.this.f4713f.m4245v().mo4168b(c4157h)));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$d */
    class d extends AbstractRunnableC4184g {
        d(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4152c.this.f4713f.m4245v().mo4172k();
            C4152c.this.m3124a(new C4150a());
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$e */
    class e extends AbstractRunnableC4184g {
        e(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4170g.m3210c(C4152c.f4707u, "Purged %d outdated debug/telemetry events.", Integer.valueOf(C4152c.this.f4713f.m4237n().mo4007a()));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$f */
    class f extends AbstractRunnableC4184g {
        f(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4170g.m3210c(C4152c.f4707u, "Purged %d outdated analytic events.", Integer.valueOf(C4152c.this.f4713f.m4236m().mo3981a()));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.c$g */
    static /* synthetic */ class g {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4734a;

        static {
            int[] iArr = new int[C4156g.b.values().length];
            f4734a = iArr;
            try {
                iArr[C4156g.b.f4757a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4734a[C4156g.b.f4758b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4734a[C4156g.b.f4759c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4734a[C4156g.b.f4760d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C4152c(Context context, C4311f c4311f, C4374j c4374j, C4193k c4193k, C4140c c4140c, C4113h c4113h, C4189l c4189l, SFMCSdkComponents sFMCSdkComponents, C4143a c4143a, InterfaceC4155f interfaceC4155f) {
        this.f4721n = context;
        this.f4724q = c4311f;
        this.f4713f = c4374j;
        this.f4714g = c4193k;
        this.f4715h = c4140c;
        this.f4711d = c4113h;
        this.f4718k = c4113h;
        this.f4716i = interfaceC4155f;
        this.f4719l = c4189l;
        this.f4712e = sFMCSdkComponents;
        this.f4717j = c4113h;
        this.f4723p = c4143a;
    }

    /* JADX INFO: renamed from: a */
    private AbstractC4163f m3114a(C4157h c4157h, Event event, List<C4156g> list) {
        ArrayList arrayList;
        if (list == null || list.size() == 0) {
            return AbstractC4163f.f4774b;
        }
        Map<String, List<Object>> mapM3126a = C4153d.m3126a(event);
        Map<String, List<Object>> mapM3117a = m3117a(c4157h);
        mapM3117a.putAll(mapM3126a);
        String strM3179g = c4157h.m3179g();
        if (strM3179g != null) {
            HashMap map = new HashMap(list.size());
            for (C4156g c4156g : list) {
                map.put(Integer.valueOf(c4156g.m3160f()), c4156g);
            }
            arrayList = new ArrayList(map.size());
            for (String str : strM3179g.split(strM3179g.contains("||") ? "\\|\\|" : "&&")) {
                arrayList.add(m3116a(mapM3117a, (C4156g) map.get(Integer.valueOf(Integer.parseInt(str)))));
            }
        } else {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<C4156g> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(m3116a(mapM3117a, it2.next()));
            }
            arrayList = arrayList2;
        }
        return (strM3179g == null || !strM3179g.contains("||")) ? new C4158a((AbstractC4163f[]) arrayList.toArray(new AbstractC4163f[0])) : new C4162e((AbstractC4163f[]) arrayList.toArray(new AbstractC4163f[0]));
    }

    /* JADX INFO: renamed from: b */
    private void m3120b() {
        SFMCSdkComponents sFMCSdkComponents = this.f4712e;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().unsubscribe(this);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "Event";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C4354m.f5672g, this.f4713f.m4245v().mo4173m());
        } catch (Exception e2) {
            C4170g.m3207b(f4707u, e2, "Unable to compile componentState for EventComponent", new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (!C4137b.m3024a(i, 4096)) {
            this.f4714g.m3445a(f4710x, this);
            this.f4715h.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_APP_FOREGROUNDED));
            m3118a();
            this.f4720m.set(false);
            return;
        }
        this.f4720m.set(true);
        this.f4714g.m3445a(f4710x, (C4193k.e) null);
        this.f4715h.m3036a(this);
        if (C4137b.m3027c(i, 4096)) {
            this.f4713f.m4245v().mo4169b(Collections.emptyList());
        }
        m3120b();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        if (!C4137b.m3026b(i, 4096)) {
            m3120b();
            this.f4720m.set(true);
        } else {
            this.f4714g.m3445a(f4710x, this);
            this.f4715h.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_APP_FOREGROUNDED));
            m3118a();
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        if (this.f4720m.get() || enumC4138a != EnumC4138a.BEHAVIOR_APP_FOREGROUNDED) {
            return;
        }
        if (this.f4722o.getCount() <= 0) {
            this.f4722o = new CountDownLatch(1);
        }
        try {
            this.f4719l.m3399b().execute(new d("app_foreground_trigger", new Object[0]));
            this.f4719l.m3399b().execute(new e("dev_stats_db_cleanup", new Object[0]));
            this.f4719l.m3399b().execute(new f("analytic_item_db_cleanup", new Object[0]));
        } catch (Exception e2) {
            C4170g.m3217e(f4707u, e2, "An error occurred while triggering app foreground", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber
    public void onEventPublished(com.salesforce.marketingcloud.sfmcsdk.components.events.Event... eventArr) {
        try {
            SFMCSdkComponents sFMCSdkComponents = this.f4712e;
            PushMessageManager pushMessageManager = null;
            Identity identity = sFMCSdkComponents != null ? sFMCSdkComponents.getIdentity() : null;
            try {
                MarketingCloudSdk marketingCloudSdk = MarketingCloudSdk.getInstance();
                if (marketingCloudSdk != null) {
                    pushMessageManager = marketingCloudSdk.getPushMessageManager();
                }
            } catch (Exception unused) {
            }
            m3124a(C4153d.m3132a((Object[]) eventArr));
            this.f4718k.mo2944a(new C4106e(this.f4724q, pushMessageManager, C4389h.m4322b(this.f4721n), identity), eventArr);
        } catch (Exception e2) {
            C4170g.m3207b(f4707u, e2, "Could not process events from onEventPublished()", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.C4193k.e
    public void onSyncReceived(C4193k.d dVar, JSONObject jSONObject) {
        if (this.f4720m.get() || !f4710x.contains(dVar)) {
            return;
        }
        if (jSONObject.optInt("version") != 1) {
            C4170g.m3206b(f4707u, "Unable to handle sync payload due to version mismatch", new Object[0]);
        } else if (dVar == C4193k.d.triggers) {
            m3119a(jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4714g.m3445a(f4710x, (C4193k.e) null);
        this.f4715h.m3036a(this);
        m3120b();
    }

    @Override // com.salesforce.marketingcloud.events.EventManager
    public void track(Event... eventArr) {
        if (this.f4720m.get()) {
            return;
        }
        try {
            this.f4719l.m3399b().execute(new b("trigger_event", new Object[0], eventArr));
        } catch (Exception e2) {
            C4170g.m3217e(f4707u, e2, "An error occurred while triggering track event", new Object[0]);
        }
    }

    protected C4152c(Context context, C4311f c4311f, C4374j c4374j, C4193k c4193k, C4140c c4140c, InterfaceC4118m interfaceC4118m, InterfaceC4119n interfaceC4119n, C4189l c4189l, SFMCSdkComponents sFMCSdkComponents, InterfaceC4155f interfaceC4155f, C4143a c4143a, InterfaceC4117l interfaceC4117l) {
        this.f4721n = context;
        this.f4724q = c4311f;
        this.f4713f = c4374j;
        this.f4714g = c4193k;
        this.f4715h = c4140c;
        this.f4711d = interfaceC4118m;
        this.f4718k = interfaceC4119n;
        this.f4716i = interfaceC4155f;
        this.f4719l = c4189l;
        this.f4712e = sFMCSdkComponents;
        this.f4717j = interfaceC4117l;
        this.f4723p = c4143a;
    }

    /* JADX INFO: renamed from: a */
    List<C4154e> m3122a(Event event, List<C4157h> list) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0) {
            try {
                for (C4157h c4157h : list) {
                    if (m3114a(c4157h, event, c4157h.m3183k()).m3193b()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        for (C4154e c4154e : c4157h.m3182j()) {
                            arrayList.add(c4154e);
                            try {
                                this.f4711d.mo2946a(c4157h.m3180h(), c4154e.m3150e(), c4154e.m3151f(), c4154e.m3149d());
                            } catch (Exception e2) {
                                C4170g.m3207b(f4707u, e2, "Failed to log analytics for trigger [%s]", c4157h.m3180h());
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e3) {
                C4170g.m3207b(f4707u, e3, "An outcome could not be reached with the given trigger(s) for the event.", new Object[0]);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private AbstractC4163f m3116a(Map<String, List<Object>> map, C4156g c4156g) {
        int i;
        if (c4156g == null) {
            return AbstractC4163f.f4775c;
        }
        ArrayList arrayList = new ArrayList();
        List<Object> list = map.get(c4156g.m3161g().toLowerCase(Locale.getDefault()));
        if (list != null) {
            i = 0;
            for (Object obj : list) {
                if (obj instanceof List) {
                    try {
                        Iterator it2 = ((List) obj).iterator();
                        while (it2.hasNext()) {
                            arrayList.add(m3115a(it2.next(), c4156g));
                            i++;
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    arrayList.add(m3115a(obj, c4156g));
                    i++;
                }
            }
        } else {
            i = 0;
        }
        return i > 1 ? new C4162e((AbstractC4163f[]) arrayList.toArray(new AbstractC4163f[0])) : i == 1 ? new C4158a((AbstractC4163f[]) arrayList.toArray(new AbstractC4163f[0])) : AbstractC4163f.f4775c;
    }

    /* JADX INFO: renamed from: a */
    private AbstractC4163f m3115a(Object obj, C4156g c4156g) {
        int i = g.f4734a[c4156g.m3164j().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractC4163f.f4775c : new C4164g(obj, c4156g.m3162h(), c4156g.m3163i()) : new C4159b(obj, c4156g.m3162h(), c4156g.m3163i()) : new C4160c(obj, c4156g.m3162h(), c4156g.m3163i()) : new C4161d(obj, c4156g.m3162h(), c4156g.m3163i());
    }

    /* JADX INFO: renamed from: a */
    private Map<String, List<Object>> m3117a(C4157h c4157h) {
        HashMap map = new HashMap();
        map.put(f4708v, new c(c4157h));
        return map;
    }

    /* JADX INFO: renamed from: a */
    void m3123a(List<C4154e> list) {
        InterfaceC4155f interfaceC4155f;
        TreeSet treeSet = null;
        for (C4154e c4154e : list) {
            if ("iam".equals(c4154e.m3151f())) {
                if (treeSet == null) {
                    treeSet = new TreeSet();
                }
                treeSet.add(c4154e.m3150e());
            }
        }
        if (treeSet == null || (interfaceC4155f = this.f4716i) == null) {
            return;
        }
        interfaceC4155f.handleOutcomes(treeSet);
    }

    /* JADX INFO: renamed from: a */
    void m3124a(Event... eventArr) {
        if (this.f4720m.get()) {
            return;
        }
        try {
            this.f4719l.m3399b().execute(new a("trigger_event", new Object[0], eventArr));
        } catch (Exception e2) {
            C4170g.m3217e(f4707u, e2, "An error occurred while processing the event", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3119a(JSONObject jSONObject) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
            int length = jSONArray.length();
            C4170g.m3202a(f4707u, "%d triggers received from sync.", Integer.valueOf(length));
            TreeSet treeSet = new TreeSet();
            InterfaceC4378n interfaceC4378nM4245v = this.f4713f.m4245v();
            for (int i = 0; i < length; i++) {
                try {
                    C4157h c4157h = new C4157h(jSONArray.getJSONObject(i));
                    interfaceC4378nM4245v.mo4167a(c4157h);
                    treeSet.add(c4157h.m3180h());
                } catch (Exception e2) {
                    C4170g.m3207b(f4707u, e2, "Unable to parse trigger from payload", new Object[0]);
                }
            }
            interfaceC4378nM4245v.mo4169b(treeSet);
            JSONObject jSONObject2 = new JSONObject();
            InterfaceC4117l.a aVar = InterfaceC4117l.a.TRIGGER_PROCESS;
            jSONObject2.put(aVar.m2951b(), System.currentTimeMillis() - jCurrentTimeMillis);
            if (this.f4723p.m3079l()) {
                this.f4717j.mo2945a(aVar, jSONObject2);
            }
        } catch (JSONException e3) {
            C4170g.m3207b(f4707u, e3, "Unable to parse trigger sync payload", new Object[0]);
        }
        this.f4722o.countDown();
    }

    /* JADX INFO: renamed from: a */
    private void m3118a() {
        SFMCSdkComponents sFMCSdkComponents = this.f4712e;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().subscribe(this);
        }
    }

    /* JADX INFO: renamed from: a */
    List<C4157h> m3121a(Event event) {
        return this.f4713f.m4245v().mo4171g(event.name());
    }
}
