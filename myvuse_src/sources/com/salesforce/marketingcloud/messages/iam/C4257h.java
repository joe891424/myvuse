package com.salesforce.marketingcloud.messages.iam;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.internal.C4190m;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4257h {
    /* JADX INFO: renamed from: a */
    public static final List<InAppMessage.Button> m3752a(JSONArray jSONArray) throws JSONException {
        InAppMessage.Button button;
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
        ArrayList arrayList2 = new ArrayList();
        for (JSONObject jSONObject2 : arrayList) {
            try {
                String string2 = jSONObject2.getString("id");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                int iOptInt = jSONObject2.optInt(FirebaseAnalytics.Param.INDEX, 0);
                String string3 = jSONObject2.getString("text");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                InAppMessage.Button.ActionType actionTypeValueOf = InAppMessage.Button.ActionType.close;
                String strOptString = jSONObject2.optString("actionType");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strM3408b = C4190m.m3408b(strOptString);
                if (strM3408b != null) {
                    actionTypeValueOf = InAppMessage.Button.ActionType.valueOf(strM3408b);
                }
                String strOptString2 = jSONObject2.optString("actionAndroid");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strM3408b2 = C4190m.m3408b(strOptString2);
                String strOptString3 = jSONObject2.optString("fontColor");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                String strM3408b3 = C4190m.m3408b(strOptString3);
                InAppMessage.Size size = InAppMessage.Size.f5218s;
                String strOptString4 = jSONObject2.optString("fontSize");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                String strM3408b4 = C4190m.m3408b(strOptString4);
                InAppMessage.Size sizeValueOf = strM3408b4 != null ? InAppMessage.Size.valueOf(strM3408b4) : size;
                String strOptString5 = jSONObject2.optString("backgroundColor");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                String strM3408b5 = C4190m.m3408b(strOptString5);
                String strOptString6 = jSONObject2.optString("borderColor");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                String strM3408b6 = C4190m.m3408b(strOptString6);
                String strOptString7 = jSONObject2.optString("borderWidth");
                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                String strM3408b7 = C4190m.m3408b(strOptString7);
                InAppMessage.Size sizeValueOf2 = strM3408b7 != null ? InAppMessage.Size.valueOf(strM3408b7) : size;
                String strOptString8 = jSONObject2.optString("cornerRadius");
                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                String strM3408b8 = C4190m.m3408b(strOptString8);
                button = new InAppMessage.Button(string2, iOptInt, string3, actionTypeValueOf, strM3408b2, strM3408b3, sizeValueOf, strM3408b5, strM3408b6, sizeValueOf2, strM3408b8 != null ? InAppMessage.Size.valueOf(strM3408b8) : size);
            } catch (Exception unused) {
                button = null;
            }
            InAppMessage.Button button2 = button;
            if (button2 != null) {
                arrayList2.add(button2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: b */
    public static final InAppMessage.Media m3753b(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String string = jSONObject.getString("url");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InAppMessage.Media.ImageSize imageSizeValueOf = InAppMessage.Media.ImageSize.e2e;
        String strOptString = jSONObject.optString("size");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        if (strM3408b != null) {
            imageSizeValueOf = InAppMessage.Media.ImageSize.valueOf(strM3408b);
        }
        InAppMessage.Media.ImageSize imageSize = imageSizeValueOf;
        String strOptString2 = jSONObject.optString("altText");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        InAppMessage.Size size = InAppMessage.Size.f5218s;
        String strOptString3 = jSONObject.optString("borderWidth");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        InAppMessage.Size sizeValueOf = strM3408b3 != null ? InAppMessage.Size.valueOf(strM3408b3) : size;
        String strOptString4 = jSONObject.optString("borderColor");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strM3408b4 = C4190m.m3408b(strOptString4);
        String strOptString5 = jSONObject.optString("cornerRadius");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strM3408b5 = C4190m.m3408b(strOptString5);
        return new InAppMessage.Media(string, imageSize, strM3408b2, sizeValueOf, strM3408b4, strM3408b5 != null ? InAppMessage.Size.valueOf(strM3408b5) : size);
    }

    /* JADX INFO: renamed from: c */
    public static final InAppMessage.TextField m3754c(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String string = jSONObject.getString("text");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        InAppMessage.Size sizeValueOf = InAppMessage.Size.f5218s;
        String strOptString = jSONObject.optString("fontSize");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        if (strM3408b != null) {
            sizeValueOf = InAppMessage.Size.valueOf(strM3408b);
        }
        String strOptString2 = jSONObject.optString("fontColor");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        InAppMessage.Alignment alignmentValueOf = InAppMessage.Alignment.center;
        String strOptString3 = jSONObject.optString("alignment");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        if (strM3408b3 != null) {
            alignmentValueOf = InAppMessage.Alignment.valueOf(strM3408b3);
        }
        return new InAppMessage.TextField(string, sizeValueOf, strM3408b2, alignmentValueOf);
    }

    /* JADX INFO: renamed from: a */
    public static final InAppMessage.CloseButton m3751a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        InAppMessage.Alignment alignmentValueOf = InAppMessage.Alignment.end;
        String strOptString = jSONObject.optString("alignment");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        if (strM3408b != null) {
            alignmentValueOf = InAppMessage.Alignment.valueOf(strM3408b);
        }
        return new InAppMessage.CloseButton(alignmentValueOf);
    }
}
