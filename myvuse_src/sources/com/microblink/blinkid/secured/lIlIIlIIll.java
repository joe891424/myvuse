package com.microblink.blinkid.secured;

import android.content.Context;
import android.util.AndroidException;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlIIlIIll {
    private Context llIIlIlIIl;

    public lIlIIlIIll(Context context) {
        this.llIIlIlIIl = context;
        if (context == null) {
            throw new NullPointerException("Device manager cannot be null!");
        }
    }

    public llllllllll llIIlIlIIl(llIlIlIlIl llilililil, IIllllllll iIllllllll) {
        llIIlIlIIl lliililiil = new llIIlIlIIl(this.llIIlIlIIl, new llIllllIIl(0.083333336f, 1.0f), 0.083333336f);
        IlIIlllIll ilIIlllIll = new IlIIlllIll();
        if (iIllllllll.IlIllIlllI() || lIlIllIIlI.llIIlIIlll().llIllIIlll()) {
            Log.m2711i(this, "Using camera1 manager because either settings or device blacklist expect using legacy camera API", new Object[0]);
            return llIIlIlIIl(llilililil, iIllllllll, lliililiil, ilIIlllIll);
        }
        if (lllllllIIl.llIIlIlIIl() && iIllllllll.lIIIIIlIlI() && lIlIllIIlI.llIIlIIlll().lIlllIlIlI()) {
            Log.m2711i(this, "Using camera1 manager because phase autofocus is buggy on this device", new Object[0]);
            return llIIlIlIIl(llilililil, iIllllllll, lliililiil, ilIIlllIll);
        }
        try {
            if (!IlIlIlIIlI.IlIllIlIIl(this.llIIlIlIIl, iIllllllll.IlIllIlIIl())) {
                Log.m2711i(this, "Camera2 API not supported natively. Will use camera1 manager!", new Object[0]);
                return llIIlIlIIl(llilililil, iIllllllll, lliililiil, ilIIlllIll);
            }
            Log.m2711i(this, "Using camera2 manager", new Object[0]);
            int i = IIIIIIIIII.llIIlIlIIl;
            return new lllIIlIIlI(this.llIIlIlIIl, lliililiil, llilililil, iIllllllll);
        } catch (AndroidException unused) {
            Log.m2709e(this, "Failed to query camera capabilities when deciding which camera manager to use! Will use camera1 API", new Object[0]);
            return llIIlIlIIl(llilililil, iIllllllll, lliililiil, ilIIlllIll);
        }
    }

    private IlIlllllII llIIlIlIIl(llIlIlIlIl llilililil, IIllllllll iIllllllll, llIIlIlIIl lliililiil, lIIIllIIlI liiilliili) {
        return new IlIlllllII(lliililiil, liiilliili, llilililil, iIllllllll);
    }
}
