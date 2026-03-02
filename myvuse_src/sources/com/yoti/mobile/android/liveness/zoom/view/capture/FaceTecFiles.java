package com.yoti.mobile.android.liveness.zoom.view.capture;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "", "frames", "", "", "faceMap", "(Ljava/util/List;Ljava/lang/String;)V", "getFaceMap", "()Ljava/lang/String;", "getFrames", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceTecFiles {
    private final String faceMap;
    private final List<String> frames;

    public FaceTecFiles(List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        this.frames = frames;
        this.faceMap = faceMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FaceTecFiles copy$default(FaceTecFiles faceTecFiles, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = faceTecFiles.frames;
        }
        if ((i & 2) != 0) {
            str = faceTecFiles.faceMap;
        }
        return faceTecFiles.copy(list, str);
    }

    public final List<String> component1() {
        return this.frames;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFaceMap() {
        return this.faceMap;
    }

    public final FaceTecFiles copy(List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        return new FaceTecFiles(frames, faceMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceTecFiles)) {
            return false;
        }
        FaceTecFiles faceTecFiles = (FaceTecFiles) other;
        return Intrinsics.areEqual(this.frames, faceTecFiles.frames) && Intrinsics.areEqual(this.faceMap, faceTecFiles.faceMap);
    }

    public final String getFaceMap() {
        return this.faceMap;
    }

    public final List<String> getFrames() {
        return this.frames;
    }

    public int hashCode() {
        return (this.frames.hashCode() * 31) + this.faceMap.hashCode();
    }

    public String toString() {
        return "FaceTecFiles(frames=" + this.frames + ", faceMap=" + this.faceMap + ')';
    }
}
