package com.yoti.mobile.android.facecapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.liveness.data.remote.model.LivenessUploadResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponse;", "Lcom/yoti/mobile/android/liveness/data/remote/model/LivenessUploadResponse;", "code", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;", "accepted", "", "retriesRemaining", "", "(Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;ZI)V", "getCode", "()Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureUploadResponse extends LivenessUploadResponse {

    @SerializedName("code")
    private final FaceCaptureUploadResponseCode code;

    public FaceCaptureUploadResponse(FaceCaptureUploadResponseCode faceCaptureUploadResponseCode, boolean z, int i) {
        super(z, i);
        this.code = faceCaptureUploadResponseCode;
    }

    public final FaceCaptureUploadResponseCode getCode() {
        return this.code;
    }
}
