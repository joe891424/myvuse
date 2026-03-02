package p000a.p001a.p002a.p003a.p004a.p007c;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.viewbinding.ViewBinding;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.p046UI.Helper.FragmentViewBindingDelegate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItemConsentState;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;

/* JADX INFO: renamed from: a.a.a.a.a.c.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0026u {
    /* JADX INFO: renamed from: a */
    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> m161a(Fragment fragment, Function1<? super View, ? extends T> viewBindingFactory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(viewBindingFactory, "viewBindingFactory");
        return new FragmentViewBindingDelegate<>(fragment, viewBindingFactory);
    }

    /* JADX INFO: renamed from: a */
    public static final <T> T m162a(LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        if (liveData.getValue() == null) {
            throw new IllegalStateException("LiveData does not have any value");
        }
        T value = liveData.getValue();
        Intrinsics.checkNotNull(value);
        return value;
    }

    /* JADX INFO: renamed from: a */
    public static String m163a(int i) {
        ArrayList arrayList = new ArrayList();
        if (i >= 1) {
            arrayList.add(1);
            int i2 = 2;
            if (i >= 2) {
                arrayList.add(2);
                while (true) {
                    int i3 = i2 - 1;
                    int i4 = i2 - 2;
                    if (i < ((Integer) arrayList.get(i3)).intValue() + ((Integer) arrayList.get(i4)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i3)).intValue() + ((Integer) arrayList.get(i4)).intValue()));
                    i2++;
                }
            }
        }
        StringBuilder sb = new StringBuilder("1");
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int iIntValue = ((Integer) arrayList.get(size)).intValue();
            if (i >= iIntValue) {
                sb.insert(0, "1");
                i -= iIntValue;
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static final String m165a(JSONObject jSONObject, String key, String defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (jSONObject != null) {
            try {
                string = jSONObject.getString(key);
            } catch (Exception unused) {
                string = defaultValue;
            }
        } else {
            string = null;
        }
        return string == null ? defaultValue : string;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ String m166a(JSONObject jSONObject, String str, String str2, int i) {
        return m165a(jSONObject, str, (i & 2) != 0 ? "" : null);
    }

    /* JADX INFO: renamed from: a */
    public static JSONArray m168a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("Groups");
        return jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray : new JSONArray();
    }

    /* JADX INFO: renamed from: a */
    public static final JSONObject m169a(JSONObject jSONObject, String searchQuery, JSONObject vendorObject, boolean z) throws JSONException {
        JSONArray jSONArrayNames;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(vendorObject, "vendorObject");
        JSONObject jSONObject2 = new JSONObject();
        if (searchQuery.length() == 0 || (jSONArrayNames = vendorObject.names()) == null) {
            return vendorObject;
        }
        String str = z ? "Name" : "name";
        int length = jSONArrayNames.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArrayNames.getString(i);
            JSONObject jSONObject3 = vendorObject.getJSONObject(string);
            String string2 = jSONObject3.getString(str);
            Intrinsics.checkNotNullExpressionValue(string2, "vendor.getString(nameKey)");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = string2.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt.contains((CharSequence) lowerCase, (CharSequence) searchQuery, true)) {
                jSONObject2.put(string, jSONObject3);
            }
        }
        return jSONObject2;
    }

    /* JADX INFO: renamed from: a */
    public static void m170a(C0045d c0045d, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        SharedPreferences.Editor editorEdit = c0045d.m271a().edit();
        editorEdit.putString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", String.valueOf(jSONObject));
        editorEdit.putString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", String.valueOf(jSONObject2));
        editorEdit.putString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", String.valueOf(jSONObject3));
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: a */
    public static final void m171a(View view, String str) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        view.setBackgroundColor(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public static final void m174a(Button button, String str) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        button.setTextColor(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public static final void m175a(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        imageView.getDrawable().setTint(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public static final void m176a(SwitchCompat switchCompat, String str, String str2) {
        Intrinsics.checkNotNullParameter(switchCompat, "<this>");
        if (str == null || str.length() == 0) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(switchCompat.getContext(), C3896R.color.light_greyOT));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        if (str2 == null || str2.length() == 0) {
            switchCompat.getThumbDrawable().setTint(ContextCompat.getColor(switchCompat.getContext(), C3896R.color.contentTextColorOT));
        } else {
            switchCompat.getThumbDrawable().setTint(Color.parseColor(str2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m177a(String str, Activity activity, String str2, String str3, ImageView imageView, boolean z) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            try {
                Class.forName("com.google.zxing.MultiFormatWriter");
                int i = (int) (((double) displayMetrics.heightPixels) * 0.3d);
                int i2 = (int) (((double) displayMetrics.widthPixels) * 0.2d);
                BitMatrix bitMatrixM160a = m160a(str, i, i2, z);
                if (bitMatrixM160a == null) {
                    OTLogger.m2743a(6, "OTQRCodeUtils", "encodeToBitmap(): null bitMatrix");
                    return;
                }
                int width = bitMatrixM160a.getWidth();
                int height = bitMatrixM160a.getHeight();
                int[] iArr = new int[width * height];
                if (C0048h.m305b(str2) || C0048h.m305b(str3)) {
                    return;
                }
                int color = Color.parseColor(str2);
                int color2 = Color.parseColor(str3);
                for (int i3 = 0; i3 < height; i3++) {
                    int i4 = i3 * width;
                    for (int i5 = 0; i5 < width; i5++) {
                        iArr[i4 + i5] = bitMatrixM160a.get(i5, i3) ? color2 : color;
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, width, height);
                imageView.setImageBitmap(bitmapCreateBitmap);
            } catch (ClassNotFoundException unused) {
                OTLogger.m2743a(6, "OTQRCodeUtils", "Add implementation 'com.google.zxing:core:3.3.0' to gradle file and try again to support QR code");
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTQRCodeUtils", "encodeToBitmap(): " + e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m181a(String str, boolean z) {
        return C0048h.m305b(str) ? z : "true".equalsIgnoreCase(str);
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m182a(JSONObject jSONObject, String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject == null) {
            return z;
        }
        try {
            return jSONObject.getBoolean(key);
        } catch (Exception unused) {
            return z;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m183a(JSONObject jSONObject, String str, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m182a(jSONObject, str, z);
    }

    /* JADX INFO: renamed from: b */
    public static final String m186b(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return jSONObject.getString(key);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m187b(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        imageView.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
    }

    /* JADX INFO: renamed from: a */
    public static BitMatrix m160a(String str, int i, int i2, boolean z) {
        int i3 = z ? 1 : 2;
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            enumMap.put(EncodeHintType.MARGIN, Integer.valueOf(i3));
            return new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i2, i, enumMap);
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTQRCodeUtils", "encodeToBitmap(): " + e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m159a(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return -1;
        }
        String strOptString = jSONObject.optJSONObject(str).optString("userConsentStatus");
        return ("ACTIVE".equalsIgnoreCase(strOptString) || "OPT_IN".equalsIgnoreCase(strOptString)) ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public static String m164a(C0045d c0045d) {
        JSONObject jSONObject;
        String string;
        String string2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            string2 = c0045d.m271a().getString("OT_API_FETCH_STATUS_DATA", "");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting status data json, err: " + e.getMessage());
        }
        JSONObject jSONObject3 = !C0048h.m305b(string2) ? new JSONObject(string2) : new JSONObject();
        String string3 = c0045d.m271a().getString("OTT_DOMAIN_DATA", "");
        if (!C0048h.m305b(string3)) {
            try {
                jSONObject = new JSONObject(string3);
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "OneTrust", "error while returning domain data, err: " + e2.getMessage());
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        try {
            string = c0045d.m271a().getString("OT_CULTURE_DATA", "");
        } catch (JSONException e3) {
            OTLogger.m2743a(6, "OneTrust", "Error while getting culture data json on getCultureData, err: " + e3.getMessage());
        }
        JSONObject jSONObject4 = !C0048h.m305b(string) ? new JSONObject(string) : new JSONObject();
        m179a(jSONObject2, jSONObject3, "status");
        m179a(jSONObject2, jSONObject, "domain");
        m179a(jSONObject2, jSONObject4, "culture");
        return !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m180a(C0106b0 c0106b0) {
        String str;
        Intrinsics.checkNotNullParameter(c0106b0, "<this>");
        return (!c0106b0.m614a() || (str = c0106b0.f726e) == null || str.length() == 0) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static void m179a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            OTLogger.m2743a(3, "OTSharedPreferenceHelper", "Exception thrown while constructing ott data, err : " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m178a(JSONArray jSONArray, SharedPreferences sharedPreferences) {
        String string;
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONObject.put(jSONArray.optJSONObject(i).optString("CustomGroupId"), jSONArray.optJSONObject(i).optString("Type"));
                if (jSONArray.optJSONObject(i).has("SubGroups") && (jSONArrayOptJSONArray = jSONArray.optJSONObject(i).optJSONArray("SubGroups")) != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        jSONObject.put(jSONArrayOptJSONArray.optJSONObject(i2).optString("CustomGroupId"), jSONArrayOptJSONArray.optJSONObject(i2).optString("Type"));
                    }
                }
            }
            OTLogger.m2743a(3, "OTTemplateUtils", "Groups configured: " + jSONObject);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            editorEdit.putString("OT_GROUP_ID_OBJECT", string).apply();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTTemplateUtils", "Error while saving groups in template,err: " + e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m173a(Button button, C0115i titleFontProperty, OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        Intrinsics.checkNotNullParameter(button, "<this>");
        Intrinsics.checkNotNullParameter(titleFontProperty, "titleFontProperty");
        String str = titleFontProperty.f753d;
        if (str != null && str.length() != 0 && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            button.setTypeface(otTypeFaceMap);
            return;
        }
        int style = titleFontProperty.f752c;
        if (style == -1 && (typeface = button.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        String str2 = titleFontProperty.f750a;
        button.setTypeface((str2 == null || str2.length() == 0) ? Typeface.create(button.getTypeface(), style) : Typeface.create(titleFontProperty.f750a, style));
    }

    /* JADX INFO: renamed from: a */
    public static final void m172a(Button button, C0107c buttonProperty, String str, String str2, String str3, OTConfiguration oTConfiguration) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        Intrinsics.checkNotNullParameter(buttonProperty, "buttonProperty");
        C0115i c0115i = buttonProperty.f728a;
        Intrinsics.checkNotNullExpressionValue(c0115i, "buttonProperty.fontProperty");
        m173a(button, c0115i, oTConfiguration);
        String str4 = c0115i.f751b;
        if (str4 != null && str4.length() != 0) {
            String str5 = c0115i.f751b;
            Intrinsics.checkNotNull(str5);
            button.setTextSize(Float.parseFloat(str5));
        }
        m174a(button, str2);
        C0074f.m397a(button.getContext(), button, buttonProperty, str, str3);
    }

    /* JADX INFO: renamed from: a */
    public static final List<VendorItem> m167a(JSONObject jSONObject, boolean z) throws JSONException {
        JSONArray jSONArrayNames;
        VendorItem vendorItem;
        VendorItemConsentState vendorItemConsentState;
        VendorItemConsentState vendorItemConsentState2;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayNames = jSONObject.names()) == null) {
            return arrayList;
        }
        int length = jSONArrayNames.length();
        for (int i = 0; i < length; i++) {
            JSONObject itemJson = jSONObject.getJSONObject(jSONArrayNames.get(i).toString());
            int i2 = -1;
            if (z) {
                Intrinsics.checkNotNullExpressionValue(itemJson, "itemJson");
                String string = jSONArrayNames.get(i).toString();
                String strM166a = m166a(itemJson, "Name", (String) null, 2);
                Intrinsics.checkNotNullParameter(itemJson, "<this>");
                Intrinsics.checkNotNullParameter(OTVendorUtils.CONSENT_TYPE, "key");
                try {
                    i2 = itemJson.getInt(OTVendorUtils.CONSENT_TYPE);
                } catch (Exception unused) {
                }
                if (i2 != 0) {
                    vendorItemConsentState2 = i2 != 1 ? VendorItemConsentState.NoToggle : VendorItemConsentState.Grant;
                } else {
                    vendorItemConsentState2 = VendorItemConsentState.Deny;
                }
                vendorItem = new VendorItem(string, strM166a, vendorItemConsentState2);
            } else {
                Intrinsics.checkNotNullExpressionValue(itemJson, "itemJson");
                String strM165a = m165a(itemJson, "id", "-1");
                String strM166a2 = m166a(itemJson, "name", (String) null, 2);
                Intrinsics.checkNotNullParameter(itemJson, "<this>");
                Intrinsics.checkNotNullParameter(OTVendorUtils.CONSENT_TYPE, "key");
                try {
                    i2 = itemJson.getInt(OTVendorUtils.CONSENT_TYPE);
                } catch (Exception unused2) {
                }
                if (i2 != 0) {
                    vendorItemConsentState = i2 != 1 ? VendorItemConsentState.NoToggle : VendorItemConsentState.Grant;
                } else {
                    vendorItemConsentState = VendorItemConsentState.Deny;
                }
                vendorItem = new VendorItem(strM165a, strM166a2, vendorItemConsentState);
            }
            arrayList.add(vendorItem);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m184a(boolean z, JSONObject jSONObject, String str, String str2, String str3, String str4) throws JSONException {
        if (!str3.equalsIgnoreCase(str4)) {
            OTLogger.m2743a(5, "UCPurposesDataHandler", "Invalid ID passed to update UCP Consent values");
            return false;
        }
        if (!z) {
            str = str2;
        }
        jSONObject.put("userConsentStatus", str);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m185a(boolean z, JSONObject jSONObject, String str, String str2, JSONObject jSONObject2, String str3) throws JSONException {
        if (!jSONObject2.has(str3)) {
            OTLogger.m2743a(5, "UCPurposesDataHandler", "Invalid ID passed to update UCP Consent values");
            return false;
        }
        if (!z) {
            str = str2;
        }
        jSONObject.put("userConsentStatus", str);
        return true;
    }
}
