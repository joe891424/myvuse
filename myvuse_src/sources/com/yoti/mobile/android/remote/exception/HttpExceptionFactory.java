package com.yoti.mobile.android.remote.exception;

import com.newrelic.agent.android.util.Constants;
import com.yoti.mobile.android.remote.model.ErrorResponseCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: HttpExceptionFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/HttpExceptionFactory;", "", "()V", "create", "Lretrofit2/HttpException;", "httpCode", "", "code", "Lcom/yoti/mobile/android/remote/model/ErrorResponseCode;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class HttpExceptionFactory {
    public static final HttpExceptionFactory INSTANCE = new HttpExceptionFactory();

    private HttpExceptionFactory() {
    }

    public static /* synthetic */ HttpException create$default(HttpExceptionFactory httpExceptionFactory, int i, ErrorResponseCode errorResponseCode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            errorResponseCode = null;
        }
        return httpExceptionFactory.create(i, errorResponseCode);
    }

    public final HttpException create(int httpCode, ErrorResponseCode code) {
        Response responseError = Response.error(httpCode, ResponseBody.INSTANCE.create("{code: " + (code != null ? code.name() : null) + ", message: error}", MediaType.INSTANCE.get(Constants.Network.ContentType.JSON)));
        Intrinsics.checkNotNullExpressionValue(responseError, "error(\n                h….toMediaType())\n        )");
        return new HttpException(responseError);
    }
}
