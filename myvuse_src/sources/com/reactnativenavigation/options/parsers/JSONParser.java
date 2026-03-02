package com.reactnativenavigation.options.parsers;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class JSONParser {
    public JSONObject parse(ReadableMap readableMap) {
        try {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            JSONObject jSONObject = new JSONObject();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                int i = C39711.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()];
                if (i == 1) {
                    jSONObject.put(strNextKey, readableMap.getString(strNextKey));
                } else if (i == 2) {
                    jSONObject.put(strNextKey, parseNumber(readableMap, strNextKey));
                } else if (i == 3) {
                    jSONObject.put(strNextKey, readableMap.getBoolean(strNextKey));
                } else if (i == 4) {
                    jSONObject.put(strNextKey, parse(readableMap.getArray(strNextKey)));
                } else if (i == 5) {
                    jSONObject.put(strNextKey, parse(readableMap.getMap(strNextKey)));
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.options.parsers.JSONParser$1 */
    static /* synthetic */ class C39711 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public JSONArray parse(ReadableArray readableArray) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            int i2 = C39711.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                jSONArray.put(readableArray.getString(i));
            } else if (i2 == 2) {
                jSONArray.put(parseNumber(readableArray, i));
            } else if (i2 == 3) {
                jSONArray.put(readableArray.getBoolean(i));
            } else if (i2 == 4) {
                jSONArray.put(parse(readableArray.getArray(i)));
            } else if (i2 == 5) {
                jSONArray.put(parse(readableArray.getMap(i)));
            }
        }
        return jSONArray;
    }

    private static Object parseNumber(ReadableMap readableMap, String str) {
        try {
            Double dValueOf = Double.valueOf(readableMap.getDouble(str));
            return dValueOf.doubleValue() % 1.0d == 0.0d ? Integer.valueOf(readableMap.getInt(str)) : dValueOf;
        } catch (Exception unused) {
            return Integer.valueOf(readableMap.getInt(str));
        }
    }

    private static Object parseNumber(ReadableArray readableArray, int i) {
        try {
            Double dValueOf = Double.valueOf(readableArray.getDouble(i));
            return dValueOf.doubleValue() % 1.0d == 0.0d ? Integer.valueOf(readableArray.getInt(i)) : dValueOf;
        } catch (Exception unused) {
            return Integer.valueOf(readableArray.getInt(i));
        }
    }

    public static WritableMap convert(JSONObject jSONObject) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONObject) {
                writableMapCreateMap.putMap(next, convert((JSONObject) objOpt));
            } else if (objOpt instanceof JSONArray) {
                writableMapCreateMap.putArray(next, convert((JSONArray) objOpt));
            } else if (objOpt instanceof Boolean) {
                writableMapCreateMap.putBoolean(next, ((Boolean) objOpt).booleanValue());
            } else if (objOpt instanceof Integer) {
                writableMapCreateMap.putInt(next, ((Integer) objOpt).intValue());
            } else if (objOpt instanceof Double) {
                writableMapCreateMap.putDouble(next, ((Double) objOpt).doubleValue());
            } else if (objOpt instanceof String) {
                writableMapCreateMap.putString(next, (String) objOpt);
            } else {
                writableMapCreateMap.putString(next, objOpt.toString());
            }
        }
        return writableMapCreateMap;
    }

    public static WritableArray convert(JSONArray jSONArray) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objOpt = jSONArray.opt(i);
            if (objOpt instanceof JSONObject) {
                writableArrayCreateArray.pushMap(convert((JSONObject) objOpt));
            } else if (objOpt instanceof JSONArray) {
                writableArrayCreateArray.pushArray(convert((JSONArray) objOpt));
            } else if (objOpt instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) objOpt).booleanValue());
            } else if (objOpt instanceof Integer) {
                writableArrayCreateArray.pushInt(((Integer) objOpt).intValue());
            } else if (objOpt instanceof Double) {
                writableArrayCreateArray.pushDouble(((Double) objOpt).doubleValue());
            } else if (objOpt instanceof String) {
                writableArrayCreateArray.pushString((String) objOpt);
            } else {
                writableArrayCreateArray.pushString(objOpt.toString());
            }
        }
        return writableArrayCreateArray;
    }
}
