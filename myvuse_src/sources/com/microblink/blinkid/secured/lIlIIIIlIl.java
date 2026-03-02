package com.microblink.blinkid.secured;

import android.content.Context;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lIlIIIIlIl extends lIlIIlIlll {
    lIlIIIIlIl(Context context) {
        super(context, "com.microblink.baltazar.preferences");
    }

    public String IlIllIlIIl() {
        return IllIIIllII("com.microblink.baltazar.preferences.lastServerResponse");
    }

    public void IllIIIIllI(String str) {
        llIIlIlIIl("com.microblink.baltazar.preferences.lastServerResponse", str);
    }

    public Boolean IllIIIllII() {
        return llIIlIlIIl("com.microblink.baltazar.preferences.licenceUnlocked");
    }

    public void llIIlIlIIl(com.microblink.licence.llIIlIlIIl lliililiil) {
        llIIlIlIIl("com.microblink.baltazar.preferences.licenceUnlocked", Boolean.valueOf(lliililiil.llIIlIlIIl));
        llIIlIlIIl("com.microblink.baltazar.preferences.lease", lliililiil.IlIllIlIIl);
    }

    public long llIIlIlIIl() {
        return IlIllIlIIl("com.microblink.baltazar.preferences.lease");
    }
}
