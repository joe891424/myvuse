package com.yoti.mobile.android.documentscan.ui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.F, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanViewConfiguration;", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "documentRatio", "", "(F)V", "getDocumentRatio", "()F", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class ScanViewConfiguration implements IScanViewConfiguration {
    public static final Parcelable.Creator CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final float f6988a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.F$a */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new ScanViewConfiguration(in.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new ScanViewConfiguration[i];
        }
    }

    public ScanViewConfiguration(float f) {
        this.f6988a = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ScanViewConfiguration) && Float.compare(getF6988a(), ((ScanViewConfiguration) other).getF6988a()) == 0;
        }
        return true;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration
    /* JADX INFO: renamed from: getDocumentRatio, reason: from getter */
    public float getF6988a() {
        return this.f6988a;
    }

    public int hashCode() {
        return Float.hashCode(getF6988a());
    }

    public String toString() {
        return "ScanViewConfiguration(documentRatio=" + getF6988a() + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeFloat(this.f6988a);
    }
}
