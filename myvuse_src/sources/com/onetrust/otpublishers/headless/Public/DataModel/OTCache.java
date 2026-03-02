package com.onetrust.otpublishers.headless.Public.DataModel;

/* JADX INFO: loaded from: classes6.dex */
public class OTCache {

    /* JADX INFO: renamed from: a */
    public final String f4059a;

    public static class OTCacheBuilder {

        /* JADX INFO: renamed from: a */
        public String f4060a;

        public static OTCacheBuilder newInstance() {
            return new OTCacheBuilder();
        }

        public OTCache build() {
            return new OTCache(this);
        }

        @Deprecated
        public OTCacheBuilder setDataSubjectIdentifier(String str) {
            this.f4060a = str;
            return this;
        }
    }

    public OTCache(OTCacheBuilder oTCacheBuilder) {
        this.f4059a = oTCacheBuilder.f4060a;
    }

    public String getDataSubjectIdentifier() {
        return this.f4059a;
    }

    public String toString() {
        return "OTCache{dataSubjectIdentifier='" + this.f4059a + "'}";
    }
}
