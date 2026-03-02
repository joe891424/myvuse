package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegion;", "", "type", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegionType;", "coordinates", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/Frame;", "(Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegionType;Lcom/yoti/mobile/android/documentcapture/data/remote/model/Frame;)V", "getCoordinates", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/Frame;", "getType", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageRegionType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageRegion {

    @SerializedName("coordinates")
    private final Frame coordinates;

    @SerializedName("type")
    private final PageRegionType type;

    public PageRegion(PageRegionType type, Frame frame) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.coordinates = frame;
    }

    public static /* synthetic */ PageRegion copy$default(PageRegion pageRegion, PageRegionType pageRegionType, Frame frame, int i, Object obj) {
        if ((i & 1) != 0) {
            pageRegionType = pageRegion.type;
        }
        if ((i & 2) != 0) {
            frame = pageRegion.coordinates;
        }
        return pageRegion.copy(pageRegionType, frame);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageRegionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Frame getCoordinates() {
        return this.coordinates;
    }

    public final PageRegion copy(PageRegionType type, Frame coordinates) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PageRegion(type, coordinates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageRegion)) {
            return false;
        }
        PageRegion pageRegion = (PageRegion) other;
        return this.type == pageRegion.type && Intrinsics.areEqual(this.coordinates, pageRegion.coordinates);
    }

    public final Frame getCoordinates() {
        return this.coordinates;
    }

    public final PageRegionType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Frame frame = this.coordinates;
        return iHashCode + (frame == null ? 0 : frame.hashCode());
    }

    public String toString() {
        return "PageRegion(type=" + this.type + ", coordinates=" + this.coordinates + ')';
    }
}
