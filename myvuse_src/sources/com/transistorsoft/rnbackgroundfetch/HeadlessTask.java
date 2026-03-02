package com.transistorsoft.rnbackgroundfetch;

import android.content.Context;
import android.os.Handler;
import androidx.work.WorkRequest;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.transistorsoft.tsbackgroundfetch.BGTask;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import com.transistorsoft.tsbackgroundfetch.FetchJobService;

/* JADX INFO: loaded from: classes6.dex */
public class HeadlessTask {
    private static final String HEADLESS_TASK_NAME = "BackgroundFetch";
    private static final Handler mHandler = new Handler();
    private final BGTask mBGTask;

    public HeadlessTask(Context context, BGTask bGTask) {
        this.mBGTask = bGTask;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, bGTask.getTaskId());
        writableNativeMap.putBoolean("timeout", bGTask.getTimedOut());
        try {
            startTask(new HeadlessJsTaskConfig(HEADLESS_TASK_NAME, writableNativeMap, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS), context);
        } catch (AssertionError e) {
            LogInstrumentation.m2726d(BackgroundFetch.TAG, "[HeadlessTask] Failed invoke HeadlessTask: " + e.getMessage());
        }
    }

    protected void startTask(HeadlessJsTaskConfig headlessJsTaskConfig, Context context) {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = getReactContext(context);
        if (reactContext == null) {
            createReactContextAndScheduleTask(headlessJsTaskConfig, context);
        } else {
            invokeStartTask(reactContext, headlessJsTaskConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        if (reactContext.getLifecycleState() == LifecycleState.RESUMED) {
            return;
        }
        final HeadlessJsTaskContext headlessJsTaskContext = HeadlessJsTaskContext.getInstance(reactContext);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.transistorsoft.rnbackgroundfetch.HeadlessTask$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$invokeStartTask$1(headlessJsTaskContext, headlessJsTaskConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeStartTask$1(final HeadlessJsTaskContext headlessJsTaskContext, HeadlessJsTaskConfig headlessJsTaskConfig) {
        try {
            final int iStartTask = headlessJsTaskContext.startTask(headlessJsTaskConfig);
            LogInstrumentation.m2726d(BackgroundFetch.TAG, "[HeadlessTask] start taskId: " + iStartTask);
            this.mBGTask.setCompletionHandler(new FetchJobService.CompletionHandler() { // from class: com.transistorsoft.rnbackgroundfetch.HeadlessTask$$ExternalSyntheticLambda0
                @Override // com.transistorsoft.tsbackgroundfetch.FetchJobService.CompletionHandler
                public final void finish() {
                    HeadlessTask.lambda$invokeStartTask$0(iStartTask, headlessJsTaskContext);
                }
            });
        } catch (IllegalStateException unused) {
            LogInstrumentation.m2728e(BackgroundFetch.TAG, "[HeadlessTask] task attempted to run in the foreground.  Task ignored.");
        }
    }

    static /* synthetic */ void lambda$invokeStartTask$0(int i, HeadlessJsTaskContext headlessJsTaskContext) {
        LogInstrumentation.m2726d(BackgroundFetch.TAG, "[HeadlessTask] end taskId: " + i);
        if (headlessJsTaskContext.isTaskRunning(i)) {
            headlessJsTaskContext.finishTask(i);
        }
    }

    private ReactNativeHost getReactNativeHost(Context context) {
        return ((ReactApplication) context.getApplicationContext()).getReactNativeHost();
    }

    private Object getReactHost(Context context) {
        Context applicationContext = context.getApplicationContext();
        try {
            return applicationContext.getClass().getMethod("getReactHost", new Class[0]).invoke(applicationContext, new Object[0]);
        } catch (Exception e) {
            LogInstrumentation.m2726d(BackgroundFetch.TAG, "[HeadlessTask] Reflection error ReactHost: " + e);
            return null;
        }
    }

    private ReactContext getReactContext(Context context) {
        if (isBridglessArchitectureEnabled()) {
            Object reactHost = getReactHost(context);
            Assertions.assertNotNull(reactHost, "getReactHost() is null in New Architecture");
            try {
                return (ReactContext) reactHost.getClass().getMethod("getCurrentReactContext", new Class[0]).invoke(reactHost, new Object[0]);
            } catch (Exception e) {
                LogInstrumentation.m2728e(BackgroundFetch.TAG, "[HeadlessTask] Reflection error getCurrentReactContext: " + e);
            }
        }
        return getReactNativeHost(context).getReactInstanceManager().getCurrentReactContext();
    }

    private void createReactContextAndScheduleTask(HeadlessJsTaskConfig headlessJsTaskConfig, Context context) {
        LogInstrumentation.m2726d(BackgroundFetch.TAG, "[HeadlessTask] initializing ReactContext");
        if (isBridglessArchitectureEnabled()) {
            Object reactHost = getReactHost(context);
            try {
                reactHost.getClass().getMethod("addReactInstanceEventListener", ReactInstanceEventListener.class).invoke(reactHost, new C44521(headlessJsTaskConfig, reactHost));
                reactHost.getClass().getMethod("start", new Class[0]).invoke(reactHost, new Object[0]);
                return;
            } catch (Exception e) {
                LogInstrumentation.m2728e(BackgroundFetch.TAG, "[HeadlessTask] reflection error addReactInstanceEventListener: " + e);
                return;
            }
        }
        ReactInstanceManager reactInstanceManager = getReactNativeHost(context).getReactInstanceManager();
        reactInstanceManager.addReactInstanceEventListener(new C44532(headlessJsTaskConfig, reactInstanceManager));
        reactInstanceManager.createReactContextInBackground();
    }

    /* JADX INFO: renamed from: com.transistorsoft.rnbackgroundfetch.HeadlessTask$1 */
    class C44521 implements ReactInstanceEventListener {
        final /* synthetic */ Object val$reactHost;
        final /* synthetic */ HeadlessJsTaskConfig val$taskConfig;

        C44521(HeadlessJsTaskConfig headlessJsTaskConfig, Object obj) {
            this.val$taskConfig = headlessJsTaskConfig;
            this.val$reactHost = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReactContextInitialized$0(ReactContext reactContext, HeadlessJsTaskConfig headlessJsTaskConfig) {
            HeadlessTask.this.invokeStartTask(reactContext, headlessJsTaskConfig);
        }

        @Override // com.facebook.react.ReactInstanceEventListener
        public void onReactContextInitialized(final ReactContext reactContext) {
            Handler handler = HeadlessTask.mHandler;
            final HeadlessJsTaskConfig headlessJsTaskConfig = this.val$taskConfig;
            handler.postDelayed(new Runnable() { // from class: com.transistorsoft.rnbackgroundfetch.HeadlessTask$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReactContextInitialized$0(reactContext, headlessJsTaskConfig);
                }
            }, 500L);
            try {
                this.val$reactHost.getClass().getMethod("removeReactInstanceEventListener", ReactInstanceEventListener.class).invoke(this.val$reactHost, this);
            } catch (Exception e) {
                LogInstrumentation.m2728e(BackgroundFetch.TAG, "[HeadlessTask] reflection error removeReactInstanceEventListener" + e);
            }
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.rnbackgroundfetch.HeadlessTask$2 */
    class C44532 implements ReactInstanceEventListener {
        final /* synthetic */ ReactInstanceManager val$reactInstanceManager;
        final /* synthetic */ HeadlessJsTaskConfig val$taskConfig;

        C44532(HeadlessJsTaskConfig headlessJsTaskConfig, ReactInstanceManager reactInstanceManager) {
            this.val$taskConfig = headlessJsTaskConfig;
            this.val$reactInstanceManager = reactInstanceManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReactContextInitialized$0(ReactContext reactContext, HeadlessJsTaskConfig headlessJsTaskConfig) {
            HeadlessTask.this.invokeStartTask(reactContext, headlessJsTaskConfig);
        }

        @Override // com.facebook.react.ReactInstanceEventListener
        public void onReactContextInitialized(final ReactContext reactContext) {
            Handler handler = HeadlessTask.mHandler;
            final HeadlessJsTaskConfig headlessJsTaskConfig = this.val$taskConfig;
            handler.postDelayed(new Runnable() { // from class: com.transistorsoft.rnbackgroundfetch.HeadlessTask$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReactContextInitialized$0(reactContext, headlessJsTaskConfig);
                }
            }, 500L);
            this.val$reactInstanceManager.removeReactInstanceEventListener(this);
        }
    }

    private boolean isBridglessArchitectureEnabled() {
        try {
            return Class.forName("com.facebook.react.defaults.DefaultNewArchitectureEntryPoint").getMethod("getBridgelessEnabled", new Class[0]).invoke(null, new Object[0]) == Boolean.TRUE;
        } catch (Exception unused) {
            return false;
        }
    }
}
