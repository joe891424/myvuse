package com.reactnativenavigation.react.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.utils.LogKt;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class EventEmitter {
    private static final String AppLaunched = "RNN.AppLaunched";
    private static final String BottomTabPressed = "RNN.BottomTabPressed";
    private static final String BottomTabSelected = "RNN.BottomTabSelected";
    private static final String CommandCompleted = "RNN.CommandCompleted";
    private static final String ComponentDidAppear = "RNN.ComponentDidAppear";
    private static final String ComponentDidDisappear = "RNN.ComponentDidDisappear";
    private static final String ComponentWillAppear = "RNN.ComponentWillAppear";
    private static final String ModalDismissed = "RNN.ModalDismissed";
    private static final String NavigationButtonPressed = "RNN.NavigationButtonPressed";
    private static final String ScreenPopped = "RNN.ScreenPopped";

    @Nullable
    private ReactContext reactContext;

    public EventEmitter(@Nullable ReactContext reactContext) {
        this.reactContext = reactContext;
    }

    public void appLaunched() {
        emit(AppLaunched, Arguments.createMap());
    }

    public void emitComponentDidDisappear(String str, String str2, ComponentType componentType) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        writableMapCreateMap.putString("componentName", str2);
        writableMapCreateMap.putString("componentType", componentType.getName());
        emit(ComponentDidDisappear, writableMapCreateMap);
    }

    public void emitComponentWillAppear(String str, String str2, ComponentType componentType) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        writableMapCreateMap.putString("componentName", str2);
        writableMapCreateMap.putString("componentType", componentType.getName());
        emit(ComponentWillAppear, writableMapCreateMap);
    }

    public void emitComponentDidAppear(String str, String str2, ComponentType componentType) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        writableMapCreateMap.putString("componentName", str2);
        writableMapCreateMap.putString("componentType", componentType.getName());
        emit(ComponentDidAppear, writableMapCreateMap);
    }

    public void emitOnNavigationButtonPressed(String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        writableMapCreateMap.putString("buttonId", str2);
        emit(NavigationButtonPressed, writableMapCreateMap);
    }

    public void emitBottomTabSelected(int i, int i2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("unselectedTabIndex", i);
        writableMapCreateMap.putInt("selectedTabIndex", i2);
        emit(BottomTabSelected, writableMapCreateMap);
    }

    public void emitBottomTabPressed(int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("tabIndex", i);
        emit(BottomTabPressed, writableMapCreateMap);
    }

    public void emitCommandCompleted(String str, String str2, long j) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("commandName", str);
        writableMapCreateMap.putString("commandId", str2);
        writableMapCreateMap.putDouble("completionTime", j);
        emit(CommandCompleted, writableMapCreateMap);
    }

    public void emitModalDismissed(String str, String str2, int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        writableMapCreateMap.putString("componentName", str2);
        writableMapCreateMap.putInt("modalsDismissed", i);
        emit(ModalDismissed, writableMapCreateMap);
    }

    public void emitScreenPoppedEvent(String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("componentId", str);
        emit(ScreenPopped, writableMapCreateMap);
    }

    private void emit(String str, WritableMap writableMap) {
        ReactContext reactContext = this.reactContext;
        if (reactContext == null) {
            LogInstrumentation.m2728e(LogKt.MAIN_LIB_TAG, "Could not send event " + str + ". React context is null!");
        } else {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }
}
