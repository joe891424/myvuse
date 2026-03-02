package com.yoti.mobile.mpp.mrtddump;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/Key;", "", "rawValue", "", "([B)V", "getRawValue", "()[B", "equals", "", "other", "hashCode", "", "isMatchingClass", "Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "Lcom/yoti/mobile/mpp/mrtddump/MacKey;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Key {

    /* JADX INFO: renamed from: a */
    private final byte[] f8010a;

    private Key(byte[] bArr) {
        this.f8010a = bArr;
    }

    public /* synthetic */ Key(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo5381a(Object obj);

    /* JADX INFO: renamed from: a, reason: from getter */
    public final byte[] getF8010a() {
        return this.f8010a;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!mo5381a(other)) {
            return false;
        }
        if (other != null) {
            return Arrays.equals(this.f8010a, ((Key) other).f8010a);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.mpp.mrtddump.Key");
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8010a);
    }
}
