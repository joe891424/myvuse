package com.yoti.mobile.mpp.mrtddump.asn1;

import com.yoti.mobile.mpp.mrtddump.p096j.C5121e;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0015\u0010\b\u001a\u00060\tj\u0002`\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/asn1/MessagingState;", "", "ssc", "", "(J)V", "getSsc", "()J", "setSsc", "sscBytes", "", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "getSscBytes", "()[B", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MessagingState {

    /* JADX INFO: renamed from: a */
    private long f8012a;

    public MessagingState(long j) {
        this.f8012a = j;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getF8012a() {
        return this.f8012a;
    }

    /* JADX INFO: renamed from: a */
    public final void m5420a(long j) {
        this.f8012a = j;
    }

    /* JADX INFO: renamed from: b */
    public final byte[] m5421b() {
        return C5121e.m5543a(this.f8012a);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MessagingState) && this.f8012a == ((MessagingState) other).f8012a;
    }

    public int hashCode() {
        return Long.hashCode(this.f8012a);
    }

    public String toString() {
        return "MessagingState(ssc=" + this.f8012a + ')';
    }
}
