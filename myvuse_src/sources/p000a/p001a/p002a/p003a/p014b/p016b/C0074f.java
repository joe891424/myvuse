package p000a.p001a.p002a.p003a.p014b.p016b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.surajit.rnrg.RadialGradientManager;
import java.util.Objects;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.instance.InstanceFactory;
import org.xml.sax.XMLReader;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;

/* JADX INFO: renamed from: a.a.a.a.b.b.f */
/* JADX INFO: loaded from: classes.dex */
public class C0074f {

    /* JADX INFO: renamed from: a.a.a.a.b.b.f$a */
    public static class a implements Html.TagHandler {

        /* JADX INFO: renamed from: b */
        public String f238b;

        /* JADX INFO: renamed from: a */
        public boolean f237a = true;

        /* JADX INFO: renamed from: c */
        public int f239c = 1;

        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if ("ul".equals(str)) {
                this.f238b = "UL";
            } else if ("ol".equals(str)) {
                this.f238b = "OL";
            }
            if ("li".equals(str)) {
                if ("UL".equals(this.f238b)) {
                    if (this.f237a) {
                        editable.append("\n\t•");
                        this.f237a = false;
                        return;
                    }
                } else if (this.f237a) {
                    editable.append(InstanceFactory.ERROR_SEPARATOR).append((CharSequence) String.valueOf(this.f239c)).append(". ");
                    this.f237a = false;
                    this.f239c++;
                    return;
                }
                this.f237a = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m395a(String str) {
        int i;
        if (C0048h.m305b(str)) {
            return "";
        }
        if (RadialGradientManager.PROP_CENTER.equalsIgnoreCase(str)) {
            i = 4;
        } else if (ViewProps.LEFT.equalsIgnoreCase(str)) {
            i = 2;
        } else {
            if (!ViewProps.RIGHT.equalsIgnoreCase(str)) {
                return "";
            }
            i = 3;
        }
        return String.valueOf(i);
    }

    /* JADX INFO: renamed from: a */
    public static String m396a(JSONObject jSONObject, String str) {
        if (C0048h.m305b(str) || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UIUtils", "Error on getting vendor count for category : " + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m398a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    public static void m399a(Button button, String str, String str2, int i) {
        if (button.getId() != i) {
            button.setBackgroundColor(Color.parseColor(str));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_3D), Color.parseColor(str2));
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(Float.parseFloat("0"));
        button.setBackground(gradientDrawable);
    }

    /* JADX INFO: renamed from: a */
    public static void m400a(ImageView imageView, String str) {
        imageView.getDrawable().setTint(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m402a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("SubGroups")) {
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = jSONObject.getJSONArray("SubGroups");
            for (int i = 0; i < jSONArray3.length(); i++) {
                if (!jSONArray3.getJSONObject(i).getString("Type").contains("COOKIE")) {
                    jSONArray2.put(jSONArray3.getJSONObject(i));
                }
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                m403a(jSONArray, jSONObject2, jSONObject3, "IAB2_STACK".equals(jSONObject3.getString("Type")));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m403a(JSONArray jSONArray, JSONObject jSONObject, JSONObject jSONObject2, boolean z) throws JSONException {
        if (z || jSONObject2.getString("Type").contains("COOKIE") || jSONObject2.getString("Type").contains("BRANCH")) {
            return;
        }
        jSONObject.put("CustomGroupId", jSONObject2.optString("CustomGroupId", ""));
        jSONObject.put("GroupName", jSONObject2.optString("GroupName", ""));
        jSONObject.put("Type", jSONObject2.optString("Type", ""));
        jSONArray.put(jSONObject);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m404b(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return false;
        }
        if (z) {
            if (!jSONObject.has("BannerMPButtonColor")) {
                OTLogger.m2743a(6, "OneTrust", "Downloaded data does not contain the required fields to render the UI. \nPlease publish the application to a version that matches the SDK version from the admin UI.");
                return true;
            }
        } else if (!jSONObject.has("IsIabEnabled") || !jSONObject.has("PCGrpDescType") || !jSONObject.has("BConsentText")) {
            OTLogger.m2743a(6, "OneTrust", "Downloaded data does not contain the required fields to render the UI. \nPlease publish the application to a version that matches the SDK version from the admin UI.");
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public int m405a(Context context) {
        if (Build.VERSION.SDK_INT < 30) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) Objects.requireNonNull(context)).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        WindowMetrics currentWindowMetrics = ((Activity) Objects.requireNonNull(context)).getWindowManager().getCurrentWindowMetrics();
        Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        int i = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
        int i2 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
        Rect bounds = currentWindowMetrics.getBounds();
        return new Size(bounds.width() - i, bounds.height() - i2).getHeight();
    }

    /* JADX INFO: renamed from: a */
    public View m406a(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        return new C0048h().m318g(context) ? layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar)).inflate(i, viewGroup, false) : layoutInflater.inflate(i, viewGroup, false);
    }

    /* JADX INFO: renamed from: a */
    public String m409a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("GroupNameMobile");
        return C0048h.m305b(strOptString) ? jSONObject.optString("GroupName") : strOptString;
    }

    /* JADX INFO: renamed from: a */
    public void m413a(Context context, SwitchCompat switchCompat, String str, String str2) {
        if (C0048h.m305b(str)) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(context, C3896R.color.light_greyOT));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        if (C0048h.m305b(str2)) {
            switchCompat.getThumbDrawable().setTint(ContextCompat.getColor(context, C3896R.color.contentTextColorOT));
        } else {
            switchCompat.getThumbDrawable().setTint(Color.parseColor(str2));
        }
    }

    /* JADX INFO: renamed from: a */
    public String m410a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z, String str2) {
        return ((C0048h.m305b(str) ? false : "IAB2V2".equalsIgnoreCase(str)) && m418a(jSONObject2, z)) ? str2 + " (" + m396a(jSONObject, jSONObject2.optString("CustomGroupId")) + ")" : str2;
    }

    /* JADX INFO: renamed from: a */
    public String m408a(C0106b0 c0106b0, String str) {
        return !C0048h.m305b(c0106b0.f724c) ? c0106b0.f724c : str;
    }

    /* JADX INFO: renamed from: a */
    public String m407a(long j, JSONObject jSONObject) {
        String str;
        String string;
        StringBuilder sb;
        StringBuilder sbAppend;
        String strOptString;
        if (j <= 0) {
            return "0 " + jSONObject.optString("PCenterVendorListLifespanDays");
        }
        int i = (int) (j / 2629746);
        int i2 = ((int) (j % 2629746)) / 86400;
        str = "";
        if (i != 0) {
            if (i != 1) {
                sb = new StringBuilder();
                sbAppend = sb.append(i).append(" ");
                strOptString = jSONObject.optString("PCenterVendorListLifespanMonths");
            } else {
                sb = new StringBuilder();
                sbAppend = sb.append(i).append(" ");
                strOptString = jSONObject.optString("PCenterVendorListLifespanMonth");
            }
            string = sbAppend.append(strOptString).toString();
        } else {
            string = "";
        }
        if (i2 == 0) {
            boolean z = i == 0;
            String str2 = "0 " + jSONObject.optString("PCenterVendorListLifespanDays");
            if (z) {
                str = str2;
            }
        } else if (i2 != 1) {
            str = 30 != i2 ? i2 + " " + jSONObject.optString("PCenterVendorListLifespanDays") : "";
            if (30 == i2) {
                int i3 = i + 1;
                string = i3 + " " + (i3 == 1 ? jSONObject.optString("PCenterVendorListLifespanMonth") : jSONObject.optString("PCenterVendorListLifespanMonths"));
            }
        } else {
            str = i2 + " " + jSONObject.optString("PCenterVendorListLifespanDay");
        }
        return string + " " + str;
    }

    /* JADX INFO: renamed from: a */
    public static int m394a(Context context, OTConfiguration oTConfiguration) {
        return (oTConfiguration == null || C0048h.m305b(oTConfiguration.getDarkModeThemeValue())) ? 32 == (context.getResources().getConfiguration().uiMode & 48) ? 11 : 22 : C0026u.m181a(oTConfiguration.getDarkModeThemeValue(), false) ? 11 : 22;
    }

    /* JADX INFO: renamed from: a */
    public void m415a(View view, Context context) {
        RelativeLayout.LayoutParams layoutParams;
        int i;
        if (Build.VERSION.SDK_INT >= 28) {
            View decorView = ((Activity) Objects.requireNonNull(context)).getWindow().getDecorView();
            if ((decorView.getRootWindowInsets() != null ? decorView.getRootWindowInsets().getDisplayCutout() : null) != null) {
                OTLogger.m2743a(5, "UIUtils", "Device is notch enabled");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.setMargins(0, 0, 0, 50);
                view.setLayoutParams(layoutParams2);
                return;
            }
            OTLogger.m2743a(5, "UIUtils", "Device is not notch enabled");
            layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            i = 70;
        } else {
            layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            i = 60;
        }
        layoutParams.setMargins(0, 0, 0, i);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m418a(JSONObject jSONObject, boolean z) throws JSONException {
        if (z && jSONObject.getString("Type").contains("IAB")) {
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("SubGroups")) {
            jSONArray = jSONObject.getJSONArray("SubGroups");
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getJSONObject(i).getString("Type").contains("IAB")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m412a(Context context, TextView textView, String str) {
        if (str != null && !C0048h.m305b(str)) {
            if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str).matches()) {
                textView.setText(str);
                return;
            }
            OTLogger.m2743a(3, "UIUtils", "Rendering html content");
            Spanned spannedFromHtml = Html.fromHtml(str, 0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
            for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
                spannableStringBuilder.setSpan(new C0073e(this, context, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
                spannableStringBuilder.removeSpan(uRLSpan);
            }
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        OTLogger.m2743a(3, "UIUtils", "renderHtmlText called with 'null' text content.");
    }

    /* JADX INFO: renamed from: a */
    public static void m397a(Context context, Button button, C0107c c0107c, String str, String str2) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(3, "UIUtils", "Button set background color called with empty buttonBackGroundColor.");
            return;
        }
        if (new C0048h().m318g(context)) {
            button.setBackgroundColor(Color.parseColor(str));
            return;
        }
        if (c0107c != null) {
            String str3 = c0107c.f732e;
            String str4 = c0107c.f733f;
            if (!C0048h.m305b(str3) || !C0048h.m305b(str4)) {
                String str5 = c0107c.f732e;
                if (C0048h.m305b(str5)) {
                    str5 = "4";
                }
                if (C0048h.m305b(str2)) {
                    str2 = str;
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke(Integer.parseInt(str5), Color.parseColor(str2));
                gradientDrawable.setColor(Color.parseColor(str));
                if (!C0048h.m305b(c0107c.f733f)) {
                    gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, Integer.parseInt(c0107c.f733f), context.getResources().getDisplayMetrics()));
                }
                button.setBackground(gradientDrawable);
                return;
            }
        }
        m399a(button, str, str2, C3896R.id.cookies_setting_button);
    }

    /* JADX INFO: renamed from: a */
    public void m416a(Button button, C0115i c0115i, OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        String str = c0115i.f753d;
        if (!C0048h.m305b(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            button.setTypeface(otTypeFaceMap);
            return;
        }
        int style = c0115i.f752c;
        if (style == -1 && (typeface = button.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        button.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(button.getTypeface(), style));
    }

    /* JADX INFO: renamed from: a */
    public void m417a(TextView textView, C0115i c0115i, OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        String str = c0115i.f753d;
        if (!C0048h.m305b(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
            return;
        }
        int style = c0115i.f752c;
        if (style == -1 && (typeface = textView.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
    }

    /* JADX INFO: renamed from: a */
    public static void m401a(TextView textView, int i) {
        if ((textView.getContext().getApplicationInfo().flags & 4194304) == 0) {
            int layoutDirection = textView.getContext().getResources().getConfiguration().getLayoutDirection();
            int i2 = GravityCompat.END;
            int i3 = GravityCompat.START;
            if (layoutDirection != 1) {
                i3 = 8388613;
                i2 = 8388611;
            }
            if (i == 2) {
                textView.setGravity(3);
                return;
            }
            if (i == 3) {
                textView.setGravity(5);
                return;
            }
            if (i == 4) {
                textView.setGravity(1);
                return;
            } else if (i == 5) {
                textView.setGravity(i2);
                return;
            } else {
                if (i != 6) {
                    return;
                }
                textView.setGravity(i3);
                return;
            }
        }
        textView.setTextAlignment(i);
    }

    /* JADX INFO: renamed from: a */
    public void m414a(Context context, BottomSheetDialog bottomSheetDialog) {
        if (context != null && bottomSheetDialog == null) {
            OTLogger.m2743a(3, "UIUtils", "setupFullHeight: null instance found, recreating bottomSheetDialog");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (!C0048h.m305b(string)) {
                str = string;
            }
            bottomSheetDialog = str.equals(OTThemeConstants.OT_SDK_UI_THEME) ? new BottomSheetDialog(context, C3896R.style.OTSDKTheme) : new BottomSheetDialog(context);
        }
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(C3896R.id.design_bottom_sheet);
        if (frameLayout != null) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            int iM405a = m405a(context);
            if (layoutParams != null) {
                layoutParams.height = iM405a;
            }
            frameLayout.setLayoutParams(layoutParams);
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setPeekHeight(m405a(context));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m411a(C0003b c0003b, C0002a c0002a) {
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }
}
