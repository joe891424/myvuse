package com.bat.myvuse.mobile.rncomponents.notifications;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationsModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/bat/myvuse/mobile/rncomponents/notifications/NotificationsModule;", "Lcom/bat/myvuse/mobile/rncomponents/notifications/NotificationsBaseModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "TAG", "", "getInitialNotification", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getName", "app_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NotificationsModule extends NotificationsBaseModule {
    private String TAG;
    private final ReactApplicationContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NotificationsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.TAG = "NotificationsModule";
    }

    @Override // com.bat.myvuse.mobile.rncomponents.notifications.NotificationsBaseModule, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NotificationsModule";
    }

    @ReactMethod
    public final void getInitialNotification(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        PushNotificationProps pushNotificationProps = InitialNotificationHolder.getInstance().get();
        if (pushNotificationProps == null) {
            promise.resolve(null);
        } else {
            InitialNotificationHolder.getInstance().clear();
            promise.resolve(Arguments.fromBundle(pushNotificationProps.asBundle()));
        }
    }
}
