package com.qualtrics.digital;

import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.qualtrics.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class ActionSet {
    private ActionOptions ActionOptions;
    String Creative;
    private ArrayList<EmbeddedData> EmbeddedData;

    /* JADX INFO: renamed from: ID */
    String f4192ID;
    protected String InterceptID;
    private Logic Logic;
    protected Target Target;
    protected Map<String, String> embeddedDataMap = new HashMap();
    protected Creative mCreative;
    String mSurveyBaseUrl;

    ActionSet() {
    }

    boolean evaluate() {
        Logic logic = this.Logic;
        return logic != null && logic.evaluate() && SamplingUtil.checkSampling(this.ActionOptions.getActionSetSampleRate());
    }

    void loadCreative(IQualtricsCallback iQualtricsCallback, InterceptAssetVersions interceptAssetVersions, String str, String str2) {
        this.mSurveyBaseUrl = str2;
        this.InterceptID = str;
        Properties.instance(null).setLastDisplayTime();
        if (this.mCreative == null) {
            int creativeVersion = interceptAssetVersions.getCreativeVersion(this.Creative);
            SiteInterceptService.instance().getCreativeDefinition(this.Creative, creativeVersion, str, getCreativeDefinitionCallback(iQualtricsCallback, creativeVersion));
        } else {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.passed, getTargetUrl(), null));
        }
    }

    boolean display(Context context, int i, boolean z) {
        Creative creative = this.mCreative;
        if (creative == null) {
            return false;
        }
        boolean zDisplay = creative.display(context, getTargetUrl(), this.InterceptID, this.Creative, this.f4192ID, i, this.Target.PrimaryElement, this.mSurveyBaseUrl, this.embeddedDataMap, z);
        if (!zDisplay) {
            LogInstrumentation.m2728e("Qualtrics", "Failed to display creative");
            return zDisplay;
        }
        SiteInterceptService.instance().recordImpression(this.InterceptID, this.Creative, this.f4192ID);
        return zDisplay;
    }

    String getTargetUrl() {
        Uri.Builder builderBuildUpon;
        if (this.Target.getType().toLowerCase().equals("survey")) {
            String str = this.mSurveyBaseUrl;
            if (str == null) {
                builderBuildUpon = new Uri.Builder();
                builderBuildUpon.scheme("https");
                builderBuildUpon.authority(BuildConfig.SURVEY_BASE_URL);
            } else {
                builderBuildUpon = Uri.parse(str).buildUpon();
            }
            if (builderBuildUpon == null) {
                LogInstrumentation.m2728e("Qualtrics", "Unable to build survey url");
                return null;
            }
            builderBuildUpon.appendPath("jfe").appendPath("form").appendPath(this.Target.getPrimaryElement());
            return appendEmbeddedData(builderBuildUpon).build().toString();
        }
        if (this.Target.getType().toLowerCase().equals("userdefined")) {
            return appendEmbeddedData(Uri.parse(this.Target.getPrimaryElement()).buildUpon()).build().toString();
        }
        LogInstrumentation.m2728e("Qualtrics", "Unexpected target type: " + this.Target.getType());
        return null;
    }

    private Uri.Builder appendEmbeddedData(Uri.Builder builder) {
        if (ClientSideInterceptUtils.instance().getQTouchpoint(this.InterceptID) != null) {
            builder.appendQueryParameter("Q_Touchpoint", ClientSideInterceptUtils.instance().getQTouchpoint(this.InterceptID));
        }
        Properties propertiesInstance = Properties.instance(null);
        Map<String, ?> map = new HashMap<>();
        if (propertiesInstance != null) {
            map = propertiesInstance.getAllQProperties();
        }
        builder.appendQueryParameter("Q_CHL", "si_appsdk");
        this.embeddedDataMap.put("Q_CHL", "si_appsdk");
        ArrayList<EmbeddedData> arrayList = this.EmbeddedData;
        if (arrayList != null) {
            for (EmbeddedData embeddedData : arrayList) {
                String lowerCase = embeddedData.type.toLowerCase();
                lowerCase.hashCode();
                switch (lowerCase) {
                    case "mobilepagecounttotal":
                        String str = ViewCounter.instance().getTotalViewsVisited() + "";
                        builder.appendQueryParameter(embeddedData.name, str);
                        this.embeddedDataMap.put(embeddedData.name, str);
                        break;
                    case "mobiletimespentvisitingsite":
                        String str2 = DurationTimer.instance().getElapsedSeconds() + "";
                        builder.appendQueryParameter(embeddedData.name, str2);
                        this.embeddedDataMap.put(embeddedData.name, str2);
                        break;
                    case "mobilecustomproperty":
                        Object obj = map.get(embeddedData.value);
                        if (obj != null) {
                            String strValueOf = String.valueOf(obj);
                            builder.appendQueryParameter(embeddedData.name, strValueOf);
                            this.embeddedDataMap.put(embeddedData.name, strValueOf);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "mobilepagecountpage":
                        String str3 = ViewCounter.instance().getUniqueViewsVisited() + "";
                        builder.appendQueryParameter(embeddedData.name, str3);
                        this.embeddedDataMap.put(embeddedData.name, str3);
                        break;
                    case "mobilestaticval":
                        builder.appendQueryParameter(embeddedData.name, embeddedData.value);
                        this.embeddedDataMap.put(embeddedData.name, embeddedData.value);
                        break;
                }
            }
        }
        return builder;
    }

    private Callback<JsonObject> getCreativeDefinitionCallback(final IQualtricsCallback iQualtricsCallback, int i) {
        final LatencyReporter latencyReporter = new LatencyReporter(String.format(Locale.US, "creativeDefinition.%s", this.Creative), String.format(Locale.US, "/WRSiteInterceptEngine/Asset.php?Module=%s&Version=%d&Q_InterceptID=%s", this.Creative, Integer.valueOf(i), this.InterceptID));
        return new Callback<JsonObject>() { // from class: com.qualtrics.digital.ActionSet.1
            @Override // retrofit2.Callback
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                latencyReporter.stopTimerAndReport();
                String creativeType = DecoderUtils.getCreativeType(response);
                ActionSet.this.mCreative = DecoderUtils.getDecodedCreativeDefinition(response);
                if (ActionSet.this.mCreative == null) {
                    LogInstrumentation.m2728e("Qualtrics", "Creative JSON contains invalid type");
                    iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, new Exception("Creative JSON contains invalid type")));
                } else {
                    ActionSet.this.mCreative.setSurveyUrl(ActionSet.this.getTargetUrl());
                    iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.passed, ActionSet.this.getTargetUrl(), null, ActionSet.this.InterceptID, ActionSet.this.Creative, ActionSet.this.f4192ID, CreativeTypes.getCreativeTypeFromName(creativeType)));
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<JsonObject> call, Throwable th) {
                latencyReporter.stopTimerAndReport();
                LogInstrumentation.m2728e("Qualtrics", "Unexpected response getting creative");
                LogInstrumentation.m2728e("Qualtrics", th.getMessage());
                iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, new Exception(th)));
            }
        };
    }
}
