package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.c.v */
/* JADX INFO: loaded from: classes.dex */
public class C0027v {
    /* JADX INFO: renamed from: a */
    public boolean m188a(Context context, OTUXParams oTUXParams) {
        boolean z;
        if (oTUXParams.getUxParam() != null) {
            C0048h.m300a(context, oTUXParams.getUxParam());
            z = true;
        } else {
            z = false;
        }
        if (oTUXParams.getOTSDKTheme() != null) {
            C0048h.m307c(context, oTUXParams.getOTSDKTheme());
        }
        return z;
    }
}
