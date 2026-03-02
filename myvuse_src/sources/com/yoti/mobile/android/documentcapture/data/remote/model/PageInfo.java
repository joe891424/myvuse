package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.salesforce.marketingcloud.storage.p047db.C4351j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "", "captureMethod", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/CaptureMethodType;", C4351j.f5641e, "", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegion;", "imageResolution", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/ImageResolution;", "(Lcom/yoti/mobile/android/documentcapture/data/remote/model/CaptureMethodType;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/data/remote/model/ImageResolution;)V", "getCaptureMethod", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/CaptureMethodType;", "getImageResolution", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/ImageResolution;", "getRegions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageInfo {

    @SerializedName("capture_method")
    private final CaptureMethodType captureMethod;

    @SerializedName("image_resolution")
    private final ImageResolution imageResolution;

    @SerializedName(C4351j.f5641e)
    private final List<PageRegion> regions;

    public PageInfo(CaptureMethodType captureMethod, List<PageRegion> list, ImageResolution imageResolution) {
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.captureMethod = captureMethod;
        this.regions = list;
        this.imageResolution = imageResolution;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, CaptureMethodType captureMethodType, List list, ImageResolution imageResolution, int i, Object obj) {
        if ((i & 1) != 0) {
            captureMethodType = pageInfo.captureMethod;
        }
        if ((i & 2) != 0) {
            list = pageInfo.regions;
        }
        if ((i & 4) != 0) {
            imageResolution = pageInfo.imageResolution;
        }
        return pageInfo.copy(captureMethodType, list, imageResolution);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CaptureMethodType getCaptureMethod() {
        return this.captureMethod;
    }

    public final List<PageRegion> component2() {
        return this.regions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageResolution getImageResolution() {
        return this.imageResolution;
    }

    public final PageInfo copy(CaptureMethodType captureMethod, List<PageRegion> regions, ImageResolution imageResolution) {
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        return new PageInfo(captureMethod, regions, imageResolution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageInfo)) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) other;
        return this.captureMethod == pageInfo.captureMethod && Intrinsics.areEqual(this.regions, pageInfo.regions) && Intrinsics.areEqual(this.imageResolution, pageInfo.imageResolution);
    }

    public final CaptureMethodType getCaptureMethod() {
        return this.captureMethod;
    }

    public final ImageResolution getImageResolution() {
        return this.imageResolution;
    }

    public final List<PageRegion> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        int iHashCode = this.captureMethod.hashCode() * 31;
        List<PageRegion> list = this.regions;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        ImageResolution imageResolution = this.imageResolution;
        return iHashCode2 + (imageResolution != null ? imageResolution.hashCode() : 0);
    }

    public String toString() {
        return "PageInfo(captureMethod=" + this.captureMethod + ", regions=" + this.regions + ", imageResolution=" + this.imageResolution + ')';
    }

    public /* synthetic */ PageInfo(CaptureMethodType captureMethodType, List list, ImageResolution imageResolution, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureMethodType, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : imageResolution);
    }
}
