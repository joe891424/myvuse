package com.microblink.entities.recognizers.templating.dewarpPolicies;

import com.microblink.entities.recognizers.templating.DewarpPolicy;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class FixedDewarpPolicy extends DewarpPolicy {
    public static final int DEFAULT_DEWARP_HEIGHT = 100;
    private int llIIlIlIIl;

    public FixedDewarpPolicy() {
        this(100);
    }

    private static native void fixedPolicyNativeSet(long j, int i);

    public int getDewarpHeight() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.entities.recognizers.templating.DewarpPolicy
    protected void llIIlIlIIl(long j) {
        fixedPolicyNativeSet(j, this.llIIlIlIIl);
    }

    public FixedDewarpPolicy(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Invalid dewarp height");
        }
        this.llIIlIlIIl = i;
    }
}
