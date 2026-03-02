package com.yoti.mobile.android.documentcapture.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionEntity;", "", "type", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionTypeEntity;", "coordinates", "Lcom/yoti/mobile/android/documentcapture/domain/model/FrameEntity;", "(Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionTypeEntity;Lcom/yoti/mobile/android/documentcapture/domain/model/FrameEntity;)V", "getCoordinates", "()Lcom/yoti/mobile/android/documentcapture/domain/model/FrameEntity;", "getType", "()Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionTypeEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageRegionEntity {
    private final FrameEntity coordinates;
    private final PageRegionTypeEntity type;

    public PageRegionEntity(PageRegionTypeEntity type, FrameEntity frameEntity) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.coordinates = frameEntity;
    }

    public static /* synthetic */ PageRegionEntity copy$default(PageRegionEntity pageRegionEntity, PageRegionTypeEntity pageRegionTypeEntity, FrameEntity frameEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            pageRegionTypeEntity = pageRegionEntity.type;
        }
        if ((i & 2) != 0) {
            frameEntity = pageRegionEntity.coordinates;
        }
        return pageRegionEntity.copy(pageRegionTypeEntity, frameEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageRegionTypeEntity getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FrameEntity getCoordinates() {
        return this.coordinates;
    }

    public final PageRegionEntity copy(PageRegionTypeEntity type, FrameEntity coordinates) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PageRegionEntity(type, coordinates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageRegionEntity)) {
            return false;
        }
        PageRegionEntity pageRegionEntity = (PageRegionEntity) other;
        return this.type == pageRegionEntity.type && Intrinsics.areEqual(this.coordinates, pageRegionEntity.coordinates);
    }

    public final FrameEntity getCoordinates() {
        return this.coordinates;
    }

    public final PageRegionTypeEntity getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        FrameEntity frameEntity = this.coordinates;
        return iHashCode + (frameEntity == null ? 0 : frameEntity.hashCode());
    }

    public String toString() {
        return "PageRegionEntity(type=" + this.type + ", coordinates=" + this.coordinates + ')';
    }

    public /* synthetic */ PageRegionEntity(PageRegionTypeEntity pageRegionTypeEntity, FrameEntity frameEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageRegionTypeEntity, (i & 2) != 0 ? null : frameEntity);
    }
}
