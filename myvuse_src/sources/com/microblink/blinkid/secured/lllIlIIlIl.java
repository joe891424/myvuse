package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllIlIIlIl extends View {
    private double IlIllIlIIl;
    private int IllIIIIllI;
    private int IllIIIllII;
    lllllllIll lIlIIIIlIl;
    private int llIIIlllll;
    llIIllllII llIIlIIlll;
    private double llIIlIlIIl;

    public lllIlIIlIl(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.llIIlIlIIl = 0.11d;
        this.IlIllIlIIl = 0.11d;
        this.IllIIIllII = -1;
        this.llIIIlllll = -1;
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = new lllllllIll();
        this.llIIlIIlll = new llIIllllII();
        setBackgroundColor(0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.IllIIIllII == -1) {
            this.IllIIIllII = getWidth();
        }
        if (this.llIIIlllll == -1) {
            this.llIIIlllll = getHeight();
        }
        int i = this.IllIIIllII;
        int i2 = (int) ((1.0d - this.llIIlIlIIl) * ((double) i));
        int i3 = (int) ((1.0d - this.IlIllIlIIl) * ((double) this.llIIIlllll));
        this.IllIIIIllI = (i - i2) / 2;
        float f = i2;
        float f2 = 0.5f * f;
        float f3 = (20.0f * f2) / 160.0f;
        float f4 = f3 * 2.0f;
        float f5 = f2 / 10.0f;
        float f6 = (f - ((f4 + f5) + f2)) / 2.0f;
        float fRandom = ((i3 - f4) * ((float) Math.random())) + ((r3 - i3) / 2);
        int i4 = (int) f4;
        this.lIlIIIIlIl.llIIlIlIIl(canvas, (int) (this.IllIIIIllI + f6), (int) fRandom, i4, i4);
        this.llIIlIIlll.llIIlIlIIl(canvas, (int) (this.IllIIIIllI + f6 + f4 + f5), (int) ((fRandom - (f4 / 4.0f)) + f3), (int) f2, (int) f3);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IllIIIllII = getWidth();
        this.llIIIlllll = getHeight();
        Log.m2713v(this, "LogoOverlayView layouting to size: {}x{}", Integer.valueOf(this.IllIIIllII), Integer.valueOf(this.llIIIlllll));
    }
}
