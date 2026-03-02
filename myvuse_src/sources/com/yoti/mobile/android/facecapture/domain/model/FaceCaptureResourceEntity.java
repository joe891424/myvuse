package com.yoti.mobile.android.facecapture.domain.model;

import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureResourceEntity;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "resourceId", "", "_frames", "", "(Ljava/lang/String;I)V", "frames", "getFrames", "()I", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureResourceEntity implements ILivenessResourceEntity {
    private final int _frames;
    private final String resourceId;

    public FaceCaptureResourceEntity(String resourceId, int i) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this._frames = i;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int get_frames() {
        return this._frames;
    }

    public static /* synthetic */ FaceCaptureResourceEntity copy$default(FaceCaptureResourceEntity faceCaptureResourceEntity, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = faceCaptureResourceEntity.getResourceId();
        }
        if ((i2 & 2) != 0) {
            i = faceCaptureResourceEntity._frames;
        }
        return faceCaptureResourceEntity.copy(str, i);
    }

    public final String component1() {
        return getResourceId();
    }

    public final FaceCaptureResourceEntity copy(String resourceId, int _frames) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new FaceCaptureResourceEntity(resourceId, _frames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureResourceEntity)) {
            return false;
        }
        FaceCaptureResourceEntity faceCaptureResourceEntity = (FaceCaptureResourceEntity) other;
        return Intrinsics.areEqual(getResourceId(), faceCaptureResourceEntity.getResourceId()) && this._frames == faceCaptureResourceEntity._frames;
    }

    public final int getFrames() {
        return 1;
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (getResourceId().hashCode() * 31) + Integer.hashCode(this._frames);
    }

    public String toString() {
        return "FaceCaptureResourceEntity(resourceId=" + getResourceId() + ", _frames=" + this._frames + ')';
    }
}
