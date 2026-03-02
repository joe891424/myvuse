package p000a.p001a.p002a.p003a.p014b.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0158d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0069a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;

/* JADX INFO: renamed from: a.a.a.a.b.f.b */
/* JADX INFO: loaded from: classes.dex */
public class C0134b extends RecyclerView.Adapter<a> implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0075c f951a;

    /* JADX INFO: renamed from: b */
    public final OTConfiguration f952b;

    /* JADX INFO: renamed from: c */
    public OTPublishersHeadlessSDK f953c;

    /* JADX INFO: renamed from: d */
    public JSONArray f954d;

    /* JADX INFO: renamed from: e */
    public Context f955e;

    /* JADX INFO: renamed from: f */
    public final C0002a f956f;

    /* JADX INFO: renamed from: g */
    public ViewOnClickListenerC0158d f957g;

    /* JADX INFO: renamed from: h */
    public C0126t f958h;

    /* JADX INFO: renamed from: i */
    public String f959i;

    /* JADX INFO: renamed from: j */
    public String f960j;

    /* JADX INFO: renamed from: k */
    public String f961k;

    /* JADX INFO: renamed from: l */
    public final C0171c f962l;

    /* JADX INFO: renamed from: m */
    public final C0074f f963m = new C0074f();

    /* JADX INFO: renamed from: n */
    public final JSONObject f964n;

    /* JADX INFO: renamed from: a.a.a.a.b.f.b$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f965a;

        /* JADX INFO: renamed from: b */
        public TextView f966b;

        /* JADX INFO: renamed from: c */
        public SwitchCompat f967c;

        /* JADX INFO: renamed from: d */
        public ImageView f968d;

        /* JADX INFO: renamed from: e */
        public View f969e;

        public a(View view) {
            super(view);
            this.f965a = (TextView) view.findViewById(C3896R.id.group_name);
            this.f967c = (SwitchCompat) view.findViewById(C3896R.id.consent_switch);
            this.f966b = (TextView) view.findViewById(C3896R.id.alwaysActiveText);
            this.f969e = view.findViewById(C3896R.id.view3);
            this.f968d = (ImageView) view.findViewById(C3896R.id.show_more);
        }
    }

    public C0134b(Context context, C0171c c0171c, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, C0002a c0002a, InterfaceC0075c interfaceC0075c, OTConfiguration oTConfiguration) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONObject jSONObject;
        this.f962l = c0171c;
        this.f954d = c0171c.m974b();
        this.f955e = context;
        this.f953c = oTPublishersHeadlessSDK;
        this.f956f = c0002a;
        this.f951a = interfaceC0075c;
        this.f958h = c0171c.m962a();
        this.f952b = oTConfiguration;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        String string = (z ? sharedPreferencesC0047f : sharedPreferences).getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.m2743a(3, "IAB2V2Flow", "Getting vendorCountForCategoryString = " + string);
        if (C0048h.m305b(string)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTSPUtils", "Error on getting vendor count for categories : " + e.getMessage());
                jSONObject = new JSONObject();
            }
        }
        this.f964n = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m697a(JSONObject jSONObject, a aVar, String str, View view) {
        try {
            if (jSONObject.has("SubGroups")) {
                JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
                boolean zIsChecked = aVar.f967c.isChecked();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("CustomGroupId");
                    if (jSONObject2.optBoolean("HasConsentOptOut", false)) {
                        m701a(zIsChecked, string);
                        this.f953c.updatePurposeConsent(string, zIsChecked);
                    }
                }
            }
            m701a(aVar.f967c.isChecked(), str);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error in setting subgroup consent parent " + e.getMessage());
        }
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 4) {
            notifyDataSetChanged();
        }
        InterfaceC0075c interfaceC0075c = this.f951a;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m702b(SwitchCompat switchCompat) {
        Context context = this.f955e;
        String str = this.f959i;
        String str2 = this.f960j;
        if (C0048h.m305b(str)) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(context, C3896R.color.light_greyOT));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        switchCompat.getThumbDrawable().setTint(!C0048h.m305b(str2) ? Color.parseColor(str2) : ContextCompat.getColor(context, C3896R.color.contentTextColorOT));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f954d.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_preference_center_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m696a(JSONObject jSONObject, a aVar, CompoundButton compoundButton, boolean z) {
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f953c.updatePurposeConsent(string, z);
            OTLogger.m2743a(3, "OTPCGroupsAdapter", "updated consent of group : " + string + ":" + this.f953c.getPurposeConsentLocal(string));
            C0003b c0003b = new C0003b(7);
            c0003b.f3b = string;
            c0003b.f4c = z ? 1 : 0;
            C0002a c0002a = this.f956f;
            if (c0002a != null) {
                c0002a.m0a(c0003b);
            } else {
                OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z) {
                m702b(aVar.f967c);
            } else {
                m700a(aVar.f967c);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while updating parent " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m695a(int i, JSONObject jSONObject, View view) {
        if (this.f957g.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("SUBGROUP_ARRAY", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        if (jSONObject.has("SubGroups")) {
            bundle.putInt("PARENT_POSITION", i);
        }
        bundle.putString("sdkLevelOptOutShow", this.f962l.f1480G);
        this.f957g.setArguments(bundle);
        this.f957g.show(((FragmentActivity) this.f955e).getSupportFragmentManager(), OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, int i) {
        try {
            final int adapterPosition = aVar.getAdapterPosition();
            final JSONObject jSONObject = this.f954d.getJSONObject(adapterPosition);
            C0126t c0126t = this.f958h;
            this.f959i = c0126t.f834e;
            this.f960j = c0126t.f832c;
            this.f961k = c0126t.f833d;
            String str = this.f962l.f1504s;
            if (!C0048h.m305b(str)) {
                C0074f.m400a(aVar.f968d, str);
            }
            int i2 = 0;
            boolean zOptBoolean = jSONObject.optBoolean("HasConsentOptOut", false);
            final String string = jSONObject.getString("CustomGroupId");
            C0069a c0069a = this.f962l.f1508w;
            m699a(aVar.f966b, c0069a.mo376a(), c0069a);
            C0171c c0171c = this.f962l;
            C0069a c0069a2 = c0171c.f1509x;
            TextView textView = aVar.f965a;
            C0074f c0074f = this.f963m;
            m699a(textView, c0074f.m410a(this.f964n, jSONObject, c0171c.f1485L, c0171c.f1484K, c0074f.m409a(jSONObject)), c0069a2);
            C0170b.m953a(aVar.f969e, this.f962l.f1505t);
            if (aVar.getAdapterPosition() == 0) {
                OTLogger.m2743a(3, "OT_Automation", "setLineBreakColor PC List: " + this.f962l.f1505t);
            }
            if (this.f954d.getJSONObject(adapterPosition).getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
                aVar.f967c.setVisibility(8);
                aVar.f966b.setVisibility(0);
            } else {
                aVar.f966b.setVisibility(4);
                if (zOptBoolean) {
                    aVar.f967c.setVisibility(0);
                } else {
                    aVar.f967c.setVisibility(8);
                }
            }
            aVar.f967c.setOnCheckedChangeListener(null);
            aVar.f967c.setOnClickListener(null);
            aVar.f967c.setContentDescription(this.f962l.f1481H);
            aVar.f965a.setLabelFor(C3896R.id.consent_switch);
            aVar.f967c.setChecked(this.f953c.getPurposeConsentLocal(string) == 1);
            if (this.f953c.getPurposeConsentLocal(string) == 1) {
                m702b(aVar.f967c);
            } else {
                m700a(aVar.f967c);
            }
            aVar.f967c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.b$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m697a(jSONObject, aVar, string, view);
                }
            });
            aVar.f967c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.b$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.m696a(jSONObject, aVar, compoundButton, z);
                }
            });
            C0002a c0002a = this.f956f;
            OTConfiguration oTConfiguration = this.f952b;
            C0171c c0171c2 = this.f962l;
            ViewOnClickListenerC0158d viewOnClickListenerC0158d = new ViewOnClickListenerC0158d();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
            viewOnClickListenerC0158d.setArguments(bundle);
            viewOnClickListenerC0158d.f1209X = c0002a;
            viewOnClickListenerC0158d.f1231j0 = oTConfiguration;
            viewOnClickListenerC0158d.f1235l0 = c0171c2;
            this.f957g = viewOnClickListenerC0158d;
            viewOnClickListenerC0158d.f1190E = this;
            viewOnClickListenerC0158d.f1189D = this.f953c;
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.b$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m695a(adapterPosition, jSONObject, view);
                }
            });
            View view = aVar.f969e;
            if (i == this.f954d.length() - 1) {
                i2 = 8;
            }
            view.setVisibility(i2);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error in rendering groups " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m700a(SwitchCompat switchCompat) {
        Context context = this.f955e;
        String str = this.f959i;
        String str2 = this.f961k;
        if (C0048h.m305b(str)) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(context, C3896R.color.light_greyOT));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        switchCompat.getThumbDrawable().setTint(!C0048h.m305b(str2) ? Color.parseColor(str2) : ContextCompat.getColor(context, C3896R.color.contentTextColorOT));
    }

    /* JADX INFO: renamed from: a */
    public final void m699a(TextView textView, String str, C0069a c0069a) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        textView.setText(str);
        textView.setTextColor(Color.parseColor(c0069a.mo378b()));
        if (!C0048h.m305b(c0069a.f231o)) {
            textView.setTextSize(Float.parseFloat(c0069a.f231o));
        }
        C0074f.m401a(textView, c0069a.f230n);
        textView.setVisibility(c0069a.f229m);
        C0115i c0115i = c0069a.f728a;
        OTConfiguration oTConfiguration = this.f952b;
        String str2 = c0115i.f753d;
        if (!C0048h.m305b(str2) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) != null) {
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
    public final void m701a(boolean z, String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        Context context = this.f955e;
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            sharedPreferencesC0047f = null;
            z2 = false;
        }
        if (z2) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        new C0046e(context);
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray(jSONObject.get(str).toString());
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e.getMessage());
            }
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f953c.updateSDKConsentStatus(jSONArray.get(i).toString(), z);
        }
    }
}
