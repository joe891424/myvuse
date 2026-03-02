package com.yoti.mobile.android.liveness.zoom.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecResourceRequestParams;", "", "source", "", "requirementId", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecResourceRequestParams {

    @SerializedName("requirement_id")
    private final String requirementId;

    @SerializedName("source")
    private final String source;

    public LivenessFaceTecResourceRequestParams(String source, String requirementId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        this.source = source;
        this.requirementId = requirementId;
    }

    public /* synthetic */ LivenessFaceTecResourceRequestParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "NATIVE" : str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getRequirementId() {
        return this.requirementId;
    }

    public static /* synthetic */ LivenessFaceTecResourceRequestParams copy$default(LivenessFaceTecResourceRequestParams livenessFaceTecResourceRequestParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecResourceRequestParams.source;
        }
        if ((i & 2) != 0) {
            str2 = livenessFaceTecResourceRequestParams.requirementId;
        }
        return livenessFaceTecResourceRequestParams.copy(str, str2);
    }

    public final LivenessFaceTecResourceRequestParams copy(String source, String requirementId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        return new LivenessFaceTecResourceRequestParams(source, requirementId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecResourceRequestParams)) {
            return false;
        }
        LivenessFaceTecResourceRequestParams livenessFaceTecResourceRequestParams = (LivenessFaceTecResourceRequestParams) other;
        return Intrinsics.areEqual(this.source, livenessFaceTecResourceRequestParams.source) && Intrinsics.areEqual(this.requirementId, livenessFaceTecResourceRequestParams.requirementId);
    }

    public int hashCode() {
        return (this.source.hashCode() * 31) + this.requirementId.hashCode();
    }

    public String toString() {
        return "LivenessFaceTecResourceRequestParams(source=" + this.source + ", requirementId=" + this.requirementId + ')';
    }
}
