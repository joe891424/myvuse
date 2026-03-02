package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializationCallback;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecInitializer;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;", "()V", "initialize", "", "license", "", "callback", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecInitializationCallback;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationFaceTecInitializer implements IFaceTecInitializer {
    @Inject
    public AutomationFaceTecInitializer() {
    }

    @Override // com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer
    public void initialize(String license, FaceTecInitializationCallback callback) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess();
    }
}
