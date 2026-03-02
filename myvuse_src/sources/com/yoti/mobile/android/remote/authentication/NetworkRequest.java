package com.yoti.mobile.android.remote.authentication;

import com.google.android.gms.actions.SearchIntents;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/authentication/NetworkRequest;", "", "method", "", "path", SearchIntents.EXTRA_QUERY, "body", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V", "getBody", "()[B", "getMethod", "()Ljava/lang/String;", "getPath", "getQuery", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class NetworkRequest {
    private final byte[] body;
    private final String method;
    private final String path;
    private final String query;

    public static /* synthetic */ NetworkRequest copy$default(NetworkRequest networkRequest, String str, String str2, String str3, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkRequest.method;
        }
        if ((i & 2) != 0) {
            str2 = networkRequest.path;
        }
        if ((i & 4) != 0) {
            str3 = networkRequest.query;
        }
        if ((i & 8) != 0) {
            bArr = networkRequest.body;
        }
        return networkRequest.copy(str, str2, str3, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final byte[] getBody() {
        return this.body;
    }

    public final NetworkRequest copy(String method, String path, String query, byte[] body) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(query, "query");
        return new NetworkRequest(method, path, query, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) other;
        return Intrinsics.areEqual(this.method, networkRequest.method) && Intrinsics.areEqual(this.path, networkRequest.path) && Intrinsics.areEqual(this.query, networkRequest.query) && Intrinsics.areEqual(this.body, networkRequest.body);
    }

    public int hashCode() {
        int iHashCode = ((((this.method.hashCode() * 31) + this.path.hashCode()) * 31) + this.query.hashCode()) * 31;
        byte[] bArr = this.body;
        return iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public String toString() {
        return "NetworkRequest(method=" + this.method + ", path=" + this.path + ", query=" + this.query + ", body=" + Arrays.toString(this.body) + ')';
    }

    public NetworkRequest(String method, String path, String query, byte[] bArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(query, "query");
        this.method = method;
        this.path = path;
        this.query = query;
        this.body = bArr;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getQuery() {
        return this.query;
    }

    public final byte[] getBody() {
        return this.body;
    }
}
