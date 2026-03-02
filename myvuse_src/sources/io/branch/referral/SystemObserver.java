package io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.autofill.HintConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import io.branch.coroutines.AdvertisingIdsKt;
import io.branch.coroutines.InstallReferrersKt;
import io.branch.data.InstallReferrerResult;
import io.branch.referral.util.DependencyUtilsKt;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
abstract class SystemObserver {
    static final String BLANK = "bnc_no_value";
    static final String UUID_EMPTY = "00000000-0000-0000-0000-000000000000";
    private String AIDInitializationSessionID_;
    private String GAIDString_ = null;
    private int LATVal_ = 0;

    interface AdsParamsFetchEvents {
        void onAdsParamsFetchFinished();
    }

    interface InstallReferrerFetchEvents {
        void onInstallReferrersFinished();
    }

    SystemObserver() {
    }

    static UniqueId getUniqueID(Context context, boolean z) {
        return new UniqueId(context, z);
    }

    static String getAnonID(Context context) {
        String anonID = PrefHelper.getInstance(context).getAnonID();
        if (!TextUtils.isEmpty(anonID) && !anonID.equals("bnc_no_value")) {
            return anonID;
        }
        String string = UUID.randomUUID().toString();
        PrefHelper.getInstance(context).setAnonID(string);
        return string;
    }

    static String getPackageName(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e) {
                BranchLogger.logException("Error obtaining PackageName", e);
            }
        }
        return "";
    }

    static String getAppVersion(Context context) {
        String str;
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                BranchLogger.logException("Error obtaining AppVersion", e);
                str = "";
            }
        } else {
            str = "";
        }
        return TextUtils.isEmpty(str) ? "bnc_no_value" : str;
    }

    static long getFirstInstallTime(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (Exception e) {
                BranchLogger.logException("Error obtaining FirstInstallTime", e);
            }
        }
        return 0L;
    }

    static boolean isPackageInstalled(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()) == null) {
                return false;
            }
            return !packageManager.queryIntentActivities(r3, 65536).isEmpty();
        } catch (Exception e) {
            BranchLogger.logException("Error obtaining PackageInfo", e);
            return false;
        }
    }

    static long getLastUpdateTime(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            } catch (Exception e) {
                BranchLogger.logException("Error obtaining LastUpdateTime", e);
            }
        }
        return 0L;
    }

    static String getPhoneBrand() {
        return Build.MANUFACTURER;
    }

    static boolean isHuaweiDevice() {
        return getPhoneBrand().equalsIgnoreCase("huawei");
    }

    static String getPhoneModel() {
        return Build.MODEL;
    }

    static String getISO2CountryCode() {
        return Locale.getDefault().getCountry();
    }

    static String getISO2LanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    static boolean isFireOSDevice() {
        return getPhoneBrand().equalsIgnoreCase("amazon");
    }

    static boolean isHuaweiMobileServicesAvailable(Context context) {
        return isHuaweiDevice() && !isGooglePlayServicesAvailable(context);
    }

    static boolean isGooglePlayServicesAvailable(Context context) {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.common.GoogleApiAvailability");
            Object objInvoke = cls.getDeclaredMethod("isGooglePlayServicesAvailable", Context.class).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue() == 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    static String getOS(Context context) {
        if (isFireOSDevice()) {
            return context == null ? getPhoneModel().contains("AFT") ? "AMAZON_FIRE_TV" : "AMAZON_FIRE" : context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv") ? "AMAZON_FIRE_TV" : "AMAZON_FIRE";
        }
        return "Android";
    }

    static int getAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    static String getCPUType() {
        return System.getProperty("os.arch");
    }

    static String getDeviceBuildId() {
        return Build.DISPLAY;
    }

    static String getLocale() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    static String getConnectionType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        return "mobile";
    }

    static String getCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return null;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        if (TextUtils.isEmpty(networkOperatorName)) {
            return null;
        }
        return networkOperatorName;
    }

    static DisplayMetrics getScreenDisplay(Context context) {
        DisplayManager displayManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = null;
        if (context != null && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            display = displayManager.getDisplay(0);
        }
        if (display != null) {
            display.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    static boolean getWifiConnected(Context context) {
        return "wifi".equalsIgnoreCase(getConnectionType(context));
    }

    public void fetchAdId(Context context, AdsParamsFetchEvents adsParamsFetchEvents) {
        if (isFireOSDevice()) {
            setFireAdId(context, adsParamsFetchEvents);
        } else if (isHuaweiMobileServicesAvailable(context)) {
            fetchHuaweiAdId(context, adsParamsFetchEvents);
        } else {
            fetchGoogleAdId(context, adsParamsFetchEvents);
        }
    }

    private void fetchHuaweiAdId(Context context, final AdsParamsFetchEvents adsParamsFetchEvents) {
        if (DependencyUtilsKt.classExists(DependencyUtilsKt.huaweiAdvertisingIdClientClass)) {
            AdvertisingIdsKt.getHuaweiAdvertisingInfoObject(context, new Continuation<AdvertisingIdClient.Info>() { // from class: io.branch.referral.SystemObserver.1
                @Override // kotlin.coroutines.Continuation
                /* JADX INFO: renamed from: getContext */
                public CoroutineContext get$context() {
                    return EmptyCoroutineContext.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj) {
                    AdsParamsFetchEvents adsParamsFetchEvents2;
                    try {
                        if (obj != null) {
                            try {
                                AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) obj;
                                boolean zIsLimitAdTrackingEnabled = info.isLimitAdTrackingEnabled();
                                String id = !zIsLimitAdTrackingEnabled ? info.getId() : null;
                                SystemObserver.this.setLAT(zIsLimitAdTrackingEnabled ? 1 : 0);
                                SystemObserver.this.setGAID(id);
                                adsParamsFetchEvents2 = adsParamsFetchEvents;
                                if (adsParamsFetchEvents2 == null) {
                                    return;
                                }
                            } catch (Exception e) {
                                BranchLogger.m5575d("Error in continuation: " + e);
                                adsParamsFetchEvents2 = adsParamsFetchEvents;
                                if (adsParamsFetchEvents2 == null) {
                                    return;
                                }
                            }
                            adsParamsFetchEvents2.onAdsParamsFetchFinished();
                        }
                    } catch (Throwable th) {
                        AdsParamsFetchEvents adsParamsFetchEvents3 = adsParamsFetchEvents;
                        if (adsParamsFetchEvents3 != null) {
                            adsParamsFetchEvents3.onAdsParamsFetchFinished();
                        }
                        throw th;
                    }
                }
            });
            return;
        }
        if (adsParamsFetchEvents != null) {
            adsParamsFetchEvents.onAdsParamsFetchFinished();
        }
        BranchLogger.m5578v("Huawei advertising service not found. If not expected, import com.huawei.hms.ads.identifier.AdvertisingIdClient into your gradle dependencies");
    }

    private void fetchGoogleAdId(Context context, final AdsParamsFetchEvents adsParamsFetchEvents) {
        if (DependencyUtilsKt.classExists(DependencyUtilsKt.playStoreAdvertisingIdClientClass)) {
            AdvertisingIdsKt.getGoogleAdvertisingInfoObject(context, new Continuation<AdvertisingIdClient.Info>() { // from class: io.branch.referral.SystemObserver.2
                @Override // kotlin.coroutines.Continuation
                /* JADX INFO: renamed from: getContext */
                public CoroutineContext get$context() {
                    return EmptyCoroutineContext.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj) {
                    AdsParamsFetchEvents adsParamsFetchEvents2;
                    try {
                        if (obj != null) {
                            try {
                                AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) obj;
                                boolean zIsLimitAdTrackingEnabled = info.isLimitAdTrackingEnabled();
                                String id = !zIsLimitAdTrackingEnabled ? info.getId() : null;
                                SystemObserver.this.setLAT(zIsLimitAdTrackingEnabled ? 1 : 0);
                                SystemObserver.this.setGAID(id);
                                adsParamsFetchEvents2 = adsParamsFetchEvents;
                                if (adsParamsFetchEvents2 == null) {
                                    return;
                                }
                            } catch (Exception e) {
                                BranchLogger.m5575d("Error in continuation: " + e);
                                adsParamsFetchEvents2 = adsParamsFetchEvents;
                                if (adsParamsFetchEvents2 == null) {
                                    return;
                                }
                            }
                            adsParamsFetchEvents2.onAdsParamsFetchFinished();
                        }
                    } catch (Throwable th) {
                        AdsParamsFetchEvents adsParamsFetchEvents3 = adsParamsFetchEvents;
                        if (adsParamsFetchEvents3 != null) {
                            adsParamsFetchEvents3.onAdsParamsFetchFinished();
                        }
                        throw th;
                    }
                }
            });
            return;
        }
        if (adsParamsFetchEvents != null) {
            adsParamsFetchEvents.onAdsParamsFetchFinished();
        }
        BranchLogger.m5578v("Play Store advertising service not found. If not expected, import com.google.android.gms.ads.identifier.AdvertisingIdClient into your gradle dependencies");
    }

    private void setFireAdId(Context context, final AdsParamsFetchEvents adsParamsFetchEvents) {
        BranchLogger.m5578v("setFireAdId");
        AdvertisingIdsKt.getAmazonFireAdvertisingInfoObject(context, new Continuation<Pair<? extends Integer, ? extends String>>() { // from class: io.branch.referral.SystemObserver.3
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext */
            public CoroutineContext get$context() {
                return EmptyCoroutineContext.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
            @Override // kotlin.coroutines.Continuation
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void resumeWith(java.lang.Object r4) {
                /*
                    r3 = this;
                    java.lang.String r0 = "Error in continuation: "
                    if (r4 == 0) goto L59
                    kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    io.branch.referral.SystemObserver r1 = io.branch.referral.SystemObserver.this     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Object r2 = r4.component1()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    r1.setLAT(r2)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Object r1 = r4.component1()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    if (r1 != 0) goto L2d
                    io.branch.referral.SystemObserver r1 = io.branch.referral.SystemObserver.this     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Object r4 = r4.component2()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    r1.setGAID(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    goto L59
                L2d:
                    io.branch.referral.SystemObserver r1 = io.branch.referral.SystemObserver.this     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.Object r4 = r4.component2()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    r1.setGAID(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
                    goto L59
                L39:
                    r4 = move-exception
                    goto L51
                L3b:
                    r4 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
                    r1.<init>(r0)     // Catch: java.lang.Throwable -> L39
                    java.lang.StringBuilder r4 = r1.append(r4)     // Catch: java.lang.Throwable -> L39
                    java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L39
                    io.branch.referral.BranchLogger.m5575d(r4)     // Catch: java.lang.Throwable -> L39
                    io.branch.referral.SystemObserver$AdsParamsFetchEvents r4 = r2
                    if (r4 == 0) goto L60
                    goto L5d
                L51:
                    io.branch.referral.SystemObserver$AdsParamsFetchEvents r0 = r2
                    if (r0 == 0) goto L58
                    r0.onAdsParamsFetchFinished()
                L58:
                    throw r4
                L59:
                    io.branch.referral.SystemObserver$AdsParamsFetchEvents r4 = r2
                    if (r4 == 0) goto L60
                L5d:
                    r4.onAdsParamsFetchFinished()
                L60:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.C51883.resumeWith(java.lang.Object):void");
            }
        });
    }

    public void fetchInstallReferrer(final Context context, InstallReferrerFetchEvents installReferrerFetchEvents) {
        try {
            try {
                InstallReferrersKt.fetchLatestInstallReferrer(context, new Continuation<InstallReferrerResult>() { // from class: io.branch.referral.SystemObserver.4
                    @Override // kotlin.coroutines.Continuation
                    /* JADX INFO: renamed from: getContext */
                    public CoroutineContext get$context() {
                        return EmptyCoroutineContext.INSTANCE;
                    }

                    @Override // kotlin.coroutines.Continuation
                    public void resumeWith(Object obj) {
                        if (obj != null) {
                            InstallReferrerResult installReferrerResult = (InstallReferrerResult) obj;
                            AppStoreReferrer.processReferrerInfo(context, installReferrerResult.getLatestRawReferrer(), installReferrerResult.getLatestClickTimestamp(), installReferrerResult.getLatestInstallTimestamp(), installReferrerResult.getAppStore());
                        }
                    }
                });
                if (installReferrerFetchEvents == null) {
                    return;
                }
            } catch (Exception e) {
                BranchLogger.m5575d(e.getMessage());
                if (installReferrerFetchEvents == null) {
                    return;
                }
            }
            installReferrerFetchEvents.onInstallReferrersFinished();
        } catch (Throwable th) {
            if (installReferrerFetchEvents != null) {
                installReferrerFetchEvents.onInstallReferrersFinished();
            }
            throw th;
        }
    }

    static String getLocalIPAddress() {
        String str = "";
        try {
            Iterator it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it2.hasNext()) {
                Iterator it3 = Collections.list(((NetworkInterface) it2.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it3.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it3.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                str = hostAddress;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            BranchLogger.m5575d(e.getMessage());
        }
        return str;
    }

    static String getUIMode(Context context) {
        UiModeManager uiModeManager;
        String str;
        if (context != null) {
            try {
                uiModeManager = (UiModeManager) context.getSystemService("uimode");
            } catch (Exception unused) {
                return "UI_MODE_TYPE_UNDEFINED";
            }
        } else {
            uiModeManager = null;
        }
        if (uiModeManager == null) {
            return "UI_MODE_TYPE_UNDEFINED";
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                str = "UI_MODE_TYPE_NORMAL";
                break;
            case 2:
                str = "UI_MODE_TYPE_DESK";
                break;
            case 3:
                str = "UI_MODE_TYPE_CAR";
                break;
            case 4:
                str = "UI_MODE_TYPE_TELEVISION";
                break;
            case 5:
                str = "UI_MODE_TYPE_APPLIANCE";
                break;
            case 6:
                str = "UI_MODE_TYPE_WATCH";
                break;
            default:
                return "UI_MODE_TYPE_UNDEFINED";
        }
        return str;
    }

    static class UniqueId {
        private boolean isRealId;
        private String uniqueId;

        UniqueId(Context context, boolean z) {
            this.isRealId = !z;
            this.uniqueId = "bnc_no_value";
            String string = (context == null || z || !TextUtils.isEmpty(DeviceInfo.getInstance().getSystemObserver().getAID())) ? null : Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                if (z) {
                    string = UUID.randomUUID().toString();
                } else {
                    String randomlyGeneratedUuid = PrefHelper.getInstance(context).getRandomlyGeneratedUuid();
                    if (TextUtils.isEmpty(randomlyGeneratedUuid) || randomlyGeneratedUuid.equals("bnc_no_value")) {
                        randomlyGeneratedUuid = UUID.randomUUID().toString();
                        PrefHelper.getInstance(context).setRandomlyGeneratedUuid(randomlyGeneratedUuid);
                    }
                    string = randomlyGeneratedUuid;
                }
                this.isRealId = false;
            }
            this.uniqueId = string;
        }

        String getId() {
            return this.uniqueId;
        }

        boolean isReal() {
            return this.isRealId;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UniqueId uniqueId = (UniqueId) obj;
            return this.uniqueId.equals(uniqueId.uniqueId) && this.isRealId == uniqueId.isRealId;
        }

        public int hashCode() {
            int i = ((this.isRealId ? 1 : 0) + 1) * 31;
            String str = this.uniqueId;
            return i + (str == null ? 0 : str.hashCode());
        }
    }

    String getAID() {
        return this.GAIDString_;
    }

    int getLATVal() {
        return this.LATVal_;
    }

    void setGAID(String str) {
        this.GAIDString_ = str;
    }

    void setLAT(int i) {
        this.LATVal_ = i;
    }
}
