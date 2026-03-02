package com.salesforce.marketingcloud.analytics.stats;

import com.salesforce.marketingcloud.C4170g;
import java.util.Date;
import org.json.JSONException;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4133b {

    /* JADX INFO: renamed from: f */
    public static final int f4501f = 100;

    /* JADX INFO: renamed from: g */
    public static final int f4502g = 101;

    /* JADX INFO: renamed from: h */
    public static final int f4503h = 102;

    /* JADX INFO: renamed from: i */
    public static final int f4504i = 103;

    /* JADX INFO: renamed from: j */
    public static final int f4505j = 104;

    /* JADX INFO: renamed from: k */
    public static final int f4506k = 105;

    /* JADX INFO: renamed from: l */
    public static final int f4507l = 106;

    /* JADX INFO: renamed from: m */
    public static final int f4508m = 107;

    /* JADX INFO: renamed from: a */
    C4135d f4509a;

    /* JADX INFO: renamed from: b */
    private Integer f4510b;

    /* JADX INFO: renamed from: c */
    private int f4511c;

    /* JADX INFO: renamed from: d */
    private Date f4512d;

    /* JADX INFO: renamed from: e */
    private boolean f4513e;

    private C4133b(Integer num, int i, Date date, C4135d c4135d, boolean z) {
        this.f4510b = num;
        this.f4511c = i;
        this.f4512d = date;
        this.f4509a = c4135d;
        this.f4513e = z;
    }

    /* JADX INFO: renamed from: a */
    public static C4133b m2984a(int i, Date date, C4135d c4135d, boolean z) {
        return new C4133b(null, i, date, c4135d, z);
    }

    /* JADX INFO: renamed from: b */
    public Integer m2988b() {
        return this.f4510b;
    }

    /* JADX INFO: renamed from: c */
    public C4135d m2989c() {
        return this.f4509a;
    }

    /* JADX INFO: renamed from: d */
    public int m2990d() {
        return this.f4511c;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2991e() {
        return this.f4513e;
    }

    /* JADX INFO: renamed from: a */
    public void m2986a(Date date) {
        int time = (int) ((date.getTime() - this.f4512d.getTime()) / 1000.0d);
        if (time <= 0) {
            time = 1;
        }
        try {
            this.f4509a.m3021b(time);
            this.f4513e = true;
        } catch (JSONException e) {
            C4170g.m3207b(C4134c.f4514k, e, "Unable to finalize event [%d]", Integer.valueOf(this.f4511c));
        }
    }

    /* JADX INFO: renamed from: a */
    public static C4133b m2983a(int i, int i2, Date date, C4135d c4135d, boolean z) {
        return new C4133b(Integer.valueOf(i), i2, date, c4135d, z);
    }

    /* JADX INFO: renamed from: a */
    public Date m2985a() {
        return this.f4512d;
    }

    /* JADX INFO: renamed from: a */
    public void m2987a(boolean z) {
        this.f4513e = z;
    }
}
