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
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0059b;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0062e;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.C0142j;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.h.l */
/* JADX INFO: loaded from: classes.dex */
public class C0166l extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: a */
    public TextView f1368a;

    /* JADX INFO: renamed from: b */
    public TextView f1369b;

    /* JADX INFO: renamed from: c */
    public TextView f1370c;

    /* JADX INFO: renamed from: d */
    public TextView f1371d;

    /* JADX INFO: renamed from: e */
    public RecyclerView f1372e;

    /* JADX INFO: renamed from: f */
    public BottomSheetDialog f1373f;

    /* JADX INFO: renamed from: g */
    public ImageView f1374g;

    /* JADX INFO: renamed from: h */
    public TextView f1375h;

    /* JADX INFO: renamed from: i */
    public C0142j f1376i;

    /* JADX INFO: renamed from: j */
    public OTPublishersHeadlessSDK f1377j;

    /* JADX INFO: renamed from: k */
    public InterfaceC0075c f1378k;

    /* JADX INFO: renamed from: l */
    public String f1379l;

    /* JADX INFO: renamed from: m */
    public String f1380m;

    /* JADX INFO: renamed from: n */
    public String f1381n;

    /* JADX INFO: renamed from: p */
    public C0074f f1383p;

    /* JADX INFO: renamed from: q */
    public int f1384q;

    /* JADX INFO: renamed from: r */
    public C0031z f1385r;

    /* JADX INFO: renamed from: s */
    public boolean f1386s;

    /* JADX INFO: renamed from: v */
    public JSONObject f1389v;

    /* JADX INFO: renamed from: w */
    public OTConfiguration f1390w;

    /* JADX INFO: renamed from: x */
    public C0126t f1391x;

    /* JADX INFO: renamed from: y */
    public RelativeLayout f1392y;

    /* JADX INFO: renamed from: z */
    public View f1393z;

    /* JADX INFO: renamed from: o */
    public C0002a f1382o = new C0002a();

    /* JADX INFO: renamed from: t */
    public List<C0062e> f1387t = new ArrayList();

    /* JADX INFO: renamed from: u */
    public List<C0059b> f1388u = new ArrayList();

    /* JADX INFO: renamed from: a */
    public static String m881a(String str, String str2) {
        return C0048h.m305b(str) ? str2 : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m883a(DialogInterface dialogInterface) {
        this.f1373f = (BottomSheetDialog) dialogInterface;
        this.f1383p.m414a(getActivity(), this.f1373f);
        this.f1373f.setCancelable(false);
        this.f1373f.setCanceledOnTouchOutside(false);
        this.f1373f.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.l$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m885a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m884a(View view) {
        dismiss();
        InterfaceC0075c interfaceC0075c = this.f1378k;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(6);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m886a() {
        this.f1374g.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.l$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m884a(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1383p.m414a(getActivity(), this.f1373f);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.f1377j == null) {
            this.f1377j = new OTPublishersHeadlessSDK(applicationContext);
        }
        this.f1383p = new C0074f();
        try {
            this.f1389v = this.f1377j.getPreferenceCenterData();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPPurposeDetails", "error while fetching PC Data " + e);
        }
        if (getArguments() != null) {
            if (getArguments().getParcelableArrayList("CUSTOM_PREF_ARRAY") != null) {
                this.f1388u = getArguments().getParcelableArrayList("CUSTOM_PREF_ARRAY");
            } else if (getArguments().getParcelableArrayList("TOPIC_PREF_ARRAY") != null) {
                this.f1387t = getArguments().getParcelableArrayList("TOPIC_PREF_ARRAY");
            }
            this.f1379l = getArguments().getString("ITEM_LABEL");
            this.f1380m = getArguments().getString("ITEM_DESC");
            this.f1384q = getArguments().getInt("ITEM_POSITION");
            this.f1381n = getArguments().getString("TITLE_TEXT_COLOR");
            this.f1386s = getArguments().getBoolean("PURPOSE_TOGGLE_STATE");
        }
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.l$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m883a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        int i = C3896R.layout.fragment_ot_uc_purposes_options;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        try {
            this.f1391x = new C0130x(context).m671a(C0074f.m394a(context, this.f1390w));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f1368a = (TextView) viewInflate.findViewById(C3896R.id.title);
        this.f1369b = (TextView) viewInflate.findViewById(C3896R.id.selected_item_title);
        this.f1370c = (TextView) viewInflate.findViewById(C3896R.id.selected_item_description);
        this.f1371d = (TextView) viewInflate.findViewById(C3896R.id.list_title);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C3896R.id.consent_preferences_selection_list);
        this.f1372e = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f1372e.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f1374g = (ImageView) viewInflate.findViewById(C3896R.id.back_cp);
        this.f1375h = (TextView) viewInflate.findViewById(C3896R.id.view_powered_by_logo);
        this.f1392y = (RelativeLayout) viewInflate.findViewById(C3896R.id.option_main_layout);
        this.f1393z = viewInflate.findViewById(C3896R.id.pc_title_divider);
        m886a();
        this.f1369b.setText(this.f1379l);
        this.f1370c.setText(this.f1380m);
        String strM881a = m881a(this.f1391x.f830a, this.f1389v.optString("PcBackgroundColor"));
        C0126t c0126t = this.f1391x;
        C0106b0 c0106b0 = c0126t.f849t;
        C0106b0 c0106b02 = c0126t.f841l;
        String strM881a2 = m881a(c0106b0.f724c, this.f1381n);
        String strM881a3 = m881a(this.f1391x.f840k.f724c, this.f1381n);
        String strM881a4 = m881a(c0106b02.f724c, this.f1381n);
        m882a(c0106b0, strM881a2, this.f1369b);
        m882a(c0106b02, strM881a2, this.f1370c);
        m882a(c0106b02, strM881a2, this.f1371d);
        this.f1368a.setTextColor(Color.parseColor(strM881a3));
        this.f1374g.setColorFilter(Color.parseColor(strM881a3));
        this.f1392y.setBackgroundColor(Color.parseColor(strM881a));
        this.f1375h.setVisibility(this.f1391x.f838i ? 0 : 8);
        m882a(c0106b02, strM881a4, this.f1375h);
        String str = this.f1391x.f831b;
        if (!C0048h.m305b(str)) {
            this.f1393z.setBackgroundColor(Color.parseColor(str));
        }
        if (this.f1388u.size() > 0) {
            this.f1371d.setText(this.f1388u.get(this.f1384q).f143b);
            this.f1368a.setText(this.f1388u.get(this.f1384q).f143b);
            this.f1376i = new C0142j(this.f1388u.get(this.f1384q).f147f, "customPrefOptionType", this.f1388u.get(this.f1384q).f145d, this.f1385r, this.f1386s, strM881a2, this.f1391x);
        } else if (this.f1387t.size() > 0) {
            this.f1371d.setText(this.f1387t.get(this.f1384q).f171a);
            this.f1368a.setText(this.f1387t.get(this.f1384q).f171a);
            this.f1376i = new C0142j(this.f1387t.get(this.f1384q).f172b, "topicOptionType", "null", this.f1385r, this.f1386s, strM881a2, this.f1391x);
        }
        this.f1372e.setAdapter(this.f1376i);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1378k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m885a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            this.f1382o.m0a(new C0003b(6));
            dismiss();
            InterfaceC0075c interfaceC0075c = this.f1378k;
            if (interfaceC0075c != null) {
                interfaceC0075c.mo419a(6);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m882a(C0106b0 c0106b0, String str, TextView textView) {
        if (!C0048h.m305b(str)) {
            textView.setTextColor(Color.parseColor(str));
        }
        String str2 = c0106b0.f722a.f751b;
        if (C0048h.m305b(str2)) {
            return;
        }
        textView.setTextSize(Float.parseFloat(str2));
    }
}
