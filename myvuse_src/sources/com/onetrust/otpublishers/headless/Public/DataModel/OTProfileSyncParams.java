package com.onetrust.otpublishers.headless.Public.DataModel;

/* JADX INFO: loaded from: classes6.dex */
public class OTProfileSyncParams {

    /* JADX INFO: renamed from: a */
    public String f4075a;

    /* JADX INFO: renamed from: b */
    public String f4076b;

    /* JADX INFO: renamed from: c */
    public String f4077c;

    /* JADX INFO: renamed from: d */
    public String f4078d;

    /* JADX INFO: renamed from: e */
    public String f4079e;

    public static class OTProfileSyncParamsBuilder {

        /* JADX INFO: renamed from: a */
        public String f4080a;

        /* JADX INFO: renamed from: b */
        public String f4081b;

        /* JADX INFO: renamed from: c */
        public String f4082c;

        /* JADX INFO: renamed from: d */
        public String f4083d;

        /* JADX INFO: renamed from: e */
        public String f4084e;

        public static OTProfileSyncParamsBuilder newInstance() {
            return new OTProfileSyncParamsBuilder();
        }

        public OTProfileSyncParams build() {
            return new OTProfileSyncParams(this);
        }

        public OTProfileSyncParamsBuilder setIdentifier(String str) {
            this.f4081b = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncGroupId(String str) {
            this.f4084e = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncProfile(String str) {
            this.f4080a = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncProfileAuth(String str) {
            this.f4082c = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setTenantId(String str) {
            this.f4083d = str;
            return this;
        }
    }

    public OTProfileSyncParams(OTProfileSyncParamsBuilder oTProfileSyncParamsBuilder) {
        this.f4075a = oTProfileSyncParamsBuilder.f4080a;
        this.f4076b = oTProfileSyncParamsBuilder.f4081b;
        this.f4077c = oTProfileSyncParamsBuilder.f4082c;
        this.f4078d = oTProfileSyncParamsBuilder.f4083d;
        this.f4079e = oTProfileSyncParamsBuilder.f4084e;
    }

    public String getIdentifier() {
        return this.f4076b;
    }

    public String getSyncGroupId() {
        return this.f4079e;
    }

    public String getSyncProfile() {
        return this.f4075a;
    }

    public String getSyncProfileAuth() {
        return this.f4077c;
    }

    public String getTenantId() {
        return this.f4078d;
    }

    public String toString() {
        return "OTProfileSyncParams{syncProfile=" + this.f4075a + ", identifier='" + this.f4076b + "', syncProfileAuth='" + this.f4077c + "', tenantId='" + this.f4078d + "', syncGroupId='" + this.f4079e + "'}";
    }
}
