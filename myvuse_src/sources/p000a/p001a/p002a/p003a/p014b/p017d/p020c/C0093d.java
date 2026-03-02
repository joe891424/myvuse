package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import com.google.android.material.C2309R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.Map;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0090a;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0095f;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0098i;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.d */
/* JADX INFO: loaded from: classes.dex */
public class C0093d extends BottomSheetDialogFragment implements ViewOnKeyListenerC0095f.a, ViewOnKeyListenerC0090a.a, ViewOnKeyListenerC0102m.a, ViewOnKeyListenerC0098i.a {

    /* JADX INFO: renamed from: a */
    public BottomSheetBehavior<View> f509a;

    /* JADX INFO: renamed from: b */
    public FrameLayout f510b;

    /* JADX INFO: renamed from: c */
    public BottomSheetDialog f511c;

    /* JADX INFO: renamed from: d */
    public Context f512d;

    /* JADX INFO: renamed from: e */
    public OTPublishersHeadlessSDK f513e;

    /* JADX INFO: renamed from: f */
    public C0002a f514f;

    /* JADX INFO: renamed from: g */
    public int f515g;

    /* JADX INFO: renamed from: h */
    public C0074f f516h;

    /* JADX INFO: renamed from: i */
    public int f517i;

    /* JADX INFO: renamed from: j */
    public Fragment f518j;

    /* JADX INFO: renamed from: k */
    public OTConfiguration f519k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m534a(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        this.f511c = bottomSheetDialog;
        m539a(bottomSheetDialog);
        FrameLayout frameLayout = (FrameLayout) this.f511c.findViewById(C2309R.id.design_bottom_sheet);
        this.f510b = frameLayout;
        if (frameLayout != null) {
            this.f509a = BottomSheetBehavior.from(frameLayout);
        }
        this.f511c.setCancelable(false);
        this.f511c.setCanceledOnTouchOutside(false);
        this.f509a.setSkipCollapsed(true);
        this.f509a.setHideable(false);
        this.f509a.setPeekHeight(m537a());
        this.f511c.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.d.c.d$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m536a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m536a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        m541b();
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final int m537a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (getActivity() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            OTLogger.m2743a(6, "OneTrust", "TV: getActivity() returned null");
        }
        return displayMetrics.heightPixels;
    }

    /* JADX INFO: renamed from: b */
    public final void m541b() {
        String str;
        int i = this.f517i;
        String str2 = OTConsentInteractionType.PC_CLOSE;
        if (i == 0) {
            this.f516h.m411a(new C0003b(2), this.f514f);
            str = OTConsentInteractionType.BANNER_CLOSE;
        } else {
            str = OTConsentInteractionType.PC_CLOSE;
        }
        if (this.f517i == 1) {
            this.f516h.m411a(new C0003b(6), this.f514f);
            this.f517i = 0;
        } else {
            str2 = str;
        }
        if (this.f517i == 3) {
            this.f516h.m411a(new C0003b(13), this.f514f);
            this.f517i = 0;
        }
        int i2 = this.f517i;
        if (i2 == 4 || 5 == i2) {
            this.f516h.m411a(new C0003b(13), this.f514f);
            this.f517i = 1;
        }
        if (this.f517i == 6) {
            this.f516h.m411a(new C0003b(26), this.f514f);
            this.f517i = 1;
        }
        if (!str2.equals(OTConsentInteractionType.BANNER_CLOSE)) {
            getChildFragmentManager().popBackStack();
        }
        if (getChildFragmentManager().getBackStackEntryCount() > 1 || str2.equals(OTConsentInteractionType.BANNER_CLOSE)) {
            return;
        }
        C0003b c0003b = new C0003b(17);
        c0003b.f5d = str2;
        this.f516h.m411a(c0003b, this.f514f);
        dismiss();
    }

    /* JADX INFO: renamed from: b */
    public final void m542b(int i) {
        Fragment fragment = this.f518j;
        if (fragment == null || fragment.getArguments() == null) {
            return;
        }
        this.f518j.getArguments().putInt("OT_TV_FOCUSED_BTN", i);
    }

    /* JADX INFO: renamed from: b */
    public final void m543b(final String str, final int i) {
        new Thread(new Runnable() { // from class: a.a.a.a.b.d.c.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m535a(str, i);
            }
        }).start();
        dismiss();
    }

    /* JADX INFO: renamed from: c */
    public final void m544c() {
        this.f517i = 1;
        C0002a c0002a = this.f514f;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f513e;
        OTConfiguration oTConfiguration = this.f519k;
        ViewOnKeyListenerC0095f viewOnKeyListenerC0095f = new ViewOnKeyListenerC0095f();
        Bundle bundle = new Bundle();
        bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        viewOnKeyListenerC0095f.setArguments(bundle);
        viewOnKeyListenerC0095f.f558d = c0002a;
        viewOnKeyListenerC0095f.f557c = this;
        viewOnKeyListenerC0095f.f556b = oTPublishersHeadlessSDK;
        viewOnKeyListenerC0095f.f572r = oTConfiguration;
        getChildFragmentManager().beginTransaction().replace(C3896R.id.tv_main_lyt, viewOnKeyListenerC0095f).addToBackStack(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG).commit();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m539a(this.f511c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.C0093d.onCreate(android.os.Bundle):void");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.d.c.d$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m534a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f512d;
        int i = C3896R.layout.ot_pc_main_tvfragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        return layoutInflater.inflate(i, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m535a(String str, int i) {
        OTLogger.m2743a(4, "OneTrust", "Saving Consent on BG thread");
        this.f513e.saveConsent(str);
        this.f516h.m411a(new C0003b(i), this.f514f);
        C0003b c0003b = new C0003b(17);
        c0003b.f5d = str;
        this.f516h.m411a(c0003b, this.f514f);
    }

    /* JADX INFO: renamed from: a */
    public static C0093d m533a(String str, C0002a c0002a, int i, OTConfiguration oTConfiguration) {
        C0093d c0093d = new C0093d();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, str);
        c0093d.setArguments(bundle);
        c0093d.f514f = c0002a;
        c0093d.f515g = i;
        c0093d.f519k = oTConfiguration;
        return c0093d;
    }

    /* JADX INFO: renamed from: a */
    public void m538a(int i) {
        if (i == 14) {
            m543b(OTConsentInteractionType.PC_CONFIRM, 10);
        }
        if (i == 11) {
            m543b(OTConsentInteractionType.BANNER_ALLOW_ALL, 3);
        }
        if (i == 12) {
            m543b(OTConsentInteractionType.BANNER_REJECT_ALL, 4);
        }
        if (i == 21) {
            m543b(OTConsentInteractionType.PC_ALLOW_ALL, 8);
        }
        if (i == 22) {
            m543b(OTConsentInteractionType.PC_REJECT_ALL, 9);
        }
        if (i == 13) {
            m543b(OTConsentInteractionType.BANNER_CLOSE, 2);
        }
        if (i == 16) {
            m543b(OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING, 2);
        }
        if (i == 15) {
            this.f517i = 3;
            m542b(2);
            m540a((Map<String, String>) null, false, false);
        }
        if (i == 17) {
            this.f517i = 5;
            m540a((Map<String, String>) null, false, false);
        }
        if (i == 18) {
            this.f517i = 4;
            m540a((Map<String, String>) null, false, true);
        }
        if (i == 32) {
            m543b(OTConsentInteractionType.VENDOR_LIST_REJECT_ALL, 20);
        }
        if (i == 31) {
            m543b(OTConsentInteractionType.VENDOR_LIST_ALLOW_ALL, 19);
        }
        if (i == 33) {
            m543b(OTConsentInteractionType.VENDOR_LIST_CONFIRM, 14);
        }
        if (i == 23) {
            m541b();
        }
        if (i == 42) {
            m543b(OTConsentInteractionType.SDK_LIST_REJECT_ALL, 22);
        }
        if (i == 41) {
            m543b(OTConsentInteractionType.SDK_LIST_ALLOW_ALL, 21);
        }
        if (i == 43) {
            m543b(OTConsentInteractionType.SDK_LIST_CONFIRM, 23);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m540a(Map<String, String> map, boolean z, boolean z2) {
        this.f516h.m411a(new C0003b(12), this.f514f);
        C0002a c0002a = this.f514f;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f513e;
        OTConfiguration oTConfiguration = this.f519k;
        ViewOnKeyListenerC0102m viewOnKeyListenerC0102m = new ViewOnKeyListenerC0102m();
        Bundle bundle = new Bundle();
        bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        viewOnKeyListenerC0102m.setArguments(bundle);
        viewOnKeyListenerC0102m.f688d = c0002a;
        viewOnKeyListenerC0102m.f687c = this;
        viewOnKeyListenerC0102m.f686b = oTPublishersHeadlessSDK;
        viewOnKeyListenerC0102m.f699o = oTPublishersHeadlessSDK.getOtVendorUtils();
        viewOnKeyListenerC0102m.f698n = z;
        viewOnKeyListenerC0102m.f697m = map;
        viewOnKeyListenerC0102m.f682H = OTVendorListMode.IAB;
        viewOnKeyListenerC0102m.f684J = oTConfiguration;
        if (z2) {
            viewOnKeyListenerC0102m.f682H = OTVendorListMode.GOOGLE;
        }
        getChildFragmentManager().beginTransaction().replace(C3896R.id.tv_main_lyt, viewOnKeyListenerC0102m).addToBackStack(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG).commit();
    }

    /* JADX INFO: renamed from: a */
    public final void m539a(BottomSheetDialog bottomSheetDialog) {
        if (getActivity() != null && bottomSheetDialog == null) {
            OTLogger.m2743a(3, "OTTV", "setupFullHeight: null instance found, recreating bottomSheetDialog");
            bottomSheetDialog = new BottomSheetDialog(getActivity());
        }
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(C3896R.id.design_bottom_sheet);
        this.f510b = frameLayout;
        if (frameLayout != null) {
            this.f509a = BottomSheetBehavior.from(frameLayout);
            ViewGroup.LayoutParams layoutParams = this.f510b.getLayoutParams();
            int iM537a = m537a();
            if (layoutParams != null) {
                layoutParams.height = iM537a;
            }
            this.f510b.setLayoutParams(layoutParams);
            this.f509a.setState(3);
        }
    }
}
