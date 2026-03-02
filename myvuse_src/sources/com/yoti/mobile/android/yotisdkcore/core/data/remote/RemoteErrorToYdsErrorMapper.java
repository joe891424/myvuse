package com.yoti.mobile.android.yotisdkcore.core.data.remote;

import com.yoti.mobile.android.remote.exception.RemoteError;
import com.yoti.mobile.android.remote.interceptor.SigningInterceptorException;
import com.yoti.mobile.android.remote.model.ErrorResponse;
import com.yoti.mobile.android.remote.model.ErrorResponseCode;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsExpiredSessionError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsNetworkError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsNoNetworkError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsServerError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsSessionNotFoundError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsSessionNotReadyError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnauthorizedSessionError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnexpectedError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnprocessableMediaError;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkResourceLockedError;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/RemoteErrorToYdsErrorMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "()V", "map", "from", "mapServerError", "error", "Lcom/yoti/mobile/android/remote/exception/RemoteError$ServerError;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class RemoteErrorToYdsErrorMapper implements Mapper<RemoteError, YotiDocsError> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorResponseCode.values().length];
            iArr[ErrorResponseCode.MESSAGE_SIGNING.ordinal()] = 1;
            iArr[ErrorResponseCode.BAD_TOKEN.ordinal()] = 2;
            iArr[ErrorResponseCode.BAD_SDK_ID.ordinal()] = 3;
            iArr[ErrorResponseCode.MALFORMED_REQUEST.ordinal()] = 4;
            iArr[ErrorResponseCode.AUTHENTICATION_NOT_ALLOWED.ordinal()] = 5;
            iArr[ErrorResponseCode.SESSION_LOCKED.ordinal()] = 6;
            iArr[ErrorResponseCode.SESSION_COMPLETED.ordinal()] = 7;
            iArr[ErrorResponseCode.SESSION_EXPIRED.ordinal()] = 8;
            iArr[ErrorResponseCode.SESSION_NOT_FOUND.ordinal()] = 9;
            iArr[ErrorResponseCode.SESSION_NOT_READY.ordinal()] = 10;
            iArr[ErrorResponseCode.SERVER_ERROR.ordinal()] = 11;
            iArr[ErrorResponseCode.TEMPORARILY_UNAVAILABLE.ordinal()] = 12;
            iArr[ErrorResponseCode.RESOURCE_LOCKED.ordinal()] = 13;
            iArr[ErrorResponseCode.UNPROCESSABLE_MEDIA.ordinal()] = 14;
            iArr[ErrorResponseCode.APP_NOT_FOUND.ordinal()] = 15;
            iArr[ErrorResponseCode.MEDIA_CONTENT_NOT_FOUND.ordinal()] = 16;
            iArr[ErrorResponseCode.TASK_NOT_FOUND.ordinal()] = 17;
            iArr[ErrorResponseCode.PAGE_INDEX_NOT_FOUND.ordinal()] = 18;
            iArr[ErrorResponseCode.CHECK_NOT_FOUND.ordinal()] = 19;
            iArr[ErrorResponseCode.INCOMPLETE.ordinal()] = 20;
            iArr[ErrorResponseCode.REPORT_EXISTS.ordinal()] = 21;
            iArr[ErrorResponseCode.UNSUPPORTED_TYPE.ordinal()] = 22;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public RemoteErrorToYdsErrorMapper() {
    }

    private final YotiDocsError mapServerError(RemoteError.ServerError error) {
        ErrorResponse response = error.getResponse();
        ErrorResponseCode code = response != null ? response.getCode() : null;
        switch (code == null ? -1 : WhenMappings.$EnumSwitchMapping$0[code.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new YotiDocsUnauthorizedSessionError(null, 1, null);
            case 8:
                return new YotiDocsExpiredSessionError(null, 1, null);
            case 9:
                return new YotiDocsSessionNotFoundError(null, 1, null);
            case 10:
                return new YotiDocsSessionNotReadyError(null, 1, null);
            case 11:
            case 12:
                return new YotiDocsServerError(null, 1, null);
            case 13:
                return new YotiSdkResourceLockedError(null, 1, null);
            case 14:
                return new YotiDocsUnprocessableMediaError(null, 1, null);
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return new YotiDocsUnexpectedError(null, 1, null);
            default:
                return new YotiDocsNetworkError(null, 1, null);
        }
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(RemoteError from) {
        YotiDocsError yotiDocsUnexpectedError;
        Intrinsics.checkNotNullParameter(from, "from");
        if (from instanceof RemoteError.ServerError) {
            return mapServerError((RemoteError.ServerError) from);
        }
        if (from instanceof RemoteError.NetworkError) {
            yotiDocsUnexpectedError = from.getCause() instanceof SigningInterceptorException ? new YotiDocsUnauthorizedSessionError(from.getCause()) : new YotiDocsNoNetworkError(((RemoteError.NetworkError) from).getError());
        } else {
            if (!(from instanceof RemoteError.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            yotiDocsUnexpectedError = new YotiDocsUnexpectedError(((RemoteError.UnknownError) from).getError());
        }
        return yotiDocsUnexpectedError;
    }
}
