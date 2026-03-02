package com.yoti.mobile.android.mrtd.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/StateReadFailed;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "error", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;", "(Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;)V", "getError", "()Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StateReadFailed extends MrtdReadState {
    private final MrtdError error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateReadFailed(MrtdError error) {
        super(null);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ StateReadFailed copy$default(StateReadFailed stateReadFailed, MrtdError mrtdError, int i, Object obj) {
        if ((i & 1) != 0) {
            mrtdError = stateReadFailed.error;
        }
        return stateReadFailed.copy(mrtdError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MrtdError getError() {
        return this.error;
    }

    public final StateReadFailed copy(MrtdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new StateReadFailed(error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StateReadFailed) && this.error == ((StateReadFailed) other).error;
    }

    public final MrtdError getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public String toString() {
        return "StateReadFailed(error=" + this.error + ')';
    }
}
