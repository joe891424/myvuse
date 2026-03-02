package com.qualtrics.digital;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
class InterceptManager {
    static final int NEW_API = 2;
    static final int OLD_API = 1;
    static final int UNEVALUATED = -1;
    ScheduledExecutorService executor;
    private String mBrandId;
    ClientCallbackUtils mClientCallbackUtils;
    ClientSideInterceptUtils mClientSideInterceptUtils;
    private boolean mEnabled;
    private LatencyReporter mEvaluateProjectLatencyReporter;
    protected String mExtRefId;
    private Intercept mIntercept;
    private InterceptAssetVersions mInterceptAssetVersions;
    private String mInterceptId;
    int mLastEvaluateVersion;
    SDKUtils mSDKUtils;
    SiteInterceptService mSiteInterceptService;
    private String mSurveyBaseUrl;
    private LatencyReporter mTargetingResponseLatencyReporter;
    private String mZoneId;
    boolean mobileEmbeddedFeedbackEnabled;
    boolean useHeadlessApis;

    InterceptManager(String str, String str2, String str3, Context context, SDKUtils sDKUtils, ClientCallbackUtils clientCallbackUtils, ClientSideInterceptUtils clientSideInterceptUtils, ScheduledExecutorService scheduledExecutorService) {
        this.mEnabled = false;
        this.mInterceptId = str3;
        this.mBrandId = str;
        this.mZoneId = str2;
        String applicationName = getApplicationName(context);
        this.mSDKUtils = sDKUtils;
        this.mClientCallbackUtils = clientCallbackUtils;
        this.mClientSideInterceptUtils = clientSideInterceptUtils;
        this.mLastEvaluateVersion = -1;
        LatencyReporter latencyReporter = new LatencyReporter("targetingResponse", "/WRSiteInterceptEngine/MobileTargeting?Q_ZoneID=" + this.mZoneId);
        this.mTargetingResponseLatencyReporter = latencyReporter;
        latencyReporter.resetTimer();
        LatencyReporter latencyReporter2 = new LatencyReporter("evaluateProject", "/WRSiteInterceptEngine/MobileXmdDcfEval?Q_ZoneID=" + this.mZoneId);
        this.mEvaluateProjectLatencyReporter = latencyReporter2;
        latencyReporter2.resetTimer();
        initializeDependentServices(str, str2, str3, applicationName);
        this.executor = scheduledExecutorService;
    }

    InterceptManager(String str, String str2, Context context, SDKUtils sDKUtils, ClientCallbackUtils clientCallbackUtils, ClientSideInterceptUtils clientSideInterceptUtils, ScheduledExecutorService scheduledExecutorService, String str3) {
        this.mInterceptId = "";
        this.mEnabled = false;
        this.mZoneId = str2;
        this.mExtRefId = str3;
        this.mBrandId = str;
        String str4 = getApplicationName(context) + "_" + getApplicationVersion(context);
        this.mSDKUtils = sDKUtils;
        this.mClientCallbackUtils = clientCallbackUtils;
        this.mClientSideInterceptUtils = clientSideInterceptUtils;
        this.executor = scheduledExecutorService;
        this.mLastEvaluateVersion = -1;
        LatencyReporter latencyReporter = new LatencyReporter("targetingResponse", "/WRSiteInterceptEngine/MobileTargeting?Q_ZoneID=" + this.mZoneId);
        this.mTargetingResponseLatencyReporter = latencyReporter;
        latencyReporter.resetTimer();
        LatencyReporter latencyReporter2 = new LatencyReporter("evaluateProject", "/WRSiteInterceptEngine/MobileXmdDcfEval?Q_ZoneID=" + this.mZoneId);
        this.mEvaluateProjectLatencyReporter = latencyReporter2;
        latencyReporter2.resetTimer();
        initializeDependentServices(str, str2, null, str4);
    }

    void initializeDependentServices(String str, String str2, String str3, String str4) {
        this.mSDKUtils.initialize(str, str2, str3, str4);
        this.mSiteInterceptService = SiteInterceptService.instance();
    }

    private String getApplicationName(Context context) {
        return context.getPackageName();
    }

    private String getApplicationVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "0";
        }
    }

    void loadIntercept(IQualtricsInitializationCallback iQualtricsInitializationCallback) {
        this.mClientCallbackUtils.setLoadInterceptCallback(iQualtricsInitializationCallback);
        loadIntercept();
    }

    void loadIntercept() {
        try {
            final LatencyReporter latencyReporter = new LatencyReporter("assetVersions", "/WRSiteInterceptEngine/AssetVersions.php?Q_InterceptID=" + this.mInterceptId);
            this.mSiteInterceptService.getAssetVersions(this.mInterceptId, new Callback<ProjectAssetVersions>() { // from class: com.qualtrics.digital.InterceptManager.1
                @Override // retrofit2.Callback
                public void onResponse(Call<ProjectAssetVersions> call, Response<ProjectAssetVersions> response) {
                    InterceptManager.this.decodeAssetVersions(response.body(), latencyReporter);
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<ProjectAssetVersions> call, Throwable th) {
                    if (!(th instanceof IOException)) {
                        InterceptManager.this.postErrorLog("Error calling initialize endpoint", th);
                    }
                    latencyReporter.stopTimerAndReport();
                    QualtricsLog.logError("Unexpected response getting asset versions");
                    QualtricsLog.logError(th);
                    InterceptManager.this.callInterceptInitializationCallback(false, th);
                }
            });
        } catch (Exception e) {
            if (!(e instanceof IOException)) {
                postErrorLog("Error calling initialize endpoint", e);
            }
            callInterceptInitializationCallback(false, (Throwable) e);
        }
    }

    void loadProject(IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback) {
        this.mClientCallbackUtils.setLoadProjectCallback(iQualtricsProjectInitializationCallback);
        loadProject();
    }

    /* JADX INFO: renamed from: com.qualtrics.digital.InterceptManager$2 */
    class C39202 implements Callback<TargetingResponse> {
        C39202() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<TargetingResponse> call, Response<TargetingResponse> response) {
            try {
                TargetingResponse targetingResponseBody = response.body();
                if (targetingResponseBody.Message != null && targetingResponseBody.Message.equals(XMDUtils.xmdRetryResponseKey)) {
                    XMDUtils.getInstance().targetingRetrier.backOffAndRetry(new Runnable() { // from class: com.qualtrics.digital.InterceptManager$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m6389lambda$onResponse$0$comqualtricsdigitalInterceptManager$2();
                        }
                    }, InterceptManager.this.executor);
                } else {
                    InterceptManager interceptManager = InterceptManager.this;
                    interceptManager.handleTargetingResponse(targetingResponseBody, interceptManager.mTargetingResponseLatencyReporter);
                }
            } catch (Exception e) {
                InterceptManager.this.logProjectCancelInitialization(e.getMessage() + ", mobileTargeting Error calling Targeting, initialization cancelled");
                InterceptManager.this.postErrorLog("Error loading project", true, e);
            }
        }

        /* JADX INFO: renamed from: lambda$onResponse$0$com-qualtrics-digital-InterceptManager$2, reason: not valid java name */
        /* synthetic */ void m6389lambda$onResponse$0$comqualtricsdigitalInterceptManager$2() {
            InterceptManager.this.loadProject();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<TargetingResponse> call, Throwable th) {
            if (!(th instanceof IOException)) {
                InterceptManager.this.postErrorLog("Error calling loadProject", th);
            }
            InterceptManager.this.mTargetingResponseLatencyReporter.stopTimerAndReport();
            QualtricsLog.logError("Unexpected response getting asset versions");
            QualtricsLog.logError(th);
            InterceptManager.this.callProjectInitializationCallback("Error", false, th);
        }
    }

    void loadProject() {
        this.mTargetingResponseLatencyReporter.startTimer();
        this.mSiteInterceptService.getMobileTargeting(this.mZoneId, this.mExtRefId, new C39202());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logProjectCancelInitialization(String str) {
        QualtricsLog.logError(str + ", aborting SDK initialization...");
        HashMap map = new HashMap();
        map.put("Error", new InitializationResult(false, str + ", aborting SDK project initialization..."));
        this.mClientCallbackUtils.callLoadProjectCallback(map);
    }

    private void logCancelInitialization(String str) {
        QualtricsLog.logError(str + ", aborting SDK initialization...");
        this.mClientCallbackUtils.callLoadCallback(new InitializationResult(false, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postErrorLog(String str, boolean z, Throwable th) {
        this.mSiteInterceptService.postErrorLog(String.format("%s zoneId=%s", str, this.mZoneId), z, th);
    }

    void decodeAssetVersions(ProjectAssetVersions projectAssetVersions, LatencyReporter latencyReporter) {
        if (projectAssetVersions == null) {
            logCancelInitialization("Could not deserialize asset versions");
            return;
        }
        if (projectAssetVersions.Message != null && projectAssetVersions.Message.equals(SDKUtils.deactivatedProjectResponseKey)) {
            logCancelInitialization("Zone is deactivated");
            return;
        }
        this.mSDKUtils.recordPageView(this.mInterceptId, null, null);
        if (projectAssetVersions.ClientBenchmarkSampleRate != null) {
            this.mSDKUtils.setBenchmarkSampleRate(projectAssetVersions.ClientBenchmarkSampleRate);
            latencyReporter.stopTimerAndReport();
        }
        if (projectAssetVersions.ExecutionEnabled == null) {
            logCancelInitialization("Expected ExecutionEnabled field not present for intercept");
            return;
        }
        if (!projectAssetVersions.ExecutionEnabled.booleanValue()) {
            logCancelInitialization("Mobile SDK ExecutionEnabled not enabled");
            return;
        }
        if (projectAssetVersions.Intercepts == null || !projectAssetVersions.Intercepts.containsKey(this.mInterceptId)) {
            logCancelInitialization("Unexpected intercept asset version received from server");
            return;
        }
        if (!projectAssetVersions.Intercepts.get(this.mInterceptId).Active) {
            logCancelInitialization("Intercept " + this.mInterceptId + " is not active");
            return;
        }
        if (projectAssetVersions.ClientLogSampleRate != null) {
            this.mSDKUtils.setErrorLogSampling(projectAssetVersions.ClientLogSampleRate);
        }
        if (projectAssetVersions.BrandBaseUrl != null) {
            this.mSurveyBaseUrl = projectAssetVersions.BrandBaseUrl;
        }
        if (projectAssetVersions.FeatureFlippers != null) {
            Boolean bool = projectAssetVersions.FeatureFlippers.get("DX.EmbeddedFeedback_NewAPIs");
            if (bool == null) {
                this.useHeadlessApis = false;
            } else {
                this.useHeadlessApis = bool.booleanValue();
            }
            this.mSDKUtils.setUseHeadlessApis(this.useHeadlessApis);
        }
        this.mInterceptAssetVersions = projectAssetVersions.Intercepts.get(this.mInterceptId);
        getInterceptDefinition();
    }

    void handleTargetingResponse(TargetingResponse targetingResponse, LatencyReporter latencyReporter) {
        if (targetingResponse == null) {
            logProjectCancelInitialization("Error calling Targeting");
            postErrorLog("Received null targetingResponse ", true, null);
            return;
        }
        if (targetingResponse.Message != null && targetingResponse.Message.equals(SDKUtils.deactivatedProjectResponseKey)) {
            logProjectCancelInitialization("Zone is deactivated");
            postErrorLog("Received targetingResponse for deactivated project", true, null);
            return;
        }
        if (targetingResponse.FeatureFlags == null) {
            logProjectCancelInitialization("Error calling Targeting");
            postErrorLog("Received null feature flags", true, null);
            return;
        }
        Boolean bool = targetingResponse.FeatureFlags.get("DX.MobileTargeting");
        if (bool == null) {
            logProjectCancelInitialization("Error calling Targeting");
            return;
        }
        Boolean bool2 = targetingResponse.FeatureFlags.get("DX.MobileEmbeddedFeedbackVisitor");
        if (bool2 == null) {
            this.mobileEmbeddedFeedbackEnabled = false;
        } else {
            this.mobileEmbeddedFeedbackEnabled = bool2.booleanValue();
        }
        Boolean bool3 = targetingResponse.FeatureFlags.get("DX.EmbeddedFeedback_NewAPIs");
        if (bool3 == null) {
            this.useHeadlessApis = false;
        } else {
            this.useHeadlessApis = bool3.booleanValue();
        }
        if (!bool.booleanValue()) {
            logProjectCancelInitialization("Project level APIs not enabled for this brand");
            return;
        }
        Targeting targeting = targetingResponse.Targeting;
        if (targeting == null) {
            logProjectCancelInitialization("Unexpected Targeting response received from server");
            postErrorLog("Unable to decode targeting object", true, null);
            return;
        }
        this.mClientSideInterceptUtils.setInitializedClientSideIntercepts(targeting.ClientSideIntercepts);
        this.mClientSideInterceptUtils.setSurveyBaseUrl(targeting.BrandBaseUrl);
        this.mClientSideInterceptUtils.findClientSideInterceptsWithDCF();
        if (this.mExtRefId != null) {
            XMDUtils.getInstance().setXMDImpressionTouchpointParams(this.mExtRefId, targeting.BrandID, targeting.BrandDC);
        }
        this.mSDKUtils.setErrorLogSampling(targeting.ClientLogSampleRate);
        this.mSDKUtils.setBenchmarkSampleRate(targeting.ClientBenchmarkSampleRate);
        this.mSDKUtils.setUseHeadlessApis(this.useHeadlessApis);
        latencyReporter.stopTimerAndReport();
        this.mClientSideInterceptUtils.fetchAllInterceptDefinitions();
        this.mSiteInterceptService.recordPageView(this.mZoneId, null, null);
    }

    void handleContactFrequencyResponse(ContactFrequencyResponse contactFrequencyResponse, LatencyReporter latencyReporter) {
        if (contactFrequencyResponse == null) {
            logProjectCancelEvaluation("Error calling Contact Frequency");
            postErrorLog("Received null contact frequency response", false, null);
            return;
        }
        if (contactFrequencyResponse.Message != null && contactFrequencyResponse.Message.equals(XMDUtils.xmdRetryResponseKey)) {
            XMDUtils.getInstance().contactFrequencyRetrier.backOffAndRetry(new Runnable() { // from class: com.qualtrics.digital.InterceptManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m2790xbdae1be3();
                }
            }, this.executor);
            return;
        }
        XMDUtils.getInstance().contactFrequencyRetrier.resetRetryCount();
        this.mClientSideInterceptUtils.setContactFrequencyRequest(null);
        Map<String, Boolean> map = contactFrequencyResponse.ContactFrequencyIntercepts;
        for (String str : map.keySet()) {
            Boolean bool = map.get(str);
            boolean zContains = this.mClientSideInterceptUtils.cstInterceptsWithDCFEnabled.contains(str);
            if (XMDUtils.getInstance().isXMDContactAnonymous || bool.booleanValue() || !zContains) {
                this.mClientSideInterceptUtils.fetchCreativeDefinition(str);
            } else {
                this.mClientSideInterceptUtils.targetingResults.put(str, new TargetingResult(TargetingResultStatus.contactFrequencyFailed, null, null, str, null, null, null));
                this.mClientCallbackUtils.callMasterEvaluateCallback(this.mClientSideInterceptUtils.targetingResults);
            }
        }
        latencyReporter.stopTimerAndReport();
    }

    /* JADX INFO: renamed from: lambda$handleContactFrequencyResponse$0$com-qualtrics-digital-InterceptManager */
    /* synthetic */ void m2790xbdae1be3() {
        this.mClientSideInterceptUtils.contactFrequencyRequest.run();
    }

    private void getInterceptDefinition() {
        final LatencyReporter latencyReporter = new LatencyReporter("interceptDefinition", String.format(Locale.US, "/WRSiteInterceptEngine/Asset.php?Module=%s&Version=%d&Q_FULL_DEFINITION=true", this.mInterceptId, Integer.valueOf(this.mInterceptAssetVersions.getVersion())));
        this.mSiteInterceptService.getInterceptDefinition(this.mInterceptId, this.mInterceptAssetVersions.getVersion(), new Callback<Intercept>() { // from class: com.qualtrics.digital.InterceptManager.3
            @Override // retrofit2.Callback
            public void onResponse(Call<Intercept> call, Response<Intercept> response) {
                latencyReporter.stopTimerAndReport();
                InterceptManager.this.mIntercept = response.body();
                InterceptManager.this.decodeInterceptDefinition();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<Intercept> call, Throwable th) {
                if (!(th instanceof IOException)) {
                    InterceptManager.this.postErrorLog("Error calling getInterceptDefinition", th);
                }
                latencyReporter.stopTimerAndReport();
                QualtricsLog.logError("Unexpected response getting intercept");
                QualtricsLog.logError(th);
                InterceptManager.this.callInterceptInitializationCallback(false, th);
            }
        });
    }

    void decodeInterceptDefinition() {
        this.mEnabled = true;
        if (this.mIntercept.getInterceptDefinition() != null) {
            this.mIntercept.getInterceptDefinition().setSurveyBaseUrl(this.mSurveyBaseUrl);
            callInterceptInitializationCallback(true, "Qualtrics: Intercept has been loaded");
        }
    }

    void evaluateTargetingLogic(IQualtricsCallback iQualtricsCallback) {
        Intercept intercept;
        if (this.mEnabled && (intercept = this.mIntercept) != null) {
            intercept.getInterceptDefinition().evaluateAndExecuteCallback(iQualtricsCallback, this.mInterceptAssetVersions);
        } else {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, null));
        }
        this.mLastEvaluateVersion = 1;
    }

    void evaluateProject() {
        boolean zEvaluateAllClientSideIntercepts;
        this.mClientCallbackUtils.setMasterEvaluateCallback(new IQualtricsProjectEvaluationCallback() { // from class: com.qualtrics.digital.InterceptManager$$ExternalSyntheticLambda3
            @Override // com.qualtrics.digital.IQualtricsProjectEvaluationCallback
            public final void run(Map map) {
                this.f$0.m6387lambda$evaluateProject$1$comqualtricsdigitalInterceptManager(map);
            }
        });
        if (this.mExtRefId != null && this.mClientSideInterceptUtils.doAnyInterceptsHaveDCFEnabled()) {
            this.mEvaluateProjectLatencyReporter.startTimer();
            zEvaluateAllClientSideIntercepts = this.mClientSideInterceptUtils.evaluateAllClientSideIntercepts(new IMakeDCFRequestCallback() { // from class: com.qualtrics.digital.InterceptManager$$ExternalSyntheticLambda4
                @Override // com.qualtrics.digital.IMakeDCFRequestCallback
                public final void run(Map map) {
                    this.f$0.m6388lambda$evaluateProject$2$comqualtricsdigitalInterceptManager(map);
                }
            });
        } else {
            zEvaluateAllClientSideIntercepts = this.mClientSideInterceptUtils.evaluateAllClientSideIntercepts(null);
        }
        this.mLastEvaluateVersion = 2;
        if (zEvaluateAllClientSideIntercepts) {
            SiteInterceptService.instance().recordPageView(this.mZoneId, null, null);
        }
    }

    /* JADX INFO: renamed from: lambda$evaluateProject$1$com-qualtrics-digital-InterceptManager, reason: not valid java name */
    /* synthetic */ void m6387lambda$evaluateProject$1$comqualtricsdigitalInterceptManager(Map map) {
        this.mClientCallbackUtils.runEvaluateProjectCallbackIfAllEvaluated(map);
    }

    /* JADX INFO: renamed from: lambda$evaluateProject$2$com-qualtrics-digital-InterceptManager, reason: not valid java name */
    /* synthetic */ void m6388lambda$evaluateProject$2$comqualtricsdigitalInterceptManager(Map map) {
        this.mSiteInterceptService.requestXMDContactFrequency(this.mZoneId, this.mExtRefId, map, new Callback<ContactFrequencyResponse>() { // from class: com.qualtrics.digital.InterceptManager.4
            @Override // retrofit2.Callback
            public void onResponse(Call<ContactFrequencyResponse> call, Response<ContactFrequencyResponse> response) {
                InterceptManager.this.handleContactFrequencyResponse(response.body(), InterceptManager.this.mEvaluateProjectLatencyReporter);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ContactFrequencyResponse> call, Throwable th) {
                if (!(th instanceof IOException)) {
                    InterceptManager.this.postErrorLog("Unexpected response getting contact frequency response", th);
                }
                InterceptManager.this.mEvaluateProjectLatencyReporter.stopTimerAndReport();
                QualtricsLog.logError("Unexpected response getting contact frequency response");
                QualtricsLog.logError(th);
            }
        });
    }

    void evaluateIntercept(final String str) {
        boolean zEvaluateClientSideIntercept;
        final LatencyReporter latencyReporter = new LatencyReporter("evaluateIntercept", "/WRSiteInterceptEngine/MobileXmdDcfEval?Q_ZoneID=" + this.mZoneId + " interceptId: " + str);
        this.mClientCallbackUtils.setMasterEvaluateCallback(new IQualtricsProjectEvaluationCallback() { // from class: com.qualtrics.digital.InterceptManager$$ExternalSyntheticLambda1
            @Override // com.qualtrics.digital.IQualtricsProjectEvaluationCallback
            public final void run(Map map) {
                this.f$0.m2788xabca3576(str, map);
            }
        });
        if (this.mExtRefId != null && this.mClientSideInterceptUtils.cstInterceptsWithDCFEnabled.contains(str)) {
            zEvaluateClientSideIntercept = this.mClientSideInterceptUtils.evaluateClientSideIntercept(str, new IMakeDCFRequestCallback() { // from class: com.qualtrics.digital.InterceptManager$$ExternalSyntheticLambda2
                @Override // com.qualtrics.digital.IMakeDCFRequestCallback
                public final void run(Map map) {
                    this.f$0.m2789x2e82655(latencyReporter, map);
                }
            });
        } else {
            zEvaluateClientSideIntercept = this.mClientSideInterceptUtils.evaluateClientSideIntercept(str, null);
        }
        if (zEvaluateClientSideIntercept) {
            SiteInterceptService.instance().recordPageView(str, null, null);
        }
    }

    /* JADX INFO: renamed from: lambda$evaluateIntercept$3$com-qualtrics-digital-InterceptManager */
    /* synthetic */ void m2788xabca3576(String str, Map map) {
        this.mClientCallbackUtils.callEvaluateInterceptCallback((TargetingResult) map.get(str));
    }

    /* JADX INFO: renamed from: lambda$evaluateIntercept$4$com-qualtrics-digital-InterceptManager */
    /* synthetic */ void m2789x2e82655(final LatencyReporter latencyReporter, Map map) {
        this.mSiteInterceptService.requestXMDContactFrequency(this.mZoneId, this.mExtRefId, map, new Callback<ContactFrequencyResponse>() { // from class: com.qualtrics.digital.InterceptManager.5
            @Override // retrofit2.Callback
            public void onResponse(Call<ContactFrequencyResponse> call, Response<ContactFrequencyResponse> response) {
                InterceptManager.this.handleContactFrequencyResponse(response.body(), latencyReporter);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ContactFrequencyResponse> call, Throwable th) {
                if (!(th instanceof IOException)) {
                    InterceptManager.this.postErrorLog("Unexpected response getting contact frequency response", th);
                }
                latencyReporter.stopTimerAndReport();
                QualtricsLog.logError("Unexpected response getting contact frequency response");
                QualtricsLog.logError(th);
            }
        });
    }

    private void logProjectCancelEvaluation(String str) {
        QualtricsLog.logError(str + ", aborting SDK evaluation...");
        HashMap map = new HashMap();
        map.put("Error", new TargetingResult(TargetingResultStatus.error, str + ", aborting SDK project evaluation...", new Exception("Qualtrics: " + str + ", evaluation cancelled")));
        this.mClientCallbackUtils.callMasterEvaluateCallback(map);
    }

    ArrayList<String> getInitializedIntercepts() {
        return new ArrayList<>(this.mClientSideInterceptUtils.mInterceptDefinitions.keySet());
    }

    ArrayList<String> getPassingIntercepts() {
        return new ArrayList<>(this.mClientSideInterceptUtils.mPassingActionSets.keySet());
    }

    void hide() {
        logMessage("hiding");
    }

    boolean display(Context context, int i, boolean z) {
        boolean zDisplayAllPassingIntercepts;
        boolean zDisplay;
        Intercept intercept;
        logMessage("Displaying...");
        int i2 = this.mLastEvaluateVersion;
        if (i2 == 2) {
            zDisplayAllPassingIntercepts = this.mClientSideInterceptUtils.displayAllPassingIntercepts(context, i, z);
            zDisplay = false;
        } else if (i2 == 1 && this.mEnabled && (intercept = this.mIntercept) != null) {
            zDisplay = intercept.getInterceptDefinition().display(context, i, z);
            zDisplayAllPassingIntercepts = false;
        } else {
            zDisplayAllPassingIntercepts = false;
            zDisplay = false;
        }
        return zDisplayAllPassingIntercepts || zDisplay;
    }

    boolean displayIntercept(Context context, String str, int i, boolean z) {
        return this.mClientSideInterceptUtils.displayIntercept(context, str, i, z);
    }

    private void logMessage(String str) {
        QualtricsLog.logInfo(str);
    }

    private void callInterceptInitializationCallback(boolean z, String str) {
        this.mClientCallbackUtils.callLoadCallback(new InitializationResult(Boolean.valueOf(z), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callInterceptInitializationCallback(boolean z, Throwable th) {
        callInterceptInitializationCallback(z, (th == null || th.toString() == null) ? "Unexpected error during initialization" : th.toString());
    }

    private void callProjectInitializationCallback(String str, boolean z, String str2) {
        HashMap map = new HashMap();
        map.put(str, new InitializationResult(Boolean.valueOf(z), str2));
        this.mClientCallbackUtils.callLoadProjectCallback(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callProjectInitializationCallback(String str, boolean z, Throwable th) {
        callProjectInitializationCallback(str, z, (th == null || th.toString() == null) ? "Unexpected error during initialization" : th.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postErrorLog(String str, Throwable th) {
        this.mSDKUtils.postErrorLog(String.format("%s-%s-%s-%s", this.mBrandId, this.mZoneId, this.mIntercept, str), th, true);
    }
}
