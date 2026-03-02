package com.yoti.mobile.android.documentscan.model.result;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/MetaData;", "Landroid/os/Parcelable;", "mainImage", "", "holograms", "", "cropRegion", "Landroid/graphics/RectF;", "croppedDocumentImage", "croppedFaceImage", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/RectF;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;)V", "getCropRegion", "()Landroid/graphics/RectF;", "getCroppedDocumentImage", "()Ljava/lang/String;", "getCroppedFaceImage", "getHolograms", "()Ljava/util/List;", "getImageFormat", "()Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "getMainImage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class MetaData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final RectF cropRegion;
    private final String croppedDocumentImage;
    private final String croppedFaceImage;
    private final List<String> holograms;
    private final ImageFormat imageFormat;
    private final String mainImage;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new MetaData(in.readString(), in.createStringArrayList(), (RectF) in.readParcelable(MetaData.class.getClassLoader()), in.readString(), in.readString(), (ImageFormat) Enum.valueOf(ImageFormat.class, in.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new MetaData[i];
        }
    }

    public MetaData(String str, List<String> holograms, RectF rectF, String str2, String str3, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(holograms, "holograms");
        Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
        this.mainImage = str;
        this.holograms = holograms;
        this.cropRegion = rectF;
        this.croppedDocumentImage = str2;
        this.croppedFaceImage = str3;
        this.imageFormat = imageFormat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaData copy$default(MetaData metaData, String str, List list, RectF rectF, String str2, String str3, ImageFormat imageFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaData.mainImage;
        }
        if ((i & 2) != 0) {
            list = metaData.holograms;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            rectF = metaData.cropRegion;
        }
        RectF rectF2 = rectF;
        if ((i & 8) != 0) {
            str2 = metaData.croppedDocumentImage;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = metaData.croppedFaceImage;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            imageFormat = metaData.imageFormat;
        }
        return metaData.copy(str, list2, rectF2, str4, str5, imageFormat);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMainImage() {
        return this.mainImage;
    }

    public final List<String> component2() {
        return this.holograms;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RectF getCropRegion() {
        return this.cropRegion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCroppedDocumentImage() {
        return this.croppedDocumentImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCroppedFaceImage() {
        return this.croppedFaceImage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final MetaData copy(String mainImage, List<String> holograms, RectF cropRegion, String croppedDocumentImage, String croppedFaceImage, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(holograms, "holograms");
        Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
        return new MetaData(mainImage, holograms, cropRegion, croppedDocumentImage, croppedFaceImage, imageFormat);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) other;
        return Intrinsics.areEqual(this.mainImage, metaData.mainImage) && Intrinsics.areEqual(this.holograms, metaData.holograms) && Intrinsics.areEqual(this.cropRegion, metaData.cropRegion) && Intrinsics.areEqual(this.croppedDocumentImage, metaData.croppedDocumentImage) && Intrinsics.areEqual(this.croppedFaceImage, metaData.croppedFaceImage) && Intrinsics.areEqual(this.imageFormat, metaData.imageFormat);
    }

    public final RectF getCropRegion() {
        return this.cropRegion;
    }

    public final String getCroppedDocumentImage() {
        return this.croppedDocumentImage;
    }

    public final String getCroppedFaceImage() {
        return this.croppedFaceImage;
    }

    public final List<String> getHolograms() {
        return this.holograms;
    }

    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final String getMainImage() {
        return this.mainImage;
    }

    public int hashCode() {
        String str = this.mainImage;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.holograms;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        RectF rectF = this.cropRegion;
        int iHashCode3 = (iHashCode2 + (rectF != null ? rectF.hashCode() : 0)) * 31;
        String str2 = this.croppedDocumentImage;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.croppedFaceImage;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ImageFormat imageFormat = this.imageFormat;
        return iHashCode5 + (imageFormat != null ? imageFormat.hashCode() : 0);
    }

    public String toString() {
        return "MetaData(mainImage=" + this.mainImage + ", holograms=" + this.holograms + ", cropRegion=" + this.cropRegion + ", croppedDocumentImage=" + this.croppedDocumentImage + ", croppedFaceImage=" + this.croppedFaceImage + ", imageFormat=" + this.imageFormat + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.mainImage);
        parcel.writeStringList(this.holograms);
        parcel.writeParcelable(this.cropRegion, flags);
        parcel.writeString(this.croppedDocumentImage);
        parcel.writeString(this.croppedFaceImage);
        parcel.writeString(this.imageFormat.name());
    }
}
