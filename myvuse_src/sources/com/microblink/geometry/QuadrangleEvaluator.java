package com.microblink.geometry;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class QuadrangleEvaluator implements TypeEvaluator<Quadrilateral> {
    private ArgbEvaluator llIIlIlIIl = new ArgbEvaluator();
    private Quadrilateral IlIllIlIIl = new Quadrilateral();

    @Override // android.animation.TypeEvaluator
    public Quadrilateral evaluate(float f, Quadrilateral quadrilateral, Quadrilateral quadrilateral2) {
        int iIntValue = ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(quadrilateral.getColor()), Integer.valueOf(quadrilateral2.getColor()))).intValue();
        Point pointMakeCopy = quadrilateral2.getUpperLeft().makeCopy();
        pointMakeCopy.operatorMinusEquals(quadrilateral.getUpperLeft()).operatorMultiplyEquals(f);
        Point pointMakeCopy2 = quadrilateral2.getUpperRight().makeCopy();
        pointMakeCopy2.operatorMinusEquals(quadrilateral.getUpperRight()).operatorMultiplyEquals(f);
        Point pointMakeCopy3 = quadrilateral2.getLowerLeft().makeCopy();
        pointMakeCopy3.operatorMinusEquals(quadrilateral.getLowerLeft()).operatorMultiplyEquals(f);
        Point pointMakeCopy4 = quadrilateral2.getLowerRight().makeCopy();
        pointMakeCopy4.operatorMinusEquals(quadrilateral.getLowerRight()).operatorMultiplyEquals(f);
        this.IlIllIlIIl.setPoints(quadrilateral.getUpperLeft().operatorPlus(pointMakeCopy), quadrilateral.getUpperRight().operatorPlus(pointMakeCopy2), quadrilateral.getLowerLeft().operatorPlus(pointMakeCopy3), quadrilateral.getLowerRight().operatorPlus(pointMakeCopy4));
        this.IlIllIlIIl.setColor(iIntValue);
        if (quadrilateral2.isDefaultQuad() && (f > 0.95d || quadrilateral.isDefaultQuad())) {
            this.IlIllIlIIl.setIsDefaultQuad(true);
        }
        return this.IlIllIlIIl;
    }
}
