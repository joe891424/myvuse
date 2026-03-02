package com.yoti.mobile.android.yotisdkcore.core.data.model;

import androidx.core.app.FrameMetricsAggregator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Js\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Configuration;", "", "primaryColor", "", "secondaryColor", "fontColor", "locale", "presetIssuingCountry", "successUrl", "errorUrl", "hideLogo", "", "privacyPolicyUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getErrorUrl", "()Ljava/lang/String;", "getFontColor", "getHideLogo", "()Z", "getLocale", "getPresetIssuingCountry", "getPrimaryColor", "getPrivacyPolicyUrl", "getSecondaryColor", "getSuccessUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Configuration {

    @SerializedName("error_url")
    private final String errorUrl;

    @SerializedName("font_colour")
    private final String fontColor;

    @SerializedName("hide_logo")
    private final boolean hideLogo;

    @SerializedName("locale")
    private final String locale;

    @SerializedName("preset_issuing_country")
    private final String presetIssuingCountry;

    @SerializedName("primary_colour")
    private final String primaryColor;

    @SerializedName("privacy_policy_url")
    private final String privacyPolicyUrl;

    @SerializedName("secondary_colour")
    private final String secondaryColor;

    @SerializedName("success_url")
    private final String successUrl;

    public Configuration() {
        this(null, null, null, null, null, null, null, false, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public Configuration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8) {
        this.primaryColor = str;
        this.secondaryColor = str2;
        this.fontColor = str3;
        this.locale = str4;
        this.presetIssuingCountry = str5;
        this.successUrl = str6;
        this.errorUrl = str7;
        this.hideLogo = z;
        this.privacyPolicyUrl = str8;
    }

    public /* synthetic */ Configuration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? false : z, (i & 256) == 0 ? str8 : null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFontColor() {
        return this.fontColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPresetIssuingCountry() {
        return this.presetIssuingCountry;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSuccessUrl() {
        return this.successUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getErrorUrl() {
        return this.errorUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHideLogo() {
        return this.hideLogo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final Configuration copy(String primaryColor, String secondaryColor, String fontColor, String locale, String presetIssuingCountry, String successUrl, String errorUrl, boolean hideLogo, String privacyPolicyUrl) {
        return new Configuration(primaryColor, secondaryColor, fontColor, locale, presetIssuingCountry, successUrl, errorUrl, hideLogo, privacyPolicyUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) other;
        return Intrinsics.areEqual(this.primaryColor, configuration.primaryColor) && Intrinsics.areEqual(this.secondaryColor, configuration.secondaryColor) && Intrinsics.areEqual(this.fontColor, configuration.fontColor) && Intrinsics.areEqual(this.locale, configuration.locale) && Intrinsics.areEqual(this.presetIssuingCountry, configuration.presetIssuingCountry) && Intrinsics.areEqual(this.successUrl, configuration.successUrl) && Intrinsics.areEqual(this.errorUrl, configuration.errorUrl) && this.hideLogo == configuration.hideLogo && Intrinsics.areEqual(this.privacyPolicyUrl, configuration.privacyPolicyUrl);
    }

    public final String getErrorUrl() {
        return this.errorUrl;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final boolean getHideLogo() {
        return this.hideLogo;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getPresetIssuingCountry() {
        return this.presetIssuingCountry;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    public final String getSuccessUrl() {
        return this.successUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v28 */
    public int hashCode() {
        String str = this.primaryColor;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secondaryColor;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fontColor;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.locale;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.presetIssuingCountry;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.successUrl;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.errorUrl;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        boolean z = this.hideLogo;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode7 + r2) * 31;
        String str8 = this.privacyPolicyUrl;
        return i + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "Configuration(primaryColor=" + this.primaryColor + ", secondaryColor=" + this.secondaryColor + ", fontColor=" + this.fontColor + ", locale=" + this.locale + ", presetIssuingCountry=" + this.presetIssuingCountry + ", successUrl=" + this.successUrl + ", errorUrl=" + this.errorUrl + ", hideLogo=" + this.hideLogo + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ')';
    }
}
