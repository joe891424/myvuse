package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.storage.InterfaceC4372h;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.g */
/* JADX INFO: loaded from: classes6.dex */
public final class C4348g extends AbstractC4343b implements InterfaceC4372h {

    /* JADX INFO: renamed from: e */
    public static final String f5600e = "inbox_messages";

    /* JADX INFO: renamed from: f */
    private static final String f5601f = "(start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?)";

    /* JADX INFO: renamed from: g */
    static final String f5602g = C4170g.m3197a("InboxMessageDbStorage");

    /* JADX INFO: renamed from: h */
    private static final String[] f5603h = {"id", "start_date", "is_deleted", "is_read", "message_hash", "is_dirty"};

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.g$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5604a;

        static {
            int[] iArr = new int[InterfaceC4372h.a.values().length];
            f5604a = iArr;
            try {
                iArr[InterfaceC4372h.a.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5604a[InterfaceC4372h.a.UNREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5604a[InterfaceC4372h.a.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5604a[InterfaceC4372h.a.NOT_DELETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C4348g(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    static void m4087b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE inbox_messages(id TEXT PRIMARY KEY, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, is_deleted INTEGER DEFAULT 0, is_read INTEGER DEFAULT 0, is_dirty INTEGER DEFAULT 0, message_hash TEXT DEFAULT NULL, message_json TEXT);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE inbox_messages(id TEXT PRIMARY KEY, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, is_deleted INTEGER DEFAULT 0, is_read INTEGER DEFAULT 0, is_dirty INTEGER DEFAULT 0, message_hash TEXT DEFAULT NULL, message_json TEXT);");
        }
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4090c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,start_date,end_date,is_deleted,is_read,is_dirty,message_hash,message_json FROM inbox_messages");
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5602g, e, "%s is invalid", f5600e);
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: a */
    public void mo4096a(InboxMessage inboxMessage, InterfaceC4384c interfaceC4384c) {
        ContentValues contentValuesM4044a = C4345d.m4044a(inboxMessage, interfaceC4384c);
        if (m4028a(contentValuesM4044a, "id = ?", new String[]{inboxMessage.m3794id()}) == 0) {
            m4031a(contentValuesM4044a);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: d */
    public void mo4100d(String str) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {str, strValueOf, strValueOf};
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "UPDATE inbox_messages SET   is_read = 1,  is_dirty = CASE WHEN is_dirty=1 OR is_deleted=0 THEN 1 ELSE 0 END WHERE   id=? AND (start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_read=0", strArr);
        } else {
            sQLiteDatabase.execSQL("UPDATE inbox_messages SET   is_read = 1,  is_dirty = CASE WHEN is_dirty=1 OR is_deleted=0 THEN 1 ELSE 0 END WHERE   id=? AND (start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_read=0", strArr);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: e */
    public boolean mo4101e(String str) {
        return DatabaseUtils.queryNumEntries(this.f5588c, f5600e, "id=?", new String[]{str}) > 0;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: f */
    public InterfaceC4372h.b mo4102f(String str) {
        Cursor cursorM4034a = m4034a(f5603h, "id=?", new String[]{str});
        if (cursorM4034a != null) {
            bVarM4084a = cursorM4034a.moveToFirst() ? m4084a(cursorM4034a) : null;
            cursorM4034a.close();
        }
        return bVarM4084a;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: h */
    public int mo4103h() {
        return m4041i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: i */
    public List<InterfaceC4372h.b> mo4104i() {
        ArrayList arrayList = null;
        Cursor cursorM4034a = m4034a(f5603h, "is_dirty=1", (String[]) null);
        if (cursorM4034a != null) {
            if (cursorM4034a.moveToFirst()) {
                ArrayList arrayList2 = new ArrayList(cursorM4034a.getCount());
                do {
                    arrayList2.add(m4084a(cursorM4034a));
                } while (cursorM4034a.moveToNext());
                arrayList = arrayList2;
            }
            cursorM4034a.close();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: j */
    public void mo4105j() {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {strValueOf, strValueOf};
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "UPDATE inbox_messages SET   is_read = 1,  is_dirty = CASE WHEN is_dirty=1 OR is_deleted=0 THEN 1 ELSE 0 END WHERE (start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_read=0", strArr);
        } else {
            sQLiteDatabase.execSQL("UPDATE inbox_messages SET   is_read = 1,  is_dirty = CASE WHEN is_dirty=1 OR is_deleted=0 THEN 1 ELSE 0 END WHERE (start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_read=0", strArr);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: n */
    public List<InboxMessage> mo4106n(InterfaceC4384c interfaceC4384c) {
        return m4085a(m4034a((String[]) null, (String) null, (String[]) null), interfaceC4384c);
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5600e;
    }

    /* JADX INFO: renamed from: a */
    static void m4086a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS inbox_messages");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_messages");
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4091d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4090c = m4090c(sQLiteDatabase);
        if (zM4090c) {
            return zM4090c;
        }
        try {
            m4086a(sQLiteDatabase);
            m4087b(sQLiteDatabase);
            return m4090c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5602g, e, "Unable to recover %s", f5600e);
            return zM4090c;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: b */
    public void mo4097b() {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("is_dirty", (Integer) 1);
        contentValues.put("is_deleted", (Integer) 1);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        m4028a(contentValues, "(start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_deleted=0", new String[]{strValueOf, strValueOf});
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: c */
    public void mo4099c(String str) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("is_dirty", (Integer) 1);
        contentValues.put("is_deleted", (Integer) 1);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        m4028a(contentValues, "id=? AND (start_date IS NULL OR start_date<?) AND (end_date IS NULL OR end_date>?) AND is_deleted=0", new String[]{str, strValueOf, strValueOf});
    }

    /* JADX INFO: renamed from: c */
    private static String m4089c(InterfaceC4372h.a aVar) {
        String str;
        StringBuilder sbAppend = new StringBuilder(101).append(f5601f);
        int i = a.f5604a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            str = " AND is_read=? AND is_deleted=?";
        } else {
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException("Unknown MessageStatus while getting message counts.");
            }
            str = " AND is_deleted=?";
        }
        sbAppend.append(str);
        return sbAppend.toString();
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: a */
    public InboxMessage mo4094a(String str, InterfaceC4384c interfaceC4384c) {
        Cursor cursorM4036a = m4036a(null, "id=?", new String[]{str}, null, null, null, "1");
        if (cursorM4036a != null) {
            inboxMessageM4045a = cursorM4036a.moveToFirst() ? C4345d.m4045a(cursorM4036a, interfaceC4384c) : null;
            cursorM4036a.close();
        }
        return inboxMessageM4045a;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: b */
    public void mo4098b(String[] strArr) {
        if (strArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_dirty", (Integer) 0);
            try {
                m4037a(contentValues, Arrays.asList(strArr));
            } catch (Exception unused) {
                C4170g.m3216e(f5602g, "Unable to update %s table.", mo4026o());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static String[] m4088b(InterfaceC4372h.a aVar) {
        String[] strArr;
        String strValueOf = String.valueOf(System.currentTimeMillis());
        int i = a.f5604a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            strArr = new String[4];
            strArr[0] = strValueOf;
            strArr[1] = strValueOf;
            strArr[2] = aVar != InterfaceC4372h.a.READ ? "0" : "1";
            strArr[3] = "0";
        } else {
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException("Unknown MessageStatus while getting message counts.");
            }
            strArr = new String[3];
            strArr[0] = strValueOf;
            strArr[1] = strValueOf;
            strArr[2] = aVar != InterfaceC4372h.a.DELETED ? "0" : "1";
        }
        return strArr;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: a */
    public int mo4092a(InterfaceC4372h.a aVar) {
        return (int) DatabaseUtils.queryNumEntries(this.f5588c, f5600e, m4089c(aVar), m4088b(aVar));
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: a */
    public List<InboxMessage> mo4095a(InterfaceC4384c interfaceC4384c, InterfaceC4372h.a aVar) {
        return m4085a(m4035a(null, m4089c(aVar), m4088b(aVar), null, null, "IFNULL(start_date, " + System.currentTimeMillis() + ") DESC"), interfaceC4384c);
    }

    /* JADX INFO: renamed from: a */
    private static List<InboxMessage> m4085a(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        List<InboxMessage> listEmptyList = Collections.emptyList();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    InboxMessage inboxMessageM4045a = C4345d.m4045a(cursor, interfaceC4384c);
                    if (inboxMessageM4045a != null) {
                        arrayList.add(inboxMessageM4045a);
                    }
                } while (cursor.moveToNext());
                listEmptyList = arrayList;
            }
            cursor.close();
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: a */
    private static InterfaceC4372h.b m4084a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("start_date");
        return new InterfaceC4372h.b(cursor.getString(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("message_hash")), cursor.isNull(columnIndex) ? null : new Date(cursor.getLong(columnIndex)), cursor.getInt(cursor.getColumnIndex("is_read")) == 1, cursor.getInt(cursor.getColumnIndex("is_deleted")) == 1, cursor.getInt(cursor.getColumnIndex("is_dirty")) == 1);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4372h
    /* JADX INFO: renamed from: a */
    public int mo4093a(List<String> list) {
        if (list.size() == 0) {
            return m4030a((String) null, (String[]) null);
        }
        try {
            return m4029a(mo4026o(), list);
        } catch (Exception unused) {
            C4170g.m3216e(f5602g, "Unable to clean up %s table.", mo4026o());
            return 0;
        }
    }
}
