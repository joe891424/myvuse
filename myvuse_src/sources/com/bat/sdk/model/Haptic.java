package com.bat.sdk.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Haptic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/model/Haptic;", "", FirebaseAnalytics.Param.LEVEL, "", "<init>", "(I)V", "getLevel", "()I", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Haptic {
    private final int level;

    public Haptic() {
        this(0, 1, null);
    }

    public static /* synthetic */ Haptic copy$default(Haptic haptic, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = haptic.level;
        }
        return haptic.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final Haptic copy(int level) {
        return new Haptic(level);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Haptic) && this.level == ((Haptic) other).level;
    }

    public int hashCode() {
        return Integer.hashCode(this.level);
    }

    public Haptic(int i) {
        this.level = i;
    }

    public /* synthetic */ Haptic(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getLevel() {
        return this.level;
    }

    public String toString() {
        return "haptic level=" + this.level;
    }
}
