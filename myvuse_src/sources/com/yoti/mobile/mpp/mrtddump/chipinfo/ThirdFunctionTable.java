package com.yoti.mobile.mpp.mrtddump.chipinfo;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ThirdFunctionTable;", "", "commandChaining", "", "extendedLength", "hasExtendedInfo", "(ZZZ)V", "getCommandChaining", "()Z", "getExtendedLength", "getHasExtendedInfo", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
final /* data */ class ThirdFunctionTable {

    /* JADX INFO: renamed from: a */
    private final boolean f8057a;

    /* JADX INFO: renamed from: b */
    private final boolean f8058b;

    /* JADX INFO: renamed from: c */
    private final boolean f8059c;

    public ThirdFunctionTable(boolean z, boolean z2, boolean z3) {
        this.f8057a = z;
        this.f8058b = z2;
        this.f8059c = z3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getF8057a() {
        return this.f8057a;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getF8058b() {
        return this.f8058b;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdFunctionTable)) {
            return false;
        }
        ThirdFunctionTable thirdFunctionTable = (ThirdFunctionTable) other;
        return this.f8057a == thirdFunctionTable.f8057a && this.f8058b == thirdFunctionTable.f8058b && this.f8059c == thirdFunctionTable.f8059c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z = this.f8057a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.f8058b;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.f8059c;
        return i2 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "ThirdFunctionTable(commandChaining=" + this.f8057a + ", extendedLength=" + this.f8058b + ", hasExtendedInfo=" + this.f8059c + ')';
    }
}
