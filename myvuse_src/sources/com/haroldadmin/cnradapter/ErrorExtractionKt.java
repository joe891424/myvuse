package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import com.haroldadmin.cnradapter.NetworkResponse;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: ErrorExtraction.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00040\bH\u0000\u001a@\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00040\u000b\"\b\b\u0000\u0010\f*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\r2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00040\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"UNKNOWN_ERROR_RESPONSE_CODE", "", "extractFromHttpException", "Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", ExifInterface.LONGITUDE_EAST, "", "Lretrofit2/HttpException;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "extractNetworkResponse", "Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.LATITUDE_SOUTH, "", "coroutines-network-response-adapter"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class ErrorExtractionKt {
    public static final int UNKNOWN_ERROR_RESPONSE_CODE = 520;

    public static final <E> NetworkResponse.ServerError<E> extractFromHttpException(HttpException extractFromHttpException, Converter<ResponseBody, E> errorConverter) {
        Intrinsics.checkParameterIsNotNull(extractFromHttpException, "$this$extractFromHttpException");
        Intrinsics.checkParameterIsNotNull(errorConverter, "errorConverter");
        Response<?> response = extractFromHttpException.response();
        E eConvert = null;
        ResponseBody responseBodyErrorBody = response != null ? response.errorBody() : null;
        Response<?> response2 = extractFromHttpException.response();
        int iCode = response2 != null ? response2.code() : UNKNOWN_ERROR_RESPONSE_CODE;
        Response<?> response3 = extractFromHttpException.response();
        Headers headers = response3 != null ? response3.headers() : null;
        if (responseBodyErrorBody != null && responseBodyErrorBody.getContentLength() != 0) {
            try {
                eConvert = errorConverter.convert(responseBodyErrorBody);
            } catch (Exception unused) {
                return new NetworkResponse.ServerError<>(null, iCode, headers);
            }
        }
        return new NetworkResponse.ServerError<>(eConvert, iCode, headers);
    }

    public static final <S, E> NetworkResponse<S, E> extractNetworkResponse(Throwable extractNetworkResponse, Converter<ResponseBody, E> errorConverter) {
        Intrinsics.checkParameterIsNotNull(extractNetworkResponse, "$this$extractNetworkResponse");
        Intrinsics.checkParameterIsNotNull(errorConverter, "errorConverter");
        return extractNetworkResponse instanceof IOException ? new NetworkResponse.NetworkError((IOException) extractNetworkResponse) : extractNetworkResponse instanceof HttpException ? extractFromHttpException((HttpException) extractNetworkResponse, errorConverter) : new NetworkResponse.UnknownError(extractNetworkResponse);
    }
}
