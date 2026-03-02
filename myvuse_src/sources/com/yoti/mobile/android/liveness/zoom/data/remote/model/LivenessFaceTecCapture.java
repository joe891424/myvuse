package com.yoti.mobile.android.liveness.zoom.data.remote.model;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecCapture;", "", "resourceId", "", "frames", "", "Ljava/io/File;", "faceMap", "(Ljava/lang/String;Ljava/util/List;Ljava/io/File;)V", "getFaceMap", "()Ljava/io/File;", "fileCount", "", "getFileCount", "()I", "getFrames", "()Ljava/util/List;", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecCapture {
    private final File faceMap;
    private final int fileCount;
    private final List<File> frames;
    private final String resourceId;

    /* JADX WARN: Multi-variable type inference failed */
    public LivenessFaceTecCapture(String resourceId, List<? extends File> frames, File faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        this.resourceId = resourceId;
        this.frames = frames;
        this.faceMap = faceMap;
        this.fileCount = frames.size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivenessFaceTecCapture copy$default(LivenessFaceTecCapture livenessFaceTecCapture, String str, List list, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecCapture.resourceId;
        }
        if ((i & 2) != 0) {
            list = livenessFaceTecCapture.frames;
        }
        if ((i & 4) != 0) {
            file = livenessFaceTecCapture.faceMap;
        }
        return livenessFaceTecCapture.copy(str, list, file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    public final List<File> component2() {
        return this.frames;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final File getFaceMap() {
        return this.faceMap;
    }

    public final LivenessFaceTecCapture copy(String resourceId, List<? extends File> frames, File faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        return new LivenessFaceTecCapture(resourceId, frames, faceMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecCapture)) {
            return false;
        }
        LivenessFaceTecCapture livenessFaceTecCapture = (LivenessFaceTecCapture) other;
        return Intrinsics.areEqual(this.resourceId, livenessFaceTecCapture.resourceId) && Intrinsics.areEqual(this.frames, livenessFaceTecCapture.frames) && Intrinsics.areEqual(this.faceMap, livenessFaceTecCapture.faceMap);
    }

    public final File getFaceMap() {
        return this.faceMap;
    }

    public final int getFileCount() {
        return this.fileCount;
    }

    public final List<File> getFrames() {
        return this.frames;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((this.resourceId.hashCode() * 31) + this.frames.hashCode()) * 31) + this.faceMap.hashCode();
    }

    public String toString() {
        return "LivenessFaceTecCapture(resourceId=" + this.resourceId + ", frames=" + this.frames + ", faceMap=" + this.faceMap + ')';
    }
}
