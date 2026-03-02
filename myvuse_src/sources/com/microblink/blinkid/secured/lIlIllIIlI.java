package com.microblink.blinkid.secured;

import android.content.Context;
import android.os.Build;
import com.microblink.blinkid.secured.IlIIIlIIIl;
import com.microblink.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.jose4j.jwk.RsaJsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlIllIIlI {
    private static volatile lIlIllIIlI IllIIIIllI;
    private static int IllIIIllII;
    public static final /* synthetic */ int lIlIIIIlIl = 0;
    private static int llIIIlllll;
    private Context IlIllIlIIl;
    private Map<String, IlllllIIIl> llIIlIlIIl;

    static {
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new IIllIIllll());
            IllIIIllII = fileArrListFiles.length;
            llIIIlllll = -1;
            for (File file : fileArrListFiles) {
                String str = file.getAbsolutePath() + "/cpufreq/cpuinfo_max_freq";
                Log.m2707d(lIlIllIIlI.class, "Examining file {}", str);
                int iIlIllIlIIl = IlIllIlIIl(str);
                if (iIlIllIlIIl > llIIIlllll) {
                    llIIIlllll = iIlIllIlIIl;
                }
            }
            int i = llIIIlllll;
            if (i != -1) {
                llIIIlllll = Math.round(i / 1000.0f);
            }
            Log.m2711i(lIlIllIIlI.class, "Calculated max CPU frequency: {} MHz", Integer.valueOf(llIIIlllll));
        } catch (Exception unused) {
            IllIIIllII = Runtime.getRuntime().availableProcessors();
            llIIIlllll = -1;
        }
    }

    private lIlIllIIlI(Context context, String str) {
        this.IlIllIlIIl = context;
        try {
            JSONObject jSONObject = new JSONObject(llIIlIlIIl(str));
            JSONArray jSONArrayNames = jSONObject.names();
            this.llIIlIlIIl = new HashMap(jSONArrayNames.length());
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String string = jSONArrayNames.getString(i);
                IlllllIIIl illlllIIIl = new IlllllIIIl(jSONObject.getJSONObject(string), string);
                String[] strArrSplit = string.split(",");
                if (strArrSplit.length > 1) {
                    for (String str2 : strArrSplit) {
                        this.llIIlIlIIl.put(str2, illlllIIIl);
                    }
                } else {
                    this.llIIlIlIIl.put(string, illlllIIIl);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse assets/microblink/device_list.json. Please make sure JSON syntax is correct!", e);
        }
    }

    public static String IIlIIIllIl() {
        return Build.MANUFACTURER;
    }

    public static String IlIllIlIIl() {
        return Build.VERSION.RELEASE;
    }

    public static int IlIllIlllI() {
        return IllIIIllII;
    }

    public static String IllIIIIllI() {
        return Build.DEVICE;
    }

    public static int lIIIIIllll() {
        return llIIIlllll;
    }

    private IlllllIIIl lIlIIIIlIl() {
        return this.llIIlIlIIl.get(new IlllllIIIl(Build.DEVICE, Build.MODEL).IllIIlIIII());
    }

    public static lIlIllIIlI llIIlIIlll() {
        if (IllIIIIllI != null) {
            return IllIIIIllI;
        }
        throw new IllegalStateException("DeviceManager.setup wasn't called and DeviceManager instance is null.");
    }

    public static void llIIlIlIIl(Context context, String str) {
        if (IllIIIIllI == null) {
            IllIIIIllI = new lIlIllIIlI(context.getApplicationContext(), str);
        }
    }

    public static String lllIIIlIlI() {
        return Build.MODEL;
    }

    public boolean IlIIlllIIl() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.IllIIIllII());
    }

    public boolean IlIlllllII() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.IIlIIIllIl());
    }

    public int IllIIIllII() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return -1;
        }
        return illlllIIIlLIlIIIIlIl.llIIlIlIIl();
    }

    public IlIIIlIIIl.llIIlIlIIl IllIIlIIII() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return null;
        }
        return illlllIIIlLIlIIIIlIl.lllIIIlIlI();
    }

    public boolean lIIIIIlIlI() {
        return this.llIIlIlIIl != null;
    }

    public boolean lIllIIlIIl() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.lllIlIlIIl());
    }

    public boolean lIlllIlIlI() {
        if (lIlIIIIlIl() == null) {
            return true;
        }
        return !llIIlIlIIl(r0.IlIllIlllI());
    }

    public Context llIIIlllll() {
        return this.IlIllIlIIl;
    }

    public boolean llIIlIIIll() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.IlIllIlIIl());
    }

    public boolean llIllIIlll() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.llIIIlllll());
    }

    public IlIIIlIIIl.llIIlIlIIl lllIlIlIIl() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return null;
        }
        return illlllIIIlLIlIIIIlIl.lIIIIIllll();
    }

    public boolean lllllIlIll() {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl == null) {
            return false;
        }
        return llIIlIlIIl(illlllIIIlLIlIIIIlIl.lIlIIIIlIl());
    }

    private static int IlIllIlIIl(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        String line;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
            }
        } catch (IOException unused2) {
        }
        try {
            line = randomAccessFile.readLine();
        } catch (IOException unused3) {
            randomAccessFile2 = randomAccessFile;
            Log.m2711i(lIlIllIIlI.class, "Failed to open {} for reading", str);
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return -1;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (line == null) {
            randomAccessFile.close();
            return -1;
        }
        try {
            int i = Integer.parseInt(line);
            try {
                randomAccessFile.close();
            } catch (IOException unused5) {
            }
            return i;
        } catch (NumberFormatException unused6) {
            Log.m2709e(lIlIllIIlI.class, "Failed to parse CPU frequency: '{}'", line);
            try {
                randomAccessFile.close();
            } catch (IOException unused7) {
            }
            return -1;
        }
    }

    private String llIIlIlIIl(String str) {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = this.IlIllIlIIl.getAssets().open(str + "/device_list.json");
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
                throw new RuntimeException("Cannot load asset microblink/device_list.json. Please make sure that this asset exists!", e);
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

    public boolean llIIlIlIIl() {
        return this.IlIllIlIIl.getPackageManager().hasSystemFeature("android.hardware.camera") || this.IlIllIlIIl.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public float llIIlIlIIl(float f) {
        IlllllIIIl illlllIIIlLIlIIIIlIl = lIlIIIIlIl();
        if (illlllIIIlLIlIIIIlIl != null) {
            float fLlIIlIIlll = (float) illlllIIIlLIlIIIIlIl.llIIlIIlll();
            float fIllIIIIllI = ((((float) illlllIIIlLIlIIIIlIl.IllIIIIllI()) - fLlIIlIIlll) * f) + fLlIIlIIlll;
            Log.m2711i(this, "Adjusting zoom level from {} to {}", Float.valueOf(f), Float.valueOf(fIllIIIIllI));
            return fIllIIIIllI;
        }
        Log.m2711i(this, "Keeping zoom level at {}", Float.valueOf(f));
        return f;
    }

    private boolean llIIlIlIIl(lIlIlIIIII lililiiiii) {
        if (lililiiiii == null) {
            return false;
        }
        try {
            return lililiiiii.llIIlIlIIl(new llIIIlIIII(Build.VERSION.RELEASE));
        } catch (Exception e) {
            Log.m2716w(this, e, "Failed to extract android version number!", new Object[0]);
            return false;
        }
    }
}
