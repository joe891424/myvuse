package com.facebook.react.packagerconnection;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.branch.rnbranch.RNBranchModule;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {
    private static final int PROTOCOL_VERSION = 2;
    private static final String TAG = "JSPackagerClient";
    private Map<String, RequestHandler> mRequestHandlers;
    private ReconnectingWebSocket mWebSocket;

    private class ResponderImpl implements Responder {
        private Object mId;

        public ResponderImpl(Object obj) {
            this.mId = obj;
        }

        @Override // com.facebook.react.packagerconnection.Responder
        public void respond(Object obj) {
            String string;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("result", obj);
                ReconnectingWebSocket reconnectingWebSocket = JSPackagerClient.this.mWebSocket;
                if (jSONObject instanceof JSONObject) {
                    string = JSONObjectInstrumentation.toString(jSONObject);
                } else {
                    string = jSONObject.toString();
                }
                reconnectingWebSocket.sendMessage(string);
            } catch (Exception e) {
                FLog.m1278e(JSPackagerClient.TAG, "Responding failed", e);
            }
        }

        @Override // com.facebook.react.packagerconnection.Responder
        public void error(Object obj) {
            String string;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("error", obj);
                ReconnectingWebSocket reconnectingWebSocket = JSPackagerClient.this.mWebSocket;
                if (jSONObject instanceof JSONObject) {
                    string = JSONObjectInstrumentation.toString(jSONObject);
                } else {
                    string = jSONObject.toString();
                }
                reconnectingWebSocket.sendMessage(string);
            } catch (Exception e) {
                FLog.m1278e(JSPackagerClient.TAG, "Responding with error failed", e);
            }
        }
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map) {
        this(str, packagerConnectionSettings, map, null);
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map, ReconnectingWebSocket.ConnectionCallback connectionCallback) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("ws").encodedAuthority(packagerConnectionSettings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", packagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", str);
        this.mWebSocket = new ReconnectingWebSocket(builder.build().toString(), this, connectionCallback);
        this.mRequestHandlers = map;
    }

    public void init() {
        this.mWebSocket.connect();
    }

    public void close() {
        this.mWebSocket.closeQuietly();
    }

    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.MessageCallback
    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("version");
            String strOptString = jSONObject.optString("method");
            Object objOpt = jSONObject.opt("id");
            Object objOpt2 = jSONObject.opt(RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS);
            if (iOptInt != 2) {
                FLog.m1277e(TAG, "Message with incompatible or missing version of protocol received: " + iOptInt);
                return;
            }
            if (strOptString == null) {
                abortOnMessage(objOpt, "No method provided");
                return;
            }
            RequestHandler requestHandler = this.mRequestHandlers.get(strOptString);
            if (requestHandler == null) {
                abortOnMessage(objOpt, "No request handler for method: " + strOptString);
            } else if (objOpt == null) {
                requestHandler.onNotification(objOpt2);
            } else {
                requestHandler.onRequest(objOpt2, new ResponderImpl(objOpt));
            }
        } catch (Exception e) {
            FLog.m1278e(TAG, "Handling the message failed", e);
        }
    }

    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.MessageCallback
    public void onMessage(ByteString byteString) {
        FLog.m1317w(TAG, "Websocket received message with payload of unexpected type binary");
    }

    private void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            new ResponderImpl(obj).error(str);
        }
        FLog.m1277e(TAG, "Handling the message failed with reason: " + str);
    }
}
