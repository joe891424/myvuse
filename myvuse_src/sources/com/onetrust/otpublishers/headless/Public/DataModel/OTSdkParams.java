package com.onetrust.otpublishers.headless.Public.DataModel;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes6.dex */
public class OTSdkParams {

    /* JADX INFO: renamed from: a */
    public final String f4085a;

    /* JADX INFO: renamed from: b */
    public final String f4086b;

    /* JADX INFO: renamed from: c */
    public final String f4087c;

    /* JADX INFO: renamed from: d */
    public final OTProfileSyncParams f4088d;

    /* JADX INFO: renamed from: e */
    public final OTUXParams f4089e;

    /* JADX INFO: renamed from: f */
    public final String f4090f;

    /* JADX INFO: renamed from: g */
    public final String f4091g;

    /* JADX INFO: renamed from: h */
    public final boolean f4092h;

    public static class SdkParamsBuilder {

        /* JADX INFO: renamed from: a */
        public String f4093a;

        /* JADX INFO: renamed from: b */
        public String f4094b;

        /* JADX INFO: renamed from: c */
        public String f4095c;

        /* JADX INFO: renamed from: d */
        public OTProfileSyncParams f4096d;

        /* JADX INFO: renamed from: e */
        public String f4097e;

        /* JADX INFO: renamed from: f */
        public String f4098f;

        /* JADX INFO: renamed from: g */
        public OTUXParams f4099g;

        /* JADX INFO: renamed from: h */
        public boolean f4100h;

        public static SdkParamsBuilder newInstance() {
            return new SdkParamsBuilder();
        }

        public OTSdkParams build() {
            return new OTSdkParams(this);
        }

        public SdkParamsBuilder setAPIVersion(String str) {
            this.f4095c = str;
            return this;
        }

        public SdkParamsBuilder setOTCountryCode(String str) {
            this.f4093a = str;
            return this;
        }

        public SdkParamsBuilder setOTRegionCode(String str) {
            this.f4094b = str;
            return this;
        }

        public SdkParamsBuilder setOTUXParams(OTUXParams oTUXParams) {
            this.f4099g = oTUXParams;
            return this;
        }

        @Deprecated
        public SdkParamsBuilder setOtBannerHeightRatio(String str) {
            OTLogger.m2743a(5, "OneTrust", "setOtBannerHeightRatio() method is deprecated and eventually will get removed from SDK. Please configure the banner height from OT admin UI template settings");
            this.f4098f = str;
            return this;
        }

        public SdkParamsBuilder setProfileSyncParams(OTProfileSyncParams oTProfileSyncParams) {
            this.f4096d = oTProfileSyncParams;
            return this;
        }

        public SdkParamsBuilder setSyncWebSDKConsent(boolean z) {
            this.f4100h = z;
            return this;
        }

        public SdkParamsBuilder shouldCreateProfile(String str) {
            this.f4097e = str;
            return this;
        }
    }

    public OTSdkParams(SdkParamsBuilder sdkParamsBuilder) {
        this.f4085a = sdkParamsBuilder.f4093a;
        this.f4086b = sdkParamsBuilder.f4094b;
        this.f4087c = sdkParamsBuilder.f4095c;
        this.f4088d = sdkParamsBuilder.f4096d;
        this.f4090f = sdkParamsBuilder.f4097e;
        this.f4091g = sdkParamsBuilder.f4098f;
        this.f4089e = sdkParamsBuilder.f4099g;
        this.f4092h = sdkParamsBuilder.f4100h;
    }

    public String getCreateProfile() {
        return this.f4090f;
    }

    public String getOTCountryCode() {
        return this.f4085a;
    }

    public String getOTRegionCode() {
        return this.f4086b;
    }

    public String getOTSdkAPIVersion() {
        return this.f4087c;
    }

    public OTUXParams getOTUXParams() {
        return this.f4089e;
    }

    public String getOtBannerHeight() {
        return this.f4091g;
    }

    public OTProfileSyncParams getOtProfileSyncParams() {
        return this.f4088d;
    }

    public boolean getSyncWebSDKConsent() {
        return this.f4092h;
    }
}
