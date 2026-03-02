package com.salesforce.marketingcloud.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.g */
/* JADX INFO: loaded from: classes6.dex */
public final class C4156g {

    /* JADX INFO: renamed from: a */
    private final int f4743a;

    /* JADX INFO: renamed from: b */
    private final String f4744b;

    /* JADX INFO: renamed from: c */
    private final a f4745c;

    /* JADX INFO: renamed from: d */
    private final b f4746d;

    /* JADX INFO: renamed from: e */
    private final String f4747e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.g$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final a f4748a = new a("EQ", 0);

        /* JADX INFO: renamed from: b */
        public static final a f4749b = new a("NEQ", 1);

        /* JADX INFO: renamed from: c */
        public static final a f4750c = new a("LT", 2);

        /* JADX INFO: renamed from: d */
        public static final a f4751d = new a("GT", 3);

        /* JADX INFO: renamed from: e */
        public static final a f4752e = new a("LTEQ", 4);

        /* JADX INFO: renamed from: f */
        public static final a f4753f = new a("GTEQ", 5);

        /* JADX INFO: renamed from: g */
        public static final a f4754g = new a("REGEX", 6);

        /* JADX INFO: renamed from: h */
        private static final /* synthetic */ a[] f4755h;

        /* JADX INFO: renamed from: i */
        private static final /* synthetic */ EnumEntries f4756i;

        static {
            a[] aVarArrM3166a = m3166a();
            f4755h = aVarArrM3166a;
            f4756i = EnumEntriesKt.enumEntries(aVarArrM3166a);
        }

        private a(String str, int i) {
        }

        /* JADX INFO: renamed from: a */
        private static final /* synthetic */ a[] m3166a() {
            return new a[]{f4748a, f4749b, f4750c, f4751d, f4752e, f4753f, f4754g};
        }

        /* JADX INFO: renamed from: b */
        public static EnumEntries<a> m3167b() {
            return f4756i;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f4755h.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.g$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final b f4757a = new b("INT", 0);

        /* JADX INFO: renamed from: b */
        public static final b f4758b = new b("DOUBLE", 1);

        /* JADX INFO: renamed from: c */
        public static final b f4759c = new b("BOOL", 2);

        /* JADX INFO: renamed from: d */
        public static final b f4760d = new b("STRING", 3);

        /* JADX INFO: renamed from: e */
        private static final /* synthetic */ b[] f4761e;

        /* JADX INFO: renamed from: f */
        private static final /* synthetic */ EnumEntries f4762f;

        static {
            b[] bVarArrM3168a = m3168a();
            f4761e = bVarArrM3168a;
            f4762f = EnumEntriesKt.enumEntries(bVarArrM3168a);
        }

        private b(String str, int i) {
        }

        /* JADX INFO: renamed from: a */
        private static final /* synthetic */ b[] m3168a() {
            return new b[]{f4757a, f4758b, f4759c, f4760d};
        }

        /* JADX INFO: renamed from: b */
        public static EnumEntries<b> m3169b() {
            return f4762f;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f4761e.clone();
        }
    }

    public C4156g(int i, String key, a operator, b valueType, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f4743a = i;
        this.f4744b = key;
        this.f4745c = operator;
        this.f4746d = valueType;
        this.f4747e = value;
    }

    /* JADX INFO: renamed from: a */
    public final int m3154a() {
        return this.f4743a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3156b() {
        return this.f4744b;
    }

    /* JADX INFO: renamed from: c */
    public final a m3157c() {
        return this.f4745c;
    }

    /* JADX INFO: renamed from: d */
    public final b m3158d() {
        return this.f4746d;
    }

    /* JADX INFO: renamed from: e */
    public final String m3159e() {
        return this.f4747e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4156g)) {
            return false;
        }
        C4156g c4156g = (C4156g) obj;
        return this.f4743a == c4156g.f4743a && Intrinsics.areEqual(this.f4744b, c4156g.f4744b) && this.f4745c == c4156g.f4745c && this.f4746d == c4156g.f4746d && Intrinsics.areEqual(this.f4747e, c4156g.f4747e);
    }

    /* JADX INFO: renamed from: f */
    public final int m3160f() {
        return this.f4743a;
    }

    /* JADX INFO: renamed from: g */
    public final String m3161g() {
        return this.f4744b;
    }

    /* JADX INFO: renamed from: h */
    public final a m3162h() {
        return this.f4745c;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f4743a) * 31) + this.f4744b.hashCode()) * 31) + this.f4745c.hashCode()) * 31) + this.f4746d.hashCode()) * 31) + this.f4747e.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final String m3163i() {
        return this.f4747e;
    }

    /* JADX INFO: renamed from: j */
    public final b m3164j() {
        return this.f4746d;
    }

    /* JADX INFO: renamed from: k */
    public final JSONObject m3165k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FirebaseAnalytics.Param.INDEX, this.f4743a);
        jSONObject.put("key", this.f4744b);
        jSONObject.put("operator", this.f4745c.name());
        jSONObject.put("valueType", this.f4746d.name());
        jSONObject.put("value", this.f4747e);
        return jSONObject;
    }

    public String toString() {
        return "Rule(index=" + this.f4743a + ", key=" + this.f4744b + ", operator=" + this.f4745c + ", valueType=" + this.f4746d + ", value=" + this.f4747e + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C4156g(JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        int iOptInt = json.optInt(FirebaseAnalytics.Param.INDEX, 0);
        String string = json.getString("key");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = json.getString("operator");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        a aVarValueOf = a.valueOf(string2);
        String string3 = json.getString("valueType");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        b bVarValueOf = b.valueOf(string3);
        String string4 = json.getString("value");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this(iOptInt, string, aVarValueOf, bVarValueOf, string4);
    }

    /* JADX INFO: renamed from: a */
    public final C4156g m3155a(int i, String key, a operator, b valueType, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(value, "value");
        return new C4156g(i, key, operator, valueType, value);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4156g m3153a(C4156g c4156g, int i, String str, a aVar, b bVar, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c4156g.f4743a;
        }
        if ((i2 & 2) != 0) {
            str = c4156g.f4744b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            aVar = c4156g.f4745c;
        }
        a aVar2 = aVar;
        if ((i2 & 8) != 0) {
            bVar = c4156g.f4746d;
        }
        b bVar2 = bVar;
        if ((i2 & 16) != 0) {
            str2 = c4156g.f4747e;
        }
        return c4156g.m3155a(i, str3, aVar2, bVar2, str2);
    }
}
