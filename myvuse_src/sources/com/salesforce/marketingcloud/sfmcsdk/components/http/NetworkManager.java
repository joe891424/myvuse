package com.salesforce.marketingcloud.sfmcsdk.components.http;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.salesforce.marketingcloud.sfmcsdk.components.http.Response;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import com.salesforce.marketingcloud.sfmcsdk.util.NetworkUtils;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p099io.CloseableKt;

/* JADX INFO: compiled from: NetworkManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0016\"\u00020\r¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0001¢\u0006\u0002\b\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0015\u0010$\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\rH\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b'J\u001f\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010)\u001a\u00020\u0019H\u0001¢\u0006\u0002\b*J\u001d\u0010+\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020#H\u0001¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0001¢\u0006\u0002\b/R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u00061"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/http/NetworkManager;", "", "context", "Landroid/content/Context;", "executors", "Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/SdkExecutors;", "networkPreferences", "Landroid/content/SharedPreferences;", "authenticator", "Lcom/salesforce/marketingcloud/sfmcsdk/components/http/Authenticator;", "(Landroid/content/Context;Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/SdkExecutors;Landroid/content/SharedPreferences;Lcom/salesforce/marketingcloud/sfmcsdk/components/http/Authenticator;)V", "requestsInFlight", "", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getRequestsInFlight$sfmcsdk_release$annotations", "()V", "getRequestsInFlight$sfmcsdk_release", "()Ljava/util/Map;", "canMakeRequest", "", "requestNames", "", "([Ljava/lang/String;)Z", "deviceRetryAfterTime", "", "requestName", "deviceRetryAfterTime$sfmcsdk_release", "executeAsync", "", "request", "Lcom/salesforce/marketingcloud/sfmcsdk/components/http/Request;", "callback", "Lcom/salesforce/marketingcloud/sfmcsdk/components/http/Callback;", "executeSync", "Lcom/salesforce/marketingcloud/sfmcsdk/components/http/Response;", "isBlockedByRetryAfter", "isBlockedByRetryAfter$sfmcsdk_release", "makeRequest", "makeRequest$sfmcsdk_release", "recordDeviceRetryAfter", "timestamp", "recordDeviceRetryAfter$sfmcsdk_release", "recordRetryAfter", "response", "recordRetryAfter$sfmcsdk_release", "serverRetryAfterTime", "serverRetryAfterTime$sfmcsdk_release", "Companion", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NetworkManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MAX_SERVER_RETRY = 86400000;
    public static final String TAG = "~$NetworkManager";
    private final Authenticator authenticator;
    private final Context context;
    private final SdkExecutors executors;
    private final SharedPreferences networkPreferences;
    private final Map<String, AtomicBoolean> requestsInFlight;

    public static /* synthetic */ void getRequestsInFlight$sfmcsdk_release$annotations() {
    }

    public NetworkManager(Context context, SdkExecutors executors, SharedPreferences networkPreferences, Authenticator authenticator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(networkPreferences, "networkPreferences");
        this.context = context;
        this.executors = executors;
        this.networkPreferences = networkPreferences;
        this.authenticator = authenticator;
        this.requestsInFlight = new LinkedHashMap();
    }

    public /* synthetic */ NetworkManager(Context context, SdkExecutors sdkExecutors, SharedPreferences sharedPreferences, Authenticator authenticator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, sdkExecutors, sharedPreferences, (i & 8) != 0 ? null : authenticator);
    }

    /* JADX INFO: compiled from: NetworkManager.kt */
    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/http/NetworkManager$Companion;", "", "()V", "MAX_SERVER_RETRY", "", "TAG", "", "getDeviceRetryKey", "requestName", "getDeviceRetryKey$sfmcsdk_release", "getServerRetryKey", "getServerRetryKey$sfmcsdk_release", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getServerRetryKey$sfmcsdk_release(String requestName) {
            Intrinsics.checkNotNullParameter(requestName, "requestName");
            return "retry_server_" + requestName;
        }

        public final String getDeviceRetryKey$sfmcsdk_release(String requestName) {
            Intrinsics.checkNotNullParameter(requestName, "requestName");
            return "retry_device_" + requestName;
        }
    }

    public final Map<String, AtomicBoolean> getRequestsInFlight$sfmcsdk_release() {
        return this.requestsInFlight;
    }

    public final void executeAsync(final Request request, final Callback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SdkExecutorsKt.namedRunnable(this.executors.getNetworkIO(), "network_manager_execute", new Function0<Unit>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeAsync.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Callback callback2 = callback;
                Request request2 = request;
                callback2.onResponse(request2, this.executeSync(request2));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v26, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Request] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Response] */
    /* JADX WARN: Type inference failed for: r3v31, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Request] */
    /* JADX WARN: Type inference failed for: r3v34, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Response] */
    public final Response executeSync(Request request) {
        Authenticator authenticator;
        Intrinsics.checkNotNullParameter(request, "request");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = request;
        try {
            AtomicBoolean atomicBoolean = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean == null || !atomicBoolean.get()) {
                this.requestsInFlight.put(((Request) objectRef.element).getName(), new AtomicBoolean(true));
            } else if (atomicBoolean.get()) {
                return Response.INSTANCE.error$sfmcsdk_release(((Request) objectRef.element).getName() + " request already in-flight", 429);
            }
            AtomicBoolean atomicBoolean2 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(true);
            }
            if (!NetworkUtils.hasConnectivity(this.context)) {
                AtomicBoolean atomicBoolean3 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                if (atomicBoolean3 != null) {
                    atomicBoolean3.set(false);
                }
                return Response.INSTANCE.error$sfmcsdk_release("Device has no network connectivity", 599);
            }
            if (isBlockedByRetryAfter$sfmcsdk_release(((Request) objectRef.element).getName())) {
                AtomicBoolean atomicBoolean4 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                if (atomicBoolean4 != null) {
                    atomicBoolean4.set(false);
                }
                return Response.INSTANCE.error$sfmcsdk_release("Too many requests. " + ((Request) objectRef.element).getName() + " request aborted.", 429);
            }
            NetworkUtils.installProvidersIfNeeded(this.context);
            recordDeviceRetryAfter$sfmcsdk_release$default(this, (Request) objectRef.element, 0L, 2, null);
            Authenticator authenticator2 = this.authenticator;
            if (authenticator2 != null) {
                Pair authTokenHeader$sfmcsdk_release$default = Authenticator.getAuthTokenHeader$sfmcsdk_release$default(authenticator2, false, 1, null);
                if (authTokenHeader$sfmcsdk_release$default == null) {
                    Response responseError$sfmcsdk_release = Response.INSTANCE.error$sfmcsdk_release("Expectation Failed", 417);
                    SFMCSdkLogger.INSTANCE.mo3980w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$executeSync$authHeader$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to get AuthToken header.";
                        }
                    });
                    this.authenticator.deleteCachedToken();
                    AtomicBoolean atomicBoolean5 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                    if (atomicBoolean5 != null) {
                        atomicBoolean5.set(false);
                    }
                    return responseError$sfmcsdk_release;
                }
                objectRef.element = ((Request) objectRef.element).toBuilder$sfmcsdk_release().addOrReplaceHeader((String) authTokenHeader$sfmcsdk_release$default.getFirst(), (String) authTokenHeader$sfmcsdk_release$default.getSecond()).build();
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = makeRequest$sfmcsdk_release((Request) objectRef.element);
            if (((Response) objectRef2.element).getCode() == 401 && (authenticator = this.authenticator) != null) {
                authenticator.deleteCachedToken();
                Pair<String, String> pairRefreshAuthTokenHeader = authenticator.refreshAuthTokenHeader();
                if (pairRefreshAuthTokenHeader != null) {
                    objectRef.element = ((Request) objectRef.element).toBuilder$sfmcsdk_release().addOrReplaceHeader(pairRefreshAuthTokenHeader.getFirst(), pairRefreshAuthTokenHeader.getSecond()).build();
                    ?? MakeRequest$sfmcsdk_release = makeRequest$sfmcsdk_release((Request) objectRef.element);
                    if (MakeRequest$sfmcsdk_release.getCode() == 401) {
                        this.authenticator.deleteCachedToken();
                    }
                    objectRef2.element = MakeRequest$sfmcsdk_release;
                }
            }
            recordRetryAfter$sfmcsdk_release((Request) objectRef.element, (Response) objectRef2.element);
            AtomicBoolean atomicBoolean6 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean6 != null) {
                atomicBoolean6.set(false);
            }
            SFMCSdkLogger.INSTANCE.mo3976d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeSync.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return objectRef.element.getName() + " request to " + objectRef.element.getUrl() + " took " + objectRef2.element.timeToExecute() + "ms and resulted in a " + objectRef2.element.getCode() + " - " + objectRef2.element.getMessage() + " response.";
                }
            });
            return (Response) objectRef2.element;
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.mo3977e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeSync.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Could not complete request.";
                }
            });
            AtomicBoolean atomicBoolean7 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean7 != null) {
                atomicBoolean7.set(false);
            }
            return Response.INSTANCE.error$sfmcsdk_release("An unknown error occurred. The " + ((Request) objectRef.element).getName() + " request to " + ((Request) objectRef.element).getUrl() + " could not be completed.", -999);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, java.net.HttpURLConnection] */
    public final Response makeRequest$sfmcsdk_release(final Request request) {
        final Response responseError$sfmcsdk_release;
        HttpURLConnection httpURLConnection;
        URLConnection uRLConnection;
        Intrinsics.checkNotNullParameter(request, "request");
        long jCurrentTimeMillis = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            try {
                uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(request.getUrl()).openConnection()));
            } catch (Throwable th) {
                AtomicBoolean atomicBoolean = this.requestsInFlight.get(request.getName());
                if (atomicBoolean != null) {
                    atomicBoolean.set(false);
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) objectRef.element;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.mo3977e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to complete request";
                }
            });
            responseError$sfmcsdk_release = Response.INSTANCE.error$sfmcsdk_release(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, -100);
            AtomicBoolean atomicBoolean2 = this.requestsInFlight.get(request.getName());
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(false);
            }
            httpURLConnection = (HttpURLConnection) objectRef.element;
            if (httpURLConnection != null) {
            }
        }
        if (uRLConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        objectRef.element = (HttpURLConnection) uRLConnection;
        ((HttpURLConnection) objectRef.element).setRequestMethod(request.getMethod());
        ((HttpURLConnection) objectRef.element).setDoInput(true);
        ((HttpURLConnection) objectRef.element).setUseCaches(false);
        ((HttpURLConnection) objectRef.element).setAllowUserInteraction(false);
        ((HttpURLConnection) objectRef.element).setConnectTimeout(request.getConnectionTimeout());
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, request.getHeaders().size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                ((HttpURLConnection) objectRef.element).setRequestProperty(request.getHeaders().get(i), request.getHeaders().get(i + 1));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        String requestBody = request.getRequestBody();
        if (requestBody != null) {
            ((HttpURLConnection) objectRef.element).setDoOutput(true);
            SFMCSdkLogger.INSTANCE.mo3976d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return request.getName() + SafeJsonPrimitive.NULL_CHAR + objectRef.element.getRequestMethod() + " initiated\nwith request properties " + objectRef.element.getRequestProperties() + "\nand body " + request.getRequestBody();
                }
            });
            OutputStream outputStream = ((HttpURLConnection) objectRef.element).getOutputStream();
            try {
                byte[] bytes = requestBody.getBytes(RequestKt.getUTF_8());
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
            } finally {
            }
        }
        Response.Builder builder = new Response.Builder();
        builder.code(((HttpURLConnection) objectRef.element).getResponseCode());
        String responseMessage = ((HttpURLConnection) objectRef.element).getResponseMessage();
        Intrinsics.checkNotNullExpressionValue(responseMessage, "connection.responseMessage");
        builder.message(responseMessage);
        Map<String, List<String>> headerFields = ((HttpURLConnection) objectRef.element).getHeaderFields();
        Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
        builder.headers(headerFields);
        try {
            String all = FileUtilsKt.readAll(((HttpURLConnection) objectRef.element).getInputStream());
            if (all != null) {
                builder.body(all);
            }
        } catch (IOException unused) {
            String all2 = FileUtilsKt.readAll(((HttpURLConnection) objectRef.element).getErrorStream());
            if (all2 != null) {
                builder.body(all2);
            }
        }
        builder.startTimeMillis(jCurrentTimeMillis);
        builder.endTimeMillis(System.currentTimeMillis());
        responseError$sfmcsdk_release = builder.build();
        SFMCSdkLogger.INSTANCE.mo3976d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "HTTP response " + responseError$sfmcsdk_release.getCode() + " for " + request.getName() + " request. Request took " + responseError$sfmcsdk_release.timeToExecute() + "ms.";
            }
        });
        AtomicBoolean atomicBoolean3 = this.requestsInFlight.get(request.getName());
        if (atomicBoolean3 != null) {
            atomicBoolean3.set(false);
        }
        httpURLConnection = (HttpURLConnection) objectRef.element;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        return responseError$sfmcsdk_release;
    }

    public final boolean isBlockedByRetryAfter$sfmcsdk_release(final String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jServerRetryAfterTime$sfmcsdk_release = serverRetryAfterTime$sfmcsdk_release(requestName);
        long jDeviceRetryAfterTime$sfmcsdk_release = deviceRetryAfterTime$sfmcsdk_release(requestName);
        if (jCurrentTimeMillis > jServerRetryAfterTime$sfmcsdk_release && jCurrentTimeMillis > jDeviceRetryAfterTime$sfmcsdk_release) {
            return false;
        }
        SFMCSdkLogger.INSTANCE.mo3980w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$isBlockedByRetryAfter$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Route " + requestName + " _blocked_ by Retry-After.";
            }
        });
        return true;
    }

    public final boolean canMakeRequest(String... requestNames) {
        Intrinsics.checkNotNullParameter(requestNames, "requestNames");
        if (!NetworkUtils.hasConnectivity(this.context)) {
            return false;
        }
        for (String str : requestNames) {
            if (isBlockedByRetryAfter$sfmcsdk_release(str)) {
                return false;
            }
        }
        return true;
    }

    public final long serverRetryAfterTime$sfmcsdk_release(String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        return this.networkPreferences.getLong(INSTANCE.getServerRetryKey$sfmcsdk_release(requestName), 0L);
    }

    public final long deviceRetryAfterTime$sfmcsdk_release(String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        return this.networkPreferences.getLong(INSTANCE.getDeviceRetryKey$sfmcsdk_release(requestName), 0L);
    }

    public static /* synthetic */ void recordDeviceRetryAfter$sfmcsdk_release$default(NetworkManager networkManager, Request request, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        networkManager.recordDeviceRetryAfter$sfmcsdk_release(request, j);
    }

    public final void recordDeviceRetryAfter$sfmcsdk_release(Request request, long timestamp) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getRateLimit() > 0) {
            SharedPreferences.Editor editorEdit = this.networkPreferences.edit();
            editorEdit.putLong(INSTANCE.getDeviceRetryKey$sfmcsdk_release(request.getName()), request.getRateLimit() + timestamp);
            editorEdit.apply();
        }
    }

    public final void recordRetryAfter$sfmcsdk_release(Request request, Response response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        SharedPreferences.Editor editorEdit = this.networkPreferences.edit();
        recordDeviceRetryAfter$sfmcsdk_release(request, response.getEndTimeMillis());
        List<String> list = response.getHeaders().get(HttpHeaders.RETRY_AFTER);
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            long j = Long.parseLong(list.get(0)) * 1000;
            String serverRetryKey$sfmcsdk_release = INSTANCE.getServerRetryKey$sfmcsdk_release(request.getName());
            long endTimeMillis = response.getEndTimeMillis();
            if (j > MAX_SERVER_RETRY) {
                j = 86400000;
            }
            editorEdit.putLong(serverRetryKey$sfmcsdk_release, endTimeMillis + j);
            editorEdit.apply();
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.mo3975d(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$recordRetryAfter$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to parse Retry-After value.";
                }
            });
        }
    }
}
