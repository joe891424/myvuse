package com.salesforce.marketingcloud.media;

import java.util.Iterator;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.e */
/* JADX INFO: loaded from: classes6.dex */
class RunnableC4207e implements Runnable {

    /* JADX INFO: renamed from: a */
    final C4217o f5032a;

    /* JADX INFO: renamed from: b */
    final C4206d f5033b;

    /* JADX INFO: renamed from: c */
    final C4210h f5034c;

    /* JADX INFO: renamed from: d */
    private Exception f5035d;

    RunnableC4207e(C4210h c4210h, C4206d c4206d) {
        this.f5032a = c4206d.m3520c();
        this.f5034c = c4210h;
        this.f5033b = c4206d;
    }

    /* JADX INFO: renamed from: a */
    Exception m3522a() {
        return this.f5035d;
    }

    /* JADX INFO: renamed from: b */
    boolean m3523b() {
        return this.f5035d != null;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                Thread.currentThread().setName("CacheCleaner - Cleaning");
                C4220r c4220rM3518a = this.f5033b.m3518a();
                Iterator<String> it2 = this.f5033b.m3521d().iterator();
                while (it2.hasNext()) {
                    c4220rM3518a.m3583b(it2.next());
                }
                c4220rM3518a.m3581a();
            } catch (Exception e) {
                this.f5035d = e;
            }
            Thread.currentThread().setName("CacheCleaner - Idle");
            this.f5034c.m3528a(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("CacheCleaner - Idle");
            throw th;
        }
    }
}
