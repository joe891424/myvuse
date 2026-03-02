package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.storage.C4374j;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.o */
/* JADX INFO: loaded from: classes6.dex */
public class C4217o {

    /* JADX INFO: renamed from: i */
    static final Handler f5082i = new a(Looper.getMainLooper());

    /* JADX INFO: renamed from: a */
    final Context f5083a;

    /* JADX INFO: renamed from: b */
    final C4210h f5084b;

    /* JADX INFO: renamed from: c */
    final C4205c f5085c;

    /* JADX INFO: renamed from: d */
    final C4220r f5086d;

    /* JADX INFO: renamed from: e */
    final Map<ImageView, ViewTreeObserverOnPreDrawListenerC4209g> f5087e;

    /* JADX INFO: renamed from: f */
    final Map<Object, AbstractC4203a> f5088f;

    /* JADX INFO: renamed from: g */
    private final List<AbstractC4223u> f5089g;

    /* JADX INFO: renamed from: h */
    public ReferenceQueue f5090h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.o$a */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                RunnableC4216n runnableC4216n = (RunnableC4216n) message.obj;
                runnableC4216n.f5066a.m3570a(runnableC4216n);
            } else {
                if (i != 5) {
                    return;
                }
                RunnableC4207e runnableC4207e = (RunnableC4207e) message.obj;
                runnableC4207e.f5032a.m3569a(runnableC4207e);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.o$b */
    public enum b {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);


        /* JADX INFO: renamed from: a */
        final int f5095a;

        b(int i) {
            this.f5095a = i;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.o$c */
    public enum c {
        NORMAL,
        HIGH
    }

    public C4217o(Context context, C4210h c4210h, C4205c c4205c, C4220r c4220r) {
        this.f5083a = context;
        this.f5084b = c4210h;
        this.f5085c = c4205c;
        this.f5086d = c4220r;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new C4219q(c4220r));
        arrayList.add(new C4211i(context));
        this.f5089g = Collections.unmodifiableList(arrayList);
        this.f5088f = new WeakHashMap();
        this.f5087e = new WeakHashMap();
    }

    /* JADX INFO: renamed from: a */
    public C4204b m3565a(List<String> list) {
        return new C4204b(this, new ArrayList(list));
    }

    /* JADX INFO: renamed from: b */
    public C4222t m3574b(String str) {
        return new C4222t(this, Uri.parse(str));
    }

    /* JADX INFO: renamed from: a */
    void m3571a(Object obj) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AbstractC4203a abstractC4203aRemove = this.f5088f.remove(obj);
            if (abstractC4203aRemove != null) {
                abstractC4203aRemove.mo3498a();
                this.f5084b.m3526a(abstractC4203aRemove);
            }
            if (obj instanceof ImageView) {
                ViewTreeObserverOnPreDrawListenerC4209g viewTreeObserverOnPreDrawListenerC4209gRemove = this.f5087e.remove((ImageView) obj);
                if (viewTreeObserverOnPreDrawListenerC4209gRemove != null) {
                    viewTreeObserverOnPreDrawListenerC4209gRemove.m3524a();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public Bitmap m3564a(String str) {
        return this.f5085c.m3514a(str);
    }

    /* JADX INFO: renamed from: a */
    public void m3569a(RunnableC4207e runnableC4207e) {
        InterfaceC4208f interfaceC4208fM3519b = runnableC4207e.f5033b.m3519b();
        if (interfaceC4208fM3519b != null) {
            if (runnableC4207e.m3523b()) {
                interfaceC4208fM3519b.mo3510a(runnableC4207e.m3522a());
            } else {
                interfaceC4208fM3519b.mo3508a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3570a(RunnableC4216n runnableC4216n) {
        AbstractC4203a abstractC4203aM3551c = runnableC4216n.m3551c();
        List<AbstractC4203a> listM3552d = runnableC4216n.m3552d();
        boolean z = (listM3552d == null || listM3552d.isEmpty()) ? false : true;
        if (abstractC4203aM3551c != null || z) {
            Exception excM3554f = runnableC4216n.m3554f();
            AbstractC4223u.b bVarM3557i = runnableC4216n.m3557i();
            if (abstractC4203aM3551c != null) {
                m3563a(abstractC4203aM3551c, bVarM3557i, excM3554f);
            }
            if (z) {
                int size = listM3552d.size();
                for (int i = 0; i < size; i++) {
                    m3563a(listM3552d.get(i), bVarM3557i, excM3554f);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C4217o m3562a(Context context, C4374j c4374j) {
        C4205c c4205c = new C4205c(context);
        return new C4217o(context, new C4210h(context, new C4215m(), f5082i, c4205c), c4205c, new C4220r(c4374j.m4235k()));
    }

    /* JADX INFO: renamed from: a */
    public void m3567a(ImageView imageView, ViewTreeObserverOnPreDrawListenerC4209g viewTreeObserverOnPreDrawListenerC4209g) {
        if (this.f5087e.containsKey(imageView)) {
            m3571a(imageView);
        }
        this.f5087e.put(imageView, viewTreeObserverOnPreDrawListenerC4209g);
    }

    /* JADX INFO: renamed from: a */
    private void m3563a(AbstractC4203a abstractC4203a, AbstractC4223u.b bVar, Exception exc) {
        if (abstractC4203a.m3506g()) {
            return;
        }
        this.f5088f.remove(abstractC4203a.m3505f());
        if (bVar != null) {
            abstractC4203a.mo3499a(bVar);
        } else {
            abstractC4203a.mo3500a(exc);
        }
    }

    /* JADX INFO: renamed from: a */
    List<AbstractC4223u> m3566a() {
        return this.f5089g;
    }

    /* JADX INFO: renamed from: a */
    public void m3572a(Collection<String> collection) {
        m3573a(collection, (InterfaceC4208f) null);
    }

    /* JADX INFO: renamed from: a */
    public void m3573a(Collection<String> collection, InterfaceC4208f interfaceC4208f) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f5084b.m3527a(new C4206d(this, new ArrayList(collection), this.f5086d, interfaceC4208f));
    }

    /* JADX INFO: renamed from: a */
    public void m3568a(AbstractC4203a abstractC4203a) {
        Object objM3505f = abstractC4203a.m3505f();
        if (objM3505f != null && this.f5088f.get(objM3505f) != abstractC4203a) {
            m3571a(objM3505f);
            this.f5088f.put(objM3505f, abstractC4203a);
        }
        this.f5084b.m3529b(abstractC4203a);
    }
}
