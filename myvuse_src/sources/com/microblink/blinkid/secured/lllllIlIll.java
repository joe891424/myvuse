package com.microblink.blinkid.secured;

import com.microblink.hardware.camera.Camera1Frame;
import com.microblink.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllllIlIll {
    private IlIllIlIIl llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements lIIlIllIll {
        final /* synthetic */ int IlIllIlIIl;
        final /* synthetic */ IlIlllllII IllIIIIllI;
        final /* synthetic */ int IllIIIllII;
        final /* synthetic */ int llIIIlllll;
        final /* synthetic */ lIIIlIIllI llIIlIlIIl;

        llIIlIlIIl(lIIIlIIllI liiiliilli, int i, int i2, int i3, IlIlllllII ilIlllllII) {
            this.llIIlIlIIl = liiiliilli;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
            this.llIIIlllll = i3;
            this.IllIIIIllI = ilIlllllII;
        }

        @Override // com.microblink.blinkid.secured.lIIlIllIll
        public IIllIllIII llIIlIlIIl() {
            lIIIlIIllI liiiliilli = this.llIIlIlIIl;
            int i = this.IlIllIlIIl;
            int i2 = this.IllIIIllII;
            int i3 = this.llIIIlllll;
            lllllIlIll lllllilill = lllllIlIll.this;
            IlIlllllII ilIlllllII = this.IllIIIIllI;
            ((IlIIllIlII) liiiliilli).getClass();
            return new Camera1Frame(i, i2, i3, lllllilill, ilIlllllII);
        }
    }

    public lllllIlIll(int i, int i2, int i3, int i4, IlIlllllII ilIlllllII, lIIIlIIllI liiiliilli) {
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = new IlIllIlIIl(new llIIlIlIIl(liiiliilli, i, i2, i3, ilIlllllII), i4);
    }

    public llIIlIIlll IlIllIlIIl() {
        return (llIIlIIlll) this.llIIlIlIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(llIIlIIlll lliiliilll) {
        this.llIIlIlIIl.llIIlIlIIl(lliiliilll);
    }

    public llIIlIIlll llIIlIlIIl(byte[] bArr) {
        IlIllIlIIl ilIllIlIIl = this.llIIlIlIIl;
        if (ilIllIlIIl != null) {
            return ilIllIlIIl.llIIlIlIIl(bArr);
        }
        return null;
    }

    public void llIIlIlIIl() {
        this.llIIlIlIIl.IlIllIlIIl();
        this.llIIlIlIIl = null;
    }

    /* JADX INFO: compiled from: line */
    private class IlIllIlIIl extends IllIllllII {
        private Map<byte[], llIIlIIlll> IllIIIIllI;

        public IlIllIlIIl(lIIlIllIll liilillill, int i) {
            super(liilillill, i);
            this.IllIIIIllI = null;
            this.IllIIIIllI = new HashMap(i);
        }

        public void IlIllIlIIl() {
            Map<byte[], llIIlIIlll> map = this.IllIIIIllI;
            if (map != null) {
                Iterator<byte[]> it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    this.IllIIIIllI.get(it2.next()).IIlIIIllIl();
                }
                this.IllIIIIllI.clear();
            }
            this.IllIIIIllI = null;
        }

        protected void finalize() throws Throwable {
            IlIllIlIIl();
            super.finalize();
        }

        @Override // com.microblink.blinkid.secured.IllIllllII
        public synchronized IIllIllIII llIIlIlIIl() {
            llIIlIIlll lliiliilll;
            lliiliilll = (llIIlIIlll) super.llIIlIlIIl();
            this.IllIIIIllI.put(lliiliilll.llIIlIlIIl, lliiliilll);
            Log.m2707d(lllllIlIll.this, "Creating new camera preview frame", new Object[0]);
            return lliiliilll;
        }

        public synchronized llIIlIIlll llIIlIlIIl(byte[] bArr) {
            Map<byte[], llIIlIIlll> map = this.IllIIIIllI;
            if (map == null) {
                return null;
            }
            llIIlIIlll lliiliilll = map.get(bArr);
            if (lliiliilll == null) {
                return null;
            }
            lliiliilll.llIIIlllll();
            return lliiliilll;
        }
    }
}
