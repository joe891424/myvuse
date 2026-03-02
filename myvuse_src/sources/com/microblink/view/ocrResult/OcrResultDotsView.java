package com.microblink.view.ocrResult;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.microblink.geometry.Point;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.library.C3714R;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.results.ocr.CharWithVariants;
import com.microblink.results.ocr.OcrBlock;
import com.microblink.results.ocr.OcrLine;
import com.microblink.view.viewfinder.points.IDisplayablePointsView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrResultDotsView extends ViewGroup implements IOcrResultView, IDisplayablePointsView, OrientationChangeListener {
    public static final int DEFAULT_NUMBER_OF_DOTS = 50;
    private int IIlIIIllIl;
    private final Handler IlIllIlIIl;
    private boolean IlIllIlllI;
    private final ImageView[] IllIIIIllI;
    private final int IllIIIllII;
    private int lIIIIIllll;
    private final SecureRandom lIlIIIIlIl;
    private final int llIIIlllll;
    private int llIIlIIlll;
    private final ConcurrentLinkedQueue<Pair<Point, Long>> llIIlIlIIl;
    private Orientation lllIIIlIlI;

    /* JADX INFO: renamed from: com.microblink.view.ocrResult.OcrResultDotsView$4 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C37264 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[Orientation.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[Orientation.ORIENTATION_PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_PORTRAIT_UPSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public OcrResultDotsView(Context context, int i, Orientation orientation) {
        this(context, i, orientation, 50);
    }

    @Override // com.microblink.view.viewfinder.points.IDisplayablePointsView
    public void addDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("method is intended to be called from non-UI thread");
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Iterator<Point> it2 = displayablePointsDetection.getTransformedPointSet().getPoints().iterator();
        while (it2.hasNext()) {
            this.llIIlIlIIl.add(new Pair<>(it2.next(), lValueOf));
        }
        llIIlIlIIl();
    }

    @Override // com.microblink.view.ocrResult.IOcrResultView
    public void addOcrResult(DisplayableOcrResult displayableOcrResult) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("method is intended to be called from non-UI thread");
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        OcrBlock[] blocks = displayableOcrResult.getOcrResult().getBlocks();
        if (blocks != null) {
            for (OcrBlock ocrBlock : blocks) {
                OcrLine[] lines = ocrBlock.getLines();
                if (lines != null) {
                    for (OcrLine ocrLine : lines) {
                        CharWithVariants[] chars = ocrLine.getChars();
                        if (chars != null) {
                            for (int i = 1; i < chars.length - 1; i++) {
                                RectF rectF = chars[i].getChar().getPosition().toRectF();
                                displayableOcrResult.getTransformMatrix().mapRect(rectF);
                                this.llIIlIlIIl.add(new Pair<>(new Point(rectF.centerX(), rectF.centerY()), lValueOf));
                            }
                        }
                    }
                }
            }
        }
        llIIlIlIIl();
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public void clearDisplayedContent() {
        this.llIIlIlIIl.clear();
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = (int) (this.llIIIlllll * 0.04761905f);
        this.llIIlIIlll = getWidth();
        this.IIlIIIllIl = getHeight();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i7 = i5 / 2;
                childAt.layout(i - i7, i2 - i7, i + i7, i7 + i2);
            }
        }
    }

    @Override // com.microblink.hardware.orientation.OrientationChangeListener
    public void onOrientationChange(Orientation orientation) {
        this.lllIIIlIlI = orientation;
    }

    @Override // com.microblink.view.viewfinder.points.IDisplayablePointsView
    public void setDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        this.llIIlIlIIl.clear();
        addDisplayablePointsDetection(displayablePointsDetection);
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public void setHostActivityOrientation(int i) {
        this.lIIIIIllll = i;
    }

    @Override // com.microblink.view.ocrResult.IOcrResultView
    public void setOcrResult(DisplayableOcrResult displayableOcrResult) {
        this.llIIlIlIIl.clear();
        addOcrResult(displayableOcrResult);
    }

    public OcrResultDotsView(Context context, int i, Orientation orientation, int i2) {
        super(context);
        this.llIIlIlIIl = new ConcurrentLinkedQueue<>();
        this.llIIlIIlll = -1;
        this.IIlIIIllIl = -1;
        this.lIIIIIllll = 1;
        this.lllIIIlIlI = Orientation.ORIENTATION_PORTRAIT;
        this.IlIllIlllI = false;
        setBackgroundColor(0);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("View must be created from main thread");
        }
        if (i2 <= 0) {
            throw new RuntimeException("mNumberOfDots parameter must be positive number");
        }
        this.IllIIIllII = i2;
        this.lIlIIIIlIl = new SecureRandom();
        this.IlIllIlIIl = new Handler();
        this.lIIIIIllll = i;
        if (orientation != null && orientation != Orientation.ORIENTATION_UNKNOWN) {
            this.lllIIIlIlI = orientation;
        }
        this.llIIIlllll = context.getResources().getDisplayMetrics().densityDpi;
        Bitmap bitmapDecodeResource = BitmapFactoryInstrumentation.decodeResource(context.getResources(), C3714R.drawable.mb_dot);
        this.IllIIIIllI = new ImageView[i2];
        for (int i3 = 0; i3 < this.IllIIIllII; i3++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(bitmapDecodeResource);
            imageView.setVisibility(4);
            this.IllIIIIllI[i3] = imageView;
            addView(imageView);
        }
    }

    private void llIIlIlIIl() {
        if (this.IlIllIlllI || this.llIIlIlIIl.isEmpty()) {
            return;
        }
        this.IlIllIlllI = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        while (true) {
            Pair<Point, Long> pairPoll = this.llIIlIlIIl.poll();
            if (pairPoll == null) {
                break;
            } else if (((Long) pairPoll.second).longValue() + 1500 > jCurrentTimeMillis) {
                arrayList.add((Point) pairPoll.first);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        while (arrayList.size() > this.IllIIIllII) {
            arrayList.remove(this.lIlIIIIlIl.nextInt(arrayList.size()));
        }
        float[] fArr = new float[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            Point point = (Point) arrayList.get(i);
            int i2 = i * 2;
            fArr[i2] = point.getX();
            fArr[i2 + 1] = point.getY();
        }
        llIIlIlIIl(fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void llIIlIlIIl(float[] r18) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.view.ocrResult.OcrResultDotsView.llIIlIlIIl(float[]):void");
    }
}
