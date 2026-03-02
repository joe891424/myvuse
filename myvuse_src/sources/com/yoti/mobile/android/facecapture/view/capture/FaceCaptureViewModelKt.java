package com.yoti.mobile.android.facecapture.view.capture;

import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.view.capture.CaptureViewState;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"AUTO_CAPTURE_TIMEOUT_MS", "", "DURATION_GOT_IT_MESSAGE_MS", "FLASH_TIMEOUT_MS", "INITIAL_VIEW_STATE", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "TAG", "", "facecapture_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureViewModelKt {
    private static final long AUTO_CAPTURE_TIMEOUT_MS = 20000;
    private static final long DURATION_GOT_IT_MESSAGE_MS = 1000;
    private static final long FLASH_TIMEOUT_MS = 500;
    private static final CaptureViewState.CaptureInProgress INITIAL_VIEW_STATE = new CaptureViewState.CaptureInProgress(false, false, new ScanFeedback(Integer.valueOf(C4832R.string.yds_face_capture_frame_your_face), null, 2, null), 2, null);
    private static final String TAG = "FaceCaptureViewModel";
}
