package com.microblink.ping;

import android.content.Context;
import android.os.Build;
import com.microblink.blinkid.secured.IIIIIIIlII;
import com.microblink.blinkid.secured.lIllIIIlll;
import com.microblink.recognition.RightsManager;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.UserIdProvider;
import java.util.Locale;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ProductIntegrationInfo {
    private static ProductIntegrationInfo instance;
    private final String deviceName;
    private final String licenseId;
    private final String licensee;
    private final String osVersion;
    private final String packageName;
    private final String platform = "ANDROID";
    private final String product;
    private final String productVersion;
    private final String userId;

    private ProductIntegrationInfo(Context context) {
        this.userId = UserIdProvider.getUserId(context);
        lIllIIIlll lilliiilllIllIIIllII = NativeLibraryInfo.IllIIIllII();
        this.product = IIIIIIIlII.llIIlIlIIl(lilliiilllIllIIIllII.llIIlIlIIl());
        this.productVersion = lilliiilllIllIIIllII.IlIllIlIIl();
        this.osVersion = Build.VERSION.RELEASE;
        this.deviceName = buildDeviceName();
        this.licenseId = RightsManager.llIIlIlIIl();
        this.licensee = RightsManager.IlIllIlIIl();
        this.packageName = context.getPackageName();
    }

    private static String buildDeviceName() {
        String str = Build.MANUFACTURER;
        String upperCase = str == null ? "" : str.toUpperCase(Locale.US);
        String str2 = Build.MODEL;
        return upperCase + " - " + (str2 != null ? str2.toUpperCase(Locale.US) : "");
    }

    public static final ProductIntegrationInfo getProductIntegrationInfo(Context context) {
        if (instance == null) {
            instance = new ProductIntegrationInfo(context);
        }
        return instance;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getLicenseId() {
        return this.licenseId;
    }

    public String getLicensee() {
        return this.licensee;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPlatform() {
        return "ANDROID";
    }

    public String getProduct() {
        return this.product;
    }

    public String getProductVersion() {
        return this.productVersion;
    }

    public String getUserId() {
        return this.userId;
    }
}
