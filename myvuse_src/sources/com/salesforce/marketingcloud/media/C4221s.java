package com.salesforce.marketingcloud.media;

import android.net.Uri;
import com.salesforce.marketingcloud.media.C4217o;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.s */
/* JADX INFO: loaded from: classes6.dex */
public class C4221s {

    /* JADX INFO: renamed from: m */
    static final char f5106m = '\n';

    /* JADX INFO: renamed from: a */
    public final Uri f5107a;

    /* JADX INFO: renamed from: b */
    public final String f5108b = m3584a();

    /* JADX INFO: renamed from: c */
    public final C4217o.c f5109c;

    /* JADX INFO: renamed from: d */
    public final int f5110d;

    /* JADX INFO: renamed from: e */
    public final int f5111e;

    /* JADX INFO: renamed from: f */
    public final int f5112f;

    /* JADX INFO: renamed from: g */
    public final boolean f5113g;

    /* JADX INFO: renamed from: h */
    public final boolean f5114h;

    /* JADX INFO: renamed from: i */
    public final float f5115i;

    /* JADX INFO: renamed from: j */
    public final float f5116j;

    /* JADX INFO: renamed from: k */
    public final int f5117k;

    /* JADX INFO: renamed from: l */
    public long f5118l;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.s$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        Uri f5119a;

        /* JADX INFO: renamed from: b */
        C4217o.c f5120b;

        /* JADX INFO: renamed from: c */
        int f5121c;

        /* JADX INFO: renamed from: d */
        int f5122d;

        /* JADX INFO: renamed from: e */
        int f5123e;

        /* JADX INFO: renamed from: f */
        boolean f5124f;

        /* JADX INFO: renamed from: g */
        boolean f5125g;

        /* JADX INFO: renamed from: h */
        float f5126h;

        /* JADX INFO: renamed from: i */
        float f5127i;

        /* JADX INFO: renamed from: j */
        int f5128j;

        public a(Uri uri) {
            this.f5119a = uri;
        }

        /* JADX INFO: renamed from: a */
        public C4221s m3593a() {
            if (this.f5120b == null) {
                this.f5120b = C4217o.c.NORMAL;
            }
            return new C4221s(this);
        }

        /* JADX INFO: renamed from: b */
        public a m3594b() {
            this.f5124f = true;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m3595c() {
            this.f5125g = true;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public boolean m3596d() {
            return this.f5120b != null;
        }

        /* JADX INFO: renamed from: a */
        public a m3589a(float f, float f2, int i) {
            this.f5126h = f;
            this.f5127i = f2;
            this.f5128j = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m3590a(int i, int i2) {
            this.f5122d = i;
            this.f5123e = i2;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m3591a(C4217o.c cVar) {
            this.f5120b = cVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m3592a(b bVar, b... bVarArr) {
            if (bVar == null) {
                return this;
            }
            this.f5121c = bVar.f5133a | this.f5121c;
            if (bVarArr == null) {
                return this;
            }
            for (b bVar2 : bVarArr) {
                this.f5121c = bVar2.f5133a | this.f5121c;
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.s$b */
    public enum b {
        NO_MEMORY_CACHE(1),
        NO_MEMORY_STORE(2),
        NO_DISK_STORE(4);


        /* JADX INFO: renamed from: a */
        int f5133a;

        b(int i) {
            this.f5133a = i;
        }

        /* JADX INFO: renamed from: b */
        public static boolean m3599b(int i) {
            return (i & NO_MEMORY_STORE.f5133a) == 0;
        }

        /* JADX INFO: renamed from: c */
        public static boolean m3600c(int i) {
            return (i & NO_DISK_STORE.f5133a) == 0;
        }

        /* JADX INFO: renamed from: a */
        public static boolean m3597a(int i) {
            return (i & NO_MEMORY_CACHE.f5133a) == 0;
        }

        /* JADX INFO: renamed from: b */
        public int m3601b() {
            return this.f5133a;
        }
    }

    C4221s(a aVar) {
        this.f5107a = aVar.f5119a;
        this.f5109c = aVar.f5120b;
        this.f5110d = aVar.f5121c;
        this.f5111e = aVar.f5122d;
        this.f5112f = aVar.f5123e;
        this.f5113g = aVar.f5124f;
        this.f5114h = aVar.f5125g;
        this.f5115i = aVar.f5126h;
        this.f5116j = aVar.f5127i;
        this.f5117k = aVar.f5128j;
    }

    /* JADX INFO: renamed from: a */
    private String m3584a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5107a.toString()).append(f5106m);
        if (m3587d()) {
            sb.append("resize:").append(this.f5111e).append('x').append(this.f5112f).append(f5106m);
        }
        if (this.f5113g) {
            sb.append("centerCrop\n");
        }
        if (this.f5114h) {
            sb.append("centerInside\n");
        }
        if (m3586c()) {
            sb.append("radius:").append(this.f5115i).append(",border:").append(this.f5116j).append(",color:").append(this.f5117k);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    String m3585b() {
        return String.valueOf(this.f5107a.getPath());
    }

    /* JADX INFO: renamed from: c */
    boolean m3586c() {
        return (this.f5115i == 0.0f && this.f5116j == 0.0f) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3587d() {
        return (this.f5111e == 0 && this.f5112f == 0) ? false : true;
    }

    /* JADX INFO: renamed from: e */
    boolean m3588e() {
        return m3587d() || m3586c();
    }
}
