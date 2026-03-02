package com.qualtrics.digital;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.C3902R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class Qualtrics {
    private static Qualtrics mInstance;
    protected InterceptManager mInterceptManager = null;
    public Properties properties = Properties.instance(null);
    QualtricsWebviewTheme webviewTheme = new QualtricsWebviewTheme(C3902R.drawable.ic_close_black_24dp, Color.parseColor("#F5F5F5"));
    QualtricsTheme creativeTheme = QualtricsTheme.buildDefaultQualtricsTheme();
    ScheduledExecutorService backgroundExecutor = Executors.newScheduledThreadPool(1);

    private Qualtrics() {
    }

    public static Qualtrics instance() {
        if (mInstance == null) {
            mInstance = new Qualtrics();
        }
        return mInstance;
    }

    private boolean validateID(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        return Pattern.compile(String.format(Locale.US, "%s_[0-9a-zA-Z]{11,15}", str)).matcher(str2).matches();
    }

    private void logInvalidId(String str) {
        LogInstrumentation.m2728e("Qualtrics", String.format(Locale.US, "Invalid %s, initialization cancelled", str));
    }

    public void setLogLevel(QualtricsLogLevel qualtricsLogLevel) {
        QualtricsLog.setLogLevel(qualtricsLogLevel);
    }

    public void initialize(String str, String str2, String str3, Context context) {
        initialize(str, str2, str3, context, null);
    }

    public void initialize(String str, String str2, String str3, Context context, final IQualtricsInitializationCallback iQualtricsInitializationCallback) {
        try {
            if (!validateID("ZN", str2)) {
                logInvalidId("zone ID");
                if (iQualtricsInitializationCallback != null) {
                    iQualtricsInitializationCallback.run(new InitializationResult(false, "Invalid Zone ID"));
                    return;
                }
                return;
            }
            if (!validateID("SI", str3)) {
                logInvalidId("intercept ID");
                if (iQualtricsInitializationCallback != null) {
                    iQualtricsInitializationCallback.run(new InitializationResult(false, "Invalid Intercept ID"));
                    return;
                }
                return;
            }
            if (str == null) {
                logInvalidId("brand ID");
                if (iQualtricsInitializationCallback != null) {
                    iQualtricsInitializationCallback.run(new InitializationResult(false, "Invalid Brand ID"));
                    return;
                }
                return;
            }
            DurationTimer.instance().start();
            QualtricsNotificationManager.createChannel(context);
            this.properties.setContext(context);
            this.mInterceptManager = new InterceptManager(str, str2, str3, context, SDKUtils.instance(), ClientCallbackUtils.instance(), ClientSideInterceptUtils.instance(), this.backgroundExecutor);
            if (iQualtricsInitializationCallback != null) {
                this.backgroundExecutor.execute(new Runnable() { // from class: com.qualtrics.digital.Qualtrics$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m6391lambda$initialize$0$comqualtricsdigitalQualtrics(iQualtricsInitializationCallback);
                    }
                });
            } else {
                this.backgroundExecutor.execute(new Runnable() { // from class: com.qualtrics.digital.Qualtrics$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m6392lambda$initialize$1$comqualtricsdigitalQualtrics();
                    }
                });
            }
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$0$com-qualtrics-digital-Qualtrics, reason: not valid java name */
    /* synthetic */ void m6391lambda$initialize$0$comqualtricsdigitalQualtrics(IQualtricsInitializationCallback iQualtricsInitializationCallback) {
        this.mInterceptManager.loadIntercept(iQualtricsInitializationCallback);
    }

    /* JADX INFO: renamed from: lambda$initialize$1$com-qualtrics-digital-Qualtrics, reason: not valid java name */
    /* synthetic */ void m6392lambda$initialize$1$comqualtricsdigitalQualtrics() {
        this.mInterceptManager.loadIntercept();
    }

    public void initializeProject(String str, String str2, Context context) {
        initializeProject(str, str2, null, context, null);
    }

    public void initializeProject(String str, String str2, Context context, IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback) {
        initializeProject(str, str2, null, context, iQualtricsProjectInitializationCallback);
    }

    public void initializeProject(String str, String str2, String str3, Context context) {
        initializeProject(str, str2, str3, context, null);
    }

    public void initializeProject(String str, String str2, String str3, Context context, final IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback) {
        try {
            if (!validateID("ZN", str2)) {
                logInvalidId("zone ID");
                if (iQualtricsProjectInitializationCallback != null) {
                    HashMap map = new HashMap();
                    map.put("Error", new InitializationResult(false, "Invalid Zone ID"));
                    iQualtricsProjectInitializationCallback.run(map);
                    return;
                }
                return;
            }
            if (str == null) {
                logInvalidId("brand ID");
                if (iQualtricsProjectInitializationCallback != null) {
                    HashMap map2 = new HashMap();
                    map2.put("Error", new InitializationResult(false, "Invalid Brand ID"));
                    iQualtricsProjectInitializationCallback.run(map2);
                    return;
                }
                return;
            }
            if (str3 != null && str3.equals("")) {
                str3 = null;
            }
            DurationTimer.instance().start();
            QualtricsNotificationManager.createChannel(context);
            this.properties.setContext(context);
            this.mInterceptManager = new InterceptManager(str, str2, context, SDKUtils.instance(), ClientCallbackUtils.instance(), ClientSideInterceptUtils.instance(), this.backgroundExecutor, str3);
            if (iQualtricsProjectInitializationCallback != null) {
                this.backgroundExecutor.execute(new Runnable() { // from class: com.qualtrics.digital.Qualtrics$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m6393lambda$initializeProject$2$comqualtricsdigitalQualtrics(iQualtricsProjectInitializationCallback);
                    }
                });
            } else {
                this.backgroundExecutor.execute(new Runnable() { // from class: com.qualtrics.digital.Qualtrics$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m6394lambda$initializeProject$3$comqualtricsdigitalQualtrics();
                    }
                });
            }
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    /* JADX INFO: renamed from: lambda$initializeProject$2$com-qualtrics-digital-Qualtrics, reason: not valid java name */
    /* synthetic */ void m6393lambda$initializeProject$2$comqualtricsdigitalQualtrics(IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback) {
        this.mInterceptManager.loadProject(iQualtricsProjectInitializationCallback);
    }

    /* JADX INFO: renamed from: lambda$initializeProject$3$com-qualtrics-digital-Qualtrics, reason: not valid java name */
    /* synthetic */ void m6394lambda$initializeProject$3$comqualtricsdigitalQualtrics() {
        this.mInterceptManager.loadProject();
    }

    public void setCustomNetworkRequestInterceptor(IQualtricsRequestInterceptor iQualtricsRequestInterceptor) {
        RequestInterceptorProvider.getInstance().setRequestHandler(iQualtricsRequestInterceptor);
    }

    public void evaluateTargetingLogic(IQualtricsCallback iQualtricsCallback) {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager != null) {
                interceptManager.evaluateTargetingLogic(iQualtricsCallback);
            } else {
                LogInstrumentation.m2728e("Qualtrics", "Cannot evaluate logic, SDK has not been initialized");
                iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, SDK has not been initialized")));
            }
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    public void evaluateProject(IQualtricsProjectEvaluationCallback iQualtricsProjectEvaluationCallback) {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager != null) {
                interceptManager.mClientCallbackUtils.setEvaluateProjectCallback(iQualtricsProjectEvaluationCallback);
                this.mInterceptManager.evaluateProject();
            } else {
                LogInstrumentation.m2728e("Qualtrics", "Cannot evaluate logic, SDK has not been initialized");
                TargetingResult targetingResult = new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, SDK has not been initialized"));
                HashMap map = new HashMap();
                map.put("Error", targetingResult);
                iQualtricsProjectEvaluationCallback.run(map);
            }
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    public void evaluateIntercept(String str, IQualtricsCallback iQualtricsCallback) {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager != null) {
                interceptManager.mClientCallbackUtils.setEvaluateInterceptCallback(iQualtricsCallback);
                this.mInterceptManager.evaluateIntercept(str);
            } else {
                LogInstrumentation.m2728e("Qualtrics", "Cannot evaluate logic, SDK has not been initialized");
                iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, SDK has not been initialized")));
            }
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    public void setEmbeddedFeedbackDialogCloseListener(IQualtricsEmbeddedFeedbackDialogCloseListener iQualtricsEmbeddedFeedbackDialogCloseListener) {
        ClientCallbackUtils.instance().setEmbeddedFeedbackOnCloseListener(iQualtricsEmbeddedFeedbackDialogCloseListener);
    }

    public void registerViewVisit(String str) {
        try {
            ViewCounter.instance().registerViewVisit(str);
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
        }
    }

    public boolean display(Context context, int i, boolean z) {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager != null) {
                return interceptManager.display(context, i, z);
            }
            return false;
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
            return false;
        }
    }

    public boolean display(Context context) {
        return display(context, 0, false);
    }

    public boolean display(Context context, boolean z) {
        return display(context, 0, z);
    }

    public boolean displayIntercept(Context context, String str, int i, boolean z) {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager != null) {
                return interceptManager.displayIntercept(context, str, i, z);
            }
            return false;
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
            return false;
        }
    }

    public boolean displayIntercept(Context context, String str) {
        return displayIntercept(context, str, 0, false);
    }

    public boolean displayIntercept(Context context, String str, int i) {
        return displayIntercept(context, str, i, false);
    }

    public boolean displayTarget(Context context, String str) {
        return displayTarget(context, str, 0, false);
    }

    public boolean displayTarget(Context context, String str, boolean z) {
        return displayTarget(context, str, 0, z);
    }

    public boolean displayTarget(Context context, String str, int i, boolean z) {
        if (context == null || str == null) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) QualtricsSurveyActivity.class);
        intent.putExtra("targetURL", str);
        intent.putExtra("autoCloseAtEndOfSurvey", z);
        intent.setFlags(268435456);
        intent.putExtra("layoutFlags", i);
        context.startActivity(intent);
        return true;
    }

    public ArrayList<String> getInitializedIntercepts() {
        InterceptManager interceptManager = this.mInterceptManager;
        if (interceptManager != null) {
            return interceptManager.getInitializedIntercepts();
        }
        return new ArrayList<>();
    }

    public String getQualtricsContactId(String str) {
        return ClientSideInterceptUtils.instance().getQTouchpoint(str);
    }

    public ArrayList<String> getPassingIntercepts() {
        InterceptManager interceptManager = this.mInterceptManager;
        if (interceptManager != null) {
            return interceptManager.getPassingIntercepts();
        }
        return new ArrayList<>();
    }

    public boolean hide() {
        try {
            InterceptManager interceptManager = this.mInterceptManager;
            if (interceptManager == null) {
                return false;
            }
            interceptManager.hide();
            return true;
        } catch (Throwable th) {
            CrashReporter.logCrash(th);
            return false;
        }
    }

    public void resetViewCounter() {
        ViewCounter.instance().reset();
    }

    public void resetTimer() {
        DurationTimer.instance().start();
    }

    public void setWebviewTheme(QualtricsWebviewTheme qualtricsWebviewTheme) {
        this.webviewTheme = qualtricsWebviewTheme;
    }

    public QualtricsWebviewTheme getWebviewTheme() {
        return this.webviewTheme;
    }

    public void setCreativeTheme(QualtricsTheme qualtricsTheme) {
        this.creativeTheme = qualtricsTheme;
    }

    public QualtricsTheme getCreativeTheme() {
        return this.creativeTheme;
    }
}
