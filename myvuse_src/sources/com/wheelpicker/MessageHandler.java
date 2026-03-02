package com.wheelpicker;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes6.dex */
final class MessageHandler extends Handler {
    final Context context;
    final LoopView loopview;

    MessageHandler(LoopView loopView, Context context) {
        this.loopview = loopView;
        this.context = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        LogInstrumentation.m2726d("MessageHandler", "message: " + message.toString());
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(ReactVideoView.EVENT_PROP_WHAT, message.what);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ((ReactContext) this.context).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onSwipe", writableMapCreateMap);
        if (message.what == 1000) {
            this.loopview.invalidate();
        }
        if (message.what == 2000) {
            LoopView.smoothScroll(this.loopview);
        } else if (message.what == 3000) {
            this.loopview.itemSelected();
        }
        super.handleMessage(message);
    }
}
