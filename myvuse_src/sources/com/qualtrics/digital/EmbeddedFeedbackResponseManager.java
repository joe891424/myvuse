package com.qualtrics.digital;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.qualtrics.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackResponseManager {
    static final String BASE_URL = "baseUrl";
    static final String EMBEDDED_DATA = "embeddedData";
    static final String SURVEY_ID = "surveyId";
    final String baseUrl;
    final Map<String, String> embeddedData;
    HeadlessStartResponse headlessStartResponse;
    final String interceptId;
    final SDKUtils mSDKUtils;
    private final Properties properties;
    final SiteInterceptService siteInterceptService;
    final String surveyId;
    final String surveyVersionId;
    final boolean useHeadlessApi;
    Map<String, Object> responses = new HashMap();
    Map<String, String> questionTypes = new HashMap();

    EmbeddedFeedbackResponseManager(String str, String str2, String str3, Map<String, String> map, String str4, SDKUtils sDKUtils, SiteInterceptService siteInterceptService, Properties properties) {
        this.interceptId = str;
        this.baseUrl = str2;
        this.siteInterceptService = siteInterceptService;
        this.properties = properties;
        this.surveyId = str3;
        this.surveyVersionId = str4;
        this.mSDKUtils = sDKUtils;
        this.embeddedData = map;
        this.useHeadlessApi = sDKUtils.getUseHeadlessApis();
    }

    void addToResponse(String str, String str2) {
        this.responses.put(str, str2);
    }

    void addMultipleChoiceTextResponse(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("Text", str3);
        map.put("Value", str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        this.responses.put(str, arrayList);
    }

    String getStringifiedResponse() {
        Gson gsonCreate = new GsonBuilder().disableHtmlEscaping().create();
        Map<String, Object> map = this.responses;
        return !(gsonCreate instanceof Gson) ? gsonCreate.toJson(map) : GsonInstrumentation.toJson(gsonCreate, map);
    }

    String getStringifiedEmbeddedData() {
        Gson gson = new Gson();
        Map<String, String> map = this.embeddedData;
        return !(gson instanceof Gson) ? gson.toJson(map) : GsonInstrumentation.toJson(gson, map);
    }

    void postResponse() {
        if (this.responses.size() == 0) {
            return;
        }
        if (ClientSideInterceptUtils.instance().getQTouchpoint(this.interceptId) != null) {
            this.embeddedData.put("Q_Touchpoint", ClientSideInterceptUtils.instance().getQTouchpoint(this.interceptId));
        }
        if (this.useHeadlessApi) {
            postHeadlessResponse();
        } else {
            this.siteInterceptService.postResponse(String.format("%s%s", this.baseUrl, "/DX/PostResponse"), this.interceptId, this.surveyId, getStringifiedResponse(), getStringifiedEmbeddedData());
        }
    }

    private void postHeadlessResponse() {
        String str;
        if (this.surveyVersionId == null) {
            str = BuildConfig.HEADLESS_SURVEY_START_TEMPLATE;
        } else {
            str = "https://s.qualtrics.com/spoke/all/jam/unauthenticated-headless-api/v1/forms/%s/sessions/?Q_SurveyVersionID=" + this.surveyVersionId;
        }
        HashMap map = new HashMap();
        map.put(EMBEDDED_DATA, this.embeddedData);
        this.siteInterceptService.startSurveySession(String.format(str, this.surveyId), map, new Callback<JsonObject>() { // from class: com.qualtrics.digital.EmbeddedFeedbackResponseManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Object objFromJson;
                try {
                    EmbeddedFeedbackResponseManager embeddedFeedbackResponseManager = EmbeddedFeedbackResponseManager.this;
                    Gson gson = new Gson();
                    JsonObject jsonObjectBody = response.body();
                    if (gson instanceof Gson) {
                        objFromJson = GsonInstrumentation.fromJson(gson, (JsonElement) jsonObjectBody, (Class<Object>) HeadlessStartResponse.class);
                    } else {
                        objFromJson = gson.fromJson((JsonElement) jsonObjectBody, (Class<Object>) HeadlessStartResponse.class);
                    }
                    embeddedFeedbackResponseManager.headlessStartResponse = (HeadlessStartResponse) objFromJson;
                    QualtricsLog.logInfo("Qualtrics: Survey SessionId is " + EmbeddedFeedbackResponseManager.this.headlessStartResponse.sessionId);
                    for (Question question : EmbeddedFeedbackResponseManager.this.headlessStartResponse.questions) {
                        EmbeddedFeedbackResponseManager.this.questionTypes.put(question.questionId, question.type);
                    }
                    EmbeddedFeedbackResponseManager.this.updateSurveySession(EmbeddedFeedbackResponseManager.this.createSurveyResponse());
                } catch (Exception e) {
                    QualtricsLog.logError("Qualtrics: Error reading start survey session response: " + e.getMessage());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<JsonObject> call, Throwable th) {
                QualtricsLog.logError("Qualtrics: Error starting survey session: " + th.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> createSurveyResponse() {
        HashMap map = new HashMap();
        for (String str : this.responses.keySet()) {
            Object obj = this.responses.get(str);
            String str2 = this.questionTypes.get(str);
            str2.hashCode();
            if (str2.equals("mc")) {
                map.put(str, createManipulatedMultipleChoiceAnswer(obj));
            } else {
                map.put(str, obj);
            }
        }
        return map;
    }

    private Map<String, Object> createManipulatedMultipleChoiceAnswer(Object obj) {
        if (obj instanceof String) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map2.put("selected", true);
            map.put((String) obj, map2);
            return map;
        }
        ArrayList arrayList = (ArrayList) obj;
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        map4.put("selected", true);
        map4.put("text", ((Map) arrayList.get(0)).get("Text"));
        map3.put(((Map) arrayList.get(0)).get("Value"), map4);
        return map3;
    }

    void updateSurveySession(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.put("sessionId", this.headlessStartResponse.sessionId);
        map2.put(EMBEDDED_DATA, this.embeddedData);
        map2.put("responses", map);
        map2.put("advance", true);
        this.siteInterceptService.updateSurveySession(this.headlessStartResponse.apiUrls.get("sessionUpdateUrl"), map2);
        this.properties.setSurveyHasBeenTaken(this.surveyId);
    }
}
