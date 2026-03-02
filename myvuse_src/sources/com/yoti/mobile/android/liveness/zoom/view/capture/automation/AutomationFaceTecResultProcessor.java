package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import com.facetec.sdk.FaceTecSessionResult;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecFiles;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecResultProcessor;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;", "faceTecLivenessResultProvider", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecLivenessResultProvider;", "(Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecLivenessResultProvider;)V", "processFaceTecResult", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "result", "Lcom/facetec/sdk/FaceTecSessionResult;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationFaceTecResultProcessor implements IFaceTecResultProcessor {
    private final AutomationFaceTecLivenessResultProvider faceTecLivenessResultProvider;

    @Inject
    public AutomationFaceTecResultProcessor(AutomationFaceTecLivenessResultProvider faceTecLivenessResultProvider) {
        Intrinsics.checkNotNullParameter(faceTecLivenessResultProvider, "faceTecLivenessResultProvider");
        this.faceTecLivenessResultProvider = faceTecLivenessResultProvider;
    }

    @Override // com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor
    public Single<FaceTecFiles> processFaceTecResult(FaceTecSessionResult result) {
        Single<FaceTecFiles> singleJust = Single.just(new FaceTecFiles(this.faceTecLivenessResultProvider.getFramesPath(), this.faceTecLivenessResultProvider.getFacemapPath()));
        Intrinsics.checkNotNullExpressionValue(singleJust, "just(\n                Fa…              )\n        )");
        return singleJust;
    }
}
