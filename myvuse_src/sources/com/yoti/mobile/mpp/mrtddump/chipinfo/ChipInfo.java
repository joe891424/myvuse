package com.yoti.mobile.mpp.mrtddump.chipinfo;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;", "", "extendedLengthSupported", "", "maxSendLength", "", "maxReceiveLength", "commandChainingSupported", "(ZIIZ)V", "getCommandChainingSupported", "()Z", "getExtendedLengthSupported", "getMaxReceiveLength", "()I", "getMaxSendLength", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ChipInfo {

    /* JADX INFO: renamed from: a */
    private final boolean f8041a;

    /* JADX INFO: renamed from: b */
    private final int f8042b;

    /* JADX INFO: renamed from: c */
    private final int f8043c;

    /* JADX INFO: renamed from: d */
    private final boolean f8044d;

    public ChipInfo(boolean z, int i, int i2, boolean z2) {
        this.f8041a = z;
        this.f8042b = i;
        this.f8043c = i2;
        this.f8044d = z2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getF8043c() {
        return this.f8043c;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChipInfo)) {
            return false;
        }
        ChipInfo chipInfo = (ChipInfo) other;
        return this.f8041a == chipInfo.f8041a && this.f8042b == chipInfo.f8042b && this.f8043c == chipInfo.f8043c && this.f8044d == chipInfo.f8044d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z = this.f8041a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((r0 * 31) + Integer.hashCode(this.f8042b)) * 31) + Integer.hashCode(this.f8043c)) * 31;
        boolean z2 = this.f8044d;
        return iHashCode + (z2 ? 1 : z2);
    }

    public String toString() {
        return "ChipInfo(extendedLengthSupported=" + this.f8041a + ", maxSendLength=" + this.f8042b + ", maxReceiveLength=" + this.f8043c + ", commandChainingSupported=" + this.f8044d + ')';
    }
}
