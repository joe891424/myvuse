package com.yoti.mobile.android.liveness.zoom.domain.model;

import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecCaptureEntity;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "resourceId", "", "frames", "", "faceMap", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFaceMap", "()Ljava/lang/String;", "getFrames", "()Ljava/util/List;", "getResourceId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecCaptureEntity implements ILivenessCaptureEntity {
    private final String faceMap;
    private final List<String> frames;
    private final String resourceId;

    public LivenessFaceTecCaptureEntity(String resourceId, List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        this.resourceId = resourceId;
        this.frames = frames;
        this.faceMap = faceMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivenessFaceTecCaptureEntity copy$default(LivenessFaceTecCaptureEntity livenessFaceTecCaptureEntity, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecCaptureEntity.getResourceId();
        }
        if ((i & 2) != 0) {
            list = livenessFaceTecCaptureEntity.frames;
        }
        if ((i & 4) != 0) {
            str2 = livenessFaceTecCaptureEntity.faceMap;
        }
        return livenessFaceTecCaptureEntity.copy(str, list, str2);
    }

    public final String component1() {
        return getResourceId();
    }

    public final List<String> component2() {
        return this.frames;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFaceMap() {
        return this.faceMap;
    }

    public final LivenessFaceTecCaptureEntity copy(String resourceId, List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        return new LivenessFaceTecCaptureEntity(resourceId, frames, faceMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecCaptureEntity)) {
            return false;
        }
        LivenessFaceTecCaptureEntity livenessFaceTecCaptureEntity = (LivenessFaceTecCaptureEntity) other;
        return Intrinsics.areEqual(getResourceId(), livenessFaceTecCaptureEntity.getResourceId()) && Intrinsics.areEqual(this.frames, livenessFaceTecCaptureEntity.frames) && Intrinsics.areEqual(this.faceMap, livenessFaceTecCaptureEntity.faceMap);
    }

    public final String getFaceMap() {
        return this.faceMap;
    }

    public final List<String> getFrames() {
        return this.frames;
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((getResourceId().hashCode() * 31) + this.frames.hashCode()) * 31) + this.faceMap.hashCode();
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity
    public boolean isValid() {
        return this.frames.size() == 3;
    }

    public String toString() {
        return "LivenessFaceTecCaptureEntity(resourceId=" + getResourceId() + ", frames=" + this.frames + ", faceMap=" + this.faceMap + ')';
    }
}
