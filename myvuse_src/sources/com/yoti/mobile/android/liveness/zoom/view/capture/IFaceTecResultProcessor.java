package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.facetec.sdk.FaceTecSessionResult;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;", "", "processFaceTecResult", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "result", "Lcom/facetec/sdk/FaceTecSessionResult;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IFaceTecResultProcessor {
    Single<FaceTecFiles> processFaceTecResult(FaceTecSessionResult result);
}
