package com.onetrust.otpublishers.headless.Public.DataModel;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.onetrust.otpublishers.headless.Public.OTBackButtonMode;
import com.onetrust.otpublishers.headless.Public.OTVendorListDismissMode;
import java.util.HashMap;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: loaded from: classes6.dex */
public class OTConfiguration {

    /* JADX INFO: renamed from: a */
    public final HashMap<String, Typeface> f4061a;

    /* JADX INFO: renamed from: b */
    public final String f4062b;

    /* JADX INFO: renamed from: c */
    public final String f4063c;

    /* JADX INFO: renamed from: d */
    public final String f4064d;

    /* JADX INFO: renamed from: e */
    public final View f4065e;

    /* JADX INFO: renamed from: f */
    public final Drawable f4066f;

    /* JADX INFO: renamed from: g */
    public final Drawable f4067g;

    public static class OTConfigurationBuilder {

        /* JADX INFO: renamed from: a */
        public final HashMap<String, Typeface> f4068a = new HashMap<>();

        /* JADX INFO: renamed from: b */
        public String f4069b;

        /* JADX INFO: renamed from: c */
        public String f4070c;

        /* JADX INFO: renamed from: d */
        public String f4071d;

        /* JADX INFO: renamed from: e */
        public View f4072e;

        /* JADX INFO: renamed from: f */
        public Drawable f4073f;

        /* JADX INFO: renamed from: g */
        public Drawable f4074g;

        public static OTConfigurationBuilder newInstance() {
            return new OTConfigurationBuilder();
        }

        public OTConfigurationBuilder addOTTypeFace(String str, Typeface typeface) {
            this.f4068a.put(str, typeface);
            return this;
        }

        public OTConfiguration build() {
            return new OTConfiguration(this);
        }

        public OTConfigurationBuilder setBackButton(String str) {
            this.f4069b = str;
            return this;
        }

        public OTConfigurationBuilder setBannerLogo(Drawable drawable) {
            this.f4073f = drawable;
            return this;
        }

        public OTConfigurationBuilder setPCLogo(Drawable drawable) {
            this.f4074g = drawable;
            return this;
        }

        public OTConfigurationBuilder setSyncNotificationView(View view) {
            this.f4072e = view;
            return this;
        }

        public OTConfigurationBuilder setVendorListJourney(String str) {
            this.f4070c = str;
            return this;
        }

        public OTConfigurationBuilder shouldEnableDarkMode(String str) {
            this.f4071d = str;
            return this;
        }
    }

    public OTConfiguration(OTConfigurationBuilder oTConfigurationBuilder) {
        this.f4061a = oTConfigurationBuilder.f4068a;
        this.f4062b = oTConfigurationBuilder.f4069b;
        this.f4063c = oTConfigurationBuilder.f4070c;
        this.f4064d = oTConfigurationBuilder.f4071d;
        this.f4065e = oTConfigurationBuilder.f4072e;
        this.f4066f = oTConfigurationBuilder.f4073f;
        this.f4067g = oTConfigurationBuilder.f4074g;
    }

    public Drawable getBannerLogo() {
        return this.f4066f;
    }

    public String getDarkModeThemeValue() {
        return this.f4064d;
    }

    public Typeface getOtTypeFaceMap(String str) {
        if (this.f4061a.containsKey(str)) {
            return this.f4061a.get(str);
        }
        return null;
    }

    public HashMap<String, Typeface> getOtTypeFaceMap() {
        return this.f4061a;
    }

    public Drawable getPcLogo() {
        return this.f4067g;
    }

    public View getView() {
        return this.f4065e;
    }

    public boolean isBannerBackButtonCloseBanner() {
        if (C0048h.m305b(this.f4062b)) {
            return false;
        }
        return OTBackButtonMode.DEFAULT_CONSENT_AND_CLOSE_BANNER.equalsIgnoreCase(this.f4062b);
    }

    public boolean isBannerBackButtonDisMissUI() {
        if (C0048h.m305b(this.f4062b)) {
            return false;
        }
        return OTBackButtonMode.DISMISS_BANNER.equalsIgnoreCase(this.f4062b);
    }

    public boolean isBannerBackButtonDisabled() {
        return (isBannerBackButtonDisMissUI() || isBannerBackButtonCloseBanner()) ? false : true;
    }

    public boolean isShowConfirmMyChoice() {
        if (C0048h.m305b(this.f4063c)) {
            return false;
        }
        return OTVendorListDismissMode.SHOW_CONFIRM_MY_CHOICE.equalsIgnoreCase(this.f4063c);
    }

    public String toString() {
        return "OTConfig{otTypeFaceMap=" + this.f4061a + "bannerBackButton=" + this.f4062b + "vendorListMode=" + this.f4063c + "darkMode=" + this.f4064d + '}';
    }
}
