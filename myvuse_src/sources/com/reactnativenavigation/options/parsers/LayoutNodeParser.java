package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.LayoutNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class LayoutNodeParser {
    public static LayoutNode parse(JSONObject jSONObject) {
        return new LayoutNode(jSONObject.optString("id"), LayoutNode.Type.valueOf(jSONObject.optString("type")), parseData(jSONObject), parseChildren(jSONObject));
    }

    private static List<LayoutNode> parseChildren(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(parse(jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
        return arrayList;
    }

    private static JSONObject parseData(JSONObject jSONObject) {
        return jSONObject.has("data") ? jSONObject.optJSONObject("data") : new JSONObject();
    }
}
