package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import com.haroldadmin.cnradapter.NetworkResponse;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/* JADX INFO: compiled from: ResponseHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0000\u0010\u0005*\u00020\u0001\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00060\f¨\u0006\u000e"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/ResponseHandler;", "", "()V", "handle", "Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "response", "Lretrofit2/Response;", "successBodyType", "Ljava/lang/reflect/Type;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class ResponseHandler {
    public static final ResponseHandler INSTANCE = new ResponseHandler();

    private ResponseHandler() {
    }

    public final <S, E> NetworkResponse<S, E> handle(Response<S> response, Type successBodyType, Converter<ResponseBody, E> errorConverter) {
        NetworkResponse.UnknownError unknownError;
        Intrinsics.checkParameterIsNotNull(response, "response");
        Intrinsics.checkParameterIsNotNull(successBodyType, "successBodyType");
        Intrinsics.checkParameterIsNotNull(errorConverter, "errorConverter");
        S sBody = response.body();
        Headers headers = response.headers();
        int iCode = response.code();
        ResponseBody responseBodyErrorBody = response.errorBody();
        if (!response.isSuccessful()) {
            try {
                unknownError = new NetworkResponse.ServerError(errorConverter.convert(responseBodyErrorBody), iCode, headers);
            } catch (Exception e) {
                unknownError = new NetworkResponse.UnknownError(e);
            }
            return unknownError;
        }
        if (sBody != null) {
            return new NetworkResponse.Success(sBody, headers, iCode);
        }
        if (Intrinsics.areEqual(successBodyType, Unit.class)) {
            return new NetworkResponse.Success(Unit.INSTANCE, headers, iCode);
        }
        return new NetworkResponse.ServerError(null, iCode, headers);
    }
}
