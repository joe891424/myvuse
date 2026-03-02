package com.yoti.mobile.android.remote;

import com.haroldadmin.cnradapter.NetworkResponse;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.remote.exception.RemoteError;
import com.yoti.mobile.android.remote.model.ErrorResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkResponseToRemoteResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m5598d2 = {"toEither", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "SuccessType", "", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "Lcom/yoti/mobile/android/remote/model/ErrorResponse;", "remote_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NetworkResponseToRemoteResponseKt {
    public static final <SuccessType> Either<RemoteError, SuccessType> toEither(NetworkResponse<? extends SuccessType, ErrorResponse> networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "<this>");
        if (networkResponse instanceof NetworkResponse.NetworkError) {
            return new Either.Failure(new RemoteError.NetworkError(((NetworkResponse.NetworkError) networkResponse).getError()));
        }
        if (networkResponse instanceof NetworkResponse.ServerError) {
            NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) networkResponse;
            return new Either.Failure(new RemoteError.ServerError(serverError.getCode(), (ErrorResponse) serverError.getBody()));
        }
        if (networkResponse instanceof NetworkResponse.UnknownError) {
            return new Either.Failure(new RemoteError.UnknownError(((NetworkResponse.UnknownError) networkResponse).getError()));
        }
        if (networkResponse instanceof NetworkResponse.Success) {
            return new Either.Success(((NetworkResponse.Success) networkResponse).getBody());
        }
        throw new NoWhenBranchMatchedException();
    }
}
