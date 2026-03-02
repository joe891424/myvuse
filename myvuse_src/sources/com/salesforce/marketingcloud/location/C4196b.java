package com.salesforce.marketingcloud.location;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.location.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4196b {

    /* JADX INFO: renamed from: f */
    public static final a f4970f = new a(null);

    /* JADX INFO: renamed from: g */
    public static final int f4971g = 1;

    /* JADX INFO: renamed from: h */
    public static final int f4972h = 2;

    /* JADX INFO: renamed from: i */
    public static final int f4973i = 4;

    /* JADX INFO: renamed from: a */
    private final String f4974a;

    /* JADX INFO: renamed from: b */
    private final float f4975b;

    /* JADX INFO: renamed from: c */
    private final double f4976c;

    /* JADX INFO: renamed from: d */
    private final double f4977d;

    /* JADX INFO: renamed from: e */
    private final int f4978e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.b$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.b$b */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface b {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.location.b$c */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface c {
    }

    public C4196b(String id, float f, double d, double d2, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f4974a = id;
        this.f4975b = f;
        this.f4976c = d;
        this.f4977d = d2;
        this.f4978e = i;
    }

    /* JADX INFO: renamed from: a */
    public final String m3465a() {
        return this.f4974a;
    }

    /* JADX INFO: renamed from: b */
    public final float m3466b() {
        return this.f4975b;
    }

    /* JADX INFO: renamed from: c */
    public final double m3467c() {
        return this.f4976c;
    }

    /* JADX INFO: renamed from: d */
    public final double m3468d() {
        return this.f4977d;
    }

    /* JADX INFO: renamed from: e */
    public final int m3469e() {
        return this.f4978e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4196b)) {
            return false;
        }
        C4196b c4196b = (C4196b) obj;
        return Intrinsics.areEqual(this.f4974a, c4196b.f4974a) && Float.compare(this.f4975b, c4196b.f4975b) == 0 && Double.compare(this.f4976c, c4196b.f4976c) == 0 && Double.compare(this.f4977d, c4196b.f4977d) == 0 && this.f4978e == c4196b.f4978e;
    }

    /* JADX INFO: renamed from: f */
    public final String m3470f() {
        return this.f4974a;
    }

    /* JADX INFO: renamed from: g */
    public final double m3471g() {
        return this.f4976c;
    }

    /* JADX INFO: renamed from: h */
    public final double m3472h() {
        return this.f4977d;
    }

    public int hashCode() {
        return (((((((this.f4974a.hashCode() * 31) + Float.hashCode(this.f4975b)) * 31) + Double.hashCode(this.f4976c)) * 31) + Double.hashCode(this.f4977d)) * 31) + Integer.hashCode(this.f4978e);
    }

    /* JADX INFO: renamed from: i */
    public final float m3473i() {
        return this.f4975b;
    }

    /* JADX INFO: renamed from: j */
    public final int m3474j() {
        return this.f4978e;
    }

    public String toString() {
        return "GeofenceRegion(id=" + this.f4974a + ", radius=" + this.f4975b + ", latitude=" + this.f4976c + ", longitude=" + this.f4977d + ", transition=" + this.f4978e + ")";
    }

    /* JADX INFO: renamed from: a */
    public final C4196b m3464a(String id, float f, double d, double d2, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new C4196b(id, f, d, d2, i);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4196b m3463a(C4196b c4196b, String str, float f, double d, double d2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c4196b.f4974a;
        }
        if ((i2 & 2) != 0) {
            f = c4196b.f4975b;
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            d = c4196b.f4976c;
        }
        double d3 = d;
        if ((i2 & 8) != 0) {
            d2 = c4196b.f4977d;
        }
        double d4 = d2;
        if ((i2 & 16) != 0) {
            i = c4196b.f4978e;
        }
        return c4196b.m3464a(str, f2, d3, d4, i);
    }
}
