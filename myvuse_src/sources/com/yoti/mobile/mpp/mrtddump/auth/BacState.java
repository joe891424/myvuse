package com.yoti.mobile.mpp.mrtddump.auth;

import com.yoti.mobile.mpp.mrtddump.MrtdAuthException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.auth.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\tJ\u0011\u0010\u001c\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006HÆ\u0003JQ\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020'HÖ\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0007\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00060\u0003j\u0002`\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0015\u0010\u0016\u001a\u00060\u0003j\u0002`\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0015\u0010\u0018\u001a\u00060\u0003j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0015\u0010\u001a\u001a\u00060\u0003j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b¨\u0006("}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/auth/BacState;", "", "rndIfd", "", "Lcom/yoti/mobile/mpp/mrtddump/Nonce;", "kIfd", "Lcom/yoti/mobile/mpp/mrtddump/PlainKey;", "rndIc", "kIc", "([B[B[B[B)V", "getKIc", "()[B", "setKIc", "([B)V", "getKIfd", "setKIfd", "getRndIc", "setRndIc", "getRndIfd", "setRndIfd", "safeKIc", "getSafeKIc", "safeKIfd", "getSafeKIfd", "safeRndIc", "getSafeRndIc", "safeRndIfd", "getSafeRndIfd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class BacState {

    /* JADX INFO: renamed from: a */
    private byte[] f8006a;

    /* JADX INFO: renamed from: b */
    private byte[] f8007b;

    /* JADX INFO: renamed from: c */
    private byte[] f8008c;

    /* JADX INFO: renamed from: d */
    private byte[] f8009d;

    public BacState() {
        this(null, null, null, null, 15, null);
    }

    public BacState(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f8006a = bArr;
        this.f8007b = bArr2;
        this.f8008c = bArr3;
        this.f8009d = bArr4;
    }

    public /* synthetic */ BacState(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr, (i & 2) != 0 ? null : bArr2, (i & 4) != 0 ? null : bArr3, (i & 8) != 0 ? null : bArr4);
    }

    /* JADX INFO: renamed from: a */
    public final void m5405a(byte[] bArr) {
        this.f8009d = bArr;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final byte[] getF8009d() {
        return this.f8009d;
    }

    /* JADX INFO: renamed from: b */
    public final void m5407b(byte[] bArr) {
        this.f8007b = bArr;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final byte[] getF8007b() {
        return this.f8007b;
    }

    /* JADX INFO: renamed from: c */
    public final void m5409c(byte[] bArr) {
        this.f8008c = bArr;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final byte[] getF8008c() {
        return this.f8008c;
    }

    /* JADX INFO: renamed from: d */
    public final void m5411d(byte[] bArr) {
        this.f8006a = bArr;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final byte[] getF8006a() {
        return this.f8006a;
    }

    /* JADX INFO: renamed from: e */
    public final byte[] m5413e() throws MrtdAuthException {
        byte[] bArr = this.f8009d;
        if (bArr != null) {
            return bArr;
        }
        throw new MrtdAuthException("setAuthResponsePayload not called", null, 2, null);
    }

    public boolean equals(Object other) {
        byte[] f8006a;
        byte[] f8007b;
        byte[] f8008c;
        if (this == other) {
            return true;
        }
        if (!(other instanceof BacState)) {
            return false;
        }
        byte[] bArr = this.f8006a;
        byte[] bArr2 = null;
        if (bArr == null) {
            f8006a = null;
        } else {
            f8006a = ((BacState) other).getF8006a();
            if (f8006a == null || !Arrays.equals(f8006a, bArr)) {
                f8006a = null;
            }
            if (f8006a == null) {
                return false;
            }
        }
        if (f8006a == null && ((BacState) other).f8006a != null) {
            return false;
        }
        byte[] bArr3 = this.f8007b;
        if (bArr3 == null) {
            f8007b = null;
        } else {
            f8007b = ((BacState) other).getF8007b();
            if (f8007b == null || !Arrays.equals(f8007b, bArr3)) {
                f8007b = null;
            }
            if (f8007b == null) {
                return false;
            }
        }
        if (f8007b == null && ((BacState) other).f8007b != null) {
            return false;
        }
        byte[] bArr4 = this.f8008c;
        if (bArr4 == null) {
            f8008c = null;
        } else {
            f8008c = ((BacState) other).getF8008c();
            if (f8008c == null || !Arrays.equals(f8008c, bArr4)) {
                f8008c = null;
            }
            if (f8008c == null) {
                return false;
            }
        }
        if (f8008c == null && ((BacState) other).f8008c != null) {
            return false;
        }
        byte[] bArr5 = this.f8009d;
        if (bArr5 != null) {
            byte[] f8009d = ((BacState) other).getF8009d();
            if (f8009d != null && Arrays.equals(f8009d, bArr5)) {
                bArr2 = f8009d;
            }
            if (bArr2 == null) {
                return false;
            }
        }
        return bArr2 != null || ((BacState) other).f8009d == null;
    }

    /* JADX INFO: renamed from: f */
    public final byte[] m5414f() throws MrtdAuthException {
        byte[] bArr = this.f8007b;
        if (bArr != null) {
            return bArr;
        }
        throw new MrtdAuthException("generateAuthDataPayload not called", null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final byte[] m5415g() throws MrtdAuthException {
        byte[] bArr = this.f8008c;
        if (bArr != null) {
            return bArr;
        }
        throw new MrtdAuthException("setChallenge not called", null, 2, null);
    }

    /* JADX INFO: renamed from: h */
    public final byte[] m5416h() throws MrtdAuthException {
        byte[] bArr = this.f8006a;
        if (bArr != null) {
            return bArr;
        }
        throw new MrtdAuthException("generateAuthDataPayload not called", null, 2, null);
    }

    public int hashCode() {
        byte[] bArr = this.f8006a;
        int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
        byte[] bArr2 = this.f8007b;
        int iHashCode2 = (iHashCode + (bArr2 == null ? 0 : Arrays.hashCode(bArr2))) * 31;
        byte[] bArr3 = this.f8008c;
        int iHashCode3 = (iHashCode2 + (bArr3 == null ? 0 : Arrays.hashCode(bArr3))) * 31;
        byte[] bArr4 = this.f8009d;
        return iHashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public String toString() {
        return "BacState(rndIfd=" + Arrays.toString(this.f8006a) + ", kIfd=" + Arrays.toString(this.f8007b) + ", rndIc=" + Arrays.toString(this.f8008c) + ", kIc=" + Arrays.toString(this.f8009d) + ')';
    }
}
