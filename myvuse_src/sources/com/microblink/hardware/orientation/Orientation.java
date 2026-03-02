package com.microblink.hardware.orientation;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum Orientation {
    ORIENTATION_PORTRAIT(0, true, false),
    ORIENTATION_LANDSCAPE_RIGHT(1, false, true),
    ORIENTATION_PORTRAIT_UPSIDE(2, true, false),
    ORIENTATION_LANDSCAPE_LEFT(3, false, true),
    ORIENTATION_UNKNOWN(4, false, false);

    private boolean IlIllIlIIl;
    private boolean IllIIIllII;
    private int llIIlIlIIl;

    Orientation(int i, boolean z, boolean z2) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = z;
        this.IllIIIllII = z2;
    }

    public static Orientation fromActivityInfoCode(int i) {
        return i != 0 ? i != 1 ? i != 8 ? i != 9 ? ORIENTATION_PORTRAIT : ORIENTATION_PORTRAIT_UPSIDE : ORIENTATION_LANDSCAPE_LEFT : ORIENTATION_PORTRAIT : ORIENTATION_LANDSCAPE_RIGHT;
    }

    public static Orientation fromInt(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? ORIENTATION_UNKNOWN : ORIENTATION_LANDSCAPE_LEFT : ORIENTATION_PORTRAIT_UPSIDE : ORIENTATION_LANDSCAPE_RIGHT : ORIENTATION_PORTRAIT;
    }

    public int intValue() {
        return this.llIIlIlIIl;
    }

    public boolean isHorizontal() {
        return this.IllIIIllII;
    }

    public boolean isVertical() {
        return this.IlIllIlIIl;
    }

    public Orientation rotate180() {
        return fromInt((this.llIIlIlIIl + 2) % 4);
    }

    public Orientation rotate90Clockwise() {
        return fromInt((this.llIIlIlIIl + 3) % 4);
    }

    public Orientation rotate90CounterClockwise() {
        return fromInt((this.llIIlIlIIl + 1) % 4);
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.llIIlIlIIl;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Unknown" : "Landscape left" : "Inverse portrait" : "Landscape right" : "Portrait";
    }
}
