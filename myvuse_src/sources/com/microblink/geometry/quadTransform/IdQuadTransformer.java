package com.microblink.geometry.quadTransform;

import com.microblink.geometry.Quadrilateral;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IdQuadTransformer implements IQuadTransformer {
    Orientation IlIllIlIIl;
    float llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.geometry.quadTransform.IdQuadTransformer$1 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C37111 {
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
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public IdQuadTransformer(float f, Orientation orientation) {
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = orientation;
    }

    public Orientation getCurrentOrientation() {
        return this.IlIllIlIIl;
    }

    public void setOrientation(Orientation orientation) {
        if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            return;
        }
        this.IlIllIlIIl = orientation;
    }

    @Override // com.microblink.geometry.quadTransform.IQuadTransformer
    public Quadrilateral transformQuad(Quadrilateral quadrilateral) {
        int i = C37111.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
        if (i == 1) {
            return new Quadrilateral(quadrilateral.getUpperLeft(), quadrilateral.getUpperRight(), quadrilateral.getLowerLeft().operatorPlus(quadrilateral.getUpperLeft().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerRight().operatorPlus(quadrilateral.getUpperRight().operatorMinus(quadrilateral.getLowerRight()).operatorMultiply(this.llIIlIlIIl)));
        }
        if (i == 2) {
            return new Quadrilateral(quadrilateral.getUpperLeft().operatorPlus(quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getUpperRight().operatorPlus(quadrilateral.getLowerRight().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerLeft(), quadrilateral.getLowerRight());
        }
        if (i == 3) {
            return new Quadrilateral(quadrilateral.getUpperLeft().operatorPlus(quadrilateral.getUpperRight().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getUpperRight(), quadrilateral.getLowerLeft().operatorPlus(quadrilateral.getLowerRight().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerRight());
        }
        if (i != 4) {
            if (i != 5) {
                return null;
            }
            Log.m2709e(this, "Illegal orientation set as current orientation!", new Object[0]);
            return null;
        }
        return new Quadrilateral(quadrilateral.getUpperLeft(), quadrilateral.getUpperRight().operatorPlus(quadrilateral.getUpperLeft().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl)), quadrilateral.getLowerLeft(), quadrilateral.getLowerRight().operatorPlus(quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getLowerRight()).operatorMultiply(this.llIIlIlIIl)));
    }
}
