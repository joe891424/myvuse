package com.salesforce.marketingcloud.media;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.media.C4221s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4204b implements InterfaceC4208f {

    /* JADX INFO: renamed from: g */
    private static final String f5017g = C4170g.m3197a("BatchRequestHandler");

    /* JADX INFO: renamed from: a */
    private final AtomicInteger f5018a;

    /* JADX INFO: renamed from: b */
    private final C4217o f5019b;

    /* JADX INFO: renamed from: c */
    private final List<String> f5020c;

    /* JADX INFO: renamed from: d */
    private a f5021d;

    /* JADX INFO: renamed from: e */
    private boolean f5022e;

    /* JADX INFO: renamed from: f */
    private boolean f5023f;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.b$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3512a(boolean z);
    }

    public C4204b(C4217o c4217o, List<String> list) {
        this.f5019b = c4217o;
        this.f5020c = list;
        this.f5018a = new AtomicInteger(list.size());
    }

    /* JADX INFO: renamed from: c */
    private void m3507c() {
        a aVar;
        if (this.f5018a.decrementAndGet() > 0 || (aVar = this.f5021d) == null || this.f5022e) {
            return;
        }
        aVar.mo3512a(!this.f5023f);
    }

    /* JADX INFO: renamed from: a */
    public void m3509a(a aVar) {
        this.f5021d = aVar;
        if (this.f5018a.get() == 0) {
            if (aVar != null) {
                aVar.mo3512a(true);
            }
        } else {
            Iterator<String> it2 = this.f5020c.iterator();
            while (it2.hasNext()) {
                this.f5019b.m3574b(it2.next()).m3607a(C4221s.b.NO_MEMORY_CACHE, C4221s.b.NO_MEMORY_STORE).m3610a(this);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3511b() {
        this.f5022e = true;
    }

    @Override // com.salesforce.marketingcloud.media.InterfaceC4208f
    /* JADX INFO: renamed from: a */
    public void mo3510a(Exception exc) {
        if (exc instanceof C4213k) {
            C4170g.m3207b(f5017g, exc, "Failed to pre-fetch image, but will be ignored since the url cannot be handled.", new Object[0]);
        } else {
            this.f5023f = true;
            C4170g.m3207b(f5017g, exc, "Failed to pre-fetch image.", new Object[0]);
        }
        m3507c();
    }

    @Override // com.salesforce.marketingcloud.media.InterfaceC4208f
    /* JADX INFO: renamed from: a */
    public void mo3508a() {
        m3507c();
    }
}
