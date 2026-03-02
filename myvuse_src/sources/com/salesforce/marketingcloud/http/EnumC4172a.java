package com.salesforce.marketingcloud.http;

import android.content.SharedPreferences;
import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.util.Constants;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.util.C4393l;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'k' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.salesforce.marketingcloud.http.a */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumC4172a {

    /* JADX INFO: renamed from: h */
    public static final EnumC4172a f4816h = new EnumC4172a("ET_ANALYTICS", 0, "POST", 1, "/device/v1/event/analytic", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "analytics_next_retry_time");

    /* JADX INFO: renamed from: i */
    public static final EnumC4172a f4817i = new EnumC4172a("PI_ANALYTICS", 1, "POST", 2, "{0}", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "piwama_next_retry_time");

    /* JADX INFO: renamed from: j */
    public static final EnumC4172a f4818j;

    /* JADX INFO: renamed from: k */
    public static final EnumC4172a f4819k;

    /* JADX INFO: renamed from: l */
    public static final EnumC4172a f4820l;

    /* JADX INFO: renamed from: m */
    public static final EnumC4172a f4821m;

    /* JADX INFO: renamed from: n */
    public static final EnumC4172a f4822n;

    /* JADX INFO: renamed from: o */
    public static final EnumC4172a f4823o;

    /* JADX INFO: renamed from: p */
    public static final EnumC4172a f4824p;

    /* JADX INFO: renamed from: q */
    public static final EnumC4172a f4825q;

    /* JADX INFO: renamed from: r */
    public static final EnumC4172a f4826r;

    /* JADX INFO: renamed from: s */
    public static final String f4827s = "X-Subscriber-Token";

    /* JADX INFO: renamed from: t */
    private static final String f4828t = "Bearer %s";

    /* JADX INFO: renamed from: u */
    private static final String f4829u;

    /* JADX INFO: renamed from: v */
    private static final long f4830v = 86400000;

    /* JADX INFO: renamed from: w */
    private static final /* synthetic */ EnumC4172a[] f4831w;

    /* JADX INFO: renamed from: a */
    public final int f4832a;

    /* JADX INFO: renamed from: b */
    public final String f4833b;

    /* JADX INFO: renamed from: c */
    public final String f4834c;

    /* JADX INFO: renamed from: d */
    public final String f4835d;

    /* JADX INFO: renamed from: e */
    public final String f4836e;

    /* JADX INFO: renamed from: f */
    public final String f4837f;

    /* JADX INFO: renamed from: g */
    public final long f4838g;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.a$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        static final int f4839a = 1;

        /* JADX INFO: renamed from: b */
        static final int f4840b = 2;

        private a() {
        }
    }

    static {
        EnumC4172a enumC4172a = new EnumC4172a("INBOX_MESSAGE", 2, "GET", 1, "/device/v1/{0}/message/?deviceid={1}&messagetype=8&contenttype=2", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "inbox_next_retry_time");
        f4818j = enumC4172a;
        f4819k = new EnumC4172a("USER_INITIATED_INBOX_MESSAGE", 3, enumC4172a.f4837f, enumC4172a.f4832a, enumC4172a.f4833b, enumC4172a.f4835d, enumC4172a.f4836e, enumC4172a.f4834c, 60000L);
        f4820l = new EnumC4172a("INBOX_STATUS", 4, "PATCH", 1, "/device/v1/{0}/message", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "inbox_status_next_retry_time");
        f4821m = new EnumC4172a("GEOFENCE_MESSAGE", 5, "GET", 1, "/device/v1/location/{0}/fence/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "geofence_next_retry_time");
        f4822n = new EnumC4172a("PROXIMITY_MESSAGES", 6, "GET", 1, "/device/v1/location/{0}/proximity/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "proximity_next_retry_time");
        f4823o = new EnumC4172a("REGISTRATION", 7, "POST", 1, "/device/v1/registration", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "registration_next_retry_time", 60000L);
        f4824p = new EnumC4172a("SYNC", 8, "POST", 1, "/device/v1/{0}/sync/{1}", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "sync_next_retry_time");
        f4825q = new EnumC4172a("DEVICE_STATS", 9, "POST", 1, "/devicestatistics/v1/analytic", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "et_device_stats_retry_after");
        f4826r = new EnumC4172a("EVENTS", 10, "POST", 1, "/devicestatistics/v1/event", Constants.Network.ContentType.JSON, Constants.Network.ContentType.JSON, "et_events_retry_after");
        f4831w = m3243a();
        f4829u = String.format(C4393l.f5817a, "MarketingCloudSdk/%s (Android %s; %%s; %s/%s) %%s/%%s", MarketingCloudSdk.getSdkVersionName(), Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL);
    }

    private EnumC4172a(String str, int i, String str2, int i2, String str3, String str4, String str5, String str6) {
        this(str, i, str2, i2, str3, str4, str5, str6, 0L);
    }

    /* JADX INFO: renamed from: a */
    private static /* synthetic */ EnumC4172a[] m3243a() {
        return new EnumC4172a[]{f4816h, f4817i, f4818j, f4819k, f4820l, f4821m, f4822n, f4823o, f4824p, f4825q, f4826r};
    }

    /* JADX INFO: renamed from: b */
    private String m3246b(MarketingCloudConfig marketingCloudConfig) {
        return String.format(C4393l.f5817a, f4829u, Locale.getDefault(), marketingCloudConfig.getAppPackageName(), marketingCloudConfig.getAppVersionName());
    }

    public static EnumC4172a valueOf(String str) {
        return (EnumC4172a) Enum.valueOf(EnumC4172a.class, str);
    }

    public static EnumC4172a[] values() {
        return (EnumC4172a[]) f4831w.clone();
    }

    /* JADX INFO: renamed from: c */
    long m3257c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(this.f4834c, 0L);
    }

    private EnumC4172a(String str, int i, String str2, int i2, String str3, String str4, String str5, String str6, long j) {
        this.f4837f = str2;
        this.f4832a = i2;
        this.f4833b = str3;
        this.f4835d = str4;
        this.f4836e = str5;
        this.f4834c = str6;
        this.f4838g = j < 0 ? 0L : j;
    }

    /* JADX INFO: renamed from: b */
    public static Object[] m3247b(String str, String str2) {
        return new Object[]{str, str2};
    }

    /* JADX INFO: renamed from: c */
    public static Object[] m3248c(String str, String str2) {
        return new Object[]{str, str2};
    }

    /* JADX INFO: renamed from: a */
    long m3249a(SharedPreferences sharedPreferences) {
        if (this.f4838g > 0) {
            return sharedPreferences.getLong(this.f4834c + "_device", 0L);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    private String m3240a(String str, String str2) throws MalformedURLException {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return new URL(String.format(C4393l.f5817a, "%s%s", str, str2)).toString();
    }

    /* JADX INFO: renamed from: b */
    void m3256b(SharedPreferences sharedPreferences) {
        if (this.f4838g > 0) {
            sharedPreferences.edit().putLong(this.f4834c + "_device", this.f4838g + System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    private String m3239a(MarketingCloudConfig marketingCloudConfig) {
        return this.f4832a == 1 ? marketingCloudConfig.marketingCloudServerUrl() : marketingCloudConfig.predictiveIntelligenceServerUrl();
    }

    /* JADX INFO: renamed from: a */
    public static Object[] m3244a(String str) {
        return new Object[]{str};
    }

    /* JADX INFO: renamed from: a */
    void m3255a(SharedPreferences sharedPreferences, C4175d c4175d) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (c4175d.m3307g() && this.f4838g > 0) {
            editorEdit.putLong(this.f4834c + "_device", c4175d.m3303c() + this.f4838g);
        }
        List<String> list = c4175d.m3304d().get(HttpHeaders.RETRY_AFTER);
        if (list != null && !list.isEmpty()) {
            try {
                long j = Long.parseLong(list.get(0)) * 1000;
                String str = this.f4834c;
                long jM3303c = c4175d.m3303c();
                if (j > 86400000) {
                    j = 86400000;
                }
                editorEdit.putLong(str, jM3303c + j);
            } catch (Exception e) {
                C4170g.m3203a("MCRequest", e, "Unable to parse Retry-After value.", new Object[0]);
            }
        }
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: a */
    public static Object[] m3245a(String str, String str2, LatLon latLon) {
        return new Object[]{str, Double.valueOf(latLon.latitude()), Double.valueOf(latLon.longitude()), str2};
    }

    /* JADX INFO: renamed from: a */
    public static void m3241a(Map<String, List<String>> map, InterfaceC4340c interfaceC4340c) {
        List<String> list;
        String str;
        if (map == null || map.isEmpty() || (list = map.get(f4827s)) == null || list.isEmpty() || (str = list.get(0)) == null || str.isEmpty()) {
            return;
        }
        interfaceC4340c.mo3930a(InterfaceC4340c.f5568j, str);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3242a(C4374j c4374j) {
        return c4374j.mo4220c().mo3931b(InterfaceC4340c.f5568j, null) != null;
    }

    /* JADX INFO: renamed from: a */
    public C4173b m3250a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, String str) {
        return m3238a(marketingCloudConfig, interfaceC4340c, m3239a(marketingCloudConfig), this.f4833b, str, null);
    }

    /* JADX INFO: renamed from: a */
    public C4173b m3251a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, String str, String str2) {
        String strM3239a = m3239a(marketingCloudConfig);
        if (str2 == null) {
            str2 = this.f4833b;
        }
        return m3238a(marketingCloudConfig, interfaceC4340c, strM3239a, str2, str, null);
    }

    /* JADX INFO: renamed from: a */
    private C4173b m3238a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, String str, String str2, String str3, Map<String, String> map) {
        try {
            String strM3240a = m3240a(str, str2);
            C4170g.m3213d("MCRequest", "Executing %s request ...", strM3240a);
            C4173b.a aVarM3290d = C4173b.m3262b().m3288b(this.f4837f).m3283a(this).m3284a(this.f4835d).m3290d(strM3240a);
            if (str3 != null) {
                aVarM3290d.m3289c(str3);
            }
            aVarM3290d.m3285a("User-Agent", m3246b(marketingCloudConfig));
            aVarM3290d.m3285a(HttpHeaders.AUTHORIZATION, String.format(C4393l.f5817a, f4828t, marketingCloudConfig.accessToken()));
            aVarM3290d.m3285a(HttpHeaders.ACCEPT, this.f4836e);
            aVarM3290d.m3285a("X-SDK-Version", MarketingCloudSdk.getSdkVersionName());
            String strMo3931b = interfaceC4340c.mo3931b(InterfaceC4340c.f5568j, null);
            if (strMo3931b != null) {
                aVarM3290d.m3285a(f4827s, strMo3931b);
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    aVarM3290d.m3285a(entry.getKey(), entry.getValue());
                }
            }
            return aVarM3290d.m3286a();
        } catch (Exception e) {
            C4170g.m3207b("MCRequest", e, "Failed to execute request.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public C4173b m3252a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, Object[] objArr) {
        return m3238a(marketingCloudConfig, interfaceC4340c, m3239a(marketingCloudConfig), new MessageFormat(this.f4833b, C4393l.f5817a).format(objArr), null, null);
    }

    /* JADX INFO: renamed from: a */
    public C4173b m3253a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, Object[] objArr, String str) {
        return m3238a(marketingCloudConfig, interfaceC4340c, m3239a(marketingCloudConfig), new MessageFormat(this.f4833b, C4393l.f5817a).format(objArr), str, null);
    }

    /* JADX INFO: renamed from: a */
    public C4173b m3254a(MarketingCloudConfig marketingCloudConfig, InterfaceC4340c interfaceC4340c, Object[] objArr, String str, Map<String, String> map) {
        return m3238a(marketingCloudConfig, interfaceC4340c, m3239a(marketingCloudConfig), new MessageFormat(this.f4833b, C4393l.f5817a).format(objArr), str, map);
    }
}
