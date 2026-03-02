package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.media.C4221s;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.t */
/* JADX INFO: loaded from: classes6.dex */
public class C4222t {

    /* JADX INFO: renamed from: a */
    private final C4217o f5134a;

    /* JADX INFO: renamed from: b */
    private final C4221s.a f5135b;

    /* JADX INFO: renamed from: c */
    private boolean f5136c;

    public C4222t(C4217o c4217o, Uri uri) {
        this.f5134a = c4217o;
        this.f5135b = new C4221s.a(uri);
    }

    /* JADX INFO: renamed from: a */
    public C4222t m3603a() {
        this.f5135b.m3594b();
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C4222t m3611b() {
        this.f5135b.m3595c();
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m3612c() {
        m3610a((InterfaceC4208f) null);
    }

    /* JADX INFO: renamed from: d */
    public C4222t m3613d() {
        this.f5136c = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    private C4221s m3602a(long j) {
        C4221s c4221sM3593a = this.f5135b.m3593a();
        c4221sM3593a.f5118l = j;
        return c4221sM3593a;
    }

    /* JADX INFO: renamed from: a */
    public C4222t m3604a(float f, float f2, int i) {
        this.f5135b.m3589a(f, f2, i);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3610a(InterfaceC4208f interfaceC4208f) {
        long jNanoTime = System.nanoTime();
        if (!this.f5135b.m3596d()) {
            this.f5135b.m3591a(C4217o.c.NORMAL);
        }
        C4221s c4221sM3602a = m3602a(jNanoTime);
        if (!C4221s.b.m3597a(c4221sM3602a.f5110d) || this.f5134a.m3564a(c4221sM3602a.f5108b) == null) {
            this.f5134a.m3568a((AbstractC4203a) new C4212j(this.f5134a, c4221sM3602a, interfaceC4208f));
        } else {
            C4170g.m3202a("IMAGE", "onSuccess - Loaded from: MEMORY", new Object[0]);
            if (interfaceC4208f != null) {
                interfaceC4208f.mo3508a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3608a(ImageView imageView) {
        m3609a(imageView, (InterfaceC4208f) null);
    }

    /* JADX INFO: renamed from: a */
    public void m3609a(ImageView imageView, InterfaceC4208f interfaceC4208f) {
        Bitmap bitmapM3564a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("TODO");
        }
        if (!this.f5135b.m3596d()) {
            this.f5135b.m3591a(C4217o.c.HIGH);
        }
        if (this.f5136c) {
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                this.f5134a.m3567a(imageView, new ViewTreeObserverOnPreDrawListenerC4209g(this, imageView, interfaceC4208f));
                return;
            }
            this.f5135b.m3590a(width, height);
        }
        C4221s c4221sM3602a = m3602a(System.nanoTime());
        if (!C4221s.b.m3597a(c4221sM3602a.f5110d) || (bitmapM3564a = this.f5134a.m3564a(c4221sM3602a.f5108b)) == null) {
            this.f5134a.m3568a((AbstractC4203a) new C4218p(this.f5134a, new C4224v(imageView), c4221sM3602a, interfaceC4208f));
            return;
        }
        AbstractC4223u.b bVar = new AbstractC4223u.b(bitmapM3564a, C4217o.b.MEMORY);
        C4214l.m3540a(imageView, this.f5134a.f5083a, bVar);
        C4170g.m3202a("IMAGE", "onSuccess - Loaded from: %s", bVar.m3621c());
        if (interfaceC4208f != null) {
            interfaceC4208f.mo3508a();
        }
    }

    /* JADX INFO: renamed from: a */
    public C4222t m3606a(C4217o.c cVar) {
        this.f5135b.m3591a(cVar);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C4222t m3605a(int i, int i2) {
        this.f5135b.m3590a(i, i2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C4222t m3607a(C4221s.b bVar, C4221s.b... bVarArr) {
        this.f5135b.m3592a(bVar, bVarArr);
        return this;
    }
}
