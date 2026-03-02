package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.C0140h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0129w;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.h.k */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0165k extends BottomSheetDialogFragment implements View.OnClickListener, InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public RelativeLayout f1350a;

    /* JADX INFO: renamed from: b */
    public TextView f1351b;

    /* JADX INFO: renamed from: c */
    public TextView f1352c;

    /* JADX INFO: renamed from: d */
    public TextView f1353d;

    /* JADX INFO: renamed from: e */
    public View f1354e;

    /* JADX INFO: renamed from: f */
    public View f1355f;

    /* JADX INFO: renamed from: g */
    public Button f1356g;

    /* JADX INFO: renamed from: h */
    public RecyclerView f1357h;

    /* JADX INFO: renamed from: i */
    public BottomSheetDialog f1358i;

    /* JADX INFO: renamed from: j */
    public ImageView f1359j;

    /* JADX INFO: renamed from: k */
    public TextView f1360k;

    /* JADX INFO: renamed from: l */
    public Context f1361l;

    /* JADX INFO: renamed from: m */
    public OTPublishersHeadlessSDK f1362m;

    /* JADX INFO: renamed from: n */
    public JSONObject f1363n;

    /* JADX INFO: renamed from: o */
    public C0129w f1364o;

    /* JADX INFO: renamed from: p */
    public C0126t f1365p;

    /* JADX INFO: renamed from: q */
    public C0074f f1366q;

    /* JADX INFO: renamed from: r */
    public C0031z f1367r;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m875a(DialogInterface dialogInterface) {
        this.f1358i = (BottomSheetDialog) dialogInterface;
        this.f1366q.m414a(getActivity(), this.f1358i);
        this.f1358i.setCancelable(false);
        this.f1358i.setCanceledOnTouchOutside(false);
        this.f1358i.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.k$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m876a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m876a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dismiss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void m877b(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: a */
    public final String m878a(String str, String str2) {
        return (str == null || C0048h.m305b(str)) ? this.f1363n.optString(str2) : str;
    }

    /* JADX INFO: renamed from: a */
    public final void m880a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C3896R.id.consent_preferences_list);
        this.f1357h = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f1357h.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f1353d = (TextView) view.findViewById(C3896R.id.title);
        this.f1356g = (Button) view.findViewById(C3896R.id.btn_save_consent_preferences);
        this.f1352c = (TextView) view.findViewById(C3896R.id.consent_preferences_title);
        this.f1351b = (TextView) view.findViewById(C3896R.id.consent_preferences_description);
        this.f1359j = (ImageView) view.findViewById(C3896R.id.close_cp);
        this.f1354e = view.findViewById(C3896R.id.header_rv_divider);
        this.f1355f = view.findViewById(C3896R.id.pc_title_divider);
        this.f1359j.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.k$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m877b(view2);
            }
        });
        this.f1360k = (TextView) view.findViewById(C3896R.id.view_powered_by_logo);
        this.f1350a = (RelativeLayout) view.findViewById(C3896R.id.uc_purpose_layout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3896R.id.btn_save_consent_preferences) {
            this.f1362m.saveConsent(OTConsentInteractionType.UC_PC_CONFIRM);
            dismiss();
        } else if (id == C3896R.id.close_cp) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1366q.m414a(getActivity(), this.f1358i);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.f1362m == null) {
            this.f1362m = new OTPublishersHeadlessSDK(applicationContext);
        }
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f1362m;
        if (oTPublishersHeadlessSDK != null) {
            this.f1367r = oTPublishersHeadlessSDK.getUcpHandler();
        }
        this.f1366q = new C0074f();
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.k$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m875a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        this.f1361l = context;
        int i = C3896R.layout.fragment_ot_uc_purposes;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        int iM394a = C0074f.m394a(this.f1361l, (OTConfiguration) null);
        m880a(viewInflate);
        this.f1356g.setOnClickListener(this);
        this.f1359j.setOnClickListener(this);
        Context context2 = this.f1361l;
        try {
            this.f1363n = this.f1362m.getPreferenceCenterData();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTUCPurposesFragment", "Error in PC data initialization. Error msg = " + e.getMessage());
        }
        try {
            C0130x c0130x = new C0130x(context2);
            this.f1364o = c0130x.m672a(this.f1367r, iM394a);
            this.f1365p = c0130x.m671a(iM394a);
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OTUCPurposesFragment", "Error in ui property object, error message = " + e2.getMessage());
        }
        C0129w c0129w = this.f1364o;
        if (c0129w != null && this.f1365p != null) {
            this.f1353d.setText(c0129w.f874c);
            this.f1350a.setBackgroundColor(Color.parseColor(m878a(this.f1365p.f830a, "PcBackgroundColor")));
            C0106b0 c0106b0 = this.f1364o.f876e;
            C0106b0 c0106b02 = this.f1365p.f840k;
            this.f1353d.setTextColor(Color.parseColor(m878a(c0106b02.f724c, "PcTextColor")));
            m879a(c0106b02, this.f1352c);
            this.f1352c.setVisibility(c0106b0.m614a() ? 0 : 8);
            this.f1366q.m412a(this.f1361l, this.f1352c, c0106b0.f726e);
            C0106b0 c0106b03 = this.f1364o.f877f;
            C0106b0 c0106b04 = this.f1365p.f841l;
            m879a(c0106b04, this.f1351b);
            this.f1351b.setVisibility(c0106b03.m614a() ? 0 : 8);
            this.f1366q.m412a(this.f1361l, this.f1351b, c0106b03.f726e);
            this.f1360k.setVisibility(this.f1364o.f875d ? 0 : 8);
            m879a(c0106b04, this.f1360k);
            this.f1360k.setText(requireContext().getString(C3896R.string.ot_powered_by_one_trust));
            if (this.f1364o.f879h.size() == 0) {
                this.f1354e.setVisibility(8);
            }
            String str = this.f1365p.f831b;
            if (!C0048h.m305b(str)) {
                this.f1354e.setBackgroundColor(Color.parseColor(str));
                this.f1355f.setBackgroundColor(Color.parseColor(str));
            }
            this.f1357h.setAdapter(new C0140h(this.f1361l, this.f1364o, this.f1365p, this.f1363n.optString("PcTextColor"), this, this.f1367r, null));
            C0107c c0107c = this.f1364o.f878g;
            C0107c c0107c2 = this.f1365p.f854y;
            Button button = this.f1356g;
            button.setText(c0107c2.mo376a());
            C0115i c0115i = c0107c2.f728a;
            if (!C0048h.m305b(c0115i.f751b)) {
                button.setTextSize(Float.parseFloat(c0115i.f751b));
            }
            button.setTextColor(Color.parseColor(!C0048h.m305b(c0107c2.mo378b()) ? c0107c2.mo378b() : this.f1363n.optString("PcButtonTextColor")));
            C0074f.m397a(this.f1361l, button, c0107c2, !C0048h.m305b(c0107c2.f729b) ? c0107c2.f729b : this.f1363n.optString("PcButtonColor"), c0107c2.f731d);
            this.f1356g.setText(c0107c.mo376a());
            String strM878a = this.f1365p.f855z.f744e;
            if (C0048h.m305b(strM878a)) {
                strM878a = m878a(this.f1365p.f841l.f724c, "PcTextColor");
            }
            this.f1359j.setColorFilter(Color.parseColor(strM878a));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 1) {
            dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m879a(C0106b0 c0106b0, TextView textView) {
        textView.setTextColor(Color.parseColor(m878a(c0106b0.f724c, "PcTextColor")));
        if (C0048h.m305b(c0106b0.f722a.f751b)) {
            return;
        }
        textView.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
    }
}
