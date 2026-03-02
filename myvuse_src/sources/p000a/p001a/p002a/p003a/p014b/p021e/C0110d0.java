package p000a.p001a.p002a.p003a.p014b.p021e;

import android.content.Context;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.e.d0 */
/* JADX INFO: loaded from: classes.dex */
public class C0110d0 {

    /* JADX INFO: renamed from: a */
    public JSONObject f746a;

    public C0110d0(Context context) {
        this.f746a = new JSONObject();
        String string = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OTT_UX_PARAMS_JSON", "");
        if (C0048h.m305b(string)) {
            return;
        }
        this.f746a = new JSONObject(string);
    }

    /* JADX INFO: renamed from: b */
    public static C0115i m618b(JSONObject jSONObject) {
        C0115i c0115i = new C0115i();
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_NAME)) {
            c0115i.f750a = jSONObject.getString(OTUXParamsKeys.OT_UX_FONT_NAME);
        }
        if (jSONObject.has("fontSize")) {
            c0115i.f751b = jSONObject.getString("fontSize");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_TEXT_STYLE)) {
            c0115i.f752c = jSONObject.getInt(OTUXParamsKeys.OT_UX_FONT_TEXT_STYLE);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY)) {
            c0115i.f753d = jSONObject.getString(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY);
        }
        return c0115i;
    }

    /* JADX INFO: renamed from: d */
    public static C0104a0 m619d(JSONObject jSONObject) {
        C0104a0 c0104a0 = new C0104a0();
        if (jSONObject.has("backgroundColor")) {
            c0104a0.f712a = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            c0104a0.f713b = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_PLACEHOLDER_TEXT_COLOR)) {
            c0104a0.f714c = jSONObject.getString(OTUXParamsKeys.OT_UX_PLACEHOLDER_TEXT_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_ICON_COLOR)) {
            c0104a0.f715d = jSONObject.getString(OTUXParamsKeys.OT_UX_ICON_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_CLEAR_BUTTON_COLOR)) {
            c0104a0.f717f = jSONObject.getString(OTUXParamsKeys.OT_UX_CLEAR_BUTTON_COLOR);
        }
        if (jSONObject.has("borderColor")) {
            c0104a0.f716e = jSONObject.getString("borderColor");
        }
        if (jSONObject.has("borderWidth")) {
            c0104a0.f718g = jSONObject.getString("borderWidth");
        }
        if (jSONObject.has("borderRadius")) {
            c0104a0.f719h = jSONObject.getString("borderRadius");
        }
        return c0104a0;
    }

    /* JADX INFO: renamed from: a */
    public C0107c m620a(JSONObject jSONObject) {
        C0107c c0107c = new C0107c();
        c0107c.f728a = m618b(jSONObject);
        if (jSONObject.has("backgroundColor")) {
            c0107c.f729b = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            c0107c.f730c = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        if (jSONObject.has("borderColor")) {
            c0107c.f731d = jSONObject.getString("borderColor");
        }
        if (jSONObject.has("borderWidth")) {
            c0107c.f732e = jSONObject.getString("borderWidth");
        }
        if (jSONObject.has("borderRadius")) {
            c0107c.f733f = jSONObject.getString("borderRadius");
        }
        return c0107c;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m621a() {
        if (this.f746a.has(OTUXParamsKeys.OT_UI_CONFIG)) {
            return this.f746a.getJSONObject(OTUXParamsKeys.OT_UI_CONFIG);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final C0117k m623c(JSONObject jSONObject) {
        C0117k c0117k = new C0117k();
        c0117k.f755a = m624e(jSONObject);
        return c0117k;
    }

    /* JADX INFO: renamed from: e */
    public C0106b0 m624e(JSONObject jSONObject) {
        C0106b0 c0106b0 = new C0106b0();
        c0106b0.f722a = m618b(jSONObject);
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_ALIGNMENT)) {
            c0106b0.f723b = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_ALIGNMENT);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            c0106b0.f724c = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        return c0106b0;
    }

    /* JADX INFO: renamed from: b */
    public C0124r m622b() {
        JSONObject jSONObjectM621a = m621a();
        C0124r c0124r = null;
        JSONObject jSONObject = (jSONObjectM621a == null || !jSONObjectM621a.has(OTUXParamsKeys.OT_GLOBAL_THEME)) ? null : jSONObjectM621a.getJSONObject(OTUXParamsKeys.OT_GLOBAL_THEME);
        if (jSONObject != null) {
            c0124r = new C0124r();
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINK_UNDERLINE)) {
                c0124r.f800a = jSONObject.getBoolean(OTUXParamsKeys.OT_UX_LINK_UNDERLINE);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINK_COLOR)) {
                c0124r.f801b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINK_COLOR);
            }
        }
        return c0124r;
    }
}
