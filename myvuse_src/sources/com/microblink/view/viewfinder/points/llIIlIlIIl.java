package com.microblink.view.viewfinder.points;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.microblink.view.viewfinder.points.PointSetView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIlIlIIl implements Runnable {
    final /* synthetic */ PointSetView llIIlIlIIl;

    llIIlIlIIl(PointSetView pointSetView) {
        this.llIIlIlIIl = pointSetView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.llIIlIlIIl.llIIlIIlll != null) {
            this.llIIlIlIIl.llIIlIIlll.cancel();
        }
        PointSetView pointSetView = this.llIIlIlIIl;
        PointSetView.IlIllIlIIl ilIllIlIIl = new PointSetView.IlIllIlIIl(pointSetView, null);
        PointSetView pointSetView2 = this.llIIlIlIIl;
        PointSetView.llIIlIlIIl lliililiil = new PointSetView.llIIlIlIIl(pointSetView2, pointSetView2.lllIIIlIlI, this.llIIlIlIIl.lIIIIIllll);
        PointSetView pointSetView3 = this.llIIlIlIIl;
        pointSetView.llIIlIIlll = ValueAnimator.ofObject(ilIllIlIIl, lliililiil, new PointSetView.llIIlIlIIl(pointSetView3, pointSetView3.lIIIIIllll, this.llIIlIlIIl.lllIIIlIlI));
        this.llIIlIlIIl.llIIlIIlll.setDuration(250L);
        this.llIIlIlIIl.llIIlIIlll.setInterpolator(new AccelerateDecelerateInterpolator());
        this.llIIlIlIIl.llIIlIIlll.addUpdateListener(this.llIIlIlIIl);
        this.llIIlIlIIl.llIIlIIlll.start();
    }
}
