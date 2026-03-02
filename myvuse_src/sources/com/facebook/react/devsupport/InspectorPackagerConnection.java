package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Inspector;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InspectorPackagerConnection {
    private static final String TAG = "InspectorPackagerConnection";
    private BundleStatusProvider mBundleStatusProvider;
    private final Connection mConnection;
    private final Map<String, Inspector.LocalConnection> mInspectorConnections = new HashMap();
    private final String mPackageName;

    public interface BundleStatusProvider {
        BundleStatus getBundleStatus();
    }

    public InspectorPackagerConnection(String str, String str2, BundleStatusProvider bundleStatusProvider) {
        this.mConnection = new Connection(str);
        this.mPackageName = str2;
        this.mBundleStatusProvider = bundleStatusProvider;
    }

    public void connect() {
        this.mConnection.connect();
    }

    public void closeQuietly() {
        this.mConnection.close();
    }

    public void sendEventToAllConnections(String str) {
        Iterator<Map.Entry<String, Inspector.LocalConnection>> it2 = this.mInspectorConnections.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().sendMessage(str);
        }
    }

    void handleProxyMessage(JSONObject jSONObject) throws JSONException, IOException {
        String string;
        string = jSONObject.getString(NotificationCompat.CATEGORY_EVENT);
        string.hashCode();
        switch (string) {
            case "disconnect":
                handleDisconnect(jSONObject.getJSONObject("payload"));
                return;
            case "connect":
                handleConnect(jSONObject.getJSONObject("payload"));
                return;
            case "wrappedEvent":
                handleWrappedEvent(jSONObject.getJSONObject("payload"));
                return;
            case "getPages":
                sendEvent("getPages", getPages());
                return;
            default:
                throw new IllegalArgumentException("Unknown event: " + string);
        }
    }

    void closeAllConnections() {
        Iterator<Map.Entry<String, Inspector.LocalConnection>> it2 = this.mInspectorConnections.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().disconnect();
        }
        this.mInspectorConnections.clear();
    }

    private void handleConnect(JSONObject jSONObject) throws JSONException {
        final String string = jSONObject.getString("pageId");
        if (this.mInspectorConnections.remove(string) != null) {
            throw new IllegalStateException("Already connected: " + string);
        }
        try {
            this.mInspectorConnections.put(string, Inspector.connect(Integer.parseInt(string), new Inspector.RemoteConnection() { // from class: com.facebook.react.devsupport.InspectorPackagerConnection.1
                @Override // com.facebook.react.bridge.Inspector.RemoteConnection
                public void onMessage(String str) {
                    try {
                        InspectorPackagerConnection.this.sendWrappedEvent(string, str);
                    } catch (JSONException e) {
                        FLog.m1318w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                    }
                }

                @Override // com.facebook.react.bridge.Inspector.RemoteConnection
                public void onDisconnect() {
                    try {
                        InspectorPackagerConnection.this.mInspectorConnections.remove(string);
                        InspectorPackagerConnection inspectorPackagerConnection = InspectorPackagerConnection.this;
                        inspectorPackagerConnection.sendEvent("disconnect", inspectorPackagerConnection.makePageIdPayload(string));
                    } catch (JSONException e) {
                        FLog.m1318w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                    }
                }
            }));
        } catch (Exception e) {
            FLog.m1318w(TAG, "Failed to open page: " + string, e);
            sendEvent("disconnect", makePageIdPayload(string));
        }
    }

    private void handleDisconnect(JSONObject jSONObject) throws JSONException {
        Inspector.LocalConnection localConnectionRemove = this.mInspectorConnections.remove(jSONObject.getString("pageId"));
        if (localConnectionRemove == null) {
            return;
        }
        localConnectionRemove.disconnect();
    }

    private void handleWrappedEvent(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("pageId");
        String string2 = jSONObject.getString("wrappedEvent");
        Inspector.LocalConnection localConnection = this.mInspectorConnections.get(string);
        if (localConnection == null) {
            FLog.m1317w(TAG, "PageID " + string + " is disconnected. Dropping event: " + string2);
        } else {
            localConnection.sendMessage(string2);
        }
    }

    private JSONArray getPages() throws JSONException {
        List<Inspector.Page> pages = Inspector.getPages();
        JSONArray jSONArray = new JSONArray();
        BundleStatus bundleStatus = this.mBundleStatusProvider.getBundleStatus();
        for (Inspector.Page page : pages) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(page.getId()));
            jSONObject.put("title", page.getTitle());
            jSONObject.put("app", this.mPackageName);
            jSONObject.put("vm", page.getVM());
            jSONObject.put("isLastBundleDownloadSuccess", bundleStatus.isLastDownloadSuccess);
            jSONObject.put("bundleUpdateTimestamp", bundleStatus.updateTimestamp);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWrappedEvent(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        jSONObject.put("wrappedEvent", str2);
        sendEvent("wrappedEvent", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
        jSONObject.put("payload", obj);
        this.mConnection.send(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject makePageIdPayload(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        return jSONObject;
    }

    private class Connection extends WebSocketListener {
        private static final int RECONNECT_DELAY_MS = 2000;
        private boolean mClosed;
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private OkHttpClient mHttpClient;
        private boolean mSuppressConnectionErrors;
        private final String mUrl;
        private WebSocket mWebSocket;

        public Connection(String str) {
            this.mUrl = str;
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            this.mWebSocket = webSocket;
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (this.mWebSocket != null) {
                abort("Websocket exception", th);
            }
            if (this.mClosed) {
                return;
            }
            reconnect();
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            try {
                InspectorPackagerConnection.this.handleProxyMessage(new JSONObject(str));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int i, String str) {
            this.mWebSocket = null;
            InspectorPackagerConnection.this.closeAllConnections();
            if (this.mClosed) {
                return;
            }
            reconnect();
        }

        public void connect() {
            if (this.mClosed) {
                throw new IllegalStateException("Can't connect closed client");
            }
            if (this.mHttpClient == null) {
                this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
            }
            Request.Builder builderUrl = new Request.Builder().url(this.mUrl);
            this.mHttpClient.newWebSocket(!(builderUrl instanceof Request.Builder) ? builderUrl.build() : OkHttp3Instrumentation.build(builderUrl), this);
        }

        private void reconnect() {
            if (this.mClosed) {
                throw new IllegalStateException("Can't reconnect closed client");
            }
            if (!this.mSuppressConnectionErrors) {
                FLog.m1317w(InspectorPackagerConnection.TAG, "Couldn't connect to packager, will silently retry");
                this.mSuppressConnectionErrors = true;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.facebook.react.devsupport.InspectorPackagerConnection.Connection.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Connection.this.mClosed) {
                        return;
                    }
                    Connection.this.connect();
                }
            }, FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
        }

        public void close() {
            this.mClosed = true;
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.mWebSocket = null;
            }
        }

        /* JADX INFO: renamed from: com.facebook.react.devsupport.InspectorPackagerConnection$Connection$2 */
        class AsyncTaskC19542 extends AsyncTask<WebSocket, Void, Void> implements TraceFieldInterface {
            public Trace _nr_trace;
            final /* synthetic */ JSONObject val$object;

            @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
            public void _nr_setTrace(Trace trace) {
                try {
                    this._nr_trace = trace;
                } catch (Exception unused) {
                }
            }

            AsyncTaskC19542(JSONObject jSONObject) {
                this.val$object = jSONObject;
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ Void doInBackground(WebSocket[] webSocketArr) {
                try {
                    TraceMachine.enterMethod(this._nr_trace, "InspectorPackagerConnection$Connection$2#doInBackground", null);
                } catch (NoSuchFieldError unused) {
                    TraceMachine.enterMethod(null, "InspectorPackagerConnection$Connection$2#doInBackground", null);
                }
                Void voidDoInBackground2 = doInBackground2(webSocketArr);
                TraceMachine.exitMethod();
                return voidDoInBackground2;
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected Void doInBackground2(WebSocket... webSocketArr) {
                String string;
                if (webSocketArr != null && webSocketArr.length != 0) {
                    try {
                        WebSocket webSocket = webSocketArr[0];
                        JSONObject jSONObject = this.val$object;
                        if (jSONObject instanceof JSONObject) {
                            string = JSONObjectInstrumentation.toString(jSONObject);
                        } else {
                            string = jSONObject.toString();
                        }
                        webSocket.send(string);
                    } catch (Exception e) {
                        FLog.m1318w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                    }
                }
                return null;
            }
        }

        public void send(JSONObject jSONObject) {
            AsyncTaskC19542 asyncTaskC19542 = new AsyncTaskC19542(jSONObject);
            WebSocket[] webSocketArr = {this.mWebSocket};
            if (asyncTaskC19542 instanceof AsyncTask) {
                AsyncTaskInstrumentation.execute(asyncTaskC19542, webSocketArr);
            } else {
                asyncTaskC19542.execute(webSocketArr);
            }
        }

        private void abort(String str, Throwable th) {
            FLog.m1278e(InspectorPackagerConnection.TAG, "Error occurred, shutting down websocket connection: " + str, th);
            InspectorPackagerConnection.this.closeAllConnections();
            closeWebSocketQuietly();
        }

        private void closeWebSocketQuietly() {
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.mWebSocket = null;
            }
        }
    }

    public static class BundleStatus {
        public Boolean isLastDownloadSuccess;
        public long updateTimestamp;

        public BundleStatus(Boolean bool, long j) {
            this.isLastDownloadSuccess = bool;
            this.updateTimestamp = j;
        }

        public BundleStatus() {
            this(false, -1L);
        }
    }
}
