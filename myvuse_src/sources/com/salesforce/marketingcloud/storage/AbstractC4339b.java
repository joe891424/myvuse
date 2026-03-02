package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.p047db.C4353l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.io.File;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.b */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4339b extends AbstractC4367e {

    /* JADX INFO: renamed from: k */
    protected static final String f5552k = "create_date";

    /* JADX INFO: renamed from: l */
    private static final String f5553l = "storagedb.db";

    /* JADX INFO: renamed from: m */
    private static final String f5554m = "ETSharedPrefs";

    /* JADX INFO: renamed from: n */
    private static final String f5555n = "mcsdk_%s";

    /* JADX INFO: renamed from: h */
    protected final String f5556h;

    /* JADX INFO: renamed from: i */
    protected final Context f5557i;

    /* JADX INFO: renamed from: j */
    protected final InterfaceC4384c f5558j;

    AbstractC4339b(Context context, InterfaceC4384c interfaceC4384c, String str, String str2) {
        super(str, str2);
        this.f5557i = context;
        this.f5558j = interfaceC4384c;
        this.f5556h = str;
        if (!m3998g() && m4000i() && m4001j()) {
            try {
                m3999h();
            } catch (Exception e) {
                C4170g.m3207b(AbstractC4367e.f5690c, e, "Unable to migrate data to BU specific storage", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static String m3997a(String str) {
        return String.format(Locale.ENGLISH, f5555n, str);
    }

    /* JADX INFO: renamed from: g */
    private boolean m3998g() {
        File databasePath = this.f5557i.getDatabasePath(C4353l.m4156a(this.f5556h));
        return databasePath != null && databasePath.exists();
    }

    /* JADX INFO: renamed from: h */
    private void m3999h() {
        File databasePath = this.f5557i.getDatabasePath(f5553l);
        if (databasePath != null && databasePath.exists()) {
            try {
                if (!databasePath.renameTo(new File(databasePath.getParent(), C4353l.m4156a(this.f5556h)))) {
                    C4170g.m3206b(AbstractC4367e.f5690c, "Unable to rename storagedb.db to BU specific naming scheme", new Object[0]);
                }
            } catch (Exception e) {
                C4170g.m3207b(AbstractC4367e.f5690c, e, "Unable to rename storagedb.db to BU specific naming scheme", new Object[0]);
            }
        }
        File file = new File(this.f5557i.getApplicationInfo().dataDir, "shared_prefs/");
        if (file.exists()) {
            File file2 = new File(file, "ETCustomerPrefs.xml");
            if (file2.exists()) {
                try {
                    if (!file2.renameTo(new File(file, InterfaceC4340c.a.m4003b(this.f5556h) + ".xml"))) {
                        C4170g.m3206b(AbstractC4367e.f5690c, "Unable to rename ETCustomerPrefs.xml to BU specific naming scheme", new Object[0]);
                    }
                } catch (Exception e2) {
                    C4170g.m3207b(AbstractC4367e.f5690c, e2, "Unable to rename ETCustomerPrefs.xml to BU specific naming scheme", new Object[0]);
                }
            }
            File file3 = new File(file, "ETSharedPrefs.xml");
            if (file3.exists()) {
                try {
                    if (file3.renameTo(new File(file, m3997a(this.f5556h) + ".xml"))) {
                        return;
                    }
                    C4170g.m3206b(AbstractC4367e.f5690c, "Unable to rename ETSharedPrefs.xml to BU specific naming scheme", new Object[0]);
                } catch (Exception e3) {
                    C4170g.m3207b(AbstractC4367e.f5690c, e3, "Unable to rename ETSharedPrefs.xml to BU specific naming scheme", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private boolean m4000i() {
        File databasePath = this.f5557i.getDatabasePath(f5553l);
        return databasePath != null && databasePath.exists();
    }

    /* JADX INFO: renamed from: j */
    private boolean m4001j() {
        return mo4002a(this.f5557i.getSharedPreferences(f5554m, 0));
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo4002a(SharedPreferences sharedPreferences);
}
