package com.yoti.mobile.android.remote.exception;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
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
import java.io.IOException;
import java.io.Reader;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: RemoteExceptionToEntityMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "map", "from", "mapServerException", "httpException", "Lretrofit2/HttpException;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class RemoteExceptionToEntityMapper implements Mapper<Throwable, YotiDocsError> {
    private final Gson gson;

    /* JADX INFO: compiled from: RemoteExceptionToEntityMapper.kt */
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
    public RemoteExceptionToEntityMapper(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(Throwable from) {
        YotiDocsError map;
        Intrinsics.checkNotNullParameter(from, "from");
        if (from instanceof HttpException) {
            return mapServerException((HttpException) from);
        }
        if (from instanceof IOException) {
            return new YotiDocsNoNetworkError(from);
        }
        if (!(from instanceof RuntimeException)) {
            return new YotiDocsUnexpectedError(from);
        }
        Throwable cause = from.getCause();
        return (cause == null || (map = map(cause)) == null) ? new YotiDocsUnexpectedError(from) : map;
    }

    private final YotiDocsError mapServerException(HttpException httpException) {
        ResponseBody responseBodyErrorBody;
        Gson gson = this.gson;
        Response<?> response = httpException.response();
        Reader readerCharStream = (response == null || (responseBodyErrorBody = response.errorBody()) == null) ? null : responseBodyErrorBody.charStream();
        ErrorResponse errorResponse = (ErrorResponse) (!(gson instanceof Gson) ? gson.fromJson(readerCharStream, ErrorResponse.class) : GsonInstrumentation.fromJson(gson, readerCharStream, ErrorResponse.class));
        ErrorResponseCode code = errorResponse != null ? errorResponse.getCode() : null;
        switch (code == null ? -1 : WhenMappings.$EnumSwitchMapping$0[code.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new YotiDocsUnauthorizedSessionError(httpException);
            case 8:
                return new YotiDocsExpiredSessionError(httpException);
            case 9:
                return new YotiDocsSessionNotFoundError(httpException);
            case 10:
                return new YotiDocsSessionNotReadyError(httpException);
            case 11:
            case 12:
                return new YotiDocsServerError(httpException);
            case 13:
                return new YotiSdkResourceLockedError(httpException);
            case 14:
                return new YotiDocsUnprocessableMediaError(httpException);
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return new YotiDocsUnexpectedError(httpException);
            default:
                return new YotiDocsNetworkError(httpException);
        }
    }
}
