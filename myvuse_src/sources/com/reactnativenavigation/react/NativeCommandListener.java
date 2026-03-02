package com.reactnativenavigation.react;

import com.facebook.react.bridge.Promise;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.Now;

/* JADX INFO: loaded from: classes6.dex */
public class NativeCommandListener extends CommandListenerAdapter {
    private String commandId;
    private String commandName;
    private EventEmitter eventEmitter;
    private Now now;
    private Promise promise;

    public NativeCommandListener(String str, String str2, Promise promise, EventEmitter eventEmitter, Now now) {
        this.commandName = str;
        this.commandId = str2;
        this.promise = promise;
        this.eventEmitter = eventEmitter;
        this.now = now;
    }

    @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
    public void onSuccess(String str) {
        Promise promise = this.promise;
        if (promise != null) {
            promise.resolve(str);
        }
        this.eventEmitter.emitCommandCompleted(this.commandName, this.commandId, this.now.now());
    }

    @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
    public void onError(String str) {
        Promise promise = this.promise;
        if (promise != null) {
            promise.reject(new Throwable(str));
        }
    }
}
