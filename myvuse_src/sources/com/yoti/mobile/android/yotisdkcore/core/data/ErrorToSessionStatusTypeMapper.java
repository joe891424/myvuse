package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsExpiredSessionError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsNetworkError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsNoNetworkError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsServerError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsSessionNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsSessionNotReadyError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnauthorizedSessionError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnprocessableMediaError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKDocumentCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKFaceCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKSupplementaryDocumentCaptureDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSDKZoomLivenessDependencyNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkIncompatibleError;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0017¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "()V", "map", "from", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class ErrorToSessionStatusTypeMapper implements Mapper<Throwable, SessionStatusType> {
    @Inject
    public ErrorToSessionStatusTypeMapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SessionStatusType map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (from instanceof YotiDocsNoNetworkError) {
            return SessionStatusType.NO_NETWORK;
        }
        if (from instanceof YotiDocsSessionNotFoundError) {
            return SessionStatusType.SESSION_NOT_FOUND;
        }
        if (from instanceof YotiDocsSessionNotReadyError) {
            return SessionStatusType.UNSUPPORTED_CONFIGURATION;
        }
        if (from instanceof YotiDocsUnauthorizedSessionError) {
            return SessionStatusType.UNAUTHORISED_REQUEST;
        }
        if (from instanceof YotiDocsExpiredSessionError) {
            return SessionStatusType.SESSION_EXPIRED;
        }
        if (from instanceof YotiDocsServerError) {
            return SessionStatusType.SERVICE_DOWN;
        }
        if (from instanceof YotiDocsNetworkError) {
            return SessionStatusType.NETWORK_ERROR;
        }
        if (from instanceof YotiSDKDocumentCaptureDependencyNotFoundError) {
            return SessionStatusType.DOCUMENT_CAPTURE_NOT_FOUND_ERROR;
        }
        if (from instanceof YotiSDKZoomLivenessDependencyNotFoundError) {
            return SessionStatusType.ZOOM_LIVENESS_NOT_FOUND_ERROR;
        }
        if (from instanceof YotiSDKSupplementaryDocumentCaptureDependencyNotFoundError) {
            return SessionStatusType.SUPPLEMENTARY_DOCUMENT_NOT_FOUND_ERROR;
        }
        if (from instanceof YotiSDKFaceCaptureDependencyNotFoundError) {
            return SessionStatusType.FACE_CAPTURE_NOT_FOUND_ERROR;
        }
        if (!(from instanceof YotiSdkIncompatibleError)) {
            if (from instanceof YotiDocsUnprocessableMediaError) {
                return SessionStatusType.INSTANCE.getDefault();
            }
            if (from instanceof IOException) {
                return SessionStatusType.STORAGE_ERROR;
            }
            if (!(from instanceof RuntimeException) || !(from.getCause() instanceof YotiSdkIncompatibleError)) {
                return SessionStatusType.UNEXPECTED_INTERNAL_ERROR;
            }
        }
        return SessionStatusType.SDK_OUT_OF_DATE;
    }
}
