package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecSessionStatus;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecFailureType;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToFailureMapper;", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "()V", "map", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "from", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecErrorToFailureMapper extends ExceptionToFailureMapper {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FaceTecSessionStatus.values().length];
            iArr[FaceTecSessionStatus.USER_CANCELLED.ordinal()] = 1;
            iArr[FaceTecSessionStatus.USER_CANCELLED_VIA_HARDWARE_BUTTON.ordinal()] = 2;
            iArr[FaceTecSessionStatus.LOCKED_OUT.ordinal()] = 3;
            iArr[FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FaceTecSDKStatus.values().length];
            iArr2[FaceTecSDKStatus.NETWORK_ISSUES.ordinal()] = 1;
            iArr2[FaceTecSDKStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 2;
            iArr2[FaceTecSDKStatus.DEVICE_LOCKED_OUT.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public FaceTecErrorToFailureMapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    public YdsFailure map(Throwable from) {
        int i;
        YdsFailure ydsFailure;
        Intrinsics.checkNotNullParameter(from, "from");
        LivenessFaceTecError livenessFaceTecError = from instanceof LivenessFaceTecError ? (LivenessFaceTecError) from : null;
        boolean zIsRetryAllowed = livenessFaceTecError != null ? livenessFaceTecError.getF7491a() : false;
        if (from instanceof LivenessFaceTecError.LivenessFaceTecCaptureError) {
            FaceTecSessionStatus faceTecSessionStatus = ((LivenessFaceTecError.LivenessFaceTecCaptureError) from).getFaceTecSessionStatus();
            i = faceTecSessionStatus != null ? WhenMappings.$EnumSwitchMapping$0[faceTecSessionStatus.ordinal()] : -1;
            if (i == 1 || i == 2) {
                ydsFailure = new YdsFailure(LivenessFaceTecFailureType.FaceTecSessionCancelledFailure.INSTANCE, zIsRetryAllowed, from);
            } else if (i == 3 || i == 4) {
                ydsFailure = new YdsFailure(LivenessFaceTecFailureType.NoLocalAttemptsFailure.INSTANCE, zIsRetryAllowed, from);
            } else {
                if (zIsRetryAllowed) {
                    return new YdsFailure(LivenessFaceTecFailureType.FaceTecFaceCaptureFailure.INSTANCE, false, from, 2, null);
                }
                ydsFailure = new YdsFailure(YdsFailureType.SomethingWentWrong.INSTANCE, zIsRetryAllowed, from);
            }
        } else {
            if (!(from instanceof LivenessFaceTecError.LivenessFaceTecInitialisationError)) {
                return super.map(from);
            }
            FaceTecSDKStatus faceTecSDKStatus = ((LivenessFaceTecError.LivenessFaceTecInitialisationError) from).getFaceTecSDKStatus();
            i = faceTecSDKStatus != null ? WhenMappings.$EnumSwitchMapping$1[faceTecSDKStatus.ordinal()] : -1;
            if (i == 1) {
                ydsFailure = new YdsFailure(YdsFailureType.NetworkNotAvailable.INSTANCE, zIsRetryAllowed, from);
            } else if (i == 2 || i == 3) {
                ydsFailure = new YdsFailure(LivenessFaceTecFailureType.NoLocalAttemptsFailure.INSTANCE, zIsRetryAllowed, from);
            } else {
                if (zIsRetryAllowed) {
                    return new YdsFailure(null, false, from, 3, null);
                }
                ydsFailure = new YdsFailure(YdsFailureType.SomethingWentWrong.INSTANCE, zIsRetryAllowed, from);
            }
        }
        return ydsFailure;
    }
}
