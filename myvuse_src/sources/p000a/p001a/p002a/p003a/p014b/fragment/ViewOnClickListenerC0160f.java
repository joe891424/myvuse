package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.Map;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.adapter.C0135c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.h.f */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0160f extends BottomSheetDialogFragment implements C0135c.a, View.OnClickListener, InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public TextView f1299a;

    /* JADX INFO: renamed from: b */
    public RecyclerView f1300b;

    /* JADX INFO: renamed from: c */
    public Button f1301c;

    /* JADX INFO: renamed from: d */
    public BottomSheetDialog f1302d;

    /* JADX INFO: renamed from: e */
    public C0135c f1303e;

    /* JADX INFO: renamed from: f */
    public RelativeLayout f1304f;

    /* JADX INFO: renamed from: g */
    public Context f1305g;

    /* JADX INFO: renamed from: h */
    public RelativeLayout f1306h;

    /* JADX INFO: renamed from: i */
    public OTPublishersHeadlessSDK f1307i;

    /* JADX INFO: renamed from: j */
    public a f1308j;

    /* JADX INFO: renamed from: k */
    public Map<String, String> f1309k;

    /* JADX INFO: renamed from: l */
    public Map<String, String> f1310l;

    /* JADX INFO: renamed from: m */
    public C0132z f1311m;

    /* JADX INFO: renamed from: n */
    public OTConfiguration f1312n;

    /* JADX INFO: renamed from: o */
    public View f1313o;

    /* JADX INFO: renamed from: p */
    public C0170b f1314p;

    /* JADX INFO: renamed from: q */
    public String f1315q;

    /* JADX INFO: renamed from: a.a.a.a.b.h.f$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo845a(Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m843a(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        this.f1302d = bottomSheetDialog;
        this.f1314p.m960a(this.f1305g, bottomSheetDialog);
        this.f1302d.setCancelable(false);
        this.f1302d.setCanceledOnTouchOutside(false);
        this.f1302d.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.f$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m844a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m844a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!C0170b.m957a(i, keyEvent)) {
            return false;
        }
        this.f1310l = this.f1309k;
        dismiss();
        return false;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 1) {
            this.f1308j.mo845a(this.f1303e.m704a());
            dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3896R.id.btn_apply_filter) {
            this.f1308j.mo845a(this.f1303e.m704a());
            dismiss();
        } else if (id == C3896R.id.ot_cancel_filter) {
            this.f1310l = this.f1309k;
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1314p.m960a(this.f1305g, this.f1302d);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f1307i == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.f$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m843a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x021d A[Catch: JSONException -> 0x0233, TryCatch #0 {JSONException -> 0x0233, blocks: (B:78:0x0213, B:79:0x0217, B:81:0x021d, B:83:0x022d), top: B:149:0x0213 }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r18, android.view.ViewGroup r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0160f.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }
}
