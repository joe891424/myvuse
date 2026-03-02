package com.yoti.mobile.android.liveness.zoom.domain.model;

import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecSessionStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0003¨\u0006\u0004"}, m5598d2 = {"isRetryAllowed", "", "Lcom/facetec/sdk/FaceTecSDKStatus;", "Lcom/facetec/sdk/FaceTecSessionStatus;", "liveness-zoom_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecErrorKt {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FaceTecSDKStatus.values().length];
            iArr[FaceTecSDKStatus.NEVER_INITIALIZED.ordinal()] = 1;
            iArr[FaceTecSDKStatus.INITIALIZED.ordinal()] = 2;
            iArr[FaceTecSDKStatus.NETWORK_ISSUES.ordinal()] = 3;
            iArr[FaceTecSDKStatus.DEVICE_IN_LANDSCAPE_MODE.ordinal()] = 4;
            iArr[FaceTecSDKStatus.DEVICE_IN_REVERSE_PORTRAIT_MODE.ordinal()] = 5;
            iArr[FaceTecSDKStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 6;
            iArr[FaceTecSDKStatus.VERSION_DEPRECATED.ordinal()] = 7;
            iArr[FaceTecSDKStatus.INVALID_DEVICE_KEY_IDENTIFIER.ordinal()] = 8;
            iArr[FaceTecSDKStatus.KEY_EXPIRED_OR_INVALID.ordinal()] = 9;
            iArr[FaceTecSDKStatus.DEVICE_NOT_SUPPORTED.ordinal()] = 10;
            iArr[FaceTecSDKStatus.DEVICE_LOCKED_OUT.ordinal()] = 11;
            iArr[FaceTecSDKStatus.ENCRYPTION_KEY_INVALID.ordinal()] = 12;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FaceTecSessionStatus.values().length];
            iArr2[FaceTecSessionStatus.NON_PRODUCTION_MODE_NETWORK_REQUIRED.ordinal()] = 1;
            iArr2[FaceTecSessionStatus.USER_CANCELLED.ordinal()] = 2;
            iArr2[FaceTecSessionStatus.USER_CANCELLED_VIA_HARDWARE_BUTTON.ordinal()] = 3;
            iArr2[FaceTecSessionStatus.USER_CANCELLED_VIA_CLICKABLE_READY_SCREEN_SUBTEXT.ordinal()] = 4;
            iArr2[FaceTecSessionStatus.SESSION_UNSUCCESSFUL.ordinal()] = 5;
            iArr2[FaceTecSessionStatus.CAMERA_PERMISSION_DENIED.ordinal()] = 6;
            iArr2[FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY.ordinal()] = 7;
            iArr2[FaceTecSessionStatus.TIMEOUT.ordinal()] = 8;
            iArr2[FaceTecSessionStatus.CONTEXT_SWITCH.ordinal()] = 9;
            iArr2[FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED.ordinal()] = 10;
            iArr2[FaceTecSessionStatus.REVERSE_PORTRAIT_NOT_ALLOWED.ordinal()] = 11;
            iArr2[FaceTecSessionStatus.CAMERA_INITIALIZATION_ISSUE.ordinal()] = 12;
            iArr2[FaceTecSessionStatus.NON_PRODUCTION_MODE_KEY_INVALID.ordinal()] = 13;
            iArr2[FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 14;
            iArr2[FaceTecSessionStatus.ENCRYPTION_KEY_INVALID.ordinal()] = 15;
            iArr2[FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR.ordinal()] = 16;
            iArr2[FaceTecSessionStatus.LOCKED_OUT.ordinal()] = 17;
            iArr2[FaceTecSessionStatus.MISSING_GUIDANCE_IMAGES.ordinal()] = 18;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean isRetryAllowed(FaceTecSDKStatus faceTecSDKStatus) {
        switch (faceTecSDKStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[faceTecSDKStatus.ordinal()]) {
            case -1:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return false;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
        }
    }

    public static final boolean isRetryAllowed(FaceTecSessionStatus faceTecSessionStatus) {
        switch (faceTecSessionStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[faceTecSessionStatus.ordinal()]) {
            case -1:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return false;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return true;
        }
    }
}
