package com.yoti.mobile.android.facecapture.domain.model;

import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureEntity;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "resourceId", "", "capture", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;)V", "getCapture", "()Ljava/io/File;", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureEntity implements ILivenessCaptureEntity {
    private final File capture;
    private final String resourceId;

    public FaceCaptureEntity(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        this.resourceId = resourceId;
        this.capture = capture;
    }

    public static /* synthetic */ FaceCaptureEntity copy$default(FaceCaptureEntity faceCaptureEntity, String str, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faceCaptureEntity.getResourceId();
        }
        if ((i & 2) != 0) {
            file = faceCaptureEntity.capture;
        }
        return faceCaptureEntity.copy(str, file);
    }

    public final String component1() {
        return getResourceId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final File getCapture() {
        return this.capture;
    }

    public final FaceCaptureEntity copy(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        return new FaceCaptureEntity(resourceId, capture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureEntity)) {
            return false;
        }
        FaceCaptureEntity faceCaptureEntity = (FaceCaptureEntity) other;
        return Intrinsics.areEqual(getResourceId(), faceCaptureEntity.getResourceId()) && Intrinsics.areEqual(this.capture, faceCaptureEntity.capture);
    }

    public final File getCapture() {
        return this.capture;
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (getResourceId().hashCode() * 31) + this.capture.hashCode();
    }

    @Override // com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity
    public boolean isValid() {
        return ILivenessCaptureEntity.DefaultImpls.isValid(this);
    }

    public String toString() {
        return "FaceCaptureEntity(resourceId=" + getResourceId() + ", capture=" + this.capture + ')';
    }
}
