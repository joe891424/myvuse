package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.InterfaceC4338a;
import com.salesforce.marketingcloud.util.C4393l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4342a extends AbstractC4343b implements InterfaceC4338a {

    /* JADX INFO: renamed from: e */
    public static final String f5572e = "analytic_item";

    /* JADX INFO: renamed from: f */
    static final int f5573f = 1000;

    /* JADX INFO: renamed from: h */
    private static final String f5575h = "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL);";

    /* JADX INFO: renamed from: g */
    private static final String[] f5574g = {"id", a.f5579c, a.f5585i, a.f5580d, "value", a.f5582f, a.f5581e, a.f5584h, a.f5583g, "predictive_intelligence_identifier"};

    /* JADX INFO: renamed from: i */
    private static final String f5576i = C4170g.m3197a("AnalyticItemDbStorage");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.a$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final String f5577a = "id";

        /* JADX INFO: renamed from: b */
        public static final String f5578b = "value";

        /* JADX INFO: renamed from: c */
        public static final String f5579c = "event_date";

        /* JADX INFO: renamed from: d */
        public static final String f5580d = "analytic_type";

        /* JADX INFO: renamed from: e */
        public static final String f5581e = "object_ids";

        /* JADX INFO: renamed from: f */
        public static final String f5582f = "ready_to_send";

        /* JADX INFO: renamed from: g */
        public static final String f5583g = "enc_json_et_payload";

        /* JADX INFO: renamed from: h */
        public static final String f5584h = "enc_json_pi_payload";

        /* JADX INFO: renamed from: i */
        public static final String f5585i = "analytic_product_type";

        /* JADX INFO: renamed from: j */
        public static final String f5586j = "predictive_intelligence_identifier";
    }

    public C4342a(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: a */
    public void mo3984a(C4103b c4103b, InterfaceC4384c interfaceC4384c) throws Exception {
        int i = c4103b.m2903j() == 0 ? 0 : 1;
        int iM4024h = m4024h(i);
        if (iM4024h + 1 > 1000) {
            m4017a(iM4024h, 1000, i);
        }
        c4103b.m2889a((int) m4031a(m4021c(c4103b, interfaceC4384c)));
    }

    /* JADX INFO: renamed from: b */
    List<C4103b> m4025b(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        List<C4103b> listEmptyList = Collections.emptyList();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    C4103b c4103bM4015a = m4015a(cursor, interfaceC4384c);
                    if (c4103bM4015a != null) {
                        arrayList.add(c4103bM4015a);
                    } else {
                        int i = cursor.getInt(cursor.getColumnIndex("id"));
                        if (i >= 0) {
                            m4030a(m4016a("%s = ?", "id"), new String[]{String.valueOf(i)});
                        }
                    }
                } while (cursor.moveToNext());
                listEmptyList = arrayList;
            }
            cursor.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: c */
    public List<C4103b> mo3988c(InterfaceC4384c interfaceC4384c) {
        return m4025b(m4035a(f5574g, m4016a("%s=? AND %s=?", a.f5585i, a.f5582f), new String[]{String.valueOf(0), "1"}, null, null, m4016a("%s ASC", "id")), interfaceC4384c);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: d */
    public int mo3990d() {
        return m4024h(0);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: e */
    public int mo3991e() {
        return m4024h(1);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: g */
    public int mo3992g(int i) {
        return m4030a(m4016a("%s = ?", a.f5585i), new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: h */
    public List<C4103b> mo3994h(InterfaceC4384c interfaceC4384c) {
        return m4025b(m4034a(f5574g, m4016a("(%1$s=? OR %1$s=?) AND %2$s=?", a.f5580d, a.f5582f), new String[]{String.valueOf(13), String.valueOf(11), String.valueOf(0)}), interfaceC4384c);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: i */
    public List<C4103b> mo3995i(InterfaceC4384c interfaceC4384c) {
        return m4019b(1, interfaceC4384c);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: o */
    public List<C4103b> mo3996o(InterfaceC4384c interfaceC4384c) {
        return m4025b(m4035a(f5574g, m4016a("%s=? AND %s=?", a.f5585i, a.f5582f), new String[]{String.valueOf(1), String.valueOf(1)}, null, null, m4016a("%s ASC", a.f5579c)), interfaceC4384c);
    }

    /* JADX INFO: renamed from: a */
    private static C4103b m4015a(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        String strOptString;
        String str;
        C4103b c4103bM2883a;
        try {
            int i = cursor.getInt(cursor.getColumnIndex(a.f5580d));
            int i2 = cursor.getInt(cursor.getColumnIndex(a.f5585i)) == 0 ? 0 : 1;
            Date dateM4353f = C4393l.m4353f(cursor.getString(cursor.getColumnIndex(a.f5579c)));
            boolean z = cursor.getInt(cursor.getColumnIndex(a.f5582f)) == 1;
            List listEmptyList = Collections.emptyList();
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex(a.f5581e)));
            if (jSONArray.length() > 0) {
                listEmptyList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    listEmptyList.add(jSONArray.getString(i3));
                }
            }
            List list = listEmptyList;
            if (interfaceC4384c != null) {
                String strMo4260b = interfaceC4384c.mo4260b(cursor.getString(cursor.getColumnIndex(a.f5583g)));
                strOptString = !TextUtils.isEmpty(strMo4260b) ? new JSONObject(strMo4260b).optString("requestId") : null;
                str = strMo4260b;
            } else {
                strOptString = null;
                str = null;
            }
            if (!TextUtils.isEmpty(strOptString)) {
                c4103bM2883a = C4103b.m2885a(dateM4353f, i2, i, list, strOptString, z);
            } else if (list.size() > 0) {
                c4103bM2883a = C4103b.m2886a(dateM4353f, i2, i, (List<String>) list, z);
            } else {
                c4103bM2883a = C4103b.m2883a(dateM4353f, i2, i);
                c4103bM2883a.m2890a(z);
            }
            c4103bM2883a.m2889a(cursor.getInt(cursor.getColumnIndex("id")));
            c4103bM2883a.m2892b(cursor.getInt(cursor.getColumnIndex("value")));
            c4103bM2883a.m2893b(str);
            if (i2 == 1 && interfaceC4384c != null) {
                c4103bM2883a.m2897d(interfaceC4384c.mo4260b(cursor.getString(cursor.getColumnIndex("predictive_intelligence_identifier"))));
                String string = cursor.getString(cursor.getColumnIndex(a.f5584h));
                if (!TextUtils.isEmpty(string)) {
                    c4103bM2883a.m2895c(interfaceC4384c.mo4260b(string));
                }
            }
            return c4103bM2883a;
        } catch (Exception e) {
            C4170g.m3207b(f5576i, e, "Failed to create our analytic item from storage.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4023d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4022c = m4022c(sQLiteDatabase);
        if (zM4022c) {
            return zM4022c;
        }
        try {
            m4018a(sQLiteDatabase);
            m4020b(sQLiteDatabase);
            return m4022c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5576i, e, "Unable to recover %s", f5572e);
            return zM4022c;
        }
    }

    /* JADX INFO: renamed from: h */
    private int m4024h(int i) {
        return (int) DatabaseUtils.queryNumEntries(this.f5588c, f5572e, m4016a("%s=%s", a.f5585i, Integer.valueOf(i)));
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: b */
    public int mo3985b(int i) {
        return m4030a(m4016a("%s = ? AND %s IN (%s)", a.f5585i, a.f5580d, TextUtils.join(",", C4103b.f4375t)), new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: c */
    public boolean mo3989c(int i) {
        return DatabaseUtils.queryNumEntries(this.f5588c, mo4026o(), m4016a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", a.f5580d, a.f5585i, "value", a.f5582f), new String[]{String.valueOf(4), String.valueOf(5), String.valueOf(i), String.valueOf(0), String.valueOf(0)}) > 0;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: g */
    public List<C4103b> mo3993g(InterfaceC4384c interfaceC4384c) {
        return m4019b(0, interfaceC4384c);
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5572e;
    }

    /* JADX INFO: renamed from: b */
    private List<C4103b> m4019b(int i, InterfaceC4384c interfaceC4384c) {
        return m4025b(m4035a(f5574g, m4016a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", a.f5580d, a.f5585i, "value", a.f5582f), new String[]{String.valueOf(4), String.valueOf(5), String.valueOf(i), String.valueOf(0), String.valueOf(0)}, null, null, m4016a("%s ASC", "id")), interfaceC4384c);
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4022c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(C4344c.m4042a("SELECT %s FROM %s", TextUtils.join(",", f5574g), f5572e));
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5576i, e, "%s is invalid", f5572e);
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: a */
    public int mo3983a(String[] strArr) {
        return m4041i(m4016a("%s IN (%s)", "id", TextUtils.join(",", strArr)));
    }

    /* JADX INFO: renamed from: c */
    private static ContentValues m4021c(C4103b c4103b, InterfaceC4384c interfaceC4384c) throws Exception {
        String strMo4259a;
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.f5579c, C4393l.m4336a(c4103b.m2891b()));
        contentValues.put(a.f5585i, Integer.valueOf(c4103b.m2903j()));
        contentValues.put(a.f5580d, Integer.valueOf(c4103b.m2888a()));
        contentValues.put("value", Integer.valueOf(c4103b.m2900g()));
        contentValues.put(a.f5582f, Integer.valueOf(c4103b.m2901h() ? 1 : 0));
        JSONArray jSONArray = new JSONArray((Collection) c4103b.m2902i());
        contentValues.put(a.f5581e, !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
        if (c4103b.m2894c() != null) {
            contentValues.put(a.f5583g, interfaceC4384c.mo4259a(c4103b.m2894c()));
        }
        if (c4103b.m2903j() == 1) {
            contentValues.put("predictive_intelligence_identifier", interfaceC4384c.mo4259a(c4103b.m2899f()));
            strMo4259a = interfaceC4384c.mo4259a(c4103b.m2898e());
        } else {
            contentValues.put("predictive_intelligence_identifier", (String) null);
            strMo4259a = "";
        }
        contentValues.put(a.f5584h, strMo4259a);
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: a */
    public int mo3982a(int i) {
        return m4030a(m4016a("%s = ? AND %s NOT IN (%s)", a.f5585i, a.f5580d, TextUtils.join(",", C4103b.f4375t)), new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: b */
    public List<C4103b> mo3987b(Region region, InterfaceC4384c interfaceC4384c) {
        return m4025b(m4034a(f5574g, m4016a("(%1$s=? OR %1$s=?) AND %2$s LIKE ? AND %3$s=?", a.f5580d, a.f5581e, a.f5582f), new String[]{String.valueOf(13), String.valueOf(11), m4016a("%%%s%%", region.m3630id()), String.valueOf(0)}), interfaceC4384c);
    }

    /* JADX INFO: renamed from: a */
    static void m4018a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS analytic_item");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
        }
    }

    /* JADX INFO: renamed from: b */
    static void m4020b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, f5575h);
        } else {
            sQLiteDatabase.execSQL(f5575h);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m4016a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: b */
    public int mo3986b(C4103b c4103b, InterfaceC4384c interfaceC4384c) throws Exception {
        return m4028a(m4021c(c4103b, interfaceC4384c), m4016a("%s = ?", "id"), new String[]{String.valueOf(c4103b.m2896d())});
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4338a
    /* JADX INFO: renamed from: a */
    public int mo3981a() {
        try {
            return m4030a("analytic_product_type =? AND event_date <= ?", new String[]{String.valueOf(1), C4393l.m4336a(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(14L)))});
        } catch (Exception e) {
            C4170g.m3207b(f5576i, e, "Unable to purge old analytic data.", new Object[0]);
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4017a(int i, int i2, int i3) throws Exception {
        m4041i(m4016a("%s IN ( SELECT %s FROM %s WHERE %s=%d ORDER BY %s ASC LIMIT %d )", "id", "id", f5572e, a.f5585i, Integer.valueOf(i3), "id", Integer.valueOf((i + 1) - i2)));
    }
}
