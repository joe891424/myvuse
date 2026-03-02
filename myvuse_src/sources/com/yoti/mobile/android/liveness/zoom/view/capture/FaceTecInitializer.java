package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.facetec.sdk.FaceTecAuditTrailType;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecCustomization;
import com.facetec.sdk.FaceTecFeedbackCustomization;
import com.facetec.sdk.FaceTecFrameCustomization;
import com.facetec.sdk.FaceTecGuidanceCustomization;
import com.facetec.sdk.FaceTecOvalCustomization;
import com.facetec.sdk.FaceTecOverlayCustomization;
import com.facetec.sdk.FaceTecResultScreenCustomization;
import com.facetec.sdk.FaceTecSDK;
import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForMainThread;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecInitializer;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;", "context", "Landroid/content/Context;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "sessionStatusTypeMapper", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToSessionStatusTypeMapper;", "failureMapper", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToFailureMapper;", "postExecutionThread", "Lio/reactivex/Scheduler;", "(Landroid/content/Context;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToSessionStatusTypeMapper;Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToFailureMapper;Lio/reactivex/Scheduler;)V", "initialize", "", "license", "", "callback", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecInitializationCallback;", "onFaceTecCompletion", "successful", "", "faceTecSDKStatus", "Lcom/facetec/sdk/FaceTecSDKStatus;", "Companion", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecInitializer implements IFaceTecInitializer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final FaceTecErrorToFailureMapper failureMapper;
    private final Scheduler postExecutionThread;
    private final SessionStatus sessionStatus;
    private final FaceTecErrorToSessionStatusTypeMapper sessionStatusTypeMapper;

    @Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u000eH\u0002¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecInitializer$Companion;", "", "()V", "cancelButtonCustomization", "Lcom/facetec/sdk/FaceTecCancelButtonCustomization;", "faceTecCustomization", "Lcom/facetec/sdk/FaceTecCustomization;", "context", "Landroid/content/Context;", "feedbackCustomization", "Lcom/facetec/sdk/FaceTecFeedbackCustomization;", "frameCustomization", "Lcom/facetec/sdk/FaceTecFrameCustomization;", "guidanceCustomization", "Lcom/facetec/sdk/FaceTecGuidanceCustomization;", "ovalCustomization", "Lcom/facetec/sdk/FaceTecOvalCustomization;", "overlayCustomization", "Lcom/facetec/sdk/FaceTecOverlayCustomization;", "resultScreenCustomization", "Lcom/facetec/sdk/FaceTecResultScreenCustomization;", "vocalGuidanceCustomization", "Lcom/facetec/sdk/FaceTecVocalGuidanceCustomization;", "retryScreenCustomization", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FaceTecCancelButtonCustomization cancelButtonCustomization() {
            FaceTecCancelButtonCustomization faceTecCancelButtonCustomization = new FaceTecCancelButtonCustomization();
            faceTecCancelButtonCustomization.setLocation(FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM);
            faceTecCancelButtonCustomization.customImage = FaceTecInitializerKt.CANCEL_BUTTON_IMAGE_ID;
            faceTecCancelButtonCustomization.setCustomLocation(FaceTecInitializerKt.CANCEL_BUTTON_LOCATION);
            return faceTecCancelButtonCustomization;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FaceTecCustomization faceTecCustomization(Context context) {
            FaceTecCustomization faceTecCustomization = new FaceTecCustomization();
            Companion companion = FaceTecInitializer.INSTANCE;
            faceTecCustomization.setFrameCustomization(companion.frameCustomization(context));
            faceTecCustomization.setGuidanceCustomization(companion.guidanceCustomization(context));
            faceTecCustomization.setCancelButtonCustomization(companion.cancelButtonCustomization());
            faceTecCustomization.setFeedbackCustomization(companion.feedbackCustomization(context));
            faceTecCustomization.setOvalCustomization(companion.ovalCustomization(context));
            faceTecCustomization.setOverlayCustomization(companion.overlayCustomization(context));
            faceTecCustomization.setResultScreenCustomization(companion.resultScreenCustomization());
            faceTecCustomization.vocalGuidanceCustomization = companion.vocalGuidanceCustomization();
            return faceTecCustomization;
        }

        private final FaceTecFeedbackCustomization feedbackCustomization(Context context) {
            FaceTecFeedbackCustomization faceTecFeedbackCustomization = new FaceTecFeedbackCustomization();
            faceTecFeedbackCustomization.backgroundColors = ContextCompat.getColor(context, FaceTecInitializerKt.FEEDBACK_BACKGROUND_COLOR_ID);
            faceTecFeedbackCustomization.cornerRadius = 7;
            faceTecFeedbackCustomization.elevation = 7;
            faceTecFeedbackCustomization.textColor = ContextCompat.getColor(context, FaceTecInitializerKt.FEEDBACK_TEXT_COLOR_ID);
            faceTecFeedbackCustomization.textFont = FaceTecInitializerKt.getHEADER_FONT();
            return faceTecFeedbackCustomization;
        }

        private final FaceTecFrameCustomization frameCustomization(Context context) {
            FaceTecFrameCustomization faceTecFrameCustomization = new FaceTecFrameCustomization();
            faceTecFrameCustomization.backgroundColor = ContextCompat.getColor(context, FaceTecInitializerKt.FRAME_BACKGROUND_COLOR_ID);
            faceTecFrameCustomization.borderWidth = 0;
            return faceTecFrameCustomization;
        }

        private final FaceTecGuidanceCustomization guidanceCustomization(Context context) {
            FaceTecGuidanceCustomization faceTecGuidanceCustomization = new FaceTecGuidanceCustomization();
            faceTecGuidanceCustomization.backgroundColors = ContextCompat.getColor(context, FaceTecInitializerKt.FRAME_BACKGROUND_COLOR_ID);
            faceTecGuidanceCustomization.foregroundColor = ContextCompat.getColor(context, FaceTecInitializerKt.FOREGROUND_COLOR_ID);
            faceTecGuidanceCustomization.headerFont = FaceTecInitializerKt.getHEADER_FONT();
            faceTecGuidanceCustomization.subtextFont = FaceTecInitializerKt.getSUBTEXT_FONT();
            faceTecGuidanceCustomization.buttonFont = FaceTecInitializerKt.getBUTTON_FONT();
            faceTecGuidanceCustomization.buttonCornerRadius = 7;
            faceTecGuidanceCustomization.buttonBackgroundNormalColor = ContextCompat.getColor(context, FaceTecInitializerKt.ACCENT_COLOR_ID);
            faceTecGuidanceCustomization.buttonBackgroundHighlightColor = ContextCompat.getColor(context, FaceTecInitializerKt.ACCENT_PRESSED_COLOR_ID);
            faceTecGuidanceCustomization.buttonBackgroundDisabledColor = ContextCompat.getColor(context, FaceTecInitializerKt.ACCENT_DISABLED_COLOR_ID);
            faceTecGuidanceCustomization.buttonTextNormalColor = ContextCompat.getColor(context, FaceTecInitializerKt.GUIDANCE_BUTTON_TEXT_COLOR_ID);
            faceTecGuidanceCustomization.buttonTextDisabledColor = ContextCompat.getColor(context, FaceTecInitializerKt.GUIDANCE_BUTTON_TEXT_DISABLED_COLOR_ID);
            FaceTecInitializer.INSTANCE.retryScreenCustomization(faceTecGuidanceCustomization);
            return faceTecGuidanceCustomization;
        }

        private final FaceTecOvalCustomization ovalCustomization(Context context) {
            FaceTecOvalCustomization faceTecOvalCustomization = new FaceTecOvalCustomization();
            faceTecOvalCustomization.strokeColor = ContextCompat.getColor(context, FaceTecInitializerKt.OVAL_STROKE_COLOR_ID);
            faceTecOvalCustomization.strokeWidth = 0;
            faceTecOvalCustomization.progressColor1 = ContextCompat.getColor(context, FaceTecInitializerKt.OVAL_PROGRESS1_COLOR_ID);
            faceTecOvalCustomization.progressColor2 = ContextCompat.getColor(context, FaceTecInitializerKt.OVAL_PROGRESS2_COLOR_ID);
            faceTecOvalCustomization.progressStrokeWidth = 8;
            return faceTecOvalCustomization;
        }

        private final FaceTecOverlayCustomization overlayCustomization(Context context) {
            FaceTecOverlayCustomization faceTecOverlayCustomization = new FaceTecOverlayCustomization();
            faceTecOverlayCustomization.backgroundColor = ContextCompat.getColor(context, FaceTecInitializerKt.FRAME_BACKGROUND_COLOR_ID);
            faceTecOverlayCustomization.brandingImage = 0;
            faceTecOverlayCustomization.showBrandingImage = false;
            return faceTecOverlayCustomization;
        }

        private final FaceTecResultScreenCustomization resultScreenCustomization() {
            FaceTecResultScreenCustomization faceTecResultScreenCustomization = new FaceTecResultScreenCustomization();
            faceTecResultScreenCustomization.backgroundColors = FaceTecInitializerKt.FRAME_BACKGROUND_COLOR_ID;
            faceTecResultScreenCustomization.foregroundColor = FaceTecInitializerKt.FOREGROUND_COLOR_ID;
            faceTecResultScreenCustomization.showUploadProgressBar = false;
            return faceTecResultScreenCustomization;
        }

        private final void retryScreenCustomization(FaceTecGuidanceCustomization faceTecGuidanceCustomization) {
            faceTecGuidanceCustomization.retryScreenHeaderFont = FaceTecInitializerKt.getHEADER_FONT();
            faceTecGuidanceCustomization.retryScreenSubtextFont = FaceTecInitializerKt.getSUBTEXT_FONT();
            faceTecGuidanceCustomization.retryScreenImageCornerRadius = 7;
            faceTecGuidanceCustomization.retryScreenImageBorderColor = FaceTecInitializerKt.FOREGROUND_COLOR_ID;
        }

        private final FaceTecVocalGuidanceCustomization vocalGuidanceCustomization() {
            FaceTecVocalGuidanceCustomization faceTecVocalGuidanceCustomization = new FaceTecVocalGuidanceCustomization();
            faceTecVocalGuidanceCustomization.mode = FaceTecVocalGuidanceCustomization.VocalGuidanceMode.NO_VOCAL_GUIDANCE;
            return faceTecVocalGuidanceCustomization;
        }
    }

    @Inject
    public FaceTecInitializer(Context context, SessionStatus sessionStatus, FaceTecErrorToSessionStatusTypeMapper sessionStatusTypeMapper, FaceTecErrorToFailureMapper failureMapper, @ForMainThread Scheduler postExecutionThread) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(sessionStatusTypeMapper, "sessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(failureMapper, "failureMapper");
        Intrinsics.checkNotNullParameter(postExecutionThread, "postExecutionThread");
        this.context = context;
        this.sessionStatus = sessionStatus;
        this.sessionStatusTypeMapper = sessionStatusTypeMapper;
        this.failureMapper = failureMapper;
        this.postExecutionThread = postExecutionThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onFaceTecCompletion$lambda-0, reason: not valid java name */
    public static final void m6879onFaceTecCompletion$lambda0(FaceTecSDKStatus faceTecSDKStatus, boolean z, FaceTecInitializationCallback callback, FaceTecInitializer this$0) {
        Intrinsics.checkNotNullParameter(faceTecSDKStatus, "$faceTecSDKStatus");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (faceTecSDKStatus == FaceTecSDKStatus.INITIALIZED && z) {
            callback.onSuccess();
        } else {
            this$0.sessionStatus.setSessionStatus(this$0.sessionStatusTypeMapper.map((Throwable) FaceTecStatusToLivenessErrorKt.toFaceTecLivenessError(faceTecSDKStatus)));
            callback.onError(this$0.failureMapper.map((Throwable) FaceTecStatusToLivenessErrorKt.toFaceTecLivenessError(faceTecSDKStatus)));
        }
    }

    @Override // com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer
    public void initialize(String license, final FaceTecInitializationCallback callback) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FaceTecSDK.setCustomization(INSTANCE.faceTecCustomization(this.context));
        FaceTecSDK.setAuditTrailType(FaceTecAuditTrailType.HEIGHT_640);
        FaceTecSDK.initializeInProductionMode(this.context, license, FaceTecConstantsKt.FACETEC_APP_TOKEN, FaceTecConstantsKt.FACETEC_PUBLIC_KEY, new FaceTecSDK.InitializeCallback() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer.initialize.1
            @Override // com.facetec.sdk.FaceTecSDK.InitializeCallback
            public void onCompletion(boolean successful) {
                FaceTecInitializer faceTecInitializer = FaceTecInitializer.this;
                FaceTecSDKStatus status = FaceTecSDK.getStatus(faceTecInitializer.context);
                Intrinsics.checkNotNullExpressionValue(status, "getStatus(context)");
                faceTecInitializer.onFaceTecCompletion(successful, status, callback);
            }
        });
    }

    public final void onFaceTecCompletion(final boolean successful, final FaceTecSDKStatus faceTecSDKStatus, final FaceTecInitializationCallback callback) {
        Intrinsics.checkNotNullParameter(faceTecSDKStatus, "faceTecSDKStatus");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.postExecutionThread.scheduleDirect(new Runnable() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FaceTecInitializer.m6879onFaceTecCompletion$lambda0(faceTecSDKStatus, successful, callback, this);
            }
        });
    }
}
