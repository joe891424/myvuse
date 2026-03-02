package com.yoti.mobile.android.remote.exception;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.remote.model.ErrorResponse;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0006\u0007\bB\u0013\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "NetworkError", "ServerError", "UnknownError", "Lcom/yoti/mobile/android/remote/exception/RemoteError$ServerError;", "Lcom/yoti/mobile/android/remote/exception/RemoteError$NetworkError;", "Lcom/yoti/mobile/android/remote/exception/RemoteError$UnknownError;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class RemoteError extends Exception {
    public /* synthetic */ RemoteError(Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(th);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/RemoteError$ServerError;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "code", "", "response", "Lcom/yoti/mobile/android/remote/model/ErrorResponse;", "(ILcom/yoti/mobile/android/remote/model/ErrorResponse;)V", "getCode", "()I", "getResponse", "()Lcom/yoti/mobile/android/remote/model/ErrorResponse;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class ServerError extends RemoteError {
        private final int code;
        private final ErrorResponse response;

        public static /* synthetic */ ServerError copy$default(ServerError serverError, int i, ErrorResponse errorResponse, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = serverError.code;
            }
            if ((i2 & 2) != 0) {
                errorResponse = serverError.response;
            }
            return serverError.copy(i, errorResponse);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ErrorResponse getResponse() {
            return this.response;
        }

        public final ServerError copy(int code, ErrorResponse response) {
            return new ServerError(code, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            ServerError serverError = (ServerError) other;
            return this.code == serverError.code && Intrinsics.areEqual(this.response, serverError.response);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.code) * 31;
            ErrorResponse errorResponse = this.response;
            return iHashCode + (errorResponse == null ? 0 : errorResponse.hashCode());
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ServerError(code=" + this.code + ", response=" + this.response + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ServerError(int i, ErrorResponse errorResponse) {
            super(null, 1, 0 == true ? 1 : 0);
            this.code = i;
            this.response = errorResponse;
        }

        public /* synthetic */ ServerError(int i, ErrorResponse errorResponse, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : errorResponse);
        }

        public final int getCode() {
            return this.code;
        }

        public final ErrorResponse getResponse() {
            return this.response;
        }
    }

    private RemoteError(Throwable th) {
        super(th);
    }

    public /* synthetic */ RemoteError(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/RemoteError$NetworkError;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "error", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getError", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NetworkError extends RemoteError {
        private final IOException error;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = networkError.error;
            }
            return networkError.copy(iOException);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IOException getError() {
            return this.error;
        }

        public final NetworkError copy(IOException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new NetworkError(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NetworkError) && Intrinsics.areEqual(this.error, ((NetworkError) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "NetworkError(error=" + this.error + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(IOException error) {
            super(error, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final IOException getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/exception/RemoteError$UnknownError;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class UnknownError extends RemoteError {
        private final Throwable error;

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = unknownError.error;
            }
            return unknownError.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final UnknownError copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new UnknownError(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnknownError) && Intrinsics.areEqual(this.error, ((UnknownError) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "UnknownError(error=" + this.error + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(Throwable error) {
            super(error, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
