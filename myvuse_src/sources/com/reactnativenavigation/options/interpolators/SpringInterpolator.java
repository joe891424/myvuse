package com.reactnativenavigation.options.interpolators;

import android.animation.TimeInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: SpringInterpolator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/reactnativenavigation/options/interpolators/SpringInterpolator;", "Landroid/animation/TimeInterpolator;", "mass", "", "damping", "stiffness", "allowsOverdamping", "", "initialVelocity", "(FFFZF)V", "velocity", "getInterpolation", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SpringInterpolator implements TimeInterpolator {
    private final boolean allowsOverdamping;
    private final float damping;
    private final float mass;
    private final float stiffness;
    private final float velocity;

    public SpringInterpolator() {
        this(0.0f, 0.0f, 0.0f, false, 0.0f, 31, null);
    }

    public SpringInterpolator(float f, float f2, float f3, boolean z, float f4) {
        this.mass = f;
        this.damping = f2;
        this.stiffness = f3;
        this.allowsOverdamping = z;
        this.velocity = f4;
    }

    public /* synthetic */ SpringInterpolator(float f, float f2, float f3, boolean z, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 3.0f : f, (i & 2) != 0 ? 500.0f : f2, (i & 4) != 0 ? 200.0f : f3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? 0.0f : f4);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t) {
        float f;
        float fExp;
        float f2 = this.damping;
        float f3 = this.mass;
        float f4 = this.stiffness;
        float f5 = this.velocity;
        float f6 = f2 / (2 * f3);
        float fSqrt = (float) Math.sqrt(f4 / f3);
        float f7 = fSqrt * fSqrt;
        float f8 = f6 * f6;
        float fSqrt2 = (float) Math.sqrt(f7 - f8);
        float fSqrt3 = (float) Math.sqrt(f8 - f7);
        if (!this.allowsOverdamping && f6 > fSqrt) {
            f6 = fSqrt;
        }
        if (t == 1.0f) {
            return 1.0f;
        }
        if (f6 < fSqrt) {
            f = 1;
            float f9 = -1;
            double d = t * fSqrt2;
            fExp = ((float) Math.exp((-f6) * t)) * ((((float) Math.cos(d)) * f9) + ((((f6 * f9) + f5) / fSqrt2) * ((float) Math.sin(d))));
        } else if (f6 == fSqrt) {
            f = 1;
            float f10 = -1;
            fExp = ((float) Math.exp((-f6) * t)) * (f10 + (((f6 * f10) + f5) * t));
        } else {
            float f11 = -1;
            double d2 = t * fSqrt3;
            return 1 + (((float) Math.exp((-f6) * t)) * ((((float) Math.cosh(d2)) * f11) + ((((f6 * f11) + f5) / fSqrt3) * ((float) Math.sinh(d2)))));
        }
        return f + fExp;
    }
}
