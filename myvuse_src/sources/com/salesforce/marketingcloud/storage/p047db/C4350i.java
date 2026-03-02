package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.C4183f;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.storage.InterfaceC4375k;
import com.salesforce.marketingcloud.util.C4393l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.i */
/* JADX INFO: loaded from: classes6.dex */
public final class C4350i extends AbstractC4343b implements InterfaceC4375k {

    /* JADX INFO: renamed from: e */
    public static final String f5612e = "messages";

    /* JADX INFO: renamed from: g */
    private static final String f5614g = "CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER );";

    /* JADX INFO: renamed from: f */
    private static final String[] f5613f = {"id", "title", "alert", "sound", a.f5620e, a.f5621f, a.f5622g, "start_date", "end_date", "message_type", "content_type", "url", "custom", "keys", a.f5630o, a.f5632q, a.f5633r, a.f5631p, a.f5634s, a.f5635t, a.f5636u, a.f5637v, a.f5638w, a.f5639x, a.f5640y};

    /* JADX INFO: renamed from: h */
    private static final String f5615h = C4170g.m3197a("MessageDbStorage");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.i$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final String f5616a = "id";

        /* JADX INFO: renamed from: b */
        public static final String f5617b = "title";

        /* JADX INFO: renamed from: c */
        public static final String f5618c = "alert";

        /* JADX INFO: renamed from: d */
        public static final String f5619d = "sound";

        /* JADX INFO: renamed from: e */
        public static final String f5620e = "mediaUrl";

        /* JADX INFO: renamed from: f */
        public static final String f5621f = "mediaAlt";

        /* JADX INFO: renamed from: g */
        public static final String f5622g = "open_direct";

        /* JADX INFO: renamed from: h */
        public static final String f5623h = "start_date";

        /* JADX INFO: renamed from: i */
        public static final String f5624i = "end_date";

        /* JADX INFO: renamed from: j */
        public static final String f5625j = "message_type";

        /* JADX INFO: renamed from: k */
        public static final String f5626k = "content_type";

        /* JADX INFO: renamed from: l */
        public static final String f5627l = "url";

        /* JADX INFO: renamed from: m */
        public static final String f5628m = "custom";

        /* JADX INFO: renamed from: n */
        public static final String f5629n = "keys";

        /* JADX INFO: renamed from: o */
        public static final String f5630o = "period_show_count";

        /* JADX INFO: renamed from: p */
        public static final String f5631p = "show_count";

        /* JADX INFO: renamed from: q */
        public static final String f5632q = "last_shown_date";

        /* JADX INFO: renamed from: r */
        public static final String f5633r = "next_allowed_show";

        /* JADX INFO: renamed from: s */
        public static final String f5634s = "message_limit";

        /* JADX INFO: renamed from: t */
        public static final String f5635t = "rolling_period";

        /* JADX INFO: renamed from: u */
        public static final String f5636u = "period_type";

        /* JADX INFO: renamed from: v */
        public static final String f5637v = "number_of_periods";

        /* JADX INFO: renamed from: w */
        public static final String f5638w = "messages_per_period";

        /* JADX INFO: renamed from: x */
        public static final String f5639x = "proximity";

        /* JADX INFO: renamed from: y */
        public static final String f5640y = "notify_id";
    }

    public C4350i(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4119c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(C4344c.m4042a("SELECT %s FROM %s", TextUtils.join(",", f5613f), f5612e));
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5615h, e, "%s is invalid", f5612e);
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4120d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4119c = m4119c(sQLiteDatabase);
        if (zM4119c) {
            return zM4119c;
        }
        try {
            m4116a(sQLiteDatabase);
            m4118b(sQLiteDatabase);
            return m4119c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5615h, e, "Unable to recover %s", f5612e);
            return zM4119c;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: a */
    public void mo4125a(Message message, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValuesM4117b = m4117b(message, interfaceC4384c);
        if (m4028a(contentValuesM4117b, m4114a("%s = ?", "id"), new String[]{message.m3624id()}) == 0) {
            m4031a(contentValuesM4117b);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: b */
    public List<Message> mo4126b(InterfaceC4384c interfaceC4384c) {
        List<Message> listEmptyList = Collections.emptyList();
        Cursor cursorM4033a = m4033a(f5613f, m4115a(5));
        if (cursorM4033a != null) {
            if (cursorM4033a.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorM4033a.getCount());
                do {
                    Message messageM4047b = C4345d.m4047b(cursorM4033a, interfaceC4384c);
                    if (messageM4047b != null) {
                        arrayList.add(messageM4047b);
                    }
                } while (cursorM4033a.moveToNext());
                listEmptyList = arrayList;
            }
            cursorM4033a.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: e */
    public int mo4127e(int i) {
        return m4030a(m4114a("%s = ?", "message_type"), new String[]{String.valueOf(i)});
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5612e;
    }

    /* JADX INFO: renamed from: a */
    private String m4115a(int... iArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i : iArr) {
            if (z) {
                sb.append("message_type IN(");
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(i);
        }
        sb.append(");");
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    static void m4118b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, f5614g);
        } else {
            sQLiteDatabase.execSQL(f5614g);
        }
    }

    /* JADX INFO: renamed from: b */
    private static ContentValues m4117b(Message message, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", message.m3624id());
        contentValues.put("title", interfaceC4384c.mo4259a(message.title()));
        contentValues.put("alert", interfaceC4384c.mo4259a(message.alert()));
        contentValues.put("sound", message.sound());
        if (message.media() != null) {
            contentValues.put(a.f5620e, interfaceC4384c.mo4259a(message.media().url()));
            contentValues.put(a.f5621f, interfaceC4384c.mo4259a(message.media().altText()));
        }
        contentValues.put("start_date", C4393l.m4336a(message.startDateUtc()));
        contentValues.put("end_date", C4393l.m4336a(message.endDateUtc()));
        contentValues.put("message_type", Integer.valueOf(message.messageType()));
        contentValues.put("content_type", Integer.valueOf(message.contentType()));
        contentValues.put("url", interfaceC4384c.mo4259a(message.url()));
        contentValues.put("custom", interfaceC4384c.mo4259a(message.custom()));
        contentValues.put(a.f5638w, Integer.valueOf(message.messagesPerPeriod()));
        contentValues.put(a.f5637v, Integer.valueOf(message.numberOfPeriods()));
        contentValues.put(a.f5636u, Integer.valueOf(message.periodType()));
        contentValues.put(a.f5635t, Integer.valueOf(message.isRollingPeriod() ? 1 : 0));
        contentValues.put(a.f5634s, Integer.valueOf(message.messageLimit()));
        contentValues.put(a.f5639x, Integer.valueOf(message.proximity()));
        contentValues.put(a.f5622g, interfaceC4384c.mo4259a(message.openDirect()));
        contentValues.put("keys", interfaceC4384c.mo4259a(C4393l.m4337a(message.customKeys())));
        contentValues.put(a.f5633r, C4393l.m4336a(C4183f.m3359b(message)));
        contentValues.put(a.f5630o, Integer.valueOf(C4183f.m3364d(message)));
        contentValues.put(a.f5640y, Integer.valueOf(C4183f.m3362c(message)));
        contentValues.put(a.f5631p, Integer.valueOf(C4183f.m3365e(message)));
        contentValues.put(a.f5632q, C4393l.m4336a(C4183f.m3356a(message)));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: a */
    public int mo4121a(String str) {
        return m4030a(m4114a("%s = ?", "id"), new String[]{str});
    }

    /* JADX INFO: renamed from: a */
    static void m4116a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS messages");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m4114a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: a */
    public List<Message> mo4124a(InterfaceC4384c interfaceC4384c) {
        List<Message> listEmptyList = Collections.emptyList();
        Cursor cursorM4033a = m4033a(f5613f, m4115a(3, 4));
        if (cursorM4033a != null) {
            if (cursorM4033a.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorM4033a.getCount());
                do {
                    Message messageM4047b = C4345d.m4047b(cursorM4033a, interfaceC4384c);
                    if (messageM4047b != null) {
                        arrayList.add(messageM4047b);
                    }
                } while (cursorM4033a.moveToNext());
                listEmptyList = arrayList;
            }
            cursorM4033a.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: a */
    public Message mo4123a(String str, InterfaceC4384c interfaceC4384c) {
        Cursor cursorM4036a = m4036a(f5613f, m4114a("%s = ?", "id"), new String[]{str}, null, null, null, "1");
        if (cursorM4036a != null) {
            messageM4047b = cursorM4036a.moveToFirst() ? C4345d.m4047b(cursorM4036a, interfaceC4384c) : null;
            cursorM4036a.close();
        }
        return messageM4047b;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4375k
    /* JADX INFO: renamed from: a */
    public int mo4122a(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.f5640y, Integer.valueOf(i));
        return m4028a(contentValues, m4114a("%s = ?", "id"), new String[]{str});
    }
}
