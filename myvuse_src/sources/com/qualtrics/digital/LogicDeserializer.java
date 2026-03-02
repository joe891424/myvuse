package com.qualtrics.digital;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: Deserializers.java */
/* JADX INFO: loaded from: classes6.dex */
class LogicDeserializer extends BaseCollectionDeserializer implements JsonDeserializer<Logic> {
    LogicDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Logic deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.toString().equals("\"\"")) {
            return new Logic(null, null);
        }
        try {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LogicSet.class, new LogicSetDeserializer());
            ArrayList arrayList = new ArrayList();
            createCollection(asJsonObject, arrayList, gsonBuilder, LogicSet.class);
            return new Logic(asJsonObject.get("Type").getAsString(), arrayList);
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
