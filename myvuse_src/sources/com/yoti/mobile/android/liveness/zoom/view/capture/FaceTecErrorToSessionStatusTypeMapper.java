package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecSessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToSessionStatusTypeMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "()V", "map", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "from", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceTecErrorToSessionStatusTypeMapper extends ErrorToSessionStatusTypeMapper {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FaceTecSessionStatus.values().length];
            iArr[FaceTecSessionStatus.USER_CANCELLED.ordinal()] = 1;
            iArr[FaceTecSessionStatus.USER_CANCELLED_VIA_HARDWARE_BUTTON.ordinal()] = 2;
            iArr[FaceTecSessionStatus.TIMEOUT.ordinal()] = 3;
            iArr[FaceTecSessionStatus.CONTEXT_SWITCH.ordinal()] = 4;
            iArr[FaceTecSessionStatus.LOCKED_OUT.ordinal()] = 5;
            iArr[FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 6;
            iArr[FaceTecSessionStatus.CAMERA_PERMISSION_DENIED.ordinal()] = 7;
            iArr[FaceTecSessionStatus.CAMERA_INITIALIZATION_ISSUE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FaceTecSDKStatus.values().length];
            iArr2[FaceTecSDKStatus.NETWORK_ISSUES.ordinal()] = 1;
            iArr2[FaceTecSDKStatus.VERSION_DEPRECATED.ordinal()] = 2;
            iArr2[FaceTecSDKStatus.INVALID_DEVICE_KEY_IDENTIFIER.ordinal()] = 3;
            iArr2[FaceTecSDKStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 4;
            iArr2[FaceTecSDKStatus.KEY_EXPIRED_OR_INVALID.ordinal()] = 5;
            iArr2[FaceTecSDKStatus.DEVICE_LOCKED_OUT.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public FaceTecErrorToSessionStatusTypeMapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType map(java.lang.Throwable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "from"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError.LivenessFaceTecCaptureError
            r1 = -1
            if (r0 == 0) goto L28
            com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError$LivenessFaceTecCaptureError r3 = (com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError.LivenessFaceTecCaptureError) r3
            com.facetec.sdk.FaceTecSessionStatus r3 = r3.getFaceTecSessionStatus()
            if (r3 != 0) goto L13
            goto L1b
        L13:
            int[] r0 = com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecErrorToSessionStatusTypeMapper.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r1 = r0[r3]
        L1b:
            switch(r1) {
                case 1: goto L25;
                case 2: goto L25;
                case 3: goto L25;
                case 4: goto L25;
                case 5: goto L41;
                case 6: goto L41;
                case 7: goto L22;
                case 8: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L4d
        L1f:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.NO_CAMERA
            goto L54
        L22:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.NO_CAMERA_PERMISSION
            goto L54
        L25:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.USER_CANCELLED_SESSION
            goto L54
        L28:
            boolean r0 = r3 instanceof com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError.LivenessFaceTecInitialisationError
            if (r0 == 0) goto L50
            com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError$LivenessFaceTecInitialisationError r3 = (com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecError.LivenessFaceTecInitialisationError) r3
            com.facetec.sdk.FaceTecSDKStatus r3 = r3.getFaceTecSDKStatus()
            if (r3 != 0) goto L35
            goto L3d
        L35:
            int[] r0 = com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecErrorToSessionStatusTypeMapper.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r1 = r0[r3]
        L3d:
            switch(r1) {
                case 1: goto L4a;
                case 2: goto L47;
                case 3: goto L44;
                case 4: goto L44;
                case 5: goto L44;
                case 6: goto L41;
                default: goto L40;
            }
        L40:
            goto L4d
        L41:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.NO_LOCAL_TRIES_FOR_LIVENESS
            goto L54
        L44:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.UNEXPECTED_INTERNAL_ERROR
            goto L54
        L47:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.SDK_OUT_OF_DATE
            goto L54
        L4a:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.NO_NETWORK
            goto L54
        L4d:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.UNEXPECTED_LIVENESS_ERROR
            goto L54
        L50:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType r3 = super.map(r3)
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecErrorToSessionStatusTypeMapper.map(java.lang.Throwable):com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType");
    }
}
