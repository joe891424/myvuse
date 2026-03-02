package com.salesforce.marketingcloud.registration;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.internal.C4190m;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B½\u0001\b\u0000\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\u0010\u001dJ\r\u0010\u0017\u001a\u00020\bH\u0007¢\u0006\u0002\b&J\r\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0002\b'J\u0019\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cH\u0007¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b*J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u001aHÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b=Jß\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001cHÆ\u0001J\r\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0002\b?J\u0013\u0010@\u001a\u00020\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\r\u0010\u0016\u001a\u00020\bH\u0007¢\u0006\u0002\bCJ\r\u0010\u0018\u001a\u00020\bH\u0007¢\u0006\u0002\bDJ\r\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\bEJ\r\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0002\bFJ\r\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\bGJ\r\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0002\bHJ\r\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0002\bIJ\r\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0002\bJJ\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\bKJ\u000f\u0010\n\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\bLJ\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007¢\u0006\u0002\bMJ\r\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0002\bNJ\r\u0010O\u001a\u00020\u0003H\u0000¢\u0006\u0002\bPJ\t\u0010Q\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0017\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u001eR\u0013\u0010\f\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001eR\u001f\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001c8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001fR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001eR\u0013\u0010\t\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001eR\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010 R\u0013\u0010\u0016\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001eR\u001c\u0010\u0005\u001a\u00020\u00068\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0013\u0010\u0018\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001eR\u0013\u0010\u000f\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010 R\u0013\u0010\u0015\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001eR\u0013\u0010\u0011\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001eR\u0013\u0010\u0010\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010 R\u0013\u0010\u0012\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010 R\u0013\u0010\u000b\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001eR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010%R\u0013\u0010\u0013\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"¨\u0006R"}, m5598d2 = {"Lcom/salesforce/marketingcloud/registration/Registration;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "id", "", "signedString", "", "deviceId", "systemToken", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "appVersion", C4352k.a.f5652f, "", "locationEnabled", "proximityEnabled", "platformVersion", "pushEnabled", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "contactKey", "platform", C4352k.a.f5659m, "appId", "locale", C4352k.a.f5653g, "", C4352k.a.f5654h, "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;)V", "()Ljava/lang/String;", "()Ljava/util/Map;", "()Z", "-id", "()I", "setId$sdk_release", "(I)V", "()Ljava/util/Set;", "-deprecated_appId", "-deprecated_appVersion", "-deprecated_attributes", "component1", "component1$sdk_release", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "-deprecated_contactKey", "copy", "-deprecated_deviceId", "equals", "other", "hashCode", "-deprecated_hwid", "-deprecated_locale", "-deprecated_locationEnabled", "-deprecated_platform", "-deprecated_platformVersion", "-deprecated_proximityEnabled", "-deprecated_pushEnabled", "-deprecated_sdkVersion", "-deprecated_signedString", "-deprecated_systemToken", "-deprecated_tags", "-deprecated_timeZone", "toJson", "toJson$sdk_release", "toString", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class Registration {
    private final String appId;
    private final String appVersion;
    private final Map<String, String> attributes;
    private final String contactKey;
    private final String deviceId;
    private final boolean dst;
    private final String hwid;
    private int id;
    private final String locale;
    private final boolean locationEnabled;
    private final String platform;
    private final String platformVersion;
    private final boolean proximityEnabled;
    private final boolean pushEnabled;
    private final String sdkVersion;
    private final String signedString;
    private final String systemToken;
    private final Set<String> tags;
    private final int timeZone;

    public Registration(int i, String str, String deviceId, String str2, String sdkVersion, String appVersion, boolean z, boolean z2, boolean z3, String platformVersion, boolean z4, int i2, String str3, String platform, String hwid, String appId, String locale, Set<String> tags, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(hwid, "hwid");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.id = i;
        this.signedString = str;
        this.deviceId = deviceId;
        this.systemToken = str2;
        this.sdkVersion = sdkVersion;
        this.appVersion = appVersion;
        this.dst = z;
        this.locationEnabled = z2;
        this.proximityEnabled = z3;
        this.platformVersion = platformVersion;
        this.pushEnabled = z4;
        this.timeZone = i2;
        this.contactKey = str3;
        this.platform = platform;
        this.hwid = hwid;
        this.appId = appId;
        this.locale = locale;
        this.tags = tags;
        this.attributes = attributes;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "appId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_appId, reason: not valid java name and from getter */
    public final String getAppId() {
        return this.appId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "appVersion", imports = {}))
    /* JADX INFO: renamed from: -deprecated_appVersion, reason: not valid java name and from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = C4352k.a.f5654h, imports = {}))
    /* JADX INFO: renamed from: -deprecated_attributes, reason: not valid java name */
    public final Map<String, String> m6714deprecated_attributes() {
        return this.attributes;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "contactKey", imports = {}))
    /* JADX INFO: renamed from: -deprecated_contactKey, reason: not valid java name and from getter */
    public final String getContactKey() {
        return this.contactKey;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deviceId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_deviceId, reason: not valid java name and from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = C4352k.a.f5659m, imports = {}))
    /* JADX INFO: renamed from: -deprecated_hwid, reason: not valid java name and from getter */
    public final String getHwid() {
        return this.hwid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locale", imports = {}))
    /* JADX INFO: renamed from: -deprecated_locale, reason: not valid java name and from getter */
    public final String getLocale() {
        return this.locale;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locationEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_locationEnabled, reason: not valid java name and from getter */
    public final boolean getLocationEnabled() {
        return this.locationEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "platform", imports = {}))
    /* JADX INFO: renamed from: -deprecated_platform, reason: not valid java name and from getter */
    public final String getPlatform() {
        return this.platform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "platformVersion", imports = {}))
    /* JADX INFO: renamed from: -deprecated_platformVersion, reason: not valid java name and from getter */
    public final String getPlatformVersion() {
        return this.platformVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proximityEnabled, reason: not valid java name and from getter */
    public final boolean getProximityEnabled() {
        return this.proximityEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pushEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pushEnabled, reason: not valid java name and from getter */
    public final boolean getPushEnabled() {
        return this.pushEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.SDK_VERSION, imports = {}))
    /* JADX INFO: renamed from: -deprecated_sdkVersion, reason: not valid java name and from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "signedString", imports = {}))
    /* JADX INFO: renamed from: -deprecated_signedString, reason: not valid java name and from getter */
    public final String getSignedString() {
        return this.signedString;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "systemToken", imports = {}))
    /* JADX INFO: renamed from: -deprecated_systemToken, reason: not valid java name and from getter */
    public final String getSystemToken() {
        return this.systemToken;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = C4352k.a.f5653g, imports = {}))
    /* JADX INFO: renamed from: -deprecated_tags, reason: not valid java name */
    public final Set<String> m6727deprecated_tags() {
        return this.tags;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.TIME_ZONE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_timeZone, reason: not valid java name and from getter */
    public final int getTimeZone() {
        return this.timeZone;
    }

    /* JADX INFO: renamed from: -id, reason: not valid java name and from getter */
    public final int getId() {
        return this.id;
    }

    public final String appId() {
        return this.appId;
    }

    public final String appVersion() {
        return this.appVersion;
    }

    public final Map<String, String> attributes() {
        return this.attributes;
    }

    public final int component1$sdk_release() {
        return this.id;
    }

    public final String component10() {
        return this.platformVersion;
    }

    public final boolean component11() {
        return this.pushEnabled;
    }

    public final int component12() {
        return this.timeZone;
    }

    public final String component13() {
        return this.contactKey;
    }

    public final String component14() {
        return this.platform;
    }

    public final String component15() {
        return this.hwid;
    }

    public final String component16() {
        return this.appId;
    }

    public final String component17() {
        return this.locale;
    }

    public final Set<String> component18() {
        return this.tags;
    }

    public final Map<String, String> component19() {
        return this.attributes;
    }

    public final String component2() {
        return this.signedString;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.systemToken;
    }

    public final String component5() {
        return this.sdkVersion;
    }

    public final String component6() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDst() {
        return this.dst;
    }

    public final boolean component8() {
        return this.locationEnabled;
    }

    public final boolean component9() {
        return this.proximityEnabled;
    }

    public final String contactKey() {
        return this.contactKey;
    }

    public final Registration copy(int id, String signedString, String deviceId, String systemToken, String sdkVersion, String appVersion, boolean dst, boolean locationEnabled, boolean proximityEnabled, String platformVersion, boolean pushEnabled, int timeZone, String contactKey, String platform, String hwid, String appId, String locale, Set<String> tags, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(hwid, "hwid");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new Registration(id, signedString, deviceId, systemToken, sdkVersion, appVersion, dst, locationEnabled, proximityEnabled, platformVersion, pushEnabled, timeZone, contactKey, platform, hwid, appId, locale, tags, attributes);
    }

    public final String deviceId() {
        return this.deviceId;
    }

    public final boolean dst() {
        return this.dst;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Registration)) {
            return false;
        }
        Registration registration = (Registration) other;
        return this.id == registration.id && Intrinsics.areEqual(this.signedString, registration.signedString) && Intrinsics.areEqual(this.deviceId, registration.deviceId) && Intrinsics.areEqual(this.systemToken, registration.systemToken) && Intrinsics.areEqual(this.sdkVersion, registration.sdkVersion) && Intrinsics.areEqual(this.appVersion, registration.appVersion) && this.dst == registration.dst && this.locationEnabled == registration.locationEnabled && this.proximityEnabled == registration.proximityEnabled && Intrinsics.areEqual(this.platformVersion, registration.platformVersion) && this.pushEnabled == registration.pushEnabled && this.timeZone == registration.timeZone && Intrinsics.areEqual(this.contactKey, registration.contactKey) && Intrinsics.areEqual(this.platform, registration.platform) && Intrinsics.areEqual(this.hwid, registration.hwid) && Intrinsics.areEqual(this.appId, registration.appId) && Intrinsics.areEqual(this.locale, registration.locale) && Intrinsics.areEqual(this.tags, registration.tags) && Intrinsics.areEqual(this.attributes, registration.attributes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.signedString;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.deviceId.hashCode()) * 31;
        String str2 = this.systemToken;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.sdkVersion.hashCode()) * 31) + this.appVersion.hashCode()) * 31;
        boolean z = this.dst;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z2 = this.locationEnabled;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean z3 = this.proximityEnabled;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int iHashCode4 = (((i2 + r13) * 31) + this.platformVersion.hashCode()) * 31;
        boolean z4 = this.pushEnabled;
        int iHashCode5 = (((iHashCode4 + (z4 ? 1 : z4)) * 31) + Integer.hashCode(this.timeZone)) * 31;
        String str3 = this.contactKey;
        return ((((((((((((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.platform.hashCode()) * 31) + this.hwid.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.locale.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.attributes.hashCode();
    }

    public final String hwid() {
        return this.hwid;
    }

    public final String locale() {
        return this.locale;
    }

    public final boolean locationEnabled() {
        return this.locationEnabled;
    }

    public final String platform() {
        return this.platform;
    }

    public final String platformVersion() {
        return this.platformVersion;
    }

    public final boolean proximityEnabled() {
        return this.proximityEnabled;
    }

    public final boolean pushEnabled() {
        return this.pushEnabled;
    }

    public final String sdkVersion() {
        return this.sdkVersion;
    }

    public final void setId$sdk_release(int i) {
        this.id = i;
    }

    public final String signedString() {
        return this.signedString;
    }

    public final String systemToken() {
        return this.systemToken;
    }

    public final Set<String> tags() {
        return this.tags;
    }

    public final int timeZone() {
        return this.timeZone;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("signedString", this.signedString);
        jSONObject.put("deviceID", this.deviceId);
        String str = this.systemToken;
        if (str != null) {
            jSONObject.put("device_Token", str);
        }
        jSONObject.put("sdk_Version", this.sdkVersion);
        jSONObject.put("app_Version", this.appVersion);
        jSONObject.put("dST", this.dst);
        jSONObject.put("location_Enabled", this.locationEnabled);
        jSONObject.put("proximity_Enabled", this.proximityEnabled);
        jSONObject.put("platform_Version", this.platformVersion);
        jSONObject.put("push_Enabled", this.pushEnabled);
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, String.valueOf(this.timeZone));
        String str2 = this.contactKey;
        if (str2 != null) {
            jSONObject.put("subscriberKey", str2);
        }
        jSONObject.put("platform", this.platform);
        jSONObject.put(C4352k.a.f5659m, this.hwid);
        jSONObject.put("etAppId", this.appId);
        jSONObject.put("locale", this.locale);
        jSONObject.put(C4352k.a.f5653g, new JSONArray((Collection) new TreeSet(this.tags)));
        jSONObject.put(C4352k.a.f5654h, C4190m.m3407a(MapsKt.toSortedMap(this.attributes)));
        return jSONObject;
    }

    public String toString() {
        return "Registration(id=" + this.id + ", signedString=" + this.signedString + ", deviceId=" + this.deviceId + ", systemToken=" + this.systemToken + ", sdkVersion=" + this.sdkVersion + ", appVersion=" + this.appVersion + ", dst=" + this.dst + ", locationEnabled=" + this.locationEnabled + ", proximityEnabled=" + this.proximityEnabled + ", platformVersion=" + this.platformVersion + ", pushEnabled=" + this.pushEnabled + ", timeZone=" + this.timeZone + ", contactKey=" + this.contactKey + ", platform=" + this.platform + ", hwid=" + this.hwid + ", appId=" + this.appId + ", locale=" + this.locale + ", tags=" + this.tags + ", attributes=" + this.attributes + ")";
    }

    public /* synthetic */ Registration(int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, boolean z4, int i2, String str7, String str8, String str9, String str10, String str11, Set set, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, str, str2, (i3 & 8) != 0 ? null : str3, str4, str5, z, z2, z3, str6, z4, i2, (i3 & 4096) != 0 ? null : str7, str8, str9, str10, str11, set, map);
    }

    public Registration(JSONObject json) throws JSONException {
        Object objValueOf;
        String string;
        Intrinsics.checkNotNullParameter(json, "json");
        String strOptString = json.optString("signedString");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        String string2 = json.getString("deviceID");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String strOptString2 = json.optString("device_Token");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        String string3 = json.getString("sdk_Version");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = json.getString("app_Version");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        boolean z = json.getBoolean("dST");
        boolean z2 = json.getBoolean("location_Enabled");
        boolean z3 = json.getBoolean("proximity_Enabled");
        String string5 = json.getString("platform_Version");
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        boolean z4 = json.getBoolean("push_Enabled");
        String string6 = json.getString(RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        int i = Integer.parseInt(string6);
        String strOptString3 = json.optString("subscriberKey");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        String string7 = json.getString("platform");
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = json.getString(C4352k.a.f5659m);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        String string9 = json.getString("etAppId");
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        String string10 = json.getString("locale");
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        JSONArray jSONArray = json.getJSONArray(C4352k.a.f5653g);
        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            Iterator<Integer> it3 = it2;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            boolean z5 = z4;
            String str = string5;
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                objValueOf = jSONArray.getJSONObject(iNextInt);
                if (objValueOf == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                objValueOf = Integer.valueOf(jSONArray.getInt(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                objValueOf = Double.valueOf(jSONArray.getDouble(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                objValueOf = Long.valueOf(jSONArray.getLong(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                objValueOf = Boolean.valueOf(jSONArray.getBoolean(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = jSONArray.getString(iNextInt);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                arrayList.add(string);
                it2 = it3;
                z4 = z5;
                string5 = str;
            } else {
                objValueOf = jSONArray.get(iNextInt);
                if (objValueOf == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            string = (String) objValueOf;
            arrayList.add(string);
            it2 = it3;
            z4 = z5;
            string5 = str;
        }
        String str2 = string5;
        boolean z6 = z4;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!TextUtils.isEmpty((String) obj)) {
                arrayList2.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList2);
        JSONArray jSONArray2 = json.getJSONArray(C4352k.a.f5654h);
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
        this(0, strM3408b, string2, strM3408b2, string3, string4, z, z2, z3, str2, z6, i, strM3408b3, string7, string8, string9, string10, set, C4190m.m3410b(jSONArray2));
    }
}
