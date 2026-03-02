package com.newrelic.agent.android.util;

import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class SafeJsonPrimitive {
    public static final char NULL_CHAR = ' ';
    public static final String NULL_STRING = "null";
    public static final Number NULL_NUMBER = Float.valueOf(Float.NaN);
    public static final Boolean NULL_BOOL = Boolean.FALSE;

    public static String checkNull(String str) {
        return str == null ? "null" : str;
    }

    public static Boolean checkNull(Boolean bool) {
        return bool == null ? NULL_BOOL : bool;
    }

    public static Number checkNull(Number number) {
        return number == null ? NULL_NUMBER : number;
    }

    public static Character checkNull(Character ch) {
        return Character.valueOf(ch == null ? NULL_CHAR : ch.charValue());
    }

    public static JsonPrimitive factory(Boolean bool) {
        return new JsonPrimitive(checkNull(bool));
    }

    public static JsonPrimitive factory(Number number) {
        return new JsonPrimitive(checkNull(number));
    }

    public static JsonPrimitive factory(String str) {
        return new JsonPrimitive(checkNull(str));
    }

    public static JsonPrimitive factory(Character ch) {
        return new JsonPrimitive(checkNull(ch));
    }

    public static JsonPrimitive factory(Double d) {
        if (d.floatValue() > 2.1474836E9f && d.longValue() == d.doubleValue()) {
            return new JsonPrimitive(Long.valueOf(d.longValue()));
        }
        return new JsonPrimitive(checkNull(d));
    }
}
