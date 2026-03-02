package com.facebook.react.devsupport;

import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.hermes.intl.Constants;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import com.facebook.react.util.RNLog;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Okio;
import okio.Sink;
import org.jose4j.lang.HashUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DevServerHelper {
    private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    private final BundleDownloader mBundleDownloader;
    private final InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
    private final OkHttpClient mClient;
    private InspectorPackagerConnection mInspectorPackagerConnection;
    private final String mPackageName;
    private JSPackagerClient mPackagerClient;
    private final PackagerConnectionSettings mPackagerConnectionSettings;
    private final PackagerStatusCheck mPackagerStatusCheck;
    private final DeveloperSettings mSettings;

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    private enum BundleType {
        BUNDLE("bundle"),
        MAP("map");

        private final String mTypeID;

        BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public DevServerHelper(DeveloperSettings developerSettings, String str, InspectorPackagerConnection.BundleStatusProvider bundleStatusProvider, PackagerConnectionSettings packagerConnectionSettings) {
        this.mSettings = developerSettings;
        this.mPackagerConnectionSettings = packagerConnectionSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(5000L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).build();
        this.mClient = okHttpClientBuild;
        this.mBundleDownloader = new BundleDownloader(okHttpClientBuild);
        this.mPackagerStatusCheck = new PackagerStatusCheck(okHttpClientBuild);
        this.mPackageName = str;
    }

    public void openPackagerConnection(String str, PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.m1317w(ReactConstants.TAG, "Packager connection already open, nooping.");
            return;
        }
        AsyncTaskC19371 asyncTaskC19371 = new AsyncTaskC19371(packagerCommandListener, str);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (asyncTaskC19371 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(asyncTaskC19371, executor, voidArr);
        } else {
            asyncTaskC19371.executeOnExecutor(executor, voidArr);
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevServerHelper$1 */
    class AsyncTaskC19371 extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
        public Trace _nr_trace;
        final /* synthetic */ String val$clientId;
        final /* synthetic */ PackagerCommandListener val$commandListener;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC19371(PackagerCommandListener packagerCommandListener, String str) {
            this.val$commandListener = packagerCommandListener;
            this.val$clientId = str;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "DevServerHelper$1#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "DevServerHelper$1#doInBackground", null);
            }
            Void voidDoInBackground2 = doInBackground2(voidArr);
            TraceMachine.exitMethod();
            return voidDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... voidArr) {
            HashMap map = new HashMap();
            map.put("reload", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.1
                @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                public void onNotification(Object obj) {
                    AsyncTaskC19371.this.val$commandListener.onPackagerReloadCommand();
                }
            });
            map.put("devMenu", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.2
                @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                public void onNotification(Object obj) {
                    AsyncTaskC19371.this.val$commandListener.onPackagerDevMenuCommand();
                }
            });
            map.put("captureHeap", new RequestOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.3
                @Override // com.facebook.react.packagerconnection.RequestOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                public void onRequest(Object obj, Responder responder) {
                    AsyncTaskC19371.this.val$commandListener.onCaptureHeapCommand(responder);
                }
            });
            Map<String, RequestHandler> mapCustomCommandHandlers = this.val$commandListener.customCommandHandlers();
            if (mapCustomCommandHandlers != null) {
                map.putAll(mapCustomCommandHandlers);
            }
            map.putAll(new FileIoHandler().handlers());
            ReconnectingWebSocket.ConnectionCallback connectionCallback = new ReconnectingWebSocket.ConnectionCallback() { // from class: com.facebook.react.devsupport.DevServerHelper.1.4
                @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                public void onConnected() {
                    AsyncTaskC19371.this.val$commandListener.onPackagerConnected();
                }

                @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                public void onDisconnected() {
                    AsyncTaskC19371.this.val$commandListener.onPackagerDisconnected();
                }
            };
            DevServerHelper.this.mPackagerClient = new JSPackagerClient(this.val$clientId, DevServerHelper.this.mPackagerConnectionSettings, map, connectionCallback);
            DevServerHelper.this.mPackagerClient.init();
            return null;
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevServerHelper$2 */
    class AsyncTaskC19382 extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
        public Trace _nr_trace;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC19382() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "DevServerHelper$2#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "DevServerHelper$2#doInBackground", null);
            }
            Void voidDoInBackground2 = doInBackground2(voidArr);
            TraceMachine.exitMethod();
            return voidDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... voidArr) {
            if (DevServerHelper.this.mPackagerClient != null) {
                DevServerHelper.this.mPackagerClient.close();
                DevServerHelper.this.mPackagerClient = null;
            }
            return null;
        }
    }

    public void closePackagerConnection() {
        AsyncTaskC19382 asyncTaskC19382 = new AsyncTaskC19382();
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (asyncTaskC19382 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(asyncTaskC19382, executor, voidArr);
        } else {
            asyncTaskC19382.executeOnExecutor(executor, voidArr);
        }
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.m1317w(ReactConstants.TAG, "Inspector connection already open, nooping.");
            return;
        }
        AsyncTaskC19393 asyncTaskC19393 = new AsyncTaskC19393();
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (asyncTaskC19393 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(asyncTaskC19393, executor, voidArr);
        } else {
            asyncTaskC19393.executeOnExecutor(executor, voidArr);
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevServerHelper$3 */
    class AsyncTaskC19393 extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
        public Trace _nr_trace;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC19393() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "DevServerHelper$3#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "DevServerHelper$3#doInBackground", null);
            }
            Void voidDoInBackground2 = doInBackground2(voidArr);
            TraceMachine.exitMethod();
            return voidDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... voidArr) {
            DevServerHelper.this.mInspectorPackagerConnection = new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
            DevServerHelper.this.mInspectorPackagerConnection.connect();
            return null;
        }
    }

    public void disableDebugger() {
        InspectorPackagerConnection inspectorPackagerConnection = this.mInspectorPackagerConnection;
        if (inspectorPackagerConnection != null) {
            inspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.DevServerHelper$4 */
    class AsyncTaskC19404 extends AsyncTask<Void, Void, Void> implements TraceFieldInterface {
        public Trace _nr_trace;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC19404() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "DevServerHelper$4#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "DevServerHelper$4#doInBackground", null);
            }
            Void voidDoInBackground2 = doInBackground2(voidArr);
            TraceMachine.exitMethod();
            return voidDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... voidArr) {
            if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                DevServerHelper.this.mInspectorPackagerConnection = null;
            }
            return null;
        }
    }

    public void closeInspectorConnection() {
        AsyncTaskC19404 asyncTaskC19404 = new AsyncTaskC19404();
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (asyncTaskC19404 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(asyncTaskC19404, executor, voidArr);
        } else {
            asyncTaskC19404.executeOnExecutor(executor, voidArr);
        }
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", this.mPackagerConnectionSettings.getDebugServerHost());
    }

    private static String getSHA256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HashUtil.SHA_256);
            messageDigest.reset();
            try {
                byte[] bArrDigest = messageDigest.digest(str.getBytes("UTF-8"));
                return String.format("%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x", Byte.valueOf(bArrDigest[0]), Byte.valueOf(bArrDigest[1]), Byte.valueOf(bArrDigest[2]), Byte.valueOf(bArrDigest[3]), Byte.valueOf(bArrDigest[4]), Byte.valueOf(bArrDigest[5]), Byte.valueOf(bArrDigest[6]), Byte.valueOf(bArrDigest[7]), Byte.valueOf(bArrDigest[8]), Byte.valueOf(bArrDigest[9]), Byte.valueOf(bArrDigest[10]), Byte.valueOf(bArrDigest[11]), Byte.valueOf(bArrDigest[12]), Byte.valueOf(bArrDigest[13]), Byte.valueOf(bArrDigest[14]), Byte.valueOf(bArrDigest[15]), Byte.valueOf(bArrDigest[16]), Byte.valueOf(bArrDigest[17]), Byte.valueOf(bArrDigest[18]), Byte.valueOf(bArrDigest[19]));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError("This environment doesn't support UTF-8 encoding", e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError("Could not get standard SHA-256 algorithm", e2);
        }
    }

    private String getInspectorDeviceId() {
        return getSHA256(String.format(Locale.US, "android-%s-%s", this.mPackageName, "android_id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s&device=%s", this.mPackagerConnectionSettings.getInspectorServerHost(), Uri.encode(AndroidInfoHelpers.getFriendlyDeviceName()), Uri.encode(this.mPackageName), Uri.encode(getInspectorDeviceId()));
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo);
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, builder);
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mPackagerConnectionSettings.getDebugServerHost());
        int iLastIndexOf = str.lastIndexOf(58);
        if (iLastIndexOf <= -1) {
            return AndroidInfoHelpers.DEVICE_LOCALHOST;
        }
        return AndroidInfoHelpers.DEVICE_LOCALHOST + str.substring(iLastIndexOf);
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return createBundleURL(str, bundleType, str2, false, true);
    }

    private String createSplitBundleURL(String str, String str2) {
        return createBundleURL(str, BundleType.BUNDLE, str2, true, false);
    }

    private String createBundleURL(String str, BundleType bundleType, String str2, boolean z, boolean z2) {
        boolean devMode = getDevMode();
        return String.format(Locale.US, "http://%s/%s.%s?platform=android&dev=%s&lazy=%s&minify=%s&app=%s&modulesOnly=%s&runModule=%s", str2, str, bundleType.typeID(), Boolean.valueOf(devMode), Boolean.valueOf(devMode), Boolean.valueOf(getJSMinifyMode()), this.mPackageName, z ? "true" : Constants.CASEFIRST_FALSE, z2 ? "true" : Constants.CASEFIRST_FALSE);
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", str, str2);
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, BundleType.BUNDLE, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public String getDevServerSplitBundleURL(String str) {
        return createSplitBundleURL(str, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        String debugServerHost = this.mPackagerConnectionSettings.getDebugServerHost();
        if (debugServerHost == null) {
            FLog.m1317w(ReactConstants.TAG, "No packager host configured.");
            packagerStatusCallback.onPackagerStatusFetched(false);
        } else {
            this.mPackagerStatusCheck.run(debugServerHost, packagerStatusCallback);
        }
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public void launchJSDevtools() {
        Request.Builder builderUrl = new Request.Builder().url(createLaunchJSDevtoolsCommandUrl());
        Request requestBuild = !(builderUrl instanceof Request.Builder) ? builderUrl.build() : OkHttp3Instrumentation.build(builderUrl);
        OkHttpClient okHttpClient = this.mClient;
        FirebasePerfOkHttpClient.enqueue(!(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(requestBuild) : OkHttp3Instrumentation.newCall(okHttpClient, requestBuild), new Callback() { // from class: com.facebook.react.devsupport.DevServerHelper.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        Call callNewCall;
        Request.Builder builderUrl = new Request.Builder().url(createResourceURL(this.mPackagerConnectionSettings.getDebugServerHost(), str));
        Request requestBuild = !(builderUrl instanceof Request.Builder) ? builderUrl.build() : OkHttp3Instrumentation.build(builderUrl);
        try {
            OkHttpClient okHttpClient = this.mClient;
            if (okHttpClient instanceof OkHttpClient) {
                callNewCall = OkHttp3Instrumentation.newCall(okHttpClient, requestBuild);
            } else {
                callNewCall = okHttpClient.newCall(requestBuild);
            }
            Response responseExecute = FirebasePerfOkHttpClient.execute(callNewCall);
            try {
                if (!responseExecute.isSuccessful()) {
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return null;
                }
                Sink sink = Okio.sink(file);
                try {
                    Okio.buffer(responseExecute.body().getSource()).readAll(sink);
                    if (sink != null) {
                        sink.close();
                    }
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return file;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            FLog.m1279e(ReactConstants.TAG, "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
            return null;
        }
        FLog.m1279e(ReactConstants.TAG, "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
        return null;
    }

    public void openDebugger(final ReactContext reactContext, final String str) {
        Request.Builder builderMethod = new Request.Builder().url(String.format(Locale.US, "http://%s/open-debugger?appId=%s&device=%s", this.mPackagerConnectionSettings.getInspectorServerHost(), Uri.encode(this.mPackageName), Uri.encode(getInspectorDeviceId()))).method("POST", RequestBody.create((MediaType) null, ""));
        Request requestBuild = !(builderMethod instanceof Request.Builder) ? builderMethod.build() : OkHttp3Instrumentation.build(builderMethod);
        OkHttpClient okHttpClient = this.mClient;
        FirebasePerfOkHttpClient.enqueue(!(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(requestBuild) : OkHttp3Instrumentation.newCall(okHttpClient, requestBuild), new Callback() { // from class: com.facebook.react.devsupport.DevServerHelper.6
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RNLog.m1361w(reactContext, str);
            }
        });
    }
}
