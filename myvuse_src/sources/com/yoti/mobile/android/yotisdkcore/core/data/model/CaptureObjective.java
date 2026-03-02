package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjective;", "", "type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjectiveType;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjectiveType;)V", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjectiveType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CaptureObjective {

    @SerializedName("type")
    private final CaptureObjectiveType type;

    /* JADX WARN: Multi-variable type inference failed */
    public CaptureObjective() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CaptureObjective(CaptureObjectiveType captureObjectiveType) {
        this.type = captureObjectiveType;
    }

    public /* synthetic */ CaptureObjective(CaptureObjectiveType captureObjectiveType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CaptureObjectiveType.UNKNOWN : captureObjectiveType);
    }

    public static /* synthetic */ CaptureObjective copy$default(CaptureObjective captureObjective, CaptureObjectiveType captureObjectiveType, int i, Object obj) {
        if ((i & 1) != 0) {
            captureObjectiveType = captureObjective.type;
        }
        return captureObjective.copy(captureObjectiveType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CaptureObjectiveType getType() {
        return this.type;
    }

    public final CaptureObjective copy(CaptureObjectiveType type) {
        return new CaptureObjective(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CaptureObjective) && this.type == ((CaptureObjective) other).type;
    }

    public final CaptureObjectiveType getType() {
        return this.type;
    }

    public int hashCode() {
        CaptureObjectiveType captureObjectiveType = this.type;
        if (captureObjectiveType == null) {
            return 0;
        }
        return captureObjectiveType.hashCode();
    }

    public String toString() {
        return "CaptureObjective(type=" + this.type + ')';
    }
}
