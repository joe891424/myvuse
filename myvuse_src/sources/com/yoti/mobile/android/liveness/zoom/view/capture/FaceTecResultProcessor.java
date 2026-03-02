package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import com.facetec.sdk.FaceTecSessionResult;
import com.facetec.sdk.FaceTecSessionStatus;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecResultProcessor;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "processFaceTecResult", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "result", "Lcom/facetec/sdk/FaceTecSessionResult;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecResultProcessor implements IFaceTecResultProcessor {
    private final Context context;

    @Inject
    public FaceTecResultProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor
    public Single<FaceTecFiles> processFaceTecResult(FaceTecSessionResult result) {
        LivenessFaceTecError.LivenessFaceTecCaptureError livenessFaceTecCaptureError;
        FaceTecSessionStatus status;
        if ((result != null ? result.getStatus() : null) == FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY) {
            return FaceTecSessionResultUtilsKt.files(result, this.context);
        }
        if (result == null || (status = result.getStatus()) == null || (livenessFaceTecCaptureError = FaceTecStatusToLivenessErrorKt.toFaceTecLivenessError(status)) == null) {
            livenessFaceTecCaptureError = new LivenessFaceTecError.LivenessFaceTecCaptureError(null, 1, null);
        }
        Single<FaceTecFiles> singleError = Single.error(livenessFaceTecCaptureError);
        Intrinsics.checkNotNullExpressionValue(singleError, "{\n                Single…ureError())\n            }");
        return singleError;
    }
}
