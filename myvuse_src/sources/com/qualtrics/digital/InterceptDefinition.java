package com.qualtrics.digital;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class InterceptDefinition {
    ArrayList<ActionSet> ActionSets;
    DisplayOptions DisplayOptions;
    String InterceptID;
    Logic Logic;
    boolean actionSetEvaluate;
    boolean displayRateSampling;
    boolean logicEvaluate;
    private String mSurveyBaseUrl;
    ActionSet mTriggeredActionSet;
    boolean shouldDisplay;

    InterceptDefinition(Logic logic, ArrayList<ActionSet> arrayList, DisplayOptions displayOptions, String str) {
        this.Logic = logic;
        this.ActionSets = arrayList;
        this.DisplayOptions = displayOptions;
        this.InterceptID = str;
    }

    void setSurveyBaseUrl(String str) {
        this.mSurveyBaseUrl = str;
    }

    String getSurveyBaseUrl() {
        return this.mSurveyBaseUrl;
    }

    boolean shouldDisplayIntercept() {
        return Properties.instance(null).getLastDisplayTime() + ((long) ((((this.DisplayOptions.getPreventRepeatedDisplayInDays() * 24.0d) * 60.0d) * 60.0d) * 1000.0d)) <= System.currentTimeMillis();
    }

    private boolean evaluate() {
        this.shouldDisplay = shouldDisplayIntercept();
        Logic logic = this.Logic;
        this.logicEvaluate = logic != null && logic.evaluate();
        boolean zCheckSampling = SamplingUtil.checkSampling(Double.valueOf(this.DisplayOptions.getSamplingRate()));
        this.displayRateSampling = zCheckSampling;
        return this.shouldDisplay && this.logicEvaluate && zCheckSampling;
    }

    void evaluateAndExecuteCallback(IQualtricsCallback iQualtricsCallback, InterceptAssetVersions interceptAssetVersions) {
        LatencyReporter latencyReporter = new LatencyReporter("evaluateTargetingLogic", "");
        if (evaluate()) {
            if (this.DisplayOptions.getHasActionSetRandomization() && this.ActionSets.size() > 1) {
                Collections.shuffle(this.ActionSets);
            }
            for (ActionSet actionSet : this.ActionSets) {
                if (actionSet.evaluate()) {
                    this.mTriggeredActionSet = actionSet;
                    SiteInterceptService.instance().recordPageView(this.InterceptID, this.mTriggeredActionSet.Creative, this.mTriggeredActionSet.f4192ID);
                    actionSet.loadCreative(iQualtricsCallback, interceptAssetVersions, this.InterceptID, this.mSurveyBaseUrl);
                    latencyReporter.stopTimerAndReport();
                    return;
                }
            }
            this.actionSetEvaluate = false;
        }
        SiteInterceptService.instance().recordPageView(this.InterceptID, null, null);
        if (!this.shouldDisplay) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.multipleDisplayPrevented, null, null));
        } else if (!this.logicEvaluate) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.failedLogic, null, null));
        } else if (!this.displayRateSampling) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.sampledOut, null, null));
        } else if (!this.actionSetEvaluate) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.failedLogic, null, null));
        } else {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, null));
        }
        latencyReporter.stopTimerAndReport();
    }

    boolean display(Context context, int i, boolean z) {
        ActionSet actionSet = this.mTriggeredActionSet;
        if (actionSet != null) {
            boolean zDisplay = actionSet.display(context, i, z);
            this.mTriggeredActionSet = null;
            return zDisplay;
        }
        LogInstrumentation.m2728e("Qualtrics", "Attempt to call display when no survey was triggered");
        return false;
    }
}
