package com.microblink.blinkid.secured;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllllllIll {
    private static final float[] lllIIIlIlI = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private Path IIlIIIllIl;
    private Paint IlIllIlIIl;
    private Matrix IllIIIIllI;
    private Typeface IllIIIllII;
    private Matrix lIIIIIllll;
    private Matrix lIlIIIIlIl;
    private Paint llIIIlllll;
    private Paint llIIlIIlll;
    private boolean llIIlIlIIl;

    public void llIIlIlIIl(Canvas canvas, int i, int i2, int i3, int i4) {
        if (!this.llIIlIlIIl) {
            this.llIIlIlIIl = true;
            this.IlIllIlIIl = new Paint();
            this.IllIIIllII = Typeface.create(Typeface.SERIF, 0);
            this.llIIIlllll = new Paint();
            this.IllIIIIllI = new Matrix();
            this.llIIlIIlll = new Paint();
            this.IIlIIIllIl = new Path();
            this.lIIIIIllll = new Matrix();
        }
        canvas.save();
        canvas.translate(i, i2);
        canvas.scale(i3 / 28.0f, i4 / 28.0f);
        this.IlIllIlIIl.reset();
        this.IlIllIlIIl.setFlags(129);
        this.IlIllIlIIl.setStyle(Paint.Style.FILL);
        this.IlIllIlIIl.setTypeface(Typeface.DEFAULT);
        this.IlIllIlIIl.setColor(-16777216);
        this.IlIllIlIIl.setTextSize(16.0f);
        this.IlIllIlIIl.setTypeface(this.IllIIIllII);
        this.IlIllIlIIl.setStrikeThruText(false);
        this.IlIllIlIIl.setUnderlineText(false);
        canvas.save();
        this.llIIIlllll.reset();
        this.llIIIlllll.set(this.IlIllIlIIl);
        this.llIIIlllll.setColor(0);
        this.IllIIIIllI.reset();
        canvas.concat(this.IllIIIIllI);
        this.lIlIIIIlIl = canvas.getMatrix();
        canvas.save();
        this.llIIlIIlll.reset();
        this.llIIlIIlll.set(this.llIIIlllll);
        this.llIIlIIlll.setColor(-16751886);
        this.IIlIIIllIl.reset();
        this.IIlIIIllIl.moveTo(24.3827f, 5.07476f);
        this.IIlIIIllIl.lineTo(27.551498f, 12.9832f);
        this.IIlIIIllIl.cubicTo(27.6857f, 13.3175f, 27.752499f, 13.6749f, 27.748299f, 14.0351f);
        this.IIlIIIllIl.cubicTo(27.7442f, 14.3953f, 27.669f, 14.7511f, 27.527f, 15.0822f);
        this.IIlIIIllIl.lineTo(24.1737f, 22.916899f);
        this.IIlIIIllIl.cubicTo(24.0322f, 23.2477f, 23.826899f, 23.5473f, 23.5695f, 23.7987f);
        this.IIlIIIllIl.cubicTo(23.312199f, 24.0501f, 23.0079f, 24.248299f, 22.673899f, 24.3821f);
        this.IIlIIIllIl.lineTo(14.7627f, 27.551498f);
        this.IIlIIIllIl.cubicTo(14.428699f, 27.6854f, 14.0716f, 27.752f, 13.7118f, 27.748001f);
        this.IIlIIIllIl.cubicTo(13.3519f, 27.7437f, 12.9964f, 27.668798f, 12.6656f, 27.527f);
        this.IIlIIIllIl.lineTo(4.83068f, 24.173199f);
        this.IIlIIIllIl.cubicTo(4.16282f, 23.8871f, 3.63581f, 23.3477f, 3.36545f, 22.673399f);
        this.IIlIIIllIl.lineTo(0.196661f, 14.7624f);
        this.IIlIIIllIl.cubicTo(0.062792f, 14.428499f, -0.003994f, 14.0715f, 1.85E-4f, 13.7118f);
        this.IIlIIIllIl.cubicTo(0.004364f, 13.352f, 0.079419f, 12.996599f, 0.22101f, 12.665899f);
        this.IIlIIIllIl.lineTo(3.57439f, 4.83055f);
        this.IIlIIIllIl.cubicTo(3.86042f, 4.16274f, 4.39988f, 3.63576f, 5.07423f, 3.3654f);
        this.IIlIIIllIl.lineTo(12.985399f, 0.196649f);
        this.IIlIIIllIl.cubicTo(13.3194f, 0.062764f, 13.6766f, -0.003994f, 14.0364f, 1.85E-4f);
        this.IIlIIIllIl.cubicTo(14.396299f, 0.004364f, 14.7518f, 0.079399f, 15.0826f, 0.221005f);
        this.IIlIIIllIl.lineTo(22.9174f, 3.57434f);
        this.IIlIIIllIl.cubicTo(23.248299f, 3.7159f, 23.548f, 3.92126f, 23.7994f, 4.17871f);
        this.IIlIIIllIl.cubicTo(24.0508f, 4.43618f, 24.249f, 4.74065f, 24.3827f, 5.07476f);
        this.IIlIIIllIl.close();
        this.IIlIIIllIl.moveTo(19.824799f, 19.3016f);
        this.IIlIIIllIl.cubicTo(20.4343f, 18.988f, 21.0992f, 18.645899f, 21.828499f, 18.246399f);
        this.IIlIIIllIl.cubicTo(23.0303f, 17.5914f, 23.9045f, 16.4588f, 24.126299f, 15.4231f);
        this.IIlIIIllIl.cubicTo(24.3699f, 14.3771f, 23.958399f, 13.428499f, 23.1328f, 12.9081f);
        this.IIlIIIllIl.cubicTo(21.248001f, 11.7008f, 20.4739f, 10.1963f, 19.3029f, 7.92072f);
        this.IIlIIIllIl.cubicTo(18.989399f, 7.31148f, 18.6475f, 6.647f, 18.2482f, 5.91812f);
        this.IIlIIIllIl.cubicTo(17.5964f, 4.71573f, 16.4638f, 3.84021f, 15.4281f, 3.62037f);
        this.IIlIIIllIl.cubicTo(14.382001f, 3.37619f, 13.433399f, 3.7883f, 12.913001f, 4.61382f);
        this.IIlIIIllIl.cubicTo(11.705899f, 6.49819f, 10.2019f, 7.27198f, 7.92703f, 8.4423f);
        this.IIlIIIllIl.cubicTo(7.31738f, 8.75595f, 6.65237f, 9.09808f, 5.92286f, 9.4977f);
        this.IIlIIIllIl.cubicTo(4.72045f, 10.153399f, 3.84554f, 11.2859f, 3.62504f, 12.3216f);
        this.IIlIIIllIl.cubicTo(3.38149f, 13.367001f, 3.79297f, 14.316199f, 4.61851f, 14.836f);
        this.IIlIIIllIl.cubicTo(6.50334f, 16.043299f, 7.27748f, 17.5478f, 8.44843f, 19.823399f);
        this.IIlIIIllIl.cubicTo(8.761909f, 20.4326f, 9.103829f, 21.0971f, 9.503119f, 21.826f);
        this.IIlIIIllIl.cubicTo(10.155001f, 23.028399f, 11.287499f, 23.9039f, 12.323299f, 24.1237f);
        this.IIlIIIllIl.cubicTo(13.3693f, 24.367899f, 14.3179f, 23.9564f, 14.8384f, 23.1309f);
        this.IIlIIIllIl.cubicTo(16.0455f, 21.2459f, 17.5497f, 20.4721f, 19.824799f, 19.3016f);
        this.IIlIIIllIl.close();
        this.lIIIIIllll.reset();
        this.lIlIIIIlIl.invert(this.lIIIIIllll);
        this.lIIIIIllll.preConcat(this.lIlIIIIlIl);
        this.lIIIIIllll.mapPoints(lllIIIlIlI);
        this.IIlIIIllIl.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(this.IIlIIIllIl, this.llIIlIIlll);
        canvas.restore();
        canvas.restore();
        canvas.restore();
    }
}
