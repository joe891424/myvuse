package com.microblink.view.viewfinder.quadview;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.microblink.blinkid.secured.IIIlllIlII;
import com.microblink.blinkid.secured.IlIIllIIII;
import com.microblink.blinkid.secured.IllIIlIIIl;
import com.microblink.blinkid.secured.lIllIlIlIl;
import com.microblink.library.C3714R;
import com.microblink.view.recognition.RecognizerRunnerView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class QuadViewManagerFactory {

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[QuadViewPreset.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[QuadViewPreset.DEFAULT_CORNERS_FROM_PHOTOPAY_ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[QuadViewPreset.DEFAULT_CORNERS_FROM_BARCODE_SCAN_ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[QuadViewPreset.DEFAULT_FROM_OCR_LINE_SCAN_ACTIVITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[QuadViewPreset.DEFAULT_FROM_OCR_LINE_SCAN_ACTIVITY_WITH_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                llIIlIlIIl[QuadViewPreset.DEFAULT_FROM_DOCUMENT_SCAN_ACTIVITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                llIIlIlIIl[QuadViewPreset.DEFAULT_DOCUMENT_DETECTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static QuadViewManager createDocumentDetectionQuadViewManager(RecognizerRunnerView recognizerRunnerView, int i) {
        IllIIlIIIl illIIlIIIl = new IllIIlIIIl(recognizerRunnerView.getContext(), new IIIlllIlII(), 0.5d, 0.5d, recognizerRunnerView.getHostScreenOrientation());
        illIIlIIIl.setMovable(true);
        illIIlIIIl.setAnimationDuration(200L);
        illIIlIIIl.setDefaultQuadColor(Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)));
        illIIlIIIl.setDetectedQuadColor(i);
        illIIlIIIl.llIIlIlIIl(true);
        recognizerRunnerView.addChildView(illIIlIIIl, false, 0);
        return new QuadViewManager(illIIlIIIl);
    }

    public static QuadViewManager createQuadViewFromPreset(RecognizerRunnerView recognizerRunnerView, QuadViewPreset quadViewPreset) {
        Context context = recognizerRunnerView.getContext();
        switch (llIIlIlIIl.llIIlIlIIl[quadViewPreset.ordinal()]) {
            case 1:
                IlIIllIIII ilIIllIIII = new IlIIllIIII(context);
                ilIIllIIII.llIIlIlIIl(0.05f);
                ilIIllIIII.llIIlIlIIl(54);
                IllIIlIIIl illIIlIIIl = new IllIIlIIIl(context, ilIIllIIII, 0.25d, 0.25d, recognizerRunnerView.getHostScreenOrientation());
                illIIlIIIl.setMovable(true);
                illIIlIIIl.setAnimationDuration(200L);
                recognizerRunnerView.addChildView(illIIlIIIl, false, 0);
                return new QuadViewManager(illIIlIIIl);
            case 2:
                IlIIllIIII ilIIllIIII2 = new IlIIllIIII(context);
                ilIIllIIII2.llIIlIlIIl(0.05f);
                ilIIllIIII2.llIIlIlIIl(54);
                IllIIlIIIl illIIlIIIl2 = new IllIIlIIIl(context, ilIIllIIII2, 0.25d, 0.25d, recognizerRunnerView.getHostScreenOrientation());
                illIIlIIIl2.setAnimationDuration(150L);
                recognizerRunnerView.addChildView(illIIlIIIl2, false, 0);
                return new QuadViewManager(illIIlIIIl2);
            case 3:
                IllIIlIIIl illIIlIIIl3 = new IllIIlIIIl(context, new lIllIlIlIl(), 0.2d, 0.0d, recognizerRunnerView.getHostScreenOrientation());
                illIIlIIIl3.setMovable(true);
                illIIlIIIl3.setAnimationDuration(200L);
                recognizerRunnerView.addChildView(illIIlIIIl3, false, 0);
                return new QuadViewManager(illIIlIIIl3);
            case 4:
                IllIIlIIIl illIIlIIIl4 = new IllIIlIIIl(context, new lIllIlIlIl(), 0.4d, 0.0d, recognizerRunnerView.getHostScreenOrientation());
                illIIlIIIl4.setMovable(true);
                illIIlIIIl4.setAnimationDuration(200L);
                recognizerRunnerView.addChildView(illIIlIIIl4, false, 0);
                return new QuadViewManager(illIIlIIIl4);
            case 5:
                com.microblink.view.viewfinder.quadview.llIIlIlIIl lliililiil = new com.microblink.view.viewfinder.quadview.llIIlIlIIl(0.63060747663d, 0.4d, 0.1d, recognizerRunnerView);
                lliililiil.llIIlIlIIl.setMovable(false);
                lliililiil.llIIlIlIIl.setAnimationDuration(0L);
                recognizerRunnerView.addChildView(lliililiil.llIIlIlIIl, false, 0);
                return lliililiil;
            case 6:
                return createDocumentDetectionQuadViewManager(recognizerRunnerView, ContextCompat.getColor(context, C3714R.color.mb_blue));
            default:
                return new QuadViewManager();
        }
    }
}
