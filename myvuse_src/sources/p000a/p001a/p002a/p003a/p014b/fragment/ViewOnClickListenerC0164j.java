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
import android.widget.Button;
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
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.adapter.C0139g;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0128v;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0173e;

/* JADX INFO: renamed from: a.a.a.a.b.h.j */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0164j extends BottomSheetDialogFragment implements View.OnClickListener, C0139g.a {

    /* JADX INFO: renamed from: a */
    public TextView f1334a;

    /* JADX INFO: renamed from: b */
    public RecyclerView f1335b;

    /* JADX INFO: renamed from: c */
    public Button f1336c;

    /* JADX INFO: renamed from: d */
    public BottomSheetDialog f1337d;

    /* JADX INFO: renamed from: e */
    public C0139g f1338e;

    /* JADX INFO: renamed from: f */
    public RelativeLayout f1339f;

    /* JADX INFO: renamed from: g */
    public Context f1340g;

    /* JADX INFO: renamed from: h */
    public RelativeLayout f1341h;

    /* JADX INFO: renamed from: i */
    public OTPublishersHeadlessSDK f1342i;

    /* JADX INFO: renamed from: j */
    public a f1343j;

    /* JADX INFO: renamed from: k */
    public List<String> f1344k = new ArrayList();

    /* JADX INFO: renamed from: l */
    public List<String> f1345l = new ArrayList();

    /* JADX INFO: renamed from: m */
    public C0128v f1346m;

    /* JADX INFO: renamed from: n */
    public View f1347n;

    /* JADX INFO: renamed from: o */
    public OTConfiguration f1348o;

    /* JADX INFO: renamed from: p */
    public C0170b f1349p;

    /* JADX INFO: renamed from: a.a.a.a.b.h.j$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo872a(List<String> list, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m873a(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        this.f1337d = bottomSheetDialog;
        this.f1349p.m960a(this.f1340g, bottomSheetDialog);
        this.f1337d.setCancelable(false);
        this.f1337d.setCanceledOnTouchOutside(false);
        this.f1337d.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.j$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m874a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m874a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!C0170b.m957a(i, keyEvent)) {
            return false;
        }
        this.f1345l = this.f1344k;
        dismiss();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3896R.id.btn_apply_filter) {
            this.f1343j.mo872a(this.f1338e.f996c, this.f1338e.f996c.isEmpty());
            dismiss();
        } else if (id == C3896R.id.ot_cancel_filter) {
            this.f1345l = this.f1344k;
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1349p.m960a(this.f1340g, this.f1337d);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f1342i == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.j$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m873a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Typeface typeface;
        Typeface typeface2;
        Typeface otTypeFaceMap;
        Typeface otTypeFaceMap2;
        Context context = getContext();
        this.f1340g = context;
        this.f1349p = new C0170b();
        int iM394a = C0074f.m394a(context, this.f1348o);
        C0173e c0173e = new C0173e();
        c0173e.m992a(this.f1340g, iM394a, this.f1342i);
        this.f1346m = c0173e.f1525a;
        Context context2 = this.f1340g;
        int i = C3896R.layout.fragment_ot_sdk_list_filter;
        if (new C0048h().m318g(context2)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context2, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C3896R.id.filter_list);
        this.f1335b = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f1335b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f1334a = (TextView) viewInflate.findViewById(C3896R.id.ot_cancel_filter);
        this.f1341h = (RelativeLayout) viewInflate.findViewById(C3896R.id.footer_layout);
        this.f1336c = (Button) viewInflate.findViewById(C3896R.id.btn_apply_filter);
        this.f1339f = (RelativeLayout) viewInflate.findViewById(C3896R.id.filter_layout);
        this.f1347n = viewInflate.findViewById(C3896R.id.view1);
        this.f1336c.setOnClickListener(this);
        this.f1334a.setOnClickListener(this);
        C0139g c0139g = new C0139g(c0173e.m993b(C0026u.m168a(c0173e.f1526b)), this.f1345l, this.f1348o, c0173e, this);
        this.f1338e = c0139g;
        this.f1335b.setAdapter(c0139g);
        C0128v c0128v = this.f1346m;
        if (c0128v != null) {
            String str = c0128v.f857a;
            this.f1339f.setBackgroundColor(Color.parseColor(str));
            this.f1341h.setBackgroundColor(Color.parseColor(str));
            C0106b0 c0106b0 = this.f1346m.f867k;
            TextView textView = this.f1334a;
            textView.setText(c0106b0.f726e);
            C0115i c0115i = c0106b0.f722a;
            OTConfiguration oTConfiguration = this.f1348o;
            String str2 = c0115i.f753d;
            if (C0048h.m305b(str2) || oTConfiguration == null || (otTypeFaceMap2 = oTConfiguration.getOtTypeFaceMap(str2)) == null) {
                int style = c0115i.f752c;
                if (style == -1 && (typeface = textView.getTypeface()) != null) {
                    style = typeface.getStyle();
                }
                textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
            } else {
                textView.setTypeface(otTypeFaceMap2);
            }
            if (!C0048h.m305b(c0115i.f751b)) {
                textView.setTextSize(Float.parseFloat(c0115i.f751b));
            }
            if (!C0048h.m305b(c0106b0.f724c)) {
                textView.setTextColor(Color.parseColor(c0106b0.f724c));
            }
            if (!C0048h.m305b(c0106b0.f723b)) {
                C0074f.m401a(textView, Integer.parseInt(c0106b0.f723b));
            }
            C0107c c0107c = this.f1346m.f869m;
            Button button = this.f1336c;
            button.setText(c0107c.mo376a());
            C0115i c0115i2 = c0107c.f728a;
            OTConfiguration oTConfiguration2 = this.f1348o;
            String str3 = c0115i2.f753d;
            if (C0048h.m305b(str3) || oTConfiguration2 == null || (otTypeFaceMap = oTConfiguration2.getOtTypeFaceMap(str3)) == null) {
                int style2 = c0115i2.f752c;
                if (style2 == -1 && (typeface2 = button.getTypeface()) != null) {
                    style2 = typeface2.getStyle();
                }
                button.setTypeface(!C0048h.m305b(c0115i2.f750a) ? Typeface.create(c0115i2.f750a, style2) : Typeface.create(button.getTypeface(), style2));
            } else {
                button.setTypeface(otTypeFaceMap);
            }
            if (!C0048h.m305b(c0115i2.f751b)) {
                button.setTextSize(Float.parseFloat(c0115i2.f751b));
            }
            if (!C0048h.m305b(c0107c.mo378b())) {
                button.setTextColor(Color.parseColor(c0107c.mo378b()));
            }
            C0074f.m397a(this.f1340g, button, c0107c, c0107c.f729b, c0107c.f731d);
            String str4 = this.f1346m.f858b;
            if (!C0048h.m305b(str4)) {
                this.f1347n.setBackgroundColor(Color.parseColor(str4));
            }
        }
        return viewInflate;
    }
}
