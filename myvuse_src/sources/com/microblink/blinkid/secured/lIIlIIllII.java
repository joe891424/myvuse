package com.microblink.blinkid.secured;

import android.content.Context;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.settings.NativeLibraryInfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIIlIIllII {
    private static IIlIIlIIII llIIlIlIIl;

    public static IIlIIlIIII llIIlIlIIl(Context context) {
        if (llIIlIlIIl == null) {
            if (NativeLibraryInfo.isProtectionEnabled() && RightsManager.llIIlIlIIl(Right.ALLOW_IMAGE_UPLOAD)) {
                llIIlIlIIl = new lIIllllIII(context);
            } else {
                llIIlIlIIl = new IIIIllIlIl();
            }
        }
        return llIIlIlIIl;
    }
}
