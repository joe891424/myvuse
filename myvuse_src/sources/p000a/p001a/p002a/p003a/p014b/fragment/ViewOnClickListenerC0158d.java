package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.C0133a;
import p000a.p001a.p002a.p003a.p014b.adapter.InterfaceC0138f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p021e.C0125s;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;
import p000a.p001a.p002a.p003a.p014b.p025i.C0172d;

/* JADX INFO: renamed from: a.a.a.a.b.h.d */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0158d extends BottomSheetDialogFragment implements View.OnClickListener, C0133a.a, InterfaceC0075c, InterfaceC0138f {

    /* JADX INFO: renamed from: A */
    public BottomSheetDialog f1186A;

    /* JADX INFO: renamed from: B */
    public C0133a f1187B;

    /* JADX INFO: renamed from: C */
    public Context f1188C;

    /* JADX INFO: renamed from: D */
    public OTPublishersHeadlessSDK f1189D;

    /* JADX INFO: renamed from: E */
    public InterfaceC0075c f1190E;

    /* JADX INFO: renamed from: F */
    public SwitchCompat f1191F;

    /* JADX INFO: renamed from: G */
    public SwitchCompat f1192G;

    /* JADX INFO: renamed from: H */
    public SwitchCompat f1193H;

    /* JADX INFO: renamed from: I */
    public SwitchCompat f1194I;

    /* JADX INFO: renamed from: J */
    public SwitchCompat f1195J;

    /* JADX INFO: renamed from: K */
    public SwitchCompat f1196K;

    /* JADX INFO: renamed from: L */
    public RecyclerView f1197L;

    /* JADX INFO: renamed from: M */
    public RelativeLayout f1198M;

    /* JADX INFO: renamed from: N */
    public RelativeLayout f1199N;

    /* JADX INFO: renamed from: O */
    public String f1200O;

    /* JADX INFO: renamed from: P */
    public String f1201P;

    /* JADX INFO: renamed from: Q */
    public String f1202Q;

    /* JADX INFO: renamed from: R */
    public FrameLayout f1203R;

    /* JADX INFO: renamed from: S */
    public int f1204S;

    /* JADX INFO: renamed from: T */
    public ImageView f1205T;

    /* JADX INFO: renamed from: U */
    public TextView f1206U;

    /* JADX INFO: renamed from: V */
    public OTVendorListFragment f1207V;

    /* JADX INFO: renamed from: W */
    public OTSDKListFragment f1208W;

    /* JADX INFO: renamed from: Y */
    public boolean f1210Y;

    /* JADX INFO: renamed from: Z */
    public boolean f1211Z;

    /* JADX INFO: renamed from: a */
    public boolean f1212a;

    /* JADX INFO: renamed from: a0 */
    public boolean f1213a0;

    /* JADX INFO: renamed from: b */
    public TextView f1214b;

    /* JADX INFO: renamed from: b0 */
    public boolean f1215b0;

    /* JADX INFO: renamed from: c */
    public TextView f1216c;

    /* JADX INFO: renamed from: c0 */
    public JSONObject f1217c0;

    /* JADX INFO: renamed from: d */
    public TextView f1218d;

    /* JADX INFO: renamed from: d0 */
    public JSONObject f1219d0;

    /* JADX INFO: renamed from: e */
    public TextView f1220e;

    /* JADX INFO: renamed from: e0 */
    public String f1221e0;

    /* JADX INFO: renamed from: f */
    public TextView f1222f;

    /* JADX INFO: renamed from: f0 */
    public C0074f f1223f0;

    /* JADX INFO: renamed from: g */
    public TextView f1224g;

    /* JADX INFO: renamed from: h */
    public TextView f1226h;

    /* JADX INFO: renamed from: h0 */
    public String f1227h0;

    /* JADX INFO: renamed from: i */
    public TextView f1228i;

    /* JADX INFO: renamed from: i0 */
    public C0125s f1229i0;

    /* JADX INFO: renamed from: j */
    public TextView f1230j;

    /* JADX INFO: renamed from: j0 */
    public OTConfiguration f1231j0;

    /* JADX INFO: renamed from: k */
    public TextView f1232k;

    /* JADX INFO: renamed from: k0 */
    public C0124r f1233k0;

    /* JADX INFO: renamed from: l */
    public TextView f1234l;

    /* JADX INFO: renamed from: l0 */
    public C0171c f1235l0;

    /* JADX INFO: renamed from: m */
    public TextView f1236m;

    /* JADX INFO: renamed from: m0 */
    public C0172d f1237m0;

    /* JADX INFO: renamed from: n */
    public TextView f1238n;

    /* JADX INFO: renamed from: n0 */
    public String f1239n0;

    /* JADX INFO: renamed from: o */
    public TextView f1240o;

    /* JADX INFO: renamed from: p */
    public TextView f1241p;

    /* JADX INFO: renamed from: q */
    public TextView f1242q;

    /* JADX INFO: renamed from: r */
    public TextView f1243r;

    /* JADX INFO: renamed from: s */
    public TextView f1244s;

    /* JADX INFO: renamed from: t */
    public TextView f1245t;

    /* JADX INFO: renamed from: u */
    public TextView f1246u;

    /* JADX INFO: renamed from: v */
    public TextView f1247v;

    /* JADX INFO: renamed from: w */
    public TextView f1248w;

    /* JADX INFO: renamed from: x */
    public TextView f1249x;

    /* JADX INFO: renamed from: y */
    public TextView f1250y;

    /* JADX INFO: renamed from: z */
    public TextView f1251z;

    /* JADX INFO: renamed from: X */
    public C0002a f1209X = new C0002a();

    /* JADX INFO: renamed from: g0 */
    public Map<String, String> f1225g0 = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m802a(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.f1186A = (BottomSheetDialog) dialogInterface;
        this.f1223f0.m414a(getActivity(), this.f1186A);
        this.f1186A.setCancelable(false);
        BottomSheetDialog bottomSheetDialog = this.f1186A;
        if (bottomSheetDialog != null && (jSONObject = this.f1217c0) != null) {
            bottomSheetDialog.setTitle(this.f1223f0.m409a(jSONObject));
        }
        this.f1186A.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m806a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m803a(View view, int i, View view2) {
        view.setVisibility(i);
    }

    /* JADX INFO: renamed from: a */
    public static void m805a(List<String> list, JSONObject jSONObject) {
        if (!jSONObject.optBoolean("ShowSubgroup", false) || jSONObject.getJSONArray("FirstPartyCookies").length() > 0) {
            list.add(jSONObject.getString("CustomGroupId"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m806a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        m821b(4);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m807b(String str, View view) {
        try {
            m817a(str, this.f1196K.isChecked(), this.f1196K);
            SwitchCompat switchCompat = this.f1196K;
            JSONArray jSONArrayOptJSONArray = this.f1217c0.optJSONArray("FirstPartyCookies");
            if (!C0032d.m239a(jSONArrayOptJSONArray) && jSONArrayOptJSONArray.length() > 0) {
                m819a(switchCompat.isChecked(), str);
            }
            m814a(this.f1196K, false);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error in setting subgroup consent parent for parentGroupConsentToggleNonIab " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m808c(String str, View view) {
        try {
            m822b(str, this.f1192G.isChecked(), this.f1192G);
            m814a(this.f1192G, true);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error in setting subgroup consent parent for parentGroupLegitIntToggle " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public /* synthetic */ void m809d(String str, View view) {
        m817a(str, this.f1193H.isChecked(), this.f1193H);
        m819a(this.f1193H.isChecked(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public /* synthetic */ void m810e(String str, View view) {
        m817a(str, this.f1195J.isChecked(), this.f1195J);
        m819a(this.f1195J.isChecked(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public /* synthetic */ void m811f(String str, View view) {
        m822b(str, this.f1194I.isChecked(), this.f1194I);
    }

    @Override // p000a.p001a.p002a.p003a.p014b.adapter.InterfaceC0138f
    /* JADX INFO: renamed from: a */
    public void mo711a() {
        m823c();
        C0133a c0133a = this.f1187B;
        if (c0133a != null) {
            c0133a.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m815a(String str) {
        TextView textView;
        int i;
        if (str == null || C0048h.m305b(str)) {
            textView = this.f1224g;
            i = 8;
        } else {
            this.f1223f0.m412a(this.f1188C, this.f1224g, str);
            textView = this.f1224g;
            i = 0;
        }
        m803a(textView, i, (View) null);
    }

    /* JADX INFO: renamed from: a */
    public void m816a(String str, int i, boolean z, boolean z2) {
        SwitchCompat switchCompat;
        if (z2) {
            this.f1192G.setChecked(z);
            this.f1189D.updatePurposeLegitInterest(str, z);
            switchCompat = this.f1192G;
        } else if (this.f1212a) {
            this.f1191F.setChecked(z);
            this.f1189D.updatePurposeConsent(str, z);
            switchCompat = this.f1191F;
        } else {
            this.f1196K.setChecked(z);
            this.f1189D.updatePurposeConsent(str, z);
            switchCompat = this.f1196K;
        }
        m818a(z, switchCompat);
    }

    /* JADX INFO: renamed from: a */
    public final void m818a(boolean z, SwitchCompat switchCompat) {
        C0074f c0074f;
        Context context;
        String str;
        String str2;
        if (z) {
            c0074f = this.f1223f0;
            context = this.f1188C;
            C0125s c0125s = this.f1237m0.f1521j;
            str = c0125s.f806e;
            str2 = c0125s.f804c;
        } else {
            c0074f = this.f1223f0;
            context = this.f1188C;
            C0125s c0125s2 = this.f1237m0.f1521j;
            str = c0125s2.f806e;
            str2 = c0125s2.f805d;
        }
        c0074f.m413a(context, switchCompat, str, str2);
    }

    /* JADX INFO: renamed from: b */
    public void m821b(int i) {
        dismiss();
        InterfaceC0075c interfaceC0075c = this.f1190E;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m824d() {
        final String str = this.f1237m0.f1515d;
        this.f1191F.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m804a(str, view);
            }
        });
        this.f1196K.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m807b(str, view);
            }
        });
        this.f1192G.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m808c(str, view);
            }
        });
        this.f1193H.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m809d(str, view);
            }
        });
        this.f1195J.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m810e(str, view);
            }
        });
        m825e();
    }

    /* JADX INFO: renamed from: e */
    public final void m825e() {
        C0074f c0074f;
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        final String str3 = this.f1237m0.f1515d;
        this.f1194I.setChecked(this.f1189D.getPurposeLegitInterestLocal(str3) == 1);
        if (this.f1189D.getPurposeLegitInterestLocal(str3) == 1) {
            c0074f = this.f1223f0;
            context = this.f1188C;
            switchCompat = this.f1194I;
            C0125s c0125s = this.f1237m0.f1521j;
            str = c0125s.f806e;
            str2 = c0125s.f804c;
        } else {
            c0074f = this.f1223f0;
            context = this.f1188C;
            switchCompat = this.f1194I;
            C0125s c0125s2 = this.f1237m0.f1521j;
            str = c0125s2.f806e;
            str2 = c0125s2.f805d;
        }
        c0074f.m413a(context, switchCompat, str, str2);
        this.f1194I.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m811f(str3, view);
            }
        });
    }

    /* JADX INFO: renamed from: f */
    public final void m826f() {
        TextView textView = this.f1232k;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.f1240o;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.f1242q;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.f1243r;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        this.f1247v.setPaintFlags(this.f1243r.getPaintFlags() | 8);
        TextView textView5 = this.f1228i;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        TextView textView6 = this.f1238n;
        textView6.setPaintFlags(textView6.getPaintFlags() | 8);
        TextView textView7 = this.f1241p;
        textView7.setPaintFlags(textView7.getPaintFlags() | 8);
        TextView textView8 = this.f1246u;
        textView8.setPaintFlags(textView8.getPaintFlags() | 8);
        TextView textView9 = this.f1245t;
        textView9.setPaintFlags(textView9.getPaintFlags() | 8);
        TextView textView10 = this.f1244s;
        textView10.setPaintFlags(textView10.getPaintFlags() | 8);
        TextView textView11 = this.f1248w;
        textView11.setPaintFlags(textView11.getPaintFlags() | 8);
        TextView textView12 = this.f1249x;
        textView12.setPaintFlags(textView12.getPaintFlags() | 8);
    }

    /* JADX INFO: renamed from: g */
    public final void m827g() {
        C0125s c0125s = this.f1229i0;
        String str = c0125s.f811j.f726e;
        String str2 = c0125s.f812k.f726e;
        this.f1191F.setContentDescription(str);
        this.f1193H.setContentDescription(str);
        this.f1195J.setContentDescription(str);
        this.f1196K.setContentDescription(str);
        this.f1194I.setContentDescription(str2);
        this.f1192G.setContentDescription(str2);
    }

    /* JADX INFO: renamed from: h */
    public void m828h() {
        TextView textView;
        if (!this.f1215b0 || this.f1202Q == null || !C0172d.m980b(this.f1217c0)) {
            m803a(this.f1244s, 8, (View) null);
            m803a(this.f1245t, 8, (View) null);
        } else {
            if (this.f1202Q.equals(ViewProps.BOTTOM)) {
                m803a(this.f1249x, 0, (View) null);
                m803a(this.f1244s, 8, (View) null);
                textView = this.f1245t;
                m803a(textView, 8, (View) null);
            }
            if (!this.f1202Q.equals(ViewProps.TOP)) {
                return;
            }
            m803a(this.f1244s, 0, (View) null);
            m803a(this.f1245t, 0, (View) null);
        }
        m803a(this.f1248w, 8, (View) null);
        textView = this.f1249x;
        m803a(textView, 8, (View) null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3896R.id.back_to_pc) {
            m821b(4);
            return;
        }
        boolean z = false;
        z = false;
        if (id == C3896R.id.vendors_list_link || id == C3896R.id.vendors_list_link_below || id == C3896R.id.vendors_list_link_parent || id == C3896R.id.vendors_list_link_parent_below_combined) {
            if (this.f1207V.isAdded() || getActivity() == null) {
                return;
            }
            try {
                if (!this.f1217c0.optBoolean("IsIabPurpose") && C0172d.m979a(this.f1217c0)) {
                    z = true;
                }
                Bundle bundleM981a = z ? this.f1237m0.m981a(this.f1225g0) : this.f1237m0.m983b(this.f1225g0);
                bundleM981a.putBoolean("generalVendors", z);
                this.f1207V.setArguments(bundleM981a);
                OTVendorListFragment oTVendorListFragment = this.f1207V;
                oTVendorListFragment.f1401f = this;
                oTVendorListFragment.show(getActivity().getSupportFragmentManager(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                this.f1223f0.m411a(new C0003b(12), this.f1209X);
                return;
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTPCDetail", "error thrown onClick: Vendor list link " + e);
                return;
            }
        }
        if (id == C3896R.id.view_legal_text || id == C3896R.id.view_legal_text_below || id == C3896R.id.view_legal_text_parent || id == C3896R.id.view_legal_text_parent_below_combined || id == C3896R.id.view_legal_text_parent_below) {
            C0048h.m304b(this.f1188C, this.f1237m0.f1519h);
            return;
        }
        if ((id != C3896R.id.sdk_list_link && id != C3896R.id.sdk_list_link_child && id != C3896R.id.sdk_list_link_child_below && id != C3896R.id.sdk_list_link_parent_below_combined) || this.f1208W.isAdded() || getActivity() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        try {
            ArrayList arrayList = new ArrayList();
            m805a(arrayList, this.f1217c0);
            if (this.f1217c0.has("SubGroups") && this.f1217c0.optBoolean("ShowSubgroup", false)) {
                JSONArray jSONArray = this.f1217c0.getJSONArray("SubGroups");
                for (int i = 0; i < jSONArray.length(); i++) {
                    m805a(arrayList, jSONArray.getJSONObject(i));
                }
            }
            bundle.putString("OT_GROUP_ID_LIST", arrayList.toString());
            bundle.putString("GroupName", this.f1217c0.getString("GroupName"));
            bundle.putString("CustomGroupId", this.f1217c0.getString("CustomGroupId"));
            bundle.putString("sdkLevelOptOutShow", this.f1239n0);
            bundle.putString("SDK_LIST_VIEW_TITLE", this.f1229i0.f814m.f755a.f726e);
            bundle.putString("ALWAYS_ACTIVE_TEXT", this.f1229i0.f813l.f726e);
            bundle.putString("ALWAYS_ACTIVE_TEXT_COLOR", this.f1229i0.f813l.f724c);
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OTPCDetail", "error in passing sdklist : " + e2.getMessage());
        }
        this.f1208W.setArguments(bundle);
        this.f1208W.show(getActivity().getSupportFragmentManager(), OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1223f0.m414a(getActivity(), this.f1186A);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.f1189D == null) {
            this.f1189D = new OTPublishersHeadlessSDK(applicationContext);
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (C0048h.m305b(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!C0048h.m305b(string2)) {
                    str = string2;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.m2743a(3, "OneTrust", "set theme to OT defined theme ");
            setStyle(0, C3896R.style.OTSDKTheme);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.d$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m802a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        this.f1188C = getContext();
        OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1209X, this.f1231j0);
        this.f1207V = oTVendorListFragmentM930a;
        oTVendorListFragmentM930a.m914a(this.f1189D);
        OTConfiguration oTConfiguration = this.f1231j0;
        Intrinsics.checkNotNullParameter(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG, "fragmentTag");
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.m5605to(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG));
        OTSDKListFragment oTSDKListFragment = new OTSDKListFragment();
        oTSDKListFragment.setArguments(bundleBundleOf);
        oTSDKListFragment.f1320d = oTConfiguration;
        this.f1208W = oTSDKListFragment;
        Intrinsics.checkNotNullParameter(this, "listener");
        oTSDKListFragment.f1322f = this;
        OTSDKListFragment oTSDKListFragment2 = this.f1208W;
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f1189D;
        oTSDKListFragment2.getClass();
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        oTSDKListFragment2.f1319c = otPublishersHeadlessSDK;
        this.f1223f0 = new C0074f();
        Bundle arguments = getArguments();
        this.f1237m0 = new C0172d();
        if (arguments != null) {
            string = arguments.getString("SUBGROUP_ARRAY");
            this.f1204S = arguments.getInt("PARENT_POSITION");
            this.f1239n0 = arguments.getString("sdkLevelOptOutShow");
        } else {
            string = "";
        }
        int iM394a = C0074f.m394a(this.f1188C, this.f1231j0);
        C0172d c0172d = this.f1237m0;
        Context context = this.f1188C;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f1189D;
        c0172d.getClass();
        if (!C0048h.m305b(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                c0172d.f1512a = jSONObject;
                c0172d.f1516e = jSONObject.optBoolean("ShowSubgroup", false);
                c0172d.f1517f = c0172d.f1512a.optBoolean("ShowSubgroupToggle", false);
                c0172d.f1518g = c0172d.f1512a.optBoolean("ShowSubGroupDescription", false);
                c0172d.f1513b = c0172d.f1512a.optString("Type", "");
                c0172d.f1514c = c0172d.f1512a.optString("Type").equalsIgnoreCase("IAB2_STACK");
                c0172d.f1515d = c0172d.f1512a.optString("CustomGroupId");
                C0130x c0130x = new C0130x(context, iM394a);
                c0172d.f1521j = c0130x.m673b();
                c0172d.f1522k = c0130x.f880a.m622b();
                JSONObject preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData();
                if (preferenceCenterData != null) {
                    c0172d.f1519h = preferenceCenterData.optString("IabLegalTextUrl");
                    c0172d.f1523l = oTPublishersHeadlessSDK;
                    c0172d.f1524m = context;
                    c0172d.f1520i = preferenceCenterData.optString("PCGrpDescType", "");
                    C0106b0 c0106b0 = c0172d.f1521j.f813l;
                    if (C0048h.m305b(c0106b0.f726e)) {
                        c0106b0.f726e = preferenceCenterData.optString("AlwaysActiveText", "");
                    }
                    if (C0048h.m305b(c0106b0.f724c)) {
                        String str = c0106b0.f724c;
                        String strOptString = preferenceCenterData.optString("PcLinksTextColor");
                        if (C0048h.m305b(str)) {
                            str = !C0048h.m305b(strOptString) ? strOptString : "#3860BE";
                        }
                        c0106b0.f724c = str;
                    }
                    C0125s c0125s = c0172d.f1521j;
                    c0125s.f813l = c0106b0;
                    if (C0048h.m305b(c0125s.f807f)) {
                        c0172d.f1521j.f807f = preferenceCenterData.getString("PcTextColor");
                    }
                    if (C0048h.m305b(c0172d.f1521j.f802a)) {
                        c0172d.f1521j.f802a = preferenceCenterData.getString("PcBackgroundColor");
                    }
                    if (C0048h.m305b(c0172d.f1521j.f806e)) {
                        c0172d.f1521j.f806e = "#d1d1d1";
                    }
                    if (C0048h.m305b(c0172d.f1521j.f804c)) {
                        c0172d.f1521j.f804c = "#67B54B";
                    }
                    if (C0048h.m305b(c0172d.f1521j.f805d)) {
                        c0172d.f1521j.f805d = "#788381";
                    }
                    C0172d.m976a(c0172d.f1521j.f808g, c0172d.f1512a, preferenceCenterData, "PcTextColor");
                    C0172d.m976a(c0172d.f1521j.f809h, c0172d.f1512a, preferenceCenterData, "PcTextColor");
                    C0106b0 c0106b02 = c0172d.f1521j.f811j;
                    String strOptString2 = preferenceCenterData.optString("BConsentText");
                    if (C0048h.m305b(c0106b02.f724c)) {
                        c0106b02.f724c = preferenceCenterData.optString("PcTextColor");
                    }
                    c0106b02.f726e = strOptString2;
                    C0106b0 c0106b03 = c0172d.f1521j.f812k;
                    String strOptString3 = preferenceCenterData.optString("BLegitInterestText");
                    if (C0048h.m305b(c0106b03.f724c)) {
                        c0106b03.f724c = preferenceCenterData.optString("PcTextColor");
                    }
                    c0106b03.f726e = strOptString3;
                    C0172d.m977a(c0172d.f1521j.f814m, preferenceCenterData.optString("ThirdPartyCookieListText", "First Party Cookies"), preferenceCenterData, "PcLinksTextColor");
                    C0172d.m977a(c0172d.f1521j.f815n, preferenceCenterData.getString("VendorListText"), preferenceCenterData, "PcLinksTextColor");
                    C0172d.m977a(c0172d.f1521j.f816o, preferenceCenterData.optString("PCVendorFullLegalText", ""), preferenceCenterData, "PcLinksTextColor");
                    c0172d.f1521j.f817p.f754a = preferenceCenterData.optString("PCenterBackText");
                    c0172d.f1521j.f816o.f759e = preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel");
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "PC Detail", "No Data found to initialize PC Detail Config, " + e);
            }
        }
        this.f1217c0 = this.f1237m0.f1512a;
        if (this.f1235l0 == null) {
            C0171c c0171c = new C0171c();
            this.f1235l0 = c0171c;
            if (!c0171c.m973a(this.f1189D, this.f1188C, iM394a)) {
                dismiss();
                return null;
            }
        }
        C0171c c0171c2 = this.f1235l0;
        if (c0171c2 != null) {
            this.f1210Y = c0171c2.f1500o;
        }
        C0172d c0172d2 = this.f1237m0;
        this.f1229i0 = c0172d2.f1521j;
        this.f1233k0 = c0172d2.f1522k;
        View viewM406a = this.f1223f0.m406a(this.f1188C, layoutInflater, viewGroup, C3896R.layout.ot_preference_center_details_fragment);
        this.f1199N = (RelativeLayout) viewM406a.findViewById(C3896R.id.main_sub_layout);
        this.f1214b = (TextView) viewM406a.findViewById(C3896R.id.parent_group_name);
        this.f1224g = (TextView) viewM406a.findViewById(C3896R.id.parent_group_desc);
        this.f1222f = (TextView) viewM406a.findViewById(C3896R.id.sub_group_name);
        this.f1226h = (TextView) viewM406a.findViewById(C3896R.id.sub_group_desc);
        this.f1203R = (FrameLayout) viewM406a.findViewById(C3896R.id.group_layout);
        this.f1198M = (RelativeLayout) viewM406a.findViewById(C3896R.id.pc_details_main_layout);
        this.f1218d = (TextView) viewM406a.findViewById(C3896R.id.tv_consent);
        this.f1220e = (TextView) viewM406a.findViewById(C3896R.id.tv_legit_Int);
        this.f1191F = (SwitchCompat) viewM406a.findViewById(C3896R.id.parent_group_consent_toggle);
        this.f1193H = (SwitchCompat) viewM406a.findViewById(C3896R.id.consent_toggle);
        this.f1194I = (SwitchCompat) viewM406a.findViewById(C3896R.id.legitInt_toggle);
        this.f1205T = (ImageView) viewM406a.findViewById(C3896R.id.back_to_pc);
        this.f1228i = (TextView) viewM406a.findViewById(C3896R.id.vendors_list_link);
        this.f1232k = (TextView) viewM406a.findViewById(C3896R.id.view_legal_text);
        this.f1216c = (TextView) viewM406a.findViewById(C3896R.id.parent_tv_consent);
        this.f1230j = (TextView) viewM406a.findViewById(C3896R.id.parent_tv_legit_Int);
        this.f1192G = (SwitchCompat) viewM406a.findViewById(C3896R.id.parent_group_li_toggle);
        this.f1195J = (SwitchCompat) viewM406a.findViewById(C3896R.id.consent_toggle_non_iab);
        this.f1196K = (SwitchCompat) viewM406a.findViewById(C3896R.id.parent_consent_toggle_non_iab);
        this.f1197L = (RecyclerView) viewM406a.findViewById(C3896R.id.rv_pc_details);
        this.f1236m = (TextView) viewM406a.findViewById(C3896R.id.alwaysActiveText);
        this.f1234l = (TextView) viewM406a.findViewById(C3896R.id.alwaysActiveTextChild);
        this.f1250y = (TextView) viewM406a.findViewById(C3896R.id.alwaysActiveText_non_iab);
        this.f1238n = (TextView) viewM406a.findViewById(C3896R.id.vendors_list_link_below);
        this.f1240o = (TextView) viewM406a.findViewById(C3896R.id.view_legal_text_below);
        this.f1241p = (TextView) viewM406a.findViewById(C3896R.id.vendors_list_link_parent);
        this.f1242q = (TextView) viewM406a.findViewById(C3896R.id.view_legal_text_parent);
        this.f1243r = (TextView) viewM406a.findViewById(C3896R.id.view_legal_text_parent_below);
        this.f1244s = (TextView) viewM406a.findViewById(C3896R.id.sdk_list_link);
        this.f1245t = (TextView) viewM406a.findViewById(C3896R.id.sdk_list_link_child);
        this.f1248w = (TextView) viewM406a.findViewById(C3896R.id.sdk_list_link_parent_below_combined);
        this.f1249x = (TextView) viewM406a.findViewById(C3896R.id.sdk_list_link_child_below);
        this.f1246u = (TextView) viewM406a.findViewById(C3896R.id.vendors_list_link_parent_below_combined);
        this.f1247v = (TextView) viewM406a.findViewById(C3896R.id.view_legal_text_parent_below_combined);
        this.f1251z = (TextView) viewM406a.findViewById(C3896R.id.parent_alwaysActiveText_non_iab);
        this.f1206U = (TextView) viewM406a.findViewById(C3896R.id.view_powered_by_logo);
        this.f1197L.setHasFixedSize(true);
        this.f1197L.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f1205T.setOnClickListener(this);
        this.f1228i.setOnClickListener(this);
        this.f1232k.setOnClickListener(this);
        this.f1240o.setOnClickListener(this);
        this.f1238n.setOnClickListener(this);
        this.f1241p.setOnClickListener(this);
        this.f1242q.setOnClickListener(this);
        this.f1246u.setOnClickListener(this);
        this.f1247v.setOnClickListener(this);
        this.f1243r.setOnClickListener(this);
        this.f1244s.setOnClickListener(this);
        this.f1245t.setOnClickListener(this);
        this.f1248w.setOnClickListener(this);
        this.f1249x.setOnClickListener(this);
        try {
            m820b();
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OneTrust", "error in populating views with data " + e2.getMessage());
        }
        return viewM406a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1209X = null;
        this.f1190E = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m823c();
    }

    /* JADX INFO: renamed from: c */
    public final void m823c() {
        String str = this.f1237m0.f1515d;
        boolean z = this.f1189D.getPurposeConsentLocal(str) == 1;
        if (!this.f1212a) {
            this.f1196K.setChecked(z);
            m818a(z, this.f1196K);
            this.f1195J.setChecked(z);
            m818a(z, this.f1195J);
            return;
        }
        boolean z2 = this.f1189D.getPurposeLegitInterestLocal(str) == 1;
        this.f1191F.setChecked(z);
        this.f1192G.setChecked(z2);
        m818a(z, this.f1191F);
        m818a(z2, this.f1192G);
        this.f1193H.setChecked(z);
        m818a(z, this.f1193H);
        this.f1194I.setChecked(z2);
        m818a(z2, this.f1194I);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02e6  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m820b() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2123
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0158d.m820b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m804a(String str, View view) {
        try {
            m817a(str, this.f1191F.isChecked(), this.f1191F);
            SwitchCompat switchCompat = this.f1191F;
            JSONArray jSONArrayOptJSONArray = this.f1217c0.optJSONArray("FirstPartyCookies");
            if (!C0032d.m239a(jSONArrayOptJSONArray) && jSONArrayOptJSONArray.length() > 0) {
                m819a(switchCompat.isChecked(), str);
            }
            m814a(this.f1191F, false);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error in setting subgroup consent parent for parentGroupConsentToggle " + e.getMessage());
        }
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 1) {
            dismiss();
            InterfaceC0075c interfaceC0075c = this.f1190E;
            if (interfaceC0075c != null) {
                interfaceC0075c.mo419a(i);
            }
        }
        if (i == 3) {
            OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1209X, this.f1231j0);
            this.f1207V = oTVendorListFragmentM930a;
            oTVendorListFragmentM930a.m914a(this.f1189D);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m812a(C0106b0 c0106b0) {
        if (this.f1217c0.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) && C0048h.m305b(c0106b0.f726e)) {
            m803a(this.f1216c, 8, (View) null);
            m803a(this.f1236m, 8, (View) null);
            m803a(this.f1234l, 8, (View) null);
            m803a(this.f1218d, 8, (View) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m813a(TextView textView, C0106b0 c0106b0) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        textView.setText(c0106b0.f726e);
        textView.setTextColor(Color.parseColor(c0106b0.f724c));
        C0115i c0115i = c0106b0.f722a;
        OTConfiguration oTConfiguration = this.f1231j0;
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
        C0074f.m401a(textView, Integer.parseInt(c0106b0.f723b));
    }

    /* JADX INFO: renamed from: a */
    public final void m814a(SwitchCompat switchCompat, boolean z) throws JSONException {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        if (this.f1217c0.has("SubGroups")) {
            C0172d c0172d = this.f1237m0;
            JSONArray jSONArray = this.f1217c0.getJSONArray("SubGroups");
            boolean zIsChecked = switchCompat.isChecked();
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f1189D;
            c0172d.getClass();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                boolean zOptBoolean = jSONObject.optBoolean("HasConsentOptOut", false);
                String string = jSONObject.getString("CustomGroupId");
                if (z) {
                    if (oTPublishersHeadlessSDK.getPurposeLegitInterestLocal(string) >= 0) {
                        oTPublishersHeadlessSDK.updatePurposeLegitInterest(string, zIsChecked);
                    }
                } else if (zOptBoolean) {
                    oTPublishersHeadlessSDK.updatePurposeConsent(string, zIsChecked);
                    Context context = c0172d.f1524m;
                    new JSONObject();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                        sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z2 = true;
                    } else {
                        sharedPreferencesC0047f = null;
                        z2 = false;
                    }
                    if (z2) {
                        sharedPreferences = sharedPreferencesC0047f;
                    }
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                        new SharedPreferencesC0047f(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                    }
                    String string2 = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
                    JSONArray jSONArray2 = new JSONArray();
                    if (!C0048h.m305b(string2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string2);
                            if (jSONObject2.has(string)) {
                                jSONArray2 = new JSONArray(jSONObject2.get(string).toString());
                            }
                        } catch (JSONException e) {
                            OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e.getMessage());
                        }
                    }
                    OTLogger.m2743a(4, "PC Detail", "SDKs of group : " + string + " is " + jSONArray2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        try {
                            c0172d.f1523l.updateSDKConsentStatus(jSONArray2.get(i2).toString(), zIsChecked);
                        } catch (JSONException e2) {
                            OTLogger.m2743a(6, "OneTrust", "Error in setting group sdk status " + e2.getMessage());
                        }
                    }
                }
            }
            this.f1187B.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m817a(String str, boolean z, SwitchCompat switchCompat) {
        OTLogger.m2743a(3, "OTPCDetail", "Updating consent of parent :" + z);
        this.f1189D.updatePurposeConsent(str, z);
        C0003b c0003b = new C0003b(7);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        this.f1223f0.m411a(c0003b, this.f1209X);
        m818a(z, switchCompat);
    }

    /* JADX INFO: renamed from: a */
    public final void m819a(boolean z, String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        Context context = this.f1188C;
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
            try {
                this.f1189D.updateSDKConsentStatus(jSONArray.get(i).toString(), z);
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "OTPCDetail", "Error while Updating consent of SDK " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m822b(String str, boolean z, SwitchCompat switchCompat) {
        this.f1189D.updatePurposeLegitInterest(str, z);
        C0003b c0003b = new C0003b(11);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        this.f1223f0.m411a(c0003b, this.f1209X);
        m818a(z, switchCompat);
    }
}
