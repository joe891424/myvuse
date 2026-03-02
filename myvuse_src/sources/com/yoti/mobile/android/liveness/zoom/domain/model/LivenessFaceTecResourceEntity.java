package com.yoti.mobile.android.liveness.zoom.domain.model;

import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecResourceEntity;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "resourceId", "", "license", "(Ljava/lang/String;Ljava/lang/String;)V", "getLicense", "()Ljava/lang/String;", "getResourceId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecResourceEntity implements ILivenessResourceEntity {
    private final String license;
    private final String resourceId;

    public LivenessFaceTecResourceEntity(String resourceId, String license) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(license, "license");
        this.resourceId = resourceId;
        this.license = license;
    }

    public static /* synthetic */ LivenessFaceTecResourceEntity copy$default(LivenessFaceTecResourceEntity livenessFaceTecResourceEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecResourceEntity.getResourceId();
        }
        if ((i & 2) != 0) {
            str2 = livenessFaceTecResourceEntity.license;
        }
        return livenessFaceTecResourceEntity.copy(str, str2);
    }

    public final String component1() {
        return getResourceId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLicense() {
        return this.license;
    }

    public final LivenessFaceTecResourceEntity copy(String resourceId, String license) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(license, "license");
        return new LivenessFaceTecResourceEntity(resourceId, license);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecResourceEntity)) {
            return false;
        }
        LivenessFaceTecResourceEntity livenessFaceTecResourceEntity = (LivenessFaceTecResourceEntity) other;
        return Intrinsics.areEqual(getResourceId(), livenessFaceTecResourceEntity.getResourceId()) && Intrinsics.areEqual(this.license, livenessFaceTecResourceEntity.license);
    }

    public final String getLicense() {
        return this.license;
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (getResourceId().hashCode() * 31) + this.license.hashCode();
    }

    public String toString() {
        return "LivenessFaceTecResourceEntity(resourceId=" + getResourceId() + ", license=" + this.license + ')';
    }
}
