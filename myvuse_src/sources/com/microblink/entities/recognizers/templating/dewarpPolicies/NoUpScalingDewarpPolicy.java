package com.microblink.entities.recognizers.templating.dewarpPolicies;

import com.microblink.entities.recognizers.templating.DewarpPolicy;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class NoUpScalingDewarpPolicy extends DewarpPolicy {
    public static final int DEFAULT_MAX_ALLOWED_DEWARPED_HEIGHT = 400;
    private int llIIlIlIIl;

    public NoUpScalingDewarpPolicy() {
        this(400);
    }

    private static native void noUpScalingPolicyNativeSet(long j, int i);

    public int getMaxAllowedDewarpHeight() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.entities.recognizers.templating.DewarpPolicy
    protected void llIIlIlIIl(long j) {
        noUpScalingPolicyNativeSet(j, this.llIIlIlIIl);
    }

    public NoUpScalingDewarpPolicy(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Invalid max dewarp height");
        }
        this.llIIlIlIIl = i;
    }
}
