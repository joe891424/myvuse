package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FindVape.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m5598d2 = {"Lcom/bat/sdk/model/FindVape;", "", "isAlerting", "", "seconds", "", "soundPattern", "<init>", "(ZILjava/lang/Integer;)V", "()Z", "getSeconds", "()I", "getSoundPattern", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toString", "", "component1", "component2", "component3", "copy", "(ZILjava/lang/Integer;)Lcom/bat/sdk/model/FindVape;", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class FindVape {
    private final boolean isAlerting;
    private final int seconds;
    private final Integer soundPattern;

    public FindVape() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ FindVape copy$default(FindVape findVape, boolean z, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = findVape.isAlerting;
        }
        if ((i2 & 2) != 0) {
            i = findVape.seconds;
        }
        if ((i2 & 4) != 0) {
            num = findVape.soundPattern;
        }
        return findVape.copy(z, i, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsAlerting() {
        return this.isAlerting;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSeconds() {
        return this.seconds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSoundPattern() {
        return this.soundPattern;
    }

    public final FindVape copy(boolean isAlerting, int seconds, Integer soundPattern) {
        return new FindVape(isAlerting, seconds, soundPattern);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FindVape)) {
            return false;
        }
        FindVape findVape = (FindVape) other;
        return this.isAlerting == findVape.isAlerting && this.seconds == findVape.seconds && Intrinsics.areEqual(this.soundPattern, findVape.soundPattern);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.isAlerting) * 31) + Integer.hashCode(this.seconds)) * 31;
        Integer num = this.soundPattern;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public FindVape(boolean z, int i, Integer num) {
        this.isAlerting = z;
        this.seconds = i;
        this.soundPattern = num;
    }

    public /* synthetic */ FindVape(boolean z, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : num);
    }

    public final boolean isAlerting() {
        return this.isAlerting;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final Integer getSoundPattern() {
        return this.soundPattern;
    }

    public String toString() {
        return "FindVape(isAlerting=" + this.isAlerting + ", seconds=" + this.seconds + ", soundPattern=" + this.soundPattern + ')';
    }
}
