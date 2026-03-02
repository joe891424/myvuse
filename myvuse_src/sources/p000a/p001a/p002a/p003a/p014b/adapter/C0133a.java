package p000a.p001a.p002a.p003a.p014b.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0158d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0125s;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0172d;

/* JADX INFO: renamed from: a.a.a.a.b.f.a */
/* JADX INFO: loaded from: classes.dex */
public class C0133a extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public final OTConfiguration f917a;

    /* JADX INFO: renamed from: b */
    public JSONArray f918b;

    /* JADX INFO: renamed from: c */
    public String f919c;

    /* JADX INFO: renamed from: d */
    public Boolean f920d;

    /* JADX INFO: renamed from: e */
    public Boolean f921e;

    /* JADX INFO: renamed from: f */
    public Boolean f922f;

    /* JADX INFO: renamed from: g */
    public OTPublishersHeadlessSDK f923g;

    /* JADX INFO: renamed from: h */
    public Context f924h;

    /* JADX INFO: renamed from: i */
    public int f925i;

    /* JADX INFO: renamed from: j */
    public a f926j;

    /* JADX INFO: renamed from: k */
    public boolean f927k;

    /* JADX INFO: renamed from: l */
    public boolean f928l;

    /* JADX INFO: renamed from: m */
    public boolean f929m;

    /* JADX INFO: renamed from: n */
    public boolean f930n;

    /* JADX INFO: renamed from: o */
    public C0002a f931o = new C0002a();

    /* JADX INFO: renamed from: p */
    public String f932p;

    /* JADX INFO: renamed from: q */
    public String f933q;

    /* JADX INFO: renamed from: r */
    public C0125s f934r;

    /* JADX INFO: renamed from: s */
    public JSONObject f935s;

    /* JADX INFO: renamed from: t */
    public C0172d f936t;

    /* JADX INFO: renamed from: u */
    public String f937u;

    /* JADX INFO: renamed from: v */
    public String f938v;

    /* JADX INFO: renamed from: w */
    public String f939w;

    /* JADX INFO: renamed from: a.a.a.a.b.f.a$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.a$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f940a;

        /* JADX INFO: renamed from: b */
        public TextView f941b;

        /* JADX INFO: renamed from: c */
        public TextView f942c;

        /* JADX INFO: renamed from: d */
        public TextView f943d;

        /* JADX INFO: renamed from: e */
        public TextView f944e;

        /* JADX INFO: renamed from: f */
        public TextView f945f;

        /* JADX INFO: renamed from: g */
        public SwitchCompat f946g;

        /* JADX INFO: renamed from: h */
        public SwitchCompat f947h;

        /* JADX INFO: renamed from: i */
        public SwitchCompat f948i;

        /* JADX INFO: renamed from: j */
        public View f949j;

        /* JADX INFO: renamed from: k */
        public LinearLayout f950k;

        public b(View view) {
            super(view);
            this.f942c = (TextView) view.findViewById(C3896R.id.sub_group_name);
            this.f943d = (TextView) view.findViewById(C3896R.id.sub_group_desc);
            this.f946g = (SwitchCompat) view.findViewById(C3896R.id.consent_toggle);
            this.f947h = (SwitchCompat) view.findViewById(C3896R.id.legitInt_toggle);
            this.f940a = (TextView) view.findViewById(C3896R.id.tv_consent);
            this.f941b = (TextView) view.findViewById(C3896R.id.tv_legit_Int);
            this.f944e = (TextView) view.findViewById(C3896R.id.alwaysActiveTextChild);
            this.f945f = (TextView) view.findViewById(C3896R.id.alwaysActiveText_non_iab);
            this.f948i = (SwitchCompat) view.findViewById(C3896R.id.consent_toggle_non_iab);
            this.f949j = view.findViewById(C3896R.id.item_divider);
            this.f950k = (LinearLayout) view.findViewById(C3896R.id.group_name_layout);
        }
    }

    public C0133a(a aVar, Context context, int i, boolean z, OTConfiguration oTConfiguration, C0172d c0172d, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f936t = c0172d;
        this.f918b = c0172d.m982a().optJSONArray("SubGroups");
        this.f920d = Boolean.valueOf(z);
        this.f921e = Boolean.valueOf(c0172d.m987e());
        this.f922f = Boolean.valueOf(c0172d.m988f());
        this.f927k = c0172d.m986d();
        this.f923g = oTPublishersHeadlessSDK;
        this.f924h = context;
        this.f925i = i;
        this.f926j = aVar;
        this.f933q = c0172d.m984b();
        this.f934r = c0172d.m985c();
        this.f917a = oTConfiguration;
        this.f937u = c0172d.m985c().m668c();
        this.f938v = c0172d.m985c().m667b();
        this.f939w = c0172d.m985c().m666a();
    }

    /* JADX INFO: renamed from: a */
    public static void m678a(TextView textView, int i, View view) {
        textView.setVisibility(i);
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m682b(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z) {
        Drawable trackDrawable;
        int color;
        Drawable thumbDrawable;
        int color2;
        Drawable thumbDrawable2;
        int color3;
        Drawable trackDrawable2;
        int color4;
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f923g.updatePurposeConsent(string, z);
            C0003b c0003b = new C0003b(7);
            c0003b.f3b = string;
            c0003b.f4c = z ? 1 : 0;
            C0002a c0002a = this.f931o;
            if (c0002a != null) {
                c0002a.m0a(c0003b);
            } else {
                OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z) {
                Context context = this.f924h;
                SwitchCompat switchCompat = bVar.f946g;
                String str = this.f937u;
                String str2 = this.f938v;
                if (C0048h.m305b(str)) {
                    trackDrawable2 = switchCompat.getTrackDrawable();
                    color4 = ContextCompat.getColor(context, C3896R.color.light_greyOT);
                } else {
                    trackDrawable2 = switchCompat.getTrackDrawable();
                    color4 = Color.parseColor(str);
                }
                trackDrawable2.setTint(color4);
                if (C0048h.m305b(str2)) {
                    thumbDrawable = switchCompat.getThumbDrawable();
                    color2 = ContextCompat.getColor(context, C3896R.color.contentTextColorOT);
                    Drawable drawable = thumbDrawable;
                    color3 = color2;
                    thumbDrawable2 = drawable;
                } else {
                    thumbDrawable2 = switchCompat.getThumbDrawable();
                    color3 = Color.parseColor(str2);
                }
            } else {
                Context context2 = this.f924h;
                SwitchCompat switchCompat2 = bVar.f946g;
                String str3 = this.f937u;
                String str4 = this.f939w;
                if (C0048h.m305b(str3)) {
                    trackDrawable = switchCompat2.getTrackDrawable();
                    color = ContextCompat.getColor(context2, C3896R.color.light_greyOT);
                } else {
                    trackDrawable = switchCompat2.getTrackDrawable();
                    color = Color.parseColor(str3);
                }
                trackDrawable.setTint(color);
                if (C0048h.m305b(str4)) {
                    thumbDrawable = switchCompat2.getThumbDrawable();
                    color2 = ContextCompat.getColor(context2, C3896R.color.contentTextColorOT);
                    Drawable drawable2 = thumbDrawable;
                    color3 = color2;
                    thumbDrawable2 = drawable2;
                } else {
                    thumbDrawable2 = switchCompat2.getThumbDrawable();
                    color3 = Color.parseColor(str4);
                }
            }
            thumbDrawable2.setTint(color3);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while updating consent status " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m683c(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z) {
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f923g.updatePurposeConsent(string, z);
            C0003b c0003b = new C0003b(7);
            c0003b.f3b = string;
            c0003b.f4c = z ? 1 : 0;
            C0002a c0002a = this.f931o;
            if (c0002a != null) {
                c0002a.m0a(c0003b);
            } else {
                OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            m692a(z, bVar);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while updating consent status " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m688a(b bVar, JSONObject jSONObject, String str) {
        if (this.f935s != null) {
            C0074f c0074f = new C0074f();
            if (C0048h.m305b(str)) {
                m678a(bVar.f943d, 8, (View) null);
            } else {
                m678a(bVar.f943d, 0, (View) null);
            }
            if (!this.f933q.equalsIgnoreCase("user_friendly")) {
                if (this.f933q.equalsIgnoreCase("legal")) {
                    if (!jSONObject.getString("Type").equals("COOKIE")) {
                        c0074f.m412a(this.f924h, bVar.f943d, this.f932p);
                        return;
                    }
                } else if (!this.f935s.isNull(this.f933q) && !C0048h.m305b(this.f933q)) {
                    return;
                }
            }
            c0074f.m412a(this.f924h, bVar.f943d, str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        JSONArray jSONArray = this.f918b;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        b bVar = (b) viewHolder;
        bVar.setIsRecyclable(false);
        try {
            this.f935s = this.f923g.getPreferenceCenterData();
            Context context = this.f924h;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            String str = "";
            if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                z = false;
                sharedPreferencesC0047f = null;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            String string = sharedPreferences.getString("OT_TEMPLATE_TYPE", "");
            if (!C0048h.m305b(string)) {
                str = string;
            }
            this.f929m = "IAB2".equalsIgnoreCase(str);
            m684a(bVar);
            JSONObject jSONObject = this.f918b.getJSONObject(bVar.getAdapterPosition());
            this.f928l = jSONObject.optBoolean("HasLegIntOptOut", false);
            this.f930n = jSONObject.optBoolean("HasConsentOptOut", false);
            this.f919c = jSONObject.getString("Type");
            boolean zOptBoolean = jSONObject.optBoolean("HasLegIntOptOut", false);
            if (this.f929m && jSONObject.getString("Type").contains("IAB")) {
                m678a(bVar.f941b, 0, (View) null);
            } else {
                m678a(bVar.f941b, 8, (View) null);
            }
            String strOptString = jSONObject.optString("GroupNameMobile");
            if (C0048h.m305b(strOptString)) {
                strOptString = jSONObject.optString("GroupName");
            }
            bVar.f942c.setText(strOptString);
            ViewCompat.setAccessibilityHeading(bVar.f942c, true);
            if (C0170b.m958a(this.f924h)) {
                C0170b.m952a(this.f924h, strOptString, bVar.f950k, C3896R.id.consent_toggle);
                C0170b.m952a(this.f924h, strOptString, bVar.f950k, C3896R.id.legitInt_toggle);
                C0170b.m952a(this.f924h, strOptString, bVar.f950k, C3896R.id.consent_toggle_non_iab);
            }
            String strOptString2 = jSONObject.optString("GroupDescription");
            if (jSONObject.has("DescriptionLegal")) {
                this.f932p = jSONObject.getString("DescriptionLegal");
            }
            String str2 = this.f934r.f813l.f726e;
            bVar.f944e.setText(str2);
            bVar.f945f.setText(str2);
            m688a(bVar, jSONObject, strOptString2);
            m693b(bVar, jSONObject);
            m685a(bVar, i);
            m694c(bVar, jSONObject);
            m687a(bVar, jSONObject);
            m686a(bVar, i, jSONObject);
            if (this.f927k) {
                m678a(bVar.f943d, 0, (View) null);
            } else {
                m678a(bVar.f943d, 8, (View) null);
            }
            m689a(bVar, jSONObject, zOptBoolean);
            TextView textView = bVar.f944e;
            TextView textView2 = bVar.f940a;
            if (jSONObject.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) && C0048h.m305b(str2)) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while rendering purpose items in Vendor detail screen " + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_preference_center_details_item, viewGroup, false));
    }

    /* JADX INFO: renamed from: c */
    public final void m694c(final b bVar, final JSONObject jSONObject) {
        bVar.f946g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m682b(jSONObject, bVar, compoundButton, z);
            }
        });
        bVar.f948i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m683c(jSONObject, bVar, compoundButton, z);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m689a(b bVar, JSONObject jSONObject, boolean z) {
        TextView textView;
        if (this.f922f.booleanValue()) {
            m678a(bVar.f942c, 0, bVar.f949j);
            if (!jSONObject.getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) && !jSONObject.getString("Type").equals("IAB2_SPL_PURPOSE") && !jSONObject.getString("Type").equals("IAB2_FEATURE")) {
                if (this.f928l && this.f919c.equals("IAB2_PURPOSE") && this.f920d.booleanValue()) {
                    m678a(bVar.f947h, 0, (View) null);
                    m678a(bVar.f941b, 0, (View) null);
                } else {
                    m678a(bVar.f947h, 8, (View) null);
                    m678a(bVar.f941b, 8, (View) null);
                }
                if (!this.f936t.f1512a.getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) || !jSONObject.getString("Type").equals("COOKIE")) {
                    if (!this.f930n) {
                        m678a(bVar.f946g, 8, (View) null);
                        m678a(bVar.f940a, 8, (View) null);
                        m678a(bVar.f944e, 8, (View) null);
                        textView = bVar.f945f;
                    } else if (this.f929m) {
                        m678a(bVar.f946g, 0, (View) null);
                        textView = bVar.f944e;
                    } else {
                        m678a(bVar.f946g, 8, (View) null);
                        m678a(bVar.f944e, 8, (View) null);
                        m678a(bVar.f948i, 0, (View) null);
                        m678a(bVar.f945f, 8, (View) null);
                    }
                    m678a(textView, 8, (View) null);
                } else if (this.f929m) {
                    m678a(bVar.f946g, 8, (View) null);
                    m678a(bVar.f944e, 0, (View) null);
                } else {
                    m678a(bVar.f946g, 8, (View) null);
                    m678a(bVar.f944e, 8, (View) null);
                    m678a(bVar.f945f, 0, (View) null);
                }
                textView = bVar.f940a;
                m678a(textView, 8, (View) null);
            } else if (this.f929m) {
                m678a(bVar.f946g, 8, (View) null);
                m678a(bVar.f947h, 8, (View) null);
                m678a(bVar.f940a, 0, (View) null);
                m678a(bVar.f941b, 8, (View) null);
                m678a(bVar.f944e, 0, (View) null);
            } else {
                m678a(bVar.f946g, 8, (View) null);
                m678a(bVar.f944e, 8, (View) null);
                m678a(bVar.f945f, 0, (View) null);
                m678a(bVar.f940a, 8, (View) null);
            }
            if (!this.f921e.booleanValue()) {
                m678a(bVar.f946g, 8, (View) null);
                m678a(bVar.f947h, 8, (View) null);
                m678a(bVar.f941b, 8, (View) null);
                m678a(bVar.f940a, 8, (View) null);
                m678a(bVar.f944e, 8, (View) null);
                m678a(bVar.f945f, 8, (View) null);
                m678a(bVar.f948i, 8, (View) null);
                return;
            }
            if (z && jSONObject.optString("CustomGroupId", "").startsWith("IABV2_") && this.f920d.booleanValue()) {
                m678a(bVar.f947h, 0, (View) null);
                m678a(bVar.f941b, 0, (View) null);
                return;
            } else {
                m678a(bVar.f947h, 8, (View) null);
                m678a(bVar.f941b, 8, (View) null);
                return;
            }
        }
        m678a(bVar.f942c, 8, (View) null);
        m678a(bVar.f943d, 8, (View) null);
        m678a(bVar.f946g, 8, (View) null);
        m678a(bVar.f947h, 8, (View) null);
        m678a(bVar.f941b, 8, (View) null);
        m678a(bVar.f940a, 8, (View) null);
        m678a(bVar.f944e, 8, (View) null);
        m678a(bVar.f945f, 8, (View) null);
        m678a(bVar.f948i, 8, (View) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m681b(int i, b bVar, View view) {
        try {
            m691a(this.f918b.getJSONObject(i).getString("Parent"), this.f918b.getJSONObject(i).optString("CustomGroupId", ""), bVar.f948i.isChecked(), false);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while setting parent status " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff A[PHI: r1 r8
      0x00ff: PHI (r1v5 java.lang.String) = (r1v2 java.lang.String), (r1v3 java.lang.String), (r1v7 java.lang.String), (r1v8 java.lang.String) binds: [B:40:0x00fd, B:33:0x00cf, B:21:0x0082, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r8v3 androidx.appcompat.widget.SwitchCompat) = 
      (r8v1 androidx.appcompat.widget.SwitchCompat)
      (r8v2 androidx.appcompat.widget.SwitchCompat)
      (r8v8 androidx.appcompat.widget.SwitchCompat)
      (r8v9 androidx.appcompat.widget.SwitchCompat)
     binds: [B:40:0x00fd, B:33:0x00cf, B:21:0x0082, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b A[PHI: r8 r9
      0x010b: PHI (r8v6 androidx.appcompat.widget.SwitchCompat) = 
      (r8v1 androidx.appcompat.widget.SwitchCompat)
      (r8v2 androidx.appcompat.widget.SwitchCompat)
      (r8v8 androidx.appcompat.widget.SwitchCompat)
      (r8v9 androidx.appcompat.widget.SwitchCompat)
     binds: [B:40:0x00fd, B:33:0x00cf, B:21:0x0082, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r9v7 android.content.Context) = 
      (r9v3 android.content.Context)
      (r9v4 android.content.Context)
      (r9v11 android.content.Context)
      (r9v12 android.content.Context)
     binds: [B:40:0x00fd, B:33:0x00cf, B:21:0x0082, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m693b(p000a.p001a.p002a.p003a.p014b.adapter.C0133a.b r8, org.json.JSONObject r9) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.adapter.C0133a.m693b(a.a.a.a.b.f.a$b, org.json.JSONObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m679a(JSONObject jSONObject, int i, b bVar, View view) {
        try {
            m691a(jSONObject.getString("Parent"), this.f918b.getJSONObject(i).optString("CustomGroupId", ""), bVar.f947h.isChecked(), true);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while updating parent status " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m680a(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z) {
        Drawable trackDrawable;
        int color;
        Drawable thumbDrawable;
        int color2;
        Drawable thumbDrawable2;
        int color3;
        Drawable trackDrawable2;
        int color4;
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f923g.updatePurposeLegitInterest(string, z);
            C0003b c0003b = new C0003b(11);
            c0003b.f3b = string;
            c0003b.f4c = z ? 1 : 0;
            C0002a c0002a = this.f931o;
            if (c0002a != null) {
                c0002a.m0a(c0003b);
            } else {
                OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z) {
                Context context = this.f924h;
                SwitchCompat switchCompat = bVar.f947h;
                String str = this.f937u;
                String str2 = this.f938v;
                if (C0048h.m305b(str)) {
                    trackDrawable2 = switchCompat.getTrackDrawable();
                    color4 = ContextCompat.getColor(context, C3896R.color.light_greyOT);
                } else {
                    trackDrawable2 = switchCompat.getTrackDrawable();
                    color4 = Color.parseColor(str);
                }
                trackDrawable2.setTint(color4);
                if (C0048h.m305b(str2)) {
                    thumbDrawable = switchCompat.getThumbDrawable();
                    color2 = ContextCompat.getColor(context, C3896R.color.contentTextColorOT);
                    Drawable drawable = thumbDrawable;
                    color3 = color2;
                    thumbDrawable2 = drawable;
                } else {
                    thumbDrawable2 = switchCompat.getThumbDrawable();
                    color3 = Color.parseColor(str2);
                }
            } else {
                Context context2 = this.f924h;
                SwitchCompat switchCompat2 = bVar.f947h;
                String str3 = this.f937u;
                String str4 = this.f939w;
                if (C0048h.m305b(str3)) {
                    trackDrawable = switchCompat2.getTrackDrawable();
                    color = ContextCompat.getColor(context2, C3896R.color.light_greyOT);
                } else {
                    trackDrawable = switchCompat2.getTrackDrawable();
                    color = Color.parseColor(str3);
                }
                trackDrawable.setTint(color);
                if (C0048h.m305b(str4)) {
                    thumbDrawable = switchCompat2.getThumbDrawable();
                    color2 = ContextCompat.getColor(context2, C3896R.color.contentTextColorOT);
                    Drawable drawable2 = thumbDrawable;
                    color3 = color2;
                    thumbDrawable2 = drawable2;
                } else {
                    thumbDrawable2 = switchCompat2.getThumbDrawable();
                    color3 = Color.parseColor(str4);
                }
            }
            thumbDrawable2.setTint(color3);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while updating LI status " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m677a(int i, b bVar, View view) {
        try {
            m691a(this.f918b.getJSONObject(i).getString("Parent"), this.f918b.getJSONObject(i).optString("CustomGroupId", ""), bVar.f946g.isChecked(), false);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPCDetailsAdapter", "Error while setting parent status " + e.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        r5.getThumbDrawable().setTint(android.graphics.Color.parseColor(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        r5.getThumbDrawable().setTint(androidx.core.content.ContextCompat.getColor(r4, com.onetrust.otpublishers.headless.C3896R.color.contentTextColorOT));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1) == false) goto L16;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m692a(boolean r4, p000a.p001a.p002a.p003a.p014b.adapter.C0133a.b r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L30
            android.content.Context r4 = r3.f924h
            androidx.appcompat.widget.SwitchCompat r5 = r5.f948i
            java.lang.String r0 = r3.f937u
            java.lang.String r1 = r3.f938v
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r2 != 0) goto L1c
            android.graphics.drawable.Drawable r2 = r5.getTrackDrawable()
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTint(r0)
            goto L29
        L1c:
            android.graphics.drawable.Drawable r0 = r5.getTrackDrawable()
            int r2 = com.onetrust.otpublishers.headless.C3896R.color.light_greyOT
            int r2 = androidx.core.content.ContextCompat.getColor(r4, r2)
            r0.setTint(r2)
        L29:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r0 != 0) goto L69
            goto L5d
        L30:
            android.content.Context r4 = r3.f924h
            androidx.appcompat.widget.SwitchCompat r5 = r5.f948i
            java.lang.String r0 = r3.f937u
            java.lang.String r1 = r3.f939w
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r2 != 0) goto L4a
            android.graphics.drawable.Drawable r2 = r5.getTrackDrawable()
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTint(r0)
            goto L57
        L4a:
            android.graphics.drawable.Drawable r0 = r5.getTrackDrawable()
            int r2 = com.onetrust.otpublishers.headless.C3896R.color.light_greyOT
            int r2 = androidx.core.content.ContextCompat.getColor(r4, r2)
            r0.setTint(r2)
        L57:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r0 != 0) goto L69
        L5d:
            android.graphics.drawable.Drawable r4 = r5.getThumbDrawable()
            int r5 = android.graphics.Color.parseColor(r1)
            r4.setTint(r5)
            goto L76
        L69:
            android.graphics.drawable.Drawable r5 = r5.getThumbDrawable()
            int r0 = com.onetrust.otpublishers.headless.C3896R.color.contentTextColorOT
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r5.setTint(r4)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.adapter.C0133a.m692a(boolean, a.a.a.a.b.f.a$b):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m691a(String str, String str2, boolean z, boolean z2) throws JSONException {
        int purposeLegitInterestLocal;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z3 = true;
        if (z) {
            int length = this.f918b.length();
            int i = 0;
            for (int i2 = 0; i2 < this.f918b.length(); i2++) {
                OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f923g;
                JSONObject jSONObject = this.f918b.getJSONObject(i2);
                if (!z2) {
                    purposeLegitInterestLocal = oTPublishersHeadlessSDK.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", ""));
                } else if (oTPublishersHeadlessSDK.getPurposeLegitInterestLocal(jSONObject.optString("CustomGroupId", "")) >= 0) {
                    purposeLegitInterestLocal = this.f923g.getPurposeLegitInterestLocal(this.f918b.getJSONObject(i2).optString("CustomGroupId", ""));
                } else {
                    length--;
                }
                i += purposeLegitInterestLocal;
            }
            if (z2) {
                if (i == length) {
                    ((ViewOnClickListenerC0158d) this.f926j).m816a(str, this.f925i, true, true);
                }
            } else if (this.f918b.length() == i) {
                ((ViewOnClickListenerC0158d) this.f926j).m816a(str, this.f925i, true, false);
            }
        } else {
            ((ViewOnClickListenerC0158d) this.f926j).m816a(str, this.f925i, false, z2);
        }
        Context context = this.f924h;
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            sharedPreferencesC0047f = null;
            z3 = false;
        }
        if (z3) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        new C0045d(context, "OTT_DEFAULT_USER");
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str2)) {
                    jSONArray = new JSONArray(jSONObject2.get(str2).toString());
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e.getMessage());
            }
        }
        OTLogger.m2743a(4, "OTPCDetailsAdapter", "SDK Ids of  : " + str2 + " is " + jSONArray);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                this.f923g.updateSDKConsentStatus(jSONArray.get(i3).toString(), z);
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "OneTrust", "Error in setting group sdk status " + e2.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[PHI: r1 r6
      0x0088: PHI (r1v5 java.lang.String) = (r1v4 java.lang.String), (r1v6 java.lang.String) binds: [B:22:0x0086, B:15:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r6v2 androidx.appcompat.widget.SwitchCompat) = (r6v1 androidx.appcompat.widget.SwitchCompat), (r6v7 androidx.appcompat.widget.SwitchCompat) binds: [B:22:0x0086, B:15:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[PHI: r6 r7
      0x0094: PHI (r6v5 androidx.appcompat.widget.SwitchCompat) = (r6v1 androidx.appcompat.widget.SwitchCompat), (r6v7 androidx.appcompat.widget.SwitchCompat) binds: [B:22:0x0086, B:15:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r7v6 android.content.Context) = (r7v3 android.content.Context), (r7v8 android.content.Context) binds: [B:22:0x0086, B:15:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m687a(p000a.p001a.p002a.p003a.p014b.adapter.C0133a.b r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            androidx.appcompat.widget.SwitchCompat r0 = r6.f947h
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L9f
            androidx.appcompat.widget.SwitchCompat r0 = r6.f947h
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r1 = r5.f923g
            java.lang.String r2 = "CustomGroupId"
            java.lang.String r3 = ""
            java.lang.String r4 = r7.optString(r2, r3)
            int r1 = r1.getPurposeLegitInterestLocal(r4)
            r4 = 1
            if (r1 != r4) goto L1d
            r1 = r4
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r0.setChecked(r1)
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r0 = r5.f923g
            java.lang.String r7 = r7.optString(r2, r3)
            int r7 = r0.getPurposeLegitInterestLocal(r7)
            if (r7 != r4) goto L5b
            android.content.Context r7 = r5.f924h
            androidx.appcompat.widget.SwitchCompat r6 = r6.f947h
            java.lang.String r0 = r5.f937u
            java.lang.String r1 = r5.f938v
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r2 != 0) goto L47
            android.graphics.drawable.Drawable r2 = r6.getTrackDrawable()
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTint(r0)
            goto L54
        L47:
            android.graphics.drawable.Drawable r0 = r6.getTrackDrawable()
            int r2 = com.onetrust.otpublishers.headless.C3896R.color.light_greyOT
            int r2 = androidx.core.content.ContextCompat.getColor(r7, r2)
            r0.setTint(r2)
        L54:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r0 != 0) goto L94
            goto L88
        L5b:
            android.content.Context r7 = r5.f924h
            androidx.appcompat.widget.SwitchCompat r6 = r6.f947h
            java.lang.String r0 = r5.f937u
            java.lang.String r1 = r5.f939w
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r2 != 0) goto L75
            android.graphics.drawable.Drawable r2 = r6.getTrackDrawable()
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTint(r0)
            goto L82
        L75:
            android.graphics.drawable.Drawable r0 = r6.getTrackDrawable()
            int r2 = com.onetrust.otpublishers.headless.C3896R.color.light_greyOT
            int r2 = androidx.core.content.ContextCompat.getColor(r7, r2)
            r0.setTint(r2)
        L82:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r0 != 0) goto L94
        L88:
            android.graphics.drawable.Drawable r6 = r6.getThumbDrawable()
            int r7 = android.graphics.Color.parseColor(r1)
        L90:
            r6.setTint(r7)
            goto L9f
        L94:
            android.graphics.drawable.Drawable r6 = r6.getThumbDrawable()
            int r0 = com.onetrust.otpublishers.headless.C3896R.color.contentTextColorOT
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r0)
            goto L90
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.adapter.C0133a.m687a(a.a.a.a.b.f.a$b, org.json.JSONObject):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m686a(final b bVar, final int i, final JSONObject jSONObject) {
        bVar.f947h.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m679a(jSONObject, i, bVar, view);
            }
        });
        bVar.f947h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m680a(jSONObject, bVar, compoundButton, z);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m690a(TextView textView, C0106b0 c0106b0) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        textView.setText(c0106b0.f726e);
        textView.setTextColor(Color.parseColor(c0106b0.f724c));
        C0115i c0115i = c0106b0.f722a;
        OTConfiguration oTConfiguration = this.f917a;
        String str = c0115i.f753d;
        if (C0048h.m305b(str) || oTConfiguration == null || (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) == null) {
            int style = c0115i.f752c;
            if (style == -1 && (typeface = textView.getTypeface()) != null) {
                style = typeface.getStyle();
            }
            textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
        } else {
            textView.setTypeface(otTypeFaceMap);
        }
        if (!C0048h.m305b(c0115i.f751b)) {
            textView.setTextSize(Float.parseFloat(c0115i.f751b));
        }
        if (C0048h.m305b(c0106b0.f723b)) {
            return;
        }
        textView.setTextAlignment(Integer.parseInt(c0106b0.f723b));
    }

    /* JADX INFO: renamed from: a */
    public final void m684a(b bVar) {
        try {
            C0125s c0125s = this.f934r;
            if (c0125s != null) {
                m690a(bVar.f942c, c0125s.f809h);
                m690a(bVar.f943d, this.f934r.f810i);
                m690a(bVar.f940a, this.f934r.f811j);
                m690a(bVar.f941b, this.f934r.f812k);
                m690a(bVar.f944e, this.f934r.f813l);
                m690a(bVar.f945f, this.f934r.f813l);
                String str = this.f934r.f803b;
                C0170b.m953a(bVar.f949j, str);
                if (bVar.getAdapterPosition() == 0) {
                    OTLogger.m2743a(3, "OT_Automation", "setLineBreakColor PC Detail Subgroups List: " + str);
                }
                String str2 = this.f934r.f811j.f726e;
                bVar.f946g.setContentDescription(str2);
                bVar.f948i.setContentDescription(str2);
                bVar.f947h.setContentDescription(this.f934r.f812k.f726e);
            }
        } catch (IllegalArgumentException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while applying Styles to PC Details view, err : " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m685a(final b bVar, final int i) {
        bVar.f946g.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m677a(i, bVar, view);
            }
        });
        bVar.f948i.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.a$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m681b(i, bVar, view);
            }
        });
    }
}
