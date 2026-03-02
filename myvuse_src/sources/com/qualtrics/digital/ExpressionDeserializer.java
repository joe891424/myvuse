package com.qualtrics.digital;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: Deserializers.java */
/* JADX INFO: loaded from: classes6.dex */
class ExpressionDeserializer implements JsonDeserializer<Expression> {
    private static final String CONJUNCTION = "Conjuction";
    private static final String COUNT_TYPE = "CountType";
    private static final String KEY = "Key";
    private static final String LEFT_OPERAND = "LeftOperand";
    private static final String OPERATOR = "Operator";
    private static final String PROPERTY_TYPE = "PropertyType";
    private static final String RIGHT_OPERAND = "RightOperand";
    private static final String SURVEY_ID = "SurveyID";
    private static final String TIME_TYPE = "TimeType";
    private static final String TIME_ZONE = "TimeZone";
    private static final String TYPE = "Type";

    ExpressionDeserializer() {
    }

    private String getAsStringSafe(JsonObject jsonObject, String str) {
        if (jsonObject.has(str)) {
            return jsonObject.get(str).getAsString();
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Expression deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject;
        String asStringSafe;
        String asStringSafe2;
        String asStringSafe3;
        asJsonObject = jsonElement.getAsJsonObject();
        asStringSafe = getAsStringSafe(asJsonObject, OPERATOR);
        asStringSafe2 = getAsStringSafe(asJsonObject, TYPE);
        asStringSafe3 = getAsStringSafe(asJsonObject, CONJUNCTION);
        String lowerCase = asJsonObject.get("LogicType").getAsString().toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "mobiletimeonsite":
                return new DurationExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, RIGHT_OPERAND), getAsStringSafe(asJsonObject, TIME_TYPE));
            case "mobilecustomproperty":
                return new VariableExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, KEY), getAsStringSafe(asJsonObject, RIGHT_OPERAND), getAsStringSafe(asJsonObject, PROPERTY_TYPE));
            case "day":
                return new DayExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, LEFT_OPERAND), getAsStringSafe(asJsonObject, TIME_ZONE));
            case "date":
                return new DateExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, LEFT_OPERAND), getAsStringSafe(asJsonObject, TIME_ZONE));
            case "time":
                return new TimeExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, LEFT_OPERAND), getAsStringSafe(asJsonObject, TIME_ZONE));
            case "mobilepagecount":
                return new ViewCountExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, RIGHT_OPERAND), getAsStringSafe(asJsonObject, COUNT_TYPE));
            case "qualtricssurvey":
                return new QualtricsSurveyExpression(asStringSafe, asStringSafe2, asStringSafe3, getAsStringSafe(asJsonObject, SURVEY_ID));
            default:
                return null;
        }
    }
}
