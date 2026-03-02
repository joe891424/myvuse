package com.yoti.mobile.documentscanconfig.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.json.b */
/* JADX INFO: loaded from: classes4.dex */
public final class C5069b {
    /* JADX INFO: renamed from: a */
    public final Map<String, CountrySupportedDocumentsJsonConfig> m5373a(InputStream supportedCountriesInput) throws IOException {
        Intrinsics.checkParameterIsNotNull(supportedCountriesInput, "supportedCountriesInput");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JsonElement jsonElement = new JsonParser().parse(new InputStreamReader(supportedCountriesInput));
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "JsonParser().parse(Input…supportedCountriesInput))");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("countries");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "jsonObject.get(DEFAULT_S…RTED_COUNTRIES_JSON_FILE)");
        JsonArray asJsonArray = jsonElement2.getAsJsonArray();
        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "jsonObject.get(DEFAULT_S…ES_JSON_FILE).asJsonArray");
        Gson gson = new Gson();
        Object objFromJson = !(gson instanceof Gson) ? gson.fromJson((JsonElement) asJsonArray, CountrySupportedDocumentsJsonConfig[].class) : GsonInstrumentation.fromJson(gson, (JsonElement) asJsonArray, CountrySupportedDocumentsJsonConfig[].class);
        Intrinsics.checkExpressionValueIsNotNull(objFromJson, "Gson().fromJson(countrie…sJsonConfig>::class.java)");
        for (Object obj : (Object[]) objFromJson) {
            CountrySupportedDocumentsJsonConfig countrySupportedDocumentsJsonConfig = (CountrySupportedDocumentsJsonConfig) obj;
            linkedHashMap.put(countrySupportedDocumentsJsonConfig.getCodeAlpha3(), countrySupportedDocumentsJsonConfig);
        }
        supportedCountriesInput.close();
        return linkedHashMap;
    }
}
