package com.salesforce.marketingcloud.config;

import android.net.Uri;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.config.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4144b {

    /* JADX INFO: renamed from: d */
    public static final a f4692d = new a(null);

    /* JADX INFO: renamed from: a */
    private final String f4693a;

    /* JADX INFO: renamed from: b */
    private final String f4694b;

    /* JADX INFO: renamed from: c */
    private final Integer f4695c;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.b$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: renamed from: a */
        public final C4144b m3103a(String endpointIn) {
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            return m3102a(this, endpointIn, null, null, 6, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final C4144b m3104a(String endpointIn, String str) {
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            return m3102a(this, endpointIn, str, null, 4, null);
        }

        /* JADX INFO: renamed from: a */
        public final C4144b m3105a(String endpointIn, String str, Integer num) {
            String string;
            Intrinsics.checkNotNullParameter(endpointIn, "endpointIn");
            String string2 = StringsKt.trim((CharSequence) endpointIn).toString();
            if (string2.length() == 0 || !ArraysKt.contains(b.values(), b.valueOf(string2))) {
                throw new IllegalArgumentException("Invalid 'endpoint' for endpoint config.");
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null) {
                string = null;
            } else if (string.length() == 0 || !StringsKt.startsWith$default(string, "/", false, 2, (Object) null) || !Intrinsics.areEqual(string, Uri.parse(string).getPath())) {
                throw new IllegalArgumentException("Invalid 'path' for " + string2 + " endpoint config.");
            }
            if (num != null && !new IntRange(10, Integer.MAX_VALUE).contains(num.intValue())) {
                throw new IllegalArgumentException("Invalid 'maxBatchSize' for " + string2 + " endpoint config.");
            }
            if (string == null && num == null) {
                throw new IllegalArgumentException("Empty endpoint config for " + string2 + " is pointless.");
            }
            return new C4144b(string2, string, num, defaultConstructorMarker);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ C4144b m3102a(a aVar, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            return aVar.m3105a(str, str2, num);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.b$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final b f4696a = new b("EVENTS", 0);

        /* JADX INFO: renamed from: b */
        private static final /* synthetic */ b[] f4697b;

        /* JADX INFO: renamed from: c */
        private static final /* synthetic */ EnumEntries f4698c;

        static {
            b[] bVarArrM3106a = m3106a();
            f4697b = bVarArrM3106a;
            f4698c = EnumEntriesKt.enumEntries(bVarArrM3106a);
        }

        private b(String str, int i) {
        }

        /* JADX INFO: renamed from: a */
        private static final /* synthetic */ b[] m3106a() {
            return new b[]{f4696a};
        }

        /* JADX INFO: renamed from: b */
        public static EnumEntries<b> m3107b() {
            return f4698c;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f4697b.clone();
        }
    }

    private C4144b(String str, String str2, Integer num) {
        this.f4693a = str;
        this.f4694b = str2;
        this.f4695c = num;
    }

    /* JADX INFO: renamed from: a */
    public final String m3096a() {
        return this.f4693a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3097b() {
        return this.f4694b;
    }

    /* JADX INFO: renamed from: c */
    public final Integer m3098c() {
        return this.f4695c;
    }

    /* JADX INFO: renamed from: d */
    public final String m3099d() {
        return this.f4693a;
    }

    /* JADX INFO: renamed from: e */
    public final Integer m3100e() {
        return this.f4695c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4144b)) {
            return false;
        }
        C4144b c4144b = (C4144b) obj;
        return Intrinsics.areEqual(this.f4693a, c4144b.f4693a) && Intrinsics.areEqual(this.f4694b, c4144b.f4694b) && Intrinsics.areEqual(this.f4695c, c4144b.f4695c);
    }

    /* JADX INFO: renamed from: f */
    public final String m3101f() {
        return this.f4694b;
    }

    public int hashCode() {
        int iHashCode = this.f4693a.hashCode() * 31;
        String str = this.f4694b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f4695c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "EndpointConfig(endpoint=" + this.f4693a + ", path=" + this.f4694b + ", maxBatchSize=" + this.f4695c + ")";
    }

    /* synthetic */ C4144b(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    /* JADX INFO: renamed from: a */
    public final C4144b m3095a(String endpoint, String str, Integer num) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return new C4144b(endpoint, str, num);
    }

    public /* synthetic */ C4144b(String str, String str2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, num);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4144b m3094a(C4144b c4144b, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c4144b.f4693a;
        }
        if ((i & 2) != 0) {
            str2 = c4144b.f4694b;
        }
        if ((i & 4) != 0) {
            num = c4144b.f4695c;
        }
        return c4144b.m3095a(str, str2, num);
    }
}
