package com.RNFetchBlob;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.internal.AssetHelper;
import com.RNFetchBlob.Response.RNFetchBlobDefaultResp;
import com.RNFetchBlob.Response.RNFetchBlobFileResp;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.util.Constants;
import com.qualtrics.digital.RequestInterceptor;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes.dex */
public class RNFetchBlobReq extends BroadcastReceiver implements Runnable {
    Callback callback;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    ReadableMap headers;
    String method;
    RNFetchBlobConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    RNFetchBlobBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseType responseType;
    String taskId;
    String url;
    public static HashMap<String, Call> taskTable = new HashMap<>();
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static HashMap<String, RNFetchBlobProgressConfig> progressReport = new HashMap<>();
    static HashMap<String, RNFetchBlobProgressConfig> uploadProgressReport = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    ResponseFormat responseFormat = ResponseFormat.Auto;
    boolean timeout = false;
    ArrayList<String> redirects = new ArrayList<>();

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    public RNFetchBlobReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback) {
        this.method = str2.toUpperCase();
        RNFetchBlobConfig rNFetchBlobConfig = new RNFetchBlobConfig(readableMap);
        this.options = rNFetchBlobConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        if (rNFetchBlobConfig.fileCache.booleanValue() || this.options.path != null) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        if (taskTable.containsKey(str)) {
            taskTable.get(str).cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) RNFetchBlob.RCTContext.getApplicationContext().getSystemService("download")).remove(androidDownloadManagerTaskTable.get(str).longValue());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        OkHttpClient.Builder builderNewBuilder;
        final Request requestBuild;
        Call callNewCall;
        if (this.options.addAndroidDownloads != null && this.options.addAndroidDownloads.hasKey("useDownloadManager") && this.options.addAndroidDownloads.getBoolean("useDownloadManager")) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.url));
            if (this.options.addAndroidDownloads.hasKey("notification") && this.options.addAndroidDownloads.getBoolean("notification")) {
                request.setNotificationVisibility(1);
            } else {
                request.setNotificationVisibility(2);
            }
            if (this.options.addAndroidDownloads.hasKey("title")) {
                request.setTitle(this.options.addAndroidDownloads.getString("title"));
            }
            if (this.options.addAndroidDownloads.hasKey("description")) {
                request.setDescription(this.options.addAndroidDownloads.getString("description"));
            }
            if (this.options.addAndroidDownloads.hasKey("path")) {
                request.setDestinationUri(Uri.fromFile(new File(this.options.addAndroidDownloads.getString("path"))));
            }
            if (this.options.addAndroidDownloads.hasKey("mime")) {
                request.setMimeType(this.options.addAndroidDownloads.getString("mime"));
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = this.headers.keySetIterator();
            if (this.options.addAndroidDownloads.hasKey("mediaScannable") && this.options.addAndroidDownloads.hasKey("mediaScannable")) {
                request.allowScanningByMediaScanner();
            }
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                request.addRequestHeader(strNextKey, this.headers.getString(strNextKey));
            }
            Context applicationContext = RNFetchBlob.RCTContext.getApplicationContext();
            long jEnqueue = ((DownloadManager) applicationContext.getSystemService("download")).enqueue(request);
            this.downloadManagerId = jEnqueue;
            androidDownloadManagerTaskTable.put(this.taskId, Long.valueOf(jEnqueue));
            applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            return;
        }
        String md5 = this.taskId;
        String str = this.options.appendExt.isEmpty() ? "" : "." + this.options.appendExt;
        if (this.options.key != null) {
            md5 = RNFetchBlobUtils.getMD5(this.options.key);
            if (md5 == null) {
                md5 = this.taskId;
            }
            File file = new File(RNFetchBlobFS.getTmpPath(md5) + str);
            if (file.exists()) {
                this.callback.invoke(null, "path", file.getAbsolutePath());
                return;
            }
        }
        if (this.options.path != null) {
            this.destPath = this.options.path;
        } else if (this.options.fileCache.booleanValue()) {
            this.destPath = RNFetchBlobFS.getTmpPath(md5) + str;
        }
        try {
            if (this.options.trusty.booleanValue()) {
                builderNewBuilder = RNFetchBlobUtils.getUnsafeOkHttpClient(this.client);
            } else {
                builderNewBuilder = this.client.newBuilder();
            }
            OkHttpClient.Builder builder = builderNewBuilder;
            if (this.options.wifiOnly.booleanValue()) {
                ReactApplicationContext reactApplicationContext = RNFetchBlob.RCTContext;
                ReactApplicationContext reactApplicationContext2 = RNFetchBlob.RCTContext;
                ConnectivityManager connectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkInfo != null && networkInfo.isConnected() && networkCapabilities.hasTransport(1)) {
                        builder.proxy(Proxy.NO_PROXY);
                        builder.socketFactory(network.getSocketFactory());
                    }
                }
                this.callback.invoke("No available WiFi connections.", null, null);
                releaseTaskResource();
                return;
            }
            Request.Builder builder2 = new Request.Builder();
            try {
                builder2.url(new URL(this.url));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HashMap<String, String> map = new HashMap<>();
            ReadableMap readableMap = this.headers;
            if (readableMap != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator2 = readableMap.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator2.hasNextKey()) {
                    String strNextKey2 = readableMapKeySetIteratorKeySetIterator2.nextKey();
                    String string = this.headers.getString(strNextKey2);
                    if (strNextKey2.equalsIgnoreCase("RNFB-Response")) {
                        if (string.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
                            this.responseFormat = ResponseFormat.BASE64;
                        } else if (string.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_UTF8)) {
                            this.responseFormat = ResponseFormat.UTF8;
                        }
                    } else {
                        builder2.header(strNextKey2.toLowerCase(), string);
                        map.put(strNextKey2.toLowerCase(), string);
                    }
                }
            }
            if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                String lowerCase = getHeaderIgnoreCases(map, "Content-Type").toLowerCase();
                if (this.rawRequestBodyArray != null) {
                    this.requestType = RequestType.Form;
                } else if (lowerCase.isEmpty()) {
                    if (!lowerCase.equalsIgnoreCase("")) {
                        builder2.header("Content-Type", "application/octet-stream");
                    }
                    this.requestType = RequestType.SingleFile;
                }
                String str2 = this.rawRequestBody;
                if (str2 != null) {
                    if (!str2.startsWith(RNFetchBlobConst.FILE_PREFIX) && !this.rawRequestBody.startsWith(RNFetchBlobConst.CONTENT_PREFIX)) {
                        if (lowerCase.toLowerCase().contains(";base64") || lowerCase.toLowerCase().startsWith("application/octet")) {
                            String strReplace = lowerCase.replace(";base64", "").replace(";BASE64", "");
                            if (map.containsKey(RequestInterceptor.CONTENT_TYPE)) {
                                map.put(RequestInterceptor.CONTENT_TYPE, strReplace);
                            }
                            if (map.containsKey("Content-Type")) {
                                map.put("Content-Type", strReplace);
                            }
                            this.requestType = RequestType.SingleFile;
                        } else {
                            this.requestType = RequestType.AsIs;
                        }
                    } else {
                        this.requestType = RequestType.SingleFile;
                    }
                }
            } else {
                this.requestType = RequestType.WithoutBody;
            }
            boolean zEqualsIgnoreCase = getHeaderIgnoreCases(map, HttpHeaders.TRANSFER_ENCODING).equalsIgnoreCase("chunked");
            int i = C13574.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                RNFetchBlobBody mime = new RNFetchBlobBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, RequestInterceptor.CONTENT_TYPE)));
                this.requestBody = mime;
                builder2.method(this.method, mime);
            } else if (i == 2) {
                RNFetchBlobBody mime2 = new RNFetchBlobBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, RequestInterceptor.CONTENT_TYPE)));
                this.requestBody = mime2;
                builder2.method(this.method, mime2);
            } else if (i == 3) {
                RNFetchBlobBody mime3 = new RNFetchBlobBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBodyArray).setMIME(MediaType.parse("multipart/form-data; boundary=" + ("RNFetchBlob-" + this.taskId)));
                this.requestBody = mime3;
                builder2.method(this.method, mime3);
            } else if (i == 4) {
                if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                    builder2.method(this.method, RequestBody.create((MediaType) null, new byte[0]));
                } else {
                    builder2.method(this.method, null);
                }
            }
            if (builder2 instanceof Request.Builder) {
                requestBuild = OkHttp3Instrumentation.build(builder2);
            } else {
                requestBuild = builder2.build();
            }
            builder.addNetworkInterceptor(new Interceptor() { // from class: com.RNFetchBlob.RNFetchBlobReq.1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    RNFetchBlobReq.this.redirects.add(chain.request().url().getUrl());
                    return chain.proceed(chain.request());
                }
            });
            builder.addInterceptor(new Interceptor() { // from class: com.RNFetchBlob.RNFetchBlobReq.2
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v1, types: [okhttp3.Response] */
                /* JADX WARN: Type inference failed for: r1v2, types: [okhttp3.Response] */
                /* JADX WARN: Type inference failed for: r1v3, types: [okhttp3.Response] */
                /* JADX WARN: Type inference failed for: r1v4, types: [okhttp3.Response] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v6 */
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    ResponseBody rNFetchBlobDefaultResp;
                    Response.Builder builderBody;
                    ?? Proceed = 0;
                    Proceed = 0;
                    Proceed = 0;
                    try {
                        Proceed = chain.proceed(requestBuild);
                        int i2 = C13574.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType[RNFetchBlobReq.this.responseType.ordinal()];
                        if (i2 != 1 && i2 == 2) {
                            rNFetchBlobDefaultResp = new RNFetchBlobFileResp(RNFetchBlob.RCTContext, RNFetchBlobReq.this.taskId, Proceed.body(), RNFetchBlobReq.this.destPath, RNFetchBlobReq.this.options.overwrite.booleanValue());
                        } else {
                            rNFetchBlobDefaultResp = new RNFetchBlobDefaultResp(RNFetchBlob.RCTContext, RNFetchBlobReq.this.taskId, Proceed.body(), RNFetchBlobReq.this.options.increment.booleanValue());
                        }
                        Response.Builder builderNewBuilder2 = !(Proceed instanceof Response.Builder) ? Proceed.newBuilder() : OkHttp3Instrumentation.newBuilder((Response.Builder) Proceed);
                        if (builderNewBuilder2 instanceof Response.Builder) {
                            Response.Builder builder3 = builderNewBuilder2;
                            builderBody = OkHttp3Instrumentation.body(builderNewBuilder2, rNFetchBlobDefaultResp);
                        } else {
                            builderBody = builderNewBuilder2.body(rNFetchBlobDefaultResp);
                        }
                        return builderBody.build();
                    } catch (SocketException unused) {
                        RNFetchBlobReq.this.timeout = true;
                        if (Proceed != 0) {
                            Proceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (SocketTimeoutException unused2) {
                        RNFetchBlobReq.this.timeout = true;
                        if (Proceed != 0) {
                            Proceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (Exception unused3) {
                        if (Proceed != 0) {
                            Proceed.close();
                        }
                        return chain.proceed(chain.request());
                    }
                }
            });
            if (this.options.timeout >= 0) {
                builder.connectTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
                builder.readTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
            }
            builder.connectionPool(pool);
            builder.retryOnConnectionFailure(false);
            builder.followRedirects(this.options.followRedirect.booleanValue());
            builder.followSslRedirects(this.options.followRedirect.booleanValue());
            builder.retryOnConnectionFailure(true);
            OkHttpClient okHttpClientBuild = enableTls12OnPreLollipop(builder).build();
            if (okHttpClientBuild instanceof OkHttpClient) {
                OkHttpClient okHttpClient = okHttpClientBuild;
                callNewCall = OkHttp3Instrumentation.newCall(okHttpClientBuild, requestBuild);
            } else {
                callNewCall = okHttpClientBuild.newCall(requestBuild);
            }
            taskTable.put(this.taskId, callNewCall);
            FirebasePerfOkHttpClient.enqueue(callNewCall, new okhttp3.Callback() { // from class: com.RNFetchBlob.RNFetchBlobReq.3
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    RNFetchBlobReq.cancelTask(RNFetchBlobReq.this.taskId);
                    if (RNFetchBlobReq.this.respInfo == null) {
                        RNFetchBlobReq.this.respInfo = Arguments.createMap();
                    }
                    if (iOException.getClass().equals(SocketTimeoutException.class)) {
                        RNFetchBlobReq.this.respInfo.putBoolean("timeout", true);
                        RNFetchBlobReq.this.callback.invoke("The request timed out.", null, null);
                    } else {
                        RNFetchBlobReq.this.callback.invoke(iOException.getLocalizedMessage(), null, null);
                    }
                    RNFetchBlobReq.this.releaseTaskResource();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    String string2;
                    ReadableMap readableMap2 = RNFetchBlobReq.this.options.addAndroidDownloads;
                    if (readableMap2 != null) {
                        String string3 = readableMap2.hasKey("title") ? RNFetchBlobReq.this.options.addAndroidDownloads.getString("title") : "";
                        String string4 = readableMap2.hasKey("description") ? readableMap2.getString("description") : "";
                        if (!readableMap2.hasKey("mime")) {
                            string2 = AssetHelper.DEFAULT_MIME_TYPE;
                        } else {
                            string2 = readableMap2.getString("mime");
                        }
                        String str3 = string2;
                        boolean z = readableMap2.hasKey("mediaScannable") ? readableMap2.getBoolean("mediaScannable") : false;
                        boolean z2 = readableMap2.hasKey("notification") ? readableMap2.getBoolean("notification") : false;
                        ReactApplicationContext reactApplicationContext3 = RNFetchBlob.RCTContext;
                        ReactApplicationContext reactApplicationContext4 = RNFetchBlob.RCTContext;
                        ((DownloadManager) reactApplicationContext3.getSystemService("download")).addCompletedDownload(string3, string4, z, str3, RNFetchBlobReq.this.destPath, RNFetchBlobReq.this.contentLength, z2);
                    }
                    RNFetchBlobReq.this.done(response);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            releaseTaskResource();
            this.callback.invoke("RNFetchBlob request error: " + e2.getMessage() + e2.getCause());
        }
    }

    /* JADX INFO: renamed from: com.RNFetchBlob.RNFetchBlobReq$4 */
    static /* synthetic */ class C13574 {
        static final /* synthetic */ int[] $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType;

        static {
            int[] iArr = new int[ResponseType.values().length];
            $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType = iArr;
            try {
                iArr[ResponseType.KeepInMemory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType[ResponseType.FileStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RequestType.values().length];
            $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType = iArr2;
            try {
                iArr2[RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[RequestType.Form.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[RequestType.WithoutBody.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        RNFetchBlobBody rNFetchBlobBody = this.requestBody;
        if (rNFetchBlobBody != null) {
            rNFetchBlobBody.clearRequestBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0117 A[Catch: IOException -> 0x017a, TRY_LEAVE, TryCatch #1 {IOException -> 0x017a, blocks: (B:35:0x00d3, B:37:0x00dd, B:38:0x00f9, B:40:0x0100, B:41:0x0104, B:42:0x0117, B:45:0x012f, B:47:0x013d, B:49:0x0157, B:51:0x015d, B:52:0x016c), top: B:60:0x00d3, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void done(okhttp3.Response r10) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.done(okhttp3.Response):void");
    }

    public static RNFetchBlobProgressConfig getReportProgress(String str) {
        if (progressReport.containsKey(str)) {
            return progressReport.get(str);
        }
        return null;
    }

    public static RNFetchBlobProgressConfig getReportUploadProgress(String str) {
        if (uploadProgressReport.containsKey(str)) {
            return uploadProgressReport.get(str);
        }
        return null;
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("status", response.code());
        writableMapCreateMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, this.taskId);
        writableMapCreateMap.putBoolean("timeout", this.timeout);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            writableMapCreateMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it2 = this.redirects.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(it2.next());
        }
        writableMapCreateMap.putArray("redirects", writableArrayCreateArray);
        writableMapCreateMap.putMap("headers", writableMapCreateMap2);
        Headers headers = response.headers();
        if (z) {
            writableMapCreateMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers, RequestInterceptor.CONTENT_TYPE).equalsIgnoreCase("text/")) {
            writableMapCreateMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers, RequestInterceptor.CONTENT_TYPE).contains(Constants.Network.ContentType.JSON)) {
            writableMapCreateMap.putString("respType", "json");
        } else {
            writableMapCreateMap.putString("respType", "");
        }
        return writableMapCreateMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean zEqualsIgnoreCase = headerIgnoreCases.equalsIgnoreCase("text/");
        boolean zEqualsIgnoreCase2 = headerIgnoreCases.equalsIgnoreCase(Constants.Network.ContentType.JSON);
        if (this.options.binaryContentTypes != null) {
            for (int i = 0; i < this.options.binaryContentTypes.size(); i++) {
                if (headerIgnoreCases.toLowerCase().contains(this.options.binaryContentTypes.getString(i).toLowerCase())) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        return (zEqualsIgnoreCase2 && zEqualsIgnoreCase) || z;
    }

    private String getHeaderIgnoreCases(Headers headers, String str) {
        String str2 = headers.get(str);
        return str2 != null ? str2 : headers.get(str.toLowerCase()) == null ? "" : headers.get(str.toLowerCase());
    }

    private String getHeaderIgnoreCases(HashMap<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = map.get(str.toLowerCase());
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_HTTP_STATE, writableMap);
        } catch (Exception e) {
            FLog.m1278e("RNFetchBlobReq", "Error emitting state event", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ef  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r13, android.content.Intent r14) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.onReceive(android.content.Context, android.content.Intent):void");
    }
}
