package com.yoti.mobile.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/model/ErrorResponse;", "", "_code", "Lcom/yoti/mobile/android/remote/model/ErrorResponseCode;", "_message", "", "(Lcom/yoti/mobile/android/remote/model/ErrorResponseCode;Ljava/lang/String;)V", "get_code", "()Lcom/yoti/mobile/android/remote/model/ErrorResponseCode;", "get_message", "()Ljava/lang/String;", "code", "getCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ErrorResponse {

    @SerializedName("code")
    private final ErrorResponseCode _code;

    @SerializedName("message")
    private final String _message;

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, ErrorResponseCode errorResponseCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            errorResponseCode = errorResponse._code;
        }
        if ((i & 2) != 0) {
            str = errorResponse._message;
        }
        return errorResponse.copy(errorResponseCode, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ErrorResponseCode get_code() {
        return this._code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String get_message() {
        return this._message;
    }

    public final ErrorResponse copy(ErrorResponseCode _code, String _message) {
        return new ErrorResponse(_code, _message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) other;
        return this._code == errorResponse._code && Intrinsics.areEqual(this._message, errorResponse._message);
    }

    public int hashCode() {
        ErrorResponseCode errorResponseCode = this._code;
        int iHashCode = (errorResponseCode == null ? 0 : errorResponseCode.hashCode()) * 31;
        String str = this._message;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ErrorResponse(_code=" + this._code + ", _message=" + this._message + ')';
    }

    public ErrorResponse(ErrorResponseCode errorResponseCode, String str) {
        this._code = errorResponseCode;
        this._message = str;
    }

    public /* synthetic */ ErrorResponse(ErrorResponseCode errorResponseCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : errorResponseCode, (i & 2) != 0 ? null : str);
    }

    public final ErrorResponseCode get_code() {
        return this._code;
    }

    public final String get_message() {
        return this._message;
    }

    public final ErrorResponseCode getCode() {
        ErrorResponseCode errorResponseCode = this._code;
        return errorResponseCode == null ? ErrorResponseCode.UNKNOWN : errorResponseCode;
    }
}
