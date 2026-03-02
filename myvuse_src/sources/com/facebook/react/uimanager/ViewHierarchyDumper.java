package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.bridge.UiThreadUtil;
import org.jose4j.jwk.RsaJsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ViewHierarchyDumper {
    public static JSONObject toJSON(View view) throws JSONException {
        UiThreadUtil.assertOnUiThread();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(RsaJsonWebKey.MODULUS_MEMBER_NAME, view.getClass().getName());
        jSONObject.put(ContextChain.TAG_INFRA, System.identityHashCode(view));
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String)) {
            jSONObject.put(RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, tag);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    jSONArray.put(i, toJSON(viewGroup.getChildAt(i)));
                }
                jSONObject.put("c", jSONArray);
            }
        }
        return jSONObject;
    }
}
