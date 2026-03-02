package com.yoti.mobile.mpp.mrtddump.chipinfo;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ExtendedLengthInfo;", "", "sendLengthBytes", "", "receiveLengthBytes", "(II)V", "getReceiveLengthBytes", "()I", "getSendLengthBytes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
final /* data */ class ExtendedLengthInfo {

    /* JADX INFO: renamed from: a */
    private final int f8055a;

    /* JADX INFO: renamed from: b */
    private final int f8056b;

    public ExtendedLengthInfo(int i, int i2) {
        this.f8055a = i;
        this.f8056b = i2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getF8056b() {
        return this.f8056b;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getF8055a() {
        return this.f8055a;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtendedLengthInfo)) {
            return false;
        }
        ExtendedLengthInfo extendedLengthInfo = (ExtendedLengthInfo) other;
        return this.f8055a == extendedLengthInfo.f8055a && this.f8056b == extendedLengthInfo.f8056b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f8055a) * 31) + Integer.hashCode(this.f8056b);
    }

    public String toString() {
        return "ExtendedLengthInfo(sendLengthBytes=" + this.f8055a + ", receiveLengthBytes=" + this.f8056b + ')';
    }
}
