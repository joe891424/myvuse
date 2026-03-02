package com.salesforce.marketingcloud.storage.p047db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.storage.exceptions.C4368a;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4356a;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4357b;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4358c;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4359d;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4360e;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4361f;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4362g;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4363h;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4364i;
import com.salesforce.marketingcloud.storage.p047db.upgrades.C4365j;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.l */
/* JADX INFO: loaded from: classes6.dex */
public final class C4353l extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: d */
    public static final int f5666d = 11;

    /* JADX INFO: renamed from: e */
    private static final String f5667e = "mcsdk_%s.db";

    /* JADX INFO: renamed from: f */
    private static final String f5668f = C4170g.m3197a("StorageSqliteOpenHelper");

    /* JADX INFO: renamed from: a */
    private final Context f5669a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC4384c f5670b;

    /* JADX INFO: renamed from: c */
    private boolean f5671c;

    public C4353l(Context context, InterfaceC4384c interfaceC4384c, String str) {
        this(context, interfaceC4384c, m4156a(str), 11);
    }

    /* JADX INFO: renamed from: a */
    public static String m4156a(String str) {
        return String.format(Locale.ENGLISH, f5667e, str);
    }

    /* JADX INFO: renamed from: b */
    public void m4159b() throws Exception {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        m4157a(writableDatabase);
        if (writableDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(writableDatabase, "VACUUM");
        } else {
            writableDatabase.execSQL("VACUUM");
        }
        onCreate(writableDatabase);
    }

    /* JADX INFO: renamed from: c */
    public void m4160c() throws IllegalStateException, C4368a {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (!C4352k.m4150c(writableDatabase)) {
            C4170g.m3216e(f5668f, "Database table %s was not initialized properly and will be dropped and recreated.  Some data may be lost.", C4352k.f5644e);
            try {
                m4159b();
                if (!C4352k.m4150c(writableDatabase)) {
                    throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4352k.f5644e));
                }
                throw new C4368a();
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        if (!C4348g.m4091d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4348g.f5600e));
        }
        if (!C4342a.m4023d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4342a.f5572e));
        }
        if (!C4351j.m4136g(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4351j.f5641e));
        }
        if (!C4350i.m4120d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4350i.f5612e));
        }
        if (!C4349h.m4110d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4349h.f5605e));
        }
        if (!C4354m.m4166d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4354m.f5672g));
        }
        if (!C4347f.m4075m(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", C4347f.f5594e));
        }
        if (!C4346e.m4059d(writableDatabase)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", "device_stats"));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4352k.m4148b(sQLiteDatabase);
            C4348g.m4087b(sQLiteDatabase);
            C4342a.m4020b(sQLiteDatabase);
            C4351j.m4133d(sQLiteDatabase);
            C4350i.m4118b(sQLiteDatabase);
            C4349h.m4108b(sQLiteDatabase);
            C4347f.m4071i(sQLiteDatabase);
            C4354m.m4163b(sQLiteDatabase);
            C4346e.m4057b(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C4170g.m3216e(f5668f, "SQLite database being downgraded from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
        this.f5671c = true;
        m4157a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (sQLiteDatabase.isReadOnly()) {
            return;
        }
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "PRAGMA foreign_keys=ON");
        } else {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        if (i < 2) {
            C4357b.m4181b(sQLiteDatabase, this.f5669a, this.f5670b);
        }
        if (i < 3) {
            C4358c.m4191f(sQLiteDatabase);
        }
        if (i < 4) {
            C4359d.m4194c(sQLiteDatabase);
        }
        if (i < 5) {
            C4360e.m4196b(sQLiteDatabase);
        }
        if (i < 6) {
            C4361f.m4198b(sQLiteDatabase);
        }
        if (i < 7) {
            C4362g.m4200b(sQLiteDatabase);
        }
        if (i < 8) {
            C4363h.m4201a(sQLiteDatabase);
        }
        if (i < 9) {
            C4364i.m4203b(sQLiteDatabase);
        }
        if (i < 10) {
            C4365j.m4207b(sQLiteDatabase, this.f5670b);
        }
        if (i < 11) {
            C4356a.m4175b(sQLiteDatabase, this.f5670b);
        }
    }

    C4353l(Context context, InterfaceC4384c interfaceC4384c, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f5669a = context;
        this.f5670b = interfaceC4384c;
    }

    /* JADX INFO: renamed from: a */
    private void m4157a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4352k.m4147a(sQLiteDatabase);
            C4348g.m4086a(sQLiteDatabase);
            C4342a.m4018a(sQLiteDatabase);
            C4351j.m4132c(sQLiteDatabase);
            C4350i.m4116a(sQLiteDatabase);
            C4349h.m4107a(sQLiteDatabase);
            C4347f.m4067e(sQLiteDatabase);
            C4354m.m4162a(sQLiteDatabase);
            C4346e.m4055a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4158a() {
        return this.f5671c;
    }
}
