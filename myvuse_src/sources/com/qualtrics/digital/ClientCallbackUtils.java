package com.qualtrics.digital;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ClientCallbackUtils {
    private static final Object evaluateLock = new Object();
    private static final Object fetchLock = new Object();
    private static ClientCallbackUtils mInstance;
    private IQualtricsEmbeddedFeedbackDialogCloseListener mEmbeddedFeedbackOnCloseListener;
    private IQualtricsCallback mEvaluateInterceptCallback;
    private IQualtricsProjectEvaluationCallback mEvaluateProjectCallback;
    private IQualtricsInitializationCallback mLoadInterceptCallback;
    private IQualtricsProjectInitializationCallback mLoadProjectCallback;
    private IQualtricsProjectEvaluationCallback mMasterEvaluateCallback;
    private int totalNumIntercepts;
    private int numFetchedIntercepts = 0;
    private int numEvaluatedIntercepts = 0;

    static ClientCallbackUtils instance() {
        if (mInstance == null) {
            mInstance = new ClientCallbackUtils();
        }
        return mInstance;
    }

    void callLoadCallback(InitializationResult initializationResult) {
        IQualtricsInitializationCallback iQualtricsInitializationCallback = this.mLoadInterceptCallback;
        if (iQualtricsInitializationCallback == null) {
            return;
        }
        iQualtricsInitializationCallback.run(initializationResult);
        this.mLoadInterceptCallback = null;
    }

    void callLoadProjectCallback(Map<String, InitializationResult> map) {
        setNumFetchedIntercepts(0);
        IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback = this.mLoadProjectCallback;
        if (iQualtricsProjectInitializationCallback == null) {
            return;
        }
        iQualtricsProjectInitializationCallback.run(map);
        this.mLoadProjectCallback = null;
    }

    void runLoadProjectCallbackIfAllInterceptsFetched(Map<String, InitializationResult> map, Map<String, InterceptDefinition> map2) {
        incrementNumFetchedIntercepts();
        if (this.numFetchedIntercepts == this.totalNumIntercepts) {
            triggerCallLoadProjectCallback(map, map2);
        }
    }

    void triggerCallLoadProjectCallback(Map<String, InitializationResult> map, Map<String, InterceptDefinition> map2) {
        if (map2.isEmpty()) {
            HashMap map3 = new HashMap();
            map3.put("Error", new InitializationResult(false, "Qualtrics: No Intercepts loaded, project initialization cancelled"));
            callLoadProjectCallback(map3);
        } else {
            QualtricsLog.logInfo("Initialization Successful");
            callLoadProjectCallback(map);
        }
    }

    void setNumFetchedIntercepts(int i) {
        this.numFetchedIntercepts = i;
    }

    void incrementNumFetchedIntercepts() {
        synchronized (fetchLock) {
            setNumFetchedIntercepts(this.numFetchedIntercepts + 1);
        }
    }

    void setTotalNumIntercepts(int i) {
        this.totalNumIntercepts = i;
    }

    void callMasterEvaluateCallback(Map<String, TargetingResult> map) {
        IQualtricsProjectEvaluationCallback iQualtricsProjectEvaluationCallback = this.mMasterEvaluateCallback;
        if (iQualtricsProjectEvaluationCallback == null) {
            return;
        }
        iQualtricsProjectEvaluationCallback.run(map);
    }

    void callEvaluateInterceptCallback(TargetingResult targetingResult) {
        IQualtricsCallback iQualtricsCallback = this.mEvaluateInterceptCallback;
        if (iQualtricsCallback == null) {
            return;
        }
        iQualtricsCallback.run(targetingResult);
        this.mEvaluateInterceptCallback = null;
        this.mMasterEvaluateCallback = null;
    }

    void callEvaluateProjectCallback(Map<String, TargetingResult> map) {
        setNumEvaluatedIntercepts(0);
        IQualtricsProjectEvaluationCallback iQualtricsProjectEvaluationCallback = this.mEvaluateProjectCallback;
        if (iQualtricsProjectEvaluationCallback == null) {
            return;
        }
        iQualtricsProjectEvaluationCallback.run(map);
        this.mEvaluateProjectCallback = null;
        this.mMasterEvaluateCallback = null;
    }

    void runEvaluateProjectCallbackIfAllEvaluated(Map<String, TargetingResult> map) {
        incrementNumEvaluatedIntercepts();
        if (this.numEvaluatedIntercepts == this.totalNumIntercepts) {
            callEvaluateProjectCallback(map);
        }
    }

    void setNumEvaluatedIntercepts(int i) {
        this.numEvaluatedIntercepts = i;
    }

    void incrementNumEvaluatedIntercepts() {
        synchronized (evaluateLock) {
            setNumEvaluatedIntercepts(this.numEvaluatedIntercepts + 1);
        }
    }

    void callEmbeddedFeedbackOnCloseListener() {
        IQualtricsEmbeddedFeedbackDialogCloseListener iQualtricsEmbeddedFeedbackDialogCloseListener = this.mEmbeddedFeedbackOnCloseListener;
        if (iQualtricsEmbeddedFeedbackDialogCloseListener != null) {
            iQualtricsEmbeddedFeedbackDialogCloseListener.run();
        }
        this.mEmbeddedFeedbackOnCloseListener = null;
    }

    void setLoadInterceptCallback(IQualtricsInitializationCallback iQualtricsInitializationCallback) {
        this.mLoadInterceptCallback = iQualtricsInitializationCallback;
    }

    void setLoadProjectCallback(IQualtricsProjectInitializationCallback iQualtricsProjectInitializationCallback) {
        this.mLoadProjectCallback = iQualtricsProjectInitializationCallback;
    }

    void setMasterEvaluateCallback(IQualtricsProjectEvaluationCallback iQualtricsProjectEvaluationCallback) {
        this.mMasterEvaluateCallback = iQualtricsProjectEvaluationCallback;
    }

    void setEvaluateProjectCallback(IQualtricsProjectEvaluationCallback iQualtricsProjectEvaluationCallback) {
        this.mEvaluateProjectCallback = iQualtricsProjectEvaluationCallback;
    }

    void setEvaluateInterceptCallback(IQualtricsCallback iQualtricsCallback) {
        this.mEvaluateInterceptCallback = iQualtricsCallback;
    }

    void setEmbeddedFeedbackOnCloseListener(IQualtricsEmbeddedFeedbackDialogCloseListener iQualtricsEmbeddedFeedbackDialogCloseListener) {
        this.mEmbeddedFeedbackOnCloseListener = iQualtricsEmbeddedFeedbackDialogCloseListener;
    }
}
