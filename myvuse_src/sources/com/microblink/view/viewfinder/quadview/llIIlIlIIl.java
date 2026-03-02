package com.microblink.view.viewfinder.quadview;

import android.content.Context;
import com.microblink.blinkid.secured.IIlIIlIllI;
import com.microblink.blinkid.secured.IllIIlIIIl;
import com.microblink.blinkid.secured.IllIllIllI;
import com.microblink.geometry.quadTransform.IdQuadTransformer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.util.Log;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIIlIlIIl extends QuadViewManager implements OrientationChangeListener {
    private double IlIllIlIIl = 1.0d;
    private Context IllIIIIllI;
    private double[] IllIIIllII;
    private double[] llIIIlllll;

    /* JADX INFO: renamed from: com.microblink.view.viewfinder.quadview.llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
    /* JADX INFO: compiled from: line */
    class C5993llIIlIlIIl implements OnSizeChangedListener {
        C5993llIIlIlIIl() {
        }

        @Override // com.microblink.view.OnSizeChangedListener
        public void onSizeChanged(int i, int i2) {
            if (IIlIIlIllI.llIIlIlIIl(llIIlIlIIl.this.IllIIIIllI)) {
                llIIlIlIIl.this.IlIllIlIIl = ((double) i2) / ((double) i);
            } else {
                llIIlIlIIl.this.IlIllIlIIl = ((double) i) / ((double) i2);
            }
            llIIlIlIIl lliililiil = llIIlIlIIl.this;
            Log.m2711i(lliililiil, "Card quad view aspect ratio: {}", Double.valueOf(lliililiil.IlIllIlIIl));
            llIIlIlIIl.this.llIIIlllll[1] = 1.0d - (((1.0d - llIIlIlIIl.this.llIIIlllll[0]) * llIIlIlIIl.llIIIlllll(llIIlIlIIl.this)) / llIIlIlIIl.this.IlIllIlIIl);
            llIIlIlIIl.this.IllIIIllII[0] = 1.0d - (((1.0d - llIIlIlIIl.this.IllIIIllII[1]) * llIIlIlIIl.this.IlIllIlIIl) * llIIlIlIIl.llIIIlllll(llIIlIlIIl.this));
            llIIlIlIIl.this.llIIlIlIIl();
        }
    }

    public llIIlIlIIl(double d, double d2, double d3, RecognizerRunnerView recognizerRunnerView) {
        this.IllIIIllII = new double[]{d2, d2};
        this.llIIIlllll = new double[]{d3, d3};
        this.IllIIIIllI = recognizerRunnerView.getContext();
        int hostScreenOrientation = recognizerRunnerView.getHostScreenOrientation();
        Context context = this.IllIIIIllI;
        IllIllIllI illIllIllI = new IllIllIllI(new IdQuadTransformer(0.0f, llIIlIlIIl(hostScreenOrientation)), this.IllIIIIllI);
        double[] dArr = this.llIIIlllll;
        IllIIlIIIl illIIlIIIl = new IllIIlIIIl(context, illIllIllI, dArr[0], dArr[1], hostScreenOrientation);
        this.llIIlIlIIl = illIIlIIIl;
        illIIlIIIl.setMovable(true);
        this.llIIlIlIIl.setOnSizeChangedListener(new C5993llIIlIlIIl());
        recognizerRunnerView.addOrientationChangeListener(this);
    }

    static /* synthetic */ double llIIIlllll(llIIlIlIIl lliililiil) {
        lliililiil.getClass();
        return 0.63060747663d;
    }

    @Override // com.microblink.hardware.orientation.OrientationChangeListener
    public void onOrientationChange(Orientation orientation) {
        ((IdQuadTransformer) ((IllIllIllI) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).setOrientation(orientation);
        llIIlIlIIl();
    }

    @Override // com.microblink.view.viewfinder.quadview.QuadViewManager
    public void setInitialHostActivityOrientation(int i) {
        super.setInitialHostActivityOrientation(i);
        ((IdQuadTransformer) ((IllIllIllI) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).setOrientation(llIIlIlIIl(i));
    }

    private Orientation llIIlIlIIl(int i) {
        if (i == 0) {
            return Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        }
        if (i == 1) {
            return Orientation.ORIENTATION_PORTRAIT;
        }
        if (i == 8) {
            return Orientation.ORIENTATION_LANDSCAPE_LEFT;
        }
        if (i != 9) {
            return Orientation.ORIENTATION_UNKNOWN;
        }
        return Orientation.ORIENTATION_PORTRAIT_UPSIDE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl() {
        Orientation currentOrientation = ((IdQuadTransformer) ((IllIllIllI) this.llIIlIlIIl.getQuadDrawer()).IlIllIlIIl()).getCurrentOrientation();
        if (!IIlIIlIllI.llIIlIlIIl(this.IllIIIIllI)) {
            if (currentOrientation.isVertical()) {
                IllIIlIIIl illIIlIIIl = this.llIIlIlIIl;
                double[] dArr = this.llIIIlllll;
                illIIlIIIl.llIIlIlIIl(dArr[1], dArr[0]);
                return;
            } else {
                IllIIlIIIl illIIlIIIl2 = this.llIIlIlIIl;
                double[] dArr2 = this.IllIIIllII;
                illIIlIIIl2.llIIlIlIIl(dArr2[1], dArr2[0]);
                return;
            }
        }
        if (currentOrientation.isVertical()) {
            IllIIlIIIl illIIlIIIl3 = this.llIIlIlIIl;
            double[] dArr3 = this.llIIIlllll;
            illIIlIIIl3.llIIlIlIIl(dArr3[0], dArr3[1]);
        } else {
            IllIIlIIIl illIIlIIIl4 = this.llIIlIlIIl;
            double[] dArr4 = this.IllIIIllII;
            illIIlIIIl4.llIIlIlIIl(dArr4[0], dArr4[1]);
        }
    }
}
