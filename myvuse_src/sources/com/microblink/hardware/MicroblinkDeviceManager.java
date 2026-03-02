package com.microblink.hardware;

import android.content.Context;
import android.os.Build;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.lIlIlIIIII;
import com.microblink.blinkid.secured.lIlIllIIlI;
import com.microblink.blinkid.secured.llIIIlIIII;
import com.microblink.util.Log;
import com.microblink.view.NotSupportedReason;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class MicroblinkDeviceManager {
    private static volatile MicroblinkDeviceManager IllIIIIllI;
    private static boolean llIIIlllll;
    private Context IlIllIlIIl;
    private lIlIllIIlI IllIIIllII = lIlIllIIlI.llIIlIIlll();
    private Map<String, llIIlIlIIl> llIIlIlIIl;

    static {
        int i = lIlIllIIlI.lIlIIIIlIl;
        boolean z = true;
        if (Build.CPU_ABI.equals("armeabi-v7a")) {
            if (new File("/proc/cpuinfo").exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            z = false;
                            break;
                        }
                        String lowerCase = line.toLowerCase(Locale.ROOT);
                        boolean zContains = lowerCase.contains("neon");
                        boolean zContains2 = lowerCase.contains("vfpv4");
                        if (zContains && zContains2) {
                            bufferedReader.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    Log.m2710e(lIlIllIIlI.class, e, "Cannot read /proc/cpuinfo to obtain whether NEON and VFPv4 are supported. Will assume they are (and risk crash).", new Object[0]);
                }
            } else {
                Log.m2709e(lIlIllIIlI.class, "File /proc/cpuinfo seems to be missing. Cannot determine whether NEON and VFPv4 are supported. Will assume they are (and risk crash).", new Object[0]);
            }
        }
        llIIIlllll = z;
        IllIIIIllI = null;
        IIIlIllllI.IllIIIllII();
    }

    private MicroblinkDeviceManager(Context context) {
        this.IlIllIlIIl = context;
        try {
            JSONObject jSONObject = new JSONObject(llIIlIIlll());
            JSONArray jSONArrayNames = jSONObject.names();
            this.llIIlIlIIl = new HashMap(jSONArrayNames.length());
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String string = jSONArrayNames.getString(i);
                this.llIIlIlIIl.put(string, new llIIlIlIIl(jSONObject.getJSONObject(string), string));
            }
            lIlIllIIlI.IlIllIlIIl();
            String str = Build.VERSION.RELEASE;
            lIlIllIIlI.IIlIIIllIl();
            String str2 = Build.MANUFACTURER;
            lIlIllIIlI.lllIIIlIlI();
            String str3 = Build.MODEL;
            lIlIllIIlI.IllIIIIllI();
            initNativeDeviceInfo(str, str2, str3, Build.DEVICE, lIlIllIIlI.IlIllIlllI(), lIlIllIIlI.lIIIIIllll(), llIIIlllll(), IllIIIIllI());
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse assets/microblink/device_list_mb.json. Please make sure JSON syntax is correct!", e);
        }
    }

    private boolean IllIIIIllI() {
        llIIlIlIIl llIIlIlIIl = llIIlIlIIl();
        if (llIIlIlIIl == null) {
            return false;
        }
        return llIIlIlIIl(llIIlIlIIl.llIIlIlIIl());
    }

    private static native long initNativeDeviceInfo(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2);

    public static boolean lIlIIIIlIl() {
        return llIIIlllll;
    }

    private boolean llIIIlllll() {
        llIIlIlIIl llIIlIlIIl = llIIlIlIIl();
        if (llIIlIlIIl == null) {
            return false;
        }
        return llIIlIlIIl(llIIlIlIIl.llIIIlllll());
    }

    private String llIIlIIlll() {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = this.IlIllIlIIl.getAssets().open("microblink/device_list_mb.json");
                StringWriter stringWriter = new StringWriter();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    stringWriter.write(line);
                }
                String string = stringWriter.toString();
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                    }
                }
                return string;
            } catch (IOException e) {
                throw new RuntimeException("Cannot load asset microblink/device_list_mb.json. Please make sure that this asset exists!", e);
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static MicroblinkDeviceManager llIIlIlIIl(Context context) {
        if (IllIIIIllI == null) {
            synchronized (MicroblinkDeviceManager.class) {
                if (IllIIIIllI == null) {
                    IllIIIIllI = new MicroblinkDeviceManager(context.getApplicationContext());
                }
            }
        }
        return IllIIIIllI;
    }

    public double IlIllIlIIl() {
        llIIlIlIIl llIIlIlIIl = llIIlIlIIl();
        if (llIIlIlIIl != null) {
            return llIIlIlIIl.IlIllIlIIl();
        }
        return 1.0d;
    }

    public NotSupportedReason IllIIIllII() {
        int i = lIlIllIIlI.lIlIIIIlIl;
        if (!this.IllIIIllII.llIIlIlIIl()) {
            return NotSupportedReason.NO_CAMERA;
        }
        if (llIIIlllll) {
            return null;
        }
        return NotSupportedReason.UNSUPPORTED_PROCESSOR_ARCHITECTURE;
    }

    private llIIlIlIIl llIIlIlIIl() {
        int i = lIlIllIIlI.lIlIIIIlIl;
        return this.llIIlIlIIl.get(new llIIlIlIIl(Build.DEVICE, Build.MODEL).IllIIIllII());
    }

    private boolean llIIlIlIIl(lIlIlIIIII lililiiiii) {
        if (lililiiiii == null) {
            return false;
        }
        try {
            int i = lIlIllIIlI.lIlIIIIlIl;
            return lililiiiii.llIIlIlIIl(new llIIIlIIII(Build.VERSION.RELEASE));
        } catch (Exception e) {
            Log.m2716w(this, e, "Failed to extract android version number!", new Object[0]);
            return false;
        }
    }
}
