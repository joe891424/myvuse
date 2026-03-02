package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4221s;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.h */
/* JADX INFO: loaded from: classes6.dex */
public class C4210h {

    /* JADX INFO: renamed from: h */
    static final int f5039h = 1;

    /* JADX INFO: renamed from: i */
    static final int f5040i = 2;

    /* JADX INFO: renamed from: j */
    static final int f5041j = 3;

    /* JADX INFO: renamed from: k */
    static final int f5042k = 4;

    /* JADX INFO: renamed from: l */
    static final int f5043l = 5;

    /* JADX INFO: renamed from: m */
    static final int f5044m = 6;

    /* JADX INFO: renamed from: n */
    private static final String f5045n = C4170g.m3197a("Dispatcher");

    /* JADX INFO: renamed from: a */
    final Map<String, RunnableC4216n> f5046a;

    /* JADX INFO: renamed from: b */
    final b f5047b;

    /* JADX INFO: renamed from: c */
    final Context f5048c;

    /* JADX INFO: renamed from: d */
    final ExecutorService f5049d;

    /* JADX INFO: renamed from: e */
    final Handler f5050e;

    /* JADX INFO: renamed from: f */
    final Handler f5051f;

    /* JADX INFO: renamed from: g */
    final C4205c f5052g;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.h$a */
    private static class a extends Handler {

        /* JADX INFO: renamed from: a */
        private final C4210h f5053a;

        a(Looper looper, C4210h c4210h) {
            super(looper);
            this.f5053a = c4210h;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f5053a.m3535d((AbstractC4203a) message.obj);
                    break;
                case 2:
                    this.f5053a.m3536d((RunnableC4216n) message.obj);
                    break;
                case 3:
                    this.f5053a.m3537e((RunnableC4216n) message.obj);
                    break;
                case 4:
                    this.f5053a.m3530b((C4206d) message.obj);
                    break;
                case 5:
                    this.f5053a.m3531b((RunnableC4207e) message.obj);
                    break;
                case 6:
                    this.f5053a.m3533c((AbstractC4203a) message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.h$b */
    static class b extends HandlerThread {
        public b() {
            super("mcsdk_image_thread", 10);
        }
    }

    C4210h(Context context, ExecutorService executorService, Handler handler, C4205c c4205c) {
        b bVar = new b();
        this.f5047b = bVar;
        bVar.start();
        this.f5048c = context;
        this.f5049d = executorService;
        this.f5046a = new LinkedHashMap();
        this.f5050e = new a(bVar.getLooper(), this);
        this.f5051f = handler;
        this.f5052g = c4205c;
    }

    /* JADX INFO: renamed from: a */
    private void m3525a(RunnableC4216n runnableC4216n) {
        if (runnableC4216n.m3558j()) {
            return;
        }
        AbstractC4223u.b bVarM3557i = runnableC4216n.m3557i();
        if (bVarM3557i != null && bVarM3557i.m3622d()) {
            bVarM3557i.m3619a().prepareToDraw();
        }
        Handler handler = this.f5051f;
        handler.sendMessage(handler.obtainMessage(2, runnableC4216n));
    }

    /* JADX INFO: renamed from: b */
    public void m3532b(RunnableC4216n runnableC4216n) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(2, runnableC4216n));
    }

    /* JADX INFO: renamed from: c */
    public void m3534c(RunnableC4216n runnableC4216n) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(3, runnableC4216n));
    }

    /* JADX INFO: renamed from: d */
    void m3536d(RunnableC4216n runnableC4216n) {
        if (C4221s.b.m3599b(runnableC4216n.f5071f.f5110d)) {
            AbstractC4223u.b bVar = runnableC4216n.f5074i;
            if (bVar.m3622d()) {
                this.f5052g.m3516a(runnableC4216n.m3556h(), bVar.m3619a());
            }
        }
        this.f5046a.remove(runnableC4216n.m3556h());
        m3525a(runnableC4216n);
    }

    /* JADX INFO: renamed from: e */
    void m3537e(RunnableC4216n runnableC4216n) {
        this.f5046a.remove(runnableC4216n.m3556h());
        m3525a(runnableC4216n);
    }

    /* JADX INFO: renamed from: a */
    public void m3527a(C4206d c4206d) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(4, c4206d));
    }

    /* JADX INFO: renamed from: b */
    public void m3529b(AbstractC4203a abstractC4203a) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(1, abstractC4203a));
    }

    /* JADX INFO: renamed from: c */
    void m3533c(AbstractC4203a abstractC4203a) {
        String strM3502c = abstractC4203a.m3502c();
        RunnableC4216n runnableC4216n = this.f5046a.get(strM3502c);
        if (runnableC4216n != null) {
            runnableC4216n.m3550b(abstractC4203a);
            if (runnableC4216n.m3548a()) {
                this.f5046a.remove(strM3502c);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m3535d(AbstractC4203a abstractC4203a) {
        RunnableC4216n runnableC4216n = this.f5046a.get(abstractC4203a.m3502c());
        if (runnableC4216n != null) {
            runnableC4216n.m3547a(abstractC4203a);
        } else {
            if (this.f5049d.isShutdown()) {
                C4170g.m3202a(f5045n, "ExecutorService is shutdown.  Ignoring request.", new Object[0]);
                return;
            }
            RunnableC4216n runnableC4216nM3544a = RunnableC4216n.m3544a(abstractC4203a.m3501b(), this, this.f5052g, abstractC4203a);
            runnableC4216nM3544a.f5075j = this.f5049d.submit(runnableC4216nM3544a);
            this.f5046a.put(abstractC4203a.m3502c(), runnableC4216nM3544a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3526a(AbstractC4203a abstractC4203a) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(6, abstractC4203a));
    }

    /* JADX INFO: renamed from: b */
    void m3530b(C4206d c4206d) {
        if (this.f5049d.isShutdown()) {
            C4170g.m3202a(f5045n, "ExecutorService is shutdown.  Ignoring request.", new Object[0]);
        } else {
            this.f5049d.submit(new RunnableC4207e(this, c4206d));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3528a(RunnableC4207e runnableC4207e) {
        Handler handler = this.f5050e;
        handler.sendMessage(handler.obtainMessage(5, runnableC4207e));
    }

    /* JADX INFO: renamed from: b */
    void m3531b(RunnableC4207e runnableC4207e) {
        Handler handler = this.f5051f;
        handler.sendMessage(handler.obtainMessage(5, runnableC4207e));
    }
}
