package com.google.android.gms.internal.vision;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgm implements Parcelable.Creator<zzgn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgn[] newArray(int i) {
        return new zzgn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgn createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        PointF pointF = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 2) {
                pointF = (PointF) SafeParcelReader.createParcelable(parcel, header, PointF.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzgn(i, pointF);
    }
}
