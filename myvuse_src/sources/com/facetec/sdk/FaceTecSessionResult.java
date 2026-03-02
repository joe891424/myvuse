package com.facetec.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecSessionResult implements Parcelable {
    public static final Parcelable.Creator<FaceTecSessionResult> CREATOR = new Parcelable.Creator<FaceTecSessionResult>() { // from class: com.facetec.sdk.FaceTecSessionResult.4
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceTecSessionResult[] newArray(int i) {
            return new FaceTecSessionResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceTecSessionResult createFromParcel(Parcel parcel) {
            return new FaceTecSessionResult(parcel, (byte) 0);
        }
    };

    /* JADX INFO: renamed from: B */
    private final FaceTecSessionStatus f2244B;
    private final byte[] Code;

    /* JADX INFO: renamed from: I */
    private final byte[][] f2245I;

    /* JADX INFO: renamed from: V */
    private final byte[][] f2246V;

    /* JADX INFO: renamed from: Z */
    private String f2247Z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* synthetic */ FaceTecSessionResult(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2244B.name());
        parcel.writeString(this.f2247Z);
        C2230u.Code(this.f2246V, parcel);
        C2230u.Code(this.f2245I, parcel);
        C2230u.Code(this.Code, parcel);
    }

    private FaceTecSessionResult(Parcel parcel) {
        this.f2244B = FaceTecSessionStatus.valueOf(parcel.readString());
        this.f2247Z = parcel.readString();
        this.f2246V = (byte[][]) C2230u.m2296V(parcel);
        this.f2245I = (byte[][]) C2230u.m2296V(parcel);
        this.Code = (byte[]) C2230u.m2296V(parcel);
    }

    FaceTecSessionResult(FaceTecSessionStatus faceTecSessionStatus, byte[][] bArr, byte[][] bArr2, byte[] bArr3) {
        this.f2244B = faceTecSessionStatus;
        this.f2246V = bArr;
        this.f2245I = bArr2;
        this.Code = bArr3;
    }

    public final byte[] getFaceScan() {
        byte[] bArr = new byte[0];
        byte[] bArr2 = this.Code;
        return bArr2 != null ? bArr2 : bArr;
    }

    public final String getFaceScanBase64() {
        byte[] bArr = new byte[0];
        byte[] bArr2 = this.Code;
        if (bArr2 != null) {
            bArr = bArr2;
        }
        return Base64.encodeToString(bArr, 2);
    }

    public final String[] getLowQualityAuditTrailCompressedBase64() {
        byte[][] bArr = this.f2245I;
        if (bArr != null) {
            String[] strArr = new String[bArr.length];
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.f2245I;
                if (i >= bArr2.length) {
                    return strArr;
                }
                strArr[i] = Base64.encodeToString(bArr2[i], 0);
                i++;
            }
        } else {
            return new String[0];
        }
    }

    public final String[] getAuditTrailCompressedBase64() {
        byte[][] bArr = this.f2246V;
        int i = 0;
        if (bArr != null) {
            String[] strArr = new String[bArr.length];
            while (true) {
                byte[][] bArr2 = this.f2246V;
                if (i >= bArr2.length) {
                    return strArr;
                }
                strArr[i] = Base64.encodeToString(bArr2[i], 2);
                i++;
            }
        } else {
            return new String[0];
        }
    }

    public final FaceTecSessionStatus getStatus() {
        return this.f2244B;
    }

    public final String getSessionId() {
        return this.f2247Z;
    }

    /* JADX INFO: renamed from: B */
    final void m1410B(String str) {
        this.f2247Z = str;
    }
}
