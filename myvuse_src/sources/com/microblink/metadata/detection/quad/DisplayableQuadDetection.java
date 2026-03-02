package com.microblink.metadata.detection.quad;

import com.microblink.geometry.Quadrilateral;
import com.microblink.metadata.detection.DisplayableDetection;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DisplayableQuadDetection extends DisplayableDetection {
    private Quadrilateral IllIIIllII;
    private Quadrilateral llIIIlllll;

    public DisplayableQuadDetection(int i, float[] fArr, float[] fArr2) {
        super(i, fArr);
        this.IllIIIllII = new Quadrilateral(fArr2);
    }

    public Quadrilateral getDisplayLocation() {
        return this.IllIIIllII;
    }

    public Quadrilateral getTransformedDisplayLocation() {
        if (this.llIIIlllll == null) {
            float[] fArr = new float[8];
            this.IllIIIllII.toFloatArray(fArr);
            this.llIIlIlIIl.mapPoints(fArr);
            this.llIIIlllll = new Quadrilateral(fArr);
        }
        return this.llIIIlllll;
    }
}
