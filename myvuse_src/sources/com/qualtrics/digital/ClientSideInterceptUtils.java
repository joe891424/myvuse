package com.qualtrics.digital;

import android.content.Context;
import com.google.gson.JsonObject;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class ClientSideInterceptUtils {
    private static final String DISTRIBUTION_ID_PREFIX = "DXD_";
    private static ClientSideInterceptUtils mInstance;
    IHydratedDCFRequest contactFrequencyRequest;
    Set<String> cstInterceptsWithDCFEnabled;
    ClientCallbackUtils mClientCallbackUtils;
    private ArrayList<ClientSideIntercept> mInitializedClientSideIntercepts;
    Map<String, InterceptDefinition> mInterceptDefinitions;
    Map<String, ActionSet> mPassingActionSets;
    Map<String, CSTActionSet> mPassingCSTActionSets;
    Properties mProperties;
    SDKUtils mSDKUtils;
    String mSurveyBaseUrl;
    Map<String, XmdAttributes> passingActionSetXmdAttributes;
    Map<String, TargetingResult> targetingResults;

    ClientSideInterceptUtils() {
        this.mProperties = Qualtrics.instance().properties;
        this.mSDKUtils = SDKUtils.instance();
        this.mClientCallbackUtils = ClientCallbackUtils.instance();
        this.mInitializedClientSideIntercepts = new ArrayList<>();
        this.mInterceptDefinitions = new HashMap();
        this.cstInterceptsWithDCFEnabled = new HashSet();
        this.mPassingActionSets = new HashMap();
        this.mPassingCSTActionSets = new HashMap();
        this.targetingResults = new HashMap();
        this.passingActionSetXmdAttributes = new HashMap();
    }

    ClientSideInterceptUtils(Properties properties, SDKUtils sDKUtils, ClientCallbackUtils clientCallbackUtils) {
        this.mProperties = properties;
        this.mSDKUtils = sDKUtils;
        this.mClientCallbackUtils = clientCallbackUtils;
        this.mInitializedClientSideIntercepts = new ArrayList<>();
        this.mInterceptDefinitions = new HashMap();
        this.cstInterceptsWithDCFEnabled = new HashSet();
        this.mPassingActionSets = new HashMap();
        this.mPassingCSTActionSets = new HashMap();
        this.targetingResults = new HashMap();
        this.passingActionSetXmdAttributes = new HashMap();
    }

    static ClientSideInterceptUtils instance() {
        if (mInstance == null) {
            mInstance = new ClientSideInterceptUtils();
        }
        return mInstance;
    }

    void setInitializedClientSideIntercepts(ArrayList<ClientSideIntercept> arrayList) {
        this.mInitializedClientSideIntercepts = arrayList;
    }

    void setSurveyBaseUrl(String str) {
        this.mSurveyBaseUrl = str;
    }

    void setContactFrequencyRequest(IHydratedDCFRequest iHydratedDCFRequest) {
        this.contactFrequencyRequest = iHydratedDCFRequest;
    }

    void fetchAllInterceptDefinitions() {
        this.mInterceptDefinitions.clear();
        final HashMap map = new HashMap();
        this.mClientCallbackUtils.setTotalNumIntercepts(this.mInitializedClientSideIntercepts.size());
        for (final ClientSideIntercept clientSideIntercept : this.mInitializedClientSideIntercepts) {
            fetchIntercept(clientSideIntercept, new IQualtricsInitializationCallback() { // from class: com.qualtrics.digital.ClientSideInterceptUtils.1
                @Override // com.qualtrics.digital.IQualtricsInitializationCallback
                public void run(InitializationResult initializationResult) {
                    map.put(clientSideIntercept.InterceptID, initializationResult);
                    ClientSideInterceptUtils.this.mClientCallbackUtils.runLoadProjectCallbackIfAllInterceptsFetched(map, ClientSideInterceptUtils.this.mInterceptDefinitions);
                }
            });
        }
    }

    void fetchIntercept(final ClientSideIntercept clientSideIntercept, final IQualtricsInitializationCallback iQualtricsInitializationCallback) {
        if (!clientSideIntercept.Active.booleanValue()) {
            iQualtricsInitializationCallback.run(new InitializationResult(false, "Qualtrics: Intercept is inactive"));
            return;
        }
        try {
            int i = Integer.parseInt(clientSideIntercept.InterceptRevision);
            this.mSDKUtils.getInterceptDefinition(clientSideIntercept.InterceptID, i, new Callback<Intercept>() { // from class: com.qualtrics.digital.ClientSideInterceptUtils.2
                @Override // retrofit2.Callback
                public void onResponse(Call<Intercept> call, Response<Intercept> response) {
                    try {
                        InterceptDefinition interceptDefinition = response.body().getInterceptDefinition();
                        interceptDefinition.setSurveyBaseUrl(ClientSideInterceptUtils.this.mSurveyBaseUrl);
                        ClientSideInterceptUtils.this.mInterceptDefinitions.put(clientSideIntercept.InterceptID, interceptDefinition);
                        iQualtricsInitializationCallback.run(new InitializationResult(true, "Qualtrics: Intercept has been loaded"));
                    } catch (Exception e) {
                        ClientSideInterceptUtils.this.postErrorLog("Unable to decode intercept definition", clientSideIntercept.InterceptID, e);
                        iQualtricsInitializationCallback.run(new InitializationResult(false, "Qualtrics: Error loading intercept"));
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Intercept> call, Throwable th) {
                    iQualtricsInitializationCallback.run(new InitializationResult(false, "Qualtrics: Error loading intercept"));
                }
            });
        } catch (Exception e) {
            postErrorLog("Unable to parse intercept revision", clientSideIntercept.InterceptID, e);
            iQualtricsInitializationCallback.run(new InitializationResult(false, "Qualtrics: Error parsing revision for intercept"));
        }
    }

    boolean shouldPreventRepeatedDisplay(String str, String str2) {
        try {
            double d = Double.parseDouble(str);
            long lastDisplayTimeForIntercept = this.mProperties.getLastDisplayTimeForIntercept(str2);
            return lastDisplayTimeForIntercept != Long.MAX_VALUE && lastDisplayTimeForIntercept + ((long) ((((d * 24.0d) * 60.0d) * 60.0d) * 1000.0d)) > System.currentTimeMillis();
        } catch (Exception e) {
            postErrorLog(String.format("Encountered error while parsing PRD: %s intercept:%s", str, str2), str2, e);
            return true;
        }
    }

    boolean evaluateAllClientSideIntercepts(final IMakeDCFRequestCallback iMakeDCFRequestCallback) {
        this.mPassingActionSets.clear();
        this.mPassingCSTActionSets.clear();
        this.targetingResults.clear();
        if (this.mInitializedClientSideIntercepts.isEmpty()) {
            this.targetingResults.put("Error", new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, no initialized intercept found")));
            this.mClientCallbackUtils.callEvaluateProjectCallback(this.targetingResults);
            return false;
        }
        Iterator<ClientSideIntercept> it2 = this.mInitializedClientSideIntercepts.iterator();
        while (it2.hasNext()) {
            evaluateClientSideInterceptLogic(it2.next().InterceptID);
        }
        if (iMakeDCFRequestCallback != null) {
            final HashMap map = new HashMap();
            for (String str : this.mPassingCSTActionSets.keySet()) {
                map.put(str, this.mPassingCSTActionSets.get(str).ActionSetID);
            }
            setContactFrequencyRequest(new IHydratedDCFRequest() { // from class: com.qualtrics.digital.ClientSideInterceptUtils$$ExternalSyntheticLambda2
                @Override // com.qualtrics.digital.IHydratedDCFRequest
                public final void run() {
                    iMakeDCFRequestCallback.run(map);
                }
            });
            iMakeDCFRequestCallback.run(map);
        } else {
            HashMap map2 = new HashMap();
            for (String str2 : this.mPassingCSTActionSets.keySet()) {
                map2.put(str2, true);
                fetchCreativeDefinition(str2);
            }
        }
        return true;
    }

    boolean evaluateClientSideIntercept(String str, final IMakeDCFRequestCallback iMakeDCFRequestCallback) {
        this.mPassingActionSets.clear();
        this.mPassingCSTActionSets.clear();
        this.targetingResults.clear();
        if (this.mInitializedClientSideIntercepts.isEmpty()) {
            this.mClientCallbackUtils.callEvaluateInterceptCallback(new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, no initialized intercept found")));
            return false;
        }
        evaluateClientSideInterceptLogic(str);
        if (iMakeDCFRequestCallback != null) {
            final HashMap map = new HashMap();
            map.put(str, this.mPassingCSTActionSets.get(str).ActionSetID);
            setContactFrequencyRequest(new IHydratedDCFRequest() { // from class: com.qualtrics.digital.ClientSideInterceptUtils$$ExternalSyntheticLambda0
                @Override // com.qualtrics.digital.IHydratedDCFRequest
                public final void run() {
                    iMakeDCFRequestCallback.run(map);
                }
            });
            iMakeDCFRequestCallback.run(map);
            return true;
        }
        fetchCreativeDefinition(str);
        return true;
    }

    void evaluateClientSideInterceptLogic(final String str) {
        IQualtricsCallback iQualtricsCallback = new IQualtricsCallback() { // from class: com.qualtrics.digital.ClientSideInterceptUtils$$ExternalSyntheticLambda1
            @Override // com.qualtrics.digital.IQualtricsCallback
            public final void run(TargetingResult targetingResult) {
                this.f$0.m2787x6c2ad7f5(str, targetingResult);
            }
        };
        ClientSideIntercept clientSideInterceptFindMatchingIntercept = findMatchingIntercept(str);
        if (clientSideInterceptFindMatchingIntercept == null) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.error, null, new Exception("Cannot evaluate logic, intercept does not exist or has not been loaded yet"), str, null, null, null));
            return;
        }
        if (!clientSideInterceptFindMatchingIntercept.Active.booleanValue()) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.inactive, null, null, str, null, null, null));
            return;
        }
        if (shouldPreventRepeatedDisplay(clientSideInterceptFindMatchingIntercept.PreventRepeatedDisplay, clientSideInterceptFindMatchingIntercept.InterceptID)) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.multipleDisplayPrevented, null, null, str, null, null, null));
            return;
        }
        if (!clientSideInterceptFindMatchingIntercept.LogicTree.evaluate()) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.failedLogic, null, null, str, null, null, null));
            return;
        }
        CSTActionSet cSTActionSetFindFirstPassingActionSet = findFirstPassingActionSet(clientSideInterceptFindMatchingIntercept);
        if (cSTActionSetFindFirstPassingActionSet == null) {
            iQualtricsCallback.run(new TargetingResult(TargetingResultStatus.failedLogic, null, null, str, null, null, null));
            return;
        }
        this.mPassingCSTActionSets.put(str, cSTActionSetFindFirstPassingActionSet);
        if (clientSideInterceptFindMatchingIntercept.ContactID == null || clientSideInterceptFindMatchingIntercept.DirectoryID == null) {
            return;
        }
        XmdAttributes xmdAttributes = new XmdAttributes();
        try {
            xmdAttributes.DistributionId = HashingUtils.getGuid(DISTRIBUTION_ID_PREFIX);
            xmdAttributes.ContactId = clientSideInterceptFindMatchingIntercept.ContactID;
            xmdAttributes.DirectoryId = clientSideInterceptFindMatchingIntercept.DirectoryID;
            this.passingActionSetXmdAttributes.put(str, xmdAttributes);
        } catch (NoSuchAlgorithmException unused) {
            QualtricsLog.logError("XMD Error - no such hashing algorithm");
        }
    }

    /* JADX INFO: renamed from: lambda$evaluateClientSideInterceptLogic$2$com-qualtrics-digital-ClientSideInterceptUtils */
    /* synthetic */ void m2787x6c2ad7f5(String str, TargetingResult targetingResult) {
        this.targetingResults.put(str, targetingResult);
        this.mClientCallbackUtils.callMasterEvaluateCallback(this.targetingResults);
    }

    public void fetchCreativeDefinition(final String str) {
        final CSTActionSet cSTActionSet = this.mPassingCSTActionSets.get(str);
        Callback<JsonObject> callback = new Callback<JsonObject>() { // from class: com.qualtrics.digital.ClientSideInterceptUtils.3
            @Override // retrofit2.Callback
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Creative decodedCreativeDefinition = DecoderUtils.getDecodedCreativeDefinition(response);
                if (decodedCreativeDefinition == null) {
                    Exception exc = new Exception("Failed to load creative definition, creative JSON contains invalid type");
                    ClientSideInterceptUtils.this.postErrorLog("Failed to load creative definition, creative JSON contains invalid type", str, exc);
                    ClientSideInterceptUtils.this.targetingResults.put(str, new TargetingResult(TargetingResultStatus.error, null, exc, str, null, null, null));
                    return;
                }
                ClientSideInterceptUtils.this.populateTriggeredActionSet(str, cSTActionSet.ActionSetID, decodedCreativeDefinition);
                if (ClientSideInterceptUtils.this.mPassingActionSets.get(str) == null) {
                    Exception exc2 = new Exception("Evaluation was called on intercept before intercept was done loading");
                    ClientSideInterceptUtils.this.postErrorLog("Evaluation was called on intercept before intercept was done loading", str, exc2);
                    ClientSideInterceptUtils.this.targetingResults.put(str, new TargetingResult(TargetingResultStatus.error, null, exc2, str, null, null, null));
                    return;
                }
                ClientSideInterceptUtils.this.targetingResults.put(str, new TargetingResult(TargetingResultStatus.passed, ClientSideInterceptUtils.this.mPassingActionSets.get(str).getTargetUrl(), null, str, cSTActionSet.Creative.f4193ID, cSTActionSet.ActionSetID, CreativeTypes.getCreativeTypeFromName(cSTActionSet.Creative.Type)));
                ClientSideInterceptUtils.this.mClientCallbackUtils.callMasterEvaluateCallback(ClientSideInterceptUtils.this.targetingResults);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<JsonObject> call, Throwable th) {
                ClientSideInterceptUtils.this.targetingResults.put(str, new TargetingResult(TargetingResultStatus.error, null, new Exception("Failed to load creative definition, network request failed"), str, null, null, null));
                ClientSideInterceptUtils.this.mClientCallbackUtils.callMasterEvaluateCallback(ClientSideInterceptUtils.this.targetingResults);
            }
        };
        try {
            this.mSDKUtils.getCreativeDefinition(cSTActionSet.Creative.f4193ID, Integer.parseInt(cSTActionSet.Creative.Revision), str, callback);
        } catch (Exception unused) {
            Exception exc = new Exception("Action set revision not parsable");
            postErrorLog("Action set revision not parsable", str, exc);
            this.targetingResults.put(str, new TargetingResult(TargetingResultStatus.error, null, exc, str, null, null, null));
        }
    }

    void findClientSideInterceptsWithDCF() {
        this.cstInterceptsWithDCFEnabled.clear();
        for (ClientSideIntercept clientSideIntercept : this.mInitializedClientSideIntercepts) {
            if (clientSideIntercept.ContactFrequencyRulesEnabled.booleanValue()) {
                this.cstInterceptsWithDCFEnabled.add(clientSideIntercept.InterceptID);
            }
        }
    }

    boolean doAnyInterceptsHaveDCFEnabled() {
        return this.cstInterceptsWithDCFEnabled.size() > 0;
    }

    CSTActionSet findFirstPassingActionSet(ClientSideIntercept clientSideIntercept) {
        ArrayList<CSTActionSet> arrayList = clientSideIntercept.ActionSets;
        if (clientSideIntercept.RandomizedActionSets.booleanValue()) {
            Collections.shuffle(arrayList);
        }
        if (arrayList == null) {
            return null;
        }
        for (CSTActionSet cSTActionSet : arrayList) {
            if (cSTActionSet.LogicTree.evaluate()) {
                return cSTActionSet;
            }
        }
        return null;
    }

    ClientSideIntercept findMatchingIntercept(String str) {
        for (ClientSideIntercept clientSideIntercept : this.mInitializedClientSideIntercepts) {
            if (clientSideIntercept.InterceptID.equals(str)) {
                return clientSideIntercept;
            }
        }
        return null;
    }

    void populateTriggeredActionSet(String str, String str2, Creative creative) {
        InterceptDefinition interceptDefinition = this.mInterceptDefinitions.get(str);
        if (interceptDefinition == null) {
            return;
        }
        for (ActionSet actionSet : interceptDefinition.ActionSets) {
            if (actionSet.f4192ID.equals(str2)) {
                actionSet.InterceptID = str;
                actionSet.mCreative = creative;
                actionSet.mSurveyBaseUrl = interceptDefinition.getSurveyBaseUrl();
                this.mPassingActionSets.put(str, actionSet);
                return;
            }
        }
    }

    boolean displayAllPassingIntercepts(Context context, int i, boolean z) {
        String str;
        if (new HashSet(this.mPassingActionSets.keySet()).isEmpty()) {
            return false;
        }
        boolean zDisplayNotificationIntercepts = displayNotificationIntercepts(context, i, z);
        Map<String, ActionSet> nonNotificationActionSets = getNonNotificationActionSets();
        Iterator<ClientSideIntercept> it2 = this.mInitializedClientSideIntercepts.iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = null;
                break;
            }
            str = it2.next().InterceptID;
            if (nonNotificationActionSets.containsKey(str)) {
                break;
            }
        }
        boolean zDisplayIntercept = str != null ? displayIntercept(context, str, i, z) : false;
        this.mPassingActionSets.clear();
        return zDisplayNotificationIntercepts || zDisplayIntercept;
    }

    boolean displayNotificationIntercepts(Context context, int i, boolean z) {
        Map<String, ActionSet> notificationActionSets = getNotificationActionSets();
        boolean z2 = false;
        if (!notificationActionSets.isEmpty()) {
            Iterator<ClientSideIntercept> it2 = this.mInitializedClientSideIntercepts.iterator();
            while (it2.hasNext()) {
                String str = it2.next().InterceptID;
                if (notificationActionSets.containsKey(str) && displayIntercept(context, str, i, z)) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    Map<String, ActionSet> getNonNotificationActionSets() {
        HashMap map = new HashMap();
        for (String str : this.mPassingActionSets.keySet()) {
            ActionSet actionSet = this.mPassingActionSets.get(str);
            if (actionSet.mCreative.getCreativeType() != CreativeType.MobileNotification) {
                map.put(str, actionSet);
            }
        }
        return map;
    }

    Map<String, ActionSet> getNotificationActionSets() {
        HashMap map = new HashMap();
        for (String str : this.mPassingActionSets.keySet()) {
            ActionSet actionSet = this.mPassingActionSets.get(str);
            if (actionSet.mCreative.getCreativeType() == CreativeType.MobileNotification) {
                map.put(str, actionSet);
            }
        }
        return map;
    }

    boolean displayIntercept(Context context, String str, int i, boolean z) {
        ActionSet actionSet = this.mPassingActionSets.get(str);
        if (actionSet == null) {
            return false;
        }
        if (this.passingActionSetXmdAttributes.containsKey(str)) {
            this.passingActionSetXmdAttributes.get(str).SurveyId = actionSet.Target.PrimaryElement;
        }
        boolean zDisplay = actionSet.display(context, i, z);
        this.mPassingActionSets.remove(str);
        Qualtrics.instance().properties.setLastDisplayTimeForIntercept(str);
        return zDisplay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postErrorLog(String str, String str2, Throwable th) {
        this.mSDKUtils.postErrorLog(String.format("%s interceptId:%s", str, str2), th);
    }

    public String getQTouchpoint(String str) {
        XmdAttributes xmdAttributes = this.passingActionSetXmdAttributes.get(str);
        if (xmdAttributes != null) {
            return xmdAttributes.DistributionId + "_" + xmdAttributes.ContactId + "_" + xmdAttributes.DirectoryId;
        }
        return null;
    }
}
