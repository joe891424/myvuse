package com.facetec.sdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.ca */
/* JADX INFO: loaded from: classes3.dex */
public final class C2187ca {

    /* JADX INFO: renamed from: C */
    private String f3004C;
    private final NfcAdapter Code;

    /* JADX INFO: renamed from: S */
    private V f3006S;

    /* JADX INFO: renamed from: V */
    private final WeakReference<Activity> f3007V;

    /* JADX INFO: renamed from: Z */
    private IsoDep f3008Z;

    /* JADX INFO: renamed from: B */
    private Exception f3003B = null;

    /* JADX INFO: renamed from: I */
    private EnumC2184bx f3005I = null;

    /* JADX INFO: renamed from: com.facetec.sdk.ca$Code */
    public interface Code {
        void Code(EnumC2184bx enumC2184bx);

        /* JADX INFO: renamed from: I */
        void mo1985I();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ca$V */
    public static class V {

        /* JADX INFO: renamed from: B */
        public final String f3012B;

        /* JADX INFO: renamed from: V */
        public final String f3013V;

        /* JADX INFO: renamed from: Z */
        public final String f3014Z;
    }

    final native String nativeStartReading(String str, String str2, String str3);

    final native String nativeStartReadingWithKey(String str);

    /* JADX INFO: renamed from: Z */
    public static C2187ca m1982Z(Activity activity) {
        NfcAdapter nfcAdapterM1981V = m1981V(activity);
        if (nfcAdapterM1981V == null) {
            return null;
        }
        return new C2187ca(nfcAdapterM1981V, activity);
    }

    /* JADX INFO: renamed from: I */
    public static boolean m1980I(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.NFC") == 0 && m1981V(activity) != null;
    }

    /* JADX INFO: renamed from: B */
    public static boolean m1978B(Activity activity) {
        NfcAdapter nfcAdapterM1981V;
        return ContextCompat.checkSelfPermission(activity, "android.permission.NFC") == 0 && (nfcAdapterM1981V = m1981V(activity)) != null && nfcAdapterM1981V.isEnabled();
    }

    /* JADX INFO: renamed from: V */
    private static NfcAdapter m1981V(Activity activity) {
        NfcManager nfcManager = (NfcManager) activity.getSystemService("nfc");
        if (nfcManager == null) {
            return null;
        }
        return nfcManager.getDefaultAdapter();
    }

    private C2187ca(NfcAdapter nfcAdapter, Activity activity) {
        this.Code = nfcAdapter;
        this.f3007V = new WeakReference<>(activity);
    }

    public final boolean Code(Class<?> cls, String str) {
        Activity activity = this.f3007V.get();
        if (activity == null) {
            return false;
        }
        this.f3004C = str;
        Intent intent = new Intent(activity, cls);
        intent.addFlags(536870912);
        this.Code.enableForegroundDispatch(activity, PendingIntent.getActivity(activity, 0, intent, 134217728), null, new String[][]{new String[]{"android.nfc.tech.IsoDep"}});
        return true;
    }

    /* JADX INFO: renamed from: V */
    public final boolean m1984V(Intent intent, final Code code) {
        if (!"android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            return false;
        }
        this.f3008Z = IsoDep.get((Tag) intent.getExtras().getParcelable("android.nfc.extra.TAG"));
        new Thread(new Runnable() { // from class: com.facetec.sdk.ca.5
            @Override // java.lang.Runnable
            public final void run() {
                C2187ca.m1979I(C2187ca.this, code);
            }
        }).start();
        return true;
    }

    /* JADX INFO: renamed from: V */
    public final void m1983V() {
        Activity activity = this.f3007V.get();
        if (activity != null) {
            this.Code.disableForegroundDispatch(activity);
        }
    }

    final byte[] sendCommand(byte[] bArr) {
        this.f3003B = null;
        try {
            if (!this.f3008Z.isConnected()) {
                this.f3008Z.connect();
            }
            return this.f3008Z.transceive(bArr);
        } catch (IOException e) {
            this.f3003B = e;
            e.printStackTrace();
            return null;
        }
    }

    final void setNativeError(int i) {
        if (i == 1) {
            this.f3005I = EnumC2184bx.Unknown;
        } else if (i == 2) {
            this.f3005I = EnumC2184bx.InvalidMrzKey;
        } else {
            if (i != 3) {
                return;
            }
            this.f3005I = EnumC2184bx.ResponseError;
        }
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1979I(C2187ca c2187ca, final Code code) {
        final EnumC2184bx enumC2184bx;
        String strNativeStartReading;
        Activity activity = c2187ca.f3007V.get();
        if (activity != null) {
            c2187ca.f3003B = null;
            c2187ca.f3005I = null;
            try {
                String str = c2187ca.f3004C;
                if (str != null && !str.isEmpty()) {
                    strNativeStartReading = c2187ca.nativeStartReadingWithKey(c2187ca.f3004C);
                } else {
                    strNativeStartReading = c2187ca.nativeStartReading(c2187ca.f3006S.f3013V, c2187ca.f3006S.f3012B, c2187ca.f3006S.f3014Z);
                }
            } catch (Throwable unused) {
                enumC2184bx = EnumC2184bx.Unknown;
            }
            if (strNativeStartReading != null) {
                new JSONObject(strNativeStartReading);
                activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ca.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        code.mo1985I();
                    }
                });
                return;
            }
            if (c2187ca.f3003B != null) {
                enumC2184bx = EnumC2184bx.ConnectionError;
            } else {
                enumC2184bx = c2187ca.f3005I;
                if (enumC2184bx == null) {
                    enumC2184bx = EnumC2184bx.Unknown;
                }
            }
            activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ca.4
                @Override // java.lang.Runnable
                public final void run() {
                    code.Code(enumC2184bx);
                }
            });
        }
    }
}
