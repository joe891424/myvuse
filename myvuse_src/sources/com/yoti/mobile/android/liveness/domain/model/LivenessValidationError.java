package com.yoti.mobile.android.liveness.domain.model;

import com.yoti.mobile.android.yotidocs.common.error.YotiDocsFeatureError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/domain/model/LivenessValidationError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "retriesRemaining", "", "error", "", "(ILjava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getRetriesRemaining", "()I", "equals", "", "other", "", "hashCode", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessValidationError extends YotiDocsFeatureError {
    private final Throwable error;
    private final int retriesRemaining;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessValidationError(int i, Throwable error) {
        super(error, i > 0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.retriesRemaining = i;
        this.error = error;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.liveness.domain.model.LivenessValidationError");
        }
        LivenessValidationError livenessValidationError = (LivenessValidationError) other;
        return this.retriesRemaining == livenessValidationError.retriesRemaining && Intrinsics.areEqual(this.error, livenessValidationError.error);
    }

    public final Throwable getError() {
        return this.error;
    }

    public final int getRetriesRemaining() {
        return this.retriesRemaining;
    }

    public int hashCode() {
        return (this.retriesRemaining * 31) + this.error.hashCode();
    }
}
