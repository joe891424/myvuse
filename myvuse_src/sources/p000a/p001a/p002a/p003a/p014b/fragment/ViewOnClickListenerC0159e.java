package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.ArrayList;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p009f.C0040d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.C0134b;
import p000a.p001a.p002a.p003a.p014b.adapter.InterfaceC0138f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0069a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;
import p000a.p001a.p002a.p003a.p014b.p025i.C0173e;

/* JADX INFO: renamed from: a.a.a.a.b.h.e */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0159e extends BottomSheetDialogFragment implements View.OnClickListener, InterfaceC0075c, InterfaceC0138f {

    /* JADX INFO: renamed from: A */
    public InterfaceC0075c f1252A;

    /* JADX INFO: renamed from: C */
    public OTConfiguration f1254C;

    /* JADX INFO: renamed from: D */
    public C0074f f1255D;

    /* JADX INFO: renamed from: E */
    public C0124r f1256E;

    /* JADX INFO: renamed from: F */
    public View f1257F;

    /* JADX INFO: renamed from: G */
    public View f1258G;

    /* JADX INFO: renamed from: H */
    public View f1259H;

    /* JADX INFO: renamed from: I */
    public View f1260I;

    /* JADX INFO: renamed from: J */
    public View f1261J;

    /* JADX INFO: renamed from: K */
    public View f1262K;

    /* JADX INFO: renamed from: L */
    public TextView f1263L;

    /* JADX INFO: renamed from: M */
    public C0171c f1264M;

    /* JADX INFO: renamed from: N */
    public TextView f1265N;

    /* JADX INFO: renamed from: O */
    public TextView f1266O;

    /* JADX INFO: renamed from: P */
    public View f1267P;

    /* JADX INFO: renamed from: Q */
    public View f1268Q;

    /* JADX INFO: renamed from: R */
    public int f1269R;

    /* JADX INFO: renamed from: S */
    public boolean f1270S;

    /* JADX INFO: renamed from: a */
    public TextView f1272a;

    /* JADX INFO: renamed from: b */
    public TextView f1273b;

    /* JADX INFO: renamed from: c */
    public TextView f1274c;

    /* JADX INFO: renamed from: d */
    public TextView f1275d;

    /* JADX INFO: renamed from: e */
    public TextView f1276e;

    /* JADX INFO: renamed from: f */
    public TextView f1277f;

    /* JADX INFO: renamed from: g */
    public TextView f1278g;

    /* JADX INFO: renamed from: h */
    public TextView f1279h;

    /* JADX INFO: renamed from: i */
    public TextView f1280i;

    /* JADX INFO: renamed from: j */
    public TextView f1281j;

    /* JADX INFO: renamed from: k */
    public RecyclerView f1282k;

    /* JADX INFO: renamed from: l */
    public Button f1283l;

    /* JADX INFO: renamed from: m */
    public Button f1284m;

    /* JADX INFO: renamed from: n */
    public Button f1285n;

    /* JADX INFO: renamed from: o */
    public BottomSheetDialog f1286o;

    /* JADX INFO: renamed from: p */
    public ImageView f1287p;

    /* JADX INFO: renamed from: q */
    public ImageView f1288q;

    /* JADX INFO: renamed from: r */
    public ImageView f1289r;

    /* JADX INFO: renamed from: s */
    public TextView f1290s;

    /* JADX INFO: renamed from: t */
    public Button f1291t;

    /* JADX INFO: renamed from: u */
    public RelativeLayout f1292u;

    /* JADX INFO: renamed from: v */
    public Context f1293v;

    /* JADX INFO: renamed from: w */
    public RelativeLayout f1294w;

    /* JADX INFO: renamed from: x */
    public OTPublishersHeadlessSDK f1295x;

    /* JADX INFO: renamed from: y */
    public OTVendorListFragment f1296y;

    /* JADX INFO: renamed from: z */
    public OTSDKListFragment f1297z;

    /* JADX INFO: renamed from: B */
    public C0002a f1253B = new C0002a();

    /* JADX INFO: renamed from: T */
    public boolean f1271T = true;

    /* JADX INFO: renamed from: a.a.a.a.b.h.e$a */
    public class a implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C0069a f1298a;

        public a(ViewOnClickListenerC0159e viewOnClickListenerC0159e, C0069a c0069a) {
            this.f1298a = c0069a;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            OTLogger.m2743a(3, "PreferenceCenter", "Logo shown for Preference Center failed for url " + this.f1298a.mo376a());
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            OTLogger.m2743a(3, "PreferenceCenter", "Logo shown for Preference Center for url " + this.f1298a.mo376a());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m830a(DialogInterface dialogInterface) {
        this.f1286o = (BottomSheetDialog) dialogInterface;
        if (C0170b.m959a(getActivity(), "OT_PConCreateDialog")) {
            this.f1255D.m414a(requireActivity(), this.f1286o);
        }
        this.f1286o.setCancelable(false);
        this.f1286o.setCanceledOnTouchOutside(false);
        this.f1286o.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.e$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m831a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m831a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.f1255D.m411a(new C0003b(6), this.f1253B);
        m832a(2, true);
        return true;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 1) {
            m832a(i, false);
        }
        if (i == 3) {
            OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1253B, this.f1254C);
            this.f1296y = oTVendorListFragmentM930a;
            oTVendorListFragmentM930a.m914a(this.f1295x);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m832a(int i, boolean z) {
        dismiss();
        InterfaceC0075c interfaceC0075c = this.f1252A;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        } else if (z) {
            m838a(OTConsentInteractionType.PC_CLOSE);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m838a(String str) {
        C0003b c0003b = new C0003b(17);
        c0003b.f5d = str;
        this.f1255D.m411a(c0003b, this.f1253B);
    }

    /* JADX INFO: renamed from: b */
    public final void m839b() {
        String str;
        C0069a c0069a = this.f1264M.f1494i;
        a aVar = new a(this, c0069a);
        this.f1288q.setVisibility(c0069a.f229m);
        ImageView imageView = this.f1288q;
        String str2 = this.f1264M.f1506u.f818A.f762c;
        if (str2 == null) {
            str2 = "";
        }
        imageView.setContentDescription(str2);
        if (c0069a.f229m == 0) {
            if (new C0045d(this.f1293v, "OTT_DEFAULT_USER").m271a().getBoolean("OTT_LOAD_OFFLINE_DATA", false)) {
                OTConfiguration oTConfiguration = this.f1254C;
                if (oTConfiguration == null || oTConfiguration.getPcLogo() == null) {
                    return;
                } else {
                    str = "Loading offline logo for PC.";
                }
            } else {
                if (!new C0045d(this.f1293v, "OTT_DEFAULT_USER").m271a().getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false) || new C0040d().m261a(this.f1293v)) {
                    Glide.with(this).load(c0069a.mo376a()).fitCenter().fallback(C3896R.drawable.ic_ot).listener(aVar).timeout(AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION).into(this.f1288q);
                    return;
                }
                OTConfiguration oTConfiguration2 = this.f1254C;
                if (oTConfiguration2 == null || oTConfiguration2.getPcLogo() == null) {
                    return;
                } else {
                    str = "Loading offline set logo for PC.";
                }
            }
            OTLogger.m2743a(3, "PreferenceCenter", str);
            this.f1288q.setImageDrawable(this.f1254C.getPcLogo());
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m840c() {
        C0171c c0171c = this.f1264M;
        if (c0171c.f1510y != null) {
            m837a(c0171c, this.f1277f);
            C0171c c0171c2 = this.f1264M;
            if (c0171c2.f1511z != null) {
                m837a(c0171c2, this.f1281j);
            } else {
                this.f1281j.setVisibility(8);
            }
            m837a(this.f1264M, this.f1278g);
        } else {
            this.f1277f.setVisibility(8);
            this.f1278g.setVisibility(8);
            this.f1281j.setVisibility(8);
            this.f1289r.setVisibility(8);
            this.f1262K.setVisibility(8);
        }
        if ("true".equals(this.f1264M.f1479F)) {
            m837a(this.f1264M, this.f1280i);
            m837a(this.f1264M, this.f1279h);
        } else {
            this.f1280i.setVisibility(8);
            this.f1279h.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m841d() {
        String str = this.f1264M.f1505t;
        OTLogger.m2743a(3, "OT_Automation", "setSectionDividerColor PC: " + str);
        C0170b.m953a(this.f1257F, str);
        C0170b.m953a(this.f1258G, str);
        C0170b.m953a(this.f1267P, str);
        C0170b.m953a(this.f1268Q, str);
        C0170b.m953a(this.f1259H, str);
        C0170b.m953a(this.f1260I, str);
        C0170b.m953a(this.f1262K, str);
    }

    /* JADX INFO: renamed from: e */
    public final void m842e() {
        if (!this.f1270S) {
            this.f1268Q.setVisibility(8);
        }
        if (this.f1265N.getVisibility() == 8) {
            this.f1267P.setVisibility(8);
        }
        if (!this.f1264M.f1483J || !this.f1271T) {
            this.f1268Q.setVisibility(8);
            if (!this.f1270S) {
                this.f1265N.setVisibility(8);
                this.f1267P.setVisibility(8);
                this.f1259H.setVisibility(8);
            }
        }
        if (this.f1264M.f1501p.length() > 0) {
            return;
        }
        this.f1266O.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        C0074f c0074f;
        C0003b c0003b;
        int id = view.getId();
        if (id == C3896R.id.btn_allow_all) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f1295x;
            str = OTConsentInteractionType.PC_ALLOW_ALL;
            oTPublishersHeadlessSDK.saveConsent(OTConsentInteractionType.PC_ALLOW_ALL);
            c0074f = this.f1255D;
            c0003b = new C0003b(8);
        } else if (id == C3896R.id.btn_confirm_choices) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f1295x;
            str = OTConsentInteractionType.PC_CONFIRM;
            oTPublishersHeadlessSDK2.saveConsent(OTConsentInteractionType.PC_CONFIRM);
            c0074f = this.f1255D;
            c0003b = new C0003b(10);
        } else {
            if (id == C3896R.id.close_pc || id == C3896R.id.close_pc_text || id == C3896R.id.close_pc_button) {
                this.f1255D.m411a(new C0003b(6), this.f1253B);
                m832a(2, true);
                return;
            }
            if (id != C3896R.id.btn_reject_PC) {
                if (id == C3896R.id.view_all_vendors) {
                    if (this.f1296y.isAdded() || getActivity() == null) {
                        OTLogger.m2743a(6, "PreferenceCenter", "Show Vendors: Fragment already added or getActivity() returned null");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("IS_FILTERED_VENDOR_LIST", false);
                    this.f1296y.setArguments(bundle);
                    OTVendorListFragment oTVendorListFragment = this.f1296y;
                    oTVendorListFragment.f1401f = this;
                    oTVendorListFragment.show(requireActivity().getSupportFragmentManager(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                    this.f1255D.m411a(new C0003b(12), this.f1253B);
                    return;
                }
                if (id == C3896R.id.cookie_policy_link) {
                    C0048h.m304b(this.f1293v, this.f1264M.f1502q);
                    return;
                }
                if (id == C3896R.id.text_copy) {
                    Context context = this.f1293v;
                    ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copiedText", this.f1278g.getText().toString()));
                    Toast.makeText(context, "Data Copied to Clipboard", 0).show();
                    return;
                }
                if (id == C3896R.id.view_all_sdks) {
                    if (this.f1297z.isAdded() || getActivity() == null) {
                        OTLogger.m2743a(6, "PreferenceCenter", "renderSDKListFragment: Fragment already added or getActivity() returned null");
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    C0173e c0173e = new C0173e();
                    c0173e.m992a(this.f1293v, this.f1269R, this.f1295x);
                    if (((ArrayList) c0173e.m991a(C0026u.m168a(c0173e.f1526b))).isEmpty()) {
                        this.f1271T = false;
                    }
                    bundle2.putString("OT_GROUP_ID_LIST", c0173e.m991a(C0026u.m168a(c0173e.f1526b)).toString());
                    bundle2.putString("sdkLevelOptOutShow", this.f1264M.f1480G);
                    C0069a c0069a = this.f1264M.f1508w;
                    bundle2.putString("ALWAYS_ACTIVE_TEXT", c0069a.mo376a());
                    bundle2.putString("ALWAYS_ACTIVE_TEXT_COLOR", c0069a.mo378b());
                    this.f1297z.setArguments(bundle2);
                    this.f1297z.show(requireActivity().getSupportFragmentManager(), OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
                    return;
                }
                return;
            }
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK3 = this.f1295x;
            str = OTConsentInteractionType.PC_REJECT_ALL;
            oTPublishersHeadlessSDK3.saveConsent(OTConsentInteractionType.PC_REJECT_ALL);
            c0074f = this.f1255D;
            c0003b = new C0003b(9);
        }
        c0074f.m411a(c0003b, this.f1253B);
        m838a(str);
        m832a(1, false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1255D.m414a(getActivity(), this.f1286o);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Context applicationContext;
        super.onCreate(bundle);
        setRetainInstance(true);
        if (C0170b.m959a(getContext(), OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG) && (applicationContext = requireContext().getApplicationContext()) != null && this.f1295x == null) {
            this.f1295x = new OTPublishersHeadlessSDK(applicationContext);
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.e$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m830a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        this.f1293v = getContext();
        OTVendorListFragment oTVendorListFragmentM930a = OTVendorListFragment.f1394n.m930a(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, this.f1253B, this.f1254C);
        this.f1296y = oTVendorListFragmentM930a;
        oTVendorListFragmentM930a.m914a(this.f1295x);
        OTConfiguration oTConfiguration = this.f1254C;
        Intrinsics.checkNotNullParameter(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG, "fragmentTag");
        boolean z = false;
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.m5605to(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG));
        OTSDKListFragment oTSDKListFragment = new OTSDKListFragment();
        oTSDKListFragment.setArguments(bundleBundleOf);
        oTSDKListFragment.f1320d = oTConfiguration;
        this.f1297z = oTSDKListFragment;
        Intrinsics.checkNotNullParameter(this, "listener");
        oTSDKListFragment.f1322f = this;
        OTSDKListFragment oTSDKListFragment2 = this.f1297z;
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f1295x;
        oTSDKListFragment2.getClass();
        Intrinsics.checkNotNullParameter(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        oTSDKListFragment2.f1319c = otPublishersHeadlessSDK;
        C0074f c0074f = new C0074f();
        this.f1255D = c0074f;
        View viewM406a = c0074f.m406a(this.f1293v, layoutInflater, viewGroup, C3896R.layout.fragment_ot_pc);
        RecyclerView recyclerView = (RecyclerView) viewM406a.findViewById(C3896R.id.preferences_list);
        this.f1282k = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f1282k.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f1282k.setNestedScrollingEnabled(false);
        this.f1292u = (RelativeLayout) viewM406a.findViewById(C3896R.id.pc_layout);
        this.f1294w = (RelativeLayout) viewM406a.findViewById(C3896R.id.footer_layout);
        this.f1273b = (TextView) viewM406a.findViewById(C3896R.id.main_text);
        this.f1274c = (TextView) viewM406a.findViewById(C3896R.id.preferences_header);
        this.f1284m = (Button) viewM406a.findViewById(C3896R.id.btn_confirm_choices);
        this.f1272a = (TextView) viewM406a.findViewById(C3896R.id.main_info_text);
        this.f1287p = (ImageView) viewM406a.findViewById(C3896R.id.close_pc);
        this.f1290s = (TextView) viewM406a.findViewById(C3896R.id.close_pc_text);
        this.f1291t = (Button) viewM406a.findViewById(C3896R.id.close_pc_button);
        this.f1265N = (TextView) viewM406a.findViewById(C3896R.id.ot_pc_vendor_sdk_list_section_header);
        this.f1266O = (TextView) viewM406a.findViewById(C3896R.id.view_all_sdks);
        this.f1267P = viewM406a.findViewById(C3896R.id.ot_pc_vendor_sdk_list_header_line_break);
        this.f1268Q = viewM406a.findViewById(C3896R.id.ot_pc_vendor_list_line_break);
        this.f1275d = (TextView) viewM406a.findViewById(C3896R.id.view_all_vendors);
        this.f1285n = (Button) viewM406a.findViewById(C3896R.id.btn_reject_PC);
        this.f1283l = (Button) viewM406a.findViewById(C3896R.id.btn_allow_all);
        this.f1276e = (TextView) viewM406a.findViewById(C3896R.id.cookie_policy_link);
        this.f1288q = (ImageView) viewM406a.findViewById(C3896R.id.pc_logo);
        this.f1289r = (ImageView) viewM406a.findViewById(C3896R.id.text_copy);
        this.f1257F = viewM406a.findViewById(C3896R.id.ot_pc_vendor_sdk_list_section_divider);
        this.f1262K = viewM406a.findViewById(C3896R.id.dsId_divider);
        this.f1258G = viewM406a.findViewById(C3896R.id.ot_pc_allow_all_layout_top_divider);
        this.f1259H = viewM406a.findViewById(C3896R.id.ot_pc_preferences_header_top_divider);
        this.f1260I = viewM406a.findViewById(C3896R.id.ot_pc_preferences_list_top_divider);
        this.f1261J = viewM406a.findViewById(C3896R.id.pc_title_divider);
        this.f1277f = (TextView) viewM406a.findViewById(C3896R.id.dsid_title);
        this.f1278g = (TextView) viewM406a.findViewById(C3896R.id.dsid);
        this.f1279h = (TextView) viewM406a.findViewById(C3896R.id.time_stamp);
        this.f1280i = (TextView) viewM406a.findViewById(C3896R.id.time_stamp_title);
        this.f1281j = (TextView) viewM406a.findViewById(C3896R.id.dsid_description);
        this.f1263L = (TextView) viewM406a.findViewById(C3896R.id.view_powered_by_logo);
        this.f1255D.m415a(this.f1294w, this.f1293v);
        this.f1283l.setOnClickListener(this);
        this.f1287p.setOnClickListener(this);
        this.f1290s.setOnClickListener(this);
        this.f1291t.setOnClickListener(this);
        this.f1284m.setOnClickListener(this);
        this.f1285n.setOnClickListener(this);
        this.f1276e.setOnClickListener(this);
        this.f1275d.setOnClickListener(this);
        this.f1266O.setOnClickListener(this);
        this.f1289r.setOnClickListener(this);
        this.f1264M = new C0171c();
        if (C0170b.m959a(this.f1293v, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            int iM394a = C0074f.m394a(this.f1293v, this.f1254C);
            this.f1269R = iM394a;
            if (!this.f1264M.m973a(this.f1295x, this.f1293v, iM394a)) {
                dismiss();
            }
            this.f1256E = this.f1264M.f1507v;
            try {
                new C0173e().m992a(this.f1293v, this.f1269R, this.f1295x);
                this.f1271T = !((ArrayList) r11.m991a(C0026u.m168a(r11.f1526b))).isEmpty();
                Context context = this.f1293v;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                String str = "";
                if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z = true;
                } else {
                    sharedPreferencesC0047f = null;
                }
                if (z) {
                    sharedPreferences = sharedPreferencesC0047f;
                }
                String string = sharedPreferences.getString("OT_TEMPLATE_TYPE", "");
                if (!C0048h.m305b(string)) {
                    str = string;
                }
                this.f1270S = "IAB2".equalsIgnoreCase(str);
                m836a(this.f1264M.f1486a, this.f1273b);
                ViewCompat.setAccessibilityHeading(this.f1273b, true);
                m836a(this.f1264M.f1487b, this.f1272a);
                m836a(this.f1264M.f1490e, this.f1276e);
                C0170b.m955a(this.f1276e, this.f1264M.f1506u.f821D.m649a());
                TextView textView = this.f1276e;
                C0124r c0124r = this.f1256E;
                if (c0124r == null || c0124r.f800a) {
                    textView.setPaintFlags(textView.getPaintFlags() | 8);
                }
                m836a(this.f1264M.f1491f, this.f1265N);
                ViewCompat.setAccessibilityHeading(this.f1265N, true);
                m836a(this.f1264M.f1492g, this.f1275d);
                m836a(this.f1264M.f1493h, this.f1266O);
                String str2 = this.f1264M.f1504s;
                if (!C0048h.m305b(str2)) {
                    C0072d.m385a(this.f1275d, str2);
                    C0072d.m385a(this.f1266O, str2);
                    C0074f.m400a(this.f1289r, str2);
                }
                m839b();
                C0069a c0069a = this.f1264M.f1495j;
                m836a(c0069a, this.f1274c);
                ViewCompat.setAccessibilityHeading(this.f1274c, true);
                m834a(this.f1264M.f1496k, this.f1283l);
                m834a(this.f1264M.f1497l, this.f1285n);
                m834a(this.f1264M.f1498m, this.f1284m);
                this.f1282k.setAdapter(new C0134b(this.f1293v, this.f1264M, this.f1295x, this.f1253B, this, this.f1254C));
                String str3 = this.f1264M.f1503r;
                this.f1292u.setBackgroundColor(Color.parseColor(str3));
                this.f1282k.setBackgroundColor(Color.parseColor(str3));
                this.f1294w.setBackgroundColor(Color.parseColor(str3));
                OTLogger.m2743a(3, "OT_Automation", "BG color PC: " + str3);
                m835a(this.f1264M.f1499n, this.f1287p, this.f1290s, this.f1291t);
                m841d();
                if (this.f1264M.f1482I) {
                    C0074f.m398a(this.f1262K, 10);
                    C0074f.m398a(this.f1257F, 10);
                    C0074f.m398a(this.f1258G, 10);
                    C0074f.m398a(this.f1259H, 10);
                }
                m833a(c0069a);
                m840c();
                this.f1264M.m970a(this.f1263L, this.f1254C);
                m842e();
            } catch (RuntimeException e) {
                OTLogger.m2743a(6, "PreferenceCenter", "error while populating  PC fields" + e.getMessage());
            }
        }
        return viewM406a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1253B = null;
    }

    /* JADX INFO: renamed from: a */
    public static ViewOnClickListenerC0159e m829a(String str, C0002a c0002a, OTConfiguration oTConfiguration) {
        ViewOnClickListenerC0159e viewOnClickListenerC0159e = new ViewOnClickListenerC0159e();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, str);
        viewOnClickListenerC0159e.setArguments(bundle);
        viewOnClickListenerC0159e.f1253B = c0002a;
        viewOnClickListenerC0159e.f1254C = oTConfiguration;
        return viewOnClickListenerC0159e;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.adapter.InterfaceC0138f
    /* JADX INFO: renamed from: a */
    public void mo711a() {
        if (this.f1282k.getAdapter() != null) {
            C0134b c0134b = (C0134b) this.f1282k.getAdapter();
            C0171c c0171c = c0134b.f962l;
            c0134b.f954d = c0171c.f1501p;
            c0134b.f958h = c0171c.f1506u;
            c0134b.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m837a(C0171c c0171c, TextView textView) {
        C0106b0 c0106b0;
        C0069a c0069a;
        if (textView.equals(this.f1277f)) {
            c0171c.m971a(textView, c0171c.f1510y, c0171c.f1506u.f842m.f726e);
            textView.setText(c0171c.f1474A.f726e);
            c0171c.m969a(textView, c0171c.f1474A, c0171c.f1495j, this.f1254C);
            this.f1289r.setContentDescription(c0171c.f1506u.f824G.m648a());
            return;
        }
        if (textView.equals(this.f1281j)) {
            c0171c.m971a(textView, c0171c.f1511z, c0171c.f1506u.f847r.f726e);
            this.f1255D.m412a(this.f1293v, textView, c0171c.f1475B.f726e);
            c0106b0 = c0171c.f1475B;
            c0069a = c0171c.f1487b;
        } else {
            if (textView.equals(this.f1278g)) {
                textView.setText(c0171c.f1476C.f726e);
                c0106b0 = c0171c.f1476C;
            } else if (textView.equals(this.f1280i)) {
                textView.setText(c0171c.f1478E.f726e);
                c0106b0 = c0171c.f1478E;
                c0069a = c0171c.f1495j;
            } else {
                if (!textView.equals(this.f1279h)) {
                    return;
                }
                textView.setText(c0171c.f1477D.f726e);
                c0106b0 = c0171c.f1477D;
            }
            c0069a = c0171c.f1509x;
        }
        c0171c.m969a(textView, c0106b0, c0069a, this.f1254C);
    }

    /* JADX INFO: renamed from: a */
    public final void m833a(C0069a c0069a) {
        this.f1260I.setVisibility(c0069a.f229m);
    }

    /* JADX INFO: renamed from: a */
    public final void m836a(C0069a c0069a, TextView textView) {
        this.f1255D.m412a(this.f1293v, textView, c0069a.mo376a());
        textView.setVisibility(c0069a.f229m);
        textView.setTextColor(Color.parseColor(c0069a.mo378b()));
        C0074f.m401a(textView, c0069a.f230n);
        if (!C0048h.m305b(c0069a.f231o)) {
            textView.setTextSize(Float.parseFloat(c0069a.f231o));
        }
        this.f1255D.m417a(textView, c0069a.f728a, this.f1254C);
    }

    /* JADX INFO: renamed from: a */
    public final void m834a(C0069a c0069a, Button button) {
        button.setText(c0069a.mo376a());
        button.setVisibility(c0069a.f229m);
        button.setTextColor(Color.parseColor(c0069a.mo378b()));
        if (!C0048h.m305b(c0069a.f728a.f751b)) {
            button.setTextSize(Float.parseFloat(c0069a.f231o));
        }
        this.f1255D.m416a(button, c0069a.f728a, this.f1254C);
        C0074f.m397a(this.f1293v, button, c0069a.f232p, c0069a.f729b, c0069a.f731d);
    }

    /* JADX INFO: renamed from: a */
    public final void m835a(C0069a c0069a, ImageView imageView, TextView textView, Button button) {
        imageView.setVisibility(c0069a.f229m);
        imageView.setContentDescription(c0069a.mo376a());
        textView.setVisibility(c0069a.f233q);
        imageView.getDrawable().setTint(Color.parseColor(c0069a.mo378b()));
        int i = 0;
        if (c0069a.f234r == 0) {
            button.setVisibility(0);
            button.setText(c0069a.mo376a());
            button.setTextColor(Color.parseColor(c0069a.mo378b()));
            if (!C0048h.m305b(c0069a.f728a.f751b)) {
                button.setTextSize(Float.parseFloat(c0069a.f231o));
            }
            this.f1255D.m416a(button, c0069a.f728a, this.f1254C);
            C0074f.m397a(this.f1293v, button, c0069a.f232p, c0069a.f729b, c0069a.f731d);
        } else if (c0069a.f233q == 0) {
            textView.setText(c0069a.mo376a());
            textView.setTextColor(Color.parseColor(c0069a.mo378b()));
            C0124r c0124r = this.f1256E;
            if (c0124r == null || c0124r.f800a) {
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
        }
        View view = this.f1261J;
        if (c0069a.f233q == 8 && c0069a.f229m == 8 && c0069a.f234r == 8) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
