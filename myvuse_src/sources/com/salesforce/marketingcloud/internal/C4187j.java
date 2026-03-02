package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.j */
/* JADX INFO: loaded from: classes6.dex */
public final class C4187j {

    /* JADX INFO: renamed from: a */
    public static final a f4906a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.j$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final boolean m3389a(Region region) {
            Intrinsics.checkNotNullParameter(region, "region");
            return region.getIsInside();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final Region m3387a(LatLon center, int i) {
            Intrinsics.checkNotNullParameter(center, "center");
            return Region.INSTANCE.m6618magicFence(center, i);
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3388a(Region region, boolean z) {
            Intrinsics.checkNotNullParameter(region, "region");
            region.m6615isInside(z);
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final boolean m3386a(Region region) {
        return f4906a.m3389a(region);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final Region m3384a(LatLon latLon, int i) {
        return f4906a.m3387a(latLon, i);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3385a(Region region, boolean z) {
        f4906a.m3388a(region, z);
    }
}
