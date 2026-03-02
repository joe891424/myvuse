package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.InitializationStatus;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.c */
/* JADX INFO: loaded from: classes6.dex */
public final class C4180c {

    /* JADX INFO: renamed from: a */
    public static final a f4900a = new a(null);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.c$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final InitializationStatus m3344a() {
            return InitializationStatus.INSTANCE.m2811a();
        }

        @JvmStatic
        /* JADX INFO: renamed from: b */
        public final InitializationStatus.C4081a m3345b() {
            return InitializationStatus.INSTANCE.m2812b();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final InitializationStatus m3342a() {
        return f4900a.m3344a();
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final InitializationStatus.C4081a m3343b() {
        return f4900a.m3345b();
    }
}
