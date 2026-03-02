package p000a.p001a.p002a.p003a.p004a.p006b;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import java.util.HashSet;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.b.a */
/* JADX INFO: loaded from: classes.dex */
public class C0002a {

    /* JADX INFO: renamed from: a */
    public HashSet<OTEventListener> f1a = new HashSet<>();

    /* JADX INFO: renamed from: a */
    public void m0a(C0003b c0003b) {
        int size = this.f1a.size();
        if (size <= 0) {
            OTLogger.m2743a(3, "EventListenerSetter", "Empty callback set. No oneTrustEventListener callback.");
            return;
        }
        OTLogger.m2743a(4, "EventListenerSetter", "Sending oneTrustDataEventListener callback. oneTrustEventListener size = " + size);
        for (OTEventListener oTEventListener : this.f1a) {
            String str = c0003b.f5d;
            switch (c0003b.f2a) {
                case 1:
                    oTEventListener.onShowBanner(c0003b.f7f);
                    break;
                case 2:
                    oTEventListener.onHideBanner();
                    break;
                case 3:
                    oTEventListener.onBannerClickedAcceptAll();
                    break;
                case 4:
                    oTEventListener.onBannerClickedRejectAll();
                    break;
                case 5:
                    oTEventListener.onShowPreferenceCenter(c0003b.f7f);
                    break;
                case 6:
                    oTEventListener.onHidePreferenceCenter();
                    break;
                case 7:
                    oTEventListener.onPreferenceCenterPurposeConsentChanged(c0003b.f3b, c0003b.f4c);
                    break;
                case 8:
                    oTEventListener.onPreferenceCenterAcceptAll();
                    break;
                case 9:
                    oTEventListener.onPreferenceCenterRejectAll();
                    break;
                case 10:
                    oTEventListener.onPreferenceCenterConfirmChoices();
                    break;
                case 11:
                    oTEventListener.onPreferenceCenterPurposeLegitimateInterestChanged(c0003b.f3b, c0003b.f4c);
                    break;
                case 12:
                    oTEventListener.onShowVendorList();
                    break;
                case 13:
                    oTEventListener.onHideVendorList();
                    break;
                case 14:
                    oTEventListener.onVendorConfirmChoices();
                    break;
                case 15:
                    if (C0048h.m305b(c0003b.f6e)) {
                        oTEventListener.onVendorListVendorConsentChanged(c0003b.f3b, c0003b.f4c);
                    } else {
                        oTEventListener.onVendorListVendorConsentChanged(c0003b.f6e, c0003b.f3b, c0003b.f4c);
                    }
                    break;
                case 16:
                    oTEventListener.onVendorListVendorLegitimateInterestChanged(c0003b.f3b, c0003b.f4c);
                    break;
                case 17:
                    oTEventListener.allSDKViewsDismissed(str);
                    break;
                case 18:
                    oTEventListener.onSDKNoAction(str);
                    break;
                case 19:
                    oTEventListener.onVendorListAcceptAll();
                    break;
                case 20:
                    oTEventListener.onVendorListRejectAll();
                    break;
                case 24:
                    oTEventListener.onSdkListSdkConsentChanged(c0003b.f3b, c0003b.f4c);
                    break;
                case 25:
                    oTEventListener.onShowSdkList();
                    break;
                case 26:
                    oTEventListener.onHideSdkList();
                    break;
            }
        }
    }
}
