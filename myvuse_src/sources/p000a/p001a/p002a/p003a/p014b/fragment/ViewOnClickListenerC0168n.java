package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p009f.C0039c;
import p000a.p001a.p002a.p003a.p004a.p009f.InterfaceC0037a;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.adapter.C0145m;
import p000a.p001a.p002a.p003a.p014b.adapter.C0147o;
import p000a.p001a.p002a.p003a.p014b.adapter.C0148p;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p021e.C0131y;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: renamed from: a.a.a.a.b.h.n */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0168n extends BottomSheetDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    public RecyclerView f1421A;

    /* JADX INFO: renamed from: B */
    public RecyclerView f1422B;

    /* JADX INFO: renamed from: C */
    public RecyclerView f1423C;

    /* JADX INFO: renamed from: D */
    public RecyclerView f1424D;

    /* JADX INFO: renamed from: E */
    public RecyclerView f1425E;

    /* JADX INFO: renamed from: F */
    public RelativeLayout f1426F;

    /* JADX INFO: renamed from: G */
    public RelativeLayout f1427G;

    /* JADX INFO: renamed from: H */
    public LinearLayout f1428H;

    /* JADX INFO: renamed from: I */
    public LinearLayout f1429I;

    /* JADX INFO: renamed from: J */
    public String f1430J;

    /* JADX INFO: renamed from: K */
    public b f1431K;

    /* JADX INFO: renamed from: L */
    public View f1432L;

    /* JADX INFO: renamed from: M */
    public View f1433M;

    /* JADX INFO: renamed from: N */
    public String f1434N;

    /* JADX INFO: renamed from: O */
    public String f1435O;

    /* JADX INFO: renamed from: P */
    public String f1436P;

    /* JADX INFO: renamed from: Q */
    public String f1437Q;

    /* JADX INFO: renamed from: R */
    public String f1438R;

    /* JADX INFO: renamed from: S */
    public C0131y f1439S;

    /* JADX INFO: renamed from: T */
    public OTConfiguration f1440T;

    /* JADX INFO: renamed from: U */
    public C0124r f1441U;

    /* JADX INFO: renamed from: V */
    public C0074f f1442V;

    /* JADX INFO: renamed from: W */
    public C0002a f1443W;

    /* JADX INFO: renamed from: X */
    public TextView f1444X;

    /* JADX INFO: renamed from: Y */
    public C0171c f1445Y;

    /* JADX INFO: renamed from: a */
    public String f1446a;

    /* JADX INFO: renamed from: b */
    public TextView f1447b;

    /* JADX INFO: renamed from: c */
    public TextView f1448c;

    /* JADX INFO: renamed from: d */
    public TextView f1449d;

    /* JADX INFO: renamed from: e */
    public TextView f1450e;

    /* JADX INFO: renamed from: f */
    public TextView f1451f;

    /* JADX INFO: renamed from: g */
    public TextView f1452g;

    /* JADX INFO: renamed from: h */
    public TextView f1453h;

    /* JADX INFO: renamed from: i */
    public TextView f1454i;

    /* JADX INFO: renamed from: j */
    public TextView f1455j;

    /* JADX INFO: renamed from: k */
    public TextView f1456k;

    /* JADX INFO: renamed from: l */
    public TextView f1457l;

    /* JADX INFO: renamed from: m */
    public TextView f1458m;

    /* JADX INFO: renamed from: n */
    public TextView f1459n;

    /* JADX INFO: renamed from: o */
    public TextView f1460o;

    /* JADX INFO: renamed from: p */
    public TextView f1461p;

    /* JADX INFO: renamed from: q */
    public RecyclerView f1462q;

    /* JADX INFO: renamed from: r */
    public RelativeLayout f1463r;

    /* JADX INFO: renamed from: s */
    public BottomSheetDialog f1464s;

    /* JADX INFO: renamed from: t */
    public ImageView f1465t;

    /* JADX INFO: renamed from: u */
    public Context f1466u;

    /* JADX INFO: renamed from: v */
    public OTPublishersHeadlessSDK f1467v;

    /* JADX INFO: renamed from: w */
    public JSONObject f1468w;

    /* JADX INFO: renamed from: x */
    public SwitchCompat f1469x;

    /* JADX INFO: renamed from: y */
    public SwitchCompat f1470y;

    /* JADX INFO: renamed from: z */
    public RecyclerView f1471z;

    /* JADX INFO: renamed from: a.a.a.a.b.h.n$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo948a(JSONObject jSONObject);
    }

    /* JADX INFO: renamed from: a.a.a.a.b.h.n$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo929a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m931a(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.f1464s = (BottomSheetDialog) dialogInterface;
        this.f1442V.m414a(getActivity(), this.f1464s);
        this.f1464s.setCancelable(false);
        BottomSheetDialog bottomSheetDialog = this.f1464s;
        if (bottomSheetDialog != null && (jSONObject = this.f1468w) != null) {
            bottomSheetDialog.setTitle(jSONObject.optString("name"));
        }
        this.f1464s.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m935a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m933a(CompoundButton compoundButton, boolean z) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        this.f1467v.updateVendorConsent(OTVendorListMode.IAB, this.f1430J, z);
        C0074f c0074f = this.f1442V;
        if (z) {
            context = this.f1466u;
            switchCompat = this.f1469x;
            str = this.f1438R;
            str2 = this.f1436P;
        } else {
            context = this.f1466u;
            switchCompat = this.f1469x;
            str = this.f1438R;
            str2 = this.f1437Q;
        }
        c0074f.m413a(context, switchCompat, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void m937b(CompoundButton compoundButton, boolean z) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        this.f1467v.updateVendorLegitInterest(OTVendorListMode.IAB, this.f1430J, z);
        C0074f c0074f = this.f1442V;
        if (z) {
            context = this.f1466u;
            switchCompat = this.f1470y;
            str = this.f1438R;
            str2 = this.f1436P;
        } else {
            context = this.f1466u;
            switchCompat = this.f1470y;
            str = this.f1438R;
            str2 = this.f1437Q;
        }
        c0074f.m413a(context, switchCompat, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m938a() {
        if (!C0048h.m305b(this.f1439S.f890e.f722a.f751b)) {
            this.f1447b.setTextSize(Float.parseFloat(this.f1439S.f890e.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1439S.f893h.f722a.f751b)) {
            this.f1455j.setTextSize(Float.parseFloat(this.f1439S.f893h.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1439S.f894i.f722a.f751b)) {
            this.f1456k.setTextSize(Float.parseFloat(this.f1439S.f894i.f722a.f751b));
        }
        String str = this.f1439S.f895j.f755a.f722a.f751b;
        if (!C0048h.m305b(str)) {
            this.f1448c.setTextSize(Float.parseFloat(str));
        }
        if (!C0048h.m305b(this.f1439S.f891f.f722a.f751b)) {
            float f = Float.parseFloat(this.f1439S.f891f.f722a.f751b);
            this.f1449d.setTextSize(f);
            this.f1450e.setTextSize(f);
            this.f1452g.setTextSize(f);
            this.f1453h.setTextSize(f);
            this.f1451f.setTextSize(f);
            this.f1457l.setTextSize(f);
            this.f1460o.setTextSize(f);
            this.f1461p.setTextSize(f);
        }
        if (C0048h.m305b(this.f1439S.f892g.f722a.f751b)) {
            return;
        }
        float f2 = Float.parseFloat(this.f1439S.f892g.f722a.f751b);
        this.f1458m.setTextSize(f2);
        this.f1459n.setTextSize(f2);
    }

    /* JADX INFO: renamed from: a */
    public final void m939a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1447b.setTextColor(Color.parseColor(this.f1435O));
        this.f1454i.setTextColor(Color.parseColor(this.f1435O));
        this.f1455j.setTextColor(Color.parseColor(str2));
        this.f1456k.setTextColor(Color.parseColor(str3));
        this.f1427G.setBackgroundColor(Color.parseColor(str));
        this.f1426F.setBackgroundColor(Color.parseColor(str));
        this.f1429I.setBackgroundColor(Color.parseColor(str));
        this.f1428H.setBackgroundColor(Color.parseColor(str));
        this.f1465t.setColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC_IN);
        this.f1448c.setTextColor(Color.parseColor(str6));
        this.f1449d.setTextColor(Color.parseColor(str4));
        this.f1452g.setTextColor(Color.parseColor(str4));
        this.f1453h.setTextColor(Color.parseColor(str4));
        this.f1451f.setTextColor(Color.parseColor(str4));
        this.f1450e.setTextColor(Color.parseColor(str4));
        this.f1457l.setTextColor(Color.parseColor(str4));
        this.f1459n.setTextColor(Color.parseColor(this.f1434N));
        this.f1458m.setTextColor(Color.parseColor(this.f1434N));
        this.f1460o.setTextColor(Color.parseColor(str4));
        this.f1461p.setTextColor(Color.parseColor(str4));
    }

    /* JADX INFO: renamed from: b */
    public final void m941b() {
        if (!C0048h.m305b(this.f1439S.f890e.f723b)) {
            this.f1447b.setTextAlignment(Integer.parseInt(this.f1439S.f890e.f723b));
        }
        if (!C0048h.m305b(this.f1439S.f893h.f723b)) {
            this.f1455j.setTextAlignment(Integer.parseInt(this.f1439S.f893h.f723b));
        }
        if (!C0048h.m305b(this.f1439S.f894i.f723b)) {
            this.f1456k.setTextAlignment(Integer.parseInt(this.f1439S.f894i.f723b));
        }
        if (!C0048h.m305b(this.f1439S.f891f.f723b)) {
            int i = Integer.parseInt(this.f1439S.f891f.f723b);
            this.f1449d.setTextAlignment(i);
            this.f1451f.setTextAlignment(i);
            this.f1453h.setTextAlignment(i);
            this.f1452g.setTextAlignment(i);
            this.f1450e.setTextAlignment(i);
            this.f1457l.setTextAlignment(i);
            this.f1460o.setTextAlignment(i);
            this.f1461p.setTextAlignment(i);
        }
        if (C0048h.m305b(this.f1439S.f892g.f723b)) {
            return;
        }
        int i2 = Integer.parseInt(this.f1439S.f892g.f723b);
        this.f1458m.setTextAlignment(i2);
        this.f1459n.setTextAlignment(i2);
    }

    /* JADX INFO: renamed from: c */
    public final void m943c() {
        this.f1448c.setOnClickListener(this);
        this.f1465t.setOnClickListener(this);
        this.f1469x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m933a(compoundButton, z);
            }
        });
        this.f1470y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m937b(compoundButton, z);
            }
        });
        this.f1469x.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m932a(view);
            }
        });
        this.f1470y.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m936b(view);
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public final void m944c(JSONObject jSONObject) {
        try {
            int iM394a = C0074f.m394a(this.f1466u, this.f1440T);
            C0130x c0130x = new C0130x(this.f1466u, iM394a);
            this.f1439S = c0130x.m675c();
            this.f1441U = c0130x.f880a.m622b();
            m942b(jSONObject);
            String str = this.f1439S.f891f.f724c;
            String strOptString = jSONObject.optString("PcTextColor");
            String str2 = "#696969";
            String str3 = !C0048h.m305b(str) ? str : !C0048h.m305b(strOptString) ? strOptString : iM394a == 11 ? "#FFFFFF" : "#696969";
            String str4 = this.f1439S.f893h.f724c;
            String strOptString2 = jSONObject.optString("PcTextColor");
            if (C0048h.m305b(str4)) {
                str4 = !C0048h.m305b(strOptString2) ? strOptString2 : iM394a == 11 ? "#FFFFFF" : "#696969";
            }
            String str5 = this.f1439S.f894i.f724c;
            String strOptString3 = jSONObject.optString("PcTextColor");
            if (C0048h.m305b(str5)) {
                str5 = !C0048h.m305b(strOptString3) ? strOptString3 : iM394a == 11 ? "#FFFFFF" : "#696969";
            }
            String str6 = this.f1439S.f886a;
            String strOptString4 = jSONObject.optString("PcBackgroundColor");
            if (C0048h.m305b(str6)) {
                str6 = !C0048h.m305b(strOptString4) ? strOptString4 : iM394a == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            String str7 = this.f1439S.f896k;
            String strOptString5 = jSONObject.optString("PcTextColor");
            if (!C0048h.m305b(str7)) {
                str2 = str7;
            } else if (!C0048h.m305b(strOptString5)) {
                str2 = strOptString5;
            } else if (iM394a == 11) {
                str2 = "#FFFFFF";
            }
            m947e();
            String strM408a = this.f1442V.m408a(this.f1439S.f895j.f755a, jSONObject.optString("PcLinksTextColor"));
            C0124r c0124r = this.f1441U;
            if (c0124r == null || c0124r.f800a) {
                TextView textView = this.f1448c;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
            m938a();
            m941b();
            m945d();
            m939a(str6, str4, str5, str3, str2, strM408a);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while applying styles to Vendor details, err : " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m945d() {
        this.f1442V.m417a(this.f1447b, this.f1439S.f890e.f722a, this.f1440T);
        this.f1442V.m417a(this.f1448c, this.f1439S.f895j.f755a.f722a, this.f1440T);
        C0115i c0115i = this.f1439S.f891f.f722a;
        this.f1442V.m417a(this.f1449d, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1450e, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1452g, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1453h, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1451f, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1457l, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1460o, c0115i, this.f1440T);
        this.f1442V.m417a(this.f1461p, c0115i, this.f1440T);
        C0115i c0115i2 = this.f1439S.f892g.f722a;
        this.f1442V.m417a(this.f1458m, c0115i2, this.f1440T);
        this.f1442V.m417a(this.f1459n, c0115i2, this.f1440T);
        this.f1442V.m417a(this.f1455j, this.f1439S.f893h.f722a, this.f1440T);
        this.f1442V.m417a(this.f1456k, this.f1439S.f894i.f722a, this.f1440T);
    }

    /* JADX INFO: renamed from: e */
    public final void m947e() {
        String str = this.f1439S.f888c;
        if (str != null && !C0048h.m305b(str)) {
            this.f1437Q = this.f1439S.f888c;
        }
        String str2 = this.f1439S.f887b;
        if (str2 != null && !C0048h.m305b(str2)) {
            this.f1436P = this.f1439S.f887b;
        }
        String str3 = this.f1439S.f889d;
        if (str3 == null || C0048h.m305b(str3)) {
            return;
        }
        this.f1438R = this.f1439S.f889d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != C3896R.id.vendor_detail_back) {
            if (id == C3896R.id.VD_vendors_privacy_notice) {
                C0048h.m304b(this.f1466u, this.f1446a);
            }
        } else {
            dismiss();
            b bVar = this.f1431K;
            if (bVar != null) {
                bVar.mo929a();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1442V.m414a(getActivity(), this.f1464s);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f1467v == null && getActivity() != null) {
            this.f1467v = new OTPublishersHeadlessSDK(getActivity());
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m931a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1466u = getContext();
        this.f1445Y = new C0171c();
        if (!this.f1445Y.m973a(this.f1467v, this.f1466u, C0074f.m394a(this.f1466u, this.f1440T))) {
            dismiss();
            return null;
        }
        Context context = this.f1466u;
        int i = C3896R.layout.ot_vendors_details_fragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f1447b = (TextView) viewInflate.findViewById(C3896R.id.VD_vendor_name);
        this.f1448c = (TextView) viewInflate.findViewById(C3896R.id.VD_vendors_privacy_notice);
        this.f1426F = (RelativeLayout) viewInflate.findViewById(C3896R.id.vendor_detail_header);
        this.f1427G = (RelativeLayout) viewInflate.findViewById(C3896R.id.vendor_detail_RL);
        this.f1454i = (TextView) viewInflate.findViewById(C3896R.id.VD_page_title);
        this.f1465t = (ImageView) viewInflate.findViewById(C3896R.id.vendor_detail_back);
        this.f1469x = (SwitchCompat) viewInflate.findViewById(C3896R.id.VD_consent_switch);
        this.f1470y = (SwitchCompat) viewInflate.findViewById(C3896R.id.VD_LI_switch);
        this.f1428H = (LinearLayout) viewInflate.findViewById(C3896R.id.vd_linearLyt);
        this.f1455j = (TextView) viewInflate.findViewById(C3896R.id.VD_consent_title);
        this.f1456k = (TextView) viewInflate.findViewById(C3896R.id.VD_LISwitch_title);
        this.f1432L = viewInflate.findViewById(C3896R.id.name_view);
        this.f1433M = viewInflate.findViewById(C3896R.id.consent_title_view);
        this.f1471z = (RecyclerView) viewInflate.findViewById(C3896R.id.vd_purpose_rv);
        this.f1421A = (RecyclerView) viewInflate.findViewById(C3896R.id.vd_liPurpose_rv);
        this.f1422B = (RecyclerView) viewInflate.findViewById(C3896R.id.vd_feature_rv);
        this.f1423C = (RecyclerView) viewInflate.findViewById(C3896R.id.vd_spFeature_rv);
        this.f1424D = (RecyclerView) viewInflate.findViewById(C3896R.id.vd_SpPurpose_rv);
        this.f1449d = (TextView) viewInflate.findViewById(C3896R.id.VD_purpose_title);
        this.f1450e = (TextView) viewInflate.findViewById(C3896R.id.VD_LIPurpose_title);
        this.f1451f = (TextView) viewInflate.findViewById(C3896R.id.VD_Feature_title);
        this.f1453h = (TextView) viewInflate.findViewById(C3896R.id.VD_SpFeature_title);
        this.f1452g = (TextView) viewInflate.findViewById(C3896R.id.VD_SpPurpose_title);
        this.f1457l = (TextView) viewInflate.findViewById(C3896R.id.VD_lifespan_label);
        this.f1458m = (TextView) viewInflate.findViewById(C3896R.id.VD_lifespan_value);
        this.f1459n = (TextView) viewInflate.findViewById(C3896R.id.VD_lifespan_desc);
        this.f1463r = (RelativeLayout) viewInflate.findViewById(C3896R.id.disclosure_RL);
        this.f1460o = (TextView) viewInflate.findViewById(C3896R.id.VD_disclosure_title);
        this.f1425E = (RecyclerView) viewInflate.findViewById(C3896R.id.VD_disclosure_rv);
        this.f1429I = (LinearLayout) viewInflate.findViewById(C3896R.id.scrollable_content);
        this.f1444X = (TextView) viewInflate.findViewById(C3896R.id.view_powered_by_logo);
        this.f1461p = (TextView) viewInflate.findViewById(C3896R.id.VD_domain_used_title);
        this.f1462q = (RecyclerView) viewInflate.findViewById(C3896R.id.VD_domains_rv);
        this.f1442V = new C0074f();
        m943c();
        try {
            JSONObject preferenceCenterData = this.f1467v.getPreferenceCenterData();
            m944c(preferenceCenterData);
            String strOptString = preferenceCenterData.optString("BConsentText");
            this.f1455j.setText(strOptString);
            this.f1469x.setContentDescription(strOptString);
            String strOptString2 = preferenceCenterData.optString("BLegitInterestText");
            this.f1456k.setText(strOptString2);
            this.f1470y.setContentDescription(strOptString2);
            if (preferenceCenterData.has("PCenterViewPrivacyPolicyText")) {
                this.f1448c.setText(preferenceCenterData.getString("PCenterViewPrivacyPolicyText"));
                if (preferenceCenterData.has("PCPrivacyLinkActionAriaLabel")) {
                    C0170b.m955a(this.f1448c, preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel"));
                }
            }
            if (preferenceCenterData.has("PCenterBackText")) {
                this.f1465t.setContentDescription(preferenceCenterData.optString("PCenterBackText"));
            }
            if (getArguments() != null) {
                String string = getArguments().getString("vendorId");
                this.f1430J = string;
                JSONObject vendorDetails = this.f1467v.getVendorDetails(OTVendorListMode.IAB, string);
                this.f1468w = vendorDetails;
                if (vendorDetails != null) {
                    String string2 = vendorDetails.getString("name");
                    this.f1447b.setText(string2);
                    ViewCompat.setAccessibilityHeading(this.f1447b, true);
                    if (C0170b.m958a(this.f1466u)) {
                        C0170b.m952a(this.f1466u, string2, this.f1428H, C3896R.id.VD_consent_switch);
                        C0170b.m952a(this.f1466u, string2, this.f1428H, C3896R.id.VD_LI_switch);
                    }
                    this.f1446a = this.f1468w.getString("policyUrl");
                    this.f1457l.setText(String.format("%s:", preferenceCenterData.optString("PCenterVendorListLifespan")));
                    this.f1459n.setText(preferenceCenterData.optString("PCenterVendorListNonCookieUsage"));
                    this.f1458m.setText(new C0074f().m407a(this.f1468w.optLong("cookieMaxAgeSeconds"), preferenceCenterData));
                    m946d(preferenceCenterData);
                    m940a(preferenceCenterData);
                }
            }
            this.f1445Y.m970a(this.f1444X, this.f1440T);
        } catch (Exception e) {
            OTLogger.m2743a(6, "VendorDetail", "error while populating Vendor Detail fields" + e.getMessage());
        }
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071 A[Catch: JSONException -> 0x0084, TryCatch #0 {JSONException -> 0x0084, blocks: (B:3:0x0003, B:6:0x001b, B:12:0x0051, B:13:0x0061, B:15:0x0080, B:14:0x0071, B:7:0x002b, B:9:0x004a, B:8:0x003b), top: B:20:0x0003 }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            r9 = this;
            super.onResume()
            org.json.JSONObject r0 = r9.f1468w     // Catch: org.json.JSONException -> L84
            java.lang.String r1 = "consent"
            int r0 = r0.getInt(r1)     // Catch: org.json.JSONException -> L84
            org.json.JSONObject r1 = r9.f1468w     // Catch: org.json.JSONException -> L84
            java.lang.String r2 = "legIntStatus"
            int r1 = r1.getInt(r2)     // Catch: org.json.JSONException -> L84
            r2 = 0
            r3 = 1
            r4 = 8
            if (r0 == 0) goto L3b
            if (r0 == r3) goto L2b
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1469x     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            android.widget.TextView r0 = r9.f1455j     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            android.view.View r0 = r9.f1432L     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            goto L4d
        L2b:
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1469x     // Catch: org.json.JSONException -> L84
            r0.setChecked(r3)     // Catch: org.json.JSONException -> L84
            a.a.a.a.b.b.f r0 = r9.f1442V     // Catch: org.json.JSONException -> L84
            android.content.Context r5 = r9.f1466u     // Catch: org.json.JSONException -> L84
            androidx.appcompat.widget.SwitchCompat r6 = r9.f1469x     // Catch: org.json.JSONException -> L84
            java.lang.String r7 = r9.f1438R     // Catch: org.json.JSONException -> L84
            java.lang.String r8 = r9.f1436P     // Catch: org.json.JSONException -> L84
            goto L4a
        L3b:
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1469x     // Catch: org.json.JSONException -> L84
            r0.setChecked(r2)     // Catch: org.json.JSONException -> L84
            a.a.a.a.b.b.f r0 = r9.f1442V     // Catch: org.json.JSONException -> L84
            android.content.Context r5 = r9.f1466u     // Catch: org.json.JSONException -> L84
            androidx.appcompat.widget.SwitchCompat r6 = r9.f1469x     // Catch: org.json.JSONException -> L84
            java.lang.String r7 = r9.f1438R     // Catch: org.json.JSONException -> L84
            java.lang.String r8 = r9.f1437Q     // Catch: org.json.JSONException -> L84
        L4a:
            r0.m413a(r5, r6, r7, r8)     // Catch: org.json.JSONException -> L84
        L4d:
            if (r1 == 0) goto L71
            if (r1 == r3) goto L61
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1470y     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            android.widget.TextView r0 = r9.f1456k     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            android.view.View r0 = r9.f1433M     // Catch: org.json.JSONException -> L84
            r0.setVisibility(r4)     // Catch: org.json.JSONException -> L84
            goto L9e
        L61:
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1470y     // Catch: org.json.JSONException -> L84
            r0.setChecked(r3)     // Catch: org.json.JSONException -> L84
            a.a.a.a.b.b.f r0 = r9.f1442V     // Catch: org.json.JSONException -> L84
            android.content.Context r1 = r9.f1466u     // Catch: org.json.JSONException -> L84
            androidx.appcompat.widget.SwitchCompat r2 = r9.f1470y     // Catch: org.json.JSONException -> L84
            java.lang.String r3 = r9.f1438R     // Catch: org.json.JSONException -> L84
            java.lang.String r4 = r9.f1436P     // Catch: org.json.JSONException -> L84
            goto L80
        L71:
            androidx.appcompat.widget.SwitchCompat r0 = r9.f1470y     // Catch: org.json.JSONException -> L84
            r0.setChecked(r2)     // Catch: org.json.JSONException -> L84
            a.a.a.a.b.b.f r0 = r9.f1442V     // Catch: org.json.JSONException -> L84
            android.content.Context r1 = r9.f1466u     // Catch: org.json.JSONException -> L84
            androidx.appcompat.widget.SwitchCompat r2 = r9.f1470y     // Catch: org.json.JSONException -> L84
            java.lang.String r3 = r9.f1438R     // Catch: org.json.JSONException -> L84
            java.lang.String r4 = r9.f1437Q     // Catch: org.json.JSONException -> L84
        L80:
            r0.m413a(r1, r2, r3, r4)     // Catch: org.json.JSONException -> L84
            goto L9e
        L84:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error while setting toggle values"
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r1 = 6
            java.lang.String r2 = "VendorDetail"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r1, r2, r0)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n.onResume():void");
    }

    /* JADX INFO: renamed from: d */
    public final void m946d(final JSONObject jSONObject) throws JSONException {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        if (this.f1468w.has("deviceStorageDisclosureUrl")) {
            this.f1460o.setVisibility(8);
            this.f1460o.setText(String.format("%s:", jSONObject.optString("PCenterVendorListDisclosure")));
            String string = this.f1468w.getString("deviceStorageDisclosureUrl");
            Context context = this.f1466u;
            boolean z = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            String string2 = sharedPreferences.getString("OT_IAB_PURPOSES_TRANSLATED", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!C0048h.m305b(string2)) {
                jSONObject2 = new JSONObject(string2);
            }
            final JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has("purposes")) {
                jSONObject3 = jSONObject2.getJSONObject("purposes");
            }
            C0038b c0038b = new C0038b(this.f1466u);
            a aVar = new a() { // from class: a.a.a.a.b.h.n$$ExternalSyntheticLambda6
                @Override // p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n.a
                /* JADX INFO: renamed from: a */
                public final void mo948a(JSONObject jSONObject4) {
                    this.f$0.m934a(jSONObject3, jSONObject, jSONObject4);
                }
            };
            OTLogger.m2743a(3, "NetworkRequestHandler", "IAB Vendor Disclosure API called ");
            ((InterfaceC0037a) new Retrofit.Builder().baseUrl("https://geolocation.1trust.app/").addConverterFactory(ScalarsConverterFactory.create()).client(new OkHttpClient.Builder().build()).build().create(InterfaceC0037a.class)).m248a(string).enqueue(new C0039c(c0038b, new JSONObject[1], aVar));
            return;
        }
        this.f1463r.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m936b(View view) {
        C0003b c0003b = new C0003b(16);
        c0003b.f3b = this.f1430J;
        c0003b.f4c = this.f1470y.isChecked() ? 1 : 0;
        C0002a c0002a = this.f1443W;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m942b(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        C0106b0 c0106b0 = this.f1439S.f890e;
        if (!C0048h.m305b(c0106b0.f724c)) {
            strOptString = c0106b0.f724c;
        } else {
            strOptString = jSONObject.optString("PcTextColor");
        }
        this.f1435O = strOptString;
        C0106b0 c0106b02 = this.f1439S.f892g;
        if (!C0048h.m305b(c0106b02.f724c)) {
            strOptString2 = c0106b02.f724c;
        } else {
            strOptString2 = jSONObject.optString("PcTextColor");
        }
        this.f1434N = strOptString2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m932a(View view) {
        C0003b c0003b = new C0003b(15);
        c0003b.f3b = this.f1430J;
        c0003b.f4c = this.f1469x.isChecked() ? 1 : 0;
        C0002a c0002a = this.f1443W;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        c0003b.f6e = OTVendorListMode.IAB;
        C0002a c0002a2 = this.f1443W;
        if (c0002a2 != null) {
            c0002a2.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m935a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        dismiss();
        b bVar = this.f1431K;
        if (bVar == null) {
            return false;
        }
        bVar.mo929a();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m934a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C0147o c0147o = new C0147o(jSONObject3, this.f1467v, this.f1439S, jSONObject);
        try {
            if (C0032d.m240a(jSONObject3)) {
                this.f1463r.setVisibility(8);
            }
            if (!C0032d.m240a(jSONObject3) && jSONObject3.has("disclosures") && jSONObject3.getJSONArray("disclosures").length() > 0) {
                this.f1463r.setVisibility(0);
                this.f1460o.setVisibility(0);
                this.f1425E.setLayoutManager(new LinearLayoutManager(this.f1466u));
                this.f1425E.setAdapter(c0147o);
            }
            JSONArray jSONArray = new JSONArray();
            if (jSONObject3.has("domains")) {
                jSONArray = jSONObject3.getJSONArray("domains");
            }
            if (C0032d.m239a(jSONArray)) {
                return;
            }
            this.f1463r.setVisibility(0);
            this.f1461p.setVisibility(0);
            this.f1461p.setText(jSONObject2.optString("PCVLSDomainsUsed"));
            C0148p c0148p = new C0148p(jSONArray, jSONObject2, this.f1439S);
            this.f1462q.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1462q.setAdapter(c0148p);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VendorDetail", "showVendorDisclosureDetails: " + e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m940a(JSONObject jSONObject) {
        if (this.f1468w.getJSONArray("purposes").length() > 0) {
            this.f1449d.setVisibility(0);
            TextView textView = this.f1449d;
            textView.setText(jSONObject.optString("BConsentPurposesText", getString(C3896R.string.ot_vd_purposes_consent_title)));
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f1471z.setVisibility(0);
            this.f1471z.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1471z.setAdapter(new C0145m(this.f1468w.getJSONArray("purposes"), this.f1434N, this.f1439S, this.f1440T, OTVendorListMode.IAB));
            this.f1471z.setNestedScrollingEnabled(false);
        }
        if (this.f1468w.getJSONArray("legIntPurposes").length() > 0) {
            this.f1450e.setVisibility(0);
            TextView textView2 = this.f1450e;
            textView2.setText(jSONObject.optString("BLegitimateInterestPurposesText", getString(C3896R.string.ot_vd_LIPurposes_consent_title)));
            ViewCompat.setAccessibilityHeading(textView2, true);
            this.f1421A.setVisibility(0);
            this.f1421A.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1421A.setAdapter(new C0145m(this.f1468w.getJSONArray("legIntPurposes"), this.f1434N, this.f1439S, this.f1440T, OTVendorListMode.IAB));
            this.f1421A.setNestedScrollingEnabled(false);
        }
        if (this.f1468w.getJSONArray("features").length() > 0) {
            this.f1451f.setVisibility(0);
            TextView textView3 = this.f1451f;
            textView3.setText(jSONObject.optString("BFeaturesText", getString(C3896R.string.ot_vd_feature_consent_title)));
            ViewCompat.setAccessibilityHeading(textView3, true);
            this.f1422B.setVisibility(0);
            this.f1422B.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1422B.setAdapter(new C0145m(this.f1468w.getJSONArray("features"), this.f1434N, this.f1439S, this.f1440T, OTVendorListMode.IAB));
            this.f1422B.setNestedScrollingEnabled(false);
        }
        if (this.f1468w.getJSONArray("specialFeatures").length() > 0) {
            this.f1453h.setVisibility(0);
            TextView textView4 = this.f1453h;
            textView4.setText(jSONObject.optString("BSpecialFeaturesText", getString(C3896R.string.ot_vd_SpFeature_consent_title)));
            ViewCompat.setAccessibilityHeading(textView4, true);
            this.f1423C.setVisibility(0);
            this.f1423C.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1423C.setAdapter(new C0145m(this.f1468w.getJSONArray("specialFeatures"), this.f1434N, this.f1439S, this.f1440T, OTVendorListMode.IAB));
            this.f1423C.setNestedScrollingEnabled(false);
        }
        if (this.f1468w.getJSONArray("specialPurposes").length() > 0) {
            this.f1452g.setVisibility(0);
            TextView textView5 = this.f1452g;
            textView5.setText(jSONObject.optString("BSpecialPurposesText", getString(C3896R.string.ot_vd_SpPurposes_consent_title)));
            ViewCompat.setAccessibilityHeading(textView5, true);
            this.f1424D.setVisibility(0);
            this.f1424D.setLayoutManager(new LinearLayoutManager(this.f1466u));
            this.f1424D.setAdapter(new C0145m(this.f1468w.getJSONArray("specialPurposes"), this.f1434N, this.f1439S, this.f1440T, OTVendorListMode.IAB));
            this.f1424D.setNestedScrollingEnabled(false);
        }
    }
}
