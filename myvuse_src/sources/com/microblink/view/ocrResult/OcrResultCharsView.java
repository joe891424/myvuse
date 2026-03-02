package com.microblink.view.ocrResult;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.microblink.library.C3714R;
import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrResultCharsView extends View implements IOcrResultView {
    private int IIlIIIllIl;
    private int IlIllIlIIl;
    private ArgbEvaluator IllIIIIllI;
    private int IllIIIllII;
    private int lIIIIIllll;
    private int lIlIIIIlIl;
    private Paint llIIIlllll;
    private int llIIlIIlll;
    private ConcurrentMap<String, DisplayableOcrResult> llIIlIlIIl;

    public OcrResultCharsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.llIIlIlIIl = new ConcurrentHashMap();
        this.IlIllIlIIl = -1;
        this.IllIIIllII = -1;
        this.llIIIlllll = null;
        this.IllIIIIllI = new ArgbEvaluator();
        this.lIlIIIIlIl = SupportMenu.CATEGORY_MASK;
        this.llIIlIIlll = -16711936;
        this.IIlIIIllIl = InputDeviceCompat.SOURCE_ANY;
        this.lIIIIIllll = 1;
        setBackgroundColor(0);
        Paint paint = new Paint(1);
        this.llIIIlllll = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.llIIIlllll.setTextAlign(Paint.Align.LEFT);
        this.llIIIlllll.setTypeface(Typeface.DEFAULT_BOLD);
        this.llIIIlllll.setShadowLayer(10.0f, 2.0f, 2.0f, -16777216);
        Resources resources = context.getResources();
        this.lIlIIIIlIl = resources.getColor(C3714R.color.mb_min_quality_ocr_color);
        this.IIlIIIllIl = resources.getColor(C3714R.color.mb_med_quality_ocr_color);
        this.llIIlIIlll = resources.getColor(C3714R.color.mb_max_quality_ocr_color);
        this.lIIIIIllll = i;
        setLayerType(1, this.llIIIlllll);
    }

    @Override // com.microblink.view.ocrResult.IOcrResultView
    public void addOcrResult(DisplayableOcrResult displayableOcrResult) {
        this.llIIlIlIIl.put(displayableOcrResult.getResultName(), displayableOcrResult);
        postInvalidate();
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public void clearDisplayedContent() {
        this.llIIlIlIIl.clear();
        postInvalidate();
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public View getView() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x018e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.view.ocrResult.OcrResultCharsView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IlIllIlIIl = getWidth();
        this.IllIIIllII = getHeight();
        Log.m2713v(this, "OCR view layouting to size: {}x{}", Integer.valueOf(this.IlIllIlIIl), Integer.valueOf(this.IllIIIllII));
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
}
