package com.microblink.blinkid.secured;

import android.content.Context;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microblink.licence.LicenceManager;
import com.microblink.licence.exception.LicenceLockedException;
import com.microblink.licence.exception.RemoteLicenceCheckException;
import com.microblink.recognition.RightsManager;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.Log;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIlIIIIIl implements IllllIIIIl {
    private lIlIIIIlIl IlIllIlIIl;
    private lIIlIIlIll IllIIIllII;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: line */
    static class llIIlIlIIl {
        static final llIlIIIIIl llIIlIlIIl = new llIlIIIIIl(null);
    }

    /* synthetic */ llIlIIIIIl(llllllIllI llllllilli) {
        this();
    }

    @Override // com.microblink.blinkid.secured.IllllIIIIl
    public void IlIllIlIIl(Context context) {
        if (this.IlIllIlIIl == null) {
            this.IlIllIlIIl = new lIlIIIIlIl(context);
        }
        if (!llIIlIlIIl(3)) {
            this.IllIIIllII.llIIlIlIIl(new llllllIllI(this, context));
            return;
        }
        Log.m2707d("Baltazar", "using baltazar cache", new Object[0]);
        int i = llIIlIlIIl(this.IlIllIlIIl.IlIllIlIIl()).IllIIIllII;
        if (i == 0 || i == 1) {
            return;
        }
        this.IllIIIllII.llIIlIlIIl(new llllllIllI(this, context));
    }

    private llIlIIIIIl() {
        lIIlIIlIll liiliilill = new lIIlIIlIll("Baltazar");
        this.IllIIIllII = liiliilill;
        liiliilill.start();
    }

    @Override // com.microblink.blinkid.secured.IllllIIIIl
    public void llIIlIlIIl(Context context) throws Throwable {
        if (this.IlIllIlIIl == null) {
            this.IlIllIlIIl = new lIlIIIIlIl(context);
        }
        boolean zLlIIlIlIIl = true;
        if (!llIIlIlIIl(0) || !llIIlIlIIl(this.IlIllIlIIl.IlIllIlIIl()).llIIlIlIIl) {
            zLlIIlIlIIl = llIIlIlIIl(context, true);
        }
        if (!zLlIIlIlIIl) {
            throw new LicenceLockedException();
        }
    }

    private boolean llIIlIlIIl(int i) {
        return TimeUnit.MILLISECONDS.toMinutes(this.IlIllIlIIl.llIIlIlIIl() - System.currentTimeMillis()) > ((long) i) && this.IlIllIlIIl.IllIIIllII().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean llIIlIlIIl(Context context, boolean z) throws Throwable {
        try {
            lIllIIIlll lilliiilllIllIIIllII = NativeLibraryInfo.IllIIIllII();
            String strLlIIlIlIIl = RightsManager.llIIlIlIIl();
            String strIlIllIlIIl = RightsManager.IlIllIlIIl();
            String packageName = context.getPackageName();
            String strLlIIlIlIIl2 = IIIIIIIlII.llIIlIlIIl(lilliiilllIllIIIllII.llIIlIlIIl());
            String strIlIllIlIIl2 = lilliiilllIllIIIllII.IlIllIlIIl();
            IIIlIIlIll iIIlIIlIllLlIIlIlIIl = IIIlIIlIll.llIIlIlIIl("https://baltazar.microblink.com/api/v1/status/check");
            iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            TreeMap treeMap = new TreeMap();
            treeMap.put("sdkName", strLlIIlIlIIl2);
            treeMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, strIlIllIlIIl2);
            treeMap.put("licensee", strIlIllIlIIl);
            treeMap.put("licenseId", strLlIIlIlIIl);
            treeMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, packageName);
            treeMap.put("platform", "ANDROID");
            iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(new JSONObject(treeMap));
            int iIlIllIlIIl = iIIlIIlIllLlIIlIlIIl.IlIllIlIIl();
            String strIllIIIllII = iIIlIIlIllLlIIlIlIIl.IllIIIllII();
            if (!new IllIIIIllI(iIlIllIlIIl, strIllIIIllII).llIIlIlIIl()) {
                if (z) {
                    return llIIlIlIIl(context, false);
                }
                throw new RemoteLicenceCheckException("Unable to do remote licence check.");
            }
            com.microblink.licence.llIIlIlIIl llIIlIlIIl2 = llIIlIlIIl(strIllIIIllII);
            int i = llIIlIlIIl2.IllIIIllII;
            if (i == 0 || i == 1) {
                return llIIlIlIIl2.llIIlIlIIl;
            }
            if (z) {
                return llIIlIlIIl(context, false);
            }
            throw new RemoteLicenceCheckException("Unable to do remote licence check.");
        } catch (Exception unused) {
            if (z) {
                return llIIlIlIIl(context, false);
            }
            throw new RemoteLicenceCheckException("Unable to do remote licence check.");
        }
    }

    private com.microblink.licence.llIIlIlIIl llIIlIlIIl(String str) {
        this.IlIllIlIIl.IllIIIIllI(str);
        com.microblink.licence.llIIlIlIIl llIIlIlIIl2 = LicenceManager.llIIlIlIIl(str);
        this.IlIllIlIIl.llIIlIlIIl(llIIlIlIIl2);
        return llIIlIlIIl2;
    }
}
