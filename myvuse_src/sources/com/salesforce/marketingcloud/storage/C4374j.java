package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.exceptions.C4368a;
import com.salesforce.marketingcloud.storage.p047db.C4342a;
import com.salesforce.marketingcloud.storage.p047db.C4346e;
import com.salesforce.marketingcloud.storage.p047db.C4347f;
import com.salesforce.marketingcloud.storage.p047db.C4348g;
import com.salesforce.marketingcloud.storage.p047db.C4349h;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import com.salesforce.marketingcloud.storage.p047db.C4351j;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.storage.p047db.C4353l;
import com.salesforce.marketingcloud.storage.p047db.C4354m;
import com.salesforce.marketingcloud.util.C4388g;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.j */
/* JADX INFO: loaded from: classes6.dex */
public class C4374j extends AbstractC4339b {

    /* JADX INFO: renamed from: B */
    private static final String f5722B = "mcsdk_cache_%s";

    /* JADX INFO: renamed from: C */
    private static final String f5723C = "ETStorage.version";

    /* JADX INFO: renamed from: D */
    private static final int f5724D = 1;

    /* JADX INFO: renamed from: A */
    private InterfaceC4341d f5725A;

    /* JADX INFO: renamed from: o */
    private final InterfaceC4340c f5726o;

    /* JADX INFO: renamed from: p */
    private final SharedPreferences f5727p;

    /* JADX INFO: renamed from: q */
    private final C4353l f5728q;

    /* JADX INFO: renamed from: r */
    private final C4370f f5729r;

    /* JADX INFO: renamed from: s */
    private C4342a f5730s;

    /* JADX INFO: renamed from: t */
    private C4350i f5731t;

    /* JADX INFO: renamed from: u */
    private C4351j f5732u;

    /* JADX INFO: renamed from: v */
    private C4352k f5733v;

    /* JADX INFO: renamed from: w */
    private C4349h f5734w;

    /* JADX INFO: renamed from: x */
    private C4348g f5735x;

    /* JADX INFO: renamed from: y */
    private C4347f f5736y;

    /* JADX INFO: renamed from: z */
    private C4354m f5737z;

    public C4374j(Context context, InterfaceC4384c interfaceC4384c, String str, String str2, C4189l c4189l) {
        super(context, interfaceC4384c, str, str2);
        C4353l c4353l = new C4353l(context, interfaceC4384c, this.f5556h);
        this.f5728q = c4353l;
        c4353l.getWritableDatabase();
        InterfaceC4340c.a aVar = new InterfaceC4340c.a(context, interfaceC4384c, this.f5556h);
        this.f5726o = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AbstractC4339b.m3997a(this.f5556h), 0);
        this.f5727p = sharedPreferences;
        this.f5729r = new C4370f(context, sharedPreferences, str, c4189l);
        if (c4353l.m4158a()) {
            aVar.mo3928a();
            sharedPreferences.edit().clear().apply();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m4231d(InterfaceC4384c interfaceC4384c) throws Exception {
        this.f5727p.edit().putString("create_date", interfaceC4384c.mo4259a(String.valueOf(System.currentTimeMillis()))).apply();
    }

    /* JADX INFO: renamed from: l */
    private void m4232l() throws Exception {
        File fileM4235k = m4235k();
        if (fileM4235k.exists() && fileM4235k.isDirectory()) {
            C4388g.m4313a(fileM4235k);
        }
        m4233w();
        this.f5728q.m4159b();
    }

    /* JADX INFO: renamed from: w */
    private void m4233w() throws Exception {
        mo4220c().mo3928a();
        mo4222f().edit().clear().apply();
        m4231d(this.f5558j);
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: a */
    protected final Context mo4215a() {
        return this.f5557i;
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: a */
    protected void mo4216a(Context context, int i, int i2) {
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: b */
    public InterfaceC4384c mo4218b() {
        return this.f5558j;
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: c */
    public InterfaceC4340c mo4220c() {
        return this.f5726o;
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: e */
    protected SQLiteOpenHelper mo4221e() {
        return this.f5728q;
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4367e
    /* JADX INFO: renamed from: f */
    public SharedPreferences mo4222f() {
        return this.f5727p;
    }

    /* JADX INFO: renamed from: k */
    public File m4235k() {
        return new File(this.f5557i.getCacheDir(), String.format(Locale.ENGLISH, f5722B, this.f5556h));
    }

    /* JADX INFO: renamed from: m */
    public InterfaceC4338a m4236m() {
        if (this.f5730s == null) {
            this.f5730s = new C4342a(this.f5728q.getWritableDatabase());
        }
        return this.f5730s;
    }

    /* JADX INFO: renamed from: n */
    public InterfaceC4341d m4237n() {
        if (this.f5725A == null) {
            this.f5725A = new C4346e(this.f5728q.getWritableDatabase());
        }
        return this.f5725A;
    }

    /* JADX INFO: renamed from: o */
    public C4370f m4238o() {
        return this.f5729r;
    }

    /* JADX INFO: renamed from: p */
    public InterfaceC4371g m4239p() {
        if (this.f5736y == null) {
            this.f5736y = new C4347f(this.f5728q.getWritableDatabase());
        }
        return this.f5736y;
    }

    /* JADX INFO: renamed from: q */
    public InterfaceC4372h m4240q() {
        if (this.f5735x == null) {
            this.f5735x = new C4348g(this.f5728q.getWritableDatabase());
        }
        return this.f5735x;
    }

    /* JADX INFO: renamed from: r */
    public InterfaceC4373i m4241r() {
        if (this.f5734w == null) {
            this.f5734w = new C4349h(this.f5728q.getWritableDatabase());
        }
        return this.f5734w;
    }

    /* JADX INFO: renamed from: s */
    public InterfaceC4375k m4242s() {
        if (this.f5731t == null) {
            this.f5731t = new C4350i(this.f5728q.getWritableDatabase());
        }
        return this.f5731t;
    }

    /* JADX INFO: renamed from: t */
    public InterfaceC4376l m4243t() {
        if (this.f5732u == null) {
            this.f5732u = new C4351j(this.f5728q.getWritableDatabase());
        }
        return this.f5732u;
    }

    /* JADX INFO: renamed from: u */
    public InterfaceC4377m m4244u() {
        if (this.f5733v == null) {
            this.f5733v = new C4352k(this.f5728q.getWritableDatabase());
        }
        return this.f5733v;
    }

    /* JADX INFO: renamed from: v */
    public InterfaceC4378n m4245v() {
        if (this.f5737z == null) {
            this.f5737z = new C4354m(this.f5728q.getWritableDatabase());
        }
        return this.f5737z;
    }

    /* JADX INFO: renamed from: x */
    public final void m4246x() {
        this.f5728q.close();
    }

    /* JADX INFO: renamed from: a */
    public final void m4234a(InitializationStatus.C4081a c4081a) {
        if (!mo4002a(this.f5727p)) {
            boolean zContains = this.f5727p.contains("create_date");
            c4081a.m2804a(zContains);
            if (zContains) {
                try {
                    m4232l();
                } catch (Exception e) {
                    c4081a.m2803a(e);
                    c4081a.m2810f(true);
                    C4170g.m3207b(AbstractC4367e.f5690c, e, "Failed to recover from encryption change.", new Object[0]);
                    return;
                }
            }
        }
        try {
            try {
                this.f5728q.m4160c();
            } catch (Exception e2) {
                c4081a.m2803a(e2);
                c4081a.m2810f(true);
                C4170g.m3207b(AbstractC4367e.f5690c, e2, "Failed to recover from data reset.", new Object[0]);
                return;
            }
        } catch (C4368a unused) {
            m4233w();
        } catch (IllegalStateException e3) {
            c4081a.m2803a(e3);
            c4081a.m2810f(true);
            C4170g.m3207b(AbstractC4367e.f5690c, e3, "Could not create the necessary database table(s).", new Object[0]);
            return;
        }
        int i = this.f5727p.getInt(f5723C, -1);
        if (i == 0 || i == 1) {
            return;
        }
        Context context = this.f5557i;
        if (1 < i) {
            mo4216a(context, i, 1);
        } else {
            m4219b(context, i, 1);
        }
        this.f5727p.edit().putInt(f5723C, 1).apply();
    }

    @Override // com.salesforce.marketingcloud.storage.AbstractC4339b
    /* JADX INFO: renamed from: a */
    protected boolean mo4002a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("create_date", null);
        if (string == null) {
            return false;
        }
        try {
            this.f5558j.mo4260b(string);
            return true;
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            C4170g.m3207b(AbstractC4367e.f5690c, e, "Failed to verify existing encryption key", new Object[0]);
            return false;
        }
    }
}
