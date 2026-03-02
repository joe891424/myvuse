package com.salesforce.marketingcloud.analytics;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.util.C4391j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4103b {

    /* JADX INFO: renamed from: a */
    private static final String f4356a = "~!AnalyticItem";

    /* JADX INFO: renamed from: b */
    public static final int f4357b = 2;

    /* JADX INFO: renamed from: c */
    public static final int f4358c = 3;

    /* JADX INFO: renamed from: d */
    public static final int f4359d = 4;

    /* JADX INFO: renamed from: e */
    public static final int f4360e = 5;

    /* JADX INFO: renamed from: f */
    public static final int f4361f = 5;

    /* JADX INFO: renamed from: g */
    public static final int f4362g = 6;

    /* JADX INFO: renamed from: h */
    public static final int f4363h = 7;

    /* JADX INFO: renamed from: i */
    public static final int f4364i = 10;

    /* JADX INFO: renamed from: j */
    public static final int f4365j = 11;

    /* JADX INFO: renamed from: k */
    public static final int f4366k = 12;

    /* JADX INFO: renamed from: l */
    public static final int f4367l = 13;

    /* JADX INFO: renamed from: m */
    public static final int f4368m = 14;

    /* JADX INFO: renamed from: n */
    public static final int f4369n = 15;

    /* JADX INFO: renamed from: o */
    public static final int f4370o = 16;

    /* JADX INFO: renamed from: p */
    public static final int f4371p = 17;

    /* JADX INFO: renamed from: q */
    public static final int f4372q = 88888;

    /* JADX INFO: renamed from: r */
    public static final int f4373r = 888;

    /* JADX INFO: renamed from: s */
    public static final int f4374s = 8888;

    /* JADX INFO: renamed from: t */
    public static final List<Integer> f4375t = Collections.unmodifiableList(Arrays.asList(3, 14));

    /* JADX INFO: renamed from: u */
    public static final int f4376u = 0;

    /* JADX INFO: renamed from: v */
    public static final int f4377v = 1;

    /* JADX INFO: renamed from: A */
    private String f4378A;

    /* JADX INFO: renamed from: B */
    private int f4379B;

    /* JADX INFO: renamed from: C */
    private int f4380C;

    /* JADX INFO: renamed from: D */
    private boolean f4381D;

    /* JADX INFO: renamed from: E */
    private String f4382E;

    /* JADX INFO: renamed from: F */
    private String f4383F;

    /* JADX INFO: renamed from: G */
    private final String f4384G;

    /* JADX INFO: renamed from: w */
    private final Date f4385w;

    /* JADX INFO: renamed from: x */
    private final int f4386x;

    /* JADX INFO: renamed from: y */
    private final int f4387y;

    /* JADX INFO: renamed from: z */
    private final List<String> f4388z;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.b$a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.b$b */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private C4103b(Date date, int i, int i2, List<String> list, String str, boolean z, String str2) {
        ArrayList arrayList = new ArrayList();
        this.f4388z = arrayList;
        this.f4385w = (Date) C4391j.m4326a(date, "The Date is null.");
        C4391j.m4328a(i == 0 || i == 1, "The Product Type must be one of AnalyticProductType");
        this.f4386x = i;
        C4391j.m4328a(i2 > 0, "AnalyticType must be a valid int > 0.");
        this.f4387y = i2;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        this.f4384G = str;
        this.f4383F = m2887a(str2);
        this.f4381D = z;
    }

    /* JADX INFO: renamed from: a */
    public int m2888a() {
        return this.f4387y;
    }

    /* JADX INFO: renamed from: b */
    public Date m2891b() {
        return this.f4385w;
    }

    /* JADX INFO: renamed from: c */
    public String m2894c() {
        return this.f4383F;
    }

    /* JADX INFO: renamed from: d */
    public int m2896d() {
        return this.f4379B;
    }

    /* JADX INFO: renamed from: e */
    public String m2898e() {
        return this.f4382E;
    }

    /* JADX INFO: renamed from: f */
    public String m2899f() {
        return this.f4378A;
    }

    /* JADX INFO: renamed from: g */
    public int m2900g() {
        return this.f4380C;
    }

    /* JADX INFO: renamed from: h */
    public boolean m2901h() {
        return this.f4381D;
    }

    /* JADX INFO: renamed from: i */
    public List<String> m2902i() {
        List<String> list;
        synchronized (this.f4388z) {
            list = this.f4388z;
        }
        return list;
    }

    /* JADX INFO: renamed from: j */
    public int m2903j() {
        return this.f4386x;
    }

    /* JADX INFO: renamed from: k */
    public String m2904k() {
        return this.f4384G;
    }

    /* JADX INFO: renamed from: a */
    private String m2887a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = this.f4384G;
            if (str2 != null) {
                jSONObject.put("requestId", str2);
            }
        } catch (JSONException e) {
            C4170g.m3217e(f4356a, e, "unable to build et json payload", new Object[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("propertyBag", new JSONObject(str));
            return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        }
        if (!(jSONObject instanceof JSONObject)) {
            return jSONObject.toString();
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    /* JADX INFO: renamed from: b */
    public void m2893b(String str) {
        this.f4383F = str;
    }

    /* JADX INFO: renamed from: c */
    public void m2895c(String str) {
        this.f4382E = str;
    }

    /* JADX INFO: renamed from: d */
    public void m2897d(String str) {
        this.f4378A = str;
    }

    /* JADX INFO: renamed from: a */
    public static C4103b m2883a(Date date, int i, int i2) {
        return m2885a(date, i, i2, Collections.emptyList(), null, false);
    }

    /* JADX INFO: renamed from: b */
    public void m2892b(int i) {
        this.f4380C = i;
    }

    /* JADX INFO: renamed from: a */
    public static C4103b m2884a(Date date, int i, int i2, NotificationMessage notificationMessage, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(notificationMessage.m3845id());
        Region region = notificationMessage.region();
        if (region != null) {
            arrayList.add(region.m3630id());
        }
        return new C4103b(date, i, i2, arrayList, notificationMessage.requestId(), z, notificationMessage.propertyBag());
    }

    /* JADX INFO: renamed from: a */
    public static C4103b m2885a(Date date, int i, int i2, List<String> list, String str, boolean z) {
        return new C4103b(date, i, i2, list, str, z, null);
    }

    /* JADX INFO: renamed from: a */
    public static C4103b m2886a(Date date, int i, int i2, List<String> list, boolean z) {
        return m2885a(date, i, i2, list, null, z);
    }

    /* JADX INFO: renamed from: a */
    public void m2889a(int i) {
        this.f4379B = i;
    }

    /* JADX INFO: renamed from: a */
    public void m2890a(boolean z) {
        this.f4381D = z;
    }
}
