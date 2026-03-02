package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult;", "", "type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;", "result", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult$ResultType;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult$ResultType;)V", "getResult", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult$ResultType;", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ResultType", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class AssessmentResult {

    @SerializedName("result")
    private final ResultType result;

    @SerializedName("type")
    private final AssessmentType type;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult$ResultType;", "", "(Ljava/lang/String;I)V", "PASS", "FAIL", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum ResultType {
        PASS,
        FAIL
    }

    public AssessmentResult(AssessmentType type, ResultType result) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(result, "result");
        this.type = type;
        this.result = result;
    }

    public static /* synthetic */ AssessmentResult copy$default(AssessmentResult assessmentResult, AssessmentType assessmentType, ResultType resultType, int i, Object obj) {
        if ((i & 1) != 0) {
            assessmentType = assessmentResult.type;
        }
        if ((i & 2) != 0) {
            resultType = assessmentResult.result;
        }
        return assessmentResult.copy(assessmentType, resultType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AssessmentType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ResultType getResult() {
        return this.result;
    }

    public final AssessmentResult copy(AssessmentType type, ResultType result) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(result, "result");
        return new AssessmentResult(type, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssessmentResult)) {
            return false;
        }
        AssessmentResult assessmentResult = (AssessmentResult) other;
        return this.type == assessmentResult.type && this.result == assessmentResult.result;
    }

    public final ResultType getResult() {
        return this.result;
    }

    public final AssessmentType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.result.hashCode();
    }

    public String toString() {
        return "AssessmentResult(type=" + this.type + ", result=" + this.result + ')';
    }
}
