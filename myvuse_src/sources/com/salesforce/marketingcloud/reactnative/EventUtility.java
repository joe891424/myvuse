package com.salesforce.marketingcloud.reactnative;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.sfmcsdk.components.events.CartEvent;
import com.salesforce.marketingcloud.sfmcsdk.components.events.CatalogEvent;
import com.salesforce.marketingcloud.sfmcsdk.components.events.CatalogObject;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import com.salesforce.marketingcloud.sfmcsdk.components.events.LineItem;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Order;
import com.salesforce.marketingcloud.sfmcsdk.components.events.OrderEvent;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class EventUtility {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.salesforce.marketingcloud.sfmcsdk.components.events.Event toEvent(com.facebook.react.bridge.ReadableMap r5) {
        /*
            org.json.JSONObject r5 = toJSONObject(r5)     // Catch: org.json.JSONException -> L6f
            java.lang.String r0 = "objType"
            java.lang.String r0 = r5.optString(r0)     // Catch: org.json.JSONException -> L6f
            int r1 = r0.hashCode()     // Catch: org.json.JSONException -> L6f
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -2101929158: goto L33;
                case -1569048564: goto L29;
                case -133620343: goto L1f;
                case 662517986: goto L15;
                default: goto L14;
            }     // Catch: org.json.JSONException -> L6f
        L14:
            goto L3d
        L15:
            java.lang.String r1 = "CatalogObjectEvent"
            boolean r0 = r0.equals(r1)     // Catch: org.json.JSONException -> L6f
            if (r0 == 0) goto L3d
            r0 = r2
            goto L3e
        L1f:
            java.lang.String r1 = "CustomEvent"
            boolean r0 = r0.equals(r1)     // Catch: org.json.JSONException -> L6f
            if (r0 == 0) goto L3d
            r0 = r4
            goto L3e
        L29:
            java.lang.String r1 = "OrderEvent"
            boolean r0 = r0.equals(r1)     // Catch: org.json.JSONException -> L6f
            if (r0 == 0) goto L3d
            r0 = r3
            goto L3e
        L33:
            java.lang.String r1 = "CartEvent"
            boolean r0 = r0.equals(r1)     // Catch: org.json.JSONException -> L6f
            if (r0 == 0) goto L3d
            r0 = 0
            goto L3e
        L3d:
            r0 = -1
        L3e:
            if (r0 == 0) goto L6a
            if (r0 == r4) goto L55
            if (r0 == r3) goto L50
            if (r0 == r2) goto L4b
            com.salesforce.marketingcloud.sfmcsdk.components.events.Event r5 = checkForOtherEvents(r5)     // Catch: org.json.JSONException -> L6f
            return r5
        L4b:
            com.salesforce.marketingcloud.sfmcsdk.components.events.Event r5 = createCatalogEvent(r5)     // Catch: org.json.JSONException -> L6f
            return r5
        L50:
            com.salesforce.marketingcloud.sfmcsdk.components.events.OrderEvent r5 = createOrderEvent(r5)     // Catch: org.json.JSONException -> L6f
            return r5
        L55:
            java.lang.String r0 = "name"
            java.lang.String r0 = r5.optString(r0)     // Catch: org.json.JSONException -> L6f
            java.lang.String r1 = "attributes"
            org.json.JSONObject r5 = r5.optJSONObject(r1)     // Catch: org.json.JSONException -> L6f
            java.util.Map r5 = toMap(r5)     // Catch: org.json.JSONException -> L6f
            com.salesforce.marketingcloud.sfmcsdk.components.events.Event r5 = com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.customEvent(r0, r5)     // Catch: org.json.JSONException -> L6f
            return r5
        L6a:
            com.salesforce.marketingcloud.sfmcsdk.components.events.CartEvent r5 = createCartEvent(r5)     // Catch: org.json.JSONException -> L6f
            return r5
        L6f:
            r5 = move-exception
            r5.printStackTrace()
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.reactnative.EventUtility.toEvent(com.facebook.react.bridge.ReadableMap):com.salesforce.marketingcloud.sfmcsdk.components.events.Event");
    }

    private static Event createCatalogEvent(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("name");
        strOptString.hashCode();
        switch (strOptString) {
            case "View Catalog Object Detail":
                return CatalogEvent.viewDetail(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "Share Catalog Object":
                return CatalogEvent.share(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "Quick View Catalog Object":
                return CatalogEvent.quickView(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "Favorite Catalog Object":
                return CatalogEvent.favorite(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "Comment Catalog Object":
                return CatalogEvent.comment(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "View Catalog Object":
                return CatalogEvent.view(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            case "Review Catalog Object":
                return CatalogEvent.review(getCatalogObject(jSONObject.optJSONObject("catalogObject")));
            default:
                return null;
        }
    }

    private static CatalogObject getCatalogObject(JSONObject jSONObject) throws JSONException {
        return new CatalogObject(jSONObject.optString("type"), jSONObject.optString("id"), toMap(jSONObject.optJSONObject(C4352k.a.f5654h)), getRelatedCatalogObjects(jSONObject.optJSONObject("relatedCatalogObjects")));
    }

    private static Map<String, List<String>> getRelatedCatalogObjects(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONArray) {
                map.put(next, toList((JSONArray) objOpt));
            }
        }
        return map;
    }

    private static List<String> toList(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    private static Event checkForOtherEvents(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE);
        strOptString.hashCode();
        if (strOptString.equals("engagement")) {
            return EventManager.customEvent(jSONObject.optString("name"), toMap(jSONObject.optJSONObject(C4352k.a.f5654h)), Event.Producer.PUSH, Event.Category.ENGAGEMENT);
        }
        if (strOptString.equals("system")) {
            return EventManager.customEvent(jSONObject.optString("name"), toMap(jSONObject.optJSONObject(C4352k.a.f5654h)), Event.Producer.PUSH, Event.Category.SYSTEM);
        }
        return null;
    }

    private static OrderEvent createOrderEvent(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("name");
        strOptString.hashCode();
        switch (strOptString) {
            case "Return":
                return OrderEvent.returnOrder(getOrder(jSONObject.optJSONObject("order")));
            case "Preorder":
                return OrderEvent.preorder(getOrder(jSONObject.optJSONObject("order")));
            case "Deliver":
                return OrderEvent.deliver(getOrder(jSONObject.optJSONObject("order")));
            case "Ship":
                return OrderEvent.ship(getOrder(jSONObject.optJSONObject("order")));
            case "Purchase":
                return OrderEvent.purchase(getOrder(jSONObject.optJSONObject("order")));
            case "Cancel":
                return OrderEvent.cancel(getOrder(jSONObject.optJSONObject("order")));
            case "Exchange":
                return OrderEvent.exchange(getOrder(jSONObject.optJSONObject("order")));
            default:
                return null;
        }
    }

    private static Order getOrder(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("id");
        String strOptString2 = jSONObject.optString(FirebaseAnalytics.Param.CURRENCY);
        double dOptDouble = jSONObject.optDouble("totalValue");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lineItems");
        Map<String, Object> attributesMap = getAttributesMap(jSONObject.optJSONObject(C4352k.a.f5654h));
        if (attributesMap == null) {
            return new Order(strOptString, getLineItems(jSONArrayOptJSONArray), Double.valueOf(dOptDouble), strOptString2);
        }
        return new Order(strOptString, getLineItems(jSONArrayOptJSONArray), Double.valueOf(dOptDouble), strOptString2, attributesMap);
    }

    private static Map<String, Object> getAttributesMap(JSONObject jSONObject) {
        try {
            return toMap(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<LineItem> getLineItems(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(getLineItem(jSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static CartEvent createCartEvent(JSONObject jSONObject) {
        LineItem lineItem;
        lineItem = getLineItem(jSONObject.optJSONObject("lineItem"));
        String strOptString = jSONObject.optString("name");
        strOptString.hashCode();
        switch (strOptString) {
            case "Remove From Cart":
                return CartEvent.remove(lineItem);
            case "Replace Cart":
                return CartEvent.replace(new ArrayList<LineItem>() { // from class: com.salesforce.marketingcloud.reactnative.EventUtility.1
                    {
                        add(this.val$lineItem);
                    }
                });
            case "Add To Cart":
                return CartEvent.add(lineItem);
            default:
                return null;
        }
    }

    private static LineItem getLineItem(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("catalogObjectType");
        String strOptString2 = jSONObject.optString("catalogObjectId");
        int iOptInt = jSONObject.optInt(FirebaseAnalytics.Param.QUANTITY);
        double dOptDouble = jSONObject.optDouble(FirebaseAnalytics.Param.PRICE);
        String strOptString3 = jSONObject.optString(FirebaseAnalytics.Param.CURRENCY);
        Map<String, Object> attributesMap = getAttributesMap(jSONObject.optJSONObject(C4352k.a.f5654h));
        if (attributesMap == null) {
            return new LineItem(strOptString, strOptString2, iOptInt, Double.valueOf(dOptDouble), strOptString3);
        }
        return new LineItem(strOptString, strOptString2, iOptInt, Double.valueOf(dOptDouble), strOptString3, attributesMap);
    }

    private static JSONObject toJSONObject(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            int i = C42822.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()];
            if (i == 1) {
                jSONObject.put(strNextKey, readableMap.getBoolean(strNextKey));
            } else if (i == 2) {
                jSONObject.put(strNextKey, readableMap.getDouble(strNextKey));
            } else if (i == 3) {
                jSONObject.put(strNextKey, readableMap.getString(strNextKey));
            } else if (i == 4) {
                jSONObject.put(strNextKey, toJSONObject(readableMap.getMap(strNextKey)));
            } else if (i == 5) {
                jSONObject.put(strNextKey, toJSONArray(readableMap.getArray(strNextKey)));
            }
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.reactnative.EventUtility$2 */
    static /* synthetic */ class C42822 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static JSONArray toJSONArray(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (C42822.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    jSONArray.put(i, readableArray.getBoolean(i));
                    break;
                case 2:
                    jSONArray.put(i, readableArray.getDouble(i));
                    break;
                case 3:
                    jSONArray.put(i, readableArray.getString(i));
                    break;
                case 4:
                    jSONArray.put(i, toJSONObject(readableArray.getMap(i)));
                    break;
                case 5:
                    jSONArray.put(i, toJSONArray(readableArray.getArray(i)));
                    break;
                case 6:
                    jSONArray.put(i, (Object) null);
                    break;
            }
        }
        return jSONArray;
    }

    private static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object array = jSONObject.get(next);
            if (array instanceof JSONObject) {
                array = toMap((JSONObject) array);
            }
            if (array instanceof JSONArray) {
                array = toArray((JSONArray) array);
            }
            map.put(next, array);
        }
        return map;
    }

    private static Map<String, Object> toMap(ReadableMap readableMap) {
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (C42822.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
                    break;
                case 2:
                    map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
                    break;
                case 3:
                    map.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 4:
                    map.put(strNextKey, toMap(readableMap.getMap(strNextKey)));
                    break;
                case 5:
                    map.put(strNextKey, toArray(readableMap.getArray(strNextKey)));
                    break;
                case 6:
                    map.put(strNextKey, null);
                    break;
            }
        }
        return map;
    }

    private static Object[] toArray(JSONArray jSONArray) throws JSONException {
        Object[] objArr = new Object[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            Object array = jSONArray.get(i);
            if (array instanceof JSONObject) {
                array = toMap((JSONObject) array);
            }
            if (array instanceof JSONArray) {
                array = toArray((JSONArray) array);
            }
            objArr[i] = array;
        }
        return objArr;
    }

    private static Object[] toArray(ReadableArray readableArray) {
        Object[] objArr = new Object[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            switch (C42822.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    objArr[i] = Boolean.valueOf(readableArray.getBoolean(i));
                    break;
                case 2:
                    objArr[i] = Double.valueOf(readableArray.getDouble(i));
                    break;
                case 3:
                    objArr[i] = readableArray.getString(i);
                    break;
                case 4:
                    objArr[i] = toMap(readableArray.getMap(i));
                    break;
                case 5:
                    objArr[i] = toArray(readableArray.getArray(i));
                    break;
                case 6:
                    objArr[i] = null;
                    break;
            }
        }
        return objArr;
    }
}
