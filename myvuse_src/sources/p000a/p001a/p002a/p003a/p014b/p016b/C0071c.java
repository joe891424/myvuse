package p000a.p001a.p002a.p003a.p014b.p016b;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0159e;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.C0093d;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.b.c */
/* JADX INFO: loaded from: classes.dex */
public class C0071c {
    /* JADX INFO: renamed from: a */
    public boolean m381a(FragmentActivity fragmentActivity, C0002a c0002a, OTConfiguration oTConfiguration, OTUIDisplayReason oTUIDisplayReason) {
        boolean z;
        SharedPreferences sharedPreferencesC0047f;
        AppCompatDialogFragment appCompatDialogFragmentM829a;
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        boolean z3;
        SharedPreferencesC0047f sharedPreferencesC0047f3;
        String str = OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG;
        if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            return false;
        }
        OTLogger.m2743a(4, "OneTrust", "Showing Preference Center");
        OTLogger.m2743a(4, "OneTrust", oTUIDisplayReason.logReason());
        C0003b c0003b = new C0003b(5);
        c0003b.f7f = oTUIDisplayReason;
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(fragmentActivity, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(fragmentActivity, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            z = false;
            sharedPreferencesC0047f = null;
        }
        OTLogger.m2743a(4, "OneTrust", "ui type " + (z ? sharedPreferencesC0047f : sharedPreferences).getInt("OT_UI_MODE_TYPE", 102));
        if (!z) {
            sharedPreferencesC0047f = sharedPreferences;
        }
        if (sharedPreferencesC0047f.getInt("OT_UI_MODE_TYPE", 102) == 101) {
            str = OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG;
            appCompatDialogFragmentM829a = C0093d.m533a(OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG, c0002a, 1, oTConfiguration);
        } else {
            appCompatDialogFragmentM829a = ViewOnClickListenerC0159e.m829a(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG, c0002a, oTConfiguration);
        }
        C0170b.m956a(fragmentActivity, appCompatDialogFragmentM829a, str);
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        SharedPreferences sharedPreferences2 = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        SharedPreferences sharedPreferences3 = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        Boolean bool = Boolean.FALSE;
        if (C0026u.m181a(sharedPreferences3.getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
            sharedPreferencesC0047f2 = new SharedPreferencesC0047f(fragmentActivity, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            z2 = false;
            sharedPreferencesC0047f2 = null;
        }
        if (z2) {
            sharedPreferences2 = sharedPreferencesC0047f2;
        }
        if (sharedPreferences2.getInt("OneTrustBannerShownToUser", -1) >= 1) {
            return true;
        }
        SharedPreferences sharedPreferences4 = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
            sharedPreferencesC0047f3 = new SharedPreferencesC0047f(fragmentActivity, sharedPreferences4, sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", ""));
            z3 = true;
        } else {
            z3 = false;
            sharedPreferencesC0047f3 = null;
        }
        if (z3) {
            sharedPreferences4 = sharedPreferencesC0047f3;
        }
        sharedPreferences4.edit().putInt("OneTrustBannerShownToUser", 1).apply();
        return true;
    }
}
