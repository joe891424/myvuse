package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecSessionStatus;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0003*\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0005"}, m5598d2 = {"toFaceTecLivenessError", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecInitialisationError;", "Lcom/facetec/sdk/FaceTecSDKStatus;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecCaptureError;", "Lcom/facetec/sdk/FaceTecSessionStatus;", "liveness-zoom_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecStatusToLivenessErrorKt {
    public static final LivenessFaceTecError.LivenessFaceTecCaptureError toFaceTecLivenessError(FaceTecSessionStatus faceTecSessionStatus) {
        return new LivenessFaceTecError.LivenessFaceTecCaptureError(faceTecSessionStatus);
    }

    public static final LivenessFaceTecError.LivenessFaceTecInitialisationError toFaceTecLivenessError(FaceTecSDKStatus faceTecSDKStatus) {
        return new LivenessFaceTecError.LivenessFaceTecInitialisationError(faceTecSDKStatus);
    }
}
