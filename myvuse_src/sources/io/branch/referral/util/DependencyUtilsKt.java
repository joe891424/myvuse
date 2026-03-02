package io.branch.referral.util;

import com.newrelic.agent.android.agentdata.HexAttribute;
import io.branch.referral.BranchLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DependencyUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"billingGooglePlayClass", "", "huaweiAdvertisingIdClientClass", "huaweiInstallReferrerClass", "playStoreAdvertisingIdClientClass", "playStoreInstallReferrerClass", "samsungInstallReferrerClass", "xiaomiInstallReferrerClass", "classExists", "", HexAttribute.HEX_ATTR_CLASS_NAME, "Branch-SDK_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DependencyUtilsKt {
    public static final String billingGooglePlayClass = "com.android.billingclient.api.BillingClient";
    public static final String huaweiAdvertisingIdClientClass = "com.huawei.hms.ads.identifier.AdvertisingIdClient";
    public static final String huaweiInstallReferrerClass = "com.huawei.hms.ads.installreferrer.api.InstallReferrerClient";
    public static final String playStoreAdvertisingIdClientClass = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    public static final String playStoreInstallReferrerClass = "com.android.installreferrer.api.InstallReferrerClient";
    public static final String samsungInstallReferrerClass = "com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient";
    public static final String xiaomiInstallReferrerClass = "com.miui.referrer.api.GetAppsReferrerClient";

    public static final boolean classExists(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException unused) {
            BranchLogger.m5578v("Could not find " + className + ". If expected, import the dependency into your app.");
            return false;
        }
    }
}
