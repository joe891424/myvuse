package com.salesforce.marketingcloud.registration;

import android.os.Build;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.f */
/* JADX INFO: loaded from: classes6.dex */
public final class C4311f {

    /* JADX INFO: renamed from: a */
    private final String f5515a;

    /* JADX INFO: renamed from: b */
    private final String f5516b;

    /* JADX INFO: renamed from: c */
    private final String f5517c;

    /* JADX INFO: renamed from: d */
    private final String f5518d;

    /* JADX INFO: renamed from: e */
    private final String f5519e;

    /* JADX INFO: renamed from: f */
    private final String f5520f;

    /* JADX INFO: renamed from: g */
    private final String f5521g;

    public C4311f(String deviceId, String appId, String appVersion) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.f5515a = deviceId;
        this.f5516b = appId;
        this.f5517c = appVersion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%s %s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.f5518d = str;
        this.f5519e = "Android";
        String str2 = Build.VERSION.RELEASE;
        this.f5520f = str2 == null ? "Unknown Release" : str2;
        String sdkVersionName = MarketingCloudSdk.getSdkVersionName();
        Intrinsics.checkNotNullExpressionValue(sdkVersionName, "getSdkVersionName(...)");
        this.f5521g = sdkVersionName;
    }

    /* JADX INFO: renamed from: a */
    public final String m3964a() {
        return this.f5515a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3965b() {
        return this.f5516b;
    }

    /* JADX INFO: renamed from: c */
    public final String m3966c() {
        return this.f5517c;
    }

    /* JADX INFO: renamed from: d */
    public final String m3967d() {
        return this.f5516b;
    }

    /* JADX INFO: renamed from: e */
    public final String m3968e() {
        return this.f5517c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4311f)) {
            return false;
        }
        C4311f c4311f = (C4311f) obj;
        return Intrinsics.areEqual(this.f5515a, c4311f.f5515a) && Intrinsics.areEqual(this.f5516b, c4311f.f5516b) && Intrinsics.areEqual(this.f5517c, c4311f.f5517c);
    }

    /* JADX INFO: renamed from: f */
    public final String m3969f() {
        return this.f5515a;
    }

    /* JADX INFO: renamed from: g */
    public final String m3970g() {
        return this.f5518d;
    }

    /* JADX INFO: renamed from: h */
    public final String m3971h() {
        return this.f5519e;
    }

    public int hashCode() {
        return (((this.f5515a.hashCode() * 31) + this.f5516b.hashCode()) * 31) + this.f5517c.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final String m3972i() {
        return this.f5520f;
    }

    /* JADX INFO: renamed from: j */
    public final String m3973j() {
        return this.f5521g;
    }

    public String toString() {
        return "RegistrationMeta(deviceId=" + this.f5515a + ", appId=" + this.f5516b + ", appVersion=" + this.f5517c + ")";
    }

    /* JADX INFO: renamed from: a */
    public final C4311f m3963a(String deviceId, String appId, String appVersion) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return new C4311f(deviceId, appId, appVersion);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4311f m3962a(C4311f c4311f, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c4311f.f5515a;
        }
        if ((i & 2) != 0) {
            str2 = c4311f.f5516b;
        }
        if ((i & 4) != 0) {
            str3 = c4311f.f5517c;
        }
        return c4311f.m3963a(str, str2, str3);
    }
}
