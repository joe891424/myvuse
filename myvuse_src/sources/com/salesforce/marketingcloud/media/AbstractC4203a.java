package com.salesforce.marketingcloud.media;

import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4217o;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4203a<T> {

    /* JADX INFO: renamed from: a */
    final C4221s f5011a;

    /* JADX INFO: renamed from: b */
    final WeakReference<T> f5012b;

    /* JADX INFO: renamed from: c */
    final C4224v<T> f5013c;

    /* JADX INFO: renamed from: d */
    private final C4217o f5014d;

    /* JADX INFO: renamed from: e */
    private boolean f5015e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.a$a */
    static class a<M> extends WeakReference<M> {

        /* JADX INFO: renamed from: a */
        final AbstractC4203a f5016a;

        a(AbstractC4203a abstractC4203a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f5016a = abstractC4203a;
        }
    }

    AbstractC4203a(C4217o c4217o, C4224v<T> c4224v, C4221s c4221s) {
        this.f5014d = c4217o;
        this.f5011a = c4221s;
        if (c4224v == null) {
            this.f5012b = null;
        } else {
            this.f5012b = new a(this, c4224v.f5140a, c4217o.f5090h);
            c4224v.f5140a = null;
        }
        this.f5013c = c4224v;
    }

    /* JADX INFO: renamed from: a */
    void mo3498a() {
        this.f5015e = true;
    }

    /* JADX INFO: renamed from: a */
    abstract void mo3499a(AbstractC4223u.b bVar);

    /* JADX INFO: renamed from: a */
    abstract void mo3500a(Exception exc);

    /* JADX INFO: renamed from: b */
    C4217o m3501b() {
        return this.f5014d;
    }

    /* JADX INFO: renamed from: c */
    public String m3502c() {
        return this.f5011a.f5108b;
    }

    /* JADX INFO: renamed from: d */
    public C4217o.c m3503d() {
        return this.f5011a.f5109c;
    }

    /* JADX INFO: renamed from: e */
    C4221s m3504e() {
        return this.f5011a;
    }

    /* JADX INFO: renamed from: f */
    T m3505f() {
        WeakReference<T> weakReference = this.f5012b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: renamed from: g */
    public boolean m3506g() {
        return this.f5015e;
    }
}
