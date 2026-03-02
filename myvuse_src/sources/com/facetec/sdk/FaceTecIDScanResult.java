package com.facetec.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecIDScanResult implements Parcelable {
    public static final Parcelable.Creator<FaceTecIDScanResult> CREATOR = new Parcelable.Creator<FaceTecIDScanResult>() { // from class: com.facetec.sdk.FaceTecIDScanResult.3
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceTecIDScanResult[] newArray(int i) {
            return new FaceTecIDScanResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceTecIDScanResult createFromParcel(Parcel parcel) {
            return new FaceTecIDScanResult(parcel, (byte) 0);
        }
    };

    /* JADX INFO: renamed from: B */
    private ArrayList<String> f2227B;
    private String Code;

    /* JADX INFO: renamed from: I */
    private byte[] f2228I;

    /* JADX INFO: renamed from: V */
    private ArrayList<String> f2229V;

    /* JADX INFO: renamed from: Z */
    private final FaceTecIDScanStatus f2230Z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* synthetic */ FaceTecIDScanResult(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f2230Z);
        C2230u.Code(this.f2229V, parcel);
        C2230u.Code(this.f2227B, parcel);
        C2230u.Code(this.f2228I, parcel);
        C2230u.Code(this.Code, parcel);
    }

    private FaceTecIDScanResult(Parcel parcel) {
        this.f2229V = new ArrayList<>();
        this.f2227B = new ArrayList<>();
        this.f2230Z = (FaceTecIDScanStatus) parcel.readSerializable();
        this.f2229V = (ArrayList) C2230u.m2296V(parcel);
        this.f2227B = (ArrayList) C2230u.m2296V(parcel);
        this.f2228I = (byte[]) C2230u.m2296V(parcel);
        this.Code = (String) C2230u.m2296V(parcel);
    }

    FaceTecIDScanResult(FaceTecIDScanStatus faceTecIDScanStatus) {
        this.f2229V = new ArrayList<>();
        this.f2227B = new ArrayList<>();
        this.f2230Z = faceTecIDScanStatus;
    }

    public final FaceTecIDScanStatus getStatus() {
        return this.f2230Z;
    }

    public final ArrayList<String> getFrontImagesCompressedBase64() {
        return this.f2229V;
    }

    public final ArrayList<String> getBackImagesCompressedBase64() {
        return this.f2227B;
    }

    /* JADX INFO: renamed from: B */
    final void m1401B(byte[][] bArr) {
        if (bArr != null) {
            for (byte[] bArr2 : bArr) {
                this.f2229V.add(Base64.encodeToString(bArr2, 2));
            }
        }
    }

    /* JADX INFO: renamed from: V */
    final void m1402V(byte[][] bArr) {
        if (bArr != null) {
            for (byte[] bArr2 : bArr) {
                this.f2227B.add(Base64.encodeToString(bArr2, 2));
            }
        }
    }

    public final byte[] getIDScan() {
        byte[] bArr = new byte[0];
        byte[] bArr2 = this.f2228I;
        return bArr2 != null ? bArr2 : bArr;
    }

    public final String getIDScanBase64() {
        byte[] bArr = new byte[0];
        byte[] bArr2 = this.f2228I;
        if (bArr2 != null) {
            bArr = bArr2;
        }
        return Base64.encodeToString(bArr, 2);
    }

    /* JADX INFO: renamed from: Z */
    final void m1403Z(byte[] bArr) {
        this.f2228I = bArr;
    }

    public final String getSessionId() {
        return this.Code;
    }

    /* JADX INFO: renamed from: B */
    final void m1400B(String str) {
        this.Code = str;
    }
}
