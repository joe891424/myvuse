package com.yoti.mobile.android.documentcapture.domain.model;

import com.salesforce.marketingcloud.storage.p047db.C4351j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/PageInfoEntity;", "", "captureMethod", "Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", C4351j.f5641e, "", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionEntity;", "dimensions", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageDimensionsEntity;", "(Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/domain/model/PageDimensionsEntity;)V", "getCaptureMethod", "()Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", "getDimensions", "()Lcom/yoti/mobile/android/documentcapture/domain/model/PageDimensionsEntity;", "getRegions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageInfoEntity {
    private final CaptureMethodTypeEntity captureMethod;
    private final PageDimensionsEntity dimensions;
    private final List<PageRegionEntity> regions;

    public PageInfoEntity(CaptureMethodTypeEntity captureMethod, List<PageRegionEntity> regions, PageDimensionsEntity pageDimensionsEntity) {
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        Intrinsics.checkNotNullParameter(regions, "regions");
        this.captureMethod = captureMethod;
        this.regions = regions;
        this.dimensions = pageDimensionsEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageInfoEntity copy$default(PageInfoEntity pageInfoEntity, CaptureMethodTypeEntity captureMethodTypeEntity, List list, PageDimensionsEntity pageDimensionsEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            captureMethodTypeEntity = pageInfoEntity.captureMethod;
        }
        if ((i & 2) != 0) {
            list = pageInfoEntity.regions;
        }
        if ((i & 4) != 0) {
            pageDimensionsEntity = pageInfoEntity.dimensions;
        }
        return pageInfoEntity.copy(captureMethodTypeEntity, list, pageDimensionsEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CaptureMethodTypeEntity getCaptureMethod() {
        return this.captureMethod;
    }

    public final List<PageRegionEntity> component2() {
        return this.regions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageDimensionsEntity getDimensions() {
        return this.dimensions;
    }

    public final PageInfoEntity copy(CaptureMethodTypeEntity captureMethod, List<PageRegionEntity> regions, PageDimensionsEntity dimensions) {
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        Intrinsics.checkNotNullParameter(regions, "regions");
        return new PageInfoEntity(captureMethod, regions, dimensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageInfoEntity)) {
            return false;
        }
        PageInfoEntity pageInfoEntity = (PageInfoEntity) other;
        return this.captureMethod == pageInfoEntity.captureMethod && Intrinsics.areEqual(this.regions, pageInfoEntity.regions) && Intrinsics.areEqual(this.dimensions, pageInfoEntity.dimensions);
    }

    public final CaptureMethodTypeEntity getCaptureMethod() {
        return this.captureMethod;
    }

    public final PageDimensionsEntity getDimensions() {
        return this.dimensions;
    }

    public final List<PageRegionEntity> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        int iHashCode = ((this.captureMethod.hashCode() * 31) + this.regions.hashCode()) * 31;
        PageDimensionsEntity pageDimensionsEntity = this.dimensions;
        return iHashCode + (pageDimensionsEntity == null ? 0 : pageDimensionsEntity.hashCode());
    }

    public String toString() {
        return "PageInfoEntity(captureMethod=" + this.captureMethod + ", regions=" + this.regions + ", dimensions=" + this.dimensions + ')';
    }

    public /* synthetic */ PageInfoEntity(CaptureMethodTypeEntity captureMethodTypeEntity, List list, PageDimensionsEntity pageDimensionsEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureMethodTypeEntity, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : pageDimensionsEntity);
    }
}
