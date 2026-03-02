package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: compiled from: NetworkResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0004\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "()V", "NetworkError", "ServerError", "Success", "UnknownError", "Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", "Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", "Lcom/haroldadmin/cnradapter/NetworkResponse$NetworkError;", "Lcom/haroldadmin/cnradapter/NetworkResponse$UnknownError;", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public abstract class NetworkResponse<T, U> {
    private NetworkResponse() {
    }

    public /* synthetic */ NetworkResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B!\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "", "body", "headers", "Lokhttp3/Headers;", "code", "", "(Ljava/lang/Object;Lokhttp3/Headers;I)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getCode", "()I", "getHeaders", "()Lokhttp3/Headers;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Lokhttp3/Headers;I)Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", "equals", "", "other", "hashCode", "toString", "", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final /* data */ class Success<T> extends NetworkResponse {
        private final T body;
        private final int code;
        private final Headers headers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, Headers headers, int i, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = success.body;
            }
            if ((i2 & 2) != 0) {
                headers = success.headers;
            }
            if ((i2 & 4) != 0) {
                i = success.code;
            }
            return success.copy(obj, headers, i);
        }

        public final T component1() {
            return this.body;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final Success<T> copy(T body, Headers headers, int code) {
            Intrinsics.checkParameterIsNotNull(body, "body");
            return new Success<>(body, headers, code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.body, success.body) && Intrinsics.areEqual(this.headers, success.headers) && this.code == success.code;
        }

        public int hashCode() {
            T t = this.body;
            int iHashCode = (t != null ? t.hashCode() : 0) * 31;
            Headers headers = this.headers;
            return ((iHashCode + (headers != null ? headers.hashCode() : 0)) * 31) + this.code;
        }

        public String toString() {
            return "Success(body=" + this.body + ", headers=" + this.headers + ", code=" + this.code + ")";
        }

        public final T getBody() {
            return this.body;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Success(Object obj, Headers headers, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i2 & 2) != 0) {
                headers = null;
            }
            this(obj, headers, i);
        }

        public final Headers getHeaders() {
            return this.headers;
        }

        public final int getCode() {
            return this.code;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T body, Headers headers, int i) {
            super(null);
            Intrinsics.checkParameterIsNotNull(body, "body");
            this.body = body;
            this.headers = headers;
            this.code = i;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", "U", "", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "", "body", "code", "", "headers", "Lokhttp3/Headers;", "(Ljava/lang/Object;ILokhttp3/Headers;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getCode", "()I", "getHeaders", "()Lokhttp3/Headers;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;ILokhttp3/Headers;)Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", "equals", "", "other", "hashCode", "toString", "", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final /* data */ class ServerError<U> extends NetworkResponse {
        private final U body;
        private final int code;
        private final Headers headers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ServerError copy$default(ServerError serverError, Object obj, int i, Headers headers, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = serverError.body;
            }
            if ((i2 & 2) != 0) {
                i = serverError.code;
            }
            if ((i2 & 4) != 0) {
                headers = serverError.headers;
            }
            return serverError.copy(obj, i, headers);
        }

        public final U component1() {
            return this.body;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }

        public final ServerError<U> copy(U body, int code, Headers headers) {
            return new ServerError<>(body, code, headers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            ServerError serverError = (ServerError) other;
            return Intrinsics.areEqual(this.body, serverError.body) && this.code == serverError.code && Intrinsics.areEqual(this.headers, serverError.headers);
        }

        public int hashCode() {
            U u = this.body;
            int iHashCode = (((u != null ? u.hashCode() : 0) * 31) + this.code) * 31;
            Headers headers = this.headers;
            return iHashCode + (headers != null ? headers.hashCode() : 0);
        }

        public String toString() {
            return "ServerError(body=" + this.body + ", code=" + this.code + ", headers=" + this.headers + ")";
        }

        public final U getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ServerError(Object obj, int i, Headers headers, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i2 & 4) != 0) {
                headers = null;
            }
            this(obj, i, headers);
        }

        public final Headers getHeaders() {
            return this.headers;
        }

        public ServerError(U u, int i, Headers headers) {
            super(null);
            this.body = u;
            this.code = i;
            this.headers = headers;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$NetworkError;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "", "error", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getError", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final /* data */ class NetworkError extends NetworkResponse {
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
            Intrinsics.checkParameterIsNotNull(error, "error");
            return new NetworkError(error);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof NetworkError) && Intrinsics.areEqual(this.error, ((NetworkError) other).error);
            }
            return true;
        }

        public int hashCode() {
            IOException iOException = this.error;
            if (iOException != null) {
                return iOException.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "NetworkError(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(IOException error) {
            super(null);
            Intrinsics.checkParameterIsNotNull(error, "error");
            this.error = error;
        }

        public final IOException getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$UnknownError;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final /* data */ class UnknownError extends NetworkResponse {
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
            Intrinsics.checkParameterIsNotNull(error, "error");
            return new UnknownError(error);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UnknownError) && Intrinsics.areEqual(this.error, ((UnknownError) other).error);
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.error;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "UnknownError(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(Throwable error) {
            super(null);
            Intrinsics.checkParameterIsNotNull(error, "error");
            this.error = error;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
