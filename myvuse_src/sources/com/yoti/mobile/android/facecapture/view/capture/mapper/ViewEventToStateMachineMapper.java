package com.yoti.mobile.android.facecapture.view.capture.mapper;

import androidx.core.app.NotificationCompat;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.FaceCaptureViewEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/mapper/ViewEventToStateMachineMapper;", "", "()V", "map", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ViewEventToStateMachineMapper {
    @Inject
    public ViewEventToStateMachineMapper() {
    }

    public final Event map(FaceCaptureViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FaceCaptureViewEvent.OnCapturePressed) {
            return new Event.OnCapturePressed(((FaceCaptureViewEvent.OnCapturePressed) event).getLightLevel());
        }
        if (event instanceof FaceCaptureViewEvent.OnDetectionResult) {
            FaceCaptureViewEvent.OnDetectionResult onDetectionResult = (FaceCaptureViewEvent.OnDetectionResult) event;
            return ViewEventToStateMachineMapperKt.toStateMachineEvent(onDetectionResult.getResult(), onDetectionResult.getLightLevel());
        }
        if (event instanceof FaceCaptureViewEvent.OnAnalysisStarted ? true : event instanceof FaceCaptureViewEvent.OnCameraError ? true : Intrinsics.areEqual(event, FaceCaptureViewEvent.OnMissingPermissions.INSTANCE) ? true : Intrinsics.areEqual(event, FaceCaptureViewEvent.OnFaceCaptureFinished.INSTANCE)) {
            throw new IllegalArgumentException("The view event " + Reflection.getOrCreateKotlinClass(event.getClass()).getSimpleName() + " cannot be mapped to a state machine event");
        }
        throw new NoWhenBranchMatchedException();
    }
}
