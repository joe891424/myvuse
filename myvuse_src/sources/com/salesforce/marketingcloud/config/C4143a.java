package com.salesforce.marketingcloud.config;

import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.C4193k;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.InterfaceC4118m;
import com.salesforce.marketingcloud.config.C4144b;
import com.salesforce.marketingcloud.events.C4152c;
import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4143a extends AbstractC4169f implements C4193k.e {

    /* JADX INFO: renamed from: A */
    private static final String f4635A = "invalidConfigurationValue";

    /* JADX INFO: renamed from: B */
    private static final String f4636B = "event";

    /* JADX INFO: renamed from: C */
    private static final String f4637C = "activeEvents";

    /* JADX INFO: renamed from: D */
    private static final String f4638D = "enableEngagementEvents";

    /* JADX INFO: renamed from: E */
    private static final String f4639E = "enableSystemEvents";

    /* JADX INFO: renamed from: F */
    private static final String f4640F = "enableAppEvents";

    /* JADX INFO: renamed from: G */
    private static final String f4641G = "enableIdentityEvents";

    /* JADX INFO: renamed from: H */
    private static final String f4642H = "enableDebugInfo";

    /* JADX INFO: renamed from: I */
    private static final String f4643I = "enableTelemetryInfo";

    /* JADX INFO: renamed from: J */
    private static final String f4644J = "endpoints";

    /* JADX INFO: renamed from: K */
    private static final String f4645K = "dataTypes";

    /* JADX INFO: renamed from: L */
    private static final int f4646L = 1000;

    /* JADX INFO: renamed from: M */
    private static final String f4647M = "version";

    /* JADX INFO: renamed from: N */
    private static C4143a f4648N = null;

    /* JADX INFO: renamed from: d */
    public static final a f4649d = new a(null);

    /* JADX INFO: renamed from: e */
    public static final String f4650e = "correlationIds";

    /* JADX INFO: renamed from: f */
    public static final String f4651f = "gateEventProcessingMs";

    /* JADX INFO: renamed from: g */
    public static final int f4652g = 0;

    /* JADX INFO: renamed from: h */
    public static final String f4653h = "eventName";

    /* JADX INFO: renamed from: i */
    public static final String f4654i = "endpoint";

    /* JADX INFO: renamed from: j */
    public static final String f4655j = "path";

    /* JADX INFO: renamed from: k */
    public static final String f4656k = "maxBatchSize";

    /* JADX INFO: renamed from: l */
    private static final EnumSet<C4193k.d> f4657l;

    /* JADX INFO: renamed from: m */
    private static final Object f4658m;

    /* JADX INFO: renamed from: n */
    private static final String f4659n = "~!ConfigComponent";

    /* JADX INFO: renamed from: o */
    private static final int f4660o = 1;

    /* JADX INFO: renamed from: p */
    private static final boolean f4661p = true;

    /* JADX INFO: renamed from: q */
    private static final boolean f4662q = false;

    /* JADX INFO: renamed from: r */
    private static final boolean f4663r = false;

    /* JADX INFO: renamed from: s */
    private static final boolean f4664s = false;

    /* JADX INFO: renamed from: t */
    private static final boolean f4665t = false;

    /* JADX INFO: renamed from: u */
    private static final boolean f4666u = false;

    /* JADX INFO: renamed from: v */
    private static final String f4667v = "items";

    /* JADX INFO: renamed from: w */
    private static final String f4668w = "inApp";

    /* JADX INFO: renamed from: x */
    private static final String f4669x = "maxDisplay";

    /* JADX INFO: renamed from: y */
    private static final String f4670y = "timeBetweenDisplaySec";

    /* JADX INFO: renamed from: z */
    private static final String f4671z = "invalidConfigurationKey";

    /* JADX INFO: renamed from: O */
    private final C4193k f4672O;

    /* JADX INFO: renamed from: P */
    private final C4374j f4673P;

    /* JADX INFO: renamed from: Q */
    private final InterfaceC4118m f4674Q;

    /* JADX INFO: renamed from: R */
    private Map<String, C4144b> f4675R;

    /* JADX INFO: renamed from: S */
    private Boolean f4676S;

    /* JADX INFO: renamed from: T */
    private Boolean f4677T;

    /* JADX INFO: renamed from: U */
    private Boolean f4678U;

    /* JADX INFO: renamed from: V */
    private Boolean f4679V;

    /* JADX INFO: renamed from: W */
    private Boolean f4680W;

    /* JADX INFO: renamed from: X */
    private Boolean f4681X;

    /* JADX INFO: renamed from: Y */
    private Map<String, String> f4682Y;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public static /* synthetic */ void m3080b() {
        }

        /* JADX INFO: renamed from: a */
        public final C4143a m3081a() {
            return C4143a.f4648N;
        }

        /* JADX INFO: renamed from: c */
        public final Object m3083c() {
            return C4143a.f4658m;
        }

        /* JADX INFO: renamed from: d */
        public final EnumSet<C4193k.d> m3084d() {
            return C4143a.f4657l;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final void m3082a(C4143a c4143a) {
            C4143a.f4648N = c4143a;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$b */
    static final class b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final b f4683a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to generate complete SDK state output for component.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$c */
    static final class c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final c f4684a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [Endpoint Config] sync data.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$d */
    static final class d extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final d f4685a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [Event Config] sync data";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$e */
    static final class e extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final e f4686a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [InApp Config] sync data";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$f */
    static final class f extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4687a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.f4687a = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unknown endpoint '" + this.f4687a + "' in config.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$g */
    static final class g extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final g f4688a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse endpoint from sync response.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$h */
    static final class h extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final h f4689a = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to handle sync payload due to version mismatch";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$i */
    static final class i extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final i f4690a = new i();

        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Could not process [AppConfig Node] from Sync.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$j */
    static final class j extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(0);
            this.f4691a = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to log analytics for InvalidConfig [" + this.f4691a + "]";
        }
    }

    static {
        EnumSet<C4193k.d> enumSetOf = EnumSet.of(C4193k.d.appConfig);
        Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
        f4657l = enumSetOf;
        f4658m = new Object();
    }

    public C4143a(C4193k syncRouteComponent, C4374j storage, InterfaceC4118m triggerAnalytics) {
        Intrinsics.checkNotNullParameter(syncRouteComponent, "syncRouteComponent");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(triggerAnalytics, "triggerAnalytics");
        this.f4672O = syncRouteComponent;
        this.f4673P = storage;
        this.f4674Q = triggerAnalytics;
        f4648N = this;
    }

    /* JADX INFO: renamed from: e */
    public static final C4143a m3067e() {
        return f4649d.m3081a();
    }

    /* JADX INFO: renamed from: f */
    private final Map<String, String> m3068f() {
        SharedPreferences sharedPreferencesMo4222f = this.f4673P.mo4222f();
        JSONArray jSONArray = new JSONArray();
        return PushExtensionsKt.toMap(new JSONArray(sharedPreferencesMo4222f.getString(f4637C, !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray))));
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "ConfigComponent";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        synchronized (f4658m) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(f4638D, this.f4673P.mo4222f().getBoolean(f4638D, true));
                jSONObject2.put(f4639E, this.f4673P.mo4222f().getBoolean(f4639E, false));
                jSONObject2.put(f4640F, this.f4673P.mo4222f().getBoolean(f4640F, false));
                jSONObject2.put(f4641G, this.f4673P.mo4222f().getBoolean(f4641G, false));
                jSONObject2.put(f4643I, this.f4673P.mo4222f().getBoolean(f4643I, false));
                jSONObject2.put(f4642H, this.f4673P.mo4222f().getBoolean(f4642H, false));
                Map<String, String> mapEmptyMap = this.f4682Y;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : mapEmptyMap.entrySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(f4653h, entry.getKey());
                    String value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(f4650e, value);
                    }
                    jSONArray.put(jSONObject3);
                }
                Unit unit = Unit.INSTANCE;
                jSONObject2.put(f4637C, jSONArray);
                jSONObject.put("event", jSONObject2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(f4651f, this.f4673P.mo4222f().getInt(f4651f, 0));
                jSONObject4.put(f4669x, this.f4673P.mo4222f().getInt(f4669x, Integer.MAX_VALUE));
                jSONObject4.put(f4670y, this.f4673P.mo4222f().getInt(f4670y, 0));
                jSONObject.put(f4668w, jSONObject4);
                Map<String, C4144b> mapEmptyMap2 = this.f4675R;
                if (mapEmptyMap2 == null) {
                    mapEmptyMap2 = MapsKt.emptyMap();
                }
                jSONObject.put(f4644J, PushExtensionsKt.toJSONArray(mapEmptyMap2));
            } catch (Exception unused) {
                C4170g.m3215e(C4170g.f4785a, f4659n, null, b.f4683a, 2, null);
            }
            Unit unit2 = Unit.INSTANCE;
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: d */
    public final Map<String, String> m3073d() {
        return this.f4682Y;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3074g() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4678U;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4640F, false);
                this.f4678U = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m3075h() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4681X;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4642H, false);
                this.f4681X = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3076i() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4676S;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4638D, true);
                this.f4676S = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3077j() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4679V;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4641G, false);
                this.f4679V = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m3078k() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4677T;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4639E, false);
                this.f4677T = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m3079l() {
        boolean zBooleanValue;
        synchronized (f4658m) {
            Boolean bool = this.f4680W;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.f4673P.mo4222f().getBoolean(f4643I, false);
                this.f4680W = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    @Override // com.salesforce.marketingcloud.C4193k.e
    public void onSyncReceived(C4193k.d node, JSONObject data) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(data, "data");
        if (f4657l.contains(node)) {
            if (data.optInt(f4647M) != 1) {
                C4170g.m3205b(C4170g.f4785a, f4659n, null, h.f4689a, 2, null);
                return;
            }
            try {
                if (node == C4193k.d.appConfig) {
                    m3072c(data);
                }
            } catch (Throwable th) {
                C4170g.f4785a.m3223b(f4659n, th, i.f4690a);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4672O.m3445a(f4657l, (C4193k.e) null);
        f4648N = null;
    }

    /* JADX INFO: renamed from: b */
    private final void m3065b(JSONObject jSONObject) {
        int iOptInt;
        synchronized (f4658m) {
            try {
                int iOptInt2 = jSONObject.optInt(f4651f, 0);
                int iOptInt3 = jSONObject.optInt(f4669x, Integer.MAX_VALUE);
                iOptInt = jSONObject.optInt(f4670y, 0);
                SharedPreferences.Editor editorEdit = this.f4673P.mo4222f().edit();
                Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
                if (iOptInt2 >= 0) {
                    editorEdit.putInt(C4152c.f4704r, iOptInt2);
                }
                if (iOptInt3 >= 0) {
                    editorEdit.putInt(C4152c.f4705s, iOptInt3);
                }
                if (iOptInt >= 0) {
                    editorEdit.putInt(C4152c.f4706t, iOptInt);
                }
                editorEdit.apply();
                if (iOptInt2 < 0) {
                    m3059a(f4651f, String.valueOf(iOptInt2));
                }
                if (iOptInt3 < 0) {
                    m3059a(f4669x, String.valueOf(iOptInt3));
                }
            } catch (Exception e2) {
                C4170g.f4785a.m3223b(f4659n, e2, e.f4686a);
            }
            if (iOptInt < 0) {
                m3059a(f4670y, String.valueOf(iOptInt));
                Unit unit = Unit.INSTANCE;
            } else {
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3072c(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObjectOptJSONObject = data.optJSONObject("items");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("event");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        } else {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
        }
        m3061a(jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(f4668w);
        if (jSONObjectOptJSONObject3 == null) {
            jSONObjectOptJSONObject3 = new JSONObject();
        } else {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject3);
        }
        m3065b(jSONObjectOptJSONObject3);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(f4644J);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        } else {
            Intrinsics.checkNotNull(jSONArrayOptJSONArray);
        }
        m3060a(jSONArrayOptJSONArray);
    }

    /* JADX INFO: renamed from: b */
    private final Map<String, C4144b> m3063b(JSONArray jSONArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    Object obj = jSONArray.get(i2);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f4645K);
                    if (jSONArrayOptJSONArray != null) {
                        int length2 = jSONArrayOptJSONArray.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            Object obj2 = jSONArrayOptJSONArray.get(i3);
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (Intrinsics.areEqual(str, "EVENTS")) {
                                C4144b.a aVar = C4144b.f4692d;
                                String stringOrNull = PushExtensionsKt.getStringOrNull(jSONObject, "path");
                                Integer intOrNull = PushExtensionsKt.getIntOrNull(jSONObject, f4656k);
                                linkedHashMap.put(str, aVar.m3105a(str, stringOrNull, Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 1000)));
                            } else {
                                C4170g.m3215e(C4170g.f4785a, f4659n, null, new f(str), 2, null);
                            }
                        }
                    }
                } catch (Exception e2) {
                    C4170g.f4785a.m3226e(f4659n, e2, g.f4688a);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    public final C4144b m3069a(C4374j c4374j, String str) {
        String string;
        C4144b c4144b;
        if (c4374j == null || str == null || str.length() == 0) {
            return null;
        }
        synchronized (f4658m) {
            Map<String, C4144b> map = this.f4675R;
            if (map == null || (c4144b = map.get(str)) == null) {
                SharedPreferences sharedPreferencesMo4222f = c4374j.mo4222f();
                JSONArray jSONArray = new JSONArray();
                if (jSONArray instanceof JSONArray) {
                    string = JSONArrayInstrumentation.toString(jSONArray);
                } else {
                    string = jSONArray.toString();
                }
                Map<String, C4144b> mapM3063b = m3063b(new JSONArray(sharedPreferencesMo4222f.getString(f4644J, string)));
                this.f4675R = mapM3063b;
                c4144b = mapM3063b.get(str);
            }
        }
        return c4144b;
    }

    /* JADX INFO: renamed from: b */
    public static final void m3064b(C4143a c4143a) {
        f4649d.m3082a(c4143a);
    }

    /* JADX INFO: renamed from: a */
    public final String m3070a(String eventName) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        synchronized (f4658m) {
            Map<String, String> map = this.f4682Y;
            if (map != null) {
                String lowerCase = eventName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                str = map.get(lowerCase);
                if (str == null) {
                }
            }
            Map<String, String> mapM3068f = m3068f();
            this.f4682Y = mapM3068f;
            String lowerCase2 = eventName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            str = mapM3068f.get(lowerCase2);
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    private final void m3060a(JSONArray jSONArray) {
        String string;
        synchronized (f4658m) {
            try {
                this.f4675R = m3063b(jSONArray);
                SharedPreferences.Editor editorEdit = this.f4673P.mo4222f().edit();
                if (jSONArray instanceof JSONArray) {
                    string = JSONArrayInstrumentation.toString(jSONArray);
                } else {
                    string = jSONArray.toString();
                }
                editorEdit.putString(f4644J, string).apply();
            } catch (Exception e2) {
                C4170g.f4785a.m3223b(f4659n, e2, c.f4684a);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3071b(String eventName) {
        String lowerCase;
        String str;
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        synchronized (f4658m) {
            Map<String, String> mapM3068f = this.f4682Y;
            if (mapM3068f != null) {
                lowerCase = eventName.toLowerCase(Locale.ROOT);
                str = "this as java.lang.String).toLowerCase(Locale.ROOT)";
            } else {
                mapM3068f = m3068f();
                this.f4682Y = mapM3068f;
                lowerCase = eventName.toLowerCase(Locale.ROOT);
                str = "this as java.lang.String).toLowerCase(Locale.ROOT)";
            }
            Intrinsics.checkNotNullExpressionValue(lowerCase, str);
            zContainsKey = mapM3068f.containsKey(lowerCase);
        }
        return zContainsKey;
    }

    /* JADX INFO: renamed from: a */
    private final void m3061a(JSONObject jSONObject) {
        String string;
        synchronized (f4658m) {
            try {
                SharedPreferences.Editor editorEdit = this.f4673P.mo4222f().edit();
                Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
                Boolean boolValueOf = Boolean.valueOf(jSONObject.optBoolean(f4638D, true));
                editorEdit.putBoolean(f4638D, boolValueOf.booleanValue());
                this.f4676S = boolValueOf;
                Boolean boolValueOf2 = Boolean.valueOf(jSONObject.optBoolean(f4639E, false));
                editorEdit.putBoolean(f4639E, boolValueOf2.booleanValue());
                this.f4677T = boolValueOf2;
                Boolean boolValueOf3 = Boolean.valueOf(jSONObject.optBoolean(f4640F, false));
                editorEdit.putBoolean(f4640F, boolValueOf3.booleanValue());
                this.f4678U = boolValueOf3;
                Boolean boolValueOf4 = Boolean.valueOf(jSONObject.optBoolean(f4641G, false));
                editorEdit.putBoolean(f4641G, boolValueOf4.booleanValue());
                this.f4679V = boolValueOf4;
                Boolean boolValueOf5 = Boolean.valueOf(jSONObject.optBoolean(f4642H, false));
                editorEdit.putBoolean(f4642H, boolValueOf5.booleanValue());
                this.f4681X = boolValueOf5;
                Boolean boolValueOf6 = Boolean.valueOf(jSONObject.optBoolean(f4643I, false));
                editorEdit.putBoolean(f4643I, boolValueOf6.booleanValue());
                this.f4680W = boolValueOf6;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f4637C);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                } else {
                    Intrinsics.checkNotNull(jSONArrayOptJSONArray);
                }
                this.f4682Y = PushExtensionsKt.toMap(jSONArrayOptJSONArray);
                if (jSONArrayOptJSONArray instanceof JSONArray) {
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    string = JSONArrayInstrumentation.toString(jSONArrayOptJSONArray);
                } else {
                    string = jSONArrayOptJSONArray.toString();
                }
                editorEdit.putString(f4637C, string);
                editorEdit.apply();
            } catch (Exception e2) {
                C4170g.f4785a.m3223b(f4659n, e2, d.f4685a);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a statusBuilder) {
        Intrinsics.checkNotNullParameter(statusBuilder, "statusBuilder");
        this.f4672O.m3445a(f4657l, this);
    }

    /* JADX INFO: renamed from: a */
    private final void m3059a(String str, String str2) {
        try {
            if (m3075h()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f4671z, str);
                jSONObject.put(f4635A, str2);
                this.f4674Q.mo2947a(jSONObject);
            }
        } catch (Exception e2) {
            C4170g.f4785a.m3223b(f4659n, e2, new j(str));
        }
    }
}
