package com.yoti.mobile.android.facecapture.data.remote.model;

import com.yoti.mobile.android.liveness.data.remote.model.LivenessValidationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureValidationException;", "Lcom/yoti/mobile/android/liveness/data/remote/model/LivenessValidationException;", "code", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;", "attemptsLeft", "", "(Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;I)V", "getCode", "()Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;", "equals", "", "other", "", "hashCode", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureValidationException extends LivenessValidationException {
    private final FaceCaptureUploadResponseCode code;

    public FaceCaptureValidationException(FaceCaptureUploadResponseCode faceCaptureUploadResponseCode, int i) {
        super(i);
        this.code = faceCaptureUploadResponseCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(FaceCaptureValidationException.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureValidationException");
        }
        FaceCaptureValidationException faceCaptureValidationException = (FaceCaptureValidationException) other;
        return this.code == faceCaptureValidationException.code && getAttemptsLeft() == faceCaptureValidationException.getAttemptsLeft();
    }

    public final FaceCaptureUploadResponseCode getCode() {
        return this.code;
    }

    public int hashCode() {
        FaceCaptureUploadResponseCode faceCaptureUploadResponseCode = this.code;
        return ((faceCaptureUploadResponseCode != null ? faceCaptureUploadResponseCode.hashCode() : 0) * 31) + getAttemptsLeft();
    }
}
