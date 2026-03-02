package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.registration.Registration;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.k */
/* JADX INFO: loaded from: classes6.dex */
public final class C4188k {

    /* JADX INFO: renamed from: a */
    public static final a f4907a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.k$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final Registration m3395a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new Registration(json);
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final JSONObject m3397b(Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            return registration.toJson$sdk_release();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final int m3394a(Registration registration) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            return registration.getId();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final void m3396a(Registration registration, int i) {
            Intrinsics.checkNotNullParameter(registration, "registration");
            registration.setId$sdk_release(i);
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final Registration m3391a(JSONObject jSONObject) {
        return f4907a.m3395a(jSONObject);
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final JSONObject m3393b(Registration registration) {
        return f4907a.m3397b(registration);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final int m3390a(Registration registration) {
        return f4907a.m3394a(registration);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3392a(Registration registration, int i) {
        f4907a.m3396a(registration, i);
    }
}
