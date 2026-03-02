package com.salesforce.marketingcloud.internal;

import androidx.exifinterface.media.ExifInterface;
import com.salesforce.marketingcloud.C4170g;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.m */
/* JADX INFO: loaded from: classes6.dex */
public final class C4190m {

    /* JADX INFO: renamed from: a */
    private static final String f4913a = C4170g.m3197a("GeneralUtils");

    /* JADX INFO: renamed from: b */
    private static final String f4914b = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* JADX INFO: renamed from: c */
    private static final TimeZone f4915c;

    /* JADX INFO: renamed from: d */
    private static final Charset f4916d;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.m$a */
    static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.f4917a = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse " + this.f4917a + " as a Date.";
        }
    }

    static {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(...)");
        f4915c = timeZone;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        f4916d = charsetForName;
    }

    /* JADX INFO: renamed from: a */
    public static final Date m3404a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f4914b, Locale.US);
            simpleDateFormat.setTimeZone(f4915c);
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            C4170g.f4785a.m3223b(f4913a, e, new a(str));
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final Map<String, String> m3410b(JSONArray jSONArray) throws JSONException {
        Object string;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList<JSONObject> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject = jSONArray.getJSONObject(iNextInt);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string = Integer.valueOf(jSONArray.getInt(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string = Double.valueOf(jSONArray.getDouble(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string = Long.valueOf(jSONArray.getLong(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    string = Boolean.valueOf(jSONArray.getBoolean(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = jSONArray.getString(iNextInt);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    string = jSONArray.get(iNextInt);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
                jSONObject = (JSONObject) string;
            }
            arrayList.add(jSONObject);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (JSONObject jSONObject2 : arrayList) {
            Pair pairM5605to = TuplesKt.m5605to(jSONObject2.optString("key"), jSONObject2.optString("value"));
            linkedHashMap.put(pairM5605to.getFirst(), pairM5605to.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    public static final String m3403a(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f4914b, Locale.US);
        simpleDateFormat.setTimeZone(f4915c);
        String str = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: renamed from: b */
    public static final Charset m3409b() {
        return f4916d;
    }

    /* JADX INFO: renamed from: a */
    public static final JSONArray m3407a(Map<String, String> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", key);
            jSONObject.put("value", value);
            arrayList.add(jSONObject);
        }
        return new JSONArray((Collection) arrayList);
    }

    /* JADX INFO: renamed from: b */
    public static final String m3408b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ <T> List<T> m3405a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Object jSONObject = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class)) ? jSONArray.getJSONObject(iNextInt) : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? Integer.valueOf(jSONArray.getInt(iNextInt)) : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE)) ? Double.valueOf(jSONArray.getDouble(iNextInt)) : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE)) ? Long.valueOf(jSONArray.getLong(iNextInt)) : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) ? Boolean.valueOf(jSONArray.getBoolean(iNextInt)) : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) ? jSONArray.getString(iNextInt) : jSONArray.get(iNextInt);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            arrayList.add(jSONObject);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ <T extends Enum<T>> T m3401a(JSONObject jSONObject, String name) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String string = jSONObject.getString(name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) Enum.valueOf(null, string);
    }

    /* JADX INFO: renamed from: a */
    public static final TimeZone m3406a() {
        return f4915c;
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ <T extends Enum<T>> T m3402a(JSONObject jSONObject, String name, T t) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(t, "default");
        String strOptString = jSONObject.optString(name);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = m3408b(strOptString);
        if (strM3408b == null) {
            return t;
        }
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) Enum.valueOf(null, strM3408b);
    }
}
