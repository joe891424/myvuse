package p000a.p001a.p002a.p003a.p014b.p021e;

import android.content.Context;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.e.x */
/* JADX INFO: loaded from: classes.dex */
public class C0130x {

    /* JADX INFO: renamed from: a */
    public C0110d0 f880a;

    /* JADX INFO: renamed from: b */
    public C0120n f881b;

    /* JADX INFO: renamed from: e */
    public C0103a f884e;

    /* JADX INFO: renamed from: f */
    public C0105b f885f;

    /* JADX INFO: renamed from: d */
    public C0112f f883d = new C0112f();

    /* JADX INFO: renamed from: c */
    public C0108c0 f882c = new C0108c0();

    public C0130x(Context context) {
        this.f880a = new C0110d0(context);
        this.f881b = new C0120n(context);
        this.f884e = new C0103a(context);
        this.f885f = new C0105b(context);
    }

    public C0130x(Context context, int i) {
        this.f880a = new C0110d0(context);
        this.f881b = new C0120n(context, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0219  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0121o m670a() {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0130x.m670a():a.a.a.a.b.e.o");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b1  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0125s m673b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0130x.m673b():a.a.a.a.b.e.s");
    }

    /* JADX INFO: renamed from: c */
    public C0131y m675c() throws JSONException {
        C0110d0 c0110d0 = this.f880a;
        JSONObject jSONObjectM621a = c0110d0.m621a();
        C0131y c0131y = null;
        JSONObject jSONObject = (jSONObjectM621a == null || !jSONObjectM621a.has(OTUXParamsKeys.OT_VENDOR_DETAILS_THEME)) ? null : jSONObjectM621a.getJSONObject(OTUXParamsKeys.OT_VENDOR_DETAILS_THEME);
        if (jSONObject != null) {
            c0131y = new C0131y();
            if (jSONObject.has("backgroundColor")) {
                c0131y.f886a = jSONObject.getString("backgroundColor");
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON)) {
                c0131y.f887b = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF)) {
                c0131y.f888c = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR)) {
                c0131y.f889d = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR)) {
                c0131y.f896k = jSONObject.getString(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR);
            }
            if (jSONObject.has("title")) {
                c0131y.f890e = c0110d0.m624e(jSONObject.getJSONObject("title"));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_DETAILS_SUMMARY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_DETAILS_SUMMARY);
                if (jSONObject2.has("title")) {
                    c0131y.f891f = c0110d0.m624e(jSONObject2.getJSONObject("title"));
                }
                if (jSONObject2.has("description")) {
                    c0131y.f892g = c0110d0.m624e(jSONObject2.getJSONObject("description"));
                }
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_CONSENT_TITLE)) {
                c0131y.f893h = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_CONSENT_TITLE));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LEGITIMATE_INTEREST_TITLE)) {
                c0131y.f894i = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_LEGITIMATE_INTEREST_TITLE));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINKS)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_LINKS);
                if (jSONObject3.has(OTUXParamsKeys.OT_UX_PRIVACY_NOTICE_BUTTON)) {
                    c0131y.f895j = c0110d0.m623c(jSONObject3.getJSONObject(OTUXParamsKeys.OT_UX_PRIVACY_NOTICE_BUTTON));
                }
            }
        }
        C0120n c0120n = this.f881b;
        c0120n.getClass();
        C0113g c0113g = new C0113g();
        C0131y c0131y2 = new C0131y();
        JSONObject jSONObjectM663a = c0120n.m663a();
        if (jSONObjectM663a.has(OTVendorListMode.GENERAL)) {
            JSONObject jSONObject4 = jSONObjectM663a.getJSONObject(OTVendorListMode.GENERAL);
            c0131y2.f886a = c0113g.m643a(c0120n.f769a, jSONObject4.optString("backgroundColor"), jSONObject4.optString("backgroundColorDark"));
            String strM643a = c0113g.m643a(c0120n.f769a, jSONObject4.optString("toggleActiveColor"), jSONObject4.optString("toggleActiveColorDark"));
            String strM643a2 = c0113g.m643a(c0120n.f769a, jSONObject4.optString("toggleInactiveColor"), jSONObject4.optString("toggleInactiveColorDark"));
            c0131y2.f887b = strM643a;
            c0131y2.f888c = strM643a2;
        }
        if (jSONObjectM663a.has(OTUXParamsKeys.OT_UX_SUMMARY)) {
            JSONObject jSONObject5 = jSONObjectM663a.getJSONObject(OTUXParamsKeys.OT_UX_SUMMARY);
            if (jSONObject5.has("description")) {
                JSONObject jSONObject6 = jSONObject5.getJSONObject("description");
                C0106b0 c0106b0M654a = C0120n.m654a(jSONObject6, c0120n.f769a, OTUXParamsKeys.OT_UX_TEXT_COLOR, "textColorDark", "fontSize");
                c0131y2.f892g = c0106b0M654a;
                c0131y2.f891f = c0106b0M654a;
                c0131y2.f893h = c0106b0M654a;
                c0131y2.f894i = c0106b0M654a;
                c0131y2.f896k = c0113g.m643a(c0120n.f769a, jSONObject6.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR), jSONObject6.optString("textColorDark"));
            }
        }
        JSONObject jSONObjectM644a = c0113g.m644a(jSONObjectM663a, OTUXParamsKeys.OT_UX_LINKS, OTUXParamsKeys.OT_UX_LINK_POLICY_LINK);
        if (jSONObjectM644a != null) {
            c0131y2.f895j = C0120n.m656a(jSONObjectM644a, c0120n.f769a, false);
        }
        JSONObject jSONObjectM644a2 = c0113g.m644a(jSONObjectM663a, OTUXParamsKeys.OT_UX_SUMMARY, "title");
        C0106b0 c0106b0 = new C0106b0();
        if (jSONObjectM644a2 != null) {
            C0115i c0115i = new C0115i();
            if (jSONObjectM644a2.has("fontSize")) {
                c0115i.f751b = jSONObjectM644a2.getString("fontSize");
            }
            c0106b0.f722a = c0115i;
        }
        if (jSONObjectM663a.has("purposeListItem")) {
            JSONObject jSONObject7 = jSONObjectM663a.getJSONObject("purposeListItem");
            c0106b0.f724c = c0113g.m643a(c0120n.f769a, jSONObject7.optString("titleTextColor"), jSONObject7.optString("titleTextColorDark"));
        }
        c0131y2.f890e = c0106b0;
        C0112f c0112f = this.f883d;
        C0124r c0124rM622b = this.f880a.m622b();
        c0112f.getClass();
        if (c0131y == null) {
            if (c0124rM622b != null && !C0048h.m305b(c0124rM622b.f801b)) {
                String str = c0124rM622b.f801b;
                C0117k c0117k = c0131y2.f895j;
                C0106b0 c0106b02 = c0117k.f755a;
                c0106b02.f724c = str;
                c0117k.f755a = c0106b02;
                c0131y2.f895j = c0117k;
            }
            return c0131y2;
        }
        String strM639a = C0112f.m639a(c0131y.f886a, c0131y2.f886a);
        if (strM639a != null && !C0048h.m305b(strM639a)) {
            c0131y.f886a = strM639a;
        }
        String strM639a2 = C0112f.m639a(c0131y.f896k, c0131y2.f896k);
        if (strM639a2 != null && !C0048h.m305b(strM639a2)) {
            c0131y.f896k = strM639a2;
        }
        String strM639a3 = C0112f.m639a(c0131y.f887b, c0131y2.f887b);
        if (strM639a3 != null && !C0048h.m305b(strM639a3)) {
            c0131y.f887b = strM639a3;
        }
        String strM639a4 = C0112f.m639a(c0131y.f888c, c0131y2.f888c);
        if (strM639a4 != null && !C0048h.m305b(strM639a4)) {
            c0131y.f888c = strM639a4;
        }
        c0131y.f890e = C0112f.m642c(c0131y.f890e, c0131y2.f890e);
        c0131y.f891f = C0112f.m642c(c0131y.f891f, c0131y2.f892g);
        c0131y.f892g = C0112f.m642c(c0131y.f892g, c0131y2.f892g);
        c0131y.f895j = C0112f.m636a(c0131y.f895j, c0131y2.f895j, c0124rM622b);
        c0131y.f893h = C0112f.m642c(c0131y.f893h, c0131y2.f893h);
        c0131y.f894i = C0112f.m642c(c0131y.f894i, c0131y2.f894i);
        return c0131y;
    }

    /* JADX INFO: renamed from: c */
    public C0132z m676c(int i) {
        C0132z c0132z;
        C0110d0 c0110d0 = this.f880a;
        JSONObject jSONObjectM621a = c0110d0.m621a();
        C0127u c0127u = null;
        JSONObject jSONObject = (jSONObjectM621a == null || !jSONObjectM621a.has(OTUXParamsKeys.OT_VENDOR_LIST_THEME)) ? null : jSONObjectM621a.getJSONObject(OTUXParamsKeys.OT_VENDOR_LIST_THEME);
        if (jSONObject != null) {
            c0132z = new C0132z();
            if (jSONObject.has("backgroundColor")) {
                c0132z.f897a = jSONObject.getString("backgroundColor");
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR)) {
                c0132z.f898b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_COLOR_ON)) {
                c0132z.f902f = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF)) {
                c0132z.f903g = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_SELECTION_COLOR)) {
                c0132z.f904h = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_SELECTION_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON)) {
                c0132z.f899c = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF)) {
                c0132z.f900d = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR)) {
                c0132z.f901e = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR)) {
                c0132z.f905i = jSONObject.getString(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SEARCH_BAR)) {
                c0132z.f910n = C0110d0.m619d(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_SEARCH_BAR));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_NAVIGATION_TEXT)) {
                c0132z.f906j = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_FILTER_NAVIGATION_TEXT));
            }
            if (jSONObject.has("title")) {
                c0132z.f907k = c0110d0.m624e(jSONObject.getJSONObject("title"));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_ALLOW_ALL_TOGGLE_TEXT)) {
                c0132z.f908l = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_ALLOW_ALL_TOGGLE_TEXT));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_ITEM_TITLE_TEXT)) {
                c0132z.f909m = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_FILTER_ITEM_TITLE_TEXT));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR)) {
                    c0132z.f913q = jSONObject2.getString(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR);
                }
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_VL_CONFIRM_CHOICE)) {
                    c0132z.f911o = c0110d0.m620a(jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_VL_CONFIRM_CHOICE));
                }
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_APPLY_FILTER_BUTTON)) {
                    c0132z.f912p = c0110d0.m620a(jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_APPLY_FILTER_BUTTON));
                }
            }
        } else {
            c0132z = null;
        }
        JSONObject jSONObjectM621a2 = c0110d0.m621a();
        JSONObject jSONObject3 = (jSONObjectM621a2 == null || !jSONObjectM621a2.has("pageHeader")) ? null : jSONObjectM621a2.getJSONObject("pageHeader");
        if (jSONObject3 != null) {
            c0127u = new C0127u();
            C0106b0 c0106b0 = new C0106b0();
            c0106b0.f722a = C0110d0.m618b(jSONObject3);
            if (jSONObject3.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
                c0106b0.f724c = jSONObject3.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            }
            c0127u.f856a = c0106b0;
        }
        if (c0127u != null) {
            (c0132z == null ? new C0132z() : c0132z).f914r = c0127u;
        }
        C0132z c0132zM665b = this.f881b.m665b(i);
        this.f883d.getClass();
        if (c0132z == null) {
            return c0132zM665b;
        }
        if (c0132zM665b == null) {
            return c0132z;
        }
        String strM639a = C0112f.m639a(c0132z.f913q, c0132zM665b.f913q);
        if (strM639a != null && !C0048h.m305b(strM639a)) {
            c0132z.f913q = strM639a;
        }
        String strM639a2 = C0112f.m639a(c0132z.f897a, c0132zM665b.f897a);
        if (strM639a2 != null && !C0048h.m305b(strM639a2)) {
            c0132z.f897a = strM639a2;
        }
        String strM639a3 = C0112f.m639a(c0132z.f905i, c0132zM665b.f905i);
        if (strM639a3 != null && !C0048h.m305b(strM639a3)) {
            c0132z.f905i = strM639a3;
        }
        c0132z.f907k = C0112f.m642c(c0132z.f907k, c0132zM665b.f907k);
        c0132z.f906j = C0112f.m642c(c0132z.f906j, c0132zM665b.f906j);
        c0132z.f909m = C0112f.m640b(c0132z.f909m, c0132zM665b.f909m);
        c0132z.f904h = (String) Objects.requireNonNull(C0112f.m639a(c0132z.f904h, c0132zM665b.f904h));
        c0132z.f910n = C0112f.m630a(c0132z.f910n, c0132zM665b.f910n);
        c0132z.f911o = C0112f.m641b(c0132z.f911o, c0132zM665b.f911o);
        c0132z.f912p = C0112f.m641b(c0132z.f912p, c0132zM665b.f912p);
        c0132z.f902f = (String) Objects.requireNonNull(C0112f.m639a(c0132z.f902f, c0132zM665b.f902f));
        c0132z.f903g = (String) Objects.requireNonNull(C0112f.m639a(c0132z.f903g, c0132zM665b.f903g));
        c0132z.f908l = C0112f.m642c(c0132z.f908l, c0132zM665b.f908l);
        String strM639a4 = C0112f.m639a(c0132z.f899c, c0132zM665b.f899c);
        if (strM639a4 != null && !C0048h.m305b(strM639a4)) {
            c0132z.f899c = strM639a4;
        }
        String strM639a5 = C0112f.m639a(c0132z.f900d, c0132zM665b.f900d);
        if (strM639a5 == null || C0048h.m305b(strM639a5)) {
            return c0132z;
        }
        c0132z.f900d = strM639a5;
        return c0132z;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f7  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0129w m672a(p000a.p001a.p002a.p003a.p004a.p007c.C0031z r24, int r25) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0130x.m672a(a.a.a.a.a.c.z, int):a.a.a.a.b.e.w");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a4  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0128v m674b(int r18) {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0130x.m674b(int):a.a.a.a.b.e.v");
    }

    /* JADX INFO: renamed from: a */
    public C0126t m671a(int i) throws JSONException {
        C0126t c0126t;
        C0110d0 c0110d0 = this.f880a;
        JSONObject jSONObjectM621a = c0110d0.m621a();
        JSONObject jSONObject = (jSONObjectM621a == null || !jSONObjectM621a.has(OTUXParamsKeys.OT_PREFERENCE_CENTER_THEME)) ? null : jSONObjectM621a.getJSONObject(OTUXParamsKeys.OT_PREFERENCE_CENTER_THEME);
        if (jSONObject != null) {
            c0126t = new C0126t();
            if (jSONObject.has("backgroundColor")) {
                c0126t.f830a = jSONObject.getString("backgroundColor");
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR)) {
                c0126t.f831b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON)) {
                c0126t.f832c = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF)) {
                c0126t.f833d = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR)) {
                c0126t.f834e = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR)) {
                c0126t.f836g = jSONObject.getString(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SHOW_LOGO_ON_PC)) {
                C0118l c0118l = new C0118l();
                c0118l.f760a = String.valueOf(jSONObject.getBoolean(OTUXParamsKeys.OT_UX_SHOW_LOGO_ON_PC));
                c0126t.f818A = c0118l;
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SUMMARY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_SUMMARY);
                if (jSONObject2.has("title")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("title");
                    c0126t.f840k = c0110d0.m624e(jSONObject3);
                    c0126t.f848s = c0110d0.m624e(jSONObject3);
                    c0126t.f851v = c0110d0.m624e(jSONObject3);
                    c0126t.f842m = c0110d0.m624e(jSONObject3);
                }
                if (jSONObject2.has("description")) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("description");
                    c0126t.f841l = c0110d0.m624e(jSONObject4);
                    c0126t.f847r = c0110d0.m624e(jSONObject4);
                }
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_PURPOSE_TITLE)) {
                JSONObject jSONObject5 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_PURPOSE_TITLE);
                c0126t.f849t = c0110d0.m624e(jSONObject5);
                c0126t.f843n = c0110d0.m624e(jSONObject5);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_ALWAYS_ACTIVE_STATUS)) {
                c0126t.f850u = c0110d0.m624e(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_TOGGLE_ALWAYS_ACTIVE_STATUS));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
                JSONObject jSONObject6 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR)) {
                    String string = jSONObject6.getString(OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR);
                    C0109d c0109d = new C0109d();
                    c0109d.f744e = string;
                    c0126t.f855z = c0109d;
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CLOSE_BUTTON)) {
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_CLOSE_BUTTON);
                    C0109d c0109d2 = c0126t.f855z;
                    C0107c c0107cM620a = c0110d0.m620a(jSONObject7);
                    if (!C0048h.m305b(c0107cM620a.f729b)) {
                        c0107cM620a.f735h = "true";
                        c0109d2.f745f = c0107cM620a;
                        c0126t.f855z = c0109d2;
                    }
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR)) {
                    c0126t.f820C = jSONObject6.getString(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR);
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_ACCEPT_ALL)) {
                    c0126t.f852w = c0110d0.m620a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_ACCEPT_ALL));
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_REJECT_ALL)) {
                    c0126t.f853x = c0110d0.m620a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_REJECT_ALL));
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CONFIRM_CHOICE)) {
                    c0126t.f854y = c0110d0.m620a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_CONFIRM_CHOICE));
                }
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINKS)) {
                JSONObject jSONObject8 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_LINKS);
                if (jSONObject8.has(OTUXParamsKeys.OT_UX_LINK_POLICY_LINK)) {
                    c0126t.f821D = c0110d0.m623c(jSONObject8.getJSONObject(OTUXParamsKeys.OT_UX_LINK_POLICY_LINK));
                }
                if (jSONObject8.has(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST)) {
                    c0126t.f822E = c0110d0.m623c(jSONObject8.getJSONObject(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST));
                }
            }
        } else {
            c0126t = null;
        }
        C0126t c0126tM662a = this.f881b.m662a(i);
        C0112f c0112f = this.f883d;
        C0124r c0124rM622b = this.f880a.m622b();
        c0112f.getClass();
        if (c0126t == null) {
            if (c0124rM622b != null && !C0048h.m305b(c0124rM622b.f801b)) {
                String str = c0124rM622b.f801b;
                if (c0126tM662a == null) {
                    return null;
                }
                C0117k c0117k = c0126tM662a.f821D;
                C0106b0 c0106b0 = c0117k.f755a;
                c0106b0.f724c = str;
                c0117k.f755a = c0106b0;
                c0126tM662a.f821D = c0117k;
            }
            return c0126tM662a;
        }
        if (c0126tM662a != null) {
            String strM639a = C0112f.m639a(c0126t.f830a, c0126tM662a.f830a);
            if (strM639a != null && !C0048h.m305b(strM639a)) {
                c0126t.f830a = strM639a;
            }
            String strM639a2 = C0112f.m639a(c0126t.f837h, c0126tM662a.f837h);
            if (strM639a2 != null && !C0048h.m305b(strM639a2)) {
                c0126t.f837h = strM639a2;
            }
            String strM639a3 = C0112f.m639a(c0126t.f836g, c0126tM662a.f836g);
            if (strM639a3 != null && !C0048h.m305b(strM639a3)) {
                c0126t.f836g = strM639a3;
            }
            c0126t.f838i = c0126tM662a.f838i;
            c0126t.f840k = C0112f.m642c(c0126t.f840k, c0126tM662a.f840k);
            c0126t.f842m = C0112f.m642c(c0126t.f842m, c0126tM662a.f842m);
            c0126t.f846q = C0112f.m642c(c0126t.f846q, c0126tM662a.f846q);
            c0126t.f844o = C0112f.m642c(c0126t.f844o, c0126tM662a.f844o);
            c0126t.f845p = C0112f.m642c(c0126t.f845p, c0126tM662a.f845p);
            c0126t.f828K = C0112f.m639a(c0126t.f828K, c0126tM662a.f828K);
            c0126t.f841l = C0112f.m642c(c0126t.f841l, c0126tM662a.f841l);
            c0126t.f847r = C0112f.m642c(c0126t.f847r, c0126tM662a.f847r);
            c0126t.f848s = C0112f.m642c(c0126t.f848s, c0126tM662a.f848s);
            c0126t.f851v = C0112f.m642c(c0126t.f851v, c0126tM662a.f851v);
            c0126t.f843n = C0112f.m642c(c0126t.f843n, c0126tM662a.f843n);
            c0126t.f826I = C0112f.m639a(c0126t.f826I, c0126tM662a.f826I);
            c0126t.f827J = C0112f.m639a(c0126t.f827J, c0126tM662a.f827J);
            C0117k c0117kM636a = C0112f.m636a(c0126t.f821D, c0126tM662a.f821D, c0124rM622b);
            c0117kM636a.f758d = c0126tM662a.f821D.f758d;
            c0126t.f821D = c0117kM636a;
            c0126t.f822E = C0112f.m635a(c0126t.f822E, c0126tM662a.f822E);
            C0117k c0117kM635a = C0112f.m635a(c0126t.f823F, c0126tM662a.f823F);
            C0106b0 c0106b02 = c0126tM662a.f823F.f755a;
            String str2 = c0106b02.f726e;
            if (str2 != null) {
                c0117kM635a.f755a.f726e = str2;
            }
            c0117kM635a.f755a.f727f = c0106b02.f727f;
            c0126t.f823F = c0117kM635a;
            c0126t.f839j = c0126tM662a.f839j;
            c0126t.f852w = C0112f.m641b(c0126t.f852w, c0126tM662a.f852w);
            c0126t.f853x = C0112f.m641b(c0126t.f853x, c0126tM662a.f853x);
            c0126t.f854y = C0112f.m641b(c0126t.f854y, c0126tM662a.f854y);
            c0126t.f855z = C0112f.m633a(c0126t.f855z, c0126tM662a.f855z);
            C0106b0 c0106b0M640b = C0112f.m640b(c0126t.f850u, c0126tM662a.f850u);
            if (!C0048h.m305b(c0126tM662a.f850u.f726e)) {
                c0106b0M640b.f726e = c0126tM662a.f850u.f726e;
            }
            c0126t.f850u = c0106b0M640b;
            c0126t.f849t = C0112f.m640b(c0126t.f849t, c0126tM662a.f849t);
            c0126t.f818A = C0112f.m637a(c0126t.f818A, c0126tM662a.f818A);
            String strM639a4 = C0112f.m639a(c0126t.f832c, c0126tM662a.f832c);
            if (strM639a4 != null && !C0048h.m305b(strM639a4)) {
                c0126t.f832c = strM639a4;
            }
            String strM639a5 = C0112f.m639a(c0126t.f833d, c0126tM662a.f833d);
            if (strM639a5 != null && !C0048h.m305b(strM639a5)) {
                c0126t.f833d = strM639a5;
            }
            String strM639a6 = C0112f.m639a(c0126t.f831b, c0126tM662a.f831b);
            if (strM639a6 != null && !C0048h.m305b(strM639a6)) {
                c0126t.f831b = strM639a6;
            }
        }
        return c0126t;
    }
}
