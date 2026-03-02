package com.microblink.blinkid.secured;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.microblink.geometry.QuadrangleEvaluator;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlllIIlIIl implements Runnable {
    final /* synthetic */ IllIIlIIIl llIIlIlIIl;

    IlllIIlIIl(IllIIlIIIl illIIlIIIl) {
        this.llIIlIlIIl = illIIlIIIl;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.m2707d(this.llIIlIlIIl, "Starting quad animation", new Object[0]);
        if (this.llIIlIlIIl.llIIlIIIll != null) {
            this.llIIlIlIIl.llIIlIIIll.cancel();
        }
        this.llIIlIlIIl.llIIlIIIll = ValueAnimator.ofObject(new QuadrangleEvaluator(), this.llIIlIlIIl.lllIIIlIlI, this.llIIlIlIIl.IlIllIlllI);
        this.llIIlIlIIl.llIIlIIIll.setDuration(this.llIIlIlIIl.lIIIIIllll);
        this.llIIlIlIIl.llIIlIIIll.setInterpolator(new AccelerateDecelerateInterpolator());
        this.llIIlIlIIl.llIIlIIIll.addUpdateListener(this.llIIlIlIIl);
        this.llIIlIlIIl.llIIlIIIll.addListener(this.llIIlIlIIl.IlIIlIIIII);
        this.llIIlIlIIl.llIIlIIIll.start();
    }
}
