package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvClientAssessment;", "", "_type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;", "_scheme", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "_state", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentState;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentState;)V", "get_scheme", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "get_state", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentState;", "get_type", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;", "scheme", "getScheme", "state", "getState", "type", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IbvClientAssessment {

    @SerializedName("scheme")
    private final AssessmentScheme _scheme;

    @SerializedName("state")
    private final AssessmentState _state;

    @SerializedName("type")
    private final AssessmentType _type;

    public IbvClientAssessment() {
        this(null, null, null, 7, null);
    }

    public IbvClientAssessment(AssessmentType assessmentType, AssessmentScheme assessmentScheme, AssessmentState assessmentState) {
        this._type = assessmentType;
        this._scheme = assessmentScheme;
        this._state = assessmentState;
    }

    public /* synthetic */ IbvClientAssessment(AssessmentType assessmentType, AssessmentScheme assessmentScheme, AssessmentState assessmentState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : assessmentType, (i & 2) != 0 ? null : assessmentScheme, (i & 4) != 0 ? null : assessmentState);
    }

    public static /* synthetic */ IbvClientAssessment copy$default(IbvClientAssessment ibvClientAssessment, AssessmentType assessmentType, AssessmentScheme assessmentScheme, AssessmentState assessmentState, int i, Object obj) {
        if ((i & 1) != 0) {
            assessmentType = ibvClientAssessment._type;
        }
        if ((i & 2) != 0) {
            assessmentScheme = ibvClientAssessment._scheme;
        }
        if ((i & 4) != 0) {
            assessmentState = ibvClientAssessment._state;
        }
        return ibvClientAssessment.copy(assessmentType, assessmentScheme, assessmentState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AssessmentType get_type() {
        return this._type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AssessmentScheme get_scheme() {
        return this._scheme;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AssessmentState get_state() {
        return this._state;
    }

    public final IbvClientAssessment copy(AssessmentType _type, AssessmentScheme _scheme, AssessmentState _state) {
        return new IbvClientAssessment(_type, _scheme, _state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IbvClientAssessment)) {
            return false;
        }
        IbvClientAssessment ibvClientAssessment = (IbvClientAssessment) other;
        return this._type == ibvClientAssessment._type && this._scheme == ibvClientAssessment._scheme && this._state == ibvClientAssessment._state;
    }

    public final AssessmentScheme getScheme() {
        AssessmentScheme assessmentScheme = this._scheme;
        return assessmentScheme == null ? AssessmentScheme.UNKNOWN : assessmentScheme;
    }

    public final AssessmentState getState() {
        AssessmentState assessmentState = this._state;
        return assessmentState == null ? AssessmentState.UNKNOWN : assessmentState;
    }

    public final AssessmentType getType() {
        AssessmentType assessmentType = this._type;
        return assessmentType == null ? AssessmentType.UNKNOWN : assessmentType;
    }

    public final AssessmentScheme get_scheme() {
        return this._scheme;
    }

    public final AssessmentState get_state() {
        return this._state;
    }

    public final AssessmentType get_type() {
        return this._type;
    }

    public int hashCode() {
        AssessmentType assessmentType = this._type;
        int iHashCode = (assessmentType == null ? 0 : assessmentType.hashCode()) * 31;
        AssessmentScheme assessmentScheme = this._scheme;
        int iHashCode2 = (iHashCode + (assessmentScheme == null ? 0 : assessmentScheme.hashCode())) * 31;
        AssessmentState assessmentState = this._state;
        return iHashCode2 + (assessmentState != null ? assessmentState.hashCode() : 0);
    }

    public String toString() {
        return "IbvClientAssessment(_type=" + this._type + ", _scheme=" + this._scheme + ", _state=" + this._state + ')';
    }
}
