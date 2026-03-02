package com.reactnativenavigation.react;

import android.app.Activity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.reactnativenavigation.NavigationActivity;
import com.reactnativenavigation.NavigationApplication;
import com.reactnativenavigation.options.LayoutFactory;
import com.reactnativenavigation.options.LayoutNode;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.parsers.JSONParser;
import com.reactnativenavigation.options.parsers.LayoutNodeParser;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.LaunchArgsParser;
import com.reactnativenavigation.utils.Now;
import com.reactnativenavigation.utils.SystemUiUtils;
import com.reactnativenavigation.utils.UiThread;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.navigator.Navigator;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class NavigationModule extends ReactContextBaseJavaModule {
    private static final String NAME = "RNNBridgeModule";
    private EventEmitter eventEmitter;
    private final JSONParser jsonParser;
    private final LayoutFactory layoutFactory;
    private final Now now;
    private final ReactInstanceManager reactInstanceManager;

    public NavigationModule(ReactApplicationContext reactApplicationContext, ReactInstanceManager reactInstanceManager, LayoutFactory layoutFactory) {
        this(reactApplicationContext, reactInstanceManager, new JSONParser(), layoutFactory);
    }

    public NavigationModule(ReactApplicationContext reactApplicationContext, ReactInstanceManager reactInstanceManager, JSONParser jSONParser, LayoutFactory layoutFactory) {
        super(reactApplicationContext);
        this.now = new Now();
        this.reactInstanceManager = reactInstanceManager;
        this.jsonParser = jSONParser;
        this.layoutFactory = layoutFactory;
        reactApplicationContext.addLifecycleEventListener(new C39731(reactApplicationContext, layoutFactory));
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.react.NavigationModule$1 */
    class C39731 extends LifecycleEventListenerAdapter {
        final /* synthetic */ LayoutFactory val$layoutFactory;
        final /* synthetic */ ReactApplicationContext val$reactContext;

        C39731(ReactApplicationContext reactApplicationContext, LayoutFactory layoutFactory) {
            this.val$reactContext = reactApplicationContext;
            this.val$layoutFactory = layoutFactory;
        }

        @Override // com.reactnativenavigation.react.LifecycleEventListenerAdapter, com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
            super.onHostPause();
            UiUtils.runOnMainThread(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onHostPause$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onHostPause$0() {
            if (NavigationModule.this.activity() != null) {
                NavigationModule.this.navigator().onHostPause();
            }
        }

        @Override // com.reactnativenavigation.react.LifecycleEventListenerAdapter, com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
            NavigationModule.this.eventEmitter = new EventEmitter(this.val$reactContext);
            NavigationModule.this.navigator().setEventEmitter(NavigationModule.this.eventEmitter);
            this.val$layoutFactory.init(NavigationModule.this.activity(), NavigationModule.this.eventEmitter, NavigationModule.this.navigator().getChildRegistry(), ((NavigationApplication) NavigationModule.this.activity().getApplication()).getExternalComponents());
            UiUtils.runOnMainThread(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onHostResume$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onHostResume$1() {
            NavigationModule.this.navigator().onHostResume();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getLaunchArgs(String str, Promise promise) {
        promise.resolve(LaunchArgsParser.parse(activity()));
    }

    private WritableMap createNavigationConstantsMap() {
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(Constants.BACK_BUTTON_JS_KEY, Constants.BACK_BUTTON_ID);
        writableMapCreateMap.putDouble(Constants.BOTTOM_TABS_HEIGHT_KEY, UiUtils.pxToDp(r0, UiUtils.getBottomTabsHeight(r0)));
        writableMapCreateMap.putDouble(Constants.STATUS_BAR_HEIGHT_KEY, UiUtils.pxToDp(r0, SystemUiUtils.getStatusBarHeight(currentActivity)));
        writableMapCreateMap.putDouble(Constants.TOP_BAR_HEIGHT_KEY, UiUtils.pxToDp(r0, UiUtils.getTopBarHeight(r0)));
        return writableMapCreateMap;
    }

    @ReactMethod
    public void getNavigationConstants(Promise promise) {
        promise.resolve(createNavigationConstantsMap());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getNavigationConstantsSync() {
        return createNavigationConstantsMap();
    }

    @ReactMethod
    public void setRoot(final String str, ReadableMap readableMap, final Promise promise) {
        final LayoutNode layoutNode = LayoutNodeParser.parse((JSONObject) Objects.requireNonNull(this.jsonParser.parse(readableMap).optJSONObject("root")));
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setRoot$0(layoutNode, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRoot$0(LayoutNode layoutNode, String str, Promise promise) {
        navigator().setRoot(this.layoutFactory.create(layoutNode), new NativeCommandListener("setRoot", str, promise, this.eventEmitter, this.now), this.reactInstanceManager);
    }

    @ReactMethod
    public void setDefaultOptions(final ReadableMap readableMap) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDefaultOptions$1(readableMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultOptions$1(ReadableMap readableMap) {
        Options options = parse(readableMap);
        this.layoutFactory.setDefaultOptions(options);
        navigator().setDefaultOptions(options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeOptions$2(String str, ReadableMap readableMap) {
        navigator().mergeOptions(str, parse(readableMap));
    }

    @ReactMethod
    public void mergeOptions(final String str, final ReadableMap readableMap) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mergeOptions$2(str, readableMap);
            }
        });
    }

    @ReactMethod
    public void push(final String str, final String str2, ReadableMap readableMap, final Promise promise) {
        final LayoutNode layoutNode = LayoutNodeParser.parse(this.jsonParser.parse(readableMap));
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$push$3(layoutNode, str2, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$push$3(LayoutNode layoutNode, String str, String str2, Promise promise) {
        navigator().push(str, this.layoutFactory.create(layoutNode), new NativeCommandListener("push", str2, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void setStackRoot(final String str, final String str2, final ReadableArray readableArray, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setStackRoot$4(readableArray, str2, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStackRoot$4(ReadableArray readableArray, String str, String str2, Promise promise) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(this.layoutFactory.create(LayoutNodeParser.parse(this.jsonParser.parse(readableArray.getMap(i)))));
        }
        navigator().setStackRoot(str, arrayList, new NativeCommandListener("setStackRoot", str2, promise, this.eventEmitter, this.now));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pop$5(String str, ReadableMap readableMap, String str2, Promise promise) {
        navigator().pop(str, parse(readableMap), new NativeCommandListener("pop", str2, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void pop(final String str, final String str2, final ReadableMap readableMap, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$pop$5(str2, readableMap, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popTo$6(String str, ReadableMap readableMap, String str2, Promise promise) {
        navigator().popTo(str, parse(readableMap), new NativeCommandListener("popTo", str2, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void popTo(final String str, final String str2, final ReadableMap readableMap, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$popTo$6(str2, readableMap, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popToRoot$7(String str, ReadableMap readableMap, String str2, Promise promise) {
        navigator().popToRoot(str, parse(readableMap), new NativeCommandListener("popToRoot", str2, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void popToRoot(final String str, final String str2, final ReadableMap readableMap, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$popToRoot$7(str2, readableMap, str, promise);
            }
        });
    }

    @ReactMethod
    public void showModal(final String str, ReadableMap readableMap, final Promise promise) {
        final LayoutNode layoutNode = LayoutNodeParser.parse(this.jsonParser.parse(readableMap));
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showModal$8(layoutNode, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showModal$8(LayoutNode layoutNode, String str, Promise promise) {
        navigator().showModal(this.layoutFactory.create(layoutNode), new NativeCommandListener("showModal", str, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void dismissModal(final String str, final String str2, final ReadableMap readableMap, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dismissModal$9(str2, readableMap, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissModal$9(String str, ReadableMap readableMap, String str2, Promise promise) {
        navigator().mergeOptions(str, parse(readableMap));
        navigator().dismissModal(str, new NativeCommandListener("dismissModal", str2, promise, this.eventEmitter, this.now));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissAllModals$10(ReadableMap readableMap, String str, Promise promise) {
        navigator().dismissAllModals(parse(readableMap), new NativeCommandListener("dismissAllModals", str, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void dismissAllModals(final String str, final ReadableMap readableMap, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dismissAllModals$10(readableMap, str, promise);
            }
        });
    }

    @ReactMethod
    public void showOverlay(final String str, ReadableMap readableMap, final Promise promise) {
        final LayoutNode layoutNode = LayoutNodeParser.parse(this.jsonParser.parse(readableMap));
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showOverlay$11(layoutNode, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOverlay$11(LayoutNode layoutNode, String str, Promise promise) {
        navigator().showOverlay(this.layoutFactory.create(layoutNode), new NativeCommandListener("showOverlay", str, promise, this.eventEmitter, this.now));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissOverlay$12(String str, String str2, Promise promise) {
        navigator().dismissOverlay(str, new NativeCommandListener("dismissOverlay", str2, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void dismissOverlay(final String str, final String str2, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dismissOverlay$12(str2, str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissAllOverlays$13(String str, Promise promise) {
        navigator().dismissAllOverlays(new NativeCommandListener("dismissAllOverlays", str, promise, this.eventEmitter, this.now));
    }

    @ReactMethod
    public void dismissAllOverlays(final String str, final Promise promise) {
        handle(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dismissAllOverlays$13(str, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Navigator navigator() {
        return activity().getNavigator();
    }

    private Options parse(ReadableMap readableMap) {
        return readableMap == null ? Options.EMPTY : Options.parse(getReactApplicationContext(), new TypefaceLoader(activity()), this.jsonParser.parse(readableMap));
    }

    protected void handle(final Runnable runnable) {
        UiThread.post(new Runnable() { // from class: com.reactnativenavigation.react.NavigationModule$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handle$14(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$14(Runnable runnable) {
        if (getCurrentActivity() == null || activity().isFinishing()) {
            return;
        }
        runnable.run();
    }

    protected NavigationActivity activity() {
        return (NavigationActivity) getCurrentActivity();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        NavigationActivity navigationActivityActivity = activity();
        if (navigationActivityActivity != null) {
            navigationActivityActivity.onCatalystInstanceDestroy();
        }
        super.onCatalystInstanceDestroy();
    }
}
