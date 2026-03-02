package com.yoti.mobile.android.common.p049ui.widgets.progress;

import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
public class ProgressSpinnerScheduler {

    /* JADX INFO: renamed from: a */
    private InterfaceC4561d f6464a;

    /* JADX INFO: renamed from: b */
    private Handler f6465b;

    /* JADX INFO: renamed from: c */
    private long f6466c;

    /* JADX INFO: renamed from: d */
    private Runnable f6467d = new RunnableC4558a();

    /* JADX INFO: renamed from: e */
    private Runnable f6468e = new RunnableC4559b();

    /* JADX INFO: renamed from: f */
    private Runnable f6469f = new RunnableC4560c();

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.progress.ProgressSpinnerScheduler$a */
    class RunnableC4558a implements Runnable {
        RunnableC4558a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressSpinnerScheduler.this.f6464a.addTransparentLayerForProgress();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.progress.ProgressSpinnerScheduler$b */
    class RunnableC4559b implements Runnable {
        RunnableC4559b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressSpinnerScheduler.this.f6464a.showSpinnerProgress();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.progress.ProgressSpinnerScheduler$c */
    class RunnableC4560c implements Runnable {
        RunnableC4560c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressSpinnerScheduler.this.f6464a.removeSpinnerProgress();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.progress.ProgressSpinnerScheduler$d */
    interface InterfaceC4561d {
        void addTransparentLayerForProgress();

        void removeSpinnerProgress();

        void showSpinnerProgress();
    }

    public ProgressSpinnerScheduler(InterfaceC4561d interfaceC4561d, Handler handler) {
        this.f6464a = interfaceC4561d;
        this.f6465b = handler;
    }

    public void startProgress() {
        this.f6465b.removeCallbacks(this.f6469f);
        this.f6465b.removeCallbacks(this.f6468e);
        this.f6465b.post(this.f6467d);
        this.f6466c = System.currentTimeMillis();
        this.f6465b.postDelayed(this.f6468e, 500L);
    }

    public void stopProgress() {
        if (this.f6466c + 500 > System.currentTimeMillis()) {
            stopProgressImmediate();
            return;
        }
        long jCurrentTimeMillis = (this.f6466c + 1550) - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            this.f6465b.postDelayed(this.f6469f, jCurrentTimeMillis);
        } else {
            this.f6465b.post(this.f6469f);
        }
    }

    public void stopProgressImmediate() {
        this.f6465b.removeCallbacks(this.f6467d);
        this.f6465b.removeCallbacks(this.f6468e);
        this.f6465b.post(this.f6469f);
    }
}
