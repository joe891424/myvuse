package com.microblink.blinkid.secured;

import android.content.Context;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.settings.NativeLibraryInfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIllllllI {
    private static lIllIlIlII llIIlIlIIl;

    public static void llIIlIlIIl(Context context) {
        if (NativeLibraryInfo.isProtectionEnabled() && RightsManager.llIIlIlIIl(Right.PING_USED)) {
            llIIlIlIIl = new IIllllIIlI(context);
        } else {
            llIIlIlIIl = new lIlIllllII();
        }
    }

    public static lIllIlIlII llIIlIlIIl() {
        lIllIlIlII lillililii = llIIlIlIIl;
        if (lillililii != null) {
            return lillililii;
        }
        throw new IllegalStateException("PingManagerProvider.setup wasn't called and pingManager instance is null.");
    }
}
