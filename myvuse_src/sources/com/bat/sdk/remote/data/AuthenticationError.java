package com.bat.sdk.remote.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: AuthenticationError.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/remote/data/AuthenticationError;", "", "request", "Lokhttp3/Request;", "response", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getRequest", "()Lokhttp3/Request;", "getResponse", "()Lokhttp3/Response;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class AuthenticationError {
    private final Request request;
    private final Response response;

    public static /* synthetic */ AuthenticationError copy$default(AuthenticationError authenticationError, Request request, Response response, int i, Object obj) {
        if ((i & 1) != 0) {
            request = authenticationError.request;
        }
        if ((i & 2) != 0) {
            response = authenticationError.response;
        }
        return authenticationError.copy(request, response);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Response getResponse() {
        return this.response;
    }

    public final AuthenticationError copy(Request request, Response response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        return new AuthenticationError(request, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationError)) {
            return false;
        }
        AuthenticationError authenticationError = (AuthenticationError) other;
        return Intrinsics.areEqual(this.request, authenticationError.request) && Intrinsics.areEqual(this.response, authenticationError.response);
    }

    public int hashCode() {
        return (this.request.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "AuthenticationError(request=" + this.request + ", response=" + this.response + ')';
    }

    public AuthenticationError(Request request, Response response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        this.request = request;
        this.response = response;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final Response getResponse() {
        return this.response;
    }
}
