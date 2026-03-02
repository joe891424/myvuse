package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.MarketingCloudConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4182e {

    /* JADX INFO: renamed from: a */
    public static final a f4902a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.e$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final boolean m3355a(MarketingCloudConfig self, MarketingCloudConfig other) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(other, "other");
            return self.m6537applicationChanged(other);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final boolean m3354a(MarketingCloudConfig marketingCloudConfig, MarketingCloudConfig marketingCloudConfig2) {
        return f4902a.m3355a(marketingCloudConfig, marketingCloudConfig2);
    }
}
