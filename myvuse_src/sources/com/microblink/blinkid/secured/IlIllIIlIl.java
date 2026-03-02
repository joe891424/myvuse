package com.microblink.blinkid.secured;

import android.content.Context;
import com.microblink.blinkid.secured.IllllIlIIl;
import com.microblink.ping.ProductIntegrationInfo;
import com.microblink.recognition.RightsManager;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIllIIlIl {
    private final IIIlllIIll IlIllIlIIl;
    private final long IllIIIIllI;
    private final lIIlIIlIll IllIIIllII;
    private final ProductIntegrationInfo llIIIlllll;
    private final IllllIlIIl llIIlIlIIl = new IllllIlIIl();

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        IlIllIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IlIllIIlIl.IlIllIlIIl(IlIllIIlIl.this);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ lIIllllIIl llIIlIlIIl;

        llIIlIlIIl(lIIllllIIl liilllliil) {
            this.llIIlIlIIl = liilllliil;
        }

        @Override // java.lang.Runnable
        public void run() {
            IlIllIIlIl.this.IlIllIlIIl.llIIlIlIIl(this.llIIlIlIIl);
            IlIllIIlIl.IlIllIlIIl(IlIllIIlIl.this);
        }
    }

    IlIllIIlIl(Context context) {
        this.IlIllIlIIl = new IIIlllIIll(context);
        lIIlIIlIll liiliilill = new lIIlIIlIll("Ping");
        this.IllIIIllII = liiliilill;
        liiliilill.start();
        this.llIIIlllll = ProductIntegrationInfo.getProductIntegrationInfo(context);
        this.IllIIIIllI = TimeUnit.DAYS.toMillis(RightsManager.IllIIIllII());
    }

    static void IlIllIlIIl(IlIllIIlIl ilIllIIlIl) {
        ilIllIIlIl.getClass();
        if (System.currentTimeMillis() - ilIllIIlIl.IlIllIlIIl.llIIlIlIIl() >= ilIllIIlIl.IllIIIIllI) {
            lIIllllIIl liilllliilIlIllIlIIl = ilIllIIlIl.IlIllIlIIl.IlIllIlIIl();
            if (liilllliilIlIllIlIIl.IllIIIIllI()) {
                return;
            }
            try {
                if (ilIllIIlIl.llIIlIlIIl.llIIlIlIIl(new IllllIlIIl.llIIlIlIIl(ilIllIIlIl.llIIIlllll.getProduct(), ilIllIIlIl.llIIIlllll.getProductVersion(), ilIllIIlIl.llIIIlllll.getUserId(), ilIllIIlIl.llIIIlllll.getLicensee(), ilIllIIlIl.llIIIlllll.getLicenseId(), ilIllIIlIl.llIIIlllll.getPackageName(), ilIllIIlIl.llIIIlllll.getPlatform(), ilIllIIlIl.llIIIlllll.getOsVersion(), ilIllIIlIl.llIIIlllll.getDeviceName(), liilllliilIlIllIlIIl)).llIIlIlIIl()) {
                    ilIllIIlIl.IlIllIlIIl.llIIlIlIIl(System.currentTimeMillis());
                    ilIllIIlIl.IlIllIlIIl.IllIIIllII();
                }
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.IllIIIllII.IlIllIlIIl();
    }

    void llIIlIlIIl(lIIllllIIl liilllliil) {
        this.IllIIIllII.llIIlIlIIl(new llIIlIlIIl(liilllliil));
    }

    void llIIlIlIIl() {
        this.IllIIIllII.llIIlIlIIl(new IlIllIlIIl());
    }
}
