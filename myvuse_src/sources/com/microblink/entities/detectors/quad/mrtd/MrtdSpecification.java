package com.microblink.entities.detectors.quad.mrtd;

import com.microblink.entities.detectors.quad.Specification;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class MrtdSpecification extends Specification {
    private MrtdSpecification(MrtdSpecificationPreset mrtdSpecificationPreset) {
        super(nativeCreateFromPreset(mrtdSpecificationPreset.ordinal()), true);
        this.llIIlIlIIl = nativeCreateFromPreset(mrtdSpecificationPreset.ordinal());
    }

    public static MrtdSpecification createFromPreset(MrtdSpecificationPreset mrtdSpecificationPreset) {
        if (mrtdSpecificationPreset != null) {
            return new MrtdSpecification(mrtdSpecificationPreset);
        }
        throw new IllegalArgumentException("Preset cannot be null!");
    }

    private static native long nativeCreateFromPreset(int i);

    private static native void nativeDestruct(long j);

    public long getNativeContext() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.entities.detectors.quad.Specification
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public MrtdSpecification(long j) {
        super(j, false);
    }
}
