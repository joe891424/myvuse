package com.microblink.blinkid.secured;

import android.graphics.Bitmap;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllIIIlIlI {
    public final int IlIllIlIIl;
    public final int IllIIIllII;
    public final Bitmap llIIlIlIIl;

    public lllIIIlIlI(Bitmap bitmap, int i, int i2) {
        this.llIIlIlIIl = bitmap;
        this.IlIllIlIIl = i;
        this.IllIIIllII = i2;
    }

    public static lllIIIlIlI llIIlIlIIl(Image image, int i) {
        Bitmap bitmapConvertToBitmap = image.convertToBitmap();
        Orientation imageOrientation = image.getImageOrientation();
        return new lllIIIlIlI(bitmapConvertToBitmap, imageOrientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT ? 1 : imageOrientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE ? 6 : imageOrientation == Orientation.ORIENTATION_LANDSCAPE_LEFT ? 3 : imageOrientation == Orientation.ORIENTATION_PORTRAIT ? 8 : 0, i);
    }
}
