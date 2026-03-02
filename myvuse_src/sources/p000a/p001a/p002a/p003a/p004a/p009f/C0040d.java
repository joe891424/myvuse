package p000a.p001a.p002a.p003a.p004a.p009f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: renamed from: a.a.a.a.a.f.d */
/* JADX INFO: loaded from: classes.dex */
public class C0040d {
    /* JADX INFO: renamed from: a */
    public boolean m261a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        OTLogger.m2743a(4, "NWUtils", "isConnected = " + z);
        return z;
    }
}
