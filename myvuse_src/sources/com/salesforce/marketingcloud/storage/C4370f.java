package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.util.C4388g;
import com.salesforce.marketingcloud.util.C4393l;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.f */
/* JADX INFO: loaded from: classes6.dex */
public class C4370f {

    /* JADX INFO: renamed from: c */
    private final Context f5699c;

    /* JADX INFO: renamed from: d */
    private final SharedPreferences f5700d;

    /* JADX INFO: renamed from: e */
    final File f5701e;

    /* JADX INFO: renamed from: f */
    private final String f5702f;

    /* JADX INFO: renamed from: g */
    private final C4189l f5703g;

    /* JADX INFO: renamed from: h */
    private String f5704h;

    /* JADX INFO: renamed from: a */
    final Object f5697a = new Object();

    /* JADX INFO: renamed from: b */
    private final Object f5698b = new Object();

    /* JADX INFO: renamed from: i */
    private boolean f5705i = false;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.f$a */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            C4370f.this.m4227b();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.f$b */
    class b extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5707b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5707b = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r2v7 */
        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            ?? fileOutputStream;
            Throwable th;
            ?? r2;
            synchronized (C4370f.this.f5697a) {
                ?? r1 = 0;
                ?? r12 = 0;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(C4370f.this.f5701e);
                    } catch (Throwable th2) {
                        fileOutputStream = r1;
                        th = th2;
                    }
                } catch (Exception unused) {
                }
                try {
                    String str = this.f5707b;
                    fileOutputStream.write(str != null ? str.getBytes(C4393l.f5818b) : new byte[0]);
                    String str2 = AbstractC4367e.f5690c;
                    C4170g.m3213d(str2, "Gdpr mode [%s] written to file.", this.f5707b);
                    r1 = str2;
                    r2 = fileOutputStream;
                } catch (Exception unused2) {
                    r12 = fileOutputStream;
                    C4170g.m3206b(AbstractC4367e.f5690c, "Failed to write gdpr mode to file: ", C4370f.this.f5701e.getAbsolutePath());
                    r2 = r12;
                    r1 = r12;
                } catch (Throwable th3) {
                    th = th3;
                    C4388g.m4312a((Closeable) fileOutputStream);
                    throw th;
                }
                C4388g.m4312a((Closeable) r2);
            }
        }
    }

    C4370f(Context context, SharedPreferences sharedPreferences, String str, C4189l c4189l) {
        this.f5699c = context;
        this.f5700d = sharedPreferences;
        this.f5703g = c4189l;
        String str2 = str + "_SFMC_PrivacyMode";
        this.f5702f = str2;
        this.f5701e = new File(context.getNoBackupFilesDir(), str2);
        m4225c();
    }

    /* JADX INFO: renamed from: a */
    private void m4224a() {
        while (!this.f5705i) {
            try {
                this.f5698b.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4225c() {
        synchronized (this.f5698b) {
            this.f5705i = false;
        }
        new a("gdpr_file_load").start();
    }

    /* JADX INFO: renamed from: b */
    void m4227b() throws Throwable {
        synchronized (this.f5698b) {
            if (this.f5705i) {
                return;
            }
            String string = null;
            if (this.f5701e.exists()) {
                String strM4223a = m4223a(this.f5701e);
                if (!TextUtils.isEmpty(strM4223a)) {
                    string = strM4223a;
                }
            } else {
                String str = AbstractC4367e.f5690c;
                C4170g.m3202a(str, "Checking SharedPreferences for gdpr mode", new Object[0]);
                string = this.f5700d.getString("cc_state", null);
                if (string != null) {
                    this.f5700d.edit().remove("cc_state").apply();
                } else {
                    C4170g.m3202a(str, "Checking pre-lollipop location for gdpr mode", new Object[0]);
                    File file = new File(this.f5699c.getFilesDir(), this.f5702f);
                    if (file.exists()) {
                        string = m4223a(file);
                        C4388g.m4318b(file);
                    }
                }
                m4229c(string);
            }
            synchronized (this.f5698b) {
                this.f5704h = string;
                this.f5705i = true;
                this.f5698b.notifyAll();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m4226a(String str) {
        synchronized (this.f5698b) {
            m4224a();
            String str2 = this.f5704h;
            if (str2 != null) {
                str = str2;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    public void m4228b(String str) {
        synchronized (this.f5698b) {
            C4170g.m3213d(AbstractC4367e.f5690c, "Updating gdpr mode: %s", str);
            this.f5704h = str;
            m4229c(str);
        }
    }

    /* JADX INFO: renamed from: c */
    void m4229c(String str) {
        this.f5703g.m3399b().execute(new b("storing_gdpr", new Object[0], str));
    }

    /* JADX INFO: renamed from: a */
    private static String m4223a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String line = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                line = new BufferedReader(new InputStreamReader(fileInputStream, C4393l.f5818b)).readLine();
            } catch (Exception unused) {
                try {
                    C4170g.m3206b(AbstractC4367e.f5690c, "Failed to read gdpr mode from file: ", file.getAbsolutePath());
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    C4388g.m4312a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C4388g.m4312a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            C4388g.m4312a((Closeable) fileInputStream);
            throw th;
        }
        C4388g.m4312a((Closeable) fileInputStream);
        return line;
    }
}
