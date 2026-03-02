package com.microblink.entities.recognizers.templating.dewarpPolicies;

import com.microblink.entities.recognizers.templating.DewarpPolicy;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DPIBasedDewarpPolicy extends DewarpPolicy {
    public static final int DEFAULT_DPI = 250;
    private int llIIlIlIIl;

    public DPIBasedDewarpPolicy() {
        this(250);
    }

    private static native void dpiPolicyNativeSet(long j, int i);

    public int getDPI() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.entities.recognizers.templating.DewarpPolicy
    protected void llIIlIlIIl(long j) {
        dpiPolicyNativeSet(j, this.llIIlIlIIl);
    }

    public DPIBasedDewarpPolicy(int i) {
        if (i < 100 || i > 400) {
            throw new IllegalArgumentException("DPI value must be in range [100, 400], you are trying to set DPI to: " + i + ".");
        }
        this.llIIlIlIIl = i;
    }
}
