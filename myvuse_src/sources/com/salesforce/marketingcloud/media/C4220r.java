package com.salesforce.marketingcloud.media;

import com.salesforce.marketingcloud.util.C4387f;
import com.salesforce.marketingcloud.util.C4388g;
import com.salesforce.marketingcloud.util.C4393l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.r */
/* JADX INFO: loaded from: classes6.dex */
public class C4220r {

    /* JADX INFO: renamed from: d */
    private static final int f5102d = 20971520;

    /* JADX INFO: renamed from: a */
    private final File f5103a;

    /* JADX INFO: renamed from: b */
    private final Object f5104b = new Object();

    /* JADX INFO: renamed from: c */
    private C4387f f5105c;

    C4220r(File file) {
        this.f5103a = file;
    }

    /* JADX INFO: renamed from: b */
    private void m3578b() throws IOException {
        synchronized (this.f5104b) {
            if (this.f5105c == null) {
                this.f5105c = C4387f.m4270a(this.f5103a, 0, 1, 20971520L);
                this.f5104b.notifyAll();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m3579c(String str) {
        return C4393l.m4354g(str);
    }

    /* JADX INFO: renamed from: a */
    void m3581a() throws IOException {
        m3578b();
        this.f5105c.m4285c();
    }

    /* JADX INFO: renamed from: a */
    InputStream m3580a(String str) throws IOException {
        InputStream inputStreamM4308a;
        m3578b();
        String strM3579c = m3579c(str);
        synchronized (this.f5104b) {
            C4387f.e eVarM4283b = this.f5105c.m4283b(strM3579c);
            inputStreamM4308a = eVarM4283b != null ? eVarM4283b.m4308a(0) : null;
        }
        return inputStreamM4308a;
    }

    /* JADX INFO: renamed from: b */
    void m3583b(String str) throws IOException {
        m3578b();
        this.f5105c.m4287d(m3579c(str));
    }

    /* JADX INFO: renamed from: a */
    void m3582a(String str, InputStream inputStream) throws IOException {
        m3578b();
        String strM3579c = m3579c(str);
        synchronized (this.f5104b) {
            C4387f.c cVarM4279a = this.f5105c.m4279a(strM3579c);
            try {
                C4388g.m4316a(inputStream, cVarM4279a.m4300c(0));
                cVarM4279a.m4301c();
            } finally {
                C4388g.m4312a((Closeable) inputStream);
            }
        }
    }
}
