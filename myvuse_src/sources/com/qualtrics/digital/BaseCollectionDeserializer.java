package com.qualtrics.digital;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;

/* JADX INFO: compiled from: Deserializers.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class BaseCollectionDeserializer {
    BaseCollectionDeserializer() {
    }

    void createCollection(JsonObject jsonObject, ArrayList arrayList, GsonBuilder gsonBuilder, Class cls) {
        for (int i = 0; jsonObject.has("" + i); i++) {
            Gson gsonCreate = gsonBuilder.create();
            JsonObject asJsonObject = jsonObject.getAsJsonObject("" + i);
            arrayList.add(!(gsonCreate instanceof Gson) ? gsonCreate.fromJson((JsonElement) asJsonObject, cls) : GsonInstrumentation.fromJson(gsonCreate, (JsonElement) asJsonObject, cls));
        }
    }
}
