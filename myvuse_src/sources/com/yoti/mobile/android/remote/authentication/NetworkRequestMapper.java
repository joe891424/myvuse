package com.yoti.mobile.android.remote.authentication;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: compiled from: NetworkRequestMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/authentication/NetworkRequestMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lokhttp3/Request;", "Lcom/yoti/mobile/android/remote/authentication/NetworkRequest;", "()V", "map", "from", "mapBody", "", "body", "Lokhttp3/RequestBody;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NetworkRequestMapper implements Mapper<Request, NetworkRequest> {
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public NetworkRequest map(Request from) {
        String str;
        Intrinsics.checkNotNullParameter(from, "from");
        String strMethod = from.method();
        String strReplace$default = StringsKt.replace$default(from.url().encodedPath(), "/idverify/v1", "", false, 4, (Object) null);
        String strEncodedQuery = from.url().encodedQuery();
        if (strEncodedQuery == null || (str = "?" + strEncodedQuery) == null) {
            str = "";
        }
        RequestBody requestBodyBody = from.body();
        return new NetworkRequest(strMethod, strReplace$default, str, requestBodyBody != null ? mapBody(requestBodyBody) : null);
    }

    private final byte[] mapBody(RequestBody body) throws IOException {
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        return buffer.readByteArray();
    }
}
