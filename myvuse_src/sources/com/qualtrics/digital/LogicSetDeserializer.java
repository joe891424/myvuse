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
class LogicSetDeserializer extends BaseCollectionDeserializer implements JsonDeserializer<LogicSet> {
    LogicSetDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public LogicSet deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Expression.class, new ExpressionDeserializer());
        ArrayList arrayList = new ArrayList();
        createCollection(asJsonObject, arrayList, gsonBuilder, Expression.class);
        return new LogicSet(asJsonObject.get("Type").getAsString(), arrayList);
    }
}
