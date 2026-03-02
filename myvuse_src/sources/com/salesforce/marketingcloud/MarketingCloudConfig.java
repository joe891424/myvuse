package com.salesforce.marketingcloud;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.proximity.ProximityNotificationCustomizationOptions;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleConfig;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZB§\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0000H\u0001¢\u0006\u0002\b$J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b%J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0012HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000e\u0010.\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b/J\u000e\u00100\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b1J\u000e\u00102\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b3J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003JÏ\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003HÆ\u0001J\r\u0010\u000f\u001a\u00020\tH\u0007¢\u0006\u0002\b=J\u0013\u0010>\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010?HÖ\u0003J\r\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\b@J\t\u0010A\u001a\u00020BHÖ\u0001J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\bCJ \u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bLJ\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\bMJ\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bNJ\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\bOJ\r\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0002\bPJ\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\bQJ\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\bRJ\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bSJ\u0006\u0010T\u001a\u00020UJ\t\u0010V\u001a\u00020\u0003HÖ\u0001J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\bWJ\r\u0010\u0010\u001a\u00020\tH\u0007¢\u0006\u0002\bXR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001bR\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001cR\u0016\u0010\u0017\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u001bR\u0016\u0010\u0018\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001bR\u0013\u0010\u000f\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001cR\u0013\u0010\n\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0013\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0013\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u0011\u001a\u00020\u00128\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001dR\u0013\u0010\f\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001cR\u0016\u0010\u0019\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u0013\u0010\r\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001fR\u0013\u0010\u0010\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001c¨\u0006["}, m5598d2 = {"Lcom/salesforce/marketingcloud/MarketingCloudConfig;", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/push/PushModuleConfig;", "applicationId", "", "accessToken", "senderId", "marketingCloudServerUrl", "mid", "analyticsEnabled", "", "geofencingEnabled", "inboxEnabled", "piAnalyticsEnabled", "proximityEnabled", "markMessageReadOnInboxNotificationOpen", "delayRegistrationUntilContactKeyIsSet", "useLegacyPiIdentifier", "notificationCustomizationOptions", "Lcom/salesforce/marketingcloud/notifications/NotificationCustomizationOptions;", "proximityNotificationCustomizationOptions", "Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "urlHandler", "Lcom/salesforce/marketingcloud/UrlHandler;", "appPackageName", "appVersionName", "predictiveIntelligenceServerUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZZLcom/salesforce/marketingcloud/notifications/NotificationCustomizationOptions;Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;Lcom/salesforce/marketingcloud/UrlHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "()Z", "()Lcom/salesforce/marketingcloud/notifications/NotificationCustomizationOptions;", "()Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "()Lcom/salesforce/marketingcloud/UrlHandler;", "-deprecated_accessToken", "-deprecated_analyticsEnabled", "applicationChanged", "other", "-applicationChanged", "-deprecated_applicationId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component17$sdk_release", "component18", "component18$sdk_release", "component19", "component19$sdk_release", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "-deprecated_delayRegistrationUntilContactKeyIsSet", "equals", "", "-deprecated_geofencingEnabled", "hashCode", "", "-deprecated_inboxEnabled", "init", "", "context", "Landroid/content/Context;", "components", "Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkComponents;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleReadyListener;", "-deprecated_markMessageReadOnInboxNotificationOpen", "-deprecated_marketingCloudServerUrl", "-deprecated_mid", "-deprecated_notificationCustomizationOptions", "-deprecated_piAnalyticsEnabled", "-deprecated_proximityEnabled", "-deprecated_proximityNotificationCustomizationOptions", "-deprecated_senderId", "toBuilder", "Lcom/salesforce/marketingcloud/MarketingCloudConfig$Builder;", "toString", "-deprecated_urlHandler", "-deprecated_useLegacyPiIdentifier", "Builder", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class MarketingCloudConfig extends PushModuleConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = C4170g.m3197a("MarketingCloudConfig");
    private final String accessToken;
    private final boolean analyticsEnabled;
    private final String appPackageName;
    private final String appVersionName;
    private final String applicationId;
    private final boolean delayRegistrationUntilContactKeyIsSet;
    private final boolean geofencingEnabled;
    private final boolean inboxEnabled;
    private final boolean markMessageReadOnInboxNotificationOpen;
    private final String marketingCloudServerUrl;
    private final String mid;
    private final NotificationCustomizationOptions notificationCustomizationOptions;
    private final boolean piAnalyticsEnabled;
    private final String predictiveIntelligenceServerUrl;
    private final boolean proximityEnabled;
    private final ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions;
    private final String senderId;
    private final UrlHandler urlHandler;
    private final boolean useLegacyPiIdentifier;

    @Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\t\b\u0010¢\u0006\u0004\b>\u0010?B\u0011\b\u0010\u0012\u0006\u0010@\u001a\u000201¢\u0006\u0004\b>\u0010AJ#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0082\bJ!\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0082\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0012J\u0017\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0002H\u0007¢\u0006\u0004\b,\u0010-J\u000e\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00103R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00103R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00103R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00103R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00104R\u0016\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00104R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00104R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00104R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00104R\u0018\u00108\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010<R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00103¨\u0006D"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MarketingCloudConfig$Builder;", "", "", "value", "Lkotlin/Function0;", "lazyMessage", "checkNotEmpty", "checkNotNullOrEmpty", "applicationId", "setApplicationId", "accessToken", "setAccessToken", "senderId", "setSenderId", "marketingCloudServerUrl", "setMarketingCloudServerUrl", "mid", "setMid", "", "analyticsEnabled", "setAnalyticsEnabled", "geofenceEnabled", "setGeofencingEnabled", "inboxEnabled", "setInboxEnabled", "piAnalyticsEnabled", "setPiAnalyticsEnabled", "proximityEnabled", "setProximityEnabled", "Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "options", "setProximityNotificationOptions", "Lcom/salesforce/marketingcloud/UrlHandler;", "urlHandler", "setUrlHandler", "Lcom/salesforce/marketingcloud/notifications/NotificationCustomizationOptions;", "setNotificationCustomizationOptions", "useLegacyPiIdentifier", "setUseLegacyPiIdentifier", "markRead", "setMarkMessageReadOnInboxNotificationOpen", BackgroundFetchConfig.FIELD_DELAY, "setDelayRegistrationUntilContactKeyIsSet", "url", "-setPredictiveIntelligenceServerUrl", "(Ljava/lang/String;)Lcom/salesforce/marketingcloud/MarketingCloudConfig$Builder;", "setPredictiveIntelligenceServerUrl", "Landroid/content/Context;", "context", "Lcom/salesforce/marketingcloud/MarketingCloudConfig;", "build", "Ljava/lang/String;", "Z", "geofencingEnabled", "markMessageReadOnInboxNotificationOpen", "delayRegistrationUntilContactKeyIsSet", "notificationCustomizationOptions", "Lcom/salesforce/marketingcloud/notifications/NotificationCustomizationOptions;", "proximityNotificationCustomizationOptions", "Lcom/salesforce/marketingcloud/proximity/ProximityNotificationCustomizationOptions;", "Lcom/salesforce/marketingcloud/UrlHandler;", "predictiveIntelligenceServerUrl", "<init>", "()V", "config", "(Lcom/salesforce/marketingcloud/MarketingCloudConfig;)V", "Companion", "a", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
    public static final class Builder {
        private static final int ACCESS_TOKEN_LENGTH = 24;
        private static final String INITIAL_PI_VALUE = "";
        private static final String TSE_ERROR_MSG = "An App Endpoint (the Marketing Cloud Server URL) is required in order to configure the SDK. See http://salesforce-marketingcloud.github.io/MarketingCloudSDK-Android for more information.";
        private String accessToken;
        private boolean analyticsEnabled;
        private String applicationId;
        private boolean delayRegistrationUntilContactKeyIsSet;
        private boolean geofencingEnabled;
        private boolean inboxEnabled;
        private boolean markMessageReadOnInboxNotificationOpen;
        private String marketingCloudServerUrl;
        private String mid;
        private NotificationCustomizationOptions notificationCustomizationOptions;
        private boolean piAnalyticsEnabled;
        private String predictiveIntelligenceServerUrl;
        private boolean proximityEnabled;
        private ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions;
        private String senderId;
        private UrlHandler urlHandler;
        private boolean useLegacyPiIdentifier;
        private static final Regex APP_ID_REGEX = new Regex("[0-9a-f]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}");

        public Builder() {
            this.markMessageReadOnInboxNotificationOpen = true;
            this.useLegacyPiIdentifier = true;
            this.predictiveIntelligenceServerUrl = "";
        }

        private final String checkNotEmpty(String value, Function0<? extends Object> lazyMessage) {
            if (value == null || TextUtils.getTrimmedLength(value) != 0) {
                return value;
            }
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }

        private final String checkNotNullOrEmpty(String value, Function0<? extends Object> lazyMessage) {
            if (value == null || TextUtils.getTrimmedLength(value) == 0) {
                throw new IllegalStateException(lazyMessage.invoke().toString());
            }
            return value;
        }

        /* JADX INFO: renamed from: -setPredictiveIntelligenceServerUrl, reason: not valid java name */
        public final Builder m6554setPredictiveIntelligenceServerUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.predictiveIntelligenceServerUrl = url;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.salesforce.marketingcloud.MarketingCloudConfig build(android.content.Context r25) {
            /*
                Method dump skipped, instruction units count: 368
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MarketingCloudConfig.Builder.build(android.content.Context):com.salesforce.marketingcloud.MarketingCloudConfig");
        }

        public final Builder setAccessToken(String accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            this.accessToken = accessToken;
            return this;
        }

        public final Builder setAnalyticsEnabled(boolean analyticsEnabled) {
            this.analyticsEnabled = analyticsEnabled;
            return this;
        }

        public final Builder setApplicationId(String applicationId) {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            this.applicationId = applicationId;
            return this;
        }

        public final Builder setDelayRegistrationUntilContactKeyIsSet(boolean delay) {
            this.delayRegistrationUntilContactKeyIsSet = delay;
            return this;
        }

        public final Builder setGeofencingEnabled(boolean geofenceEnabled) {
            this.geofencingEnabled = geofenceEnabled;
            return this;
        }

        public final Builder setInboxEnabled(boolean inboxEnabled) {
            this.inboxEnabled = inboxEnabled;
            return this;
        }

        public final Builder setMarkMessageReadOnInboxNotificationOpen(boolean markRead) {
            this.markMessageReadOnInboxNotificationOpen = markRead;
            return this;
        }

        public final Builder setMarketingCloudServerUrl(String marketingCloudServerUrl) {
            Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
            this.marketingCloudServerUrl = marketingCloudServerUrl;
            return this;
        }

        public final Builder setMid(String mid) {
            Intrinsics.checkNotNullParameter(mid, "mid");
            this.mid = mid;
            return this;
        }

        public final Builder setNotificationCustomizationOptions(NotificationCustomizationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.notificationCustomizationOptions = options;
            return this;
        }

        public final Builder setPiAnalyticsEnabled(boolean piAnalyticsEnabled) {
            this.piAnalyticsEnabled = piAnalyticsEnabled;
            return this;
        }

        public final Builder setProximityEnabled(boolean proximityEnabled) {
            this.proximityEnabled = proximityEnabled;
            return this;
        }

        public final Builder setProximityNotificationOptions(ProximityNotificationCustomizationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.proximityNotificationCustomizationOptions = options;
            return this;
        }

        public final Builder setSenderId(String senderId) {
            Intrinsics.checkNotNullParameter(senderId, "senderId");
            this.senderId = senderId;
            return this;
        }

        public final Builder setUrlHandler(UrlHandler urlHandler) {
            Intrinsics.checkNotNullParameter(urlHandler, "urlHandler");
            this.urlHandler = urlHandler;
            return this;
        }

        public final Builder setUseLegacyPiIdentifier(boolean useLegacyPiIdentifier) {
            this.useLegacyPiIdentifier = useLegacyPiIdentifier;
            return this;
        }

        public Builder(MarketingCloudConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.markMessageReadOnInboxNotificationOpen = true;
            this.useLegacyPiIdentifier = true;
            this.applicationId = config.applicationId();
            this.accessToken = config.accessToken();
            this.senderId = config.senderId();
            this.marketingCloudServerUrl = config.marketingCloudServerUrl();
            this.mid = config.mid();
            this.analyticsEnabled = config.analyticsEnabled();
            this.geofencingEnabled = config.geofencingEnabled();
            this.inboxEnabled = config.inboxEnabled();
            this.piAnalyticsEnabled = config.piAnalyticsEnabled();
            this.proximityEnabled = config.proximityEnabled();
            this.markMessageReadOnInboxNotificationOpen = config.markMessageReadOnInboxNotificationOpen();
            this.delayRegistrationUntilContactKeyIsSet = config.delayRegistrationUntilContactKeyIsSet();
            this.useLegacyPiIdentifier = config.useLegacyPiIdentifier();
            this.notificationCustomizationOptions = config.notificationCustomizationOptions();
            this.proximityNotificationCustomizationOptions = config.proximityNotificationCustomizationOptions();
            this.urlHandler = config.urlHandler();
            this.predictiveIntelligenceServerUrl = config.predictiveIntelligenceServerUrl();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"Lcom/salesforce/marketingcloud/MarketingCloudConfig$Companion;", "", "()V", "TAG", "", "builder", "Lcom/salesforce/marketingcloud/MarketingCloudConfig$Builder;", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.MarketingCloudConfig$a */
    static final class C4085a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ InitializationStatus f4242a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4085a(InitializationStatus initializationStatus) {
            super(0);
            this.f4242a = initializationStatus;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "InitializationStatus: " + this.f4242a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketingCloudConfig(String applicationId, String accessToken, String str, String marketingCloudServerUrl, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, NotificationCustomizationOptions notificationCustomizationOptions, ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions, UrlHandler urlHandler, String appPackageName, String appVersionName, String predictiveIntelligenceServerUrl) {
        super(applicationId);
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
        Intrinsics.checkNotNullParameter(notificationCustomizationOptions, "notificationCustomizationOptions");
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(predictiveIntelligenceServerUrl, "predictiveIntelligenceServerUrl");
        this.applicationId = applicationId;
        this.accessToken = accessToken;
        this.senderId = str;
        this.marketingCloudServerUrl = marketingCloudServerUrl;
        this.mid = str2;
        this.analyticsEnabled = z;
        this.geofencingEnabled = z2;
        this.inboxEnabled = z3;
        this.piAnalyticsEnabled = z4;
        this.proximityEnabled = z5;
        this.markMessageReadOnInboxNotificationOpen = z6;
        this.delayRegistrationUntilContactKeyIsSet = z7;
        this.useLegacyPiIdentifier = z8;
        this.notificationCustomizationOptions = notificationCustomizationOptions;
        this.proximityNotificationCustomizationOptions = proximityNotificationCustomizationOptions;
        this.urlHandler = urlHandler;
        this.appPackageName = appPackageName;
        this.appVersionName = appVersionName;
        this.predictiveIntelligenceServerUrl = predictiveIntelligenceServerUrl;
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(final ModuleReadyListener listener, InitializationStatus it2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(it2, "it");
        C4170g.m3215e(C4170g.f4785a, TAG, null, new C4085a(it2), 2, null);
        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.salesforce.marketingcloud.MarketingCloudConfig$$ExternalSyntheticLambda1
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
            public final void ready(MarketingCloudSdk marketingCloudSdk) {
                MarketingCloudConfig.init$lambda$1$lambda$0(listener, marketingCloudSdk);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1$lambda$0(ModuleReadyListener listener, MarketingCloudSdk sdk) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        listener.ready(sdk);
    }

    /* JADX INFO: renamed from: -applicationChanged, reason: not valid java name */
    public final boolean m6537applicationChanged(MarketingCloudConfig other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return (Intrinsics.areEqual(this.applicationId, other.applicationId) && Intrinsics.areEqual(this.accessToken, other.accessToken)) ? false : true;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "accessToken", imports = {}))
    /* JADX INFO: renamed from: -deprecated_accessToken, reason: not valid java name and from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "analyticsEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_analyticsEnabled, reason: not valid java name and from getter */
    public final boolean getAnalyticsEnabled() {
        return this.analyticsEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "applicationId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_applicationId, reason: not valid java name and from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delayRegistrationUntilContactKeyIsSet", imports = {}))
    /* JADX INFO: renamed from: -deprecated_delayRegistrationUntilContactKeyIsSet, reason: not valid java name and from getter */
    public final boolean getDelayRegistrationUntilContactKeyIsSet() {
        return this.delayRegistrationUntilContactKeyIsSet;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "geofencingEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_geofencingEnabled, reason: not valid java name and from getter */
    public final boolean getGeofencingEnabled() {
        return this.geofencingEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "inboxEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_inboxEnabled, reason: not valid java name and from getter */
    public final boolean getInboxEnabled() {
        return this.inboxEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "markMessageReadOnInboxNotificationOpen", imports = {}))
    /* JADX INFO: renamed from: -deprecated_markMessageReadOnInboxNotificationOpen, reason: not valid java name and from getter */
    public final boolean getMarkMessageReadOnInboxNotificationOpen() {
        return this.markMessageReadOnInboxNotificationOpen;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "marketingCloudServerUrl", imports = {}))
    /* JADX INFO: renamed from: -deprecated_marketingCloudServerUrl, reason: not valid java name and from getter */
    public final String getMarketingCloudServerUrl() {
        return this.marketingCloudServerUrl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mid", imports = {}))
    /* JADX INFO: renamed from: -deprecated_mid, reason: not valid java name and from getter */
    public final String getMid() {
        return this.mid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "notificationCustomizationOptions", imports = {}))
    /* JADX INFO: renamed from: -deprecated_notificationCustomizationOptions, reason: not valid java name and from getter */
    public final NotificationCustomizationOptions getNotificationCustomizationOptions() {
        return this.notificationCustomizationOptions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "piAnalyticsEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_piAnalyticsEnabled, reason: not valid java name and from getter */
    public final boolean getPiAnalyticsEnabled() {
        return this.piAnalyticsEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityEnabled", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proximityEnabled, reason: not valid java name and from getter */
    public final boolean getProximityEnabled() {
        return this.proximityEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityNotificationCustomizationOptions", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proximityNotificationCustomizationOptions, reason: not valid java name and from getter */
    public final ProximityNotificationCustomizationOptions getProximityNotificationCustomizationOptions() {
        return this.proximityNotificationCustomizationOptions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "senderId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_senderId, reason: not valid java name and from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "urlHandler", imports = {}))
    /* JADX INFO: renamed from: -deprecated_urlHandler, reason: not valid java name and from getter */
    public final UrlHandler getUrlHandler() {
        return this.urlHandler;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "useLegacyPiIdentifier", imports = {}))
    /* JADX INFO: renamed from: -deprecated_useLegacyPiIdentifier, reason: not valid java name and from getter */
    public final boolean getUseLegacyPiIdentifier() {
        return this.useLegacyPiIdentifier;
    }

    public final String accessToken() {
        return this.accessToken;
    }

    public final boolean analyticsEnabled() {
        return this.analyticsEnabled;
    }

    /* JADX INFO: renamed from: appPackageName, reason: from getter */
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    /* JADX INFO: renamed from: appVersionName, reason: from getter */
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final String applicationId() {
        return this.applicationId;
    }

    public final String component1() {
        return this.applicationId;
    }

    public final boolean component10() {
        return this.proximityEnabled;
    }

    public final boolean component11() {
        return this.markMessageReadOnInboxNotificationOpen;
    }

    public final boolean component12() {
        return this.delayRegistrationUntilContactKeyIsSet;
    }

    public final boolean component13() {
        return this.useLegacyPiIdentifier;
    }

    public final NotificationCustomizationOptions component14() {
        return this.notificationCustomizationOptions;
    }

    public final ProximityNotificationCustomizationOptions component15() {
        return this.proximityNotificationCustomizationOptions;
    }

    public final UrlHandler component16() {
        return this.urlHandler;
    }

    public final String component17$sdk_release() {
        return this.appPackageName;
    }

    public final String component18$sdk_release() {
        return this.appVersionName;
    }

    /* JADX INFO: renamed from: component19$sdk_release, reason: from getter */
    public final String getPredictiveIntelligenceServerUrl() {
        return this.predictiveIntelligenceServerUrl;
    }

    public final String component2() {
        return this.accessToken;
    }

    public final String component3() {
        return this.senderId;
    }

    public final String component4() {
        return this.marketingCloudServerUrl;
    }

    public final String component5() {
        return this.mid;
    }

    public final boolean component6() {
        return this.analyticsEnabled;
    }

    public final boolean component7() {
        return this.geofencingEnabled;
    }

    public final boolean component8() {
        return this.inboxEnabled;
    }

    public final boolean component9() {
        return this.piAnalyticsEnabled;
    }

    public final MarketingCloudConfig copy(String applicationId, String accessToken, String senderId, String marketingCloudServerUrl, String mid, boolean analyticsEnabled, boolean geofencingEnabled, boolean inboxEnabled, boolean piAnalyticsEnabled, boolean proximityEnabled, boolean markMessageReadOnInboxNotificationOpen, boolean delayRegistrationUntilContactKeyIsSet, boolean useLegacyPiIdentifier, NotificationCustomizationOptions notificationCustomizationOptions, ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions, UrlHandler urlHandler, String appPackageName, String appVersionName, String predictiveIntelligenceServerUrl) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
        Intrinsics.checkNotNullParameter(notificationCustomizationOptions, "notificationCustomizationOptions");
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(predictiveIntelligenceServerUrl, "predictiveIntelligenceServerUrl");
        return new MarketingCloudConfig(applicationId, accessToken, senderId, marketingCloudServerUrl, mid, analyticsEnabled, geofencingEnabled, inboxEnabled, piAnalyticsEnabled, proximityEnabled, markMessageReadOnInboxNotificationOpen, delayRegistrationUntilContactKeyIsSet, useLegacyPiIdentifier, notificationCustomizationOptions, proximityNotificationCustomizationOptions, urlHandler, appPackageName, appVersionName, predictiveIntelligenceServerUrl);
    }

    public final boolean delayRegistrationUntilContactKeyIsSet() {
        return this.delayRegistrationUntilContactKeyIsSet;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketingCloudConfig)) {
            return false;
        }
        MarketingCloudConfig marketingCloudConfig = (MarketingCloudConfig) other;
        return Intrinsics.areEqual(this.applicationId, marketingCloudConfig.applicationId) && Intrinsics.areEqual(this.accessToken, marketingCloudConfig.accessToken) && Intrinsics.areEqual(this.senderId, marketingCloudConfig.senderId) && Intrinsics.areEqual(this.marketingCloudServerUrl, marketingCloudConfig.marketingCloudServerUrl) && Intrinsics.areEqual(this.mid, marketingCloudConfig.mid) && this.analyticsEnabled == marketingCloudConfig.analyticsEnabled && this.geofencingEnabled == marketingCloudConfig.geofencingEnabled && this.inboxEnabled == marketingCloudConfig.inboxEnabled && this.piAnalyticsEnabled == marketingCloudConfig.piAnalyticsEnabled && this.proximityEnabled == marketingCloudConfig.proximityEnabled && this.markMessageReadOnInboxNotificationOpen == marketingCloudConfig.markMessageReadOnInboxNotificationOpen && this.delayRegistrationUntilContactKeyIsSet == marketingCloudConfig.delayRegistrationUntilContactKeyIsSet && this.useLegacyPiIdentifier == marketingCloudConfig.useLegacyPiIdentifier && Intrinsics.areEqual(this.notificationCustomizationOptions, marketingCloudConfig.notificationCustomizationOptions) && Intrinsics.areEqual(this.proximityNotificationCustomizationOptions, marketingCloudConfig.proximityNotificationCustomizationOptions) && Intrinsics.areEqual(this.urlHandler, marketingCloudConfig.urlHandler) && Intrinsics.areEqual(this.appPackageName, marketingCloudConfig.appPackageName) && Intrinsics.areEqual(this.appVersionName, marketingCloudConfig.appVersionName) && Intrinsics.areEqual(this.predictiveIntelligenceServerUrl, marketingCloudConfig.predictiveIntelligenceServerUrl);
    }

    public final boolean geofencingEnabled() {
        return this.geofencingEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((this.applicationId.hashCode() * 31) + this.accessToken.hashCode()) * 31;
        String str = this.senderId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.marketingCloudServerUrl.hashCode()) * 31;
        String str2 = this.mid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.analyticsEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z2 = this.geofencingEnabled;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean z3 = this.inboxEnabled;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int i3 = (i2 + r13) * 31;
        boolean z4 = this.piAnalyticsEnabled;
        ?? r14 = z4;
        if (z4) {
            r14 = 1;
        }
        int i4 = (i3 + r14) * 31;
        boolean z5 = this.proximityEnabled;
        ?? r15 = z5;
        if (z5) {
            r15 = 1;
        }
        int i5 = (i4 + r15) * 31;
        boolean z6 = this.markMessageReadOnInboxNotificationOpen;
        ?? r16 = z6;
        if (z6) {
            r16 = 1;
        }
        int i6 = (i5 + r16) * 31;
        boolean z7 = this.delayRegistrationUntilContactKeyIsSet;
        ?? r17 = z7;
        if (z7) {
            r17 = 1;
        }
        int i7 = (i6 + r17) * 31;
        boolean z8 = this.useLegacyPiIdentifier;
        int iHashCode4 = (((i7 + (z8 ? 1 : z8)) * 31) + this.notificationCustomizationOptions.hashCode()) * 31;
        ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = this.proximityNotificationCustomizationOptions;
        int iHashCode5 = (iHashCode4 + (proximityNotificationCustomizationOptions == null ? 0 : proximityNotificationCustomizationOptions.hashCode())) * 31;
        UrlHandler urlHandler = this.urlHandler;
        return ((((((iHashCode5 + (urlHandler != null ? urlHandler.hashCode() : 0)) * 31) + this.appPackageName.hashCode()) * 31) + this.appVersionName.hashCode()) * 31) + this.predictiveIntelligenceServerUrl.hashCode();
    }

    public final boolean inboxEnabled() {
        return this.inboxEnabled;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public void init(Context context, SFMCSdkComponents components, final ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MarketingCloudSdk.m2833b(context, this, components, new MarketingCloudSdk.InitializationListener() { // from class: com.salesforce.marketingcloud.MarketingCloudConfig$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.InitializationListener
            public final void complete(InitializationStatus initializationStatus) {
                MarketingCloudConfig.init$lambda$1(listener, initializationStatus);
            }
        });
    }

    public final boolean markMessageReadOnInboxNotificationOpen() {
        return this.markMessageReadOnInboxNotificationOpen;
    }

    public final String marketingCloudServerUrl() {
        return this.marketingCloudServerUrl;
    }

    public final String mid() {
        return this.mid;
    }

    public final NotificationCustomizationOptions notificationCustomizationOptions() {
        return this.notificationCustomizationOptions;
    }

    public final boolean piAnalyticsEnabled() {
        return this.piAnalyticsEnabled;
    }

    public final String predictiveIntelligenceServerUrl() {
        return this.predictiveIntelligenceServerUrl;
    }

    public final boolean proximityEnabled() {
        return this.proximityEnabled;
    }

    public final ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions() {
        return this.proximityNotificationCustomizationOptions;
    }

    public final String senderId() {
        return this.senderId;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "MarketingCloudConfig(applicationId=" + this.applicationId + ", accessToken=" + this.accessToken + ", senderId=" + this.senderId + ", marketingCloudServerUrl=" + this.marketingCloudServerUrl + ", mid=" + this.mid + ", analyticsEnabled=" + this.analyticsEnabled + ", geofencingEnabled=" + this.geofencingEnabled + ", inboxEnabled=" + this.inboxEnabled + ", piAnalyticsEnabled=" + this.piAnalyticsEnabled + ", proximityEnabled=" + this.proximityEnabled + ", markMessageReadOnInboxNotificationOpen=" + this.markMessageReadOnInboxNotificationOpen + ", delayRegistrationUntilContactKeyIsSet=" + this.delayRegistrationUntilContactKeyIsSet + ", useLegacyPiIdentifier=" + this.useLegacyPiIdentifier + ", notificationCustomizationOptions=" + this.notificationCustomizationOptions + ", proximityNotificationCustomizationOptions=" + this.proximityNotificationCustomizationOptions + ", urlHandler=" + this.urlHandler + ", appPackageName=" + this.appPackageName + ", appVersionName=" + this.appVersionName + ", predictiveIntelligenceServerUrl=" + this.predictiveIntelligenceServerUrl + ")";
    }

    public final UrlHandler urlHandler() {
        return this.urlHandler;
    }

    public final boolean useLegacyPiIdentifier() {
        return this.useLegacyPiIdentifier;
    }
}
