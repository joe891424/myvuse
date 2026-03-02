package com.microblink.entities.recognizers.blinkid.imageoptions.extension;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ImageExtensionFactors {
    private float IlIllIlIIl;
    private float IllIIIllII;
    private float llIIIlllll;
    private float llIIlIlIIl;

    public ImageExtensionFactors(float f, float f2, float f3, float f4) {
        llIIlIlIIl(f);
        llIIlIlIIl(f2);
        llIIlIlIIl(f3);
        llIIlIlIIl(f4);
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = f2;
        this.llIIIlllll = f3;
        this.IllIIIllII = f4;
    }

    public static final ImageExtensionFactors createFromArray(float[] fArr) {
        if (fArr == null) {
            return new ImageExtensionFactors(0.0f, 0.0f, 0.0f, 0.0f);
        }
        if (fArr.length != 4) {
            throw new IllegalArgumentException("Expected array of 4 factors!");
        }
        for (float f : fArr) {
            llIIlIlIIl(f);
        }
        return new ImageExtensionFactors(fArr[0], fArr[2], fArr[3], fArr[1]);
    }

    private static final void llIIlIlIIl(float f) {
        double d = f;
        if (d > 1.0d || d < 0.0d) {
            throw new IllegalArgumentException("Extension factor must be in range [0.0, 1.0], current factor value: " + f);
        }
    }

    public float getDownFactor() {
        return this.IlIllIlIIl;
    }

    public float getLeftFactor() {
        return this.llIIIlllll;
    }

    public float getRightFactor() {
        return this.IllIIIllII;
    }

    public float getUpFactor() {
        return this.llIIlIlIIl;
    }

    public float[] serializeToArray() {
        return new float[]{this.llIIlIlIIl, this.IllIIIllII, this.IlIllIlIIl, this.llIIIlllll};
    }
}
