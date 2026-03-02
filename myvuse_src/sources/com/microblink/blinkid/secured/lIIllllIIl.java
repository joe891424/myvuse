package com.microblink.blinkid.secured;

import java.util.ArrayList;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class lIIllllIIl {
    private final long IlIllIlIIl;
    private final long IllIIIllII;
    private final llllllllIl llIIIlllll;
    private final long llIIlIlIIl;

    public lIIllllIIl(long j, long j2, long j3, llllllllIl llllllllil) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = j2;
        this.IllIIIllII = j3;
        this.llIIIlllll = llllllllil;
    }

    public long IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    boolean IllIIIIllI() {
        return this.llIIlIlIIl == 0 && this.IlIllIlIIl == 0 && this.IllIIIllII == 0 && this.llIIIlllll.IlIllIlIIl();
    }

    public long IllIIIllII() {
        return this.IlIllIlIIl;
    }

    public long llIIIlllll() {
        return this.IllIIIllII;
    }

    public llllllllIl llIIlIlIIl() {
        return this.llIIIlllll;
    }

    static lIIllllIIl llIIlIlIIl(lIIllllIIl... liilllliilArr) {
        ArrayList arrayList = new ArrayList(liilllliilArr.length);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        for (lIIllllIIl liilllliil : liilllliilArr) {
            j += liilllliil.llIIlIlIIl;
            j2 += liilllliil.IlIllIlIIl;
            j3 += liilllliil.IllIIIllII;
            arrayList.add(liilllliil.llIIIlllll);
        }
        return new lIIllllIIl(j, j2, j3, llllllllIl.IlIllIlIIl(arrayList));
    }
}
